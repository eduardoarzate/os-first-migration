<%
/*###############################################################################
# Nombre del Programa :  SICMOR0330Header.jsp                                   #
# Autor               :  JOAQUIN MOJICA Q.                                      #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-08-299-04                 	   FECHA:15/10/2008     #
# Descripcion General :										                    #
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :						                                    #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :														    #
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
<%@ page import="com.wellcom.prosa.sacii.*" %>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>

<%
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
   }
   HTML inputText;
   HTML combo;
   ArrayList cbBancosEglo;
   ArrayList cbTipoTxn;
   /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
   ComboBoxGen comboBox=new ComboBoxGen();
   /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */  
   cbBancosEglo=comboBox.getBancosEglo(session);
   cbTipoTxn=comboBox.getTipoTrxsVenDev(session);
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
        var showTextCuentaORef = false;
        var showTextBancoEglo = false;
        var showTextTipoTxn = false;
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
                } else if (showTextCuentaORef)
                {
                    span = document.getElementById('textCuentaORef');
                    span.style.display = 'none';
                    showTextCuentaORef = false;
                } else if (showTextBancoEglo)
                {
                    span = document.getElementById('textBancoEglo');
                    span.style.display = 'none';
                    showTextBancoEglo = false;
                } else if (showTextTipoTxn)
                {
                    span = document.getElementById('textTipoTxn');
                    span.style.display = 'none';
                    showTextTipoTxn = false;
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
                } else if ((document.frmTOCHeader.cuenta.value == "" || document.frmTOCHeader.cuenta.value == null) && (document.frmTOCHeader.referencia.value == "" || document.frmTOCHeader.referencia.value == null))
                {
                    span = document.getElementById('textCuentaORef');
                    span.style.display = 'inline';
                    showTextCuentaORef = true;
                    return false;
                } else if (document.frmTOCHeader.bancoAdq.value == "None")
                {
                    span = document.getElementById('textBancoEglo');
                    span.style.display = 'inline';
                    showTextBancoEglo = true;
                    return false;
                } else if (document.frmTOCHeader.tipoTxn.value == "None")
                {
                    span = document.getElementById('textTipoTxn');
                    span.style.display = 'inline';
                    showTextTipoTxn = true;
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
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación -->
            <form action="ControllerServletMonitoreo?action=SICMOR0330Main" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación -->
                <table width="100%" border="0" cellspacing="0" id="tabla">
                    <tr>
                        <th id= "tituloTab" width="100%" colspan="5" align="left" ><font color="#000000">SICMOR0330 - Verificador de Transacciones Enviadas por Bancomer/ Banamex/ E-Global</font></th>
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
                            </a><br/>
                            <span id = "txtInitDate" class="ocultar">Selecciona una fecha</span><%//agregar class%>
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
                        <td align="left"><strong>Cuenta:</strong></td>
                        <td align="left">
                            <%
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputText( "cuenta", 20,20 ) );
                            %><br/>
                        </td>
                        <td align="left"><strong>Referencia:</strong></td>
                        <td align="left">
                            <%
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputText( "referencia", 25,25 ) );
                            %><br/>
                            <span id = "textCuentaORef" class="ocultar">Escriba una cuenta o una referencia</span>
                        </td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Tipo Transacci&oacute;n:</strong></td>
                        <td align="left">
                            <%
                                    combo = new HTML();
                                    out.println( "" + combo.getListBox( "tipoTxn", cbTipoTxn,"Seleccione un Tipo de Transacción" ) );
                            %><br/>
                            <span id = "textTipoTxn" class="ocultar">Seleccione un Tipo Transacción</span>
                        </td>
                        <td align="left"><strong>Banco:</strong></td>
                        <td align="left">
                            <%
                                    combo = new HTML();
                                    out.println( "" + combo.getListBox( "bancoAdq", cbBancosEglo,"Seleccione un Banco" ) );
                            %><br/>
                            <span id = "textBancoEglo" class="ocultar">Seleccione un banco</span>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Naturaleza Contable(Opcional):</strong></td>
                        <td align="left">
                            <%
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputText( "natContable", 1,1 ) );
                            %><br/>
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
