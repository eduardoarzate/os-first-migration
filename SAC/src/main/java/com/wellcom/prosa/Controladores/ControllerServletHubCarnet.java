/*###############################################################################
# Nombre del Programa :  ControllerServletHubCarnet.java                        #
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
import java.text.ParseException;
import com.wellcom.exceptions.WellException;
import com.wellcom.prosa.sacii.RptUtils;
import java.util.logging.Logger;
import java.io.IOException;
import java.text.ParseException;

/**
 * Servlet implementation class ControllerServletHubCarnet
 */
public class ControllerServletHubCarnet extends HttpServlet {

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
    public ControllerServletHubCarnet() {
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
            System.out.println("ControllerServletHubCarnet session: " + this.sessionId);
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
                    System.out.println("Action Login ControllerServletHubCarnet: " + action);
                    url = "/login.jsp";
                }//Comienzan reportes 
                else if (action.equals("SICLIRH0110")) {
                    url = "/SICLIRH0110Header.jsp";
                } else if (action.equals("SICLIRH0110Main")) {
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
                    String[] tipoTarjetaArray = request.getParameterValues("tipoTransac");
                    String stipoTarjeta = "";
                    for (String tarjeta : tipoTarjetaArray) {
                        if (!stipoTarjeta.equals("")) {
                            stipoTarjeta += ",";
                        }
                        stipoTarjeta += tarjeta;
                    }
                    session.setAttribute("tipoTransac", stipoTarjeta);
                    ControllerServletUtil.SICLIRH0110Main(session, "PRSA_SETL_IND", "PRSA_RPT_IND", initDate, endDate, bancosEmi);
                    try {
                        url = value.valida(session, initDate, endDate, "SiclirH0110");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } else if (action.equals("SICLIRH0120")) {
                    url = "/SICLIRH0120Header.jsp";
                } else if (action.equals("SICLIRH0120Main")) {
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
                    String[] tipoTarjetaArray = request.getParameterValues("tipoTransac");
                    String stipoTarjeta = "";
                    for (String tarjeta : tipoTarjetaArray) {
                        if (!stipoTarjeta.equals("")) {
                            stipoTarjeta += ",";
                        }
                        stipoTarjeta += tarjeta;
                    }
                    session.setAttribute("tipoTransac", stipoTarjeta);
                    ControllerServletUtil.SICLIRH0120Main(session, "PRSA_SETL_IND", "PRSA_RPT_IND", initDate, endDate, interredesStr, divisionesStr);
                    try {
                        url = value.valida(session, initDate, endDate, "SiclirH0120");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } else if (action.equals("SICLIRH0130")) {
                    url = "/SICLIRH0130Header.jsp";
                } else if (action.equals("SICLIRH0130Main")) {
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
                    String[] tipoTarjetaArray = request.getParameterValues("tipoTransac");
                    String stipoTarjeta = "'";
                    for (String tarjeta : tipoTarjetaArray) {
                        if (!stipoTarjeta.equals("")) {
                            stipoTarjeta += "','";
                        }
                        stipoTarjeta += tarjeta;
                    }
                    session.setAttribute("bancoEmi", bancosEmi);
                    session.setAttribute("tipoTransac", stipoTarjeta);
                    ControllerServletUtil.SICLIRH0130Main(session, "PRSA_SETL_IND", "PRSA_RPT_IND", initDate, endDate);
                    try {
                        url = value.valida(session, initDate, endDate, "SiclirH0130");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } else if (action.equals("SICLIRH0135")) {
                    url = "/SICLIRH0135Header.jsp";
                } else if (action.equals("SICLIRH0135Main")) {
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
                    String[] tipoTarjetaArray = request.getParameterValues("tipoTransac");
                    String stipoTarjeta = "";
                    for (String tarjeta : tipoTarjetaArray) {
                        if (!stipoTarjeta.equals("")) {
                            stipoTarjeta += ",";
                        }
                        stipoTarjeta += tarjeta;
                    }
                    session.setAttribute("bancoEmi", bancosEmi);
                    session.setAttribute("tipoTransac", stipoTarjeta);
                    ControllerServletUtil.SICLIRH0135Main(session, "PRSA_SETL_IND", "PRSA_RPT_IND", initDate, endDate);

                    try {
                        url = value.valida(session, initDate, endDate, "SiclirH0135");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } else if (action.equals("SICLIRH0140")) {
                    url = "/SICLIRH0140Header.jsp";
                } else if (action.equals("SICLIRH0140Main")) {
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
                    String[] tipoTarjetaArray = request.getParameterValues("tipoTransac");
                    String stipoTarjeta = "";
                    for (String tarjeta : tipoTarjetaArray) {
                        if (!stipoTarjeta.equals("")) {
                            stipoTarjeta += ",";
                        }
                        stipoTarjeta += tarjeta;
                    }
                    session.setAttribute("bancoEmi", bancosEmi);
                    session.setAttribute("tipoTransac", stipoTarjeta);
                    ControllerServletUtil.SICLIRH0140Main(session, "PRSA_SETL_IND", "PRSA_RPT_IND", initDate, endDate);
                    try {
                        url = value.valida(session, initDate, endDate, "SiclirH0140");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } else if (action.equals("SICLIRH0430")) {
                    url = "/SICLIRH0430Header.jsp";
                } else if (action.equals("SICLIRH0430Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String diaHabAnt = (String) session.getAttribute("diaHabAnt");
                    String[] interreds = request.getParameterValues("interred");
                    String interredesStr = "";
                    for (String interrred : interreds) {
                        if (!interredesStr.equals("")) {
                            interredesStr += ",";
                        }
                        interredesStr += interrred;
                    }
                    String[] bancoEmiArray = request.getParameterValues("bancoEmi");
                    String bancosEmi = "";
                    for (String banco : bancoEmiArray) {
                        if (!bancosEmi.equals("")) {
                            bancosEmi += ",";
                        }
                        bancosEmi += banco;
                    }
                    String[] tipoTarjetaArray = request.getParameterValues("tipoTransac");
                    String stipoTarjeta = "";
                    for (String tarjeta : tipoTarjetaArray) {
                        if (!stipoTarjeta.equals("")) {
                            stipoTarjeta += ",";
                        }
                        stipoTarjeta += tarjeta;
                    }
                    session.setAttribute("bancoEmi", bancosEmi);
                    session.setAttribute("tipoTransac", stipoTarjeta);
                    ControllerServletUtil.SICLIRH0430Main(session, "PRSA_SETL_IND", "PRSA_RPT_IND", initDate, endDate, interredesStr);
                    try {
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        try {
                            metodo = new ControllerMethod();
                            if (format.parse(initDate).compareTo(format.parse(diaHabAnt7)) > 0) {
                                metodo.Oparticiones(initDate, endDate, session);
                                url = value.valida(session, initDate, endDate, "SiclirH0430");
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
                } else if (action.equals("SICLIRHP320")) {
                    url = "/SICLIRHP320Header.jsp";
                } else if (action.equals("SICLIRHP320Main")) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
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
                    String[] tipoTarjetaArray = request.getParameterValues("tipoTransac");
                    String stipoTarjeta = "";
                    for (String tarjeta : tipoTarjetaArray) {
                        if (!stipoTarjeta.equals("")) {
                            stipoTarjeta += ",";
                        }
                        stipoTarjeta += tarjeta;
                    }
                    session.setAttribute("bancoEmi", bancosEmi);
                    session.setAttribute("tipoTransac", stipoTarjeta);
                    ControllerServletUtil.SICLIRHP320Main(session, "PRSA_SETL_IND", "PRSA_RPT_IND", initDate, endDate);

                    try {
                        url = value.valida(session, initDate, endDate, "SiclirHp320");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (action.equals("SICMTRH001")) {
                    url = "/SICMTRH001Header.jsp";
                } else if (action.equals("SICMTRH001Main")) {
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
                    String[] tipoTarjetaArray = request.getParameterValues("tipoTransac");
                    String stipoTarjeta = "";
                    for (String tarjeta : tipoTarjetaArray) {
                        if (!stipoTarjeta.equals("")) {
                            stipoTarjeta += ",";
                        }
                        stipoTarjeta += tarjeta;
                    }
                    session.setAttribute("bancoEmi", bancosEmi);
                    session.setAttribute("tipoTransac", stipoTarjeta);
                    ControllerServletUtil.SICMTRH001Main(session, "PRSA_SETL_IND", "PRSA_RPT_IND", initDate, endDate);

                    try {
                        url = value.valida(session, initDate, endDate, "SICMTRH001");
                        url = value.valida(session, initDate, endDate, "SICMTRH001");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } else if (action.equals("SICCOMR001")) {
                    url = "/SICCOMR001Header.jsp";
                } else if (action.equals("SICCOMR001Main")) {
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
                    String[] tipoTarjetaArray = request.getParameterValues("tipoTransac");
                    String stipoTarjeta = "";
                    for (String tarjeta : tipoTarjetaArray) {
                        if (!stipoTarjeta.equals("")) {
                            stipoTarjeta += ",";
                        }
                        stipoTarjeta += tarjeta;
                    }
                    session.setAttribute("bancoEmi", bancosEmi);
                    session.setAttribute("tipoTransac", stipoTarjeta);
                    ControllerServletUtil.SICCOMR001Main(session, "PRSA_SETL_IND", "PRSA_RPT_IND", initDate, endDate);
                    try {
                        url = value.valida(session, initDate, endDate, "Siccomr001");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } else if (action.equals("SICMORH")) {
                    url = "/SICMORHHeader.jsp";
                } else if (action.equals("SICMORHMain")) {
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
                    String tipoTx = request.getParameter("tipoTransac");
                    session.setAttribute("bancoEmi", bancosEmi);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("tipoTransac", tipoTx);

                    try {
                        url = value.valida(session, initDate, endDate, "SicmorH");
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
