<%
/*###############################################################################
# Nombre del Programa :  Sicmor0301.jsp                                         #
# Autor               :  CARLOS MENDEZ                                          #
# Compania            :  PROSA                                                  #
# Proyecto/Procliente :  P-08-299-04                       FECHA:03/12/2012     #
# Descripcion General :                                                         #
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :                                                         #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :                                                         #
#################################################################################
#                               MODIFICACIONES                                  #
# Autor               :                                                         #
# Compania            :                                                         #
# Proyecto/Procliente :                              Fecha:                     #
# Modificación        :                                                         #
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
	String initDate;
	String bancoAdq;
	String bancoEmi;
	String suparticion;
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
					suparticion = (String)session.getAttribute("suparticion");
					bancoAdq = (String)session.getAttribute("bancoAdq");
					bancoEmi = (String)session.getAttribute("bancoEmi");
					ejecuto= session.getAttribute("login").toString();										
		%>
		<birt:viewer id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/sicmor0301.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 SICMOR0301" showToolBar="true" >
			<birt:param name="initDate" value="<%=initDate%>" />
			<birt:param name="suparticion" value="<%=suparticion%>" />
			<birt:param name="adq" value="<%=bancoAdq%>" />
			<birt:param name="emi" value="<%=bancoEmi%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />			
		</birt:viewer>
	</body>
</html>