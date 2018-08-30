<%
/*###############################################################################
# Nombre del Programa :  login.jsp		                                        #
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
# Autor               : German Gonzalez Esquivel                                #
# Compania            : WELLCOM S.A. DE C.V.                                    #
# Proyecto/Procliente : P-54-2452-14                 Fecha:07-08-2014           #
# Modificacion        : Cambio para la validacion de usuario                    #
#-----------------------------------------------------------------------------  #
# Autor               :  Daniel Ramírez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-----------------------------------------------------------------------------  #
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<%@page contentType="text/html" errorPage="errorPage.jsp"%>
<%@page pageEncoding="UTF-8"%>
<jsp:useBean id="myJndi" scope="session" class="com.wellcom.directory.Jndi"/>
<%@page import="com.wellcom.logger.FactoryHandler"%>
<%@page import="java.util.logging.Handler"%>
<%
    String login;
    String password;
    String myRole;
    String myOu1st;
    String myOu2nd;
    String myOu3rd;
    String myLogin;
    //Integer rolAccVal=0;
    int rolAccVal=0;
%>

<%
        //ServletContext context = getServletContext();
        ServletContext context = getServletConfig().getServletContext();

        String appLoggerFile=context.getRealPath(context.getInitParameter("APP_LOGGER_FILE"));
        String appLoggerLevel=context.getInitParameter("APP_LOGGER_LEVEL");
    	
    	java.util.logging.Logger logger;
    	String active=context.getInitParameter("APP_LOGGER_ACTIVE");
    	if(active!=null&&active.toUpperCase().equals("TRUE"))
    	   logger=java.util.logging.Logger.getLogger("pmrLog");
    	else
    	   logger=null;
    	if(logger!=null){
    	Handler[] handlers= logger.getHandlers();
    	if(handlers.length==0){
			logger.addHandler(FactoryHandler.getFileHandler(appLoggerLevel,appLoggerFile, 1, 100000));
			//logger.addHandler(FactoryHandler.getConsolHandler(appLoggerLevel));
			//logger.addHandler(FactoryHandler.getJDBCHandler(appLoggerLevel,""));
		}
    	}


    if(request.getParameter("txtfLogin") != null
        && request.getParameter("txtfPwd") != null) {
        
        login = request.getParameter("txtfLogin");
        password = request.getParameter("txtfPwd");
    
        if(login.length() != 0 && password.length() != 0) {

            System.out.println("Autentificando al usuario...");
            myJndi.doProperties("../../../../propiedades.xml");
            if(myJndi.doLogin(login, password)) {

                session.setAttribute("jndi", myJndi);
                /**
                * User Roles
                */
                 if(logger!=null){
                                        logger=java.util.logging.Logger.getLogger("pmrLog");
            			            	//logger.addHandler(FactoryHandler.getFileHandler(appLoggerLevel,appLoggerFile, 1, 10000000));
        								//logger.addHandler(FactoryHandler.getConsolHandler(appLoggerLevel));
            			            	logger.info(session.getId()+":"+"Loggin Exitoso");
            			            	session.setAttribute(session.getId()+"_Log", logger);
                }
                
                
                myRole = myJndi.loadUidRoles(myJndi.appDn, myJndi.uid).toString();
                System.out.println("myRole: " + myRole);
                if((myRole.toLowerCase()).indexOf("administrador") >= 0) {
                    myRole = "administrador";
                    rolAccVal=127;
                } else if((myRole.toLowerCase()).indexOf("banco") >= 0) {
                    myRole = "banco";
                    rolAccVal=3;
                } else if((myRole.toLowerCase()).indexOf("operador") >= 0) {
                    myRole = "operador";
                    rolAccVal=63;
                } else {
                    throw new Exception(
                        "Usuario sin Roles de acceso al Sistema.");
                }
                session.setAttribute("rolAccVal", rolAccVal);
                session.setAttribute("role", myRole);
                System.out.println("Rol: " + myRole);
                System.out.println("rolAccVal: " + rolAccVal);
                /**
                * Numero de Afiliacion
                */
                
                myOu1st = myJndi.dn.substring((myJndi.dn).indexOf("ou=")+ 3);
                System.out.println("myOu.indexOf(\",\"): " + myOu1st.indexOf(","));
                myOu1st = myOu1st.indexOf(",") >= 0 ?(myOu1st.substring(0, myOu1st.indexOf(","))).trim(): myOu1st;
                System.out.println("myOu1st: " + myOu1st);
                session.setAttribute("name", myOu1st);

                /**
                * FIID
                */
                System.out.println("myJndi.dn.toLowerCase()).indexOf(\"o=bancos\"): " +(myJndi.dn.toLowerCase()).indexOf("o=bancos"));
                if((myJndi.dn.toLowerCase()).indexOf("o=bancos") >= 0){
                    myOu2nd = myJndi.dn.substring(0,(myJndi.dn.toLowerCase()).indexOf("o=bancos")- 1);
                    System.out.println("myOu2nd: " + myOu2nd);
                    myOu2nd = myOu2nd.lastIndexOf("o=") >= 0 ? myOu2nd.substring(myOu2nd.indexOf("o=")+ 2,myOu2nd.indexOf(",",myOu2nd.indexOf("o="))).trim(): "";
/* INICIA CAMBIO WELLCOM P-54-2453-14 16/07/2014 GERMAN GONZALEZ */
                    if (myOu2nd.equals("B044") )
                    {
                    	rolAccVal=4;
                    	session.setAttribute("rolAccVal", rolAccVal);
                    }
/* FIN CAMBIO WELLCOM P-54-2453-14 16/07/2014 GERMAN GONZALEZ */
                } else {
                    /**
                    * Usuario PROSA no tiene FIID
                    */
                    myOu2nd = "";
                }
                System.out.println("myOu2nd: " + myOu2nd);
                session.setAttribute("numFiid", myOu2nd);
                /**
                * Participant
                */
                myLogin = myJndi.dn.substring((myJndi.dn).indexOf("uid=")+ 4);
                myLogin = myLogin.indexOf(",") >= 0 ?(myLogin.substring(0, myLogin.indexOf(","))).trim(): myLogin;
                session.setAttribute("login", myLogin);
                System.out.println("myLogin" + myLogin);
                session.setAttribute("grantAccess", "true");
				//Modificacion: SAS-DRT F-52-8063-16 Marca de Inicio
                response.sendRedirect("ControllerServletGen?action=index");
				//Modificacion: SAS-DRT F-52-8063-16 Marca de Fin
            }
        }
    }
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Sistema Adquirente Carnet</title>
<meta http-equiv="Content-Type" content="text/html; ">
<link rel="stylesheet" href="css/master-style.css" type="text/css">
<style> 
a:link {text-decoration: none;} 
a:hover {text-decoration: none;}
a:visited {text-decoration: none;}
</style> 

</head>
<SCRIPT LANGUAGE = "JavaScript1.2">

// which keeps track of the currently selected tab
var which="none";

// Function to 'turn-off' all imx.
	function imageoff() {
			//document.documentation.src = documentationoff.src;
			//document.support.src = supportoff.src;
                          document.bannerlinkone.src = bannerlinkoneoff.src;
 
	}
	

function validar(e) { // 1
    tecla = (document.all) ? e.keyCode : e.which; // 2
    if (tecla==8) return true; // 3
    patron =/\w/; // 4
    te = String.fromCharCode(tecla); // 5
    return patron.test(te); // 6
} 



// Function to 'turn-on' the target image.
	function imageon(imgName) {
			document[imgName].src = eval(imgName + "on.src");
	}

// Function to 'load the content page and swap tab imx'.
	function loadandswap(imgName, contentName) {
		imageoff();
		imageon(imgName);
        which=imgName;
		}
		
// Function to handle mouse overs
     function over(imgName) {
        if (which!=imgName) 
          document[imgName].src= eval(imgName + "over.src");
          
        else return false;
        }

// Function to handle mouse outs
     function out(imgName) {
        if (which!=imgName) 
          document[imgName].src= eval(imgName + "off.src");
          
        else return false;
        }

</SCRIPT>
 
<BODY marginwidth="0" marginheight="0" topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0" bgcolor="#ffffff">
 
<SCRIPT> 
                bannerlinkoneoff = new Image();
                bannerlinkoneoff.src = "pics/imx/grey_dot.gif";
 
                bannerlinkoneover = new Image();
                bannerlinkoneover.src = "pics/imx/red_dot.gif";
 
                bannerlinkoneon = new Image();
                bannerlinkoneon.src = "pics/imx/red_dot.gif";
 
</SCRIPT>
 
  <table border="0" cellspacing="0" cellpadding="0">
    <tr> 
      <td width="190"><img src="pics/imx/spacer.gif" width="190" height="16" alt=" "></td>
      <td rowspan="4" valign="bottom"><img src="pics/imx/iplanetBanner.gif" width="100" height="30" alt="WebMail PROSA"></td>
      <td width="7"><img src="pics/imx/spacer.gif" width="277" height="16" alt=" "></td>
      <td width="5"><img src="pics/imx/spacer.gif" width="7" height="16" alt=" "></td>
      <td bgcolor="#cccccc" rowspan="3"><img src="pics/imx/spacer.gif" width="1" height="16" alt=" "></td>
      <td width="5"><img src="pics/imx/spacer.gif" width="7" height="16" alt=" "></td>
      <td>&nbsp;</td>
      <td><img src="pics/imx/spacer.gif" width="17" height="16" alt=" "></td>
    </tr>
    <tr>
      <td></td>
      <td align="right"><a href="http://www.prosa.com.mx" onMouseOver="over('bannerlinkone')" onMouseOut="out('bannerlinkone')" 
        onClick="loadandswap('bannerlinkone', 'http://www.prosa.com.mx'); return true"> 
        <img name="bannerlinkone" src="pics/imx/grey_dot.gif" width="7" height="8" border="0" alt=" "></a></td>
      <td></td>
      <td></td>
      <td colspan="2"><a href="http://www.prosa.com.mx" onMouseOver="over('bannerlinkone')" onMouseOut="out('bannerlinkone')" 
        onClick="loadandswap('bannerlinkone', 'http://www.prosa.com.mx'); return true"> 
        <font size="-1"><span class="banner-links">prosa.com.mx</span></font></a></td>
    </tr>
    <tr>
      <td><img src="pics/imx/spacer.gif" width="190" height="30" alt=" "></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
    </tr>
  </table>
       
  <table width="100%" border="0" cellspacing="0" cellpadding="0" background="pics/imx/RedGrey_blank.gif">
    <tr> 
    </tr>
  </table>
   <!--Modificacion: SAS-DRT F-52-8063-16 Marca de Inicio-->
  <form action="ControllerServletGen?action=login" method="post" enctype="application/x-www-form-urlencoded"  id="frmLogin">
  <!--Modificacion: SAS-DRT F-52-8063-16 Marca de fin-->
  <table border="0" cellspacing="0" cellpadding="0">
    <tr> 
      <td><img src="pics/imx/spacer.gif" width="180" height="1" alt=" "></td>
      <td><img src="pics/imx/spacer.gif" width="10" height="1" alt=" "></td>
      <td></td>
      <td><img src="pics/imx/spacer.gif" width="10" height="1" alt=" "></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr> 
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td><font color="black" face="tahoma" size="2">Sistema Adquirente Carnet</font></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td colspan="4"><img src="pics/imx/spacer.gif" width="1" height="14" alt=" "></td>
    </tr>   
    <tr> 
      <td align="right"><font color="black" face="tahoma" size="2">Usuario</font></td>
      <td>&nbsp;</td>
      <td>  
      <input name="txtfLogin" type="text" class="textInput" id="txtfLogin" size="26" onkeypress="return validar(event)"/>
      </td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td colspan="4"><img src="pics/imx/spacer.gif" width="1" height="6" alt=" "></td>
    </tr>
    <tr>
      <td align="right"><font color="black" face="tahoma" size="2">Contrase&ntilde;a</font></td>
      <td>&nbsp;</td>
      <td>  
      <input name="txtfPwd" type="password" class="textInput" id="txtfPwd" size="26"/>
      </td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td colspan="4"><img src="pics/imx/spacer.gif" width="1" height="9" alt=" "></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td> 
        <table border="0" cellspacing="0" cellpadding="0">
          <tr> 
            <td>
              <table border="0" cellspacing="0" cellpadding="0">
                <!-- start of button top --> 
                <tr> 
                  <td>
                   
                     <input type="submit" name="enviar" id="enviar" value="Aceptar" class="button-label" />
                    
                    
                    </td>
                  
                </tr>
                <!-- end of button top --> 
                <tr> <!-- start of button Bottom --> 
                  
                </tr>
                
                <!-- end of button Bottom --> 
              </table>
              
            </td>
          </tr>
        </table>
      </td>
      <td>&nbsp;</td>
    </tr>
  </table>
  </form>    
  <table border="0" cellspacing="0" cellpadding="0">
	<tr>	  
      <td colspan="4"><img src="pics/imx/spacer.gif" width="1" height="28" alt=" "></td>
    </tr>
    <tr>
      <td><img src="pics/imx/spacer.gif" width="190" height="1" alt=" "></td>
      <td rowspan="2" bgcolor="#cccccc"><img src="pics/imx/spacer.gif" width="1" height="1" alt=" "></td>
      <td><img src="pics/imx/spacer.gif" width="10" height="1" alt=" "></td>
      <td><img src="pics/imx/spacer.gif" width="10" height="1" alt=" "></td>
    </tr>
    <tr>
      <td><img src="pics/imx/spacer.gif" width="190" height="30" alt=" "></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
	<tr> 
      <td colspan="4" bgcolor="#cccccc"><img src="pics/imx/spacer.gif" width="1" height="1" alt=" "></td>
    </tr>
  </table>
       
  <table border="0" cellspacing="0" cellpadding="0">
	<tr> 
      <td><img src="pics/imx/spacer.gif" width="190" height="5" alt=" "></td>
      <td rowspan="2" bgcolor="#cccccc"><img src="pics/imx/spacer.gif" width="1" height="1" alt=" "></td>
      <td colspan="3"><img src="pics/imx/spacer.gif" width="1" height="5" alt=" "></td>
    </tr>
    <tr> 
      <td><img src="pics/imx/spacer.gif" width="190" height="1" alt=" "></td>
      <td><img src="pics/imx/spacer.gif" width="10" height="1" alt=" "></td>
      <td><img src="pics/imx/spacer.gif" width="10" height="8" alt=" "></td>
    </tr>
  </table> 
</body> 
</html>

