<%
/*###############################################################################
# Nombre del Programa :  please.jsp		                                        #
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
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%
 if(!ga.AccessGranted(session, "grantAccess"))
 {
        response.sendRedirect("login.jsp");
 }
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  <center>
  	<span style="font-family: Arial; color:red; font-weight: bold; font-size: 18">Procesando...</span>
  	<br/>
  	<img src="pics/icons/loader.gif"/>
  	<br/>
  	<span style="text-align: justify; font-weight: bold; font-size: 12">Esta ventana se cerrará automáticamente.</span>
  </center>
  </body>
</html>
