<%
/*###############################################################################
# Nombre del Programa :  detallesoporteval.jsp                                 #
# Autor               :  Salvador Montiel                                       #
# Compania            :  AM Estudio                                             #
# Proyecto/Procliente :  P-54-2940-14                     FECHA:27/04/2015      #
# Descripcion General :  Soporte interactivo (Chat FAQ Tutoriales y Manuales)   #
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
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 12/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!-- Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */-->
<%/*@page import="com.wellcom.sql.Database"*/%>
<%@page import="com.wellcom.conexion.*"%>
<!-- Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */-->
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.sql.ResultSet"%>
<%@ page import="java.io.FileOutputStream" %>
<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="java.io.File" %>

<%@ page import="java.io.BufferedWriter" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileWriter" %>
<%@ page import="java.io.IOException" %>
<%@ page import="javax.servlet.ServletConfig" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.Blob"%>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.OutputStream" %>
<%@ page import="java.io.FileOutputStream" %>
<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="java.io.BufferedOutputStream" %>


<%@ page import="java.io.*" %> 
<%@ page import="java.lang.*" %> 
<%@ page import="java.sql.*" %> 
<%@ page import="javax.servlet.ServletException" %>
<%@ page import="javax.servlet.http.HttpServlet" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>



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
    ConexionORACLE conOracle = null;
    String sessionID;
   // String GRUPO_SACII;
    /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
    String query;
    ArrayList tocAL;
    Iterator it;
    String[] tmpAStr=null;
    String[] rowValue=null;
    int i;   
    /**
    * Action type
    */
    String rbtndetallesoporte;//String rbtnDelModGrpSacii;
    String btndetallesoporte;//String btnDelModGrpSacii;
    String btnedita;//String btnModGrpSacii;
	
        //String btndescarga;
	
	
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
         String role;

          byte[] FILE_PDF = null;


%>


<%
    /**
    * Action type
    */
    rbtndetallesoporte = request.getParameter("rbtn");//rbtnDelModGrpSacii = request.getParameter("rbtn");
        session.setAttribute("rbtndetallesoporte",rbtndetallesoporte);
    btndetallesoporte = request.getParameter("btndetallesoporte");//btnDelModGrpSacii = request.getParameter("btnDelModGrpSacii");
    btnedita = request.getParameter("btnedita");//btnModGrpSacii = request.getParameter("btnModGrpSacii");
 
  //  btndescarga =  "DESCARGAR";//request.getParameter("btndescarga");
    
    /**
    * Database
    */
    sessionID = request.getRequestedSessionId();
    /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
    //db = (Database)session.getAttribute(sessionID + "db");
    //GRUPO_SACII = (String)session.getAttribute("GRUPO_SACII");
    /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
    tocAL = (ArrayList)session.getAttribute(sessionID + "tocAL");
         session.setAttribute("tocAL",tocAL);
          role = (String)session.getAttribute("role");
	 

        txtfUsuario = (String)session.getAttribute("login");
    /**************************************************************************/   
    /**
    * From "lstGrpSacii"
    */
    if(btndetallesoporte != null) {       
        /**
        * Get Row to Delete/Modify
        */
        i = 0;
        it = tocAL.iterator();
        while(it.hasNext()) {
            tmpAStr = (String[])it.next();
            if(Integer.parseInt(rbtndetallesoporte) == i ) {
                rowValue = tmpAStr;
				
                                break;
            }
            i++;
			
		
        }
        
        /**
        * Modify
        */
		
         if(btndetallesoporte.equals("Consultar")) {
		 
                  System.out.println("En detallesoporteval.jsp: btndetallesoporte ");
		  
			   
               String txtfStartDate = (String)session.getAttribute("txtfStartDate");
               String txtFiidVal = (String)session.getAttribute("txtFiidVal");
            session.setAttribute("rowValuetipoSacii", rowValue);    
                        String NM_PDF = null;

                                                 ArrayList pdfs = null;
                                                 String[] arrayPdf = null;
try{
    /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
                conOracle = new ConexionORACLE();
                conOracle.Conectar();
		        		
                                                        // Connect to Oracle
                        //    Class.forName("oracle.jdbc.driver.OracleDriver");
                                        Connection con =  conOracle.getConnection();
    /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
                           con.setAutoCommit(false);
					
		      
                                        String q0="SELECT id, nm_pdf, file_pdf FROM PMADMIN.TBL_PMT_SOPORTE WHERE ID=? ";
									
                                                PreparedStatement ps = conOracle.getConnection().prepareStatement(q0);			
                                            ps.setString(1,rowValue[0]);
                        ResultSet rs = ps.executeQuery();
					
                                                System.out.println("Ejecuto el query: "+ q0);	
					
                                          while (rs.next()) {
                                                int dbId = rs.getInt(1);
                                                int campoID = dbId +1 ;
                                                NM_PDF = rs.getString(2);
                                                    System.out.println("Detalle_NM_PDF: "+ NM_PDF);
						
                                        FILE_PDF = rs.getBytes(3);					
                                               System.out.println("FILE_PDF: "+ FILE_PDF);
					
                                                request.setAttribute("FILE_PDF", FILE_PDF);
                                                session.setAttribute("bytes",FILE_PDF);

					
                                  }

                                        } catch (Exception e){
                        System.out.println("Error: "+ e);
                        /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
                }finally{ conOracle.Desconectar(); }	
                       /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */


            output =
                "<div id=\"main\" align=\"center\">"
                                 +"<form action=\"soporte.jsp\" method=\"post\" name=\"frmSoporteHeader\" >"
                +"    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"tbl_border\" summary=\"Modify a Group\">"
                +"<tr>"
    //            +"   <th class=\"td_header\" width=\"100%\" colspan=4 >SOPORTE INTERACTIVO - Detalle documento<br></th>"
        +"   <th id= \"tituloTab\" width=\"100%\" colspan=5 ><font color=\"#000000\">SOPORTE INTERACTIVO - Detalle documento</font><font color=\"#000000\"></font><br></th>"
                +"</tr>";
%>
<%
 if(!role.equals("banco")){
output += "      <tr>"
+"        <td><div align=\"right\">Id:</div></td>"
+"        <td><div align=\"left\">"
+"          &nbsp;<input name=\"campoID\" value=\""+rowValue[0]+"\" type=\"text\" id=\"campoID\" size=\"35\" maxlength=\"35\" disabled=\"disabled\">"
+"        </div></td>"
+"      </tr>"
+"      <tr>"
+"        <td><div align=\"right\">Usuario:</div></td>"
+"        <td><div align=\"left\">"
+"          &nbsp;<input name=\"campoUSUARIO\" value=\""+rowValue[2]+"\" type=\"text\" id=\"campoUSUARIO\" size=\"35\" maxlength=\"35\" disabled=\"disabled\">"
+"        </div></td>"
+"      </tr>";
 }
%>
<%
                output += "      <tr>"
+"        <td><div align=\"right\">Estatus:</div></td>"
+"        <td><div align=\"left\">"
+"          &nbsp;<input name=\"campoESTATUS\" value=\""+rowValue[7]+"\" type=\"text\" id=\"campoESTATUS\" size=\"35\" maxlength=\"35\" disabled=\"disabled\">"
+"        </div></td>"
+"      </tr>"				
+"      <tr>"
+"        <td><div align=\"right\">Fecha:</div></td>"
+"        <td><div align=\"left\">"
+"          &nbsp;<input name=\"campoFECHA\" value="+rowValue[3]+" type=\"text\" id=\"campoFECHA\" size=\"35\" maxlength=\"35\" disabled=\"disabled\" >"
+"        </div></td>"
+"      </tr>"
                +"      <tr>"
+"        <td><div align=\"right\">Tipo documento:</div></td>"
+"        <td><div align=\"left\">"
+"          &nbsp;<input name=\"campoTIPO\" value=\""+rowValue[4]+"\" type=\"text\" id=\"campoTIPO\" size=\"35\" maxlength=\"35\" disabled=\"disabled\">"
+"        </div></td>"
+"      </tr>"
                +"        <td><div align=\"right\">Nombre documento:</div></td>"
+"        <td><div  align=\"left\">"
                +"          &nbsp;<a href=\"javascript: void(0)\" onclick=\"previewPdf()\">"+rowValue[5]+"</a>"
+"        </div></td>"
+"      </tr>"
+"        <td><div align=\"right\">Descripción:</div></td>"
+"        <td><div align=\"left\">"
+"        &nbsp;<textarea name=\"campoDESCRIPCION\"  rows=\"10\" cols=\"50\"disabled=\"disabled\">"+rowValue[6]+"</textarea> "
			
+"        </div></td>"
+"      </tr>"
                +"                <tr>"
+"             <td colspan=\"6\"><div align=\"center\">"
 +"                  <input name=\"btncancelar\" type=\"submit\" id=\"btncancelar\" value=\"Regresar\"/>";
                  
%>
<%
 System.out.println("*****" + role);
 if(!role.equals("banco")) {
                                
output+=" &nbsp;<input name=\"btneditar\" type=\"button\" id=\"btneditar\" value=\"Editar\"onclick=\"editarSoporte("+rbtndetallesoporte+");return false;\"/>"  
					 
          +" &nbsp;<input name=\"btneditar\" type=\"button\" id=\"btneliminar\" value=\"Eliminar\"onclick=\"eliminarSoporte("+rowValue[0]+");return false;\"/>"  
					 
					  
+" </div></td>"
+" </tr>";
                                 }
%>
<%
            output+="  </table>"
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
            function previewPdf() {

                window.open('reporte.jsp', 'VistaPrevia', 'menubar=no,resizable=yes,title=no,status=yes,toolbar=no,scrollbars=yes,alwaysRaised=yes,width=800,height=600');


            }


        </script>
    </head>      

    <body>

        <%
            out.println(output);    
        %>  



    </body>    
</html>
