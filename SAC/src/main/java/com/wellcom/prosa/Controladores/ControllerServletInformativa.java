/*###############################################################################
# Nombre del Programa :  ControllerServletInformativa.java                      #
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 27/01/2017         #
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
import com.wellcom.prosa.sacii.RptUtils;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.logging.Logger;

/**
 * Servlet implementation class ControllerServletInformativa
 */
public class ControllerServletInformativa extends HttpServlet {

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
    public ControllerServletInformativa() {
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
            System.out.println("ControllerServletInformativa session: " + this.sessionId);
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
        Logger logger = null;
        ControllerMethod metodo = null;
        try {
            if (action != null) {
                if (action.equals("login")) {
                    //session.invalidate();
                    System.out.println("Action Login ControllerServletInformativa: " + action);
                    url = "/login.jsp";
                }//Reporte SICLIRI050
                else if (action.equals("SICLIRI050")) {
                    url = "/SICLIRI050Header.jsp";
                } else if (action.equals("SICLIRI050Main")) {
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
                        url = value.valida(session, initDate, endDate, "Sicliri050");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (ParseException pe) {
                        pe.printStackTrace();
                    }
                } //Reporte SICLIRI060
                else if (action.equals("SICLIRI060")) {
                    url = "/SICLIRI060Header.jsp";
                } else if (action.equals("SICLIRI060Main")) {
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
                        url = value.valida(session, initDate, endDate, "Sicliri060");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (ParseException pe) {
                        pe.printStackTrace();
                    }
                } //Reporte SICLILRI077
                else if (action.equals("SICLIRI077")) {
                    url = "/SICLIRI077Header.jsp";
                } else if (action.equals("SICLIRI077Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String natCont = request.getParameter("natCont");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("natCont", natCont);
                    try {
                        url = value.valida(session, initDate, endDate, "Sicliri077");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte SICLIRI087
                else if (action.equals("SICLIRI087")) {
                    url = "/SICLIRI087Header.jsp";
                } else if (action.equals("SICLIRI087Main")) {
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
                        url = value.valida(session, initDate, endDate, "Sicliri087");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (ParseException pe) {
                        pe.printStackTrace();
                    }
                } //Reporte SICLIRI360
                else if (action.equals("SICLIRI360")) {
                    url = "/SICLIRI360Header.jsp";
                } else if (action.equals("SICLIRI360Main")) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String tipoes = request.getParameter("tipoES");
                    String[] bancoArray = request.getParameterValues("banco");
                    String banco = "";
                    for (String bancoFor : bancoArray) {
                        if (!banco.equals("")) {
                            banco += ",";
                        }
                        banco += bancoFor;
                    }
                    String[] tipoProcArray = request.getParameterValues("tipoProc");
                    String tipoProc = "";
                    for (String tipoProcTmp : tipoProcArray) {
                        if (!tipoProc.equals("")) {
                            tipoProc += ",";
                        }
                        tipoProc += tipoProcTmp;
                    }
                    String agrTotales = request.getParameter("agrTotales");
                    if (agrTotales == null) {
                        agrTotales = "false";
                    } else {
                        agrTotales = "true";
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", banco);
                    session.setAttribute("tipoProc", tipoProc);
                    session.setAttribute("tipoes", tipoes);
                    session.setAttribute("agrTotales", agrTotales);

                    try {
                        String initDateHabAnt = format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate)));
                        String endDateHabAnt = format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate)));
                        metodo = new ControllerMethod();
                        try {
                            if (format.parse(initDate).compareTo(format.parse(diaHabAnt7)) > 0) {
                                metodo.Oparticioneshabant(initDate, endDate, initDateHabAnt, endDateHabAnt, session);
                                url = value.valida(session, initDate, endDate, "Sicliri360");
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
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } //Reporte SICLIRI020
                else if (action.equals("SICLIRI020")) {
                    url = "/SICLIRI020Header.jsp";
                } else if (action.equals("SICLIRI020Main")) {
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
                        url = value.valida(session, initDate, endDate, "Sicliri020");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte SICLIRI030
                else if (action.equals("SICLIRI030")) {
                    url = "/SICLIRI030Header.jsp";
                } else if (action.equals("SICLIRI030Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);

                    try {
                        url = value.valida(session, initDate, endDate, "Sicliri030");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte SICLIRI040
                else if (action.equals("SICLIRI040")) {
                    url = "/SICLIRI040Header.jsp";
                } else if (action.equals("SICLIRI040Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);

                    try {
                        metodo = new ControllerMethod();
                        metodo.Oparticionesdiaant(initDate, endDate, initDate, endDate, session);
                        url = value.valida(session, initDate, endDate, "Sicliri040");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte SICLIRI110
                else if (action.equals("SICLIRI110")) {
                    url = "/SICLIRI110Header.jsp";
                } else if (action.equals("SICLIRI110Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
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
                        url = value.valida(session, initDate, endDate, "Sicliri110");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte SICLIRI120
                else if (action.equals("SICLIRI120")) {
                    url = "/SICLIRI120Header.jsp";
                } else if (action.equals("SICLIRI120Main")) {
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
                        url = value.valida(session, initDate, endDate, "Sicliri120");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte SICLIRI130
                else if (action.equals("SICLIRI130")) {
                    url = "/SICLIRI130Header.jsp";
                } else if (action.equals("SICLIRI130Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    try {
                        url = value.valida(session, initDate, endDate, "Sicliri130");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte SICLIRI140
                else if (action.equals("SICLIRI140")) {
                    url = "/SICLIRI140Header.jsp";
                } else if (action.equals("SICLIRI140Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    try {
                        url = value.valida(session, initDate, endDate, "Sicliri140");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte SICMORI360
                else if (action.equals("SICMORI360")) {
                    url = "/SICMORI360Header.jsp";
                } else if (action.equals("SICMORI360Main")) {
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
                                url = value.valida(session, initDate, endDate, "Sicmori360");
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
                } //Reporte SICLIFI060
                else if (action.equals("SICLIFI060")) {
                    url = "/SICLIFI060Header.jsp";
                } else if (action.equals("SICLIFI060Main")) {
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
                        metodo = new ControllerMethod();
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        session.setAttribute("initDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                        session.setAttribute("endDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                        metodo.Oparticionesdiaant(initDate, endDate, initDate, endDate, session);
                        url = value.valida(session, initDate, endDate, "Siclifi060");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } //Reporte SICLIRI200
                else if (action.equals("SICLIRI200")) {
                    url = "/SICLIRI200Header.jsp";
                } else if (action.equals("SICLIRI200Main")) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
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
                        session.setAttribute("txtfStartDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                        session.setAttribute("txtfEndDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                        url = value.valida(session, initDate, endDate, "Sicliri200");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (ParseException pe) {
                        pe.printStackTrace();
                    }
                } //Reporte I320
                else if (action.equals("SICLIRI320")) {
                    url = "/SICLIRI320Header.jsp";
                } else if (action.equals("SICLIRI320Main")) {
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
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("tipoLiq", tipoLiqStr);
                    try {
                        session.setAttribute("initDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                        session.setAttribute("endDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                        url = value.valida(session, initDate, endDate, "Sicliri320");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } //------------------------Reportes comentados en el XML REPORTES
                //Reporte SICLIRI150
                else if (action.equals("SICLIRI150")) {
                    url = "/SICLIRI150Header.jsp";
                } else if (action.equals("SICLIRI150Main")) {
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
                        url = value.valida(session, initDate, endDate, "Sicliri150");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte SICLIFI065
                else if (action.equals("SICLIFI065")) {
                    url = "/SICLIFI065Header.jsp";
                } else if (action.equals("SICLIFI065Main")) {
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
                        metodo = new ControllerMethod();
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        session.setAttribute("initDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                        session.setAttribute("endDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                        metodo.Oparticionesdiaant(initDate, endDate, initDate, endDate, session);
                        url = value.valida(session, initDate, endDate, "Siclifi065");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
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
