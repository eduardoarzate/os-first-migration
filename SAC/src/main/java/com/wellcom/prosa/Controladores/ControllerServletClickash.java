/*###############################################################################
# Nombre del Programa :  ControllerServletClickash.java                         #
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
import com.wellcom.prosa.sacii.RptUtils;
import java.util.logging.Logger;
import java.io.IOException;
import java.text.ParseException;

/**
 * Servlet implementation class ControllerServletClickash
 */
public class ControllerServletClickash extends HttpServlet {

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
    public ControllerServletClickash() {
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
            System.out.println("ControllerServletClickash session: " + this.sessionId);
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
                    System.out.println("Action Login ControllerServletClickash: " + action);
                    url = "/login.jsp";
                } else if (action.equals("index")) {
                    System.out.println("Atributo Inicio " + session.getAttribute("inicio"));
                    System.out.println("Action Index Liq:" + action);
                    try {
                        if (session.getAttribute("inicio") == null || session.getAttribute("inicio").equals("true")) {
                            fiidManager inicia = new fiidManager();
                            inicia.NumeroProsa(session);
                            session.setAttribute("inicio", "false");
                        }
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                    String rolSesion = (String) session.getAttribute("role").toString();
                    String est = "";
                    new Mantenimiento();
                    est = Mantenimiento.leeEstado("aplicacion", rutaContext);
                    if (est.equals("2") && rolSesion != "administrador") {
                        url = "/indexman.jsp";
                    } else {
                        url = "/index.jsp";
                    }

                } else if (action.equals("Salir")) {
                    System.out.println("Action Salir :");
                    //session.invalidate();
                    session.setAttribute("grantAccess", "false");
                    url = "/login.jsp";
                }//Comienzan reportes 
                else if (action.equals("Mxvrtda001")) {

                    url = "/reportsjsp/CCA/Mxvrtda001Header.jsp";
                } else if (action.equals("Mxvrtda001Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String[] AdquirenteArreglo = request.getParameterValues("Adquirente");
                    String tasaMxvrtda = (request.getParameter("tasaMxvrtda") == null ? "false" : "true");
                    String AdquirenteStr = "";
                    for (String Adquirente : AdquirenteArreglo) {
                        if (!AdquirenteStr.equals("")) {
                            AdquirenteStr += ",";
                        }
                        AdquirenteStr += Adquirente;
                    }
                    String[] EmisorArreglo = request.getParameterValues("Emisor");
                    String EmisorStr = "";
                    for (String Emisor : EmisorArreglo) {
                        if (!EmisorStr.equals("")) {
                            EmisorStr += ",";
                        }
                        EmisorStr += Emisor;
                    }
                    session.setAttribute("tasaMxvrtda", tasaMxvrtda);
                    session.setAttribute("initDate", initDate);
                    session.setAttribute("endDate", endDate);
                    session.setAttribute("Adquiriente", AdquirenteStr);
                    session.setAttribute("Emisor", EmisorStr);

                    try {
                        url = value.valida(session, initDate, endDate, "Mxvrtda001");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }

                } // Reporte Mxvrtac001
                else if (action.equals("Mxvrtac001")) {
                    url = "/reportsjsp/CCA/Mxvrtac001Header.jsp";
                } else if (action.equals("Mxvrtac001Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String[] AdquirenteArreglo = request.getParameterValues("Adquirente");
                    String tasaMxvrtac = (request.getParameter("tasaMxvrtac") == null ? "false" : "true");
                    String AdquirenteStr = "";
                    for (String Adquirente : AdquirenteArreglo) {
                        if (!AdquirenteStr.equals("")) {
                            AdquirenteStr += ",";
                        }
                        AdquirenteStr += Adquirente;
                    }
                    String[] EmisorArreglo = request.getParameterValues("Emisor");
                    String EmisorStr = "";
                    for (String Emisor : EmisorArreglo) {
                        if (!EmisorStr.equals("")) {
                            EmisorStr += ",";
                        }
                        EmisorStr += Emisor;
                    }
                    session.setAttribute("tasaMxvrtac", tasaMxvrtac);
                    session.setAttribute("initDate", initDate);
                    session.setAttribute("endDate", endDate);
                    session.setAttribute("Adquiriente", AdquirenteStr);
                    session.setAttribute("Emisor", EmisorStr);
                    try {
                        url = value.valida(session, initDate, endDate, "Mxvrtac001");
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
