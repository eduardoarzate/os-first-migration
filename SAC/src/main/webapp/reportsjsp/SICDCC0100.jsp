<%
/*###############################################################################
# Nombre del Programa :  SICDCC0100.jsp		                                #
# Autor               :  Gerardo G. Burguete                                    #
# Compania            :  Axia Consultores, S.A. de C.V.                         #
# Proyecto/Procliente :  P-02-0496-10                 	   FECHA:11/12/2012     #
# Descripcion General :                                                         #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :						                #
# Dias de ejecucion   :								#
#################################################################################
#								MODIFICACIONES  #
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
    String ejecuto;
    String fuente;
    String ttr;
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
            endDate  = (String)session.getAttribute("txtfEndDate");
            banco    = (String)session.getAttribute("banco");
            fuente   = (String)session.getAttribute("fuente");
            ttr      = (String)session.getAttribute("ttr");

            ejecuto= session.getAttribute("login").toString();
		%>
		<birt:viewer id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/SICDCC0100.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 SICDCC0100" showToolBar="true">
			<birt:param name="initDate" value="<%=initDate%>" />
			<birt:param name="endDate" value="<%=endDate%>" />
			<birt:param name="banco" value="<%=banco%>" />
			<birt:param name="fuente" value="<%=fuente%>" />
			<birt:param name="ttr" value="<%=ttr%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
		</birt:viewer>
	</body>
</html>