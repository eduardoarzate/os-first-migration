/*###############################################################################
# Nombre del Programa :  ControllerServletDCC.java                              #
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
#################################################################################
#                                                              Modificaciones   #
#-------------------------------------------------------------------------------#
# Modificacion        :  Mejora Reporteador  SAC2                               #
# Proyecto/Procliente :  D-52-8122-17                 Fecha: 10/07/2017         #
#                                                                               #
#                                                                               #
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
import com.wellcom.prosa.sacii.RptUtils;
import java.util.logging.Logger;

/**
 * Servlet implementation class ControllerServletDCC
 */
public class ControllerServletDCC extends HttpServlet {

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
    public ControllerServletDCC() {
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
        action = "login";
        this.session = request.getSession(false);
        if (this.session != null && this.session.getAttribute("activo") != null) {
            action = request.getParameter("action");
            System.out.println("Action : " + action);

            this.sessionId = session.getId();
            System.out.println("ControllerServletDCC session: " + this.sessionId);
            this.session.setMaxInactiveInterval(2400);

            session.setAttribute("rutaContext", rutaContext);
            String posicion = request.getParameter("p");
            posicion = Posicion(posicion);

            session.setAttribute("pos", posicion);
            value = new Validador();
            if (session.getAttribute("viewerManager") == null) {
                viewerManager = new ViewerManager();
                session.setAttribute("viewerManager", viewerManager);
            } else {
                viewerManager = (ViewerManager) session.getAttribute("viewerManager");
            }
            java.util.Date fechaAnterior = new java.util.Date();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date fechaActual = new java.util.Date();
            fechaHoy = formato.format(fechaActual);
            session.setAttribute("fechaHoy", fechaHoy);
        }
        Logger logger = null;
        ControllerMethod metodo = null;
        try {
            if (action != null) {
                if (action.equals("login")) {
                    //session.invalidate();
                    System.out.println("Action Login ControllerServletDCC: " + action);
                    url = "/login.jsp";
                }//Comienzan reportes 
                else if (action.equals("SICDCC0010")) {
                    url = "/SICDCC0010Header.jsp";
                } else if (action.equals("SICDCC0010Main")) {
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
                    /* Inicia modificacion wellcom D-52-8122-17 10-07-2017*/
                    session.setAttribute("txtfStartDate", initDate);
                    /* Fin modificacion wellcom D-52-8122-17 10-07-2017*/
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosSocios);
                    try {
                        url = value.valida(session, initDate, endDate, "SICDCC0010");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } else if (action.equals("SICDCC0020")) {
                    url = "/SICDCC0020Header.jsp";
                } else if (action.equals("SICDCC0020Main")) {
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
                        url = value.valida(session, initDate, endDate, "SICDCC0020");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte DCC0030
                else if (action.equals("SICDCC0030")) {
                    url = "/SICDCC0030Header.jsp";
                } else if (action.equals("SICDCC0030Main")) {
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
                        url = value.valida(session, initDate, endDate, "SICDCC0030");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte DCC0040
                else if (action.equals("SICDCC0040")) {
                    url = "/SICDCC0040Header.jsp";
                } else if (action.equals("SICDCC0040Main")) {
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
                        url = value.valida(session, initDate, endDate, "SICDCC0040");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte DCC0060
                else if (action.equals("SICDCC0060")) {
                    url = "/SICDCC0060Header.jsp";
                } else if (action.equals("SICDCC0060Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String tipo = request.getParameter("tipo");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("tipo", tipo);
                    try {
                        url = value.valida(session, initDate, endDate, "SICDCC0060");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                }//Reporte DCC0070
                else if (action.equals("SICDCC0070")) {
                    url = "/SICDCC0070Header.jsp";
                } else if (action.equals("SICDCC0070Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String mapr = request.getParameter("mapr");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("mapr", mapr);
                    try {
                        url = value.valida(session, initDate, endDate, "SICDCC0070");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte DCC0080
                else if (action.equals("SICDCC0080")) {
                    url = "/SICDCC0080Header.jsp";
                } else if (action.equals("SICDCC0080Main")) {
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
                        url = value.valida(session, initDate, endDate, "SICDCC0080");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte DCC0090
                else if (action.equals("SICDCC0090")) {
                    url = "/SICDCC0090Header.jsp";
                } else if (action.equals("SICDCC0090Main")) {
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
                        url = value.valida(session, initDate, endDate, "SICDCC0090");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte DCC0100
                else if (action.equals("SICDCC0100")) {
                    url = "/SICDCC0100Header.jsp";
                } else if (action.equals("SICDCC0100Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String[] bancoSocioArray = request.getParameterValues("banco");
                    String bancosSocios = "";
                    String fuente = request.getParameter("fuente");
                    String ttr = request.getParameter("ttr");
                    for (String banco : bancoSocioArray) {
                        if (!bancosSocios.equals("")) {
                            bancosSocios += ",";
                        }
                        bancosSocios += banco;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosSocios);
                    session.setAttribute("fuente", fuente);
                    session.setAttribute("ttr", ttr);
                    try {
                        url = value.valida(session, initDate, endDate, "SICDCC0100");
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
