/*###############################################################################
# Nombre del Programa :  ControllerServletHerramientas.java                     #
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

import biz.ideasoft.beans.ViewerManager;

import com.prosa.beans.AfiliacionObj;
import com.prosa.beans.CuentaObj;
import com.prosa.dao.AltasDAO;
import com.prosa.struts.AfiliacionForm;
import com.prosa.struts.AltasForm;
import com.prosa.struts.ConsultaForm;
import com.prosa.struts.CuentaForm;
import com.wellcom.exceptions.WellException;
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
 * Servlet implementation class ControllerServletHerramientas
 */
public class ControllerServletHerramientas extends HttpServlet {

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
    public ControllerServletHerramientas() {
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
            System.out.println("ControllerServletHerramientas session: " + this.sessionId);
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
                    //session.invalidate();
                    System.out.println("Action Login ControllerServletHerramientas: " + action);
                    url = "/login.jsp";
                } //Comienzan reportes 
                else if (action.equals("aggtipocambio")) {
                    url = "/aggtipocambio.jsp?btnaggtipocambio=Agregar";
                } else if (action.equals("edittipocambio")) {
                    String rbtn = request.getParameter("rbtn");
                    url = "/edittipocambio.jsp?rbtn=" + rbtn + "&btnedittipocambio=Editar";
                } else if (action.equals("delModSacii")) {
                    String rbtn = request.getParameter("rbtn");
                    url = "/delModSacii.jsp?rbtn=" + rbtn + "&btnDelModGrpSacii=Liberar";
                } else if (action.equals("lstGrpSacii")) {
                    url = "/lstGrpSaciiHeader.jsp";
                } else if (action.equals("Monitor")) {
                    url = "/MonitorHeader.jsp";
                } else if (action.equals("manto")) {

                    url = "/mantenimientoHeader.jsp";
                } else if (action.equals("tipocambio")) {
                    url = "/tipocambioHeader.jsp";
                } else if (action.equals("cierreDifCuotas")) {
                    url = "/cierreDifCuotasHeader.jsp";
                } else if (action.equals("editdifcuotas")) {
                    String rbtn = request.getParameter("rbtn");
                    url = "/editdifcuotas.jsp?rbtn=" + rbtn + "&btneditdifcuotas=Editar";
                } else if (action.equals("MantTelef")) {
                    url = "/mantTelf_Header.jsp";
                } else if (action.equals("XXXXmntoTel")) {
                    session.removeAttribute("guardado");
                    String[] telefonicaMnto = request.getParameterValues("telefonica");
                    String telefonicaStr = "";
                    for (String telefonica : telefonicaMnto) {
                        if (!telefonicaStr.equals("")) {
                            telefonicaStr += ",";
                        }
                        telefonicaStr += telefonica;
                    }
                    DaoMntoTelefonica dmt = new DaoMntoTelefonica();
                    dmt.buscaDatosTelefonica(session, telefonicaStr);
                    session.setAttribute("vtc_tasa_com_int_cre", dmt.getVtc_tasa_com_int_cre());
                    session.setAttribute("vtc_tasa_com_adq_cre", dmt.getVtc_tasa_com_adq_cre());
                    session.setAttribute("vtc_tasa_com_com_cre", dmt.getVtc_tasa_com_com_cre());
                    session.setAttribute("vtc_tasa_com_int_deb", dmt.getVtc_tasa_com_int_deb());
                    session.setAttribute("vtc_tasa_com_adq_deb", dmt.getVtc_tasa_com_adq_deb());
                    session.setAttribute("vtc_tasa_com_com_deb", dmt.getVtc_tasa_com_com_deb());
                    session.setAttribute("vtc_tasa_com_int_efe", dmt.getVtc_tasa_com_int_efe());
                    session.setAttribute("vtc_tasa_com_adq_efe", dmt.getVtc_tasa_com_adq_efe());
                    session.setAttribute("vtc_tasa_com_com_efe", dmt.getVtc_tasa_com_com_efe());
                    session.setAttribute("vtc_tasa_iva", dmt.getVtc_tasa_iva());
                    session.setAttribute("estatus", dmt.getEstatus());
                    session.setAttribute("claveTelefonica", dmt.getVtc_cve_telef());
                    session.setAttribute("nombreTelefonica", dmt.getVtc_nom_telef());
                    url = "/mantenimientoTelefonica.jsp";
                } else if (action.equals("guardadoMantTelef")) {
                    DaoMntoTelefonica dmt = new DaoMntoTelefonica();
                    dmt.setVtc_tasa_com_int_cre(Double.parseDouble(request.getParameter("vtc_tasa_com_int_cre")));
                    dmt.setVtc_tasa_com_adq_cre(Double.parseDouble(request.getParameter("vtc_tasa_com_adq_cre")));
                    dmt.setVtc_tasa_com_com_cre(Double.parseDouble(request.getParameter("vtc_tasa_com_com_cre")));
                    dmt.setVtc_tasa_com_int_deb(Double.parseDouble(request.getParameter("vtc_tasa_com_int_deb")));
                    dmt.setVtc_tasa_com_adq_deb(Double.parseDouble(request.getParameter("vtc_tasa_com_adq_deb")));
                    dmt.setVtc_tasa_com_com_deb(Double.parseDouble(request.getParameter("vtc_tasa_com_com_deb")));
                    dmt.setVtc_tasa_com_int_efe(Double.parseDouble(request.getParameter("vtc_tasa_com_int_efe")));
                    dmt.setVtc_tasa_com_adq_efe(Double.parseDouble(request.getParameter("vtc_tasa_com_adq_efe")));
                    dmt.setVtc_tasa_com_com_efe(Double.parseDouble(request.getParameter("vtc_tasa_com_com_efe")));
                    dmt.setVtc_tasa_iva(Double.parseDouble(request.getParameter("vtc_tasa_iva")));
                    if (request.getParameter("cbo_estatus").equals("0")) {
                        dmt.setEstatus("A");
                    } else {
                        dmt.setEstatus("B");
                    }
                    dmt.setVtc_cve_telef(Integer.parseInt(request.getParameter("claveTelefonica")));
                    String telefonicaMnto = request.getParameter("claveTelefonica");
                    dmt.guardaDatosTelefonica(session, telefonicaMnto);

                    // reabrir la pagina
                    dmt.buscaDatosTelefonica(session, telefonicaMnto);
                    session.setAttribute("vtc_tasa_com_int_cre", dmt.getVtc_tasa_com_int_cre());
                    session.setAttribute("vtc_tasa_com_adq_cre", dmt.getVtc_tasa_com_adq_cre());
                    session.setAttribute("vtc_tasa_com_com_cre", dmt.getVtc_tasa_com_com_cre());
                    session.setAttribute("vtc_tasa_com_int_deb", dmt.getVtc_tasa_com_int_deb());
                    session.setAttribute("vtc_tasa_com_adq_deb", dmt.getVtc_tasa_com_adq_deb());
                    session.setAttribute("vtc_tasa_com_com_deb", dmt.getVtc_tasa_com_com_deb());
                    session.setAttribute("vtc_tasa_com_int_efe", dmt.getVtc_tasa_com_int_efe());
                    session.setAttribute("vtc_tasa_com_adq_efe", dmt.getVtc_tasa_com_adq_efe());
                    session.setAttribute("vtc_tasa_com_com_efe", dmt.getVtc_tasa_com_com_efe());
                    session.setAttribute("vtc_tasa_iva", dmt.getVtc_tasa_iva());
                    session.setAttribute("estatus", dmt.getEstatus());
                    session.setAttribute("claveTelefonica", dmt.getVtc_cve_telef());
                    session.setAttribute("nombreTelefonica", dmt.getVtc_nom_telef());
                    session.setAttribute("guardado", "ok");
                    url = "/mantenimientoTelefonica.jsp";
                } else if (action.equals("MantDistri")) {
                    url = "/mantDistri_Header.jsp";
                } //Siclir0010
                else if (action.equals("XXXXmntoDistri")) {
                    String[] DistribuidorMnto = request.getParameterValues("distribuidor");
                    String distribuidorStr = "";
                    for (String distribuidor : DistribuidorMnto) {
                        if (!distribuidorStr.equals("")) {
                            distribuidorStr += ",";
                        }
                        distribuidorStr += distribuidor;
                    }
                    session.removeAttribute("guardado");
                    DaoMntoDistribuidor dmd = new DaoMntoDistribuidor();
                    dmd.buscaDatosDistribuidor(session, distribuidorStr);
                    session.setAttribute("vtc_imp_tarifa", dmd.getVtc_imp_tarifa());
                    session.setAttribute("vtc_ent_numero", dmd.getVtc_ent_numero());
                    session.setAttribute("vtc_estatus", dmd.getVtc_estatus());
                    session.setAttribute("nombreDistribuidor", dmd.getVtc_nom_distr());
                    session.setAttribute("claveDistribuidor", dmd.getVtc_id_distr());
                    url = "/mantenimientoDistribuidor.jsp";
                } else if (action.equals("guardadoMantDistri")) {
                    DaoMntoDistribuidor dmd = new DaoMntoDistribuidor();
                    dmd.setVtc_imp_tarifa(Double.parseDouble(request.getParameter("vtc_imp_tarifa")));
                    dmd.setVtc_ent_numero(Integer.parseInt(request.getParameter("vtc_ent_numero")));
                    if (request.getParameter("cbo_estatus").equals("0")) {
                        dmd.setVtc_estatus("A");
                    } else {
                        dmd.setVtc_estatus("B");
                    }
                    String distribuidorMnto = request.getParameter("claveDistribuidor");
                    dmd.guardaDatosDistribuidor(session, distribuidorMnto);
                    // re abre pagina
                    dmd.buscaDatosDistribuidor(session, distribuidorMnto);
                    session.setAttribute("vtc_imp_tarifa", dmd.getVtc_imp_tarifa());
                    session.setAttribute("vtc_ent_numero", dmd.getVtc_ent_numero());
                    session.setAttribute("vtc_estatus", dmd.getVtc_estatus());
                    session.setAttribute("nombreDistribuidor", dmd.getVtc_nom_distr());
                    session.setAttribute("claveDistribuidor", dmd.getVtc_id_distr());
                    session.setAttribute("guardado", "ok");
                    url = "/mantenimientoDistribuidor.jsp";
                } else if (action.equals("AltasLACPI")) {
                    Collection listado = new ArrayList();
                    String accion = "";
                    AltasDAO modelo = new AltasDAO();
                    String[] claves = null;
                    Collection listado2 = new ArrayList();
                    Collection listado3 = new ArrayList();
                    String cuenta = "";
                    String afiliacion = "";
                    String feIni = "";
                    String feFin = "";

                    // CREA LA FORMA
                    AltasForm altasForm = new AltasForm();
                    accion = request.getParameter("accion");

                    if (accion == null) {
                        accion = "";
                    }

                    // LA ACCION INICIAL ES LISTADO
                    if (("".compareTo(accion) == 0) || ("1".compareTo(accion) == 0)) {
                        // OBTIENE EL LISTADO DE LA BD
                        listado = modelo.listarAfiliaciones();
                        listado3 = modelo.listarCuentas();

                        // PONE LOS VALORES INICIALES
                        altasForm.setAccion("1");
                        altasForm.setListado(listado);
                        altasForm.setNumListado(String.valueOf(listado.size()));
                        altasForm.setListado3(listado3);
                        altasForm.setNumListado3(String.valueOf(listado3.size()));
                        url = "/Altas.jsp";
                        session.setAttribute("datos", altasForm);
                    } // LA ACCION ES 0, CANCELAR
                    else if ("0".compareTo(accion) == 0) {
                        // LA SIGUIENTE PANTALLA ES BLANCO
                        url = "/index.jsp";
                    } // LA ACCION ES 2, CREAR AFILIACION
                    else if ("2".compareTo(accion) == 0) {
                        // PONE LA ACCION EN LA SESION
                        AfiliacionForm afiliacionForm = new AfiliacionForm();
                        afiliacionForm.setAfiliacion("");
                        afiliacionForm.setAccion("2");
                        url = "/Afiliacion.jsp";
                        session.setAttribute("datos", afiliacionForm);
                    } // LA ACCION ES 4, BORRAR AFILIACION
                    else if ("4".compareTo(accion) == 0) {
                        // OBTIENE LA TERMINAL A BORRAR
                        claves = request.getParameterValues("idafiliacion");

                        // PROCESA LA LISTA DE REGISTROS
                        if (claves == null) {
                            altasForm.setError("Debe elegir un registro para eliminar");
                        } else {
                            // PROCESA LA LISTA A BORRAR
                            for (int i = 0; i < claves.length; i++) {
                                // ELIMINA EL PREFIJO
                                modelo.borrarAfiliacion(claves[i]);
                            }
                        }

                        // OBTIENE EL LISTADO DE LA BD
                        listado = modelo.listarAfiliaciones();
                        listado3 = modelo.listarCuentas();

                        // PONE LOS VALORES INICIALES
                        altasForm.setAccion("1");
                        altasForm.setListado(listado);
                        altasForm.setNumListado(String.valueOf(listado.size()));
                        altasForm.setListado3(listado3);
                        altasForm.setNumListado3(String.valueOf(listado3.size()));
                        url = "/Altas.jsp";
                        session.setAttribute("datos", altasForm);
                    } // LA ACCION ES 6, CREAR CUENTA
                    else if ("6".compareTo(accion) == 0) {
                        // PONE LA ACCION EN LA SESION
                        CuentaForm cuentaForm = new CuentaForm();
                        cuentaForm.setCuenta("");
                        cuentaForm.setAccion("6");
                        url = "/Cuenta.jsp";
                        session.setAttribute("datos", cuentaForm);
                    } // LA ACCION ES 8, BORRAR CUENTA
                    else if ("8".compareTo(accion) == 0) {
                        // OBTIENE LA TERMINAL A BORRAR
                        claves = request.getParameterValues("idcuenta");

                        // PROCESA LA LISTA DE REGISTROS
                        if (claves == null) {
                            altasForm.setError("Debe elegir un registro para eliminar");
                        } else {
                            // PROCESA LA LISTA A BORRAR
                            for (int i = 0; i < claves.length; i++) {
                                // ELIMINA EL PREFIJO
                                modelo.borrarCuenta(claves[i]);
                            }
                        }

                        // OBTIENE EL LISTADO DE LA BD
                        listado = modelo.listarAfiliaciones();
                        listado3 = modelo.listarCuentas();

                        // PONE LOS VALORES INICIALES
                        altasForm.setAccion("1");
                        altasForm.setListado(listado);
                        altasForm.setNumListado(String.valueOf(listado.size()));
                        altasForm.setListado3(listado3);
                        altasForm.setNumListado3(String.valueOf(listado3.size()));
                        url = "/Altas.jsp";
                        session.setAttribute("datos", altasForm);
                    }
                } // MODULO DE AFILIACION
                else if (action.equals("AfiliacionLACPI")) {
                    String accion = "";
                    AltasDAO modelo = new AltasDAO();
                    AfiliacionObj datos = new AfiliacionObj();
                    String clave = request.getParameter("afiliacion");
                    String validacion = "";

                    accion = request.getParameter("accion");
                    if (accion == null) {
                        accion = "";
                    }

                    // SI LA ACCION ES CREAR
                    if (accion.compareTo("2") == 0) {
                        validacion = validaAfiliacion(clave);

                        // SI LA VALIDACION ES CORRECTA
                        if (validacion.length() == 0) {
                            // CREA EL OBJETO CON LOS VALORES EN PANTALLA Y LO INSERTA
                            datos.setAfiliacion(clave);
                            modelo.crearAfiliacion(datos);

                            url = "/Altas.jsp";
                            Collection listado = new ArrayList();
                            Collection listado3 = new ArrayList();

                            // CREA LA FORMA
                            AltasForm altasForm = new AltasForm();

                            // OBTIENE EL LISTADO DE LA BD
                            listado = modelo.listarAfiliaciones();
                            listado3 = modelo.listarCuentas();

                            // PONE LOS VALORES INICIALES
                            altasForm.setAccion("1");
                            altasForm.setListado(listado);
                            altasForm.setNumListado(String.valueOf(listado.size()));
                            altasForm.setListado3(listado3);
                            altasForm.setNumListado3(String.valueOf(listado3.size()));
                            session.setAttribute("datos", altasForm);
                        } else {
                            AfiliacionForm afiliacionForm = new AfiliacionForm();
                            afiliacionForm.setAfiliacion(clave);
                            afiliacionForm.setError(validacion);
                            afiliacionForm.setAccion("2");
                            url = "/Afiliacion.jsp";
                            session.setAttribute("datos", afiliacionForm);
                        }
                    } else {
                        url = "/index.jsp";
                    }
                } // MODULO DE CUENTA
                else if (action.equals("CuentaLACPI")) {
                    String accion = "";
                    AltasDAO modelo = new AltasDAO();
                    CuentaObj datos = new CuentaObj();
                    String clave = request.getParameter("cuenta");
                    String validacion = "";

                    accion = request.getParameter("accion");
                    if (accion == null) {
                        accion = "";
                    }

                    // SI LA ACCION ES CREAR
                    if (accion.compareTo("6") == 0) {
                        validacion = validaCuenta(clave);

                        // SI LA VALIDACION ES CORRECTA
                        if (validacion.length() == 0) {
                            // CREA EL OBJETO CON LOS VALORES EN PANTALLA Y LO INSERTA
                            datos.setCuenta(clave);
                            modelo.crearCuenta(datos);

                            url = "/Altas.jsp";
                            Collection listado = new ArrayList();
                            Collection listado3 = new ArrayList();

                            // CREA LA FORMA
                            AltasForm altasForm = new AltasForm();

                            // OBTIENE EL LISTADO DE LA BD
                            listado = modelo.listarAfiliaciones();
                            listado3 = modelo.listarCuentas();

                            // PONE LOS VALORES INICIALES
                            altasForm.setAccion("1");
                            altasForm.setListado(listado);
                            altasForm.setNumListado(String.valueOf(listado.size()));
                            altasForm.setListado3(listado3);
                            altasForm.setNumListado3(String.valueOf(listado3.size()));
                            session.setAttribute("datos", altasForm);
                        } else {
                            CuentaForm cuentaForm = new CuentaForm();
                            cuentaForm.setCuenta(clave);
                            cuentaForm.setError(validacion);
                            cuentaForm.setAccion("6");
                            url = "/Cuenta.jsp";
                            session.setAttribute("datos", cuentaForm);
                        }
                    } else {
                        url = "/index.jsp";
                    }
                } else if (action.equals("ConsultaLACPI")) {
                    Collection listado = new ArrayList();
                    String accion = "";
                    String cuenta = "";
                    String afiliacion = "";
                    String feIni = "";
                    String feFin = "";
                    AltasDAO modelo = new AltasDAO();
                    url = "/Consulta.jsp";
                    String validacion = "";
                    String validacion2 = "";

                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                    java.sql.Date fechaIni;
                    java.sql.Date fechaFin;

                    // OBTIENE LA FECHA ACTUAL
                    Calendar currenttime = Calendar.getInstance();

                    // TRABAJA EN LA ZONA HORARIA DE MEXICO
                    currenttime.setTimeZone(TimeZone.getTimeZone("GMT-06:00"));

                    // CREA LA FORMA
                    ConsultaForm consultaForm = new ConsultaForm();
                    accion = request.getParameter("accion");

                    if (accion == null) {
                        accion = "";
                    }

                    // LA ACCION ES BLANCO, INICIALIZA
                    if ("".compareTo(accion) == 0) {
                        // OBTIENE LA FECHA DEFAULT DE INICIO Y FIN
                        // FIN ES LA FECHA ACTUAL, INICIO ES UN MES ATRAS
                        fechaFin = new java.sql.Date((currenttime.getTime()).getTime());
                        currenttime.add(Calendar.MONTH, -3);
                        fechaIni = new java.sql.Date((currenttime.getTime()).getTime());

                        feIni = formatoFecha.format(fechaIni);
                        feFin = formatoFecha.format(fechaFin);

                        // PONE LOS DATOS EN BLANCO
                        // DATOS ELEGIDOS MAS LISTADO OBTENIDO
                        consultaForm.setAccion("1");
                        consultaForm.setCuenta("");
                        consultaForm.setAfiliacion("");
                        consultaForm.setFechaInicio(feIni);
                        consultaForm.setFechaFinal(feFin);
                    } // LA ACCION ES 0, CANCELAR
                    else if ("0".compareTo(accion) == 0) {
                        // LA SIGUIENTE PANTALLA ES BLANCO
                        url = "/index.jsp";
                    } else {
                        // OBTIENE LA FECHA DEFAULT DE INICIO Y FIN
                        // FIN ES LA FECHA ACTUAL, INICIO ES UN MES ATRAS
                        fechaFin = new java.sql.Date((currenttime.getTime()).getTime());
                        currenttime.add(Calendar.MONTH, -3);
                        fechaIni = new java.sql.Date((currenttime.getTime()).getTime());

                        // OBTIENE LOS CRITERIOS ELEGIDOS
                        cuenta = request.getParameter("cuenta");
                        afiliacion = request.getParameter("afiliacion");
                        feIni = request.getParameter("fechaInicio");
                        feFin = request.getParameter("fechaFinal");

                        // PONE LOS VALORES DEFAULT, SI ESTAN EN BLANCO
                        if ("".compareTo(feIni) == 0) {
                            feIni = formatoFecha.format(fechaIni);
                        }

                        if ("".compareTo(feFin) == 0) {
                            feFin = formatoFecha.format(fechaFin);
                        }

                        validacion = validaCuentaSin(cuenta);
                        validacion2 = validaAfiliacion(afiliacion);
                        if (validacion.length() == 0 && validacion2.length() == 0) {
                            // OBTIENE EL LISTADO DE DEVOLUCIONES
                            listado = modelo.consultarDevoluciones(feIni, feFin, afiliacion, cuenta);

                            // PONE LOS DATOS DE LA FORMA
                            // DATOS ELEGIDOS MAS LISTADO OBTENIDO
                            consultaForm.setAccion("1");
                            consultaForm.setCuenta(cuenta);
                            consultaForm.setAfiliacion(afiliacion);
                            consultaForm.setListado(listado);
                            consultaForm.setFechaInicio(feIni);
                            consultaForm.setFechaFinal(feFin);
                        } else {
                            // PONE LOS DATOS DE LA FORMA
                            // DATOS ELEGIDOS MAS LISTADO OBTENIDO
                            consultaForm.setAccion("1");
                            consultaForm.setCuenta(cuenta);
                            consultaForm.setAfiliacion(afiliacion);
                            consultaForm.setListado(null);
                            consultaForm.setFechaInicio(feIni);
                            consultaForm.setFechaFinal(feFin);
                            consultaForm.setError(validacion);
                            consultaForm.setError2(validacion2);
                        }

                    }
                    session.setAttribute("datos", consultaForm);
                } else if (action.equals("soporte")) {
                    url = "/soporteHeader.jsp";
                } else if (action.equals("aggsoporte")) {
                    url = "/aggsoporte.jsp?btnaggsoporte=Agregar";
                } else if (action.equals("detallesoporte")) {
                    String rbtn = request.getParameter("rbtn");
                    url = "/detallesoporte.jsp?rbtn=" + rbtn + "&btndetallesoporte=Consultar";
                } else if (action.equals("descargarsoporte")) {
                    String rbtn = request.getParameter("rbtn");
                    url = "/descargarsoporte.jsp?rbtn=" + rbtn + "&btndescargar=Descargar";
                } else if (action.equals("editarsoporte")) {
                    String rbtn = request.getParameter("rbtn");
                    url = "/editarsoporte.jsp?rbtn=" + rbtn + "&btneditar=Editar";
                } else if (action.equals("eliminarsoporte")) {
                    String rbtn = request.getParameter("rbtn");
                    url = "/eliminarsoporte.jsp?rbtn=" + rbtn + "&btneliminarsoporte=OK";
                } else if (action.equals("inserta")) {
                    url = "/insertar.jsp";
                } else if (action.equals("losprefijos")) {
                    url = "/losprefijosheader.jsp";
                } else if (action.equals("losprefijosmain")) {
                    url = "/losprefijosmain.jsp";
                } else if (action.equals("elimodprefijo") || action.equals("modificaprefijo")) {
                    url = "/elimodprefijo.jsp";
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

    private String validaAfiliacion(String cuenta) {
        BigInteger numero;
        String regreso = "";
        AltasDAO modelo = new AltasDAO();

        if (cuenta.length() == 0) {
            return regreso;
        }

        if (modelo.existeAfiliacion(cuenta) == true) {
            return "La Afiliacion ya existe";
        }
        try {
            numero = new BigInteger(cuenta);

            if (numero.compareTo(new BigInteger("0")) <= 0) {
                regreso = "El campo debe ser positivo";
            }
        } catch (Exception ex) {
            regreso = "El campo debe ser num&eacute;rico";
        }
        return regreso;
    }

    // VALIDA LA CUENTA IMPORTANDO LA LONGITUD (ALTA)
    private String validaCuenta(String cuenta) {
        BigInteger numero;
        String regreso = "";
        AltasDAO modelo = new AltasDAO();

        if (cuenta.length() == 0) {
            return regreso;
        }

        if (modelo.existeCuenta(cuenta) == true) {
            return "La Cuenta ya existe";
        }

        // LA CUENTA DEBE SER NUMERICA SI SE CAPTURA
        if (cuenta.length() >= 16) {
            try {
                numero = new BigInteger(cuenta);

                if (numero.compareTo(new BigInteger("0")) <= 0) {
                    regreso = "El campo debe ser positivo";
                }
            } catch (Exception ex) {
                regreso = "El campo debe ser num&eacute;rico";
            }
        } else {
            regreso = "Debe ser num&eacute;rico de m&iacute;nimo 16 d&iacute;gitos";
        }
        return regreso;
    }

    private String validaCuentaSin(String cuenta) {
        BigInteger numero;
        String regreso = "";
        AltasDAO modelo = new AltasDAO();
        if (cuenta.length() == 0) {
            return regreso;
        }
        if (modelo.existeCuenta(cuenta) == true) {
            return "La Cuenta ya existe";
        }
        try {
            numero = new BigInteger(cuenta);

            if (numero.compareTo(new BigInteger("0")) <= 0) {
                regreso = "El campo debe ser positivo";
            }
        } catch (Exception ex) {
            regreso = "El campo debe ser num&eacute;rico";
        }
        return regreso;
    }
}
