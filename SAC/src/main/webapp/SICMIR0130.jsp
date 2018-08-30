<%
/*###############################################################################
# Nombre del Programa :  SICMIR0130.jsp                MODIFICACIONES      #
# Autor               :  Daniel Ramirez Torres /Llao                            #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  B-54-2904-15                 	   FECHA: 25/08/2016    #
# Descripcion General :								#
#                                                                               #
#------------------------------------------------------------------------------#
# Autor               :  Daniel Ramírez Torres                                 #
# Compania            :  SAS S.A. DE C.V.                                      #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017        #
# Modificacion        :  Mejora Conexiones  SAC2                               #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                  #
#------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<%@ page import="com.wellcom.io.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>
<%@page import="java.io.IOException"%>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%
    if(!ga.AccessGranted(session, "grantAccess"))
    {
        response.sendRedirect("login.jsp");
    }
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>SAC 2</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css">
    </head>
    <script type="text/javascript">

    </script>
    <body>
        <div align="center">
            <!--  <form method="post" enctype="multipart/form-data" action="ReloadServletServlet?action=cargaArchivoMain">!-->
            <!--<form method="post" enctype="multipart/form-data" action="ReloadServlet?action=cargaArchivoMain">!-->
            <!--  <form method="post" id="myform" action="javascript: mandarForm()">!-->
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación -->
            <form method="post" id="myform" enctype="multipart/form-data" action="ReloadServlet?action=loadEnt" target="_blank">
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación -->
                <!-- <form enctype="multipart/form-data" action="ReloadServlet?action=loadEnt" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">!-->
                <table width="100%" border="0" cellspacing="0" id="tabla">
                    <tr>
                        <th id="tituloTab" width="100%" colspan="7" align="left" ><font color="#000000">SICMIR0130 - Reporte Lectura T140
                            </font></th>
                    </tr>
                    <tr>
                        <td align="right">Selecione Archivo: </td>
                        <td>

                            <input type="file" name="file" id="fil" /><br /><br />
                        </td>
                    </tr>
                    <tr>
                        <td><input name="btnLstTOC" type="submit" id="btnLstTOC" value="Cargar Información"></td>

                    </tr>

                </table>
            </form>
        </div>
        <iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="scripts/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
        </iframe>
    </body>
</html>
