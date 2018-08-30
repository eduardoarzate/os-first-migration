
<%
/*###############################################################################
# Nombre del Programa :  reporteAcumuladoComercio.jsp  									#
# Autor               :  Laura Maleni Ramirez Vazquez                           #
# Compania            :  SAS S.A. DE C.V.                                  		#
# Proyecto/Procliente :  Z-02-2675-12                 	   FECHA:31/05/2016     #
# Descripcion General :															#
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :															#
#                                                                               #
#                                                                               #
# Dias de ejecucion   :															#
#################################################################################
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
    String btnLstTOC;
    String initDate;
    String endDate;
          String banco;	
          String tipoPago;	
          String distribuidor;	
          String telefonica;
          String ejecuto;
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
        initDate = (String)session.getAttribute("initDate");
        endDate = (String)session.getAttribute("endDate");
        banco    = (String)session.getAttribute("bancoS");
        tipoPago    = (String)session.getAttribute("tipoPagoS");
        distribuidor  = (String)session.getAttribute("distribuidorS");
        telefonica  = (String)session.getAttribute("telefonicaS");
        ejecuto  = session.getAttribute("login").toString();
        %>
        <birt:viewer id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/vtcacco01.rptdesign\"%>"
                     showParameterPage="false" showTitle="true" pattern="frameset"
                     format="HTML" isHostPage="true" title="Reporte de Acumulado Tiempo Aire por Comercio" showToolBar="true">
            <birt:param name="fechaInicial" value="<%=initDate%>" />		
            <birt:param name="fechaFinal" value="<%=endDate%>" />		
            <birt:param name="banco" value="<%=banco%>" />
            <birt:param name="tipoPago" value="<%=tipoPago%>" />
            <birt:param name="distribuidor" value="<%=distribuidor%>" />
            <birt:param name="telefonica" value="<%=telefonica%>" />
            <birt:param name="ejecuto" value="<%=ejecuto%>" />
            <birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
            <birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
        </birt:viewer>
    </body>
</html>