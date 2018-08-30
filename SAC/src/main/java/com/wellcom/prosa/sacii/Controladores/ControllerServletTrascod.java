/*###############################################################################
# Nombre del Programa :  ControllerServletTrascod.java                          #
# Autor               :  Juan Rodriguez Gonzalez                                #
# Compania            :  IDSYS S.A. DE C.V.                                     #
# Proyecto/Procliente :  P-22-0136-14                 Fecha: 12/06/2017         #
# Modificacion        :  Trascodificadas  SAC2                                  #
#################################################################################
#                                                              Modificaciones   #
#-------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
package com.wellcom.prosa.sacii.Controladores;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import biz.ideasoft.beans.ViewerManager;

import com.wellcom.Validator.Mantenimiento;
import com.wellcom.Validator.Validador;
import com.wellcom.prosa.Controladores.ControllerMethod;
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
 * Servlet implementation class ControllerServletTrascod
 */
public class ControllerServletTrascod extends HttpServlet {

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
    public ControllerServletTrascod() {
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
            System.out.println("ControllerServletTrascod session: " + this.sessionId);
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
            System.out.println("Action Login ControllerServletTrascod: " + action);
            if (action != null) {
                if (action.equals("login")) {
                    //session.invalidate();
                    url = "/login.jsp";
                } //Comienzan reportes 
                //Reporte SICTRC0001
                else if(action.equals("SICTRC0001"))
                {
                   url = "/SICTRC0001Header.jsp";
                }
                else if(action.equals("SICTRC0001Main"))
                {
                  try
                    {
                      String initDate = request.getParameter("txtfStartDate");
                      String endDate = request.getParameter("txtfEndDate");
                      //String fiid = request.getParameter("numFiid");
                      String[] bancosAdq = request.getParameterValues("numFiid");
                      String fiid = "";
                      for (String bancoAdqr : bancosAdq) {
                          if (!fiid.equals("")) {
                              fiid += ",";
                          }
                          fiid += bancoAdqr;
                      }
                      String CtaO = request.getParameter("txtfCtaOri");
                      String CtaD = request.getParameter("txtfCtaDest");

                      session.setAttribute("txtfStartDate", initDate);
                      session.setAttribute("txtfEndDate", endDate);
                      session.setAttribute("numFiid",fiid);
                      session.setAttribute("txtfCtaOri",CtaO);
                      session.setAttribute("txtfCtaDest",CtaD);
                      url = value.valida(session, initDate, endDate,"SICTRC0001");
                      viewerManager.setUpViewer(this, request, response, url);
                      isAnswerReport=true;
                    }catch (WellException e) {e.printStackTrace();}
                }
                 //Reporte SICTRC0002
                 else if(action.equals("SICTRC0002"))
                 {
                    url = "/SICTRC0002Header.jsp";
                 }else if(action.equals("SICTRC0002Main"))
                 {
                    try
                     {
                       //metodo = new ControllerMethod();
                       String initDate = request.getParameter("txtfStartDate");
                       String endDate = request.getParameter("txtfEndDate");
                       /*String fiid = request.getParameter("numFiid");*/
                       String[] bancosAdq = request.getParameterValues("numFiid");
                       String fiid = "";
                       int aux=0;
                       if (aux == 0)
                       {
                           fiid +="'";
                       }else{aux++;}
                        for (String bancoAdqr : bancosAdq) {
                            if (!fiid.equals("")) {
                                if (aux == 0)
                                {
                                    fiid +="'";
                                }else{aux++;}
                                fiid += ",'";
                            }
                            fiid += bancoAdqr;
                        }
                        fiid +="'";
                        fiid = fiid.substring(3, fiid.length());
                       String CtaO = request.getParameter("txtfCtaOri2");
                       String CtaD = request.getParameter("txtfCtaDest2");
                       session.setAttribute("txtfStartDate", initDate);
                       session.setAttribute("txtfEndDate", endDate);
                       session.setAttribute("numFiid", fiid);
                       session.setAttribute("txtfCtaOri2",CtaO);
                       session.setAttribute("txtfCtaDest2",CtaD);
                       url = value.valida(session, initDate, endDate, "SICTRC0002");
                       viewerManager.setUpViewer(this, request, response, url);
                       isAnswerReport=true;
                     }catch (WellException e){e.printStackTrace();}
                 }
                //Terminan los  reportes 
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
            System.out.println("FIN PROCESS REQUEST: "+url);
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
        String retorno = "a10";
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
