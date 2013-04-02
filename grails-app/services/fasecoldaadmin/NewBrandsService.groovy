
package fasecoldaadmin

import org.joda.time.format.DateTimeFormatter
import static groovyx.net.http.ContentType.JSON
import static groovyx.net.http.Method.GET
import static groovyx.net.http.Method.HEAD


class NewBrandsService {


    static transactional = true;    
    def attributesCache;
    def restClient;
    def sessionFactory;
    def propertyInstanceMap = org.codehaus.groovy.grails.plugins.DomainClassGrailsPlugin.PROPERTY_INSTANCE_MAP;

	
	/**
	* @author nicolas moraes
	* @description despliega por consola el dump correspondiente a la tabla model_version, simulando una consulta
	* en la BD MOTORS
	*
	*/
	public void mostrarModelsVersion(){
		
		//category_id          | version | external_id | name
		def item = ModelVersion.findAll()
		println("+-----------------------------------------------------------------------------------------+")
		println("| model_versions_id      |    version_version_id  |    version_year    !  versions_idx    !")
		println("+-----------------------------------------------------------------------------------------+")
		item.each {
			
			 i -> println( "    "+ i.model_versions_id  );
			
			}
		println("+-----------------------------------------------------------------------------------------+")
		
		
		
		}
	
	/**
	* @author nicolas moraes
	* @description despliega por consola el dump correspondiente a la tabla model, simulando una consulta
	* en la BD MOTORS
	*
	*/
	public void mostrarModel(){
		
		//category_id          | version | external_id | name  
		def item = Model.findAll()
		println("+----------------------------------+")
		println("| category_id      |    name       |")
		println("+----------------------------------+")
		item.each {
			
			 i -> println( "  "+ i.category_id  + "                " + i.name );
			
			}
		println("+----------------------------------+")
		
		
		
		}
	
	/**
	* @author nicolas moraes
	* @description despliega por consola el dump correspondiente a la tabla brand, simulando una consulta
	* en la BD MOTORS
	* 
	*/
	public void mostrarCategoryBrand(){
		
		
		def item = CategoryBrand.findAll()
		println("+------------------------------------------------------+")
		println("| category_brands_id  |    brand_id  |   brands_idx    |")
		println("+------------------------------------------------------+")
		item.each {
			
			 i -> println( "  "+ i.category_brands_id + "                " + i.brand_id );
			
			}
		println("+------------------------------------------------------+")
		
		
		
		}
	
	/**
	* @author nicolas moraes
	* @description despliega por consola el dump correspondiente a la tabla Category brand, simulando una consulta
	* en la BD MOTORS
	*
	*/
	
	public void mostrarCategory(){
		
		def item = Category.findAll()
		println("+-------------------------------------------+")
		println("| category_id     |    version |     name   |")
		println("+-------------------------------------------+")
		item.each {
			
			 i -> println( "  "+ i.category_id + "    " + i.version + "     " + i.name);
			
			}
		println("+-------------------------------------------+")
		
		
		
		
		
		
		}
	
	/**
	* @author nicolas moraes
	* @description despliega por consola el dump correspondiente a la brands, simulando una consulta
	* en la BD MOTORS
	*
	*/
	public void mostrarBrands(){

		def item = Brand.findAll()
		println("+----------------------------+")
		println("| MARCA     |    CATEGORY_ID |")
		println("+----------------------------+")
		item.each {
			
			 i -> println( "  "+ i.name + "         " + i.categoryId);
			
			}
		println("+----------------------------+")
		
		
		
		
				
		}

	/**
	* @author nicolas moraes
	* @description despliega por consola el dump correspondiente a la tabla brand_model, simulando una consulta
	* en la BD MOTORS
	*
	*/
	public void mostrarBrandsModel(){
			
		def item = BrandModel.findAll()
		println("+---------------------------------------+")
		println("| brand_models_id |         model_id    |")
		println("+---------------------------------------+")
		item.each { 
			
			 i -> println( "  "+ i.brand_model + "               " + i.categoryId);
			
			}
		println("+---------------------------------------+")
		
		
		}
	
	
    public void buildSiteBrands( String siteId )
    {
       
            
            getBrandDump(siteId); 


    }

    private def getBrandDump( String siteId ) {
		
        //log.info( "[${siteId}] Getting dump..." );
		
		
		
		
		Category category = new Category();
		category.category_id = siteId+"1744";
	    category.version = "1";
		category.name = "Carros y Camionetas";
		category.save(flush:true);
	
		
        
        def brands;
		def models;
		def allmodels;

        Date startTime = new Date();
		
		
		System.out.println( "********Dentro del service ********");	
		System.out.println( "Generando el dump de BD MOTORS.....");
		System.out.println("https://api.mercadolibre.com/categories/${siteId}"+"1744");
		
		
        restClient.request( GET, JSON )
        { req ->
            uri.path =  "https://api.mercadolibre.com/categories/${siteId}"+"1744".toString();

            response.success =
            { resp, json ->
                brands = json;
            }

            response.failure =
            { resp ->
                log.info( "[${siteId}] ERROR Getting dump. Status: ${resp.status}. ${resp.data}" );
            
				System.out.println( "[${siteId}] ERROR Getting dump. Status: ${resp.status}. ${resp.data}" );
				}
        };

        if( brands ){
           
			int indice =0;
            brands.children_categories.each { brand -> 
				                
                Brand cat          = new Brand();	
                cat.categoryId     = brand.id;
                cat.name           = brand.name;	
				
				
				//INSERT BRAND
				//String insert= "INSERT INTO brand (category_id ,version,external_id,name) VALUES (\"${cat.categoryId}\" ,0,0,\"${cat.name}\" );";
				//println(insert);
				

				CategoryBrand cb = new CategoryBrand();
				cb.category_brands_id= siteId+"1744";
				cb.brand_id = brand.id;
				
				
				//INSERT CATEGORY_BRAND
				//String insert= "INSERT INTO category_brand (category_brands_id ,brand_id, brands_idx) VALUES (\"MLV1744\",\"${cb.brand_id}\" " +","+ indice+   ");";
				//println(insert);
			    //indice++;
				
				
				restClient.request( GET, JSON )
				{ req ->
					uri.path =  "https://api.mercadolibre.com/categories/${cat.categoryId}".toString();
		
					response.success =
					{ resp, json ->
						models = json;
					}
		
					response.failure =
					{ resp ->
						//log.info( "[${siteId}] ERROR Getting dump. Status: ${resp.status}. ${resp.data}" );
					
						System.out.println( "[${siteId}] ERROR Getting dump. Status: ${resp.status}. ${resp.data}" );
						}
				};
				
				models.children_categories.each { model -> 
				                
                BrandModel mod          = new BrandModel();	
                mod.categoryId     = model.id;
                mod.name           = model.name;	
				mod.brand_model = brand.id;
				
				
				//INSERT BRAND_MODEL
				//String insert= "INSERT INTO brand_model (brand_models_id,model_id) VALUES (\"${mod.brand_model}\",\"${mod.categoryId}\");";
				//println(insert);
							
				
				Model m          = new Model();
				m.category_id     = mod.categoryId;
				m.name           = mod.name ;
				
				//INSERT MODEL
				//String insert= "INSERT INTO model (category_id ,version,external_id,name) VALUES (\"${mod.categoryId}\" ,0,0,\"${mod.name}\" );";
				//println(insert);
				
				
				ModelVersion mv = new ModelVersion();
				mv.model_versions_id =mod.categoryId;

				
				//INSERT VERSION_MODEL
				//Descomentar para generar insert para la tabla version_model.
				//insertVersionModel(mod.categoryId)
				
				//INSERT VERSION
				//Descomentar para generar insert para la tabla version.
			    //insertVersion(mod.categoryId)
				
				
			
				if (!(mv.save(flush:true)) ){
					mv.errors.each{print it}
					
					}
				
				
				
				if (!(m.save(flush:true)) ){
					m.errors.each{print it}
					
					}
				
		
				
				if (!(mod.save(flush:true)) ){
					mod.errors.each{print it}
					
					}
				
				if (!(cb.save(flush:true)) ){
					cb.errors.each{print it}
					
					}
			
		
				}
				
				
				
				if (!(cat.save(flush:true)) ){
					cat.errors.each{print it}
					
					}
	
       
            };
        

			System.out.println("commit;");

			
        }
    }
	
	
	
	/**
	 * @author nicolas moraes
	 * @description insertVersionModel genera un script para insertar en la tabla version_model, 
	 * en la base de datos Motors.
	 * @param modelId
	 * 
	 */
	private def insertVersionModel( String modelId ){
	def models;
	int cont=0;
		restClient.request( GET, JSON )
		{ req ->
			uri.path =  "https://api.mercadolibre.com/categories/${modelId}/attributes".toString();

			response.success =
			{ resp, json ->
				models = json;
			}

			response.failure =
			{ resp ->
				System.out.println( "[${siteId}] ERROR Getting dump. Status: ${resp.status}. ${resp.data}" );
				}
		};
	
	def atributo= models.find{ it.name=="Versión"}
	
	if(atributo){
	atributo.values.each{
		
		String insert2= "INSERT INTO model_version (model_versions_id ,version_version_id ,version_year, versions_idx) VALUES (\"${modelId}\" ,\"${it.id}\",null,\"${cont}\" );";
		println(insert2);
		cont ++;		
		}
	}
			
		
	}
	
	/**
	 * @author nicolas moraes
	 * @description insertVersion genera un script para insertar en la tabla version, 
	 * en la base de datos Motors.
	 * @param modelId
	 * 
	 */
	private def insertVersion( String modelId ){
		def models;

	int cont=0;
		restClient.request( GET, JSON )
		{ req ->
			uri.path =  "https://api.mercadolibre.com/categories/${modelId}/attributes".toString();

			response.success =
			{ resp, json ->
				models = json;
			}

			response.failure =
			{ resp ->
			
				System.out.println( "[${siteId}] ERROR Getting dump. Status: ${resp.status}. ${resp.data}" );
				}
		};
	
	def atributo= models.find{ it.name=="Versión"}
	
	if(atributo){
	atributo.values.each{
		
		for (int i=1960; i<=2012; i++){	
			String versionIdYear = it.id;
			String version_id =versionIdYear + "-"+ i.toString();
			String insert2= "INSERT INTO version (version_id, year,version,name ) VALUES (\"${version_id}\" ,\"${i}\",1,\"${it.id}\" );";
			println(insert2);
		
		
		}
		
		
		}
	}
			
		
	}
	

	
	
}

