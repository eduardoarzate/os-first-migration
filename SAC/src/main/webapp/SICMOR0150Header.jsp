<%
/*###############################################################################
# Nombre del Programa :  SICMOR0150Header.jsp                                   #
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
<%ArrayList cbTipoTrxsValues;
        ArrayList cbArchivoValues;
        HTML seleccionMultiple;
        /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
        ComboBoxGen myComboBox;%>
<%
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
   }
   myComboBox = new ComboBoxGen();
   /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */  
   cbTipoTrxsValues = myComboBox.getTipoTrxs(session);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>SAC 2</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css">

        <script type="text/javascript">
            var span = null;
            var showTextInitDate = false;
            var showTextEndDate = false;
            var showTextTipoTrans = false;
            var showTextArchivo = false;

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
                    } else if (showTextTipoTrans)
                    {
                        span = document.getElementById('txtTipoTrans');
                        span.style.display = 'none';
                        showTextTipoTrans = false;
                    } else if (showTextArchivo)
                    {
                        span = document.getElementById('txtArchivo');
                        span.style.display = 'none';
                        showTextArchivo = false;
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
                    } else if (document.frmTOCHeader.tipoTrans.value == "None")
                    {
                        span = document.getElementById('txtTipoTrans');
                        span.style.display = 'inline';
                        showTextTipoTrans = true;
                        return false;
                    } else if (document.frmTOCHeader.archivo.value == "None")
                    {
                        span = document.getElementById('txtArchivo');
                        span.style.display = 'inline';
                        showTextArchivo = true;
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
    </head>

    <body>
        <div align="center">
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación -->
            <form action="ControllerServletMonitoreo?action=SICMOR0150Main" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación -->
                <table width="100%" border="0" cellspacing="0" id="tabla">
                    <tr>
                        <th id="tituloTab" colspan=5 align="left" ><font color="#000000">SICMOR0150 - Comparaci&oacute;n de Cifras de Control por Archivo</font></th>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>

                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Fecha Inicio:</strong></td>
                        <td align="left" id="initDate">	
                            <input name="txtfStartDate" type="text" id="txtfStartDate" size="15" readonly maxlength="15" onblur="javascript:sendDatas('txtfStartDate', 'txtfEndDate', 'archivo', 'comboBoxArchivo');" value=<%=session.getAttribute("fechaHoy")%>>
                            <a href="javascript:void(0)" onclick="if (self.gfPop)
                                        gfPop.fPopCalendar(document.frmTOCHeader.txtfStartDate);return false;" >
                                <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg" border="0" alt="">
                            </a><br/>
                            <span id = "txtInitDate" class="ocultar">Selecciona una fecha</span>
                        </td>
                        <td align="left"><strong>Fecha Fin:</strong></td>
                        <td align="left" id="endDate">
                            <input name="txtfEndDate" type="text" id="txtfEndDate" size="15" readonly maxlength="15"  onblur="javascript:sendDatas('txtfStartDate', 'txtfEndDate', 'archivo', 'comboBoxArchivo');" value=<%=session.getAttribute("fechaHoy")%>>
                            <a href="javascript:void(0)" onclick="if (self.gfPop)
                                        gfPop.fPopCalendar(document.frmTOCHeader.txtfEndDate);
                                    return false;"  >
                                <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg" border="0" alt="">
                            </a><br/>
                            <span id = "txtEndDate" class="ocultar">Selecciona una fecha</span>
                        </td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Tipo transacci&oacute;n:</strong></td>
                        <td align="left" id="comboBoxTipoTrans">
                            <% seleccionMultiple = new HTML();
       out.println( "" + seleccionMultiple.getListBox( "tipoTrans", cbTipoTrxsValues, "onchange", "javascript:sendDatas('txtfStartDate', 'txtfEndDate', 'archivo', 'comboBoxArchivo');", "Selecciona un Tipo De Transacción" ) );
                            %><br/>
                            <span id = "txtTipoTrans" class="ocultar">Elije una Opción</span>
                        </td>
                        <td align="left"><strong>Archivo:</strong></td>
                        <td align="left" id="comboBoxArchivo">
                            <select multiple="multiple">
                                <option selected="selected" value="None">Selecciona un Archivo</option>
                            </select>
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
