package fasecoldaadmin

import static groovyx.net.http.Method.GET;
import static groovyx.net.http.ContentType.JSON;
//import com.newrelic.api.agent.NewRelic;
//import com.newrelic.api.agent.Trace;

class JobBrandsJob {
   
    static triggers =
    {
        simple name           : 'CategoriesDumperJobTrigger',
               startDelay     : 10000l,         // 10 seconds
               repeatInterval : ( 60l * 1000l ) // execute job once in 60 seconds
    }

    def concurrent = false;

    def NewBrandsService;
    def restClient;

  //@Trace( dispatcher = true )
    def execute()
    {
        log.info( "Executing job..." );
        
        // Get the sites //
        def sites;

        log.info( "Getting sites..." );
        
        restClient.request( GET, JSON )
        { req ->
            uri.path = "/sites";

            response.success =
            { resp, json ->
                sites = json;
            }

            response.failure =
            { resp ->
                log.info( "ERROR Getting sites. Status: ${resp.status}. ${resp.data}" );
            }
        };

        log.info( "DONE Getting sites. Count: ${sites.size()}" );

        for( def site : sites )
        {
            NewBrandsService.buildSiteBrands( site.id );
        }
        
        log.info( "Job end." );
    }
}
