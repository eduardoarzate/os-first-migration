<%
/*
################################################################################
# Nombre              : SICLIQ0500Header.jsp                                   #
# Autor               : Gerardo G. Burguete                                    #
# Compania            : Axia Consultores, S.A. de C.V.                         #
# Proyecto/Procliente : P-53-2933-14                          FECHA:04/06/2015 #
# Descripcion General : Recalculo de compensacion y administracion de umbrales #
# Modificacion        : Reporte de Entidades Prorrateo                         #
# Programa Dependiente: N/A                                                    #
# Programa Subsecuente: N/A                                                    #
# Cond. de ejecucion  : Acceder al sistema                                     #
# Dias de ejecucion   : A Peticion del web, se pueden ejecutar n instancias    #
#------------------------------------------------------------------------------#
#                                MODIFICACIONES                                #
#------------------------------------------------------------------------------#
# Autor               : Francisco Javier Cuamatzi Cuamatzi                     #
# Compania            : Axia Consultores, S.A. DE C.V.                         #
# Proyecto/Procliente : P-53-2933-14                          Fecha: 28/07/2016#
# Descripcion General : Re-calculo de compensacion y administracion de umbrales#
# Modificacion        : Se registringe consulta de entidades solo Bancos Nales #
# Marca del Cambio    : AXIA-FJCC-P-53-2933-14                                 #
#------------------------------------------------------------------------------#
# Autor               :  Daniel Ramirez Torres                                 #
# Compania            :  SAS S.A. DE C.V.                                      #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017        #
# Modificacion        :  Mejora Conexiones  SAC2                               #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                  #
#------------------------------------------------------------------------------#
# Numero de Parametros: 1                                                      #
# Parametros Entrada  : Order Date                         Formato:aaaammdd    #
# Parametros Salida   : N/A                                Formato:N/A         #
# Archivo    Entrada  : N/A                                Formato:N/A         #
# Arvhivo    Salida   : N/A                                Formato:N/A         #
################################################################################
*/
%>
<%@ page import="com.wellcom.io.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%!
        ArrayList cbBancosSocios;
        HTML comboBox;
        /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
        ComboBoxGen myComboBox;%>
<%
  if(!ga.AccessGranted(session, "grantAccess"))
    response.sendRedirect("login.jsp");
  myComboBox = new ComboBoxGen();
        /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */  
  cbBancosSocios = myComboBox.getBancoAdqSinMer(session);
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
        var showTextBancoSocio = false;
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
                } else if (showTextBancoSocio) {
                    span = document.getElementById('txtBancoSocio');
                    span.style.display = 'none';
                    showTextBancoSocio = false;
                }

                if (document.frmTOCHeader.txtfStartDate.value == ""
                        || document.frmTOCHeader.txtfStartDate.value == null)
                {
                    span = document.getElementById("txtInitDate");
                    span.style.display = 'inline';
                    showTextInitDate = true;
                    return false;
                } else if (document.frmTOCHeader.txtfEndDate.value == ""
                        || document.frmTOCHeader.txtfEndDate.value == null)
                {
                    span = document.getElementById('txtEndDate');
                    span.style.display = 'inline';
                    showTextEndDate = true;
                    return false;
                } else if (document.frmTOCHeader.bancoSocio.value == "None") {
                    span = document.getElementById('txtBancoSocio');
                    span.style.display = 'inline';
                    showTextBancoSocio = true;
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
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación -->
            <form action="ControllerServletReLQ?action=SICLIQ0500Main" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación -->
                <table width="100%" border="0" cellspacing="0" id="tabla">
                    <tr>
                        <th id="tituloTab" width="100%" colspan="5" align="left" >
                            <font color="#000000">
                                SICLIQ0500 - Reporte de Entidades Prorrateo<br>
                            </font>
                        </th>
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
                          gfPop.fPopCalendar(document.frmTOCHeader.txtfStartDate);return false;" hidefocus>
                                <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg" border="0" alt="">
                            </a>
                            <br/>
                            <span id = "txtInitDate" class="ocultar">Selecciona una fecha</span><%//agregar class%>
                        </td>
                        <td align="left"><strong>Fecha Fin:</strong></td>
                        <td align="left">
                            <input name="txtfEndDate" type="text" id="txtfEndDate" size="15" readonly maxlength="15" value=<%=session.getAttribute("fechaHoy")%>>
                            <a href="javascript:void(0)" onclick="if (self.gfPop)
                          gfPop.fPopCalendar(document.frmTOCHeader.txtfEndDate);return false;" hidefocus>
                                <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg" border="0" alt="">
                            </a>
                            <br/>
                            <span id = "txtEndDate" class="ocultar">Selecciona una fecha</span>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Banco:</strong> </td>
                        <td align="left">
                            <%
                              comboBox = new HTML();
                              String tCB = comboBox.getListBox("bancoSocio", cbBancosSocios, "Selecciona un Banco");
                              String newComboBox = new String("");
                              int idx = tCB.indexOf("</option>");
                              idx += 9;
                              if (idx > 0) {
                                      newComboBox = tCB.substring(0, idx);
                                      newComboBox += "</option><option value=\"0\">0 TODAS LAS ENTIDADES</option>";
                                      newComboBox += tCB.substring(idx);
                              }
                              out.println( "" + newComboBox );
                            %>
                            <br/>
                            <span id = "txtBancoSocio" class="ocultar">Elije una Opción</span>
                        </td>
                        <td><br/></td>
                        <td><br/></td>
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
