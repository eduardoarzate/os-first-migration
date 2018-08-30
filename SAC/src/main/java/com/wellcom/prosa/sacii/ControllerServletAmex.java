/*###############################################################################
# Nombre del Programa :  ControllerServletAmex.java                             #
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  P-20-0115-16                 Fecha: 28/07/2017         #
# Modificacion        :  Incorporación de American Express                      #
#################################################################################
#                                                              Modificaciones   #
#-------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
package com.wellcom.prosa.sacii;

import biz.ideasoft.beans.ViewerManager;

import com.wellcom.exceptions.WellException;
import com.wellcom.prosa.Controladores.ControllerMethod;
import com.wellcom.sql.Database;
import com.wellcom.sql.SessionConnection;
import com.wellcom.Validator.Mantenimiento;
import com.wellcom.Validator.Validador;
import com.wellcom.prosa.sacii.fiidManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import com.wellcom.prosa.sacii.rlq.*;
import com.wellcom.prosa.sacii.mnto.DaoMntoDistribuidor;
import com.wellcom.prosa.sacii.mnto.DaoMntoTelefonica;
import com.wellcom.struts.*;
import com.wellcom.beans.*;
import com.wellcom.dao.*;
import java.util.*;
import java.text.*;
import java.awt.*;
import java.sql.*;
import java.math.BigInteger;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;
import net.sf.jasperreports.engine.export.*;
import net.sf.jasperreports.engine.data.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.*;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;
import javax.servlet.ServletOutputStream;
import javax.imageio.ImageIO;
import com.wellcom.prosa.sacii.RptUtils;

/**
 * Servlet implementation class ControllerServletAmex
 */
public class ControllerServletAmex extends HttpServlet {

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
    public ControllerServletAmex() {
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
            System.out.println("ControllerServletAmex session: " + this.sessionId);
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
            Date fechaActual = new Date();
            fechaHoy = formato.format(fechaActual);
            session.setAttribute("FILAS_POR_PAGINA", new Integer(100));
            session.setAttribute("fechaHoy", fechaHoy);
        }
        Logger logger = null;
        ControllerMethod metodo = null;

        try {
            if (action != null) {
                if (action.equals("login")) {
                    System.out.println("Action Login ControllerServletAmex: " + action);
                    url = "/login.jsp";
                } else if (action.equals("rptAmexEpape")) {
                    url = "/AMEX_EPAPE_Header.jsp";
                } else if (action.equals("rptAmexEpapeMain")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
					String[] bancoArreglo = request.getParameterValues("Adquirente");
                    String[] EpapeArreglo = request.getParameterValues("tipoEpape");
                    String numeroIndustria = request.getParameter("numeroIndustria");
                    String numeroComercio = request.getParameter("numeroComercio");
                    
					String EpapeStr = "";
                    for (String Epape : EpapeArreglo) {
                        if (!EpapeStr.equals("")) {
                            EpapeStr += ",";
                        }
                        EpapeStr += Epape;
                    }
					
					
					String bancoaStr = "";
                    for (String bancoAdq : bancoArreglo) {
                        if (!bancoaStr.equals("")) {
                            bancoaStr += ",";
                        }
                        bancoaStr += bancoAdq;
                    }
					
                    session.setAttribute("initDate", initDate);
                    session.setAttribute("endDate", endDate);
                    session.setAttribute("numeroIndustria", numeroIndustria);
                    session.setAttribute("numeroComercio", numeroComercio);
                    session.setAttribute("tipoEpape", EpapeStr);
					session.setAttribute("bancoAdq", bancoaStr);
                    try {
                        url = value.valida(session, initDate, endDate, "Amxepapedet001");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } else if (action.equals("rptAmexEpapeAjustes")) {
                    url = "/AMEX_EPAPE_AJUSTE_Header.jsp";
                } else if (action.equals("rptAmexEpapeAjustesMain")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
					String[] bancoArreglo = request.getParameterValues("Adquirente");
                    String numeroIndustria = request.getParameter("numeroIndustria");
                    String numeroComercio = request.getParameter("numeroComercio");
                    
					String bancoaStr = "";
                    for (String bancoAdq : bancoArreglo) {
                        if (!bancoaStr.equals("")) {
                            bancoaStr += ",";
                        }
                        bancoaStr += bancoAdq;
                    }
					
					session.setAttribute("initDate", initDate);
                    session.setAttribute("endDate", endDate);
                    session.setAttribute("numeroIndustria", numeroIndustria);
                    session.setAttribute("numeroComercio", numeroComercio);
					session.setAttribute("bancoAdq", bancoaStr);
					
                    try {
                        url = value.valida(session, initDate, endDate, "Amxepapeadj002");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } else if (action.equals("repConcProsaAmex")) {
                    url = "/AMEX_CONC_Header.jsp";
                } else if (action.equals("repConcProsaAmexMain")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
					String[] bancoArreglo = request.getParameterValues("Adquirente");
                    String numeroIndustria = request.getParameter("numeroIndustria");
                    String numeroComercio = request.getParameter("numeroComercio");
                    String tipoTransaccion = request.getParameter("tipoTransaccion");
                    String tipoReporte = request.getParameter("tipoReporte");
					
					String bancoaStr = "";
                    for (String bancoAdq : bancoArreglo) {
                        if (!bancoaStr.equals("")) {
                            bancoaStr += ",";
                        }
                        bancoaStr += bancoAdq;
                    }
					
                    session.setAttribute("initDate", initDate);
                    session.setAttribute("endDate", endDate);
					session.setAttribute("bancoAdq", bancoaStr);
                    session.setAttribute("numeroIndustria", numeroIndustria);
                    session.setAttribute("numeroComercio", numeroComercio);
                    session.setAttribute("tipoTransaccion", tipoTransaccion);
                    session.setAttribute("tipoReporte", tipoReporte);
					
                    try {
                        url = value.valida(session, initDate, endDate, "Amxepapecnc003");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Action Null :" + action);
            }
        } catch (NullPointerException npe) {
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
