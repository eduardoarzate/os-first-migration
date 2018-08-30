<%
/*###############################################################################
# Nombre del Programa :  cierreDifCuotas.jsp                                    #
# Autor               :  Carlos Mendez                                          #
# Compania            :  PROSA                                                  #
# Proyecto/Procliente : C-04-3035-13                            Fecha:11/12/2013#
# Modificacion        : Generacion de Proceso de Diferencia de Cuota de         #
#                       Intercambio de EGLO SAC2                                #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :                                                         #
#                                                                               #
#                                                                               #
#################################################################################
#                               MODIFICACIONES                                  #
#-----------------------------------------------------------------------------  #
# Autor               :  Daniel Ramírez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 12/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!-- Modificacion: Marca de inicio    SAS-DRT F-52-8063-16 -->
<%/*@page import="com.wellcom.sql.Database"*/%>
<!-- Modificacion: Marca de fin    SAS-DRT F-52-8063-16 -->
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
     /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
    //Database db;
    String sessionID;
    //String GRUPO_SACII;
     /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
    String query;
    ArrayList tocAL;
    Iterator it;
    String[] tmpAStr;
    String[] rowValue = new String[6];
    int i;   
    /**
    * Action type
    */
    String rbtneditdifcuotas;//String rbtnDelModGrpSacii;
    String btneditdifcuotas;//String btnDelModGrpSacii;
    String btnprocesa;//String btnModGrpSacii;
    String output=null;
    String campoPROCESO;
        String campoFECHA;
    String campoCOMPRA;
    String campoVENTA;
    String campoFECHA_FIN;
    String txtfUsuario;
%>


<%
    /**
    * Action type
    */
    rbtneditdifcuotas = request.getParameter("rbtn");//rbtnDelModGrpSacii = request.getParameter("rbtn");
    btneditdifcuotas = request.getParameter("btneditdifcuotas");
    btnprocesa = request.getParameter("btnprocesa");
 
    
    
    /**
    * Database
    */
    sessionID = request.getRequestedSessionId();
    /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
    //db = (Database)session.getAttribute(sessionID + "dbSICB2");
    //GRUPO_SACII = (String)session.getAttribute("GRUPO_SACII");
    /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
    tocAL = (ArrayList)session.getAttribute(sessionID + "tocAL");

        txtfUsuario = (String)session.getAttribute("login");
    /**************************************************************************/   
    /**
    * From "lstGrpSacii"
    */
    if(btneditdifcuotas != null) {       
        /**
        * Get Row to Delete/Modify
        */
        i = 0;
        it = tocAL.iterator();
        while(it.hasNext()) {
            tmpAStr = (String[])it.next();
            if(Integer.parseInt(rbtneditdifcuotas) == i ) {
                rowValue = tmpAStr;
                                System.out.println("rowValue:"+rowValue);
                                break;
            }
            i++;
        }
        
        /**
        * Modify
        */
        if(btneditdifcuotas.equals("Procesar")) {
               String txtfStartDate = (String)session.getAttribute("txtfStartDate");
            session.setAttribute("rowValuetipoSacii", rowValue); 
            rowValue[6] = rowValue[3].trim().length() > 0 ? rowValue[6] : txtfUsuario;
            output =
                "<div align=\"center\">"
                +"  <form action=\"cierreDifCuotas.jsp?txtfStartDate="+txtfStartDate+"&txtfStartDate="+txtfStartDate+"&btndifcuotas=OK\" method=\"post\" name=\"frmTOCHeader\">"
                +"    <table width=\"50%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"tbl_border\" summary=\"Modify a Group\">"
                +"<tr>"
                +"   <th class=\"td_header\" width=\"100%\" colspan=4 >CIERRE DE PERIODO DIFERENCIA CUOTAS<br></th>"
                +"</tr>"
                +"      <tr>"
                +"      <td align=\"right\"><strong>FECHA INICIO:</strong></td> "
                +"      <td align=\"left\"> "
                +"              <input name=\"campoFECHA_INI\" type=\"text\" id=\"campoFECHA_INI\" size=\"15\" readonly maxlength=\"15\" value="+rowValue[1]+"> "
                +"      </td> "
                +"      <tr>"
                +"      <td align=\"right\"><strong>FECHA FIN:</strong></td> "
                +"      <td align=\"left\"> "
                +"              <input name=\"campoFECHA_FIN\" type=\"text\" id=\"campoFECHA_FIN\" size=\"15\" readonly maxlength=\"15\" value="+rowValue[2]+"> "
                +"              <a href=\"javascript:void(0)\" onclick=\"if(self.gfPop)gfPop.fPopCalendar(document.frmTOCHeader.campoFECHA_FIN);return false;\" hidefocus> "
                +"                  <img name=\"popcalStart\" align=\"absmiddle\" src=\"scripts/calendar/calbtn.jpg\" border=\"0\" alt=\"\"> "
                +"              </a><br/> "
                +"      </td> "
                +"      </tr>";
                if (rowValue[3].trim().length() > 0){
                    output +=
                "      <tr>"
                +"        <td><div align=\"right\">BANCOMER:</div></td>"
                +"        <td><div align=\"left\">"	
                +"          &nbsp;<input name=\"campoBCM\" value="+rowValue[3]+" type=\"text\" id=\"campoBCM\" size=\"12\" maxlength=\"12\" disabled=\"disabled\" >"
                +"        </div></td>"
                +"      </tr>";
                }
                if (rowValue[4].trim().length() > 0){
                output +=    
                 "      <tr>"
                +"        <td><div align=\"right\">BANAMEX:</div></td>"
                +"        <td><div align=\"left\">"
                +"          &nbsp;<input name=\"campoBMX\" value="+rowValue[4]+" type=\"text\" id=\"campoBMX\" size=\"12\" maxlength=\"12\" disabled=\"disabled\" >"
                +"        </div></td>"
                +"        </tr>";
                }
                output +=
                 "      <tr>"
                +"        <td><div align=\"right\">USUARIO:</div></td>"
                +"        <td><div align=\"left\">"
                +"          &nbsp;<input name=\"campoUSR\" value="+rowValue[6]+" type=\"text\" id=\"campoUSR\" size=\"12\" maxlength=\"12\" disabled=\"disabled\" >"
                +"        </div></td>"
                +"        </tr>"
                +"      <tr>"
                +"      <td align=\"right\"><strong>FECHA REGISTRO:</strong></td> "
                +"      <td align=\"left\"> "
                +"              <input name=\"campoFECHA_REG\" type=\"text\" id=\"campoFECHA_REG\" size=\"15\" readonly maxlength=\"15\" disabled=\"disabled\" value="+rowValue[7]+"> "
                +"      </td> "
                +"      <tr>"                
                +"        <td colspan=\"2\"><div align=\"center\">"
                +"          &nbsp;<input name=\"btnprocesa\" type=\"submit\" id=\"btnprocesa\" value=\"PROCESAR\" onclick=\"javascript:return valida(this.form);\">"
                +"        </div></td>"
                +"      </tr>"
                +"    </table>"
                +"             <span id = \"txtFecha\" class=\"ocultar\">Debe seleccionar la fecha final del periodo</span> "
                +"  </form>"
                +"</div>"
                +"<iframe width=174 height=189 name=\"gToday:normal:agenda.js\" id=\"gToday:normal:agenda.js\" src=\"scripts/calendar/ipopeng.htm\" scrolling=\"no\" frameborder=\"0\" style=\"visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;\">"
                +"</iframe>";
        }
    }

   
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
            var showFecha = false;
            var numPage = 0;
            function valida(form1)
            {
                try
                {
                    if (showFecha) {
                        span = document.getElementById("txtFecha");
                        span.style.display = 'none';
                        showFiid = false;
                    }

                    if (document.frmTOCHeader.campoFECHA_FIN.value == "" || document.frmTOCHeader.campoFECHA_FIN.value == "None") {
                        span = document.getElementById("txtFecha");
                        span.style.display = 'inline';
                        showTextInitDate = true;
                        return false;
                    } else {
                        return true;
                    }
                } catch (e) {
                }
            }
        </script>
    </head>      
    <%
    
    if (btnprocesa == null)
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
