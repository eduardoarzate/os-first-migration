<%/*
#								MODIFICACIONES  #
# Autor               :  Daniel Ramírez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#------------------------------------------------------------------------------#
*/%>
<%@ page import="com.wellcom.io.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%ArrayList cbAdquirente;
        ArrayList cbEmisor;
        ArrayList cbFuente;
        ArrayList cbNatCon;
        ArrayList cbTransaccion;
        ArrayList cbLiquidacion;
        HTML comboBox;
        HTML inputText;
         /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
        ComboBoxGen myComboBox;
%>
<%
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
   }
   myComboBox = new ComboBoxGen();
    /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
   cbAdquirente = myComboBox.getBancosAdqsHijosSinFiltros2(session);
   cbEmisor = myComboBox.getBancosEmisHijos(session);

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <link href="css/styles.css" rel="stylesheet" type="text/css">
        <title>SAC 2</title>

        <script type="text/javascript">
            var span = null;
            var showTextInitDate = false;
            var showTextIEndDate = false;
            var verAdquirente = false;
            var verEmisor = false;
            var verFuente = false;
            var verTransaccion = false;
            var verLiquidacion = false;

            function valida()
            {
                try
                {
                    if (showTextInitDate)
                    {
                        span = document.getElementById("txtInitDate");
                        span.style.display = 'none';
                        showTextInitDate = false;
                    } else if (verAdquirente)
                    {
                        span = document.getElementById('spamAdquirente');
                        span.style.display = 'none';
                        verAdquirente = false;
                    } else if (verEmisor)
                    {
                        span = document.getElementById('spamEmisor');
                        span.style.display = 'none';
                        verEmisor = false;
                    } else if (verFuente)
                    {
                        span = document.getElementById('txtArchivo');
                        span.style.display = 'none';
                        verFuente = false;
                    }
                    /*else if(verTransaccion)
                     {
                     span = document.getElementById('spamTransaccion');
                     span.style.display = 'none';
                     verTransaccion = false;
                     }
                     
                     else if(verLiquidacion)
                     {
                     span = document.getElementById('spamLiquidacion');
                     span.style.display = 'none';
                     verLiquidacion = false;
                     }*/

                    if (document.frmTOCHeader.txtfStartDate.value == "" || document.frmTOCHeader.txtfStartDate.value == null)
                    {
                        span = document.getElementById("txtInitDate");
                        span.style.display = 'inline';
                        showTextInitDate = true;
                        return false;
                    } else if (document.frmTOCHeader.bancoAdq.value == "None")
                    {
                        span = document.getElementById('spamAdquirente');
                        span.style.display = 'inline';
                        verAdquirente = true;
                        return false;
                    } else if (document.frmTOCHeader.bancoEmi.value == "None")
                    {
                        span = document.getElementById('spamEmisor');
                        span.style.display = 'inline';
                        verEmisor = true;
                        return false;
                    } else if (document.frmTOCHeader.archivoAdq.value == "None")
                    {
                        span = document.getElementById('txtArchivo');
                        span.style.display = 'inline';
                        verFuente = true;
                        return false;
                    }
                    /*else if(document.frmTOCHeader.transaccion.value == "None")
                     {
                     span = document.getElementById('spamTransaccion');
                     span.style.display = 'inline';
                     verTransaccion = true;
                     return false;
                     }
                     else if(document.frmTOCHeader.liquidacion.value == "None")
                     {
                     span = document.getElementById('spamLiquidacion');
                     span.style.display = 'inline';
                     verLiquidacion = true;
                     return false;
                     }*/

                    else
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
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación -->
            <form action="ControllerServletCompensacion?action=SICLICE300Main" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación -->
                <table width="100%" border="0" cellspacing="0" id="tabla">
                    <tr>
                        <th id="tituloTab" width="100%" colspan="5" align="left" ><font color="#000000">SICLICE300 - Reporte Corresponsales Detalle emisores</font>  
                        </th>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Fecha Liquidación:</strong></td>
                        <td align="left">
                            <input name="txtfStartDate" type="text" id="txtfStartDate" size="15" readonly maxlength="15" value=<%=session.getAttribute("fechaHoy")%>>
                            <a href="javascript:void(0)" onclick="if (self.gfPop)
                                        gfPop.fPopCalendar(document.frmTOCHeader.txtfStartDate);
                                    return false;" hidefocus>
                                <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg" border="0" alt="">
                            </a><br/>
                            <span id = "txtInitDate" class="ocultar">Selecciona una fecha</span><%//agregar class%>
                        </td>
                        <td align="left"><strong>Banco Adquirente:<br></strong></td>
                        <td align="left">
                            <%
                          comboBox = new HTML();
                        out.println( "" + comboBox.getListBox( "bancoAdq", cbAdquirente, "onchange", "javascript:sendDatas('bancoAdq','txtfStartDate','corresponsalBin','comboBoxArchivo');","Seleciona Un Banco" ) );
                            %><br/>
                            <span id = "spamAdquirente" class="ocultar">Elija una Opción</span>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <!-- <td align="left"><strong>Fuente:</strong></td> -->
                        <td align="left"><strong></strong></td>
                        <td align="left" id = "comboBoxArchivo">
                            <select multiple="multiple">
                                <option>Selecciona un Archivo</option>
                            </select>
                        </td>
                        <td align="left"><strong>Banco Emisor:</strong></td>
                        <td align="left">
                            <% 
                                    comboBox = new HTML();
                        out.println( "" + comboBox.getComboBox( "bancoEmi", cbEmisor, "onchange", "javascript:sendDatasCI('bancoAdq','txtfStartDate', 'txtfEndDate','corresponsalBin','comboBoxArchivo');", "Selecciona un Banco") );
                            %><br/>
                            <span id = "spamEmisor" class="ocultar">Elija una Opción</span>
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
