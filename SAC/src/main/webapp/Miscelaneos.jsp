<%
/*###############################################################################
# Nombre del Programa :  Miscelaneos.java                                       #
# Autor               :  Carolina Martin del Cmapo Rodriguez                    #
# Compania            :  IDSYS S.A. DE C.V.                                     #
# Proyecto/Procliente :  N-08-2033-13                      FECHA:14/10/13       #
# Descripcion General :                                                         #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :                                                         #
# Dias de ejecucion   :                                                         #
#################################################################################
#                MODIFICACIONES                                                 #
# Autor               :                                                         #
# Compania            :                                                         #
# Proyecto/Procliente :                              Fecha:                     #
# Modificacion      :                                                           #
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
<!--title>MISCELANEOS 103</title-->
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
	    		<td id="rightPanel" valign="top" ><jsp:include page="MiscelaneosHeader.jsp"/></td>
	  	</tr>
		</table>
		<jsp:include page="footer.jsp"/>
		</div>
</body>
</html>
