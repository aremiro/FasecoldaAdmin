<html>
    <head>
        <title>Script generator for DB MOTORS</title>
        <meta name="layout" content="main" />
        <style type="text/css" media="screen">

        #nav {
            margin-top:20px;
            margin-left:30px;
            width:228px;
            float:left;

        }
        .homePagePanel * {
            margin:0px;
        }
        .homePagePanel .panelBody ul {
            list-style-type:none;
            margin-bottom:10px;
        }
        .homePagePanel .panelBody h1 {
            text-transform:uppercase;
            font-size:1.1em;
            margin-bottom:10px;
        }
        .homePagePanel .panelBody {
            background: url(images/leftnav_midstretch.png) repeat-y top;
            margin:0px;
            padding:15px;
        }
        .homePagePanel .panelBtm {
            background: url(images/leftnav_btm.png) no-repeat top;
            height:20px;
            margin:0px;
        }

        .homePagePanel .panelTop {
            background: url(images/leftnav_top.png) no-repeat top;
            height:11px;
            margin:0px;
        }
        h2 {
            margin-top:15px;
            margin-bottom:15px;
            font-size:1.2em;
        }
        #pageBody {
            margin-left:280px;
            margin-right:20px;
        }
        </style>
    </head>
    <body>
        <div id="nav">
            <div class="homePagePanel">
                <div class="panelTop"></div>
                <div class="panelBody">
                    <h1>Application Status</h1>
                    <ul>
                        <li>App version: <g:meta name="app.version"></g:meta></li>
                        <li>Grails version: <g:meta name="app.grails.version"></g:meta></li>
                        <li>Groovy version: ${org.codehaus.groovy.runtime.InvokerHelper.getVersion()}</li>
                        <li>JVM version: ${System.getProperty('java.version')}</li>
                        <li>Controllers: ${grailsApplication.controllerClasses.size()}</li>
                        <li>Domains: ${grailsApplication.domainClasses.size()}</li>
                        <li>Services: ${grailsApplication.serviceClasses.size()}</li>
                        <li>Tag Libraries: ${grailsApplication.tagLibClasses.size()}</li>
                    </ul>
                    <h1>Installed Plugins</h1>
                    <ul>
                        <g:set var="pluginManager"
                               value="${applicationContext.getBean('pluginManager')}"></g:set>

                        <g:each var="plugin" in="${pluginManager.allPlugins}">
                            <li>${plugin.name} - ${plugin.version}</li>
                        </g:each>

                    </ul>
                </div>
                <div class="panelBtm"></div>
            </div>
        </div>
        <div id="pageBody">
            <h1>FASECOLDA/INMA Administrador</h1>
            <p>Bienvenido al administrador para proceso de datos para posterior insercion en la BD mysql MOTORS.
            Esta apliacion contiene 3 controladores, que se detallan a continuacion:
            </p>
           
           <h2>ImportarController</h2>
            <p>
             Este controlador toma un archivo proveniente de FACECOLDA en formato
             *.CSV (contiene marcas, modelos y precios)y lo ingresa al administrador, para poder tratar sus datos y 
             posteriormente poder insertarlos en la BD Motors.
            </p>
			
			  <h2>InsercionInicialController</h2>
            <p>
             Muestra en pantalla el archivo *.csv cargado 
            </p>
			
		    <h2>InsercionInicialController (generador de script de insercion en BD MOTORS)</h2>
            <p>
             Este controlador contiene 2 partes, generar un dump localmente a partir de la API de mercadolibre, simulando
             la base de datos de motors, el cual luego de generado el dump, se podran hacer listados de las 
             tablas simuladas, esos listados son en la consola del IDE, por lo tanto se debe de correr la app
             desde el IDE. </p>
             <BR>
             <p>
             Si queremos generar los insert (ej: INSERT INTO BRANDS .......), debemos entrar al codigo del servicio
             "NewBrandsService" y descomentar el println comentado (//String insert= "INSERT INTO brand (category_id.... ), y oprimir el boton generar dump, entonces a medida que se genrera el dump
             empieza a listar por la consola el insert correspondiente. Una vez finalizado, 
             se comenta el anterior y se descomentan los siguientes, y se oprime de nuevo generar dump, asi sucesivamente.
             <BR><BR>
             Antes de eso necesitamos setear que site le vamos a "pegar" (MCO, MLV..)
             Para eso necesitmos entrar en el codigo del controlador (InsercionInicialController) y modificar:
	         <BR><BR>
	         private final String siteId={poner el site que corresponda: MCO, MLV, etc...};
	         ej: private final String siteId="MLV";
	         
             <BR>
             <BR>
             Luego que generamos el script, se copia de la consola, y se guarda en un archivo .sql, luego de eso podemos ejecutarlo en la base de datos
       
            </p>
	
			
            <div id="controllerList" class="dialog">
                <h2>Controladores disponibles:</h2>
                <ul>
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                        <li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
                    </g:each>
                </ul>
            </div>
        </div>
    </body>
</html>
