
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
    
      <h1>Generar dump</h1>
         
         <g:form>
                     <g:actionSubmit action="cargaInicial" value="Carga inicial" />
                     
      
                     
         </g:form>
      <h1>Consultar Dump</h1>
     <g:form>
      <g:actionSubmit action="mostrarBrands" value="Listar brands " />      
     </g:form>
   
      <g:form>
      <g:actionSubmit action="mostrarBrandsModel" value="Listar brands-model" />
      </g:form>
     
       <g:form>
      <g:actionSubmit action="mostrarCategory" value="Listar category" />
      </g:form> 
     
      <g:form>
      <g:actionSubmit action="mostrarCategoryBrand" value="Listar category brand" />
      </g:form> 
     
      <g:form>
      <g:actionSubmit action="mostrarModels" value="Listar model" />
      </g:form> 
     
     
     
    </body>
</html>
