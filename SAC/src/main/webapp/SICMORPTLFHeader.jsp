<%
/*###############################################################################
# Nombre del Programa :  SICMORPTLFHeader.jsp                                   #
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
# Proyecto/Procliente :  N-04-2207-13                Fecha: 24/02/2014          #
# Modificación        :  Adicionar funcionalidad de Afiliacion					#
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

<%ArrayList cbBANCO;
        HTML comboBox;
        ArrayList cbMeses;
        ArrayList cbYears;	
        /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
        ComboBoxGen myComboBox;%>

<%
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
   }
   HTML inputText;
   HTML comboText;
   
   myComboBox = new ComboBoxGen();
   /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */  
   cbBANCO = myComboBox.getBancoAdqFiid(session);
   cbMeses=myComboBox.getMeses(session);
   cbYears=myComboBox.getYears(session);
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
        var vercuenta = false;
        var verafiliacion = false;
        var verbanco = false;
        /*Inicia cambio WELLCOM N-04-2207-13 29/11/2013 */
        function validas(form1, accion)
        {
            if (accion == 0)
            {
                /*Fin cambio WELLCOM N-04-2207-13 29/11/2013 */
                try
                {
                    if (showTextInitDate)
                    {
                        span = document.getElementById("txtInitDate");
                        span.style.display = 'none';
                        showTextInitDate = false;
                    } else if (vercuenta)
                    {
                        span = document.getElementById('spamcuenta');
                        span.style.display = 'none';
                        vercuenta = false;
                    }
                    /*Inicia cambio WELLCOM N-04-2207-13 24/02/2014 
                     else if(verafiliacion)
                     {
                     span = document.getElementById('spamafiliacion');
                     span.style.display = 'none';
                     verafiliacion = false;
                     }
                     Fin cambio WELLCOM N-04-2207-13 24/02/2014 */
                    else if (verbanco)
                    {
                        span = document.getElementById('spambanco');
                        span.style.display = 'none';
                        verbanco = false;
                    }

                    if (document.frmTOCHeader.mes.value == "None" || document.frmTOCHeader.year.value == "None")
                    {
                        span = document.getElementById("txtInitDate");
                        span.style.display = 'inline';
                        showTextInitDate = true;
                        return false;
                    } else if ((document.frmTOCHeader.cuenta.value == "" || document.frmTOCHeader.cuenta.value == null) || (document.frmTOCHeader.cuenta.value == 'None'))
                    {
                        span = document.getElementById('spamcuenta');
                        span.style.display = 'inline';
                        vercuenta = true;
                        return false;
                    } else if ((document.frmTOCHeader.banco.value == "" || document.frmTOCHeader.banco.value == null) || (document.frmTOCHeader.banco.value == 'None'))
                    {
                        span = document.getElementById('spambanco');
                        span.style.display = 'inline';
                        verbanco = true;
                        return false;
                    }
                    /*Inicio cambio WELLCOM N-04-2207-13 24/02/2014
                     else if((document.frmTOCHeader.afiliacion.value == "" || document.frmTOCHeader.afiliacion.value == null))
                     {
                     span = document.getElementById('spamafiliacion');
                     span.style.display = 'inline';
                     verafiliacion = true;
                     return false;
                     }
                     Fin cambio WELLCOM N-04-2207-13 24/02/2014 */
                    else
                    {
                        /*Inicia cambio WELLCOM N-04-2207-13 29/11/2013 */
                        sendDatasPTLF('mes', 'year', 'afiliacion', 'cuenta', 'banco', 'tablePaintPTLF', 'tableResult', '0');
                        ventana(window.open('please.jsp', '', 'left=250,top=300,width=600,height=100,directories=0,location=0,menubar=0,resizable=1,scrollbars=1,status=0,titlebar=0,toolbar=0'));
                        return true;
                    }

                } catch (e)
                {

                }
            }
            if (accion == 1 || accion == 2)
            {
                sendDatasPTLF('mes', 'year', 'afiliacion', 'cuenta', 'banco', 'tablePaintPTLF', 'tableResult', accion);
                ventana(window.open('please.jsp', '', 'left=250,top=300,width=600,height=100,directories=0,location=0,menubar=0,resizable=1,scrollbars=1,status=0,titlebar=0,toolbar=0'));
                return true;
            }
        }

        function valida()
        {
            try
            {
                if (showTextInitDate)
                {
                    span = document.getElementById("txtInitDate");
                    span.style.display = 'none';
                    showTextInitDate = false;
                } else if (vercuenta)
                {
                    span = document.getElementById('spamcuenta');
                    span.style.display = 'none';
                    vercuenta = false;
                } else if (verafiliacion)
                {
                    span = document.getElementById('spamafiliacion');
                    span.style.display = 'none';
                    verafiliacion = false;
                } else if (verbanco)
                {
                    span = document.getElementById('spambanco');
                    span.style.display = 'none';
                    verbanco = false;
                }

                if (document.frmTOCHeader.mes.value == "None" || document.frmTOCHeader.year.value == "None")
                {
                    span = document.getElementById("txtInitDate");
                    span.style.display = 'inline';
                    showTextInitDate = true;
                    return false;
                } else if ((document.frmTOCHeader.cuenta.value == "" || document.frmTOCHeader.cuenta.value == null) || (document.frmTOCHeader.cuenta.value == 'None'))
                {
                    span = document.getElementById('spamcuenta');
                    span.style.display = 'inline';
                    vercuenta = true;
                    return false;
                } else if ((document.frmTOCHeader.banco.value == "" || document.frmTOCHeader.banco.value == null) || (document.frmTOCHeader.banco.value == 'None'))
                {
                    span = document.getElementById('spambanco');
                    span.style.display = 'inline';
                    verbanco = true;
                    return false;
                } else if ((document.frmTOCHeader.afiliacion.value == "" || document.frmTOCHeader.afiliacion.value == null))
                {
                    span = document.getElementById('spamafiliacion');
                    span.style.display = 'inline';
                    verafiliacion = true;
                    return false;
                } else
                {
                    /*Fin cambio WELLCOM N-04-2207-13 29/11/2013 */
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
            <form action="ControllerServletMonitoreo?action=SICMORPTLFMain" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación -->
                <table width="100%" border="0" cellspacing="0" id="tabla">
                    <tr>
                        <th id="tituloTab" width="100%" colspan="5" align="left" ><font color="#000000">SICMORPTLF - LOG Adquirente<br></font></th>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Fecha:</strong></td>
                        <td align="left">
                            <% comboBox = new HTML();
                               out.println( "" + comboBox.getComboBox( "mes", cbMeses, "Mes" ) );
                               out.println( "" + comboBox.getComboBox( "year", cbYears, " Año" ) );
                            %><br/>
                            <span id = "txtInitDate" class="ocultar">Selecciona una fecha</span>
                        </td>
                        <td align="left"><strong>Afiliaci&oacute;n:</strong></td>
                        <td align="left">
                            <%
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputText( "afiliacion", 15,15 ) );
                            %><br/><span id = "spamafiliacion1" class="ocultar">Selecciona una afiliacion</span>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Cuenta:</strong></td>
                        <td align="left">
                            <%
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputText( "cuenta", 16,20 ) );
                            %><br/><span id = "spamcuenta" class="ocultar">Selecciona una cuenta</span>
                        </td>
                        <td align="left"><strong>Fiid Adquirente:</strong><br></td>
                        <td align="left">
                            <%
                                    comboBox = new HTML();
                                    out.println( "" + comboBox.getListBox( "banco", cbBANCO,"Seleccione una opcion" ) );
                            %><br/>
                            <span id = "spambanco" class="ocultar">Seleccionar una Fiid</span>
                        </td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>

                    </tr>


                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4" align="left">
                            <input name="btnLstTOC" type="submit" id="btnLstTOC" value="Mostrar Reporte" onclick="javascript:return valida(this.form);">
                            <!-- Inicia cambio WELLCOM N-04-2207-13 29/11/2013 -->                          
                            <input name="btnLstTOC" type="button" id="btnLstTOC" value="Mostrar Consulta" onclick="javascript:return validas(this.form, 0);">
                            <!-- Fin cambio WELLCOM N-04-2207-13 29/11/2013 -->
                        </td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>
                    </tr>

                </table>
                <!-- Inicia cambio WELLCOM N-04-2207-13 29/11/2013 -->
                <div id="tableResult">
                    <% 
                     String bandera=(String)session.getAttribute("mostrarTabla");
                      if(bandera!=null&&bandera.equals("true")){ 
                       session.setAttribute("mostrarTabla","false");
                      //String table= (String)session.getAttribute("tabla0100" );
                              Table tab=(Table)session.getAttribute("tablaCons");
                              out.println(tab.createTable(10));
                              out.println("&nbsp;&nbsp;<a onclick=\"javascript:return valida(this.form,2);\" >Anterior</a>");
                      out.println("&nbsp;&nbsp;<a onclick=\"javascript:return valida(this.form,1);\">Siguientes</a>");
                            } %>
               	</div>
                <!-- Fin cambio WELLCOM N-04-2207-13 29/11/2013 -->
            </form>
        </div>
        <iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="scripts/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
        </iframe>
    </body>
</html>
