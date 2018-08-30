
<%
/*###############################################################################
# Nombre del Programa :  mantTelf_Header.jsp  								#
# Autor               :  Juan Antonio Guzman Gomez                              #
# Compania            :  SAS S.A. DE C.V.                                  		#
# Proyecto/Procliente :  Z-02-2675-12                 	   FECHA:25/02/2013     #
# Descripcion General :															#
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :															#
#                                                                               #
#                                                                               #
# Dias de ejecucion   :															#
#################################################################################
#                                                                Modificaciones #
#-----------------------------------------------------------------------------  #
# Autor               :  Daniel Ramírez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<%@ page import="com.wellcom.io.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.wellcom.prosa.sacii.*"%>

<jsp:useBean id="ga" scope="session"
             class="com.wellcom.prosa.sacii.GrantAccess" />

<%!ArrayList cbIntValues;
        HTML comboBox;
        HTML checkBox;
        /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
        ComboBoxGen myComboBox;%>

<%
        if (!ga.AccessGranted(session, "grantAccess")) {
                response.sendRedirect("login.jsp");
        }

        myComboBox = new ComboBoxGen();
        /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
        cbIntValues = myComboBox.getDistribuidorMantenimiento(session);
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
        var showTextBanco = false;

        function valida() {
            try {

                if (showTextBanco) {
                    span = document.getElementById('txtBanco');
                    span.style.display = 'none';
                    showTextBanco = false;
                } else if (document.frmTOCHeader.banco.value == "None") {
                    span = document.getElementById('txtBanco');
                    span.style.display = 'inline';
                    showTextBanco = true;
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
            <!--Modificacion: SAS-DRT F-52-8063-16 Marca de inicio-->
            <form action="ControllerServletHerr?action=XXXXmntoDistri" method="post"
                  name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
            <!--Modificacion: SAS-DRT F-52-8063-16 Marca de fin-->
                <table width="100%" border="0" cellspacing="0" id="tabla">
                    <tr>
                        <th id="tituloTab" width="100%" colspan="5" align="left"><font
                                color="#000000">Mantenimiento Distribuidor</font></th>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br /></td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Distribuidor:</strong></td>
                        <td align="left">
                            <%
                                    comboBox = new HTML();
                                    out.println(""
                                                    + comboBox.getListBox("distribuidor", cbIntValues,
                                                                    "Selecciona un distribuidor"));
                            %><br /> <span id="txtBanco" class="ocultar">Elije una Opción</span>
                        </td>



                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br /></td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4" align="left"><input name="btnLstTOC"
                                                            type="submit" id="btnLstTOC" value="Cambiar"
                                                            onclick="javascript:return valida(this.form);"></td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br /></td>
                    </tr>
                </table>
            </form>
        </div>


    </body>
</html>