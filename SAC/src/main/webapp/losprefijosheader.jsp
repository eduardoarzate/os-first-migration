<%
/*###############################################################################
# Nombre del Programa :  losprefijosheader.jsp                                  #
# Autor               :  JOAQUIN MOJICA Q.                                      #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-02-1202-09                  	   FECHA:08/02/2010     #
# Descripcion General :	 AUTOMATIZACION DE PREPAGO								#
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :						                                    #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :														    #
#-------------------------------------------------------------------------------#
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 01/03/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<%@ page import="com.wellcom.io.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>

<%
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
   }
%>
<%
        ArrayList cbFIID;
        ArrayList cbRESULTADOS;
        HTML comboBox;
        HTML inputText;
        /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
        ComboBoxGen myComboBox;
        /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
%>

<%
    if(!ga.AccessGranted(session, "grantAccess"))
    {
        response.sendRedirect("login.jsp");
    }
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
    myComboBox = new ComboBoxGen();
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
    cbFIID = myComboBox.getPrefijoPRE(session);
    cbRESULTADOS = myComboBox.getPrefijoPRE(session);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Untitled Document</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css">
    </head> 
    <body>
        <div align="center">
            <!--Modificacion: SAS-DRT F-52-8063-16 Marca de inicio-->
            <form action="ControllerServletHerr?action=losprefijosmain" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
                <!--Modificacion: SAS-DRT F-52-8063-16 Marca de fin-->
                <table width="100%" border="0" cellspacing="0" class="tbl_border" class="tbl_border" >
                    <tr>
                        <th class= "td_header" width="100%" colspan=4 >PREFIJOS</th>
                    </tr>

                    <tr>
                        <td><div align="right">FIID:</div></td>
                        <td><%
                                                                comboBox = new HTML();
                                        out.println( "" + comboBox.getListBox( "fiid", cbFIID , "onchange", "javascript:sendData('fiid','cargaresultado','resultado');", "Selecciona una FIID" ));
                            %><br/></td>
                        <td><div align="right">Prefijo:</div></td>
                        <td colspan="4" id="resultado"><br/><select name="resultado"  id="resultado" >
                                <option selected="selected" value="None">Valores de la FIID</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td colspan="4"><div align="center">
                                <input name="btnLstTOC" type="submit" id="btnLstTOC" value="OK">
                                &nbsp;
                                <input name="btnErase" type="reset" id="btnErase" value="Borrar">
                                &nbsp;                                
                            </div></td>
                    </tr>
                </table>
            </form>
            <!--Modificacion: SAS-DRT F-52-8063-16 Marca de inicio-->            
            <form action="ControllerServletHerr?action=inserta" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
                <!--Modificacion: SAS-DRT F-52-8063-16 Marca de fin-->            
                <input name="btnIn" type="submit" id="btnInsrt" value="Agregar">
            </form>
        </div>
        <iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="scripts/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
    </body>
</html>
