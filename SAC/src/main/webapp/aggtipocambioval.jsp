<%
/*###############################################################################
# Nombre del Programa :  delModGrpSacii.jsp                                     #
# Autor               :  JOAQUIN MOJICA Q.                                      #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-08-299-04                       FECHA:15/10/2008     #
# Descripcion General :                                                         #
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :                                                         #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :                                                         #
#################################################################################
#                               MODIFICACIONES                                  #
#-----------------------------------------------------------------------------  #
# Autor               :  Daniel Ramírez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 08/02/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!--Modificacion: SAS-DRT F-52-8063-16 Marca de inicio-->
<%/*@page import="com.wellcom.sql.Database"*/%>
<!--Modificacion: SAS-DRT F-52-8063-16 Marca de fin-->
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<!--Modificacion: SAS-DRT F-52-8063-16 Marca de inicio-->
<%@page import="com.wellcom.prosa.sacii.ComboBoxGen"%>
<!--Modificacion: SAS-DRT F-52-8063-16 Marca de fin-->
<%@page import="com.wellcom.io.HTML"%>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>

<%
  HTML comboBox = new HTML();
  /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
  ComboBoxGen myComboBox = new ComboBoxGen();
  /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
  session.setAttribute("accion","nvoTC");
  ArrayList cbFiid = myComboBox.getBancosBU(session);
%>

<%
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
    }
%>
<%
    /**
    * Database
    */
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
    //Database db;
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
    String sessionID;
    int i;   
    /**
    * Action type
    */
    String btnaggtipocambio;//String btnDelModGrpSacii;
    String btninsertaregistro;//String btnModGrpSacii;
    String output=null;
    String campoBU;
    String campoCODIGO;
    String campoFECHA;
    String campoTIPO;
    String campoFUENTE;
    String campoCOMPRA;
    String campoVENTA;
    String campoPROMEDIO;
    String txtfUsuario;
    
    
%>


<%
    /**
    * Action type
    */
    btnaggtipocambio = request.getParameter("btnaggtipocambio"); //btnDelModGrpSacii = request.getParameter("btnDelModGrpSacii");
    btninsertaregistro = request.getParameter("btninsertaregistro"); //btnModGrpSacii = request.getParameter("btnModGrpSacii");
 
    
    
    /**
    * Database
    */
    sessionID = request.getRequestedSessionId();
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
    //db = (Database)session.getAttribute(sessionID + "db");
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
    
    txtfUsuario = (String)session.getAttribute("login");
    /**************************************************************************/   
    /**
    * From "lstGrpSacii"
    */
    if(btnaggtipocambio.equals("Agregar")) 
        {
               String txtfStartDate = (String)session.getAttribute("txtfStartDate");
               String txtFiidVal = (String)session.getAttribute("txtFiidVal");
               String fecha = (String)session.getAttribute("fechaHoy");

            output =
                "<div align=\"center\">"
                +"  <form action=\"tipocambio.jsp?txtfStartDate="+txtfStartDate+"&txtFiidVal="+txtFiidVal+"&btntipocambio=OK\" method=\"post\" name=\"frmTOCHeader\" >"
                +"    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"tbl_border\" summary=\"Modify a Group\">"
                +"<tr>"
                +"   <th class=\"td_header\" width=\"100%\" colspan=4 >TIPO CAMBIO<br></th>"
                +"</tr>"
                +"      <tr>"
                +"        <td><div align=\"right\">PROCESO:</div></td> "
                +"        <td><div align=\"left\"> ";
  							
                 output += comboBox.getComboBox( "campoBU", cbFiid, "Proceso..." );
	                        
                 output +="            <span id = \"txtFiid\" class=\"ocultar\">Elije una Opción</span> "
                                +"		</div></td> "
                +"      </tr>"
                +"      <tr>"
                +"        <td><div align=\"right\">CODIGO MONEDA:</div></td>"
                +"        <td><div align=\"left\">"
                +"          &nbsp;<input name=\"campoCODIGO\" value=\"484\" type=\"text\" id=\"campoCODIGO\" size=\"3\" maxlength=\"3\" disabled=\"disabled\" >"
                +"        </div></td>"
                +"      </tr>"
                +"      <tr>"
                +"      <td align=\"right\"><strong>FECHA:</strong></td> "
                +"      <td align=\"left\"> "
                +"              <input name=\"campoFECHA\" type=\"text\" id=\"campoFECHA\" size=\"15\" readonly maxlength=\"15\" value="+fecha+"> "
                +"              <a href=\"javascript:void(0)\" onclick=\"if(self.gfPop)gfPop.fPopCalendar(document.frmTOCHeader.campoFECHA);return false;\" hidefocus> "
                +"                  <img name=\"popcalStart\" align=\"absmiddle\" src=\"scripts/calendar/calbtn.jpg\" border=\"0\" alt=\"\"> "
                +"              </a><br/> "
                +"      </td> "
                +"        </tr>"
                +"         <tr>"
                +"         <td><div align=\"right\">TC COMPRA:</div></td>"
                +"         <td><div align=\"left\">"
                +"          &nbsp;<input name=\"campoCOMPRA\" value=\"00.0000\" type=\"text\" id=\"campoCOMPRA\" size=\"7\" maxlength=\"7\" onkeydown=\"if if ((event.keyCode < 45 && event.keyCode != 8 && event.keyCode != 37 && event.keyCode != 39) || (event.keyCode > 57 && event.keyCode < 96) || (event.keyCode > 105 && event.keyCode != 110 && event.keyCode != 190)) event.returnValue = false;\" >"
                +"             <span id = \"txtCompra\" class=\"ocultar\">El valor debe ser diferente de cero y es obligatorio</span> "
                +"        </div></td>"
                +"      </tr>"
                +"        </tr>"
                +"         <tr>"
                +"         <td><div align=\"right\">TC VENTA:</div></td>"
                +"         <td><div align=\"left\">"
                +"          &nbsp;<input name=\"campoVENTA\" value=\"00.0000\" type=\"text\" id=\"campoVENTA\" size=\"7\" maxlength=\"7\" onkeydown=\"if if ((event.keyCode < 45 && event.keyCode != 8 && event.keyCode != 37 && event.keyCode != 39) || (event.keyCode > 57 && event.keyCode < 96) || (event.keyCode > 105 && event.keyCode != 110 && event.keyCode != 190)) event.returnValue = false;\" >"
                +"             <span id = \"txtVenta\" class=\"ocultar\">El valor debe ser diferente de cero y es obligatorio</span> "
                +"        </div></td>"
                +"      </tr>"
                +"        </tr>"
                +"         <tr>"
                +"         <td><div align=\"right\">TC PROMEDIO:</div></td>"
                +"         <td><div align=\"left\">"
                +"          &nbsp;<input name=\"campoPROMEDIO\" value=\"00.0000\" type=\"text\" id=\"campoPROMEDIO\" size=\"7\" maxlength=\"7\" onkeydown=\"if if ((event.keyCode < 45 && event.keyCode != 8 && event.keyCode != 37 && event.keyCode != 39) || (event.keyCode > 57 && event.keyCode < 96) || (event.keyCode > 105 && event.keyCode != 110 && event.keyCode != 190)) event.returnValue = false;\" >"
                +"             <span id = \"txtPromedio\" class=\"ocultar\">El valor debe ser diferente de cero y es obligatorio</span> "
                +"        </div></td>"
                +"      </tr>"
                +"      <tr>"
                +"        <td colspan=\"2\"><div align=\"center\">"
                +"          &nbsp;<input name=\"btninsertaregistro\" type=\"submit\" id=\"btninsertaregistro\" value=\"INSERTAR\" onclick=\"javascript:return valida(this.form);\">"
                +"        </div></td>"
                +"      </tr>"
                +"    </table>"
                +"  </form>"
                +"</div>"
                +"<iframe width=174 height=189 name=\"gToday:normal:agenda.js\" id=\"gToday:normal:agenda.js\" src=\"scripts/calendar/ipopeng.htm\" scrolling=\"no\" frameborder=\"0\" style=\"visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;\">"
                +"</iframe>";
        }
    /**
    *  From "delModGrpSacii"
    */
   
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css">

        <script type="text/javascript">
            var span = null;
            // var ventana = null;
            var showCompra = false;
            var showVenta = false;
            var showPromedio = false;
            var showFiid = false;
            var numPage = 0;
            function valida(form1)
            {

                try
                {
                    if (showFiid)
                    {
                        span = document.getElementById("txtFiid");
                        span.style.display = 'none';
                        showFiid = false;
                    } else if (showCompra)
                    {
                        span = document.getElementById("txtCompra");
                        span.style.display = 'none';
                        showFiid = false;
                    } else if (showVenta)
                    {
                        span = document.getElementById("txtVenta");
                        span.style.display = 'none';
                        showFiid = false;
                    } else if (showPromedio)
                    {
                        span = document.getElementById("txtPromedio");
                        span.style.display = 'none';
                        showFiid = false;
                    }
                    if (document.frmTOCHeader.campoBU.value == "" || document.frmTOCHeader.campoBU.value == "None")
                    {
                        span = document.getElementById("txtFiid");
                        span.style.display = 'inline';
                        showTextInitDate = true;
                        return false;
                    } else if (document.frmTOCHeader.campoCOMPRA.value == "" || document.frmTOCHeader.campoCOMPRA.value == "None" || document.frmTOCHeader.campoCOMPRA.value == "0" || document.frmTOCHeader.campoRATE.value == "00.0000")
                    {
                        span = document.getElementById("txtCompra");
                        span.style.display = 'inline';
                        showTextInitDate = true;
                        return false;
                    } else if (document.frmTOCHeader.campoVENTA.value == "" || document.frmTOCHeader.campoVENTA.value == "None" || document.frmTOCHeader.campoVENTA.value == "0" || document.frmTOCHeader.campoRATE.value == "00.0000")
                    {
                        span = document.getElementById("txtVenta");
                        span.style.display = 'inline';
                        showTextInitDate = true;
                        return false;
                    } else if (document.frmTOCHeader.campoPROMEDIO.value == "" || document.frmTOCHeader.campoPROMEDIO.value == "None" || document.frmTOCHeader.campoPROMEDIO.value == "0" || document.frmTOCHeader.campoRATE.value == "00.0000")
                    {
                        span = document.getElementById("txtPromedio");
                        span.style.display = 'inline';
                        showTextInitDate = true;
                        return false;
                    } else
                    {
                        return true;
                    }
                } catch (e) {
                }
            }
        </script>
    </head>      
    <body>    
        <%
            out.println(output); 
                       
        %>        
    </body>    
</html>
