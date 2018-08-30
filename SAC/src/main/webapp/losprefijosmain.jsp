<%
/*###############################################################################
# Nombre del Programa :  losprefijosmain.jsp                                    #
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
<%@page import="com.wellcom.conexion.*"%>
<!--Modificacion: SAS-DRT F-52-8063-16 Marca de fin-->
<%@page import="com.wellcom.io.HTML"%>
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
    ConexionORACLE conOracle = null;
   /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
    String sessionID;
    String TBL_PRE_PREFIJO2;
    String query;
    ArrayList tocAL;
    Iterator it;
    String[] colsTitles = {"FIID", "Prefijo", "Eliminar/Modificar"};
    
    /**
    * HTML
    */
    HTML html;
    String btnLstTOC;
    //String txtfStartDate;
    //String txtfEndDate;
    String fiid;
    String prefijo;
    
    /**
    * Pagination
    */
    int FILAS_POR_PAGINA;
    //int TBL_PRE_PREFIJO2;
    String pagination;
    int currentRow;
    int numResults;
    
    /**
    * Print Results
    */
    void resultsTable(javax.servlet.jsp.JspWriter out) {
        
        try {
            html.setCSSTable("titTablaTransDaily");
            html.setCSSTRTable("datosTablaTransDaily");
            out.println(html.getTableRadioBtn(colsTitles, tocAL));
            out.println(
                "<br>"
                +"<div align=\"center\">"
                +"    <table width=\"11%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">"
                +"        <tr>"
                //+"            <td width=\"50%\"><div align=\"center\">"
                //+"                <input type=\"submit\" name=\"btnDelModTOC\" value=\"Agregar\">"
                //+"            </div></td>"
                +"            <td width=\"50%\"><div align=\"center\">"
                +"                <input type=\"submit\" name=\"btnDelModTOC\" value=\"Eliminar\">"
                +"            </div></td>"
                +"            <td width=\"50%\"><div align=\"center\">"
                +"                <input type=\"submit\" name=\"btnDelModTOC\" value=\"Modificar\">"
                +"            </div></td>"
                +"        </tr>"
                +"    </table>"
                +"</div>"
            );
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
%>

<%
    /**
    * Database
    */
    sessionID = request.getRequestedSessionId();
        /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
    conOracle = new ConexionORACLE();
    //db = (Database)session.getAttribute(sessionID + "db");
   /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
    TBL_PRE_PREFIJO2 = (String)session.getAttribute("TBL_PRE_PREFIJO2");
    //TIPO_DE_CAMBIO = (String)session.getAttribute("TIPO_DE_CAMBIO");
    /**************************************************************************/
    
    /**
    * HTML
    */
    html = new HTML();
    btnLstTOC = request.getParameter("btnLstTOC");
    /**************************************************************************/
    
    /**
    * Pagination
    */
    FILAS_POR_PAGINA =
        ((Integer)session.getAttribute("FILAS_POR_PAGINA")).intValue();
    pagination = request.getParameter("pagination");
    /**************************************************************************/
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
        <form action="ControllerServlet?action=elimodprefijo" method="post" enctype="application/x-www-form-urlencoded" name="frmDelModTOC" id="frmDelModTOC">
            <%
                if(btnLstTOC != null && pagination == null) {
                    
                    /**
                    * Data
                    */
                    fiid = request.getParameter("fiid");
                    //out.println("valor de fiid"+fiid);
                    prefijo = request.getParameter("resultado");
                    //out.println("valor de prefijo"+prefijo);                    
                    //txtfStartDate = request.getParameter("txtfStartDate");
                    //txtfEndDate = request.getParameter("txtfEndDate");
                    
                    //html.addFieldToValidate("Fecha Inicio", txtfStartDate);
                    //html.addFieldToValidate("Fecha Fin", txtfEndDate);
                    
                    html.addFieldToValidate("fiid", fiid);
                    html.addFieldToValidate("prefijo", prefijo);
                    
                    /**
                    * Validate Fields
                    */
                    if(html.validateFields().size() == 0) {                        
                        query = "SELECT ENTIDAD_PROSA FIID, PREFIJO PREFIJO FROM PRE.TBL_PRE_PREFIJO2"+
                        " WHERE ENTIDAD_PROSA = "+fiid+" AND PREFIJO = "+prefijo;                                                        
                        //System.out.println(query);
                        /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
                        conOracle.Conectar();
                        conOracle.Consultar(query);
                        //db.setQuerySelect(query);
                        //db.executeQuerySelect();
                        /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
                        numResults = conOracle.getNumRowsRS();
                        if(numResults > 0) {
                            tocAL = conOracle.getNextResultSetData(100);
                            session.setAttribute(sessionID + "tocAL", tocAL);
                        }

                        if(tocAL != null) {

                            /**
                            * Pagination
                            */
                            currentRow = 1;
                            out.println("<b>Número de resultados: " + numResults + "<b><br><br>");
                            out.println("Resultados " + currentRow
                                + " al " + (numResults));
                            out.println("&nbsp&nbsp<a href=\"losprefijosmain.jsp?pagination=P\">Previos</a>");
                            out.println("&nbsp&nbsp<a href=\"losprefijosmain.jsp?pagination=N\">Siguientes</a>");
                            out.println("<br><br>");
                            /**
                            * Print Results
                            */
                            resultsTable(out);
                        } else {
                            out.println("No se encontraron Registros.");
                        }
                    } else {
                        out.println("Los campos: " + html.validateFields().toString() + " son obligatorios.");
                    }
                } else if(btnLstTOC == null && pagination == null) {
                    currentRow = 1;
                    out.println("<b>Resultados de B&uacute;squeda de Prefijos.</b>");
                /**
                * Pagination - Next
                */
                } else if(pagination.equals("N")) {
                    /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
                    tocAL = conOracle.getNextResultSetData(FILAS_POR_PAGINA);
                    /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
                    //numResults = db.getNumRowsRS();
                    out.println("<b>Número de resultados: " + numResults + "<b><br><br>");
                    it = tocAL.iterator();
                    int pageSize = tocAL.size();
                    if((currentRow + pageSize) < numResults)
                        currentRow += FILAS_POR_PAGINA;
                    out.println("Resultados " + currentRow
                        + " al " + (currentRow + pageSize - 1));
                    out.println("&nbsp&nbsp<a href=\"lstTOCMain.jsp?pagination=P\">Previos</a>");
                    out.println("&nbsp&nbsp<a href=\"lstTOCMain.jsp?pagination=N\">Siguientes</a>");
                    out.println("<br><br>");
                    resultsTable(out);
                /**
                * Pagination - Previous
                */
                } else if (pagination.equals("P")) {
                    /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
                    tocAL = conOracle.getPrevResultSetData(FILAS_POR_PAGINA);
                    /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
                    //numResults = db.getNumRowsRS();
                    out.println("<b>Número de resultados: " + numResults + "<b><br><br>");
                    it = tocAL.iterator();
                    int pageSize = tocAL.size();
                    if ((currentRow - pageSize) > 0)
                        currentRow -= FILAS_POR_PAGINA;
                    out.println("Resultados " + currentRow
                        + " al " + (currentRow + pageSize - 1));
                    out.println("&nbsp&nbsp<a href=\"lstTOCMain.jsp?pagination=P\">Previos</a>");
                    out.println("&nbsp&nbsp<a href=\"lstTOCMain.jsp?pagination=N\">Siguientes</a>");
                    out.println("<br><br>");
                    
                    resultsTable(out);
                }
           /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
            conOracle.Desconectar();
          /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
            %>
        </form>
    </body>
</html>
