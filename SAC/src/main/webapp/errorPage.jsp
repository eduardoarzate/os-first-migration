<%/*
#-----------------------------------------------------------------------------  #
# Autor               :  Daniel Ramírez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-------------------------------------------------------------------------------#
*/%>

<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%@ page import="com.wellcom.io.*" %>
<%@ page import="java.util.logging.*" %>
<%@ page import="java.lang.Exception" %>


<%@ page isErrorPage = "true"%>

<%
        HTML htmlcomp=new HTML();
        Exception exp=new Exception();
        Logger logger=Logger.getLogger("default");
        logger.severe("Error Page: "+ exp.toString());
	
        String msgError="";
        String mensaje="";
        String causa = "";
        int pos=0;
    try
    {
        pos = exception.getMessage().indexOf(":");
        //pos = exception.getCause().toString().indexOf(":");
        }
        catch(Exception e)
        {
        pos = -2;
        exception = e;
        }

    if (pos > -1)
        //msgError = exception.getMessage().substring(0,pos);
        //msgError = exception.getCause().toString();
        msgError = exception.getMessage();
    else
        msgError="ERRORPROGRAMADO";
    	
    	
        //System.out.println("msgError..." + msgError);
	
        if (msgError.indexOf("ORA-00001") > -1 )
                mensaje = "<B><I>No puede haber registros duplicados. Por favor verifique</I></B>";
        else if (msgError.indexOf("ORA-1012") > -1 )
           mensaje = "<B><I>No existe conexi&oacute;n con Oracle. Por favor verifique</I></B>";
        else if (msgError.indexOf("ORA-0051") > -1 )
           mensaje = "<B><I>Se produjo un fin de intervalo mientras se esperaba un cierto recurso. Por favor verifique</I></B>";
        else if (msgError.indexOf("ORA-0061") > -1 )
           mensaje = "<B><I>La transacci&oacute;n fue cancelada debido a un bloqueo<I></B>";
        else if (msgError.indexOf("ORA-1001") > -1 )
           mensaje = "<B><I>Operaci&oacute;n ilegal con un cursor</I></B>";
        else if (msgError.indexOf("ORA-1017") > -1 )
           mensaje = "<B><I>Nombre de usuario o contraseña inv&aacute;lidos</I></B>";
        else if (msgError.indexOf("ORA-1403") > -1 )
           mensaje = "<B><I>No se ha encontrado ning&uacute;n dato</I></B>";
        else if (msgError.indexOf("ORA-1422") > -1 )
           mensaje = "<B><I>Hay m&aacute;s de una fila que corresponde a una orden Select..Into</I></B>";
        else if (msgError.indexOf("ORA-1476") > -1 )
           mensaje = "<B><I>Divisi&oacute;n por cero</I></B>";
        else if (msgError.indexOf("ORA-1722") > -1 )
           mensaje = "<B><I>Fall&oacute; la conversi&oacute;n a un n&uacute;mero;por ejemplo, IA no es v&aacute;lido</I></B>";
        else if (msgError.indexOf("ORA-6500") > -1 )
           mensaje = "<B><I>Error interno PL/SQL, generado cuando PL/SQL se queda sin memoria</I></B>";
        else if (msgError.indexOf("ORA-6501") > -1 )
           mensaje = "<B><I>Error interno PL/SQL</I></B>";
        else if (msgError.indexOf("ORA-6502") > -1 )
           mensaje = "<B><I>Error de truncamiento, aritm&eacute;tico o de conversi&oacute;n</I></B>";
        else if (msgError.indexOf("ORA-6504") > -1 )
           mensaje = "<B><I>Una variable de cursor del host y una variable de cursor PL/SQL tienen tipos de filas incompatibles</I></B>";
        else if (msgError.indexOf("ORA-6511") > -1 )
           mensaje = "<B><I>Se ha intentado abrir un cursor que ya est&aacute; abierto</I></B>";
        else if (msgError.indexOf("ORA-6530") > -1 )
           mensaje = "<B><I>Se ha intentado asignar valores a los atributos de un objeto que tiene el valor de NULL</I></B>";
        else if (msgError.indexOf("ORA-6531") > -1 )
           mensaje = "<B><I>Se ha intenado aplicar m&eacute;todos de colecci&oacute;n distintos de EXISTS a una tabla &oacute; array PL/SQL con valor NULL</I></B>";
        else if (msgError.indexOf("ORA-6532") > -1 )
           mensaje = "<B><I>Una referencia a una tabla anidada o &iacute;ndice de array se encuentra fuera del rango declarado (por ejemplo -1)</I></B>";
        else if (msgError.indexOf("ORA-6533") > -1 )
           mensaje = "<B><I>Una referencia a una tabla anidada o &iacute;ndice de array es mayor que el n&uacute;mero de elementos de la colecci&oacute;n</I></B>";
        else if (msgError.indexOf("ORA-00904") > -1 )
           mensaje = "<B><I>Referencia a un nombre de columna inv&aacute;lido.</I></B>";
        else if (msgError.indexOf("ORA-01438") > -1 )
           mensaje = "<B><I>Valor mayor que el m&aacute;ximo permitido para esta columna.</I></B>";
        else if (msgError.indexOf("ORA-02292") > -1 )
           mensaje = "<B><I>Imposible eliminar registro, tiene datos dependientes.<br>Por favor rectifique</I></B>";
        else if (msgError.indexOf("ORA-01847") > -1 || msgError.indexOf("ORA-01843") > -1 )
           mensaje = "<B><I>Fecha Invalida. Verifique datos de captura.</I></B>";
        else if (msgError.indexOf("CONNECTION") > -1 )
           mensaje = "<B><I>No existe conexi&oacute;n a la base de datos.</I></B>";
        else if (msgError.indexOf("NODATA") > -1 )
           mensaje = "<B><I>Debe informar login y password. Estos campos no pueden ser nulos. <br> Por favor intente nuevamente.</I></B>";
        else if (msgError.indexOf("NOEXISTS") > -1 )
           mensaje = "<B><I>El usuario no existe. Por favor verifique. </I></B>";
        else if (msgError.indexOf("NOGROUP") > -1 )
           mensaje = "<B><I>El usuario no tiene permiso de accesar al sistema. </I></B>";
        else if (msgError.indexOf("[LDAP: error code 32") > -1 )
           mensaje = "<B><I>Error de autenticaci&oacute;n: El usuario no existe. <br> Por favor intentelo de nuevo.</I></B>";
        else if (msgError.indexOf("[LDAP: error code 34") > -1 )
           mensaje = "<B><I>Error de autenticaci&oacute;n: El usuario no existe. <br> Por favor intentelo de nuevo.</I></B>";
        else if (msgError.indexOf("[LDAP: error code 49")> -1 )
           mensaje = "<B><I>Error de autenticaci&oacute;n: El password es incorrecto. <br> Por favor teclee bien su password.</I></B>";
        else if (pos == -2 ) //ERRORPROGRAMADO
           mensaje = "<B><I>" + "Error en la operación normal del Sistema. " + "<BR><BR>Su tiempo de conexion ha expirado.</I></B>";
        else
           mensaje = "<B><I>" + exception.getMessage() + "</I></B>	Por favor, contacte al administrador.";

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html >
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="scripts/resize.js"></script>
        <script language="JavaScript" type="text/javascript">

            function mostrarExcepcion(id, idHide, idSee)
            {
                document.getElementById("imgOculataExp").style.display = "inline";//MOSTRAR EL LINK ALTERNATIVO
                document.getElementById("imgMuestraExp").style.display = "none";//OCULTAR LINK INICIAL
                document.getElementById("inpExcepcion").style.display = "inline";//MOSTRAR BLOQUE
                return false;
            }

            function ocultarExcepcion(id, idHide, idSee)
            {
                document.getElementById("imgMuestraExp").style.display = "inline";//OCULTAR EL LINK ALTERNATIVO
                document.getElementById("imgOculataExp").style.display = "none";//MOSTRAR LINK INICIAL
                document.getElementById("inpExcepcion").style.display = "none";//OCULTA BLOQUE 
                return false;
            }

            function onLoad()
            {
                document.getElementById("inpExcepcion").style.display = "none";//OCULTA BLOQUE
            }


        </script>     

        <title> SAC 2</title>
    </head>

    <body onload="javascript:onLoad(this.form);">
        <div id="wrapper">
            <!--Modificacion: Marca de inicio    SAS-DRT F-52-8063-16-->
            <form action="ControllerServletGen?action=login" enctype="multipart/form-data" method="post" name="frmTOCHeader" id="frmTOCHeader">	    
            <!--Modificacion: Marca de fin    SAS-DRT F-52-8063-16-->
                <table >
                    <tr>
                        <td colspan="1" align="left">
                            <%= mensaje%>
                        </td>
                        <td  align="right">
                            <input  type="submit" value="Login" />
                        </td>
                    </tr>
                    <tr>
                        <td align="left">
                            <input id="imgMuestraExp" value="Mostrar" style="display: inline;" type="image" onclick="javascript:return mostrarExcepcion(this.form);" src="pics/msg/down.png"></input>
                            <input id="imgOculataExp" value="Ocultar" style="display: none;" type="image" onclick="javascript:return ocultarExcepcion(this.form);" src="pics/msg/up.png"></input>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <textarea id="inpExcepcion" cols="180" rows="20"  disabled="disabled"><%exception.printStackTrace(new java.io.PrintWriter(out));%></textarea>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>