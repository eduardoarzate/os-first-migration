<%
/*###############################################################################
# Nombre del Programa :  SICLIF0320Header.jsp                                   #
# Autor               :  CARLOS MENDEZ                                          #
# Compania            :  PROSA                                                  #
# Proyecto/Procliente : C-04-3035-13                            Fecha:11/12/2013#
# Modificacion        : Generacion de Proceso de Diferencia de Cuota de         #
#                       Intercambio de EGLO SAC2                                #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :                                                         #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :                                                         #
#################################################################################
#								MODIFICACIONES                                  #
# Autor               : Jesus P. M.                                             #
# Compania            : SAS S.A. DE C.V.                                        #
# Proyecto/Procliente : P-53-2004-15                 Fecha: 03/11/2015          #
# Modificación        : Diferencia de cuotas entre cámaras.                     #
#-----------------------------------------------------------------------------  #
# Numero de Parametros: 0                                                       #
#################################################################################
#								MODIFICACIONES                                  #
# Autor               :  Daniel RT                                              #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  P-53-2004-15                Fecha: FECHA:01/04/2016    #
# Modificación        :  Diferencia de cuotas de intercambio                    #
#-----------------------------------------------------------------------------  #
#################################################################################
# Autor               :  Daniel Ramírez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-----------------------------------------------------------------------------  #
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<%@ page import="com.wellcom.io.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>

<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%/* Modificacion: Marca de inicio    SAS-JPM P-53-2004-15  */%>
<% 
    ArrayList cbTipoEntSal;
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
        cbTipoEntSal=myComboBox.getTipoEntSal(session);
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
        var showTextTipoSalEnt = false;

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
                } else if (showTextTipoSalEnt)
                {
                    span = document.getElementById('txtTipoEntSal');
                    span.style.display = 'none';
                    showTextTipoSalEnt = false;
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
                } else if (document.frmTOCHeader.tipoEntSal.value == "None")
                {
                    span = document.getElementById('txtTipoEntSal');
                    span.style.display = 'inline';
                    showTextTipoSalEnt = true;
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
            <form action="ControllerServletCompensacion?action=SICLIF0320Main" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación -->
                <table width="100%" border="0" cellspacing="0" id="tabla">
                    <tr>
                        <th id="tituloTab" width="100%" colspan="5" align="left" ><font color="#000000">SICLIF0320 - Diferencia de cuotas (Arbitro Comercios)</font></th>
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
                        <td>&nbsp;</td>
                        <td align="left"><strong>Tipo Proceso:</strong></td>
                        <td align="left">
                            <%
            comboBox = new HTML();
            out.println( "" + comboBox.getComboBox( "tipoEntSal",  cbTipoEntSal, "Selecciona un Tipo de Proceso"  ) );
                            %><br/>
                            <span id = "txtTipoEntSal" class="ocultar">Elije una Opción</span>
                        </td>
                        <td class="etiquetaListado" width="110px">
                            Formato Salida
                        </td>
                        <td valign="middle" width="210px">
                            <select name="formato" value="0" >
                                <option value="0" selected>Html</option>
                                <option value="1">Excel</option>
                                <option value="2">Pdf</option>
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
                            <input name="btnLstTOC" type="submit" id="btnLstTOC" value="Generar Reporte" onclick="javascript:return valida(this.form);">
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
    <%/* Modificacion: Marca de fin    SAS-JPM P-53-2004-15  */%>
</html>
