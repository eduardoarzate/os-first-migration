<%
/*###############################################################################
# Nombre del Programa :  SICMIR0290.jsp		                                    #
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
<link href="css/styles.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="scripts/resize.js">
window.onload= function add() <%//poner esto%>
		{
			OnLoadMenu();
		}
</script>
<title>SICMIR0290 - Reporte Integral de Transacciones Recibidas en Prosa</title>
</head>

<body>
<div id="wrapper"><%//poner esto%>
	<table width="100%" border="0" cellpadding="0" cellspacing="2">
	        <tr>
	    		<td id="leftPanel" valign="top" ><jsp:include page="menu.jsp"/></td>
	    		<td id="rightPanel" valign="top" ><jsp:include page="SICMIR0290HHeader.jsp"/></td>
	  		</tr>
	</table>
		<jsp:include page="footer.jsp"/><%//poner esto%>
	</div><%//poner esto%>
</body>
</html>
