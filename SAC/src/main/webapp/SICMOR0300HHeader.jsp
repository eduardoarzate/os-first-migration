<%/*
#------------------------------------------------------------------------------#
# Autor               :  Daniel Ramirez Torres                                 #
# Compania            :  SAS S.A. DE C.V.                                      #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017        #
# Modificacion        :  Mejora Conexiones  SAC2                               #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                  #
#------------------------------------------------------------------------------#
*/%>
<%@ page import="com.wellcom.io.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%ArrayList cbAdquirente;
        ArrayList cbEmisor;
        ArrayList cbFuente;
        ArrayList cbTransaccion;
        ArrayList cbLiquidacion;
        HTML comboBox;
        /*Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación*/
        ComboBoxGen myComboBox;
        /*Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación*/
%>
<%
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
   }
 
 	
        String ruta = "http://10.255.11.30:8080/reportesPMTH/acceso.jsp?nombreReporte=sicmor0300&uid=b014ascr";
        response.sendRedirect(ruta);

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <link href="css/styles.css" rel="stylesheet" type="text/css">
        <title>SAC 2</title>

    </head>


</html>