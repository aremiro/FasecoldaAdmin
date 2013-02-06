
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

	
	public void mostrarBrands(){
		
		
		def item = Brand.findAll()
		
		item.each {  i -> System.out.println( "Marca :" + i.name);
		
			
			}
		System.out.println("fin del dump !");
		
		
		}
	
	
    public void buildSiteBrands( String siteId )
    {
       
            
            getBrandDump(siteId); 


    }

    private def getBrandDump( String siteId )
    {
		
	
		
        //log.info( "[${siteId}] Getting dump..." );
        
        def brands;

        Date startTime = new Date();
		
		
		System.out.println( "dentro del service ********");
		
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

        if( brands )
        {
           
			
			System.out.println( " IF BRANDS ....");
            def brandsToAdd = new ArrayList<Brand>(); 

		
			
            brands.children_categories.each { brand -> 
				                
                Brand cat          = new Brand();	
                cat.categoryId     = brand.id;
                cat.name           = brand.name;
				cat.site_Id         = brand.id.substring( 0, 3 );
				
                //cat.parentCategory = brand.path_from_root.size() > 1 ? brand.path_from_root[brand.path_from_root.size() - 2].id : null;
               // cat.isLeaf         = brand.children_categories.size() == 0;
                
				cat.save();
                
       
            };
        
        
			System.out.println("fin del dump !");

			
        }
    }
}
