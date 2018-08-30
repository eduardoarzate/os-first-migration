<%
/*###############################################################################
# Nombre del Programa :  Siclirh0110.jsp                                        #
# Autor               :  Jesus Parra Martinez                                   #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  P-06-0527-11                 	   FECHA:01/07/2015     #
# Descripcion General :	 Implementación de Hub de Pagos en PROSA		        #
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :						                                    #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :														    #
#-----------------------------------------------------------------------------  #  
#								MODIFICACIONES                                  #  
# Autor               :  Laura Maleni Ramirez Vazquez                           #  
# Compania            :  SAS				                                    #  
# Proyecto/Procliente :  P-21-0013-16                Fecha: 19/02/2016          #  
# Modificación        :  Modificacion de hub de Pagos para Mifel                # 
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
    String bancoEmi;
	String tipoTarjeta;
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
            bancoEmi = (String)session.getAttribute("bancoEmi");
            ejecuto= session.getAttribute("login").toString();
			tipoTarjeta= (String)session.getAttribute("tipoTransac");
		%>
		<birt:viewer id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/siclirH0110.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 SICLIRH0110" showToolBar="true" >
			<birt:param name="initDate" value="<%=initDate%>" />
			<birt:param name="endDate" value="<%=endDate%>" />
			<birt:param name="bancoEmi" value="<%=bancoEmi%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="tipoTarjeta" value="<%=tipoTarjeta%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
		</birt:viewer>
	</body>
</html>