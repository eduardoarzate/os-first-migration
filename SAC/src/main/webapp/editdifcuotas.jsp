<%
/*###############################################################################
# Nombre del Programa :  cierreDifCuotas.jsp                                    #
# Autor               :  Carlos Mendez                                          #
# Compania            :  PROSA                                                  #
# Proyecto/Procliente : C-04-3035-13                            Fecha:11/12/2013#
# Modificacion        : Generacion de Proceso de Diferencia de Cuota de         #
#                       Intercambio de EGLO SAC2                                #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :                                                         #
#                                                                               #
#                                                                               #
#################################################################################
#                               MODIFICACIONES                                  #
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
<title>TIPO CAMBIO</title>
<link href="css/styles.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="scripts/resize.js"></script>
</head>

<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">	  			
	        <tr>
	    		<td id="rightPanel" valign="top" ><jsp:include page="editdifcuotasval.jsp"/></td>
	  		</tr>
		</table>
</body>
</html>