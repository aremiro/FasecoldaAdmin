
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

    public void buildSiteBrands( String siteId )
    {
       
            
            getBrandDump(siteId); 


    }

    private def getBrandDump( String siteId )
    {
		
	
		
        //log.info( "[${siteId}] Getting dump..." );
        
        def brands;

        Date startTime = new Date();
        
		//ANTES
		//"/sites/${siteId}/categories/MCO1744"
		//DESPUES
		//https://api.mercadolibre.com/categories/MCO1744
		
		
		
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
            //log.info( "[${siteId}] DONE Getting dump. Duration: ${TimeCategory.minus( new Date(), startTime )}" );
            
            //log.info( "[${siteId}] Deleting categories" );
         //   Brand.executeUpdate( "delete Brand c where c.siteId = :siteId", [siteId : "${siteId}"] );
            //log.info( "[${siteId}] Categories deleted" );
            
            def brandsToAdd = new ArrayList<Brand>();

            brands.each
            { categoryId, brand ->
                
                Brand cat       = new Brand();	
                cat.id             = brand.id;
                cat.name           = brand.name;
                cat.parentCategory = brand.path_from_root.size() > 1 ? brand.path_from_root[brand.path_from_root.size() - 2].id : null;
                cat.isLeaf         = brand.children_categories.size() == 0;
                cat.siteId         = brand.id.substring( 0, 3 );
                
                brandsToAdd.add( cat );
            };
        
            startTime = new Date();
            
            log.info( "[${siteId}] Inserting BRANDS..." );
            log.info( "[${siteId}] Inserting BRANDS...(0/${brandsToAdd.size()})" );
            for( int i = 0; i < brandsToAdd.size(); i++ )
            {
                brandsToAdd[i].save();

                if( ( i + 1 ) % 100 == 0 )
                {
                    def session = sessionFactory.currentSession;
                    session.flush();
                    session.clear();
                    propertyInstanceMap.get().clear();
                    
                    log.info( "[${siteId}] Inserting categories...(${i}/${brandsToAdd.size()})" );
                }
            }

            log.info( "[${siteId}] Categories inserted. Duration: ${TimeCategory.minus( new Date(), startTime )}" );
        }
    }
}
