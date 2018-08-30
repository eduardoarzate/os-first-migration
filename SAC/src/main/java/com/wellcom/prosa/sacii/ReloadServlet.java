/*###############################################################################
# Nombre del Programa :  ReloadServlet.java                                     #
# Autor               :  JOAQUIN MOJICA Q.                                      #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-08-299-04                 	   FECHA:15/10/2008       #
# Descripcion General :										        	                            #
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :  Acceder al sistema                                     #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :  A Peticion del web, se pueden ejecutar n instancias    #
#################################################################################
#								MODIFICACIONES                                                  #
# Autor               : ERIKA A. MOJICA                                         #
# Compania            : WELLCOM SA DE CV                                        #
# Proyecto/Procliente : P-02-1202-09                 Fecha: 08/02/2010          #
# Modificación        : AUTOMATIZACION DE PREPAGO                               #
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-08-2253-12                Fecha: 13/02/2013          #
# Modificación        :  Adicionar indicadores ABM a Reporte de log certificado #
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-04-2207-13                Fecha: 02/12/2013          #
# Modificación        :  Actualización de LOG CERTIFICADO con Indicadores ABM a #
#                        detalle                                                #
#-----------------------------------------------------------------------------  #
# Autor               : Carlos Mendez De Luna                                   #
# Compania            : PROSA                                                   #
# Proyecto/Procliente : C-04-3035-13                            Fecha:11/12/2013#
# Modificacion        : Generacion de Proceso de Diferencia de Cuota de         #
#                       Intercambio de EGLO SAC2                                #
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-06-2233-13                Fecha: 10/11/2014          #
# Modificación        : Integración de compensación en proceso de corresponsales#
#-----------------------------------------------------------------------------  #
# Autor               : Salvador Montiel                                        #
# Compania            : AM Estudio                                              #
# Proyecto/Procliente : P-54-2940-14               Fecha: 23/04/2015            #
# Modificacion        : Soporte Interactivo (FAQs,Tutoriales,Manuales)          #
# Marca del Cambio    : P-54-2940-14 AMEstudio 23.04.2015                       #
#-------------------------------------------------------------------------------#
#                MODIFICACIONES                                                 #
# Autor               : Miguel Nieto                                            #
# Compania            : Axia, consultores, S.A. DE C.V.                         #
# Proyecto/Procliente : P-60-2646-14                 Fecha: 03/02/2016          #
# Modificacion        : Incorporacion Consubanco a Corresponsales con Chedraui  #
# Marca del Cambio    : AXIA-GGB-P-02-0275-12                                   #
#-------------------------------------------------------------------------------#
# Autor               :  Daniel Ramírez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  B-54-2904-15                 Fecha: 27/06/2016         #
# Modificacion        :  Mejorar Reportería SAC2                                #
# Marca del Cambio    :  SAS-DRT B-54-2904-15                                   #
#-------------------------------------------------------------------------------#
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 22/03/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
package com.wellcom.prosa.sacii;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 * ******** Inicio Modificacion WELLCOM N-08-2253-12 *********
 */
import java.util.Date;
/**
 * ******** Fin Modificacion WELLCOM N-08-2253-12 *********
 */

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wellcom.exceptions.WellException;
import com.wellcom.io.HTML;
import com.wellcom.prosa.sacii.ComboBox;
import com.wellcom.prosa.sacii.Table;
import com.wellcom.sql.Database;
import com.wellcom.sql.SessionConnection;
/*#Marca de cambio:  SAS-DRT B-54-2904-15  Inicia Modificación #  */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*#Marca de cambio:  SAS-DRT B-54-2904-15  Fin Modificación #  */
   /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
import com.wellcom.conexion.*;
   /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */

public class ReloadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
       /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
//    private String VW_BUS_ACQ;
//    private String PRSA_CIFRAS_CTRL;
//    private String PRSA_BITACORA_ARCHIVOS;
//    private String VW_BUS_EMI;
//    private String PRSA_ENTIDADES;
//    private String PRSA_DBL_FIID;
//    private String PRSA_ARCHIVOS;
//    private String PRSA_TXN_ACEPTADAS;
//    private String PRSA_TIPOS_TRANSACCION;
//
//    private Database db;
//    private SessionConnection sc;
//    private Connection con;
    private HttpSession session;
    private String query;
//    private String sessionId, oldSessionId;
//    private String connectionType,
//            driver,
//            dbURL,
//            userName,
//            password,
//            dataSourceName;
    Table createTable = new Table();

    HashMap<String, String> entidades;//Entidades Tx
    HashMap<String, String> entidadesEr;//Entidades Re
    HashMap<String, String> tipoTrac;//Tipo Tranc
    HashMap<String, String> ica;//ICA TX
    HashMap<String, String> icaRecha;//ICA Re

    String cadenaForma = "";
    String cadenaError = "";

    ConexionORACLE conOracle = null;

//    private void prepareDBObject() {
//
//        try {
//            this.db = new Database();
//            this.db.setConnectionType(this.connectionType);
//            this.db.setDriver(this.driver);
//            this.db.setUrl(this.dbURL);
//            this.db.setUserName(this.userName);
//            this.db.setPassword(this.password);
//            this.db.setDataSourceName(this.dataSourceName);
//            this.db.doConnection();
//            this.con = this.db.getConnection();
//            this.session.setAttribute(this.sessionId + "db", this.db);
//            this.sc = new SessionConnection(this.con);
//            this.session.setAttribute(this.sessionId + "sc", this.sc);
//        } catch (Exception ex) {
//            System.out.println(ex.toString());
//        }
//    }
//    private void verifySessionConnection(HttpServletRequest request) {
//
//        //Se verifica si ya existe un Id de Sesion previo
//        this.oldSessionId = (String) session.getAttribute(this.sessionId + "os");
//        if (this.oldSessionId == null) {
//            oldSessionId = "";
//        }
//
//        if (!oldSessionId.equalsIgnoreCase(this.sessionId)) {
//
//            System.out.println(
//                    "New connection: " + request.getHeader("user-agent"));
//
//            try {
//
//                this.session.setAttribute(this.sessionId + "os",
//                        this.sessionId);
//                this.prepareDBObject();
//
//            } catch (Exception ex) {
//                System.out.println(ex.toString());
//            }
//        } else {
//
//            System.out.println("Getting Pool connection: "
//                    + request.getHeader("user-agent"));
//
//            this.sc
//                    = (SessionConnection) this.session.getAttribute(this.sessionId + "sc");
//
//            this.con = this.sc.getConnection();
//            if (this.con == null) {
//                try {
//                    System.out.println("Conexion = null");
//                    this.prepareDBObject();
//                } catch (Exception ex) {
//                    System.out.println(ex.toString());
//                }
//            }
//        }
//    }
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        this.connectionType = config.getInitParameter("jdbcConnectionType");
//        this.driver = config.getInitParameter("jdbcDriver");
//        this.dbURL = config.getInitParameter("jdbcUrl");
//        this.userName = config.getInitParameter("jdbcUserName");
//        this.password = config.getInitParameter("jdbcPassword");
//        this.dataSourceName = config.getInitParameter("dataSourceName");
//
//        this.VW_BUS_ACQ = config.getInitParameter("VW_BUS_ACQ");
//        this.PRSA_CIFRAS_CTRL = config.getInitParameter("PRSA_CIFRAS_CTRL");
//        this.PRSA_BITACORA_ARCHIVOS = config.getInitParameter("PRSA_BITACORA_ARCHIVOS");
//        this.VW_BUS_EMI = config.getInitParameter("VW_BUS_EMI");
//        this.PRSA_ENTIDADES = config.getInitParameter("PRSA_ENTIDADES");
//        this.PRSA_DBL_FIID = config.getInitParameter("PRSA_DBL_FIID");
//        this.PRSA_ARCHIVOS = config.getInitParameter("PRSA_ARCHIVOS");
//        this.PRSA_TXN_ACEPTADAS = config.getInitParameter("PRSA_TXN_ACEPTADAS");
//        this.PRSA_TIPOS_TRANSACCION = config.getInitParameter("PRSA_TIPOS_TRANSACCION");
//    }
    /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        reloadPage(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        reloadPage(request, response);
    }

    protected void reloadPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        this.session = request.getSession(true);
//        this.sessionId = session.getId();
//        System.out.println("ControllerServlet session: " + this.sessionId);
//        verifySessionConnection(request);

        String action = request.getParameter("action");
        String url = null;
        /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
        conOracle = new ConexionORACLE();
        HttpSession session = request.getSession();
//        session.setAttribute("VW_BUS_ACQ", this.VW_BUS_ACQ);
//        session.setAttribute("PRSA_CIFRAS_CTRL", this.PRSA_CIFRAS_CTRL);
//        session.setAttribute("PRSA_BITACORA_ARCHIVOS", this.PRSA_BITACORA_ARCHIVOS);
//        session.setAttribute("VW_BUS_EMI", this.VW_BUS_EMI);
//        session.setAttribute("PRSA_ENTIDADES", this.PRSA_ENTIDADES);
//        session.setAttribute("PRSA_DBL_FIID", this.PRSA_DBL_FIID);
//        session.setAttribute("PRSA_ARCHIVOS", this.PRSA_ARCHIVOS);
//        session.setAttribute("PRSA_TXN_ACEPTADAS", this.PRSA_TXN_ACEPTADAS);
//        session.setAttribute("PRSA_TIPOS_TRANSACCION", this.PRSA_TIPOS_TRANSACCION);
        ComboBoxGen myComboBox;
        myComboBox = new ComboBoxGen();
        /*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */
        HTML comboBox;
        comboBox = new HTML();

        ArrayList cbDivisionValues;
        ArrayList cbArchivoValues;
        ArrayList cbArchivoAdqValues;
        ArrayList cbArchivoEmiValues;
        ArrayList cbTableValues;
        ArrayList cbArchivo0054Values;
        ArrayList cbFuentes;
        ArrayList cbArchivob054Values;
        ArrayList cbRechazoValues;
        ArrayList cbRESULTADO;
        ArrayList cbTransaccion;
        PrintWriter out;
        out = response.getWriter();

        if (action != null) {
            System.out.println("Entraste a Reload");
            System.out.println("Accion:" + action + ":");

            if (action.equals("cargafavor")) {
                try {

                    String tipoproc = request.getParameter("tipoProc");
                    cbRESULTADO = myComboBox.getES(tipoproc);
                    out.println("" + comboBox.getComboBox("tipoES", cbRESULTADO, "Elije la opcion"));
                    out.println("<br/>");
                    out.println("<span id = 'txtES' class='ocultar' >Elije la opcion</span>");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (action.equals("lstGrpSaciiiAccion")) {
                //url="/lstGrpSacii.jsp";
                //RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                //rd.forward(request, response);
                //out.println("<br/>");
                String txtfStartDate = request.getParameter("txtfStartDate");
                String txtfEndDate = request.getParameter("txtfEndDate");
                String btnLstGrpSacii = "OK";
                url = "/lstGrpSaciiMain.jsp?txtfStartDate=" + txtfStartDate + "&txtfEndDate=" + txtfEndDate + "&btnLstGrpSacii=" + btnLstGrpSacii;
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request, response);
                //out.println("<jsp:include page=\"/lstGrpSaciiMain.jsp?txtfStartDate="+txtfStartDate+"&txtfEndDate="+txtfEndDate+"&btnLstGrpSacii="+btnLstGrpSacii+"\"/>");
            } else if (action.equals("tipocambioAccion")) {
                String txtfStartDate = request.getParameter("txtfStartDate");
                String txtFiidVal = request.getParameter("txtFiidVal");
                String btntipocambio = "OK";
                url = "/tipocambioMain.jsp?txtfStartDate=" + txtfStartDate + "&txtFiid=" + txtFiidVal + "&btntipocambio=" + btntipocambio;
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request, response);
            } //Marca inicio: P-54-2940-14 AMEstudio 23.04.2015
            else if (action.equals("soporte")) {
                //String txtfStartDate=request.getParameter("txtfStartDate");
                String txtTipoDoc = request.getParameter("txtTipoDoc");
                String btnsoporte = "OK";
                url = "/soporteMain.jsp?txtTipoDoc=" + txtTipoDoc + "&btnsoporte=" + btnsoporte;
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request, response);

            } //Marca fin: P-54-2940-14 AMEstudio 23.04.2015
            else if (action.equals("cargacomercio")) {
                try {

                    String bancobu = request.getParameter("banco");
                    cbRESULTADO = myComboBox.getComercioBu(bancobu);
                    out.println("" + comboBox.getComboBox("scomercio", cbRESULTADO, "comercio"));
                    out.println("<br/>");
                    out.println("<span id = 'spamcomercio' class='ocultar' >Elije un comercio</span>");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } /* Inicia modificacion C-04-3035-13 */ else if (action.equals("cierreDCAccion")) {
                String txtfStartDate = request.getParameter("txtfStartDate");
                String txtFiidVal = request.getParameter("txtFiidVal");
                String btnDifCuotas = "OK";
                url = "/cierreDifCuotasMain.jsp?txtfStartDate=" + txtfStartDate + "&txtFiid=" + txtFiidVal + "&btnDifCuotas=" + btnDifCuotas;
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request, response);
            } /* Termina modificacion C-04-3035-13 */ //  ---------------------------------------------------------------------------------//
            //  -- Marca del Cambio : WELL-EMQ-P-02-1202-09 Inicia la Modificacion   08/02/2010 -//
            //  ---------------------------------------------------------------------------------//
            else if (action.equals("cargaresultado")) {
                try {

                    String fiid = request.getParameter("fiid");
                    cbRESULTADO = myComboBox.getPrefijoPREFIID(fiid);
                    out.println("" + comboBox.getListBox("resultado", cbRESULTADO, "Prefijos de la FIID"));
                    out.println("<br/>");
                    out.println("<span id = 'spamprefijo' class='ocultar'>Elije un prefijo</span>");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } //  -----------------------------------------------------------------------------------//
            //  -- Marca del Cambio : WELL-EMQ-P-02-1202-09 Finaliza la Modificacion   08/02/2010 -//
            //  -----------------------------------------------------------------------------------//
            else if (action.equals("division")) {
                try {

                    String interred = request.getParameter("interred");
                    cbDivisionValues = myComboBox.getDivision(session, interred);
                    out.println("" + comboBox.getListBox("division", cbDivisionValues, "Selecciona Una Divisi&oacute;n"));
                    out.println("<br/>");
                    out.println("<span id = 'txtDivision' class='ocultar'>Elije Una Opcion</span>");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (action.equals("divisiondol")) {
                try {

                    String interred = request.getParameter("interred");
                    cbDivisionValues = myComboBox.getDivisionDol(session, interred);
                    out.println("" + comboBox.getListBox("division", cbDivisionValues, "Selecciona Una Divisi&oacute;n"));
                    out.println("<br/>");
                    out.println("<span id = 'txtDivision' class='ocultar'>Elije Una Opcion</span>");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (action.equals("archivo")) {
                System.out.println("Entraste a Accion");
                try {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    cbArchivoValues = myComboBox.getArchivo(session, initDate, endDate);
                    out.println("" + comboBox.getListBox("archivo", cbArchivoValues, "Selecciona Un Archivo"));
                    out.println("<br/>");
                    out.println("<span id = 'txtArchivo' class='ocultar'>Elije Una Opcion</span>");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } //  -----------------------------------------------------------------------------------//
            //  -- Marca del Cambio : WELL-EMQ-P-06-2233-13 Inica la Modificacion   10/11/2014    -//
            //  -----------------------------------------------------------------------------------//
            /*else if(action.equals("corresponsal"))
			{
				try
				{
					String bancoAdq = request.getParameter("bancoAdq");
					String initDate = request.getParameter("txtfStartDate");

					System.out.println("bco:"+bancoAdq+" fecha:"+initDate);

					cbArchivoAdqValues = myComboBox.getArchivoAdqCorresponsal(session, bancoAdq);
					out.println("<strong>Fuente:</strong>");
					out.println("" + comboBox.getListBox( "archivoAdq", cbArchivoAdqValues, "Selecciona Un Archivo"));
					out.println("<br/>");
					out.println("<span id = 'txtArchivo' class='ocultar'>Elije Una Opción</span>");
					out.println("<br/>");

					cbArchivoAdqValues = myComboBox.getLiquidacionCorresponsal(session);
					out.println("<strong>Liquidacion:</strong>");
					out.println("" + comboBox.getComboBox( "Liquidacion", cbArchivoAdqValues, "Selecciona una Liquidacion"));
					out.println("<br/>");
					out.println("<span id = 'spamLiquidacion' class='ocultar'>Elije Una Opción</span>");
					out.println("<br/>");

					cbTransaccion = myComboBox.getTrxsCorresponsal(session);
					out.println("<strong>Tipo Transacción:</strong>");
					out.println("" + comboBox.getListBox( "Transaccion", cbTransaccion, "Selecciona una Transaccion"));
					out.println("<br/>");
					out.println("<span id = 'spamTransaccion' class='ocultar'>Elije Una Opción</span>");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}

			else if(action.equals("corresponsalBin"))
			{
				try
				{

					cbArchivoAdqValues = myComboBox.getArchivoBinCorresponsal(session);
					out.println("<strong>Bin:</strong>");
					out.println("" + comboBox.getListBox( "archivoAdq", cbArchivoAdqValues, "Selecciona Un Archivo"));
					out.println("<br/>");
					out.println("<span id = 'txtArchivo' class='ocultar'>Elije Una Opción</span>");
					out.println("<br/>");

					cbArchivoAdqValues = myComboBox.getLiquidacionCorresponsal(session);
					out.println("<strong>Liquidacion:</strong>");
					out.println("" + comboBox.getComboBox( "Liquidacion", cbArchivoAdqValues, "Selecciona una Liquidacion"));
					out.println("<br/>");
					out.println("<span id = 'spamLiquidacion' class='ocultar'>Elije Una Opción</span>");
					out.println("<br/>");

					cbTransaccion = myComboBox.getTrxsCorresponsal(session);
					out.println("<strong>Tipo Transacción:</strong>");
					out.println("" + comboBox.getListBox( "Transaccion", cbTransaccion, "Selecciona una Transaccion"));
					out.println("<br/>");
					out.println("<span id = 'spamTransaccion' class='ocultar'>Elije Una Opción</span>");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
             */ //  -----------------------------------------------------------------------------------//
            //  -- Marca del Cambio : WELL-EMQ-P-06-2233-13 Finaliza la Modificacion   10/11/2014 -//
            //  -----------------------------------------------------------------------------------//
            //  -----------------------------------------------------------------------------------//
            //  -- Marca del Cambio : AXIA-MN-P-60-2646-14 Inica la Modificacion   02/03/2016   -//
            //  -----------------------------------------------------------------------------------//
            else if (action.equals("corresponsalBin") || action.equals("corresponsal")) {
                try {
                    String bancoAdq = request.getParameter("bancoAdq");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");

                    System.out.println("bco:" + bancoAdq + " fechaini:" + initDate);

                    cbArchivoAdqValues = myComboBox.getArchivoAdqC(session, bancoAdq, initDate);
                    out.println("<strong>Fuente:</strong>");
                    out.println("" + comboBox.getListBox("archivoAdq", cbArchivoAdqValues, "Selecciona Un Archivo"));
                    out.println("<br/>");
                    out.println("<span id = 'txtArchivo' class='ocultar'>Elije Una Opción</span>");
                    out.println("<br/>");

                        /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
                   /* ArrayList cbValues;
                    //String sessionID;
                    //Database db;
                            
                    try {
                        query = "SELECT * FROM PMADMIN.VW_BUS_ACQ VBA "
                                + " WHERE VBA.NUMERO_PROSA IN (" + bancoAdq + ")"
                                + " AND VBA.TIE_NUMERO IN (2)";
                        conOracle.Conectar();
                        conOracle.Consultar(query);
                        cbValues = conOracle.getRSColsData();
                    } catch (Exception ex) {
                        throw new WellException("com.wellcom.ReloadServlet.validacion: " + ex.toString());
                    } finally {
                        conOracle.Desconectar();
                    }
                    System.out.println("Tam.Existe:" + cbValues.size() + ": Banco:" + bancoAdq + ":");*/
                    /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } //  -----------------------------------------------------------------------------------//
            //  -- Marca del Cambio : AXIA-MN-P-60-2646-14 Finaliza la Modificacion   02/03/2016 -//
            //  -----------------------------------------------------------------------------------//
            else if (action.equals("archivoAdq")) {
                try {
                    String bancoAdq = request.getParameter("bancoAdq");
                    String initDate = request.getParameter("txtfStartDate");

                    System.out.println("bco:" + bancoAdq + " fecha:" + initDate);

                    cbArchivoAdqValues = myComboBox.getArchivoAdq2(session, bancoAdq, initDate);
                    out.println("<strong>Fuente:</strong>");
                    out.println("" + comboBox.getListBox("archivoAdq", cbArchivoAdqValues, "Selecciona Un Archivo"));
                    out.println("<br/>");
                    out.println("<span id = 'txtArchivo' class='ocultar'>Elije Una Opción</span>");
                    out.println("<br/>");
                    ArrayList cbValues;
                    try {
                        query = "SELECT * FROM PMADMIN.VW_BUS_ACQ VBA "
                                + " WHERE VBA.NUMERO_PROSA IN (" + bancoAdq + ")"
                                + " AND VBA.TIE_NUMERO NOT IN (8,11,13,14,15,17,18)";
                        /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
                        conOracle.Conectar();
                        conOracle.Consultar(query);
                        cbValues = conOracle.getRSColsData();
                    } catch (Exception ex) {
                        throw new WellException("com.wellcom.ReloadServlet.validacion: " + ex.toString());
                    } finally {
                        conOracle.Desconectar();
                    }
                    /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */

                    System.out.println("Tam.Existe:" + cbValues.size() + ": Banco:" + bancoAdq + ":");

                    if (cbValues.size() > 0) {
                        cbArchivoAdqValues = myComboBox.getLiquidacionxBcoAdq(session, bancoAdq);
                        out.println("<strong>Liquidacion:</strong>");
                        out.println("" + comboBox.getListBox("Liquidacion", cbArchivoAdqValues, "Selecciona una Liquidacion"));
                        out.println("<br/>");
                        out.println("<span id = 'spamLiquidacion' class='ocultar'>Elije Una Opción</span>");
                        out.println("<br/>");

                        cbTransaccion = myComboBox.getGrupoTrxs(session);
                        out.println("<strong>Tipo Transacción:</strong>");
                        out.println("" + comboBox.getListBox("Transaccion", cbTransaccion, "Selecciona una Transaccion"));
                        out.println("<br/>");
                        out.println("<span id = 'spamTransaccion' class='ocultar'>Elije Una Opción</span>");
                    } else {
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (action.equals("archivoAdqFechas")) {
                try {
                    String bancoAdq = request.getParameter("bancoAdq");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");

                    System.out.println("bco:" + bancoAdq + " fecha1:" + initDate);

                    cbArchivoAdqValues = myComboBox.getArchivoAdq2(session, bancoAdq, initDate);
                    out.println("" + comboBox.getListBox("archivoAdq", cbArchivoAdqValues, "Selecciona Un Archivo"));
                    out.println("<br/>");
                    out.println("<span id = 'txtArchivo' class='ocultar'>Elije Una Opcion</span>");

                    ArrayList cbValues;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (action.equals("rechazos")) {
                try {
                    String banco = request.getParameter("banco");
                    String initDate = request.getParameter("txtfStartDate");
                    //String endDate = request.getParameter("txtfEndDate");

                    System.out.println("bco:" + banco + " fecha1:" + initDate);

                    cbRechazoValues = myComboBox.getRechazo(session, banco, initDate);
                    out.println("" + comboBox.getListBox("proceso", cbRechazoValues, "Selecciona un Rechazo"));
                    out.println("<br/>");
                    out.println("<span id = 'txtProceso' class='ocultar'>Elije Una Opcion</span>");

                    ArrayList cbValues;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (action.equals("archivoAdqFechas2")) {
                try {
                    String bancoAdq = request.getParameter("bancoAdq");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");

                    System.out.println("bco:" + bancoAdq + " fecha1:" + initDate);

                    cbArchivoAdqValues = myComboBox.getArchivoAdq2(session, bancoAdq, initDate);
                    out.println("" + comboBox.getListBox("archivoAdq", cbArchivoAdqValues, "Selecciona Un Archivo"));
                    out.println("<br/>");
                    out.println("<span id = 'txtArchivo' class='ocultar'>Elije Una Opcion</span>");

                    ArrayList cbValues;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (action.equals("archivoEmi")) {
                try {
                    String bancoEmi = request.getParameter("bancoEmi");

                    if (bancoEmi.contains(",")) {
                        //cbArchivoEmiValues = myComboBox.getPrefijos(session, bancoEmi);
                        //out.println("" + comboBox.getListBox( "archivoEmi", cbArchivoEmiValues, "Selecciona Un Archivo"));
                        //out.println("<br/>");
                        //out.println("<span id = 'txtArchivo' class='ocultar'>Elije Una Opcion</span>");
                    } else {
                        cbArchivoEmiValues = myComboBox.getPrefijos(session, bancoEmi);
                        out.println("<strong>Bin:</strong>");
                        out.println("" + comboBox.getListBox("archivoEmi", cbArchivoEmiValues, "Selecciona Un Bin:"));
                        out.println("<br/>");
                        out.println("<span id = 'txtArchivo' class='ocultar'>Elije Una Opcion</span>");
                    }

                    ArrayList cbValues;
                    try {
                        query = "SELECT * FROM PMADMIN.VW_BUS_EMI VBE "
                                + " WHERE VBE.NUMERO_PROSA IN (" + bancoEmi + ")"
                                + " AND VBE.TIE_NUMERO NOT IN (8,11,13,14,15,17,18)";
                        /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
                        conOracle.Conectar();
                        conOracle.Consultar(query);
                        cbValues = conOracle.getRSColsData();
                    } catch (Exception ex) {
                        throw new WellException("com.wellcom.ReloadServlet.validacion: " + ex.toString());
                    } finally {
                        conOracle.Desconectar();
                    }
                    /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */

                    System.out.println("Tam.Existe:" + cbValues.size() + ": Banco:" + bancoEmi + ":");
                    if (cbValues.size() > 0) {
                        cbArchivoAdqValues = myComboBox.getLiquidacionxBcoEmi(session, bancoEmi);
                        out.println("<strong>Liquidacion:</strong>");
                        out.println("" + comboBox.getListBox("Liquidacion", cbArchivoAdqValues, "Selecciona una Liquidacion"));
                        out.println("<br/>");
                        out.println("<span id = 'spamLiquidacion' class='ocultar'>Elije Una Opcion</span>");

                        cbTransaccion = myComboBox.getGrupoTrxs2(session);
                        out.println("<strong>Tipo Transacción:</strong>");
                        out.println("" + comboBox.getListBox("Transaccion", cbTransaccion, "Selecciona una Transaccion"));
                        out.println("<br/>");
                        out.println("<span id = 'spamTransaccion' class='ocultar'>Elije Una Opcion</span>");
                    } else {

                    }

                    //cbArchivoAdqValues = myComboBox.getLiquidacionxBcoEmi(session, bancoEmi);
                    //out.println("<strong>Entidades:</strong>");
                    //out.println("" + comboBox.getListBox( "Entidades", cbArchivoAdqValues, "Selecciona las Entidades"));
                    //out.println("<br/>");
                    //out.println("<span id = 'spamEntidad' class='ocultar'>Elije Una Opcion</span>");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (action.equals("fuente")) {
                try {
                    String bancoAdq = request.getParameter("bancoAdq");
                    String fecha = request.getParameter("txtfStartDate");
                    cbFuentes = myComboBox.getArchivoAdq(session, bancoAdq);
                    out.println("" + comboBox.getListBox("fuente", cbFuentes, "Selecciona una fuente"));
                    out.println("<br/>");
                    out.println("<span id = 'txtArchivoEmi' class='ocultar'>Elije Una Opcion</span>");
                } catch (WellException e) {
                    e.printStackTrace();
                }
            } /**
             * ******** Inicio Modificacion WELLCOM N-08-2253-12 *********
             */
            else if (action.equals("tablePaint205")) {
                try {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String cuenta = request.getParameter("cuenta");
                    String comercio = request.getParameter("comercio");
                    String referencia = request.getParameter("referencia");

                    session.setAttribute("FechaInicial", initDate);
                    session.setAttribute("FechaFinal", endDate);
                    Date fecha_actual = new Date();

                    session.setAttribute("HoraActual", fecha_actual.getHours());

                    int accion = Integer.parseInt(request.getParameter("accion"));
                    if (accion == 0) {
                        createTable = new Table();
                        session.setAttribute("tablaCons", createTable);
                    } else {
                        createTable = (Table) session.getAttribute("tablaCons");
                    }
                    String table = createTable.getTableRowsValues205(session, initDate, endDate, cuenta, comercio, referencia,
                            accion, 205);
                    out.println(table);
                    out.println("&nbsp;&nbsp;<a style=\"cursor: hand;\" onclick=\"javascript:return valida(this.form,2);\" >Anterior</a>");
                    out.println("&nbsp;&nbsp;<a style=\"cursor: hand;\" onclick=\"javascript:return valida(this.form,1);\">Siguientes</a>");
                    System.out.println("Tabla creada correctamente...");
                } catch (WellException e) {
                    e.printStackTrace();
                }
            } /**
             * ******** Fin Modificacion WELLCOM N-08-2253-12 *********
             */
            /* Inicia cambio WELLCOM N-04-2207-13 29/11/2013 */ else if (action.equals("tablePaint205H")) {
                System.out.println("reload205H");
                try {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String cuenta = request.getParameter("cuenta");
                    String comercio = request.getParameter("comercio");
                    String referencia = request.getParameter("referencia");

                    session.setAttribute("FechaInicial", initDate);
                    session.setAttribute("FechaFinal", endDate);
                    Date fecha_actual = new Date();

                    session.setAttribute("HoraActual", fecha_actual.getHours());

                    int accion = Integer.parseInt(request.getParameter("accion"));
                    if (accion == 0) {
                        createTable = new Table();
                        session.setAttribute("tablaCons", createTable);
                    } else {
                        createTable = (Table) session.getAttribute("tablaCons");
                    }
                    String table = createTable.getTableRowsValues205H(session, initDate, endDate, cuenta, comercio, referencia,
                            accion, 2050);
                    out.println(table);
                    out.println("&nbsp;&nbsp;<a style=\"cursor: hand;\" onclick=\"javascript:return valida(this.form,2);\" >Anterior</a>");
                    out.println("&nbsp;&nbsp;<a style=\"cursor: hand;\" onclick=\"javascript:return valida(this.form,1);\">Siguientes</a>");
                    System.out.println("Tabla creada correctamente...");
                } catch (WellException e) {
                    e.printStackTrace();
                }
            } else if (action.equals("tablePaintPTLF")) {
                System.out.println("reloadPTLF");
                try {
                    String initDateM = request.getParameter("mes");
                    String initDateY = request.getParameter("year");
                    String afiliacion = request.getParameter("afiliacion");
                    String cuenta = request.getParameter("cuenta");
                    String banco = request.getParameter("banco");

                    session.setAttribute("Mes", initDateM);
                    session.setAttribute("Anio", initDateY);
                    Date fecha_actual = new Date();

                    session.setAttribute("HoraActual", fecha_actual.getHours());

                    int accion = Integer.parseInt(request.getParameter("accion"));
                    if (accion == 0) {
                        createTable = new Table();
                        session.setAttribute("tablaCons", createTable);
                    } else {
                        createTable = (Table) session.getAttribute("tablaCons");
                    }
                    String table = createTable.getTableRowsValuesPTLF(session, initDateM, initDateY, afiliacion, cuenta, banco,
                            accion, 10);
                    out.println(table);
                    /*Inicia marca de cambio wellcom N-51-2098-14 05-08-2015*/
                    out.println("&nbsp;&nbsp;<a style=\"cursor: hand;\" onclick=\"javascript:return validas(this.form,2);\" >Anterior</a>");
                    out.println("&nbsp;&nbsp;<a style=\"cursor: hand;\" onclick=\"javascript:return validas(this.form,1);\">Siguientes</a>");
                    /*Fin marca de cambio wellcom N-51-2098-14 05-08-2015*/
                    System.out.println("Tabla creada correctamente...");
                } catch (WellException e) {
                    e.printStackTrace();
                }
            } /* Fin cambio WELLCOM N-04-2207-13 29/11/2013 */ else if (action.equals("tablePaint100")) {
                try {
                    String initDate = request.getParameter("txtfStartDate");
                    //String endDate     = request.getParameter("txtfEndDate");
                    String bancoAdq = request.getParameter("bancoAdq");
                    String bancoEmi = request.getParameter("bancoEmi");
                    String noTrans = request.getParameter("NoTrans");
                    String fuente = request.getParameter("Fuente");
                    String noArchivo = request.getParameter("importe");
                    //String nomArchivo  = request.getParameter("NomArchivo");
                    String noCuenta = request.getParameter("NoCuenta");
                    String noAuto = request.getParameter("NoAuto");
                    String noRef = request.getParameter("NoRef");
                    String noComer = request.getParameter("NoComer");
                    String nomComer = request.getParameter("NomComer");
                    String giroComer = request.getParameter("GiroComer");
                    System.out.println(request.getParameter("accion"));
                    int accion = Integer.parseInt(request.getParameter("accion"));
                    //String tipoCaptura = request.getParameter("TipoCaptura");
                    if (accion == 0) {
                        createTable = new Table();
                        session.setAttribute("tablaCons", createTable);
                    } else {
                        createTable = (Table) session.getAttribute("tablaCons");
                    }
                    String table = createTable.getTableRowsValues(session, initDate, bancoAdq,
                            bancoEmi, noTrans, fuente, noArchivo,
                            noCuenta, noAuto, noRef, noComer, nomComer, giroComer, accion, 100);
                    out.println(table);
                    out.println("&nbsp;&nbsp;<a style=\"cursor: hand;\" onclick=\"javascript:return valida(this.form,2);\" >Anterior</a>");
                    out.println("&nbsp;&nbsp;<a style=\"cursor: hand;\" onclick=\"javascript:return valida(this.form,1);\">Siguientes</a>");
                    System.out.println("Tabla creada correctamente...");
                } catch (WellException e) {
                    e.printStackTrace();
                }

            } else if (action.equals("tablePaint1000")) {
                try {
                    String initDate = request.getParameter("txtfStartDate");
                    //String endDate     = request.getParameter("txtfEndDate");
                    String bancoAdq = request.getParameter("bancoAdq");
                    String bancoEmi = request.getParameter("bancoEmi");
                    String noTrans = request.getParameter("NoTrans");
                    String fuente = request.getParameter("Fuente");
                    String noArchivo = request.getParameter("importe");
                    //String nomArchivo  = request.getParameter("NomArchivo");
                    String noCuenta = request.getParameter("NoCuenta");
                    String noAuto = request.getParameter("NoAuto");
                    String noRef = request.getParameter("NoRef");
                    String noComer = request.getParameter("NoComer");
                    String nomComer = request.getParameter("NomComer");
                    String giroComer = request.getParameter("GiroComer");
                    System.out.println(request.getParameter("accion"));
                    int accion = Integer.parseInt(request.getParameter("accion"));
                    //String tipoCaptura = request.getParameter("TipoCaptura");
                    if (accion == 0) {
                        createTable = new Table();
                        session.setAttribute("tablaCons", createTable);
                    } else {
                        createTable = (Table) session.getAttribute("tablaCons");
                    }
                    String table = createTable.getTableRowsValues(session, initDate, bancoAdq,
                            bancoEmi, noTrans, fuente, noArchivo,
                            noCuenta, noAuto, noRef, noComer, nomComer, giroComer, accion, 1000);
                    out.println(table);
                    out.println("&nbsp;&nbsp;<a style=\"cursor: hand;\" onclick=\"javascript:return valida(this.form,2);\" >Anterior</a>");
                    out.println("&nbsp;&nbsp;<a style=\"cursor: hand;\" onclick=\"javascript:return valida(this.form,1);\">Siguientes</a>");
                    System.out.println("Tabla creada correctamente...");
                } catch (WellException e) {
                    e.printStackTrace();
                }

            } else if (action.equals("tablePaint120")) {
                try {
                    String initDate = request.getParameter("txtfStartDate");
                    //String endDate     = request.getParameter("txtfEndDate");
                    String bancoAdq = request.getParameter("bancoAdq");
                    String bancoEmi = request.getParameter("bancoEmi");
                    String noTrans = request.getParameter("NoTrans");
                    String fuente = request.getParameter("Fuente");
                    String noArchivo = request.getParameter("importe");
                    //String nomArchivo  = request.getParameter("NomArchivo");
                    String noCuenta = request.getParameter("NoCuenta");
                    String noAuto = request.getParameter("NoAuto");
                    String noRef = request.getParameter("NoRef");
                    String noComer = request.getParameter("NoComer");
                    String nomComer = request.getParameter("NomComer");
                    String giroComer = request.getParameter("GiroComer");
                    System.out.println(request.getParameter("accion"));
                    int accion = Integer.parseInt(request.getParameter("accion"));
                    //String tipoCaptura = request.getParameter("TipoCaptura");
                    if (accion == 0) {
                        createTable = new Table();
                        session.setAttribute("tablaCons", createTable);
                    } else {
                        createTable = (Table) session.getAttribute("tablaCons");
                    }
                    String table = createTable.getTableRowsValues(session, initDate, bancoAdq,
                            bancoEmi, noTrans, fuente, noArchivo,
                            noCuenta, noAuto, noRef, noComer, nomComer, giroComer, accion, 120);
                    out.println(table);
                    out.println("&nbsp;&nbsp;<a onclick=\"javascript:return valida(this.form,2);\" >Anterior</a>");
                    out.println("&nbsp;&nbsp;<a onclick=\"javascript:return valida(this.form,1);\">Siguientes</a>");
                    System.out.println("Tabla creada correctamente...");
                } catch (WellException e) {
                    e.printStackTrace();
                }

            } else if (action.equals("tablePaintB100")) {
                try {
                    String initDate = request.getParameter("txtfStartDate");
                    //String endDate     = request.getParameter("txtfEndDate");
                    String bancoAdq = request.getParameter("bancoAdq");
                    String bancoEmi = request.getParameter("bancoEmi");
                    String noTrans = request.getParameter("NoTrans");
                    String fuente = request.getParameter("Fuente");
                    String noArchivo = request.getParameter("importe");
                    //String nomArchivo  = request.getParameter("NomArchivo");
                    String noCuenta = request.getParameter("NoCuenta");
                    String noAuto = request.getParameter("NoAuto");
                    String noRef = request.getParameter("NoRef");
                    String noComer = request.getParameter("NoComer");
                    String nomComer = request.getParameter("NomComer");
                    String giroComer = request.getParameter("GiroComer");
                    System.out.println(request.getParameter("accion"));
                    int accion = Integer.parseInt(request.getParameter("accion"));
                    //String tipoCaptura = request.getParameter("TipoCaptura");
                    if (accion == 0) {
                        createTable = new Table();
                        session.setAttribute("tablaCons", createTable);
                    } else {
                        createTable = (Table) session.getAttribute("tablaCons");
                    }
                    String table = createTable.getTableRowsValues(session, initDate, bancoAdq,
                            bancoEmi, noTrans, fuente, noArchivo,
                            noCuenta, noAuto, noRef, noComer, nomComer, giroComer, accion, 101);
                    out.println(table);
                    out.println("&nbsp;&nbsp;<a onclick=\"javascript:return valida(this.form,2);\" >Anterior</a>");
                    out.println("&nbsp;&nbsp;<a onclick=\"javascript:return valida(this.form,1);\">Siguientes</a>");
                    System.out.println("Tabla creada correctamente...");
                } catch (WellException e) {
                    e.printStackTrace();
                }

            } else if (action.equals("tablePaintB120")) {
                try {
                    String initDate = request.getParameter("txtfStartDate");
                    //String endDate     = request.getParameter("txtfEndDate");
                    String bancoAdq = request.getParameter("bancoAdq");
                    String bancoEmi = request.getParameter("bancoEmi");
                    String noTrans = request.getParameter("NoTrans");
                    String fuente = request.getParameter("Fuente");
                    String noArchivo = request.getParameter("importe");
                    //String nomArchivo  = request.getParameter("NomArchivo");
                    String noCuenta = request.getParameter("NoCuenta");
                    String noAuto = request.getParameter("NoAuto");
                    String noRef = request.getParameter("NoRef");
                    String noComer = request.getParameter("NoComer");
                    String nomComer = request.getParameter("NomComer");
                    String giroComer = request.getParameter("GiroComer");
                    System.out.println(request.getParameter("accion"));
                    int accion = Integer.parseInt(request.getParameter("accion"));
                    //String tipoCaptura = request.getParameter("TipoCaptura");
                    if (accion == 0) {
                        createTable = new Table();
                        session.setAttribute("tablaCons", createTable);
                    } else {
                        createTable = (Table) session.getAttribute("tablaCons");
                    }
                    String table = createTable.getTableRowsValues(session, initDate, bancoAdq,
                            bancoEmi, noTrans, fuente, noArchivo,
                            noCuenta, noAuto, noRef, noComer, nomComer, giroComer, accion, 121);
                    out.println(table);
                    out.println("&nbsp;&nbsp;<a onclick=\"javascript:return valida(this.form,2);\" >Anterior</a>");
                    out.println("&nbsp;&nbsp;<a onclick=\"javascript:return valida(this.form,1);\">Siguientes</a>");
                    System.out.println("Tabla creada correctamente...");
                } catch (WellException e) {
                    e.printStackTrace();
                }

            } else if (action.equals("divTablaPrincipal")) {

                System.out.println("Tabla actualizada....." + request.getParameter("txtfStartDate"));

            } else if (action.equals("archivo0054")) {
                try {
                    String bancoEmi = request.getParameter("bancoEmi");
                    cbArchivo0054Values = myComboBox.getArchivoEmi(session, bancoEmi);
                    out.println("" + comboBox.getComboBox("archivoEmi", cbArchivo0054Values, "Selecciona Un Archivo"));
                    out.println("<br/>");
                    out.println("<span id = 'txtArchivoEmi' class='ocultar'>Elije Una Opcion</span>");
                } catch (WellException e) {
                    e.printStackTrace();
                }
            } else if (action.equals("archivob054")) {
                try {
                    String bancoAdq = request.getParameter("bancoAdq");
                    cbArchivob054Values = myComboBox.getArchivoAdqDol(session, bancoAdq);
                    out.println("" + comboBox.getListBox("archivoAdq", cbArchivob054Values, "Selecciona Un Archivo"));
                    out.println("<br/>");
                    out.println("<span id = 'txtArchivoAdq' class='ocultar'>Elije Una Opcion</span>");
                } catch (WellException e) {
                    e.printStackTrace();
                }
            } else if (action.equals("detailsSICMOF0100")) {
                String filClick = request.getParameter("numFil");
                url = "/detailsSICMOF0100Header.jsp?numFil=" + filClick;
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request, response);
            } else if (action.equals("detailsSICMOF0100H")) {
                String filClick = request.getParameter("numFil");
                url = "/detailsSICMOF0100HHeader.jsp?numFil=" + filClick;
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request, response);
            } else if (action.equals("detailsSICMOF0120")) {
                String filClick = request.getParameter("numFil");
                url = "/detailsSICMOF0120Header.jsp?numFil=" + filClick;
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request, response);
            } else if (action.equals("detailsSICMOFB100")) {
                String filClick = request.getParameter("numFil");
                url = "/detailsSICMOFB100Header.jsp?numFil=" + filClick;
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request, response);
            } else if (action.equals("detailsSICMOFB120")) {
                String filClick = request.getParameter("numFil");
                url = "/detailsSICMOFB120Header.jsp?numFil=" + filClick;
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request, response);
            } else if (action.equals("lstGrpSacii")) {
                url = "/lstGrpSacii.jsp";
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request, response);
            } /**
             * ******** Inicio Modificacion WELLCOM N-08-2253-12 *********
             */
            else if (action.equals("detailsSICMOR0205")) {
                String filClick = request.getParameter("numFil");
                url = "/detailsSICMOR0205Header.jsp?numFil=" + filClick;
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request, response);
            } /**
             * ******** Fin Modificacion WELLCOM N-08-2253-12 *********
             */
            /**
             * ******** Inicio Modificacion WELLCOM N-08-2253-12 *********
             */
            else if (action.equals("detailsSICMOR0205H")) {
                String filClick = request.getParameter("numFil");
                url = "/detailsSICMOR0205HHeader.jsp?numFil=" + filClick;
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request, response);
            } /**
             * ******** Fin Modificacion WELLCOM N-08-2253-12 *********
             */
            /* Inicio modificacion WELLCOM N-04-2207-13 29/11/2013 */ else if (action.equals("detailsSICMORPTLF")) {
                String filClick = request.getParameter("numFil");
                url = "/detailsSICMORPTLFHeader.jsp?numFil=" + filClick;
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request, response);
            } /* Fin modificacion WELLCOM N-04-2207-13 29/11/2013 */ /*#Marca de cambio:  SAS-DRT B-54-2904-15  Inicia Modificación #  */ else if (action.equals("archivosCNN")) {
                try {
                    String banco = request.getParameter("banco");
                    String fechaIni = request.getParameter("txtfStartDate");
                    String fechaFin = request.getParameter("txtfEndDate");
                    String tipo = request.getParameter("tipo");
                    if (!banco.contains("None")) {
                        ArrayList cbArchivoCNNEntrada;
                        ArrayList cbArchivoCNNSalida;
                        cbArchivoCNNEntrada = myComboBox.getArchivoEntrada(session, banco, fechaIni, fechaFin, tipo);
                        cbArchivoCNNSalida = myComboBox.getArchivoSalida(session, banco, fechaIni, fechaFin, tipo);
                        out.println("" + comboBox.getListBox("archivoEntrada", cbArchivoCNNEntrada, "onChange", "addFileIN();", "Selecciona Un Archivo de Entrada"));
                        out.println("<br/>");
                        out.println("<span id = 'txtArchivoAdq' class='ocultar'>Elije Una Opcion</span><br/>");
                        out.println("" + comboBox.getListBox("archivoSalida", cbArchivoCNNSalida, "onChange", "addFileOut();", "Selecciona Un Archivo de Salida"));
                        out.println("<br/>");
                        out.println("<span id = 'txtArchivoEmi' class='ocultar'>Elije Una Opcion</span>");
                    } else {
                        out.println("<select style=\"width:270px;height:58.75px;\" multiple=\"multiple\" id=\"archivoEntrada\" onClick=\"javascript:addFileIN();\" >");
                        out.println("<option value=\"\" disabled>Selecciona un Archivo Entrada !</option></select><br/>");
                        out.println("<span id = 'txtArchivoAdq' class='ocultar'>Elije Una Opcion</span><br/>");
                        out.println("<select style=\"width:270px;height:58.75px;\" multiple=\"multiple\" id=\"archivoSalida\" onClick=\"javascript:addFileOut();\">"
                                + "<option value=\"\" disabled>Selecciona un Archivo Salida !</option></select>");
                        out.println("<br/>");
                        out.println("<span id = 'txtArchivoAdq' class='ocultar'>Elije Una Opcion</span>");
                    }

                } catch (WellException e) {
                    System.err.println("ReloadServlet: accion loadE: " + e);
                    e.printStackTrace();
                }
            } else if (action.equals("loadEnt")) {
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
                    String cadenaLimpia = "";
                    cadenaLimpia = formateo(in);
//            if (action.equals("listar")) {
                    if (!cadenaLimpia.equals("Error")) {
                        out.write("<html>\n"
                                + "    <head>\n"
                                + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\n"
                                + "        <link href=\"css/styles.css\" rel=\"stylesheet\" type=\"text/css\">\n"
                                + "        <script type=\"text/javascript\" src=\"scripts/formatT140.js\"></script>\n"
                                + "    </head>\n"
                                + "    <script type=\"text/javascript\">\n"
                                + "\n"
                                + "    </script>\n"
                                + "    <body>\n"
                                + "        <div align=\"center\">"
                                + "<form method=\"post\" id=\"myform\" enctype=\"multipart/form-data\" action=\"ReloadServlet?action=loadEnt\">\n"
                                + "               <!-- <form method=\"post\" name=\"frmTOCHeader\" target=\"mainFrameTOC\" id=\"frmTOCHeader\">!-->\n"
                                + "                <table width=\"100%\" border=\"0\" cellspacing=\"0\" id=\"tabla\">\n"
                                + "                    <tr>\n"
                                + "                        <th id=\"tituloTab\" width=\"100%\" colspan=\"3\" align=\"left\" ><font color=\"#000000\">SICMIR0130 - Reporte Lectura T140\n"
                                + "                            </font></th>\n"
                                + "                    </tr>");
                        out.println("<tr><td colspan=\"3\"><br/></td></tr>");
//                        out.println("<tr><td>Tipo de Movimiento:</td><td>Entidad:</td><td>Tipo de Transaccion</td></tr>");
                        out.println("<tr><td><select onchange=\"javascript:filtrar('tipoInfo');\" name=\"tipoInfo\"  multiple id=\"tipoInfo\">\n");
                        out.println("<option value=\"None\" >Seleccionan una opcion</option>");
                        out.println("<option value=\"0\" >Rechazos</option>");
                        out.println("<option value=\"1\" >Transacciones</option>");
                        out.println("</select></td>");

                        out.write("<td>");
                        if (!ica.isEmpty()) {
                            crear(ica, response, "tipoIca", "ICA (TX)");
                        } else {
                            out.println("<select style=\"display:none;\" onchange=\"javascript:filtrar();\" name=\"tipoIca\"  multiple id=\"tipoIca\">\n");
                            out.println("<option value=\"None\" >Seleccionan un ICA (TX)</option>");
                            out.println("</select>");
                        }
                        if (!entidades.isEmpty()) {
                            cbRESULTADO = myComboBox.getEntidadesTx(session, getOnlyValues(entidades));
                            out.println(comboBox.getListBox("Entidades", cbRESULTADO, "onChange", "filtrar();", "Selecciona una Entidad"));
                        }
                        if (!entidadesEr.isEmpty()) {
                            cbRESULTADO = myComboBox.getEntidadesTx(session, getOnlyValues(entidadesEr));
                            out.println(comboBox.getListBox("EntidadesEr", cbRESULTADO, "onChange", "filtrar();", "Selecciona una Entidad"));
                        } else {
                            out.println("<select style=\"display:none;\" onchange=\"javascript:filtrar();\" name=\"EntidadesEr\"  multiple id=\"EntidadesEr\">\n");
                            out.println("<option value=\"None\" >Seleccionan una Entidad</option>");
                            out.println("</select>");
                        }
                        if (!icaRecha.isEmpty()) {
                            crear(icaRecha, response, "tipoIcaRe", "ICA (Rechazos)");
                        } else {
                            out.println("<select style=\"display:none;\" onchange=\"javascript:filtrar();\" name=\"tipoIcaRe\"  multiple id=\"tipoIcaRe\">\n");
                            out.println("<option value=\"None\" >Seleccionan un ICA (Rechazos)</option>");
                            out.println("</select>");
                        }

//                crear(entidades, response, "Entidades", "Entidad");
//                crear(entidadesEr, response, "EntidadesEr", "EntidadEr");
                        out.write("</td><td>");

                        if (!tipoTrac.isEmpty()) {
                            crear(tipoTrac, response, "tipoTx", "Transaccion");
                        } else {
                            out.println("<select style=\"display:none;\" onchange=\"javascript:filtrar();\" name=\"tipoTx\"  multiple id=\"tipoTx\">\n");
                            out.println("<option value=\"None\" >Seleccionan una Transaccion</option>");
                            out.println("</select>");
                        }
//                String out1=getDatosEntidadS(entidades, response, request);
                        out.write("</td></tr><tr><td colspan=\"3\"><br/></td></tr>");
                        out.write("");
                        out.write("<tr><td colspan=\"3\"><textarea id=\"infoDin\" readonly style=\"margin: 0px; width: 100%; height: 200px;\" rows=\"4\" cols=\"50\">\n");
                        // out.write(cadenaLimpia);
                        out.write("</textarea></td></tr>");

                        out.write("<tr>\n"
                                + "<td colspan=\"3\"><div id=\"trTtx\" style=\"display:none;\" >Total de Transacciones: <input name=\"contTx\" type=\"text\" id=\"contTx\" value=\"\">"
                                + "   Monto (RECON AMOUNT) USD:<input name=\"sumReUS\" type=\"text\" id=\"sumReUS\" value=\"\">\n"
                                + "   Monto (RECON AMOUNT) MXN:<input name=\"sumReMX\" type=\"text\" id=\"sumReMX\" value=\"\"><br/><br/>\n"
                                + "Monto (TRANS FEE) USD:<input name=\"sumFeeUS\" type=\"text\" id=\"sumFeeUS\" value=\"\">\n"
                                + "  Monto (TRANS FEE) MXN:<input name=\"sumFeeMX\" type=\"text\" id=\"sumFeeMX\" value=\"\"></div>"
                                + "<div id=\"trTR\" style=\"display:none;\">Total de Rechazos: <input name=\"contRe\" type=\"text\" id=\"contRe\" value=\"\">"
                                + "         Total Importe Rechazos:<input name=\"sumTImp\" type=\"text\" id=\"sumTImp\" value=\"\"></div></td></tr>\n");

                        out.write("<tr><td colspan=\"3\"><textarea id=\"infoDinH\" style=\"margin: 0px; width: 100%; height: 269px; display:none;\" rows=\"4\" cols=\"50\">\n");
                        out.write(cadenaLimpia);
                        out.write("</textarea></tr></td>");
                        out.write("  </table>\n"
                                + "            </form>\n"
                                + "        </div>\n"
                                + "</body>\n"
                                + "</html>");
                        in.close();
                        cadenaForma = "";
                        cadenaError = "";
                        tipoTrac.clear();
                        entidades.clear();
                        entidadesEr.clear();
                        ica.clear();
                        icaRecha.clear();
                        request.getInputStream().close();

                    } else {
                        out.write("<h2>El archivo no cumple con las caracteristicas para ser formateado</h2>");
                    }
                } catch (WellException e) {
                    System.err.println("ReloadServlet: accion loadE: " + e);
                    e.printStackTrace();
                }
            } else if (action.equals("loadBinIn")) {
                try {
                    String fechaIni = request.getParameter("txtfStartDate");
                    if (lee(fechaIni).equals("SI")) {
                        //System.err.print(getOnlyValues(entidades));
                        cbRESULTADO = myComboBox.getBinInternacionEntidad(session, getOnlyValues(entidades));
                        out.println(comboBox.getListBox("banco", cbRESULTADO, "", "", "Selecciona un Banco (Bin)"));
                        entidades.clear();
                    } else {
                        out.println("No se ha encontrado el achivo para la fecha seleccionada");
                    }

                } catch (WellException e) {
                    System.err.println("ReloadServlet: accion loadE: " + e);
                    e.printStackTrace();
                }

            }
            /*#Marca de cambio:  SAS-DRT B-54-2904-15  Termina Modificación #  */
        }
    }

    /*#Marca de cambio:  SAS-DRT B-54-2904-15  Inicui Modificación #  */
    public String formateo(BufferedReader in) throws IOException {
        entidades = new HashMap<String, String>();
        entidadesEr = new HashMap<String, String>();//Entidades Re
        tipoTrac = new HashMap<String, String>();//Tipo Tranc
        ica = new HashMap<String, String>();//ICA TX
        icaRecha = new HashMap<String, String>();//ICA Re
        //  BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String line = null;
        boolean tempBloque = false;
        boolean tempError = false;
        boolean tempErrorDeta = false;
        String columnaTemp = "";
        String tempcolumnaError = "";
        ArrayList<String> MTI = new ArrayList<String>();
        ArrayList<String> MTIHead = new ArrayList<String>();
        MTI.add("D0002");//NUMERO CUENTA
        MTI.add("D0004");//IMPORTE
        MTI.add("D0003 S01");//TTR
        MTI.add("D0038");//N.AUT Define el limite
        MTI.add("D0094");//N.AUT Define el limite
        MTIHead.add("NUMERO CUENTA");
        MTIHead.add("IMPORTE");
        MTIHead.add("TTR");
        MTIHead.add("N.AUT");
        MTIHead.add("CODIGO MARCA");
        try {
            int cont = 0;
            while ((line = in.readLine()) != null) {
                if (line.length() > 47) {
                    if (line.substring(17, 29).replaceAll(" ", "").equals("TRANS. FUNC.".replaceAll(" ", ""))) {
                        tempBloque = true;
                    } else if (line.substring(30, 45).replaceAll(" ", "").equals("TOTAL")) {
                        tempBloque = false;
                    } else if (line.substring(17, 36).replaceAll(" ", "").equals("CODE    DESCRIPTION".replaceAll(" ", ""))) {
                        tempError = true;
                        tempcolumnaError = "";
                    } else if (line.substring(17, 32).replaceAll(" ", "").equals("MESSAGE DETAILS".replaceAll(" ", ""))) {
                        tempError = false;
                    } else if (line.substring(33, 36).replaceAll(" ", "").equals("MTI".replaceAll(" ", ""))) {
                        tempErrorDeta = true;
                    } else if (line.substring(33, 38).replaceAll(" ", "").equals(MTI.get(MTI.size() - 1).replaceAll(" ", ""))) {
                        cadenaError += formatSeg(line.substring(47, line.length()), 16) + "  " + tempcolumnaError + "?\n";
                        tempErrorDeta = false;
                        icaRecha.put(line.substring(5, 11), line.substring(5, 11));
                    } else if (tempBloque) {
                        if (line.substring(17, 29).replaceAll(" ", "").length() != 0
                                && !line.substring(17, 29).contains("------------")) {
                            cadenaForma += line + "!\n";
                            columnaTemp = line.substring(17, 29);
                            entidades.put(line.substring(11, 15), line.substring(11, 15));
                            tipoTrac.put(line.substring(30, 45), line.substring(30, 45));
                            ica.put(line.substring(5, 11), line.substring(5, 11));
                        } else if (!line.substring(17, 29).contains("------------")) {
                            cadenaForma += line.substring(0, 17) + columnaTemp + line.substring(29, line.length()) + "!\n";
                            tipoTrac.put((line.substring(0, 17) + columnaTemp + line.substring(29, line.length())).substring(30, 45), (line.substring(0, 17) + columnaTemp + line.substring(29, line.length())).substring(30, 45));
                        } else {
                        }
                    } else if (tempError) {
                        if (line.replaceAll(" ", "").length() > 17) {
                            tempcolumnaError += line.substring(16, line.length());
                            entidadesEr.put(line.substring(11, 15), line.substring(11, 15));

                        }
                    } else if (tempErrorDeta) {
                        for (int l = 0; l < MTI.size(); l++) {
                            if (line.substring(33, 47).replaceAll(" ", "").contains(MTI.get(l).replaceAll(" ", ""))) {
                                if (MTI.get(l).equals("D0002")) {
                                    cadenaError += formatSeg(line.substring(0, 15), 6) + formatSeg(line.substring(47, line.length()), 20);
                                } else if (MTI.get(l).equals("D0004")) {
                                    String tm = line.substring(47, line.length()).replaceAll(" ", "");
                                    tm = tm.substring(0, tm.length() - 2) + "." + tm.substring(tm.length() - 2, tm.length());
                                    cadenaError += formatSeg(tm, 16);
                                } else//                                cadenaError += formatSeg(line.substring(47, line.length()),16);
                                 if (MTI.get(l).equals("D0003 S01")) {
                                        cadenaError += formatSeg(line.substring(47, line.length()), 7);
                                    } else {
                                        cadenaError += formatSeg(line.substring(47, line.length()), 15);
                                    }
                            }
                        }
                    } else if (line.substring(17, 29).replaceAll(" ", "").replaceAll(" ", "").length() == 0
                            && line.substring(41, 45).replaceAll(" ", "").contains("ORIG")) {
                        cadenaForma += line + "!\n";
                        ica.put(line.substring(5, 11), line.substring(5, 11));
                        entidades.put(line.substring(11, 15), line.substring(11, 15));
                        tipoTrac.put(line.substring(30, 45), line.substring(30, 45));
                    } else if (line.substring(17, 29).replaceAll(" ", "").replaceAll(" ", "").length() != 0
                            && line.substring(41, 45).replaceAll(" ", "").contains("ORIG")) {
                        cadenaForma += line + "!" + "\n";
                        ica.put(line.substring(5, 11), line.substring(5, 11));
                        entidades.put(line.substring(11, 15), line.substring(11, 15));
                        tipoTrac.put(line.substring(30, 45), line.substring(30, 45));
                    }
                    cont++;
                }

            }
            //System.err.println("data:" + (cadenaForma + ";" +"\n"+ cadenaError));
            System.err.println("formateo t140 exitoso");
            return "\n" + cadenaForma + ";\n" + cadenaError;
        } catch (Exception err) {
            System.err.println("El error: " + err);
            return "Error";
        }
    }

    public PrintWriter getDatosEntidad(HashMap<String, String> data, HttpServletResponse response, HttpServletRequest request) throws IOException {
        PrintWriter out = response.getWriter();
        Iterator iterador = data.entrySet().iterator();
        Map.Entry producto;
        String arreglo[] = cadenaForma.split("!");
        while (iterador.hasNext()) {
            producto = (Map.Entry) iterador.next();
            for (int i = 0; i < arreglo.length; i++) {
                if (arreglo[i].length() > 15) {
                    if (producto.getKey().equals(arreglo[i].substring(12, 16))) {
                        out.print(arreglo[i]);
                    }
                }
            }
        }
        return out;

    }

    public String getDatosEntidadS(HashMap<String, String> data, HttpServletResponse response, HttpServletRequest request) throws IOException {
        String out = "";
        Iterator iterador = data.entrySet().iterator();
        Map.Entry producto;
        String arreglo[] = cadenaForma.split("!");
        while (iterador.hasNext()) {
            producto = (Map.Entry) iterador.next();
            for (int i = 0; i < arreglo.length; i++) {
                if (arreglo[i].length() > 15) {
                    if (producto.getKey().equals(arreglo[i].substring(12, 16))) {
                        out += arreglo[i];
                    }
                }
            }
        }
        return out;

    }

    public PrintWriter crear(HashMap<String, String> data, HttpServletResponse response, String titulo, String titulo1) throws IOException {
        PrintWriter out = response.getWriter();
        Iterator iterador = data.entrySet().iterator();
        Map.Entry producto;
        out.println("<select style=\"display:none;\" onchange=\"javascript:filtrar('" + titulo + "');\" name=" + titulo + "  multiple id=" + titulo + "  >\n");
        out.println("<option value=\"None\" >Seleccionan una " + titulo1 + "</option>");
        while (iterador.hasNext()) {
            producto = (Map.Entry) iterador.next();
            out.println("<option value='" + producto.getKey() + "' >" + producto.getKey() + "</option>");
        }
        out.println("</select>");
        return out;

    }

    public String getOnlyValues(HashMap<String, String> data) throws IOException {
//        PrintWriter out = response.getWriter();
        String out = "";
        Iterator iterador = data.entrySet().iterator();
        Map.Entry producto;
        while (iterador.hasNext()) {
            producto = (Map.Entry) iterador.next();
            out += producto.getKey() + ",";
        }
        out = out.substring(0, out.length() - 1);
        return out;

    }

    public String formatSeg(String cadenaF, int tama) {
        String temp = "";
        String cadenaSeSPA = cadenaF.replaceAll(" ", "");
        int longCd = cadenaSeSPA.length();
        for (int i = 0; i < (tama - longCd); i++) {
            temp += " ";
        }

        return temp + cadenaSeSPA;
    }

    public String lee(String fechaIni) throws FileNotFoundException, IOException {
        String menssaje = "NO";
        try {
            SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formateo2 = new SimpleDateFormat("yyMMdd");
            String fechaIniFor = formateo2.format(formateo.parse(fechaIni));
//            String archivo = "C:\\049" + fechaIniFor + "_MI";
            String archivo = "//aplic//prod//pmt//pmr//vsa//049" + fechaIniFor + "_MI";
            File fichero = new File(archivo);
            if (fichero.exists()) {
                String line = "";
                FileReader f = new FileReader(archivo);
                BufferedReader in = new BufferedReader(f);
                while ((line = in.readLine()) != null) {
                    entidades.put(line.substring(6, 12), line.substring(6, 12));
                }
                in.close();
                menssaje = "SI";
            }
        } catch (ParseException ex) {
            System.err.println("ReloadServlet: accion lee: " + ex);
        }
        return menssaje;
    }
    /*#Marca de cambio:  SAS-DRT B-54-2904-15  Fin Modificación #  */
}
