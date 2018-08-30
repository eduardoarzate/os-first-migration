<%
/*###############################################################################
# Nombre del Programa :  tipocambioHeader.jsp                                   #
# Autor               :  JOAQUIN MOJICA Q.                                      #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-08-299-04                     FECHA:15/10/2008       #
# Descripcion General :                                                         #
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :                                                         #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :                                                         #
#################################################################################
#                               MODIFICACIONES                                  #
# Autor               :  Hector D Arellano J                                    #
# Compania            :  Hosting Business                                       #
# Proyecto/Procliente :  B-52-2103-14 Mejora al proceso de captura de paridades #
#                                                        Fecha:11/02/2014       #
# Modificación        :  Se agrega registro en SUPERSIC.TIPOS_CAMBIO por        #
#                        medio de dblinks LG_PMTU_IFO_01 y LG_PMTU_SIC          #
#-----------------------------------------------------------------------------  #
# Autor               : Carlos Mendez De Luna                                   #
# Compania            : PROSA                                                   #
# Proyecto/Procliente : C-04-3035-13                            Fecha:11/12/2013#
# Modificacion        : Generacion de Proceso de Diferencia de Cuota de         #
#                       Intercambio de EGLO SAC2                                #
#-----------------------------------------------------------------------------  #
# Autor               :  Daniel Ramírez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 27/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<%@ page import="com.wellcom.io.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>
<!--Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación-->
<%@page import="com.wellcom.conexion.*"%>
<!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación-->
<%@page import="java.util.Iterator"%>
<%/*###############INICIO DE CAMBIO###############
B-52-2103-14 Mejora al proceso de captura de paridades*/%>
<%@page import="java.sql.ResultSet"%>
<%/*###############FIN DE CAMBIO###############
B-52-2103-14 Mejora al proceso de captura de paridades*/%>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%
        ArrayList cbFiid;
        HTML comboBox;
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
        ComboBoxGen myComboBox;
        /* Inicia cambio C-04-3035-13 */
        RptUtils util = new RptUtils();
        /* Termina cambio C-04-3035-13 */
%>
<%
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
    }
    myComboBox = new ComboBoxGen();
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
    session.setAttribute("accion","consulta");
    cbFiid = myComboBox.getBancosBU(session);
%>

<%
/**
    * Database
    */
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
    //Database db;
        ConexionORACLE conOracle = null;
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
    String sessionID;
    String query;
    String queryValida;
    ArrayList tocAL;
    Iterator it;
    String[] rowValue = null;
    int i;   
    int ResultValida;
    /*###############INICIO DE CAMBIO###############
    B-52-2103-14 Mejora al proceso de captura de paridades*/
    String queryVistaEmi;
    String queryInsTipCam01;
    String queryInsTipCam02;
    String queryUpda01;
    String queryUpda02;
    ArrayList<String> vistaAL = new ArrayList<String>();
    int ResultValidaVistaEmi = 0;
    String numeroProsa = null;
    ResultSet queryRs= null;
    /*###############FIN DE CAMBIO###############
    B-52-2103-14 Mejora al proceso de captura de paridades*/
    /**
    * Action type
    */
    String rbtnEdita;//String rbtnDelModGrpSacii;
    String btnaggtipocambio;//String btnDelModGrpSacii;
    String btninsertaregistro;//String btnModGrpSacii;
    String btnedita;
    String output;
    String campoBU;
    String campoCODIGO;
    String campoFECHA;
    String campoCOMPRA;
    String campoVENTA;
    String campoPROMEDIO;
    String valor = null;
    String txtfUsuario;
    String role;
    
    sessionID = request.getRequestedSessionId();
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
    //db = (Database)session.getAttribute(sessionID + "db");
    tocAL = (ArrayList)session.getAttribute(sessionID + "tocAL");
    
    txtfUsuario = (String)session.getAttribute("login");
    role = (String)session.getAttribute("role");
    btninsertaregistro = request.getParameter("btninsertaregistro"); //btnModGrpSacii = request.getParameter("btnModGrpSacii");
    btnedita = request.getParameter("btnedita");
    
        conOracle = new ConexionORACLE();
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
    
if(btnedita != null)
{
                rowValue = (String[])session.getAttribute("rowValuetipoSacii");
		
        campoBU = rowValue[0];
        campoCODIGO = rowValue[2];
        campoFECHA = rowValue[3];
        campoCOMPRA = (String)request.getParameter("campoCOMPRA");
        campoVENTA = (String)request.getParameter("campoVENTA");
        campoPROMEDIO = (String)request.getParameter("campoPROMEDIO");
      
      for(int z=1; z<=3; z++){
        if(z==1){valor = campoCOMPRA;}
        else if(z==2){valor = campoVENTA;}
        else if(z==3){valor = campoPROMEDIO;}
      	
        query =
        " UPDATE CORE.CZ_CRNCY_RATE CCR \n"+
        " SET CCR.CR_RATE = "+valor+", \n"+
        "     CCR.CR_UPD_DATE = SYSDATE, \n"+
        "     CCR.CR_UPD_USER = '"+txtfUsuario+"' \n"+
        " WHERE CCR.CR_BU = "+campoBU+"\n"+
        " AND CCR.CR_CD = "+campoCODIGO+"\n"+
        " AND CCR.CR_TYP = "+z+"\n"+
        " AND CCR.CR_EFF_DT = TO_DATE('"+campoFECHA+"','DD/MM/YYYY') \n";
        
        System.out.println("QueryUpdate: " + query);
        /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
         conOracle.Conectar();
                  conOracle.Modificar(query);
        
      //  db.setQueryUpdate(query);
       // db.executeQueryUpdate();
        /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
        output = "Registro Actualizado.";
      }
        /*###############INICIO DE CAMBIO###############
        B-52-2103-14 Mejora al proceso de captura de paridades*/
        String[] colsTitles ={"NUMERO_PROSA"};

        if(campoBU.equals("1033")){
            numeroProsa = "1031";
            System.out.println("BU: "+campoBU+" se deja fijo por el numero prosa: " + numeroProsa);
        }
        else if(campoBU.equals("194")){
            numeroProsa = campoBU;
            System.out.println("BU: "+campoBU+" se deja fijo por el numero prosa: " + numeroProsa);
        }
        else if(campoBU.equals("230")){
            numeroProsa = campoBU;
            System.out.println("BU: "+campoBU+" se deja fijo por el numero prosa: " + numeroProsa);
        }
        else{
            queryVistaEmi = " SELECT NUMERO_PROSA \n"+
                            " FROM PMADMIN.VW_BUS_EMI \n"+
                            " WHERE BU_TX_ISS = "+campoBU+" \n"+
                            " UNION ALL \n"+
                            " SELECT NUMERO_PROSA \n"+
                            " FROM PMADMIN.VW_BUS_ACQ \n"+
                            " WHERE BU_TX_ADQ = "+campoBU+" \n";

            System.out.println(queryVistaEmi);
            /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
           // db.setQuerySelect(queryVistaEmi);
           // db.executeQuerySelect();
            conOracle.Conectar();
                  conOracle.Consultar(queryVistaEmi);
           
            ResultValidaVistaEmi = conOracle.getNumRowsRS();
            /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
            System.out.println("Cantidad: "+ResultValidaVistaEmi);
            if(ResultValidaVistaEmi == 0){
                numeroProsa = campoBU;
                System.out.println("No hay coincidencia en vistas emisor o adquirente para BU "+campoBU+" se deja el mismo: " + numeroProsa);
            }
            else if(ResultValidaVistaEmi > 0){
                /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
                queryRs = conOracle.getResultSet();
                /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
                queryRs.next();
                numeroProsa = queryRs.getString(1);
                System.out.println("Se coloca lo configurado en vistas emisor o adquirente para BU "+campoBU+" numero prosa: " + numeroProsa);
            }
        }

        queryUpda01 =
        " UPDATE SUPERSIC.TIPOS_CAMBIO@LG_PMTU_IFO_01 \n"+
        "    SET CAMBIO_VENTA = "+campoVENTA+", \n"+
        "        CAMBIO_COMPRA = "+campoCOMPRA+", \n"+
        "        CAMBIO_PROMEDIO = "+campoPROMEDIO+", \n"+
        "        USUARIO_MODIFICO = '"+txtfUsuario+"', \n"+
        "        FECHA_MODIFICO = SYSDATE \n"+
        "  WHERE ENT_NUMERO_PROSA = "+numeroProsa+" \n"+
        "    AND CODIGO_MONEDA = "+campoCODIGO+" \n"+
        "    AND FECHA = TO_DATE('"+campoFECHA+"','DD/MM/YYYY') \n";

        System.out.println("QueryUpdate01: " + queryUpda01);
        ///db.setQueryUpdate(queryUpda01);
       // db.executeQueryUpdate();
       /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
       conOracle.Conectar();
        conOracle.Modificar(queryUpda01);
       /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
        queryUpda02 =
        " UPDATE SUPERSIC.TIPOS_CAMBIO@LG_PMTU_SIC \n"+
        "    SET CAMBIO_VENTA = "+campoVENTA+", \n"+
        "        CAMBIO_COMPRA = "+campoCOMPRA+", \n"+
        "        CAMBIO_PROMEDIO = "+campoPROMEDIO+", \n"+
        "        USUARIO_MODIFICO = '"+txtfUsuario+"', \n"+
        "        FECHA_MODIFICO = SYSDATE \n"+
        "  WHERE ENT_NUMERO_PROSA = "+numeroProsa+" \n"+
        "    AND CODIGO_MONEDA = "+campoCODIGO+" \n"+
        "    AND FECHA = TO_DATE('"+campoFECHA+"','DD/MM/YYYY') \n";

       System.out.println("QueryUpdate01: " + queryUpda02);
       //db.setQueryUpdate(queryUpda02);
       //db.executeQueryUpdate();
       /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
       conOracle.Conectar();
        conOracle.Modificar(queryUpda02);
       /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
       output = "Registro Actualizado.";
        
    /*###############FIN DE CAMBIO###############
    B-52-2103-14 Mejora al proceso de captura de paridades*/

        if(campoBU.equals("1033"))
        {
        String[] fecha = campoFECHA.split("/");
        /* Inicia cambio C-04-3035-13 */
        util.lanzaCondicion("PMTGTCAC999Q01_OK", fecha[1]+fecha[0],1);
        util.lanzaCondicion("PMTGTCAC999Q01_OK1", fecha[1]+fecha[0],1);
        /* Termina cambio C-04-3035-13 */
        }
}
    
else if(btninsertaregistro != null) 
{
        campoBU = (String)request.getParameter("campoBU");
        campoCODIGO = (String)request.getParameter("campoCODIGO");
        campoFECHA = (String)request.getParameter("campoFECHA");
        campoCOMPRA = (String)request.getParameter("campoCOMPRA");
        campoVENTA = (String)request.getParameter("campoVENTA");
        campoPROMEDIO = (String)request.getParameter("campoPROMEDIO");
        
        queryValida = " SELECT CCR.CR_BU \n"+
                " FROM CORE.CZ_CRNCY_RATE CCR \n"+
                " WHERE CCR.CR_EFF_DT = TO_DATE('"+ campoFECHA +"','DD/MM/YYYY') \n"+
                " AND CCR.CR_BU = "+campoBU+"\n"+
                " ORDER BY CCR.CR_RATE ";
        
        System.out.println("QueryValida: " + queryValida);
        //db.setQuerySelect(queryValida);
        //db.executeQuerySelect();
        /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
        conOracle.Conectar();
        conOracle.Consultar(queryValida);
        
        ResultValida = conOracle.getNumRowsRS();
        /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
        System.out.println("ValorValida: " + ResultValida);
        
        if(ResultValida>0)
        {
        output = "Ya Existe un Registro para este Dia.";
        }
        else
        {
           for(int y=1; y<=3; y++){
            if(y==1){valor = campoCOMPRA;}
            else if(y==2){valor = campoVENTA;}
            else if(y==3){valor = campoPROMEDIO;}
       	
                        query = " INSERT INTO CORE.CZ_CRNCY_RATE CCR \n"+
                                " 			(CCR.CR_BU, CCR.CR_CD, CCR.CR_EFF_DT, CCR.CR_TYP, CCR.CR_SRCE, \n"+
                                " 			 CCR.CR_RATE, CCR.CR_REG_USER, CCR.CR_REG_DATE) \n"+
                                " 			VALUES ("+campoBU+", 484, TO_DATE('"+campoFECHA+"','DD/MM/YYYY'), "+y+", \n";
                                        if(campoBU.equals("145")){
                                                query += " 			 12, \n";
                                        }else{
                                                query += " 			902, \n";
                                        }
                                        query +=" 			 "+valor+", \n"+
                                                        " 			'"+txtfUsuario+"', \n"+
                                            " 			 SYSDATE) \n";
		

                                System.out.println("QueryInsert: " + query);
        //db.setQueryUpdate(query);
        //db.executeQueryUpdate();
        /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
        conOracle.Conectar();
        conOracle.Modificar(query);
        /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
        output = "Registro insertado.";
        }

        if(campoBU.equals("1033"))
        {
        String[] fecha = campoFECHA.split("/");
        /* Inicia cambio C-04-3035-13 */
        util.lanzaCondicion("PMTGTCAC999Q01_OK",fecha[1]+fecha[0],1);
        util.lanzaCondicion("PMTGTCAC999Q01_OK1",fecha[1]+fecha[0],1);
        /* Termina cambio C-04-3035-13 */
        }
        /*###############INICIO DE CAMBIO###############
        B-52-2103-14 Mejora al proceso de captura de paridades*/
        String[] colsTitles ={"NUMERO_PROSA"};

        if(campoBU.equals("1033")){
            numeroProsa = "1031";
            System.out.println("BU: "+campoBU+" se deja fijo por el numero prosa: " + numeroProsa);
        }
        else if(campoBU.equals("194")){
            numeroProsa = campoBU;
            System.out.println("BU: "+campoBU+" se deja fijo por el numero prosa: " + numeroProsa);
        }
        else if(campoBU.equals("230")){
            numeroProsa = campoBU;
            System.out.println("BU: "+campoBU+" se deja fijo por el numero prosa: " + numeroProsa);
        }
        else{
            queryVistaEmi = " SELECT NUMERO_PROSA \n"+
                            " FROM PMADMIN.VW_BUS_EMI \n"+
                            " WHERE BU_TX_ISS = "+campoBU+" \n"+
                            " UNION ALL \n"+
                            " SELECT NUMERO_PROSA \n"+
                            " FROM PMADMIN.VW_BUS_ACQ \n"+
                            " WHERE BU_TX_ADQ = "+campoBU+" \n";

            System.out.println(queryVistaEmi);
            //db.setQuerySelect(queryVistaEmi);
            //db.executeQuerySelect
            /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
              conOracle.Conectar();
        conOracle.Consultar(queryVistaEmi);
        
            ResultValidaVistaEmi = conOracle.getNumRowsRS();
            /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
            System.out.println("Cantidad: "+ResultValidaVistaEmi);
            if(ResultValidaVistaEmi == 0){
                numeroProsa = campoBU;
                System.out.println("No hay coincidencia en vistas emisor o adquirente para BU "+campoBU+" se deja el mismo: " + numeroProsa);
            }
            else if(ResultValidaVistaEmi > 0){
                queryRs = conOracle.getResultSet();
                queryRs.next();
                numeroProsa = queryRs.getString(1);
                System.out.println("Se coloca lo configurado en vistas emisor o adquirente para BU "+campoBU+" numero prosa: " + numeroProsa);
            }
        }

        //Inserta en SUPERSIC.TIPOS_CAMBIO@LG_PMTU_SIC
        queryInsTipCam01 = " INSERT INTO SUPERSIC.TIPOS_CAMBIO@LG_PMTU_SIC \n"+
                "    (FECHA, CAMBIO_VENTA, CAMBIO_COMPRA, USUARIO_REGISTRO, FECHA_REGISTRO, USUARIO_MODIFICO, \n"+
                "     FECHA_MODIFICO, OBSERVACIONES, ENT_NUMERO_PROSA, CODIGO_MONEDA, CAMBIO_PROMEDIO, \n"+
                "     IND_LIQ_VISA, CODIGO_MONEDA_DESTINO, NOMBRE_ARCHIVO) \n"+
                " VALUES (TO_DATE('"+campoFECHA+"','DD/MM/YYYY'), "+campoVENTA+", "+campoCOMPRA+", '"+txtfUsuario+"', SYSDATE, NULL, \n"+
                "         NULL, NULL, "+numeroProsa+", 484, "+campoPROMEDIO+", NULL, 0, NULL)";

        System.out.println("queryInsTipCam01: " + queryInsTipCam01);
        /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
          conOracle.Conectar();
        conOracle.Modificar(queryInsTipCam01);
        
        //db.setQueryUpdate(queryInsTipCam01);
        //db.executeQueryUpdate();

        //Inserta en SUPERSIC.TIPOS_CAMBIO@LG_PMTU_IFO_01
        queryInsTipCam02 = " INSERT INTO SUPERSIC.TIPOS_CAMBIO@LG_PMTU_IFO_01 \n"+
                "    (FECHA, CAMBIO_VENTA, CAMBIO_COMPRA, USUARIO_REGISTRO, FECHA_REGISTRO, USUARIO_MODIFICO, \n"+
                "     FECHA_MODIFICO, OBSERVACIONES, ENT_NUMERO_PROSA, CODIGO_MONEDA, CAMBIO_PROMEDIO, \n"+
                "     IND_LIQ_VISA, CODIGO_MONEDA_DESTINO, NOMBRE_ARCHIVO) \n"+
                " VALUES (TO_DATE('"+campoFECHA+"','DD/MM/YYYY'), "+campoVENTA+", "+campoCOMPRA+", '"+txtfUsuario+"', SYSDATE, NULL, \n"+
                "         NULL, NULL, "+numeroProsa+", 484, "+campoPROMEDIO+", NULL, 0, NULL)";

        System.out.println("queryInsTipCam01: " + queryInsTipCam02);
        //db.setQueryUpdate(queryInsTipCam02);
        //db.executeQueryUpdate();
          conOracle.Conectar();
        conOracle.Modificar(queryInsTipCam02);
        
        output = "Registro insertado.";
        /*###############FIN DE CAMBIO###############
        B-52-2103-14 Mejora al proceso de captura de paridades*/
        }
    }
conOracle.Desconectar();
       /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>TIPO DE CAMBIO</title>

        <script type="text/javascript">
            var span = null;
            // var ventana = null;
            var showTextInitDate = false;
            var showFiid = false;
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
                    }

                    if (document.frmTipoCambioHeader.txtfStartDate.value == "" || document.frmTipoCambioHeader.txtfStartDate.value == null)
                    {
                        span = document.getElementById("txtInitDate");
                        span.style.display = 'inline';
                        showTextInitDate = true;
                        return false;
                    } else
                    {
                        sendDatas("txtfStartDate", "txtFiidVal", "tipocambioAccion", "tableTablaPrincipal");
                        return true;
                    }
                } catch (e) {
                }
            }
        </script>
        <script type="text/javascript" src="scripts/envio.js"></script>
    </head>

    <body>
        <div align="center">
            <form action="aggtipocambio.jsp" method="post" name="frmTipoCambioHeader" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tbl_border" >
                    <tr>
                        <th id= "tituloTab" width="100%" colspan=5 ><font color="#000000">TIPO DE CAMBIO</font><font color="#000000"></font><br></th>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="3"><br/></td>
                    </tr>
                    <tr>
                        <td><div align="right">Fecha Inicio:</div></td>
                        <td><div align="left">
                                &nbsp;
                                <input name="txtfStartDate" type="text" id="txtfStartDate" size="15" maxlength="15" value=<%=session.getAttribute("fechaHoy")%>>
                                <a href="javascript:void(0)" onclick="if (self.gfPop)
                    gfPop.fPopCalendar(document.frmTipoCambioHeader.txtfStartDate);
                return false;" hidefocus>
                                    <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg"  border="0" alt="">
                                </a><br/>
                                <span id = "txtInitDate" class="ocultar">Selecciona un proceso</span>
                            </div></td>
                        <td><div align="right">Proceso:</div></td>
                        <td align="left">
                            <%
            comboBox = new HTML();
            out.println( "" + comboBox.getComboBox( "txtFiidVal", cbFiid, "Selecciona un Proceso" ) );
                            %><br/>
                            <span id = "txtFiid" class="ocultar">Elije una Opción</span>
                        </td>

                    </tr>
                    <tr>
                        <td colspan="6"><div align="center">
                                <input name="btntipocambio" type="button" id="btntipocambio" value="BUSCAR" onclick="javascript:return valida(this.form);">
                                <%
                                 System.out.println("*****" + role);
                                 if(!role.equals("banco")) {
                                %>
                                &nbsp;
                                <input name="btnErase" type="reset" id="btnErase" value="Borrar">
                                &nbsp;
                                <input type="submit" name="btnaggtipocambio" value="Agregar">
                                <%
                                }
                                %>
                            </div></td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <div id="divTablaPrincipal" align="center" >
                                <br/>
                                <br/>
                                <div id="tableTablaPrincipal" ><jsp:include page="tipocambioMain.jsp"/></div>

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
