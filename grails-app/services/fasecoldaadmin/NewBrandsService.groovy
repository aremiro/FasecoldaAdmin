
package fasecoldaadmin

import org.joda.time.format.DateTimeFormatter
import static groovyx.net.http.ContentType.JSON
import static groovyx.net.http.Method.GET
import static groovyx.net.http.Method.HEAD


class NewBrandsService {


    static transactional = true;

   // static DateTimeFormatter dateTimeFormatter = ISODateTimeFormat.dateTime();
    
    def attributesCache;
    def restClient;

    def sessionFactory;
    def propertyInstanceMap = org.codehaus.groovy.grails.plugins.DomainClassGrailsPlugin.PROPERTY_INSTANCE_MAP;

	
	
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
		category.category_id = "MLV1744";
	    category.version = "1";
		category.name = "Carros y Camionetas";
		
		category.save(flush:true);
	
		//def category_brands_id = category.findByCategory_id();
        
        def brands;
		def models;
		def allmodels;

        Date startTime = new Date();
		
		
		System.out.println( "********Dentro del service ********");	
		System.out.println( "tomando el dump de marcas.....");
		System.out.println( "https://api.mercadolibre.com/categories/MLV1744".toString());
		println("inicio del script *.sql");
        restClient.request( GET, JSON )
        { req ->
            uri.path =  "https://api.mercadolibre.com/categories/MLV1744".toString();

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
				cb.category_brands_id= "MLV1744";
				cb.brand_id = brand.id;
				
				
				//INSERT BRAND
				//String insert= "INSERT INTO category_brand (category_brands_id ,brand_id, brands_idx) VALUES (\"MLV1744\",\"${cb.brand_id}\" " +","+ indice+   ");";
				//println(insert);
			//	indice++;
				
				//System.out.println( "tomando el dump de modelos para la categoria: "+ cat.categoryId + " "+cat.name );
				//System.out.println( "https://api.mercadolibre.com/categories/${cat.categoryId}".toString());
				
				
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
				
				
				//INSERT BRAND
				//String insert= "INSERT INTO brand_model (brand_models_id,model_id) VALUES (\"${mod.brand_model}\",\"${mod.categoryId}\");";
				//println(insert);
				
				
				
				//SCRIPT DE INSERT
				//| category_id  | version | external_id | name |
				
				
				
				//println("se crea 1 Brand Model*******" )
			//	println(mod.categoryId +" "+ mod.name +" "+ mod.brand_model) //modelo
				
				
				Model m          = new Model();
				m.category_id     = mod.categoryId;
				m.name           = mod.name ;
				
				//String insert2= "INSERT INTO model (category_id ,version,external_id,name) VALUES (\"${mod.categoryId}\" ,0,0,\"${mod.name}\" );";
				//println(insert2);
				
				//println("se crea 1 Model ********" )
				//println(m.category_id +" "+ m.name) //modelo
			
				
				ModelVersion mv = new ModelVersion();
				mv.model_versions_id =mod.categoryId;
				
				//setVersion(mod.categoryId)
			    //setVersiontable(mod.categoryId)
				
				
				
				
				//insert2= "INSERT INTO model (category_id ,version,external_id,name) VALUES (\"${mod.categoryId}\" ,0,0,\"${mod.name}\" );";
				//println(insert2);
				
				
			
				if (!(mv.save(flush:true)) ){
					mv.errors.each{print it}
					
					}
				
				
				
				if (!(m.save(flush:true)) ){
					m.errors.each{print it}
					
					}
				
				
				
				//}
				
		
			
				
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
        
        
		
		
		
			System.out.println("Fin del dump !");

			
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
	
	
	
	
	
	
	/*
	public void generateModelVersion(){
		
		Category category = new Category();
		category.category_id = "MLV1744";
		category.version = "1";
		category.name = "Carros y Camionetas";
		
		category.save(flush:true);
	
		//def category_brands_id = category.findByCategory_id();
		
		def brands;
		def models;
		def allmodels;

		Date startTime = new Date();
		
		
		System.out.println( "********Se va a generar model_service********");
		System.out.println( "tomando el dump de marcas.....");
		System.out.println( "https://api.mercadolibre.com/categories/MLV1744".toString());
		println("inicio del script *.sql");
		restClient.request( GET, JSON )
		{ req ->
			uri.path =  "https://api.mercadolibre.com/categories/MLV1744".toString();

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
				
				
				Model m          = new Model();
				m.category_id     = mod.categoryId;
				m.name           = mod.name ;
				
				
				setVersion(mod.categoryId)
							
				
				}
				
				
	
	
	   
			};
		
		
		
		
		
			System.out.println("Fin del dump !");

			
		}
		
		
		
		
		
		
		}
	
	
	*/
	
	
	
	
}

