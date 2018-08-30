<%
/*###############################################################################
# Nombre del Programa :  index.jsp			                                    #
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

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <link href="css/styles.css" rel="stylesheet" type="text/css">
	<title> Inicio </title>
	<script type="text/javascript" src="scripts/resize.js"></script>
	<script type="text/javascript" src="scripts/menu.js"></script>
		<script type="text/javascript" src="scripts/envio.js"></script>
	<script type="text/javascript" src="scripts/eventTable.js"></script>
	<script>
	
		window.onload= function add() 
		{
			OnLoadMenu();
		}
	
	</script>
  </head>
  
  <body>
  <div id="wrapper">
  

      <table width="100%"  border="0" cellpadding="0" cellspacing="2">
  			 
        <tr>
    		<td id="leftPanel"  valign="top"><jsp:include page="menuman.jsp"/></td>
    		<td id="rightPanel" valign="top"><jsp:include page="mainman.jsp"/><br></td>
  		</tr>
	</table>
	<jsp:include page="footer.jsp"/>
	</div>
  </body>
</html>
