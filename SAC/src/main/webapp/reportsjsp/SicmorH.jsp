<%
/*###############################################################################
# Nombre del Programa :  SicmorH.jsp										    #
#								MODIFICACIONES                                  #  
# Autor               :  Jorge Tellez Resendiz                                  #  
# Compania            :  SAS				                                    #  
# Proyecto/Procliente :  P-21-0013-16                Fecha: 07/04/2016          #  
# Modificación        :  Creacion del Reporte de detalle de						#
#		transacciones HUB CARNET vista CLIENTE  								#
################################################################################*/
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
    String bancoEmi;
	String tipoTransac;
    String ejecuto; 
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
                    initDate = (String)session.getAttribute("txtfStartDate");
                    endDate = (String)session.getAttribute("txtfEndDate");
					bancoEmi = (String)session.getAttribute("bancoEmi");
					tipoTransac = (String)session.getAttribute("tipoTransac");
					ejecuto= session.getAttribute("login").toString();
		%>
		<birt:viewer  id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/sicmorH.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="Reporte de detalle de transacciones HUB CARNET vista CLIENTE" showToolBar="true" >
			<birt:param name="initDate" value="<%=initDate%>" />
			<birt:param name="endDate" value="<%=endDate%>" />
			<birt:param name="bancoEmi" value="<%=bancoEmi%>" />
			<birt:param name="TipoTx" value="<%=tipoTransac%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
		</birt:viewer>
	</body>
</html>