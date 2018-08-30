<%
/*###############################################################################
# Nombre del Programa :  SICLIR0100CSAT.jsp	    								#
# Autor               :  GERMAN GONZALEZ ESQUIVEL                               #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-04-2862-13                 	   FECHA:06/11/2013     #
# Descripcion General :															#
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :															#
#                                                                               #
#                                                                               #
# Dias de ejecucion   :															#
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
<%@ taglib uri="/birt.tld" prefix="birt"%>
<%@page import="com.wellcom.io.HTML"%>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%
    if(!ga.AccessGranted(session, "grantAccess"))
    {
        response.sendRedirect("login.jsp");
    }
%>
<%
	HTML html;
    String btnLstTOC;
    String initDate;
    String endDate;
    String banco;
    String susparticiones;
    String cuenta;
    String autorizacion;
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
            banco = (String)session.getAttribute("banco");
            cuenta = (String)session.getAttribute("cuenta");
            autorizacion = (String)session.getAttribute("autorizacion");
            susparticiones = (String)session.getAttribute("susparticiones");
            ejecuto= session.getAttribute("login").toString();
		%>
		<birt:viewer id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/siclir0100csat.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 SICLIR0100CSAT" showToolBar="true" 
			showParameterPage="false">
			<birt:param name="initDate" value="<%=initDate%>" />
			<birt:param name="endDate" value="<%=endDate%>" />
			<birt:param name="banco" value="<%=banco%>" />
			<birt:param name="cuenta" value="<%=cuenta%>" />
			<birt:param name="autorizacion" value="<%=autorizacion%>" />
			<birt:param name="susparticiones" value="<%=susparticiones%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
		</birt:viewer>
	</body>
</html>