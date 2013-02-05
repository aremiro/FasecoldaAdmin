import grails.util.Environment;

//import com.ml.memcached.MemcachedCache;
//import com.ml.memcached.MemcachedCacheMock;

import org.codehaus.groovy.grails.commons.ApplicationHolder;
import groovyx.net.http.RESTClient;

beans =
{
	def config = ApplicationHolder.application.config;

	// REST Client //
	//    restClient( RestClient )
	//    { bean ->
	//        bean.initMethod = "init";
	//        bean.scope      = "singleton";
	//        pools           = [
	//                              "/categories/.*"           : ref( "categoriesPool" ),
	//                              "/sites/.*/categories/all" : ref( "categoriesPool" ),
	//                              "/sites/.*"                : ref( "sitesPool" ),
	//                          ];
	//    }

	restClient( RESTClient )
	{ bean ->
		//bean.initMethod    = "init";
		bean.destroyMethod = "shutdown";
		bean.scope         = "singleton";

		uri = config.grails.apisURL.toString();

	}

	//    categoriesPool( FastHttpClientPool )
	//    { bean ->
	//        bean.initMethod       = "init";
	//        bean.destroyMethod    = "destroy";
	//        bean.scope            = "singleton";
	//        name                  = "HTTP Pool - Categories";
	//        baseUrl               = config.grails.apisURL.toString();
	//        validationUri         = "/categories/ping";
	//        timeBetweenValidation = 20000;
	//        soTimeout             = 10000;
	//        defaultPoolWait       = 10000;
	//        resourcesNumber       = 5;
	//        keepAlive             = 300;
	//        repairThreadsNumber   = 2;
	//        logTime               = 1000 * 60 * 2;
	//    }
	//
	//    sitesPool( FastHttpClientPool )
	//    { bean ->
	//        bean.initMethod       = "init";
	//        bean.destroyMethod    = "destroy";
	//        bean.scope            = "singleton";
	//        name                  = "HTTP Pool - Sites";
	//        baseUrl               = config.grails.apisURL.toString();
	//        validationUri         = "/sites";
	//        timeBetweenValidation = 20000;
	//        soTimeout             = 10000;
	//        defaultPoolWait       = 10000;
	//        resourcesNumber       = 5;
	//        keepAlive             = 300;
	//        repairThreadsNumber   = 2;
	//        logTime               = 1000 * 60 * 2;
	//    }

	// Cache //
	
}
