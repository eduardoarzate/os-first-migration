<%
/*###############################################################################
# Nombre del Programa :  SICLIR400Header.jsp                MODIFICACIONES      #
# Autor               :  Daniel Ramirez Torres /Llao                            #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  B-54-2904-15                 	   FECHA: 25/08/2016    #
# Descripcion General :	 Mejorar Reportería SAC2                              	#
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
ArrayList cbBancoEmiValues ;
ArrayList cbTipoTransacValues;
String prueba;
HTML comboBox;
/* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
        ComboBoxGen myComboBox;%>
<%
    if(!ga.AccessGranted(session, "grantAccess"))
    {
        response.sendRedirect("login.jsp");
    }
    myComboBox = new ComboBoxGen();
/* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
    cbBancoEmiValues  = myComboBox.getEntidadFuente(session);
cbTipoTransacValues = myComboBox.getTipoTrxs2(session);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>SAC 2</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css">

    </head>
    <script type="text/javascript">
        var banderaValidar = false;
        var com = "archivoEntrada_OK1,archivoSalida_OK1".split(",");

        function addFileIN() {
            moveFile('archivoEntrada', 'archivoEntrada_OK1');
        }
        function deleteFileIN() {
            moveFile('archivoEntrada_OK1', 'archivoEntrada');
        }


        function addFileOut() {
            moveFile('archivoSalida', 'archivoSalida_OK1');
        }
        function deleteFileOut() {
            moveFile('archivoSalida_OK1', 'archivoSalida');
        }

        function moveFile(origenCombo, destinoCombo) {
            obj = document.getElementById(origenCombo);
            //alert("indexOBJ > "+ obj.selectedIndex);
            if ((origenCombo == 'archivoEntrada' && destinoCombo == "archivoEntrada_OK1") || (origenCombo == 'archivoSalida'
                    && destinoCombo == "archivoSalida_OK1")) {
                if (obj.selectedIndex == -1 || obj.selectedIndex == 0)
                    return alert("Selecciona una opción válida.");
            }
            valor = obj.value;
            txt = obj.options[obj.selectedIndex].text;
            obj.options[obj.selectedIndex] = null;
            obj2 = document.getElementById(destinoCombo);
            opc = new Option(txt, valor);
            eval(obj2.options[obj2.options.length] = opc);
            archivosES();

        }
        function archivosES()
        {


            var ids = "";
            for (var i = 0; i < com.length; i++)
            {
                for (var indice = 0; indice < document.getElementById(com[i]).length; indice++)
                {
                    ids += document.getElementById(com[i]).options[indice].value + ",";
                }
                if (i == 0) {
                    document.getElementById("archivoEntrada_OK").value = ids;
                } else {
                    document.getElementById("archivoSalida_OK").value = ids;
                }
                ids = "";
            }
        }

        function valida() {
            var texto = "";
            var span = document.getElementById("mensaje");

            try
            {
                if (document.getElementById("txtfStartDate").value == "") {
                    banderaValidar = false;
                    span.innerHTML = "Favor de seleccionar una fecha inicial";
                    span.style.display = 'inline';
                } else if (document.getElementById("txtfEndDate").value == "") {
                    banderaValidar = false;
                    span.innerHTML = "Favor de seleccionar una fecha final";
                    span.style.display = 'inline';
                } else if (document.getElementById("bancoEmi").value == "None") {
                    banderaValidar = false;
                    span.innerHTML = "Favor de seleccionar un banco Emisor";
                    span.style.display = 'inline';
                } else if (document.getElementById("tipoTransac").value == "None") {
                    banderaValidar = false;
                    span.innerHTML = "Favor de seleccionar un tipo de transacción";
                    span.style.display = 'inline';
                } else if (document.getElementById("archivoEntrada_OK").value == "") {
                    banderaValidar = false;
                    span.innerHTML = "Favor de seleccionar un Archivo Entrada";
                    span.style.display = 'inline';
                } else if (document.getElementById("archivoSalida_OK").value == "") {
                    banderaValidar = false;
                    span.innerHTML = "Favor de seleccionar un Archivo de Salida";
                    span.style.display = 'inline';
                } else {
                    banderaValidar = true;
                    span.innerHTML = "";
                    span.style.display = "None";
                }
            } catch (e) {

            }
            return banderaValidar;
        }
        function removeFiles() {
            for (var i = 0; i < com.length; i++) {
                document.getElementById(com[i].substring(0, com[i].length - 1)).value = "";
                while (document.getElementById(com[i]).firstChild) {
                    document.getElementById(com[i]).removeChild(document.getElementById(com[i]).firstChild);
                }
            }
        }
    </script>
    <body>
        <div align="center">
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación -->
            <form action="ControllerServletIntegracion?action=SICLIR0400Main" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación -->
                <table width="100%" border="0" cellspacing="0" id="tabla">
                    <tr>
                        <th id="tituloTab" width="100%" colspan="7" align="left" ><font color="#000000">CCN - Reporte de Conciliación Emisora
                            </font></th>
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
                                    document.getElementById('bancoEmi').value = 'None';
                                    document.getElementById('comboBoxArchivo').innerHTML = '';
                                    removeFiles();
                                    return false;" hidefocus>
                                <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg" border="0" alt="">
                            </a><br/>
                            <span id = "txtInitDate" class="ocultar">Selecciona una fecha Inicial</span>
                        </td>
                        <td align="left"><strong>Fecha Fin:</strong></td>
                        <td align="left">
                            <input name="txtfEndDate" type="text" id="txtfEndDate" size="10" readonly maxlength="10" value=<%=session.getAttribute("fechaHoy")%>>
                            <a href="javascript:void(0)" onclick="if (self.gfPop)
                                        gfPop.fPopCalendar(document.frmTOCHeader.txtfEndDate);
                                    document.getElementById('bancoEmi').value = 'None';
                                    document.getElementById('comboBoxArchivo').innerHTML = '';
                                    removeFiles();
                                    return false;" hidefocus>
                                <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg" border="0" alt="">
                            </a><br/>
                            <span id = "txtEndDate" class="ocultar" class="ocultar">Selecciona una fecha final</span>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Banco:</strong></td>
                        <td align="left">
                            <%
                                    comboBox = new HTML();
                    out.println( "" + comboBox.getListBox( "bancoEmi", cbBancoEmiValues , "onchange", "javascript:sendDataConciliacion('archivosCNN','bancoEmi');removeFiles();","Selecciona un Banco"));
                            %>
                            <img src="pics/img0303busy.gif" name="img01" id="img01" style="display: none;">
                            <br/>
                            <span id = "txtBancoEmi" class="ocultar">Elije una Opción</span>
                        </td>
                        <td align="left"><strong>Tipo Transacci&oacute;n:</strong>  </td>
                        <td align="left">
                            <%
                                    comboBox = new HTML();
                    out.println( "" + comboBox.getListBox( "tipoTransac", cbTipoTransacValues , "Selecciona una Transacción" ));
                            %><br/>
                            <span id = "txtTipoTransac" class="ocultar">Elije una Opción</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5">&nbsp;<br/></td>

                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td align="left">
                            <strong>Archivo Entrada:</strong>
                            <br/>
                            <br/>
                            <br/>
                            <br/>
                            <strong>Archivo Salida:</strong>
                        </td>
                        <td align="left" id="comboBoxArchivo">
                            <select style="width:270px;height:58.75px;" multiple="multiple" id="archivoEntrada" onClick="javascript:addFileIN();" >
                                <option value="" disabled>Seleccionan un Archivo Entrada !</option>
                            </select>
                            <br/>
                            <br/>
                            <select style="width:270px;height:58.75px;" multiple="multiple" id="archivoSalida" onClick="javascript:addFileOut();">
                                <option value="" disabled>Selecciona un Archivo Salida !</option>
                            </select>
                        </td>
                        <td colspan="2">
                            <span id = "txtArchivoEntradaOK" class="ocultar" class="ocultar">Selecciona una Archivo de Entrada</span>
                            <select style="width:270px;height:58.75px;" name = "archivoEntrada_OK1" multiple="multiple" id="archivoEntrada_OK1" onClick="javascript:deleteFileIN();">
                                <!--<option selected="selected" value="None">Seleccionan un Archivo Entrada</option>-->
                            </select>
                            <br/>
                            <br/>
                            <span id = "txtArchivoSalidaOK" class="ocultar" class="ocultar">Selecciona una Archivo de Salida</span>
                            <select style="width:270px;height:58.75px;" name = "archivoSalida_OK1" multiple="multiple" id="archivoSalida_OK1" onClick="javascript:deleteFileOut();">
                                <!--<option selected="selected" value="None">Seleccionan un Archivo Salida</option>-->
                            </select>
                        </td>
                    </tr>


                    <tr>
                        <td colspan="4" style="text-align:center;font-size: 11.5px;"><span id = "mensaje" class="ocultar" style="color:red" >
                            </span></td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="3" align="left">

                            </br>
                            <input name="btnLstTOC" type="submit" id="btnLstTOC" value="Mostrar Reporte" onclick="javascript:return valida(this.form);">
                        </td>
                    </tr>

                </table>
                <input name="archivoEntrada_OK"  id="archivoEntrada_OK" type="hidden" />
                <input name="archivoSalida_OK" id="archivoSalida_OK" type="hidden" />
            </form>
        </div>
        <iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="scripts/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
        </iframe>
    </body>
</html>
