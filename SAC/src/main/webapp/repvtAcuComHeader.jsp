
<%
/*###############################################################################
# Nombre del Programa :  repvtAcuComHeader.jsp  									#
# Autor               :  Laura Maleni Ramirez Vazquez                           #
# Compania            :  SAS S.A. DE C.V.                                  		#
# Proyecto/Procliente :  Z-02-2675-12                 	   FECHA:31/05/2016     #
# Descripcion General :															#
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :															#
#                                                                               #
#                                                                               #
# Dias de ejecucion   :															#
#------------------------------------------------------------------------------#
#                                                               MODIFICACIONES #
# Autor               :  Daniel Ramirez Torres                                 #
# Compania            :  SAS S.A. DE C.V.                                      #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017        #
# Modificacion        :  Mejora Conexiones  SAC2                               #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                  #
#------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<%@ page import="com.wellcom.io.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.wellcom.prosa.sacii.*"%>

<jsp:useBean id="ga" scope="session"
             class="com.wellcom.prosa.sacii.GrantAccess" />

<%! ArrayList cbIntValues;
        ArrayList cbDisValues;
        ArrayList cbTelValues;
        HTML comboBox;
        HTML checkBox;
         /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
        ComboBoxGen myComboBox;%>

<%
        if (!ga.AccessGranted(session, "grantAccess")) {
                response.sendRedirect("login.jsp");
        }

        myComboBox = new ComboBoxGen();
         /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */  
        cbIntValues = myComboBox.getBancoAdqTelefonica(session);
        cbDisValues = myComboBox.getDistribuidor(session);
        cbTelValues = myComboBox.getTelefonica(session);
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
        var showTtxtBanco = false;
        var showtxtTipoPago = false;
        var showtxtDistribuidor = false;
        var showtxtTelefonia = false;

        function valida() {
            try {
                if (showTextInitDate) {
                    span = document.getElementById("txtInitDate");
                    span.style.display = 'none';
                    showTextInitDate = false;
                } else if (showTextEndDate) {
                    span = document.getElementById('txtEndDate');
                    span.style.display = 'none';
                    showTextEndDate = false;
                } else if (showTtxtBanco) {
                    span = document.getElementById('txtBanco');
                    span.style.display = 'none';
                    showTtxtBanco = false;
                } else if (showtxtTipoPago) {
                    span = document.getElementById('txtTipoPago');
                    span.style.display = 'none';
                    showtxtTipoPago = false;
                } else if (showtxtDistribuidor) {
                    span = document.getElementById('txtDistribuidor');
                    span.style.display = 'none';
                    showtxtDistribuidor = false;
                } else if (showtxtTelefonia) {
                    span = document.getElementById('txtTelefonia');
                    span.style.display = 'none';
                    showtxtTelefonia = false;
                }

                if (document.frmTOCHeader.txtfStartDate.value == ""
                        || document.frmTOCHeader.txtfStartDate.value == null) {
                    span = document.getElementById("txtInitDate");
                    span.style.display = 'inline';
                    showTextInitDate = true;
                    return false;
                } else if (document.frmTOCHeader.txtfEndDate.value == ""
                        || document.frmTOCHeader.txtfEndDate.value == null) {
                    span = document.getElementById('txtEndDate');
                    span.style.display = 'inline';
                    showTextEndDate = true;
                    return false;
                } else if (document.getElementById("banco").value == "None") {
                    showTtxtBanco = true;
                    span = document.getElementById('txtBanco');
                    span.style.display = 'inline';
                    return false;
                } else if (document.getElementById("tipoPago").value == "None") {
                    showtxtTipoPago = true;
                    span = document.getElementById('txtTipoPago');
                    span.style.display = 'inline';
                    return false;
                } else if (document.getElementById("distribuidor").value == "None") {
                    showtxtDistribuidor = true;
                    span = document.getElementById('txtDistribuidor');
                    span.style.display = 'inline';
                    return false;
                } else if (document.getElementById("telefonica").value == "None") {
                    showtxtTelefonia = true;
                    span = document.getElementById('txtTelefonia');
                    span.style.display = 'inline';
                    return false;
                } else {
                    return true;
                }
            } catch (e) {

            }
        }



    </script>
    <body>
        <div align="center">
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificaci�n -->
            <form action="ControllerServletVTA?action=repvtAcuComMain" method="post"
                  name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificaci�n -->    
                <table width="100%" border="0" cellspacing="0" id="tabla">
                    <tr>
                        <th id="tituloTab" width="100%" colspan="5" align="left"><font
                                color="#000000">Reporte de Acumulado de Transacciones Tiempo Aire por Comercio</font></th>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br /></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Fecha Inicio:</strong></td>
                        <td align="left"><input name="txtfStartDate" type="text"
                                                id="txtfStartDate" size="15" readonly maxlength="15"
                                                value=<%=session.getAttribute("fechaHoy")%>> <a
                                                href="javascript:void(0)"
                                                onclick="if (self.gfPop)
                                                            gfPop.fPopCalendar(document.frmTOCHeader.txtfStartDate);
                                                        return false;"
                                                hidefocus> <img name="popcalStart" align="absmiddle"
                                            src="scripts/calendar/calbtn.jpg" border="0" alt="">
                            </a><br /> <span id="txtInitDate" class="ocultar">Selecciona una fecha</span>
                        </td>
                        <td align="left"><strong>Fecha Fin:</strong></td>
                        <td align="left"><input name="txtfEndDate" type="text"
                                                id="txtfEndDate" size="15" readonly maxlength="15"
                                                value=<%=session.getAttribute("fechaHoy")%>> <a
                                                href="javascript:void(0)"
                                                onclick="if (self.gfPop)
                                                            gfPop.fPopCalendar(document.frmTOCHeader.txtfEndDate);
                                                        return false;"
                                                hidefocus> <img name="popcalStart" align="absmiddle"
                                            src="scripts/calendar/calbtn.jpg" border="0" alt="">
                            </a><br /> <span id="txtEndDate" class="ocultar">Selecciona una
                                fecha</span></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Adquiriente:</strong></td>
                        <td align="left">
                            <%
                                    comboBox = new HTML();
                                    out.println(""+ comboBox.getListBox("banco", cbIntValues,"Selecciona un Banco"));
                            %><br />  <span id="txtBanco" class="ocultar">Elije una Opci&oacute;n</span>
                        </td>
                        <td align="left"><strong>Tipo de Operativa:</strong></td>
                        <td>
                            <select name="tipoPago" id="tipoPago">
                                <option value="None" selected="">Selecciona Tipo de Pago</option>
                                <option value="E">Efectivo</option>
                                <option value="T">Tarjeta</option>
                            </select><br />
                            <span id = "txtTipoPago" class="ocultar">Elije una Opci&oacute;n</span>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br /></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Distribuidor:</strong></td>
                        <td align="left">
                            <%
                                    comboBox = new HTML();
                                    out.println(""
                                                    + comboBox.getListBox("distribuidor", cbDisValues,
                                                                    "Selecciona un Distribuidor"));
                            %><br /><span id="txtDistribuidor" class="ocultar">Elije una Opci&oacute;n</span>
                        </td>
                        <td align="left"><strong>Telef&oacute;nica:</strong></td>
                        <td align="left">
                            <%
                            comboBox = new HTML();
                             out.println(""+ comboBox.getListBox("telefonica", cbTelValues,
                                                                    "Selecciona una Telef&oacute;nica"));
                            %><br /><span id="txtTelefonia" class="ocultar">Elije una Opci&oacute;n</span>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br /></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4" align="left"><input name="btnLstTOC"
                                                            type="submit" id="btnLstTOC" value="Mostrar Reporte"
                                                            onclick="javascript:return valida(this.form);"></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br /></td>
                    </tr>
                </table>
            </form>
        </div>
        <iframe width=174 height=189 name="gToday:normal:agenda.js"
                id="gToday:normal:agenda.js" src="scripts/calendar/ipopeng.htm"
                scrolling="no" frameborder="0"
                style="visibility: visible; z-index: 999; position: absolute; top: -500px; left: -500px;">
        </iframe>
    </body>
</html>