<%
/*###############################################################################
# Nombre del Programa :  losprefijos.jsp	                                    #
# Autor               :  JOAQUIN MOJICA Q.                                      #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-02-1202-09                  	   FECHA:08/02/2010     #
# Descripcion General :	 AUTOMATIZACION DE PREPAGO								#
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
<title>Untitled Document</title>
<link href="css/styles.css" rel="stylesheet" type="text/css">
</head>

<frameset rows="225,*" cols="*" framespacing="0" frameborder="no" border="0">
  <frame src="losprefijosheader.jsp" name="topFrameTOC" scrolling="No" noresize="noresize" id="topFrameTOC" title="topFrame">
  <frame src="losprefijosmain.jsp" name="mainFrameTOC" id="mainFrameTOC" title="mainFrame">
</frameset>
<noframes><body>
</body>
</noframes></html>
