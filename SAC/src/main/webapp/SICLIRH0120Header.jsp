<%
/*###############################################################################
# Nombre del Programa :  SICLIRH0120Header.jsp                                  #
# Autor               :  JESUS PARRA MARTINEZ                                   #
# Compania            :  Soporte y Asesoria en Sistemas S.A. DE C.V.            #
# Proyecto/Procliente :  P-06-0527-11                  	   FECHA:05/08/2014     #
# Descripcion General :										                    #
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :						                                    #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :														    #
#-----------------------------------------------------------------------------  #  
#								MODIFICACIONES                                  #  
# Autor               :  Laura Maleni Ramirez Vazquez                           #  
# Compania            :  SAS				                                    #  
# Proyecto/Procliente :  P-21-0013-16                Fecha: 19/02/2016          #  
# Modificaci�n        :  Modificacion de hub de Pagos para Mifel                # 
#------------------------------------------------------------------------------#
# Autor               :  Daniel Ramirez Torres                                 #
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
<%@ page import="java.io.IOException"%>
<%@page import="com.wellcom.prosa.sacii.ComboBox"%>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%
        ArrayList cbInterRedValues;
        HTML comboBox;
         /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
        ComboBoxGen myComboBox;
%>
<%
    if(!ga.AccessGranted(session, "grantAccess"))
    {
        response.sendRedirect("login.jsp");
    }
        myComboBox = new ComboBoxGen();
         /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */  
        cbInterRedValues  = myComboBox.getBancoAdqHub(session);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>SAC 2</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css">

    </head>
    <script type="text/javascript">
        var span = null;
        var showTextInitDate = false;
        var showTextEndDate = false;
        var showTextInterred = false;
        var showTextDivision = false;
        var showTextbancoEmi = false;
        var showTextTipoTransac = false;

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
                } else if (showTextInterred)
                {
                    span = document.getElementById('txtInterred');
                    span.style.display = 'none';
                    showTextInterred = false;
                } else if (showTextDivision)
                {
                    span = document.getElementById('txtDivision');
                    span.style.display = 'none';
                    showTextDivision = false;
                } else if (showTextTipoTransac)
                {
                    span = document.getElementById('txtTipoTransac');
                    span.style.display = 'none';
                    showTextTipoTransac = false;
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
                } else if (document.frmTOCHeader.interred.value == "None")
                {
                    span = document.getElementById('txtInterred');
                    span.style.display = 'inline';
                    showTextInterred = true;
                    return false;
                } else if (document.frmTOCHeader.division.value == "None")
                {
                    span = document.getElementById('txtDivision');
                    span.style.display = 'inline';
                    showTextDivision = true;
                    return false;
                } else if (document.frmTOCHeader.tipoTransac.value == "None")
                {
                    span = document.getElementById('txtTipoTransac');
                    span.style.display = 'inline';
                    showTextTipoTransac = true;
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
    <body>
        <div align="center">
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificaci�n -->
            <form action="ControllerServletHub?action=SICLIRH0120Main" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificaci�n -->
                <table width="100%" border="0" cellspacing="0" id="tabla">
                    <tr>
                        <th id="tituloTab" width="100%" colspan="5" align="left" ><font color="#000000">SICLIRH0120 - Liquidaci&oacute;n HUB DE PAGOS <br></font></th>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Fecha Inicio:</strong></td>
                        <td align="left">
                            <input name="txtfStartDate" type="text" id="txtfStartDate" size="15" readonly maxlength="15" value=<%=session.getAttribute("fechaHoy")%>>
                            <a href="javascript:void(0)" onclick="if (self.gfPop)
                                        gfPop.fPopCalendar(document.frmTOCHeader.txtfStartDate);
                                    return false;" hidefocus>
                                <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg" border="0" alt="">
                            </a><br/>
                            <span id = "txtInitDate" class="ocultar">Selecciona una fecha</span>
                        </td>
                        <td align="left"><strong>Fecha Fin:</strong></td>
                        <td align="left">
                            <input name="txtfEndDate" type="text" id="txtfEndDate" size="15" readonly maxlength="15" value=<%=session.getAttribute("fechaHoy")%>>
                            <a href="javascript:void(0)" onclick="if (self.gfPop)
                                        gfPop.fPopCalendar(document.frmTOCHeader.txtfEndDate);
                                    return false;" hidefocus>
                                <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg" border="0" alt="">
                            </a><br/>
                            <span id = "txtEndDate" class="ocultar">Selecciona una fecha</span>
                        </td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Banco:</strong></td>
                        <td align="left">
                            <% 
                                    comboBox = new HTML();
                            out.println( "" + comboBox.getListBox( "interred", cbInterRedValues, "onchange", "javascript:sendData('interred','division','comboBoxDivision');", "Selecciona un Banco" ));
                            %><br/>
                            <span id = "txtInterred" class="ocultar">Elije una Opci�n</span>
                        </td>
                        <td align="left"><strong>Divisi&oacute;n:</strong></td>
                        <td align="left" id="comboBoxDivision">
                            <select multiple="multiple">
                                <option selected="selected" value="None">Selecciona una Divisi&oacute;n</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Tipo Transacci&oacute;n:</strong></td>
                        <td>
                            <select name="tipoTransac" id="tipoTransac" multiple="multiple">
                                <option value="None" selected="selected">Selecciona una Transacci�n</option>
                                <option value="E">Efectivo</option>
                                <option value="'C','D'">Tarjeta</option>
                                <!--<option value="-1">Selecciona las transacciones</option>-->
                            </select>
                            <br>
                            <span id = "txtTipoTransac" class="ocultar">Elije una Opci�n</span>
                            <br>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4" align="left">
                            <input name="btnLstTOC" type="submit" id="btnLstTOC" value="Mostrar Reporte" onclick="javascript:return valida(this.form);">
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>
                    </tr>
                </table>
            </form>
        </div>
        <iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="scripts/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
        </iframe>
    </body>
</html>