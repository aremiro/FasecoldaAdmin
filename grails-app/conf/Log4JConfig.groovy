import org.apache.log4j.PatternLayout;

// Log4J Configuration //
log4j =
{
    environments
    {
        development
        {
            appenders
            {
                console name : 'stdout', layout : new PatternLayout( conversionPattern : '%d{yyyy-MM-dd HH:mm:ss} %-5p [%c{2}] %m%n' );
                'null'  name : 'nullAppender';
            }
        
            error 'org.codehaus.groovy.grails.web.servlet',
                  'org.codehaus.groovy.grails.web.pages',
                  'org.codehaus.groovy.grails.web.sitemesh',
                  'org.codehaus.groovy.grails.web.mapping.filter',
                  'org.codehaus.groovy.grails.web.mapping',
                  'org.codehaus.groovy.grails.commons',
                  'org.codehaus.groovy.grails.plugins',
                  'org.codehaus.groovy.grails.orm.hibernate',
                  'org.springframework',
                  'org.hibernate',
                  'net.sf.ehcache.hibernate';
            
            info stdout : 'grails.app';
            
            root
            {
                error 'stdout';
            };
        }
        
        production
        {
            appenders
            {
                'null'      name : "stacktrace";
                rollingFile name : "appLog"      , maxFileSize : '50MB',  maxBackupIndex : 5, file :"/Users/nicolasmoraes/log.log"    , layout : pattern( conversionPattern : '%d{yyyy-MM-dd HH:mm:ss} %-5p [%c{2}] %m%n' ), encoding : 'UTF-8';
                rollingFile name : "appLogDebug" , maxFileSize : '50MB',  maxBackupIndex : 5, file :"/Users/nicolasmoraes/log2.log", layout : pattern( conversionPattern : '%d{yyyy-MM-dd HH:mm:ss} %-5p [%c{2}] %m%n' ), encoding : 'UTF-8';
            };
        
            info  appLog      : ['grails.app.task', 'grails.app.service'], additivity : false;
            debug appLogDebug : ['grails.app.task', 'grails.app.service'], additivity : false;
            
            root
            {
                error 'appLog';
            };
        }
    }
}