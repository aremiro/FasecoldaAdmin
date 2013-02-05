
<%@ page import="fasecoldaadmin.FilaCSV" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'filaCSV.label', default: 'FilaCSV')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'filaCSV.id.label', default: 'Id')}" />
                        
                  
                        
                         <g:sortableColumn property="Novedad" title="${message(code: 'filaCSV.Novedad.label', default: 'Novedad')}" />
                        
                         <g:sortableColumn property="Marca" title="${message(code: 'filaCSV.Marca.label', default: 'Marca')}" />
                         
                           <g:sortableColumn property="Clase" title="${message(code: 'filaCSV.Novedad.label', default: 'clase')}" />
                        
                         <g:sortableColumn property="Codigo" title="${message(code: 'filaCSV.Marca.label', default: 'Codigo')}" />
                        
                        <g:sortableColumn property="HomologoCodigo" title="${message(code: 'filaCSV.Marca.label', default: 'HomologoCodigo')}" />
                        
                        <g:sortableColumn property="Referencia1" title="${message(code: 'filaCSV.Marca.label', default: 'Referencia1')}" />
                        
                        <g:sortableColumn property="Referencia2" title="${message(code: 'filaCSV.Marca.label', default: 'Referencia2')}" />
                        
                        <g:sortableColumn property="Referencia3" title="${message(code: 'filaCSV.Marca.label', default: 'Referencia3')}" />
                        	
	                        <g:sortableColumn property="Peso" title="${message(code: 'filaCSV.Marca.label', default: 'Peso')}" />
	

	

                        
                        
                        
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${filaCSVInstanceList}" status="i" var="filaCSVInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${filaCSVInstance.id}">${fieldValue(bean: filaCSVInstance, field: "id")}</g:link></td>
                        
                    
                        
                            <td>${fieldValue(bean: filaCSVInstance, field: "Novedad")}</td>
                            
                            <td>${fieldValue(bean: filaCSVInstance, field: "Marca")}</td>
                            
                             <td>${fieldValue(bean: filaCSVInstance, field: "Clase")}</td>
                             
                            <td>${fieldValue(bean: filaCSVInstance, field: "Codigo")}</td>
                             
                           <td>${fieldValue(bean: filaCSVInstance, field: "HomologoCodigo")}</td>
                             
                           <td>${fieldValue(bean: filaCSVInstance, field: "Referencia1")}</td>
                           <td>${fieldValue(bean: filaCSVInstance, field: "Referencia2")}</td>
                            <td>${fieldValue(bean: filaCSVInstance, field: "Referencia3")}</td>
                            <td>${fieldValue(bean: filaCSVInstance, field: "Peso")}</td>
                                                            
                             
                             
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${filaCSVInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
