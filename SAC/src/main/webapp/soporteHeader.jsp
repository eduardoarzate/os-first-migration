<%
/*###############################################################################
# Nombre del Programa :  soporteHeader.jsp                                      #
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
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<%@ page import="com.wellcom.io.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>
<%@page import="com.wellcom.sql.Database"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Clob"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="java.io.*" %>
<%@page import="java.lang.*" %>
<!--Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación -->
<%@page import="com.wellcom.conexion.*"%>
<!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación -->

<%@page import="org.apache.commons.fileupload.*" %>

<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.ServletException" %>
<%@ page import="javax.servlet.http.HttpServlet" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %> 

<%@ page import="org.apache.commons.io.FilenameUtils" %> 

<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>

<%@ page import="java.lang.Object" %>
<%@page import="com.wellcom.sql.Database"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>



<%
        ArrayList cbFiid;
        HTML comboBox;
        //ComboBox myComboBox;

        RptUtils util = new RptUtils();
	
/* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
        ComboBoxGen myComboBox = new ComboBoxGen();
/* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */  
          ArrayList cbTipoDoc = myComboBox.getTipoDoc(session);
	
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
   
/* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
    ConexionORACLE conOracle = null;
/* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */  
        String sessionID;
    String query;
    String queryValida;
    ArrayList tocAL;
    Iterator it;
    String[] rowValue = null;
    int i;   
    int ResultValida;
    String[] tmpAStr;
 

  
    /*###############INICIO DE CAMBIO###############
    B-52-2103-14 Mejora al proceso de captura de paridades*/
    String queryVistaEmi;
    String queryInsTipCam01;
    String queryInsTipCam02;
    String queryUpda01;
    String queryUpda02;
    ArrayList<String> vistaAL = new ArrayList<String>();
    int ResultValidaVistaEmi = 0;
    String numeroProsa = null;
    ResultSet queryRs= null;
    /*###############FIN DE CAMBIO###############
    B-52-2103-14 Mejora al proceso de captura de paridades*/
    /**
    * Action type
    */
    String btneditarsoporte;
    String btnaggsoporte;
    String btninsertaregistro;
    String btnedita;
    String output;
    String campoBU;
    String campoCODIGO;
    String campoFECHA;
    String campoCOMPRA;
    String campoVENTA;
    String campoPROMEDIO;
    String valor = null;
    String txtfUsuario;
    String role;
        String 	resultadoAcion = "";

        String btntipocambio;

	
      
    sessionID = request.getRequestedSessionId();
  //  db = (Database)session.getAttribute(sessionID + "db");
    tocAL = (ArrayList)session.getAttribute(sessionID + "tocAL");
    
    txtfUsuario = (String)session.getAttribute("login");
    role = (String)session.getAttribute("role");
    btninsertaregistro = request.getParameter("btninsertaregistro"); //btnModGrpSacii = request.getParameter("btnModGrpSacii");
    btneditarsoporte = request.getParameter("btneditarsoporte");
    
        System.out.println("btneditarsoporte: "+ btneditarsoporte);
	
        String  btnsoporte = request.getParameter("btnsoporte");
	 
         if(btnsoporte != null){
                 System.out.println("Se presiono el bot�n btnsoporte");
		 
		 
         }
	 
                String  btndescargar = request.getParameter("btndescargar");
	 
          if(btndescargar != null){
                System.out.println("En soporteHeader.jsp: btndescargar");

                        String rbtndetallesoporte = (String)session.getAttribute("rbtndetallesoporte");
                         System.out.println("rbtndetallesoporte:  "+rbtndetallesoporte);

		
         }

        String  btneliminarsoporte = request.getParameter("btneliminarsoporte");
        String rbtn =  request.getParameter("rbtn");

 if(btneliminarsoporte != null){
                System.out.println("En soporteHeader.jsp: btneliminarsoporte");

		
                try{
/* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
        conOracle = new ConexionORACLE();
        conOracle.Conectar();
/* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */  
        String q1 = "DELETE FROM  PMADMIN.TBL_PMT_SOPORTE WHERE ID=?";
        System.out.println("Query1: " + q1);
        PreparedStatement ps = conOracle.PrepararSP(q1);
        ps.setString(1, rbtn);
        ps.executeUpdate();
        //conOracle.commit();
        System.out.println("Documento ID " + rbtn + " eliminado: OK");
        resultadoAcion = "--Documento ID " + rbtn + " eliminado correctamente--";	
                }catch(Exception ex) {
            System.out.println("_Delete_Error:  " + ex.getMessage());
                        resultadoAcion =  "_Delete_Error --> " + ex.getMessage();
/* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
        }  finally{ conOracle.Desconectar(); }
/* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */  
		
         }



if(btneditarsoporte !=null)
{
System.out.println("En soporteHeader.jsp: btneditarsoporte");
            String campoID = request.getParameter("id");
		
                System.out.println(" ID Doc: "+campoID);
		
                String campoTIPO  = null;
                String campoDESCRIPCION = null;
                String campoNM_PDF = null;
                int campoVERSION = 0;
                String campoUSUARIO = txtfUsuario;
                String campoESTATUS = "Activo";
		
		        
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String SYSDATE = dateFormat.format(date).toString();
		
		
                //SYSDATE="21-MAY-15";
                System.out.println("SYSDATE: "+SYSDATE);
		
			
                response.setContentType("text/html;charset=UTF-8");

        try {
/* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
       	conOracle = new ConexionORACLE();
/* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */  
            // Apache Commons-Fileupload library classes
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload sfu  = new ServletFileUpload(factory);

            if (! ServletFileUpload.isMultipartContent(request)) {
                System.out.println("sorry. No file uploaded");
                return;
            }

FileItem file;
FileItem  tipo;
FileItem desc;
            
			 
            // parse request
            List items = sfu.parseRequest(request);
		 
         			 
            FileItem  estatus = (FileItem) items.get(0);
                         campoESTATUS =  estatus.getString();
                                  System.out.println("campoESTATUS: "+campoESTATUS);

             file = (FileItem) items.get(1);					
                 campoNM_PDF = file.getString(); 
								   
                                   if(!campoNM_PDF.equals("null")){
					   
                                           file = (FileItem) items.get(2);				
                         campoNM_PDF = file.getName(); 
                                                 campoNM_PDF = FilenameUtils.getName(campoNM_PDF);
						
                                                System.out.println("campoNM_PDF: "+campoNM_PDF);



  
					   
                                           tipo = (FileItem) items.get(1);
                                                 campoTIPO =  tipo.getString();
                                                  System.out.println("campoTIPO: "+campoTIPO);
				   
                                           desc = (FileItem) items.get(3);
                                                 campoDESCRIPCION =  desc.getString();
                                                   System.out.println("campoDESCRIPCION: "+campoDESCRIPCION);
				   
                                   }

                   System.out.println(" Hay File?? " + file.getInputStream());
                        System.out.println(" Size  File: " +file.getSize());
	
			   
                    String q0="SELECT VERSION FROM PMADMIN.TBL_PMT_SOPORTE WHERE ID="+campoID;
                                    ResultSet rs = null;
/* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
                                        conOracle.Consultar(q0);
/* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */  
                            rs = conOracle.getResultSet();
										
                // Connect to Oracle
		
                         //   Class.forName("oracle.jdbc.driver.OracleDriver");
                      //      Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.255.220.97:1590:PMTU", "PMADMIN", "PMADMIN");
                           //             Connection con = db.getConnection();
                            //con.setAutoCommit(false);
					
                                         while (rs.next()) {
					
				
                                        campoVERSION = rs.getInt(1) +1;
					
                                    }
		
                                        if(campoNM_PDF.indexOf(".pdf")!=-1 || file.getSize()==0  ){
		
                                        if(file.getSize()!=0){
						
                                                System.out.println("Se edito el PDF");
                                        String q1="UPDATE  PMADMIN.TBL_PMT_SOPORTE\n"+
                                        " SET VERSION =?,USUARIO =? ,TIPO=?,NM_PDF=?,FILE_PDF=?,DESCRIPCION=?,FECHA_MODIFICACION=to_date(?,'dd/mm/yyyy'),ESTATUS=? WHERE ID=?";
					 
                                         System.out.println("Query1: "+q1);
					 
/* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
                            PreparedStatement ps = conOracle.PrepararSP(q1);
/* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */  
  		           
                                    ps.setInt(1, campoVERSION);
                            ps.setString(2, campoUSUARIO);
				
                                        ps.setString(3, campoTIPO);
                                        ps.setString(4, campoNM_PDF);

                            // size must be converted to int otherwise it results in error
                            ps.setBinaryStream(5, file.getInputStream(), (int) file.getSize());
                                        ps.setString(6, campoDESCRIPCION);	
                                        ps.setString(7, SYSDATE);		
                            ps.setString(8, campoESTATUS);
                                        ps.setString(9, campoID);
		            
                            ps.executeUpdate();
                            //conOracle.commit();
                            //con.close();
					
					
                                System.out.println("Documento ID "+campoID + "actualizado: OK");	
				
                                resultadoAcion =  "--Documento ID "+campoID + " actualizado correctamente--";
                                        }else{
                                                System.out.println("No se edito el PDF");
                                                String q2="UPDATE  PMADMIN.TBL_PMT_SOPORTE\n"+
                                        " SET VERSION =?,USUARIO =? ,TIPO=?,DESCRIPCION=?,FECHA_MODIFICACION=to_date(?,'dd/mm/yyyy'),ESTATUS=? WHERE ID=?";
					 
                                         System.out.println("Query2: "+q2);
					 
/* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
                            PreparedStatement ps = conOracle.PrepararSP(q2);
/* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */  
  		           
                                    ps.setInt(1, campoVERSION);
                            ps.setString(2, campoUSUARIO);
				
                                        ps.setString(3, campoTIPO);
					
                                        ps.setString(4, campoDESCRIPCION);	
                                        ps.setString(5, SYSDATE);		
                            ps.setString(6, campoESTATUS);
                                        ps.setString(7, campoID);
		            
                            ps.executeUpdate();
                            //conOracle.commit();
                           // con.close();
					
					
                                System.out.println("Documento ID "+campoID + " actualizado: OK");
				
                                resultadoAcion =  "--Documento ID "+campoID + " actualizado correctamente--";	
                                        }
                        }else{
                System.out.println("El documento que se adjunto no es un PDF, archivo: "+campoNM_PDF);
                resultadoAcion = "--S&oacute;lo se pueden adjuntar archivos con extensi&oacute;n .pdf, archivo: "+campoNM_PDF+"--";
					
                                        }
					
        }
        catch(Exception ex) {
            System.out.println("_Update_Error:  " + ex.getMessage());
                        resultadoAcion =  "_Update_Error --> " + ex.getMessage();
/* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
        }  finally{ conOracle.Desconectar(); }
/* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */  
				
}
    
else if(btninsertaregistro != null) 
{
        System.out.println("En soporteHeader.jsp: btninsertaregistro");
            int campoID = 0;
                String campoTIPO  = null;
                String campoDESCRIPCION = null;
                String campoNM_PDF = null;
                int campoVERSION = 0;
                String campoUSUARIO = txtfUsuario;
                String campoESTATUS = "Activo";
		        
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String SYSDATE = dateFormat.format(date).toString();
		
                //SYSDATE="21-MAY-15";
		
                                System.out.println("SYSDATE: "+SYSDATE);
			
                response.setContentType("text/html;charset=UTF-8");

        try {
/* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
       	conOracle = new ConexionORACLE();
/* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */  
            // Apache Commons-Fileupload library classes
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload sfu  = new ServletFileUpload(factory);

            if (! ServletFileUpload.isMultipartContent(request)) {
                System.out.println("sorry. No file uploaded");
                return;
            }

            // parse request
            List items = sfu.parseRequest(request);
            FileItem  tipo = (FileItem) items.get(0);
             campoTIPO =  tipo.getString();
                         System.out.println("campoTIPO: "+campoTIPO);
			 
            
            FileItem desc = (FileItem) items.get(2);
               campoDESCRIPCION =  desc.getString();
          System.out.println("campoDESCRIPCION: "+campoDESCRIPCION);
            
                        // get uploaded file
			
            FileItem file = (FileItem) items.get(1);
                   campoNM_PDF = file.getName(); 
                                    campoNM_PDF = FilenameUtils.getName(campoNM_PDF);    
					
                    System.out.println("campoNM_PDF: "+campoNM_PDF);


                    String q0="SELECT MAX(ID) FROM PMADMIN.TBL_PMT_SOPORTE";
                                    ResultSet rs = null;
/* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
                                     conOracle.Conectar();
                                        conOracle.Consultar(q0);
                            rs = conOracle.getResultSet();
                                         while (rs.next()) {
                                        int dbId = rs.getInt(1);
                                        campoID = dbId +1 ;
                                    }

                                        if(campoNM_PDF.indexOf(".pdf")!=-1){		
                // Connect to Oracle
                          //  Class.forName("oracle.jdbc.driver.OracleDriver");
                            //            Connection con = db.getConnection();
                            conOracle.getConnection().setAutoCommit(false);
/* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */  
					
                                        String q1="INSERT INTO PMADMIN.TBL_PMT_SOPORTE\n"+
                                        "(ID,VERSION,USUARIO,FECHA_CREACION,TIPO,NM_PDF,FILE_PDF,DESCRIPCION,FECHA_MODIFICACION,ESTATUS)\n"+
                                         "VALUES(?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,to_date(?,'dd/mm/yyyy'),?)";
					 
                            PreparedStatement ps = conOracle.PrepararSP(q1);
                            ps.setInt(1, campoID);
                                    ps.setInt(2, campoVERSION);
                            ps.setString(3, campoUSUARIO);
                                        ps.setString(4, SYSDATE);
                                        ps.setString(5, campoTIPO);
                                        ps.setString(6, campoNM_PDF);

                            // size must be converted to int otherwise it results in error
                            ps.setBinaryStream(7, file.getInputStream(), (int) file.getSize());
                                        ps.setString(8, campoDESCRIPCION);	
                                        ps.setString(9, SYSDATE);		
                            ps.setString(10, campoESTATUS);
		            
                            ps.executeUpdate();
/* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
                             conOracle.getConnection().commit();
                            //con.close();
					
					
					
                                        System.out.println("Documento ingresado: OK");
					
                                        resultadoAcion = "--Documento ingresado correctamente--";
                                        }else{
                                        System.out.println("El documento que se adjunto no es un PDF, archivo: "+campoNM_PDF);
                                        resultadoAcion = "--S&oacute;lo se pueden adjuntar archivos con extensi&oacute;n .pdf, archivo: "+campoNM_PDF+"--";
                                        }
        }
        catch(Exception ex) {
             System.out.println("_Insert_Error:  " + ex.getMessage());
                        resultadoAcion =  "_Insert_Error --> " + ex.getMessage();
        }  finally{ conOracle.Desconectar(); }
                /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */  


    }
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>SOPORTE INTERACTIVO</title>

        <script type="text/javascript">
            var span = null;
            // var ventana = null;
            var showTextInitDate = false;
            var showFiid = false;
            var numPage = 0;
            function valida(form1, accion)
            {

                try
                {
                    sendDatas("txtTipoDoc", "txtTipoDoc", "soporte", "tableTablaPrincipal");
                    return true;

                } catch (e) {
                }
            }

            function previewPdf() {

                window.open('reporte.jsp', 'VistaPrevia', 'menubar=no,resizable=yes,title=no,status=yes,toolbar=no,scrollbars=yes,alwaysRaised=yes,width=800,height=600');


            }

        </script>
        <script type="text/javascript" src="scripts/envio.js"></script>
    </head>
    <div align="center">
        <form action="aggsoporte.jsp" method="post" name="frmSoporteHeader" >
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tbl_border" >
                <tr>
                    <th id= "tituloTab" width="100%" colspan=5 ><font color="#000000">SOPORTE INTERACTIVO - Consultado documentos</font><font color="#000000"></font><br></th>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td colspan="3"><br/></td>
                </tr>


                <td><div align="right">Tipo de documento:</div></td>
                <td align="left">
                    <%
          comboBox = new HTML();
          out.println( "" + comboBox.getComboBox( "txtTipoDoc", cbTipoDoc, "--Todos--" ) );
                    %><br/>
                    <span id = "txtFiid" class="ocultar">Elije una Opci�n</span>
                </td>

                </tr>
                <td colspan=1><br/></td>
                </td>
                <tr>
                    <td colspan="6"><div align="center">
                            <input name="btnsoporte" type="button" id="btnsoporte" value="Buscar" onclick="javascript:return valida(this.form);">
                            <%
                             System.out.println("*****" + role);
                             if(!role.equals("banco")) {
                            %>
                            &nbsp;&nbsp;
                            <input type="submit" name="btnaggsoporte" value="Agregar">
                            <%
                            }
                            %>
                        </div></td>
                </tr> 
                <tr>
                    <td colspan="4">
                        <div id="divTablaPrincipal" align="center" >
                            <br/>
                            <br/>

                            <div id="tableTablaPrincipal" ><jsp:include page="soporteMain.jsp"/></div>	
                            <%
out.println(resultadoAcion); 
  resultadoAcion = "";           
                            %> 
                        </div>
                    </td>
                </tr>

            </table>

        </form>
    </div>
    <iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="scripts/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
    </iframe>


</body>
</html>
