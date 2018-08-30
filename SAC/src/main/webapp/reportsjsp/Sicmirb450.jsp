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
	String initDateHabAnt;
    String endDateHabAnt;
	String bancoAdq;
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
           initDateHabAnt=(String)session.getAttribute("initDateHabAnt");
           endDateHabAnt=(String)session.getAttribute("endDateHabAnt");
           bancoAdq = (String)session.getAttribute("bancoAdq");
           ejecuto= session.getAttribute("login").toString();
		%>
		<birt:viewer   id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/sicmirb450.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 SICMIRB450" showToolBar="true" >
			<birt:param name="initDate" value="<%=initDate%>" />
			<birt:param name="endDate" value="<%=endDate%>" />
			<birt:param name="initDateHabAnt" value="<%=initDateHabAnt%>" />
			<birt:param name="endDateHabAnt" value="<%=endDateHabAnt%>" />
			<birt:param name="bancoAdq" value="<%=bancoAdq%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
		</birt:viewer>
	</body>
</html>