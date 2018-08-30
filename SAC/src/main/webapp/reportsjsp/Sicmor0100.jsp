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
    String endDate;
    String susparticiones;
	String tipoTrans;
	String bancoAdq;
	String ejecuto;
	String archivo;
	String afiliacion;
	String agrNatContable;
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
					tipoTrans =(String) session.getAttribute("nTransac");
					archivo = (String)session.getAttribute("archivoAdq");
					afiliacion = (String)session.getAttribute("afiliacion");
					ejecuto= session.getAttribute("login").toString();
					agrNatContable=(String)session.getAttribute("agrNatContable");
					String report=getServletContext().getInitParameter("UBICACION_REPORTES")+"/sicmor0100.rptdesign";
					if(agrNatContable=="true")
						report=getServletContext().getInitParameter("UBICACION_REPORTES")+"/sicmor0100B.rptdesign";
		%>
		<birt:viewer   id="birtViewer" reportDesign="<%=report%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 SICMOR0100" showToolBar="true" >
			<birt:param name="initDate" value="<%=initDate%>" />
			<birt:param name="endDate" value="<%=endDate%>" />
			<birt:param name="susparticiones" value="<%=susparticiones%>" />
			<birt:param name="bancoAdq" value="<%=bancoAdq%>" />
			<birt:param name="tipoTrans" value="<%=tipoTrans%>" />
			<birt:param name="archivo" value="<%=archivo%>" />
			<birt:param name="afiliacion" value="<%=afiliacion%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="agrNatContable" value="<%=agrNatContable%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
		</birt:viewer>
	</body>
</html>