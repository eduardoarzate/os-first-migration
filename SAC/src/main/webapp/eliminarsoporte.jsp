<%
/*###############################################################################
# Nombre del Programa :  eliminarsoporte.jsp                                    #
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
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>

<%
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
    }
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>SOPORTE INTERACTIVO</title>
<link href="css/styles.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="scripts/resize.js"></script>
</head>

<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">	  			
	        <tr>
	    		<td id="rightPanel" valign="top" ><jsp:include page="soporteHeader.jsp"/></td>
	  		</tr>
		</table>
</body>
</html>