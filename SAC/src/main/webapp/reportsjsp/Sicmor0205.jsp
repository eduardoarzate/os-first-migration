<%
/*###############################################################################
# Nombre del Programa :  SICMOR0205.jsp											#
# Autor               :  JOAQUIN MOJICA Q.                                      #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-08-299-04                 	   FECHA:15/10/2008     #
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
    String finDate;
    String susparticiones;
    String cuenta;
    String comercio;
    String ejecuto;
    String referencia;  
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
                    finDate = (String)session.getAttribute("txtfEndDate");
                    susparticiones = (String)session.getAttribute("susparticiones");
                    ejecuto= session.getAttribute("login").toString();
                    cuenta=session.getAttribute("cuenta").toString();
                    comercio=session.getAttribute("comercio").toString();    
                    referencia=session.getAttribute("referencia").toString();
		%>
		<birt:viewer  id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/sicmor0205.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 SICMOR0205" showToolBar="true" >
			<birt:param name="initDate" value="<%=initDate%>" />
			<!-- Solo para ester reporte endDate se llama finDate -->
			<birt:param name="endDate" value="<%=finDate%>" />
			<birt:param name="susparticiones" value="<%=susparticiones%>" />
			<birt:param name="cuenta" value="<%=cuenta%>" />
			<birt:param name="comercio" value="<%=comercio%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="referencia" value="<%=referencia%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
		</birt:viewer>
	</body>
</html>