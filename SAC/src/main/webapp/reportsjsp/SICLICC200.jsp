<%
/*
################################################################################
# Nombre del Programa : SICLICC200.jsp                                         #
# Autor               : GERMAN GONZALEZ E.                                     #
# Compania            : WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente : P-06-2233-13                          FECHA:28/01/2014 #
# Descripcion General :	Reportes Corresponsal                                  #
# Modificación        : N/A                                                    #
# Programa Dependiente: N/A                                                    #
# Programa Subsecuente: N/A                                                    #
# Cond. de ejecucion  : N/A                                                    #
# Dias de ejecucion   : N/A                                                    #
################################################################################
#                                 MODIFICACIONES                               #
# Autor               : N/A                                                    #
# Compania            : N/A                                                    #
# Proyecto/Procliente : N/A                                   FECHA:DD/MM/AAAA #
# Descripcion General :	N/A                                                    #
# Modificación        : N/A                                                    #
#----------------------------------------------------------------------------- #
# Numero de Parametros: 0                                                      #
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
  String bancoAdq;
  String bancoEmi;
  String ejecuto;
  String fuente;
  String natCon;
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
      bancoAdq    = (String)session.getAttribute("bancoAdq");
      bancoEmi    = (String)session.getAttribute("bancoEmi");
      natCon      = (String)session.getAttribute("natCon");
      role        = session.getAttribute("role").toString();
      fuente      = (String)session.getAttribute("fuente");
      ejecuto     = session.getAttribute("login").toString();
    %>
    <birt:viewer
      id                = "birtViewer"
      reportDesign      = "<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/SICLICC200.rptdesign\"%>"
      showParameterPage = "false"
      showTitle         = "true"
      pattern           = "frameset"
      format            = "HTML"
      isHostPage        = "true"
      title             = "SISTEMA ADQUIRENTE CARNET SAC 2 SICLICC200"
      showToolBar       = "true"
    >
      <birt:param name="initDate"    value="<%=initDate%>" />
      <birt:param name="endDate"     value="<%=endDate%>" />
      <birt:param name="adq"         value="<%=bancoAdq%>" />
      <birt:param name="emi"         value="<%=bancoEmi%>" />
      <birt:param name="fuente"      value="<%=fuente%>" />
      <birt:param name="natCon"      value="<%=natCon%>" />
      <birt:param name="ejecuto"     value="<%=ejecuto%>" />
      <birt:param name="role"        value="<%=role%>" />
      <birt:param name="srvImgLcl"   value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
      <birt:param name="srvImgRmt"   value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
    </birt:viewer>
  </body>
</html>