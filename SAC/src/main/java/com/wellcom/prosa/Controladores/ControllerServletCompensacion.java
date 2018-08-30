/*###############################################################################
# Nombre del Programa :  ControllerServletCompensacion.java                     #
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 12/01/2017         #
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
import com.wellcom.exceptions.WellException;
import com.wellcom.struts.*;
import com.wellcom.beans.*;
import com.wellcom.dao.*;
import java.util.*;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
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
import com.wellcom.prosa.sacii.RptUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Servlet implementation class ControllerServletCompensacion
 */
public class ControllerServletCompensacion extends HttpServlet {

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
    public ControllerServletCompensacion() {
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
        String fechaHoy = "";
        boolean isAnswerReport = false;

        this.session = request.getSession(false);

        ControllerMethod metodo = null;
        action = "login";
        if (this.session != null && this.session.getAttribute("activo") != null) {
            action = request.getParameter("action");
            this.sessionId = session.getId();
            System.out.println("ControllerServletCompensacion session: " + this.sessionId + "--" + session.getAttribute("pos"));
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

            Date fechaAnterior = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            long fechaAntes = fechaAnterior.getTime() - 8 * (24 * 60 * 60 * 1000);
            Date fechaActual = new Date();
            fechaHoy = formato.format(fechaActual);
            diaHabAnt7 = formato.format(fechaAntes);
            session.setAttribute("fechaHoy", fechaHoy);
            // GSOF-MVR-B-54-2092-15 Marca de Inicio
        }
        Logger logger = null;
        // GSOF-MVR-B-54-2092-15 Marca de Terminacion

        try {
            System.out.println("Action 2: " + action);
            if (action != null) {
                if (action.equals("login")) {
                    //session.invalidate();
                    System.out.println("Action Login ControllerServletCompensacion: " + action);
                    url = "/login.jsp";
//Comienzan reportes 
                    //Reporte SICLIF0320
                } else if (action.equals("SICLIF0320")) {
                    url = "/SICLIF0320Header.jsp";
                } //  -- Marca del Cambio : SAS-DRT-P-53-2004-15 INICIA la Modificacion
                else if (action.equals("SICLIF0320Main")) {
                    String[] tipoEntSalArray = request.getParameterValues("tipoEntSal");
                    String tipoEntSal = "";
                    for (String tipoEntSalTmp : tipoEntSalArray) {
                        if (!tipoEntSal.equals("")) {
                            tipoEntSal += ",";
                        }
                        tipoEntSal += tipoEntSalTmp;
                    }

                    String rutaReportes = getServletContext().getRealPath("reports");
                    FileInputStream fis = null;
                    BufferedInputStream bufferedInputStream = null;
                    JasperReport reporte = null;
                    JasperPrint jasperPrint = null;
                    JRExporter exportador = null;
                    ServletOutputStream servletOutputStream = null;
                    Map parametros = new HashMap();
                    String usuario = (String) session.getAttribute("login");
                    String formatoSalida = null;
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    String rutaImagenes = getServletContext().getRealPath("pics");
                    ImageIcon icono = new ImageIcon(rutaImagenes + "/logoProsa.jpg");
                    url = "/SICLIF0320Header.jsp";
                    RptUtils util;
                    ConexionORACLE conOracle = null;

                    try {
                        util = new RptUtils();
                        String fIni = util.convertFecha(request.getParameter("txtfStartDate"), "yyMMdd");
                        String fFin = util.convertFecha(request.getParameter("txtfEndDate"), "yyMMdd");

                        util.creaArchFechas("SICLIF0320", fIni, fFin, session.getAttribute("login").toString());
                        util.lanzaCondicion("RPTUEGLB99901_OK", util.convertFecha(request.getParameter("txtfEndDate"), "MMdd"), 1);

                        fis = new FileInputStream(rutaReportes + "/siclif0320.jasper");
                        bufferedInputStream = new BufferedInputStream(fis);
                        reporte = (JasperReport) JRLoader.loadObject(bufferedInputStream);
                        parametros.put("ejecuto", session.getAttribute("login").toString());
                        parametros.put("initDate", request.getParameter("txtfStartDate"));
                        parametros.put("endDate", request.getParameter("txtfEndDate"));
                        parametros.put("tip_liq", tipoEntSal);
                        parametros.put("logo", icono.getImage());
                        //System.out.println("datos: "+request.getParameter("txtfStartDate")+"  "+request.getParameter("txtfEndDate")+" "+request.getParameter("txtftip_liq")+ "  "+session.getAttribute("login").toString());
                        formatoSalida = request.getParameter("formato");
                        if (logger != null) {
                            logger.info(session.getId() + ":" + "El usuario " + this.session.getAttribute("login").toString()
                                    + " genero el reporte SICLIF0320 con parametros:FechaIni["
                                    + request.getParameter("txtfStartDate") + "],FechaFin[" + request.getParameter("txtfEndDate") + "]");
                        }
                        // GENERA EL REPORTE

                        //Genera objeto Conexion
                        conOracle = new ConexionORACLE();
                        conOracle.Conectar();

                        jasperPrint = JasperFillManager.fillReport(reporte, parametros, conOracle.getConnection());
                        request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);
                        response.setHeader("Pragma", "no-cache");
                        response.setHeader("Cache-control", "private");
                        response.setDateHeader("Expires", 0);
                        // HTML
                        if ("0".compareTo(formatoSalida) == 0) {
                            response.setContentType("text/html");
                            response.setHeader("Content-Disposition", "inline; filename=\"SICLIF0320.html\"");
                            exportador = new JRHtmlExporter();
                            exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                            exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                            exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI, "image?image=");
                            exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                            exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(2.0));
                            exportador.exportReport();
                            servletOutputStream = response.getOutputStream();
                            response.setContentLength(baos.size());
                            baos.writeTo(servletOutputStream);
                            // EXCEL
                        } else if ("1".compareTo(formatoSalida) == 0) {
                            response.setContentType("application/vnd.ms-excel");
                            response.setHeader("Content-Disposition", "attachment; filename=\"SICLIF0320.xls\"");
                            exportador = new JRXlsExporter();
                            exportador.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
                            exportador.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baos);
                            exportador.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                            exportador.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                            exportador.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
                            exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.FALSE);
                            exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.FALSE);
                            exportador.exportReport();
                            servletOutputStream = response.getOutputStream();
                            response.setContentLength(baos.size());
                            baos.writeTo(servletOutputStream);
                            // PDF
                        } else {
                            response.setContentType("application/pdf");
                            response.setHeader("Content-Disposition", "attachment; filename=\"SICLIF0320.pdf\"");
                            exportador = new JRPdfExporter();
                            exportador.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
                            exportador.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, baos);
                            exportador.exportReport();
                            servletOutputStream = response.getOutputStream();
                            response.setContentLength(baos.size());
                            baos.writeTo(servletOutputStream);
                        }
                        baos.flush();
                        baos.close();
                        isAnswerReport = true;
                    } catch (Exception ex) {
                        System.out.println(" Error al generar SICLIF0320:" + ex);
                        ex.printStackTrace();
                    } finally {
                        conOracle.Desconectar();
                    }
                } //Reporte 0050
                else if (action.equals("SICLIR0050")) {
                    url = "/SICLIR0050Header.jsp";
                } else if (action.equals("SICLIR0050Main")) {
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
                        url = value.valida(session, initDate, endDate, "Siclir0050");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (ParseException pe) {
                        pe.printStackTrace();
                    }

//  -- Marca del Cambio : SAS-DRT-P-53-2004-15 Termina la Modificacion        
                    /* Termina cambio C-04-3035-13 */
                } else if (action.equals("SICLIR0060")) {
                    url = "/SICLIR0060Header.jsp";
                } else if (action.equals("SICLIR0060Main")) {
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
                        url = value.valida(session, initDate, endDate, "Siclir0060");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (ParseException pe) {
                        pe.printStackTrace();
                    }
                } //Reporte 0077
                else if (action.equals("SICLIR0077")) {
                    url = "/SICLIR0077Header.jsp";
                } else if (action.equals("SICLIR0077Main")) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String natCont = request.getParameter("natCont");
                    String agrDia=(request.getParameter("agrDia")==null?"false":"true");

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("natCont", natCont);
                    session.setAttribute( "agrDia", agrDia);

                    try {
                        url = value.valida(session, initDate, endDate, "Siclir0077");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0087
                else if (action.equals("SICLIR0087")) {
                    url = "/SICLIR0087Header.jsp";
                    System.err.println("los atributos: " + session.getAttributeNames());
                } else if (action.equals("SICLIR0087Main")) {

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
                        url = value.valida(session, initDate, endDate, "Siclir0087");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (ParseException pe) {
                        pe.printStackTrace();
                    }
                } //Reporte 0090
                else if (action.equals("SICLIR0090")) {
                    url = "/SICLIR0090Header.jsp";
                } else if (action.equals("SICLIR0090Main")) {
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
                        url = value.valida(session, initDate, endDate, "Siclir0090");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (ParseException pe) {
                        pe.printStackTrace();
                    }
                } //Reporte 0100
                else if (action.equals("SICLIR0100")) {
                    url = "/SICLIR0100Header.jsp";
                } else if (action.equals("SICLIR0100Main")) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);

                    try {
                        session.setAttribute("txtfStartDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                        session.setAttribute("txtfEndDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                        url = value.valida(session, initDate, endDate, "Siclir0100");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (ParseException pe) {
                        pe.printStackTrace();
                    }
                } //Reporte 0350
                else if (action.equals("SICLIR0350")) {
                    url = "/SICLIR0350Header.jsp";
                } else if (action.equals("SICLIR0350Main")) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
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
                    String[] numMiscArray = request.getParameterValues("numMisc");
                    String numMisc = "";
                    for (String numMiscTmp : numMiscArray) {
                        if (!numMisc.equals("")) {
                            numMisc += ",";
                        }
                        numMisc += numMiscTmp;
                    }
                    String agrTotales = request.getParameter("agrTotales");
                    String tipoEmiAdq = request.getParameter("tipoEmiAdq");
                    if (agrTotales == null) {
                        agrTotales = "false";
                    } else {
                        agrTotales = "true";
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", banco);
                    session.setAttribute("numMisc", numMisc);
                    session.setAttribute("tipoProc", tipoProc);
                    session.setAttribute("agrTotales", agrTotales);
                    session.setAttribute("tipoEmiAdq", tipoEmiAdq);

                    try {
                        session.setAttribute("initDateHabAnt", format.format(TimeUtils.getDiaHabilAnt(session, format.parse(initDate))));
                        session.setAttribute("endDateHabAnt", format.format(TimeUtils.getDiaHabilAnt(session, format.parse(endDate))));
                        url = value.valida(session, initDate, endDate, "Siclir0350");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } //Reporte 0360
                else if (action.equals("SICLIR0360")) {
                    url = "/SICLIR0360Header.jsp";
                } else if (action.equals("SICLIR0360Main")) {
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

                        try {
                            if (format.parse(initDate).compareTo(format.parse(diaHabAnt7)) > 0) {
                                metodo = new ControllerMethod();
                                metodo.Oparticionesdiaant(initDate, endDate, initDateHabAnt, endDateHabAnt, session);
                                url = value.valida(session, initDate, endDate, "Siclir0360");
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
                } //Reporte 0450
                else if (action.equals("SICLIR0450")) {
                    url = "/SICLIR0450Header.jsp";
                } // SAS-DRT-P-53-2004-15 Marca de Inicio        
                else if (action.equals("SICLIR0450Main")) {
                    String rutaReportes = getServletContext().getRealPath("reports");
                    FileInputStream fis = null;
                    BufferedInputStream bufferedInputStream = null;
                    JasperReport reporte = null;
                    JasperPrint jasperPrint = null;
                    JRExporter exportador = null;
                    ServletOutputStream servletOutputStream = null;
                    Map parametros = new HashMap();
                    String usuario = (String) session.getAttribute("login");
                    String formatoSalida = null;
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    String rutaImagenes = getServletContext().getRealPath("pics");
                    ImageIcon icono = new ImageIcon(rutaImagenes + "/logoProsa.jpg");
                    url = "/SICLIR0450Header.jsp";
                    ConexionORACLE conOracle = null;

                    try {
                        fis = new FileInputStream(rutaReportes + "/siclir0450.jasper");
                        bufferedInputStream = new BufferedInputStream(fis);
                        reporte = (JasperReport) JRLoader.loadObject(bufferedInputStream);
                        String[] bancos = request.getParameterValues("banco");
                        String bancosStr = "";
                        for (String banco : bancos) {
                            if (!bancosStr.equals("")) {
                                bancosStr += ",";
                            }
                            bancosStr += banco;
                        }
                        parametros.put("ejecuto", session.getAttribute("login").toString());
                        parametros.put("initDate", request.getParameter("txtfStartDate"));
                        parametros.put("endDate", request.getParameter("txtfEndDate"));
                        parametros.put("tipoDiferencia", request.getParameter("tipoDif"));
                        parametros.put("banco", bancosStr);
                        parametros.put("logo", icono.getImage());
                        formatoSalida = request.getParameter("formato");
                        if (logger != null) {
                            logger.info(session.getId() + ":" + "El usuario " + this.session.getAttribute("login").toString()
                                    + " genero el reporte SICLIR0450 con parametros:FechaIni["
                                    + request.getParameter("txtfStartDate") + "],FechaFin[" + request.getParameter("txtfEndDate") + "]");
                        }
                        // GENERA EL REPORTE
                        conOracle = new ConexionORACLE();
                        conOracle.Conectar();

                        jasperPrint = JasperFillManager.fillReport(reporte, parametros, conOracle.getConnection());
                        request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);
                        response.setHeader("Pragma", "no-cache");
                        response.setHeader("Cache-control", "private");
                        response.setDateHeader("Expires", 0);
                        // HTML
                        if ("0".compareTo(formatoSalida) == 0) {
                            response.setContentType("text/html");
                            response.setHeader("Content-Disposition", "inline; filename=\"SICLIR0450.html\"");
                            exportador = new JRHtmlExporter();
                            exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                            exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                            exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI, "image?image=");
                            exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                            exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(2.0));
                            exportador.exportReport();
                            servletOutputStream = response.getOutputStream();
                            response.setContentLength(baos.size());
                            baos.writeTo(servletOutputStream);
                            // EXCEL
                        } else if ("1".compareTo(formatoSalida) == 0) {
                            response.setContentType("application/vnd.ms-excel");
                            response.setHeader("Content-Disposition", "attachment; filename=\"SICLIR0450.xls\"");
                            exportador = new JRXlsExporter();
                            exportador.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
                            exportador.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baos);
                            exportador.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                            exportador.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                            exportador.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
                            exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.FALSE);
                            exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.FALSE);
                            exportador.exportReport();
                            servletOutputStream = response.getOutputStream();
                            response.setContentLength(baos.size());
                            baos.writeTo(servletOutputStream);
                            // PDF
                        } else {
                            response.setContentType("application/pdf");
                            response.setHeader("Content-Disposition", "attachment; filename=\"SICLIR0450.pdf\"");
                            exportador = new JRPdfExporter();
                            exportador.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
                            exportador.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, baos);
                            exportador.exportReport();
                            servletOutputStream = response.getOutputStream();
                            response.setContentLength(baos.size());
                            baos.writeTo(servletOutputStream);
                        }
                        baos.flush();
                        baos.close();
                        isAnswerReport = true;
                    } catch (Exception ex) {
                        logger.info(" Error al generar SICLIR0450:" + ex);
                        ex.printStackTrace();
                    } finally {
                        conOracle.Desconectar();
                    }
                } //Reporte 0460
                else if (action.equals("SICLIR0460")) {
                    url = "/SICLIR0460Header.jsp";
                } else if (action.equals("SICLIR0460Main")) {
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

                    metodo = new ControllerMethod();

                    try {
                        metodo.Oparticiones(initDate, endDate, session);
                        url = value.valida(session, initDate, endDate, "Siclir0460");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0461
                else if (action.equals("SICLIR0461")) {
                    url = "/SICLIR0461Header.jsp";
                } else if (action.equals("SICLIR0461Main")) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);

                    metodo = new ControllerMethod();

                    try {

                        metodo.Oparticiones(initDate, endDate, session);
                        url = value.valida(session, initDate, endDate, "Siclir0461");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0462
                else if (action.equals("SICLIR0462")) {
                    url = "/SICLIR0462Header.jsp";
                } else if (action.equals("SICLIR0462Main")) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String[] bancoAdqArray = request.getParameterValues("bancoAdq");
                    String bancoAdq = "";
                    for (String banco : bancoAdqArray) {
                        if (!bancoAdq.equals("")) {
                            bancoAdq += ",";
                        }
                        bancoAdq += banco;
                    }

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancoAdq);

                    metodo = new ControllerMethod();

                    try {
                        metodo.Oparticiones(initDate, endDate, session);
                        url = value.valida(session, initDate, endDate, "Siclir0462");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Siclir0010
                else if (action.equals("SICLIR0010")) {
                    url = "/SICLIR0010Header.jsp";
                } else if (action.equals("SICLIR0010Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoEmi = request.getParameter("bancoEmi");
                    String[] bancoSocioArray = request.getParameterValues("banco");
                    String bancosSocios = "";
                    for (String banco : bancoSocioArray) {
                        if (!bancosSocios.equals("")) {
                            bancosSocios += ",";
                        }
                        bancosSocios += banco;
                    }
                    String[] tipoLiqArray = request.getParameterValues("tipoLiq");
                    String tiposLiq = "";
                    for (String tipoLiq : tipoLiqArray) {
                        if (!tiposLiq.equals("")) {
                            tiposLiq += ",";
                        }
                        tiposLiq += tipoLiq;
                    }

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosSocios);
                    session.setAttribute("tipoLiq", tiposLiq);
                    try {
                        url = value.valida(session, initDate, endDate, "Siclir0010");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Siclir0011
                else if (action.equals("SICLIR0011")) {
                    url = "/SICLIR0011Header.jsp";
                } else if (action.equals("SICLIR0011Main")) {
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
                        url = value.valida(session, initDate, endDate, "Siclir0011");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0020
                else if (action.equals("SICLIR0020")) {
                    url = "/SICLIR0020Header.jsp";
                } else if (action.equals("SICLIR0020Main")) {
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
                        metodo = new ControllerMethod();
                        metodo.Oparticionesdiaant(initDate, endDate, initDate, endDate, session);
                        url = value.valida(session, initDate, endDate, "Siclir0020");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0030
                else if (action.equals("SICLIR0030")) {
                    url = "/SICLIR0030Header.jsp";
                } else if (action.equals("SICLIR0030Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);

                    try {
                        metodo = new ControllerMethod();
                        metodo.Oparticionesdiaant(initDate, endDate, initDate, endDate, session);
                        url = value.valida(session, initDate, endDate, "Siclir0030");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0040
                else if (action.equals("SICLIR0040")) {
                    url = "/SICLIR0040Header.jsp";
                } else if (action.equals("SICLIR0040Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);

                    try {
                        metodo = new ControllerMethod();
                        metodo.Oparticionesdiaant(initDate, endDate, initDate, endDate, session);
                        url = value.valida(session, initDate, endDate, "Siclir0040");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0040
                else if (action.equals("SICLIRPA01")) {
                    Collection listado = new ArrayList();
                    String accion = "";
                    String feIni = "";
                    String feFin = "";
                    SICLIRPA01DAO modelo = new SICLIRPA01DAO();
                    Collection resultados = new ArrayList();
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                    java.sql.Date fechaIni = null;
                    java.sql.Date fechaFin = null;
                    Calendar currenttime = Calendar.getInstance();
                    SICLIRPA01Form forma = new SICLIRPA01Form();
                    String grupo = (String) session.getAttribute("role");
                    String rutaReportes = getServletContext().getRealPath("reports");
                    String rutaImagenes = getServletContext().getRealPath("pics");
                    ImageIcon icono = new ImageIcon(rutaImagenes + "/logoProsa.png");
                    FileInputStream fis = null;
                    BufferedInputStream bufferedInputStream = null;
                    JasperReport reporte = null;
                    JRBeanCollectionDataSource dsR = null;
                    JasperPrint jasperPrint = null;
                    JRExporter exportador = null;
                    ServletOutputStream servletOutputStream = null;
                    Map parametros = new HashMap();
                    String usuario = (String) session.getAttribute("login");
                    String formatoSalida = null;
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();

                    url = "/SICLIRPA01.jsp";

                    // OBTIENE LA FECHA ACTUAL, ZONA HORARIA DE MEXICO
                    currenttime.setTimeZone(TimeZone.getTimeZone("GMT-06:00"));

                    // OBTIENE LA FECHA DEFAULT DE INICIO Y FIN
                    // FIN ES LA FECHA ACTUAL, INICIO ES UN MES ATRAS
                    fechaFin = new java.sql.Date((currenttime.getTime()).getTime());
                    currenttime.add(Calendar.MONTH, -1);
                    fechaIni = new java.sql.Date((currenttime.getTime()).getTime());

                    accion = request.getParameter("accion");

                    if (accion == null) {
                        accion = "";
                    }

                    // LA ACCION ES BLANCO, INICIALIZA
                    if ("".compareTo(accion) == 0) {
                        feIni = formatoFecha.format(fechaIni);
                        feFin = formatoFecha.format(fechaFin);
                        // PONE LOS DATOS EN BLANCO
                        // DATOS ELEGIDOS MAS LISTADO OBTENIDO
                        forma.setAccion("1");
                        forma.setFechaInicio(feIni);
                        forma.setFechaFinal(feFin);
                        session.setAttribute("datos", forma);
                        // LA ACCION ES 0, CANCELAR
                    } else if ("0".compareTo(accion) == 0) {
                        url = "/index.jsp";
                    } else {
                        try {
                            fis = new FileInputStream(rutaReportes + "/SICLIRPA01.jasper");
                            bufferedInputStream = new BufferedInputStream(fis);
                            reporte = (JasperReport) JRLoader.loadObject(bufferedInputStream);

                            // PONE LOS CRITERIOS
                            parametros.put("logo", icono.getImage());
                            parametros.put("usuario", usuario);
                            parametros.put("ini", request.getParameter("fechaInicio"));
                            parametros.put("fin", request.getParameter("fechaFinal"));

                            formatoSalida = request.getParameter("formato");
                            // HTML
                            if ("0".compareTo(formatoSalida) == 0) {
                                parametros.put("titulo", new Integer(1));
                                // EXCEL
                            } else if ("1".compareTo(formatoSalida) == 0) {
                                parametros.put("titulo", new Integer(0));
                                // PDF
                            } else {
                                parametros.put("titulo", new Integer(1));
                            }

                            if (logger != null) {
                                logger.info(session.getId() + ":" + "El usuario " + this.session.getAttribute("login").toString()
                                        + " genero el reporte SICLIRPA01 con parametros:FechaIni["
                                        + request.getParameter("fechaInicio") + "],FechaFin[" + request.getParameter("fechaFinal") + "]");
                            }

                            // GENERA EL REPORTE
                            resultados = modelo.consultaSICLIRPA01(request.getParameter("fechaInicio"), request.getParameter("fechaFinal"));
                            dsR = new JRBeanCollectionDataSource(resultados);
                            jasperPrint = JasperFillManager.fillReport(reporte, parametros, dsR);

                            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

                            response.setHeader("Pragma", "no-cache");
                            response.setHeader("Cache-control", "private");
                            response.setDateHeader("Expires", 0);

                            // HTML
                            if ("0".compareTo(formatoSalida) == 0) {
                                response.setContentType("text/html");
                                response.setHeader("Content-Disposition", "inline; filename=\"SICLIRPA01.html\"");
                                exportador = new JRHtmlExporter();
                                exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                                exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI, "image?image=");
                                exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                                exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(2.0));
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                                // EXCEL
                            } else if ("1".compareTo(formatoSalida) == 0) {
                                response.setContentType("application/vnd.ms-excel");
                                response.setHeader("Content-Disposition", "attachment; filename=\"SICLIRPA01.xls\"");
                                exportador = new JRXlsExporter();
                                exportador.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baos);
                                exportador.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                                exportador.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                                exportador.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
                                exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.FALSE);
                                exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.FALSE);
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                                // PDF
                            } else {
                                response.setContentType("application/pdf");
                                response.setHeader("Content-Disposition", "attachment; filename=\"SICLIRPA01.pdf\"");
                                exportador = new JRPdfExporter();
                                exportador.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, baos);
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                            }
                            baos.flush();
                            baos.close();
                            isAnswerReport = true;
                        } catch (Exception ex) {
                            System.out.println(" Error al generar SICCMR0060:" + ex);
                            ex.printStackTrace();
                        }
                    }
                } //Reporte siclir0500
                else if (action.equals("SICLIR0500")) {
                    url = "/SICLIR0500Header.jsp";
                } else if (action.equals("SICLIR0500Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String[] bancoArray = request.getParameterValues("banco");
                    String bancoAdq = "";
                    for (String banco : bancoArray) {
                        if (!bancoAdq.equals("")) {
                            bancoAdq += ",";
                        }
                        bancoAdq += banco;
                    }

                    session.setAttribute("initDate", initDate);
                    session.setAttribute("endDate", endDate);
                    session.setAttribute("banco", bancoAdq);
                    try {
                        url = value.valida(session, initDate, endDate, "Siclir0500");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte siclir0501
                else if (action.equals("SICLIR0501")) {
                    url = "/SICLIR0501Header.jsp";
                } else if (action.equals("SICLIR0501Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String[] bancoArray = request.getParameterValues("banco");
                    String bancoAdq = "";
                    for (String banco : bancoArray) {
                        if (!bancoAdq.equals("")) {
                            bancoAdq += ",";
                        }
                        bancoAdq += banco;
                    }

                    session.setAttribute("initDate", initDate);
                    session.setAttribute("endDate", endDate);
                    session.setAttribute("banco", bancoAdq);
                    try {
                        url = value.valida(session, initDate, endDate, "Siclir0501");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } /*Modificacion: Marca de inicio ENOVA-VHMG Z-04-3155-11*/ else if (action.equals("SICLIF0301")) {
                    url = "/SICLIF0301F.jsp";
                } /*Modificacion: Marca de terminacion ENOVA-VHMG Z-04-3155-11*/ //Reporte 0110
                else if (action.equals("SICLIR0110")) {
                    url = "/SICLIR0110Header.jsp";
                } else if (action.equals("SICLIR0110Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoEmi = request.getParameter("bancoEmi");
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
                        url = value.valida(session, initDate, endDate, "Siclir0110");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } /*Inicia Modificacion WELLCOM Z-09-2573-12 Alta BIN 50623 para OPAM*/ //Reporte 0110 OPAM
                else if (action.equals("SICLIR0110OPAM")) {
                    url = "/SICLIR0110OPAMHeader.jsp";
                } else if (action.equals("SICLIR0110OPAMMain")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoAdq = request.getParameter("bancoAdq");
                    String[] bancoAdqArray = request.getParameterValues("bancoAdq");
                    String bancoAdq = "";
                    for (String banco : bancoAdqArray) {
                        if (!bancoAdq.equals("")) {
                            bancoAdq += ",";
                        }
                        bancoAdq += banco;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancoAdq);
                    try {
                        url = value.valida(session, initDate, endDate, "Siclir0110OPAM");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0120
                else if (action.equals("SICLIR0120")) {
                    url = "/SICLIR0120Header.jsp";
                } else if (action.equals("SICLIR0120Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String[] interredes = request.getParameterValues("interred");
                    String[] divisiones = request.getParameterValues("division");
                    //String interred = request.getParameter("interred");
                    //String division = request.getParameter("division");
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
                        url = value.valida(session, initDate, endDate, "Siclir0120");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0130
                else if (action.equals("SICLIR0130")) {
                    url = "/SICLIR0130Header.jsp";
                } else if (action.equals("SICLIR0130Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    try {
                        url = value.valida(session, initDate, endDate, "Siclir0130");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0140
                else if (action.equals("SICLIR0140")) {
                    url = "/SICLIR0140Header.jsp";
                } else if (action.equals("SICLIR0140Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    try {
                        url = value.valida(session, initDate, endDate, "Siclir0140");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0430
                else if (action.equals("SICLIR0430")) {
                    url = "/SICLIR0430Header.jsp";
                } else if (action.equals("SICLIR0430Main")) {
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

                    metodo = new ControllerMethod();

                    try {
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        try {
                            if (format.parse(initDate).compareTo(format.parse(diaHabAnt7)) > 0) {

                                metodo.Oparticiones(initDate, endDate, session);
                                url = value.valida(session, initDate, endDate, "Siclir0430");
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
                } //Reporte 0150
                else if (action.equals("SICLIR0150")) {
                    url = "/SICLIR0150Header.jsp";
                } else if (action.equals("SICLIR0150Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoEmi = request.getParameter("bancoEmi");
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
                        url = value.valida(session, initDate, endDate, "Siclir0150");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0160
                else if (action.equals("SICLIR0160")) {
                    url = "/SICLIR0160Header.jsp";
                } else if (action.equals("SICLIR0160Main")) {

                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);

                    try {
                        url = value.valida(session, initDate, endDate, "Siclir0160");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0170
                else if (action.equals("SICLIR0170")) {
                    url = "/SICLIR0170Header.jsp";
                } else if (action.equals("SICLIR0170Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String moneda = request.getParameter("moneda");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("moneda", moneda);
                    try {
                        url = value.valida(session, initDate, endDate, "Siclir0170");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0180
                else if (action.equals("SICLIR0180")) {
                    url = "/SICLIR0180Header.jsp";
                } else if (action.equals("SICLIR0180Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);

                    try {
                        url = value.valida(session, initDate, endDate, "Siclir0180");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } /*--------------------------------------------------------------------------- */ /* Marca del Cambio: AXIA-MN-P-60-2646-14 Inicia  la Modificacion 24/02/2015 */ /*----------------------------------------------------------------------------*/ ///=======Inicia Marca de cambio WELLCOM P-06-2233-13 15-05-2015 =======================
                //Reporte SICLICI200
                else if (action.equals("SICLICI200")) {
                    url = "/SICLICI200Header.jsp";
                } else if (action.equals("SICLICI200Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String natCon = request.getParameter("natCon");

                    System.out.println("SICLICI200");

                    String[] bancosAdq = request.getParameterValues("bancoAdq");
                    String bancosAdqStr = "";
                    for (String bancoAdqr : bancosAdq) {
                        if (!bancosAdqStr.equals("")) {
                            bancosAdqStr += ",";
                        }
                        bancosAdqStr += bancoAdqr;
                    }
                    String[] bancosEmi = request.getParameterValues("bancoEmi");
                    String bancosEmiStr = "";
                    for (String bancoEmir : bancosEmi) {
                        if (!bancosEmiStr.equals("")) {
                            bancosEmiStr += ",";
                        }
                        bancosEmiStr += bancoEmir;
                    }
                    String[] fuentes = request.getParameterValues("archivoAdq");
                    String fuentesStr = "";
                    for (String fuentesr : fuentes) {
                        if (!fuentesStr.equals("")) {
                            fuentesStr += ",";
                        }
                        fuentesStr += fuentesr;
                    }

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancosAdqStr);
                    session.setAttribute("bancoEmi", bancosEmiStr);
                    session.setAttribute("fuente", fuentesStr);
                    session.setAttribute("natCon", natCon);

                    try {
                        url = value.valida(session, initDate, endDate, "SICLICI200");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte SICLICP200
                else if (action.equals("SICLICP200")) {
                    url = "/SICLICP200Header.jsp";
                } else if (action.equals("SICLICP200Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String natCon = request.getParameter("natCon");

                    System.out.println("SICLICP200");

                    String[] bancosAdq = request.getParameterValues("bancoAdq");
                    String bancosAdqStr = "";
                    for (String bancoAdqr : bancosAdq) {
                        if (!bancosAdqStr.equals("")) {
                            bancosAdqStr += ",";
                        }
                        bancosAdqStr += bancoAdqr;
                    }
                    String[] bancosEmi = request.getParameterValues("bancoEmi");
                    String bancosEmiStr = "";
                    for (String bancoEmir : bancosEmi) {
                        if (!bancosEmiStr.equals("")) {
                            bancosEmiStr += ",";
                        }
                        bancosEmiStr += bancoEmir;
                    }
                    String[] fuentes = request.getParameterValues("archivoAdq");
                    String fuentesStr = "";
                    for (String fuentesr : fuentes) {
                        if (!fuentesStr.equals("")) {
                            fuentesStr += ",";
                        }
                        fuentesStr += fuentesr;
                    }

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancosAdqStr);
                    session.setAttribute("bancoEmi", bancosEmiStr);
                    session.setAttribute("fuente", fuentesStr);
                    session.setAttribute("natCon", natCon);

                    try {
                        url = value.valida(session, initDate, endDate, "SICLICP200");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte SICLICC200
                else if (action.equals("SICLICC200")) {
                    url = "/SICLICC200Header.jsp";
                } else if (action.equals("SICLICC200Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String natCon = request.getParameter("natCon");

                    System.out.println("SICLICC200");

                    String[] bancosAdq = request.getParameterValues("bancoAdq");
                    String bancosAdqStr = "";
                    for (String bancoAdqr : bancosAdq) {
                        if (!bancosAdqStr.equals("")) {
                            bancosAdqStr += ",";
                        }
                        bancosAdqStr += bancoAdqr;
                    }
                    String[] bancosEmi = request.getParameterValues("bancoEmi");
                    String bancosEmiStr = "";
                    for (String bancoEmir : bancosEmi) {
                        if (!bancosEmiStr.equals("")) {
                            bancosEmiStr += ",";
                        }
                        bancosEmiStr += bancoEmir;
                    }
                    String[] fuentes = request.getParameterValues("archivoAdq");
                    String fuentesStr = "";
                    for (String fuentesr : fuentes) {
                        if (!fuentesStr.equals("")) {
                            fuentesStr += ",";
                        }
                        fuentesStr += fuentesr;
                    }

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancosAdqStr);
                    session.setAttribute("bancoEmi", bancosEmiStr);
                    session.setAttribute("fuente", fuentesStr);
                    session.setAttribute("natCon", natCon);

                    try {
                        url = value.valida(session, initDate, endDate, "SICLICC200");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte SICLICE300
                else if (action.equals("SICLICE300")) {
                    url = "/SICLICE300Header.jsp";
                } else if (action.equals("SICLICE300Main")) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String diaHabAnt = (String) session.getAttribute("diaHabAnt");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");

                    String[] bancosAdq = request.getParameterValues("bancoAdq");
                    String bancosAdqStr = "";
                    for (String bancoAdqr : bancosAdq) {
                        if (!bancosAdqStr.equals("")) {
                            bancosAdqStr += ",";
                        }
                        bancosAdqStr += bancoAdqr;
                    }

                    String[] bancosEmi = request.getParameterValues("bancoEmi");
                    String bancosEmiStr = "";
                    for (String bancoEmir : bancosEmi) {
                        if (!bancosEmiStr.equals("")) {
                            bancosEmiStr += ",";
                        }
                        bancosEmiStr += bancoEmir;
                    }

                    String[] fuentes = request.getParameterValues("archivoAdq");
                    if (fuentes == null) {
                        fuentes = new String[0];
                    }
                    String fuentesStr = "";
                    for (String fuentesr : fuentes) {
                        if (!fuentesStr.equals("")) {
                            fuentesStr += ",";
                        }
                        fuentesStr += fuentesr;
                    }

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancosAdqStr);
                    session.setAttribute("bancoEmi", bancosEmiStr);
                    session.setAttribute("fuente", fuentesStr);

                    metodo = new ControllerMethod();

                    try {
                        try {
//                   if(format.parse(initDate).compareTo(format.parse(diaHabAnt7))>0)
//                   {
                            metodo.Oparticion(initDate, session);
                            url = "/reportsjsp/managerReports.jsp" + "?report=" + "SICLICE300";
                            viewerManager.setUpViewer(this, request, response, url);
                            isAnswerReport = true;
//                   }
//                   else
//                       url = "/fechasInvalidas.jsp?noPantalla=4";
                        } catch (Exception ex) {
                            throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                        }
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte c110
                else if (action.equals("SICLIRC110")) {
                    url = "/SICLIRC110Header.jsp";
                } else if (action.equals("SICLIRC110Main")) {
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

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoEmi", bancosEmi);
                    try {
                        url = value.valida(session, initDate, endDate, "Siclirc110");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte c120
                else if (action.equals("SICLIRC120")) {
                    url = "/SICLIRC120Header.jsp";
                } else if (action.equals("SICLIRC120Main")) {
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
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoEmi", bancosEmi);
                    try {
                        url = value.valida(session, initDate, endDate, "Siclirc120");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte SICLICA170
                else if (action.equals("SICLICA170")) {
                    url = "/SICLICA170Header.jsp";
                } else if (action.equals("SICLICA170Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");

                    System.out.println("SICLICA170");

                    String[] bancosAdq = request.getParameterValues("bancoAdq");
                    String bancosAdqStr = "";
                    for (String bancoAdqr : bancosAdq) {
                        if (!bancosAdqStr.equals("")) {
                            bancosAdqStr += ",";
                        }
                        bancosAdqStr += bancoAdqr;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancosAdqStr);

                    try {
                        url = value.valida(session, initDate, endDate, "SICLICA170");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte SICLICE170
                else if (action.equals("SICLICE170")) {
                    url = "/SICLICE170Header.jsp";
                } else if (action.equals("SICLICE170Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");

                    System.out.println("SICLICE170");

                    String[] bancosEmi = request.getParameterValues("bancoEmi");//bancoEmi
                    String bancosEmiStr = "";
                    for (String bancoEmir : bancosEmi) {
                        if (!bancosEmiStr.equals("")) {
                            bancosEmiStr += ",";
                        }
                        bancosEmiStr += bancoEmir;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoEmi", bancosEmiStr);

                    try {
                        url = value.valida(session, initDate, endDate, "SICLICE170");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } ///=======Fin Marca de cambio WELLCOM P-06-2233-13 15-05-2015 =======================
                /*--------------------------------------------------------------------------- */ /* Marca del Cambio: AXIA-MN-P-60-2646-14 Termina la Modificacion 24/02/2015 */ /*----------------------------------------------------------------------------*/ //Reporte 0060
                else if (action.equals("SICLIF0060")) {
                    url = "/SICLIF0060Header.jsp";
                } else if (action.equals("SICLIF0060Main")) {
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

                    metodo = new ControllerMethod();

                    try {
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        session.setAttribute("initDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                        session.setAttribute("endDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                        metodo.Oparticionesdiaant(initDate, endDate, initDate, endDate, session);
                        url = value.valida(session, initDate, endDate, "Siclif0060");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (action.equals("SICLIR0200")) {
                    url = "/SICLIR0200Header.jsp";
                } else if (action.equals("SICLIR0200Main")) {
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
                        url = value.valida(session, initDate, endDate, "Siclir0200");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (ParseException pe) {
                        pe.printStackTrace();
                    }
                } //Reporte 0320
                else if (action.equals("SICLIR0320")) {
                    url = "/SICLIR0320Header.jsp";
                } else if (action.equals("SICLIR0320Main")) {
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
                    if (tipoLiqStr.contains("21")) {
                        tipoLiqStr += ",27";
                    }

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("tipoLiq", tipoLiqStr);
                    try {
                        session.setAttribute("initDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                        session.setAttribute("endDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                        url = value.valida(session, initDate, endDate, "Siclir0320");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } //Reporte P320
                else if (action.equals("SICLIRP320")) {
                    url = "/SICLIRP320Header.jsp";
                } else if (action.equals("SICLIRP320Main")) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    try {
                        url = value.valida(session, initDate, endDate, "Siclirpago320");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } //Reporte 0360
                else if (action.equals("SICMOR0360")) {
                    url = "/SICMOR0360Header.jsp";
                } else if (action.equals("SICMOR0360Main")) {
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
                            conOracle = new ConexionORACLE();
                            metodo = new ControllerMethod();
                            if (format.parse(initDate).compareTo(format.parse(diaHabAnt7)) > 0) {
                                metodo.Oparticiones(initDate, endDate, session);
                                url = value.valida(session, initDate, endDate, "Sicmor0360");
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
                } // GSOF-MVR-P-53-2727-14 Marca de Inicio
                else if (action.equals("SICCMR0001")) {
                    Collection listado = new ArrayList();
                    String accion = "";
                    String feIni = "";
                    String feFin = "";
                    SICCMRDAO modelo = new SICCMRDAO();
                    Collection bancosE = new ArrayList();
                    Collection camarasA = new ArrayList();
                    Collection marcas = new ArrayList();
                    Collection resultados = new ArrayList();
                    CriteriosObj criterios = new CriteriosObj();
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                    java.sql.Date fechaIni = null;
                    java.sql.Date fechaFin = null;
                    Calendar currenttime = Calendar.getInstance();
                    SICCMR0001Form forma = new SICCMR0001Form();
                    String grupo = (String) session.getAttribute("role");
                    String fiidUsuario = (String) session.getAttribute("numFiid");
                    String owner = "";
                    String rutaReportes = getServletContext().getRealPath("reports");
                    String rutaImagenes = getServletContext().getRealPath("pics");
                    ImageIcon icono = new ImageIcon(ImageIO.read(new File(rutaImagenes + "/logoProsa.png")));
                    FileInputStream fis = null;
                    BufferedInputStream bufferedInputStream = null;
                    JasperReport reporte = null;
                    JRBeanCollectionDataSource dsR = null;
                    JasperPrint jasperPrint = null;
                    JRExporter exportador = null;
                    ServletOutputStream servletOutputStream = null;
                    Map parametros = new HashMap();
                    String usuario = (String) session.getAttribute("login");
                    String formatoSalida = null;
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();

                    url = "/SICCMR0001.jsp";

                    // OBTIENE LA FECHA ACTUAL, ZONA HORARIA DE MEXICO
                    currenttime.setTimeZone(TimeZone.getTimeZone("GMT-06:00"));

                    // OBTIENE LAS LISTAS DE CATALOGOS
                    // LOS USUARIOS DE BANCOS SOLO VEN SUS PROPIOS DATOS
                    if (("administrador".compareTo(grupo) == 0) || ("operador".compareTo(grupo) == 0)) {
                        owner = "%";
                    } else {
                        owner = fiidUsuario;
                    }

                    bancosE = modelo.listarBancos001002();
                    camarasA = modelo.listarCamaras();
                    marcas = modelo.listarMarcas();

                    // OBTIENE LA FECHA DEFAULT DE INICIO Y FIN
                    // FIN ES LA FECHA ACTUAL, INICIO ES UN MES ATRAS
                    fechaFin = new java.sql.Date((currenttime.getTime()).getTime());
                    currenttime.add(Calendar.MONTH, -1);
                    fechaIni = new java.sql.Date((currenttime.getTime()).getTime());

                    accion = request.getParameter("accion");

                    if (accion == null) {
                        accion = "";
                    }
                    // LA ACCION ES BLANCO, INICIALIZA
                    if ("".compareTo(accion) == 0) {
                        feIni = formatoFecha.format(fechaIni);
                        feFin = formatoFecha.format(fechaFin);
                        // PONE LOS DATOS EN BLANCO
                        // DATOS ELEGIDOS MAS LISTADO OBTENIDO
                        forma.setAccion("1");
                        forma.setFechaInicio(feIni);
                        forma.setFechaFinal(feFin);
                        forma.setBancosE(bancosE);
                        forma.setCamarasA(camarasA);
                        forma.setMarcas(marcas);
                        session.setAttribute("datos", forma);
                        // LA ACCION ES 0, CANCELAR
                    } else if ("0".compareTo(accion) == 0) {
                        url = "/index.jsp";
                    } else {
                        try {
                            // OBTIENE LOS CRITERIOS ELEGIDOS
                            feIni = request.getParameter("fechaInicio");
                            feFin = request.getParameter("fechaFinal");
                            // PONE LOS VALORES DEFAULT, SI ESTAN EN BLANCO
                            if ("".compareTo(feIni) == 0) {
                                feIni = formatoFecha.format(fechaIni);
                            }
                            if ("".compareTo(feFin) == 0) {
                                feFin = formatoFecha.format(fechaFin);
                            }
                            // PONE LOS CRITERIOS
                            criterios.setIni(feIni);
                            criterios.setFin(feFin);
                            criterios.setBancoEmi(request.getParameterValues("bancoEmi"));
                            criterios.setCamaraAdq(request.getParameterValues("camaraAdq"));
                            criterios.setMarca(request.getParameterValues("marca"));
                            criterios.setOwner(owner);

                            fis = new FileInputStream(rutaReportes + "/SICCMR0001.jasper");
                            bufferedInputStream = new BufferedInputStream(fis);
                            reporte = (JasperReport) JRLoader.loadObject(bufferedInputStream);

                            parametros.put("logo", icono.getImage());
                            parametros.put("usuario", usuario);
                            parametros.put("ini", criterios.getIni());
                            parametros.put("fin", criterios.getFin());
                            parametros.put("marca", modelo.descripcionesListaMarcas(request.getParameterValues("marca")));
                            parametros.put("camara", modelo.descripcionesListaCamaras(request.getParameterValues("camaraAdq")));
                            parametros.put("emisor", modelo.entidadesListaBancos(request.getParameterValues("bancoEmi")));

                            formatoSalida = request.getParameter("formato");
                            // HTML
                            if ("0".compareTo(formatoSalida) == 0) {
                                parametros.put("titulo", new Integer(1));
                                // EXCEL
                            } else if ("1".compareTo(formatoSalida) == 0) {
                                parametros.put("titulo", new Integer(0));
                                // PDF
                            } else {
                                parametros.put("titulo", new Integer(1));
                            }

                            if (logger != null) {
                                logger.info(session.getId() + ":" + "El usuario " + this.session.getAttribute("login").toString()
                                        + " genero el reporte SICCMR0001 con parametros:FechaIni["
                                        + criterios.getIni() + "],FechaFin[" + criterios.getFin() + "],Emisor["
                                        + modelo.listaCadenas(request.getParameterValues("bancoEmi"))
                                        + "],Marca[" + modelo.descripcionesListaMarcas(request.getParameterValues("marca"))
                                        + "],CamaraAdq[" + modelo.descripcionesListaCamaras(request.getParameterValues("camaraAdq")) + "]");
                            }
                            // GENERA EL REPORTE
                            resultados = modelo.consultarSICCMR0001(criterios);
                            dsR = new JRBeanCollectionDataSource(resultados);
                            jasperPrint = JasperFillManager.fillReport(reporte, parametros, dsR);

                            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

                            response.setHeader("Pragma", "no-cache");
                            response.setHeader("Cache-control", "private");
                            response.setDateHeader("Expires", 0);

                            // HTML
                            if ("0".compareTo(formatoSalida) == 0) {
                                response.setContentType("text/html");
                                response.setHeader("Content-Disposition", "inline; filename=\"SICCMR0001.html\"");
                                exportador = new JRHtmlExporter();
                                exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                                exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI, "image?image=");
                                exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                                exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(1.5));
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                                // EXCEL
                            } else if ("1".compareTo(formatoSalida) == 0) {
                                response.setContentType("application/vnd.ms-excel");
                                response.setHeader("Content-Disposition", "attachment; filename=\"SICCMR0001.xls\"");
                                exportador = new JRXlsExporter();
                                exportador.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baos);
                                exportador.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                                exportador.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                                exportador.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
                                exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.FALSE);
                                exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.FALSE);
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                                // PDF
                            } else {
                                response.setContentType("application/pdf");
                                response.setHeader("Content-Disposition", "attachment; filename=\"SICCMR0001.pdf\"");
                                exportador = new JRPdfExporter();
                                exportador.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, baos);
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                            }
                            baos.flush();
                            baos.close();
                            isAnswerReport = true;
                        } catch (Exception ex) {
                            System.out.println(" Error al generar SICCMR001:" + ex);
                            ex.printStackTrace();
                        }
                    }
                } else if (action.equals("SICCMR0002")) {
                    Collection listado = new ArrayList();
                    String accion = "";
                    String feIni = "";
                    String feFin = "";
                    SICCMRDAO modelo = new SICCMRDAO();
                    Collection bancosE = new ArrayList();
                    Collection bancosA = new ArrayList();
                    Collection camarasE = new ArrayList();
                    Collection marcas = new ArrayList();
                    Collection resultados = new ArrayList();
                    CriteriosObj criterios = new CriteriosObj();
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                    java.sql.Date fechaIni = null;
                    java.sql.Date fechaFin = null;
                    Calendar currenttime = Calendar.getInstance();
                    SICCMR0002Form forma = new SICCMR0002Form();
                    String grupo = (String) session.getAttribute("role");
                    String fiidUsuario = (String) session.getAttribute("numFiid");
                    String owner = "";
                    String rutaReportes = getServletContext().getRealPath("reports");
                    String rutaImagenes = getServletContext().getRealPath("pics");
                    ImageIcon icono = new ImageIcon(ImageIO.read(new File(rutaImagenes + "/logoProsa.png")));
                    FileInputStream fis = null;
                    BufferedInputStream bufferedInputStream = null;
                    JasperReport reporte = null;
                    JRBeanCollectionDataSource dsR = null;
                    JasperPrint jasperPrint = null;
                    JRExporter exportador = null;
                    ServletOutputStream servletOutputStream = null;
                    Map parametros = new HashMap();
                    String usuario = (String) session.getAttribute("login");
                    String formatoSalida = null;
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();

                    url = "/SICCMR0002.jsp";

                    // OBTIENE LA FECHA ACTUAL, ZONA HORARIA DE MEXICO
                    currenttime.setTimeZone(TimeZone.getTimeZone("GMT-06:00"));

                    // OBTIENE LAS LISTAS DE CATALOGOS
                    // LOS USUARIOS DE BANCOS SOLO VEN SUS PROPIOS DATOS
                    if (("administrador".compareTo(grupo) == 0) || ("operador".compareTo(grupo) == 0)) {
                        bancosA = modelo.listarBancos();
                        owner = "%";
                    } else {
                        bancosA = modelo.nombresBancos(modelo.convierteCadena(fiidUsuario));
                        owner = fiidUsuario;
                    }

                    bancosE = modelo.listarBancos001002();
                    camarasE = modelo.listarCamaras();
                    marcas = modelo.listarMarcas();

                    // OBTIENE LA FECHA DEFAULT DE INICIO Y FIN
                    // FIN ES LA FECHA ACTUAL, INICIO ES UN MES ATRAS
                    fechaFin = new java.sql.Date((currenttime.getTime()).getTime());
                    currenttime.add(Calendar.MONTH, -1);
                    fechaIni = new java.sql.Date((currenttime.getTime()).getTime());

                    accion = request.getParameter("accion");

                    if (accion == null) {
                        accion = "";
                    }

                    // LA ACCION ES BLANCO, INICIALIZA
                    if ("".compareTo(accion) == 0) {
                        feIni = formatoFecha.format(fechaIni);
                        feFin = formatoFecha.format(fechaFin);
                        // PONE LOS DATOS EN BLANCO
                        // DATOS ELEGIDOS MAS LISTADO OBTENIDO
                        forma.setAccion("1");
                        forma.setFechaInicio(feIni);
                        forma.setFechaFinal(feFin);
                        forma.setBancosA(bancosA);
                        forma.setBancosE(bancosE);
                        forma.setCamarasE(camarasE);
                        forma.setMarcas(marcas);
                        session.setAttribute("datos", forma);
                        // LA ACCION ES 0, CANCELAR
                    } else if ("0".compareTo(accion) == 0) {
                        url = "/index.jsp";
                    } else {
                        try {
                            // PONE LOS CRITERIOS
                            criterios.setIni(request.getParameter("fechaInicio"));
                            criterios.setFin(request.getParameter("fechaFinal"));
                            criterios.setBancoEmi(request.getParameterValues("bancoEmi"));
                            criterios.setBancoAdq(request.getParameterValues("bancoAdq"));
                            criterios.setCamaraEmi(request.getParameterValues("camaraEmi"));
                            criterios.setMarca(request.getParameterValues("marca"));
                            criterios.setOwner(owner);

                            fis = new FileInputStream(rutaReportes + "/SICCMR0002.jasper");
                            bufferedInputStream = new BufferedInputStream(fis);
                            reporte = (JasperReport) JRLoader.loadObject(bufferedInputStream);

                            parametros.put("logo", icono.getImage());
                            parametros.put("usuario", usuario);
                            parametros.put("ini", criterios.getIni());
                            parametros.put("fin", criterios.getFin());
                            parametros.put("marca", modelo.descripcionesListaMarcas(request.getParameterValues("marca")));
                            parametros.put("camara", modelo.descripcionesListaCamaras(request.getParameterValues("camaraEmi")));
                            parametros.put("emisor", modelo.entidadesListaBancos(request.getParameterValues("bancoEmi")));
                            parametros.put("adquirente", modelo.entidadesListaBancos(request.getParameterValues("bancoAdq")));

                            formatoSalida = request.getParameter("formato");
                            // HTML
                            if ("0".compareTo(formatoSalida) == 0) {
                                parametros.put("titulo", new Integer(1));
                                // EXCEL
                            } else if ("1".compareTo(formatoSalida) == 0) {
                                parametros.put("titulo", new Integer(0));
                                // PDF
                            } else {
                                parametros.put("titulo", new Integer(1));
                            }

                            if (logger != null) {
                                logger.info(session.getId() + ":" + "El usuario " + this.session.getAttribute("login").toString()
                                        + " genero el reporte SICCMR0002 con parametros:FechaIni["
                                        + criterios.getIni() + "],FechaFin[" + criterios.getFin() + "],Emisor["
                                        + modelo.listaCadenas(request.getParameterValues("bancoEmi")) + "],Adquirente["
                                        + modelo.listaCadenas(request.getParameterValues("bancoAdq"))
                                        + "],Marca[" + modelo.descripcionesListaMarcas(request.getParameterValues("marca"))
                                        + "],CamaraEmi[" + modelo.descripcionesListaCamaras(request.getParameterValues("camaraEmi")) + "]");
                            }

                            // GENERA EL REPORTE
                            resultados = modelo.consultarSICCMR0002(criterios);
                            dsR = new JRBeanCollectionDataSource(resultados);
                            jasperPrint = JasperFillManager.fillReport(reporte, parametros, dsR);

                            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

                            response.setHeader("Pragma", "no-cache");
                            response.setHeader("Cache-control", "private");
                            response.setDateHeader("Expires", 0);

                            // HTML
                            if ("0".compareTo(formatoSalida) == 0) {
// GSOF-MVR-P-53-2727-14 Marca de Inicio
                                if (logger != null) {
                                    logger.info(session.getId() + ":" + "processRequestContinua2. Generando HTML del reporte SICCMR0002");
                                }
// GSOF-MVR-P-53-2727-14 Marca de Terminacion
                                response.setContentType("text/html");
                                response.setHeader("Content-Disposition", "inline; filename=\"SICCMR0002.html\"");
                                exportador = new JRHtmlExporter();
                                exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                                exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI, "image?image=");
                                exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                                exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(1.5));
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                                // EXCEL
                            } else if ("1".compareTo(formatoSalida) == 0) {
// GSOF-MVR-P-53-2727-14 Marca de Inicio
                                if (logger != null) {
                                    logger.info(session.getId() + ":" + "processRequestContinua2. Generando EXCEL del reporte SICCMR0002");
                                }
// GSOF-MVR-P-53-2727-14 Marca de Terminacion
                                response.setContentType("application/vnd.ms-excel");
                                response.setHeader("Content-Disposition", "attachment; filename=\"SICCMR0002.xls\"");
                                exportador = new JRXlsExporter();
                                exportador.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baos);
                                exportador.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                                exportador.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                                exportador.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
                                exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.FALSE);
                                exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.FALSE);
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                                // PDF
                            } else {
// GSOF-MVR-P-53-2727-14 Marca de Inicio
                                if (logger != null) {
                                    logger.info(session.getId() + ":" + "processRequestContinua2. Generando PDF del reporte SICCMR0002");
                                }
// GSOF-MVR-P-53-2727-14 Marca de Terminacion
                                response.setContentType("application/pdf");
                                response.setHeader("Content-Disposition", "attachment; filename=\"SICCMR0002.pdf\"");
                                exportador = new JRPdfExporter();
                                exportador.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, baos);
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                            }
                            baos.flush();
                            baos.close();
                            isAnswerReport = true;
                        } catch (Exception ex) {
                            System.out.println(" Error al generar SICCMR0002:" + ex);
                            ex.printStackTrace();
                        }
                    }
                } else if (action.equals("SICCMR0050")) {
                    Collection listado = new ArrayList();
                    String accion = "";
                    String feIni = "";
                    String feFin = "";
                    SICCMRDAO modelo = new SICCMRDAO();
                    Collection bancosE = new ArrayList();
                    Collection camarasE = new ArrayList();
                    Collection resultados = new ArrayList();
                    CriteriosObj criterios = new CriteriosObj();
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                    java.sql.Date fechaIni = null;
                    java.sql.Date fechaFin = null;
                    Calendar currenttime = Calendar.getInstance();
                    SICCMR0050Form forma = new SICCMR0050Form();
                    String grupo = (String) session.getAttribute("role");
                    String fiidUsuario = (String) session.getAttribute("numFiid");
                    String owner = "";
                    String rutaReportes = getServletContext().getRealPath("reports");
                    String rutaImagenes = getServletContext().getRealPath("pics");
                    ImageIcon icono = new ImageIcon(ImageIO.read(new File(rutaImagenes + "/logoProsa.png")));
                    FileInputStream fis = null;
                    BufferedInputStream bufferedInputStream = null;
                    JasperReport reporte = null;
                    JRBeanCollectionDataSource dsR = null;
                    JasperPrint jasperPrint = null;
                    JRExporter exportador = null;
                    ServletOutputStream servletOutputStream = null;
                    Map parametros = new HashMap();
                    String usuario = (String) session.getAttribute("login");
                    String formatoSalida = null;
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();

                    url = "/SICCMR0050.jsp";

                    // OBTIENE LA FECHA ACTUAL, ZONA HORARIA DE MEXICO
                    currenttime.setTimeZone(TimeZone.getTimeZone("GMT-06:00"));

                    // OBTIENE LAS LISTAS DE CATALOGOS
                    bancosE = modelo.listarBancosTodos();
                    camarasE = modelo.listarCamarasEglo();

                    // LOS USUARIOS DE BANCOS SOLO VEN SUS PROPIOS DATOS
                    if (("administrador".compareTo(grupo) == 0) || ("operador".compareTo(grupo) == 0)) {
                        owner = "%";

                        // AGREGA EL ELEMENTO CONSOLIDADO
                        EstructuraListaObj consolidado = new EstructuraListaObj();
                        consolidado.setClave("999999");
                        consolidado.setDescripcion("CONSOLIDADO");
                        bancosE.add(consolidado);
                    } else {
                        owner = fiidUsuario;
                    }

                    // OBTIENE LA FECHA DEFAULT DE INICIO Y FIN
                    // FIN ES LA FECHA ACTUAL, INICIO ES UN MES ATRAS
                    fechaFin = new java.sql.Date((currenttime.getTime()).getTime());
                    currenttime.add(Calendar.MONTH, -1);
                    fechaIni = new java.sql.Date((currenttime.getTime()).getTime());

                    accion = request.getParameter("accion");

                    if (accion == null) {
                        accion = "";
                    }

                    // LA ACCION ES BLANCO, INICIALIZA
                    if ("".compareTo(accion) == 0) {
                        feIni = formatoFecha.format(fechaIni);
                        feFin = formatoFecha.format(fechaFin);
                        // PONE LOS DATOS EN BLANCO
                        // DATOS ELEGIDOS MAS LISTADO OBTENIDO
                        forma.setAccion("1");
                        forma.setFechaInicio(feIni);
                        forma.setFechaFinal(feFin);
                        forma.setBancosE(bancosE);
                        forma.setCamarasE(camarasE);
                        session.setAttribute("datos", forma);
                        // LA ACCION ES 0, CANCELAR
                    } else if ("0".compareTo(accion) == 0) {
                        url = "/index.jsp";
                    } else {
                        try {
                            // PONE LOS CRITERIOS
                            criterios.setIni(request.getParameter("fechaInicio"));
                            criterios.setFin(request.getParameter("fechaFinal"));
                            criterios.setBancoEmi(request.getParameterValues("bancoEmi"));
                            criterios.setCamaraEmi(request.getParameterValues("camaraEmi"));
                            criterios.setOwner(owner);

                            fis = new FileInputStream(rutaReportes + "/SICCMR0050.jasper");
                            bufferedInputStream = new BufferedInputStream(fis);
                            reporte = (JasperReport) JRLoader.loadObject(bufferedInputStream);

                            parametros.put("logo", icono.getImage());
                            parametros.put("usuario", usuario);
                            parametros.put("ini", criterios.getIni());
                            parametros.put("fin", criterios.getFin());
                            parametros.put("camara", modelo.descripcionesListaCamaras(request.getParameterValues("camaraEmi")));

                            formatoSalida = request.getParameter("formato");
                            // HTML
                            if ("0".compareTo(formatoSalida) == 0) {
                                parametros.put("titulo", new Integer(1));
                                // EXCEL
                            } else if ("1".compareTo(formatoSalida) == 0) {
                                parametros.put("titulo", new Integer(0));
                                // PDF
                            } else {
                                parametros.put("titulo", new Integer(1));
                            }

                            if (criterios.getBancoEmi().indexOf("999999") > -1) {
                                parametros.put("banco", "CONSOLIDADO");
                            } else {
                                parametros.put("banco", modelo.listaCadenas(request.getParameterValues("bancoEmi")));
                            }

                            if (logger != null) {
                                logger.info(session.getId() + ":" + "El usuario " + this.session.getAttribute("login").toString()
                                        + " genero el reporte SICCMR0050 con parametros:FechaIni["
                                        + criterios.getIni() + "],FechaFin[" + criterios.getFin() + "],Emisor["
                                        + modelo.listaCadenas(request.getParameterValues("bancoEmi"))
                                        + "],CamaraEmi[" + modelo.descripcionesListaCamaras(request.getParameterValues("camaraEmi")) + "]");
                            }

                            // GENERA EL REPORTE
                            resultados = modelo.consultar0050(criterios);
                            dsR = new JRBeanCollectionDataSource(resultados);
                            jasperPrint = JasperFillManager.fillReport(reporte, parametros, dsR);

                            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

                            response.setHeader("Pragma", "no-cache");
                            response.setHeader("Cache-control", "private");
                            response.setDateHeader("Expires", 0);

                            // HTML
                            if ("0".compareTo(formatoSalida) == 0) {
                                response.setContentType("text/html");
                                response.setHeader("Content-Disposition", "inline; filename=\"SICCMR0050.html\"");
                                exportador = new JRHtmlExporter();
                                exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                                exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI, "image?image=");
                                exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                                exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(1.5));
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                                // EXCEL
                            } else if ("1".compareTo(formatoSalida) == 0) {
                                response.setContentType("application/vnd.ms-excel");
                                response.setHeader("Content-Disposition", "attachment; filename=\"SICCMR0050.xls\"");
                                exportador = new JRXlsExporter();
                                exportador.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baos);
                                exportador.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                                exportador.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                                exportador.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
                                exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.FALSE);
                                exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.FALSE);
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                                // PDF
                            } else {
                                response.setContentType("application/pdf");
                                response.setHeader("Content-Disposition", "attachment; filename=\"SICCMR0050.pdf\"");
                                exportador = new JRPdfExporter();
                                exportador.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, baos);
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                            }
                            baos.flush();
                            baos.close();
                            isAnswerReport = true;
                        } catch (Exception ex) {
                            System.out.println(" Error al generar SICCMR0050:" + ex);
                            ex.printStackTrace();
                        }
                    }
                } else if (action.equals("SICCMR0060")) {
                    Collection listado = new ArrayList();
                    String accion = "";
                    String feIni = "";
                    String feFin = "";
                    SICCMRDAO modelo = new SICCMRDAO();
                    Collection bancosA = new ArrayList();
                    Collection camarasA = new ArrayList();
                    Collection resultados = new ArrayList();
                    CriteriosObj criterios = new CriteriosObj();
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                    java.sql.Date fechaIni = null;
                    java.sql.Date fechaFin = null;
                    Calendar currenttime = Calendar.getInstance();
                    SICCMR0060Form forma = new SICCMR0060Form();
                    String grupo = (String) session.getAttribute("role");
                    String fiidUsuario = (String) session.getAttribute("numFiid");
                    String owner = "";
                    String rutaReportes = getServletContext().getRealPath("reports");
                    String rutaImagenes = getServletContext().getRealPath("pics");
                    ImageIcon icono = new ImageIcon(ImageIO.read(new File(rutaImagenes + "/logoProsa.png")));
                    FileInputStream fis = null;
                    BufferedInputStream bufferedInputStream = null;
                    JasperReport reporte = null;
                    JRBeanCollectionDataSource dsR = null;
                    JasperPrint jasperPrint = null;
                    JRExporter exportador = null;
                    ServletOutputStream servletOutputStream = null;
                    Map parametros = new HashMap();
                    String usuario = (String) session.getAttribute("login");
                    String formatoSalida = null;
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();

                    url = "/SICCMR0060.jsp";

                    // OBTIENE LA FECHA ACTUAL, ZONA HORARIA DE MEXICO
                    currenttime.setTimeZone(TimeZone.getTimeZone("GMT-06:00"));

                    // OBTIENE LAS LISTAS DE CATALOGOS
                    // LOS USUARIOS DE BANCOS SOLO VEN SUS PROPIOS DATOS
                    if (("administrador".compareTo(grupo) == 0) || ("operador".compareTo(grupo) == 0)) {
                        bancosA = modelo.listarBancosTodos();
                        owner = "";

                        // AGREGA EL ELEMENTO CONSOLIDADO
                        EstructuraListaObj consolidado = new EstructuraListaObj();
                        consolidado.setClave("999999");
                        consolidado.setDescripcion("CONSOLIDADO");
                        bancosA.add(consolidado);
                    } else {
                        bancosA = modelo.nombresBancos(modelo.convierteCadena(modelo.entidadBanco(fiidUsuario)));
                        owner = fiidUsuario;
                    }

                    camarasA = modelo.listarCamarasProsa();

                    // OBTIENE LA FECHA DEFAULT DE INICIO Y FIN
                    // FIN ES LA FECHA ACTUAL, INICIO ES UN MES ATRAS
                    fechaFin = new java.sql.Date((currenttime.getTime()).getTime());
                    currenttime.add(Calendar.MONTH, -1);
                    fechaIni = new java.sql.Date((currenttime.getTime()).getTime());

                    accion = request.getParameter("accion");

                    if (accion == null) {
                        accion = "";
                    }

                    // LA ACCION ES BLANCO, INICIALIZA
                    if ("".compareTo(accion) == 0) {
                        feIni = formatoFecha.format(fechaIni);
                        feFin = formatoFecha.format(fechaFin);
                        // PONE LOS DATOS EN BLANCO
                        // DATOS ELEGIDOS MAS LISTADO OBTENIDO
                        forma.setAccion("1");
                        forma.setFechaInicio(feIni);
                        forma.setFechaFinal(feFin);
                        forma.setBancosA(bancosA);
                        forma.setCamarasA(camarasA);
                        session.setAttribute("datos", forma);
                        // LA ACCION ES 0, CANCELAR
                    } else if ("0".compareTo(accion) == 0) {
                        url = "/index.jsp";
                    } else {
                        try {
                            // PONE LOS CRITERIOS
                            criterios.setIni(request.getParameter("fechaInicio"));
                            criterios.setFin(request.getParameter("fechaFinal"));
                            criterios.setBancoAdq(request.getParameterValues("bancoAdq"));
                            criterios.setCamaraAdq(request.getParameterValues("camaraAdq"));
                            criterios.setOwner(owner);

                            fis = new FileInputStream(rutaReportes + "/SICCMR0060.jasper");
                            bufferedInputStream = new BufferedInputStream(fis);
                            reporte = (JasperReport) JRLoader.loadObject(bufferedInputStream);

                            parametros.put("logo", icono.getImage());
                            parametros.put("usuario", usuario);
                            parametros.put("ini", criterios.getIni());
                            parametros.put("fin", criterios.getFin());
                            parametros.put("camara", modelo.descripcionesListaCamaras(request.getParameterValues("camaraAdq")));

                            formatoSalida = request.getParameter("formato");
                            // HTML
                            if ("0".compareTo(formatoSalida) == 0) {
                                parametros.put("titulo", new Integer(1));
                                // EXCEL
                            } else if ("1".compareTo(formatoSalida) == 0) {
                                parametros.put("titulo", new Integer(0));
                                // PDF
                            } else {
                                parametros.put("titulo", new Integer(1));
                            }

                            if (criterios.getBancoAdq().indexOf("999999") > -1) {
                                parametros.put("banco", "CONSOLIDADO");
                            } else {
                                parametros.put("banco", modelo.listaCadenas(request.getParameterValues("bancoAdq")));
                            }

                            if (logger != null) {
                                logger.info(session.getId() + ":" + "El usuario " + this.session.getAttribute("login").toString()
                                        + " genero el reporte SICCMR0060 con parametros:FechaIni["
                                        + criterios.getIni() + "],FechaFin[" + criterios.getFin() + "],Adquirente["
                                        + modelo.listaCadenas(request.getParameterValues("bancoAdq"))
                                        + "],CamaraAdq[" + modelo.descripcionesListaCamaras(request.getParameterValues("camaraAdq")) + "]");
                            }

                            // GENERA EL REPORTE
                            resultados = modelo.consultar0060(criterios);
                            dsR = new JRBeanCollectionDataSource(resultados);
                            jasperPrint = JasperFillManager.fillReport(reporte, parametros, dsR);

                            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

                            response.setHeader("Pragma", "no-cache");
                            response.setHeader("Cache-control", "private");
                            response.setDateHeader("Expires", 0);

                            // HTML
                            if ("0".compareTo(formatoSalida) == 0) {
                                response.setContentType("text/html");
                                response.setHeader("Content-Disposition", "inline; filename=\"SICCMR0060.html\"");
                                exportador = new JRHtmlExporter();
                                exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                                exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI, "image?image=");
                                exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                                exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(1.5));
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                                // EXCEL
                            } else if ("1".compareTo(formatoSalida) == 0) {
                                response.setContentType("application/vnd.ms-excel");
                                response.setHeader("Content-Disposition", "attachment; filename=\"SICCMR0060.xls\"");
                                exportador = new JRXlsExporter();
                                exportador.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baos);
                                exportador.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                                exportador.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                                exportador.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
                                exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.FALSE);
                                exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.FALSE);
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                                // PDF
                            } else {
                                response.setContentType("application/pdf");
                                response.setHeader("Content-Disposition", "attachment; filename=\"SICCMR0060.pdf\"");
                                exportador = new JRPdfExporter();
                                exportador.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, baos);
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                            }
                            baos.flush();
                            baos.close();
                            isAnswerReport = true;
                        } catch (Exception ex) {
                            System.out.println(" Error al generar SICCMR0060:" + ex);
                            ex.printStackTrace();
                        }
                    }
                } else if (action.equals("SICCMR0065")) {
                    Collection listado = new ArrayList();
                    String accion = "";
                    String feIni = "";
                    String feFin = "";
                    SICCMRDAO modelo = new SICCMRDAO();
                    Collection bancos = new ArrayList();
                    Collection resultados = new ArrayList();
                    CriteriosObj criterios = new CriteriosObj();
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                    java.sql.Date fechaIni = null;
                    java.sql.Date fechaFin = null;
                    Calendar currenttime = Calendar.getInstance();
                    SICCMR0065Form forma = new SICCMR0065Form();
                    String grupo = (String) session.getAttribute("role");
                    String fiidUsuario = (String) session.getAttribute("numFiid");
                    String owner = "";
                    String rutaReportes = getServletContext().getRealPath("reports");
                    String rutaImagenes = getServletContext().getRealPath("pics");
                    ImageIcon icono = new ImageIcon(ImageIO.read(new File(rutaImagenes + "/logoProsa.png")));
                    FileInputStream fis = null;
                    BufferedInputStream bufferedInputStream = null;
                    JasperReport reporte = null;
                    JRBeanCollectionDataSource dsR = null;
                    JasperPrint jasperPrint = null;
                    JRExporter exportador = null;
                    ServletOutputStream servletOutputStream = null;
                    Map parametros = new HashMap();
                    String usuario = (String) session.getAttribute("login");
                    String formatoSalida = null;
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();

                    url = "/SICCMR0065.jsp";

                    // OBTIENE LA FECHA ACTUAL, ZONA HORARIA DE MEXICO
                    currenttime.setTimeZone(TimeZone.getTimeZone("GMT-06:00"));

                    // OBTIENE LAS LISTAS DE CATALOGOS
                    // LOS USUARIOS DE BANCOS SOLO VEN SUS PROPIOS DATOS
                    if (("administrador".compareTo(grupo) == 0) || ("operador".compareTo(grupo) == 0)) {
                        owner = "%";
                        bancos = modelo.listarBancos0065();
                    } else {
                        owner = fiidUsuario;
                        bancos = modelo.nombresBancos(modelo.convierteCadena(fiidUsuario));
                    }

                    // OBTIENE LA FECHA DEFAULT DE INICIO Y FIN
                    // FIN ES LA FECHA ACTUAL, INICIO ES UN MES ATRAS
                    fechaFin = new java.sql.Date((currenttime.getTime()).getTime());
                    currenttime.add(Calendar.MONTH, -1);
                    fechaIni = new java.sql.Date((currenttime.getTime()).getTime());

                    accion = request.getParameter("accion");

                    if (accion == null) {
                        accion = "";
                    }

                    // LA ACCION ES BLANCO, INICIALIZA
                    if ("".compareTo(accion) == 0) {
                        feIni = formatoFecha.format(fechaIni);
                        feFin = formatoFecha.format(fechaFin);
                        // PONE LOS DATOS EN BLANCO
                        // DATOS ELEGIDOS MAS LISTADO OBTENIDO
                        forma.setAccion("1");
                        forma.setFechaInicio(feIni);
                        forma.setFechaFinal(feFin);
                        forma.setBancos(bancos);
                        session.setAttribute("datos", forma);
                        // LA ACCION ES 0, CANCELAR
                    } else if ("0".compareTo(accion) == 0) {
                        url = "/index.jsp";
                    } else {
                        try {
                            // PONE LOS CRITERIOS
                            criterios.setIni(request.getParameter("fechaInicio"));
                            criterios.setFin(request.getParameter("fechaFinal"));
                            criterios.setBanco(request.getParameterValues("banco"));
                            criterios.setOwner(owner);

                            fis = new FileInputStream(rutaReportes + "/SICCMR0065.jasper");
                            bufferedInputStream = new BufferedInputStream(fis);
                            reporte = (JasperReport) JRLoader.loadObject(bufferedInputStream);

                            parametros.put("logo", icono.getImage());
                            parametros.put("usuario", usuario);
                            parametros.put("ini", criterios.getIni());
                            parametros.put("fin", criterios.getFin());
                            parametros.put("banco", modelo.entidadesListaBancos(request.getParameterValues("banco")));

                            formatoSalida = request.getParameter("formato");
                            // HTML
                            if ("0".compareTo(formatoSalida) == 0) {
                                parametros.put("titulo", new Integer(1));
                                // EXCEL
                            } else if ("1".compareTo(formatoSalida) == 0) {
                                parametros.put("titulo", new Integer(0));
                                // PDF
                            } else {
                                parametros.put("titulo", new Integer(1));
                            }

                            if (logger != null) {
                                logger.info(session.getId() + ":" + "El usuario " + this.session.getAttribute("login").toString()
                                        + " genero el reporte SICCMR0065 con parametros:FechaIni["
                                        + criterios.getIni() + "],FechaFin[" + criterios.getFin() + "],Banco["
                                        + modelo.listaCadenas(request.getParameterValues("banco"))
                                        + "]");
                            }

                            // GENERA EL REPORTE
                            resultados = modelo.consultarSICCMR0065(criterios);
                            dsR = new JRBeanCollectionDataSource(resultados);
                            jasperPrint = JasperFillManager.fillReport(reporte, parametros, dsR);

                            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

                            response.setHeader("Pragma", "no-cache");
                            response.setHeader("Cache-control", "private");
                            response.setDateHeader("Expires", 0);

                            // HTML
                            if ("0".compareTo(formatoSalida) == 0) {
                                response.setContentType("text/html");
                                response.setHeader("Content-Disposition", "inline; filename=\"SICCMR0065.html\"");
                                exportador = new JRHtmlExporter();
                                exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                                exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI, "image?image=");
                                exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                                exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(1.5));
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                                // EXCEL
                            } else if ("1".compareTo(formatoSalida) == 0) {
                                response.setContentType("application/vnd.ms-excel");
                                response.setHeader("Content-Disposition", "attachment; filename=\"SICCMR0065.xls\"");
                                exportador = new JRXlsExporter();
                                exportador.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baos);
                                exportador.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                                exportador.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                                exportador.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
                                exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.FALSE);
                                exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.FALSE);
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                                // PDF
                            } else {
                                response.setContentType("application/pdf");
                                response.setHeader("Content-Disposition", "attachment; filename=\"SICCMR0065.pdf\"");
                                exportador = new JRPdfExporter();
                                exportador.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, baos);
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                            }
                            baos.flush();
                            baos.close();
                            isAnswerReport = true;
                        } catch (Exception ex) {
                            System.out.println(" Error al generar SICCMR0065:" + ex);
                            ex.printStackTrace();
                        }
                    }
                } else if (action.equals("SICCMR0077")) {
                    Collection listado = new ArrayList();
                    String accion = "";
                    String feIni = "";
                    String feFin = "";
                    SICCMRDAO modelo = new SICCMRDAO();
                    Collection camarasA = new ArrayList();
                    Collection marcas = new ArrayList();
                    Collection resultados = new ArrayList();
                    CriteriosObj criterios = new CriteriosObj();
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                    java.sql.Date fechaIni = null;
                    java.sql.Date fechaFin = null;
                    Calendar currenttime = Calendar.getInstance();
                    SICCMR0077Form forma = new SICCMR0077Form();
                    String grupo = (String) session.getAttribute("role");
                    String fiidUsuario = (String) session.getAttribute("numFiid");
                    String owner = "";
                    String rutaReportes = getServletContext().getRealPath("reports");
                    String rutaImagenes = getServletContext().getRealPath("pics");
                    ImageIcon icono = new ImageIcon(ImageIO.read(new File(rutaImagenes + "/logoProsa.png")));
                    FileInputStream fis = null;
                    BufferedInputStream bufferedInputStream = null;
                    JasperReport reporte = null;
                    JRBeanCollectionDataSource dsR = null;
                    JasperPrint jasperPrint = null;
                    JRExporter exportador = null;
                    ServletOutputStream servletOutputStream = null;
                    Map parametros = new HashMap();
                    String usuario = (String) session.getAttribute("login");
                    String formatoSalida = null;
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();

                    url = "/SICCMR0077.jsp";

                    // OBTIENE LA FECHA ACTUAL, ZONA HORARIA DE MEXICO
                    currenttime.setTimeZone(TimeZone.getTimeZone("GMT-06:00"));

                    // OBTIENE LAS LISTAS DE CATALOGOS
                    // LOS USUARIOS DE BANCOS SOLO VEN SUS PROPIOS DATOS
                    if (("administrador".compareTo(grupo) == 0) || ("operador".compareTo(grupo) == 0)) {
                        owner = "%";
                    } else {
                        owner = fiidUsuario;
                    }

                    camarasA = modelo.listarCamarasProsa();
                    marcas = modelo.listarMarcas();

                    // OBTIENE LA FECHA DEFAULT DE INICIO Y FIN
                    // FIN ES LA FECHA ACTUAL, INICIO ES UN MES ATRAS
                    fechaFin = new java.sql.Date((currenttime.getTime()).getTime());
                    currenttime.add(Calendar.MONTH, -1);
                    fechaIni = new java.sql.Date((currenttime.getTime()).getTime());

                    accion = request.getParameter("accion");

                    if (accion == null) {
                        accion = "";
                    }

                    // LA ACCION ES BLANCO, INICIALIZA
                    if ("".compareTo(accion) == 0) {
                        feIni = formatoFecha.format(fechaIni);
                        feFin = formatoFecha.format(fechaFin);
                        // PONE LOS DATOS EN BLANCO
                        // DATOS ELEGIDOS MAS LISTADO OBTENIDO
                        forma.setAccion("1");
                        forma.setFechaInicio(feIni);
                        forma.setFechaFinal(feFin);
                        forma.setCamarasA(camarasA);
                        forma.setMarcas(marcas);
                        session.setAttribute("datos", forma);
                        // LA ACCION ES 0, CANCELAR
                    } else if ("0".compareTo(accion) == 0) {
                        url = "/index.jsp";
                    } else {
                        try {
                            // PONE LOS CRITERIOS
                            criterios.setIni(request.getParameter("fechaInicio"));
                            criterios.setFin(request.getParameter("fechaFinal"));
                            criterios.setCamaraAdq(request.getParameterValues("camaraAdq"));
                            criterios.setMarca(request.getParameterValues("marca"));
                            criterios.setOwner(owner);

                            fis = new FileInputStream(rutaReportes + "/SICCMR0077.jasper");
                            bufferedInputStream = new BufferedInputStream(fis);
                            reporte = (JasperReport) JRLoader.loadObject(bufferedInputStream);

                            parametros.put("logo", icono.getImage());
                            parametros.put("usuario", usuario);
                            parametros.put("ini", criterios.getIni());
                            parametros.put("fin", criterios.getFin());

                            // PONE TODAS SI SE ELIGIERON TODAS LAS MARCAS
                            if (request.getParameterValues("marca").length != 4) {
                                parametros.put("marca", modelo.descripcionesListaMarcas(request.getParameterValues("marca")));
                            } else {
                                parametros.put("marca", "TODAS");
                            }
                            parametros.put("camara", modelo.descripcionesListaCamaras(request.getParameterValues("camaraAdq")));

                            formatoSalida = request.getParameter("formato");
                            // HTML
                            if ("0".compareTo(formatoSalida) == 0) {
                                parametros.put("titulo", new Integer(1));
                                // EXCEL
                            } else if ("1".compareTo(formatoSalida) == 0) {
                                parametros.put("titulo", new Integer(0));
                                // PDF
                            } else {
                                parametros.put("titulo", new Integer(1));
                            }

                            if (logger != null) {
                                logger.info(session.getId() + ":" + "El usuario " + this.session.getAttribute("login").toString()
                                        + " genero el reporte SICCMR0077 con parametros:FechaIni["
                                        + criterios.getIni() + "],FechaFin[" + criterios.getFin() + "],Marca[" + modelo.descripcionesListaMarcas(request.getParameterValues("marca"))
                                        + "],CamaraAdq[" + modelo.descripcionesListaCamaras(request.getParameterValues("camaraAdq")) + "]");
                            }

                            // GENERA EL REPORTE
                            resultados = modelo.consultarSICCMR0077(criterios);
                            dsR = new JRBeanCollectionDataSource(resultados);
                            jasperPrint = JasperFillManager.fillReport(reporte, parametros, dsR);

                            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

                            response.setHeader("Pragma", "no-cache");
                            response.setHeader("Cache-control", "private");
                            response.setDateHeader("Expires", 0);

                            // HTML
                            if ("0".compareTo(formatoSalida) == 0) {
                                response.setContentType("text/html");
                                response.setHeader("Content-Disposition", "inline; filename=\"SICCMR0077.html\"");
                                exportador = new JRHtmlExporter();
                                exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                                exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI, "image?image=");
                                exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                                exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(1.5));
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                                // EXCEL
                            } else if ("1".compareTo(formatoSalida) == 0) {
                                response.setContentType("application/vnd.ms-excel");
                                response.setHeader("Content-Disposition", "attachment; filename=\"SICCMR0077.xls\"");
                                exportador = new JRXlsExporter();
                                exportador.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baos);
                                exportador.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                                exportador.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                                exportador.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
                                exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.FALSE);
                                exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.FALSE);
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                                // PDF
                            } else {
                                response.setContentType("application/pdf");
                                response.setHeader("Content-Disposition", "attachment; filename=\"SICCMR0077.pdf\"");
                                exportador = new JRPdfExporter();
                                exportador.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, baos);
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                            }
                            baos.flush();
                            baos.close();
                            isAnswerReport = true;
                        } catch (Exception ex) {
                            System.out.println(" Error al generar SICCMR0077:" + ex);
                            ex.printStackTrace();
                        }
                    }
                } else if (action.equals("SICCMR0087")) {
                    Collection listado = new ArrayList();
                    String accion = "";
                    String feIni = "";
                    String feFin = "";
                    SICCMRDAO modelo = new SICCMRDAO();
                    Collection camarasE = new ArrayList();
                    Collection marcas = new ArrayList();
                    Collection resultados = new ArrayList();
                    CriteriosObj criterios = new CriteriosObj();
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                    java.sql.Date fechaIni = null;
                    java.sql.Date fechaFin = null;
                    Calendar currenttime = Calendar.getInstance();
                    SICCMR0087Form forma = new SICCMR0087Form();
                    String grupo = (String) session.getAttribute("role");
                    String fiidUsuario = (String) session.getAttribute("numFiid");
                    String owner = "";
                    String rutaReportes = getServletContext().getRealPath("reports");
                    String rutaImagenes = getServletContext().getRealPath("pics");
                    ImageIcon icono = new ImageIcon(ImageIO.read(new File(rutaImagenes + "/logoProsa.png")));
                    FileInputStream fis = null;
                    BufferedInputStream bufferedInputStream = null;
                    JasperReport reporte = null;
                    JRBeanCollectionDataSource dsR = null;
                    JasperPrint jasperPrint = null;
                    JRExporter exportador = null;
                    ServletOutputStream servletOutputStream = null;
                    Map parametros = new HashMap();
                    String usuario = (String) session.getAttribute("login");
                    String formatoSalida = null;
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();

                    url = "/SICCMR0087.jsp";

                    // OBTIENE LA FECHA ACTUAL, ZONA HORARIA DE MEXICO
                    currenttime.setTimeZone(TimeZone.getTimeZone("GMT-06:00"));

                    // OBTIENE LAS LISTAS DE CATALOGOS
                    // LOS USUARIOS DE BANCOS SOLO VEN SUS PROPIOS DATOS
                    if (("administrador".compareTo(grupo) == 0) || ("operador".compareTo(grupo) == 0)) {
                        owner = "%";
                    } else {
                        owner = fiidUsuario;
                    }

                    camarasE = modelo.listarCamarasEglo();
                    marcas = modelo.listarMarcas();

                    // OBTIENE LA FECHA DEFAULT DE INICIO Y FIN
                    // FIN ES LA FECHA ACTUAL, INICIO ES UN MES ATRAS
                    fechaFin = new java.sql.Date((currenttime.getTime()).getTime());
                    currenttime.add(Calendar.MONTH, -1);
                    fechaIni = new java.sql.Date((currenttime.getTime()).getTime());

                    accion = request.getParameter("accion");

                    if (accion == null) {
                        accion = "";
                    }

                    // LA ACCION ES BLANCO, INICIALIZA
                    if ("".compareTo(accion) == 0) {
                        feIni = formatoFecha.format(fechaIni);
                        feFin = formatoFecha.format(fechaFin);
                        // PONE LOS DATOS EN BLANCO
                        // DATOS ELEGIDOS MAS LISTADO OBTENIDO
                        forma.setAccion("1");
                        forma.setFechaInicio(feIni);
                        forma.setFechaFinal(feFin);
                        forma.setCamarasE(camarasE);
                        forma.setMarcas(marcas);
                        session.setAttribute("datos", forma);
                        // LA ACCION ES 0, CANCELAR
                    } else if ("0".compareTo(accion) == 0) {
                        url = "/index.jsp";
                    } else {
                        try {
                            // PONE LOS CRITERIOS
                            criterios.setIni(request.getParameter("fechaInicio"));
                            criterios.setFin(request.getParameter("fechaFinal"));
                            criterios.setCamaraEmi(request.getParameterValues("camaraEmi"));
                            criterios.setMarca(request.getParameterValues("marca"));
                            criterios.setOwner(owner);

                            fis = new FileInputStream(rutaReportes + "/SICCMR0087.jasper");
                            bufferedInputStream = new BufferedInputStream(fis);
                            reporte = (JasperReport) JRLoader.loadObject(bufferedInputStream);

                            parametros.put("logo", icono.getImage());
                            parametros.put("usuario", usuario);
                            parametros.put("ini", criterios.getIni());
                            parametros.put("fin", criterios.getFin());

                            // PONE TODAS SI SE ELIGIERON TODAS LAS MARCAS
                            if (request.getParameterValues("marca").length != 4) {
                                parametros.put("marca", modelo.descripcionesListaMarcas(request.getParameterValues("marca")));
                            } else {
                                parametros.put("marca", "TODAS");
                            }
                            parametros.put("camara", modelo.descripcionesListaCamaras(request.getParameterValues("camaraEmi")));

                            formatoSalida = request.getParameter("formato");
                            // HTML
                            if ("0".compareTo(formatoSalida) == 0) {
                                parametros.put("titulo", new Integer(1));
                                // EXCEL
                            } else if ("1".compareTo(formatoSalida) == 0) {
                                parametros.put("titulo", new Integer(0));
                                // PDF
                            } else {
                                parametros.put("titulo", new Integer(1));
                            }

                            if (logger != null) {
                                logger.info(session.getId() + ":" + "El usuario " + this.session.getAttribute("login").toString()
                                        + " genero el reporte SICCMR0087 con parametros:FechaIni["
                                        + criterios.getIni() + "],FechaFin[" + criterios.getFin() + "],Marca[" + modelo.descripcionesListaMarcas(request.getParameterValues("marca"))
                                        + "],CamaraEmi[" + modelo.descripcionesListaCamaras(request.getParameterValues("camaraEmi")) + "]");
                            }

                            // GENERA EL REPORTE
                            resultados = modelo.consultarSICCMR0087(criterios);
                            dsR = new JRBeanCollectionDataSource(resultados);
                            jasperPrint = JasperFillManager.fillReport(reporte, parametros, dsR);

                            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

                            response.setHeader("Pragma", "no-cache");
                            response.setHeader("Cache-control", "private");
                            response.setDateHeader("Expires", 0);

                            // HTML
                            if ("0".compareTo(formatoSalida) == 0) {
                                response.setContentType("text/html");
                                response.setHeader("Content-Disposition", "inline; filename=\"SICCMR0087.html\"");
                                exportador = new JRHtmlExporter();
                                exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                                exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI, "image?image=");
                                exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                                exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(1.5));
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                                // EXCEL
                            } else if ("1".compareTo(formatoSalida) == 0) {
                                response.setContentType("application/vnd.ms-excel");
                                response.setHeader("Content-Disposition", "attachment; filename=\"SICCMR0087.xls\"");
                                exportador = new JRXlsExporter();
                                exportador.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baos);
                                exportador.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                                exportador.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                                exportador.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
                                exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.FALSE);
                                exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.FALSE);
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                                // PDF
                            } else {
                                response.setContentType("application/pdf");
                                response.setHeader("Content-Disposition", "attachment; filename=\"SICCMR0087.pdf\"");
                                exportador = new JRPdfExporter();
                                exportador.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, baos);
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                            }
                            baos.flush();
                            baos.close();
                            isAnswerReport = true;
                        } catch (Exception ex) {
                            System.out.println(" Error al generar SICCMR0087:" + ex);
                            ex.printStackTrace();
                        }
                    }
                } else if (action.equals("SICCMRC200")) {
                    Collection listado = new ArrayList();
                    String accion = "";
                    String feIni = "";
                    String feFin = "";
                    SICCMRDAO modelo = new SICCMRDAO();
                    Collection bancos = new ArrayList();
                    Collection resultados = new ArrayList();
                    CriteriosObj criterios = new CriteriosObj();
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                    java.sql.Date fechaIni = null;
                    java.sql.Date fechaFin = null;
                    Calendar currenttime = Calendar.getInstance();
                    SICCMRC200Form forma = new SICCMRC200Form();
                    String grupo = (String) session.getAttribute("role");
                    String fiidUsuario = (String) session.getAttribute("numFiid");
                    String owner = "";
                    String rutaReportes = getServletContext().getRealPath("reports");
                    String rutaImagenes = getServletContext().getRealPath("pics");
                    ImageIcon icono = new ImageIcon(ImageIO.read(new File(rutaImagenes + "/logoProsa.png")));
                    FileInputStream fis = null;
                    BufferedInputStream bufferedInputStream = null;
                    JasperReport reporte = null;
                    JRBeanCollectionDataSource dsR = null;
                    JasperPrint jasperPrint = null;
                    JRExporter exportador = null;
                    ServletOutputStream servletOutputStream = null;
                    Map parametros = new HashMap();
                    String usuario = (String) session.getAttribute("login");
                    String formatoSalida = null;
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();

                    url = "/SICCMRC200.jsp";

                    // OBTIENE LA FECHA ACTUAL, ZONA HORARIA DE MEXICO
                    currenttime.setTimeZone(TimeZone.getTimeZone("GMT-06:00"));

                    // OBTIENE LAS LISTAS DE CATALOGOS
                    // LOS USUARIOS DE BANCOS SOLO VEN SUS PROPIOS DATOS
                    if (("administrador".compareTo(grupo) == 0) || ("operador".compareTo(grupo) == 0)) {
                        owner = "%";
                        bancos = modelo.listarBancos0200();
                    } else {
                        owner = fiidUsuario;
                        bancos = modelo.nombresBancos(modelo.convierteCadena(modelo.entidadBanco(fiidUsuario)));
                    }

                    // OBTIENE LA FECHA DEFAULT DE INICIO Y FIN
                    // FIN ES LA FECHA ACTUAL, INICIO ES UN MES ATRAS
                    fechaFin = new java.sql.Date((currenttime.getTime()).getTime());
                    currenttime.add(Calendar.MONTH, -1);
                    fechaIni = new java.sql.Date((currenttime.getTime()).getTime());

                    accion = request.getParameter("accion");

                    if (accion == null) {
                        accion = "";
                    }

                    // LA ACCION ES BLANCO, INICIALIZA
                    if ("".compareTo(accion) == 0) {
                        feIni = formatoFecha.format(fechaIni);
                        feFin = formatoFecha.format(fechaFin);
                        // PONE LOS DATOS EN BLANCO
                        // DATOS ELEGIDOS MAS LISTADO OBTENIDO
                        forma.setAccion("1");
                        forma.setFechaInicio(feIni);
                        forma.setFechaFinal(feFin);
                        forma.setBancos(bancos);
                        session.setAttribute("datos", forma);
                        // LA ACCION ES 0, CANCELAR
                    } else if ("0".compareTo(accion) == 0) {
                        url = "/index.jsp";
                    } else {
                        try {
                            // PONE LOS CRITERIOS
                            criterios.setIni(request.getParameter("fechaInicio"));
                            criterios.setFin(request.getParameter("fechaFinal"));
                            criterios.setBanco(request.getParameterValues("banco"));
                            criterios.setOwner(owner);

                            fis = new FileInputStream(rutaReportes + "/SICCMRC200.jasper");
                            bufferedInputStream = new BufferedInputStream(fis);
                            reporte = (JasperReport) JRLoader.loadObject(bufferedInputStream);

                            parametros.put("logo", icono.getImage());
                            parametros.put("usuario", usuario);
                            parametros.put("ini", criterios.getIni());
                            parametros.put("fin", criterios.getFin());
                            parametros.put("banco", modelo.entidadesListaBancos(request.getParameterValues("banco")));

                            formatoSalida = request.getParameter("formato");
                            // HTML
                            if ("0".compareTo(formatoSalida) == 0) {
                                parametros.put("titulo", new Integer(1));
                                // EXCEL
                            } else if ("1".compareTo(formatoSalida) == 0) {
                                parametros.put("titulo", new Integer(0));
                                // PDF
                            } else {
                                parametros.put("titulo", new Integer(1));
                            }

                            if (logger != null) {
                                logger.info(session.getId() + ":" + "El usuario " + this.session.getAttribute("login").toString()
                                        + " genero el reporte SICCMRC200 con parametros:FechaIni["
                                        + criterios.getIni() + "],FechaFin[" + criterios.getFin() + "],Banco["
                                        + modelo.listaCadenas(request.getParameterValues("banco")) + "]");
                            }

                            // GENERA EL REPORTE
                            resultados = modelo.consultar0200(criterios);
                            dsR = new JRBeanCollectionDataSource(resultados);
                            jasperPrint = JasperFillManager.fillReport(reporte, parametros, dsR);

                            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

                            response.setHeader("Pragma", "no-cache");
                            response.setHeader("Cache-control", "private");
                            response.setDateHeader("Expires", 0);

                            // HTML
                            if ("0".compareTo(formatoSalida) == 0) {
                                response.setContentType("text/html");
                                response.setHeader("Content-Disposition", "inline; filename=\"SICCMRC200.html\"");
                                exportador = new JRHtmlExporter();
                                exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                                exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI, "image?image=");
                                exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                                exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(1.5));
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                                // EXCEL
                            } else if ("1".compareTo(formatoSalida) == 0) {
                                response.setContentType("application/vnd.ms-excel");
                                response.setHeader("Content-Disposition", "attachment; filename=\"SICCMRC200.xls\"");
                                exportador = new JRXlsExporter();
                                exportador.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baos);
                                exportador.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                                exportador.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                                exportador.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
                                exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.FALSE);
                                exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.FALSE);
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                                // PDF
                            } else {
                                response.setContentType("application/pdf");
                                response.setHeader("Content-Disposition", "attachment; filename=\"SICCMRC200.pdf\"");
                                exportador = new JRPdfExporter();
                                exportador.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, baos);
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                            }
                            baos.flush();
                            baos.close();
                            isAnswerReport = true;
                        } catch (Exception ex) {
                            System.out.println(" Error al generar SICCMRC200:" + ex);
                            ex.printStackTrace();
                        }
                    }
                } else if (action.equals("SICCMRC320")) {
                    Collection listado = new ArrayList();
                    String accion = "";
                    String feIni = "";
                    String feFin = "";
                    SICCMRDAO modelo = new SICCMRDAO();
                    Collection resultados = new ArrayList();
                    Collection resultados2 = new ArrayList();
                    CriteriosObj criterios = new CriteriosObj();
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                    java.sql.Date fechaIni = null;
                    java.sql.Date fechaFin = null;
                    Calendar currenttime = Calendar.getInstance();
                    SICCMRC320Form forma = new SICCMRC320Form();
                    String grupo = (String) session.getAttribute("role");
                    String fiidUsuario = (String) session.getAttribute("numFiid");
                    String owner = "";
                    String rutaReportes = getServletContext().getRealPath("reports");
                    String rutaImagenes = getServletContext().getRealPath("pics");
                    ImageIcon icono = new ImageIcon(ImageIO.read(new File(rutaImagenes + "/logoProsa.png")));
                    FileInputStream fis = null;
                    BufferedInputStream bufferedInputStream = null;
                    JasperReport reporte = null;
                    JRBeanCollectionDataSource dsR = null;
                    JasperPrint jasperPrint = null;
                    JRExporter exportador = null;
                    ServletOutputStream servletOutputStream = null;
                    Map parametros = new HashMap();
                    String usuario = (String) session.getAttribute("login");
                    String formatoSalida = null;
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    Collection camaras = new ArrayList();

                    url = "/SICCMRC320.jsp";

                    // OBTIENE LA FECHA ACTUAL, ZONA HORARIA DE MEXICO
                    currenttime.setTimeZone(TimeZone.getTimeZone("GMT-06:00"));

                    // OBTIENE LAS LISTAS DE CATALOGOS
                    // LOS USUARIOS DE BANCOS SOLO VEN SUS PROPIOS DATOS
                    if (("administrador".compareTo(grupo) == 0) || ("operador".compareTo(grupo) == 0)) {
                        owner = "%";
                    } else {
                        owner = fiidUsuario;
                    }
                    camaras = modelo.listarCamaras320();

                    // OBTIENE LA FECHA DEFAULT DE INICIO Y FIN
                    // FIN ES LA FECHA ACTUAL, INICIO ES UN MES ATRAS
                    fechaFin = new java.sql.Date((currenttime.getTime()).getTime());
                    currenttime.add(Calendar.MONTH, -1);
                    fechaIni = new java.sql.Date((currenttime.getTime()).getTime());

                    accion = request.getParameter("accion");

                    if (accion == null) {
                        accion = "";
                    }

                    // LA ACCION ES BLANCO, INICIALIZA
                    if ("".compareTo(accion) == 0) {
                        feIni = formatoFecha.format(fechaIni);
                        feFin = formatoFecha.format(fechaFin);
                        // PONE LOS DATOS EN BLANCO
                        // DATOS ELEGIDOS MAS LISTADO OBTENIDO
                        forma.setAccion("1");
                        forma.setFechaInicio(feIni);
                        forma.setFechaFinal(feFin);
                        forma.setCamarasA(camaras);
                        session.setAttribute("datos", forma);
                        // LA ACCION ES 0, CANCELAR
                    } else if ("0".compareTo(accion) == 0) {
                        url = "/index.jsp";
                    } else {
                        try {
                            // PONE LOS CRITERIOS
                            criterios.setIni(request.getParameter("fechaInicio"));
                            criterios.setFin(request.getParameter("fechaFinal"));
                            criterios.setCamaraAdq(request.getParameterValues("camaraAdq"));

                            fis = new FileInputStream(rutaReportes + "/SICCMRC320.jasper");
                            bufferedInputStream = new BufferedInputStream(fis);
                            reporte = (JasperReport) JRLoader.loadObject(bufferedInputStream);

                            parametros.put("logo", icono.getImage());
                            parametros.put("usuario", usuario);
                            parametros.put("ini", criterios.getIni());
                            parametros.put("fin", criterios.getFin());
                            parametros.put("camara", modelo.descripcionesListaCamaras(request.getParameterValues("camaraAdq")));
                            parametros.put("SUBREPORT_DIR", rutaReportes + "/");

                            formatoSalida = request.getParameter("formato");
                            // HTML
                            if ("0".compareTo(formatoSalida) == 0) {
                                parametros.put("titulo2", new Integer(1));
                                // EXCEL
                            } else if ("1".compareTo(formatoSalida) == 0) {
                                parametros.put("titulo2", new Integer(0));
                                // PDF
                            } else {
                                parametros.put("titulo2", new Integer(1));
                            }

                            if (logger != null) {
                                logger.info(session.getId() + ":" + "El usuario " + this.session.getAttribute("login").toString()
                                        + " genero el reporte SICCMRC320 con parametros:FechaIni["
                                        + criterios.getIni() + "],FechaFin[" + criterios.getFin() + "],Camara[" + modelo.descripcionesListaCamaras(request.getParameterValues("camaraAdq")) + "]");
                            }

                            // GENERA EL REPORTE
                            resultados = modelo.consultarSICCMRC320(criterios);
                            resultados2 = modelo.consultarSICCMRC320_2(criterios);
                            parametros.put("datos2", resultados2);
                            parametros.put("titulo", "Camara de Compensacion");
                            dsR = new JRBeanCollectionDataSource(resultados);
                            jasperPrint = JasperFillManager.fillReport(reporte, parametros, dsR);

                            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

                            response.setHeader("Pragma", "no-cache");
                            response.setHeader("Cache-control", "private");
                            response.setDateHeader("Expires", 0);

                            // HTML
                            if ("0".compareTo(formatoSalida) == 0) {
                                response.setContentType("text/html");
                                response.setHeader("Content-Disposition", "inline; filename=\"SICCMRC320.html\"");
                                exportador = new JRHtmlExporter();
                                exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                                exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI, "image?image=");
                                exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                                exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(1.5));
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                                // EXCEL
                            } else if ("1".compareTo(formatoSalida) == 0) {
                                response.setContentType("application/vnd.ms-excel");
                                response.setHeader("Content-Disposition", "attachment; filename=\"SICCMRC320.xls\"");
                                exportador = new JRXlsExporter();
                                exportador.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baos);
                                exportador.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                                exportador.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                                exportador.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
                                exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.FALSE);
                                exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.FALSE);
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                                // PDF
                            } else {
                                response.setContentType("application/pdf");
                                response.setHeader("Content-Disposition", "attachment; filename=\"SICCMRC320.pdf\"");
                                exportador = new JRPdfExporter();
                                exportador.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, baos);
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                            }
                            baos.flush();
                            baos.close();
                            isAnswerReport = true;
                        } catch (Exception ex) {
                            System.out.println(" Error al generar SICCMRC320:" + ex);
                            ex.printStackTrace();
                        }
                    }
                } else if (action.equals("SICCMRC330")) {
                    Collection listado = new ArrayList();
                    String accion = "";
                    String feIni = "";
                    String feFin = "";
                    SICCMRDAO modelo = new SICCMRDAO();
                    Collection resultados = new ArrayList();
                    Collection resultados2 = new ArrayList();
                    CriteriosObj criterios = new CriteriosObj();
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                    java.sql.Date fechaIni = null;
                    java.sql.Date fechaFin = null;
                    Calendar currenttime = Calendar.getInstance();
                    SICCMRC330Form forma = new SICCMRC330Form();
                    String grupo = (String) session.getAttribute("role");
                    String fiidUsuario = (String) session.getAttribute("numFiid");
                    String owner = "";
                    String rutaReportes = getServletContext().getRealPath("reports");
                    String rutaImagenes = getServletContext().getRealPath("pics");
                    ImageIcon icono = new ImageIcon(ImageIO.read(new File(rutaImagenes + "/logoProsa.png")));
                    FileInputStream fis = null;
                    BufferedInputStream bufferedInputStream = null;
                    JasperReport reporte = null;
                    JRBeanCollectionDataSource dsR = null;
                    JasperPrint jasperPrint = null;
                    JRExporter exportador = null;
                    ServletOutputStream servletOutputStream = null;
                    Map parametros = new HashMap();
                    String usuario = (String) session.getAttribute("login");
                    String formatoSalida = null;
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    Collection marcas = new ArrayList();

                    url = "/SICCMRC330.jsp";

                    // OBTIENE LA FECHA ACTUAL, ZONA HORARIA DE MEXICO
                    currenttime.setTimeZone(TimeZone.getTimeZone("GMT-06:00"));

                    // OBTIENE LAS LISTAS DE CATALOGOS
                    // LOS USUARIOS DE BANCOS SOLO VEN SUS PROPIOS DATOS
                    if (("administrador".compareTo(grupo) == 0) || ("operador".compareTo(grupo) == 0)) {
                        owner = "%";
                    } else {
                        owner = fiidUsuario;
                    }
                    marcas = modelo.listarMarcas330();

                    // OBTIENE LA FECHA DEFAULT DE INICIO Y FIN
                    // FIN ES LA FECHA ACTUAL, INICIO ES UN MES ATRAS
                    fechaFin = new java.sql.Date((currenttime.getTime()).getTime());
                    currenttime.add(Calendar.MONTH, -1);
                    fechaIni = new java.sql.Date((currenttime.getTime()).getTime());

                    accion = request.getParameter("accion");

                    if (accion == null) {
                        accion = "";
                    }

                    // LA ACCION ES BLANCO, INICIALIZA
                    if ("".compareTo(accion) == 0) {
                        feIni = formatoFecha.format(fechaIni);
                        feFin = formatoFecha.format(fechaFin);
                        // PONE LOS DATOS EN BLANCO
                        // DATOS ELEGIDOS MAS LISTADO OBTENIDO
                        forma.setAccion("1");
                        forma.setFechaInicio(feIni);
                        forma.setFechaFinal(feFin);
                        forma.setMarcas(marcas);
                        session.setAttribute("datos", forma);
                        // LA ACCION ES 0, CANCELAR
                    } else if ("0".compareTo(accion) == 0) {
                        url = "/index.jsp";
                    } else {
                        try {
                            // PONE LOS CRITERIOS
                            criterios.setIni(request.getParameter("fechaInicio"));
                            criterios.setFin(request.getParameter("fechaFinal"));
                            criterios.setMarca(request.getParameterValues("marca"));

                            fis = new FileInputStream(rutaReportes + "/SICCMRC330.jasper");
                            bufferedInputStream = new BufferedInputStream(fis);
                            reporte = (JasperReport) JRLoader.loadObject(bufferedInputStream);

                            parametros.put("logo", icono.getImage());
                            parametros.put("usuario", usuario);
                            parametros.put("ini", criterios.getIni());
                            parametros.put("fin", criterios.getFin());
                            parametros.put("marca", modelo.descripcionesListaMarcas(request.getParameterValues("marca")));
                            parametros.put("SUBREPORT_DIR", rutaReportes + "/");

                            formatoSalida = request.getParameter("formato");
                            // HTML
                            if ("0".compareTo(formatoSalida) == 0) {
                                parametros.put("titulo2", new Integer(1));
                                // EXCEL
                            } else if ("1".compareTo(formatoSalida) == 0) {
                                parametros.put("titulo2", new Integer(0));
                                // PDF
                            } else {
                                parametros.put("titulo2", new Integer(1));
                            }

                            if (logger != null) {
                                logger.info(session.getId() + ":" + "El usuario " + this.session.getAttribute("login").toString()
                                        + " genero el reporte SICCMRC330 con parametros:FechaIni["
                                        + criterios.getIni() + "],FechaFin[" + criterios.getFin() + "], Marca[" + modelo.descripcionesListaMarcas(request.getParameterValues("marca")) + "]");
                            }

                            // GENERA EL REPORTE
                            resultados = modelo.consultarSICCMRC330(criterios);
                            resultados2 = modelo.consultarSICCMRC330_2(criterios);
                            parametros.put("datos2", resultados2);
                            parametros.put("titulo", "Marca");
                            dsR = new JRBeanCollectionDataSource(resultados);
                            jasperPrint = JasperFillManager.fillReport(reporte, parametros, dsR);

                            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

                            response.setHeader("Pragma", "no-cache");
                            response.setHeader("Cache-control", "private");
                            response.setDateHeader("Expires", 0);

                            // HTML
                            if ("0".compareTo(formatoSalida) == 0) {
                                response.setContentType("text/html");
                                response.setHeader("Content-Disposition", "inline; filename=\"SICCMRC330.html\"");
                                exportador = new JRHtmlExporter();
                                exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                                exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI, "image?image=");
                                exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                                exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(1.5));
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                                // EXCEL
                            } else if ("1".compareTo(formatoSalida) == 0) {
                                response.setContentType("application/vnd.ms-excel");
                                response.setHeader("Content-Disposition", "attachment; filename=\"SICCMRC330.xls\"");
                                exportador = new JRXlsExporter();
                                exportador.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baos);
                                exportador.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                                exportador.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                                exportador.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
                                exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.FALSE);
                                exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.FALSE);
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                                // PDF
                            } else {
                                response.setContentType("application/pdf");
                                response.setHeader("Content-Disposition", "attachment; filename=\"SICCMRC330.pdf\"");
                                exportador = new JRPdfExporter();
                                exportador.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
                                exportador.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, baos);
                                exportador.exportReport();
                                servletOutputStream = response.getOutputStream();
                                response.setContentLength(baos.size());
                                baos.writeTo(servletOutputStream);
                            }
                            baos.flush();
                            baos.close();
                            isAnswerReport = true;
                        } catch (Exception ex) {
                            System.out.println(" Error al generar SICCMRC330:" + ex);
                            ex.printStackTrace();
                        }
                    }
                }//Reporte 0065
                else if (action.equals("SICLIF0065")) {
                    url = "/SICLIF0065Header.jsp";
                } else if (action.equals("SICLIF0065Main")) {
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
                    metodo = new ControllerMethod();
                    try {
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        session.setAttribute("initDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                        session.setAttribute("endDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                        metodo.Oparticionesdiaant(initDate, endDate, initDate, endDate, session);
                        url = value.valida(session, initDate, endDate, "Siclif0065");
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
