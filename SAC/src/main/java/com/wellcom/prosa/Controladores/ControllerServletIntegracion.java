/*###############################################################################
# Nombre del Programa :  ControllerServletIntegracion.java                      #
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
#################################################################################
#                                                              Modificaciones   #
###############################################################################*/
package com.wellcom.prosa.Controladores;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

/**
 * Servlet implementation class ControllerServletIntegracion
 */
public class ControllerServletIntegracion extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private HttpSession session;
    String url;
    String rutaContext = "";
    private String sessionId;
    Validador value;
    ParametrosCompartidos pC = new ParametrosCompartidos();
    ViewerManager viewerManager;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServletIntegracion() {
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
            System.out.println("ControllerServletIntegracion session: " + this.sessionId);
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
                    System.out.println("Action Login ControllerServletIntegracion: " + action);
                    url = "/login.jsp";
                } //Comienzan reportes 
                //Reporte 0290
                else if (action.equals("SICMIR0290")) {
                    url = "/SICMIR0290Header.jsp";
                    System.err.println("los atributos CONTROLSERL: " + session.getAttributeNames().toString());
                } else if (action.equals("SICMIR0290Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String diaHabAnt = (String) session.getAttribute("diaHabAnt");

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
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                        try {
                            if (format.parse(initDate).compareTo(format.parse(diaHabAnt7)) > 0) {
                                System.out.println("valor:" + format.parse(initDate).compareTo(format.parse(diaHabAnt7)) + ":");
                                metodo = new ControllerMethod();
                                metodo.Oparticiones(initDate, endDate, session);
                                url = value.valida(session, initDate, endDate, "Sicmir0290");
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
                    }//sicmir0300
                } else if (action.equals("SICMIR0300")) {
                    url = "/SICMIR0300Header.jsp";
                } else if (action.equals("SICMIR0300Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String typeRech = request.getParameter("typeRech");
                    //String bancoAdq = request.getParameter("bancoAdq");
                    String[] bancoEmiArray = request.getParameterValues("bancoEmi");
                    String bancoEmi = "";
                    for (String banco : bancoEmiArray) {
                        if (!bancoEmi.equals("")) {
                            bancoEmi += ",";
                        }
                        bancoEmi += banco;
                    }
                    String[] tiposTxn = request.getParameterValues("tipoTxn");
                    String tipoTxnStr = "";
                    for (String tipoTxn : tiposTxn) {
                        if (!tipoTxnStr.equals("")) {
                            tipoTxnStr += ",";
                        }
                        tipoTxnStr += tipoTxn;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("tipoTxn", tipoTxnStr);
                    session.setAttribute("bancoEmi", bancoEmi);
                    try {
                        url = value.valida(session, initDate, endDate, "Sicmir0300");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //sicmir0301
                else if (action.equals("SICMIR0301")) {
                    url = "/SICMIR0301Header.jsp";
                } else if (action.equals("SICMIR0301Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String typeRech = request.getParameter("typeRech");
                    //String bancoAdq = request.getParameter("bancoAdq");
                    String[] bancoEmiArray = request.getParameterValues("bancoEmi");
                    String bancoEmi = "";
                    for (String banco : bancoEmiArray) {
                        if (!bancoEmi.equals("")) {
                            bancoEmi += ",";
                        }
                        bancoEmi += banco;
                    }
                    String[] tiposTxn = request.getParameterValues("tipoTxn");
                    String tipoTxnStr = "";
                    for (String tipoTxn : tiposTxn) {
                        if (!tipoTxnStr.equals("")) {
                            tipoTxnStr += ",";
                        }
                        tipoTxnStr += tipoTxn;
                    }

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("tipoTxn", tipoTxnStr);
                    session.setAttribute("bancoEmi", bancoEmi);
                    try {
                        url = value.valida(session, initDate, endDate, "Sicmir0301");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0420
                else if (action.equals("SICMIR0420")) {

                    url = "/SICMIR0420Header.jsp";
                } else if (action.equals("SICMIR0420Main")) {
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
                        url = value.valida(session, initDate, endDate, "Sicmir0420");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }

                } else if (action.equals("SICMIR0040")) {
                    url = "/SICMIR0040Header.jsp";
                } else if (action.equals("SICMIR0040Main")) {
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
                            url = "/reportsjsp/managerReports.jsp" + "?report=" + "Sicmir0040";
                            viewerManager.setUpViewer(this, request, response, url);
                            isAnswerReport = true;
                        } else {
                            url = "/fechasInvalidas.jsp?noPantalla=4";
                        }
                    } catch (Exception ex) {
                        throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                    }
                } //Reporte 0340
                else if (action.equals("SICMIR0340")) {
                    url = "/SICMIR0340Header.jsp";
                } else if (action.equals("SICMIR0340Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    //String proceso = request.getParameter("proceso");
                    String tipo = request.getParameter("tipo");

                    String[] bancolst = request.getParameterValues("banco");
                    String banco = "";
                    for (String banco1 : bancolst) {
                        if (!banco.equals("")) {
                            banco += ",";
                        }
                        banco += banco1;
                    }

                    String[] procesos = request.getParameterValues("proceso");
                    String proceso = "";
                    for (String proceso1 : procesos) {
                        if (!proceso.equals("")) {
                            proceso += "','";
                        }
                        proceso += proceso1;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("banco", banco);
                    session.setAttribute("proceso", proceso);
                    session.setAttribute("tipo", tipo);

                    url = "/reportsjsp/managerReports.jsp" + "?report=" + "Sicmir0340";
                    viewerManager.setUpViewer(this, request, response, url);
                    isAnswerReport = true;
                } // SICMIF0150
                else if (action.equals("SICMIF0150")) {
                    url = "/SICMIF0150Header.jsp";
                } else if (action.equals("SICMIF0150Main")) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String banco = request.getParameter("banco");
                    String btnLstTOC = request.getParameter("btnLstTOC");

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", banco);
                    if (btnLstTOC.equals("Detalle Tx Electro.")) {
                        session.setAttribute("tipo", "1");
                    } else if (btnLstTOC.equals("Total Tx Electro.")) {
                        session.setAttribute("tipo", "2");
                    } else if (btnLstTOC.equals("Detalle Tx Papel")) {
                        session.setAttribute("tipo", "3");
                    } else if (btnLstTOC.equals("Total Tx Papel")) {
                        session.setAttribute("tipo", "4");
                    } else if (btnLstTOC.equals("Contrecargos y Representaciones")) {
                        session.setAttribute("tipo", "5");
                    } else {
                        session.setAttribute("tipo", null);
                    }
                    try {
                        try {
                            if (format.parse(initDate).compareTo(format.parse(diaHabAnt7)) > 0) {
                                url = value.valida(session, initDate, endDate, "Sicmif0150");
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
                } //Reporte 0450
                else if (action.equals("SICMIR0450")) {
                    url = "/SICMIR0450Header.jsp";
                } else if (action.equals("SICMIR0450Main")) {
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
                        url = value.valida(session, initDate, endDate, "Sicmir0450");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (ParseException pe) {
                        pe.printStackTrace();
                    }
                } //Reporte 0450
                else if (action.equals("SICMIF0450")) {
                    url = "/SICMIF0450Header.jsp";
                } else if (action.equals("SICMIF0450Main")) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat formateo2 = new SimpleDateFormat("yyMMdd");
                    String inicial = request.getParameter("txtfStartDate");
                    String adq = request.getParameter("adq");
                    if (adq.length() < 2) {
                        adq = "0" + adq;
                        //System.out.println("Variable adq es " + adq );
                    }
                    try {
                        session.setAttribute("adq", adq);
                        //inicial = format.format(TimeUtils.getDiaNatAnt(session, format.parse(inicial)));
                        String inicial2 = formateo2.format(formateo.parse(inicial));
                        session.setAttribute("initDate", inicial2);

                        //String sFichero = "C:\\probancr\\EditPackage\\POSRE_"+inicial2+"_"+adq;
                        //Ruta anteior String sFichero = "//aplic//prod//pmt//pmr//epg//POSRE_"+inicial2+"_"+adq;
                        String sFichero = "//aplic//prod//pmt//pmr//pr4//POSRE_" + inicial2 + "_" + adq;
                        System.out.println("Variable fichero es " + sFichero);
                        File fichero = new File(sFichero);

                        if (fichero.exists()) {
                            System.out.println("El fichero " + sFichero + " existe");
                            url = "/reportsjsp/managerReports.jsp" + "?report=" + "SICMIF0450";
                            viewerManager.setUpViewer(this, request, response, url);
                            isAnswerReport = true;
                        } else {
                            url = "/reportsjsp/Error.jsp";
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } //Reporte SICLIR0300
                else if (action.equals("SICLIR0300")) {
                    url = "/SICLIR0300Header.jsp";
                } else if (action.equals("SICLIR0300Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String[] AdquirenteArreglo = request.getParameterValues("bancoAdq");
                    String endDate = request.getParameter("txtfEndDate");
                    String AdquirenteStr = "";
                    for (String bancoAdq : AdquirenteArreglo) {
                        if (!AdquirenteStr.equals("")) {
                            AdquirenteStr += ",";
                        }
                        AdquirenteStr += bancoAdq;

                    }
                    String[] EmisorArreglo = request.getParameterValues("tipoTransac");
                    String EmisorStr = "";
                    for (String tipoTransac : EmisorArreglo) {
                        if (!EmisorStr.equals("")) {
                            EmisorStr += ",";
                        }
                        EmisorStr += tipoTransac;
                    }
                    String[] archivoEntradaArreglo = request.getParameter("archivoEntrada_OK").split(",");
                    String archivontradaSrt = "";
                    for (String entrada : archivoEntradaArreglo) {
                        if (!archivontradaSrt.equals("")) {
                            archivontradaSrt += ",";
                        }
                        archivontradaSrt += entrada;
                    }
                    String[] archivoSalidaArreglo = request.getParameter("archivoSalida_OK").split(",");
                    String archivoSalidaSrt = "";
                    for (String salida : archivoSalidaArreglo) {
                        if (!archivoSalidaSrt.equals("")) {
                            archivoSalidaSrt += ",";
                        }
                        archivoSalidaSrt += salida;
                    }
                    session.setAttribute("initDate", initDate);
                    session.setAttribute("endDate", endDate);
                    session.setAttribute("bancoAdq", AdquirenteStr);
                    session.setAttribute("tipoTransac", EmisorStr);
                    session.setAttribute("salida", archivoSalidaSrt);
                    session.setAttribute("entrada", archivontradaSrt);
                    try {
                        url = value.valida(session, initDate, endDate, "Siclir0300");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                }//Reporte SICLIR0400        
                else if (action.equals("SICLIR0400")) {
                    url = "/SICLIR0400Header.jsp";
                } else if (action.equals("SICLIR0400Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String[] EmisoraArreglo = request.getParameterValues("bancoEmi");
                    String endDate = request.getParameter("txtfEndDate");
                    String EmisoraStr = "";
                    for (String bancoEmi : EmisoraArreglo) {
                        if (!EmisoraStr.equals("")) {
                            EmisoraStr += ",";
                        }
                        EmisoraStr += bancoEmi;
                    }
                    String[] EmisorArreglo = request.getParameterValues("tipoTransac");
                    String EmisorStr = "";
                    for (String tipoTransac : EmisorArreglo) {
                        if (!EmisorStr.equals("")) {
                            EmisorStr += ",";
                        }
                        EmisorStr += tipoTransac;
                    }
                    String[] archivoEntradaArreglo = request.getParameter("archivoEntrada_OK").split(",");
                    String archivontradaSrt = "";
                    for (String entrada : archivoEntradaArreglo) {
                        if (!archivontradaSrt.equals("")) {
                            archivontradaSrt += ",";
                        }
                        archivontradaSrt += entrada;
                    }
                    String[] archivoSalidaArreglo = request.getParameter("archivoSalida_OK").split(",");
                    String archivoSalidaSrt = "";
                    for (String salida : archivoSalidaArreglo) {
                        if (!archivoSalidaSrt.equals("")) {
                            archivoSalidaSrt += ",";
                        }
                        archivoSalidaSrt += salida;
                    }
                    session.setAttribute("initDate", initDate);
                    session.setAttribute("endDate", endDate);
                    session.setAttribute("bancoEmi", EmisoraStr);
                    session.setAttribute("tipoTransac", EmisorStr);
                    session.setAttribute("salida", archivoSalidaSrt);
                    session.setAttribute("entrada", archivontradaSrt);
                    try {
                        url = value.valida(session, initDate, endDate, "Siclir0400");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } else if (action.equals("repTipoTransfer")) {
                    url = "/SICMIR0130.jsp";
                }//Reporte SICMIR0054
                else if (action.equals("SICMIR0054")) {
                    url = "/SICMIR0054Header.jsp";
                } else if (action.equals("SICMIR0054Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String[] bancoEmiArray = request.getParameterValues("bancoEmi");
                    String[] archivos = request.getParameterValues("archivoEmi");
                    String bancoEmi = "";
                    for (String banco : bancoEmiArray) {
                        if (!bancoEmi.equals("")) {
                            bancoEmi += ",";
                        }
                        bancoEmi += banco;
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
                    session.setAttribute("bancoEmi", bancoEmi);
                    session.setAttribute("archivoEmi", archivo);

                    try {
                        url = value.valida(session, initDate, endDate, "Sicmir0054");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Terminan los  reportes 
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
        {
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
        }
        return retorno;
    }

}
