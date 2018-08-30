<%
/*
################################################################################
# Nombre              : SICLIQ0090.jsp                                         #
# Autor               : Ascencion Hernandez Huerta                             #
# Compania            : Axia Consultores, S.A. de C.V.                         #
# Proyecto/Procliente : P-53-2933-14                          FECHA:04/06/2015 #
# Descripcion General : Recalculo de compensacion y administracion de umbrales #
# Modificacion        : Reporte de Liquidacion                                 #
# Programa Dependiente: N/A                                                    #
# Programa Subsecuente: N/A                                                    #
# Cond. de ejecucion  : Acceder al sistema                                     #
# Dias de ejecucion   : A Peticion del web, se pueden ejecutar n instancias    #
#------------------------------------------------------------------------------#
#                                MODIFICACIONES                                #
#------------------------------------------------------------------------------#
# Autor               : N/A                                                    #
# Compania            : N/A                                                    #
# Proyecto/Procliente : N/A                                 Fecha: 00/00/0000  #
# Descripcion General : N/A                                                    #
# Modificacion        : N/A                                                    #
# Marca del Cambio    : N/A                                                    #
#------------------------------------------------------------------------------#
# Numero de Parametros: 1                                                      #
# Parametros Entrada  : Order Date                         Formato:aaaammdd    #
# Parametros Salida   : N/A                                Formato:N/A         #
# Archivo    Entrada  : N/A                                Formato:N/A         #
# Arvhivo    Salida   : N/A                                Formato:N/A         #
################################################################################
*/
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
	String banco;
	String ejecuto;
	String initDateAntHab;
	String endDateAntHab;
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
         		initDateAntHab=(String)session.getAttribute("txtfStartDatePrev");
         		endDateAntHab=(String)session.getAttribute("txtfEndDatePrev");
         		banco = session.getAttribute("banco").toString();
         		ejecuto= session.getAttribute("login").toString();
         %>
         
		<birt:viewer id="birtViewer"   reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/SICLIQ0090.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 SICLIQ0090" showToolBar="true" >
			<birt:param name="initDate" value="<%=initDate%>" />
			<birt:param name="endDate" value="<%=endDate%>" />
			<birt:param name="initDateAntHab" value="<%=initDateAntHab%>" />
			<birt:param name="endDateAntHab" value="<%=endDateAntHab%>" />
			<birt:param name="banco" value="<%=banco%>" /> 
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
		</birt:viewer>
	</body>
</html>