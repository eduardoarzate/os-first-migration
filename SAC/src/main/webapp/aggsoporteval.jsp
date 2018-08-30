<%
/*###############################################################################
# Nombre del Programa :  aggsoporteval.jsp                                      #
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
<!--Modificacion: SAS-DRT F-52-8063-16 Marca de inicio-->
<%/*@page import="com.wellcom.sql.Database"*/%>
<!--Modificacion: SAS-DRT F-52-8063-16 Marca de fin-->
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<!--Modificacion: SAS-DRT F-52-8063-16 Marca de inicio-->
<%@page import="com.wellcom.prosa.sacii.ComboBoxGen"%>
<!--Modificacion: SAS-DRT F-52-8063-16 Marca de fin-->
<%@page import="com.wellcom.io.HTML"%>


<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>

<%
  HTML comboBox = new HTML();
  /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
  ComboBoxGen myComboBox = new ComboBoxGen();
  /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
 // session.setAttribute("accion","nvoTC");
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
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
   // Database db;
   /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
    String sessionID;
    int i;   
    /**
    * Action type
    */
    String btnaggsoporte;//String btnDelModGrpSacii;
    String btninsertaregistro;//String btnModGrpSacii;
    String output=null;
 
    String campoUSUARIO;
    String campoFECHA_CREACION;
        String campoESTATUS;
    String campoTIPO;
        String campoFILE_PDF;
        String campoDESCRIPCION;

    String txtfUsuario;
    
    
%>


<%
    /**
    * Action type
    */
    btnaggsoporte = request.getParameter("btnaggsoporte"); //btnDelModGrpSacii = request.getParameter("btnDelModGrpSacii");
    btninsertaregistro = request.getParameter("btninsertaregistro"); //btnModGrpSacii = request.getParameter("btnModGrpSacii");
 
    
    
    /**
    * Database
    */
    sessionID = request.getRequestedSessionId();
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
//    db = (Database)session.getAttribute(sessionID + "db");
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
    txtfUsuario = (String)session.getAttribute("login");
    /**************************************************************************/   
    /**
    * From "lstGrpSacii"
    */
    if(btnaggsoporte.equals("Agregar")) 
        {
               
               String fecha = (String)session.getAttribute("fechaHoy");

            output =
                "<div align=\"center\">"
                +"  <form enctype=\"multipart/form-data\" action=\"soporte.jsp?btninsertaregistro=OK\" method=\"post\" name=\"frmTOCHeader\"  >"
                +"    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"tbl_border\" summary=\"Modify a Group\">"
                +"<tr>"
    //            +"   <th class=\"td_header\" width=\"100%\" colspan=4 >SOPORTE INTERACTIVO - Detalle documento<br></th>"
        +"   <th id= \"tituloTab\" width=\"100%\" colspan=5 ><font color=\"#000000\">SOPORTE INTERACTIVO - Agregando documento</font><font color=\"#000000\"></font><br></th>"
                +"</tr>"
                +"      <tr>"
                +"        <td><div align=\"right\">Usuario:</div></td>"
                +"        <td><div align=\"left\">"
                +"          &nbsp;<input name=\"campoUSUARIO\" value=\""+txtfUsuario+"\" type=\"text\" id=\"campoUSUARIO\" size=\"10\" maxlength=\"10\" disabled=\"disabled\" >"
                +"        </div></td>"
                +"      </tr>"
                +"      <tr>"
                +"      <td align=\"right\"><strong>Fecha:</strong></td> "
                +"      <td align=\"left\"> "
                +"              <input name=\"campoFECHA_CREACION\" type=\"text\" id=\"campoFECHA_CREACION\" size=\"15\" readonly maxlength=\"15\" value="+fecha+" disabled=\"disabled\" > "
                +"              <a href=\"javascript:void(0)\" onclick=\"if(self.gfPop)gfPop.fPopCalendar(document.frmTOCHeader.campoFECHA_CREACION);return false;\" hidefocus> "
                +"                  <img name=\"popcalStart\" align=\"absmiddle\" src=\"scripts/calendar/calbtn.jpg\" border=\"0\" alt=\"\"> "
                +"              </a><br/> "
                +"      </td> "
                +"        </tr>"
                +"      <tr>"
                +"        <td><div align=\"right\">Estatus:</div></td>"
                +"        <td><div align=\"left\">"
                +"          &nbsp;<input name=\"campoESTATUS\" value=\"Activo\" type=\"text\" id=\"campoESTATUS\" size=\"10\" maxlength=\"10\" disabled=\"disabled\" >"
                +"        </div></td>"
                +"      </tr>"
                +"      <tr>"
                +"        <td><div align=\"right\">Tipo de documento:</div></td> "
                +"        <td><div align=\"left\"> ";
  							
                 output += comboBox.getComboBox( "campoTIPO", cbTipoDoc, "Tipo..." );
	                        
                 output +="            <span id = \"txtTipoVacio\" class=\"ocultar\"  >Debe seleccioar un tipo de documento</span> "
                                +"		</div></td> "
                +"      </tr>"				
                +"         <tr>"
                +"         <td><div align=\"right\">Documento PDF:</div></td>"
                +"         <td><div align=\"left\">"
                +"          &nbsp;<input name=\"campoFILE_PDF\"  type=\"file\" id=\"campoFILE_PDF\" size=\"7\" maxlength=\"7\" >"
                                +"         <span id = \"txtFileVacio\" class=\"ocultar\">Es necesario adjuntar un archivo PDF</span> "
                                +"         <span id = \"txtFileExt\" class=\"ocultar\">S&oacute;lo se pueden adjuntar archivos con ext .pdf</span> "
                                +"         <span id = \"txtFileSize\" class=\"ocultar\">S&oacute;lo se pueden adjuntar archivos menores a 8 MB</span> "
                +"        </div></td>"
                +"      </tr>"
                +"        </tr>"
                +"         <tr>"
                +"         <td><div align=\"right\">Descripción:</div></td>"
                +"         <td><div align=\"left\">"
                +"          &nbsp;<textarea name=\"campoDESCRIPCION\" rows=\"10\" cols=\"50\"></textarea>"
                +"             <span id = \"txtDescVacio\" class=\"ocultar\">El documento debe tener una descripci&oacute;n</span> "
                +"        </div></td>"
                +"      </tr>"
                +"        </tr>"

                        +"<tr  align=\"center\" ><div align=\"center\" >"  
		
                        +" <td align= \"right\" width=\"30%\">"
                        +" </td>"
		   
                        +" <td align= \"right\" width=\"25%\">"
                        +"          &nbsp;<input name=\"btninsertaregistro\" type=\"submit\" id=\"btninsertaregistro\" value=\"Guardar\" onclick=\"javascript:return valida(this.form);\">"
                        +"  </form>"
                            +" </td>"
			 
                            +" <td  align=\"left\" width=\"25%\" >"
                                +"  <input name=\"btncancelarsoporte\" type=\"button\" id=\"btncancelarsoporte\" value=\"Cancelar\"onclick=\" location.href='soporte.jsp' \">"			
                        +" </td>"
		
                        +" <td align= \"right\" width=\"20%\">"
                        +" </td>"
		   
                        +" </div></td>"

                +"    </table>"				
				
                +"</div>" 
	
                                +"<iframe width=174 height=189 name=\"gToday:normal:agenda.js\" id=\"gToday:normal:agenda.js\" src=\"scripts/calendar/ipopeng.htm\" scrolling=\"no\" frameborder=\"0\" style=\"visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;\">"
				
                +"</iframe>";
				

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
            var numPage = 0;
            function valida(form1)
            {

                try
                {


                    if (document.frmTOCHeader.campoTIPO.value == "" || document.frmTOCHeader.campoTIPO.value == "None")
                    {
                        span = document.getElementById("txtTipoVacio");
                        span.style.display = 'inline';
                        showTipo == true;
                        return false;

                    } else if (document.frmTOCHeader.campoTIPO.value != "" || document.frmTOCHeader.campoTIPO.value != "None")
                    {
                        span = document.getElementById("txtTipoVacio");
                        span.style.display = 'none';
                    }


                    if (document.frmTOCHeader.campoFILE_PDF.value == "" || document.frmTOCHeader.campoFILE_PDF.value == "None")
                    {
                        span = document.getElementById("txtFileVacio");
                        span.style.display = 'inline';
                        showTextInitDate = true;
                        return false;
                    } else if (document.frmTOCHeader.campoFILE_PDF.value != "" || document.frmTOCHeader.campoFILE_PDF.value != "None")
                    {

                        span = document.getElementById("txtFileVacio");
                        span.style.display = 'none';

                        var input = document.getElementById('campoFILE_PDF');
                        var file = input.files[0];
                        var sizeFile = file.size;
                        var nameFile = document.frmTOCHeader.campoFILE_PDF.value;
                        var extFile = nameFile.substring(nameFile.length - 3, nameFile.length);

                        if (extFile != "pdf") {
                            span = document.getElementById("txtFileExt");
                            span.style.display = 'inline';
                            showTextInitDate = true;
                            return false;
                        } else if (extFile == "pdf") {
                            span = document.getElementById("txtFileExt");
                            span.style.display = 'none';

                        }
                        if (sizeFile > 80000) {
                            alert("El archivo es muy grande: " + sizeFile / 1000000 + " MB");
                            span = document.getElementById("txtFileSize");
                            span.style.display = 'inline';
                            showTextInitDate = true;
                            return false;

                        } else if (sizeFile < 80000) {
                            span = document.getElementById("txtFileSize");
                            span.style.display = 'none';
                        }


                    }

                    if (document.frmTOCHeader.campoDESCRIPCION.value == "" || document.frmTOCHeader.campoDESCRIPCION.value == "None")
                    {
                        span = document.getElementById("txtDescVacio");
                        span.style.display = 'inline';
                        showTextInitDate = true;
                        return false;
                    } else if (document.frmTOCHeader.campoDESCRIPCION.value != "") {
                        span = document.getElementById("txtDescVacio");
                        span.style.display = 'none';

                    } else
                    {
                        return true;
                    }
                } catch (e) {
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
