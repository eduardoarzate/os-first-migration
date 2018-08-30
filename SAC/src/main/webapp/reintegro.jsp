<%
/*
#################################################################################
#                               MODIFICACIONES                                  #
#-------------------------------------------------------------------------------#
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 01/03/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>

<%
    /*if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
    }
    */
   
    String usuario=(String)session.getAttribute("login");
    if (usuario.equals("")){
        usuario=null;
    }
    
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
    <head>
        <link href="resources/main.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript">
            function windows()
            {
                window.open('https://aplicpm.prosa.com.mx/reintegro/reintegro.jsp?user=<%=usuario%>', '', 'directories=0,location=0,menubar=0,resizable=1,scrollbars=1,status=0,titlebar=0,toolbar=0 ,fullscreen=yes');
                //window.open('http://10.255.198.74:38083/reintegro/reintegro.jsp?user=<%=usuario%>','','directories=0,location=0,menubar=0,resizable=1,scrollbars=1,status=0,titlebar=0,toolbar=0 ,fullscreen=yes');
                var ventana = window.self;
                ventana.open('', '_parent', '');
                /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
                document.location = "ControllerServletGen?action=index";
                /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/

            }
        </script>
    </head>
    <body onload="javascript:windows();">
    </body>
</html>
