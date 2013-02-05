
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
        //log.info( "[${siteId}] Building site" );

        //SiteDumpInfo infoAPI = new SiteDumpInfo();

        //log.info( "[${siteId}] Getting HEAD" );
        //restClient.request( HEAD, JSON )
        //{ req ->
         //   uri.path = "/sites/MCO/categories/MCO1744".toString();

            //response.success =
           // { resp ->
             //   infoAPI.md5           = resp.headers.'X-Content-MD5';
              //  infoAPI.lastUpdateDate = dateTimeFormatter.parseDateTime( resp.headers.'X-Content-Created' );
           // }

           // response.failure =
           // { resp ->
             //   log.info( "[${siteId}] ERROR Getting dump HEAD. Status: ${resp.status}. ${resp.data}" );
           // }
        //};

        //String cacheKey = "${siteId}_dump_header";
    
        //SiteDumpInfo infoCache = attributesCache.get( cacheKey );

      //  if( infoAPI != infoCache )
        //{
            //log.info( "[${siteId}] New dump (Old: ${infoCache?.md5}, New: ${infoAPI.md5})" );
            
            getBrandDump("MCO" ); //siteId

          //  attributesCache.put( cacheKey, infoAPI );
       // }
        //else
        //{
          //  log.info( "[${siteId}] Same dump." );
        //}
    }

    private def getBrandDump( String siteId )
    {
        log.info( "[${siteId}] Getting dump..." );
        
        def brands;

        Date startTime = new Date();
        
        restClient.request( GET, JSON )
        { req ->
            uri.path = "/sites/${siteId}/categories/MCO1744".toString();

            response.success =
            { resp, json ->
                brands = json;
            }

            response.failure =
            { resp ->
                log.info( "[${siteId}] ERROR Getting dump. Status: ${resp.status}. ${resp.data}" );
            }
        };

        if( brands )
        {
            //log.info( "[${siteId}] DONE Getting dump. Duration: ${TimeCategory.minus( new Date(), startTime )}" );
            
            //log.info( "[${siteId}] Deleting categories" );
            Brand.executeUpdate( "delete Brand c where c.siteId = :siteId", [siteId : "${siteId}"] );
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
            
            log.info( "[${siteId}] Inserting categories..." );
            log.info( "[${siteId}] Inserting categories...(0/${brandsToAdd.size()})" );
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
