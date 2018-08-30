/*###############################################################################
# Nombre del Programa :  ControllerServletAdquirente.java                       #
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
#################################################################################
#                                                              Modificaciones   #
#-----------------------------------------------------------------------------  #
# Autor               : Luis Eduardo Ramírez Castillo                           #
# Compania            : Soporte y Asesoría en Sistemas                          #
# Proyecto/Procliente : P-20-5230-16                 Fecha: 22/09/2017          #
# Modificacion        :                                                         #
# Marca del Cambio    : SAS-LERC-P-20-5230-16                                   #
###############################################################################*/
package com.wellcom.prosa.Controladores;

//mvn install:install-file -Dfile=scorecardob.jar -DgroupId=biz.ideasoft -DartifactId=scorecardob -Dversion=1.0.0 -Dpackaging=jar


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import biz.ideasoft.beans.ViewerManager;
import com.wellcom.Validator.Mantenimiento;
import com.wellcom.Validator.Validador;
import com.wellcom.prosa.sacii.*;
import com.wellcom.conexion.*;
import com.wellcom.exceptions.WellException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import org.jdom.JDOMException;
import java.text.ParseException;
import com.wellcom.exceptions.WellException;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import javax.swing.ImageIcon;
import javax.servlet.ServletOutputStream;
import com.wellcom.prosa.sacii.RptUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Servlet implementation class ControllerServletAdquirente
 */
public class ControllerServletAdquirente extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private HttpSession session;
    String url;
    String rutaContext = "";
    private String sessionId;
    Validador value;
    ParametrosCompartidos pC = new ParametrosCompartidos();
    ViewerManager viewerManager;
    ConexionORACLE conOracle = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServletAdquirente() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        try {
            processRequest(request, response);
        } catch (WellException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JDOMException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        try {
            processRequest(request, response);
            rutaContext = this.getServletContext().getRealPath("");
        } catch (WellException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JDOMException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, WellException, JDOMException, ParseException {
        // TODO Auto-generated method stub
        String action, diaHabAnt7 = "";
        String fechaHoy;
        boolean isAnswerReport = false;
        action = "login";
        this.session = request.getSession(false);
        if (this.session != null && this.session.getAttribute("activo") != null) {
            action = request.getParameter("action");
            System.out.println("Action : " + action);

            this.sessionId = session.getId();
            System.out.println("ControllerServletAdquirente session: " + this.sessionId);
            this.session.setMaxInactiveInterval(2400);

            session.setAttribute("rutaContext", rutaContext);
            String posicion = request.getParameter("p");
            posicion = Posicion(posicion);

            session.setAttribute("pos", posicion);
            value = new Validador();
            //ComboBoxGen comboGen=new ComboBoxGen();
            if (session.getAttribute("viewerManager") == null) {
                viewerManager = new ViewerManager();
                session.setAttribute("viewerManager", viewerManager);
            } else {
                viewerManager = (ViewerManager) session.getAttribute("viewerManager");
            }
            java.util.Date fechaAnterior = new java.util.Date();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            long fechaAntes = fechaAnterior.getTime() - 8 * (24 * 60 * 60 * 1000);
            java.util.Date fechaActual = new java.util.Date();
            fechaHoy = formato.format(fechaActual);
            diaHabAnt7 = formato.format(fechaAntes);
            session.setAttribute("fechaHoy", fechaHoy);
        }
        // GSOF-MVR-B-54-2092-15 Marca de Inicio
        Logger logger = null;
        // GSOF-MVR-B-54-2092-15 Marca de Terminacion

        ControllerMethod metodo = null;

        try {
            if (action != null) {
                if (action.equals("login")) {
                    //session.invalidate();
                    System.out.println("Action Login ControllerServletAdquirente: " + action);
                    url = "/login.jsp";
                } //Comienzan reportes 
                //Reporte B450
                else if (action.equals("SICMIFB450")) {
                    url = "/SICMIFB450Header.jsp";
                } else if (action.equals("SICMIFB450Main")) {

                    SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat formateo2 = new SimpleDateFormat("yyMMdd");
                    String inicial = request.getParameter("txtfStartDate");
                    String adq = request.getParameter("adq");
                    if (adq.length() < 2) {
                        adq = "0" + adq;
                    }
                    try {
                        session.setAttribute("adq", adq);
                        String inicial2 = formateo2.format(formateo.parse(inicial));
                        session.setAttribute("initDate", inicial2);

                        String sFichero = "C:\\probancr\\EditPackage\\POSRE_" + inicial2 + "_" + adq;
                        System.out.println("Variable fichero es " + sFichero);
                        File fichero = new File(sFichero);

                        if (fichero.exists()) {
                            System.out.println("El fichero " + sFichero + " existe");
                            url = "/reportsjsp/managerReports.jsp" + "?report=" + "SICMIFB450";
                            viewerManager.setUpViewer(this, request, response, url);
                            isAnswerReport = true;
                        } else {
                            url = "/reportsjsp/Error.jsp";
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } //Reporte SICMIRB054
                else if (action.equals("SICMIRB054")) {
                    url = "/SICMIRB054Header.jsp";
                } else if (action.equals("SICMIRB054Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String[] bancoAdqArray = request.getParameterValues("bancoAdq");
                    String[] archivos = request.getParameterValues("archivoAdq");
                    String bancoAdq = "";
                    for (String banco : bancoAdqArray) {
                        if (!bancoAdq.equals("")) {
                            bancoAdq += ",";
                        }
                        bancoAdq += banco;
                    }

                    String archivo = "";
                    for (String arch : archivos) {
                        if (!archivo.equals("")) {
                            archivo += ",";
                        }
                        archivo += arch;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancoAdq);
                    session.setAttribute("archivo", archivo);

                    try {
                        url = value.valida(session, initDate, endDate, "Sicmirb054");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte B145
                else if (action.equals("SICMIRB145")) {
                    url = "/SICMIRB145Header.jsp";
                } else if (action.equals("SICMIRB145Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String outg = request.getParameter("outg");
                    String[] bancoAdqArray = request.getParameterValues("bancoAdq");
                    String bancosAdq = "";
                    for (String banco : bancoAdqArray) {
                        if (!bancosAdq.equals("")) {
                            bancosAdq += ",";
                        }
                        bancosAdq += banco;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancosAdq);
                    session.setAttribute("outg", outg);
                    try {
                        url = value.valida(session, initDate, endDate, "Sicmirb145");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte B290
                else if (action.equals("SICMIRB290")) {
                    url = "/SICMIRB290Header.jsp";
                } else if (action.equals("SICMIRB290Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoEmi = request.getParameter("bancoEmi");
                    String[] bancoAdqArray = request.getParameterValues("bancoAdq");
                    String bancosAdq = "";
                    for (String banco : bancoAdqArray) {
                        if (!bancosAdq.equals("")) {
                            bancosAdq += ",";
                        }
                        bancosAdq += banco;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancosAdq);
                    try {
                        url = value.valida(session, initDate, endDate, "Sicmirb290");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte MIRB040
                else if (action.equals("SICMIRB040")) {
                    url = "/SICMIRB040Header.jsp";
                } else if (action.equals("SICMIRB040Main")) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String comercio = request.getParameter("scomercio");
                    String[] bancolst = request.getParameterValues("banco");
                    String banco = "";
                    for (String banco1 : bancolst) {
                        if (!banco.equals("")) {
                            banco += ",";
                        }
                        banco += banco1;
                    }

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("banco", banco);
                    session.setAttribute("comercio", comercio);

                    try {
                        if (format.parse(initDate).compareTo(format.parse(diaHabAnt7)) > 0) {
                            url = "/reportsjsp/managerReports.jsp" + "?report=" + "Sicmirb040";
                            viewerManager.setUpViewer(this, request, response, url);
                            isAnswerReport = true;
                        } else {
                            url = "/fechasInvalidas.jsp?noPantalla=4";
                        }
                    } catch (Exception ex) {
                        throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                    }
                } //Reporte b420
                else if (action.equals("SICMIRB420")) {
                    url = "/SICMIRB420Header.jsp";
                } else if (action.equals("SICMIRB420Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoAdq = request.getParameter("bancoAdq");
                    String[] bancosAdq = request.getParameterValues("bancoAdq");
                    String bancosAdqStr = "";
                    for (String bancoAdq : bancosAdq) {
                        if (!bancosAdqStr.equals("")) {
                            bancosAdqStr += ",";
                        }
                        bancosAdqStr += bancoAdq;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancosAdqStr);

                    try {
                        url = value.valida(session, initDate, endDate, "Sicmirb420");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte B450
                else if (action.equals("SICMIRB450")) {
                    url = "/SICMIRB450Header.jsp";
                } else if (action.equals("SICMIRB450Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoAdq = request.getParameter("bancoAdq");
                    String[] bancoAdqArray = request.getParameterValues("bancoAdq");
                    String bancoAdq = "";
                    for (String banco : bancoAdqArray) {
                        if (!bancoAdq.equals("")) {
                            bancoAdq += ",";
                        }
                        bancoAdq += banco;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancoAdq);
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        session.setAttribute("initDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                        session.setAttribute("endDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                        url = value.valida(session, initDate, endDate, "Sicmirb450");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (ParseException pe) {
                        pe.printStackTrace();
                    }
                } //Reporte SICMOFB100
                else if (action.equals("SICMOFB100")) {
                    if (request.getParameter("mostrarTabla") != null) {
                        session.setAttribute("mostrarTabla", "true");
                    } else {
                        session.setAttribute("mostrarTabla", "false");
                    }

                    url = "/SICMOFB100Header.jsp";
                } //Reporte SICMOF0120
                else if (action.equals("SICMOFB120")) {
                    if (request.getParameter("mostrarTabla") != null) {
                        session.setAttribute("mostrarTabla", "true");
                    } else {
                        session.setAttribute("mostrarTabla", "false");
                    }

                    url = "/SICMOFB120Header.jsp";
                } //Reporte B170
                else if (action.equals("SICMORB170")) {
                    url = "/SICMORB170Header.jsp";
                } else if (action.equals("SICMORB170Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoAdq = request.getParameter("bancoAdq");
                    String[] bancoAdqArray = request.getParameterValues("bancoAdq");
                    String bancoAdq = "";
                    for (String banco : bancoAdqArray) {
                        if (!bancoAdq.equals("")) {
                            bancoAdq += ",";
                        }
                        bancoAdq += banco;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancoAdq);
                    try {
                        url = value.valida(session, initDate, endDate, "Sicmorb170");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                }//Reporte B210
                else if (action.equals("SICMORB210")) {
                    url = "/SICMORB210Header.jsp";
                } else if (action.equals("SICMORB210Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String[] bancoAdqArray = request.getParameterValues("bancoAdq");
                    String bancoAdq = "";
                    for (String banco : bancoAdqArray) {
                        if (!bancoAdq.equals("")) {
                            bancoAdq += ",";
                        }
                        bancoAdq += banco;
                    }
                    String typsRechStr = request.getParameter("typeRech");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancoAdq);
                    session.setAttribute("typeRech", typsRechStr);
                    try {
                        url = value.valida(session, initDate, endDate, "Sicmorb210");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte B121
                else if (action.equals("SICMIRB121")) {
                    url = "/SICMIRB121Header.jsp";
                } else if (action.equals("SICMIRB121Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoEmi = request.getParameter("bancoEmi");
                    String[] bancoSocioArray = request.getParameterValues("bancoSocio");
                    String bancosSocios = "";
                    for (String banco : bancoSocioArray) {
                        if (!bancosSocios.equals("")) {
                            bancosSocios += ",";
                        }
                        bancosSocios += banco;
                    }
                    String[] tipoTxnArray = request.getParameterValues("tipoTxn");
                    String tipoTxn = "";
                    for (String txn : tipoTxnArray) {
                        if (!tipoTxn.equals("")) {
                            tipoTxn += ",";
                        }
                        tipoTxn += txn;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoSocio", bancosSocios);
                    session.setAttribute("tipoTxn", tipoTxn);
                    try {
                        url = value.valida(session, initDate, endDate, "Sicmirb121");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte B124
                else if (action.equals("SICMIRB124")) {
                    url = "/SICMIRB124Header.jsp";
                } else if (action.equals("SICMIRB124Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String banco = request.getParameter("banco");
                    String[] bancos = request.getParameterValues("bancoSocio");
                    String bancosStr = "";
                    for (String banco : bancos) {
                        if (!bancosStr.equals("")) {
                            bancosStr += ",";
                        }
                        bancosStr += banco;
                    }
                    String[] ttCharbacks = request.getParameterValues("tipoTxn");
                    String ttCharbacksStr = "";
                    for (String ttCharback : ttCharbacks) {
                        if (!ttCharbacksStr.equals("")) {
                            ttCharbacksStr += ",";
                        }
                        ttCharbacksStr += ttCharback;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosStr);
                    session.setAttribute("ttCharbacks", ttCharbacksStr);

                    try {
                        url = value.valida(session, initDate, endDate, "Sicmirb124");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }//Reporte B126
                else if (action.equals("SICMIRB126")) {
                    url = "/SICMIRB126Header.jsp";
                } else if (action.equals("SICMIRB126Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String banco = request.getParameter("banco");
                    String[] bancos = request.getParameterValues("banco");
                    String bancosStr = "";
                    for (String banco : bancos) {
                        if (!bancosStr.equals("")) {
                            bancosStr += ",";
                        }
                        bancosStr += banco;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosStr);

                    try {
                        url = value.valida(session, initDate, endDate, "Sicmirb126");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } //Reporte B127_vss
                else if (action.equals("SICMIRB127_VSS")) {
                    //session.setAttribute( "ENTIDADES", this.ENTIDADES );
                    url = "/SICMIRB127_VSSHeader.jsp";
                } else if (action.equals("SICMIRB127_VSSMain")) {

                    SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat formateo2 = new SimpleDateFormat("yyMMdd");
                    String inicial = request.getParameter("txtfStartDate");
                    String banco = request.getParameter("banco");
                    if (banco.length() < 2) {
                        banco = "000" + banco;
                        System.out.println("Variable banco es " + banco);
                    } else if (banco.length() < 3) {
                        banco = "00" + banco;
                        System.out.println("Variable banco es " + banco);
                    } else if (banco.length() < 4) {
                        banco = "0" + banco;
                        System.out.println("Variable banco es " + banco);
                    }

                    try {
                        session.setAttribute("banco", banco);
                        String inicial2 = formateo2.format(formateo.parse(inicial));
                        session.setAttribute("initDate", inicial2);

                        String sFichero = "";

                        if (banco.equals("1001")) {
                            sFichero = "//aplic//prod//pmt//pmr//vsa//049" + inicial2 + "_102";
                            session.setAttribute("prefijo", "102");
                        } else if (banco.equals("1002") || banco.equals("1003")) {
                            sFichero = "//aplic//prod//pmt//pmr//vsa//049" + inicial2 + "_103";
                            session.setAttribute("prefijo", "103");
                        } else {
                            sFichero = "//aplic//prod//pmt//pmr//vsa//049" + inicial2 + "_101";
                            session.setAttribute("prefijo", "101");
                        }

                        File fichero = new File(sFichero);
                        System.out.println("El fichero es: " + sFichero);
                        if (fichero.exists()) {
                            System.out.println("El fichero " + sFichero + " existe");
                            url = "/reportsjsp/managerReports.jsp" + "?report=" + "SICMIRB127_VSS";
                            viewerManager.setUpViewer(this, request, response, url);
                            isAnswerReport = true;
                        } else {
                            url = "/reportsjsp/Error.jsp";
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } //Reporte B127_master
                else if (action.equals("SICMIRB127_MASTER")) {
                    url = "/SICMIRB127_MASTERHeader.jsp";
                } else if (action.equals("SICMIRB127_MASTERMain")) {

                    SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
                    String inicial = request.getParameter("txtfStartDate");
                    String banco = request.getParameter("banco");
                    String bancoCad = request.getParameter("banco");
                    String ciclo = request.getParameter("ciclo");

                    if (banco.length() < 2) {
                        banco = "000" + banco;
                    } else if (banco.length() < 3) {
                        banco = "00" + banco;
                    } else if (banco.length() < 4) {
                        banco = "0" + banco;
                    }

                    try {
                        session.setAttribute("banco", banco);
                        session.setAttribute("ciclo", ciclo);
                        inicial = formateo.format(formateo.parse(inicial));
                        //Genera objeto Conexion
                        conOracle = new ConexionORACLE();
                        conOracle.Conectar();
                        ArrayList dias;
                        ArrayList tienumero;

                        String SQL = "SELECT TO_CHAR(TO_DATE('" + inicial + "','DD/MM/YYYY'),'DDD') FROM DUAL";

                        conOracle.Conectar();
                        conOracle.Consultar(SQL);
                        dias = conOracle.getRSColsData();

                        String[] vv = (String[]) dias.get(0);
                        session.setAttribute("initDate", vv[0]);

                        String SQL2 = "SELECT DISTINCT PE.TIE_NUMERO FROM PMADMIN.PRSA_ENTIDADES PE WHERE PE.NUMERO_PROSA = " + bancoCad;
                        conOracle.Consultar(SQL2);
                        tienumero = conOracle.getRSColsData();

                        String[] vv2 = (String[]) tienumero.get(0);
                        String sFichero = "";

                        if (vv2[0].equals("1"))//pesos
                        {
                            sFichero = "//aplic//prod//pmt//pmr//mcd//T14002449" + vv[0] + "0" + ciclo;
                            session.setAttribute("tipo", "T14002449");
	/*  ---------------------------------------------------------------------------------
    -- Marca del Cambio : SAS-LERC-P-20-5230-16 Inicia la Modificacion  22/09/2017
    ---------------------------------------------------------------------------------*/
                        } else if (vv2[0].equals("9") && (banco.equals("1001") || banco.equals("1003") || banco.equals("1004") || banco.equals("1010") || banco.equals("1064")))//dolares
	/*  ---------------------------------------------------------------------------------
    -- Marca del Cambio : SAS-LERC-P-20-5230-16 Fin de la Modificacion  22/09/2017
    ---------------------------------------------------------------------------------*/
                        {
                            sFichero = "//aplic//prod//pmt//pmr//mcd//T14003287" + vv[0] + "0" + ciclo;
                            session.setAttribute("tipo", "T14003287");
                        } else if (vv2[0].equals("9"))//entidades en dolares, archivo nacional (pesos)
                        {
                            sFichero = "//aplic//prod//pmt//pmr//mcd//T14002449" + vv[0] + "0" + ciclo;
                            session.setAttribute("tipo", "T14002449");
                        }

                        File fichero = new File(sFichero);
                        System.out.println("Archivo:" + fichero + ":");
                        if (fichero.exists()) {
                            url = "/reportsjsp/managerReports.jsp" + "?report=" + "SICMIRB127_MASTER";
                            viewerManager.setUpViewer(this, request, response, url);
                            isAnswerReport = true;
                        } else {
                            url = "/reportsjsp/Error.jsp";
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        conOracle.Desconectar();
                    }
                } //Reporte B141
                else if (action.equals("SICMIRB141")) {
                    url = "/SICMIRB141Header.jsp";
                } else if (action.equals("SICMIRB141Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String banco = request.getParameter("banco");
                    String[] bancos = request.getParameterValues("banco");
                    String bancosStr = "";
                    for (String banco : bancos) {
                        if (!bancosStr.equals("")) {
                            bancosStr += ",";
                        }
                        bancosStr += banco;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosStr);

                    try {
                        url = value.valida(session, initDate, endDate, "Sicmirb141");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } //Reporte B142
                else if (action.equals("SICMIRB142")) {
                    url = "/SICMIRB142Header.jsp";
                } else if (action.equals("SICMIRB142Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String banco = request.getParameter("banco");
                    String[] bancos = request.getParameterValues("banco");
                    String bancosStr = "";
                    for (String banco : bancos) {
                        if (!bancosStr.equals("")) {
                            bancosStr += ",";
                        }
                        bancosStr += banco;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosStr);

                    try {
                        url = value.valida(session, initDate, endDate, "Sicmirb142");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } //Reporte 0144
                else if (action.equals("SICMIRB144")) {
                    url = "/SICMIRB144Header.jsp";
                } else if (action.equals("SICMIRB144Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String banco = request.getParameter("banco");
                    String[] bancos = request.getParameterValues("banco");
                    String bancosStr = "";
                    for (String banco : bancos) {
                        if (!bancosStr.equals("")) {
                            bancosStr += ",";
                        }
                        bancosStr += banco;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosStr);

                    try {
                        url = value.valida(session, initDate, endDate, "Sicmirb144");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } //Reporte B148
                else if (action.equals("SICMIRB148")) {
                    //session.setAttribute( "ENTIDADES", this.ENTIDADES );
                    url = "/SICMIRB148Header.jsp";
                } else if (action.equals("SICMIRB148Main")) {

                    SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat formateo2 = new SimpleDateFormat("yyMMdd");
                    String inicial = request.getParameter("txtfStartDate");

                    try {
                        String inicial2 = formateo2.format(formateo.parse(inicial));
                        session.setAttribute("initDate", inicial2);

                        String sFichero = "//aplic//prod//pmt//pmr//mcd//851" + inicial2;
                        File fichero = new File(sFichero);
                        System.out.println("El fichero es: " + sFichero);
                        if (fichero.exists()) {
                            //System.out.println("El fichero " + sFichero + " existe");
                            url = "/reportsjsp/managerReports.jsp" + "?report=" + "SICMIRB148";
                            viewerManager.setUpViewer(this, request, response, url);
                            isAnswerReport = true;
                        } else //System.out.println("Pues va a ser que no");
                        {
                            url = "/reportsjsp/Error.jsp";
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }//Reporte SICLIRB150
                else if (action.equals("SICLIRB150")) {
                    url = "/SICLIRB150Header.jsp";
                } else if (action.equals("SICLIRB150Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoEmi = request.getParameter("bancoEmi");
                    String[] bancos = request.getParameterValues("banco");
                    String bancosStr = "";
                    for (String banco : bancos) {
                        if (!bancosStr.equals("")) {
                            bancosStr += ",";
                        }
                        bancosStr += banco;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosStr);
                    try {
                        url = value.valida(session, initDate, endDate, "Siclirb150");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } // SICLIRB170
                else if (action.equals("SICLIRB170")) {
                    url = "/SICLIRB170Header.jsp";
                } else if (action.equals("SICLIRB170Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String moneda = request.getParameter("moneda");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("moneda", moneda);

                    try {
                        url = value.valida(session, initDate, endDate, "Siclirb170");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } // SICLIRB180
                else if (action.equals("SICLIRB180")) {
                    url = "/SICLIRB180Header.jsp";
                } else if (action.equals("SICLIRB180Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    try {
                        url = value.valida(session, initDate, endDate, "Siclirb180");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                }//Terminan los  reportes 
                else {
                    System.out.println("WRONG Action ELSE:" + action);
                    pC.setUrl(url);
                    pC.setIsAnswerReport(isAnswerReport);
                    //processRequestContinua(request, response,pC);
                    url = pC.getUrl();
                    isAnswerReport = pC.getIsAnswerReport();
                }

            } else {
                System.out.println("Action Null :" + action);
            }
        } catch (NullPointerException npe) {
            // TODO: handle exception
            System.out.println("Aplicacion: NullpointerException");
        }

        if (!isAnswerReport) {
            System.out.println("FIN PROCESS REQUEST");
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

    class ParametrosCompartidos {

        String url;
        boolean isAnswerReport;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean getIsAnswerReport() {
            return isAnswerReport;
        }

        public void setIsAnswerReport(boolean isAnswerReport) {
            this.isAnswerReport = isAnswerReport;
        }

    }

    public String Posicion(String posicion) {
        String retorno = "a0";
        //if posicion is null, wont show open menu
        if (posicion == null) {
            return retorno;
        } else //'posicion' always must be 2 lenght and start with the letter 'a'
         if (posicion.length() != 2 || !posicion.startsWith("a")) {
                return retorno;
            } else {
                int n = 0;

                try {
                    n = Integer.parseInt(posicion.substring(1));
                } catch (NumberFormatException e) {
                    return retorno;
                }
                if (n > 2 || n == 0) {
                    return retorno;
                } else {
                    retorno = posicion;
                }
            }
        return retorno;
    }

}
