/*###############################################################################
# Nombre del Programa :  ControllerServletVentaTA.java                          #
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
 * Servlet implementation class ControllerServletVentaTA
 */
public class ControllerServletVentaTA extends HttpServlet {

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
    public ControllerServletVentaTA() {
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
            System.out.println("ControllerServletVentaTA session: " + this.sessionId);
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
                    System.out.println("Action Login ControllerServletVentaTA: " + action);
                    url = "/login.jsp";
                } //Comienzan reportes 
                //repvtDetAdq reporte detalle adquiriente
                else if (action.equals("repvtDetAdq")) {
                    url = "/repvtDetAdq_Header.jsp";
                } else if (action.equals("XXXXrepvtDetAdq")) {
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
                    session.setAttribute("initDate", initDate);
                    session.setAttribute("endDate", endDate);
                    session.setAttribute("Adquiriente", bancosStr);
                    try {
                        url = value.valida(session, initDate, endDate, "reporteAdquirienteDetalle");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } // fin repvtDetAdq reporte detalle adquiriente
                // incio reporte Telefonica detalle
                else if (action.equals("repvtDetTel")) {
                    url = "/repvtDetTel_Header.jsp";
                } else if (action.equals("XXXXrepvtDetTel")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String[] bancos = request.getParameterValues("telefonica");
                    String bancosStr = "";
                    for (String banco : bancos) {
                        if (!bancosStr.equals("")) {
                            bancosStr += ",";
                        }
                        bancosStr += banco;
                    }
                    session.setAttribute("initDate", initDate);
                    session.setAttribute("endDate", endDate);
                    session.setAttribute("Telefonica", bancosStr);
                    try {
                        url = value.valida(session, initDate, endDate, "reporteTelefonicaDetalle");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //  inicio reporte distribuidor detalle
                else if (action.equals("repvtDetDis")) {
                    url = "/repvtDetDis_Header.jsp";
                } else if (action.equals("XXXXrepvtDetDis")) {
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
                    session.setAttribute("initDate", initDate);
                    session.setAttribute("endDate", endDate);
                    session.setAttribute("Distribuidor", bancosStr);
                    try {
                        url = value.valida(session, initDate, endDate, "reporteDistribuidorDetalle");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } // fin reporte distribuidor detalle
                // inicio adquiriente acumulado
                else if (action.equals("repvtAcuAdq")) {
                    url = "/repvtAcuAdq_Header.jsp";
                } else if (action.equals("XXXXrepvtAcuAdq")) {
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
                    session.setAttribute("initDate", initDate);
                    session.setAttribute("endDate", endDate);
                    session.setAttribute("Adquiriente", bancosStr);
                    try {
                        url = value.valida(session, initDate, endDate, "reporteAcumuladoAdquiriente");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } // fin adquiriente acumulado
                //inicio telefonica acumulado
                else if (action.equals("repvtAcuTel")) {
                    url = "/repvtAcuTel_Header.jsp";
                } else if (action.equals("XXXXrepvtAcuTel")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String[] telefonica = request.getParameterValues("banco");
                    String telefonicaStr = "";
                    for (String banco : telefonica) {
                        if (!telefonicaStr.equals("")) {
                            telefonicaStr += ",";
                        }
                        telefonicaStr += banco;
                    }
                    session.setAttribute("initDate", initDate);
                    session.setAttribute("endDate", endDate);
                    session.setAttribute("Telefonica", telefonicaStr);
                    try {
                        url = value.valida(session, initDate, endDate, "reporteAcumuladoTelefonica");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //  fin telefonica acumulado
                //  inicio distribuidor acumulado
                else if (action.equals("repvtAcuDis")) {
                    url = "/repvtAcuDis_Header.jsp";
                } else if (action.equals("XXXXrepvtAcuDis")) {
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
                    session.setAttribute("initDate", initDate);
                    session.setAttribute("endDate", endDate);
                    session.setAttribute("Distribuidor", bancosStr);
                    try {
                        url = value.valida(session, initDate, endDate, "reporteAcumuladoDistribuidor");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } // fin de distribudor acumulado
                // inicio distribuidor acumulado Tipo pago
                else if (action.equals("repvtAcuDisTipoPago")) {
                    url = "/repvtAcuDis_Header_Tipo_Pago.jsp";
                } else if (action.equals("XXXXrepvtAcuDisTipoPago")) {
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
                    session.setAttribute("initDate", initDate);
                    session.setAttribute("endDate", endDate);
                    session.setAttribute("Distribuidor", bancosStr);
                    try {
                        url = value.valida(session, initDate, endDate, "reporteAcumuladoDistribuidorTipoPago");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } // fin de distribudor acumulado tipo pago
                else if (action.equals("repvtAcuCom")) {
                    url = "/repvtAcuComHeader.jsp";
                } else if (action.equals("repvtAcuComMain")) {
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
                    String[] tipoPago = request.getParameterValues("tipoPago");
                    String tipoPagoStr = "";
                    for (String pago : tipoPago) {
                        if (!tipoPagoStr.equals("")) {
                            tipoPagoStr += ",";
                        }
                        tipoPagoStr += pago;
                    }
                    String[] distribuidor = request.getParameterValues("distribuidor");
                    String distribuidorStr = "";
                    for (String distri : distribuidor) {
                        if (!distribuidorStr.equals("")) {
                            distribuidorStr += ",";
                        }
                        distribuidorStr += distri;
                    }
                    String[] telefonica = request.getParameterValues("telefonica");
                    String telefonicaStr = "";
                    for (String telef : telefonica) {
                        if (!telefonicaStr.equals("")) {
                            telefonicaStr += ",";
                        }
                        telefonicaStr += telef;
                    }
                    session.setAttribute("initDate", initDate);
                    session.setAttribute("endDate", endDate);
                    session.setAttribute("bancoS", bancosStr);
                    session.setAttribute("tipoPagoS", tipoPagoStr);
                    session.setAttribute("distribuidorS", distribuidorStr);
                    session.setAttribute("telefonicaS", telefonicaStr);
                    try {
                        url = value.valida(session, initDate, endDate, "reporteAcumuladoComercio");
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
