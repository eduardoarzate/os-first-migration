<%
/*###############################################################################
# Nombre del Programa :  Amxepapeadj002.jsp                                     #
# Autor               :  Daniel Ramírez Torres		                            #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  P-20-0115-20          FECHA: 28/07/2017                #
# Descripcion General :	Incorporación de American Express (AMEX) a PROSA        #
#                       para transacciones POS                                  #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :						                                    #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :														    #
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

    String fechaInicial;
    String fehaFinal;
	String bancoAdq;
    String numeroIndustria;
	String numeroComercio;
	String tipoEpape;
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
			fechaInicial = (String)session.getAttribute("initDate");
			   fehaFinal = (String)session.getAttribute("endDate");
			   bancoAdq = (String)session.getAttribute("bancoAdq");
             numeroIndustria = (String)session.getAttribute("numeroIndustria");
			 numeroComercio = (String)session.getAttribute("numeroComercio");
				ejecuto = session.getAttribute("login").toString();
		%>
		
		<birt:viewer id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/Amexepapeadj002.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="Reporte Amex EPAPE Ajustes" showToolBar="true">
			
			<birt:param name="initDate" value="<%=fechaInicial%>" />
			<birt:param name="endDate" value="<%=fehaFinal%>" />
			<birt:param name="bancoAdq" value="<%=bancoAdq%>" />
			<birt:param name="numeroIndustria" value="<%=numeroIndustria%>" />
			<birt:param name="numeroAffiliation" value="<%=numeroComercio%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
			
		</birt:viewer>
	
	</body>
</html>