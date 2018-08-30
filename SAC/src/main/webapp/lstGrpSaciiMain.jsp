<%
/*###############################################################################
# Nombre del Programa :  lstGrpSaciiMain.jsp                                    #
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
#-----------------------------------------------------------------------------  #
# Autor               :  Daniel Ramírez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 06/03/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@page import="com.wellcom.sql.Database"%>
<%@page import="com.wellcom.io.HTML"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<!--Modificacion: SAS-DRT F-52-8063-16 Marca de inicio-->
<%@page import="com.wellcom.conexion.*"%>
<%@page import="java.sql.*"%>
<!--Modificacion: SAS-DRT F-52-8063-16 Marca de fin-->

<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>

<%
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
    }
%>

<%!
    /**
    * Database
    */
    //Database db;
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
    ConexionORACLE conOracle = null;
    ArrayList temp;
     int f=0;
     int restante= 0;
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
    String sessionID;
    String GRUPO_SACII;
    String query;
    ArrayList tocAL;
    Iterator it;
    String[] colsTitles = {"Numero","Liquidacion","Fecha Liberacion","Estatus", "Usuario Registro","Fecha Registro","Usuario Modifica","Fecha Modifica","Eliminar/Modificar"};
    
    /**
    * HTML
    */
    HTML html;
    String btnLstGrpSacii;
    String txtfStartDate;
    String txtfEndDate;
    String txtfGrp;
    
    /**
    * Pagination
    */
    int FILAS_POR_PAGINA;
    String pagination;
    int currentRow;
    int numResults;
    int numFinal;
    ResultSet resultset;

    /**
    * Print Results
    */
    void resultsTable(javax.servlet.jsp.JspWriter out) {
        
        try {
            html.setCSSTable("titTablaTransDaily");
            html.setCSSTRTable("datosTablaTransDaily");
            out.println(html.getTableRadioBtn(colsTitles, temp));
            out.println(
                "<br><div align=\"center\">"
                +"    <table width=\"11%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">"
                +"        <tr>"
                +"            <td width=\"50%\"><div align=\"center\">"
                +"                <input type=\"submit\" name=\"btnDelModGrpSacii\" value=\"Liberar\" onclick=\"rbtnChecked();return false;\" />"
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
    //db = (Database)session.getAttribute(sessionID + "db");
        conOracle = new ConexionORACLE();
    //GRUPO_SACII = (String)session.getAttribute("GRUPO_SACII");
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
    /**************************************************************************/
    
    /**
    * HTML
    */
    html = new HTML();
    btnLstGrpSacii = request.getParameter("btnLstGrpSacii");
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
          if(btnLstGrpSacii != null && pagination == null) {
                    
              /**
              * Data
              **/
              txtfStartDate = request.getParameter("txtfStartDate");
              txtfEndDate = request.getParameter("txtfEndDate");
              session.setAttribute("txtfStartDate", txtfStartDate);
              session.setAttribute("txtfEndDate", txtfEndDate);
              //txtfGrp = request.getParameter("txtfGrp");
                    
              html.addFieldToValidate("Fecha Inicio", txtfStartDate);
              html.addFieldToValidate("Fecha Fin", txtfEndDate);
              //html.addFieldToValidate("Grupo", txtfGrp);
                    
              /**
              * Validate Fields
              **/
              if(html.validateFields().size() == 0) {
                    
                  String[] colsTitles ={"PSI_NSI_CLR_ID","NCI_NSI_CLR_D","PSI_SETL_DT","PSI_USR_CHNG","PSI_IND"};
                  query = " SELECT PSI_NSI_CLR_ID,  NCI_NSI_CLR_D, TO_CHAR(PSI_SETL_DT, 'dd/mm/yyyy hh24:mi:ss') AS PSI_SETL_DT, DECODE(PSI_IND,0,'PROCESADO',1,'LIBERADO',2,'CONTINGENCIA'), PSI_USR_REC, TO_CHAR(PSI_REC_DT, 'dd/mm/yyyy hh24:mi:ss') AS PSI_REC_DT, PSI_USR_CHNG, TO_CHAR(PSI_CHNG_DT, 'dd/mm/yyyy hh24:mi:ss') " +
                          " FROM pmadmin.PRSA_SETL_IND PSI, pmadmin.sv_nsi_clr_id SNCI "+
                          " WHERE PSI.PSI_NSI_CLR_ID=SNCI.NCI_NSI_CLR_ID  AND TRUNC(PSI_REC_DT) BETWEEN "+ 
                          " TO_DATE('" + txtfStartDate + "', 'dd/mm/yyyy') " +
                          " AND TO_DATE('" + txtfEndDate + "', 'dd/mm/yyyy') "+
                          " AND PSI_NSI_CLR_ID NOT IN (53,52,54,28,25,29,31) ";
                  //System.out.println(query);
                  /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
                 // db.setQuerySelect(query);
                  //db.executeQuerySelect();
                  conOracle.Conectar();
                 resultset= conOracle.Consultar(query);
                  
                  numResults = conOracle.getNumRowsRS();
                  
                  /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
                  if(numResults > 0) {
                      tocAL = conOracle.getNextResultSetData(numResults);
                         temp=new ArrayList();
              System.out.println("tamal: "+tocAL.size());
                           for(int i=0;i <100;i++){
                               if(i<tocAL.size()){
                               temp.add(tocAL.get(i));
                               }
              
                        }
                      session.setAttribute(sessionID + "tocAL", tocAL);
                  }

                  if(temp != null) {

                      /**
                      * Pagination
                      **/
                      
                      currentRow = 1;
                      numFinal = numResults < 100 ? numResults : ((numResults-(((numResults-numResults%100)/100-1)*100))-numResults%100);
                      out.println("<b>Número de resultados: " + numResults + "<b><br><br>");
                      out.println("Resultados " + currentRow
                          + " al " + numFinal);
                      out.println("&nbsp&nbsp<a href=\"lstGrpSacii.jsp?pagination=P\">Previos</a>");
                      out.println("&nbsp&nbsp<a href=\"lstGrpSacii.jsp?pagination=N\">Siguientes</a>");
                      out.println("<br><br>");
                      currentRow=1;
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
          } else if(btnLstGrpSacii == null && pagination == null){
              out.println("<b>Resultados de B&uacute;squeda.</b>");
          /**
          * Pagination - Next
          */
          } else if(pagination.equals("N")) {
              /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/   
              //numResults = db.getNumRowsRS();
                ArrayList temp1= (ArrayList)session.getAttribute(sessionID + "tocAL");
              out.println("<b>Número de resultados: " + temp1.size() + "<b><br><br>");
              it = temp1.iterator();
              
              int pageSize = temp1.size();
              
              /*Valida si el contador superar el numero de resultados aumenta lo que resta del MOD*/
              out.println(currentRow +" asd");
             
              if((currentRow+100) > temp1.size()-(temp1.size()%100)){
                  if(currentRow >100){
                  restante = temp1.size()%100;
                  }
              }
              int sumarCantidad=0;
              if((currentRow+100) < temp1.size()){
                  if(currentRow+100 >99){
                    currentRow += 100;
                    sumarCantidad = 100;
                    if(currentRow+1==  temp1.size()){
                    f=(((numResults-(((numResults-numResults%100)/100-1)*100))-numResults%100)+sumarCantidad+restante);
                    }else if((numResults-numResults%100)/100-1!=0){
                    f=(((numResults-(((numResults-numResults%100)/100-1)*100))-numResults%100)+sumarCantidad);
                    }else{
                    f=pageSize;
                    }
                    
                  }
              }else{
              f=pageSize;
              }
              out.println("Resultados " + currentRow + " al " +f);
              out.println("&nbsp&nbsp<a href=\"lstGrpSacii.jsp?pagination=P\">Previos</a>");
              out.println("&nbsp&nbsp<a href=\"lstGrpSacii.jsp?pagination=N\">Siguientes</a>");
              out.println("<br><br>");
              //tocAL = conOracle.getNextResultSetData(100);
                temp=new ArrayList();
                /*Resta 1 ya que en el arreglo empieza desde 0 y no desde 1*/
                for(int i=currentRow-1;i <=(currentRow+restante+99);i++){
                    if(i<temp1.size()){
                       temp.add(temp1.get(i));
                        }             
                }                    
              /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
              resultsTable(out);
          /**
          * Pagination - Previous
          */
          } else if (pagination.equals("P")) {
              /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
               ArrayList temp1= (ArrayList)session.getAttribute(sessionID + "tocAL");
             // tocAL = conOracle.getPrevResultSetData(100);
              //numResults = db.getNumRowsRS();
              out.println("<b>Número de resultados: " + numResults + "<b><br><br>");
              it = temp1.iterator();
              int pageSize =0;
              //out.println(currentRow+ " aqui: "+pageSize);
             if (currentRow>100){
                 if((temp1.size()-temp1.size()%100)-100==0){
                  currentRow -= +100;
                 }else{
                  currentRow -= (temp1.size()-temp1.size()%100)-100;
                 }
            }
             if(temp1.size()<100){
                 pageSize=temp1.size();
             }else if((temp1.size()-temp1.size()%100)-100!=0){
             pageSize=currentRow+99;
             }else{
                 pageSize=temp1.size();
             }
              out.println(restante+"Resultados " + currentRow
                  + " al " + pageSize);
              out.println("&nbsp&nbsp<a href=\"lstGrpSacii.jsp?pagination=P\">Previos</a>");
              out.println("&nbsp&nbsp<a href=\"lstGrpSacii.jsp?pagination=N\">Siguientes</a>");
              out.println("<br><br>");
                        temp=new ArrayList();
                        for(int i=currentRow-1;i <=currentRow+100;i++){
                               if(i<temp1.size()){
                               temp.add(temp1.get(i));
                               }
                        }
              resultsTable(out);
          }
          conOracle.Desconectar();
          /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
        %>
    </body>
</html>
