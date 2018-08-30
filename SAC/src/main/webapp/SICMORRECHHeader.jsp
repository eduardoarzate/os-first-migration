<%
/*###############################################################################
# Nombre del Programa :  SICMORRECHHeader.jsp                                   #
# Autor               :  JOAQUIN MOJICA Q.                                      #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-08-2379-12                 	   FECHA:03/07/2012     #
# Descripcion General :	 Filtro de monto para CashBack                          #
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :						                                    #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :									                        #
#################################################################################
#								MODIFICACIONES                                  #
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
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>

<%ArrayList cbBANCO;
        HTML comboBox;
        ArrayList cbMeses;
        ArrayList cbYears;
        /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
        ComboBoxGen myComboBox;%>

<%
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
   }
   HTML inputText;
   HTML comboText;
   
   myComboBox = new ComboBoxGen();
   /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */  
   cbBANCO = myComboBox.getBancoAdqFiid(session);
   cbMeses=myComboBox.getMeses(session);
   cbYears=myComboBox.getYears(session);
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
        var vercuenta = false;
        var verafiliacion = false;
        var verbanco = false;

        function valida()
        {
            try
            {
                if (showTextInitDate)
                {
                    span = document.getElementById("txtInitDate");
                    span.style.display = 'none';
                    showTextInitDate = false;
                } else if (vercuenta)
                {
                    span = document.getElementById('spamcuenta');
                    span.style.display = 'none';
                    vercuenta = false;
                } else if (verafiliacion)
                {
                    span = document.getElementById('spamafiliacion');
                    span.style.display = 'none';
                    verafiliacion = false;
                } else if (verbanco)
                {
                    span = document.getElementById('spambanco');
                    span.style.display = 'none';
                    verbanco = false;
                }

                if (document.frmTOCHeader.mes.value == "None" || document.frmTOCHeader.year.value == "None")
                {
                    span = document.getElementById("txtInitDate");
                    span.style.display = 'inline';
                    showTextInitDate = true;
                    return false;
                } else if ((document.frmTOCHeader.cuenta.value == "" || document.frmTOCHeader.cuenta.value == null) || (document.frmTOCHeader.cuenta.value == 'None'))
                {
                    span = document.getElementById('spamcuenta');
                    span.style.display = 'inline';
                    vercuenta = true;
                    return false;
                } else if ((document.frmTOCHeader.banco.value == "" || document.frmTOCHeader.banco.value == null) || (document.frmTOCHeader.banco.value == 'None'))
                {
                    span = document.getElementById('spambanco');
                    span.style.display = 'inline';
                    verbanco = true;
                    return false;
                } else if ((document.frmTOCHeader.afiliacion.value == "" || document.frmTOCHeader.afiliacion.value == null))
                {
                    span = document.getElementById('spamafiliacion');
                    span.style.display = 'inline';
                    verafiliacion = true;
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
            <form action="ControllerServletMonitoreo?action=SICMORRECHMain" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación -->
                <table width="100%" border="0" cellspacing="0" id="tabla">
                    <tr>
                        <th id="tituloTab" width="100%" colspan="5" align="left" ><font color="#000000">SICMORRECH - LOG Rechazos<br></font></th>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Fecha:</strong></td>
                        <td align="left">
                            <% comboBox = new HTML();
                               out.println( "" + comboBox.getComboBox( "mes", cbMeses, "Mes" ) );
                               out.println( "" + comboBox.getComboBox( "year", cbYears, " Año" ) );
                            %><br/>
                            <span id = "txtInitDate" class="ocultar">Selecciona una fecha</span>
                        </td>
                        <td align="left"><strong>Afiliaci&oacute;n:</strong></td>
                        <td align="left">
                            <%
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputText( "afiliacion", 8,20 ) );
                            %><br/><span id = "spamafiliacion1" class="ocultar">Selecciona una afiliacion</span>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Cuenta:</strong></td>
                        <td align="left">
                            <%
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputText( "cuenta", 16,20 ) );
                            %><br/><span id = "spamcuenta" class="ocultar">Selecciona una cuenta</span>
                        </td>
                        <td align="left"><strong>Fiid Adquirente:</strong><br></td>
                        <td align="left">
                            <%
                                    comboBox = new HTML();
                                    out.println( "" + comboBox.getListBox( "banco", cbBANCO,"Seleccione una opcion" ) );
                            %><br/>
                            <span id = "spambanco" class="ocultar">Seleccionar una Fiid</span>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Codigo Rechazo:</strong></td>
                        <td align="left">
                            <%
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputText( "codigo",3,3 ) );
                            %><br/><span id = "spamcuenta" class="ocultar">Ingrese un Codigo de Respuesta</span>
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
