<%
/*###############################################################################
# Nombre del Programa :  reporteAcumuladoAdquiriente.jsp						#
# Autor               :  Juan Antonio Guzman Gomez                              #
# Compania            :  SAS S.A. DE C.V.                                  		#
# Proyecto/Procliente :  Z-02-2675-12                 	   FECHA:07/02/2013     #
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

    String fechaInicial;
    String fehaFinal;
    String Adquiriente;
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
			fechaInicial = (String)session.getAttribute("initDate");
			fehaFinal = (String)session.getAttribute("endDate");
            Adquiriente= (String )session.getAttribute("Adquiriente");
            
            
            ejecuto= session.getAttribute("login").toString();
		%>
		
		<birt:viewer id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/vtcacad01.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="Reporte Acumulado tiempo aire Adquiriente" showToolBar="true">
			
			<birt:param name="fechaInicial" value="<%=fechaInicial%>" />
			<birt:param name="fehaFinal" value="<%=fehaFinal%>" />
			<birt:param name="Adquiriente" value="<%=Adquiriente%>" />
			
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
			
		</birt:viewer>
	</body>
</html>