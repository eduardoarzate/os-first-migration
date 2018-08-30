<%
/*###############################################################################
# Nombre del Programa :  descargarsoporteval.jsp                                #
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
# Autor               :                                                         #
# Compania            :                                                         #
# Proyecto/Procliente :                                                         #
#                                                        Fecha:                 #
# Modificación        :                                                         #
#                                                                               #
#-----------------------------------------------------------------------------  #
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<%@page language="java" import="java.io.InputStream,java.io.File,java.net.URL,java.io.BufferedInputStream,java.io.FileInputStream"%>
<%@page contentType="text/html"%><%@page pageEncoding="UTF-8"%>
<%@page import="com.wellcom.sql.Database"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Blob"%>
<%@ page import="javax.servlet.ServletException" %>
<%@ page import="javax.servlet.http.HttpServlet" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.OutputStream" %>
<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>


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
    Database db;
    String sessionID;
    String GRUPO_SACII;
    String query;
    ArrayList tocAL;
    Iterator it;
    String[] tmpAStr;
    String[] rowValue = null;
    int i;   
    /**
    * Action type
    */

    String btneditar;
	    String idDocumento;//String rbtnDelModGrpSacii;
	
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
	
	ComboBox myComboBox = new ComboBox();
	
	  
%><%
    /**
    * Action type
    */

	
    btneditar = request.getParameter("btneditar");
	
	idDocumento = request.getParameter("rbtn");
	session.setAttribute("idDocumento",idDocumento);


      /**
    * Database
    */
    sessionID = request.getRequestedSessionId();
    db = (Database)session.getAttribute(sessionID + "db");
    GRUPO_SACII = (String)session.getAttribute("GRUPO_SACII");
    tocAL = (ArrayList)session.getAttribute(sessionID + "tocAL");
	 session.setAttribute("tocAL",tocAL);
	 

	txtfUsuario = (String)session.getAttribute("login");
    /**************************************************************************/   
    /**
    * From "lstGrpSacii"
    */
    if(btneditar != null) {       
        /**
        * Get Row to Delete/Modify
        */
        i = 0;
        it = tocAL.iterator();
        while(it.hasNext()) {
            tmpAStr = (String[])it.next();
            if(Integer.parseInt(idDocumento) == i ) {
                rowValue = tmpAStr;
				break;
            }
            i++;
        }
        
        /**
        * Modify
        */
		
	 if(btneditar.equals("Editar")) {
		 System.out.println("En: EditarSoporte.jsp");
		 
			    String role = (String)session.getAttribute("role");
				String fecha = (String)session.getAttribute("fechaHoy");
             
			
            output =
"<div align=\"center\">"
			    +"  <form enctype=\"multipart/form-data\" action=\"soporte.jsp?btneditarsoporte=OK&id="+rowValue[0]+"\" method=\"post\" name=\"frmTOCHeader\"  >"
                +"    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"tbl_border\" summary=\"Modify a Group\">"
                +"<tr>"
    //            +"   <th class=\"td_header\" width=\"100%\" colspan=4 >SOPORTE INTERACTIVO - Detalle documento<br></th>"
	+"   <th id= \"tituloTab\" width=\"100%\" colspan=5 ><font color=\"#000000\">SOPORTE INTERACTIVO - Editando documento</font><font color=\"#000000\"></font><br></th>"
                +"</tr>"
				
				+"      <tr>"
                +"        <td><div align=\"right\">Id:</div></td>"
                +"        <td><div align=\"left\">"
                +"          &nbsp;<input name=\"campoID\" value=\""+rowValue[0]+"\" type=\"text\" id=\"campoID\" size=\"35\" maxlength=\"35\" disabled=\"disabled\">"
                +"        </div></td>"
                +"      </tr>"
				
                +"      <tr>"
                +"        <td><div align=\"right\">Usuario:</div></td>"
                +"        <td><div align=\"left\">"
                +"          &nbsp;<input name=\"campoUSUARIO\" value=\""+txtfUsuario+"\" type=\"text\" id=\"campoUSUARIO\" size=\"35\" maxlength=\"35\" disabled=\"disabled\">"
                +"        </div></td>"
                +"      </tr>"
				
				+"      <tr>"
                +"        <td><div align=\"right\">Estatus:</div></td>"
                +"        <td><div align=\"left\">"
 	            +"          <SELECT  name=\"campoESTATUS\" id=\"campoESTATUS\"> "
			    +"             <OPTION SELECTED>"+rowValue[7]+"</OPTION>"
			   // +"             <OPTION>Activo</OPTION>"
			   // +"             <OPTION>Inactivo</OPTION>"
 			    +"          </SELECT>"
                +"        </div></td>"
                +"      </tr>"
				
                +"      <tr>"
                +"        <td><div align=\"right\">Fecha:</div></td>"
                +"        <td><div align=\"left\">"
                +"          &nbsp;<input name=\"campoFECHA_CREACION\" type=\"text\" id=\"campoFECHA_CREACION\" size=\"15\" readonly maxlength=\"15\" value="+fecha+" disabled=\"disabled\" > "
                +"        </div></td>"
                +"      </tr>"
				
				
				+"      <tr>"
                +"        <td><div align=\"right\">Tipo documento:</div></td>"
                +"        <td><div align=\"left\">"				
 	            +"        <SELECT  name=\"campoTIPO\" id=\"campoTIPO\"> "
			    +"             <OPTION SELECTED>"+rowValue[4]+"</OPTION>"
			    +"             <OPTION>FAQ</OPTION>"
			    +"             <OPTION>MANUAL</OPTION>"
			    +"             <OPTION>TUTORIAL</OPTION>"
			    +"        </SELECT>"			
                +"        </div></td>"
                +"      </tr>"
                +" <span id = \"txtTipoVacio\" class=\"ocultar\"  >Debe seleccioar un tipo de documento</span> " 
                +"         <td><div align=\"right\">Documento PDF:</div></td>"
                +"         <td><div align=\"left\">"
                +"          &nbsp;<input name=\"campoFILE_PDF\"  type=\"file\" id=\"campoFILE_PDF\" size=\"7\" maxlength=\"7\" >"
				+"         <span id = \"txtFileVacio\" class=\"ocultar\">Es necesario adjuntar un archivo PDF</span> "
				+"         <span id = \"txtFileExt\" class=\"ocultar\">S&oacute;lo se pueden adjuntar archivos con ext .pdf</span> "
				+"         <span id = \"txtFileSize\" class=\"ocultar\">S&oacute;lo se pueden adjuntar archivos menores a 8 MB</span> "
 
                +"        </div></td>"
                +"      </tr>"
                +"        </tr>"
				
			    +"      <tr>"										
				+"        <td><div align=\"right\">Nombre documento:</div></td>"
                +"        <td><div  align=\"left\">"
                +"          &nbsp;<input name=\"campoNM_PDF\" value=\""+rowValue[5]+"\" type=\"text\" id=\"campoNM_PDF\" size=\"35\" maxlength=\"35\" disabled=\"disabled\">"
                +"        </div></td>"
                +"      </tr>"
				
                +"         <tr>"
                +"         <td><div align=\"right\">Descripción:</div></td>"
                +"         <td><div align=\"left\">"
                +"          &nbsp;<textarea name=\"campoDESCRIPCION\" rows=\"10\" cols=\"50\">"+rowValue[6]+"</textarea>"
                +"             <span id = \"txtDescVacio\" class=\"ocultar\">El documento debe tener una descripci&oacute;n</span> "
                +"        </div></td>"
                +"      </tr>"	
				
				
							
                +"        </tr>"

                +"      <td>"								
                +"        </td>"


		        +"<tr  align=\"center\" ><div align=\"center\" >"  
		
		        +" <td align= \"right\" width=\"30%\">"
		        +" </td>"
		   
		        +" <td align= \"right\" width=\"25%\">"
		        +"<input name=\"btneditarsoporte\" type=\"submit\" id=\"btneditarsoporte\" value=\"Guardar\" onclick=\"javascript:return valida();\">"
		        +"  </form>"
			    +" </td>"
			 
			    +" <td  align=\"left\" width=\"25%\" >"
				+"  <input name=\"btncancelarsoporte\" type=\"button\" id=\"btncancelarsoporte\" value=\"Cancelar\"onclick=\" location.href='soporte.jsp' \">"	
		        +" </td>"
		
		        +" <td align= \"right\" width=\"20%\">"
		        +" </td>"
		   
		        +" </div></td>"

                +"    </table>"				
				
                +"</div>" ;
				
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
       // var ventana = null;
        var showTipo = "OK";
        var showVenta = false;
        var showPromedio = false;
        var showFiid = false;
        var numPage=0;
        function valida()
        {   	


	        	
	        	try
	        	{
	      
		          if(document.frmTOCHeader.campoDESCRIPCION.value == "" || document.frmTOCHeader.campoDESCRIPCION.value == "None")
	        		{
	        			span = document.getElementById("txtDescVacio");
	           			span.style.display = 'inline';
	           			showTextInitDate = true;
	           			return false;
	        		}else if(document.frmTOCHeader.campoDESCRIPCION.value != ""){
						 span = document.getElementById("txtDescVacio");
	           			 span.style.display='none';	 
						
					}
					
				 if(document.frmTOCHeader.campoFILE_PDF.value != "" || document.frmTOCHeader.campoFILE_PDF.value != "None")
	        		{

					 
					 var input = document.getElementById('campoFILE_PDF');
                     var file = input.files[0];
					 var sizeFile = file.size;
                     var nameFile = document.frmTOCHeader.campoFILE_PDF.value;	
					 var extFile = nameFile.substring(nameFile.length-3,nameFile.length);
					 
					 if(extFile != "pdf"){
						span = document.getElementById("txtFileExt");
	           			span.style.display = 'inline';
	           			showTextInitDate = true;
	           			return false;
						 }else if(extFile == "pdf"){
							 span = document.getElementById("txtFileExt");
	           			     span.style.display='none';
						
							 }
					 if(sizeFile > 80000){
						 alert("El archivo es muy grande: "+sizeFile/1000000+" MB");
			   		   span = document.getElementById("txtFileSize");
	           			span.style.display = 'inline';
	           			showTextInitDate = true;
	           			return false;
						 
					 }else if(sizeFile < 80000){
						 span = document.getElementById("txtFileSize");
	           			 span.style.display='none';	 
						 }
					 
						
	        		}
									
		
					
					
					
					
	        		else
	        		{
	           			return true;
	        		}
	        	}catch(e){
	        	}
        	}
			

        </script>
    </head>  
    <body>
        <%
            out.println(output);            
        %>        
    </body>    
</html>
