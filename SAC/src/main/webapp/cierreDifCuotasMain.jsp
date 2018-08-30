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
#                                                                Modificaciones #
#-----------------------------------------------------------------------------  #
# Autor               :  Daniel Ramírez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 13/03/2017         #
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
<%@page import="com.wellcom.io.HTML"%>
<%@page import="com.wellcom.prosa.sacii.RptUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<!--Modificacion: SAS-DRT F-52-8063-16 Marca de inicio-->
<%@page import="com.wellcom.conexion.*"%>
<!--Modificacion: SAS-DRT F-52-8063-16 Marca de fin-->

<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>

<%
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
    }
    session.setAttribute("accion","consulta");
%>

<%!
    /**
    * Database
    */
   /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
    ConexionORACLEH conOracle = null;
   /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
    String sessionID;
    String GRUPO_SACII;
    String query;
    ArrayList tocAL;
    Iterator it;
    RptUtils util = new RptUtils();
    String[] colsTitles = {"Numero","Fecha Inicio","Fecha Fin","Bancomer","Banamex","Estatus","Registra","Fecha Registro","Modifica","Fecha Modificación"};
    
    /**
    * HTML
    */
    HTML html;
    String btnCierreDifCuotas;
    String btnProcesar;
    String txtfStartDate;
    String txtFiidVal;
    String role;
    
    
    /**
    * Pagination
    */
    int FILAS_POR_PAGINA;
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
            if(!role.equals("banco")){
            out.println(
                "<br><div align=\"center\">"
                +"    <table width=\"11%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">"
                +"        <tr>"
                +"            <td width=\"50%\"><div align=\"center\">"
                +"                <input type=\"submit\" name=\"btnedittipocambio\" value=\"Procesar\" onclick=\"rbtnCheckedDC();return false;\"/>"
                +"            </div></td>"
                +"        </tr>"
                +"    </table>"
                +"</div>"
            );
            }
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
    //db = (Database)session.getAttribute(sessionID + "dbSICB2");
    conOracle = new ConexionORACLEH();
   // GRUPO_SACII = (String)session.getAttribute("GRUPO_SACII");
   /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
    /**************************************************************************/
    
    /**
    * HTML
    */
    html = new HTML();
    btnCierreDifCuotas = request.getParameter("btnDifCuotas");
    btnProcesar = request.getParameter("btnprocesa");
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
        <script type="text/javascript">


        </script> 
    </head>
    <body>
        <%
          if(btnCierreDifCuotas != null && pagination == null) {
                    
              /**
              * Data
              **/
              txtfStartDate = request.getParameter("txtfStartDate");
              txtFiidVal = request.getParameter("txtFiidVal");
              session.setAttribute("txtfStartDate", txtfStartDate);
              session.setAttribute("txtFiidVal", txtFiidVal);
              role = (String)session.getAttribute("role");
                    
              html.addFieldToValidate("Fecha Inicio", txtfStartDate);
                    
              /**
              * Validate Fields
              **/
              if(html.validateFields().size() == 0) {
                    
                  String[] colsTitles ={"NUMERO","F_INI","F_FIN","BMR","BMX","ESTATUS","USR_REG","F_REG","USR_MOD","F_MOD"};
         query = "SELECT NUMERO, \n"+
         "       TO_CHAR(FECHA_INICIO, 'DD-MM-YYYY') F_INI, \n"+
         "       TO_CHAR(FECHA_FIN, 'DD-MM-YYYY') F_FIN, \n"+
         "       TO_CHAR(DIFERENCIA_BMR,'$999,999,999.00') BMR, \n"+
         "       TO_CHAR(DIFERENCIA_BMX,'$999,999,999.00') BMX, \n"+
         "       ESTATUS, \n"+
         "       USUARIO_REGISTRO USR_REG, \n"+
         "       TO_CHAR(FECHA_REGISTRO, 'DD-MM-YYYY HH24:MI:SS') F_REG, \n"+
         "       USUARIO_MODIFICA USR_MOD, \n"+
         "       TO_CHAR(FECHA_MODIFICA, 'DD-MM-YYYY HH24:MI:SS') F_MOD \n"+
         "   FROM SUPERSIC.PERIODOS_DIFE_CUOTAS \n"+
         "   WHERE ROWNUM <= 8 \n"+
         "   ORDER BY NUMERO DESC";

                  System.out.println(query);
                  /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
                  //db.setQuerySelect(query);
                  //db.executeQuerySelect();
                  conOracle.Conectar();
                  conOracle.Consultar(query);
                  numResults = conOracle.getNumRowsRS();
                  if(numResults > 0) {
                      tocAL = conOracle.getNextResultSetData(100);
                  /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/    
                      session.setAttribute(sessionID + "tocAL", tocAL);
                  }

                  if(tocAL != null && numResults != 0) {

                      /**
                      * Pagination
                      **/
                      currentRow = 1;
                      out.println("<b>Número de resultados: " + numResults + "<b><br><br>");
                      out.println("Resultados " + currentRow
                          + " al " + (numResults));
                      out.println("<br><br>");
                      /**
                      * Print Results
                      */
                      resultsTable(out);
                  } else {
                      out.println("No se encontraron Registros.");
                  }
                }
          } else if(btnCierreDifCuotas == null && pagination == null && btnProcesar == null){
              //out.println("<b>Resultados de B&uacute;squeda.</b>");
          } else if(btnProcesar != null){
                  String txtfEndDate   = (String)request.getParameter("campoFECHA_FIN");
                  String txtfIniDate   = (String)request.getParameter("campoFECHA_INI");
                  String usr = (String)session.getAttribute("login");
                	
                  util.creaArchFechas("SICLIF0310", util.convertFecha(txtfIniDate,"yyMMdd"), util.convertFecha(txtfEndDate,"yyMMdd"), usr);
                  util.lanzaCondicion("RPTUEGLB999G02_OK", util.convertFecha(txtfEndDate, "MMdd"), 1);
                  out.println("<b>Inició el proceso cierre de diferencias.</b>");
                	
          /**
          * Pagination - Next
          */
          } else if(pagination.equals("N")) {
              /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/      
              tocAL = conOracle.getNextResultSetData(100);
              /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
              //numResults = db.getNumRowsRS();
              out.println("<b>Número de resultados: " + numResults + "<b><br><br>");
              it = tocAL.iterator();
              int pageSize = tocAL.size();
              if((currentRow + pageSize) < numResults)
                  currentRow += 100;
              out.println("Resultados " + currentRow
                  + " al " + (currentRow + pageSize - 1));
              out.println("<br><br>");
              resultsTable(out);
          /**
          * Pagination - Previous
          */
          } else if (pagination.equals("P")) {
              /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
              tocAL = conOracle.getPrevResultSetData(100);
              /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
              //numResults = db.getNumRowsRS();
              out.println("<b>Número de resultados: " + numResults + "<b><br><br>");
              it = tocAL.iterator();
              int pageSize = tocAL.size();
              if ((currentRow - pageSize) > 0)
                  currentRow -= 100;
              out.println("Resultados " + currentRow
                  + " al " + (currentRow + pageSize - 1));
              out.println("<br><br>");
              resultsTable(out);
          }
          /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
            conOracle.Desconectar();
          /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
        %>
    </body>
</html>
