<%
/*###############################################################################
# Nombre del Programa :  Siclir0300.jsp                                         #
# Autor               :  LUIS EDUARDO RAMIREZ CASTILLO                          #
# Compania            :  SAS	 S.A. DE C.V.                             		#
# Proyecto/Procliente :  B-54-2904-15                 	   FECHA:01/10/2015     #
# Descripcion General :										                    #
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :						                                    #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :														    #
#################################################################################
#								MODIFICACIONES                                  #
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  B-54-2904-15                 	   FECHA: 25/08/2016    #
# Descripcion General :	 Mejorar Reportería SAC2                              	#
#-----------------------------------------------------------------------------  #
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<%@ taglib uri="/birt.tld" prefix="birt"%>
<%@page import="com.wellcom.io.HTML"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>

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
    String fechaFinal;
    String adquiriente;
    String tipoTransac;
    String entrada;
    String salida;
    String ejecuto;
    String initDateAntHab;
    String endDateAntHab;
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
	    fechaFinal = (String)session.getAttribute("endDate");
            adquiriente = (String)session.getAttribute("bancoAdq");
	    tipoTransac = (String)session.getAttribute("tipoTransac");
	    entrada = (String)session.getAttribute("entrada");
            salida = (String)session.getAttribute("salida");
            ejecuto = session.getAttribute("login").toString();
            
            initDateAntHab= fechaInicial;
            endDateAntHab = fechaFinal;
            
            
        String fechaI = fechaInicial;
        String fechaF = fechaFinal;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDateI = null;
        Date fechaDateF = null;
        try {
            fechaDateI = formato.parse(fechaI);
            fechaDateF = formato.parse(fechaF);
            Calendar calendarI = Calendar.getInstance();
            Calendar calendarF = Calendar.getInstance();
            calendarI.setTime(fechaDateI); // Configuramos la fecha que se recibe
            calendarI.add(Calendar.HOUR, -24);
            initDateAntHab = formato.format(calendarI.getTime());
            calendarF.setTime(fechaDateF); // Configuramos la fecha que se recibe
            calendarF.add(Calendar.HOUR, - 24);  // numero de horas a añadir, o restar en caso de horas<0
            endDateAntHab = formato.format(calendarF.getTime());

        } catch (Exception ex) {
            System.out.println("Error formaeando fechas: "+ex);
        }




		%>
		
		<birt:viewer id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/siclir0300.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="Reporte Conciliacion" showToolBar="true">
			
			<birt:param name="initDate" value="<%=fechaInicial%>" />
			<birt:param name="endDate" value="<%=fechaFinal%>" />
			<birt:param name="bancoAdq" value="<%=adquiriente%>" />
			<birt:param name="ttr_numero" value="<%=tipoTransac%>" />
			<birt:param name="fileIn" value="<%=entrada%>" />
			<birt:param name="fileOut" value="<%=salida%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			
                        <birt:param name="initDateAntHab" value="<%=initDateAntHab%>" />
			<birt:param name="endDateAntHab" value="<%=endDateAntHab%>" />
     		<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />

			
		</birt:viewer>
	
	</body>
</html>