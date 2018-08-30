<%
/*###############################################################################
# Nombre del Programa :  insertar.jsp	 	                                    #
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
#------------------------------------------------------------------------------#
# Autor               :  Daniel Ramirez Torres                                 #
# Compania            :  SAS S.A. DE C.V.                                      #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 01/03/2017        #
# Modificacion        :  Mejora Conexiones  SAC2                               #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                  #
#------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!--Modificacion: SAS-DRT F-52-8063-16 Marca de inicio-->
<%@page import="com.wellcom.conexion.*"%>
<%/*@page import="com.wellcom.sql.Database"*/%>
<!--Modificacion: SAS-DRT F-52-8063-16 Marca de fin-->
<%@page import="com.wellcom.io.HTML"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>

<%
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
    }
%>


<%
    /**
    * Database
    */
     /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
    ConexionORACLE conOracle = null;
    //Database db;
   /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
    String sessionID;
    String TIPO_DE_CAMBIO;
    String query;
    
    /**
    * Data
    */
    String btnInsTOC;
    String output;
    String txtfDate;
    String txtfTOC;
    
    /*
    * HTML
    */
    HTML html;
%>

<%
    /**
    * Action type
    */
    btnInsTOC = request.getParameter("btnInsTOC");
    
    /**
    * Database
    */
    sessionID = request.getRequestedSessionId();
        /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
    conOracle = new ConexionORACLE();
//    db = (Database)session.getAttribute(sessionID + "db");
       /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
    TIPO_DE_CAMBIO = (String)session.getAttribute("TIPO_DE_CAMBIO");
    /**************************************************************************/
    
    /**
    * From insTOC
    */
    if(btnInsTOC != null) {
        
        html = new HTML();
        txtfDate = request.getParameter("txtfDate");
        txtfTOC = request.getParameter("txtfTOC");
        
        html.addFieldToValidate("Fecha", txtfDate);
        html.addFieldToValidate("Tipo de Cambio", txtfTOC);
        
        if(html.validateFields().size() == 0) {
            query = "INSERT INTO PRE.TBL_PRE_PREFIJO2"
                + "(ENTIDAD_PROSA, PREFIJO) "
                + "VALUES(" + txtfDate+","
                + txtfTOC + ")";
            System.out.println("QueryInsert: " + query);
                    /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
            conOracle.Conectar();
            conOracle.Insertar(query);
            //db.setQueryInsert(query);
            //db.executeQueryInsert();
                    /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
            output = "Registro Insertado.";
        } else {
            out.println("Los campos: " + html.validateFields().toString() + " son obligatorios.");
        }
    }
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%
            if(output != null) {
                out.println(
                    "<br><div align=\"center\">"
                    + output
                    + "</div><br>"
                );
            }
        %>
        <div align="center"><!-- <H5>Alta de Tipo de Cambio.</H5>  -->
            <div align="center">
                <!--Modificacion: SAS-DRT F-52-8063-16 Marca de inicio-->
                <form action="ControllerServletHerr?action=inserta" method="post" enctype="application/x-www-form-urlencoded" name="frmInsTOC" id="frmInsTOC">
                <!--Modificacion: SAS-DRT F-52-8063-16 Marca de fin-->
                    <table width="100%" border="0" cellspacing="0" cellpadding="5" class="tbl_border">
                        <th class= "td_header" width="100%" colspan=4 >ALTA DE PREFIJO</th>
                        <tr>
                            <td><div align="right">FIID:</div></td>
                            <td><div align="left">
                                    <input name="txtfDate" type="text" id="txtfDate" size="15" maxlength="3">                                
                                </div></td>
                        </tr>
                        <tr>
                            <td><div align="right">Prefijo: </div></td>
                            <td><div align="left">
                                    <input name="txtfTOC" type="text" id="txtfTOC" size="15" maxlength="6">
                                </div></td>
                        </tr>
                        <tr>
                            <td colspan="2"><div align="center">
                                    <input name="btnInsTOC" type="submit" id="btnInsTOC" value="Agregar">
                                    <input name="btnErase" type="reset" id="btnErase" value="Borrar">
                                </div></td>
                        </tr>
                    </table>
                </form>
            </div>
            <iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="scripts/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
                </body>
                </html>
