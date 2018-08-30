<%
/*###############################################################################
# Nombre del Programa :  Amxepapecnc003.jsp                                     #
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
    String numeroIndustria;
	String numeroComercio;
	String tipoTransaccion;
	String detalleReporte;
	String bancoAdq;
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
             numeroIndustria = (String)session.getAttribute("numeroIndustria");
			 numeroComercio = (String)session.getAttribute("numeroComercio");
			 tipoTransaccion = (String)session.getAttribute("tipoTransaccion");
			 detalleReporte = (String)session.getAttribute("tipoReporte");
			 bancoAdq = (String)session.getAttribute("bancoAdq");
				ejecuto = session.getAttribute("login").toString();
		%>
		
		<birt:viewer id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/Amexepapecon003.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="Reporte Amex EPAPE Conciliación" showToolBar="true">
			
			<birt:param name="initDate" value="<%=fechaInicial%>" />
			<birt:param name="endDate" value="<%=fehaFinal%>" />
			<birt:param name="bancoAdq" value="<%=bancoAdq%>" />
			<birt:param name="numeroIndustria" value="<%=numeroIndustria%>" />
			<birt:param name="numeroAffiliation" value="<%=numeroComercio%>" />
			<birt:param name="tipoTransaccion" value="<%=tipoTransaccion%>" />
			<birt:param name="detalleReporte" value="<%=detalleReporte%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
			
		</birt:viewer>
	
	</body>
</html>