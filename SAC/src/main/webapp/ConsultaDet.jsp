<%
// ----------------------------------------------------------------------------
// Nombre del Programa : ConsultaDet.jsp
// Autor               : Manuel Villalobos
// Compania            : GSOF
// Proyecto/Procliente : C-08-2129-12                       Fecha: 11/FEB/2015
// Descripcion General : JSP PARA LA PANTALLA DE CONSULTA DE DEVOLUCIONES LACPI
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
<jsp:useBean id="datos" scope="session" class="com.prosa.struts.ConsultaForm"/>
<%
    if(!ga.AccessGranted(session, "grantAccess"))
    {
        response.sendRedirect("login.jsp");
    }
%>
<html>
    <script language="javascript">
        function ejecutar(valor)
        {
            if((document.forms[0].fechaInicio.value.length != 0) && (document.forms[0].fechaFinal.value.length != 0)){
                document.forms[0].accion.value = valor;
                return true;
            }
            else {
                alert("Las Fechas deben tener formato 'dd/mm/aaaa'");
                return false;
            }
        }
    </script>
    <link rel="stylesheet" href="<%= request.getContextPath() + "/css/estilos.css"%>" type="text/css">
   <body>
   <table   width="100%" border="0" cellpadding="0" cellspacing="0">
   <tr>
     <td id="rightColumns" valign="top" >
           <!--Modificacion: SAS-DRT F-52-8063-16 Marca de Inicio-->
        <form action="ControllerServletHerr?action=ConsultaLACPI" name="frmTOCHeader" method="post">
           <!--Modificacion: SAS-DRT F-52-8063-16 Marca de FIN-->
            <table width="100%" border="1" bordercolor="#CE000C">
                <tr>
                    <td class="vacio">&nbsp;</td>
                </tr>
                <tr>
                    <td class="titulo2" colspan="4">
                        LACPI REPORTE
                    </td>
                </tr>
                <tr>
                    <td class="vacio" colspan="4">
                        &nbsp;
                    </td>
                </tr>
                <tr><td class="margen">
                    <table width="100%" class="marco">
                        <tr><td class="vacio">&nbsp;
                        </td></tr>
                        <tr class="margentabla">
                            <td class="etiquetaListado">
                                Fecha Inicial
                            </td>
                            <td valign="middle">
                                <input name="fechaInicio" type="text" id="txtfStartDate" size="15" readonly maxlength="15" value=<%=datos.getFechaInicio()%>>
                                <a href="javascript:void(0)" onclick="if(self.gfPop)gfPop.fPopCalendar(document.frmTOCHeader.fechaInicio);return false;" hidefocus>
                                    <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg" border="0" alt="">
                                </a><br/>
                            </td>
                            <td class="etiquetaListado">
                                Fecha Final
                            </td>
                            <td valign="middle">
                                <input name="fechaFinal" type="text" id="txtfEndDate" size="15" readonly maxlength="15" value=<%=datos.getFechaFinal()%>>
                                <a href="javascript:void(0)" onclick="if(self.gfPop)gfPop.fPopCalendar(document.frmTOCHeader.fechaFin);return false;" hidefocus>
                                    <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg" border="0" alt="">
                                </a><br/>
                            </td>
                        </tr>
                        <tr class="margentabla">
                            <td width="15%" class="etiquetaListado">
                                Afiliaci&oacute;n
                            </td>
                            <td width="35%" valign="middle">
                                <input type="text" name="afiliacion" size="9" maxlength="9" class="textbox" tabindex="3" value=<%=datos.getAfiliacion()%>>
                            </td>
                            <td width="15%" class="etiquetaListado">
                                Cuenta
                            </td>
                            <td width="35%" valign="middle">
                                <input type="text" name="cuenta" size="19" maxlength="19" class="textbox" tabindex="4" value=<%=datos.getCuenta()%>>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4" >
                                <input type="submit" name="btnBuscar" onclick="javascript:return ejecutar(1);" value="Buscar">
                            </td>
                        </tr>
                    </table>
                </td></tr>
                <tr><td class="margen">
                    <tr><td class="margentabla">
                        <display:table id="tabla" name="sessionScope.datos.listado" export="true" class="anchotabla" pagesize="30" sort="list" decorator="com.prosa.wrapper.ConsultaWrapper">
                            <display:setProperty name="export.banner">
                                <table width="700"><tr><br><div class="exportlinks">Opciones de Exportar: {0}</div></tr></table>
                            </display:setProperty>
                            <display:setProperty name="export.excel.filename"   value="reporte.xls" />
                            <display:column class="colconsulta1" property="numero_comercio"         title="Afiliación"          sortable="false" />
                            <display:column class="colconsulta2" property="fiid"                    title="Fiid"                sortable="false" />
                            <display:column class="colconsulta3" property="enmascarada"             title="Cuenta"              sortable="false" />
                            <display:column class="colconsulta5" property="numero_autorizacion"     title="Núm Autorización"    sortable="false" />
                            <display:column class="colconsulta4" property="importe_total_transac"   title="Monto"               sortable="false" />
                            <display:column class="colconsulta6" property="ttr_numero"              title="Registro"            sortable="false" />
                        </display:table>
                    </td></tr>
                </td></tr>
                <tr><td class="error"><%=datos.getError()%></td></tr>
                <tr><td class="error"><%=datos.getError2()%></td></tr>
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
    <iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="scripts/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
    </iframe>
   </body>
</html>
