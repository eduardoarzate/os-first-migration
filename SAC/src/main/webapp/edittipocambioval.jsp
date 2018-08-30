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
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!--Modificacion: SAS-DRT F-52-8063-16 Marca de inicio-->
<%/*@page import="com.wellcom.sql.Database"*/%>
<!--Modificacion: SAS-DRT F-52-8063-16 Marca de fin-->
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>

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
    String GRUPO_SACII;
    String query;
    ArrayList tocAL;
    Iterator it;
    String[] tmpAStr;
    String[] rowValue = new String[6];
    int i;   
    /**
    * Action type
    */
    String rbtnedittipocambio;//String rbtnDelModGrpSacii;
    String btnedittipocambio;//String btnDelModGrpSacii;
    String btnedita;//String btnModGrpSacii;
    String output=null;
    String campoBU;
    String campoPROCESO;
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
    rbtnedittipocambio = request.getParameter("rbtn");//rbtnDelModGrpSacii = request.getParameter("rbtn");
    btnedittipocambio = request.getParameter("btnedittipocambio");//btnDelModGrpSacii = request.getParameter("btnDelModGrpSacii");
    btnedita = request.getParameter("btnedita");//btnModGrpSacii = request.getParameter("btnModGrpSacii");
 
    
    
    /**
    * Database
    */
    sessionID = request.getRequestedSessionId();
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
    //db = (Database)session.getAttribute(sessionID + "db");
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
    GRUPO_SACII = (String)session.getAttribute("GRUPO_SACII");
    tocAL = (ArrayList)session.getAttribute(sessionID + "tocAL");

        txtfUsuario = (String)session.getAttribute("login");
    /**************************************************************************/   
    /**
    * From "lstGrpSacii"
    */
    if(btnedittipocambio != null) {       
        /**
        * Get Row to Delete/Modify
        */
        i = 0;
        it = tocAL.iterator();
        while(it.hasNext()) {
            tmpAStr = (String[])it.next();
            if(Integer.parseInt(rbtnedittipocambio) == i ) {
                rowValue = tmpAStr;
                                System.out.println("rowValue:"+rowValue);
                                break;
            }
            i++;
        }
        
        /**
        * Modify
        */
        if(btnedittipocambio.equals("Editar")) {
               String txtfStartDate = (String)session.getAttribute("txtfStartDate");
               String txtFiidVal = (String)session.getAttribute("txtFiidVal");
            session.setAttribute("rowValuetipoSacii", rowValue);    
            output =
                "<div align=\"center\">"
                +"  <form action=\"tipocambio.jsp?txtfStartDate="+txtfStartDate+"&txtFiidVal="+txtFiidVal+"&btntipocambio=OK\" method=\"post\" name=\"frmTOCHeader\">"
                +"    <table width=\"50%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"tbl_border\" summary=\"Modify a Group\">"
                +"<tr>"
                +"   <th class=\"td_header\" width=\"100%\" colspan=4 >TIPO CAMBIO<br></th>"
                +"</tr>"
                +"      <tr>"
                +"        <td><div align=\"right\">PROCESO:</div></td>"
                +"        <td><div align=\"left\">"
                +"          &nbsp;<input name=\"campoBU\" value="+rowValue[0]+" type=\"hidden\" id=\"campoBU\" size=\"4\" maxlength=\"4\" disabled=\"disabled\">"
                +"          &nbsp;<input name=\"campoPROCESO\" value=\""+rowValue[1]+"\" type=\"text\" id=\"campoPROCESO\" size=\"25\" maxlength=\"25\" disabled=\"disabled\">"
                +"        </div></td>"
                +"      </tr>"
                +"      <tr>"
                +"        <td><div align=\"right\">CODIGO MONEDA:</div></td>"
                +"        <td><div align=\"left\">"
                +"          &nbsp;<input name=\"campoCODIGO\" value="+rowValue[2]+" type=\"text\" id=\"campoFOLIO\" size=\"3\" maxlength=\"3\" disabled=\"disabled\" >"
                +"        </div></td>"
                +"      </tr>"
                +"      <tr>"
                +"      <td align=\"right\"><strong>FECHA:</strong></td> "
                +"      <td align=\"left\"> "
                +"              <input name=\"campoFECHA\" type=\"text\" id=\"campoFECHA\" size=\"15\" readonly maxlength=\"15\" value="+rowValue[3]+"> "
                +"              <a href=\"javascript:void(0)\" onclick=\"if(self.gfPop)gfPop.fPopCalendar(document.frmTOCHeader.campoFECHA);return false;\" hidefocus> "
                +"                  <img name=\"popcalStart\" align=\"absmiddle\" src=\"scripts/calendar/calbtn.jpg\" border=\"0\" alt=\"\"> "
                +"              </a><br/> "
                +"      </td> "
                +"        </tr>"
                +"         <tr>"
                +"         <td><div align=\"right\">TC COMPRA:</div></td>"
                +"         <td><div align=\"left\">";
                if(!rowValue[0].equals("196") && !rowValue[0].equals("211")){
                        output+="          &nbsp;<input name=\"campoCOMPRA\" value="+rowValue[4]+" type=\"text\" id=\"campoCOMPRA\" size=\"7\" maxlength=\"7\" onkeydown=\"if ((event.keyCode < 45 && event.keyCode != 8 && event.keyCode != 37 && event.keyCode != 39) || (event.keyCode > 57 && event.keyCode < 96) || (event.keyCode > 105 && event.keyCode != 110 && event.keyCode != 190)) event.returnValue = false;\" >";
                }else{
                        output+="          &nbsp;<input name=\"campoCOMPRA\" value="+rowValue[4]+" type=\"text\" id=\"campoCOMPRA\" size=\"7\" maxlength=\"7\" disabled=\"disabled\" >";
                }
                output+="             <span id = \"txtCompra\" class=\"ocultar\">El valor debe ser diferente de cero y es obligatorio</span> "
                +"        </div></td>"
                +"      </tr>"
                +"         <tr>"
                +"         <td><div align=\"right\">TC VENTA:</div></td>"
                +"         <td><div align=\"left\">";
                if(!rowValue[0].equals("196") && !rowValue[0].equals("211")){
                        output+="          &nbsp;<input name=\"campoVENTA\" value="+rowValue[5]+" type=\"text\" id=\"campoVENTA\" size=\"7\" maxlength=\"7\" onkeydown=\"if ((event.keyCode < 45 && event.keyCode != 8 && event.keyCode != 37 && event.keyCode != 39) || (event.keyCode > 57 && event.keyCode < 96) || (event.keyCode > 105 && event.keyCode != 110 && event.keyCode != 190)) event.returnValue = false;\" >";
                }else{
                        output+="          &nbsp;<input name=\"campoVENTA\" value="+rowValue[5]+" type=\"text\" id=\"campoVENTA\" size=\"7\" maxlength=\"7\" disabled=\"disabled\" >";
                }
                output+="             <span id = \"txtVenta\" class=\"ocultar\">El valor debe ser diferente de cero y es obligatorio</span> "
                +"        </div></td>"
                +"      </tr>"
                +"         <tr>"
                +"         <td><div align=\"right\">TC PROMEDIO:</div></td>"
                +"         <td><div align=\"left\">";
                if(!rowValue[0].equals("196") && !rowValue[0].equals("211")){
                        output+="          &nbsp;<input name=\"campoPROMEDIO\" value="+rowValue[6]+" type=\"text\" id=\"campoPROMEDIO\" size=\"7\" maxlength=\"7\" onkeydown=\"if ((event.keyCode < 45 && event.keyCode != 8 && event.keyCode != 37 && event.keyCode != 39) || (event.keyCode > 57 && event.keyCode < 96) || (event.keyCode > 105 && event.keyCode != 110 && event.keyCode != 190)) event.returnValue = false;\" >";
                }else{
                        output+="          &nbsp;<input name=\"campoPROMEDIO\" value="+rowValue[6]+" type=\"text\" id=\"campoPROMEDIO\" size=\"7\" maxlength=\"7\" disabled=\"disabled\" >";
                }
                output+="             <span id = \"txtPromedio\" class=\"ocultar\">El valor debe ser diferente de cero y es obligatorio</span> "
                +"        </div></td>"
                +"      </tr>";
                if(!rowValue[0].equals("196") && !rowValue[0].equals("211")){
                output+="      <tr>"
                +"        <td colspan=\"2\"><div align=\"center\">"
                +"          &nbsp;<input name=\"btnedita\" type=\"submit\" id=\"btnedita\" value=\"EDITAR\" onclick=\"javascript:return valida(this.form);\">"
                +"        </div></td>"
                +"      </tr>";
                }
                output+="    </table>"
                +"  </form>"
                +"</div>"
                +"<iframe width=174 height=189 name=\"gToday:normal:agenda.js\" id=\"gToday:normal:agenda.js\" src=\"scripts/calendar/ipopeng.htm\" scrolling=\"no\" frameborder=\"0\" style=\"visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;\">"
                +"</iframe>";
        }
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
            var showCompra = false;
            var showVenta = false;
            var showPromedio = false;
            var numPage = 0;
            function valida(form1)
            {

            try
            {
            if (showCompra){
            span = document.getElementById("txtCompra");
            span.style.display = 'none';
            showFiid = false;
            } else if (showVenta)
                    span = document.getElementById("txtVenta");
            span.style.display = 'none';
            showFiid = false;
            } else if (showPromedio){
            span = document.getElementById("txtPromedio");
            span.style.display = 'none';
            showFiid = false;
            }

            if (document.frmTOCHeader.campoCOMPRA.value == "" || document.frmTOCHeader.campoCOMPRA.value == "None" || document.frmTOCHeader.campoCOMPRA.value == "0" || document.frmTOCHeader.campoCOMPRA.value == "00.0000"){
            span = document.getElementById("txtCompra");
            span.style.display = 'inline';
            showTextInitDate = true;
            return false;
            } else if (document.frmTOCHeader.campoVEMTA.value == "" || document.frmTOCHeader.campoVENTA.value == "None" || document.frmTOCHeader.campoVENTA.value == "0" || document.frmTOCHeader.campoVENTA.value == "00.0000"){
            span = document.getElementById("txtVenta");
            span.style.display = 'inline';
            showTextInitDate = true;
            return false;
            } else if (document.frmTOCHeader.campoPROMEDIO.value == "" || document.frmTOCHeader.campoPROMEDIO.value == "None" || document.frmTOCHeader.campoPROMEDIO.value == "0" || document.frmTOCHeader.campoPROMEDIO.value == "00.0000"){
            span = document.getElementById("txtPromedio");
            span.style.display = 'inline';
            showTextInitDate = true;
            return false;
            } else{
            return true;
            }
            } catch (e){
            }
            }
        </script>
    </head>      
    <%
    
    if (btnedita == null)
    {%>
    <body>

        <%
            out.println(output); 
                       
        %>            
    </body>
    <%    
    }
    else 
    {%> 
    <script language="javascript" type="text/javascript">
        //window.open('','_parent','');
        //window.parent.close();
    </script>
    <body>
        <%
            out.println(output);            
        }%>        
    </body>    
</html>
