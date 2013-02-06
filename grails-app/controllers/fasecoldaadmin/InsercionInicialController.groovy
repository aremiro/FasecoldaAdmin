package fasecoldaadmin

class InsercionInicialController {
	
	def NewBrandsService;
	
	
	
	def cargaInicial ={
		System.out.println("Se va a ejecutar la carga inicial en motors DB ........");

		NewBrandsService.buildSiteBrands( "MCO");// site.id
		
	redirect(controller:"insercionInicial", action: "list")
			//render "hola mundo"	
		
		// <g:actionSubmit action="cargaInicial" value="CARGA INICIAL" />
		}
	
	
	
	

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
		
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [insercionInicialInstanceList: InsercionInicial.list(params), insercionInicialInstanceTotal: InsercionInicial.count()]
    }
}
