
/*###############################################################################
# Nombre del Programa :  ControllerServletMasterVisa.java                       #
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 23/05/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
#################################################################################
#                                                              Modificaciones   #
# Nombre del Programa :  ControllerServletMasterVisa.java                       #
# Autor               :  German Gonzalez                                        #
# Compania            :  Wellcom S.A. DE C.V.                                   #
# Proyecto/Procliente :  J-52-8248-17                 Fecha: 06/09/2017         #
# Modificacion        :  Mejora a Reportes SAC2                                 #
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.logging.Logger;

/**
 * Servlet implementation class ControllerServletMasterVisa
 */
public class ControllerServletMasterVisa extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private HttpSession session;
    String url;
    String rutaContext = "";
    private String sessionId, oldSessionId;
    Validador value;
    ParametrosCompartidos pC = new ParametrosCompartidos();
    ViewerManager viewerManager;
    ConexionORACLE conOracle = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServletMasterVisa() {
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

    // Inicia Modificacion J-52-8248-17 06-09-2017
    private void remplazar(String archivo)
    {
    	File file = new File(archivo);
    	
    	System.out.println("*****Backup Intialized******");
    	
		if(file.isFile()) {
			 System.out.println("SS:01:Start");
    	     String sourceFilePath = file.getAbsolutePath();
    	     System.out.println("SS:02a:sourceFilePath:"+sourceFilePath+":");
    	     String bakFilePath = sourceFilePath + "backup.bak";
    	     System.out.println("SS:03");
    	     File backupFile = new File(bakFilePath);   
    	     try {
				createBackup(file, backupFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	     System.out.println("SS:bakFilePath:"+bakFilePath+":");
    	     //file.renameTo(new File(archivo));
    	     //file.delete();
    		 backupFile.renameTo(new File(archivo+".ssv")); 
    	  } 
    	System.out.println("****Backup Completed*****");
    }
    
    public static void createBackup(File source, File target) throws IOException{
        InputStream in = new FileInputStream(source);
        OutputStream out = new FileOutputStream(target);
         
          byte[] buf = new byte[1024];
          int len;
     
          while ((len = in.read(buf)) > 0) {
        	  System.out.println("SS:CADENA:"+buf.toString()+":");
        	  String cadenita = new String(buf);
        	  //System.out.println(cadenita);
        	  //System.out.println(cadenita.replace("\"", " "));
        	  buf = cadenita.replace("\"", " ").getBytes();
        	  out.write(buf, 0, len);
          }
          in.close();
          out.close();
    }
    // Fin    Modificacion J-52-8248-17 06-09-2017
    
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
            System.out.println("ControllerServletMasterVisa session: " + this.sessionId);
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
            java.util.Date fechaActual = new java.util.Date();
            fechaHoy = formato.format(fechaActual);
            session.setAttribute("fechaHoy", fechaHoy);
        }
        Logger logger = null;
        ControllerMethod metodo = null;
        try {
            if (action != null) {
                if (action.equals("login")) {
                    System.out.println("Action Login ControllerServletMasterVisa: " + action);
                    url = "/login.jsp";
                } //Comienzan reportes 
                else if (action.equals("SICMIR0127_MASTER")) {
                    url = "/SICMIR0127_MASTERHeader.jsp";
                } else if (action.equals("SICMIR0127_MASTERMain")) {
                    SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
                    String inicial = request.getParameter("txtfStartDate");
                    String banco = request.getParameter("banco");
                    String bancoCad = request.getParameter("banco");
                    String ciclo = request.getParameter("ciclo");
                    String dcc = request.getParameter("dcc");

                    if (banco.length() < 2) {
                        banco = "000" + banco;
                    } else if (banco.length() < 3) {
                        banco = "00" + banco;
                    } else if (banco.length() < 4) {
                        banco = "0" + banco;
                    }

                    try {
                        session.setAttribute("ciclo", ciclo);
                        inicial = formateo.format(formateo.parse(inicial));

                        ArrayList dias;
                        ArrayList tienumero;
                        conOracle = new ConexionORACLE();
                        String SQL = "SELECT TO_CHAR(TO_DATE('" + inicial + "','DD/MM/YYYY'),'DDD') FROM DUAL";
                        conOracle.Conectar();
                        conOracle.Consultar(SQL);
                        dias = conOracle.getRSColsData();

                        String[] vv = (String[]) dias.get(0);
                        session.setAttribute("initDate", vv[0]);

                        String SQL2 = "SELECT DISTINCT PE.TIE_NUMERO FROM PMADMIN.PRSA_ENTIDADES PE WHERE PE.NUMERO_PROSA = " + bancoCad;

                        conOracle.Consultar(SQL2);
                        tienumero = conOracle.getRSColsData();

                        String[] vv2 = (String[]) tienumero.get(0);

                        String sFichero = "";

                        String tTipo = "";
                        if (vv2[0].equals("1"))//pesos
                        {
                            if (dcc.equals("i")) {
                                if (banco.equals("0007")) {
                                    banco = "0109";
                                    sFichero = "//aplic//prod//pmt//pmr//mcd//T14004023" + vv[0] + "0" + ciclo;
                                    tTipo = "T14004023";
                                    // Inicia Modificacion J-52-8248-17 06-09-2017
                                    remplazar(sFichero);
                                    // Fin Modificacion J-52-8248-17 06-09-2017
                                } else {
                                    sFichero = "//aplic//prod//pmt//pmr//mcd//T14005073" + vv[0] + "0" + ciclo;
                                    tTipo = "T14005073";
                                    // Inicia Modificacion J-52-8248-17 06-09-2017
                                    remplazar(sFichero);
                                    // Fin Modificacion J-52-8248-17 06-09-2017
                                }
                            } else {
                                sFichero = "//aplic//prod//pmt//pmr//mcd//T14002449" + vv[0] + "0" + ciclo;
                                tTipo = "T14002449";
                                // Inicia Modificacion J-52-8248-17 06-09-2017
                                remplazar(sFichero);
                                // Fin Modificacion J-52-8248-17 06-09-2017
                            }
                        } else if (vv2[0].equals("9") || banco.equals("1003"))//dolares
                        {
                            sFichero = "//aplic//prod//pmt//pmr//mcd//T14003287" + vv[0] + "0" + ciclo;
                            tTipo = "T14003287";
                            // Inicia Modificacion J-52-8248-17 06-09-2017
                            remplazar(sFichero);
                            // Fin Modificacion J-52-8248-17 06-09-2017
                        }

                        File fichero = new File(sFichero);
                        if (fichero.exists()) {
                            session.setAttribute("tipo", tTipo);
                            session.setAttribute("banco", banco);
                            url = "/reportsjsp/managerReports.jsp" + "?report=" + "SICMIR0127_MASTER";
                            viewerManager.setUpViewer(this, request, response, url);
                            isAnswerReport = true;
                        } else {
                            url = "/reportsjsp/Error.jsp";
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        conOracle.Desconectar();
                    }
                } //Reporte 0141
                else if (action.equals("SICMIR0141")) {
                    url = "/SICMIR0141Header.jsp";
                } else if (action.equals("SICMIR0141Main")) {
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

                    try {
                        url = value.valida(session, initDate, endDate, "Sicmir0141");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } //Reporte 0142
                else if (action.equals("SICMIR0142")) {
                    url = "/SICMIR0142Header.jsp";
                } else if (action.equals("SICMIR0142Main")) {
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

                    try {
                        url = value.valida(session, initDate, endDate, "Sicmir0142");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }//Reporte 0144
                else if (action.equals("SICMIR0144")) {
                    url = "/SICMIR0144Header.jsp";
                } else if (action.equals("SICMIR0144Main")) {
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

                    try {
                        url = value.valida(session, initDate, endDate, "Sicmir0144");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } //Reporte 0147
                else if (action.equals("SICMIR0147")) {
                    url = "/SICMIR0147Header.jsp";
                } else if (action.equals("SICMIR0147Main")) {

                    SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat formateo2 = new SimpleDateFormat("yyMMdd");
                    String inicial = request.getParameter("txtfStartDate");
                    String banco = request.getParameter("banco");

                    try {
                        session.setAttribute("banco", banco);
                        String inicial2 = formateo2.format(formateo.parse(inicial));
                        session.setAttribute("initDate", inicial2);

                        String sFichero = "//aplic//prod//pmt//pmr//mcd//728" + inicial2 + "_" + banco;
                        File fichero = new File(sFichero);
                        System.out.println("El fichero es: " + sFichero);
                        if (fichero.exists()) {
                            url = "/reportsjsp/managerReports.jsp" + "?report=" + "SICMIR0147";
                            viewerManager.setUpViewer(this, request, response, url);
                            isAnswerReport = true;
                        } else {
                            url = "/reportsjsp/Error.jsp";
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } //Reporte 0148
                else if (action.equals("SICMIR0148")) {
                    //session.setAttribute( "ENTIDADES", this.ENTIDADES );
                    url = "/SICMIR0148Header.jsp";
                } else if (action.equals("SICMIR0148Main")) {

                    SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat formateo2 = new SimpleDateFormat("yyMMdd");
                    String inicial = request.getParameter("txtfStartDate");
                    String icaBanco = request.getParameter("banco");

                    try {
                        String inicial2 = formateo2.format(formateo.parse(inicial));
                        session.setAttribute("initDate", inicial2);
                        session.setAttribute("icaBanco", icaBanco);

                        String sFichero = "//aplic//prod//pmt//pmr//mcd//851" + inicial2;
                        File fichero = new File(sFichero);
                        if (fichero.exists()) {
                            url = "/reportsjsp/managerReports.jsp" + "?report=" + "SICMIR0148";
                            viewerManager.setUpViewer(this, request, response, url);
                            isAnswerReport = true;
                        } else {
                            url = "/reportsjsp/Error.jsp";
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } //Reporte 0148b
                else if (action.equals("SICMIR0148b")) {
                    //session.setAttribute( "ENTIDADES", this.ENTIDADES );
                    url = "/SICMIR0148bHeader.jsp";
                } else if (action.equals("SICMIR0148bMain")) {

                    SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat formateo2 = new SimpleDateFormat("yyMMdd");
                    String inicial = request.getParameter("txtfStartDate");

                    try {
                        String inicial2 = formateo2.format(formateo.parse(inicial));
                        session.setAttribute("initDate", inicial2);

                        String sFichero = "//aplic//prod//pmt//pmr//mcd//852" + inicial2;
                        File fichero = new File(sFichero);
                        System.out.println("El fichero es: " + sFichero);
                        if (fichero.exists()) {
                            url = "/reportsjsp/managerReports.jsp" + "?report=" + "SICMIR0148b";
                            viewerManager.setUpViewer(this, request, response, url);
                            isAnswerReport = true;
                        } else {
                            url = "/reportsjsp/Error.jsp";
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } //Reporte 0145MC
                else if (action.equals("SICMIR0145MC")) {
                    url = "/SICMIR0145MCHeader.jsp";
                } else if (action.equals("SICMIR0145MCMain")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoEmi = request.getParameter("bancoEmi");
                    String[] bancoAdqArray = request.getParameterValues("bancoAdq");
                    String bancosAdq = "";
                    for (String banco : bancoAdqArray) {
                        if (!bancosAdq.equals("")) {
                            bancosAdq += ",";
                        }
                        bancosAdq += banco;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancosAdq);
                    try {
                        url = value.valida(session, initDate, endDate, "Sicmir0145mc");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 2145
                else if (action.equals("SICMIR2145")) {
                    url = "/SICMIR2145Header.jsp";
                } else if (action.equals("SICMIR2145Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String movimiento = request.getParameter("movimiento");
                    String[] bancoAdqArray = request.getParameterValues("bancoAdq");
                    String bancosAdq = "";
                    for (String banco : bancoAdqArray) {
                        if (!bancosAdq.equals("")) {
                            bancosAdq += ",";
                        }
                        bancosAdq += banco;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancosAdq);
                    session.setAttribute("movimiento", movimiento);
                    try {
                        url = value.valida(session, initDate, endDate, "Sicmir2145");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //termina Mastercard
                //Inicia VISA
                //Reporte 0121
                else if (action.equals("SICMIR0121")) {
                    url = "/SICMIR0121Header.jsp";
                } else if (action.equals("SICMIR0121Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoEmi = request.getParameter("bancoEmi");
                    String[] bancoSocioArray = request.getParameterValues("bancoSocio");
                    String bancosSocios = "";
                    for (String banco : bancoSocioArray) {
                        if (!bancosSocios.equals("")) {
                            bancosSocios += ",";
                        }
                        bancosSocios += banco;
                    }
                    String[] tipoTxnArray = request.getParameterValues("tipoTxn");
                    String tipoTxn = "";
                    for (String txn : tipoTxnArray) {
                        if (!tipoTxn.equals("")) {
                            tipoTxn += ",";
                        }
                        tipoTxn += txn;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoSocio", bancosSocios);
                    session.setAttribute("tipoTxn", tipoTxn);
                    try {
                        url = value.valida(session, initDate, endDate, "Sicmir0121");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0122
                else if (action.equals("SICMIR0122")) {
                    url = "/SICMIR0122Header.jsp";
                } else if (action.equals("SICMIR0122Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoEmi = request.getParameter("bancoEmi");
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
                        url = value.valida(session, initDate, endDate, "Sicmir0122");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0124
                else if (action.equals("SICMIR0124")) {
                    url = "/SICMIR0124Header.jsp";
                } else if (action.equals("SICMIR0124Main")) {
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
                    String[] ttCharbacks = request.getParameterValues("ttCharbacks");
                    String ttCharbacksStr = "";
                    for (String ttCharback : ttCharbacks) {
                        if (!ttCharbacksStr.equals("")) {
                            ttCharbacksStr += ",";
                        }
                        ttCharbacksStr += ttCharback;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosStr);
                    session.setAttribute("ttCharbacks", ttCharbacksStr);

                    try {
                        url = value.valida(session, initDate, endDate, "Sicmir0124");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }//Reporte 0126
                else if (action.equals("SICMIR0126")) {
                    url = "/SICMIR0126Header.jsp";
                } else if (action.equals("SICMIR0126Main")) {
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

                    try {
                        url = value.valida(session, initDate, endDate, "Sicmir0126");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } //Reporte 0127_bines
                else if (action.equals("SICMIR0127_BINES")) {
                    url = "/SICMIR0127_BINESHeader.jsp";
                } else if (action.equals("SICMIR0127_BINESMain")) {

                    SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat formateo2 = new SimpleDateFormat("yyMMdd");
                    String inicial = request.getParameter("txtfStartDate");
                    String banco = request.getParameter("banco");
                    if (banco.length() < 2) {
                        banco = "000" + banco;
                        System.out.println("Variable banco es " + banco);
                    } else if (banco.length() < 3) {
                        banco = "00" + banco;
                        System.out.println("Variable banco es " + banco);
                    } else if (banco.length() < 4) {
                        banco = "0" + banco;
                        System.out.println("Variable banco es " + banco);
                    }

                    try {
                        session.setAttribute("banco", banco);
                        String inicial2 = formateo2.format(formateo.parse(inicial));
                        session.setAttribute("initDate", inicial2);

                        String sFichero = "";

                        if (banco.equals("1001")) {
                            sFichero = "//aplic//prod//pmt//pmr//vsa//049" + inicial2 + "_102";
                            session.setAttribute("prefijo", "102");
                        } else if (banco.equals("1002") || banco.equals("1003")) {
                            sFichero = "//aplic//prod//pmt//pmr//vsa//049" + inicial2 + "_103";
                            session.setAttribute("prefijo", "103");
                        } else {
                            sFichero = "//aplic//prod//pmt//pmr//vsa//049" + inicial2 + "_101";
                            session.setAttribute("prefijo", "101");
                        }

                        File fichero = new File(sFichero);
                        if (fichero.exists()) {
                            url = "/reportsjsp/managerReports.jsp" + "?report=" + "SICMIR0127_BINES";
                            viewerManager.setUpViewer(this, request, response, url);
                            isAnswerReport = true;
                        } else {
                            url = "/reportsjsp/Error.jsp";
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } //Reporte 0127_vss
                else if (action.equals("SICMIR0127_VSS")) {
                    url = "/SICMIR0127_VSSHeader.jsp";
                } else if (action.equals("SICMIR0127_VSSMain")) {
                    SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat formateo2 = new SimpleDateFormat("yyMMdd");
                    String inicial = request.getParameter("txtfStartDate");
                    String banco = request.getParameter("banco");
                    String dcc = request.getParameter("dcc");
                    String prefijo = request.getParameter("prefijo");
                    if (banco.length() < 2) {
                        banco = "000" + banco;
                    } else if (banco.length() < 3) {
                        banco = "00" + banco;
                    } else if (banco.length() < 4) {
                        banco = "0" + banco;
                    }
                    try {
                        session.setAttribute("banco", banco);
                        String inicial2 = formateo2.format(formateo.parse(inicial));
                        session.setAttribute("initDate", inicial2);
                        String sFichero = "//aplic//prod//pmt//pmr//vsa//";
                        String sArchivo = "";
                        if (!banco.equals("0000")) {
                            if (banco.equals("1001") && (prefijo == null || prefijo.equals("102")) && !dcc.equals("i")) {
                                sArchivo = "049" + inicial2 + "_102";
                                session.setAttribute("prefijo", "102");
                                url = "/reportsjsp/managerReports.jsp" + "?report=" + "SICMIR0127_VSS";
                            } else if ((banco.equals("1002") || banco.equals("1003")) && (prefijo == null || prefijo.equals("103")) && !dcc.equals("i")) {
                                sArchivo = "049" + inicial2 + "_103";
                                session.setAttribute("prefijo", "103");
                                url = "/reportsjsp/managerReports.jsp" + "?report=" + "SICMIR0127_VSS";
                            } else if (banco.equals("0111")) {
                                if (dcc.equals("i") && (prefijo == null || prefijo.equals("105"))) {
                                    banco = "0111";
                                    sArchivo = "049" + inicial2 + "_105";
                                    session.setAttribute("prefijo", "105");
                                    session.setAttribute("banco", banco);
                                    url = "/reportsjsp/managerReports.jsp" + "?report=" + "SICMIR0127_VSS";
                                } else {
                                    url = "/reportsjsp/Error.jsp";
                                }
                            } else if (banco.equals("0007") || banco.equals("0109")) {
                                if (dcc.equals("i") && (prefijo == null || prefijo.equals("101"))) {
                                    banco = "0109";
                                    sArchivo = "1049" + inicial2 + "_101";
                                    session.setAttribute("prefijo", "101");
                                    session.setAttribute("banco", banco);
                                    url = "/reportsjsp/managerReports.jsp" + "?report=" + "SICMIR0127_VSS";
                                } else if (prefijo == null || prefijo.equals("101")) {
                                    sArchivo = "049" + inicial2 + "_101";
                                    session.setAttribute("prefijo", "101");
                                    url = "/reportsjsp/managerReports.jsp" + "?report=" + "SICMIR0127_VSS";
                                } else {
                                    url = "/reportsjsp/Error.jsp";
                                }
                            } else if ((prefijo == null || prefijo.equals("101")) && !dcc.equals("i")) {
                                sArchivo = "049" + inicial2 + "_101";
                                session.setAttribute("prefijo", "101");
                                url = "/reportsjsp/managerReports.jsp" + "?report=" + "SICMIR0127_VSS";
                            } else {
                                url = "/reportsjsp/Error.jsp";
                            }
                            sFichero += sArchivo;
                            File fichero = new File(sFichero);
                            if (fichero.exists()) {
                                session.setAttribute("dcc", dcc);
                                session.setAttribute("sArchivo", sArchivo);

                            } else {
                                url = "/reportsjsp/Error.jsp";
                            }
                            viewerManager.setUpViewer(this, request, response, url);
                            isAnswerReport = true;
                        } else {
                            //for(int i=1;i<=3;i++){
                            if (banco.equals("0111")) {
                                session.setAttribute("prefijo", prefijo);
                                sArchivo = "049" + inicial2 + "_" + prefijo;
                                url = "/reportsjsp/managerReports.jsp" + "?report=" + "SICMIR0127_VSS";
                            } else {
                                prefijo = request.getParameter("prefijo");
                                if (dcc.equals("i")) {
                                    sArchivo = "1049" + inicial2 + "_" + prefijo;
                                } else {
                                    sArchivo = "049" + inicial2 + "_" + prefijo;
                                }
                                url = "/reportsjsp/managerReports.jsp" + "?report=" + "SICMIR0127_VSS";
                            }
                            sFichero += sArchivo;
                            File fichero = new File(sFichero);
                            if (fichero.exists()) {
                                session.setAttribute("prefijo", prefijo);
                                session.setAttribute("dcc", dcc);
                                session.setAttribute("sArchivo", sArchivo);
                            } else {
                                url = "/reportsjsp/Error.jsp";
                            }
                            viewerManager.setUpViewer(this, request, response, url);
                            isAnswerReport = true;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } //Reporte 0127_vss Liverpool
                else if (action.equals("SICMIR0127_LIV")) {
                    url = "/SICMIR0127_LIVHeader.jsp";
                } else if (action.equals("SICMIR0127_LIVMain")) {
                    SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat formateo2 = new SimpleDateFormat("yyMMdd");
                    String inicial = request.getParameter("txtfStartDate");
                    String corte = request.getParameter("corte");
                    String sFichero = "";
                    String banco = request.getParameter("banco");
                    if (banco.length() < 2) {
                        banco = "000" + banco;
                    } else if (banco.length() < 3) {
                        banco = "00" + banco;
                    } else if (banco.length() < 4) {
                        banco = "0" + banco;
                    }

                    try {

                        String inicial2 = formateo2.format(formateo.parse(inicial));
                        session.setAttribute("initDate", inicial2);
                        session.setAttribute("banco", banco);
                        sFichero = "//aplic//prod//pmt//pmr//vsa//VSAINCLIVPD" + inicial2 + "EE0" + corte + ".DAT";
                        session.setAttribute("prefijo", corte);

                        File fichero = new File(sFichero);
                        if (fichero.exists()) {
                            url = "/reportsjsp/managerReports.jsp" + "?report=" + "SICMIR0127_LIV";
                            viewerManager.setUpViewer(this, request, response, url);
                            isAnswerReport = true;
                        } else {
                            url = "/reportsjsp/Error.jsp";
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } //empieza MEercados Internacionales                    
                else if (action.equals("SICMIR0129")) {
                    url = "/SICMIR0129Header.jsp";
                } else if (action.equals("SICMIR0129Main")) {
                    SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat formateo2 = new SimpleDateFormat("yyMMdd");
                    String inicial = request.getParameter("txtfStartDate");
                    String banco = request.getParameter("banco");
                    if (banco.length() < 2) {
                        banco = "000" + banco;
                    } else if (banco.length() < 3) {
                        banco = "00" + banco;
                    } else if (banco.length() < 4) {
                        banco = "0" + banco;
                    }
                    try {
                        session.setAttribute("banco", banco);
                        String inicial2 = formateo2.format(formateo.parse(inicial));
                        session.setAttribute("initDate", inicial2);
//                              String sFichero = "C://049"+inicial2+"_MI";
                        String sFichero = "//aplic//prod//pmt//pmr//vsa//049" + inicial2 + "_MI";
                        File fichero = new File(sFichero);
                        if (fichero.exists()) {
                            url = "/reportsjsp/managerReports.jsp" + "?report=" + "SICMIR0129";
                            viewerManager.setUpViewer(this, request, response, url);
                            isAnswerReport = true;
                        } else {
                            url = "/reportsjsp/Error.jsp";
                        }
//                              }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } //Reporte MIR0370
                else if (action.equals("SICMIR0370")) {
                    url = "/SICMIR0370Header.jsp";
                } else if (action.equals("SICMIR0370Main")) {
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
                        url = value.valida(session, initDate, endDate, "Sicmir0370");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                }//Reporte MIR0380
                else if (action.equals("SICMIR0380")) {
                    url = "/SICMIR0380Header.jsp";
                } else if (action.equals("SICMIR0380Main")) {
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
                        url = value.valida(session, initDate, endDate, "Sicmir0380");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte V140
                else if (action.equals("SICMIRV140")) {
                    url = "/SICMIRV140Header.jsp";
                } else if (action.equals("SICMIRV140Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoEmi = request.getParameter("bancoEmi");
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
                        url = value.valida(session, initDate, endDate, "Sicmirv140");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 0145
                else if (action.equals("SICMIR0145")) {
                    url = "/SICMIR0145Header.jsp";
                } else if (action.equals("SICMIR0145Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoEmi = request.getParameter("bancoEmi");
                    String[] bancoAdqArray = request.getParameterValues("bancoAdq");
                    String bancosAdq = "";
                    for (String banco : bancoAdqArray) {
                        if (!bancosAdq.equals("")) {
                            bancosAdq += ",";
                        }
                        bancosAdq += banco;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancosAdq);
                    try {
                        url = value.valida(session, initDate, endDate, "Sicmir0145");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte 1145
                else if (action.equals("SICMIR1145")) {
                    url = "/SICMIR1145Header.jsp";
                } else if (action.equals("SICMIR1145Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String movimiento = request.getParameter("movimiento");
                    String[] bancoAdqArray = request.getParameterValues("bancoAdq");
                    String bancosAdq = "";
                    for (String banco : bancoAdqArray) {
                        if (!bancosAdq.equals("")) {
                            bancosAdq += ",";
                        }
                        bancosAdq += banco;
                    }
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancosAdq);
                    session.setAttribute("movimiento", movimiento);
                    try {
                        url = value.valida(session, initDate, endDate, "Sicmir1145");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                }//Reporte VSA0010
                else if (action.equals("SICVSA0010")) {

                    url = "/SICVSA0010Header.jsp";
                } else if (action.equals("SICVSA0010Main")) {
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
                        url = value.valida(session, initDate, endDate, "Sicvsa0010");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte VSA0020
                else if (action.equals("SICVSA0020")) {

                    url = "/SICVSA0020Header.jsp";
                } else if (action.equals("SICVSA0020Main")) {
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
                        url = value.valida(session, initDate, endDate, "Sicvsa0020");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                }//Reporte VSA0030
                else if (action.equals("SICVSA0030")) {
                    url = "/SICVSA0030Header.jsp";
                } else if (action.equals("SICVSA0030Main")) {
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
                        url = value.valida(session, initDate, endDate, "Sicvsa0030");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte VSA0040
                else if (action.equals("SICVSA0040")) {
                    url = "/SICVSA0040Header.jsp";
                } else if (action.equals("SICVSA0040Main")) {
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
                        url = value.valida(session, initDate, endDate, "Sicvsa0040");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport = true;
                    } catch (WellException e) {
                        e.printStackTrace();
                    }
                } //Reporte VSA0050
                else if (action.equals("SICVSA0050")) {
                    url = "/SICVSA0050Header.jsp";
                } else if (action.equals("SICVSA0050Main")) {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String Tipo = request.getParameter("Tipo");
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
                    session.setAttribute("Tipo", Tipo);
                    try {
                        url = value.valida(session, initDate, endDate, "Sicvsa0050");
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
