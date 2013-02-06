package fasecoldaadmin

class InsercionInicialController {
	
	def NewBrandsService;
	
	
	
	def cargaInicial ={
		System.out.println("Se va a ejecutar la carga inicial en motors DB ........");

		NewBrandsService.buildSiteBrands("MCO");// site.id
		
		redirect(controller:"insercionInicial", action: "list")
			
		}
	
	def mostrarBrands ={
		System.out.println("Se van a mostrar los brands........");
		NewBrandsService.mostrarBrands();
		redirect(controller:"insercionInicial", action: "list")
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
