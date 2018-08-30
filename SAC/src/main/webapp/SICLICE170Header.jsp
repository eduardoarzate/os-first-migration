<%
/*
################################################################################
# Nombre              : SICLICE170Header.jsp                                   #
# Autor               : Ascencion Hernandez Huerta                             #
# Compania            : Axia Consultores, S.A. de C.V.                         #
# Proyecto/Procliente : P-60-2646-14                          FECHA:03/11/2015 #
# Descripcion General : Incorporacion d Consubanco Corresponsales con Chedraui #
# Modificacion        : Reporte Consolidado Corresponsales Emisor              #
# Programa Dependiente: N/A                                                    #
# Programa Subsecuente: N/A                                                    #
# Cond. de ejecucion  : Acceder al sistema                                     #
# Dias de ejecucion   : A Peticion del web, se pueden ejecutar n instancias    #
#------------------------------------------------------------------------------#
#                                MODIFICACIONES                                #
#------------------------------------------------------------------------------#
# Autor               : Francisco Javier Cuamatzi Cuamatzi                     #
# Compania            : Axia, consultores, S.A. DE C.V.                        #
# Proyecto/Procliente : P-60-2646-14                        Fecha: 12/04/2016  #
# Descripcion General : Incorporacion Consubanco a Corresponsales con Chedraui #
# Modificacion        : Incorporacion Consolidado de Entidades                 #
# Marca del Cambio    : AXIA-FJCC-P-60-2646-14                                 #
#------------------------------------------------------------------------------#
# Autor               :  Daniel Ramírez Torres                                 #
# Compania            :  SAS S.A. DE C.V.                                      #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017        #
# Modificacion        :  Mejora Conexiones  SAC2                               #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                  #    
#------------------------------------------------------------------------------#
# Numero de Parametros: 1                                                      #
# Parametros Entrada  : Order Date                         Formato:aaaammdd    #
# Parametros Salida   : N/A                                Formato:N/A         #
# Archivo    Entrada  : N/A                                Formato:N/A         #
# Arvhivo    Salida   : N/A                                Formato:N/A         #
################################################################################
*/
%>
<%@ page import="com.wellcom.io.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%ArrayList cbEmisor;
  ArrayList cbTransaccion;
  ArrayList cbLiquidacion;
  HTML comboBox;
  HTML inputText;
 /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
        ComboBoxGen myComboBox;
%>
<%
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
   }
   myComboBox = new ComboBoxGen();
   cbEmisor = myComboBox.getBancoEmiTodos(session);
   //cbEmisor = myComboBox.getBancosEmisHijos2(session);
   //cbFuente = myComboBox.getBancoIntEntHijas(session);
   //cbNatCon = myComboBox.getNaturalezaContable(session);
   //cbLiquidacion = myComboBox.getTipoLiq2_1(session);
    /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <link href="css/styles.css" rel="stylesheet" type="text/css">
        <title>SAC 2</title>

        <script type="text/javascript">
            var span = null;
            var showTextInitDate = false;
            var verEmisor = false;

            function valida() {
                try {
                    if (showTextInitDate) {
                        span = document.getElementById("txtInitDate");
                        span.style.display = 'none';
                        showTextInitDate = false;
                    } else if (verEmisor) {
                        span = document.getElementById('spamEmisor');
                        span.style.display = 'none';
                        verEmisor = false;
                    }
                    if (document.frmTOCHeader.txtfStartDate.value == "" || document.frmTOCHeader.txtfStartDate.value == null) {
                        span = document.getElementById("txtInitDate");
                        span.style.display = 'inline';
                        showTextInitDate = true;
                        return false;
                    } else if (document.frmTOCHeader.bancoEmi.value == "None") {
                        span = document.getElementById('spamEmisor');
                        span.style.display = 'inline';
                        verEmisor = true;
                        return false;
                    } else {
                        return true;
                    }
                } catch (e) {
                }
            }
        </script>
    </head>

    <body>
        <div align="center">
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación -->
            <form action="ControllerServletCompensacion?action=SICLICE170Main" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación -->
                <table width="100%" border="0" cellspacing="0" id="tabla">
                    <tr>
                        <th id="tituloTab" width="100%" colspan="5" align="left" ><font color="#000000">SICLICE170 - Reporte Consolidado Corresponsales Emisor</font>
                        </th>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Fecha Inicio:</strong>
                            <input name="txtfStartDate" type="text" id="txtfStartDate" size="15" readonly maxlength="15" value=<%=session.getAttribute("fechaHoy")%>>
                            <a href="javascript:void(0)" onclick="if (self.gfPop)
                                        gfPop.fPopCalendar(document.frmTOCHeader.txtfStartDate);
                                    return false;" hidefocus>
                                <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg" border="0" alt="">
                            </a><br/>
                            <span id = "txtInitDate" class="ocultar">Selecciona una fecha</span><%//agregar class%>
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
                        <td align="left"><strong>Banco Emisor:<br></strong></td>
                        <td align="left">
                            <%
                              comboBox = new HTML();
                              out.println( "" + comboBox.getListBox( "bancoEmi", cbEmisor, "onchange", "javascript:sendDatas('bancoEmi','txtfStartDate','corresponsal','comboBoxArchivo');","Seleciona Un Banco" ) );
                            %><br/>
                            <span id = "spamEmisor" class="ocultar">Elija una Opción</span>
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
