<%
/*###############################################################################
# Nombre del Programa :  SICLIR0170.jsp											#
# Autor               :  J0SE ANDRES CASTILLO MORENO                            #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-08-299-04                 	   FECHA:21/09/2010     #
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
<%!
    HTML html;
    String btnLstTOC;
    String initDate;
    String endDate; 
    String moneda;
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
                    moneda = (String)session.getAttribute("moneda");
                    ejecuto= session.getAttribute("login").toString();
		%>
		<birt:viewer  id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/siclir0170.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 SICLIR0170" showToolBar="true" >
			<birt:param name="initDate" value="<%=initDate%>" />
			<birt:param name="endDate" value="<%=endDate%>" />
			<birt:param name="moneda" value="<%=moneda%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
		</birt:viewer>
	</body>
</html>