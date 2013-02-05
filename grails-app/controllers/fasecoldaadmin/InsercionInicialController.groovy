package fasecoldaadmin

import groovyx.net.http.HTTPBuilder

class InsercionInicialController {

    def index = { }
	
	def addNewPricesYear = {
		
		def categoria_inicial = "MCO1744" //"MLA1744"
		
		//Inicio Script
		new File(basePath+'/scripts/posts-script.txt').delete()//Borro el archivo para que no se le agreguen mas filas
		def postsScript = new File(basePath+'/scripts/posts-script.txt') //Lo creo nuevamente
		
//		def url = ConfigurationHolder.getConfig().getProperty('url')
		def url = "http://localhost:9090"
		def path = "/motors_prices/"
		
		def brandHttpBuilder = new HTTPBuilder(url)
		def modelHttpBuilder = new HTTPBuilder(url)
		def versionHttpBuilder = new HTTPBuilder(url)
		def priceHttpBuilder = new HTTPBuilder(url)
		
		brandHttpBuilder.request(GET, JSON ) {
			def resPath = path + categoria_inicial + "/brands"
			uri.path = resPath
			response.success = { meth, json ->
				def brands = json.get("brands")//.getAt("name")
				def brandId
				brands.each {
					
					brandId = it.id
					
					//Manejo de Models
					modelHttpBuilder.request(GET, JSON ) {
						uri.path = path + brandId + "/models"
						response.success = { modelMeth, modelJson ->
							def models = modelJson.get("models")//.getAt("name")
							def modelId
							models.each { model ->
								
								modelId = model.id
								
								if (!modelId.equals("MLA24314")){
								
								//Manejo de Versions
								versionHttpBuilder.request(GET, JSON ) {
									uri.path = path + modelId + "/versions"
									response.success = { versionMeth, versionJson ->
										def versions = versionJson.get("versions")//.getAt("name")
										def versionId
										def newVersionId
										def jsonData
										def postRow
										def jsonResult
										versions.each { currentVersion ->
											
											if ((currentVersion.id).contains("MLA0110010002")){
												println "comienzo a debugear"
											}
											
											versionId = (currentVersion.id).substring(0, (currentVersion.id).indexOf("-")) + "2013"
												
												//Post de Version
												jsonData = [
															versionId: versionId,
															name: currentVersion.name,
															year: "2013"
														]
												
												
										
//												restClient.post(uri: url.toString() + path + "/"+modelId+"/versions",
//														data: jsonData,
//														headers: [ "Accept" : "application/json"],
//														success: { jsonResult = it.data },
//														failure: {
//															jsonResult = it
//															def errorMsg = "Error on PUT to URI: [${uri}], Data: ${jsonData as JSON}, StatusCode: [${it?.status?.statusCode}], Reason: ${it?.data}\n"
//
//															if (it.exception) {
//																log.error(errorMsg, it.exception)
//															} else {
//																log.error(errorMsg)
//															}
//
//
//														})
												
												postRow = modelId + '#{"versionId":"'+ versionId +'","name":"'+ currentVersion.name +'","year":"2013"}'
								
												postsScript.append postRow
												postsScript.append '\n'
												//Fin de Post de Version
												
												
												//Post de Price
												jsonData = [
															amount: 0,
															curSymbol: "",
															curName: ""
														]
												
//												restClient.post(uri: url.toString() + path + "/"+newVersionId+"/prices",
//														data: jsonData,
//														headers: [ "Accept" : "application/json"],
//														success: { jsonResult = it.data },
//														failure: {
//															jsonResult = it
//															def errorMsg = "Error on PUT to URI: [${uri}], Data: ${jsonData as JSON}, StatusCode: [${it?.status?.statusCode}], Reason: ${it?.data}\n"
//
//															if (it.exception) {
//																log.error(errorMsg, it.exception)
//															} else {
//																log.error(errorMsg)
//															}
//
//
//												})
												
												postRow = versionId + '#{"amount":0,"curSymbol":"-","curName":"-"}'
												
												postsScript.append postRow
												postsScript.append '\n'
												//Fin de Post de Price
										}
									}
									
									response.failure = { resp ->
										
										postsScript.append resp.statusLine
										postsScript.append '\n'
									}
								}
								//Fin de Manejo de Versions
								}
							}
						}
						
						response.failure = { resp ->
							
							postsScript.append resp.statusLine
							postsScript.append '\n'
						}
					}
					//Fin de Manejo de Models
				}
			}
			
			response.failure = { resp ->
				
				postsScript.append resp.statusLine
				postsScript.append '\n'
			}
		}
		[response:[message:"Scripts Generated"]]
	}
	
	
	
	
}
