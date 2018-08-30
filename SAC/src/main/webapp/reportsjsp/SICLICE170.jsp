<%
/*
################################################################################
# Nombre              : SICLICE170.jsp                                         #
# Autor               : Ascencion Hernandez Huerta                             #
# Compania            : Axia Consultores, S.A. de C.V.                         #
# Proyecto/Procliente : P-60-2646-14                          FECHA:03/11/2015 #
# Descripcion General : Incorporacion d Consubanco Corresponsales con Chedraui #
# Modificacion        : Reporte Consolidado Corresponsales Emisor              #
# Programa Dependiente: N/A                                                    #
# Programa Subsecuente: N/A                                                    #
# Cond. de ejecucion  : Acceder al sistema                                     #
# Dias de ejecucion   : A Peticion del web, se pueden ejecutar n instancias    #
#------------------------------------------------------------------------------#
#                                MODIFICACIONES                                #
#------------------------------------------------------------------------------#
# Autor               : N/A                                                    #
# Compania            : N/A                                                    #
# Proyecto/Procliente : N/A                                 Fecha: 00/00/0000  #
# Descripcion General : N/A                                                    #
# Modificacion        : N/A                                                    #
# Marca del Cambio    : N/A                                                    #
#------------------------------------------------------------------------------#
# Numero de Parametros: 1                                                      #
# Parametros Entrada  : Order Date                         Formato:aaaammdd    #
# Parametros Salida   : N/A                                Formato:N/A         #
# Archivo    Entrada  : N/A                                Formato:N/A         #
# Arvhivo    Salida   : N/A                                Formato:N/A         #
################################################################################
*/
%>
<%@ taglib uri="/birt.tld" prefix="birt" %>
<%@ page import="com.wellcom.io.HTML" %>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%
    if(!ga.AccessGranted(session, "grantAccess"))
        response.sendRedirect("login.jsp");
%>
<%!
  HTML   html;
  String btnLstTOC;
  String initDate;
  String endDate;
  String bancoEmi;
  String ejecuto;
  String role;
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
      initDate    = (String)session.getAttribute("txtfStartDate");
      endDate     = (String)session.getAttribute("txtfEndDate");
      bancoEmi    = (String)session.getAttribute("bancoEmi");
      role        = session.getAttribute("role").toString();
      ejecuto     = session.getAttribute("login").toString();
   %>
    <birt:viewer
      id                = "birtViewer"
      reportDesign      = "<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/SICLICE170.rptdesign\"%>"
      showParameterPage = "false"
      showTitle         = "true"
      pattern           = "frameset"
      format            = "HTML"
      isHostPage        = "true"
      title             = "SISTEMA ADQUIRENTE CARNET SAC 2 SICLICE170"
      showToolBar       = "true"
    >
      <birt:param name="initDate"    value="<%=initDate%>" />
      <birt:param name="endDate"     value="<%=endDate%>" />
      <birt:param name="emi"         value="<%=bancoEmi%>" />
      <birt:param name="ejecuto"     value="<%=ejecuto%>" />
      <birt:param name="role"        value="<%=role%>" />
      <birt:param name="srvImgLcl"   value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
      <birt:param name="srvImgRmt"   value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
    </birt:viewer>
  </body>
</html>