
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
		println("+----------------------------+")
		
		
		
		
		
		
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
			
		def item = Model.findAll()
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
		category.category_id = "MCO1744";
	    category.version = "1";
		category.name = "Carros, Camionetas y Camperos";
		
		category.save(flush:true);
	
		//def category_brands_id = category.findByCategory_id();
        
        def brands;
		def models;

        Date startTime = new Date();
		
		
		System.out.println( "********Dentro del service ********");	
		System.out.println( "tomando el dump de marcas.....");
		System.out.println( "https://api.mercadolibre.com/categories/MCO1744".toString());
		
        restClient.request( GET, JSON )
        { req ->
            uri.path =  "https://api.mercadolibre.com/categories/MCO1744".toString();

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
           
			
            brands.children_categories.each { brand -> 
				                
                Brand cat          = new Brand();	
                cat.categoryId     = brand.id;
                cat.name           = brand.name;	
				
				
				CategoryBrand cb = new CategoryBrand();
				cb.category_brands_id= "MCO1744";
				cb.brand_id = brand.id;
				
				
				System.out.println( "tomando el dump de modelos para la categoria: "+ cat.categoryId + " "+cat.name );
				System.out.println( "https://api.mercadolibre.com/categories/${cat.categoryId}".toString());
				
				
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
				                
                Model mod          = new Model();	
                mod.categoryId     = model.id;
                mod.name           = model.name;	
				mod.brand_model = brand.id;
				
				
				//aca TABLA MODEL
				
				
				
				
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
}
