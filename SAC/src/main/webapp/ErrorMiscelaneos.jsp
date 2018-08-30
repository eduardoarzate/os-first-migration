<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>

<%
/*
#------------------------------------------------------------------------------#
# Autor               :  Daniel Ramirez Torres                                 #
# Compania            :  SAS S.A. DE C.V.                                      #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017        #
# Modificacion        :  Mejora Conexiones  SAC2                               #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                  #
#------------------------------------------------------------------------------#*/
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
    }
%>

<html>
    <title>Error</title>
    <body>
	  <!--Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación -->
        <form action="ControllerServletMisc?action=errorMisc" method="post" name="errorMisc">
	    <!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación -->	
        <b>Error al llenar los campos. Solo se permiten valores num&eacute;ricos<p></p></b>
        <input type="submit" name=volMisc"  value="Volver"/>
        </form>
    </body>
</html>

