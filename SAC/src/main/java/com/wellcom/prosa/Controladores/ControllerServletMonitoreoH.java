/*###############################################################################
# Nombre del Programa :  ControllerServletMonitoreoH.java                       #
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
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import com.wellcom.exceptions.WellException;
import com.wellcom.prosa.sacii.RptUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Servlet implementation class ControllerServletMonitoreoH
 */
public class ControllerServletMonitoreoH extends HttpServlet {

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
    public ControllerServletMonitoreoH() {
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
        String diaHabAnt7Historico = "";
        String fechaHoy = "";
        boolean isAnswerReport = false;
        action = "login";
        this.session = request.getSession(false);
        if (this.session != null && this.session.getAttribute("activo") != null) {
            action = request.getParameter("action");
            System.out.println("Action : " + action);
            this.sessionId = session.getId();
            System.out.println("ControllerServletMonitoreoH session: " + this.sessionId);
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
            Date fechaAnterior = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            long fechaAntes = fechaAnterior.getTime() - 8 * (24 * 60 * 60 * 1000);
            Date fechaActual = new Date();
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
                    System.out.println("Action Login ControllerServletMonitoreoH: " + action);
                    url = "/login.jsp";
                }//Comienzan reportes 
                //Reporte SICMOF0100H
                else if (action.equals("SICMOF0100H")) {
                    fechas(session);
                    if (request.getParameter("mostrarTabla") != null) {
                        session.setAttribute("mostrarTabla", "true");
                    } else {
                        session.setAttribute("mostrarTabla", "false");
                    }

                    url = "/SICMOF0100HHeader.jsp";
                } //Reporte 0100H
                else if (action.equals("SICMOR0100H")) {
                    url = "/SICMOR0100HHeader.jsp";
                } else if (action.equals("SICMOR0100HMain")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String agrNatContable = (request.getParameter("agrNatContable") == null ? "false" : "true");
                    String natcon = request.getParameter("natcon");
                    String diaHabAnt = (String) session.getAttribute("diaHabAnt");

                    String[] bancosAdq = request.getParameterValues("bancoAdq");
                    String bancosAdqStr = "";
                    for (String bancoAdq : bancosAdq) {
                        if (!bancosAdqStr.equals("")) {
                            bancosAdqStr += ",";
                        }
                        bancosAdqStr += bancoAdq;
                    }
                    String[] transacs = request.getParameterValues("nTransac");
                    String transacsStr = "";
                    for (String transac : transacs) {
                        if (!transacsStr.equals("")) {
                            transacsStr += ",";
                        }
                        transacsStr += transac;
                    }
                    String[] archivosAdq = request.getParameterValues("archivoAdq");
                    String archivosAdqStr = "";
                    for (String archivoAdq : archivosAdq) {
                        if (!archivosAdqStr.equals("")) {
                            archivosAdqStr += ",";
                        }
                        archivosAdqStr += archivoAdq;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancosAdqStr);
                    session.setAttribute("nTransac", transacsStr);
                    session.setAttribute("archivoAdq", archivosAdqStr);
                    session.setAttribute("natcon", natcon);
                    session.setAttribute("agrNatContable", agrNatContable);

                    try {
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                        try {
                            if (format.parse(initDate).compareTo(format.parse(diaHabAnt7Historico)) <= 0 && format.parse(endDate).compareTo(format.parse(diaHabAnt7Historico)) <= 0) {
                                url = value.valida(session, initDate, endDate, "Sicmor0100H");
                                viewerManager.setUpViewer(this, request, response, url);
                                isAnswerReport = true;
                            } else {
                                url = "/fechasInvalidas.jsp?noPantalla=5";
                            }
                        } catch (Exception ex) {
                            throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                        }
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0205H
                else if (action.equals("SICMOR0205H")) {
                    /**
                     * ******** Inicio Modificacion WELLCOM N-08-2253-12
                     * *********
                     */
                    fechas(session);
                    if (request.getParameter("mostrarTabla") != null) {
                        session.setAttribute("mostrarTabla", "true");
                    } else {
                        session.setAttribute("mostrarTabla", "false");
                    }
                    /**
                     * ******** Fin Modificacion WELLCOM N-08-2253-12 *********
                     */
                    url = "/SICMOR0205HHeader.jsp";
                } else if (action.equals("SICMOR0205HMain")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String diaHabAnt = (String) session.getAttribute("diaHabAnt");

                    String cuenta = request.getParameter("cuenta").equals("") ? "null" : request.getParameter("cuenta");
                    String comercio = request.getParameter("comercio").equals("") ? "null" : request.getParameter("comercio");
                    String referencia = request.getParameter("referencia").equals("") ? "null" : request.getParameter("referencia");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("cuenta", cuenta);
                    session.setAttribute("comercio", comercio);
                    session.setAttribute("referencia", referencia);

                    try {
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                        try {
                            if (format.parse(initDate).compareTo(format.parse(diaHabAnt7Historico)) <= 0 && format.parse(endDate).compareTo(format.parse(diaHabAnt7Historico)) <= 0) {
                                url = value.valida(session, initDate, endDate, "Sicmor0205H");
                                viewerManager.setUpViewer(this, request, response, url);
                                isAnswerReport = true;
                            } else {
                                url = "/fechasInvalidas.jsp?noPantalla=5";
                            }
                        } catch (Exception ex) {
                            throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                        }
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                }//Reporte SICMOR0305H
                else if (action.equals("SICMOR0305H")) {
                    url = "/SICMOR0305HHeader.jsp";
                } else if (action.equals("SICMOR0305HMain")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String diaHabAnt = (String) session.getAttribute("diaHabAnt");

                    String prefijo = request.getParameter("Prefijo");
                    String natcon = request.getParameter("natcon");
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
                    String[] tipoTransArray = request.getParameterValues("tipoTransac");
                    String tipoTrans = "";
                    for (String tipo : tipoTransArray) {
                        if (!tipoTrans.equals("")) {
                            tipoTrans += ",";
                        }
                        tipoTrans += tipo;
                    }
                    String[] tipoLiquidacionArray = request.getParameterValues("tipoLiquidacion");
                    String tipoLiquidacion = "";
                    for (String tipo : tipoLiquidacionArray) {
                        if (!tipoLiquidacion.equals("")) {
                            tipoLiquidacion += ",";
                        }
                        tipoLiquidacion += tipo;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancoAdq);
                    session.setAttribute("bancoEmi", bancoEmi);
                    session.setAttribute("tipoTransac", tipoTrans);
                    session.setAttribute("tipoLiquidacion", tipoLiquidacion);
                    session.setAttribute("prefijo", prefijo);
                    session.setAttribute("natcon", natcon);

                    try {
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                        try {
                            if (format.parse(initDate).compareTo(format.parse(diaHabAnt7Historico)) <= 0 && format.parse(endDate).compareTo(format.parse(diaHabAnt7Historico)) <= 0) {
                                url = value.valida(session, initDate, endDate, "Sicmor0305H");
                                viewerManager.setUpViewer(this, request, response, url);
                                isAnswerReport = true;
                            } else {
                                url = "/fechasInvalidas.jsp?noPantalla=5";
                            }
                        } catch (Exception ex) {
                            throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                        }
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                }//Reporte 0360H
                else if (action.equals("SICLIR0360H")) {
                    url = "/SICLIR0360HHeader.jsp";
                } else if (action.equals("SICLIR0360HMain")) {
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

                        session.setAttribute("initDateHabAnt", initDateHabAnt);
                        session.setAttribute("endDateHabAnt", endDateHabAnt);

                        try {
                            if (format.parse(initDate).compareTo(format.parse(diaHabAnt7Historico)) <= 0 && format.parse(endDate).compareTo(format.parse(diaHabAnt7Historico)) <= 0) {
                                url = value.valida(session, initDate, endDate, "Siclir0360H");
                                viewerManager.setUpViewer(this, request, response, url);
                                isAnswerReport = true;
                            } else {
                                url = "/fechasInvalidas.jsp?noPantalla=5";
                            }
                        } catch (Exception ex) {
                            throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                        }
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } //Reporte 0460H
                else if (action.equals("SICLIR0460H")) {
                    System.out.println("460h");
                    url = "/SICLIR0460HHeader.jsp";
                } else if (action.equals("SICLIR0460HMain")) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String[] bancoEmiArray = request.getParameterValues("bancoEmi");
                    String bancoEmi = "";
                    for (String banco : bancoEmiArray) {
                        if (!bancoEmi.equals("")) {
                            bancoEmi += ",";
                        }
                        bancoEmi += banco;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoEmi", bancoEmi);
                    try {
                        metodo = new ControllerMethod();
                        metodo.Oparticiones(initDate, endDate, session);
                        url = value.valida(session, initDate, endDate, "Siclir0460H");
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
