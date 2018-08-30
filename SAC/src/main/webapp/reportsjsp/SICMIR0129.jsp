<%/*
#################################################################################
#                                                                               #
# Nombre del Programa :  SICMIR0129.jsp                                         #
# Autor               :  Daniel Ramírez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  B-54-2904-15                 	   FECHA:25/08/2016     #
# Marca de Cambio     :  SAS-B-54-2904-15-DRT                	                #
# Descripcion General :	 Mejorar Reportería SAC2                                #
#                                                                               #
###############################################################################*/
%>
<%@ taglib uri="/birt.tld" prefix="birt"%>
<%@page import="com.wellcom.io.HTML"%>
<a href="Siclir0077.jsp"></a>
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
	  String banco;	
	  String prefijo;
	  String ejecuto;
	  String dcc;
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
            banco    = (String)session.getAttribute("banco");
            prefijo  = (String)session.getAttribute("prefijo");
            ejecuto  = session.getAttribute("login").toString();

		%>
		<birt:viewer id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/SICMIR0129.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 REP_127_MI" showToolBar="true" >
			<birt:param name="initDate" value="<%=initDate%>" />		
			<birt:param name="banco" value="<%=banco%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
		</birt:viewer>
</body>
</html>