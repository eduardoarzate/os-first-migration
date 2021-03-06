<%
// ----------------------------------------------------------------------------
// Nombre del Programa : AfiliacionDet.jsp
// Autor               : Manuel Villalobos
// Compania            : GSOF
// Proyecto/Procliente : C-08-2129-12                       Fecha: 11/FEB/2015
// Descripcion General : JSP PARA LA PANTALLA DE DETALLE DE AFILIACION
// Programa Dependiente: N/A
// Programa Subsecuente: N/A
// Cond. de ejecucion  : N/A
// Dias de ejecucion   : N/A                                 Horario: N/A
//                              MODIFICACIONES
/*#-----------------------------------------------------------------------------  #
# Autor               :  Daniel Ram�rez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-------------------------------------------------------------------------------#*/
%>
<%@ page language="java" %>
<%
response.setHeader     ("Cache-Control", "no-store");
response.setHeader     ("Pragma",        "no-cache");
response.setDateHeader ("Expires",       0);
%>
<%@ page import="com.wellcom.io.*" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>
<%@ page import="com.wellcom.struts.*" %>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<jsp:useBean id="datos" scope="session" class="com.wellcom.struts.AfiliacionForm"/>
<%
    if(!ga.AccessGranted(session, "grantAccess"))
    {
        response.sendRedirect("login.jsp");
    }
%>
<html>
    <head>
        <title>Alta Afiliaci&oacute;n</title>
    </head>
    <script language="javascript">
        function ejecutar()
        {
            if(document.forms[0].afiliacion.value.length != 0){
                return true;
            }
            else {
                alert("No puede ser nula");
                return false;
            }
        }
        function cancelar()
        {
            document.forms[0].accion.value = 0;
            return true;
        }
        function Init(){
            document.forms[0].afiliacion.focus();
        }
    </script>
    <link rel="stylesheet" href="<%= request.getContextPath() + "/css/estilos.css"%>" type="text/css">
    <body >
    <table   width="100%" border="0" cellpadding="0" cellspacing="0">
       <tr>
         <td id="rightColumns" valign="top" >
             <!--Modificacion: SAS-DRT F-52-8063-16 Marca de Inicio-->
        <form action="ControllerServletHerr?action=AfiliacionLACPI" method="post">
            <!--Modificacion: SAS-DRT F-52-8063-16 Marca de fin-->
            <table width="100%" border="1" bordercolor="#CE000C" >
                <tr>
                    <td class="vacio">&nbsp;</td>
                </tr>
                <tr>
                    <td class="titulo2" colspan="2">
                        Alta Afiliaci&oacute;n
                    </td>
                </tr>
                <tr>
                    <td class="vacio" colspan="2">
                        &nbsp;
                    </td>
                </tr>
                <tr><td class="margen">
                    <table width="100%">
                        <tr>
                            <td class="vacio">&nbsp;</td>
                        </tr>
                        <tr>
                            <td width="120px" class="etiqueta">
                                Afiliaci&oacute;n
                            </td>
                            <td class="dato">
                                <input type="text" name="afiliacion" size="9" maxlength="9" class="textbox" tabindex="1" value=<%=datos.getAfiliacion()%>>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" class="error"><%=datos.getError()%></td>
                        </tr>
                        <tr>
                            <td colspan="2" class="botones">
                                <input type="submit" property="btnGuardar" onclick="javascript:return ejecutar();" class="button" value="Guardar">
                                <input type="submit" property="btnCancelar" onclick="javascript:return cancelar();" class="button" value="Cancelar">
                            </td>
                        </tr>
                    </table>
                </td></tr>
            </table>
            <input type="hidden" name="accion" value=<%=datos.getAccion()%>>
        </form>
      </td>
    </tr>
    </table>
    <script language="javascript">
        function addLoadEvent(func) {
          var oldonload = window.onload;
          if(typeof window.onload != 'function') {
               window.onload = func;
          }else{
               window.onload = function() {
               if(oldonload) {
                   oldonload();
               }
               func();
            }
          }
        }
        function carga(){
            dhxAccord.cells("a2").open();
        }
        addLoadEvent(carga);
    </script>
    </body>
</html>
