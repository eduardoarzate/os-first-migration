<%
/*###############################################################################
# Nombre del Programa :  SICMOR0310.jsp											#
# Autor               :  JOSE ANDRES CASTILLO MORENO                            #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-08-299-04                 	   FECHA:05/09/2010     #
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
    String susparticiones;
	String bancoAdq;
	String bancoEmi;
	String tipoTrans;
	String tipoLiquidacion;
	String comercio;
	String fuente;
	String detalle;
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
                    susparticiones = (String)session.getAttribute("susparticiones");
                    bancoAdq = (String)session.getAttribute("bancoAdq");
                    bancoEmi = (String)session.getAttribute("bancoEmi");
                    if (bancoEmi.equals("None"))
                    	bancoEmi ="0";
                    tipoTrans = (String)session.getAttribute("tipoTransac");
                    if (tipoTrans.equals("None"))
                    	tipoTrans = "0";
                    fuente = (String)session.getAttribute("fuente");
                    if (fuente.equals("None"))
                        fuente = null ;
                    comercio = (String)session.getAttribute("comercio");
                    	detalle = "no";

                    tipoLiquidacion = (String)session.getAttribute("tipoLiquidacion");
                    if (tipoLiquidacion.equals("None"))
                    	tipoLiquidacion = "0";
                    tipoLiquidacion = ","+tipoLiquidacion;
                    
                    tipoLiquidacion = tipoLiquidacion.replace(",22",",1");
                    tipoLiquidacion = tipoLiquidacion.replace(",32",",2");
                    tipoLiquidacion = tipoLiquidacion.replace(",33",",3");
                    tipoLiquidacion = tipoLiquidacion.replace(",26",",5");
                    
                    tipoLiquidacion = tipoLiquidacion.substring(1,tipoLiquidacion.length());
                                     
                    ejecuto= session.getAttribute("login").toString();              
		%>
		<birt:viewer  id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/sicmor0310.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 SICMOR0310" showToolBar="true" 
			showNavigationBar="true">
			<birt:param name="initDate" value="<%=initDate%>" />
			<birt:param name="endDate" value="<%=endDate%>" />
			<birt:param name="susparticiones" value="<%=susparticiones%>" />
			<birt:param name="bancoAdq" value="<%=bancoAdq%>" />
			<birt:param name="bancoEmi" value="<%=bancoEmi%>" />
			<birt:param name="tipoTrans" value="<%=tipoTrans%>" />
			<birt:param name="comercio" value="<%=comercio%>" />			
			<birt:param name="fuente" value="<%=fuente%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
		</birt:viewer>
</body>
</html>