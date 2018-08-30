<%
/*###############################################################################
# Nombre del Programa :  SICMPDA450Header.jsp                                   #
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
#################################################################################
#								MODIFICACIONES                                  #
#-----------------------------------------------------------------------------#
# Autor               :  Daniel Ramírez Torres                                #
# Compania            :  SAS S.A. DE C.V.                                     #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 27/01/2017       #
# Modificacion        :  Mejora Conexiones  SAC2                              #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                 #
#-----------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<%@ page import="com.wellcom.io.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>

<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>

<%ArrayList cbBANCO;
   ArrayList cbBANCO2;
        ArrayList cbTTR;
        ArrayList cbLIQUIDACION;
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
        /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
        cbBANCO = myComboBox.getBancosEglo(session);
        cbBANCO2 = myComboBox.getBancosSocios(session);
        cbLIQUIDACION = myComboBox.getValInval(session);
        cbTTR = myComboBox.getTipoTrxsVenDev(session);
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
        var verbanco = false;
        var verliquidacion = false;
        var veresquema = false;
        var verttr = false;
        var verbanco2 = false;

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
                } else if (verbanco)
                {
                    span = document.getElementById('spambanco');
                    span.style.display = 'none';
                    verbanco = false;
                } else if (veresquema)
                {
                    span = document.getElementById('spamesquema');
                    span.style.display = 'none';
                    veresquema = false;
                } else if (verliquidacion)
                {
                    span = document.getElementById('spamliquidacion');
                    span.style.display = 'none';
                    verliquidacion = false;
                } else if (verttr)
                {
                    span = document.getElementById('spamttr');
                    span.style.display = 'none';
                    verttr = false;
                } else if (verbanco2)
                {
                    span = document.getElementById('spambanco2');
                    span.style.display = 'none';
                    verbanco2 = false;
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
                } else if (document.frmTOCHeader.banco.value == "None")
                {
                    span = document.getElementById('spambanco');
                    span.style.display = 'inline';
                    verbanco = true;
                    return false;
                } else if (document.frmTOCHeader.banco2.value == "None")
                {
                    span = document.getElementById('spambanco2');
                    span.style.display = 'inline';
                    verbanco2 = true;
                    return false;
                } else if ((document.frmTOCHeader.esquema.value == "None") || (document.frmTOCHeader.esquema.value == "") || (document.frmTOCHeader.esquema.value == null))
                {
                    span = document.getElementById('spamesquema');
                    span.style.display = 'inline';
                    veresquema = true;
                    return false;
                } else if (document.frmTOCHeader.liquidacion.value == "None")
                {
                    span = document.getElementById('spamliquidacion');
                    span.style.display = 'inline';
                    verliquidacion = true;
                    return false;
                } else if (document.frmTOCHeader.ttrnumero.value == "None")
                {
                    span = document.getElementById('spamttr');
                    span.style.display = 'inline';
                    verttr = true;
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
            <form action="ControllerServletProm?action=SICMPD0450Main" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación -->
                <table width="100%" border="0" cellspacing="0" id="tabla"><%//cambiar esto%>
                    <tr> 
                        <th id= "tituloTab" width="100%" colspan="5" align="left" ><font color="#000000">SICMPD0450 - Transacciones con Promoci&oacute;n</font><br></th>  
                    </tr><%//cambiar lo de arriba%>
                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>
                    </tr>
                    <tr>

                        <td align="left"><strong>Fecha Inicio:</strong></td>
                        <td align="left">
                            <input name="txtfStartDate" type="text" id="txtfStartDate" size="15" readonly maxlength="15" value=<%=session.getAttribute("fechaHoy")%>>
                            <a href="javascript:void(0)" onclick="if (self.gfPop)
                                        gfPop.fPopCalendar(document.frmTOCHeader.txtfStartDate);
                                    return false;" hidefocus>
                                <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg" border="0" alt="">
                            </a><br/>
                            <span id = "txtInitDate" class="ocultar">Selecciona una fecha</span> <%//agregar class%>
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

                        <td align="left"><strong>Banco:</strong></td>
                        <td align="left">
                            <%
           comboBox = new HTML();
           out.println( "" + comboBox.getListBox( "banco", cbBANCO, "Selecciona un Banco" ) );
                            %><br/>
                            <span id = "spambanco" class="ocultar">Elije una Opción</span>
                        </td>
                        <td align="left"><strong>Estatus Promoci</strong><strong>&oacute;</strong><strong>n:</strong></td>
                        <td align="left">
                            <%
           comboBox = new HTML();
           out.println( "" + comboBox.getComboBox( "liquidacion", cbLIQUIDACION, "Selecciona una liquidacion" ) );
                            %><br/>
                            <span id = "spamliquidacion" class="ocultar">Elije una Opción</span>
                        </td>  						
                    </tr>
                    <tr>

                        <td align="left"><strong>Esquema Adquirente(1)/Emisor(2):</strong></td>
                        <td align="left">
                            <%
           inputText = new HTML();
           out.println( "" + inputText.getinputText( "esquema", 1, 10 ) );
                            %><br/>
                            <span id = "spamesquema" class="ocultar">Elije una Opción</span>
                        </td>
                        <td align="left"><strong>Tipo Transacci&oacute;n:</strong></td>
                        <td align="left">
                            <%
           comboBox = new HTML();
           out.println( "" + comboBox.getListBox( "ttrnumero", cbTTR, "Selecciona un Tipo de Transaccion" ) );
                            %><br/>

                            <span id = "spamttr" class="ocultar">Elije una Opción</span>
                        </td>  						
                    </tr>
                    <tr>  						
                        <td align="left"><strong>Bancos Prosa:</strong></td>
                        <td align="left">
                            <%
           comboBox = new HTML();
           out.println( "" + comboBox.getListBox( "banco2", cbBANCO2, "Selecciona un Banco Prosa" ) );
                            %><br/>
                            <span id = "spambanco2" class="ocultar">Elije una Opción</span>
                        </td>  						  						
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>
                    </tr>

                    <tr>

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
        </iframe> <%//Poner esto%>
    </body>
</html>
