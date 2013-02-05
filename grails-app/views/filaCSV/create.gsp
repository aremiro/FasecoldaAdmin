

<%@ page import="fasecoldaadmin.FilaCSV" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'filaCSV.label', default: 'FilaCSV')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${filaCSVInstance}">
            <div class="errors">
                <g:renderErrors bean="${filaCSVInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1970"><g:message code="filaCSV._1970.label" default="1970" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1970', 'errors')}">
                                    <g:textField name="_1970" value="${filaCSVInstance?._1970}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1971"><g:message code="filaCSV._1971.label" default="1971" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1971', 'errors')}">
                                    <g:textField name="_1971" value="${filaCSVInstance?._1971}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1972"><g:message code="filaCSV._1972.label" default="1972" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1972', 'errors')}">
                                    <g:textField name="_1972" value="${filaCSVInstance?._1972}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1973"><g:message code="filaCSV._1973.label" default="1973" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1973', 'errors')}">
                                    <g:textField name="_1973" value="${filaCSVInstance?._1973}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1974"><g:message code="filaCSV._1974.label" default="1974" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1974', 'errors')}">
                                    <g:textField name="_1974" value="${filaCSVInstance?._1974}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1975"><g:message code="filaCSV._1975.label" default="1975" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1975', 'errors')}">
                                    <g:textField name="_1975" value="${filaCSVInstance?._1975}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1976"><g:message code="filaCSV._1976.label" default="1976" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1976', 'errors')}">
                                    <g:textField name="_1976" value="${filaCSVInstance?._1976}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1977"><g:message code="filaCSV._1977.label" default="1977" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1977', 'errors')}">
                                    <g:textField name="_1977" value="${filaCSVInstance?._1977}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1978"><g:message code="filaCSV._1978.label" default="1978" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1978', 'errors')}">
                                    <g:textField name="_1978" value="${filaCSVInstance?._1978}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1979"><g:message code="filaCSV._1979.label" default="1979" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1979', 'errors')}">
                                    <g:textField name="_1979" value="${filaCSVInstance?._1979}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1980"><g:message code="filaCSV._1980.label" default="1980" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1980', 'errors')}">
                                    <g:textField name="_1980" value="${filaCSVInstance?._1980}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1981"><g:message code="filaCSV._1981.label" default="1981" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1981', 'errors')}">
                                    <g:textField name="_1981" value="${filaCSVInstance?._1981}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1982"><g:message code="filaCSV._1982.label" default="1982" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1982', 'errors')}">
                                    <g:textField name="_1982" value="${filaCSVInstance?._1982}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1983"><g:message code="filaCSV._1983.label" default="1983" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1983', 'errors')}">
                                    <g:textField name="_1983" value="${filaCSVInstance?._1983}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1984"><g:message code="filaCSV._1984.label" default="1984" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1984', 'errors')}">
                                    <g:textField name="_1984" value="${filaCSVInstance?._1984}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1985"><g:message code="filaCSV._1985.label" default="1985" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1985', 'errors')}">
                                    <g:textField name="_1985" value="${filaCSVInstance?._1985}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1986"><g:message code="filaCSV._1986.label" default="1986" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1986', 'errors')}">
                                    <g:textField name="_1986" value="${filaCSVInstance?._1986}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1987"><g:message code="filaCSV._1987.label" default="1987" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1987', 'errors')}">
                                    <g:textField name="_1987" value="${filaCSVInstance?._1987}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1988"><g:message code="filaCSV._1988.label" default="1988" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1988', 'errors')}">
                                    <g:textField name="_1988" value="${filaCSVInstance?._1988}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1989"><g:message code="filaCSV._1989.label" default="1989" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1989', 'errors')}">
                                    <g:textField name="_1989" value="${filaCSVInstance?._1989}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1990"><g:message code="filaCSV._1990.label" default="1990" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1990', 'errors')}">
                                    <g:textField name="_1990" value="${filaCSVInstance?._1990}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1991"><g:message code="filaCSV._1991.label" default="1991" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1991', 'errors')}">
                                    <g:textField name="_1991" value="${filaCSVInstance?._1991}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1992"><g:message code="filaCSV._1992.label" default="1992" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1992', 'errors')}">
                                    <g:textField name="_1992" value="${filaCSVInstance?._1992}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1993"><g:message code="filaCSV._1993.label" default="1993" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1993', 'errors')}">
                                    <g:textField name="_1993" value="${filaCSVInstance?._1993}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1994"><g:message code="filaCSV._1994.label" default="1994" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1994', 'errors')}">
                                    <g:textField name="_1994" value="${filaCSVInstance?._1994}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1995"><g:message code="filaCSV._1995.label" default="1995" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1995', 'errors')}">
                                    <g:textField name="_1995" value="${filaCSVInstance?._1995}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1996"><g:message code="filaCSV._1996.label" default="1996" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1996', 'errors')}">
                                    <g:textField name="_1996" value="${filaCSVInstance?._1996}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1997"><g:message code="filaCSV._1997.label" default="1997" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1997', 'errors')}">
                                    <g:textField name="_1997" value="${filaCSVInstance?._1997}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1998"><g:message code="filaCSV._1998.label" default="1998" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1998', 'errors')}">
                                    <g:textField name="_1998" value="${filaCSVInstance?._1998}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_1999"><g:message code="filaCSV._1999.label" default="1999" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_1999', 'errors')}">
                                    <g:textField name="_1999" value="${filaCSVInstance?._1999}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_2000"><g:message code="filaCSV._2000.label" default="2000" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_2000', 'errors')}">
                                    <g:textField name="_2000" value="${filaCSVInstance?._2000}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_2001"><g:message code="filaCSV._2001.label" default="2001" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_2001', 'errors')}">
                                    <g:textField name="_2001" value="${filaCSVInstance?._2001}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_2002"><g:message code="filaCSV._2002.label" default="2002" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_2002', 'errors')}">
                                    <g:textField name="_2002" value="${filaCSVInstance?._2002}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_2003"><g:message code="filaCSV._2003.label" default="2003" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_2003', 'errors')}">
                                    <g:textField name="_2003" value="${filaCSVInstance?._2003}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_2004"><g:message code="filaCSV._2004.label" default="2004" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_2004', 'errors')}">
                                    <g:textField name="_2004" value="${filaCSVInstance?._2004}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_2005"><g:message code="filaCSV._2005.label" default="2005" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_2005', 'errors')}">
                                    <g:textField name="_2005" value="${filaCSVInstance?._2005}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_2006"><g:message code="filaCSV._2006.label" default="2006" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_2006', 'errors')}">
                                    <g:textField name="_2006" value="${filaCSVInstance?._2006}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_2007"><g:message code="filaCSV._2007.label" default="2007" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_2007', 'errors')}">
                                    <g:textField name="_2007" value="${filaCSVInstance?._2007}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_2008"><g:message code="filaCSV._2008.label" default="2008" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_2008', 'errors')}">
                                    <g:textField name="_2008" value="${filaCSVInstance?._2008}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_2009"><g:message code="filaCSV._2009.label" default="2009" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_2009', 'errors')}">
                                    <g:textField name="_2009" value="${filaCSVInstance?._2009}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_2010"><g:message code="filaCSV._2010.label" default="2010" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_2010', 'errors')}">
                                    <g:textField name="_2010" value="${filaCSVInstance?._2010}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_2011"><g:message code="filaCSV._2011.label" default="2011" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_2011', 'errors')}">
                                    <g:textField name="_2011" value="${filaCSVInstance?._2011}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_2012"><g:message code="filaCSV._2012.label" default="2012" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_2012', 'errors')}">
                                    <g:textField name="_2012" value="${filaCSVInstance?._2012}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="_2013"><g:message code="filaCSV._2013.label" default="2013" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: '_2013', 'errors')}">
                                    <g:textField name="_2013" value="${filaCSVInstance?._2013}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="aireAcondicionado"><g:message code="filaCSV.aireAcondicionado.label" default="Aire Acondicionado" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'aireAcondicionado', 'errors')}">
                                    <g:textField name="aireAcondicionado" value="${filaCSVInstance?.aireAcondicionado}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="bcpp"><g:message code="filaCSV.bcpp.label" default="Bcpp" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'bcpp', 'errors')}">
                                    <g:textField name="bcpp" value="${filaCSVInstance?.bcpp}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="capacidadCarga"><g:message code="filaCSV.capacidadCarga.label" default="Capacidad Carga" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'capacidadCarga', 'errors')}">
                                    <g:textField name="capacidadCarga" value="${filaCSVInstance?.capacidadCarga}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="capacidadPasajeros"><g:message code="filaCSV.capacidadPasajeros.label" default="Capacidad Pasajeros" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'capacidadPasajeros', 'errors')}">
                                    <g:textField name="capacidadPasajeros" value="${filaCSVInstance?.capacidadPasajeros}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="cilindraje"><g:message code="filaCSV.cilindraje.label" default="Cilindraje" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'cilindraje', 'errors')}">
                                    <g:textField name="cilindraje" value="${filaCSVInstance?.cilindraje}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="clase"><g:message code="filaCSV.clase.label" default="Clase" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'clase', 'errors')}">
                                    <g:textField name="clase" value="${filaCSVInstance?.clase}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="codigo"><g:message code="filaCSV.codigo.label" default="Codigo" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'codigo', 'errors')}">
                                    <g:textField name="codigo" value="${filaCSVInstance?.codigo}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="combustible"><g:message code="filaCSV.combustible.label" default="Combustible" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'combustible', 'errors')}">
                                    <g:textField name="combustible" value="${filaCSVInstance?.combustible}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="ejes"><g:message code="filaCSV.ejes.label" default="Ejes" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'ejes', 'errors')}">
                                    <g:textField name="ejes" value="${filaCSVInstance?.ejes}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="estado"><g:message code="filaCSV.estado.label" default="Estado" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'estado', 'errors')}">
                                    <g:textField name="estado" value="${filaCSVInstance?.estado}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="homologoCodigo"><g:message code="filaCSV.homologoCodigo.label" default="Homologo Codigo" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'homologoCodigo', 'errors')}">
                                    <g:textField name="homologoCodigo" value="${filaCSVInstance?.homologoCodigo}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="idServicio"><g:message code="filaCSV.idServicio.label" default="Id Servicio" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'idServicio', 'errors')}">
                                    <g:textField name="idServicio" value="${filaCSVInstance?.idServicio}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="importado"><g:message code="filaCSV.importado.label" default="Importado" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'importado', 'errors')}">
                                    <g:textField name="importado" value="${filaCSVInstance?.importado}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="marca"><g:message code="filaCSV.marca.label" default="Marca" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'marca', 'errors')}">
                                    <g:textField name="marca" value="${filaCSVInstance?.marca}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="nacionalidad"><g:message code="filaCSV.nacionalidad.label" default="Nacionalidad" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'nacionalidad', 'errors')}">
                                    <g:textField name="nacionalidad" value="${filaCSVInstance?.nacionalidad}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="novedad"><g:message code="filaCSV.novedad.label" default="Novedad" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'novedad', 'errors')}">
                                    <g:textField name="novedad" value="${filaCSVInstance?.novedad}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="peso"><g:message code="filaCSV.peso.label" default="Peso" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'peso', 'errors')}">
                                    <g:textField name="peso" value="${filaCSVInstance?.peso}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="pesoCategoria"><g:message code="filaCSV.pesoCategoria.label" default="Peso Categoria" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'pesoCategoria', 'errors')}">
                                    <g:textField name="pesoCategoria" value="${filaCSVInstance?.pesoCategoria}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="potencia"><g:message code="filaCSV.potencia.label" default="Potencia" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'potencia', 'errors')}">
                                    <g:textField name="potencia" value="${filaCSVInstance?.potencia}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="puertas"><g:message code="filaCSV.puertas.label" default="Puertas" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'puertas', 'errors')}">
                                    <g:textField name="puertas" value="${filaCSVInstance?.puertas}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referencia1"><g:message code="filaCSV.referencia1.label" default="Referencia1" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'referencia1', 'errors')}">
                                    <g:textField name="referencia1" value="${filaCSVInstance?.referencia1}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referencia2"><g:message code="filaCSV.referencia2.label" default="Referencia2" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'referencia2', 'errors')}">
                                    <g:textField name="referencia2" value="${filaCSVInstance?.referencia2}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referencia3"><g:message code="filaCSV.referencia3.label" default="Referencia3" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'referencia3', 'errors')}">
                                    <g:textField name="referencia3" value="${filaCSVInstance?.referencia3}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="servicio"><g:message code="filaCSV.servicio.label" default="Servicio" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'servicio', 'errors')}">
                                    <g:textField name="servicio" value="${filaCSVInstance?.servicio}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="tipoCaja"><g:message code="filaCSV.tipoCaja.label" default="Tipo Caja" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'tipoCaja', 'errors')}">
                                    <g:textField name="tipoCaja" value="${filaCSVInstance?.tipoCaja}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="transmision"><g:message code="filaCSV.transmision.label" default="Transmision" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'transmision', 'errors')}">
                                    <g:textField name="transmision" value="${filaCSVInstance?.transmision}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="um"><g:message code="filaCSV.um.label" default="Um" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: filaCSVInstance, field: 'um', 'errors')}">
                                    <g:textField name="um" value="${filaCSVInstance?.um}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
