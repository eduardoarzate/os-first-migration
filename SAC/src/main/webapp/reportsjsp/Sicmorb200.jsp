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
	String bancoAdq;
	String bancoEmi;
	String fuente;
	String naturaleza;
	String transaccion;
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
                    endDate = (String)session.getAttribute("txtfEndDate");                    
                    bancoAdq = (String)session.getAttribute("bancoAdq");
                    bancoEmi = (String)session.getAttribute("bancoEmi");
                    fuente = (String)session.getAttribute("fuente");
                    transaccion = (String)session.getAttribute("transaccion");
                    naturaleza = (String)session.getAttribute("naturaleza");
                    if (naturaleza.equals("CD"))
                    {
                    	naturaleza = "C','D";
                    }
                    ejecuto= session.getAttribute("login").toString();
		%>
		<birt:viewer   id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/sicmorb200.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 SICMORB200" showToolBar="true" >
			<birt:param name="initDate" value="<%=initDate%>" />
			<birt:param name="endDate" value="<%=endDate%>" />			
			<birt:param name="bcoadq" value="<%=bancoAdq%>" />
			<birt:param name="bcoemi" value="<%=bancoEmi%>" />
			<birt:param name="fuente" value="<%=fuente%>" />
			<birt:param name="ttr" value="<%=transaccion%>" />
			<birt:param name="natcon" value="<%=naturaleza%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
		</birt:viewer>
	</body>
</html>