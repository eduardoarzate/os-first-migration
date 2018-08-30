<%
/*Modificación
#------------------------------------------------------------------------------#
# Autor               :  Daniel Ramirez Torres                                 #
# Compania            :  SAS S.A. DE C.V.                                      #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017        #
# Modificacion        :  Mejora Conexiones  SAC2                               #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                  #
#------------------------------------------------------------------------------#
*/%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wellcom.io.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%
        ArrayList cbIntValues;
        //ArrayList cbBancosSocios;
        ArrayList cbAnios;
        HTML comboBox;
        //ArrayList cbTipoLiq; 
        /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
        ComboBoxGen myComboBox;%>
<%
    if(!ga.AccessGranted(session, "grantAccess"))
    {
        response.sendRedirect("login.jsp");
    }
    myComboBox = new ComboBoxGen();   
    /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
    //cbBancosSocios = myComboBox.getBancosSocios(session);
    //ArrayList cbTipoLiq= myComboBox.getTipoLiq0010(session);
    cbIntValues = myComboBox.getBancoIntEntHijas(session);
    cbAnios=myComboBox.getYears(session);
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
        var showTextTipoLiq = false;
        var showTextBanco = false;

        function valida()
        {
            try
            {
                if (showTextInitDate)
                {
                    span = document.getElementById("txtInitDate");
                    span.style.display = 'none';
                    showTextInitDate = false;
                }

                /*else if(showTextEndDate)
                 {
                 span = document.getElementById('txtEndDate');
                 span.style.display = 'none';
                 showTextEndDate = false;
                 }
                 
                 else if(showTextBanco)
                 {
                 span = document.getElementById('txtBanco');
                 span.style.display = 'none';
                 showTextBanco = false;
                 }
                 
                 else if(showTextTipoLiq)
                 {
                 span = document.getElementById('txtTipoLiq');
                 span.style.display = 'none';
                 showTextTipoLiq = false;
                 }*/

                if (document.frmTOCHeader.txtfStartDate.value == "" || document.frmTOCHeader.txtfStartDate.value == null)
                {
                    span = document.getElementById("txtInitDate");
                    span.style.display = 'inline';
                    showTextInitDate = true;
                    return false;
                }

                /*else if(document.frmTOCHeader.txtfEndDate.value == "" || document.frmTOCHeader.txtfEndDate.value == null)
                 {
                 span = document.getElementById('txtEndDate');
                 span.style.display = 'inline';
                 showTextEndDate = true;
                 return false;
                 }
                 
                 else if(document.frmTOCHeader.banco.value == "None")
                 {
                 span = document.getElementById('txtBanco');
                 span.style.display = 'inline';
                 showTextBanco = true;
                 return false;
                 }
                 else if(document.frmTOCHeader.tipoLiq.value=="None")
                 {
                 span = document.getElementById('txtTipoLiq');
                 span.style.display = 'inline';
                 showTextTipoLiq = true;
                 return false;
                 }
                 */
                else
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
            <form action="ControllerServletInterf?action=SICLIR0470Main" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación -->
                <table width="100%" border="0" cellspacing="0" id="tabla">
                    <tr>
                        <th id="tituloTab" width="100%" colspan="5" align="left" ><font color="#000000">SICLIR0470 - Liquidaciones Complementarias de Facturaci&oacute;n por Folio</font></th>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Fecha Liquidaci&oacute;n:</strong></td>
                        <td align="left">
                            <input name="txtfStartDate" type="text" id="txtfStartDate" size="15" readonly maxlength="15" value=<%=session.getAttribute("fechaHoy")%>>
                            <a href="javascript:void(0)" onclick="if (self.gfPop)
                                        gfPop.fPopCalendar(document.frmTOCHeader.txtfStartDate);return false;" hidefocus>
                                <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg" border="0" alt="">
                            </a><br/>
                            <span id = "txtInitDate" class="ocultar">Selecciona una fecha</span><%//agregar class%>
                        </td>
                        <td align="left"><strong>A&ntilde;o:</strong></td>
                        <td align="left">
                            <%
                                 comboBox = new HTML();
                                         out.println( "" + comboBox.getComboBox( "anio",cbAnios, "Selecciona un Año" ) );
                            %><br/>
                            <span id = "txtBancoSocio" class="ocultar">Elije una Opción</span>
                        </td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Banco:</strong> </td>
                        <td align="left">
                            <%
            comboBox = new HTML();
            out.println( "" + comboBox.getListBox( "banco", cbIntValues, "Selecciona un Banco" ) );
                            %><br/>
                            <span id = "txtBancoSocio" class="ocultar">Elije una Opción</span>
                        </td>

                        <td align="left"><strong>Folio:</strong></td>
                        <td align="left">
                            <%
                                    HTML cb = new HTML();
                                    out.println( "" + cb.getinputText("folio",255,10) );
                            %><br/>
                            <span id = "txtTipoLiq" class="ocultar">Selecciona Opción</span>
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
                </table>
            </form>
        </div>
        <iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="scripts/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
        </iframe>
    </body>
</html>
