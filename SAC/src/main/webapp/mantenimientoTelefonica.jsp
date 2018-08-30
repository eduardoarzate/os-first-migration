<%
/*###############################################################################
# Nombre del Programa :  mantenimientoTelefonica.jsp	     					#
# Autor               :  Juan Antonio Guzman Gomez                              #
# Compania            :  SAS S.A. DE C.V.                                  		#
# Proyecto/Procliente :  Z-02-2675-12                 	   FECHA:28/02/2013     #
# Descripcion General :															#
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :															#
#                                                                               #
#                                                                               #
# Dias de ejecucion   :															#
#################################################################################
#-----------------------------------------------------------------------------  #
# Autor               :  Daniel Ramírez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-------------------------------------------------------------------------------#
# Numero de Parametros: 1                                                       #
###############################################################################*/
%>


<%@page import="com.sun.xml.rpc.processor.modeler.j2ee.xml.string"%>
<%@ page import="com.wellcom.prosa.sacii.mnto.DaoMntoTelefonica"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wellcom.io.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%
	
        HTML comboBox;
        //ArrayList cbTipoLiq; 
        /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
        //ComboBox myComboBox;
        /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
%>
<%
    if(!ga.AccessGranted(session, "grantAccess"))
    {
        response.sendRedirect("login.jsp");
    }
   
   
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>SAC 2</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css">
    </head>

    <script type="text/javascript">



        function cargaDatos() {


            var temp = '<%= session.getAttribute( "claveTelefonica" ) %>';
            var txtclaveTelefonica = document.getElementById("claveTelefonica");
            txtclaveTelefonica.value = temp;


            temp = '<%= session.getAttribute( "nombreTelefonica" ) %>';
            var txtnombreTelefonica = document.getElementById("nombreTelefonica");
            txtnombreTelefonica.value = temp;


            temp = '<%= session.getAttribute( "vtc_tasa_com_int_cre" ) %>';
            var txtvtc_tasa_com_int_cre = document.getElementById("vtc_tasa_com_int_cre");
            txtvtc_tasa_com_int_cre.value = temp;



            temp = '<%= session.getAttribute( "vtc_tasa_com_adq_cre" ) %>';
            var txtvtc_tasa_com_adq_cre = document.getElementById("vtc_tasa_com_adq_cre");
            txtvtc_tasa_com_adq_cre.value = temp;


            temp = '<%= session.getAttribute( "vtc_tasa_com_com_cre" ) %>';
            var txtvtc_tasa_com_com_cre = document.getElementById("vtc_tasa_com_com_cre");
            txtvtc_tasa_com_com_cre.value = temp;


            temp = '<%= session.getAttribute( "vtc_tasa_com_int_deb" ) %>';
            var txtvtc_tasa_com_int_deb = document.getElementById("vtc_tasa_com_int_deb");
            txtvtc_tasa_com_int_deb.value = temp;



            temp = '<%= session.getAttribute( "vtc_tasa_com_adq_deb" ) %>';
            var txtvtc_tasa_com_adq_deb = document.getElementById("vtc_tasa_com_adq_deb");
            txtvtc_tasa_com_adq_deb.value = temp;


            temp = '<%= session.getAttribute( "vtc_tasa_com_com_deb" ) %>';
            var txtvtc_tasa_com_com_deb = document.getElementById("vtc_tasa_com_com_deb");
            txtvtc_tasa_com_com_deb.value = temp;



            temp = '<%= session.getAttribute( "vtc_tasa_com_int_efe" ) %>';
            var txtvtc_tasa_com_int_efe = document.getElementById("vtc_tasa_com_int_efe");
            txtvtc_tasa_com_int_efe.value = temp;



            temp = '<%= session.getAttribute( "vtc_tasa_com_adq_efe" ) %>';
            var txtvtc_tasa_com_adq_efe = document.getElementById("vtc_tasa_com_adq_efe");
            txtvtc_tasa_com_adq_efe.value = temp;



            temp = '<%= session.getAttribute( "vtc_tasa_com_com_efe" ) %>';
            var txtvtc_tasa_com_com_efe = document.getElementById("vtc_tasa_com_com_efe");
            txtvtc_tasa_com_com_efe.value = temp;



            temp = '<%= session.getAttribute( "vtc_tasa_iva" ) %>';
            var txtvtc_tasa_iva = document.getElementById("vtc_tasa_iva");
            txtvtc_tasa_iva.value = temp;



            temp = '<%= session.getAttribute( "estatus" ) %>';
            var cboestatus = document.getElementById("cbo_estatus");
            if (temp == 'A')
            {

                cboestatus.selectedIndex = 0;
            } else
            {
                cboestatus.selectedIndex = 1;
            }


            temp = '<%= session.getAttribute( "guardado" ) %>';
            if (temp == 'ok')
            {
                alert("Guardado Exitoso");
            }


        }
        window.onload = cargaDatos;

    </script>

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
                return true;
            } catch (e)
            {
                return false;
            }

        }
    </script>


    <body>
        <div align="center">
             <!--Modificacion: SAS-DRT F-52-8063-16 Marca de Inicio-->
            <form action="ControllerServletHerr?action=guardadoMantTelef" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
             <!--Modificacion: SAS-DRT F-52-8063-16 Marca de FIN-->
                <table width="100%" border="0" cellspacing="0" id="tabla">
                    <tr>
                        <th id="tituloTab" width="100%" colspan="5" align="left" ><font color="#000000">Mantenimiento parametros telefonica</font></th>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>
                    </tr>



                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>
                    </tr>

                    <tr style=" height : 22px;">
                        <td>&nbsp;</td>
                        <td align="left"><strong>Nombre Telefonica :</strong></td>
                        <td align="left">
                            <input name="nombreTelefonica" type="text" id="nombreTelefonica" size="15"  readonly maxlength="15" >

                        </td>

                        <td align="left"><strong>Clave Telefonica :</strong></td>
                        <td align="left">
                            <input name="claveTelefonica" type="text" id="claveTelefonica" size="15"  readonly maxlength="15" >

                        </td>
                    </tr>


                    <tr style=" height : 22px;">
                        <td>&nbsp;</td>

                        <td align="left"><strong>tasa comision intercambio credito :</strong></td>
                        <td align="left">
                            <input name="vtc_tasa_com_int_cre" type="text" id="vtc_tasa_com_int_cre" size="15"  maxlength="15" >

                        </td>
                    </tr>

                    <tr style=" height : 22px;">
                        <td>&nbsp;</td>
                        <td align="left"><strong>tasa comision adquiriente credito :</strong></td>
                        <td align="left">
                            <input name="vtc_tasa_com_adq_cre" type="text" id="vtc_tasa_com_adq_cre" size="15"  maxlength="15" >

                        </td>
                    </tr>

                    <tr style=" height : 22px;">
                        <td>&nbsp;</td>
                        <td align="left"><strong>tasa comision comercio credito :</strong></td>
                        <td align="left">
                            <input name="vtc_tasa_com_com_cre" type="text" id="vtc_tasa_com_com_cre" size="15"  maxlength="15" >

                        </td>
                    </tr>


                    <tr style=" height : 22px;">
                        <td>&nbsp;</td>
                        <td align="left"><strong>tasa comision intercambio debito :</strong></td>
                        <td align="left">
                            <input name="vtc_tasa_com_int_deb" type="text" id="vtc_tasa_com_int_deb" size="15"  maxlength="15" >

                        </td>
                    </tr>



                    <tr style=" height : 22px;">
                        <td>&nbsp;</td>
                        <td align="left"><strong>tasa comision adquiriente debito :</strong></td>
                        <td align="left">
                            <input name="vtc_tasa_com_adq_deb" type="text" id="vtc_tasa_com_adq_deb" size="15"  maxlength="15" >

                        </td>
                    </tr>



                    <tr style=" height : 22px;">
                        <td>&nbsp;</td>
                        <td align="left"><strong>tasa comision comercio debito :</strong></td>
                        <td align="left">
                            <input name="vtc_tasa_com_com_deb" type="text" id="vtc_tasa_com_com_deb" size="15"  maxlength="15" >

                        </td>
                    </tr>


                    <tr style=" height : 22px;">
                        <td>&nbsp;</td>
                        <td align="left"><strong>tasa comision intercambio efectivo :</strong></td>
                        <td align="left">
                            <input name="vtc_tasa_com_int_efe" type="text" id="vtc_tasa_com_int_efe" size="15"  maxlength="15" >

                        </td>
                    </tr>

                    <tr style=" height : 22px;">
                        <td>&nbsp;</td>
                        <td align="left"><strong>tasa comision adquiriente efectivo :</strong></td>
                        <td align="left">
                            <input name="vtc_tasa_com_adq_efe" type="text" id="vtc_tasa_com_adq_efe" size="15"  maxlength="15" >

                        </td>
                    </tr>


                    <tr style=" height : 22px;">
                        <td>&nbsp;</td>
                        <td align="left"><strong>tasa comision comercio efectivo :</strong></td>
                        <td align="left">
                            <input name="vtc_tasa_com_com_efe" type="text" id="vtc_tasa_com_com_efe" size="15"  maxlength="15" >

                        </td>
                    </tr>


                    <tr style=" height : 22px;">
                        <td>&nbsp;</td>
                        <td align="left"><strong>tasa iva  :</strong></td>
                        <td align="left">
                            <input name="vtc_tasa_iva" type="text" id="vtc_tasa_iva" size="15"  maxlength="15" >

                        </td>
                    </tr>


                    <tr style=" height : 22px;">
                        <td>&nbsp;</td>
                        <td align="left"><strong>Estatus  :</strong></td>
                        <td align="left">
                            <select name="cbo_estatus" id="cbo_estatus" >
                                <option value="0">A. Activo</option>
                                <option value="1">B. Baja</option>
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
                            <input name="btnLstTOC" type="submit" id="btnLstTOC" value="Modificar parametros" onclick="javascript:return valida(this.form);
                                    window.close()">
                        </td>

                        <td colspan="4" align="left">

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
