<%
/*###############################################################################
# Nombre del Programa :  lstGrpSacii.jsp                                        #
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
<title>LIBERACION DE CIFRAS</title>
<meta http-equiv="Cache-Control" content="no-cache"/>
    <link href="css/styles.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="scripts/resize.js"></script>
	<script type="text/javascript" src="scripts/menu.js"></script>
	<script type="text/javascript" src="scripts/envio.js"></script>
	<script type="text/javascript" src="scripts/eventTable.js"></script>

</head>

<body>
<div id="wrapper">
<table width="100%" border="0" cellpadding="0" cellspacing="2">
	  				
	        <tr>
	    		<td id="leftPanel" valign="top" ><jsp:include page="menu.jsp"/></td>
	    		<td id="rightPanel" valign="top" ><jsp:include page="lstGrpSaciiHeader.jsp"/></td>
	  		</tr>
		</table>
		<jsp:include page="footer.jsp"/>
		</div>
</body>
</html>
