<%
/*###############################################################################
# Nombre del Programa :  SICMOR0310Header.jsp                                   #
# Autor               :  JOSE ANDRES CASTILLO MORENO                            #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-08-299-04                 	   FECHA:05/09/2010     #
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
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>
<%@page import="java.io.IOException"%>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%ArrayList cbBancoAdqValues;
        ArrayList cbBancoEmiValues ;
        ArrayList cbTipoTransacValues;
        ArrayList cbTipoLiquidacionValues;
        ArrayList cbFuente;
        String prueba;
        HTML comboBox;
        HTML inputText;
        /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
        ComboBoxGen myComboBox;%>
<%
    if(!ga.AccessGranted(session, "grantAccess"))
    {
        response.sendRedirect("login.jsp");
    }
    myComboBox = new ComboBoxGen();
    /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */  
    cbBancoAdqValues  = myComboBox.getBancosAdqsHijosSinFiltros(session);
    cbBancoEmiValues  = myComboBox.getBancosEmisHijos2(session);
    cbTipoTransacValues = myComboBox.getGrupoTrxs(session);
    cbTipoLiquidacionValues = myComboBox.getTipoLiq(session);
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
        var showTextBancoAdq = false;

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
                } else if (showTextBancoAdq)
                {
                    span = document.getElementById('txtBancoAdq');
                    span.style.display = 'none';
                    showTextBancoAdq = false;
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
                } else if (document.frmTOCHeader.bancoAdq.value == "None")
                {
                    span = document.getElementById('txtBancoAdq');
                    span.style.display = 'inline';
                    showTextBancoAdq = true;
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
            <form action="ControllerServletMonitoreo?action=SICMOR0310Main" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación -->
                <table width="100%" border="0" cellspacing="0" id="tabla">
                    <tr>
                        <th id="tituloTab" width="100%" colspan="5" align="left" ><font color="#000000">SICMOR0310 - Transacciones Aceptadas (Totales por Adquirente)</font> 
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
                        <td align="left"><strong>Banco Adquirente:</strong></td>
                        <td align="left">
                            <% 
                                    comboBox = new HTML();
                            out.println( "" + comboBox.getComboBox( "bancoAdq", cbBancoAdqValues,"onchange", "javascript:sendDatas('bancoAdq','txtfStartDate','archivoAdqFechas','comboBoxArchivo');" , "Selecciona un Banco" ));
                            %><br/>
                            <span id = "txtBancoAdq" class="ocultar">Elije una Opción</span>
                        </td>
                        <td align="left"><strong>Banco Emisor:</strong> </td>
                        <td align="left">
                            <% 
                                    comboBox = new HTML();
                            out.println( "" + comboBox.getListBox( "bancoEmi", cbBancoEmiValues , "Selecciona un Banco" ));
                            %><br/>
                            <span id = "txtBancoEmi" class="ocultar">Elije una Opción</span>            	 	
                        </td> 
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Tipo Transacci&oacute;n:</strong></td>
                        <td align="left">
                            <% 
                                    comboBox = new HTML();
                            out.println( "" + comboBox.getListBox( "tipoTransac", cbTipoTransacValues , "Selecciona una Transacción" ));
                            %><br/>
                            <span id = "txtTipoTransac" class="ocultar">Elije una Opción</span>
                        </td>
                        <td align="left"><strong>Fuente:</strong></td>
                        <td align="left" id ="comboBoxArchivo">
                            <select multiple="multiple">
                                <option>Selecciona un Archivo</option>
                            </select><br/>
                            <span id = "txtArchivo" class="ocultar">Elije una Opción</span>
                        </td> 
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Comercio:</strong> </td>
                        <td align="left">
                            <%
                                    inputText = new HTML();
        out.println( "" + inputText.getinputText( "comercio", 20 ,20 ));
            //comboBox = new HTML();
            //out.println( "" + comboBox.getListBox( "bancoSocio", cbBancosSocios, "Selecciona un Banco" ) );
                            %><br/>
                            <span id = "txtComercio1" class="ocultar">Falta comercio</span>
                        </td>
                        <td align="left"><strong>Tipo Liquidacion:</strong></td>
                        <td align="left">
                            <% 
                                    comboBox = new HTML();
                            out.println( "" + comboBox.getListBox( "tipoLiquidacion", cbTipoLiquidacionValues , "Selecciona una Liquidacion" ));
                            %><br/>
                            <span id = "txtTipoLiquidacion"  class="ocultar">Elije una Opción</span>
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
        <iframe width="174" height="189" name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="scripts/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
        </iframe>
    </body>
</html>
