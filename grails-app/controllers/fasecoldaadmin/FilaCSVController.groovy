package fasecoldaadmin

class FilaCSVController {
	
	
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }
	

    def list = {
		
        params.max = Math.min(params.max ? params.int('max') : 100, 100)
        [filaCSVInstanceList: FilaCSV.list(params), filaCSVInstanceTotal: FilaCSV.count()]
    }

    def create = {
        def filaCSVInstance = new FilaCSV()
        filaCSVInstance.properties = params
        return [filaCSVInstance: filaCSVInstance]
    }

    def save = {
        def filaCSVInstance = new FilaCSV(params)
        if (filaCSVInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'filaCSV.label', default: 'FilaCSV'), filaCSVInstance.id])}"
            redirect(action: "show", id: filaCSVInstance.id)
        }
        else {
            render(view: "create", model: [filaCSVInstance: filaCSVInstance])
        }
    }

    def show = {
        def filaCSVInstance = FilaCSV.get(params.id)
        if (!filaCSVInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'filaCSV.label', default: 'FilaCSV'), params.id])}"
            redirect(action: "list")
        }
        else {
            [filaCSVInstance: filaCSVInstance]
        }
    }

    def edit = {
        def filaCSVInstance = FilaCSV.get(params.id)
        if (!filaCSVInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'filaCSV.label', default: 'FilaCSV'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [filaCSVInstance: filaCSVInstance]
        }
    }

    def update = {
        def filaCSVInstance = FilaCSV.get(params.id)
        if (filaCSVInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (filaCSVInstance.version > version) {
                    
                    filaCSVInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'filaCSV.label', default: 'FilaCSV')] as Object[], "Another user has updated this FilaCSV while you were editing")
                    render(view: "edit", model: [filaCSVInstance: filaCSVInstance])
                    return
                }
            }
            filaCSVInstance.properties = params
            if (!filaCSVInstance.hasErrors() && filaCSVInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'filaCSV.label', default: 'FilaCSV'), filaCSVInstance.id])}"
                redirect(action: "show", id: filaCSVInstance.id)
            }
            else {
                render(view: "edit", model: [filaCSVInstance: filaCSVInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'filaCSV.label', default: 'FilaCSV'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def filaCSVInstance = FilaCSV.get(params.id)
        if (filaCSVInstance) {
            try {
                filaCSVInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'filaCSV.label', default: 'FilaCSV'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'filaCSV.label', default: 'FilaCSV'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'filaCSV.label', default: 'FilaCSV'), params.id])}"
            redirect(action: "list")
        }
    }
}
