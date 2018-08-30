/*###############################################################################
# Nombre del Programa :  ControllerServletAdquirienteH.java                     #
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
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import java.text.ParseException;
import com.wellcom.exceptions.WellException;
import com.wellcom.prosa.sacii.RptUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Logger;

/**
 * Servlet implementation class ControllerServletAdquirienteH
 */
public class ControllerServletAdquirienteH extends HttpServlet {

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
    public ControllerServletAdquirienteH() {
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
        String action = "";
        String diaHabAnt = "";
        String diaHabAnt7Historico = "";
        String diaHabAnt7 = "";
        String fechaHoy = "";
        boolean isAnswerReport = false;
        action = "login";
        this.session = request.getSession(false);
        if (this.session != null && this.session.getAttribute("activo") != null) {
            action = request.getParameter("action");
            System.out.println("Action : " + action);

            this.sessionId = session.getId();
            System.out.println("ControllerServletAdquirienteH session: " + this.sessionId);
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
            long fechaAntesHistorico = fechaAnterior.getTime() - 1 * (24 * 60 * 60 * 1000);
            diaHabAnt7Historico = formato.format(fechaAntesHistorico);
            session.setAttribute("diaHabAnt7", diaHabAnt7);
            session.setAttribute("fechaHoy", fechaHoy);
        }
        Logger logger = null;
        ControllerMethod metodo = null;

        try {
            if (action != null) {
                if (action.equals("login")) {
                    //session.invalidate();
                    System.out.println("Action Login ControllerServletAdquirienteH: " + action);
                    url = "/login.jsp";
                }//Comienzan reportes 
                else if (action.equals("SICMIRB040H")) {
                    url = "/SICMIRB040HHeader.jsp";
                } else if (action.equals("SICMIRB040HMain")) {
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
                        if (format.parse(initDate).compareTo(format.parse(diaHabAnt7)) <= 0) {
                            url = "/reportsjsp/managerReports.jsp" + "?report=" + "Sicmirb040H";
                            viewerManager.setUpViewer(this, request, response, url);
                            isAnswerReport = true;
                        } else {
                            url = "/fechasInvalidas.jsp?noPantalla=5";
                        }
                    } catch (Exception ex) {
                        throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
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
