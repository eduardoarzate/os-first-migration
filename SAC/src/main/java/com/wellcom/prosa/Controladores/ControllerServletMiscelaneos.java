/*###############################################################################
# Nombre del Programa :  ControllerServletMiscelaneos.java                         #
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Servlet implementation class ControllerServletMiscelaneos
 */
public class ControllerServletMiscelaneos extends HttpServlet {

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
    public ControllerServletMiscelaneos() {
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
            System.out.println("ControllerServletMiscelaneos session: " + this.sessionId);
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
                    System.out.println("Action Login ControllerServletMiscelaneos: " + action);
                    url = "/login.jsp";
                } //Comienzan reportes 
                else if (action.equals("Miscelaneos")) {
                    url = "/MiscelaneosHeader.jsp";
                } else if (action.equals("errorMisc")) {
                    url = "/Miscelaneos.jsp";
                } else if (action.equals("Miscelaneos.do")) {
                    conOracle = new ConexionORACLE();
                    String usuario;
                    ResultSet rs = null;
                    String descripcion = "MODIFICACION DE PARAMETROS EN MISCELANEO 103";
                    String[] list_ant = new String[6];
                    String[] list_act = new String[6];
                    ArrayList list_aux = null;
                    String txtCreVen = request.getParameter("txtCreVen");
                    String txtCrePag = request.getParameter("txtCrePag");
                    String txtCreDev = request.getParameter("txtCreDev");
                    String txtDebVen = request.getParameter("txtDebVen");
                    String txtDebPag = request.getParameter("txtDebPag");
                    String txtDebDev = request.getParameter("txtDebDev");
                    String obs = request.getParameter("observ");

                    //Numero total de Registros
                    String sql = "SELECT PP_VALOR FROM PRSA_PARAMETROS "
                            + "WHERE PP_ID_PARAMETRO='EGLOMISC_103'";

                    String sqlU1 = "UPDATE PRSA_PARAMETROS "
                            + "SET PP_VALOR='" + txtCreVen + "' "
                            + "WHERE PP_ID_PARAMETRO='EGLOMISC_103' "
                            + "AND PP_CLAVE='01MISC_CR'";

                    String sqlU2 = "UPDATE PRSA_PARAMETROS "
                            + "SET PP_VALOR='" + txtCrePag + "' "
                            + "WHERE PP_ID_PARAMETRO='EGLOMISC_103' "
                            + "AND PP_CLAVE='20MISC_CR'";

                    String sqlU3 = "UPDATE PRSA_PARAMETROS  "
                            + "SET PP_VALOR='" + txtCreDev + "' "
                            + "WHERE PP_ID_PARAMETRO='EGLOMISC_103' "
                            + "AND PP_CLAVE='21MISC_CR'";

                    String sqlU4 = "UPDATE PRSA_PARAMETROS "
                            + "SET PP_VALOR='" + txtDebVen + "' "
                            + "WHERE PP_ID_PARAMETRO='EGLOMISC_103' "
                            + "AND PP_CLAVE='01MISC_DB'";

                    String sqlU5 = "UPDATE PRSA_PARAMETROS "
                            + "SET PP_VALOR='" + txtDebPag + "' "
                            + "WHERE PP_ID_PARAMETRO='EGLOMISC_103' "
                            + "AND PP_CLAVE='20MISC_DB'";

                    String sqlU6 = "UPDATE PRSA_PARAMETROS "
                            + "SET PP_VALOR='" + txtDebDev + "' "
                            + "WHERE PP_ID_PARAMETRO='EGLOMISC_103' "
                            + "AND PP_CLAVE='21MISC_DB'";
                    usuario = (String) session.getAttribute("login");

                    try {

                        conOracle.Conectar();
                        conOracle.Consultar(sql);
                        rs = conOracle.getResultSet();
                    } catch (Exception ex) {
                        /*throw new WellException("com.wellcom.ReloadServlet.validacion: " + ex);*/
                        System.out.println("Error Query1:-------->" + ex);
                    } finally {
                        conOracle.Desconectar();
                    }

                    for (int i = 0; i < 6; i++) {
                        try {
                            rs.next();
                            list_ant[i] = rs.getString(1).replaceAll(" ", "");
                            //  System.out.println("Val rs: " + list_ant[i] + " - " + rs.getString(1));
                        } catch (SQLException ex) {
                            System.out.println("Error al obtener los registros");
                        }
                    }

                    int bandera = 0, val_aux = 0, valid = 0;
                    //Verifica los valores obtenidos de los textbox, si son diferentes de null los guarda en la base de datos
                    if (obs.contentEquals(" ")) {
                        obs = "Se cambia el valor de";
                        val_aux = 1;
                    }

                    if (!(txtCreVen.equals("") && txtCrePag.equals("") && txtCreDev.equals("")
                            && txtDebVen.equals("") && txtDebPag.equals("") && txtDebDev.equals(""))) {
                        try {
                            if (!txtCreVen.equals("")) {
                                System.out.println(Float.parseFloat(txtCreVen));
                            }
                            if (!txtCrePag.equals("")) {
                                System.out.println(Float.parseFloat(txtCrePag));
                            }
                            if (!txtCreDev.equals("")) {
                                System.out.println(Float.parseFloat(txtCreDev));
                            }
                            if (!txtDebVen.equals("")) {
                                System.out.println(Float.parseFloat(txtDebVen));
                            }
                            if (!txtDebPag.equals("")) {
                                System.out.println(Float.parseFloat(txtDebPag));
                            }
                            if (!txtDebDev.equals("")) {
                                System.out.println(Float.parseFloat(txtDebDev));
                            }
                        } catch (NumberFormatException ex) {
                            valid++;
                        }
                    }
                    System.out.println("valid: " + valid);
                    if (valid == 0) {
                        try {
                            //System.out.println("Lista anterior: " + list_ant[0] + list_ant[1] + list_ant[2] + list_ant[3] + list_ant[4] + list_ant[5]);
                            conOracle.Conectar();
                            if (!txtCreVen.equals("")) {
                                conOracle.Modificar(sqlU1);
                                list_act[0] = txtCreVen;
                                if (val_aux == 1) {
                                    obs += " credito en ventas a " + txtCreVen;
                                }
                                bandera = 1;
                            }
                            if (!txtCrePag.equals("")) {
                                conOracle.Modificar(sqlU2);
                                list_act[1] = txtCrePag;
                                if (val_aux == 1) {
                                    obs += " credito en pagos a " + txtCrePag;
                                }
                                bandera = 1;
                            }
                            if (!txtCreDev.equals("")) {
                                conOracle.Modificar(sqlU3);
                                list_act[2] = txtCreDev;
                                if (val_aux == 1) {
                                    obs += " credito en devoluciones a " + txtCreDev;
                                }
                                bandera = 1;
                            }
                            if (!txtDebVen.equals("")) {
                                conOracle.Modificar(sqlU4);
                                list_act[3] = txtDebVen;
                                if (val_aux == 1) {
                                    obs += " debito en ventas a " + txtDebVen;
                                }
                                bandera = 1;
                            }
                            if (!txtDebPag.equals("")) {
                                conOracle.Modificar(sqlU5);
                                list_act[4] = txtDebPag;
                                if (val_aux == 1) {
                                    obs += " debito en pagos a " + txtDebPag;
                                }
                                bandera = 1;
                            }
                            if (!txtDebDev.equals("")) {
                                conOracle.Modificar(sqlU6);
                                list_act[5] = txtDebDev;
                                if (val_aux == 1) {
                                    obs += " debito en devoluciones a " + txtDebDev;
                                }
                                bandera = 1;
                            }
                        } catch (Exception ex) {
                            /*throw new WellException("com.wellcom.ReloadServlet.validacion: " + ex.toString());*/
                            System.out.println("Error Query2:-------->" + ex.getMessage());
                        } finally {
                            conOracle.Desconectar();
                        }
                    }

                    //Prepara el query para actualizar PMT_PARAMETROS_BITACORA
                    String query = "INSERT INTO PMT_PARAMETROS_BITACORA (USUARIO,FECH_MOD,DESCRIPCION,OBSERVACIONES,"
                            + "VALOR_ANTERIOR,VALOR_ACTUAL) VALUES('"
                            + usuario + "',sysdate,'" + descripcion + "','" + obs + "','";

                    if (bandera == 1) {
                        for (int i = 0; i < 6; i++) {
                            if (i != 5) {
                                query += list_ant[i] + ",";
                            } else {
                                query += list_ant[i] + "','";
                            }
                        }

                        for (int i = 0; i < 6; i++) {
                            if (list_act[i] == null) {
                                list_act[i] = list_ant[i];
                            }
                            if (i != 5) {
                                query += list_act[i] + ",";
                            } else {
                                query += list_act[i] + "')";
                            }
                        }
                        System.out.println("Query: " + query);
                        //Guarda los cambios en PMT_PARAMETROS_BITACORA
                        try {
                            conOracle.Conectar();
                            conOracle.Insertar(query);
                        } catch (Exception ex) {
                            System.out.println("Error ACT:-------->" + ex);
                        } finally {
                            conOracle.Desconectar();
                        }
                    } else {
                        System.out.println("No se hara ningun cambio en miscelaneos");
                    }
                    if (valid == 0) {
                        url = "/Miscelaneos.jsp";
                    } else {
                        url = "/ErrorMiscelaneos.jsp";
                    }
                }//Terminan los  reportes 
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
