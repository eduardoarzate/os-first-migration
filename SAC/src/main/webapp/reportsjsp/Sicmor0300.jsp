<%
/*###############################################################################
# Nombre del Programa :  SICMOR0100.jsp											#
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
	String Transaccion;
	String bancoAdq;
	String bancoEmi;
	String suparticion;
	String ejecuto;
	String fuente;
	String liquidacion;
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
					Transaccion =(String) session.getAttribute("transaccion");
					liquidacion =(String) session.getAttribute("liquidacion");
					
					fuente = (String)session.getAttribute("fuente");
					
					if (Transaccion == null || Transaccion == "")
						Transaccion = "0";
					if (fuente == null || fuente == "")
						fuente = "0";
					if (liquidacion == null || liquidacion == "")
						liquidacion = "0";
						
										liquidacion = ","+liquidacion;
					
					liquidacion = liquidacion.replace(",22",",1");
					liquidacion = liquidacion.replace(",32",",2");
					liquidacion = liquidacion.replace(",33",",3");
					liquidacion = liquidacion.replace(",26",",5");
					liquidacion = liquidacion.replace(",21",",6");
					liquidacion = liquidacion.replace(",27",",6");
					liquidacion = liquidacion.replace(",32",",11");
					liquidacion = liquidacion.replace(",25",",42");
					liquidacion = liquidacion.replace(",24",",36,37");
					
					liquidacion = liquidacion.substring(1,liquidacion.length());

					ejecuto= session.getAttribute("login").toString();										
		%>
		<birt:viewer id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/sicmor0300.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 SICMOR0300" showToolBar="true" >
			<birt:param name="initDate" value="<%=initDate%>" />
			<birt:param name="suparticion" value="<%=suparticion%>" />
			<birt:param name="adq" value="<%=bancoAdq%>" />
			<birt:param name="emi" value="<%=bancoEmi%>" />
			<birt:param name="liquidacion" value="<%=liquidacion%>" />
			<birt:param name="ttrnumero" value="<%=Transaccion%>" />
			<birt:param name="fuente" value="<%=fuente%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />			
		</birt:viewer>
	</body>
</html>