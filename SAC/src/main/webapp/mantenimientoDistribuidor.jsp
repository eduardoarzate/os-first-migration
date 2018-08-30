<%
/*###############################################################################
# Nombre del Programa :  mantenimientoDistribuidor.jsp  								#
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


<%@page import="com.sun.xml.rpc.processor.modeler.j2ee.xml.string"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wellcom.io.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%
	
        HTML comboBox;
        //ArrayList cbTipoLiq; 
        /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
       // ComboBox myComboBox;
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


            var temp = '<%= session.getAttribute( "claveDistribuidor" ) %>';
            var txtclaveTelefonica = document.getElementById("claveDistribuidor");
            txtclaveTelefonica.value = temp;


            temp = '<%= session.getAttribute( "nombreDistribuidor" ) %>';
            var txtnombreTelefonica = document.getElementById("nombreDistribuidor");
            txtnombreTelefonica.value = temp;






            temp = '<%= session.getAttribute( "vtc_imp_tarifa" ) %>';
            txtvtc_imp_tarifa = document.getElementById("vtc_imp_tarifa");
            txtvtc_imp_tarifa.value = temp;


            var temp = '<%= session.getAttribute( "vtc_ent_numero" ) %>';
            var txtvtc_ent_numero = document.getElementById("vtc_ent_numero");
            txtvtc_ent_numero.value = temp;





            temp = '<%= session.getAttribute( "vtc_estatus" ) %>';
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
            <form action="ControllerServletHerr?action=guardadoMantDistri" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
             <!--Modificacion: SAS-DRT F-52-8063-16 Marca de FIN-->
                <table width="100%" border="0" cellspacing="0" id="tabla">
                    <tr>
                        <th id="tituloTab" width="100%" colspan="5" align="left" ><font color="#000000">Mantenimiento parametros Distribuidor</font></th>
                    </tr>

                    <tr style=" height : 22px;">
                        <td>&nbsp;</td>
                        <td align="left"><strong>Nombre Distribuidor :</strong></td>
                        <td align="left">
                            <input name="nombreDistribuidor" type="text" id="nombreDistribuidor" size="15"  readonly maxlength="15" >

                        </td>

                        <td align="left"><strong>Clave Distribuidor :</strong></td>
                        <td align="left">
                            <input name="claveDistribuidor" type="text" id="claveDistribuidor" size="15"  readonly maxlength="15" >

                        </td>
                    </tr>



                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>
                    </tr>


                    <tr style=" height : 22px;">
                        <td>&nbsp;</td>
                        <td align="left"><strong>Impuesto Tarifa :</strong></td>
                        <td align="left">
                            <input name="vtc_imp_tarifa" type="text" id="vtc_imp_tarifa" size="15"  maxlength="15" >

                        </td>
                    </tr>

                    <tr style=" height : 22px;">
                        <td>&nbsp;</td>
                        <td align="left"><strong>Numero Entidad :</strong></td>
                        <td align="left">
                            <input name="vtc_ent_numero" type="text" id="vtc_ent_numero" size="15"  maxlength="15" >

                        </td>
                    </tr>

                    <tr style=" height : 22px;">
                        <td>&nbsp;</td>
                        <td align="left"><strong>Estatus :</strong></td>
                        <!-- 
                        <td align="left">
                                <input name="vtc_estatus" type="text" id="vtc_estatus" size="15"  maxlength="15" >
                                
                        </td>
                        -->
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
                            <input name="btnLstTOC" type="submit" id="btnLstTOC" value="Modificar parametros" onclick="javascript:return valida(this.form);;window.close()">
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
