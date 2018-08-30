<%
/*###############################################################################
# Nombre del Programa :  SICMOR0340.jsp											#
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
#								MODIFICACIONES  #
# Nombre del Programa :  SICMOR0340.jsp                                   #
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS                                                    #
# Proyecto/Procliente :  B-54-2904-15                   Fecha:   25/08/2016     #
# Modificación        :  Mejorar Reportería SAC2                                #
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
        String bancoAdq;
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
                initDate = (String)session.getAttribute("txtfStartDate");
                endDate = (String)session.getAttribute("txtfEndDate");
                banco = session.getAttribute("banco").toString();
                        bancoAdq = session.getAttribute("bancoAdq").toString();
                ejecuto= session.getAttribute("login").toString();
        %>
        <birt:viewer  id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/sicmor0340.rptdesign\"%>"
                      showParameterPage="false" showTitle="true" pattern="frameset"
                      format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 SICMOR0340" showToolBar="true" >
            <birt:param name="initDate" value="<%=initDate%>" />
            <birt:param name="endDate" value="<%=endDate%>" />
            <birt:param name="bancoEmi" value="<%=banco%>" />
            <birt:param name="bancoAdq" value="<%=bancoAdq%>" />
            <birt:param name="ejecuto" value="<%=ejecuto%>" />
            <birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
            <birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
        </birt:viewer>
    </body>
</html>