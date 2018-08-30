/*###############################################################################
# Nombre del Programa :  ControllerServletInterfaces.java                       #
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
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.logging.Logger;

/**
 * Servlet implementation class ControllerServletInterfaces
 */
public class ControllerServletInterfaces extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private HttpSession session;
    String url;
    String rutaContext = "";
    private String sessionId;
    Validador value;
    ParametrosCompartidos pC = new ParametrosCompartidos();
    ViewerManager viewerManager;
    ConexionORACLE conOracle = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServletInterfaces() {
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
        String action;
        String fechaHoy;
        boolean isAnswerReport = false;
        this.session = request.getSession(false);
        action = "login";
        if (this.session != null && this.session.getAttribute("activo") != null) {
            action = request.getParameter("action");
            this.sessionId = session.getId();
            this.session.setMaxInactiveInterval(2400);
            session.setAttribute("rutaContext", rutaContext);
            System.out.println("Action : " + action);
            System.out.println("ControllerServletInterfaces session: " + this.sessionId);

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
        // GSOF-MVR-B-54-2092-15 Marca de Inicio
        Logger logger = null;
        // GSOF-MVR-B-54-2092-15 Marca de Terminacion

        ControllerMethod metodo = null;

        try {
            if (action != null) {
                if (action.equals("login")) {
                    //session.invalidate();
                    System.out.println("Action Login ControllerServletInterfaces: " + action);
                    url = "/login.jsp";
                } //Comienzan reportes 
                //Reporte 0580
                else if (action.equals("SICLIR0580")) {
                    url = "/SICLIR0580Header.jsp";
                } else if (action.equals("SICLIR0580Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String[] bancoEmiArray = request.getParameterValues("banco");
                    String bancosEmi = "";
                    for (String banco : bancoEmiArray) {
                        if (!bancosEmi.equals("")) {
                            bancosEmi += "','";
                        }
                        bancosEmi += banco;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosEmi);
                    try {
                        url = value.valida(session, initDate, endDate, "Siclir0580");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0640
                else if (action.equals("SICLIR0640")) {
                    url = "/SICLIR0640Header.jsp";
                } else if (action.equals("SICLIR0640Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);

                    try {
                        url = value.valida(session, initDate, endDate, "Siclir0640");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0650
                else if (action.equals("SICLIR0650")) {
                    url = "/SICLIR0650Header.jsp";
                } else if (action.equals("SICLIR0650Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);

                    try {
                        url = value.valida(session, initDate, endDate, "Siclir0650");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0670
                else if (action.equals("SICLIR0670")) {
                    url = "/SICLIR0670Header.jsp";
                } else if (action.equals("SICLIR0670Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String[] bancoEmiArray = request.getParameterValues("banco");
                    String bancosEmi = "";
                    for (String banco : bancoEmiArray) {
                        if (!bancosEmi.equals("")) {
                            bancosEmi += ",";
                        }
                        bancosEmi += banco;
                    }

                    Double cuota_previa = Double.parseDouble(request.getParameter("cuota_previa"));
                    Double diferencia_autorizaciones = Double.parseDouble(request.getParameter("diferencia_autorizaciones"));
                    Double autorizaciones = Double.parseDouble(request.getParameter("autorizaciones"));
                    Double copias = Double.parseDouble(request.getParameter("copias"));
                    Double penalizaciones = Double.parseDouble(request.getParameter("penalizaciones"));
                    Double tasas = Double.parseDouble(request.getParameter("tasas"));
                    Double arbitraje = Double.parseDouble(request.getParameter("arbitraje"));
                    Double intereses = Double.parseDouble(request.getParameter("intereses"));

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosEmi);
                    session.setAttribute("cuota_previa", cuota_previa);
                    session.setAttribute("diferencia_autorizaciones", diferencia_autorizaciones);
                    session.setAttribute("autorizaciones", autorizaciones);
                    session.setAttribute("copias", copias);
                    session.setAttribute("penalizaciones", penalizaciones);
                    session.setAttribute("tasas", tasas);
                    session.setAttribute("arbitraje", arbitraje);
                    session.setAttribute("intereses", intereses);

                    try {
                        url = value.valida(session, initDate, endDate, "Siclir0670");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0680
                else if (action.equals("SICLIR0680")) {
                    url = "/SICLIR0680Header.jsp";
                } else if (action.equals("SICLIR0680Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String[] bancoEmiArray = request.getParameterValues("banco");
                    String bancosEmi = "";
                    for (String banco : bancoEmiArray) {
                        if (!bancosEmi.equals("")) {
                            bancosEmi += ",";
                        }
                        bancosEmi += banco;
                    }

                    Double cuota_previa = Double.parseDouble(request.getParameter("cuota_previa"));
                    Double diferencia_autorizaciones = Double.parseDouble(request.getParameter("diferencia_autorizaciones"));
                    Double autorizaciones = Double.parseDouble(request.getParameter("autorizaciones"));
                    Double copias = Double.parseDouble(request.getParameter("copias"));
                    Double penalizaciones = Double.parseDouble(request.getParameter("penalizaciones"));
                    Double tasas = Double.parseDouble(request.getParameter("tasas"));
                    Double arbitraje = Double.parseDouble(request.getParameter("arbitraje"));
                    Double intereses = Double.parseDouble(request.getParameter("intereses"));

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosEmi);
                    session.setAttribute("cuota_previa", cuota_previa);
                    session.setAttribute("diferencia_autorizaciones", diferencia_autorizaciones);
                    session.setAttribute("autorizaciones", autorizaciones);
                    session.setAttribute("copias", copias);
                    session.setAttribute("penalizaciones", penalizaciones);
                    session.setAttribute("tasas", tasas);
                    session.setAttribute("arbitraje", arbitraje);
                    session.setAttribute("intereses", intereses);

                    try {
                        url = value.valida(session, initDate, endDate, "Siclir0680");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte SICLIRP670
                else if (action.equals("SICLIRP670")) {
                    url = "/SICLIRP670Header.jsp";
                } else if (action.equals("SICLIRP670Main")) {
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
                        url = value.valida(session, initDate, endDate, "Siclirp670");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte SICLIRP680
                else if (action.equals("SICLIRP680")) {
                    url = "/SICLIRP680Header.jsp";
                } else if (action.equals("SICLIRP680Main")) {
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
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("interred", interredesStr);

                    try {
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        try {

                            url = value.valida(session, initDate, endDate, "Siclirp680");
                            viewerManager.setUpViewer(this, request, response, url);
                            isAnswerReport = true;
                        } catch (Exception ex) {
                            throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                        }
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Siclir0470
                else if (action.equals("SICLIR0470")) {
                    url = "/SICLIR0470Header.jsp";
                } else if (action.equals("SICLIR0470Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String[] bancoSocioArray = request.getParameterValues("banco");
                    String bancosSocios = "";
                    for (String banco : bancoSocioArray) {
                        if (!bancosSocios.equals("")) {
                            bancosSocios += ",";
                        }
                        bancosSocios += banco;
                    }
                    String anio = request.getParameter("anio");
                    String folio = request.getParameter("folio");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("banco", bancosSocios);
                    session.setAttribute("anio", anio);
                    session.setAttribute("folio", folio);
                    try {
                        url = value.valida(session, initDate, initDate, "Siclir0470");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } else if (action.equals("SICLMNIR01")) {
                    url = "/SICLMNIR01Header.jsp";
                } else if (action.equals("SICLMNIR01Main")) {
                    ComboBoxGen comborpln = new ComboBoxGen();
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String marcas = request.getParameter("cmbMarcas");
                    String institucion = "";
                    String instituciones[] = request.getParameterValues("cmbInst");
                    for (String ins : instituciones) {
                        if (!institucion.equals("")) {
                            institucion += ", ";
                        }
                        institucion += ins;
                    }
                    String pcMarcas = comborpln.getMarcasCaratula(session, marcas);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("cmbMarcas", marcas);
                    session.setAttribute("cmbInst", institucion);
                    session.setAttribute("pcMarcas", pcMarcas);
                    try {
                        url = value.valida(session, initDate, endDate, "SICLMNIR01");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } else if (action.equals("SICLMNPR01")) {
                    url = "/SICLMNPR01Header.jsp";
                } else if (action.equals("SICLMNPR01Main")) {
                    ComboBoxGen comborpln = new ComboBoxGen();
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String marcas = request.getParameter("cmbMarcas");
                    String institucion = "";
                    String instituciones[] = request.getParameterValues("cmbInst");
                    for (String ins : instituciones) {
                        if (!institucion.equals("")) {
                            institucion += ", ";
                        }
                        institucion += ins;
                    }
                    String pcMarcas = comborpln.getMarcasCaratula(session, marcas);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("cmbMarcas", marcas);
                    session.setAttribute("cmbInst", institucion);
                    session.setAttribute("pcMarcas", pcMarcas);
                    try {
                        url = value.valida(session, initDate, endDate, "SICLMNPR01");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } else if (action.equals("SICLMNTT01")) {
                    url = "/SICLMNTT01Header.jsp";
                } else if (action.equals("SICLMNTT01Main")) {
                    ComboBoxGen comborpln = new ComboBoxGen();
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String marcas = request.getParameter("cmbMarcas");
                    String liquidacion = "";
                    String liquidaciones[] = request.getParameterValues("cmbLiq");
                    for (String ins : liquidaciones) {
                        if (!liquidacion.equals("")) {
                            liquidacion += ", ";
                        }
                        liquidacion += ins;
                    }
                    String pcMarcas = comborpln.getMarcasCaratula(session, marcas);
                    String pcLiquidacion = comborpln.getLiquidacionCaratula(session, liquidacion);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("cmbMarcas", marcas);
                    session.setAttribute("cmbLiq", liquidacion);
                    session.setAttribute("pcMarcas", pcMarcas);
                    session.setAttribute("pcLiquidacion", pcLiquidacion);
                    try {
                        url = value.valida(session, initDate, endDate, "SICLMNTT01");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0440
                else if (action.equals("SICLIR0440")) {
                    url = "/SICLIR0440Header.jsp";
                } else if (action.equals("SICLIR0440Main")) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String estado = request.getParameter("estado");
                    String[] bancoArray = request.getParameterValues("banco");
                    String bancos = "";
                    for (String banco : bancoArray) {
                        if (!bancos.equals("")) {
                            bancos += ",";
                        }
                        bancos += banco;
                    }

                    session.setAttribute("initDate", initDate);
                    session.setAttribute("endDate", endDate);
                    session.setAttribute("estado", estado);
                    session.setAttribute("banco", bancos);
                    try {
                        url = value.valida(session, initDate, endDate, "Siclir0440");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (Exception ex) {
                        ex.printStackTrace();
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
