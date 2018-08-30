<%
/*###############################################################################
# Nombre del Programa :  SICMOR0305.jsp											#
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
    String endDate;  
	String bancoAdq;
	String prefijo;
	String bancoEmi;
	String tipoTrans;
	String tipoLiquidacion;
	String natcon;
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
                    bancoAdq = (String)session.getAttribute("bancoAdq");
                    bancoEmi = (String)session.getAttribute("bancoEmi");
                    natcon = (String)session.getAttribute("natcon");
                    prefijo = (String)session.getAttribute("prefijo");
                    if (prefijo.equals(""))
                    	prefijo = "0";
                    tipoTrans = (String)session.getAttribute("tipoTransac");
                    ejecuto= session.getAttribute("login").toString();
                    
                    tipoLiquidacion = (String)session.getAttribute("tipoLiquidacion");
                    tipoLiquidacion = ","+tipoLiquidacion;
                    
                    tipoLiquidacion = tipoLiquidacion.replace(",22",",1");
                    tipoLiquidacion = tipoLiquidacion.replace(",32",",2");
                    tipoLiquidacion = tipoLiquidacion.replace(",33",",3");
                    tipoLiquidacion = tipoLiquidacion.replace(",26",",5");
					tipoLiquidacion = tipoLiquidacion.substring(1,tipoLiquidacion.length());
                                  
		%>
		<birt:viewer  id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/sicmor0305H.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 SICMOR0305H" showToolBar="true" >
			<birt:param name="initDate" value="<%=initDate%>" />
			<birt:param name="endDate" value="<%=endDate%>" />
			<birt:param name="bancoAdq" value="<%=bancoAdq%>" />
			<birt:param name="bancoEmi" value="<%=bancoEmi%>" />
			<birt:param name="tipoTrans" value="<%=tipoTrans%>" />
			<birt:param name="tipoLiquidacion" value="<%=tipoLiquidacion%>" />
			<birt:param name="prefijo" value="<%=prefijo%>" />
			<birt:param name="natcon" value="<%=natcon%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
		</birt:viewer>
</body>
</html>