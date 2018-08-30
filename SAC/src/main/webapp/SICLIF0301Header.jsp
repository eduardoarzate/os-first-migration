<%-- 
################################################################################
# Nombre del Programa : SICLIF0301Header.jsp                                        #
# Autor               : Victor H. Montoya G.                                   #
# Compania            : eNova                                                  #
# Proyecto/Procliente : P-02-0408-10                         Fecha: {date} #
# Descripcion General : ...                                         #
# Programa Dependiente:                                                        #
# Programa Subsecuente:                                                        #
# Cond. de ejecucion  :                                                        #
# Dias de ejecucion   :                                      Horario: hh:mm    #
################################################################################
#                              MODIFICACIONES                                  #
#								MODIFICACIONES                                  #
# Autor               :  Daniel Ramírez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
################################################################################
# Numero de Parametros:                                                        #
# Parametros Entrada  :                                      Formato:          #
# Parametros Salida   :                                      Formato:          #
##############################################################################*/

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>
<%@ page import="com.wellcom.io.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%
    ArrayList cbBancoAdq;
    HTML comboBox;
 /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
        ComboBoxGen myComboBox;
%>

<%
java.util.ArrayList<com.prosa.mx.pmr.dto.Reverso> rows = (java.util.ArrayList) request.getAttribute("items");
String msg = (String) request.getAttribute("msg");
com.prosa.mx.pmr.dto.Reverso rev = null;

String fecha = request.getParameter("txtfStartDate") == null ? "" : request.getParameter("txtfStartDate");
String cuenta = request.getParameter("cuenta") == null ? "" : request.getParameter("cuenta");
String ref = request.getParameter("ref") == null ? "" : request.getParameter("ref");
String auth = request.getParameter("auth") == null ? "" : request.getParameter("auth");
String comer = request.getParameter("comer") == null ? "" : request.getParameter("comer");

    myComboBox = new ComboBoxGen();
    /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
    cbBancoAdq = myComboBox.getBancoAdq(session);

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>SAC 2</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css">
        <style type="text/css">
            thead{font-weight:bold}
        </style>
        <script type="text/javascript">
            var span = null;
            var showTextInitDate = false;
            var showTextEndDate = false;
            var showTipoMoneda = false;

            function valida()
            {
                try
                {
                    if (showTextInitDate)
                    {
                        span = document.getElementById("txtInitDate");
                        span.style.display = 'none';
                        showTextInitDate = false;
                    } else if (showTextEndDate)
                    {
                        span = document.getElementById('txtEndDate');
                        span.style.display = 'none';
                        showTextEndDate = false;
                    } else if (showTipoMoneda)
                    {
                        span = document.getElementById('txtTipoMoneda');
                        span.style.display = 'none';
                        showTipoMoneda = false;
                    }

                    if (document.frmTOCHeader.txtfStartDate.value == "" || document.frmTOCHeader.txtfStartDate.value == null)
                    {
                        span = document.getElementById("txtInitDate");
                        span.style.display = 'inline';
                        showTextInitDate = true;
                        return false;
                    } else if (document.frmTOCHeader.txtfEndDate.value == "" || document.frmTOCHeader.txtfEndDate.value == null)
                    {
                        span = document.getElementById('txtEndDate');
                        span.style.display = 'inline';
                        showTextEndDate = true;
                        return false;
                    } else if (document.frmTOCHeader.moneda.value == "None")
                    {
                        span = document.getElementById('txtTipoMoneda');
                        span.style.display = 'inline';
                        showTipoMoneda = true;
                        return false;
                    } else
                    {
                        return true;
                    }
                } catch (e)
                {

                }

            }

            function buscar() {
                document.frmTOCHeader.send.value = "0";
                document.frmTOCHeader.submit();
            }

            function guardar() {
                document.frmTOCHeader.send.value = "1";
                document.frmTOCHeader.submit();

            }
        </script>
    </head>

    <body>
        <div align="center">
            <form action="<%=request.getContextPath()%>/findrev" method="post" name="frmTOCHeader" target="SICLIF0301" id="frmTOCHeader">
                <input type="hidden" name="send" id="action" value="0">
                <table align="left" width="100%"><tr><td>
                            <table align="left" width="100%" >
                                <tr>
                                    <th id="tituloTab" width="100%" colspan="2" align="left" ><font color="#000000">SICLIF0301 Reverso Tx Disminucion Fraudes Visa/Mcard<br></font></th>
                                </tr>
                                <tr><td align="left"><strong>Adq:</strong></td>
                                    <td>	<%comboBox = new HTML();
	               	out.println( "" + comboBox.getComboBox( "banco", cbBancoAdq, "Selecciona un Banco" ) );%>
                                        <br/>
                                        <span id = "txtbancoAdq" class="ocultar">Elije una Opci&oacute;n</span>
                                    </td></tr>
                                <tr><td align="left"><strong>Fecha proc: (dd/mm/yyyy)</strong></td>
                                    <td>

                                        <input name="txtfStartDate" type="text" id="txtfStartDate" size="15" readonly maxlength="15">
                                        <a href="javascript:void(0)" onclick="if (self.gfPop)
                                                    gfPop.fPopCalendar(document.frmTOCHeader.txtfStartDate);
                                                return false;" hidefocus>
                                            <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg"  border="0" alt="">
                                        </a><br/>
                                        <span id = "txtInitDate" class="ocultar">Selecciona una fecha</span>

                                    </td></tr>
                                <tr><td align="left"><strong>Cuenta:</strong></td><td><input type="text" name="cuenta" size="20" value="<%=cuenta%>"></td></tr>
                                <tr><td align="left"><strong>Referencia:</strong></td><td><input type="text" name="ref" size="20" value="<%=ref%>"></td></tr>
                                <tr><td align="left"><strong>Autorizaci&oacute;n:</strong></td><td><input type="text" name="auth" size="20" value="<%=auth%>"></td></tr>
                                <tr><td align="left"><strong>Comercio:</strong></td><td><input type="text" name="comer" size="20" value="<%=comer%>"></td></tr>
                                <tr><td colspan="2" align="center"><input type="button" value="Selecci&oacute;n" onclick="buscar()"></tr>
                                        <%if (msg!=null){%>
                                <tr><td colspan="2" align="center"><%=msg%></td></tr>
                                    <%}%>
                            </table>
                        <td/></tr>


                    <%if (rows!=null && rows.size()>0){%>

                    <tr><td>
                            <table border="1">
                                <thead>
                                    <tr><td/>
                                        <td>Cuenta</td>
                                        <td>Autorizaci&oacute;n</td>
                                        <td>F.Proceso</td>
                                        <td>F.Consumo</td>
                                        <td>Afiliaci&oacute;n</td>
                                        <td>Comercio</td>
                                        <td>Tipo Tx</td>
                                        <td>Emisor</td>
                                        <td>Importe</td>
                                        <td>Archivo</td>
                                        <td>Referencia</td>
                                    </tr>
                                </thead>
                                <%for(com.prosa.mx.pmr.dto.Reverso r:rows){%>
                                <tr>
                                    <td><input type="checkbox" name="check" <%=r.getIndBenef()%> value="<%=r.getId()%>"></td>
                                    <td><%=r.getCuenta()%></td>
                                    <td><%=r.getAutorizacion()%></td>
                                    <td><%=r.getFechaProceso()%></td>
                                    <td><%=r.getFechaConsumo()%></td>
                                    <td><%=r.getComercio()%></td>
                                    <td><%=r.getNombreComercio()%></td>
                                    <td><%=r.getTipoTransaccion()%></td>
                                    <td><%=r.getBancoEmisor()%></td>
                                    <td><%=r.getImporteTotal()%></td>
                                    <td><%=r.getArchivo()%></td>
                                    <td><%=r.getReferencia()%></td>
                                </tr>
                                <%}%>
                            </table>

                            <p align="center"><input type="button" value="Guardar" onclick="guardar()"></p>
                        </td></tr>
                        <%}%>
                </table>
            </form>
        </div>

        <iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="scripts/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
        </iframe>
    </body>
</html>
