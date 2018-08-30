<%
/*###############################################################################
# Nombre del Programa :  soporteMain.jsp                                        #
# Autor               :  Salvador Montiel                                       #
# Compania            :  AM Estudio                                             #
# Proyecto/Procliente :  P-54-2940-14                     FECHA:27/04/2015      #
# Descripcion General :  Soporte interactivo (Chat FAQ Tutoriall y Manuales)    #
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :                                                         #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :                                                         #
#################################################################################
#                               MODIFICACIONES                                  #
#------------------------------------------------------------------------------ #
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#------------------------------------------------------------------------------ #
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!--Modificacion: SAS-DRT F-52-8063-16 Marca de inicio-->
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
    session.setAttribute("accion","consulta");
%>

<%!
    /**
    * Database
    */
     /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
    ConexionORACLE conOracle = null;
     /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */  
       String sessionID;
    String query;
    ArrayList tocAL;
    Iterator it;
   String[] colsTitles ={"ID","VERSION","USUARIO","FECHA_MODIFICACION","TIPO","NM_PDF","DESCRIPCION","ESTATUS","SELECCIONAR"};

          String role;
	
	
	
    /**
    * HTML
    */
    HTML html;
    String btnsoporte;
    String txtfStartDate;
    String txtTipoDoc;
  
    
    
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
                        System.out.println("role:   "+role);
           // if(!role.equals("banco")){
            out.println(
                "<br><div align=\"center\">"
                +"    <table width=\"11%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">"
                +"        <tr>"
                +"            <td width=\"50%\"><div align=\"center\">"
                +"                <input type=\"submit\" name=\"btndetallesoporte\" value=\"Consultar\" onclick=\"rbtnCheckedSoporte();return false;\"/>"
                +"            </div></td>"
                +"        </tr>"
                +"    </table>"
                +"</div>"
            );
            //}
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
%>
<%
    /**
    * Database
    */

    /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
        conOracle = new ConexionORACLE();
    /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */  
   sessionID = request.getRequestedSessionId();
    /**************************************************************************/
    
    /**
    * HTML
    */
    html = new HTML();
    btnsoporte = request.getParameter("btnsoporte");
    /**************************************************************************/
    
    /**
    * Pagination
    */
    FILAS_POR_PAGINA =
        ((Integer)session.getAttribute("FILAS_POR_PAGINA")).intValue();
    pagination = request.getParameter("pagination");
    /**************************************************************************/
	
        System.out.println("btnsoporte: "+ btnsoporte);
    String action = request.getParameter("action");
        System.out.println("En soporteMain.jsp");
                System.out.println("Action: "+action);
	
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
          if(btnsoporte != null && pagination == null) {
             
              /**
              * Data
              **/
              txtfStartDate = request.getParameter("txtfStartDate");
              txtTipoDoc = request.getParameter("txtTipoDoc");
              session.setAttribute("txtfStartDate", txtfStartDate);
              session.setAttribute("txtTipoDoc", txtTipoDoc);
              role = (String)session.getAttribute("role");
                    
              html.addFieldToValidate("Tipo documento", txtTipoDoc);
                                    if(btnsoporte != null && pagination == null) {
					
					
					
                                          query = " SELECT ID,VERSION,USUARIO,FECHA_MODIFICACION, TIPO, NM_PDF,DESCRIPCION \n"+
                                                                    " FECHA_CREACION,ESTATUS  \n"+
                                                                            " FROM PMADMIN.TBL_PMT_SOPORTE \n"+ 
                                                                            "   WHERE ESTATUS='Activo'";	
								
                                                          if(html.validateFields().size() == 0) {
                                                                  query +=" AND TIPO='"+txtTipoDoc+"'";
                                                          }
								
                                                          query +=" ORDER BY FECHA_MODIFICACION DESC";
								
                                      System.out.println(query);
                  /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */                                        
                  conOracle.Conectar();
                  conOracle.Consultar(query);
               
                  numResults = conOracle.getNumRowsRS();
 System.out.println("res: "+numResults);
                  if(numResults > 0) {
                      tocAL = conOracle.getNextResultSetData(100);
                  /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */                                        
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
          } else if(btnsoporte == null && pagination == null){
              out.println("<b>Resultados de B&uacute;squeda.</b>");
          /**
          * Pagination - Next
          */
          } else if(pagination.equals("N")) {
              /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */        
              tocAL = conOracle.getNextResultSetData(100);
              /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */        
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
              /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
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
           /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */  
        %>
    </body>
</html>
