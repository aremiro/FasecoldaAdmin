
<%@ page import="fasecoldaadmin.InsercionInicial" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'insercionInicial.label', default: 'InsercionInicial')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
    
      <h1>generar dump</h1>
         
         <g:form>
                     <g:actionSubmit action="cargaInicial" value="CARGA INICIAL" />
                     
                    
                    
                     
                     
         </g:form>
      <h1>consultar dump</h1>
     <g:form>
      <g:actionSubmit action="mostrarBrands" value="Listar brands " />
      
     </g:form>
    </body>
</html>
