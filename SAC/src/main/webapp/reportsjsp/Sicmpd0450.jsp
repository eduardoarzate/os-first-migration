<%
/*###############################################################################
# Nombre del Programa :  SICMPDA450.jsp											#
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
	String banco2;
	String liquidacion;
	String esquema;
	String ttrnumero;
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
                    initDate = (String)session.getAttribute("initDate");
                    endDate = (String)session.getAttribute("endDate");
                    banco = (String)session.getAttribute("banco");
                    banco2 = (String)session.getAttribute("banco2");
                    if (banco.equals("None"))
                    {
                    	banco=null;
                    }
					liquidacion = (String)session.getAttribute("liquidacion");
					if (liquidacion.equals("None"))
                    {
                    	liquidacion=null;
                    }
					ttrnumero = (String)session.getAttribute("ttrnumero");
					if (ttrnumero.equals("None"))
                    {
                    	ttrnumero=null;
                    }
					esquema = (String)session.getAttribute("esquema");
					if (esquema.equals("None"))
                    {
                    	esquema=null;
                    }
					ejecuto= session.getAttribute("login").toString();
		%>
		<birt:viewer  id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/sicmpd0450.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 SICMPD0450" showToolBar="true" >
			<birt:param name="fecha_inicial" value="<%=initDate%>" />
			<birt:param name="fecha_final" value="<%=endDate%>" />
			<birt:param name="banco" value="<%=banco%>" />
			<birt:param name="banco2" value="<%=banco2%>" />
			<birt:param name="liquidacion" value="<%=liquidacion%>" />
			<birt:param name="esquema" value="<%=esquema%>" />
			<birt:param name="ttrnumero" value="<%=ttrnumero%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />	
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />		
		</birt:viewer>
	</body>
</html>