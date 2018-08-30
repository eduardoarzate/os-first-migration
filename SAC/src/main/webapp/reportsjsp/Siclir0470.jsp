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
    //String endDate;  
    String bancosStr;
    //String tipoLiqStr;
    String folio;
    String anio;
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
            initDate = (String)session.getAttribute("txtfStartDate");
            bancosStr = (String)session.getAttribute("banco");
            anio=(String)session.getAttribute("anio");
            folio=(String)session.getAttribute("folio");
            
            //bancoSocio = (String)session.getAttribute("bancoSocio");
            ejecuto= session.getAttribute("login").toString();
		%>
		<birt:viewer id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/siclir0470.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 SICLIR0470" showToolBar="true">
			<birt:param name="initDate" value="<%=initDate%>" />
			<birt:param name="banco" value="<%=bancosStr%>" />
			<birt:param name="anio" value="<%=anio%>" />
			<birt:param name="folio" value="<%=folio%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
		</birt:viewer>
	</body>
</html>