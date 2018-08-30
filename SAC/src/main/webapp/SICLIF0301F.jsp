<%-- 
    Document   : SICLIF0301Header
    Created on : 01-feb-2012, 11:50:41
    Author     : home
################################################################################
# Nombre del Programa : SICLIF0301Header.jsp                                        #
# Autor               : Victor H. Montoya G.                                   #
# Compania            : eNova                                                  #
# Proyecto/Procliente : P-02-0408-10                         Fecha: {date} #
# Descripcion General : ...                                         #
# Programa Dependiente:                                                        #
# Programa Subsecuente:                                                        #
# Cond. de ejecucion  :                                                        #
# Dias de ejecucion   :                                      Horario: hh:mm    #
#                              MODIFICACIONES                                  #
#################################################################################
# Autor               :  Daniel Ramírez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-----------------------------------------------------------------------------  #
# Numero de Parametros:                                                        #
# Parametros Entrada  :                                      Formato:          #
# Parametros Salida   :                                      Formato:          #
##############################################################################*/
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>
<%@ page import="com.wellcom.io.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%
    ArrayList cbBancoAdq;
    HTML comboBox;
     /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
    ComboBoxGen myComboBox;
     /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
%>

<%
java.util.ArrayList<com.prosa.mx.pmr.dto.Reverso> rows = (java.util.ArrayList) request.getAttribute("items");
String msg = (String) request.getAttribute("msg");
com.prosa.mx.pmr.dto.Reverso rev = null;

String fecha = request.getParameter("txtfStartDate") == null ? "" : request.getParameter("txtfStartDate");
String cuenta = request.getParameter("cuenta") == null ? "" : request.getParameter("cuenta");
String ref = request.getParameter("ref") == null ? "" : request.getParameter("ref");
String auth = request.getParameter("auth") == null ? "" : request.getParameter("auth");
String comer = request.getParameter("comer") == null ? "" : request.getParameter("comer");
 /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
myComboBox = new ComboBoxGen();
 /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
    cbBancoAdq = myComboBox.getBancoAdq(session);

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>SAC 2</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css">
        <style type="text/css">
            thead{font-weight:bold}
        </style>
        <script type="text/javascript">
            var span = null;
            var showTextInitDate = false;
            var showTextEndDate = false;
            var showTipoMoneda = false;

            function valida()
            {
                try
                {
                    if (showTextInitDate)
                    {
                        span = document.getElementById("txtInitDate");
                        span.style.display = 'none';
                        showTextInitDate = false;
                    } else if (showTextEndDate)
                    {
                        span = document.getElementById('txtEndDate');
                        span.style.display = 'none';
                        showTextEndDate = false;
                    } else if (showTipoMoneda)
                    {
                        span = document.getElementById('txtTipoMoneda');
                        span.style.display = 'none';
                        showTipoMoneda = false;
                    }

                    if (document.frmTOCHeader.txtfStartDate.value == "" || document.frmTOCHeader.txtfStartDate.value == null)
                    {
                        span = document.getElementById("txtInitDate");
                        span.style.display = 'inline';
                        showTextInitDate = true;
                        return false;
                    } else if (document.frmTOCHeader.txtfEndDate.value == "" || document.frmTOCHeader.txtfEndDate.value == null)
                    {
                        span = document.getElementById('txtEndDate');
                        span.style.display = 'inline';
                        showTextEndDate = true;
                        return false;
                    } else if (document.frmTOCHeader.moneda.value == "None")
                    {
                        span = document.getElementById('txtTipoMoneda');
                        span.style.display = 'inline';
                        showTipoMoneda = true;
                        return false;
                    } else
                    {
                        return true;
                    }
                } catch (e)
                {

                }

            }
        </script>
    </head>

    <body>
        <div align="center">
            <iframe name="SICLIF0301" src="SICLIF0301Header.jsp" frameborder="0" width="100%" height="470px"/>
        </div>

        <iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="scripts/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
        </iframe>
    </body>
</html>
