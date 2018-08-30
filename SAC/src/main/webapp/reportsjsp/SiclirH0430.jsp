<%
/*###############################################################################
# Nombre del Programa :  SICLIRH0430.jsp										#
# Autor               :  JESUS PARRA MARTINEZ.                                  #
# Compania            :  Soporte y Asesoria en Sistemas S.A. DE C.V.            #
# Proyecto/Procliente :  P-06-0527-11                  	   FECHA:05/08/2014     #
# Descripcion General :															#
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :															#
#                                                                               #
#                                                                               #
# Dias de ejecucion   :															#
#-----------------------------------------------------------------------------  #  
#								MODIFICACIONES                                  #  
# Autor               :  Laura Maleni Ramirez Vazquez                           #  
# Compania            :  SAS				                                    #  
# Proyecto/Procliente :  P-21-0013-16                Fecha: 19/02/2016          #  
# Modificación        :  Modificacion de hub de Pagos para Mifel                # 
#-----------------------------------------------------------------------------  #  
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
    String interred; 
    String ejecuto; 
    String bancoEmi;
	String tipoTarjeta;
    String susparticiones;
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
					tipoTarjeta= (String)session.getAttribute("tipoTransac");
                    interred = (String)session.getAttribute("interred");
                    ejecuto= session.getAttribute("login").toString();
                    susparticiones = (String)session.getAttribute("susparticiones");
		%>
		<birt:viewer   id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/siclirH0430.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 SICLIRH0430" showToolBar="true" >
			<birt:param name="initDate" value="<%=initDate%>" />
			<birt:param name="endDate" value="<%=endDate%>" />
			<birt:param name="interred" value="<%=interred%>" />
			<birt:param name="bancoEmi" value="<%=bancoEmi%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="tipoTarjeta" value="<%=tipoTarjeta%>" />
			<birt:param name="susparticiones" value="<%=susparticiones%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
		</birt:viewer>
	</body>
</html>