<%
/*###############################################################################
# Nombre del Programa :  SICMOR0810.jsp											#
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
    String txtfStartDate;
    String txtfEndDate;  
	String entidad;
	String division;
	String determinante;
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
                    txtfStartDate = (String)session.getAttribute("txtfStartDate");
                    txtfEndDate = (String)session.getAttribute("txtfEndDate");
                    entidad = (String)session.getAttribute("entidad");
					division = (String)session.getAttribute("division");
					determinante = (String)session.getAttribute("determinante");
					ejecuto= session.getAttribute("login").toString();
					
					/*
					System.out.println("Fecha1"+txtfStartDate);
					System.out.println("Fecha2"+txtfEndDate);
					System.out.println("Entidad"+entidad);
					System.out.println("Division"+division);
					System.out.println("Determinante"+determinante);
					*/
		%>
		<birt:viewer  id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/sicmor0810.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 SICMOR0810" showToolBar="true" >
			<birt:param name="fecha_inicial" value="<%=txtfStartDate%>" />
			<birt:param name="fecha_final" value="<%=txtfEndDate%>" />
			<birt:param name="entidad" value="<%=entidad%>" />
			<birt:param name="division" value="<%=division%>" />
			<birt:param name="determinante" value="<%=determinante%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />			
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
		</birt:viewer>
	</body>
</html>