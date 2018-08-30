
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
# Autor               : German Gonzalez                               #
# Compania            :  WELLCOM                                         #
# Proyecto/Procliente : N-08-2253-12              Fecha: 08/05/2013             #
# Modificación        : Adicionar indicadores ABM                           #
#-----------------------------------------------------------------------------  #
# Autor               : Salvador Montiel                                        #
# Compania            : AM Estudio                                              #
# Proyecto/Procliente : P-54-2940-14               Fecha: 23/04/2015            #
# Modificacion        : Soporte Interactivo (FAQs,Tutoriales,Manuales)          #
# Marca del Cambio    : P-54-2940-14 AMEstudio 23.04.2015                       #
#-------------------------------------------------------------------------------#
# Autor               : Gerardo G. Burguete                                    #
# Compania            : Axia, consultores, S.A. DE C.V.                        #
# Proyecto/Procliente : P-53-2933-14                         Fecha: 25/05/2015 #
# Descripcion General : Recalculo de compensacion y administracion de umbrales #
# Modificacion        : sustituir la palabra Liquidación por compensación      #
# Marca del Cambio    : AXIA-GGB-P-53-2933-14                                  #
#------------------------------------------------------------------------------#
###############################################################################*/
%>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>

<%

 if(!ga.AccessGranted(session, "grantAccess")){  
     response.sendRedirect("login.jsp");
  }
%>

<%
//-- Marca del Cambio: AXIA-GGB-P-53-2933-14 Inicio  la Modificacion 25/05/2015 --//
String pant = (String)request.getAttribute("pant");
pant = (pant == null ? "main.jsp" : pant);
//-- Marca del Cambio: AXIA-GGB-P-53-2933-14 Termina la Modificacion 25/05/2015 --//
String path = request.getContextPath();
//String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
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

<!-- Marca inicio P-54-2940-14 AMEstudio 23.04.2015  -->
function previewPdf(){
	
		window.open('reporte.jsp', 'VistaPrevia', 'menubar=no,resizable=yes,title=no,status=yes,toolbar=no,scrollbars=yes,alwaysRaised=yes,width=800,height=600');


}
<!-- Marca fin P-54-2940-14 AMEstudio 23.04.2015  -->
	</script>
	
  </head>
  
  <body>
  <div id="wrapper">
  

      <table width="100%"  border="0" cellpadding="0" cellspacing="2">
  			 
<!-- Marca del Cambio: AXIA-GGB-P-53-2933-14 Inicio  la Modificacion 25/05/2015 -->
        <tr>
    		<td id="leftPanel"  valign="top"><jsp:include page="menu.jsp"/></td>
    		<td id="rightPanel" valign="top"><jsp:include page="<%=pant%>" flush="true"/><br></td>
  		</tr>
<!-- Marca del Cambio: AXIA-GGB-P-53-2933-14 Termina la Modificacion 25/05/2015 -->
<!-- Inicia Modificacion WELLCOM 08/05/2013 N-08-2253-12 -->
  		<tr>
  			<td width="100%" colspan="2">                <jsp:include page="footer.jsp"/><br></td>
  		</tr>
<!-- Fin Modificacion WELLCOM 08/05/2013 N-08-2253-12 -->
	</table>
	</div>
  </body>
</html>
