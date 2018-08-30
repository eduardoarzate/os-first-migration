<%
/*###############################################################################
# Nombre del Programa :  elimodprefijo.jsp 	                                    #
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
#################################################################################
#								MODIFICACIONES                                  #
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
    ConexionORACLE conOracle = null;
   /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
    String sessionID;
    //String TIPO_DE_CAMBIO;
    String PREFIJO;
    String query;
    ArrayList tocAL;
    Iterator it;
    String[] tmpAStr;
    String[] rowValue;
    int i;
    
    /**
    * Action type
    */
    String rbtnDelModTOC;
    String btnDelModTOC;
    String btnModTOC;
    String output;
    String txtfDate;
    String txtfTOC;
%>

<%
    /**
    * Action type
    */
    rbtnDelModTOC = request.getParameter("rbtn");
    btnDelModTOC = request.getParameter("btnDelModTOC");
    btnModTOC = request.getParameter("btnModTOC");

        /**
    * Database
    */
    sessionID = request.getRequestedSessionId();
      /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
    conOracle = new ConexionORACLE();
    //db = (Database)session.getAttribute(sessionID + "db");
   /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
    //TIPO_DE_CAMBIO = (String)session.getAttribute("TIPO_DE_CAMBIO");
    PREFIJO = (String)session.getAttribute("TBL_PRE_PREFIJO2");
    tocAL = (ArrayList)session.getAttribute(sessionID + "tocAL");
    /**************************************************************************/
    
    /**
    * From "lstTOC"
    */
    if(rbtnDelModTOC != null && btnDelModTOC != null) {
        
        /**
        * Get Row to Delete/Modify
        */
        i = 0;
        it = tocAL.iterator();
        while(it.hasNext()) {

            tmpAStr = (String[])it.next();
            if(Integer.parseInt(rbtnDelModTOC) == i ) {
                rowValue = tmpAStr;
            }
            i++;
        }
        
        /**
        * Delete
        */
        if(btnDelModTOC.equals("Eliminar")) {
            
            query = "DELETE FROM PRE.TBL_PRE_PREFIJO2" 
                + " WHERE ENTIDAD_PROSA = " + rowValue[0]
                + " AND PREFIJO = " + rowValue[1];
            System.out.println("TOC QueryDelete: " + query);
            /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
            conOracle.Conectar();
            conOracle.Eliminar(query);
            //db.setQueryDelete(query);
            //db.executeQueryDelete();
            /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
            output = "Registro Eliminado.";
        }
        /**
        * Modify
        */
        else if(btnDelModTOC.equals("Modificar")) {
            
            session.setAttribute("rowValueTOC", rowValue);
            
            output =
                "<div align=\"center\">"
                + "  <form name=\"frmModTOC\" method=\"post\" action=\"ControllerServlet?action=modificaprefijo\" enctype=\"application/x-www-form-urlencoded\">"
                + "    <table width=\"50%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\">"
                + "      <tr>"
                + "        <td><div align=\"right\">FIID:</div></td>"
                + "        <td><div align=\"left\">"
                + "          <input value=\"" + rowValue[0] + "\" name=\"txtfDate\" type=\"text\" id=\"txtfDate\" size=\"15\" maxlength=\"3\">"
                +"              <a href=\"javascript:void(0)\" onclick=\"if(self.gfPop)gfPop.fPopCalendar(document.frmModTOC.txtfDate);return false;\" hidefocus>"
                +"              <img name=\"popcalStart\" align=\"absmiddle\" src=\"scripts/calendar/calbtn.gif\" width=\"34\" height=\"22\" border=\"0\" alt=\"\">"
                +"          </a>"
                + "        </div></td>"
                + "      </tr>"
                + "      <tr>"
                + "        <td><div align=\"right\">Prefijo: </div></td>"
                + "        <td><div align=\"left\">"
                + "          <input value=\"" + rowValue[1] + "\" name=\"txtfTOC\" type=\"text\" id=\"txtfTOC\" size=\"15\" maxlength=\"6\">"
                + "        </div></td>"
                + "      </tr>"
                + "      <tr>"
                + "        <td colspan=\"2\"><div align=\"center\">"
                + "          <input name=\"btnModTOC\" type=\"submit\" id=\"btnModTOC\" value=\"OK\">"
                + "          <input name=\"btnErase\" type=\"reset\" id=\"btnErase\" value=\"Borrar\">"
                + "        </div></td>"
                + "      </tr>"
                + "    </table>"
                + "  </form>"
                + "</div>";
        }
    }
    /**
    *  From "delModTOC"
    */    
    
    else if(btnModTOC != null) {
        
        rowValue = (String[])session.getAttribute("rowValueTOC");
        txtfDate = (String)request.getParameter("txtfDate");
        txtfTOC = (String)request.getParameter("txtfTOC");
        
        query = "UPDATE PRE.TBL_PRE_PREFIJO2" 
            + " SET ENTIDAD_PROSA = " + txtfDate
            + ", PREFIJO = " + txtfTOC
            + " WHERE ENTIDAD_PROSA = " + rowValue[0] 
            + "AND PREFIJO = " + rowValue[1];
        System.out.println("QueryModifiy: " + query);
                    /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
            conOracle.Conectar();
            conOracle.Modificar(query);
        //  db.setQueryUpdate(query);
        //db.executeQueryUpdate();
            /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/

        output = "Registro Actualizado.";
    }
               /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
            conOracle.Desconectar();
          /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%
            out.println(output);
        %>
        <iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="scripts/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
    </body>
</html>
