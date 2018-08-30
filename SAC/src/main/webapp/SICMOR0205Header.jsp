<%
/*###############################################################################
# Nombre del Programa :  SICMOR0205Header.jsp                                   #
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
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-08-2253-12                Fecha: 13/02/2013          #
# Modificación        :  Adicionar indicadores ABM a Reporte de log certificado #
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

<%
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
   }
   HTML inputText;
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
        var showTextCuentaORef = false;

        /********** Inicio Modificacion WELLCOM N-08-2253-12  **********/
        function validas(form1, accion)
        {
            if (accion == 0)
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
                    } else if (showTextCuentaORef)
                    {
                        span = document.getElementById('textCuentaORef');
                        span.style.display = 'none';
                        showTextCuentaORef = false;
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
                    } else if ((document.frmTOCHeader.cuenta.value == "" || document.frmTOCHeader.cuenta.value == null) && (document.frmTOCHeader.referencia.value == "" || document.frmTOCHeader.referencia.value == null))
                    {
                        span = document.getElementById('textCuentaORef');
                        span.style.display = 'inline';
                        showTextCuentaORef = true;
                        return false;
                    } else
                    {
                        sendDatas205('txtfStartDate', 'txtfEndDate', 'cuenta', 'comercio', 'referencia', 'tablePaint205', 'tableResult', '0');
                        ventana(window.open('please.jsp', '', 'left=250,top=300,width=600,height=100,directories=0,location=0,menubar=0,resizable=1,scrollbars=1,status=0,titlebar=0,toolbar=0'));
                        return true;
                    }

                } catch (e)
                {

                }
            }
            if (accion == 1 || accion == 2)
            {
                sendDatas205('txtfStartDate', 'txtfEndDate', 'cuenta', 'comercio', 'referencia', 'tablePaint205', 'tableResult', accion);
                ventana(window.open('please.jsp', '', 'left=250,top=300,width=600,height=100,directories=0,location=0,menubar=0,resizable=1,scrollbars=1,status=0,titlebar=0,toolbar=0'));
                return true;
            }
        }
        /********** Fin    Modificacion WELLCOM N-08-2253-12  **********/


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
                } else if (showTextCuentaORef)
                {
                    span = document.getElementById('textCuentaORef');
                    span.style.display = 'none';
                    showTextCuentaORef = false;
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
                } else if ((document.frmTOCHeader.cuenta.value == "" || document.frmTOCHeader.cuenta.value == null) && (document.frmTOCHeader.referencia.value == "" || document.frmTOCHeader.referencia.value == null))
                {
                    span = document.getElementById('textCuentaORef');
                    span.style.display = 'inline';
                    showTextCuentaORef = true;
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
            <form action="ControllerServletMonitoreo?action=SICMOR0205Main" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación -->
                <table width="100%" border="0" cellspacing="0" id="tabla">
                    <tr>
                        <th id = "tituloTab" width="100%" colspan="5" align="left" ><font color="#000000">SICMOR0205 - LOG Autorizaciones<br></font></th>
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
                        <td>&nbsp;</td>
                        <td align="left"><strong>Cuenta:</strong></td>
                        <td align="left">
                            <%
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputText( "cuenta", 20,20 ) );
                            %><br/>
                        </td>
                        <td align="left"><strong>Comercio (Opcional):</strong></td>
                        <td align="left">
                            <%
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputText( "comercio", 20,20 ) );
                            %><br/>
                        </td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Referencia:</strong></td>
                        <td align="left">
                            <%
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputText( "referencia", 23,23 ) );
                            %><br/>
                            <span id = "textCuentaORef" class="ocultar">Escriba una cuenta o una referencia</span>
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
                            <!-- Inicio Modificacion WELLCOM N-08-2253-12  -->
                            <input name="btnLstTOC" type="button" id="btnLstTOC" value="Mostrar Consulta" onclick="javascript:return validas(this.form, 0);">
                            <!-- Fin    Modificacion WELLCOM N-08-2253-12 -->
                        </td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>
                    </tr>

                </table>
                <!-- Inicio Modificacion WELLCOM N-08-2253-12-->
                <div id="tableResult">
                    <% 
                     String bandera=(String)session.getAttribute("mostrarTabla");
                      if(bandera!=null&&bandera.equals("true")){ 
                       session.setAttribute("mostrarTabla","false");
                      //String table= (String)session.getAttribute("tabla0100" );
                              Table tab=(Table)session.getAttribute("tablaCons");
                              out.println(tab.createTable(205));
                              out.println("&nbsp;&nbsp;<a onclick=\"javascript:return valida(this.form,2);\" >Anterior</a>");
                      out.println("&nbsp;&nbsp;<a onclick=\"javascript:return valida(this.form,1);\">Siguientes</a>");
                            } %>
               	</div>
                <!-- Fin    Modificacion WELLCOM N-08-2253-12-->
            </form>
        </div>
        <iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="scripts/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
        </iframe>
    </body>
</html>
