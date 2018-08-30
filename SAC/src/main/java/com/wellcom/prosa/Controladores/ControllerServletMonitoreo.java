/*###############################################################################
# Nombre del Programa :  ControllerServletMonitoreo.java                        #
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
#################################################################################
#                                                              Modificaciones   #
#-------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
package com.wellcom.prosa.Controladores;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import biz.ideasoft.beans.ViewerManager;

import com.wellcom.Validator.Mantenimiento;
import com.wellcom.Validator.Validador;
import com.wellcom.prosa.sacii.*;

import com.wellcom.exceptions.WellException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import java.text.ParseException;

import com.wellcom.exceptions.WellException;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.io.FileInputStream;
import java.util.List;

/**
 * Servlet implementation class ControllerServletMonitoreo
 */
public class ControllerServletMonitoreo extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private HttpSession session;
    String url;
    String rutaContext = "";
    private String sessionId, oldSessionId;
    Validador value;
    ParametrosCompartidos pC = new ParametrosCompartidos();
    ViewerManager viewerManager;
    String particiones;
    ComboBoxGen listaparticiones;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServletMonitoreo() {
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
        String action;
        String fechaHoy;
        boolean isAnswerReport = false;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formato1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formato2 = new SimpleDateFormat("MM/dd/yyyy");
        String diaHabAnt7 = "";
        action = "login";
        this.session = request.getSession(false);
        if (this.session != null && this.session.getAttribute("activo") != null) {
            action = request.getParameter("action");
            System.out.println("Action : " + action);

            this.sessionId = session.getId();
            System.out.println("ControllerServletMonitoreo session: " + this.sessionId);
            this.session.setMaxInactiveInterval(2400);

            session.setAttribute("rutaContext", rutaContext);
            String posicion = request.getParameter("p");
            posicion = Posicion(posicion);

            session.setAttribute("pos", posicion);
            value = new Validador();
            java.util.Date fechaAnterior = new java.util.Date();

            java.util.Date fechaActual = new java.util.Date();
            fechaHoy = formato.format(fechaActual);
            session.setAttribute("fechaHoy", fechaHoy);
            long fechaAntes = fechaAnterior.getTime() - 8 * (24 * 60 * 60 * 1000);
            diaHabAnt7 = formato.format(fechaAntes);
            if (session.getAttribute("viewerManager") == null) {
                viewerManager = new ViewerManager();
                session.setAttribute("viewerManager", viewerManager);
            } else {
                viewerManager = (ViewerManager) session.getAttribute("viewerManager");
            }
        }
        ControllerMethod metodo = null;
        try {
            if (action != null) {
                if (action.equals("login")) {
                    //session.invalidate();
                    System.out.println("Action Login ControllerServletMonitoreo: " + action);
                    url = "/login.jsp";

//Comienzan reportes 
                } //Reporte SICMOF0100
                else if (action.equals("SICMOF0100")) {
                    fechas(session);
                    if (request.getParameter("mostrarTabla") != null) {
                        session.setAttribute("mostrarTabla", "true");
                    } else {
                        session.setAttribute("mostrarTabla", "false");
                    }

                    url = "/SICMOF0100Header.jsp";
                } //Reporte SICMOF0120
                else if (action.equals("SICMOF0120")) {
                    fechas(session);
                    if (request.getParameter("mostrarTabla") != null) {
                        session.setAttribute("mostrarTabla", "true");
                    } else {

                        session.setAttribute("mostrarTabla", "false");
                    }

                    url = "/SICMOF0120Header.jsp";
                } //Reporte 0100
                else if (action.equals("SICMOR0100")) {
                    url = "/SICMOR0100Header.jsp";
                } else if (action.equals("SICMOR0100Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String agrNatContable = (request.getParameter("agrNatContable") == null ? "false" : "true");
                    String afiliacion = request.getParameter("afiliacion").equals("") ? "null" : request.getParameter("afiliacion");
                    String diaHabAnt = (String) session.getAttribute("diaHabAnt");

                    String[] bancosAdq = request.getParameterValues("bancoAdq");
                    String bancosAdqStr = "";
                    for (String bancoAdq : bancosAdq) {
                        if (!bancosAdqStr.equals("")) {
                            bancosAdqStr += ",";
                        }
                        bancosAdqStr += bancoAdq;
                    }
                    String[] transacs = request.getParameterValues("nTransac");
                    String transacsStr = "";
                    for (String transac : transacs) {
                        if (!transacsStr.equals("")) {
                            transacsStr += ",";
                        }
                        transacsStr += transac;
                    }
                    String[] archivosAdq = request.getParameterValues("archivoAdq");
                    String archivosAdqStr = "";
                    for (String archivoAdq : archivosAdq) {
                        if (!archivosAdqStr.equals("")) {
                            archivosAdqStr += ",";
                        }
                        archivosAdqStr += archivoAdq;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancosAdqStr);
                    session.setAttribute("nTransac", transacsStr);
                    session.setAttribute("archivoAdq", archivosAdqStr);
                    session.setAttribute("agrNatContable", agrNatContable);
                    session.setAttribute("afiliacion", afiliacion);

                    try {
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                        try {
                            metodo = new ControllerMethod();
                            if (format.parse(initDate).compareTo(format.parse(diaHabAnt7)) > 0) {
                                metodo.Oparticiones(initDate, endDate, session);
                                url = value.valida(session, initDate, endDate, "Sicmor0100");
                                viewerManager.setUpViewer(this, request, response, url);
                                isAnswerReport = true;
                            } else {
                                url = "/fechasInvalidas.jsp?noPantalla=4";
                            }
                        } catch (Exception ex) {
                            throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                        }
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } else if (action.equals("SICMOR0200H")) {
                    url = "/SICMOR0200H.jsp";
                } else if (action.equals("SICMOR0205")) {
                    fechas(session);
                    if (request.getParameter("mostrarTabla") != null) {
                        session.setAttribute("mostrarTabla", "true");
                    } else {
                        session.setAttribute("mostrarTabla", "false");
                    }
                    url = "/SICMOR0205Header.jsp";
                } else if (action.equals("SICMOR0205Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String diaHabAnt = (String) session.getAttribute("diaHabAnt");

                    String cuenta = request.getParameter("cuenta").equals("") ? "null" : request.getParameter("cuenta");
                    String comercio = request.getParameter("comercio").equals("") ? "null" : request.getParameter("comercio");
                    String referencia = request.getParameter("referencia").equals("") ? "null" : request.getParameter("referencia");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("cuenta", cuenta);
                    session.setAttribute("comercio", comercio);
                    session.setAttribute("referencia", referencia);

                    try {
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                        try {
                            metodo = new ControllerMethod();
                            if (format.parse(initDate).compareTo(format.parse(diaHabAnt7)) > 0) {
                                metodo.Oparticiones(initDate, endDate, session);
                                url = value.valida(session, initDate, endDate, "Sicmor0205");
                                viewerManager.setUpViewer(this, request, response, url);
                                isAnswerReport = true;
                            } else {
                                url = "/fechasInvalidas.jsp?noPantalla=4";
                            }
                        } catch (Exception ex) {
                            throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                        }
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } else if (action.equals("SICMOR0210")) {
                    url = "/SICMOR0210Header.jsp";
                } else if (action.equals("SICMOR0210Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String typeRech = request.getParameter("typeRech");
                    //String bancoAdq = request.getParameter("bancoAdq");
                    String[] bancoAdqArray = request.getParameterValues("bancoAdq");
                    String bancoAdq = "";
                    for (String banco : bancoAdqArray) {
                        if (!bancoAdq.equals("")) {
                            bancoAdq += ",";
                        }
                        bancoAdq += banco;
                    }
                    String[] typsRech = request.getParameterValues("typeRech");
                    String typsRechStr = "";
                    for (String typRech : typsRech) {
                        if (!typsRechStr.equals("")) {
                            typsRechStr += ",";
                        }
                        typsRechStr += typRech;
                    }

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("typeRech", typsRechStr);
                    session.setAttribute("bancoAdq", bancoAdq);
                    try {
                        url = value.valida(session, initDate, endDate, "Sicmor0210");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0300
                else if (action.equals("SICMOR0300")) {

                    url = "/SICMOR0300Header.jsp";
                } else if (action.equals("SICMOR0300Main")) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String diaHabAnt = (String) session.getAttribute("diaHabAnt");
                    String initDate = request.getParameter("txtfStartDate");

                    String[] bancosAdq = request.getParameterValues("bancoAdq");
                    String bancosAdqStr = "";
                    for (String bancoAdqr : bancosAdq) {
                        if (!bancosAdqStr.equals("")) {
                            bancosAdqStr += ",";
                        }
                        bancosAdqStr += bancoAdqr;
                    }

                    String[] bancosEmi = request.getParameterValues("bancoEmi");
                    String bancosEmiStr = "";
                    for (String bancoEmir : bancosEmi) {
                        if (!bancosEmiStr.equals("")) {
                            bancosEmiStr += ",";
                        }
                        bancosEmiStr += bancoEmir;
                    }

                    String[] fuentes = request.getParameterValues("archivoEmi");
                    if (fuentes == null) {
                        fuentes = new String[0];
                    }
                    String fuentesStr = "";
                    for (String fuentesr : fuentes) {
                        if (!fuentesStr.equals("")) {
                            fuentesStr += ",";
                        }
                        fuentesStr += fuentesr;
                    }

                    String[] Transacciones = request.getParameterValues("Transaccion");
                    if (Transacciones == null) {
                        Transacciones = new String[0];
                    }
                    String TransaccionesStr = "";
                    for (String Transaccionesr : Transacciones) {
                        if (!TransaccionesStr.equals("")) {
                            TransaccionesStr += ",";
                        }
                        TransaccionesStr += Transaccionesr;
                    }

                    String[] Liquidaciones = request.getParameterValues("Liquidacion");
                    if (Liquidaciones == null) {
                        Liquidaciones = new String[0];
                    }
                    String LiquidacionesStr = "";
                    for (String Liquidacionesr : Liquidaciones) {
                        if (!LiquidacionesStr.equals("")) {
                            LiquidacionesStr += ",";
                        }
                        LiquidacionesStr += Liquidacionesr;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("bancoAdq", bancosAdqStr);
                    session.setAttribute("bancoEmi", bancosEmiStr);
                    session.setAttribute("transaccion", TransaccionesStr);
                    session.setAttribute("fuente", fuentesStr);
                    session.setAttribute("liquidacion", LiquidacionesStr);

                    try {
                        try {
                            metodo = new ControllerMethod();
                            if (format.parse(initDate).compareTo(format.parse(diaHabAnt7)) > 0) {
                                metodo.Oparticion(initDate, session);
                                url = "/reportsjsp/managerReports.jsp" + "?report=" + "Sicmor0300";
                                viewerManager.setUpViewer(this, request, response, url);
                                isAnswerReport = true;
                            } else {
                                url = "/fechasInvalidas.jsp?noPantalla=4";
                            }
                        } catch (Exception ex) {
                            throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                        }
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte SICMOR0301
                else if (action.equals("SICMOR0301")) {
                    url = "/SICMOR0301Header.jsp";
                } else if (action.equals("SICMOR0301Main")) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String diaHabAnt = (String) session.getAttribute("diaHabAnt");
                    String initDate = request.getParameter("txtfStartDate");
                    String[] bancosAdq = request.getParameterValues("bancoAdq");
                    String bancosAdqStr = "";
                    for (String bancoAdqr : bancosAdq) {
                        if (!bancosAdqStr.equals("")) {
                            bancosAdqStr += ",";
                        }
                        bancosAdqStr += bancoAdqr;
                    }
                    String[] bancosEmi = request.getParameterValues("bancoEmi");
                    String bancosEmiStr = "";
                    for (String bancoEmir : bancosEmi) {
                        if (!bancosEmiStr.equals("")) {
                            bancosEmiStr += ",";
                        }
                        bancosEmiStr += bancoEmir;
                    }

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("bancoAdq", bancosAdqStr);
                    session.setAttribute("bancoEmi", bancosEmiStr);

                    try {
                        try {
                            metodo = new ControllerMethod();
                            if (format.parse(initDate).compareTo(format.parse(diaHabAnt7)) > 0) {
                                metodo.Oparticion(initDate, session);
                                url = "/reportsjsp/managerReports.jsp" + "?report=" + "Sicmor0301";
                                viewerManager.setUpViewer(this, request, response, url);
                                isAnswerReport = true;
                            } else {
                                url = "/fechasInvalidas.jsp?noPantalla=4";
                            }
                        } catch (Exception ex) {
                            throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                        }
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte SICMOR0305
                else if (action.equals("SICMOR0305")) {
                    url = "/SICMOR0305Header.jsp";
                } else if (action.equals("SICMOR0305Main")) {

                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String fecha1 = formato2.format(formato1.parse(initDate));
                    String fecha2 = formato2.format(formato1.parse(endDate));
                    String fechas = fecha1 + "        " + fecha2;
                    listaparticiones = new ComboBoxGen();
                    String diaHabAnt = (String) session.getAttribute("diaHabAnt");

                    String prefijo = request.getParameter("Prefijo");
                    String[] bancoAdqArray = request.getParameterValues("bancoAdq");
                    String bancoAdq = "";
                    for (String banco : bancoAdqArray) {
                        if (!bancoAdq.equals("")) {
                            bancoAdq += ",";
                        }
                        bancoAdq += banco;
                    }
                    String[] bancoEmiArray = request.getParameterValues("bancoEmi");
                    String bancoEmi = "";
                    for (String banco : bancoEmiArray) {
                        if (!bancoEmi.equals("")) {
                            bancoEmi += ",";
                        }
                        bancoEmi += banco;
                    }
                    String[] tipoTransArray = request.getParameterValues("tipoTransac");
                    String tipoTrans = "";
                    for (String tipo : tipoTransArray) {
                        if (!tipoTrans.equals("")) {
                            tipoTrans += ",";
                        }
                        tipoTrans += tipo;
                    }

                    String[] tipoLiquidacionArray = request.getParameterValues("tipoLiquidacion");
                    String tipoLiquidacion = "";
                    for (String tipo : tipoLiquidacionArray) {
                        if (!tipoLiquidacion.equals("")) {
                            tipoLiquidacion += ",";
                        }
                        tipoLiquidacion += tipo;
                    }

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("particiones", particiones);
                    session.setAttribute("bancoAdq", bancoAdq);
                    session.setAttribute("bancoEmi", bancoEmi);
                    session.setAttribute("tipoTransac", tipoTrans);
                    session.setAttribute("prefijo", prefijo);
                    session.setAttribute("tipoLiquidacion", tipoLiquidacion);
                    try {
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                        try {
                            metodo = new ControllerMethod();
                            if (format.parse(initDate).compareTo(format.parse(diaHabAnt7)) > 0) {
                                metodo.Oparticiones(initDate, endDate, session);
                                url = value.valida(session, initDate, endDate, "Sicmor0305");
                                viewerManager.setUpViewer(this, request, response, url);
                                isAnswerReport = true;
                            } else {
                                url = "/fechasInvalidas.jsp?noPantalla=4";
                            }
                        } catch (Exception ex) {
                            throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                        }
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                }//Reporte 0310
                else if (action.equals("SICLIR0310")) {
                    url = "/SICLIR0310Header.jsp";
                } else if (action.equals("SICLIR0310Main")) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String agrupacion = request.getParameter("agrupacion");
                    String[] bancos = request.getParameterValues("banco");
                    String[] archivoBanco = request.getParameterValues("archivoBanco");
                    String bancosStr = "";
                    for (String banco : bancos) {
                        if (!bancosStr.equals("")) {
                            bancosStr += ",";
                        }
                        bancosStr += banco;
                    }

                    String archivoBancoStr = "";
                    for (String banco : archivoBanco) {
                        if (!archivoBancoStr.equals("")) {
                            archivoBancoStr += ",";
                        }
                        archivoBancoStr += banco;
                    }

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosStr);
                    session.setAttribute("archivoBanco", archivoBancoStr);
                    session.setAttribute("agrupacion", agrupacion);
                    try {
                        url = value.valida(session, initDate, endDate, "Siclir0310");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte SICMOR0310
                else if (action.equals("SICMOR0310")) {
                    url = "/SICMOR0310Header.jsp";
                } else if (action.equals("SICMOR0310Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String comercio = request.getParameter("comercio");

                    String[] bancoAdqArray = request.getParameterValues("bancoAdq");
                    String bancoAdq = "";
                    for (String banco : bancoAdqArray) {
                        if (!bancoAdq.equals("")) {
                            bancoAdq += ",";
                        }
                        bancoAdq += banco;
                    }

                    String[] bancoEmiArray = request.getParameterValues("bancoEmi");
                    String bancoEmi = "";
                    for (String banco : bancoEmiArray) {
                        if (!bancoEmi.equals("")) {
                            bancoEmi += ",";
                        }
                        bancoEmi += banco;
                    }

                    String[] tipoTransArray = request.getParameterValues("tipoTransac");
                    String tipoTrans = "";
                    for (String tipo : tipoTransArray) {
                        if (!tipoTrans.equals("")) {
                            tipoTrans += ",";
                        }
                        tipoTrans += tipo;
                    }

                    String[] tipoLiquidacionArray = request.getParameterValues("tipoLiquidacion");
                    String tipoLiquidacion = "";
                    for (String tipo : tipoLiquidacionArray) {
                        if (!tipoLiquidacion.equals("")) {
                            tipoLiquidacion += ",";
                        }
                        tipoLiquidacion += tipo;
                    }

                    String[] fuenteArray = request.getParameterValues("archivoAdq");
                    String fuentes = "";
                    for (String tipo : fuenteArray) {
                        if (!fuentes.equals("")) {
                            fuentes += ",";
                        }
                        fuentes += tipo;
                    }

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancoAdq);
                    session.setAttribute("bancoEmi", bancoEmi);
                    session.setAttribute("tipoTransac", tipoTrans);
                    session.setAttribute("tipoLiquidacion", tipoLiquidacion);
                    session.setAttribute("fuente", fuentes);
                    session.setAttribute("comercio", comercio);

                    try {
                        metodo = new ControllerMethod();
                        metodo.Oparticiones(initDate, endDate, session);
                        url = value.valida(session, initDate, endDate, "Sicmor0310");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0330
                else if (action.equals("SICMOR0330")) {
                    url = "/SICMOR0330Header.jsp";
                } else if (action.equals("SICMOR0330Main")) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String cuenta = request.getParameter("cuenta").equals("") ? "null" : request.getParameter("cuenta");
                    String referencia = request.getParameter("referencia").equals("") ? "null" : request.getParameter("referencia");
                    if (referencia == "null") {
                        referencia = "0";
                    }
                    if (cuenta == "null") {
                        cuenta = "0";
                    }
                    System.out.println("Referencia:" + referencia + ":");
                    String natContable = request.getParameter("natContable").equals("") ? "null" : "'" + request.getParameter("natContable") + "'";
                    if (!natContable.equals("null")) {
                        natContable = natContable.toUpperCase();
                    }
                    String[] bancoAdqArray = request.getParameterValues("bancoAdq");
                    String bancoAdq = "";
                    for (String banco : bancoAdqArray) {
                        if (!bancoAdq.equals("")) {
                            bancoAdq += ",";
                        }
                        bancoAdq += banco;
                    }
                    String[] tipoTxnArray = request.getParameterValues("tipoTxn");
                    String tipoTxn = "";
                    for (String tipo : tipoTxnArray) {
                        if (!tipoTxn.equals("")) {
                            tipoTxn += ",";
                        }
                        tipoTxn += tipo;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("cuenta", cuenta);
                    session.setAttribute("referencia", referencia);
                    session.setAttribute("bancoAdq", bancoAdq);
                    session.setAttribute("tipoTxn", tipoTxn);
                    session.setAttribute("natContable", natContable);
                    try {
                        try {

                            if (format.parse(initDate).compareTo(format.parse(diaHabAnt7)) > 0) {
                                metodo = new ControllerMethod();
                                metodo.Oparticiones(initDate, endDate, session);
                                url = "/reportsjsp/managerReports.jsp" + "?report=" + "Sicmor0330";
                                viewerManager.setUpViewer(this, request, response, url);
                                isAnswerReport = true;
                            } else {
                                url = "/fechasInvalidas.jsp?noPantalla=4";
                            }
                        } catch (Exception ex) {
                            throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                        }
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0340
                else if (action.equals("SICMOR0340")) {
                    url = "/SICMOR0340Header.jsp";
                } else if (action.equals("SICMOR0340Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String[] bancos = request.getParameterValues("banco");
                    String bancosStr = "";
                    for (String banco : bancos) {
                        if (!bancosStr.equals("")) {
                            bancosStr += ",";
                        }
                        bancosStr += banco;
                    }
                    /*#Marca de cambio:  SAS-DRT B-54-2904-15  Inicio  Modificaci\F3n             #  */
                    String[] bancosAdq = request.getParameterValues("bancoAdq");
                    String bancosAdqStr = "";
                    for (String bancoAdq : bancosAdq) {
                        if (!bancosAdqStr.equals("")) {
                            bancosAdqStr += ",";
                        }
                        bancosAdqStr += bancoAdq;
                    }
                    session.setAttribute("bancoAdq", bancosAdqStr);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosStr);
                    try {
                        url = value.valida(session, initDate, endDate, "Sicmor0340");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0350
                else if (action.equals("SICMOR0350")) {
                    url = "/SICMOR0350Header.jsp";
                } else if (action.equals("SICMOR0350Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String ver = request.getParameter("ver");

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
                    session.setAttribute("ver", ver);
                    try {
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        try {
                            url = value.valida(session, initDate, endDate, "Sicmor0350");
                            viewerManager.setUpViewer(this, request, response, url);
                            isAnswerReport = true;
                        } catch (Exception ex) {
                            throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                        }
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte PTLF
                else if (action.equals("SICMORPTLF")) {
                    /**
                     * ******** Inicio Modificacion WELLCOM N-08-2253-12
                     * *********
                     */
                    fechas(session);
                    if (request.getParameter("mostrarTabla") != null) {
                        session.setAttribute("mostrarTabla", "true");
                    } else {
                        session.setAttribute("mostrarTabla", "false");
                    }
                    /**
                     * ******** Fin Modificacion WELLCOM N-08-2253-12 *********
                     */
                    url = "/SICMORPTLFHeader.jsp";
                } else if (action.equals("SICMORPTLFMain")) {
                    //String initDate = request.getParameter("txtfStartDate");
                    String afiliacion = request.getParameter("afiliacion");
                    String mes = request.getParameter("mes");
                    String year = request.getParameter("year");
                    String cuenta = request.getParameter("cuenta");
                    String[] bancoArray = request.getParameterValues("banco");
                    String bancoAdq = "";
                    for (String banco : bancoArray) {
                        if (!bancoAdq.equals("")) {
                            bancoAdq += ",";
                        }
                        bancoAdq += banco;
                    }
                    session.setAttribute("banco", bancoAdq);
                    session.setAttribute("cuenta", cuenta);
                    session.setAttribute("afiliacion", afiliacion);
                    session.setAttribute("mes", mes);
                    session.setAttribute("year", year);

                    url = "/reportsjsp/managerReports.jsp" + "?report=" + "SicmorPTLF";
                    fechas(session);
                    viewerManager.setUpViewer(this, request, response, url);
                    isAnswerReport = true;
                } //Reporte RECH
                else if (action.equals("SICMORRECH")) {
                    url = "/SICMORRECHHeader.jsp";
                } else if (action.equals("SICMORRECHMain")) {
                    String afiliacion = request.getParameter("afiliacion");
                    String mes = request.getParameter("mes");
                    String year = request.getParameter("year");
                    String cuenta = request.getParameter("cuenta");
                    String codigo = request.getParameter("codigo");
                    String[] bancoArray = request.getParameterValues("banco");
                    String bancoAdq = "";
                    for (String banco : bancoArray) {
                        if (!bancoAdq.equals("")) {
                            bancoAdq += ",";
                        }
                        bancoAdq += banco;
                    }
                    session.setAttribute("banco", bancoAdq);
                    session.setAttribute("cuenta", cuenta);
                    session.setAttribute("codigo", codigo);
                    session.setAttribute("afiliacion", afiliacion);
                    session.setAttribute("mes", mes);
                    session.setAttribute("year", year);

                    System.out.println("codigo:" + codigo);
                    url = "/reportsjsp/managerReports.jsp" + "?report=" + "SicmorRECH";
                    fechas(session);
                    viewerManager.setUpViewer(this, request, response, url);
                    isAnswerReport = true;
                } //Reporte 0150
                else if (action.equals("SICMOR0150")) {
                    url = "/SICMOR0150Header.jsp";
                } else if (action.equals("SICMOR0150Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String tipoTrans = request.getParameter("tipoTrans");
                    //String archivo = request.getParameter("archivo");
                    String[] tiposTran = request.getParameterValues("tipoTrans");
                    String tiposTranStr = "";
                    for (String tipoTran : tiposTran) {
                        if (!tiposTranStr.equals("")) {
                            tiposTranStr += ",";
                        }
                        tiposTranStr += tipoTran;
                    }
                    String[] archivos = request.getParameterValues("archivo");
                    String archivosStr = "";
                    for (String archivo : archivos) {
                        if (!archivosStr.equals("")) {
                            archivosStr += ",";
                        }
                        archivosStr += "'" + archivo + "'";
                    }
                    System.out.println(":" + archivosStr + ":");
                    session.setAttribute("initDate", initDate);
                    session.setAttribute("endDate", endDate);
                    session.setAttribute("tipoTrans", tiposTranStr);
                    session.setAttribute("archivo", archivosStr);
                    try {
                        url = value.valida(session, initDate, endDate, "Sicmor0150");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0170
                else if (action.equals("SICMOR0170")) {
                    url = "/SICMOR0170Header.jsp";
                } else if (action.equals("SICMOR0170Main")) {
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
                        url = value.valida(session, initDate, endDate, "Sicmor0170");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0280
                else if (action.equals("SICMOR0280")) {
                    url = "/SICMOR0280Header.jsp";
                } else if (action.equals("SICMOR0280Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String[] bancoSocioArray = request.getParameterValues("bancoSocio");
                    String bancosSocios = "";
                    for (String banco : bancoSocioArray) {
                        if (!bancosSocios.equals("")) {
                            bancosSocios += ",";
                        }
                        bancosSocios += banco;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoSocio", bancosSocios);
                    try {
                        url = value.valida(session, initDate, endDate, "Sicmor0280");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte SICMOR0171
                else if (action.equals("SICMOR0171")) {
                    url = "/SICMOR0171Header.jsp";
                } else if (action.equals("SICMOR0171Main")) {
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
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancoAdq);
                    try {
                        url = value.valida(session, initDate, endDate, "Sicmor0171");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } /*else if(action.equals("SICMOR0180"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICMOR0180Header.jsp";
                }
                else if(action.equals("SICMOR0180Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoEmi = request.getParameter("bancoEmi");
                    String []bancoSocioArray = request.getParameterValues("bancoSocio");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoSocio", bancosSocios);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicmor0180");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }
                 		   //Reporte 0240
            /*    else if(action.equals("SICMOR0240"))
                {
                    url = "/SICMOR0240Header.jsp";
                }
                else if(action.equals("SICMOR0240Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String corte = request.getParameter("corte");
                    String []fuenteEntArray = request.getParameterValues("fuente");
                    String fuenteEnt="";
                    for(String banco:fuenteEntArray){
                        if(!fuenteEnt.equals(""))
                            fuenteEnt+=",";
                        fuenteEnt+=banco;
                    }

                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("corte", corte);
                    session.setAttribute("fuente", fuenteEnt);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicmor0240");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }		   
                //Reporte 0270
                else if(action.equals("SICMOR0270"))
                {
                    url = "/SICMOR0270Header.jsp";
                }
                else if(action.equals("SICMOR0270Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String corte = request.getParameter("corte");
                    String fuente = request.getParameter("fuente");
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("corte", corte);
                    session.setAttribute("fuente", fuente);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicmor0270");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }
	//Reporte 0810
               /* else if(action.equals("SICMOR0810"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICMOR0810Header.jsp";
                }
                else if(action.equals("SICMOR0810Main"))
                {
                String txtfStartDate = request.getParameter("txtfStartDate");
                String txtfEndDate = request.getParameter("txtfEndDate");
                String determinante = request.getParameter("determinante");
                String []entidadArray = request.getParameterValues("interred");
                String []divisiones = request.getParameterValues("division"); //120


                String interredesStr="";
                for(String interred:entidadArray){
                    if(!interredesStr.equals(""))
                        interredesStr+=",";
                    interredesStr+=interred;
                }

                String divisionesStr="";
                for(String division:divisiones){
                    if(!divisionesStr.equals(""))
                        divisionesStr+=",";
                    divisionesStr+=division;
                }


                    session.setAttribute( "txtfStartDate", txtfStartDate);
                    session.setAttribute( "txtfEndDate", txtfEndDate);
                    session.setAttribute( "entidad", interredesStr);
                    session.setAttribute( "division", divisionesStr);
                    session.setAttribute( "determinante", determinante);
                    try
                    {
                        url = value.valida(session, txtfStartDate, txtfEndDate, "SICMOR0810");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }
                 else if(action.equals("SICMOR0290"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICMOR0290Header.jsp";
                }
                else if(action.equals("SICMOR0290Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoEmi = request.getParameter("bancoEmi");
                    String []bancoSocioArray = request.getParameterValues("bancoSocio");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoSocio", bancosSocios);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicmor0290");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }
                 */ //Fin reportes 
                else {
                    System.out.println("Action ELSE :" + action);
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

    public void fechas(HttpSession session) {
        String FechaXml = "";
        String NoFechaXml = "";
        String ruta = (String) session.getAttribute("rutaContext");
        String Fiid = (String) session.getAttribute("numFiid");
        try {
            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(new FileInputStream(ruta + "/xmls/LiberacionBancos.xml"));
            Element raiz = doc.getRootElement();
            List<Element> hijosRaiz = raiz.getChildren();
            for (Element hijo : hijosRaiz) {
                if (hijo.getAttributeValue("Fiid").equals(Fiid)) {
                    FechaXml = hijo.getAttributeValue("Fecha");
                } else {
                    NoFechaXml = "01/01/2000";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (FechaXml == "") {
            session.setAttribute("fechaXML", NoFechaXml);
        } else {
            session.setAttribute("fechaXML", FechaXml);
        }
    }

}
