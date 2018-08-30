<%
/*###############################################################################
# Nombre del Programa :  SICLMNIR01Header.jsp		    						#
# Autor               :  Jesus Parra Mtz.                                       #
# Compania            :  Soporte y Asesoria en Sistemas S.A. DE C.V.            #
# Proyecto/Procliente :  P-53-2934-14                 	   FECHA:11/03/2015     #
# Descripcion General :															#
#                                                                               #
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
<%@ page import="com.wellcom.io.HTML" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.wellcom.prosa.sacii./* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */        ComboBoxGen" %>
<%@page import="java.io.IOException"%>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%
        String tipo = "INTERRED";
        ArrayList listMarcas;
        ArrayList listEntidades;
        HTML htmlCmb;
        /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */        
        ComboBoxGen comboBox;
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
   }
   comboBox = new ComboBoxGen();    
   /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
   htmlCmb = new HTML();
   listMarcas = comboBox.getMarcasRLN(session);
   listEntidades = comboBox.getEntidadesRLN(session, tipo);
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
        var showTextMarca = false;
        var showTextInst = false;

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
                } else if (showTextMarca)
                {
                    span = document.getElementById('txtMarca');
                    span.style.display = 'none';
                    showTextInterred = false;
                } else if (showTextInst)
                {
                    span = document.getElementById('txtInst');
                    span.style.display = 'none';
                    showTextInst = false;
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
                } else if (document.frmTOCHeader.cmbMarcas.value == "None")
                {
                    span = document.getElementById('txtMarca');
                    span.style.display = 'inline';
                    showTextMarca = true;
                    return false;
                } else if (document.frmTOCHeader.cmbInst.value == "None")
                {
                    span = document.getElementById('txtInst');
                    span.style.display = 'inline';
                    showTextInst = true;
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
            <form name="frmTOCHeader" id="frmTOCHeader" target="mainFrameTOC" method="post" action="ControllerServletInterf?action=SICLMNIR01Main">
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación -->
                <table width="100%" border="0" cellspacing="0" id="tabla">
                    <tr>
                        <th id="tituloTab" width="100%" colspan="5" align="left" ><font color="#000000">SICLMNIR01 - Reporte Consolidado Interredes (por marca)<br></font></th>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>
                    </tr>

                    <tr>
                        <td><strong>&nbsp;</strong></td>
                        <td align="left"><strong>Fecha Inicio:</strong></td>
                        <td align="left">
                            <input name="txtfStartDate" type="text" id="txtfStartDate" size="15" readonly maxlength="15" value=<%=session.getAttribute("fechaHoy")%>>
                            <a href="javascript:void(0)" onclick="if (self.gfPop)
                                        gfPop.fPopCalendar(document.frmTOCHeader.txtfStartDate);
                                    return false;" hidefocus>
                                <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg" border="0" alt="">
                            </a><br/>
                            <span id = "txtInitDate" class="ocultar">Selecciona una fecha</span>
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
                        <td align="left"><strong>Marca:</strong></td>
                        <td align="left">
                            <% 
                                    out.println(htmlCmb.getListBox("cmbMarcas", listMarcas, "Seleccione una Marca"));
                            %><br/>
                            <span id = "txtMarca" class="ocultar">Elije una Opci&oacute;n</span>
                        </td>

                        <td align="left"><strong>Banco:</strong></td>
                        <td align="left">
                            <% 
                                    out.println(htmlCmb.getListBox("cmbInst", listEntidades, "Seleccione un Banco"));
                            %><br/>
                            <span id = "txtInst" class="ocultar">Elije una Opci&oacute;n</span>
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