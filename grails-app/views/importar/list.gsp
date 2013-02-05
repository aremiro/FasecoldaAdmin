
<%@ page import="fasecoldaadmin.Importar" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'importar.label', default: 'Importar')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
           <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
        </div>
           <h1>Carga de Archivo *.csv</h1>

      <g:form> 
       <g:textField name="myField" value="/Users/nicolasmoraes/Desktop/Autoplaza/GuiaPrueba.csv" />
       
       
       
       <g:actionSubmit action="loadData" value="Subir *.CSV" />
       
       </g:form>
       
            
    </body>
</html>
