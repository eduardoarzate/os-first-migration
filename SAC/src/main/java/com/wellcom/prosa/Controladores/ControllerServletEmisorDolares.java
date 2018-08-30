/*###############################################################################
# Nombre del Programa :  ControllerServletEmisorDolares.java                    #
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
import com.wellcom.exceptions.WellException;
import com.wellcom.struts.*;
import com.wellcom.beans.*;
import com.wellcom.dao.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.wellcom.prosa.sacii.RptUtils;

import java.util.logging.Logger;

/**
 * Servlet implementation class ControllerServletEmisorDolares
 */
public class ControllerServletEmisorDolares extends HttpServlet {

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
    public ControllerServletEmisorDolares() {
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
            System.out.println("ControllerServletEmisorDolares session: " + this.sessionId);
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
                    System.out.println("Action Login ControllerServletEmisorDolares: " + action);
                    url = "/login.jsp";
                } else if (action.equals("SICMORD210")) {
                    url = "/SICMORD210Header.jsp";
                } else if (action.equals("SICMORD210Main")) {
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
                        url = value.valida(session, initDate, endDate, "Sicmord210");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte D310
                else if (action.equals("SICLIRD310")) {
                    url = "/SICLIRD310Header.jsp";
                } else if (action.equals("SICLIRD310Main")) {
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
                        url = value.valida(session, initDate, endDate, "Siclird310");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte D280
                else if (action.equals("SICMORD280")) {
                    url = "/SICMORD280Header.jsp";
                } else if (action.equals("SICMORD280Main")) {
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
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoSocio", bancosSocios);
                    try {
                        url = value.valida(session, initDate, endDate, "Sicmord280");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } else if (action.equals("SICLIRD020")) {
                    url = "/SICLIRD020Header.jsp";
                } else if (action.equals("SICLIRD020Main")) {
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
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoSocio", bancosSocios);
                    try {
                        url = value.valida(session, initDate, endDate, "Siclird020");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } else if (action.equals("SICLIRD030")) {
                    url = "/SICLIRD030Header.jsp";
                } else if (action.equals("SICLIRD030Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    try {
                        metodo = new ControllerMethod();
                        metodo.Oparticionesdiaant(initDate, endDate, initDate, endDate, session);
                        url = value.valida(session, initDate, endDate, "Siclird030");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte D040
                else if (action.equals("SICLIRD040")) {
                    url = "/SICLIRD040Header.jsp";
                } else if (action.equals("SICLIRD040Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);

                    try {
                        url = value.valida(session, initDate, endDate, "Siclird040");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte D050
                else if (action.equals("SICLIRD050")) {
                    url = "/SICLIRD050Header.jsp";
                } else if (action.equals("SICLIRD050Main")) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String agrupacion = request.getParameter("agrupacion");
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
                    session.setAttribute("agrupacion", agrupacion);
                    try {
                        session.setAttribute("txtfStartDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                        session.setAttribute("txtfEndDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                        url = value.valida(session, initDate, endDate, "Siclird050");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (ParseException pe) {
                        pe.printStackTrace();
                    }
                } //Reporte D060
                else if (action.equals("SICLIRD060")) {
                    url = "/SICLIRD060Header.jsp";
                } else if (action.equals("SICLIRD060Main")) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
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
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosStr);

                    try {
                        session.setAttribute("txtfStartDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                        session.setAttribute("txtfEndDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                        url = value.valida(session, initDate, endDate, "Siclird060");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (ParseException pe) {
                        pe.printStackTrace();
                    }
                } //Reporte SICLIRD077
                else if (action.equals("SICLIRD077")) {
                    url = "/SICLIRD077Header.jsp";
                } else if (action.equals("SICLIRD077Main")) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String natCont = request.getParameter("natCont");

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("natCont", natCont);

                    try {
                        url = value.valida(session, initDate, endDate, "Siclird077");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte D087
                else if (action.equals("SICLIRD087")) {
                    url = "/SICLIRD087Header.jsp";
                } else if (action.equals("SICLIRD087Main")) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String natCont = request.getParameter("natCont");

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("natCont", natCont);

                    try {
                        session.setAttribute("txtfStartDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                        session.setAttribute("txtfEndDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                        url = value.valida(session, initDate, endDate, "Siclird087");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (ParseException pe) {
                        pe.printStackTrace();
                    }
                } //Reporte D110
                else if (action.equals("SICLIRD110")) {
                    url = "/SICLIRD110Header.jsp";
                } else if (action.equals("SICLIRD110Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoEmi = request.getParameter("bancoEmi");
                    String[] bancoEmiArray = request.getParameterValues("bancoEmi");
                    String bancosEmi = "";
                    for (String banco : bancoEmiArray) {
                        if (!bancosEmi.equals("")) {
                            bancosEmi += ",";
                        }
                        bancosEmi += banco;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoEmi", bancosEmi);
                    try {
                        url = value.valida(session, initDate, endDate, "Siclird110");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte SICLIRD120
                else if (action.equals("SICLIRD120")) {
                    url = "/SICLIRD120Header.jsp";
                } else if (action.equals("SICLIRD120Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String[] interredes = request.getParameterValues("interred");
                    String[] divisiones = request.getParameterValues("division");
                    String interredesStr = "";
                    for (String interred : interredes) {
                        if (!interredesStr.equals("")) {
                            interredesStr += ",";
                        }
                        interredesStr += interred;
                    }
                    String divisionesStr = "";
                    for (String division : divisiones) {
                        if (!divisionesStr.equals("")) {
                            divisionesStr += ",";
                        }
                        divisionesStr += division;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("interred", interredesStr);
                    session.setAttribute("division", divisionesStr);
                    try {
                        url = value.valida(session, initDate, endDate, "Siclird120");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte D130
                else if (action.equals("SICLIRD130")) {
                    url = "/SICLIRD130Header.jsp";
                } else if (action.equals("SICLIRD130Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    try {
                        url = value.valida(session, initDate, endDate, "Siclird130");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte D140
                else if (action.equals("SICLIRD140")) {
                    url = "/SICLIRD140Header.jsp";
                } else if (action.equals("SICLIRD140Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    try {
                        url = value.valida(session, initDate, endDate, "Siclird140");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte SICMORD360
                else if (action.equals("SICMORD360")) {
                    url = "/SICMORD360Header.jsp";
                } else if (action.equals("SICMORD360Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String diaHabAnt = (String) session.getAttribute("diaHabAnt");

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
                    String[] tipoTransArray = request.getParameterValues("tipoTrans");
                    String tipoTrans = "";
                    for (String tipo : tipoTransArray) {
                        if (!tipoTrans.equals("")) {
                            tipoTrans += ",";
                        }
                        tipoTrans += tipo;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancoAdq);
                    session.setAttribute("bancoEmi", bancoEmi);
                    session.setAttribute("tipoTrans", tipoTrans);
                    try {
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        try {
                            if (format.parse(initDate).compareTo(format.parse(diaHabAnt7)) > 0) {
                                metodo = new ControllerMethod();
                                metodo.Oparticiones(initDate, endDate, session);
                                url = value.valida(session, initDate, endDate, "Sicmord360");
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
                } else if (action.equals("SICMIRD121")) {
                    url = "/SICMIRD121Header.jsp";
                } else if (action.equals("SICMIRD121Main")) {
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
                        url = value.valida(session, initDate, endDate, "Sicmird121");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0122
                else if (action.equals("SICMIRD122")) {
                    url = "/SICMIRD122Header.jsp";
                } else if (action.equals("SICMIRD122Main")) {
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
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoSocio", bancosSocios);
                    try {
                        url = value.valida(session, initDate, endDate, "Sicmird122");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte MIRD370
                else if (action.equals("SICMIRD370")) {
                    url = "/SICMIRD370Header.jsp";
                } else if (action.equals("SICMIRD370Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String[] bancoSocioArray = request.getParameterValues("banco");
                    String bancosSocios = "";
                    for (String banco : bancoSocioArray) {
                        if (!bancosSocios.equals("")) {
                            bancosSocios += ",";
                        }
                        bancosSocios += banco;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosSocios);
                    try {
                        url = value.valida(session, initDate, endDate, "Sicmird370");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte SICLIRD150
                else if (action.equals("SICLIRD150")) {
                    url = "/SICLIRD150Header.jsp";
                } else if (action.equals("SICLIRD150Main")) {
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
                        url = value.valida(session, initDate, endDate, "Siclird150");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } // SICLIRD170
                else if (action.equals("SICLIRD170")) {
                    url = "/SICLIRD170Header.jsp";
                } else if (action.equals("SICLIRD170Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String moneda = request.getParameter("moneda");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("moneda", moneda);

                    try {
                        url = value.valida(session, initDate, endDate, "Siclird170");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte D180
                else if (action.equals("SICLIRD180")) {
                    url = "/SICLIRD180Header.jsp";
                } else if (action.equals("SICLIRD180Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    try {
                        url = value.valida(session, initDate, endDate, "Siclird180");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte SICLIFD060
                else if (action.equals("SICLIFD060")) {

                    url = "/SICLIFD060Header.jsp";
                } else if (action.equals("SICLIFD060Main")) {
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
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosStr);

                    try {
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        session.setAttribute("initDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                        session.setAttribute("endDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                        metodo = new ControllerMethod();
                        metodo.Oparticionesdiaant(initDate, endDate, initDate, endDate, session);
                        url = value.valida(session, initDate, endDate, "Siclifd060");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } //Reporte D200
                else if (action.equals("SICLIRD200")) {
                    url = "/SICLIRD200Header.jsp";
                } else if (action.equals("SICLIRD200Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoAdquiriente = request.getParameter("bancoAdquiriente");
                    String[] bancosAdq = request.getParameterValues("bancoAdquiriente");
                    String bancosAdqStr = "";
                    for (String bancoAdqr : bancosAdq) {
                        if (!bancosAdqStr.equals("")) {
                            bancosAdqStr += ",";
                        }
                        bancosAdqStr += bancoAdqr;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdquiriente", bancosAdqStr);

                    try {
                        url = value.valida(session, initDate, endDate, "Siclird200");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte D320
                else if (action.equals("SICLIRD320")) {
                    url = "/SICLIRD320Header.jsp";
                } else if (action.equals("SICLIRD320Main")) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String[] tipoLiq = request.getParameterValues("tipoLiq");
                    String tipoLiqStr = "";
                    for (String tipoL : tipoLiq) {
                        if (!tipoLiqStr.equals("")) {
                            tipoLiqStr += ",";
                        }
                        tipoLiqStr += tipoL;
                    }
                    if (tipoLiqStr.contains("21")) {
                        tipoLiqStr += ",27";
                    }

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("tipoLiq", tipoLiqStr);
                    try {
                        session.setAttribute("initDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                        session.setAttribute("endDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                        url = value.valida(session, initDate, endDate, "Siclird320");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } //Fin reportes 
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
