/*###############################################################################
# Nombre del Programa :  ControllerServletGen.java                              #
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
import org.jdom.JDOMException;
import java.text.ParseException;
import com.wellcom.exceptions.WellException;

/**
 * Servlet implementation class ControllerServletGen
 */
public class ControllerServletGen extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private HttpSession session;
    String url;
    String rutaContext = "";
    private String sessionId;
    Validador value;
    ParametrosCompartidos pC = new ParametrosCompartidos();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServletGen() {
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
        boolean isAnswerReport = false;

        action = request.getParameter("action");
        System.out.println("Action : " + action);

        this.session = request.getSession(true);

        this.sessionId = session.getId();
        System.out.println("ControllerServletGen session: " + this.sessionId);
        this.session.setMaxInactiveInterval(2400);

        session.setAttribute("rutaContext", rutaContext);
        String posicion = request.getParameter("p");
        posicion = Posicion(posicion);

        session.setAttribute("pos", posicion);
        value = new Validador();
        ComboBoxGen comboGen = new ComboBoxGen();

        try {
            if (action != null) {
                if (action.equals("login")) {
                    //session.invalidate();
                    System.out.println("Action Login :" + action);
                    url = "/login.jsp";
                } else if (action.equals("index")) {
                    System.out.println("Atributo Inicio " + session.getAttribute("inicio"));
                    System.out.println("Action Index Gen:" + action);
                    try {
                        if (session.getAttribute("inicio") == null || session.getAttribute("inicio").equals("true")) {
                            fiidManager inicia = new fiidManager();
                            inicia.NumeroProsa(session);
                            session.setAttribute("inicio", "false");
                            session.setAttribute("activo", "true");
                            // session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                            // session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
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
                } else if (action.equals("SICMOR0205")) {
                    System.out.println("Inicio Accion SICMOR0205");
                    comboGen.getTipoTXS();
                    System.out.println("Fin Accion SICMOR0205");
                } else if (action.equals("Salir")) {
                    System.out.println("Action Salir :");
                    //session.invalidate();
                    session = request.getSession(false);
                    session.setAttribute("grantAccess", "false");
                    session.setAttribute("activo", "false");
                    session.invalidate();
                    url = "/login.jsp";
                } else {
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

}
