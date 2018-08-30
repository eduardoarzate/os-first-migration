<%
// ----------------------------------------------------------------------------
// Nombre del Programa : AltasDet.jsp
// Autor               : Manuel Villalobos
// Compania            : GSOF
// Proyecto/Procliente : C-08-2129-12                       Fecha: 11/FEB/2015
// Descripcion General : JSP PARA LA PANTALLA DE LACPI ALTA
// Programa Dependiente: N/A
// Programa Subsecuente: N/A
// Cond. de ejecucion  : N/A
// Dias de ejecucion   : N/A                                 Horario: N/A
//                              MODIFICACIONES
/*#-----------------------------------------------------------------------------  #
# Autor               :  Daniel Ramírez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-------------------------------------------------------------------------------#*/
%>
<%@ page language="java" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%
response.setHeader     ("Cache-Control", "no-store");
response.setHeader     ("Pragma",        "no-cache");
response.setDateHeader ("Expires",       0);

%>
<%@ page import="com.wellcom.io.*" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>
<%@ page import="com.wellcom.struts.*" %>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<jsp:useBean id="datos" scope="session" class="com.prosa.struts.AltasForm"/>
<%
    if(!ga.AccessGranted(session, "grantAccess"))
    {
        response.sendRedirect("login.jsp");
    }
%>
<html>
    <head>
        <title>LACPI ALTA</title>
    </head>
    <SCRIPT LANGUAGE="JavaScript" SRC="<%= request.getContextPath() + "/javascript/date.js"%>"></SCRIPT>
    <SCRIPT LANGUAGE="JavaScript" SRC="<%= request.getContextPath() + "/javascript/AnchorPosition.js"%>"></SCRIPT>
    <SCRIPT LANGUAGE="JavaScript" SRC="<%= request.getContextPath() + "/javascript/PopupWindow.js"%>"></SCRIPT>
    <SCRIPT LANGUAGE="JavaScript" SRC="<%= request.getContextPath() + "/javascript/CalendarPopup.js"%>"></SCRIPT>
    <script language="javascript">
        function ejecutar(valor)
        {
            document.forms[0].accion.value = valor;
            return true;
        }
        function eliminar(valor)
        {
            if(confirm("Seguro de eliminar?")){
                document.forms[0].accion.value = valor;
                return true;
            }
            return false;
        }
        function unSoloCheckBox(a) {
            for ( i=0; i< document.forms[0].elements.length; i++ ) {
                var objCntrl = document.forms[0].elements[i];
                if ( objCntrl.type == 'checkbox' && objCntrl.value != a.value) {
                    if ( a.checked ) {
                        objCntrl.checked = false;
                        objCntrl.unchecked = true;
                    }
                }
            }
        }
    </script>
    <link rel="stylesheet" href="<%= request.getContextPath() + "/css/estilos.css"%>" type="text/css">
    <link rel="stylesheet" href="<%= request.getContextPath() + "/css/calendar.css"%>" type="text/css">
    <body>
    <table   width="100%" border="0" cellpadding="0" cellspacing="0" >
       <tr>
         <td id="rightColumns" valign="top" >
              <!--Modificacion: SAS-DRT F-52-8063-16 Marca de Inicio-->
            <form action="ControllerServletHerr?action=AltasLACPI" method="post">
              <!--Modificacion: SAS-DRT F-52-8063-16 Marca de FIN-->
            <table width="100%" border="1" bordercolor="#CE000C">
                <tr>
                    <td class="vacio">&nbsp;</td>
                </tr>
                <tr>
                    <td class="titulo2">
                        LACPI ALTA
                    </td>
                </tr>
                <tr><td class="error"><errors property="accion" /></td></tr>
                <tr><td class="margen">
                    <tr><td class="margentabla">
                        <display:table id="tabla" name="sessionScope.datos.listado" export="false" class="anchotabla2" pagesize="30" sort="list" decorator="com.prosa.wrapper.ConsultaWrapper">
                            <display:setProperty name="paging.banner.no_items_found">
                                <table width="350"><tr><span class="pagebanner">No se encontraron {0}.</span></tr>
                            </display:setProperty>
                            <display:setProperty name="paging.banner.one_item_found">
                                <table width="350"><tr><span class="pagebanner">Un {0} encontrado.</span></tr>
                            </display:setProperty>
                            <display:setProperty name="paging.banner.all_items_found">
                                <table width="350"><tr><span class="pagebanner">{0} {1} encontrados, mostrando todos los {2}.</span></tr>
                            </display:setProperty>
                            <display:setProperty name="paging.banner.some_items_found">
                                <table width="350"><tr><span class="pagebanner">{0} {1} encontrados, mostrando {2} al {3}.</span></tr>
                            </display:setProperty>
                            <display:column class="coldato1" property="checkAfiliacion" title="" sortable="false" media="html"/>
                            <display:column class="coldato2" property="afiliacion"   title="Afiliaci&oacute;n"  sortable="true" />
                        </display:table>
                    </td></tr>
                </td></tr>
                <tr>
                    <td class="botones">
                        <input type="submit" name="btnAgregar"  onclick="javascript:return ejecutar(2);" class="button" value="Agregar">
<%
    if(Integer.parseInt(datos.getNumListado()) > 0)
    {
%>
                        <input type="submit" name="btnEliminar" onclick="javascript:return eliminar(4);" class="button" value="Eliminar">
<%
    }
%>

                    </td>
                </tr>
                <tr><td class="margen">
                    <tr><td class="margentabla">
                        <display:table id="tabla3" name="sessionScope.datos.listado3" export="false" class="anchotabla2" pagesize="30" sort="list" decorator="com.prosa.wrapper.ConsultaWrapper">
                            <display:setProperty name="paging.banner.no_items_found">
                                <table width="350"><tr><span class="pagebanner">No se encontraron {0}.</span></tr>
                            </display:setProperty>
                            <display:setProperty name="paging.banner.one_item_found">
                                <table width="350"><tr><span class="pagebanner">Un {0} encontrado.</span></tr>
                            </display:setProperty>
                            <display:setProperty name="paging.banner.all_items_found">
                                <table width="350"><tr><span class="pagebanner">{0} {1} encontrados, mostrando todos los {2}.</span></tr>
                            </display:setProperty>
                            <display:setProperty name="paging.banner.some_items_found">
                                <table width="350"><tr><span class="pagebanner">{0} {1} encontrados, mostrando {2} al {3}.</span></tr>
                            </display:setProperty>
                            <display:column class="coldato1" property="checkCuenta" title="" sortable="false" media="html"/>
                            <display:column class="coldato2" property="cuenta"   title="Cuenta"  sortable="true" />
                        </display:table>
                    </td></tr>
                </td></tr>
                <tr>
                    <td class="botones">
                        <input type="submit" name="btnAgregar2"  onclick="javascript:return ejecutar(6);" class="button" value="Agregar">
<%
    if(Integer.parseInt(datos.getNumListado3()) > 0)
    {
%>
                        <input type="submit" name="btnEliminar" onclick="javascript:return eliminar(8);" class="button" value="Eliminar">
<%
    }
%>
                    </td>
                </tr>
                <tr><td class="error"><%=datos.getError()%></td></tr>
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
