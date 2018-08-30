<%@page import="com.wellcom.prosa.sacii.RptUtils"%>
<%
/*###############################################################################
# Nombre del Programa :  lstGrpSaciiHeader.jsp                                  #
# Autor               :  JOAQUIN MOJICA Q.                                      #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-08-299-04                 	   FECHA:15/10/2008     #
# Descripcion General :										                    #
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :						                                    #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :														    #
#################################################################################
#								MODIFICACIONES                                  #
# Autor               : Carlos Mendez De Luna                                   #
# Compania            : PROSA                                                   #
# Proyecto/Procliente : C-04-3035-13                            Fecha:11/12/2013#
# Modificacion        : Generacion de Proceso de Diferencia de Cuota de         #
#                       Intercambio de EGLO SAC2                                #
#-----------------------------------------------------------------------------  #
# Autor               :  Daniel Ramírez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<!--Modificacion: SAS-DRT F-52-8063-16 Marca de inicio-->
<%@page import="com.wellcom.conexion.*"%>
<!--Modificacion: SAS-DRT F-52-8063-16 Marca de fin-->
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.wellcom.prosa.sacii.RptUtils"%>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>

<%
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
    }
%>

<% 
/* Inicia cambio C-04-3035-13 */
        RptUtils utils = new RptUtils();

/**
    * Database
    */
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
    ConexionORACLE conOracle = null;
    String sessionID;
    //String GRUPO_SACII;
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
    String query;
    ArrayList tocAL;
    Iterator it;
    String[] tmpAStr;
    String[] rowValue;
    int i;   
    /**
    * Action type
    */
    String rbtnDelModGrpSacii;
    String btnDelModGrpSacii;
    String btnModGrpSacii;
    String output;
    String txtfPSI_NSI_CLR_ID;
    String txtfNCI_NSI_CLR_D;
        String txtfPSI_SETL_DT;
    String txtfPSI_IND;
    String txtfPSI_REC_DT;

    String txtfUsuario;
        sessionID = request.getRequestedSessionId();
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/    
    //db = (Database)session.getAttribute(sessionID + "db");
    //GRUPO_SACII = (String)session.getAttribute("GRUPO_SACII");
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
    tocAL = (ArrayList)session.getAttribute(sessionID + "tocAL");
    
    txtfUsuario = (String)session.getAttribute("login");
 btnModGrpSacii = request.getParameter("btnModGrpSacii");
if(btnModGrpSacii != null) {
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
     conOracle = new ConexionORACLE();
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/ 
        
        rowValue = (String[])session.getAttribute("rowValueGrpSacii");
        
        txtfPSI_NSI_CLR_ID = (String)request.getParameter("txtfPSI_NSI_CLR_ID");
        txtfNCI_NSI_CLR_D = (String)request.getParameter("txtfNCI_NSI_CLR_D");
        txtfPSI_SETL_DT = (String)request.getParameter("txtfPSI_SETL_DT");
        txtfPSI_IND = (String)request.getParameter("txtfPSI_IND");
                txtfPSI_REC_DT= (String)request.getParameter("txtfPSI_REC_DT");
        
        query = "UPDATE pmadmin.PRSA_SETL_IND" 
            + " SET PSI_IND = " + txtfPSI_IND
            + ", PSI_USR_CHNG='" + txtfUsuario + "'"
            + ", PSI_CHNG_DT=SYSDATE" 
            + " WHERE PSI_NSI_CLR_ID = " + rowValue[0]
            + " AND PSI_REC_DT=TO_DATE('" + rowValue[5] + "', 'dd/mm/yyyy hh24:mi:ss')";
        //System.out.println("QueryModifiy: " + query);
        /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
        conOracle.Conectar();
        conOracle.Modificar(query);
        //db.setQueryUpdate(query);
        //db.executeQueryUpdate();
        /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
        //output = "Registro Actualizado.";                
        
        //Lanza condcion a CTM
        int estado = Integer.parseInt(txtfPSI_IND);
            int tli = Integer.parseInt(rowValue[0]);
            String[] fecha = rowValue[5].split("/");
            if(estado != 3){
                    switch (tli){
                       case 22:
                         utils.lanzaCondicion("PMTGLIQCLOV02_OK", fecha[1]+fecha[0], estado);
                          break;
                       case 26:
                         utils.lanzaCondicion("PMTGLIQCINTV03_OK", fecha[1]+fecha[0], estado);
                         break;
                       case 32:
                         utils.lanzaCondicion("PMTGLIQCEGLV03_OK", fecha[1]+fecha[0], estado);
                         break;
                       case 33:
                         utils.lanzaCondicion("PMTGLIQCEGLV04_OK", fecha[1]+fecha[0], estado);
                         break;
                    }
                  }else{
                        switch (tli){
                       case 22:
                         utils.lanzaCondicion("PMTWEBRPCLV02_OK", fecha[1]+fecha[0], estado);
                          break;
                       case 26:
                         utils.lanzaCondicion("PMTWEBRPINTV03_OK", fecha[1]+fecha[0], estado);
                         break;
                       case 32:
                         utils.lanzaCondicion("PMTWEBRPEGLV03_OK", fecha[1]+fecha[0], estado);
                         break;
                       case 33:
                         utils.lanzaCondicion("PMTWEBRPEGLV04_OK", fecha[1]+fecha[0], estado);
                         break;
                    }
                  }
          /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
     conOracle.Desconectar();
          /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
    }
    /* Termina cambio C-04-3035-13 */
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>LIBERACION DE CIFRAS</title>

        <script type="text/javascript">
            var span = null;
            // var ventana = null;
            var showTextInitDate = false;
            var showTextEndDate = false;
            var numPage = 0;
            function valida(form1, accion)
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
                        span = document.getElementById("txtEndDate");
                        span.style.display = 'none';
                        showTextInitDate = false;
                    }


                    if (document.frmGrpSaciiHeader.txtfStartDate.value == "" || document.frmGrpSaciiHeader.txtfStartDate.value == null)
                    {
                        span = document.getElementById("txtInitDate");
                        span.style.display = 'inline';
                        showTextInitDate = true;
                        return false;
                    } else if (document.frmGrpSaciiHeader.txtfEndDate.value == "" || document.frmGrpSaciiHeader.txtfEndDate.value == null)
                    {
                        span = document.getElementById("txtEndDate");
                        span.style.display = 'inline';
                        showTextInitDate = true;
                        return false;
                    } else
                    {
                        //window.location="lstGrpSacii.jsp?txtfStartDate="+document.frmGrpSaciiHeader.txtfStartDate.value+"&txtfEndDate="+document.frmGrpSaciiHeader.txtfEndDate.value+"&btnLstGrpSacii="+document.frmGrpSaciiHeader.btnLstGrpSacii.value;

                        sendDatas("txtfStartDate", "txtfEndDate", "lstGrpSaciiiAccion", "tableTablaPrincipal");
                        //divTablaPrincipal

                        return true;
                    }
                } catch (e)
                {

                }

            }
        </script>
        <script type="text/javascript" src="scripts/envio.js"></script>
    </head>

    <body>
        <div align="center">
            <form action="delModSacii.jsp" method="post" name="frmGrpSaciiHeader" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tbl_border" >
                    <tr>
                        <th id= "tituloTab" width="100%" colspan=4 ><font color="#000000">Libera</font><font color="#000000">ci&oacute;n</font><font color="#000000"> de Cifras</font><br></th>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="3"><br/></td>
                    </tr>
                    <tr>
                        <td><div align="right">Fecha Inicio:</div></td>
                        <td><div align="left">
                                &nbsp;
                                <input name="txtfStartDate" type="text" id="txtfStartDate" size="15" readonly maxlength="15" value=<%=session.getAttribute("fechaHoy")%>>
                                <a href="javascript:void(0)" onclick="if (self.gfPop)
                    gfPop.fPopCalendar(document.frmGrpSaciiHeader.txtfStartDate);
                return false;" hidefocus>
                                    <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg"  border="0" alt="">
                                </a><br/>
                                <span id = "txtInitDate" class="ocultar">Selecciona una fecha</span>
                            </div></td>
                        <td><div align="right">Fecha Fin:</div></td>
                        <td><div align="left">
                                &nbsp;
                                <input name="txtfEndDate" type="text" id="txtfEndDate" size="15" readonly maxlength="15" value=<%=session.getAttribute("fechaHoy")%>>
                                <a href="javascript:void(0)" onclick="if (self.gfPop)
                                            gfPop.fPopCalendar(document.frmGrpSaciiHeader.txtfEndDate);
                                        return false;" hidefocus>
                                    <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg"  border="0" alt="">
                                </a><br/>
                                <span id = "txtEndDate" class="ocultar">Selecciona una fecha</span>
                            </div></td>

                    </tr>
                    <tr>
                        <td colspan="6"><div align="center">
                                <input name="btnLstGrpSacii" type="button" id="btnLstGrpSacii" value="OK" onclick="javascript:return valida(this.form);">
                                &nbsp;
                                <input name="btnErase" type="reset" id="btnErase" value="Borrar">
                            </div></td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <div id="divTablaPrincipal" align="center" >
                                <br/>
                                <br/>
                                <div id="tableTablaPrincipal" ><jsp:include page="lstGrpSaciiMain.jsp"/></div>

                            </div>
                        </td>
                    </tr>

                </table>

            </form>
        </div>
        <iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="scripts/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
        </iframe>
    </body>
</html>
