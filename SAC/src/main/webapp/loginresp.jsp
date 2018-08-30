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
# Autor               :                                                         #
# Compania            :                                                         #
# Proyecto/Procliente :                              Fecha:                     #
# Modificación        :                                                         #
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
    Integer rolAccVal=0;
%>

<%
ServletContext context = getServletContext();
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
                response.sendRedirect("ControllerServlet?action=index");
            }
        }
    }
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta http-equiv="Cache-Control" content="no-cache"/>
        <title>Acceso PMR</title>
        <style type="text/css" media="all" title="currentStyle">
		@import "css/style.css";
		@import "css/login.css";
	</style>
	<style type="text/css">
			<!--
			body,td,th {
				font-family: Verdana, Arial, Helvetica, sans-serif;
				font-size: 14px;
			}
			.style3 {
				font-size: 18px;
				font-weight: bold;
			}
			tblLogin {
				border-top-style: solid;
				border-right-style: solid;
				border-bottom-style: solid;
				border-left-style: solid;
			}
			.style4 {
				font-size: 12px;
				font-weight: bold;
			}
		-->
    	</style>
    </head>
    
    <body>


    <div >
	  <span  style="display: none;" class="style3">MATCH ON-LINE</span>
      
	 <div id="login">
		<div id="head_login"></div>
		<div id="barAzul">Ingrese sus datos requeridos</div>
		<div id="contenido">
			<div id="form">
				<form action="ControllerServlet?action=login" method="post" enctype="application/x-www-form-urlencoded"  id="frmLogin">
				  <p>
				  	<label for="txtfLogin">Username:
    				<input name="txtfLogin" type="text" class="textInput" id="txtfLogin" />
    				</label>
  				  </p>
				  <p>
     				<label for="txtfPwd">Password:
    				<input name="txtfPwd" type="password" class="textInput" id="txtfPwd" />
    				</label>
  				  </p>
  				  <p>
    				<label for="enviar"></label>
    				<input type="submit" name="enviar" id="enviar" value="Login" />
  				  </p>
				</form>
			</div>
		<div id="barAzulDark">Ayuda</div>	
		</div>
	</div>
    </div>
    
    </body>
</html>
