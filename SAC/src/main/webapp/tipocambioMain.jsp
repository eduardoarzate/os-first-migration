<%
/*###############################################################################
# Nombre del Programa :  tipocambioMain.jsp                                     #
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
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 27/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!--Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación -->
<%@page import="com.wellcom.conexion.*"%>
<!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación -->
<%@page import="com.wellcom.io.HTML"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

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
    //Database db;
    /*Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación */
      ConexionORACLE conOracle = null;
    /*Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación */
    String sessionID;
    String GRUPO_SACII;
    String query;
    ArrayList tocAL;
    Iterator it;
    String[] colsTitles = {"BU","Proceso","Código Moneda","Fecha","Compra","Venta","Promedio","Registra","Fecha Registro","Modifica","Fecha Modificación","Modificar"};
    
    /**
    * HTML
    */
    HTML html;
    String btntipocambio;
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
                +"                <input type=\"submit\" name=\"btnedittipocambio\" value=\"Editar\" onclick=\"rbtnCheckedTipo();return false;\"/>"
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
    /*Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación */
     conOracle = new ConexionORACLE();
    sessionID = request.getRequestedSessionId();
    //db = (Database)session.getAttribute(sessionID + "db");
    //GRUPO_SACII = (String)session.getAttribute("GRUPO_SACII");
    /*Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación */
    /**************************************************************************/
    
    /**
    * HTML
    */
    html = new HTML();
    btntipocambio = request.getParameter("btntipocambio");
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
          if(btntipocambio != null && pagination == null) {
                    
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
                    
                  String[] colsTitles ={"BU","PROCESO","CODIGO MONEDA","FECHA","COMPRA","VENTA","PROMEDIO","U_REG","F_REG","U_UPD","F_UPD"};
                                                          query = " SELECT * FROM ( SELECT  \n"+
"       CASE \n"+
"           WHEN CR_SRCE = 11 AND CR_BU = 0 THEN 196 \n"+
"           WHEN CR_SRCE = 12 AND CR_BU = 0 THEN 211 \n"+
"           ELSE CR_BU \n"+
"        END CR_BU, \n"+
"        CASE \n"+
"           WHEN CR_SRCE = 11 AND CR_BU = 0 THEN '94 VISA' \n"+
"           WHEN CR_SRCE = 12 AND CR_BU = 0 THEN '98 MASTERCARD' \n"+
"           ELSE ENT.TIPO \n"+
"        END PROCESO, \n"+
"        CR_CD CODIGO_MONEDA, \n"+
"        TO_CHAR(CR_EFF_DT,'DD/MM/YYYY') FECHA, \n"+
"        CASE \n"+
"           WHEN CR_BU = 0    AND CR_SRCE = 11  THEN MAX(DECODE(RN,3,CR_RATE)) \n"+
"           ELSE MAX(DECODE(RN,1,CR_RATE)) \n"+
"        END COMPRA, \n"+
"        CASE \n"+
"           WHEN CR_BU = 1033 AND MAX(DECODE(RN,2,CR_RATE)) IS NULL THEN MAX(DECODE(RN,1,CR_RATE)) \n"+
"           WHEN CR_BU = 0    AND CR_SRCE = 11  THEN MAX(DECODE(RN,3,CR_RATE)) \n"+
"           ELSE MAX(DECODE(RN,2,CR_RATE)) \n"+
"        END VENTA, \n"+
"        CASE \n"+
"           WHEN CR_BU = 1033 AND MAX(DECODE(RN,3,CR_RATE)) IS NULL THEN MAX(DECODE(RN,1,CR_RATE)) \n"+
"           ELSE MAX(DECODE(RN,3,CR_RATE)) \n"+
"        END PROMEDIO, \n"+
"        CR_REG_USER U_REG, \n"+
"        TO_CHAR(MAX(CR_REG_DATE), 'dd/mm/yy hh24:mi:ss') F_REG, \n"+
"        CR_UPD_USER U_UPD, \n"+
"        TO_CHAR(MAX(CR_UPD_DATE), 'dd/mm/yy hh24:mi:ss') F_UPD  \n"+
" FROM ( \n"+
"     SELECT CR_BU, CR_CD, CR_RATE, CR_EFF_DT, CR_REG_USER, \n"+
"     CR_UPD_USER, CR_UPD_DATE, CR_REG_DATE, CR_SRCE, \n"+
"     CR_TYP RN "+
"     FROM CORE.CZ_CRNCY_RATE \n"+
"     WHERE CR_EFF_DT = TO_DATE('"+ txtfStartDate +"','DD/MM/YYYY') \n"+
"     AND CR_CD = 484 \n"+
"     ) \n"+
" INNER JOIN (  \n"+
"     SELECT VBA.BU_TX_ADQ BU,   \n"+
"     CASE  WHEN VBA.BU_TX_ADQ = 1033 THEN '1031 EMISOR DOLARES'   \n"+
"        ELSE VBA.ENTIDAD_PADRE||' '||VBA.DESCRIPCION   \n"+
"     END TIPO   \n"+
"     FROM PMADMIN.VW_BUS_ACQ VBA   \n"+
"     WHERE VBA.ENTIDAD_PADRE IN (31,94,98,194,230,1031,10001,694)   \n"+
"     UNION   \n"+
"     SELECT 194, '194 PROSA LIQUIDACION' FROM DUAL   \n"+
"     UNION   \n"+
"     SELECT 230, '230 DIARIO OFICIAL' FROM DUAL  \n"+
"     UNION   \n"+
"     SELECT 0, '0 PROSA PADRE' FROM DUAL  \n"+
" ) ENT  ON ENT.BU = CR_BU      \n"+
" WHERE CR_BU IN (145,194,196,211,230,279,1033, 0, 1306) \n"+
" GROUP BY CR_BU, CR_CD, CR_EFF_DT, CR_REG_USER, CR_UPD_USER, ENT.TIPO, CR_SRCE \n"+
" ORDER BY CR_BU )";
                                                          if((txtFiidVal == null || txtFiidVal.equals("None")) && !role.equals("banco")){
                                                                  query += " WHERE CR_BU IN (145,194,196,211,230,279,1033, 1306) \n";
                                                          } else if((txtFiidVal == null || txtFiidVal.equals("None")) && role.equals("banco")){
                                                                  query += " WHERE CR_BU IN (196,211) \n";
                                                          }else{
                                                                  query += " WHERE CR_BU = "+ txtFiidVal +" \n";
                                                          }
                                
                  System.out.println(query);
                  /*Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación */
                    conOracle.Conectar();
                  conOracle.Consultar(query);
                  //db.setQuerySelect(query);
                  //db.executeQuerySelect();
                  numResults = conOracle.getNumRowsRS();
                  if(numResults > 0) {
                      tocAL = conOracle.getNextResultSetData(100);
                  /*Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación */
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
              } else {
                  out.println("Los campos: " + html.validateFields().toString() + " son obligatorios.");
              }
          } else if(btntipocambio == null && pagination == null){
              out.println("<b>Resultados de B&uacute;squeda.</b>");
          /**
          * Pagination - Next
          */
          } else if(pagination.equals("N")) {
              /*Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación */      
              tocAL = conOracle.getNextResultSetData(100);
              /*Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación */      
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
              /*Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación */      
              tocAL = conOracle.getPrevResultSetData(100);
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
          conOracle.Desconectar();
              /*Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación */      
        %>
    </body>
</html>
