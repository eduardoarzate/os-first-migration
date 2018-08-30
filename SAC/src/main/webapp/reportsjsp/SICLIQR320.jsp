<%
/*
################################################################################
# Nombre del Programa : SICLIQR320.jsp                                         #
# Autor               : Ascencion Hernandez Huerta                             #
# Compania            : Axia, Consultores, S.A. DE C.V.                        #
# Proyecto/Procliente : P-53-2933-14                           Fecha:17/11/2015#
# Descripcion General : Re-calculo de compensacion y administracion de umbrales#
# Programa Dependiente: N/A                                                    #
# Programa Subsecuente: N/A                                                    #
# Cond. de ejecucion  : N/A                                                    #
# Dias de ejecucion   : N/A                                                    #
################################################################################
#                                MODIFICACIONES                                #
# Autor               : N/A                                                    #
# Compania            : N/A                                                    #
# Proyecto/Procliente : N/A                                    Fecha:dd/mm/yyyy#
# Descripcion General : N/A                                                    #
# Modificación        : N/A                                                    #
# Marca del Cambio    : N/A                                                    #
#------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                      #
################################################################################
*/
%>
<%@ taglib uri="/birt.tld" prefix="birt"%>
<%@page import="com.wellcom.io.HTML"%>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%
  if(!ga.AccessGranted(session, "grantAccess"))
    response.sendRedirect("login.jsp");
%>
<%!
  HTML   html;
  String initDate;
  String endDate;
  String tipoLiq;
  String initDateHabAnt;
  String endDateHabAnt;
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
      initDate       = (String)session.getAttribute("txtfStartDate");
      endDate        = (String)session.getAttribute("txtfEndDate");
      tipoLiq        = (String)session.getAttribute("tipoLiq");
      initDateHabAnt = (String)session.getAttribute("initDateHabAnt");
      endDateHabAnt  = (String)session.getAttribute("endDateHabAnt");
      ejecuto        = session.getAttribute("login").toString();
    %>
    <birt:viewer
      id                = "birtViewer"
      reportDesign      = "<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/SICLIQR320.rptdesign\"%>"
      showParameterPage = "false"
      showTitle         = "true"
      pattern           = "frameset"
      format            = "HTML"
      isHostPage        = "true"
      title             = "SISTEMA ADQUIRENTE CARNET SAC 2 SICLIQR320"
      showToolBar       = "true"
    >
      <birt:param name = "initDate"       value="<%=initDate%>" />
      <birt:param name = "endDate"        value="<%=endDate%>" />
      <birt:param name = "initDateHabAnt" value="<%=initDateHabAnt%>" />
      <birt:param name = "endDateHabAnt"  value="<%=endDateHabAnt%>" />
      <birt:param name = "tipoLiq"        value="<%=tipoLiq%>" />
      <birt:param name = "ejecuto"        value="<%=ejecuto%>" />
      <birt:param name = "srvImgLcl"      value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
      <birt:param name = "srvImgRmt"      value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
    </birt:viewer>
  </body>
</html>