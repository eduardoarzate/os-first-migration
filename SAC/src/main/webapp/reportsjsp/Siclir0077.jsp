<%
/*###############################################################################
# Nombre del Programa :  SICLIR0077.jsp											#
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
#                                                                  Modificación #
# Nombre del Programa :  SICLIR0077.jsp                                         #
# Autor               :  Daniel Ramírez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  B-54-2904-15                 	   FECHA:25/08/2016     #
# Marca de Cambio     :  SAS-B-54-2904-15-DRT                	                #
# Descripcion General :	 Mejorar Reportería SAC2                                #
#                                                                               #
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
    String btnLstTOC;
    String initDate;
    String endDate;  
        String natCont;
        String ejecuto;
        String initDateAntHab;
        String endDateAntHab;
        String agrupacion0301=null;
        String agrDia;
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
                natCont = session.getAttribute("natCont").toString();
                ejecuto= session.getAttribute("login").toString();
                agrDia= session.getAttribute("agrDia").toString();
        initDateAntHab= initDate;
        endDateAntHab = endDate;
        String fechaI = initDate;
        String fechaF = endDate;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDateI = null;
        Date fechaDateF = null;
        try {
            fechaDateI = formato.parse(fechaI);
            fechaDateF = formato.parse(fechaF);
            Calendar calendarI = Calendar.getInstance();
            Calendar calendarF = Calendar.getInstance();
            calendarI.setTime(fechaDateI); // Configuramos la fecha que se recibe
            calendarI.add(Calendar.DAY_OF_YEAR, -1);
            initDateAntHab = formato.format(calendarI.getTime());
            calendarF.setTime(fechaDateF); // Configuramos la fecha que se recibe
            calendarF.add(Calendar.DAY_OF_YEAR, -1);  // numero de horas a añadir, o restar en caso de horas<0
            endDateAntHab = formato.format(calendarF.getTime());
        } catch (Exception ex) {
            System.out.println("Error formaeando fechas: "+ex);
        }
        
        
        		System.out.println("initDte:"+initDateAntHab);
         		System.out.println("initDteOp:"+initDate);
         		System.out.println("endDte:"+endDateAntHab);
         		System.out.println("endDteOp:"+endDate);
        
        %>
        <birt:viewer   id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/siclir0077.rptdesign\"%>"
                       showParameterPage="false" showTitle="true" pattern="frameset"
                       format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 SICLIR0077" showToolBar="true">
            <birt:param name="initDate" value="<%=initDateAntHab%>" />
            <birt:param name="endDate" value="<%=endDateAntHab%>" />
            <birt:param name="initDateOrig" value="<%=initDate%>" />
            <birt:param name="endDateOrig" value="<%=endDate%>" />
            <birt:param name="natContable" value="<%=natCont%>" />
            <birt:param name="ejecuto" value="<%=ejecuto%>" />
            <birt:param name="agrDia" value="<%=agrDia%>" />
            <birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
            <birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
        </birt:viewer>
    </body>
</html>