<%
/*###############################################################################
# Nombre del Programa :  Mxvrtac001.jsp											#
# Autor               :  Velasco Palacios Miguel                                #
# Compania            :  SAS S.A. DE C.V.                                  		#
# Proyecto/Procliente :  P-02-0216-12                  	   Fecha: 03/06/2014    #
# Descripcion General :															#
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :															#
#                                                                               #
#                                                                               #
# Dias de ejecucion   :															#
#################################################################################
#								MODIFICACIONES  #
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS                                                    #
# Proyecto/Procliente :  P-20-0096-15                   Fecha:   24/06/2016     #
# Modificación        :  Fase 2 del Programa Súper Ofertas Santander sobretasa 0#
#-----------------------------------------------------------------------------  #
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<%@ taglib uri="/birt.tld" prefix="birt"%>
<%@page import="com.wellcom.io.HTML"%>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%
    if(!ga.AccessGranted(session, "grantAccess"))
    {
        response.sendRedirect("login.jsp");
    }
%>
<%!
    HTML html;
    String fechaInicial;
    String fehaFinal;
    String Adquiriente;
    String Emisor;
    String ejecuto;
    String tasaMxvrtac;
%>
<%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                        + request.getServerName() + ":" + request.getServerPort()
                        + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <base href="<%=basePath%>">
    </head>
    <body>
        <% 	
        fechaInicial = (String)session.getAttribute("initDate");
        fehaFinal = (String)session.getAttribute("endDate");
        Adquiriente = (String)session.getAttribute("Adquiriente");
        Emisor = (String)session.getAttribute("Emisor");
        ejecuto = session.getAttribute("login").toString();
        tasaMxvrtac = (String)session.getAttribute("tasaMxvrtac");
        %>
        <birt:viewer id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/Mxvrtac001.rptdesign\"%>"
                     showParameterPage="false" showTitle="true" pattern="frameset"
                     format="HTML" isHostPage="true" title="Reporte de Transacciones Clicash (Detalle por Adquiriente)" showToolBar="true">
            <birt:param name="initDate" value="<%=fechaInicial%>" />
            <birt:param name="endDate" value="<%=fehaFinal%>" />
            <birt:param name="bancoEmi" value="<%=Emisor%>" />
            <birt:param name="bancoAdq" value="<%=Adquiriente%>" />
            <birt:param name="ejecuto" value="<%=ejecuto%>" />
            <birt:param name="tasaMxvrtac" value="<%=tasaMxvrtac%>" />
        </birt:viewer>
    </body>
</html>