<%
/*###############################################################################
# Nombre del Programa :  SICLMNTT01.jsp      		    						#
# Autor               :  Jesus Parra Mtz.                                       #
# Compania            :  Soporte y Asesoria en Sistemas S.A. DE C.V.            #
# Proyecto/Procliente :  P-53-2934-14                 	   FECHA:11/03/2015     #
# Descripcion General :															#
#################################################################################
#								MODIFICACIONES                                  #
# Autor               :                                                         #
# Compania            :                                                         #
# Proyecto/Procliente :                              Fecha:                     #
# Modificación        :                                                         #
#-----------------------------------------------------------------------------  #
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<%@taglib prefix="birt" uri="/birt.tld"%>
<%@page import="com.wellcom.io.HTML"%>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
   }
%>
<%!
	HTML html;
    String btnLstTOC;
    String initDate;
    String endDate;
	String marcas;
	String liquidacion;
    String ejecuto;	
	String pcMarcas;
	String pcLiquidacion;
%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path ;
			
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
	</head>
	<body>
		<% 
		    initDate = (String) session.getAttribute("txtfStartDate");
            endDate = (String) session.getAttribute("txtfEndDate");
			marcas = (String) session.getAttribute("cmbMarcas");
			liquidacion = (String) session.getAttribute("cmbLiq");
            ejecuto= session.getAttribute("login").toString();
			pcMarcas = (String) session.getAttribute("pcMarcas");
			pcLiquidacion = (String) session.getAttribute("pcLiquidacion");
    	%>
		<birt:viewer  id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/SICLMNTT01.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 SICLMNTT01" showToolBar="true" >
			<birt:param name="initDate" value="<%=initDate%>" />
			<birt:param name="endDate" value="<%=endDate%>" />
			<birt:param name="marcas" value="<%=marcas%>"/>
			<birt:param name="liquidacion" value="<%=liquidacion%>"/>
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="pcMarcas" value="<%=pcMarcas%>" />
			<birt:param name="pcLiquidacion" value="<%=pcLiquidacion%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
		</birt:viewer>
	</body>
</html>