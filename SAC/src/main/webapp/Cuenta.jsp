<%
// ----------------------------------------------------------------------------
// Nombre del Programa : Cuenta.jsp
// Autor               : Manuel Villalobos
// Compania            : GSOF
// Proyecto/Procliente : C-08-2129-12                       Fecha: 11/FEB/2015
// Descripcion General : JSP PARA LA PANTALLA DE DETALLE DE CUENTA
// Programa Dependiente: N/A
// Programa Subsecuente: N/A
// Cond. de ejecucion  : N/A
// Dias de ejecucion   : N/A                                 Horario: N/A
//                              MODIFICACIONES
// ----------------------------------------------------------------------------
// Numero de Parametros:
// Parametros Entrada  :                                    Formato:
//
// Parametros Salida   : N/A                                Formato: N/A
// ----------------------------------------------------------------------------
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
<title>TIPO DE CAMBIO</title>
<meta http-equiv="Cache-Control" content="no-cache"/>
    <link href="css/styles.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="scripts/resize.js"></script>
    <script type="text/javascript" src="scripts/menu.js"></script>
    <script type="text/javascript" src="scripts/envio.js"></script>
    <script type="text/javascript" src="scripts/eventTable.js"></script>
</head>
<body>
<div id="wrapper">
<table width="100%" border="0" cellpadding="0" cellspacing="2">
    <tr>
        <td id="leftPanel" valign="top" ><jsp:include page="menu.jsp"/></td>
        <td id="rightPanel" valign="top" ><jsp:include page="CuentaDet.jsp"/></td>
    </tr>
</table>
<jsp:include page="footer.jsp"/>
</div>
</body>
</html>