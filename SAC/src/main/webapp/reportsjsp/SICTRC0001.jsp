<%
/*###############################################################################
# Nombre del Programa :  SICTRC0001.jsp						#
# Autor               :  Juan Rodriguez Gonzalez.                               #
# Compania            :  IDSYS S.A. DE C.V.                                     #
# Proyecto/Procliente :  P-22-0136-14                      FECHA:10/11/2014     #
# Descripcion General :								#
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :								#
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
	String fiid;
	String bancoAdq;
	String ejecuto;
        String Cuenta_O;
        String Cuenta_Des;
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
                    fiid     = (String)session.getAttribute("numFiid");
                    ejecuto  = session.getAttribute("login").toString();
                    Cuenta_O = (String)session.getAttribute("txtfCtaOri");
                     if (Cuenta_O.equals(""))
                    	Cuenta_O = "0";
                    Cuenta_Des = (String)session.getAttribute("txtfCtaDest");
                     if (Cuenta_Des.equals(""))
                    	Cuenta_Des = "0";
                   %>
                     <birt:viewer id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/SICTRC0001.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 SICTRC0001" showToolBar="true">
			<birt:param name="ejecuto"   value="<%=ejecuto%>" />
                        <birt:param name="initDate"  value="<%=initDate%>" />
			<birt:param name="endDate"   value="<%=endDate%>" />
			<birt:param name="fiid"      value="<%=fiid%>" />
			<birt:param name="Cuenta_O"  value="<%=Cuenta_O%>" />
                        <birt:param name="Cuenta_Des" value="<%=Cuenta_Des%>" />
                        <birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
		</birt:viewer>
	</body>
</html>