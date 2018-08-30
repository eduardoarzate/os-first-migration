<%
/*###############################################################################
# Nombre del Programa :  SICMOFB100Header.jsp                                   #
# Autor               :  JOSE ANDRES CASTILLO MORENO                            #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-08-299-04                 	   FECHA:06/09/2010     #
# Descripcion General :										                    #
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :						                                    #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :														    #
#------------------------------------------------------------------------------#
# Autor               :  Daniel Ramírez Torres                                 #
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
<%ArrayList cbBancoAdqValues;
        ArrayList cbBancoEmisorValues;
        ArrayList cbNoTransacValues;
        ArrayList cbFuenteValues;
        ArrayList cbMeses;
        ArrayList cbYears;
        HTML comboBox;
        HTML inputText;
               /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
        ComboBoxGen myComboBox;%>
<%
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
   }
   myComboBox = new ComboBoxGen();
     /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
   cbBancoAdqValues = myComboBox.getBancoAdqDol(session);
   cbBancoEmisorValues = myComboBox.getBancosEmisHijos(session);
   cbNoTransacValues = myComboBox.getGrupoTrxs(session);
   cbFuenteValues = myComboBox.getArchivoFuente(session);
   cbMeses=myComboBox.getMeses(session);
   cbYears=myComboBox.getYears(session);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>SAC 2</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css">

        <script type="text/javascript">
            var span = null;
            // var ventana = null;
            var showTextInitDate = false;
            var showTextNoCuenta = false;
            var numPage = 0;
            function valida(form1, accion)
            {
                if (accion == 0) {
                    try
                    {
                        /*if(showTextInitDate)
                         {
                         span = document.getElementById("txtInitDate");
                         span.style.display = 'none';
                         showTextInitDate = false;
                         }
                         else */
                        if (showTextNoCuenta)
                        {
                            span = document.getElementById("txtNoCuenta");
                            span.style.display = 'none';
                            showTextNoCuenta = false;
                        }

                        /*if(document.frmTOCHeader.mes.value == "None" || document.frmTOCHeader.year.value == "None")
                         {
                         span = document.getElementById("txtInitDate");
                         span.style.display = 'inline';
                         showTextInitDate = true;
                         return false;
                         }
                         
                         else*/
                        if ((document.frmTOCHeader.NoCuenta.value == "" ||
                                document.frmTOCHeader.NoCuenta.value == null ||
                                (document.frmTOCHeader.NoCuenta.value.length != 15 && document.frmTOCHeader.NoCuenta.value.length != 16))

                                &&
                                (document.frmTOCHeader.NoRef.value == "" ||
                                        document.frmTOCHeader.NoRef.value == null ||
                                        document.frmTOCHeader.NoRef.value.length != 23)
                                )
                        {
                            span = document.getElementById('txtNoCuenta');
                            span.style.display = 'inline';
                            showTextNoCuenta = true;
                            return false;
                        } else
                        {
                            sendMoreDatas('mes', 'year', 'bancoAdq', 'bancoEmi', 'NoTrans', 'Fuente', 'importe',
                                    'NoCuenta', 'NoAuto', 'NoRef', 'NoComer', 'NomComer', 'GiroComer', 'tablePaintB100', 'tableResult', '0');
                            ventana(window.open('please.jsp', '', 'left=250,top=300,width=600,height=100,directories=0,location=0,menubar=0,resizable=1,scrollbars=1,status=0,titlebar=0,toolbar=0'));
                            return true;
                        }
                    } catch (e)
                    {

                    }
                }
                if (accion == 1 || accion == 2) {
                    sendMoreDatas('mes', 'year', 'bancoAdq', 'bancoEmi', 'NoTrans', 'Fuente', 'importe',
                            'NoCuenta', 'NoAuto', 'NoRef', 'NoComer', 'NomComer', 'GiroComer', 'tablePaintB100', 'tableResult', accion);
                    ventana(window.open('please.jsp', '', 'left=250,top=300,width=600,height=100,directories=0,location=0,menubar=0,resizable=1,scrollbars=1,status=0,titlebar=0,toolbar=0'));
                    return true;
                }
            }
        </script>
    </head>

    <body>

        <div align="center">
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación -->
            <form action="ControllerServletAdquirente?action=SICMOFB100Main" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación -->
                <table width="100%" border="0" cellspacing="0" id="tabla">
                    <tr>
                        <th id="tituloTab" colspan=5 align="left" ><font color="#000000">SICMOFB100 - Consulta de Transacciones Aceptadas</font></th>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Fecha:</strong></td>
                        <td align="left" id="initDate">	
                            <% comboBox = new HTML();
                              out.println( "" + comboBox.getComboBox( "mes", cbMeses, "Mes" ) );
                              out.println( "" + comboBox.getComboBox( "year", cbYears, " Año" ) );
                            %><br/>
                            <span id = "txtInitDate" class="ocultar">Selecciona una fecha</span>
                        </td>
                        <td align="left"><strong>Banco Adquirente:</strong></td>
                        <td align="left" id="comboBoxBancoAdq">
                            <% comboBox = new HTML();
       out.println( "" + comboBox.getComboBox( "bancoAdq", cbBancoAdqValues, "Selecciona un Banco Adquiriente" ) );
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Banco Emisor:</strong></td>
                        <td align="left" id="comboBoxBancoEmi">
                            <% comboBox = new HTML();
       out.println( "" + comboBox.getComboBox( "bancoEmi", cbBancoEmisorValues, "Selecciona un Banco Emisor" ) );
                            %>
                        </td>
                        <td align="left"><strong>Tipo de Transacci&oacute;n:</strong></td>
                        <td align="left" id="comboBoxNoTrans">
                            <% comboBox = new HTML();
       out.println( "" + comboBox.getComboBox( "NoTrans", cbNoTransacValues, "Selecciona un No. De Transacción" ) );
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Fuente:</strong></td>
                        <td align="left" id="comboBoxFuente">
                            <% comboBox = new HTML();
       out.println( "" + comboBox.getComboBox( "Fuente", cbFuenteValues, "Selecciona un No. De Fuente" ) );
                            %>
                        </td>
                        <td align="left"><strong>Importe:</strong></td>
                        <td align="left" id="inputTextImporte">
                            <% inputText = new HTML();
       out.println( "" + inputText.getinputText("importe",20,20));
                            %><br/>	                       
                        </td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>No. de Cuenta:</strong></td>
                        <td align="left" id="inputtextNoCuenta">
                            <% inputText = new HTML();
       out.println( "" + inputText.getinputText("NoCuenta",16,19));
                            %><br/>
                            <span id = "txtNoCuenta" class="ocultar">No de Cuenta o Prefijo* Inválidos </span>
                        </td>
                        <td align="left"><strong>No. de Autorizaci&oacute;n:</strong></td>
                        <td align="left" id="inputtextNoAuto">
                            <% inputText = new HTML();
       out.println( "" + inputText.getinputText("NoAuto",20,20));
                            %>
                        </td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>No. de Referencia:</strong></td>
                        <td align="left" id="inputtextNoRef">
                            <% 
                               inputText = new HTML();
       out.println( "" + inputText.getinputText("NoRef",23,25));
                            %>
                        </td>
                        <td align="left"><strong>No. de Comercio:</strong></td>
                        <td align="left" id="inputtextNoComer">
                            <% 
                               inputText = new HTML();
       out.println( "" + inputText.getinputText("NoComer",20,20));
                            %><br/>
                        </td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Nombre del Comercio:</strong></td>
                        <td align="left" id="inputtextNomComer">
                            <% 
                                    inputText = new HTML();
        out.println( "" + inputText.getinputText("NomComer",20,20));
                            %>
                        </td>
                    </tr>  									
                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4" align="left">
                            <input name="btnLstTOC" type="button" id="btnLstTOC" value="Mostrar Consulta" onclick="javascript:return valida(this.form, 0);">
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>
                    </tr>
                </table>
                <br/><br/>
               	<div id="tableResult">
                    <% 
                     String bandera=(String)session.getAttribute("mostrarTabla");
                      if(bandera!=null&&bandera.equals("true")){ 
                       session.setAttribute("mostrarTabla","false");
                      //String table= (String)session.getAttribute("tablaB100" );
                              Table tab=(Table)session.getAttribute("tablaCons");
                              out.println(tab.createTable(101));
                              out.println("&nbsp;&nbsp;<a onclick=\"javascript:return valida(this.form,2);\" >Anterior</a>");
                      out.println("&nbsp;&nbsp;<a onclick=\"javascript:return valida(this.form,1);\">Siguientes</a>");
                            } %>
               	</div>
            </form>
        </div>
        <iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="scripts/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
        </iframe>
    </body>
</html>
