<%
// ----------------------------------------------------------------------------
// Nombre del Programa : SICCMR0050.jsp
// Autor               : Manuel Villalobos
// Compania            : GSOF
// Proyecto/Procliente : P-53-2727-14                       Fecha: 23/ENE/2015
// Descripcion General : JSP PARA LA PANTALLA DE REPORTE SICCMR0050
// Programa Dependiente: N/A
// Programa Subsecuente: N/A
// Cond. de ejecucion  : N/A
// Dias de ejecucion   : N/A                                 Horario: N/A
//                              MODIFICACIONES
// ----------------------------------------------------------------------------
/*
# Autor               :  Daniel Ramírez Torres                                 #
# Compania            :  SAS S.A. DE C.V.                                      #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017        #
# Modificacion        :  Mejora Conexiones  SAC2                               #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                  #    
#------------------------------------------------------------------------------#
*/
// Numero de Parametros:
// Parametros Entrada  :                                    Formato Salida:
//
// Parametros Salida   : N/A                                Formato Salida: N/A
// ----------------------------------------------------------------------------
%>
<%@ page language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
response.setHeader     ("Cache-Control", "no-store");
response.setHeader     ("Pragma",        "no-cache");
response.setDateHeader ("Expires",       0);

%>
<%@ page import="com.wellcom.io.*" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>
<%@ page import="com.wellcom.struts.*" %>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<jsp:useBean id="datos" scope="session" class="com.wellcom.struts.SICCMR0050Form"/>
<%
    if(!ga.AccessGranted(session, "grantAccess"))
    {
        response.sendRedirect("login.jsp");
    }
%>
<html>
    <SCRIPT LANGUAGE="JavaScript" SRC="<%= request.getContextPath() + "/script/calendar/agenda.js"%>"></SCRIPT>
    <script language="javascript">
        function ejecutar(valor)
        {
            if (document.forms[0].camaraEmi.value == "-1") {
                alert("Debe elegir una Camara");
                return false;
            }
            if (document.forms[0].bancoEmi.value == "-1") {
                alert("Debe elegir un Emisor");
                return false;
            }
            if ((document.forms[0].fechaInicio.value.length != 0) && (document.forms[0].fechaFinal.value.length != 0)) {
                document.forms[0].accion.value = valor;
                return true;
            } else {
                alert("Las Fechas deben tener formato 'dd/mm/aaaa'");
                return false;
            }
        }
    </script>
    <link rel="stylesheet" href="<%= request.getContextPath() + "/css/estilosSICCMR.css"%>" type="text/css">
    <table   width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td id="rightColumns" valign="top" >
                <!--Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación -->
                <form action="ControllerServletCompensacion?action=SICCMR0050" method="post" name="frmTOCHeader" target="_blank">
                <!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación -->
                    <table width="100%" border="1" bordercolor="#CE000C">
                        <tr><td >
                                <table width="100%" border="0" bordercolor="#FFFFFF">
                                    <tr>
                                        <td class="titulo2" colspan="6">
                                            SICCMR0050 Reporte de la Compensaci&oacute;n C&aacute;mara E-Global
                                        </td>
                                    </tr>
                                    <tr><td class="vacio"  colspan="6" >&nbsp;
                                        </td></tr>
                                    <tr>
                                        <td class="etiquetaListado" width="110px">
                                            Fecha Del
                                        </td>
                                        <td valign="middle" width="230px">
                                            <input name="fechaInicio" type="text" id="txtfStartDate" size="15" readonly maxlength="15" value=<%=session.getAttribute("fechaHoy")%>>
                                            <a href="javascript:void(0)" onclick="if (self.gfPop)
                                                        gfPop.fPopCalendar(document.frmTOCHeader.fechaInicio);
                                                    return false;" hidefocus>
                                                <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg" border="0" alt="">
                                            </a><br/>
                                        </td>
                                        <td class="etiquetaListado" width="110px">
                                            Al
                                        </td>
                                        <td valign="middle" width="230px">
                                            <input name="fechaFinal" type="text" id="txtfEndDate" size="15" readonly maxlength="15" value=<%=session.getAttribute("fechaHoy")%>>
                                            <a href="javascript:void(0)" onclick="if (self.gfPop)
                                                        gfPop.fPopCalendar(document.frmTOCHeader.fechaFinal);
                                                    return false;" hidefocus>
                                                <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg" border="0" alt="">
                                            </a><br/>
                                        </td>
                                        <td class="etiquetaListado" width="110px">
                                            Formato Salida
                                        </td>
                                        <td valign="middle" width="210px">
                                            <select name="formato" value="0" >
                                                <option value="0" selected>Html</option>
                                                <option value="1">Excel</option>
                                                <option value="2">Pdf</option>
                                            </select>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="etiquetaListado">
                                            C&aacute;mara
                                        </td>
                                        <td valign="middle">
                                            <select id="camaraEmi" name="camaraEmi" multiple="multiple" size="5">
                                                <option value="-1" selected>Selecciona una Camara</option>
                                                <c:forEach var="elemento" items="${datos.camarasE}">
                                                    <option value='<c:out value="${elemento.clave}"/>'><c:out value="${elemento.descripcion}"/></option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td class="etiquetaListado">
                                            Banco
                                        </td>
                                        <td valign="middle">
                                            <select id="bancoEmi" name="bancoEmi" multiple="multiple" size="10">
                                                <option value="-1" selected>Selecciona un Emisor</option>
                                                <c:forEach var="elemento" items="${datos.bancosE}">
                                                    <option value='<c:out value="${elemento.clave}"/>'><c:out value="${elemento.descripcion}"/></option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td class="vacio" colspan="2">&nbsp;</td>
                                    </tr>

                                    <tr>
                                        <td colspan="6" >
                                            <input type="submit" name="btnBuscar" onclick="javascript:return ejecutar(1);" value="Mostrar Reporte" class="button">
                                        </td>
                                    </tr>
                                </table>
                            </td></tr>
                    </table>
                    <input type="hidden" name="accion" value=<%=datos.getAccion()%>>
                </form>
            </td>
        </tr>
    </table>
    <iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="scripts/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
    </iframe>
</html>
