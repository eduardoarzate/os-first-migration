<%
/*###############################################################################
# Nombre del Programa :  SICLIR0450.jsp											#
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
	String banco;
	String tipoDif;
	String noCuenta;
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
           ejecuto= session.getAttribute("login").toString();
           tipoDif=session.getAttribute("tipoDif").toString();
           noCuenta=session.getAttribute("noCuenta").toString();
           if(noCuenta.equals("")){
		%>
		
		<birt:viewer  id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/siclir0450.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 SICLIR0450" showToolBar="true" >
			<birt:param name="initDate" value="<%=initDate%>" />
			<birt:param name="endDate" value="<%=endDate%>" />
			<birt:param name="banco" value="<%=banco%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="tipoDiferencia" value="<%=tipoDif%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />			
		</birt:viewer>
		<%}else{ %>
		<birt:viewer id="birtViewer" reportDesign="/reports/siclir0450Detalle.rptdesign"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="SAC 2" showToolBar="true" >
			<birt:param name="initDate" value="<%=initDate%>" />
			<birt:param name="endDate" value="<%=endDate%>" />
			<birt:param name="banco" value="<%=banco%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="tipoDiferencia" value="<%=tipoDif%>" />
			<birt:param name="noCuenta" value="<%=noCuenta%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
		</birt:viewer>
		<%} %>
	</body>
</html>