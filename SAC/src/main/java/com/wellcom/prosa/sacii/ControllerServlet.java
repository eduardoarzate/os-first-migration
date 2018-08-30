/*###############################################################################
# Autor               :  JOAQUIN MOJICA Q.                                      #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-08-299-04                       FECHA:15/10/2008     #
# Descripcion General :                                                         #
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :  Acceder al sistema                                     #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :  A Peticion del web, se pueden ejecutar n instancias    #
#################################################################################
#                               MODIFICACIONES                                  #
# Autor               : ERIKA A. MOJICA                                         #
# Compania            : WELLCOM SA DE CV                                        #
# Proyecto/Procliente : P-02-1202-09                 Fecha: 08/02/2010          #
# Modificación        : AUTOMATIZACION DE PREPAGO                               #
#-----------------------------------------------------------------------------  #
# Autor               : Victor H Montoya G                                      #
# Compania            : eNova                                                   #
# Proyecto/Procliente : Z-04-3155-11                           Fecha: 27/12/2011#
# Modificacion        : nueva url en menu                                       #
#-----------------------------------------------------------------------------  #
# Autor               : Joaquin Mojica                                          #
# Compania            : WELLCOM                                                 #
# Proyecto/Procliente : N-08-2379-12                           Fecha: 05/11/2012#
# Modificacion        : Filtro de monto para CashBack                           #
#-----------------------------------------------------------------------------  #
#                               MODIFICACIONES                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-08-2253-12                Fecha: 13/02/2013          #
# Modificación        :  Adicionar indicadores ABM a Reporte de log certificado #
#-----------------------------------------------------------------------------  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  Z-09-2573-12                Fecha: 19/03/2013          #
# Modificación        : Alta BIN 50623 para OPAM #
#-----------------------------------------------------------------------------  #
# Autor               : Gerardo G. Burguete                                     #
# Compania            : Axia Consultores, S.A. de C.V.                          #
# Proyecto/Procliente : P-02-0496-10                            Fecha:11/12/2012#
# Modificacion        : DCC                                                     #
#-----------------------------------------------------------------------------  #
# Autor               : Gerardo G. Burguete                                     #
# Compania            : Axia Consultores, S.A. de C.V.                          #
# Proyecto/Procliente : P-04-3027-13                          Fecha: 23/12/2013 #
# Descripcion         : Extraccion de archivos VISA para Liverpool              #
# Modificacion        : Incorporacion de busqueda de Reporte VSS de Liverpool   #
# Marca del Cambio    : AXIA-GGB-P-04-3027-13                                   #
#-----------------------------------------------------------------------------  #
#                               MODIFICACIONES                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-08-2253-12                Fecha: 13/05/2013          #
# Modificación        :  Adicionar indicadores ABM a Reporte de log certificado #
# Numero de Parametros: 0                                                       #
#-----------------------------------------------------------------------------  #
# Autor               :  Gerardo G. Burguete                                    #
# Compania            :  Axia Consultores, S.A. DE C.V.                         #
# Proyecto/Procliente :  P-02-0060-12                Fecha: 19/09/2013          #
# Modificación        :  P-02-0060-12 DCC (Dynamic Currency Conversion) Banorte #
#                     :  con Planet Payment                                     #
#-----------------------------------------------------------------------------  #
# Autor               :  Carolina Martin del Campo Rodriguez                    #
# Compania            :  IDSYS S.A. DE C.V.                                     #
# Proyecto/Procliente :  N-08-2033-13                Fecha: 30/08/2013          #
# Modificaci?n        :  Miscelaneos 103 para modif. credito y debito        #
#-----------------------------------------------------------------------------  #
# Autor               :  Velasco Palacios Miguel                                #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  P-02-0216-12                Fecha: 03/06/2014          #
#                     :  Implementacion de Servicios Lealtad Max Value PROSA    #
#-----------------------------------------------------------------------------  #
# Autor               :  German Gonzelz Esquivel                                #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-52-2452-14                Fecha: 30/07/2014          #
#                     :  Nuevo reporte de Reverso de SCOTIABANK                 #
#-----------------------------------------------------------------------------  #
# Autor               :  German Gonzelz Esquivel                                #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-04-2207-13                Fecha: 14/10/2014          #
#                     :  Tokens para Adicionar indicadores ABM                  #
#-----------------------------------------------------------------------------  #
# Autor               : Gerardo G. Burguete                                     #
# Compania            : Axia, consultores, S.A. DE C.V.                         #
# Proyecto/Procliente : P-02-0275-12                 Fecha: 18/12/2014          #
# Modificacion        : Servicios Adquirente POS para Banco de Occidente.       #
# Marca del Cambio    : AXIA-GGB-P-02-0275-12                                   #
#-----------------------------------------------------------------------------  #
# Autor               : Luis Eduardo Ramírez Castillo                           #
# Compania            : Soporte y Asesoría en Sistemas                          #
# Proyecto/Procliente : F-52-2173-15                 Fecha: 02/03/2015          #
# Modificacion        :                                                         #
# Marca del Cambio    : SAS-LERC-F-52-2173-15                                   #
#################################################################################
# Autor               : MANUEL VILLALOBOS                                       #
# Compania            : GSOF CONSULTING                                         #
# Proyecto/Procliente : C-08-2129-12                 Fecha: 06/MAY/2015         #
# Marca del Cambio    : GSOF-MVR-C-08-2129-12                                   #
# Modificación        : DEVOLUCIONES LACPI                                      #
#################################################################################
# Autor               :  German Gonzelz Esquivel                                #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-06-2233-13                Fecha: 23/03/2015          #
#                     :  Nuevos reportes Corresponsales                         #
#-----------------------------------------------------------------------------  #
# Autor               :  Jose Pablo Lugo Correa                                 #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  P-53-2934-14                Fecha: 11/03/2015          #
#                     :  Implementación de Reporte para liquidacion nacional    #
#-----------------------------------------------------------------------------  #
# Autor               : Salvador Montiel                                        #
# Compania            : AM Estudio                                              #
# Proyecto/Procliente : P-54-2940-14               Fecha: 23/04/2015            #
# Modificacion        : Soporte Interactivo (FAQs,Tutoriales,Manuales)          #
# Marca del Cambio    : P-54-2940-14 AMEstudio 23.04.2015                       #
#-------------------------------------------------------------------------------#
# Autor               : Juan Antonio Guzman Gomez                               #
# Compania            : SAS S.A. DE C.V.                                        #
# Proyecto/Procliente : Z-02-2675-12                Fecha: 14/02/2013           #
# Modificacion        : Venta de tiempo aire en terminales punto de venta       #
#-----------------------------------------------------------------------------  #
# Autor               :  Jesus Parra Martinez                                   #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  P-06-0527-11                Fecha: 20/08/2014          #
#                     :  Implementación de Hub de Pagos en PROSA                #
#################################################################################
# Autor               : MANUEL VILLALOBOS                                       #
# Compania            : GSOF CONSULTING                                         #
# Proyecto/Procliente : C-08-2129-12                 Fecha: 18/SEP/2015         #
# Marca del Cambio    : GSOF-MVR-C-08-2129-12                                   #
# Modificación        : LACPI, SIN DUPLICADOS DE CUENTAS Y AFILIACIONES         #
#-----------------------------------------------------------------------------  #
# Autor               :  Jesus Parra Mtz.                                       #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  P-53-2934-14                Fecha: 06/10/2015          #
#                     :  Correccion Reportes para liquidacion nacional          #
#################################################################################
# Autor               : MANUEL VILLALOBOS                                       #
# Compania            : GSOF CONSULTING                                         #
# Proyecto/Procliente : B-54-2092-15                 Fecha: 26/OCT/2015         #
# Marca del Cambio    : GSOF-MVR-B-54-2092-15                                   #
# Modificación        : REPORTE SICLIRPA01                                      #
#-----------------------------------------------------------------------------  #
# Autor               : Gerardo G. Burguete                                     #
# Compania            : Axia, consultores, S.A. DE C.V.                         #
# Proyecto/Procliente : P-53-2933-14                 Fecha: 25/05/2015          #
# Descripcion General : Recalculo de compensacion y administracion de umbrales. #
# Modificacion        : sustituir la palabra Liquidación por compensación       #
# Marca del Cambio    : AXIA-GGB-P-53-2933-14                                   #
#################################################################################
#                          MODIFICACIONES                                       #
# Autor               : Miguel Nieto                                            #
# Compania            : Axia, consultores, S.A. DE C.V.                         #
# Proyecto/Procliente : P-53-2933-14                 Fecha: 24/02/2016          #
# Descripcion General : Corresponsales                                          #
# Modificacion        :                                                         #
# Marca del Cambio    : AXIA-MN-P-60-2646-14                                    #
#################################################################################
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS, S.A. DE C.V.                              #
# Proyecto/Procliente :  P-53-2004-15                Fecha: 17/05/2016          #
# Modificacion        :  Diferencia de cuotas entre cámaras                     #
# Marca del Cambio    :  SAS-DRT-P-53-2004-15                                   #
#################################################################################
# Autor               : Laura Maleni Ramírez Vázquez                            #
# Compania            : SAS S.A. DE C.V.                                        #
# Proyecto/Procliente : P-21-0013-16                 Fecha: 17/07/2016          #
# Descripcion General : Hub de Pagos para Mifel                                 #
# Marca del Cambio    : SAS-LMRV-P-21-0013-16                                   #
#################################################################################
# Autor               : MANUEL VILLALOBOS                                       #
# Compania            : GSOF CONSULTING                                         #
# Proyecto/Procliente : P-53-2727-14                 Fecha: 29/JUL/2016         #
# Marca del Cambio    : GSOF-MVR-P-53-2727-14                                   #
# Modificación        : REPORTES SICCMR                                         #
#-----------------------------------------------------------------------------  #
#                          MODIFICACIONES                                       #
# Autor               : Daniel Ramirez Torres                                   #
# Compania            : SAS S.A. DE C.V.                                        #
# Proyecto/Procliente : P-20-0096-15                 Fecha: 24/08/2016          #
# Descripcion General : Fase 2 del Programa Súper Ofertas Santander sobretasa 0 #
# Modificacion        :                                                         #
# Marca del Cambio    : SAS-DRT-P-20-0096-15                                    #
#-------------------------------------------------------------------------------#
# Autor               : Luis Eduardo Ramírez Castillo                           #
# Compania            : Soporte y Asesoría en Sistemas                          #
# Proyecto/Procliente : C-52-8021-16                 Fecha: 05/09/2016          #
# Modificacion        : Mejora lentitud de Reportes Productivos                 #
# Marca del Cambio    : SAS-LERC-C-52-8021-16                                   #
#-------------------------------------------------------------------------------#
# Autor               :  Daniel Ramírez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  B-54-2904-15                 Fecha: 25/08/2016         #
# Modificacion        :  Mejorar Reportería SAC2                                #
# Marca del Cambio    :  SAS-DRT B-54-2904-15                                   #
#-------------------------------------------------------------------------------#
# Autor               : Ascencion Hernandez Huerta                              #
# Compania            : Axia Consultores, S.A. de C.V.                          #
# Proyecto/Procliente : P-40-2187-15                          Fecha: 30/08/2016 #
# Descripcion General : Incorporacion Banorte a producto DCC (Fintrax)          #
# Modificacion        : Formateo e identificacion de Reportes Vss y T140 de Dcc #
# Marca del Cambio    : AXIA-AHH-P-40-2187-15                                   #
#-------------------------------------------------------------------------------#
# Autor               : Francisco Javier Cuamatzi Cuamatzi                      #
# Compania            : Axia Consultores, S.A. de C.V.                          #
# Proyecto/Procliente : P-40-2187-15                          Fecha: 13/03/2017 #
# Descripcion General : Incorporacion Banorte a producto DCC (Fintrax)          #
# Modificacion        : Correccion en el path para reporte Vss y T140 de Dcc    #
# Marca del Cambio    : AXIA-FJC-P-40-2187-15                                   #
#-------------------------------------------------------------------------------#
# Autor               : Francisco Javier Cuamatzi Cuamatzi                      #
# Compania            : Axia Consultores, S.A. de C.V.                          #
# Proyecto/Procliente : P-60-2126-16                          Fecha: 31/07/2017 #
# Descripcion General : Incorporacion de Invex al esquema de corresponsales     #
#                     : Porsa con Oxxo en operativa Offline FASE I              #
# Modificacion        :                                                         #
# Marca del Cambio    : AXIA-FJC-P-60-2126-16                                   #
#-------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
#################################################################################
*/

package com.wellcom.prosa.sacii;

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
/*--------------------------------------------------------------------------- */
/* Marca del Cambio: AXIA-GGB-P-53-2933-14 Inicia  la Modificacion 25/05/2015 */
/*----------------------------------------------------------------------------*/
import com.wellcom.prosa.sacii.rlq.*;
/*--------------------------------------------------------------------------- */
/* Marca del Cambio: AXIA-GGB-P-53-2933-14 Termina la Modificacion 25/05/2015 */
/*----------------------------------------------------------------------------*/
/* Marca del Cambio : SAS-JAGG-Z-02-2675-12 Inicia la Modificacion     13/02/2013  */
import com.wellcom.prosa.sacii.mnto.DaoMntoDistribuidor;
import com.wellcom.prosa.sacii.mnto.DaoMntoTelefonica;
/* Marca del Cambio : SAS-JAGG-Z-02-2675-12 finaliza la Modificacion   13/02/2013  */


// GSOF-MVR-C-08-2129-12 Marca de Inicio
import com.wellcom.struts.*;
import com.wellcom.beans.*;
import com.wellcom.dao.*;
import java.util.*;
import java.text.*;
import java.awt.*;
import java.sql.*;
import java.math.BigInteger;
// GSOF-MVR-C-08-2129-12 Marca de Terminacion
// GSOF-MVR-B-54-2092-15 Marca de Inicio
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
// GSOF-MVR-B-54-2092-15 Marca de Terminacion
// GSOF-MVR-P-53-2727-14 Marca de Inicio
import javax.imageio.ImageIO;
// GSOF-MVR-P-53-2727-14 Marca de Terminacion
// SAS-DRT-P-53-2004-15 Marca de Inicio
import com.wellcom.prosa.sacii.RptUtils;
// SAS-DRT-P-53-2004-15 Marca de Fin
/**
 *
 * @author afibarra
 * @version
 */

public class ControllerServlet extends HttpServlet {
    /**
     * Fields
     */
    private Database db,dbSICB2;
    private SessionConnection sc;
    private Connection con;
    private String connectionType,
        driver,
        dbURL,
        userName,
        password,
        dataSourceName,
    dbURLSICB2,
    userNameSICB2,
    passwordSICB2,
    dataSourceNameSICB2;
    private HttpSession session;
    private String sessionId, oldSessionId;
    /**************************************************************************/

    /**
     * List of Tables
     */
    private String PRSA_ENTIDADES;
    private String VW_BUS_ACQ;
    private String VW_BUS_EMI;
    private String SZ_TC_GRP;
    private String PRSA_TIPOS_TRANSACCION;
    private String PRSA_CIFRAS_CTRL;
    private String PRSA_BITACORA_ARCHIVOS;
    private String PRSA_ARCHIVOS;
    private String PRSA_SETL_IND;
    private String PRSA_RPT_IND;
    private String PRSA_DBL_FIID;
    private String CD_TXN_CD;
    ViewerManager viewerManager;
    String rutaContext="";
    String particiones;
    ComboBox listaparticiones;
    // GSOF-MVR-B-54-2092-15 Marca de Inicio
    Logger logger = null;
    // GSOF-MVR-B-54-2092-15 Marca de Terminacion


    /**************************************************************************/
    /*************************************************************************/
    /**
     * Parameters
     */
    String baseURL;
/*--------------------------------------------------------------------------- */
/* Marca del Cambio: AXIA-GGB-P-53-2933-14 Inicia  la Modificacion 25/05/2015 */
/*--------------------------------------------------------------------------- */
    SacIIRequest proc;
/*----------------------------------------------------------------------------*/
/* Marca del Cambio: AXIA-GGB-P-53-2933-14 Termina la Modificacion 25/05/2015 */
/*----------------------------------------------------------------------------*/
    private void prepareDBObject() {

        try {
            this.db = new Database();
            this.db.setConnectionType(this.connectionType);
            this.db.setDriver(this.driver);
            this.db.setUrl(this.dbURL);
            this.db.setUserName(this.userName);
            this.db.setPassword(this.password);
            this.db.setDataSourceName(this.dataSourceName);
            this.db.doConnection();
            this.con = this.db.getConnection();
            this.session.setAttribute(this.sessionId + "db", this.db);
            this.sc = new SessionConnection(this.con);
            this.session.setAttribute(this.sessionId + "sc", this.sc);

            this.dbSICB2 = new Database();
            this.dbSICB2.setConnectionType(this.connectionType);
            this.dbSICB2.setDriver(this.driver);
            this.dbSICB2.setUrl(this.dbURLSICB2);
            this.dbSICB2.setUserName(this.userNameSICB2);
            this.dbSICB2.setPassword(this.passwordSICB2);
            this.dbSICB2.setDataSourceName(this.dataSourceNameSICB2);
            this.dbSICB2.doConnection();
            this.con = this.dbSICB2.getConnection();
            this.session.setAttribute(this.sessionId + "dbSICB2", this.dbSICB2);
            this.sc = new SessionConnection(this.con);
            this.session.setAttribute(this.sessionId + "scSICB2", this.sc);

        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
    }

    private void verifySessionConnection(HttpServletRequest request) {

        //Se verifica si ya existe un Id de Sesion previo
        this.oldSessionId = (String)session.getAttribute(this.sessionId + "os");
        if(this.oldSessionId == null) {
            oldSessionId = "";
        }

        if(!oldSessionId.equalsIgnoreCase(this.sessionId)) {

            System.out.println(
                "New connection: " + request.getHeader("user-agent"));

            try {

                this.session.setAttribute(this.sessionId + "os",
                    this.sessionId);
                this.prepareDBObject();

            } catch(Exception ex) {
                System.out.println(ex.toString());
            }
        } else {

            System.out.println("Getting Pool connection: " +
                request.getHeader("user-agent"));

            this.sc =
                (SessionConnection)this.session.getAttribute(this.sessionId + "sc");

            this.con = this.sc.getConnection();
            if(this.con == null) {
                try {
                    System.out.println("Conexion = null");
                    this.prepareDBObject();
                } catch(Exception ex) {
                    System.out.println(ex.toString());
                }
            }
        }
    }

/********** Inicio Modificacion WELLCOM N-08-2253-12  **********/
    public void fechas(HttpSession session)
    {
        String FechaXml = "";
        String NoFechaXml = "";
        String ruta = (String)session.getAttribute( "rutaContext" );
        String Fiid = (String)session.getAttribute( "numFiid" );
        try{
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(new FileInputStream(ruta+"/xmls/LiberacionBancos.xml"));
        Element raiz = doc.getRootElement();
        List<Element> hijosRaiz = raiz.getChildren();
        for(Element hijo: hijosRaiz){
           if(hijo.getAttributeValue("Fiid").equals(Fiid) ){
              FechaXml = hijo.getAttributeValue("Fecha");
           }
           else {
               NoFechaXml = "01/01/2000";
               }
        }
        }catch(Exception e){e.printStackTrace();}
        if (FechaXml=="")
        {
            session.setAttribute( "fechaXML", NoFechaXml);
        }
        else
        {
            session.setAttribute( "fechaXML", FechaXml);
    }
    }
/********** Fin    Modificacion WELLCOM N-08-2253-12  **********/

    public void Oparticion(String fechaA)
    {

        ArrayList fechas0;
        String SQL0 = "";

        try
        {

            SQL0="SELECT PMADMIN.FN_PARTITION_ID(TO_DATE('"+fechaA+"','DD/MM/YYYY')) FROM DUAL ";

            db.setQuerySelect(SQL0);
            db.executeQuerySelect();
            fechas0=db.getRSColsData();
            db.closeResultSet();

            String[] suparticion =(String[]) fechas0.get(0);
            session.setAttribute( "suparticion", suparticion[0]);
            System.out.println(suparticion+"::");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void Oparticiones(String fechaA, String fechaB)
    {

        ArrayList fechas;
        String SQL = "";

        try
        {
            //SQL=" SELECT TO_CHAR(TO_DATE('"+fechaA+"','DD/MM/YYYY'),'YY')||TO_CHAR(TO_DATE('"+fechaA+"','DD/MM/YYYY'),'DDD')||' AND '||TO_CHAR(TO_DATE('"+fechaB+"','DD/MM/YYYY'),'YY')||TO_CHAR(TO_DATE('"+fechaB+"','DD/MM/YYYY'),'DDD') FROM DUAL ";
            SQL = "SELECT PMADMIN.FN_PARTITION_ID(TO_DATE('"+fechaA+"','DD/MM/YYYY'))||' AND '||PMADMIN.FN_PARTITION_ID(TO_DATE('"+fechaB+"','DD/MM/YYYY')) FROM DUAL";

            db.setQuerySelect(SQL);
            db.executeQuerySelect();
            fechas=db.getRSColsData();
            db.closeResultSet();

            String[] susparticiones =(String[]) fechas.get(0);
            session.setAttribute( "susparticiones", susparticiones[0]);
            System.out.println(susparticiones+"::");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void Oparticioneshabant(String fechaA, String fechaB, String fechaC, String fechaD)
    {

        ArrayList fechas;
        ArrayList fechas2;
        String SQL = "";
        String SQL2 = "";

        try
        {

            SQL="SELECT PMADMIN.FN_PARTITION_ID(TO_DATE('"+fechaA+"','DD/MM/YYYY'))||' AND '||PMADMIN.FN_PARTITION_ID(TO_DATE('"+fechaB+"','DD/MM/YYYY')) FROM DUAL";
            SQL2="SELECT PMADMIN.FN_PARTITION_ID(TO_DATE('"+fechaC+"','DD/MM/YYYY'))||' AND '||PMADMIN.FN_PARTITION_ID(TO_DATE('"+fechaD+"','DD/MM/YYYY')) FROM DUAL";

            db.setQuerySelect(SQL);
            db.executeQuerySelect();
            fechas=db.getRSColsData();
            db.closeResultSet();

            db.setQuerySelect(SQL2);
            db.executeQuerySelect();
            fechas2=db.getRSColsData();
            db.closeResultSet();

            String[] susparticiones =(String[]) fechas.get(0);
            String[] susparticioneshabant =(String[]) fechas2.get(0);

            session.setAttribute( "susparticiones", susparticiones[0]);
            session.setAttribute( "susparticionesHabAnt", susparticioneshabant[0]);

            System.out.println(susparticiones+"::");
            System.out.println(susparticioneshabant+"::");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void Oparticionesdiaant(String fechaA, String fechaB, String fechaC, String fechaD)
    {

        ArrayList fechas;
        ArrayList fechas2;
        String SQL = "";
        String SQL2 = "";

        try
        {

            SQL="SELECT PMADMIN.FN_PARTITION_ID(TO_DATE('"+fechaA+"','DD/MM/YYYY'))||' AND '||PMADMIN.FN_PARTITION_ID(TO_DATE('"+fechaB+"','DD/MM/YYYY')) FROM DUAL";
            SQL2="SELECT PMADMIN.FN_PARTITION_ID(TO_DATE('"+fechaA+"','DD/MM/YYYY')-1)||' AND '||PMADMIN.FN_PARTITION_ID(TO_DATE('"+fechaB+"','DD/MM/YYYY')-1) FROM DUAL";

            db.setQuerySelect(SQL);
            db.executeQuerySelect();
            fechas=db.getRSColsData();
            db.closeResultSet();

            db.setQuerySelect(SQL2);
            db.executeQuerySelect();
            fechas2=db.getRSColsData();
            db.closeResultSet();

            String[] susparticiones =(String[]) fechas.get(0);
            String[] susparticioneshabant =(String[]) fechas2.get(0);

            session.setAttribute( "susparticiones", susparticiones[0]);
            session.setAttribute( "susparticionesdiaant", susparticioneshabant[0]);

            System.out.println(susparticiones+"::");
            System.out.println(susparticioneshabant+"::");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void init(ServletConfig config) throws ServletException {

        super.init(config);

        /**
         * Database Object Parameters
         */
        this.connectionType = config.getInitParameter("jdbcConnectionType");
        this.driver = config.getInitParameter("jdbcDriver");
        this.dbURL = config.getInitParameter("jdbcUrl");
        this.userName = config.getInitParameter("jdbcUserName");
        this.password = config.getInitParameter("jdbcPassword");
        this.dataSourceName = config.getInitParameter("dataSourceName");

        this.dbURLSICB2 = config.getInitParameter("jdbcUrlSICB2");
        this.userNameSICB2 = config.getInitParameter("jdbcUserNameSICB2");
        this.passwordSICB2 = config.getInitParameter("jdbcPasswordSICB2");
        this.dataSourceNameSICB2 = config.getInitParameter("dataSourceNameSICB2");
        /**********************************************************************/

        /**
         * Tables
         */
        this.PRSA_ENTIDADES = config.getInitParameter("PRSA_ENTIDADES");
        this.VW_BUS_ACQ = config.getInitParameter("VW_BUS_ACQ");
        this.VW_BUS_EMI = config.getInitParameter("VW_BUS_EMI");
        this.SZ_TC_GRP = config.getInitParameter("SZ_TC_GRP");
        this.PRSA_TIPOS_TRANSACCION = config.getInitParameter("PRSA_TIPOS_TRANSACCION");
        this.PRSA_CIFRAS_CTRL = config.getInitParameter("PRSA_CIFRAS_CTRL");
        this.PRSA_BITACORA_ARCHIVOS = config.getInitParameter("PRSA_BITACORA_ARCHIVOS");
        this.PRSA_ARCHIVOS = config.getInitParameter("PRSA_ARCHIVOS");
        this.PRSA_SETL_IND = config.getInitParameter("PRSA_SETL_IND");
        this.PRSA_RPT_IND = config.getInitParameter("PRSA_RPT_IND");
        this.PRSA_DBL_FIID = config.getInitParameter("PRSA_DBL_FIID");
        this.CD_TXN_CD=config.getInitParameter("CD_TXN_CD");
        /**********************************************************************/
        /**********************************************************************/
        /**
         * parametros
         */
        this.baseURL=config.getInitParameter("baseURL");
    }

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws WellException
     * @throws JDOMException
     * @throws ParseException
     */




    @SuppressWarnings("unchecked")
    protected void processRequestContinua(HttpServletRequest request, HttpServletResponse response,ParametrosCompartidos pC)
    throws ServletException, IOException, WellException, JDOMException, ParseException {
        String action ;
        String parameter;
//        String url ;
        Validador value;
        //fiidManager  inicia = new fiidManager();
//        boolean isAnswerReport;
        String diaHabAnt7;
        String diaHabAnt7Historico;
        SimpleDateFormat formato1= new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formato2= new SimpleDateFormat("MM/dd/yyyy");
        String fechaHoy;
/* Inicia modificacion Wellcom N-04-2207-13 14-10-2014*/
            String horaHoy;
/* Fin    modificacion Wellcom N-04-2207-13 14-10-2014*/
        Date fechaAnterior = new Date();

        /**
         * Action Management
         */
        SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");

        Date fechaActual = new Date();
        long fechaAntes = fechaAnterior.getTime() - 8*(24*60*60*1000);
        long fechaAntesHistorico = fechaAnterior.getTime() - 1*(24*60*60*1000);

/* Inicia modificacion Wellcom N-04-2207-13 14-10-2014*/
        SimpleDateFormat formatoHora= new SimpleDateFormat("HH:mm:ss");
        horaHoy = formatoHora.format(fechaActual);
        session.setAttribute( "horaHoy", horaHoy);
/* Fin    modificacion Wellcom N-04-2207-13 14-10-2014*/

        diaHabAnt7 = formato.format(fechaAntes);
        diaHabAnt7Historico = formato.format(fechaAntesHistorico);
        action = request.getParameter("action");
        parameter = null;
        String url = pC.getUrl();
        value = new Validador();
        //fiidManager  inicia = new fiidManager();
        boolean isAnswerReport=pC.getIsAnswerReport();


        if(action.equals("delModSacii"))
        {
            String rbtn=request.getParameter("rbtn");
            url = "/delModSacii.jsp?rbtn="+rbtn+"&btnDelModGrpSacii=Liberar";
        }
        // GSOF-MVR-C-08-2129-12 Marca de Inicio
        // MODULO DE CONSULTAS
        else if(action.equals("ConsultaLACPI"))
        {
            Collection listado          = new ArrayList();
            String accion               = "";
            String cuenta               = "";
            String afiliacion           = "";
            String feIni                = "";
            String feFin                = "";
            AltasDAO modelo             = new AltasDAO();
            url = "/Consulta.jsp";
            String validacion           = "";
            String validacion2          = "";

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

            if(accion == null){
                accion = "";
            }

            // LA ACCION ES BLANCO, INICIALIZA
            if("".compareTo(accion) == 0){
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
            }
            // LA ACCION ES 0, CANCELAR
            else if("0".compareTo(accion) == 0){
                // LA SIGUIENTE PANTALLA ES BLANCO
                url = "/index.jsp";
            }
            else
            {
                // OBTIENE LA FECHA DEFAULT DE INICIO Y FIN
                // FIN ES LA FECHA ACTUAL, INICIO ES UN MES ATRAS
                fechaFin = new java.sql.Date((currenttime.getTime()).getTime());
                currenttime.add(Calendar.MONTH, -3);
                fechaIni = new java.sql.Date((currenttime.getTime()).getTime());

                // OBTIENE LOS CRITERIOS ELEGIDOS
                cuenta          = request.getParameter("cuenta");
                afiliacion      = request.getParameter("afiliacion");
                feIni           = request.getParameter("fechaInicio");
                feFin           = request.getParameter("fechaFinal");

                // PONE LOS VALORES DEFAULT, SI ESTAN EN BLANCO
                if("".compareTo(feIni) == 0){
                    feIni = formatoFecha.format(fechaIni);
                }

                if("".compareTo(feFin) == 0){
                    feFin = formatoFecha.format(fechaFin);
                }

                validacion = validaCuentaSin(cuenta);
                validacion2 = validaAfiliacion(afiliacion);
                if(validacion.length() == 0 && validacion2.length() == 0){
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
                }else{
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
        }

//Soporte interactivo
//Marca inicio: P-54-2940-14 AMEstudio 23.04.2015
        else if(action.equals("aggsoporte"))
        {
            url = "/aggsoporte.jsp?btnaggsoporte=Agregar";
        }

         else if(action.equals("detallesoporte"))
        {
            String rbtn=request.getParameter("rbtn");
            url = "/detallesoporte.jsp?rbtn="+rbtn+"&btndetallesoporte=Consultar";
        }

         else if(action.equals("descargarsoporte"))
        {
            String rbtn=request.getParameter("rbtn");
            url = "/descargarsoporte.jsp?rbtn="+rbtn+"&btndescargar=Descargar";
        }

         else if(action.equals("editarsoporte"))
            {
                String rbtn=request.getParameter("rbtn");
                url = "/editarsoporte.jsp?rbtn="+rbtn+"&btneditar=Editar";
            }
         else if(action.equals("eliminarsoporte"))
            {
                String rbtn=request.getParameter("rbtn");
                url = "/eliminarsoporte.jsp?rbtn="+rbtn+"&btneliminarsoporte=OK";
            }
//Marca fin: P-54-2940-14 AMEstudio 23.04.2015

        // MODULO DE ALTAS
        else if(action.equals("AltasLACPI"))
        {
            Collection listado      = new ArrayList();
            String accion           = "";
            AltasDAO modelo         = new AltasDAO();
            String[] claves         = null;
            Collection listado2     = new ArrayList();
            Collection listado3     = new ArrayList();
            String cuenta           = "";
            String afiliacion       = "";
            String feIni            = "";
            String feFin            = "";

            // CREA LA FORMA
            AltasForm altasForm   = new AltasForm();
            accion                = request.getParameter("accion");

            if(accion == null){
                accion = "";
            }

            // LA ACCION INICIAL ES LISTADO
            if(("".compareTo(accion) == 0) || ("1".compareTo(accion) == 0)){
                // OBTIENE EL LISTADO DE LA BD
                listado = modelo.listarAfiliaciones();
                listado3 = modelo.listarCuentas();

                // PONE LOS VALORES INICIALES
                altasForm.setAccion(       "1");
                altasForm.setListado(      listado);
                altasForm.setNumListado(   String.valueOf(listado.size()));
                altasForm.setListado3(     listado3);
                altasForm.setNumListado3(  String.valueOf(listado3.size()));
                url = "/Altas.jsp";
                session.setAttribute("datos", altasForm);
            }
            // LA ACCION ES 0, CANCELAR
            else if("0".compareTo(accion) == 0){
                // LA SIGUIENTE PANTALLA ES BLANCO
                url = "/index.jsp";
            }
            // LA ACCION ES 2, CREAR AFILIACION
            else if("2".compareTo(accion) == 0){
                // PONE LA ACCION EN LA SESION
                AfiliacionForm afiliacionForm = new AfiliacionForm();
                afiliacionForm.setAfiliacion("");
                afiliacionForm.setAccion("2");
                url = "/Afiliacion.jsp";
                session.setAttribute("datos", afiliacionForm);
            }
            // LA ACCION ES 4, BORRAR AFILIACION
            else if("4".compareTo(accion) == 0){
                // OBTIENE LA TERMINAL A BORRAR
                claves = request.getParameterValues("idafiliacion");

                // PROCESA LA LISTA DE REGISTROS
                if (claves == null){
                    altasForm.setError("Debe elegir un registro para eliminar");
                } else {
                    // PROCESA LA LISTA A BORRAR
                    for(int i =0; i < claves.length; i++){
                        // ELIMINA EL PREFIJO
                        modelo.borrarAfiliacion(claves[i]);
                    }
                }

                // OBTIENE EL LISTADO DE LA BD
                listado = modelo.listarAfiliaciones();
                listado3 = modelo.listarCuentas();

                // PONE LOS VALORES INICIALES
                altasForm.setAccion(       "1");
                altasForm.setListado(      listado);
                altasForm.setNumListado(   String.valueOf(listado.size()));
                altasForm.setListado3(     listado3);
                altasForm.setNumListado3(  String.valueOf(listado3.size()));
                url = "/Altas.jsp";
                session.setAttribute("datos", altasForm);
            }
            // LA ACCION ES 6, CREAR CUENTA
            else if("6".compareTo(accion) == 0){
                // PONE LA ACCION EN LA SESION
                CuentaForm cuentaForm = new CuentaForm();
                cuentaForm.setCuenta("");
                cuentaForm.setAccion("6");
                url = "/Cuenta.jsp";
                session.setAttribute("datos", cuentaForm);
            }
            // LA ACCION ES 8, BORRAR CUENTA
            else if("8".compareTo(accion) == 0){
                // OBTIENE LA TERMINAL A BORRAR
                claves = request.getParameterValues("idcuenta");

                // PROCESA LA LISTA DE REGISTROS
                if (claves == null){
                    altasForm.setError("Debe elegir un registro para eliminar");
                } else {
                    // PROCESA LA LISTA A BORRAR
                    for(int i =0; i < claves.length; i++){
                        // ELIMINA EL PREFIJO
                        modelo.borrarCuenta(claves[i]);
                    }
                }

                // OBTIENE EL LISTADO DE LA BD
                listado = modelo.listarAfiliaciones();
                listado3 = modelo.listarCuentas();

                // PONE LOS VALORES INICIALES
                altasForm.setAccion(       "1");
                altasForm.setListado(      listado);
                altasForm.setNumListado(   String.valueOf(listado.size()));
                altasForm.setListado3(     listado3);
                altasForm.setNumListado3(  String.valueOf(listado3.size()));
                url = "/Altas.jsp";
                session.setAttribute("datos", altasForm);
            }
        }
        // MODULO DE AFILIACION
        else if(action.equals("AfiliacionLACPI"))
        {
            String accion               = "";
            AltasDAO modelo             = new AltasDAO();
            AfiliacionObj datos         = new AfiliacionObj();
            String clave                = request.getParameter("afiliacion");
            String validacion           = "";

            accion = request.getParameter("accion");
            if(accion == null){
                accion = "";
            }

            // SI LA ACCION ES CREAR
            if(accion.compareTo("2") == 0){
                validacion = validaAfiliacion(clave);

                // SI LA VALIDACION ES CORRECTA
                if(validacion.length() == 0){
                    // CREA EL OBJETO CON LOS VALORES EN PANTALLA Y LO INSERTA
                    datos.setAfiliacion(    clave);
                    modelo.crearAfiliacion(datos);

                    url = "/Altas.jsp";
                    Collection listado      = new ArrayList();
                    Collection listado3     = new ArrayList();

                    // CREA LA FORMA
                    AltasForm altasForm   = new AltasForm();

                    // OBTIENE EL LISTADO DE LA BD
                    listado = modelo.listarAfiliaciones();
                    listado3 = modelo.listarCuentas();

                    // PONE LOS VALORES INICIALES
                    altasForm.setAccion(       "1");
                    altasForm.setListado(      listado);
                    altasForm.setNumListado(   String.valueOf(listado.size()));
                    altasForm.setListado3(     listado3);
                    altasForm.setNumListado3(  String.valueOf(listado3.size()));
                    session.setAttribute("datos", altasForm);
                }else{
                    AfiliacionForm afiliacionForm = new AfiliacionForm();
                    afiliacionForm.setAfiliacion(clave);
                    afiliacionForm.setError(validacion);
                    afiliacionForm.setAccion("2");
                    url = "/Afiliacion.jsp";
                    session.setAttribute("datos", afiliacionForm);
                }
            }else{
                url = "/index.jsp";
            }
        }
        // MODULO DE CUENTA
        else if(action.equals("CuentaLACPI"))
        {
            String accion               = "";
            AltasDAO modelo             = new AltasDAO();
            CuentaObj datos             = new CuentaObj();
            String clave                = request.getParameter("cuenta");
            String validacion           = "";

            accion = request.getParameter("accion");
            if(accion == null){
                accion = "";
            }

            // SI LA ACCION ES CREAR
            if(accion.compareTo("6") == 0){
                validacion = validaCuenta(clave);

                // SI LA VALIDACION ES CORRECTA
                if(validacion.length() == 0){
                    // CREA EL OBJETO CON LOS VALORES EN PANTALLA Y LO INSERTA
                    datos.setCuenta(    clave);
                    modelo.crearCuenta(datos);

                    url = "/Altas.jsp";
                    Collection listado      = new ArrayList();
                    Collection listado3     = new ArrayList();

                    // CREA LA FORMA
                    AltasForm altasForm   = new AltasForm();

                    // OBTIENE EL LISTADO DE LA BD
                    listado = modelo.listarAfiliaciones();
                    listado3 = modelo.listarCuentas();

                    // PONE LOS VALORES INICIALES
                    altasForm.setAccion(       "1");
                    altasForm.setListado(      listado);
                    altasForm.setNumListado(   String.valueOf(listado.size()));
                    altasForm.setListado3(     listado3);
                    altasForm.setNumListado3(  String.valueOf(listado3.size()));
                    session.setAttribute("datos", altasForm);
                }else{
                    CuentaForm cuentaForm = new CuentaForm();
                    cuentaForm.setCuenta(clave);
                    cuentaForm.setError(validacion);
                    cuentaForm.setAccion("6");
                    url = "/Cuenta.jsp";
                    session.setAttribute("datos", cuentaForm);
                }
            }else{
                url = "/index.jsp";
            }
        }
        // GSOF-MVR-C-08-2129-12 Marca de Terminacion
        else if(action.equals("aggtipocambio"))
        {
            url = "/aggtipocambio.jsp?btnaggtipocambio=Agregar";
        }
        else if(action.equals("edittipocambio"))
        {
            String rbtn=request.getParameter("rbtn");
            url = "/edittipocambio.jsp?rbtn="+rbtn+"&btnedittipocambio=Editar";
        }

        /* Inica cambio C-04-3035-13 */
        else if(action.equals("editdifcuotas"))
        {
            String rbtn=request.getParameter("rbtn");
            url = "/editdifcuotas.jsp?rbtn="+rbtn+"&btneditdifcuotas=Editar";
        }
        /* Termina cambio C-04-3035-13 */


        //Reporte 0360
        else if(action.equals("SICLIR0360"))
        {
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0360Header.jsp";
        }
        else if(action.equals("SICLIR0360Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String tipoes = request.getParameter("tipoES");
            String []bancoArray = request.getParameterValues("banco");
            String banco="";
            for(String bancoFor:bancoArray){
                if(!banco.equals(""))
                    banco+=",";
                banco+=bancoFor;
            }
         String []tipoProcArray = request.getParameterValues("tipoProc");
            String tipoProc="";
            for(String tipoProcTmp:tipoProcArray){
                if(!tipoProc.equals(""))
                    tipoProc+=",";
                tipoProc+=tipoProcTmp;
            }
            String agrTotales=request.getParameter("agrTotales");
            if(agrTotales==null)
                agrTotales="false";
            else
                agrTotales="true";
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", banco);
            session.setAttribute( "tipoProc", tipoProc);
            session.setAttribute( "tipoes", tipoes);
            session.setAttribute("agrTotales", agrTotales);

            try
            {
                String initDateHabAnt = format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate)));
                String endDateHabAnt = format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate)));

                try
                {
                    if(format.parse(initDate).compareTo(format.parse(diaHabAnt7))>0)
                    {
                        Oparticionesdiaant(initDate, endDate, initDateHabAnt, endDateHabAnt);
                        url = value.valida(session, initDate, endDate, "Siclir0360");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    else
                        url = "/fechasInvalidas.jsp?noPantalla=4";
                }
                catch(Exception ex)
                {
                    throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                }
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
      //Reporte 0360H
        else if(action.equals("SICLIR0360H"))
        {
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0360HHeader.jsp";
        }
        else if(action.equals("SICLIR0360HMain"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String tipoes = request.getParameter("tipoES");
            String []bancoArray = request.getParameterValues("banco");
            String banco="";
            for(String bancoFor:bancoArray){
                if(!banco.equals(""))
                    banco+=",";
                banco+=bancoFor;
            }
         String []tipoProcArray = request.getParameterValues("tipoProc");
            String tipoProc="";
            for(String tipoProcTmp:tipoProcArray){
                if(!tipoProc.equals(""))
                    tipoProc+=",";
                tipoProc+=tipoProcTmp;
            }
            String agrTotales=request.getParameter("agrTotales");
            if(agrTotales==null)
                agrTotales="false";
            else
                agrTotales="true";
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", banco);
            session.setAttribute( "tipoProc", tipoProc);
            session.setAttribute( "tipoes", tipoes);
            session.setAttribute("agrTotales", agrTotales);

            try
            {
                String initDateHabAnt = format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate)));
                String endDateHabAnt = format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate)));

                session.setAttribute( "initDateHabAnt", initDateHabAnt);
                session.setAttribute( "endDateHabAnt", endDateHabAnt);

                try
                {
                            if(format.parse(initDate).compareTo(format.parse(diaHabAnt7Historico))<=0 && format.parse(endDate).compareTo(format.parse(diaHabAnt7Historico))<=0)
                    {
                url = value.valida(session, initDate, endDate, "Siclir0360H");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
                    }
                            else
                                url = "/fechasInvalidas.jsp?noPantalla=5";
                        }
                        catch(Exception ex)
                        {
                            throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                        }
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

        //Reporte 0450
        else if(action.equals("SICMIF0450"))
        {
            url = "/SICMIF0450Header.jsp";
        }
        else if(action.equals("SICMIF0450Main"))
        {
            SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formateo2 = new SimpleDateFormat("yyMMdd");
            String inicial = request.getParameter("txtfStartDate");
            String adq = request.getParameter("adq");
            if(adq.length()<2)
            {
                adq="0"+adq;
                //System.out.println("Variable adq es " + adq );
            }
            try
            {
            session.setAttribute( "adq", adq);
            //inicial = format.format(TimeUtils.getDiaNatAnt(session, format.parse(inicial)));
            String inicial2 = formateo2.format(formateo.parse(inicial));
            session.setAttribute( "initDate", inicial2);

            //String sFichero = "C:\\probancr\\EditPackage\\POSRE_"+inicial2+"_"+adq;
            //Ruta anteior String sFichero = "//aplic//prod//pmt//pmr//epg//POSRE_"+inicial2+"_"+adq;
            String sFichero = "//aplic//prod//pmt//pmr//pr4//POSRE_"+inicial2+"_"+adq;
            System.out.println("Variable fichero es " + sFichero );
            File fichero = new File(sFichero);

            if (fichero.exists())
            {
                System.out.println("El fichero " + sFichero + " existe");
                url = "/reportsjsp/managerReports.jsp"+"?report="+"SICMIF0450";
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            else
            {
                url = "/reportsjsp/Error.jsp";
            }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        //Reporte B450
        else if(action.equals("SICMIFB450"))
        {
            url = "/SICMIFB450Header.jsp";
        }
        else if(action.equals("SICMIFB450Main"))
        {

            SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formateo2 = new SimpleDateFormat("yyMMdd");
            String inicial = request.getParameter("txtfStartDate");
            String adq = request.getParameter("adq");
            if(adq.length()<2)
            {
                adq="0"+adq;
            }
            try
            {
            session.setAttribute( "adq", adq);
            String inicial2 = formateo2.format(formateo.parse(inicial));
            session.setAttribute( "initDate", inicial2);

            String sFichero = "C:\\probancr\\EditPackage\\POSRE_"+inicial2+"_"+adq;
            System.out.println("Variable fichero es " + sFichero );
            File fichero = new File(sFichero);

            if (fichero.exists())
            {
                System.out.println("El fichero " + sFichero + " existe");
                url = "/reportsjsp/managerReports.jsp"+"?report="+"SICMIFB450";
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            else
            {
                url = "/reportsjsp/Error.jsp";
            }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        //Reporte 0130
        else if(action.equals("SICLIR0130"))
        {
            url = "/SICLIR0130Header.jsp";
        }
        else if(action.equals("SICLIR0130Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclir0130");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte D130
        else if(action.equals("SICLIRD130"))
        {
            url = "/SICLIRD130Header.jsp";
        }
        else if(action.equals("SICLIRD130Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclird130");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        // INICIA - REPORTES INFORMATIVOS PESOS-DOLARES - CML

          //Reporte SICLIRI020
        else if(action.equals("SICLIRI020"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRI020Header.jsp";
        }
        else if(action.equals("SICLIRI020Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []bancoSocioArray = request.getParameterValues("bancoSocio");
            String bancosSocios="";
            for(String banco:bancoSocioArray){
                if(!bancosSocios.equals(""))
                    bancosSocios+=",";
                bancosSocios+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoSocio", bancosSocios);
            try
            {
                url = value.valida(session, initDate, endDate, "Sicliri020");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte SICLIRI030
        else if(action.equals("SICLIRI030"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRI030Header.jsp";
        }
        else if(action.equals("SICLIRI030Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");

            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);

            try
            {
                url = value.valida(session, initDate, endDate, "Sicliri030");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte SICLIRI040
            else if(action.equals("SICLIRI040"))
            {
                session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                url = "/SICLIRI040Header.jsp";
            }
            else if(action.equals("SICLIRI040Main"))
            {
                String initDate = request.getParameter("txtfStartDate");
                String endDate = request.getParameter("txtfEndDate");

                session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                session.setAttribute("txtfStartDate", initDate);
                session.setAttribute("txtfEndDate", endDate);

                try
                {
                    Oparticionesdiaant(initDate, endDate, initDate, endDate);
                    url = value.valida(session, initDate, endDate, "Sicliri040");
                    viewerManager.setUpViewer(this, request, response, url);
                    isAnswerReport=true;
                }
                    catch (WellException e)
                {
                    e.printStackTrace();
                }
        }

        //Reporte SICLIRI050
        else if(action.equals("SICLIRI050"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRI050Header.jsp";
        }
        else if(action.equals("SICLIRI050Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String agrupacion=request.getParameter("agrupacion");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);
            session.setAttribute("agrupacion",agrupacion);
            try
            {
                session.setAttribute("txtfStartDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("txtfEndDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                url = value.valida(session, initDate, endDate, "Sicliri050");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(ParseException pe){
                pe.printStackTrace();
            }
        }

        //Reporte SICLIRI060
        else if(action.equals("SICLIRI060"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRI060Header.jsp";
        }
        else if(action.equals("SICLIRI060Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);

            try
            {
                session.setAttribute("txtfStartDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("txtfEndDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                url = value.valida(session, initDate, endDate, "Sicliri060");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(ParseException pe){
                pe.printStackTrace();
            }
        }


        //Reporte SICLILRI077
        else if(action.equals("SICLIRI077"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRI077Header.jsp";
        }
        else if(action.equals("SICLIRI077Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String natCont = request.getParameter("natCont");

            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "natCont", natCont);

            try
            {
                url = value.valida(session, initDate, endDate, "Sicliri077");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }


        //Reporte SICLIRI087
        else if(action.equals("SICLIRI087"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRI087Header.jsp";
        }
        else if(action.equals("SICLIRI087Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String natCont = request.getParameter("natCont");

            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "natCont", natCont);

            try
            {
                session.setAttribute("txtfStartDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("txtfEndDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                url = value.valida(session, initDate, endDate, "Sicliri087");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(ParseException pe){
                pe.printStackTrace();
            }
        }

            //Reporte SICLIRI110
        else if(action.equals("SICLIRI110"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRI110Header.jsp";
        }
        else if(action.equals("SICLIRI110Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []bancoEmiArray = request.getParameterValues("bancoEmi");
            String bancosEmi="";
            for(String banco:bancoEmiArray){
                if(!bancosEmi.equals(""))
                    bancosEmi+=",";
                bancosEmi+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoEmi", bancosEmi);
            try
            {
                url = value.valida(session, initDate, endDate, "Sicliri110");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte SICLIRI120
        else if(action.equals("SICLIRI120"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRI120Header.jsp";
        }
        else if(action.equals("SICLIRI120Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []interredes = request.getParameterValues("interred");
            String []divisiones = request.getParameterValues("division");
            String interredesStr="";
            for(String interred:interredes){
                if(!interredesStr.equals(""))
                    interredesStr+=",";
                interredesStr+=interred;
            }
            String divisionesStr="";
            for(String division:divisiones){
                if(!divisionesStr.equals(""))
                    divisionesStr+=",";
                divisionesStr+=division;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "interred", interredesStr);
            session.setAttribute( "division", divisionesStr);
            try
            {
                url = value.valida(session, initDate, endDate, "Sicliri120");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte SICLIRI130
        else if(action.equals("SICLIRI130"))
        {
            url = "/SICLIRI130Header.jsp";
        }
        else if(action.equals("SICLIRI130Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            try
            {
                url = value.valida(session, initDate, endDate, "Sicliri130");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

            //Reporte SICLIRI140
        else if(action.equals("SICLIRI140"))
        {
            url = "/SICLIRI140Header.jsp";
        }
        else if(action.equals("SICLIRI140Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            try
            {
                url = value.valida(session, initDate, endDate, "Sicliri140");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
        //Reporte SICLIRI150
        else if(action.equals("SICLIRI150"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRI150Header.jsp";
        }
        else if(action.equals("SICLIRI150Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String bancoEmi = request.getParameter("bancoEmi");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("banco", bancosStr);
            try
            {
                url = value.valida(session, initDate, endDate, "Sicliri150");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
        //Reporte SICLIRI200
        else if(action.equals("SICLIRI200"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRI200Header.jsp";
        }
        else if(action.equals("SICLIRI200Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
           String []bancosAdq = request.getParameterValues("bancoAdquiriente");
           String bancosAdqStr="";
        for(String bancoAdqr:bancosAdq){
            if(!bancosAdqStr.equals(""))
                bancosAdqStr+=",";
            bancosAdqStr+=bancoAdqr;
        }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "bancoAdquiriente", bancosAdqStr);

            try
            {
                session.setAttribute("txtfStartDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("txtfEndDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                url = value.valida(session, initDate, endDate, "Sicliri200");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(ParseException pe){
                pe.printStackTrace();
            }
        }

        //Reporte SICLIRI360
        else if(action.equals("SICLIRI360"))
        {
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRI360Header.jsp";
        }
        else if(action.equals("SICLIRI360Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String tipoes = request.getParameter("tipoES");
            String []bancoArray = request.getParameterValues("banco");
            String banco="";
            for(String bancoFor:bancoArray){
                if(!banco.equals(""))
                    banco+=",";
                banco+=bancoFor;
            }
         String []tipoProcArray = request.getParameterValues("tipoProc");
            String tipoProc="";
            for(String tipoProcTmp:tipoProcArray){
                if(!tipoProc.equals(""))
                    tipoProc+=",";
                tipoProc+=tipoProcTmp;
            }
            String agrTotales=request.getParameter("agrTotales");
            if(agrTotales==null)
                agrTotales="false";
            else
                agrTotales="true";
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", banco);
            session.setAttribute( "tipoProc", tipoProc);
            session.setAttribute( "tipoes", tipoes);
            session.setAttribute("agrTotales", agrTotales);

            try
            {
                String initDateHabAnt = format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate)));
                String endDateHabAnt = format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate)));

                try
                {
                    if(format.parse(initDate).compareTo(format.parse(diaHabAnt7))>0)
                    {
                        Oparticioneshabant(initDate, endDate, initDateHabAnt, endDateHabAnt);
                        url = value.valida(session, initDate, endDate, "Sicliri360");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    else
                        url = "/fechasInvalidas.jsp?noPantalla=4";
                }
                catch(Exception ex)
                {
                    throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                }
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

        //Reporte SICLIFI060
        else if(action.equals("SICLIFI060"))
        {

            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIFI060Header.jsp";
        }
        else if(action.equals("SICLIFI060Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String banco = request.getParameter("banco");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);

            try
            {
                SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                session.setAttribute("initDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("endDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                Oparticionesdiaant(initDate, endDate, initDate, endDate);
                url = value.valida(session, initDate, endDate, "Siclifi060");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        //Reporte SICLIFI065
        else if(action.equals("SICLIFI065"))
        {

            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIFI065Header.jsp";
        }
        else if(action.equals("SICLIFI065Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String banco = request.getParameter("banco");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);

            try
            {
                SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                session.setAttribute("initDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("endDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                Oparticionesdiaant(initDate, endDate, initDate, endDate);
                url = value.valida(session, initDate, endDate, "Siclifi065");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        //Reporte SICMORI360
        else if(action.equals("SICMORI360"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            session.setAttribute( "PRSA_TIPOS_TRANSACCION", this.PRSA_TIPOS_TRANSACCION );
            url = "/SICMORI360Header.jsp";
        }
        else if(action.equals("SICMORI360Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String diaHabAnt = (String)session.getAttribute("diaHabAnt");

        String []bancoAdqArray = request.getParameterValues("bancoAdq");
        String bancoAdq="";
        for(String banco:bancoAdqArray){
            if(!bancoAdq.equals(""))
                bancoAdq+=",";
            bancoAdq+=banco;
        }
      String []bancoEmiArray = request.getParameterValues("bancoEmi");
        String bancoEmi="";
        for(String banco:bancoEmiArray){
            if(!bancoEmi.equals(""))
                bancoEmi+=",";
            bancoEmi+=banco;
        }
       String []tipoTransArray = request.getParameterValues("tipoTrans");
        String tipoTrans="";
        for(String tipo:tipoTransArray){
            if(!tipoTrans.equals(""))
                tipoTrans+=",";
            tipoTrans+=tipo;
        }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "bancoAdq", bancoAdq);
            session.setAttribute( "bancoEmi", bancoEmi);
            session.setAttribute( "tipoTrans", tipoTrans);
            try
            {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                try
                {
                    if(format.parse(initDate).compareTo(format.parse(diaHabAnt7))>0)
                    {
                        Oparticiones(initDate, endDate);
                        url = value.valida(session, initDate, endDate, "Sicmori360");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    else
                        url = "/fechasInvalidas.jsp?noPantalla=4";
                }
                catch(Exception ex)
                {
                    throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                }
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
        // TERMINA - REPORTES INFORMATIVOS PESOS-DOLARES - CML

        //Reporte 0205
        else if(action.equals("SICMOR0205"))
        {
            /********** Inicio Modificacion WELLCOM N-08-2253-12  **********/
            fechas(session);
            if(request.getParameter("mostrarTabla")!=null){
                session.setAttribute("mostrarTabla","true");
            }else
                session.setAttribute("mostrarTabla","false");
            /********** Fin    Modificacion WELLCOM N-08-2253-12  **********/

            url = "/SICMOR0205Header.jsp";
        }
        else if(action.equals("SICMOR0205Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String diaHabAnt = (String)session.getAttribute("diaHabAnt");

            String cuenta=request.getParameter("cuenta").equals("")?"null":request.getParameter("cuenta");
            String comercio=request.getParameter("comercio").equals("")?"null":request.getParameter("comercio");
            String referencia=request.getParameter("referencia").equals("")?"null":request.getParameter("referencia");
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("cuenta", cuenta);
            session.setAttribute("comercio", comercio);
            session.setAttribute("referencia", referencia);

            try
            {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                try
                {
                    if(format.parse(initDate).compareTo(format.parse(diaHabAnt7))>0)
                    {
                        Oparticiones(initDate, endDate);
                        url = value.valida(session, initDate, endDate, "Sicmor0205");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    else
                        url = "/fechasInvalidas.jsp?noPantalla=4";
                }
                catch(Exception ex)
                {
                    throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                }
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte 0205H
        else if(action.equals("SICMOR0205H"))
        {
            /********** Inicio Modificacion WELLCOM N-08-2253-12  **********/
            fechas(session);
            if(request.getParameter("mostrarTabla")!=null){
                session.setAttribute("mostrarTabla","true");
            }else
                session.setAttribute("mostrarTabla","false");
            /********** Fin    Modificacion WELLCOM N-08-2253-12  **********/
            url = "/SICMOR0205HHeader.jsp";
        }
        else if(action.equals("SICMOR0205HMain"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String diaHabAnt = (String)session.getAttribute("diaHabAnt");

            String cuenta=request.getParameter("cuenta").equals("")?"null":request.getParameter("cuenta");
            String comercio=request.getParameter("comercio").equals("")?"null":request.getParameter("comercio");
            String referencia=request.getParameter("referencia").equals("")?"null":request.getParameter("referencia");
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("cuenta", cuenta);
            session.setAttribute("comercio", comercio);
            session.setAttribute("referencia", referencia);

            try
            {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                try
                {
                    if(format.parse(initDate).compareTo(format.parse(diaHabAnt7Historico))<=0 && format.parse(endDate).compareTo(format.parse(diaHabAnt7Historico))<=0)
                    {
                        url = value.valida(session, initDate, endDate, "Sicmor0205H");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    else
                        url = "/fechasInvalidas.jsp?noPantalla=5";
                }
                catch(Exception ex)
                {
                    throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                }
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte 0330
        else if(action.equals("SICMOR0330"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            session.setAttribute( "PRSA_TIPOS_TRANSACCION", this.PRSA_TIPOS_TRANSACCION );
            url = "/SICMOR0330Header.jsp";
        }
        else if(action.equals("SICMOR0330Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String cuenta=request.getParameter("cuenta").equals("")?"null":request.getParameter("cuenta");
            String referencia=request.getParameter("referencia").equals("")?"null":request.getParameter("referencia");
            if (referencia=="null")
            {
                referencia = "0";
            }
            if (cuenta=="null")
            {
                cuenta = "0";
            }
            System.out.println("Referencia:"+referencia+":");
            String natContable=request.getParameter("natContable").equals("")?"null":"'"+request.getParameter("natContable")+"'";
            if(!natContable.equals("null"))
                natContable=natContable.toUpperCase();
            String []bancoAdqArray = request.getParameterValues("bancoAdq");
            String bancoAdq="";
            for(String banco:bancoAdqArray){
                if(!bancoAdq.equals(""))
                    bancoAdq+=",";
                bancoAdq+=banco;
            }
         String []tipoTxnArray = request.getParameterValues("tipoTxn");
            String tipoTxn="";
            for(String tipo:tipoTxnArray){
                if(!tipoTxn.equals(""))
                    tipoTxn+=",";
                tipoTxn+=tipo;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("cuenta", cuenta);
            session.setAttribute("referencia", referencia);
            session.setAttribute("bancoAdq",bancoAdq);
            session.setAttribute("tipoTxn", tipoTxn);
            session.setAttribute("natContable", natContable);
            try
            {
                try
                {
                    if(format.parse(initDate).compareTo(format.parse(diaHabAnt7))>0)
                    {
                        Oparticiones (initDate, endDate);
                        url = "/reportsjsp/managerReports.jsp"+"?report="+"Sicmor0330";
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    else
                        url = "/fechasInvalidas.jsp?noPantalla=4";
                }
                catch(Exception ex)
                {
                    throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                }
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte MIR0040
        else if(action.equals("SICMIR0040"))
        {
            url = "/SICMIR0040Header.jsp";
        }
        else if(action.equals("SICMIR0040Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String comercio=request.getParameter("scomercio");
            String []bancolst = request.getParameterValues("banco");
            String banco="";
            for(String banco1:bancolst){
                if(!banco.equals(""))
                    banco+=",";
                banco+=banco1;
            }

            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("banco", banco);
            session.setAttribute("comercio", comercio);

            try
            {
                if(format.parse(initDate).compareTo(format.parse(diaHabAnt7))>0)
                {
            url = "/reportsjsp/managerReports.jsp"+"?report="+"Sicmir0040";
            viewerManager.setUpViewer(this, request, response, url);
            isAnswerReport=true;
                }
                else
                    url = "/fechasInvalidas.jsp?noPantalla=4";
            }
            catch(Exception ex)
            {
                throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
            }
            }

        else if(action.equals("SICMIR0040H"))
        {
            url = "/SICMIR0040HHeader.jsp";
        }
        else if(action.equals("SICMIR0040HMain"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String comercio=request.getParameter("scomercio");


           String []bancolst = request.getParameterValues("banco");
            String banco="";
            for(String banco1:bancolst){
                if(!banco.equals(""))
                    banco+=",";
                banco+=banco1;
            }

            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("banco", banco);
            session.setAttribute("comercio", comercio);

            url = "/reportsjsp/managerReports.jsp"+"?report="+"Sicmir0040H";
            viewerManager.setUpViewer(this, request, response, url);
            isAnswerReport=true;
            }

        //Reporte 0210
        else if(action.equals("SICMOR0210"))
        {
            session.setAttribute("SZ_TC_GRP", SZ_TC_GRP);
            url = "/SICMOR0210Header.jsp";
        }
        else if(action.equals("SICMOR0210Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String typeRech = request.getParameter("typeRech");
            //String bancoAdq = request.getParameter("bancoAdq");
            String []bancoAdqArray = request.getParameterValues("bancoAdq");
            String bancoAdq="";
            for(String banco:bancoAdqArray){
                if(!bancoAdq.equals(""))
                    bancoAdq+=",";
                bancoAdq+=banco;
            }
         String []typsRech = request.getParameterValues("typeRech");
            String typsRechStr="";
            for(String typRech:typsRech){
                if(!typsRechStr.equals(""))
                    typsRechStr+=",";
                typsRechStr+=typRech;
            }

            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("typeRech", typsRechStr);
            session.setAttribute("bancoAdq", bancoAdq);
            try
            {
                url = value.valida(session, initDate, endDate, "Sicmor0210");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte D210
        else if(action.equals("SICMORD210"))
        {
            session.setAttribute("SZ_TC_GRP", SZ_TC_GRP);
            url = "/SICMORD210Header.jsp";
        }
        else if(action.equals("SICMORD210Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String typeRech = request.getParameter("typeRech");
            //String bancoAdq = request.getParameter("bancoAdq");
            String []bancoAdqArray = request.getParameterValues("bancoAdq");
            String bancoAdq="";
            for(String banco:bancoAdqArray){
                if(!bancoAdq.equals(""))
                    bancoAdq+=",";
                bancoAdq+=banco;
            }

         String []typsRech = request.getParameterValues("typeRech");
        String typsRechStr="";
        for(String typRech:typsRech){
            if(!typsRechStr.equals(""))
                typsRechStr+=",";
            typsRechStr+=typRech;
        }

            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("typeRech", typsRechStr);
            session.setAttribute("bancoAdq", bancoAdq);
            try
            {
                url = value.valida(session, initDate, endDate, "Sicmord210");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte siclir0500
        else if(action.equals("SICLIR0500"))
        {
            session.setAttribute( "PRSA_TIPOS_TRANSACCION", this.PRSA_TIPOS_TRANSACCION );
            session.setAttribute( "PRSA_CIFRAS_CTRL", this.PRSA_CIFRAS_CTRL );
            url = "/SICLIR0500Header.jsp";
        }

        else if(action.equals("SICLIR0500Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []bancoArray = request.getParameterValues("banco");
            String bancoAdq="";
            for(String banco:bancoArray){
                if(!bancoAdq.equals(""))
                    bancoAdq+=",";
                bancoAdq+=banco;
            }

            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "initDate", initDate);
            session.setAttribute( "endDate", endDate);
            session.setAttribute( "banco", bancoAdq);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclir0500");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte siclir0501
        else if(action.equals("SICLIR0501"))
        {
            session.setAttribute( "PRSA_TIPOS_TRANSACCION", this.PRSA_TIPOS_TRANSACCION );
            session.setAttribute( "PRSA_CIFRAS_CTRL", this.PRSA_CIFRAS_CTRL );
            url = "/SICLIR0501Header.jsp";
        }

        else if(action.equals("SICLIR0501Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []bancoArray = request.getParameterValues("banco");
            String bancoAdq="";
            for(String banco:bancoArray){
                if(!bancoAdq.equals(""))
                    bancoAdq+=",";
                bancoAdq+=banco;
            }

            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "initDate", initDate);
            session.setAttribute( "endDate", endDate);
            session.setAttribute( "banco", bancoAdq);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclir0501");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //sicmir0300
        else if(action.equals("SICMIR0300"))
        {
            session.setAttribute("PRSA_TIPOS_TRANSACCION", PRSA_TIPOS_TRANSACCION);
            url = "/SICMIR0300Header.jsp";
        }
        else if(action.equals("SICMIR0300Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String typeRech = request.getParameter("typeRech");
            //String bancoAdq = request.getParameter("bancoAdq");
            String []bancoEmiArray = request.getParameterValues("bancoEmi");
            String bancoEmi="";
            for(String banco:bancoEmiArray){
                if(!bancoEmi.equals(""))
                    bancoEmi+=",";
                bancoEmi+=banco;
            }
         String []tiposTxn = request.getParameterValues("tipoTxn");
            String tipoTxnStr="";
            for(String tipoTxn:tiposTxn){
                if(!tipoTxnStr.equals(""))
                    tipoTxnStr+=",";
                tipoTxnStr+=tipoTxn;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("tipoTxn", tipoTxnStr);
            session.setAttribute("bancoEmi", bancoEmi);
            try
            {
                url = value.valida(session, initDate, endDate, "Sicmir0300");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //sicmir0301
        else if(action.equals("SICMIR0301"))
        {
            session.setAttribute("PRSA_TIPOS_TRANSACCION", PRSA_TIPOS_TRANSACCION);
            url = "/SICMIR0301Header.jsp";
        }
        else if(action.equals("SICMIR0301Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String typeRech = request.getParameter("typeRech");
            //String bancoAdq = request.getParameter("bancoAdq");
            String []bancoEmiArray = request.getParameterValues("bancoEmi");
            String bancoEmi="";
            for(String banco:bancoEmiArray){
                if(!bancoEmi.equals(""))
                    bancoEmi+=",";
                bancoEmi+=banco;
            }
         String []tiposTxn = request.getParameterValues("tipoTxn");
            String tipoTxnStr="";
            for(String tipoTxn:tiposTxn){
                if(!tipoTxnStr.equals(""))
                    tipoTxnStr+=",";
                tipoTxnStr+=tipoTxn;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("tipoTxn", tipoTxnStr);
            session.setAttribute("bancoEmi", bancoEmi);
            try
            {
                url = value.valida(session, initDate, endDate, "Sicmir0301");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte 0110
        else if(action.equals("SICLIR0110"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0110Header.jsp";
        }
        else if(action.equals("SICLIR0110Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String bancoEmi = request.getParameter("bancoEmi");
            String []bancoEmiArray = request.getParameterValues("bancoEmi");
            String bancosEmi="";
            for(String banco:bancoEmiArray){
                if(!bancosEmi.equals(""))
                    bancosEmi+=",";
                bancosEmi+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoEmi", bancosEmi);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclir0110");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte D110
        else if(action.equals("SICLIRD110"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRD110Header.jsp";
        }
        else if(action.equals("SICLIRD110Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String bancoEmi = request.getParameter("bancoEmi");
            String []bancoEmiArray = request.getParameterValues("bancoEmi");
            String bancosEmi="";
            for(String banco:bancoEmiArray){
                if(!bancosEmi.equals(""))
                    bancosEmi+=",";
                bancosEmi+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoEmi", bancosEmi);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclird110");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
//-----------------------------------------------------------------------------------//
//-- Marca del Cambio : WELL-EMQ-P-02-1202-09 Inicia la Modificacion   08/02/2010 -//
//---------------------------------------------------------------------------------//
//Reporte SICPRE001
        else if(action.equals("SICPRE001"))
        {
            //session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            //session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            //session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICPRE001Header.jsp";
        }
        else if(action.equals("SICPRE001Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String cuenta = request.getParameter("cuenta");

            //session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            //session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("cuenta", cuenta);
            try
            {
                url = value.valida(session, initDate, endDate, "SICPRE001");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }


 //Reporte SICPRE002
        else if(action.equals("SICPRE002"))
        {
            url = "/SICPRE002Header.jsp";
        }
        else if(action.equals("SICPRE002Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String cuenta = request.getParameter("cuenta");

            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("cuenta", cuenta);
            try
            {
                url = value.valida(session, initDate, endDate, "SICPRE002");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

//Reporte SICPRE004
        else if(action.equals("SICPRE004"))
        {
            url = "/SICPRE004Header.jsp";
        }
        else if(action.equals("SICPRE004Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");


            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);

            url = "/reportsjsp/managerReports.jsp"+"?report="+"SICPRE004";
            viewerManager.setUpViewer(this, request, response, url);
            isAnswerReport=true;
        }
 //Reporte SICPRE003
        else if(action.equals("SICPRE003"))
        {
                url = "/SICPRE003Header.jsp";
        }
        else if(action.equals("SICPRE003Main"))
        {
                String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String cuenta = request.getParameter("cuenta");

                //session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                //session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                session.setAttribute("txtfStartDate", initDate);
                session.setAttribute("txtfEndDate", endDate);
                //session.setAttribute("cuenta", cuenta);
                try
            {
               url = value.valida(session, initDate, endDate, "SICPRE003");
               viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                    e.printStackTrace();
            }
        }

//-----------------------------------------------------------------------------------//
//-- Marca del Cambio : WELL-EMQ-P-02-1202-09 Finaliza la Modificacion 08/02/2010 -//
//-----------------------------------------------------------------------------------//

        //Reporte 0020
        else if(action.equals("SICLIR0020"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0020Header.jsp";
        }
        else if(action.equals("SICLIR0020Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String bancoEmi = request.getParameter("bancoEmi");
            String []bancoSocioArray = request.getParameterValues("bancoSocio");
            String bancosSocios="";
            for(String banco:bancoSocioArray){
                if(!bancosSocios.equals(""))
                    bancosSocios+=",";
                bancosSocios+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoSocio", bancosSocios);
            try
            {
                Oparticionesdiaant(initDate, endDate, initDate, endDate);
                url = value.valida(session, initDate, endDate, "Siclir0020");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte D020
        else if(action.equals("SICLIRD020"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRD020Header.jsp";
        }
        else if(action.equals("SICLIRD020Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String bancoEmi = request.getParameter("bancoEmi");
            String []bancoSocioArray = request.getParameterValues("bancoSocio");
            String bancosSocios="";
            for(String banco:bancoSocioArray){
                if(!bancosSocios.equals(""))
                    bancosSocios+=",";
                bancosSocios+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoSocio", bancosSocios);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclird020");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }


        //Reporte 0670
        else if(action.equals("SICLIR0670"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0670Header.jsp";
        }
        else if(action.equals("SICLIR0670Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []bancoEmiArray = request.getParameterValues("banco");
            String bancosEmi="";
            for(String banco:bancoEmiArray){
                if(!bancosEmi.equals(""))
                    bancosEmi+=",";
                bancosEmi+=banco;
            }

            Double cuota_previa=Double.parseDouble(request.getParameter("cuota_previa"));
            Double diferencia_autorizaciones=Double.parseDouble(request.getParameter("diferencia_autorizaciones"));
            Double autorizaciones=Double.parseDouble(request.getParameter("autorizaciones"));
            Double copias=Double.parseDouble(request.getParameter("copias"));
            Double penalizaciones=Double.parseDouble(request.getParameter("penalizaciones"));
            Double tasas=Double.parseDouble(request.getParameter("tasas"));
            Double arbitraje=Double.parseDouble(request.getParameter("arbitraje"));
            Double intereses=Double.parseDouble(request.getParameter("intereses"));


            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
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

            try
            {
                url = value.valida(session, initDate, endDate, "Siclir0670");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }



        //Reporte 0680
        else if(action.equals("SICLIR0680"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0680Header.jsp";
        }
        else if(action.equals("SICLIR0680Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []bancoEmiArray = request.getParameterValues("banco");
            String bancosEmi="";
            for(String banco:bancoEmiArray){
                if(!bancosEmi.equals(""))
                    bancosEmi+=",";
                bancosEmi+=banco;
            }

            Double cuota_previa=Double.parseDouble(request.getParameter("cuota_previa"));
            Double diferencia_autorizaciones=Double.parseDouble(request.getParameter("diferencia_autorizaciones"));
            Double autorizaciones=Double.parseDouble(request.getParameter("autorizaciones"));
            Double copias=Double.parseDouble(request.getParameter("copias"));
            Double penalizaciones=Double.parseDouble(request.getParameter("penalizaciones"));
            Double tasas=Double.parseDouble(request.getParameter("tasas"));
            Double arbitraje=Double.parseDouble(request.getParameter("arbitraje"));
            Double intereses=Double.parseDouble(request.getParameter("intereses"));


            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
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

            try
            {
                url = value.valida(session, initDate, endDate, "Siclir0680");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte SICLIRP670
        else if(action.equals("SICLIRP670"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRP670Header.jsp";
        }
        else if(action.equals("SICLIRP670Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []bancoEmiArray = request.getParameterValues("bancoEmi");
            String bancosEmi="";
            for(String banco:bancoEmiArray){
                if(!bancosEmi.equals(""))
                    bancosEmi+=",";
                bancosEmi+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoEmi", bancosEmi);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclirp670");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte SICLIRP680
        else if(action.equals("SICLIRP680"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRP680Header.jsp";
        }
        else if(action.equals("SICLIRP680Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String diaHabAnt = (String)session.getAttribute("diaHabAnt");

            String []interreds = request.getParameterValues("interred");
            String interredesStr="";
            for(String interrred:interreds){
                if(!interredesStr.equals(""))
                    interredesStr+=",";
                interredesStr+=interrred;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "interred", interredesStr);

            try
            {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                try
                {

                        url = value.valida(session, initDate, endDate, "Siclirp680");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                }
                catch(Exception ex)
                {
                    throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                }                       }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte 0290
        else if(action.equals("SICMIR0290"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIR0290Header.jsp";
        }
        else if(action.equals("SICMIR0290Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String diaHabAnt = (String)session.getAttribute("diaHabAnt");

            String []bancoAdqArray = request.getParameterValues("bancoAdq");
            String bancosAdq="";
            for(String banco:bancoAdqArray){
                if(!bancosAdq.equals(""))
                    bancosAdq+=",";
                bancosAdq+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoAdq", bancosAdq);
            try
            {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                try
                {
                    if(format.parse(initDate).compareTo(format.parse(diaHabAnt7))>0)
                    {
                        System.out.println("valor:"+format.parse(initDate).compareTo(format.parse(diaHabAnt7))+":");
                        Oparticiones(initDate, endDate);
                        url = value.valida(session, initDate, endDate, "Sicmir0290");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    else
                        url = "/fechasInvalidas.jsp?noPantalla=4";
                }
                catch(Exception ex)
                {
                    throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                }
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte 0290H
        else if(action.equals("SICMIR0290H"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIR0290HHeader.jsp";
        }
        else if(action.equals("SICMIR0290HMain"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String diaHabAnt = (String)session.getAttribute("diaHabAnt");

            String []bancoAdqArray = request.getParameterValues("bancoAdq");
            String bancosAdq="";
            for(String banco:bancoAdqArray){
                if(!bancosAdq.equals(""))
                    bancosAdq+=",";
                bancosAdq+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoAdq", bancosAdq);
            try
            {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                try
                {
                    if(format.parse(initDate).compareTo(format.parse(diaHabAnt7Historico))<=0 && format.parse(endDate).compareTo(format.parse(diaHabAnt7Historico))<=0)
                    {
                        url = value.valida(session, initDate, endDate, "Sicmir0290H");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    else
                        url = "/fechasInvalidas.jsp?noPantalla=5";
                }
                catch(Exception ex)
                {
                    throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                }
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte B290
        else if(action.equals("SICMIRB290"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIRB290Header.jsp";
        }
        else if(action.equals("SICMIRB290Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String bancoEmi = request.getParameter("bancoEmi");
            String []bancoAdqArray = request.getParameterValues("bancoAdq");
            String bancosAdq="";
            for(String banco:bancoAdqArray){
                if(!bancosAdq.equals(""))
                    bancosAdq+=",";
                bancosAdq+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoAdq", bancosAdq);
            try
            {
                url = value.valida(session, initDate, endDate, "Sicmirb290");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }


        //Reporte 0120
        else if(action.equals("SICLIR0120"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0120Header.jsp";
        }
        else if(action.equals("SICLIR0120Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []interredes = request.getParameterValues("interred");
            String []divisiones = request.getParameterValues("division");
            //String interred = request.getParameter("interred");
            //String division = request.getParameter("division");
            String interredesStr="";
            for(String interred:interredes){
                if(!interredesStr.equals(""))
                    interredesStr+=",";
                interredesStr+=interred;
            }
            String divisionesStr="";
            for(String division:divisiones){
                if(!divisionesStr.equals(""))
                    divisionesStr+=",";
                divisionesStr+=division;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "interred", interredesStr);
            session.setAttribute( "division", divisionesStr);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclir0120");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte SICLIRD120
        else if(action.equals("SICLIRD120"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRD120Header.jsp";
        }
        else if(action.equals("SICLIRD120Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []interredes = request.getParameterValues("interred");
            String []divisiones = request.getParameterValues("division");
            String interredesStr="";
            for(String interred:interredes){
                if(!interredesStr.equals(""))
                    interredesStr+=",";
                interredesStr+=interred;
            }
            String divisionesStr="";
            for(String division:divisiones){
                if(!divisionesStr.equals(""))
                    divisionesStr+=",";
                divisionesStr+=division;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "interred", interredesStr);
            session.setAttribute( "division", divisionesStr);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclird120");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }


        //Reporte 0140
        else if(action.equals("SICLIR0140"))
        {
            url = "/SICLIR0140Header.jsp";
        }
        else if(action.equals("SICLIR0140Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclir0140");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte D140
        else if(action.equals("SICLIRD140"))
        {
            url = "/SICLIRD140Header.jsp";
        }
        else if(action.equals("SICLIRD140Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclird140");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte 0430
        else if(action.equals("SICLIR0430"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0430Header.jsp";
        }
        else if(action.equals("SICLIR0430Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String diaHabAnt = (String)session.getAttribute("diaHabAnt");

            String []interreds = request.getParameterValues("interred");
            String interredesStr="";
            for(String interrred:interreds){
                if(!interredesStr.equals(""))
                    interredesStr+=",";
                interredesStr+=interrred;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "interred", interredesStr);

            try
            {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                try
                {
                    if(format.parse(initDate).compareTo(format.parse(diaHabAnt7))>0)
                    {
                        Oparticiones(initDate, endDate);
                        url = value.valida(session, initDate, endDate, "Siclir0430");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    else
                        url = "/fechasInvalidas.jsp?noPantalla=4";
                }
                catch(Exception ex)
                {
                    throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                }                       }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte 0430H
        else if(action.equals("SICLIR0430H"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0430HHeader.jsp";
        }
        else if(action.equals("SICLIR0430HMain"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String diaHabAnt = (String)session.getAttribute("diaHabAnt");

            String []interreds = request.getParameterValues("interred");
            String interredesStr="";
            for(String interrred:interreds){
                if(!interredesStr.equals(""))
                    interredesStr+=",";
                if(interrred.equals("701"))
                    interredesStr+="700";
                else if (interrred.equals("723"))
                    interredesStr+="715,716,717,718,719,720,723";
                else
                    interredesStr+=interrred;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "interred", interredesStr);



            try
            {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                try
                {
                    if(format.parse(initDate).compareTo(format.parse(diaHabAnt7Historico))<=0 && format.parse(endDate).compareTo(format.parse(diaHabAnt7Historico))<=0)
                    {
                        url = value.valida(session, initDate, endDate, "Siclir0430H");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    else
                        url = "/fechasInvalidas.jsp?noPantalla=5";
                }
                catch(Exception ex)
                {
                    throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                }                       }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte 0360
        else if(action.equals("SICMOR0360"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            session.setAttribute( "PRSA_TIPOS_TRANSACCION", this.PRSA_TIPOS_TRANSACCION );
            url = "/SICMOR0360Header.jsp";
        }
        else if(action.equals("SICMOR0360Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String diaHabAnt = (String)session.getAttribute("diaHabAnt");

        String []bancoAdqArray = request.getParameterValues("bancoAdq");
        String bancoAdq="";
        for(String banco:bancoAdqArray){
            if(!bancoAdq.equals(""))
                bancoAdq+=",";
            bancoAdq+=banco;
        }
      String []bancoEmiArray = request.getParameterValues("bancoEmi");
        String bancoEmi="";
        for(String banco:bancoEmiArray){
            if(!bancoEmi.equals(""))
                bancoEmi+=",";
            bancoEmi+=banco;
        }
       String []tipoTransArray = request.getParameterValues("tipoTrans");
        String tipoTrans="";
        for(String tipo:tipoTransArray){
            if(!tipoTrans.equals(""))
                tipoTrans+=",";
            tipoTrans+=tipo;
        }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "bancoAdq", bancoAdq);
            session.setAttribute( "bancoEmi", bancoEmi);
            session.setAttribute( "tipoTrans", tipoTrans);
            try
            {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                try
                {
                    if(format.parse(initDate).compareTo(format.parse(diaHabAnt7))>0)
                    {
                        Oparticiones(initDate, endDate);
                        url = value.valida(session, initDate, endDate, "Sicmor0360");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    else
                        url = "/fechasInvalidas.jsp?noPantalla=4";
                }
                catch(Exception ex)
                {
                    throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                }
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte SICMORD360
        else if(action.equals("SICMORD360"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            session.setAttribute( "PRSA_TIPOS_TRANSACCION", this.PRSA_TIPOS_TRANSACCION );
            url = "/SICMORD360Header.jsp";
        }
        else if(action.equals("SICMORD360Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String diaHabAnt = (String)session.getAttribute("diaHabAnt");

        String []bancoAdqArray = request.getParameterValues("bancoAdq");
        String bancoAdq="";
        for(String banco:bancoAdqArray){
            if(!bancoAdq.equals(""))
                bancoAdq+=",";
            bancoAdq+=banco;
        }
      String []bancoEmiArray = request.getParameterValues("bancoEmi");
        String bancoEmi="";
        for(String banco:bancoEmiArray){
            if(!bancoEmi.equals(""))
                bancoEmi+=",";
            bancoEmi+=banco;
        }
       String []tipoTransArray = request.getParameterValues("tipoTrans");
        String tipoTrans="";
        for(String tipo:tipoTransArray){
            if(!tipoTrans.equals(""))
                tipoTrans+=",";
            tipoTrans+=tipo;
        }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "bancoAdq", bancoAdq);
            session.setAttribute( "bancoEmi", bancoEmi);
            session.setAttribute( "tipoTrans", tipoTrans);
            try
            {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                try
                {
                    if(format.parse(initDate).compareTo(format.parse(diaHabAnt7))>0)
                    {
                        Oparticiones(initDate, endDate);
                        url = value.valida(session, initDate, endDate, "Sicmord360");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    else
                        url = "/fechasInvalidas.jsp?noPantalla=4";
                }
                catch(Exception ex)
                {
                    throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                }
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte 0360H
        else if(action.equals("SICMOR0360H"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            session.setAttribute( "PRSA_TIPOS_TRANSACCION", this.PRSA_TIPOS_TRANSACCION );
            url = "/SICMOR0360HHeader.jsp";
        }
        else if(action.equals("SICMOR0360HMain"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
           String diaHabAnt = (String)session.getAttribute("diaHabAnt");

        String []bancoAdqArray = request.getParameterValues("bancoAdq");
        String bancoAdq="";
        for(String banco:bancoAdqArray){

            if(!bancoAdq.equals(""))
                bancoAdq+=",";
            if(banco.equals("701"))
                bancoAdq+="700";
            else if (banco.equals("723"))
                bancoAdq+="715,716,717,718" +
                        ",719,720,723";
            else
            bancoAdq+=banco;
        }

      String []bancoEmiArray = request.getParameterValues("bancoEmi");
        String bancoEmi="";
        for(String banco:bancoEmiArray){
            if(!bancoEmi.equals(""))
                bancoEmi+=",";
            bancoEmi+=banco;
        }
       String []tipoTransArray = request.getParameterValues("tipoTrans");
        String tipoTrans="";
        for(String tipo:tipoTransArray){
            if(!tipoTrans.equals(""))
                tipoTrans+=",";
            tipoTrans+=tipo;
        }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "bancoAdq", bancoAdq);

            session.setAttribute( "bancoEmi", bancoEmi);
            session.setAttribute( "tipoTrans", tipoTrans);
            try
            {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                try
                {
                    if(format.parse(initDate).compareTo(format.parse(diaHabAnt7Historico))<=0 && format.parse(endDate).compareTo(format.parse(diaHabAnt7Historico))<=0)
                    {
                        url = value.valida(session, initDate, endDate, "Sicmor0360H");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    else
                        url = "/fechasInvalidas.jsp?noPantalla=5";
                }
                catch(Exception ex)
                {
                    throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                }
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }



        //Reporte 0320
        else if(action.equals("SICLIR0320"))
        {
            url = "/SICLIR0320Header.jsp";
        }
        else if(action.equals("SICLIR0320Main"))
        {
            SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []tipoLiq = request.getParameterValues("tipoLiq");
           String tipoLiqStr="";
            for(String tipoL:tipoLiq){
                if(!tipoLiqStr.equals(""))
                    tipoLiqStr+=",";
                tipoLiqStr+=tipoL;
            }
            if(tipoLiqStr.contains("21"))
                tipoLiqStr+=",27";

            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("tipoLiq", tipoLiqStr);
            try
            {
                session.setAttribute("initDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("endDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                url = value.valida(session, initDate, endDate, "Siclir0320");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

        //Reporte P320
        else if(action.equals("SICLIRP320"))
        {
            url = "/SICLIRP320Header.jsp";
        }
        else if(action.equals("SICLIRP320Main"))
        {
            SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");

            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclirpago320");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

        //Reporte I320
        else if(action.equals("SICLIRI320"))
        {
            url = "/SICLIRI320Header.jsp";
        }
        else if(action.equals("SICLIRI320Main"))
        {
            SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []tipoLiq = request.getParameterValues("tipoLiq");
           String tipoLiqStr="";
            for(String tipoL:tipoLiq){
                if(!tipoLiqStr.equals(""))
                    tipoLiqStr+=",";
                tipoLiqStr+=tipoL;
            }
            //if(tipoLiqStr.contains("21"))
            //tipoLiqStr+=",27";

            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("tipoLiq", tipoLiqStr);
            try
            {
                session.setAttribute("initDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("endDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                url = value.valida(session, initDate, endDate, "Sicliri320");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

        //Reporte D320
        else if(action.equals("SICLIRD320"))
        {
            url = "/SICLIRD320Header.jsp";
        }
        else if(action.equals("SICLIRD320Main"))
        {
            SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []tipoLiq = request.getParameterValues("tipoLiq");
           String tipoLiqStr="";
            for(String tipoL:tipoLiq){
                if(!tipoLiqStr.equals(""))
                    tipoLiqStr+=",";
                tipoLiqStr+=tipoL;
            }
            if(tipoLiqStr.contains("21"))
                tipoLiqStr+=",27";

            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("tipoLiq", tipoLiqStr);
            try
            {
                session.setAttribute("initDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("endDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                url = value.valida(session, initDate, endDate, "Siclird320");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

        //Reporte 0650
        else if(action.equals("SICLIR0650"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0650Header.jsp";
        }
        else if(action.equals("SICLIR0650Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");

            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);

            try
            {
                url = value.valida(session, initDate, endDate, "Siclir0650");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte 0640
        else if(action.equals("SICLIR0640"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0640Header.jsp";
        }
        else if(action.equals("SICLIR0640Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");

            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);

            try
            {
                url = value.valida(session, initDate, endDate, "Siclir0640");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte 0580
        else if(action.equals("SICLIR0580"))
        {
            url = "/SICLIR0580Header.jsp";
        }
        else if(action.equals("SICLIR0580Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []bancoEmiArray = request.getParameterValues("banco");
            String bancosEmi="";
            for(String banco:bancoEmiArray){
                if(!bancosEmi.equals(""))
                    bancosEmi+="','";
                bancosEmi+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("banco", bancosEmi);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclir0580");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte 0200
        else if(action.equals("SICLIR0200"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0200Header.jsp";
        }
        else if(action.equals("SICLIR0200Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String bancoAdquiriente = request.getParameter("bancoAdquiriente");
           String []bancosAdq = request.getParameterValues("bancoAdquiriente");
           String bancosAdqStr="";
        for(String bancoAdqr:bancosAdq){
            if(!bancosAdqStr.equals(""))
                bancosAdqStr+=",";
            bancosAdqStr+=bancoAdqr;
        }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "bancoAdquiriente", bancosAdqStr);

            try
            {
                session.setAttribute("txtfStartDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("txtfEndDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                url = value.valida(session, initDate, endDate, "Siclir0200");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(ParseException pe){
                pe.printStackTrace();
            }
        }

        //Reporte 0200
        else if(action.equals("SICMOR0200"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMOR0200Header.jsp";
        }
        else if(action.equals("SICMOR0200Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String diaHabAnt = (String)session.getAttribute("diaHabAnt");
            String initDate = request.getParameter("txtfStartDate");
            String afiliacion = request.getParameter("Afiliacion");

            String []bancosAdq = request.getParameterValues("bancoAdq");
            String bancosAdqStr="";
            for(String bancoAdqr:bancosAdq){
            if(!bancosAdqStr.equals(""))
                bancosAdqStr+=",";
            bancosAdqStr+=bancoAdqr;
            }
            String []bancosEmi = request.getParameterValues("bancoEmi");
            String bancosEmiStr="";
            for(String bancoEmir:bancosEmi){
            if(!bancosEmiStr.equals(""))
                bancosEmiStr+=",";
            bancosEmiStr+=bancoEmir;
            }
            String []fuentes = request.getParameterValues("archivoAdq");
            String fuentesStr="";
            for(String fuentesr:fuentes){
            if(!fuentesStr.equals(""))
                fuentesStr+=",";
            fuentesStr+=fuentesr;
            }

            String []Transacciones = request.getParameterValues("Transaccion");
            if(Transacciones==null)
                Transacciones=new String[0];
            String TransaccionesStr="";
            for(String Transaccionesr:Transacciones){
            if(!TransaccionesStr.equals(""))
                TransaccionesStr+=",";
            TransaccionesStr+=Transaccionesr;
            }

           String []Liquidaciones = request.getParameterValues("Liquidacion");
           if(Liquidaciones==null)
             Liquidaciones=new String[0];
            String LiquidacionesStr="";
            for(String Liquidacionesr:Liquidaciones){
            if(!LiquidacionesStr.equals(""))
                LiquidacionesStr+=",";
            LiquidacionesStr+=Liquidacionesr;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "bancoAdq", bancosAdqStr);
            session.setAttribute( "bancoEmi", bancosEmiStr);
            session.setAttribute( "transaccion", TransaccionesStr);
            session.setAttribute( "liquidacion", LiquidacionesStr);
            session.setAttribute( "fuente", fuentesStr);

            if (afiliacion.equals(""))
            {
                afiliacion = "0";
            }
            session.setAttribute( "afiliacion", afiliacion);
            try
            {
                try
                {
                    if(format.parse(initDate).compareTo(format.parse(diaHabAnt7))>0)
                    {
                        Oparticion(initDate);
                        url = "/reportsjsp/managerReports.jsp"+"?report="+"Sicmor0200";
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    else
                        url = "/fechasInvalidas.jsp?noPantalla=4";
                }
                catch(Exception ex)
                {
                    throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                }
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }

        }
        /* Marca del Cambio : SAS-JAGG-Z-02-2675-12 Inicia la Modificacion     13/02/2013  */

                else if(action.equals("MantTelef"))
                {

                    url = "/mantTelf_Header.jsp";
                }
                else if(action.equals("XXXXmntoTel"))
                {
                    session.removeAttribute("guardado");
                    String []telefonicaMnto = request.getParameterValues("telefonica");
                    String telefonicaStr="";
                        for(String telefonica:telefonicaMnto){
                            if(!telefonicaStr.equals(""))
                                telefonicaStr+=",";
                                telefonicaStr+=telefonica;
                        }
                    DaoMntoTelefonica dmt= new DaoMntoTelefonica();
                    dmt.buscaDatosTelefonica(session, telefonicaStr);
                    session.setAttribute("vtc_tasa_com_int_cre",dmt.getVtc_tasa_com_int_cre());
                    session.setAttribute("vtc_tasa_com_adq_cre",dmt.getVtc_tasa_com_adq_cre());
                    session.setAttribute("vtc_tasa_com_com_cre",dmt.getVtc_tasa_com_com_cre());
                    session.setAttribute("vtc_tasa_com_int_deb",dmt.getVtc_tasa_com_int_deb());
                    session.setAttribute("vtc_tasa_com_adq_deb",dmt.getVtc_tasa_com_adq_deb());
                    session.setAttribute("vtc_tasa_com_com_deb",dmt.getVtc_tasa_com_com_deb());
                    session.setAttribute("vtc_tasa_com_int_efe",dmt.getVtc_tasa_com_int_efe());
                    session.setAttribute("vtc_tasa_com_adq_efe",dmt.getVtc_tasa_com_adq_efe());
                    session.setAttribute("vtc_tasa_com_com_efe",dmt.getVtc_tasa_com_com_efe());
                    session.setAttribute("vtc_tasa_iva",dmt.getVtc_tasa_iva());
                    session.setAttribute("estatus",dmt.getEstatus());
                    session.setAttribute("claveTelefonica",dmt.getVtc_cve_telef());
                    session.setAttribute("nombreTelefonica",dmt.getVtc_nom_telef());
                    url = "/mantenimientoTelefonica.jsp";
                }
                else if(action.equals("guardadoMantTelef"))
                {
                    DaoMntoTelefonica dmt= new DaoMntoTelefonica();
                    dmt.setVtc_tasa_com_int_cre( Double.parseDouble( request.getParameter("vtc_tasa_com_int_cre"))) ;
                    dmt.setVtc_tasa_com_adq_cre ( Double.parseDouble( request.getParameter("vtc_tasa_com_adq_cre"))) ;
                    dmt.setVtc_tasa_com_com_cre( Double.parseDouble( request.getParameter("vtc_tasa_com_com_cre"))) ;
                    dmt.setVtc_tasa_com_int_deb( Double.parseDouble( request.getParameter("vtc_tasa_com_int_deb"))) ;
                    dmt.setVtc_tasa_com_adq_deb( Double.parseDouble( request.getParameter("vtc_tasa_com_adq_deb"))) ;
                    dmt.setVtc_tasa_com_com_deb( Double.parseDouble( request.getParameter("vtc_tasa_com_com_deb"))) ;
                    dmt.setVtc_tasa_com_int_efe( Double.parseDouble( request.getParameter("vtc_tasa_com_int_efe"))) ;
                    dmt.setVtc_tasa_com_adq_efe( Double.parseDouble( request.getParameter("vtc_tasa_com_adq_efe"))) ;
                    dmt.setVtc_tasa_com_com_efe( Double.parseDouble( request.getParameter("vtc_tasa_com_com_efe"))) ;
                    dmt.setVtc_tasa_iva( Double.parseDouble( request.getParameter("vtc_tasa_iva"))) ;
                    if (request.getParameter("cbo_estatus").equals("0") )
                    {
                        dmt.setEstatus("A") ;
                    }
                    else
                    {
                        dmt.setEstatus("B") ;
                    }
                    dmt.setVtc_cve_telef(Integer.parseInt(request.getParameter("claveTelefonica")));
                    String telefonicaMnto=request.getParameter("claveTelefonica");
                    dmt.guardaDatosTelefonica(session, telefonicaMnto);

                    // reabrir la pagina

                    dmt.buscaDatosTelefonica(session, telefonicaMnto);
                    session.setAttribute("vtc_tasa_com_int_cre",dmt.getVtc_tasa_com_int_cre());
                    session.setAttribute("vtc_tasa_com_adq_cre",dmt.getVtc_tasa_com_adq_cre());
                    session.setAttribute("vtc_tasa_com_com_cre",dmt.getVtc_tasa_com_com_cre());
                    session.setAttribute("vtc_tasa_com_int_deb",dmt.getVtc_tasa_com_int_deb());
                    session.setAttribute("vtc_tasa_com_adq_deb",dmt.getVtc_tasa_com_adq_deb());
                    session.setAttribute("vtc_tasa_com_com_deb",dmt.getVtc_tasa_com_com_deb());
                    session.setAttribute("vtc_tasa_com_int_efe",dmt.getVtc_tasa_com_int_efe());
                    session.setAttribute("vtc_tasa_com_adq_efe",dmt.getVtc_tasa_com_adq_efe());
                    session.setAttribute("vtc_tasa_com_com_efe",dmt.getVtc_tasa_com_com_efe());
                    session.setAttribute("vtc_tasa_iva",dmt.getVtc_tasa_iva());
                    session.setAttribute("estatus",dmt.getEstatus());
                    session.setAttribute("claveTelefonica",dmt.getVtc_cve_telef());
                    session.setAttribute("nombreTelefonica",dmt.getVtc_nom_telef());
                    session.setAttribute("guardado","ok");
                    url = "/mantenimientoTelefonica.jsp";
                }

                // mantenimiento distribuidor

                else if(action.equals("MantDistri"))
                {
                    url = "/mantDistri_Header.jsp";
                }

                //Siclir0010
                else if(action.equals("XXXXmntoDistri"))
                {
                    String []DistribuidorMnto = request.getParameterValues("distribuidor");
                    String distribuidorStr="";
                        for(String distribuidor:DistribuidorMnto){
                            if(!distribuidorStr.equals(""))
                                distribuidorStr+=",";
                            distribuidorStr+=distribuidor;
                        }
                    session.removeAttribute("guardado");
                    DaoMntoDistribuidor dmd= new DaoMntoDistribuidor();
                    dmd.buscaDatosDistribuidor(session, distribuidorStr);
                    session.setAttribute("vtc_imp_tarifa",dmd.getVtc_imp_tarifa());
                    session.setAttribute("vtc_ent_numero",dmd.getVtc_ent_numero());
                    session.setAttribute("vtc_estatus",dmd.getVtc_estatus());
                    session.setAttribute("nombreDistribuidor",dmd.getVtc_nom_distr());
                    session.setAttribute("claveDistribuidor",dmd.getVtc_id_distr());
                    url = "/mantenimientoDistribuidor.jsp";
                }
                else if(action.equals("guardadoMantDistri"))
                {
                    DaoMntoDistribuidor dmd= new DaoMntoDistribuidor();
                    dmd.setVtc_imp_tarifa( Double.parseDouble( request.getParameter("vtc_imp_tarifa"))) ;
                    dmd.setVtc_ent_numero( Integer.parseInt( request.getParameter("vtc_ent_numero"))) ;
                    if (request.getParameter("cbo_estatus").equals("0"))
                    {
                        dmd.setVtc_estatus("A") ;
                    }
                    else
                    {
                        dmd.setVtc_estatus("B") ;
                    }
                    String distribuidorMnto=request.getParameter("claveDistribuidor");
                    dmd.guardaDatosDistribuidor(session, distribuidorMnto);
                    // re abre pagina
                    dmd.buscaDatosDistribuidor(session, distribuidorMnto);
                    session.setAttribute("vtc_imp_tarifa",dmd.getVtc_imp_tarifa());
                    session.setAttribute("vtc_ent_numero",dmd.getVtc_ent_numero());
                    session.setAttribute("vtc_estatus",dmd.getVtc_estatus());
                    session.setAttribute("nombreDistribuidor",dmd.getVtc_nom_distr());
                    session.setAttribute("claveDistribuidor",dmd.getVtc_id_distr());
                    session.setAttribute("guardado","ok");
                    url = "/mantenimientoDistribuidor.jsp";
                }
    /* Marca de fin de cambio : SAS-JAGG-Z-02-2675-12 Inicia la Modificacion  13/02/2013 */

        //Reporte 0300
        else if(action.equals("SICMOR0300"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMOR0300Header.jsp";
        }
        else if(action.equals("SICMOR0300Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String diaHabAnt = (String)session.getAttribute("diaHabAnt");
            String initDate = request.getParameter("txtfStartDate");

            String []bancosAdq = request.getParameterValues("bancoAdq");
            String bancosAdqStr="";
            for(String bancoAdqr:bancosAdq){
            if(!bancosAdqStr.equals(""))
                bancosAdqStr+=",";
            bancosAdqStr+=bancoAdqr;
            }

            String []bancosEmi = request.getParameterValues("bancoEmi");
            String bancosEmiStr="";
            for(String bancoEmir:bancosEmi){
            if(!bancosEmiStr.equals(""))
                bancosEmiStr+=",";
            bancosEmiStr+=bancoEmir;
            }

            String []fuentes = request.getParameterValues("archivoEmi");
            if(fuentes==null)
                fuentes=new String[0];
            String fuentesStr="";
            for(String fuentesr:fuentes){
            if(!fuentesStr.equals(""))
                fuentesStr+=",";
            fuentesStr+=fuentesr;
            }

            String []Transacciones = request.getParameterValues("Transaccion");
            if(Transacciones==null)
                Transacciones=new String[0];
            String TransaccionesStr="";
            for(String Transaccionesr:Transacciones){
            if(!TransaccionesStr.equals(""))
                TransaccionesStr+=",";
            TransaccionesStr+=Transaccionesr;
            }

            String []Liquidaciones = request.getParameterValues("Liquidacion");
           if(Liquidaciones==null)
                Liquidaciones=new String[0];
            String LiquidacionesStr="";
            for(String Liquidacionesr:Liquidaciones){
            if(!LiquidacionesStr.equals(""))
                LiquidacionesStr+=",";
            LiquidacionesStr+=Liquidacionesr;
            }

            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "bancoAdq", bancosAdqStr);
            session.setAttribute( "bancoEmi", bancosEmiStr);
            session.setAttribute( "transaccion", TransaccionesStr);
            session.setAttribute( "fuente", fuentesStr);
            session.setAttribute( "liquidacion", LiquidacionesStr);

            try
            {
                try
                {
                    if(format.parse(initDate).compareTo(format.parse(diaHabAnt7))>0)
                    {
                        Oparticion(initDate);
                        url = "/reportsjsp/managerReports.jsp"+"?report="+"Sicmor0300";
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    else
                        url = "/fechasInvalidas.jsp?noPantalla=4";
                }
                catch(Exception ex)
                {
                    throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                }
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }


        //Reporte D200
        else if(action.equals("SICLIRD200"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRD200Header.jsp";
        }
        else if(action.equals("SICLIRD200Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String bancoAdquiriente = request.getParameter("bancoAdquiriente");
           String []bancosAdq = request.getParameterValues("bancoAdquiriente");
           String bancosAdqStr="";
        for(String bancoAdqr:bancosAdq){
            if(!bancosAdqStr.equals(""))
                bancosAdqStr+=",";
            bancosAdqStr+=bancoAdqr;
        }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "bancoAdquiriente", bancosAdqStr);

            try
            {
                url = value.valida(session, initDate, endDate, "Siclird200");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte 0060
        else if(action.equals("SICLIF0060"))
        {

            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIF0060Header.jsp";
        }
        else if(action.equals("SICLIF0060Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String banco = request.getParameter("banco");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);

            try
            {
                SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                session.setAttribute("initDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("endDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                Oparticionesdiaant(initDate, endDate, initDate, endDate);
                url = value.valida(session, initDate, endDate, "Siclif0060");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        //Reporte SICLIFD060
        else if(action.equals("SICLIFD060"))
        {

            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIFD060Header.jsp";
        }
        else if(action.equals("SICLIFD060Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);

            try
            {
                SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                session.setAttribute("initDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("endDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                Oparticionesdiaant(initDate, endDate, initDate, endDate);
                url = value.valida(session, initDate, endDate, "Siclifd060");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        //Reporte 0065
        else if(action.equals("SICLIF0065"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIF0065Header.jsp";
        }
        else if(action.equals("SICLIF0065Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String banco = request.getParameter("banco");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);
            try
            {
                SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                session.setAttribute("initDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("endDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                Oparticionesdiaant(initDate, endDate, initDate, endDate);
                url = value.valida(session, initDate, endDate, "Siclif0065");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        //Reporte D065
        else if(action.equals("SICLIFD065"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIFD065Header.jsp";
        }
        else if(action.equals("SICLIFD065Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String banco = request.getParameter("banco");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);
            try
            {
                SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                session.setAttribute("initDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("endDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                url = value.valida(session, initDate, endDate, "Siclifd065");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        //Reporte 0420
        else if(action.equals("SICMIR0420"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIR0420Header.jsp";
        }
        else if(action.equals("SICMIR0420Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String bancoAdq = request.getParameter("bancoAdq");
            String []bancosAdq = request.getParameterValues("bancoAdq");
            String bancosAdqStr="";
            for(String bancoAdq:bancosAdq){
                if(!bancosAdqStr.equals(""))
                    bancosAdqStr+=",";
                bancosAdqStr+=bancoAdq;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "bancoAdq", bancosAdqStr);

            try
            {
                url = value.valida(session, initDate, endDate, "Sicmir0420");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
        //Reporte b420
        else if(action.equals("SICMIRB420"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIRB420Header.jsp";
        }
        else if(action.equals("SICMIRB420Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String bancoAdq = request.getParameter("bancoAdq");
            String []bancosAdq = request.getParameterValues("bancoAdq");
            String bancosAdqStr="";
            for(String bancoAdq:bancosAdq){
                if(!bancosAdqStr.equals(""))
                    bancosAdqStr+=",";
                bancosAdqStr+=bancoAdq;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "bancoAdq", bancosAdqStr);

            try
            {
                url = value.valida(session, initDate, endDate, "Sicmirb420");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte 0100
        else if(action.equals("SICMOR0100"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            session.setAttribute( "SZ_TC_GRP", this.SZ_TC_GRP);
            session.setAttribute( "PRSA_ARCHIVOS", this.PRSA_ARCHIVOS);
            url = "/SICMOR0100Header.jsp";
        }
        else if(action.equals("SICMOR0100Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String agrNatContable=(request.getParameter("agrNatContable")==null?"false":"true");
            String afiliacion=request.getParameter("afiliacion").equals("")?"null":request.getParameter("afiliacion");
            String diaHabAnt = (String)session.getAttribute("diaHabAnt");

            String []bancosAdq = request.getParameterValues("bancoAdq");
            String bancosAdqStr="";
            for(String bancoAdq:bancosAdq){
                if(!bancosAdqStr.equals(""))
                    bancosAdqStr+=",";
                bancosAdqStr+=bancoAdq;
            }
            String []transacs = request.getParameterValues("nTransac");
            String transacsStr="";
            for(String transac:transacs){
                if(!transacsStr.equals(""))
                    transacsStr+=",";
                transacsStr+=transac;
            }
            String []archivosAdq = request.getParameterValues("archivoAdq");
            String archivosAdqStr="";
            for(String archivoAdq:archivosAdq){
                if(!archivosAdqStr.equals(""))
                    archivosAdqStr+=",";
                archivosAdqStr+=archivoAdq;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoAdq", bancosAdqStr);
            session.setAttribute("nTransac", transacsStr);
            session.setAttribute("archivoAdq", archivosAdqStr);
            session.setAttribute("agrNatContable", agrNatContable);
            session.setAttribute("afiliacion", afiliacion);

            try
            {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                try
                {
                    if(format.parse(initDate).compareTo(format.parse(diaHabAnt7))>0)
                    {
                        Oparticiones(initDate, endDate);
                        url = value.valida(session, initDate, endDate, "Sicmor0100");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    else
                        url = "/fechasInvalidas.jsp?noPantalla=4";
                }
                catch(Exception ex)
                {
                    throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                }
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte 0100H
        else if(action.equals("SICMOR0100H"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            session.setAttribute( "SZ_TC_GRP", this.SZ_TC_GRP);
            session.setAttribute( "PRSA_ARCHIVOS", this.PRSA_ARCHIVOS);
            url = "/SICMOR0100HHeader.jsp";
        }

//Marca inicio: AMEstudio
        else if(action.equals("soporte"))
        {
            url = "/soporteHeader.jsp";
        }

//Marca inicio: AMEstudio

        else if(action.equals("SICMOR0100HMain"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String agrNatContable=(request.getParameter("agrNatContable")==null?"false":"true");
            String natcon=request.getParameter("natcon");
            String diaHabAnt = (String)session.getAttribute("diaHabAnt");

            String []bancosAdq = request.getParameterValues("bancoAdq");
            String bancosAdqStr="";
            for(String bancoAdq:bancosAdq){
                if(!bancosAdqStr.equals(""))
                    bancosAdqStr+=",";
                bancosAdqStr+=bancoAdq;
            }
            String []transacs = request.getParameterValues("nTransac");
            String transacsStr="";
            for(String transac:transacs){
                if(!transacsStr.equals(""))
                    transacsStr+=",";
                transacsStr+=transac;
            }
            String []archivosAdq = request.getParameterValues("archivoAdq");
            String archivosAdqStr="";
            for(String archivoAdq:archivosAdq){
                if(!archivosAdqStr.equals(""))
                    archivosAdqStr+=",";
                archivosAdqStr+=archivoAdq;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoAdq", bancosAdqStr);
            session.setAttribute("nTransac", transacsStr);
            session.setAttribute("archivoAdq", archivosAdqStr);
            session.setAttribute("natcon", natcon);
            session.setAttribute("agrNatContable", agrNatContable);

               try
            {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                try
                {
                    if(format.parse(initDate).compareTo(format.parse(diaHabAnt7Historico))<=0 && format.parse(endDate).compareTo(format.parse(diaHabAnt7Historico))<=0)
                    {
                        url = value.valida(session, initDate, endDate, "Sicmor0100H");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    else
                        url = "/fechasInvalidas.jsp?noPantalla=5";
                }
                catch(Exception ex)
                {
                    throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                }
                }
            catch (WellException e)
                {
                    e.printStackTrace();
                }
        }

        //Reporte SICMOF0100
        else if(action.equals("SICMOF0100"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            session.setAttribute( "PRSA_TIPOS_TRANSACCION", this.PRSA_TIPOS_TRANSACCION);
            session.setAttribute( "SZ_TC_GRP", this.SZ_TC_GRP);
            session.setAttribute( "PRSA_ARCHIVOS", this.PRSA_ARCHIVOS);
            fechas(session);
            if(request.getParameter("mostrarTabla")!=null){
                session.setAttribute("mostrarTabla","true");
            }else
                session.setAttribute("mostrarTabla","false");

            url = "/SICMOF0100Header.jsp";
        }

        //Reporte SICMOF0100H
        else if(action.equals("SICMOF0100H"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            session.setAttribute( "PRSA_TIPOS_TRANSACCION", this.PRSA_TIPOS_TRANSACCION);
            session.setAttribute( "SZ_TC_GRP", this.SZ_TC_GRP);
            session.setAttribute( "PRSA_ARCHIVOS", this.PRSA_ARCHIVOS);
            fechas(session);
            if(request.getParameter("mostrarTabla")!=null){
                session.setAttribute("mostrarTabla","true");
            }else
                session.setAttribute("mostrarTabla","false");

            url = "/SICMOF0100HHeader.jsp";
        }

        //Reporte SICMOF0120
        else if(action.equals("SICMOF0120"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            session.setAttribute( "PRSA_TIPOS_TRANSACCION", this.PRSA_TIPOS_TRANSACCION);
            session.setAttribute( "SZ_TC_GRP", this.SZ_TC_GRP);
            session.setAttribute( "PRSA_ARCHIVOS", this.PRSA_ARCHIVOS);
            fechas(session);
            if(request.getParameter("mostrarTabla")!=null){
                session.setAttribute("mostrarTabla","true");
            }else{

                session.setAttribute("mostrarTabla","false");
            }

            url = "/SICMOF0120Header.jsp";
        }

        //Reporte SICMOFB100
        else if(action.equals("SICMOFB100"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            session.setAttribute( "PRSA_TIPOS_TRANSACCION", this.PRSA_TIPOS_TRANSACCION);
            session.setAttribute( "SZ_TC_GRP", this.SZ_TC_GRP);
            session.setAttribute( "PRSA_ARCHIVOS", this.PRSA_ARCHIVOS);
            if(request.getParameter("mostrarTabla")!=null){
                session.setAttribute("mostrarTabla","true");
            }else
                session.setAttribute("mostrarTabla","false");

            url = "/SICMOFB100Header.jsp";
        }

        //Reporte SICMOF0120
        else if(action.equals("SICMOFB120"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            session.setAttribute( "PRSA_TIPOS_TRANSACCION", this.PRSA_TIPOS_TRANSACCION);
            session.setAttribute( "SZ_TC_GRP", this.SZ_TC_GRP);
            session.setAttribute( "PRSA_ARCHIVOS", this.PRSA_ARCHIVOS);
            if(request.getParameter("mostrarTabla")!=null){
                session.setAttribute("mostrarTabla","true");
            }else
                session.setAttribute("mostrarTabla","false");

            url = "/SICMOFB120Header.jsp";
        }
        //Reporte SICMOR0301
        else if(action.equals("SICMOR0301"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMOR0301Header.jsp";
        }
        else if(action.equals("SICMOR0301Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String diaHabAnt = (String)session.getAttribute("diaHabAnt");
            String initDate = request.getParameter("txtfStartDate");

            String []bancosAdq = request.getParameterValues("bancoAdq");
            String bancosAdqStr="";
            for(String bancoAdqr:bancosAdq){
            if(!bancosAdqStr.equals(""))
                bancosAdqStr+=",";
            bancosAdqStr+=bancoAdqr;
            }

            String []bancosEmi = request.getParameterValues("bancoEmi");
            String bancosEmiStr="";
            for(String bancoEmir:bancosEmi){
            if(!bancosEmiStr.equals(""))
                bancosEmiStr+=",";
            bancosEmiStr+=bancoEmir;
            }

            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "bancoAdq", bancosAdqStr);
            session.setAttribute( "bancoEmi", bancosEmiStr);

            try
            {
                try
                {
                    if(format.parse(initDate).compareTo(format.parse(diaHabAnt7))>0)
                    {
                        Oparticion(initDate);
                        url = "/reportsjsp/managerReports.jsp"+"?report="+"Sicmor0301";
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    else
                        url = "/fechasInvalidas.jsp?noPantalla=4";
                }
                catch(Exception ex)
                {
                    throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                }
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte SICMOR0305
        else if(action.equals("SICMOR0305"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            session.setAttribute( "SZ_TC_GRP", this.SZ_TC_GRP);
            url = "/SICMOR0305Header.jsp";
        }
        else if(action.equals("SICMOR0305Main"))
        {

            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String fecha1 = formato2.format(formato1.parse(initDate));
            String fecha2 = formato2.format(formato1.parse(endDate));
            String fechas = fecha1+"        "+fecha2;
            listaparticiones = new ComboBox();
            String diaHabAnt = (String)session.getAttribute("diaHabAnt");

            String prefijo=request.getParameter("Prefijo");
            String []bancoAdqArray = request.getParameterValues("bancoAdq");
            String bancoAdq="";
            for(String banco:bancoAdqArray){
                if(!bancoAdq.equals(""))
                    bancoAdq+=",";
                bancoAdq+=banco;
            }
          String []bancoEmiArray = request.getParameterValues("bancoEmi");
            String bancoEmi="";
            for(String banco:bancoEmiArray){
                if(!bancoEmi.equals(""))
                    bancoEmi+=",";
                bancoEmi+=banco;
            }
           String []tipoTransArray = request.getParameterValues("tipoTransac");
            String tipoTrans="";
            for(String tipo:tipoTransArray){
                if(!tipoTrans.equals(""))
                    tipoTrans+=",";
                tipoTrans+=tipo;
            }

           String []tipoLiquidacionArray = request.getParameterValues("tipoLiquidacion");
            String tipoLiquidacion="";
            for(String tipo:tipoLiquidacionArray){
                if(!tipoLiquidacion.equals(""))
                    tipoLiquidacion+=",";
                tipoLiquidacion+=tipo;
            }

            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "particiones", particiones);
            session.setAttribute( "bancoAdq", bancoAdq);
            session.setAttribute( "bancoEmi", bancoEmi);
            session.setAttribute( "tipoTransac", tipoTrans);
            session.setAttribute("prefijo", prefijo);
            session.setAttribute( "tipoLiquidacion", tipoLiquidacion);
            try
            {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                try
                {
                    if(format.parse(initDate).compareTo(format.parse(diaHabAnt7))>0)
                    {
                        Oparticiones(initDate, endDate);
                        url = value.valida(session, initDate, endDate, "Sicmor0305");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    else
                        url = "/fechasInvalidas.jsp?noPantalla=4";
                }
                catch(Exception ex)
                {
                    throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                }
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte SICMOR0305H
        else if(action.equals("SICMOR0305H"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            session.setAttribute( "SZ_TC_GRP", this.SZ_TC_GRP);
            url = "/SICMOR0305HHeader.jsp";
        }
        else if(action.equals("SICMOR0305HMain"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String diaHabAnt = (String)session.getAttribute("diaHabAnt");

            String prefijo=request.getParameter("Prefijo");
            String natcon=request.getParameter("natcon");
            String []bancoAdqArray = request.getParameterValues("bancoAdq");
            String bancoAdq="";
            for(String banco:bancoAdqArray){
                if(!bancoAdq.equals(""))
                    bancoAdq+=",";
                bancoAdq+=banco;
            }
          String []bancoEmiArray = request.getParameterValues("bancoEmi");
            String bancoEmi="";
            for(String banco:bancoEmiArray){
                if(!bancoEmi.equals(""))
                    bancoEmi+=",";
                bancoEmi+=banco;
            }
           String []tipoTransArray = request.getParameterValues("tipoTransac");
            String tipoTrans="";
            for(String tipo:tipoTransArray){
                if(!tipoTrans.equals(""))
                    tipoTrans+=",";
                tipoTrans+=tipo;
            }
           String []tipoLiquidacionArray = request.getParameterValues("tipoLiquidacion");
        String tipoLiquidacion="";
        for(String tipo:tipoLiquidacionArray){
            if(!tipoLiquidacion.equals(""))
                tipoLiquidacion+=",";
            tipoLiquidacion+=tipo;
        }

            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "bancoAdq", bancoAdq);
            session.setAttribute( "bancoEmi", bancoEmi);
            session.setAttribute( "tipoTransac", tipoTrans);
            session.setAttribute( "tipoLiquidacion", tipoLiquidacion);
            session.setAttribute("prefijo", prefijo);
            session.setAttribute("natcon", natcon);

            try
            {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                try
                {
                    if(format.parse(initDate).compareTo(format.parse(diaHabAnt7Historico))<=0 && format.parse(endDate).compareTo(format.parse(diaHabAnt7Historico))<=0)
                    {
                        url = value.valida(session, initDate, endDate, "Sicmor0305H");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    else
                        url = "/fechasInvalidas.jsp?noPantalla=5";
                }
                catch(Exception ex)
                {
                    throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                }
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte SICMIR0054
        else if(action.equals("SICMIR0054"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIR0054Header.jsp";
        }
        else if(action.equals("SICMIR0054Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []bancoEmiArray = request.getParameterValues("bancoEmi");
            String []archivos = request.getParameterValues("archivoEmi");
            String bancoEmi="";
                                for(String banco:bancoEmiArray){
                                    if(!bancoEmi.equals(""))
                                        bancoEmi+=",";
                                    bancoEmi+=banco;
                                }

             String archivo="";
                                for(String arch:archivos){
                                    if(!archivo.equals(""))
                                        archivo+=",";
                                    archivo+=arch;
                                }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "bancoEmi", bancoEmi);
            session.setAttribute( "archivoEmi", archivo);

            try
            {
                url = value.valida(session, initDate, endDate, "Sicmir0054");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte SICMIRB054
        else if(action.equals("SICMIRB054"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIRB054Header.jsp";
        }
        else if(action.equals("SICMIRB054Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []bancoAdqArray = request.getParameterValues("bancoAdq");
            String []archivos = request.getParameterValues("archivoAdq");
            String bancoAdq="";
                                for(String banco:bancoAdqArray){
                                    if(!bancoAdq.equals(""))
                                        bancoAdq+=",";
                                    bancoAdq+=banco;
                                }

             String archivo="";
                                for(String arch:archivos){
                                    if(!archivo.equals(""))
                                        archivo+=",";
                                    archivo+=arch;
                                }
session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "bancoAdq", bancoAdq);
            session.setAttribute( "archivo", archivo);

            try
            {
                url = value.valida(session, initDate, endDate, "Sicmirb054");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte 0050
        else if(action.equals("SICLIR0050"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0050Header.jsp";
        }
        else if(action.equals("SICLIR0050Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String agrupacion=request.getParameter("agrupacion");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);
            session.setAttribute("agrupacion",agrupacion);
            try
            {
                session.setAttribute("txtfStartDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("txtfEndDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                url = value.valida(session, initDate, endDate, "Siclir0050");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(ParseException pe){
                pe.printStackTrace();
            }
        }

        //Reporte D050
        else if(action.equals("SICLIRD050"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRD050Header.jsp";
        }
        else if(action.equals("SICLIRD050Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String agrupacion=request.getParameter("agrupacion");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);
            session.setAttribute("agrupacion",agrupacion);
            try
            {
                session.setAttribute("txtfStartDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("txtfEndDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                url = value.valida(session, initDate, endDate, "Siclird050");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(ParseException pe){
                pe.printStackTrace();
            }
        }


         //Reporte 0100
        else if(action.equals("SICLIR0100"))
        {
            url = "/SICLIR0100Header.jsp";
        }
        else if(action.equals("SICLIR0100Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");

            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);

            try
            {
                session.setAttribute("txtfStartDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("txtfEndDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                url = value.valida(session, initDate, endDate, "Siclir0100");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(ParseException pe){
                pe.printStackTrace();
            }
        }


          //Reporte 0060
        else if(action.equals("SICLIR0060"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0060Header.jsp";
        }
        else if(action.equals("SICLIR0060Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);

            try
            {
                session.setAttribute("txtfStartDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("txtfEndDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                url = value.valida(session, initDate, endDate, "Siclir0060");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(ParseException pe){
                pe.printStackTrace();
            }
        }

        //Reporte D060
        else if(action.equals("SICLIRD060"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRD060Header.jsp";
        }
        else if(action.equals("SICLIRD060Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);

            try
            {
                session.setAttribute("txtfStartDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("txtfEndDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                url = value.valida(session, initDate, endDate, "Siclird060");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(ParseException pe){
                pe.printStackTrace();
            }
        }



         //Reporte 0087
        else if(action.equals("SICLIR0087"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0087Header.jsp";
        }
        else if(action.equals("SICLIR0087Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String natCont = request.getParameter("natCont");

            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "natCont", natCont);

            try
            {
                session.setAttribute("txtfStartDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("txtfEndDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                url = value.valida(session, initDate, endDate, "Siclir0087");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(ParseException pe){
                pe.printStackTrace();
            }
        }

        //Reporte D087
        else if(action.equals("SICLIRD087"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRD087Header.jsp";
        }
        else if(action.equals("SICLIRD087Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String natCont = request.getParameter("natCont");

            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "natCont", natCont);

            try
            {
                session.setAttribute("txtfStartDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("txtfEndDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                url = value.valida(session, initDate, endDate, "Siclird087");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(ParseException pe){
                pe.printStackTrace();
            }
        }


         //Reporte 0077
        else if(action.equals("SICLIR0077"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0077Header.jsp";
        }
         /*#Marca de cambio:  SAS-DRT B-54-2904-15  Inicia Modificación #  */            
        else if(action.equals("SICLIR0077Main"))
        {
            //SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String natCont = request.getParameter("natCont");
            String agrDia=(request.getParameter("agrDia")==null?"false":"true");
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "natCont", natCont);
            session.setAttribute( "agrDia", agrDia);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclir0077");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
/*#Marca de cambio:  SAS-DRT B-54-2904-15  FIN Modificación #  */

        //Reporte SICLIRD077
        else if(action.equals("SICLIRD077"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRD077Header.jsp";
        }
        else if(action.equals("SICLIRD077Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String natCont = request.getParameter("natCont");

            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "natCont", natCont);

            try
            {
                url = value.valida(session, initDate, endDate, "Siclird077");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }


        //Reporte 0090
        else if(action.equals("SICLIR0090"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0090Header.jsp";
        }
        else if(action.equals("SICLIR0090Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);
            try
            {
                session.setAttribute("txtfStartDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("txtfEndDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                url = value.valida(session, initDate, endDate, "Siclir0090");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(ParseException pe){
                pe.printStackTrace();
            }
        }

         //Reporte 0105
        else if(action.equals("SICLIR0105"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0105Header.jsp";
        }
        else if(action.equals("SICLIR0105Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);
            try
            {
                session.setAttribute("txtfStartDatePrev", format.format(TimeUtils.getDiaHabilAnt(session, format.parse(initDate))));
                session.setAttribute("txtfEndDatePrev", format.format(TimeUtils.getDiaHabilAnt(session, format.parse(endDate))));
                url = value.valida(session, initDate, endDate, "Siclir0105");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(ParseException pe){
                pe.printStackTrace();
            }
        }

        //Reporte B450
        else if(action.equals("SICMIRB450"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIRB450Header.jsp";
        }
        else if(action.equals("SICMIRB450Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String bancoAdq = request.getParameter("bancoAdq");
            String []bancoAdqArray = request.getParameterValues("bancoAdq");
            String bancoAdq="";
            for(String banco:bancoAdqArray){
                if(!bancoAdq.equals(""))
                    bancoAdq+=",";
                bancoAdq+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "bancoAdq", bancoAdq);
            SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
            try
            {
                session.setAttribute("initDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("endDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                url = value.valida(session, initDate, endDate, "Sicmirb450");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
            catch(ParseException pe){
                pe.printStackTrace();
            }
        }

        //Reporte 0450
        else if(action.equals("SICMIR0450"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIR0450Header.jsp";
        }
        else if(action.equals("SICMIR0450Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String bancoAdq = request.getParameter("bancoAdq");
            String []bancoAdqArray = request.getParameterValues("bancoAdq");
            String bancoAdq="";
            for(String banco:bancoAdqArray){
                if(!bancoAdq.equals(""))
                    bancoAdq+=",";
                bancoAdq+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "bancoAdq", bancoAdq);
            SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
            try
            {
                session.setAttribute("initDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("endDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                url = value.valida(session, initDate, endDate, "Sicmir0450");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
            catch(ParseException pe){
                pe.printStackTrace();
            }
        }

        //Reporte 0340
        else if(action.equals("SICMIR0340"))
        {
        session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            session.setAttribute( "PRSA_TIPOS_TRANSACCION", this.PRSA_TIPOS_TRANSACCION );
            url = "/SICMIR0340Header.jsp";
        }
        else if(action.equals("SICMIR0340Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            //String proceso = request.getParameter("proceso");
            String tipo = request.getParameter("tipo");


         String []bancolst = request.getParameterValues("banco");
            String banco="";
            for(String banco1:bancolst){
                if(!banco.equals(""))
                    banco+=",";
                banco+=banco1;
            }

            String []procesos = request.getParameterValues("proceso");
            String proceso="";
            for(String proceso1:procesos){
                if(!proceso.equals(""))
                    proceso+="','";
                proceso+=proceso1;
            }

            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("banco", banco);
            session.setAttribute("proceso", proceso);
            session.setAttribute("tipo", tipo);

            url = "/reportsjsp/managerReports.jsp"+"?report="+"Sicmir0340";
            viewerManager.setUpViewer(this, request, response, url);
            isAnswerReport=true;
        }


// Inicia cambio P-52-2452-14 German Gonzalez 30/07/2014
        //Reporte 0350
        else if(action.equals("SICMOR0350"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMOR0350Header.jsp";
        }
        else if(action.equals("SICMOR0350Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String ver=request.getParameter("ver");


        String []bancoAdqArray = request.getParameterValues("bancoAdq");
        String bancoAdq="";
        for(String banco:bancoAdqArray){
            if(!bancoAdq.equals(""))
                bancoAdq+=",";
            bancoAdq+=banco;
        }

            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "bancoAdq", bancoAdq);
            session.setAttribute( "ver", ver);
            try
            {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                try
                {
                        url = value.valida(session, initDate, endDate, "Sicmor0350");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                }
                catch(Exception ex)
                {
                    throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                }
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
// Fin cambio P-52-2452-14 German Gonzalez 30/07/2014


        //Reporte 0340
        else if(action.equals("SICMOR0340"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMOR0340Header.jsp";
        }
        else if(action.equals("SICMOR0340Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
/*#Marca de cambio:  SAS-DRT B-54-2904-15  Inicio  Modificación             #  */
	    String []bancosAdq = request.getParameterValues("bancoAdq");
            String bancosAdqStr="";
            for(String bancoAdq:bancosAdq){
                if(!bancosAdqStr.equals(""))
                    bancosAdqStr+=",";
                bancosAdqStr+=bancoAdq;
            }
	    session.setAttribute( "bancoAdq", bancosAdqStr);
/*#Marca de cambio:  SAS-DRT B-54-2904-15  Final  Modificación             #  */
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);
            try
            {
                url = value.valida(session, initDate, endDate, "Sicmor0340");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte 0461
        else if(action.equals("SICLIR0461"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0461Header.jsp";
        }
        else if(action.equals("SICLIR0461Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            try
            {
                Oparticiones(initDate, endDate);
                url = value.valida(session, initDate, endDate, "Siclir0461");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
    /*  ---------------------------------------------------------------------------------
    -- Marca del Cambio : SAS-LERC-F-52-2173-15 Inicia la Modificacion Reporte 0462   25/02/2015
    ---------------------------------------------------------------------------------*/
        else if(action.equals("SICLIR0462"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICLIR0462Header.jsp";
                }
                else if(action.equals("SICLIR0462Main"))
                {
                    SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String []bancoAdqArray = request.getParameterValues("bancoAdq");
                    String bancoAdq="";
                    for(String banco:bancoAdqArray){
                        if(!bancoAdq.equals(""))
                            bancoAdq+=",";
                        bancoAdq+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute( "txtfStartDate", initDate);
                    session.setAttribute( "txtfEndDate", endDate);
                    session.setAttribute( "bancoAdq", bancoAdq);
                    try
                    {
                        Oparticiones(initDate, endDate);
                        url = value.valida(session, initDate, endDate, "Siclir0462");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }
/*  ---------------------------------------------------------------------------------
    -- Marca del Cambio : SAS-LERC-F-52-2173-15 Fin de la Modificacion Reporte 0462  25/02/2015
    ---------------------------------------------------------------------------------*/

        //Reporte 0461H
        else if(action.equals("SICLIR0461H"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0461HHeader.jsp";
        }
        else if(action.equals("SICLIR0461HMain"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            try
            {
                Oparticiones(initDate, endDate);
                url = value.valida(session, initDate, endDate, "Siclir0461H");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte 0310
        else if(action.equals("SICLIR0310"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0310Header.jsp";
        }
        else if(action.equals("SICLIR0310Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");


            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String agrupacion=request.getParameter("agrupacion");
            String []bancos = request.getParameterValues("banco");
            String []archivoBanco = request.getParameterValues("archivoBanco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }

            String archivoBancoStr="";
            for(String banco:archivoBanco){
                if(!archivoBancoStr.equals(""))
                    archivoBancoStr+=",";
                archivoBancoStr+=banco;
            }

            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);
            session.setAttribute( "archivoBanco", archivoBancoStr);
            session.setAttribute("agrupacion",agrupacion);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclir0310");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte D310
        else if(action.equals("SICLIRD310"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRD310Header.jsp";
        }
        else if(action.equals("SICLIRD310Main"))
        {
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");


            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String agrupacion=request.getParameter("agrupacion");
            String []bancos = request.getParameterValues("banco");
            String []archivoBanco = request.getParameterValues("archivoBanco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }

            String archivoBancoStr="";
            for(String banco:archivoBanco){
                if(!archivoBancoStr.equals(""))
                    archivoBancoStr+=",";
                archivoBancoStr+=banco;
            }

            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);
            session.setAttribute( "archivoBanco", archivoBancoStr);
            session.setAttribute("agrupacion",agrupacion);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclird310");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        else if(action.equals("delModGrpSacii") || action.equals("modGrpSacii")) {
            session.setAttribute("GRUPO_SACII", SZ_TC_GRP);
            url = "/delModSacii.jsp";
        } else if(action.equals("lstGrpSacii")) {
            session.setAttribute("GRUPO_SACII", SZ_TC_GRP);
            url = "/lstGrpSaciiHeader.jsp";
        }else if(action.equals("lstGrpSaciiMain")) {
            session.setAttribute("GRUPO_SACII", this.SZ_TC_GRP);
            url = "/lstGrpSaciiMain.jsp";
        }

        else if(action.equals("tipocambio"))
        {
            url = "/tipocambioHeader.jsp";
        }
        else if(action.equals("tipocambioMain"))
        {
            url = "/tipocambioMain.jsp";
        }
        //Modificacion: Marca de inicio IDSYS-CMDELCR-  N-08-2033-13 30/08/2013
        else if(action.equals("Miscelaneos"))
        {
            url = "/MiscelaneosHeader.jsp";
        }
        else if(action.equals("errorMisc"))
        {
            url = "/Miscelaneos.jsp";
        }
        //Modificacion: Marca de termino IDSYS-CMDELCR-  N-08-2033-13 30/08/2013

      /* Inicia cambio C-04-3035-13 */
      else if(action.equals("cierreDifCuotas"))
        {
            url = "/cierreDifCuotasHeader.jsp";
        }
        else if(action.equals("cierreDifCuotasMain"))
        {
            url = "/cierreDifCuotasMain.jsp";
        }
      /* Termina cambio C-04-3035-13*/

        //Siclir0470
        else if(action.equals("SICLIR0470"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0470Header.jsp";
        }
        else if(action.equals("SICLIR0470Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            //String endDate = request.getParameter("txtfEndDate");
            //String bancoEmi = request.getParameter("bancoEmi");
            String []bancoSocioArray = request.getParameterValues("banco");
            String bancosSocios="";
            for(String banco:bancoSocioArray){
                if(!bancosSocios.equals(""))
                    bancosSocios+=",";
                bancosSocios+=banco;
            }
            /*String []tipoLiqArray = request.getParameterValues("tipoLiq");
            String tiposLiq="";
            for(String tipoLiq:tipoLiqArray){
                if(!tiposLiq.equals(""))
                    tiposLiq+=",";
                tiposLiq+=tipoLiq;
            }*/
            String anio=request.getParameter("anio");
            String folio=request.getParameter("folio");
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            //session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("banco", bancosSocios);
            //session.setAttribute("tipoLiq", tiposLiq);
            session.setAttribute("anio", anio);
            session.setAttribute("folio", folio);
            try
            {
                url = value.valida(session, initDate, initDate, "Siclir0470");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

                /* Modificacion: Marca de inicio SAS-MEVP P-02-0216-12  */
// Reporte Mxvrtda001
    else if(action.equals("Mxvrtda001"))
            {

                url = "/reportsjsp/CCA/Mxvrtda001Header.jsp";
            }

            else if(action.equals("Mxvrtda001Main"))
            {
                String initDate = request.getParameter("txtfStartDate");
                String endDate = request.getParameter("txtfEndDate");
                String []AdquirenteArreglo = request.getParameterValues("Adquirente");
/* Modificacion: Marca de inicio SAS-DRT-P-20-0096-15  */
                String tasaMxvrtda=(request.getParameter("tasaMxvrtda")==null?"false":"true");                
                String AdquirenteStr="";
                for(String Adquirente:AdquirenteArreglo){
                    if(!AdquirenteStr.equals(""))
                        AdquirenteStr+=",";
                    AdquirenteStr+=Adquirente;
                }
                String []EmisorArreglo = request.getParameterValues("Emisor");
                String EmisorStr="";
                for(String Emisor:EmisorArreglo){
                    if(!EmisorStr.equals(""))
                        EmisorStr+=",";
                    EmisorStr+=Emisor;
                }
                session.setAttribute("tasaMxvrtda",tasaMxvrtda);
/* Modificacion: Marca de fin SAS-DRT-P-20-0096-15  */

                session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                session.setAttribute("initDate", initDate);
                session.setAttribute("endDate", endDate);
                session.setAttribute("Adquiriente", AdquirenteStr);
                session.setAttribute("Emisor", EmisorStr);



                try
                {
                        url = value.valida(session, initDate, endDate, "Mxvrtda001");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                catch (WellException e)
                    {
                        e.printStackTrace();
                    }

            }
// Reporte Mxvrtac001
else if(action.equals("Mxvrtac001"))
            {

                url = "/reportsjsp/CCA/Mxvrtac001Header.jsp";
            }


            else if(action.equals("Mxvrtac001Main"))
            {
                String initDate = request.getParameter("txtfStartDate");
                String endDate = request.getParameter("txtfEndDate");
                String []AdquirenteArreglo = request.getParameterValues("Adquirente");
/* Modificacion: Marca de Inicio SAS-DRT-P-20-0096-15  */
                String tasaMxvrtac=(request.getParameter("tasaMxvrtac")==null?"false":"true");
                String AdquirenteStr="";
                for(String Adquirente:AdquirenteArreglo){
                    if(!AdquirenteStr.equals(""))
                        AdquirenteStr+=",";
                    AdquirenteStr+=Adquirente;

                }
                String []EmisorArreglo = request.getParameterValues("Emisor");
                String EmisorStr="";
                for(String Emisor:EmisorArreglo){
                    if(!EmisorStr.equals(""))
                        EmisorStr+=",";
                    EmisorStr+=Emisor;
                }
                session.setAttribute( "tasaMxvrtac", tasaMxvrtac);
/* Modificacion: Marca de fin SAS-DRT-P-20-0096-15  */
                session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                session.setAttribute("initDate", initDate);
                session.setAttribute("endDate", endDate);
                session.setAttribute("Adquiriente", AdquirenteStr);
                session.setAttribute("Emisor", EmisorStr);






                try
                {
                        url = value.valida(session, initDate, endDate, "Mxvrtac001");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                catch (WellException e)
                    {
                        e.printStackTrace();
                    }

            }
/* Modificacion: Marca de fin SAS-MEVP P-02-0216-12 */

/*  Modificacion: Marca de inicio SAS-JPLC P-53-2934-14 */
/*  Modificacion: Marca de inicio SAS-JPM P-53-2934-14 */
        else if(action.equals("SICLMNIR01")) {
            url = "/SICLMNIR01Header.jsp";
        }else if(action.equals("SICLMNIR01Main")) {
            ComboBox comborpln = new ComboBox();
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String marcas = request.getParameter("cmbMarcas");
            String institucion = "";
            String instituciones[] = request.getParameterValues("cmbInst");
            for(String ins : instituciones) {
                if(!institucion.equals(""))
                    institucion += ", ";
                institucion += ins;
            }
            String pcMarcas = comborpln.getMarcasCaratula(session, marcas);
            session.setAttribute("PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute("PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("cmbMarcas", marcas);
            session.setAttribute("cmbInst", institucion);
            session.setAttribute("pcMarcas", pcMarcas);
            try {
                url = value.valida(session, initDate, endDate, "SICLMNIR01");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }catch (WellException e) {
                e.printStackTrace();
            }
        }else if(action.equals("SICLMNPR01")) {
            url = "/SICLMNPR01Header.jsp";
        }else if(action.equals("SICLMNPR01Main")) {
            ComboBox comborpln = new ComboBox();
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String marcas = request.getParameter("cmbMarcas");
            String institucion = "";
            String instituciones[] = request.getParameterValues("cmbInst");
            for(String ins : instituciones) {
                if(!institucion.equals(""))
                    institucion += ", ";
                institucion += ins;
            }
            String pcMarcas = comborpln.getMarcasCaratula(session, marcas);
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("cmbMarcas", marcas);
            session.setAttribute("cmbInst", institucion);
            session.setAttribute("pcMarcas", pcMarcas);
            try {
                url = value.valida(session, initDate, endDate, "SICLMNPR01");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }catch (WellException e) {
                e.printStackTrace();
            }
        }else if(action.equals("SICLMNTT01")) {
            url = "/SICLMNTT01Header.jsp";
        }else if(action.equals("SICLMNTT01Main")) {
            ComboBox comborpln = new ComboBox();
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String marcas = request.getParameter("cmbMarcas");
            String liquidacion = "";
            String liquidaciones[] = request.getParameterValues("cmbLiq");
            for(String ins : liquidaciones) {
                if(!liquidacion.equals(""))
                    liquidacion += ", ";
                liquidacion += ins;
            }
            String pcMarcas = comborpln.getMarcasCaratula(session, marcas);
            String pcLiquidacion = comborpln.getLiquidacionCaratula(session, liquidacion);
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("cmbMarcas", marcas);
            session.setAttribute("cmbLiq", liquidacion);
            session.setAttribute("pcMarcas", pcMarcas);
            session.setAttribute("pcLiquidacion", pcLiquidacion);
            try {
                url = value.valida(session, initDate, endDate, "SICLMNTT01");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }catch (WellException e) {
                e.printStackTrace();
            }
        }
/*  Modificacion: Marca de fin SAS-JPM P-53-2934-14 */
/*  Modificacion: Marca de fin SAS-JPLC P-53-2934-14 */

        //Reporte 0150
        else if(action.equals("SICLIR0150"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0150Header.jsp";
        }
        else if(action.equals("SICLIR0150Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String bancoEmi = request.getParameter("bancoEmi");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("banco", bancosStr);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclir0150");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }//Reporte 0160
        else if(action.equals("SICLIR0160"))
        {
            url = "/SICLIR0160Header.jsp";
        }
        else if(action.equals("SICLIR0160Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclir0160");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
        //Reporte 0170
        else if(action.equals("SICLIR0170"))
        {
            url = "/SICLIR0170Header.jsp";
        }
        else if(action.equals("SICLIR0170Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String moneda = request.getParameter("moneda");
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("moneda", moneda);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclir0170");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
        //Reporte 0180
        else if(action.equals("SICLIR0180"))
        {
            url = "/SICLIR0180Header.jsp";
        }
        else if(action.equals("SICLIR0180Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclir0180");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte D180
        else if(action.equals("SICLIRD180"))
        {
            url = "/SICLIRD180Header.jsp";
        }
        else if(action.equals("SICLIRD180Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclird180");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte 0145
        else if(action.equals("SICMIR0145"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIR0145Header.jsp";
        }
        else if(action.equals("SICMIR0145Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String bancoEmi = request.getParameter("bancoEmi");
            String []bancoAdqArray = request.getParameterValues("bancoAdq");
            String bancosAdq="";
            for(String banco:bancoAdqArray){
                if(!bancosAdq.equals(""))
                    bancosAdq+=",";
                bancosAdq+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoAdq", bancosAdq);
            try
            {
                url = value.valida(session, initDate, endDate, "Sicmir0145");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
        //Reporte 0145MC
        else if(action.equals("SICMIR0145MC"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIR0145MCHeader.jsp";
        }
        else if(action.equals("SICMIR0145MCMain"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String bancoEmi = request.getParameter("bancoEmi");
            String []bancoAdqArray = request.getParameterValues("bancoAdq");
            String bancosAdq="";
            for(String banco:bancoAdqArray){
                if(!bancosAdq.equals(""))
                    bancosAdq+=",";
                bancosAdq+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoAdq", bancosAdq);
            try
            {
                url = value.valida(session, initDate, endDate, "Sicmir0145mc");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte B145
        else if(action.equals("SICMIRB145"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIRB145Header.jsp";
        }
        else if(action.equals("SICMIRB145Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String outg = request.getParameter("outg");
            String []bancoAdqArray = request.getParameterValues("bancoAdq");
            String bancosAdq="";
            for(String banco:bancoAdqArray){
                if(!bancosAdq.equals(""))
                    bancosAdq+=",";
                bancosAdq+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoAdq", bancosAdq);
            session.setAttribute("outg", outg);
            try
            {
                url = value.valida(session, initDate, endDate, "Sicmirb145");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte 0121
        else if(action.equals("SICMIR0121"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIR0121Header.jsp";
        }
        else if(action.equals("SICMIR0121Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String bancoEmi = request.getParameter("bancoEmi");
            String []bancoSocioArray = request.getParameterValues("bancoSocio");
            String bancosSocios="";
            for(String banco:bancoSocioArray){
                if(!bancosSocios.equals(""))
                    bancosSocios+=",";
                bancosSocios+=banco;
            }
            String []tipoTxnArray = request.getParameterValues("tipoTxn");
            String tipoTxn="";
            for(String txn:tipoTxnArray){
                if(!tipoTxn.equals(""))
                    tipoTxn+=",";
                tipoTxn+=txn;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoSocio", bancosSocios);
            session.setAttribute("tipoTxn", tipoTxn);
            try
            {
                url = value.valida(session, initDate, endDate, "Sicmir0121");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte B121
        else if(action.equals("SICMIRB121"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIRB121Header.jsp";
        }
        else if(action.equals("SICMIRB121Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String bancoEmi = request.getParameter("bancoEmi");
            String []bancoSocioArray = request.getParameterValues("bancoSocio");
            String bancosSocios="";
            for(String banco:bancoSocioArray){
                if(!bancosSocios.equals(""))
                    bancosSocios+=",";
                bancosSocios+=banco;
            }
            String []tipoTxnArray = request.getParameterValues("tipoTxn");
            String tipoTxn="";
            for(String txn:tipoTxnArray){
                if(!tipoTxn.equals(""))
                    tipoTxn+=",";
                tipoTxn+=txn;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoSocio", bancosSocios);
            session.setAttribute("tipoTxn", tipoTxn);
            try
            {
                url = value.valida(session, initDate, endDate, "Sicmirb121");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte 0122
        else if(action.equals("SICMIR0122"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIR0122Header.jsp";
        }
        else if(action.equals("SICMIR0122Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String bancoEmi = request.getParameter("bancoEmi");
            String []bancoSocioArray = request.getParameterValues("bancoSocio");
            String bancosSocios="";
            for(String banco:bancoSocioArray){
                if(!bancosSocios.equals(""))
                    bancosSocios+=",";
                bancosSocios+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoSocio", bancosSocios);
            try
            {
                url = value.valida(session, initDate, endDate, "Sicmir0122");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte 0122
        else if(action.equals("SICMIRD122"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIRD122Header.jsp";
        }
        else if(action.equals("SICMIRD122Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String bancoEmi = request.getParameter("bancoEmi");
            String []bancoSocioArray = request.getParameterValues("bancoSocio");
            String bancosSocios="";
            for(String banco:bancoSocioArray){
                if(!bancosSocios.equals(""))
                    bancosSocios+=",";
                bancosSocios+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoSocio", bancosSocios);
            try
            {
                url = value.valida(session, initDate, endDate, "Sicmird122");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        else if(action.equals("SICMIRD121"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIRD121Header.jsp";
        }
        else if(action.equals("SICMIRD121Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String bancoEmi = request.getParameter("bancoEmi");
            String []bancoSocioArray = request.getParameterValues("bancoSocio");
            String bancosSocios="";
            for(String banco:bancoSocioArray){
                if(!bancosSocios.equals(""))
                    bancosSocios+=",";
                bancosSocios+=banco;
            }
            String []tipoTxnArray = request.getParameterValues("tipoTxn");
            String tipoTxn="";
            for(String txn:tipoTxnArray){
                if(!tipoTxn.equals(""))
                    tipoTxn+=",";
                tipoTxn+=txn;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoSocio", bancosSocios);
            session.setAttribute("tipoTxn", tipoTxn);
            try
            {
                url = value.valida(session, initDate, endDate, "Sicmird121");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte V140
        else if(action.equals("SICMIRV140"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIRV140Header.jsp";
        }
        else if(action.equals("SICMIRV140Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String bancoEmi = request.getParameter("bancoEmi");
            String []bancoSocioArray = request.getParameterValues("bancoSocio");
            String bancosSocios="";
            for(String banco:bancoSocioArray){
                if(!bancosSocios.equals(""))
                    bancosSocios+=",";
                bancosSocios+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoSocio", bancosSocios);
            try
            {
                url = value.valida(session, initDate, endDate, "Sicmirv140");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

        //Reporte 0126
        else if(action.equals("SICMIR0126"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIR0126Header.jsp";
        }
        else if(action.equals("SICMIR0126Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String banco = request.getParameter("banco");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);

            try
            {
                url = value.valida(session, initDate, endDate, "Sicmir0126");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        //Reporte 0141
        else if(action.equals("SICMIR0141"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIR0141Header.jsp";
        }
        else if(action.equals("SICMIR0141Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String banco = request.getParameter("banco");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);

            try
            {
                url = value.valida(session, initDate, endDate, "Sicmir0141");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        //Reporte 0144
        else if(action.equals("SICMIR0144"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIR0144Header.jsp";
        }
        else if(action.equals("SICMIR0144Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String banco = request.getParameter("banco");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);

            try
            {
                url = value.valida(session, initDate, endDate, "Sicmir0144");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        //Reporte 0142
        else if(action.equals("SICMIR0142"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIR0142Header.jsp";
        }
        else if(action.equals("SICMIR0142Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String banco = request.getParameter("banco");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);

            try
            {
                url = value.valida(session, initDate, endDate, "Sicmir0142");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        //Reporte B142
        else if(action.equals("SICMIRB142"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIRB142Header.jsp";
        }
        else if(action.equals("SICMIRB142Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String banco = request.getParameter("banco");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);

            try
            {
                url = value.valida(session, initDate, endDate, "Sicmirb142");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        //Reporte B126
        else if(action.equals("SICMIRB126"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIRB126Header.jsp";
        }
        else if(action.equals("SICMIRB126Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String banco = request.getParameter("banco");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);

            try
            {
                url = value.valida(session, initDate, endDate, "Sicmirb126");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        //Reporte B141
        else if(action.equals("SICMIRB141"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIRB141Header.jsp";
        }
        else if(action.equals("SICMIRB141Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String banco = request.getParameter("banco");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);

            try
            {
                url = value.valida(session, initDate, endDate, "Sicmirb141");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        //Reporte 0144
        else if(action.equals("SICMIRB144"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIRB144Header.jsp";
        }
        else if(action.equals("SICMIRB144Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String banco = request.getParameter("banco");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);

            try
            {
                url = value.valida(session, initDate, endDate, "Sicmirb144");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        //Reporte 0124
        else if(action.equals("SICMIR0124"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            session.setAttribute( "SZ_TC_GRP", this.SZ_TC_GRP );
            url = "/SICMIR0124Header.jsp";
        }
        else if(action.equals("SICMIR0124Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String banco = request.getParameter("banco");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            String []ttCharbacks = request.getParameterValues("ttCharbacks");
            String ttCharbacksStr="";
            for(String ttCharback:ttCharbacks){
                if(!ttCharbacksStr.equals(""))
                    ttCharbacksStr+=",";
                ttCharbacksStr+=ttCharback;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);
            session.setAttribute( "ttCharbacks", ttCharbacksStr);

            try
            {
                url = value.valida(session, initDate, endDate, "Sicmir0124");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        //Reporte B124
        else if(action.equals("SICMIRB124"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            session.setAttribute( "SZ_TC_GRP", this.SZ_TC_GRP );
            url = "/SICMIRB124Header.jsp";
        }
        else if(action.equals("SICMIRB124Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String banco = request.getParameter("banco");
            String []bancos = request.getParameterValues("bancoSocio");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            String []ttCharbacks = request.getParameterValues("tipoTxn");
            String ttCharbacksStr="";
            for(String ttCharback:ttCharbacks){
                if(!ttCharbacksStr.equals(""))
                    ttCharbacksStr+=",";
                ttCharbacksStr+=ttCharback;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "banco", bancosStr);
            session.setAttribute( "ttCharbacks", ttCharbacksStr);

            try
            {
                url = value.valida(session, initDate, endDate, "Sicmirb124");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        //Reporte 1145
        else if(action.equals("SICMIR1145"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIR1145Header.jsp";
        }
        else if(action.equals("SICMIR1145Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String movimiento = request.getParameter("movimiento");
            String []bancoAdqArray = request.getParameterValues("bancoAdq");
            String bancosAdq="";
            for(String banco:bancoAdqArray){
                if(!bancosAdq.equals(""))
                    bancosAdq+=",";
                bancosAdq+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoAdq", bancosAdq);
            session.setAttribute("movimiento", movimiento);
            try
            {
                url = value.valida(session, initDate, endDate, "Sicmir1145");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
        //Reporte 2145
        else if(action.equals("SICMIR2145"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICMIR2145Header.jsp";
        }
        else if(action.equals("SICMIR2145Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String movimiento = request.getParameter("movimiento");
            String []bancoAdqArray = request.getParameterValues("bancoAdq");
            String bancosAdq="";
            for(String banco:bancoAdqArray){
                if(!bancosAdq.equals(""))
                    bancosAdq+=",";
                bancosAdq+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoAdq", bancosAdq);
            session.setAttribute("movimiento", movimiento);
            try
            {
                url = value.valida(session, initDate, endDate, "Sicmir2145");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
        //Reporte SICLIRB150
        else if(action.equals("SICLIRB150"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRB150Header.jsp";
        }
        else if(action.equals("SICLIRB150Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String bancoEmi = request.getParameter("bancoEmi");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("banco", bancosStr);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclirb150");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

/*Inicia Modificacion WELLCOM Z-09-2573-12 Alta BIN 50623 para OPAM*/
        //Reporte 0110 OPAM
        else if(action.equals("SICLIR0110OPAM"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0110OPAMHeader.jsp";
        }
        else if(action.equals("SICLIR0110OPAMMain"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String bancoAdq = request.getParameter("bancoAdq");
            String []bancoAdqArray = request.getParameterValues("bancoAdq");
            String bancoAdq="";
            for(String banco:bancoAdqArray){
                if(!bancoAdq.equals(""))
                    bancoAdq+=",";
                bancoAdq+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "bancoAdq", bancoAdq);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclir0110OPAM");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }

                //Reporte 0110OPAMH
        else if(action.equals("SICLIR0110OPAMH"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0110OPAMHHeader.jsp";
        }
        else if(action.equals("SICLIR0110OPAMHMain"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String bancoAdq = request.getParameter("bancoAdq");
            String []bancoAdqArray = request.getParameterValues("bancoAdq");
            String bancoAdq="";
            for(String banco:bancoAdqArray){
                if(!bancoAdq.equals(""))
                    bancoAdq+=",";
                bancoAdq+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute( "txtfStartDate", initDate);
            session.setAttribute( "txtfEndDate", endDate);
            session.setAttribute( "bancoAdq", bancoAdq);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclir0110OPAMH");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
/*Fin Modificacion WELLCOM Z-09-2573-12 Alta BIN 50623 para OPAM*/

        // SICLIRB170
        else if(action.equals("SICLIRB170"))
        {
            url = "/SICLIRB170Header.jsp";
        }
        else if(action.equals("SICLIRB170Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String moneda = request.getParameter("moneda");
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("moneda", moneda);

            try
            {
                url = value.valida(session, initDate, endDate, "Siclirb170");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
        // SICLIRB180
        else if(action.equals("SICLIRB180"))
        {
            url = "/SICLIRB180Header.jsp";
        }
        else if(action.equals("SICLIRB180Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclirb180");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
            }
      //Reporte SICLIRD150
        else if(action.equals("SICLIRD150"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRD150Header.jsp";
        }
        else if(action.equals("SICLIRD150Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            //String bancoEmi = request.getParameter("bancoEmi");
            String []bancos = request.getParameterValues("banco");
            String bancosStr="";
            for(String banco:bancos){
                if(!bancosStr.equals(""))
                    bancosStr+=",";
                bancosStr+=banco;
            }
            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("banco", bancosStr);
            try
            {
                url = value.valida(session, initDate, endDate, "Siclird150");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
        // SICLIRD170
        else if(action.equals("SICLIRD170"))
        {
            url = "/SICLIRD170Header.jsp";
        }
        else if(action.equals("SICLIRD170Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String moneda = request.getParameter("moneda");
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("moneda", moneda);

            try
            {
                url = value.valida(session, initDate, endDate, "Siclird170");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
// Inicia marca de cambio wellcom P-06-2233-13
        // GSOF-MVR-B-54-2092-15 Marca de Inicio
        else{
            ParametrosCompartidos pC2=new ParametrosCompartidos();
            pC2.setUrl(url);
            pC2.setIsAnswerReport(isAnswerReport);
            processRequestContinua2(request, response,pC2);
            url=pC2.getUrl();
            isAnswerReport=pC2.getIsAnswerReport();

        }
        pC.setUrl(url);
        pC.setIsAnswerReport(isAnswerReport);
        // GSOF-MVR-B-54-2092-15 Marca de Inicio

     // Fin marca de cambio wellcom P-06-2233-13
    }

    // GSOF-MVR-B-54-2092-15 Marca de Inicio
    @SuppressWarnings("unchecked")
    protected void processRequestContinua2(HttpServletRequest request, HttpServletResponse response,ParametrosCompartidos pC)
    throws ServletException, IOException, WellException, JDOMException, ParseException {
        String action ;
        String parameter;
//        String url ;
        Validador value;
        //fiidManager  inicia = new fiidManager();
//        boolean isAnswerReport;
        String diaHabAnt7;
        String diaHabAnt7Historico;
        SimpleDateFormat formato1= new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formato2= new SimpleDateFormat("MM/dd/yyyy");
        String fechaHoy;
            String horaHoy;
        Date fechaAnterior = new Date();

        /**
         * Action Management
         */
        SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");

        Date fechaActual = new Date();
        long fechaAntes = fechaAnterior.getTime() - 8*(24*60*60*1000);
        long fechaAntesHistorico = fechaAnterior.getTime() - 1*(24*60*60*1000);

        SimpleDateFormat formatoHora= new SimpleDateFormat("HH:mm:ss");
        horaHoy = formatoHora.format(fechaActual);
        session.setAttribute( "horaHoy", horaHoy);

        diaHabAnt7 = formato.format(fechaAntes);
        diaHabAnt7Historico = formato.format(fechaAntesHistorico);
        action = request.getParameter("action");
        parameter = null;
        String url = pC.getUrl();
        value = new Validador();
        //fiidManager  inicia = new fiidManager();
        boolean isAnswerReport=pC.getIsAnswerReport();

        if(action.equals("SICLIRPA01"))
        {
            Collection                  listado             = new ArrayList();
            String                      accion              = "";
            String                      feIni               = "";
            String                      feFin               = "";
            SICLIRPA01DAO               modelo              = new SICLIRPA01DAO();
            Collection                  resultados          = new ArrayList();
            SimpleDateFormat            formatoFecha        = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date               fechaIni            = null;
            java.sql.Date               fechaFin            = null;
            Calendar                    currenttime         = Calendar.getInstance();
            SICLIRPA01Form              forma               = new SICLIRPA01Form();
            String                      grupo               = (String)session.getAttribute("role");
            String                      rutaReportes        = getServletContext().getRealPath("reports");
            String                      rutaImagenes        = getServletContext().getRealPath("pics");
            ImageIcon                   icono               = new ImageIcon(rutaImagenes + "/logoProsa.png");
            FileInputStream             fis                 = null;
            BufferedInputStream         bufferedInputStream = null;
            JasperReport                reporte             = null;
            JRBeanCollectionDataSource  dsR                 = null;
            JasperPrint                 jasperPrint         = null;
            JRExporter                  exportador          = null;
            ServletOutputStream         servletOutputStream = null;
            Map                         parametros          = new HashMap();
            String                      usuario             = (String)session.getAttribute("login");
            String                      formatoSalida       = null;
            ByteArrayOutputStream       baos                = new ByteArrayOutputStream();

            url = "/SICLIRPA01.jsp";

            // OBTIENE LA FECHA ACTUAL, ZONA HORARIA DE MEXICO
            currenttime.setTimeZone(TimeZone.getTimeZone("GMT-06:00"));

            // OBTIENE LA FECHA DEFAULT DE INICIO Y FIN
            // FIN ES LA FECHA ACTUAL, INICIO ES UN MES ATRAS
            fechaFin = new java.sql.Date((currenttime.getTime()).getTime());
            currenttime.add(Calendar.MONTH, -1);
            fechaIni = new java.sql.Date((currenttime.getTime()).getTime());

            accion = request.getParameter("accion");

            if(accion == null){accion = "";}

            // LA ACCION ES BLANCO, INICIALIZA
            if("".compareTo(accion) == 0){
                feIni = formatoFecha.format(fechaIni);
                feFin = formatoFecha.format(fechaFin);
                // PONE LOS DATOS EN BLANCO
                // DATOS ELEGIDOS MAS LISTADO OBTENIDO
                forma.setAccion(      "1");
                forma.setFechaInicio( feIni);
                forma.setFechaFinal(  feFin);
                session.setAttribute("datos", forma);
            // LA ACCION ES 0, CANCELAR
            }else if("0".compareTo(accion) == 0){
                url = "/index.jsp";
            }else{
                try{
                    fis                         = new FileInputStream(rutaReportes + "/SICLIRPA01.jasper");
                    bufferedInputStream         = new BufferedInputStream(fis);
                    reporte                     = (JasperReport) JRLoader.loadObject(bufferedInputStream);

                    // PONE LOS CRITERIOS
                    parametros.put("logo",      icono.getImage());
                    parametros.put("usuario",   usuario);
                    parametros.put("ini",       request.getParameter("fechaInicio"));
                    parametros.put("fin",       request.getParameter("fechaFinal"));

                    formatoSalida = request.getParameter("formato");
                    // HTML
                    if("0".compareTo(formatoSalida) == 0){
                        parametros.put("titulo",    new Integer(1));
                    // EXCEL
                    }else if("1".compareTo(formatoSalida) == 0){
                        parametros.put("titulo",    new Integer(0));
                    // PDF
                    }else{
                        parametros.put("titulo",    new Integer(1));
                    }

                    if(logger != null){
                        logger.info(session.getId()+":"+"El usuario " + this.session.getAttribute("login").toString() +
                                " genero el reporte SICLIRPA01 con parametros:FechaIni["+
                                request.getParameter("fechaInicio") + "],FechaFin[" + request.getParameter("fechaFinal") + "]");
                    }

                    // GENERA EL REPORTE
                    resultados  = modelo.consultaSICLIRPA01(request.getParameter("fechaInicio"), request.getParameter("fechaFinal"));
                    dsR         = new JRBeanCollectionDataSource(resultados);
                    jasperPrint = JasperFillManager.fillReport(reporte, parametros, dsR);

                    request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

                    response.setHeader("Pragma",        "no-cache");
                    response.setHeader("Cache-control", "private");
                    response.setDateHeader("Expires",   0);

                    // HTML
                    if("0".compareTo(formatoSalida) == 0){
                        response.setContentType("text/html");
                        response.setHeader("Content-Disposition", "inline; filename=\"SICLIRPA01.html\"");
                        exportador = new JRHtmlExporter();
                        exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                        exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                        exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI,"image?image=");
                        exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                        exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(2.0));
                        exportador.exportReport();
                        servletOutputStream = response.getOutputStream();
                        response.setContentLength(baos.size());
                        baos.writeTo(servletOutputStream);
                    // EXCEL
                    }else if("1".compareTo(formatoSalida) == 0){
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
                    }else{
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
                }catch(Exception ex){
// GSOF-MVR-P-53-2727-14 Marca de Inicio
                    System.out.println(" Error al generar SICCLIRPA01:" + ex);
// GSOF-MVR-P-53-2727-14 Marca de Terminacion
                    ex.printStackTrace();
                }
            }
        }
                //Reporte 0450
        else if(action.equals("SICLIR0450"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIR0450Header.jsp";
        }
// SAS-DRT-P-53-2004-15 Marca de Inicio
        else if(action.equals("SICLIR0450Main"))
        {
            String                      rutaReportes        = getServletContext().getRealPath("reports");
            FileInputStream             fis                 = null;
            BufferedInputStream         bufferedInputStream = null;
            JasperReport                reporte             = null;
            JasperPrint                 jasperPrint         = null;
            JRExporter                  exportador          = null;
            ServletOutputStream         servletOutputStream = null;
            Map                         parametros          = new HashMap();
            String                      usuario             = (String)session.getAttribute("login");
            String                      formatoSalida       = null;
            ByteArrayOutputStream       baos                = new ByteArrayOutputStream();
        String                     rutaImagenes        = getServletContext().getRealPath("pics");
            ImageIcon                   icono               = new ImageIcon(rutaImagenes + "/logoProsa.jpg");
            url = "/SICLIR0450Header.jsp";
            try{
                fis                         = new FileInputStream(rutaReportes + "/siclir0450.jasper");
                bufferedInputStream         = new BufferedInputStream(fis);
                reporte                     = (JasperReport) JRLoader.loadObject(bufferedInputStream);
        String []bancos = request.getParameterValues("banco");
                String bancosStr="";
                for(String banco:bancos){
                        if(!bancosStr.equals(""))
                        bancosStr+=",";
                        bancosStr+=banco;
                }
            parametros.put("ejecuto",session.getAttribute("login").toString());
                    parametros.put("initDate",request.getParameter("txtfStartDate"));
                    parametros.put("endDate",request.getParameter("txtfEndDate"));
            parametros.put("tipoDiferencia",request.getParameter("tipoDif"));
                    parametros.put("banco",bancosStr);
                    parametros.put("logo",icono.getImage());
                    formatoSalida = request.getParameter("formato");
                    if(logger != null){
                        logger.info(session.getId()+":"+"El usuario " + this.session.getAttribute("login").toString() +
                                " genero el reporte SICLIR0450 con parametros:FechaIni["+
                                request.getParameter("txtfStartDate") + "],FechaFin[" + request.getParameter("txtfEndDate") + "]");
                    }
                    // GENERA EL REPORTE
                    jasperPrint = JasperFillManager.fillReport(reporte, parametros, this.con);
                    request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);
                    response.setHeader("Pragma",        "no-cache");
                    response.setHeader("Cache-control", "private");
                    response.setDateHeader("Expires",   0);
                    // HTML
                    if("0".compareTo(formatoSalida) == 0){
                        response.setContentType("text/html");
                        response.setHeader("Content-Disposition", "inline; filename=\"SICLIR0450.html\"");
                        exportador = new JRHtmlExporter();
                        exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                        exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                        exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI,"image?image=");
                        exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                        exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(2.0));
                        exportador.exportReport();
                        servletOutputStream = response.getOutputStream();
                        response.setContentLength(baos.size());
                        baos.writeTo(servletOutputStream);
                    // EXCEL
                    }else if("1".compareTo(formatoSalida) == 0){
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
                    }else{
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
                }catch(Exception ex){
                   logger.info(" Error al generar SICLIR0450:" + ex);
                    ex.printStackTrace();
                }
        }

        /* Inicia cambio C-04-3035-13 */
        //Reporte SICLIF0320
        else if(action.equals("SICLIF0320"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIF0320Header.jsp";
        }
//  -- Marca del Cambio : SAS-DRT-P-53-2004-15 INICIA la Modificacion
        else if(action.equals("SICLIF0320Main"))
        {
        String []tipoEntSalArray = request.getParameterValues("tipoEntSal");
            String tipoEntSal="";
            for(String tipoEntSalTmp:tipoEntSalArray){
                if(!tipoEntSal.equals(""))
                tipoEntSal+=",";
                tipoEntSal+=tipoEntSalTmp;
                }
            String                      rutaReportes        = getServletContext().getRealPath("reports");
            FileInputStream             fis                 = null;
            BufferedInputStream         bufferedInputStream = null;
            JasperReport                reporte             = null;
            JasperPrint                 jasperPrint         = null;
            JRExporter                  exportador          = null;
            ServletOutputStream         servletOutputStream = null;
            Map                         parametros          = new HashMap();
            String                      usuario             = (String)session.getAttribute("login");
            String                      formatoSalida       = null;
            ByteArrayOutputStream       baos                = new ByteArrayOutputStream();
        String                     rutaImagenes        = getServletContext().getRealPath("pics");
            ImageIcon                   icono               = new ImageIcon(rutaImagenes + "/logoProsa.jpg");
            url = "/SICLIF0320Header.jsp";
            RptUtils util;
            try{
            util = new RptUtils();
            String fIni = util.convertFecha(request.getParameter("txtfStartDate"), "yyMMdd");
            String fFin = util.convertFecha(request.getParameter("txtfEndDate"), "yyMMdd");

            util.creaArchFechas("SICLIF0320", fIni, fFin, session.getAttribute("login").toString());
            util.lanzaCondicion("RPTUEGLB99901_OK", util.convertFecha(request.getParameter("txtfEndDate"), "MMdd"), 1);

                fis = new FileInputStream(rutaReportes + "/siclif0320.jasper");
                bufferedInputStream = new BufferedInputStream(fis);
                reporte = (JasperReport) JRLoader.loadObject(bufferedInputStream);
        parametros.put("ejecuto",session.getAttribute("login").toString());
                parametros.put("initDate",request.getParameter("txtfStartDate"));
                parametros.put("endDate",request.getParameter("txtfEndDate"));
        parametros.put("tip_liq",tipoEntSal);
        parametros.put("logo",icono.getImage());
                //System.out.println("datos: "+request.getParameter("txtfStartDate")+"  "+request.getParameter("txtfEndDate")+" "+request.getParameter("txtftip_liq")+ "  "+session.getAttribute("login").toString());
                    formatoSalida = request.getParameter("formato");
                    if(logger != null){
                        logger.info(session.getId()+":"+"El usuario " + this.session.getAttribute("login").toString() +
                                " genero el reporte SICLIF0320 con parametros:FechaIni["+
                                request.getParameter("txtfStartDate") + "],FechaFin[" + request.getParameter("txtfEndDate") + "]");
                    }
                    // GENERA EL REPORTE
                    jasperPrint = JasperFillManager.fillReport(reporte, parametros,this.con);
                    request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);
                    response.setHeader("Pragma",        "no-cache");
                    response.setHeader("Cache-control", "private");
                    response.setDateHeader("Expires",   0);
                    // HTML
                    if("0".compareTo(formatoSalida) == 0){
                        response.setContentType("text/html");
                        response.setHeader("Content-Disposition", "inline; filename=\"SICLIF0320.html\"");
                        exportador = new JRHtmlExporter();
                        exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                        exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                        exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI,"image?image=");
                        exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                        exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(2.0));
                        exportador.exportReport();
                        servletOutputStream = response.getOutputStream();
                        response.setContentLength(baos.size());
                        baos.writeTo(servletOutputStream);
                    // EXCEL
                    }else if("1".compareTo(formatoSalida) == 0){
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
                    }else{
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
                }catch(Exception ex){
                    System.out.println(" Error al generar SICLIF0320:" + ex);
                    ex.printStackTrace();
                }
        }
//  -- Marca del Cambio : SAS-DRT-P-53-2004-15 Termina la Modificacion
        /* Termina cambio C-04-3035-13 */
/*#Marca de cambio:  SAS-DRT B-54-2904-15  Inicia Modificación #  */	
//Reporte SICLIR0400        
        else if(action.equals("SICLIR0400")){
                url = "/SICLIR0400Header.jsp";
        }
        else if(action.equals("SICLIR0400Main")){
                String initDate = request.getParameter("txtfStartDate");
                String []EmisoraArreglo = request.getParameterValues("bancoEmi");
         	String endDate = request.getParameter("txtfEndDate");
                String EmisoraStr="";
                for(String bancoEmi:EmisoraArreglo){
                    if(!EmisoraStr.equals(""))
                        EmisoraStr+=",";
                    EmisoraStr+=bancoEmi;
                }
                String []EmisorArreglo = request.getParameterValues("tipoTransac");
                String EmisorStr="";
                for(String tipoTransac:EmisorArreglo){
                    if(!EmisorStr.equals(""))
                        EmisorStr+=",";
                    EmisorStr+=tipoTransac;
                }
		String []archivoEntradaArreglo = request.getParameter("archivoEntrada_OK").split(",");
                String archivontradaSrt="";
                for(String entrada:archivoEntradaArreglo){
                    if(!archivontradaSrt.equals(""))
                        archivontradaSrt+=",";
                    archivontradaSrt+=entrada;
                }
        	String []archivoSalidaArreglo = request.getParameter("archivoSalida_OK").split(",");
                String archivoSalidaSrt="";
                for(String salida:archivoSalidaArreglo){
		 if(!archivoSalidaSrt.equals(""))
                     archivoSalidaSrt+=",";	
                     archivoSalidaSrt+=salida;
                }			
		session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
		session.setAttribute("initDate", initDate);
                session.setAttribute("endDate", endDate);
                session.setAttribute("bancoEmi", EmisoraStr);
                session.setAttribute("tipoTransac", EmisorStr);
		session.setAttribute("salida", archivoSalidaSrt);
                session.setAttribute("entrada", archivontradaSrt);  
                try
                {
                        url = value.valida(session, initDate, endDate, "Siclir0400");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                catch (WellException e)
                    {
                        e.printStackTrace();
                    }
            }
         //Reporte SICLIR0300
        else if(action.equals("SICLIR0300")){
                url = "/SICLIR0300Header.jsp";
        }
        else if(action.equals("SICLIR0300Main")){
                String initDate = request.getParameter("txtfStartDate");
                String []AdquirenteArreglo = request.getParameterValues("bancoAdq");
		String endDate = request.getParameter("txtfEndDate");
                String AdquirenteStr="";
                for(String bancoAdq:AdquirenteArreglo){
                    if(!AdquirenteStr.equals(""))
                        AdquirenteStr+=",";
                    AdquirenteStr+=bancoAdq;

                }
                String []EmisorArreglo = request.getParameterValues("tipoTransac");
                String EmisorStr="";
                for(String tipoTransac:EmisorArreglo){
                    if(!EmisorStr.equals(""))
                        EmisorStr+=",";
                    EmisorStr+=tipoTransac;
                }
		String []archivoEntradaArreglo = request.getParameter("archivoEntrada_OK").split(",");
                String archivontradaSrt="";
                for(String entrada:archivoEntradaArreglo){
                    if(!archivontradaSrt.equals(""))
                        archivontradaSrt+=",";
                    archivontradaSrt+=entrada;
                }
		String []archivoSalidaArreglo = request.getParameter("archivoSalida_OK").split(",");
                String archivoSalidaSrt="";
                for(String salida:archivoSalidaArreglo){
		    if(!archivoSalidaSrt.equals(""))
                     archivoSalidaSrt+=",";	
                     archivoSalidaSrt+=salida;
                }			
		session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
		session.setAttribute("initDate", initDate);
                session.setAttribute("endDate", endDate);
                session.setAttribute("bancoAdq", AdquirenteStr);
                session.setAttribute("tipoTransac", EmisorStr);
		session.setAttribute("salida", archivoSalidaSrt);
                session.setAttribute("entrada", archivontradaSrt);  
                try
                {
                        url = value.valida(session, initDate, endDate, "Siclir0300");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                catch (WellException e)
                    {
                        e.printStackTrace();
                    }
            }
//empieza MEercados Internacionales                    
                      else if(action.equals("SICMIR0129")) {
                        url = "/SICMIR0129Header.jsp";
                      } else if(action.equals("SICMIR0129Main")) {
                            SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
                            SimpleDateFormat formateo2 = new SimpleDateFormat("yyMMdd");
                            String inicial = request.getParameter("txtfStartDate");
                            String banco = request.getParameter("banco");
                            if(banco.length()<2) {
                                banco="000"+banco;
                            } else if(banco.length()<3) {
                                banco="00"+banco;
                            } else if(banco.length()<4) {
                                banco="0"+banco;
                            }
                            try {
                              session.setAttribute( "banco", banco);
                              String inicial2 = formateo2.format(formateo.parse(inicial));
                              session.setAttribute( "initDate", inicial2);
//                              String sFichero = "C://049"+inicial2+"_MI";
                              String sFichero = "//aplic//prod//pmt//pmr//vsa//049"+inicial2+"_MI";
                                File fichero = new File(sFichero);
                                if (fichero.exists()) {
                                  url = "/reportsjsp/managerReports.jsp"+"?report="+"SICMIR0129";
                                  viewerManager.setUpViewer(this, request, response, url);
                                        isAnswerReport=true;
                                } else {
                                    url = "/reportsjsp/Error.jsp";
                                }
//                              }
                            }   catch (Exception e) {
                                      e.printStackTrace();
                                  }
                        }  
// t140
                else if(action.equals("repTipoTransfer"))
        {
            url = "/SICMIR0130.jsp";
        }
/*#Marca de cambio:  SAS-DRT B-54-2904-15  Fin Modificación #  */        
        /*Modificacion: Marca de INICIO SAS-LMRV-P-21-0013-16*/
        /* Modificacion: Marca de inicio SAS-JPM P-06-0527-11  */

        else if(action.equals("SICLIRH0130"))
        {
            url = "/SICLIRH0130Header.jsp";
        }
        else if(action.equals("SICLIRH0130Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []bancoEmiArray = request.getParameterValues("bancoEmi");
            String bancosEmi="";
            for(String banco:bancoEmiArray){
                if(!bancosEmi.equals(""))
                    bancosEmi+=",";
                bancosEmi+=banco;
            }
            String []tipoTarjetaArray = request.getParameterValues("tipoTransac");
            String stipoTarjeta="'";
            for(String tarjeta:tipoTarjetaArray){
                if(!stipoTarjeta.equals(""))
                    stipoTarjeta+="','";
                stipoTarjeta+=tarjeta;
            }
            session.setAttribute("bancoEmi", bancosEmi);
            session.setAttribute("tipoTransac", stipoTarjeta);
            ControllerServletUtil.SICLIRH0130Main(session,this.PRSA_SETL_IND,this.PRSA_RPT_IND,initDate,endDate);
            try
            {
                url = value.valida(session, initDate, endDate, "SiclirH0130");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
        else if(action.equals("SICLIRH0135"))
        {
            url = "/SICLIRH0135Header.jsp";
        }
        else if(action.equals("SICLIRH0135Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []bancoEmiArray = request.getParameterValues("bancoEmi");
            String bancosEmi="";
            for(String banco:bancoEmiArray){
                if(!bancosEmi.equals(""))
                    bancosEmi+=",";
                bancosEmi+=banco;
            }
            String []tipoTarjetaArray = request.getParameterValues("tipoTransac");
            String stipoTarjeta="";
            for(String tarjeta:tipoTarjetaArray){
                if(!stipoTarjeta.equals(""))
                    stipoTarjeta+=",";
                stipoTarjeta+=tarjeta;
            }
            session.setAttribute("bancoEmi", bancosEmi);
            session.setAttribute("tipoTransac", stipoTarjeta);
            ControllerServletUtil.SICLIRH0135Main(session,this.PRSA_SETL_IND,this.PRSA_RPT_IND,initDate,endDate);


            try
            {
                url = value.valida(session, initDate, endDate, "SiclirH0135");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
        else if(action.equals("SICLIRH0140"))
        {
            url = "/SICLIRH0140Header.jsp";
        }
        else if(action.equals("SICLIRH0140Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []bancoEmiArray = request.getParameterValues("bancoEmi");
            String bancosEmi="";
            for(String banco:bancoEmiArray){
                if(!bancosEmi.equals(""))
                    bancosEmi+=",";
                bancosEmi+=banco;
            }
            String []tipoTarjetaArray = request.getParameterValues("tipoTransac");
            String stipoTarjeta="";
            for(String tarjeta:tipoTarjetaArray){
                if(!stipoTarjeta.equals(""))
                    stipoTarjeta+=",";
                stipoTarjeta+=tarjeta;
            }
            session.setAttribute("bancoEmi", bancosEmi);
            session.setAttribute("tipoTransac", stipoTarjeta);
            ControllerServletUtil.SICLIRH0140Main(session,this.PRSA_SETL_IND,this.PRSA_RPT_IND,initDate,endDate);
            try
            {
                url = value.valida(session, initDate, endDate, "SiclirH0140");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
        else if(action.equals("SICLIRH0430"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRH0430Header.jsp";
        }
        else if(action.equals("SICLIRH0430Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
             String diaHabAnt = (String)session.getAttribute("diaHabAnt");
            String []interreds = request.getParameterValues("interred");
            String interredesStr="";
            for(String interrred:interreds){
                if(!interredesStr.equals(""))
                    interredesStr+=",";
                interredesStr+=interrred;
            }
            String []bancoEmiArray = request.getParameterValues("bancoEmi");
            String bancosEmi="";
            for(String banco:bancoEmiArray){
                if(!bancosEmi.equals(""))
                    bancosEmi+=",";
                bancosEmi+=banco;
            }
            String []tipoTarjetaArray = request.getParameterValues("tipoTransac");
            String stipoTarjeta="";
            for(String tarjeta:tipoTarjetaArray){
                if(!stipoTarjeta.equals(""))
                    stipoTarjeta+=",";
                stipoTarjeta+=tarjeta;
            }
            session.setAttribute("bancoEmi", bancosEmi);
            session.setAttribute("tipoTransac", stipoTarjeta);
            ControllerServletUtil.SICLIRH0430Main(session,this.PRSA_SETL_IND,this.PRSA_RPT_IND,initDate,endDate,interredesStr);
            try
            {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                try
                {
                    if(format.parse(initDate).compareTo(format.parse(diaHabAnt7))>0)
                    {
                        Oparticiones(initDate, endDate);
                        url = value.valida(session, initDate, endDate, "SiclirH0430");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                   }
                    else
                        url = "/fechasInvalidas.jsp?noPantalla=4";
                }
                catch(Exception ex)
                {
                    throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                }
                }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
        else if(action.equals("SICLIRHP320"))
        {
            url = "/SICLIRHP320Header.jsp";
        }
        else if(action.equals("SICLIRHP320Main"))
        {
            SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []bancoEmiArray = request.getParameterValues("bancoEmi");
            String bancosEmi="";
            for(String banco:bancoEmiArray){
                if(!bancosEmi.equals(""))
                    bancosEmi+=",";
                bancosEmi+=banco;
            }
            String []tipoTarjetaArray = request.getParameterValues("tipoTransac");
            String stipoTarjeta="";
            for(String tarjeta:tipoTarjetaArray){
                if(!stipoTarjeta.equals(""))
                    stipoTarjeta+=",";
                stipoTarjeta+=tarjeta;
            }
            session.setAttribute("bancoEmi", bancosEmi);
            session.setAttribute("tipoTransac", stipoTarjeta);
            ControllerServletUtil.SICLIRHP320Main(session,this.PRSA_SETL_IND,this.PRSA_RPT_IND,initDate,endDate);

            try
            {
                url = value.valida(session, initDate, endDate, "SiclirHp320");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        else if(action.equals("SICMTRH001"))
        {
            url = "/SICMTRH001Header.jsp";
        }
        else if(action.equals("SICMTRH001Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []bancoEmiArray = request.getParameterValues("bancoEmi");
            String bancosEmi="";
            for(String banco:bancoEmiArray){
                if(!bancosEmi.equals(""))
                    bancosEmi+=",";
                bancosEmi+=banco;
            }
            String []tipoTarjetaArray = request.getParameterValues("tipoTransac");
            String stipoTarjeta="";
            for(String tarjeta:tipoTarjetaArray){
                if(!stipoTarjeta.equals(""))
                    stipoTarjeta+=",";
                stipoTarjeta+=tarjeta;
            }
            session.setAttribute("bancoEmi", bancosEmi);
            session.setAttribute("tipoTransac", stipoTarjeta);
            ControllerServletUtil.SICMTRH001Main(session, PRSA_SETL_IND, PRSA_RPT_IND, initDate, endDate);

            try
            {
                url = value.valida(session, initDate, endDate, "SICMTRH001");
                url = value.valida(session, initDate, endDate, "SICMTRH001");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
        else if(action.equals("SICCOMR001"))
        {
            url = "/SICCOMR001Header.jsp";
        }
        else if(action.equals("SICCOMR001Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []bancoEmiArray = request.getParameterValues("bancoEmi");
            String bancosEmi="";
            for(String banco:bancoEmiArray){
                if(!bancosEmi.equals(""))
                    bancosEmi+=",";
                bancosEmi+=banco;
            }
            String []tipoTarjetaArray = request.getParameterValues("tipoTransac");
            String stipoTarjeta="";
            for(String tarjeta:tipoTarjetaArray){
                if(!stipoTarjeta.equals(""))
                    stipoTarjeta+=",";
                stipoTarjeta+=tarjeta;
            }
            session.setAttribute("bancoEmi", bancosEmi);
            session.setAttribute("tipoTransac", stipoTarjeta);
            ControllerServletUtil.SICCOMR001Main(session, PRSA_SETL_IND, PRSA_RPT_IND, initDate, endDate);
            try
            {
                url = value.valida(session, initDate, endDate, "Siccomr001");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
        /*Modificacion: Marca de FIN SAS-LMRV-P-21-0013-16*/
        /* Modificacion: Marca de fin SAS-JPM P-06-0527-11  */
          /* Modificacion: Marca de inicio SAS-JPM P-06-0527-11  */
        else if(action.equals("SICLIRH0110"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRH0110Header.jsp";
        }
        else if(action.equals("SICLIRH0110Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []bancoEmiArray = request.getParameterValues("bancoEmi");
            String bancosEmi="";
            for(String banco:bancoEmiArray){
                if(!bancosEmi.equals(""))
                    bancosEmi+=",";
                bancosEmi+=banco;
            }
            String []tipoTarjetaArray = request.getParameterValues("tipoTransac");
            String stipoTarjeta="";
            for(String tarjeta:tipoTarjetaArray){
                if(!stipoTarjeta.equals(""))
                    stipoTarjeta+=",";
                stipoTarjeta+=tarjeta;
            }
            session.setAttribute("tipoTransac", stipoTarjeta);
            ControllerServletUtil.SICLIRH0110Main(session,this.PRSA_SETL_IND,this.PRSA_RPT_IND,initDate,endDate,bancosEmi);
            try
            {
                url = value.valida(session, initDate, endDate, "SiclirH0110");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
        else if(action.equals("SICLIRH0120"))
        {
            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
            url = "/SICLIRH0120Header.jsp";
        }
        else if(action.equals("SICLIRH0120Main"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []interredes = request.getParameterValues("interred");
            String []divisiones = request.getParameterValues("division");
            String interredesStr="";
            for(String interred:interredes){
                if(!interredesStr.equals(""))
                    interredesStr+=",";
                interredesStr+=interred;
            }
            String divisionesStr="";
            for(String division:divisiones){
                if(!divisionesStr.equals(""))
                    divisionesStr+=",";
                divisionesStr+=division;
            }
            String []tipoTarjetaArray = request.getParameterValues("tipoTransac");
            String stipoTarjeta="";
            for(String tarjeta:tipoTarjetaArray){
                if(!stipoTarjeta.equals(""))
                    stipoTarjeta+=",";
                stipoTarjeta+=tarjeta;
            }
            session.setAttribute("tipoTransac", stipoTarjeta);
            ControllerServletUtil.SICLIRH0120Main(session, PRSA_SETL_IND, PRSA_RPT_IND, initDate, endDate, interredesStr, divisionesStr);
            try
            {
                url = value.valida(session, initDate, endDate, "SiclirH0120");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
        /* Modificacion: Marca de fin SAS-JPM P-06-0527-11  */
        /*Modificacion: Marca de INICIO SAS-LMRV-P-21-0013-16*/
        else if(action.equals("SICMORH"))
        {
            url = "/SICMORHHeader.jsp";
        }
        else if(action.equals("SICMORHMain"))
        {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String []bancoEmiArray = request.getParameterValues("bancoEmi");

            String bancosEmi="";
            for(String banco:bancoEmiArray){
                if(!bancosEmi.equals(""))
                    bancosEmi+=",";
                bancosEmi+=banco;
            }
            String tipoTx = request.getParameter("tipoTransac");
            session.setAttribute("bancoEmi", bancosEmi);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("tipoTransac", tipoTx);

            try
            {
                url = value.valida(session, initDate, endDate, "SicmorH");
                viewerManager.setUpViewer(this, request, response, url);
                isAnswerReport=true;
            }
            catch (WellException e)
            {
                e.printStackTrace();
            }
        }
        /*  Modificacion: Marca de fin P-21-0013-16 LMRV-SAS */
// GSOF-MVR-P-53-2727-14 Marca de Inicio
        else if(action.equals("SICCMR0001"))
        {
            Collection                  listado             = new ArrayList();
            String                      accion              = "";
            String                      feIni               = "";
            String                      feFin               = "";
            SICCMRDAO                   modelo              = new SICCMRDAO();
            Collection                  bancosE             = new ArrayList();
            Collection                  camarasA            = new ArrayList();
            Collection                  marcas              = new ArrayList();
            Collection                  resultados          = new ArrayList();
            CriteriosObj                criterios           = new CriteriosObj();
            SimpleDateFormat            formatoFecha        = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date               fechaIni            = null;
            java.sql.Date               fechaFin            = null;
            Calendar                    currenttime         = Calendar.getInstance();
            SICCMR0001Form              forma               = new SICCMR0001Form();
            String                      grupo               = (String)session.getAttribute("role");
            String                      fiidUsuario         = (String)session.getAttribute("numFiid");
            String                      owner               = "";
            String                      rutaReportes        = getServletContext().getRealPath("reports");
            String                      rutaImagenes        = getServletContext().getRealPath("pics");
            ImageIcon                   icono               = new ImageIcon(ImageIO.read(new File(rutaImagenes + "/logoProsa.png")));
            FileInputStream             fis                 = null;
            BufferedInputStream         bufferedInputStream = null;
            JasperReport                reporte             = null;
            JRBeanCollectionDataSource  dsR                 = null;
            JasperPrint                 jasperPrint         = null;
            JRExporter                  exportador          = null;
            ServletOutputStream         servletOutputStream = null;
            Map                         parametros          = new HashMap();
            String                      usuario             = (String)session.getAttribute("login");
            String                      formatoSalida       = null;
            ByteArrayOutputStream       baos                = new ByteArrayOutputStream();

            url = "/SICCMR0001.jsp";

            // OBTIENE LA FECHA ACTUAL, ZONA HORARIA DE MEXICO
            currenttime.setTimeZone(TimeZone.getTimeZone("GMT-06:00"));

            // OBTIENE LAS LISTAS DE CATALOGOS
            // LOS USUARIOS DE BANCOS SOLO VEN SUS PROPIOS DATOS
            if(("administrador".compareTo(grupo) == 0) || ("operador".compareTo(grupo) == 0)){
                owner     = "%";
            }else{
                owner     = fiidUsuario;
            }

            bancosE   = modelo.listarBancos001002();
            camarasA  = modelo.listarCamaras();
            marcas    = modelo.listarMarcas();

            // OBTIENE LA FECHA DEFAULT DE INICIO Y FIN
            // FIN ES LA FECHA ACTUAL, INICIO ES UN MES ATRAS
            fechaFin = new java.sql.Date((currenttime.getTime()).getTime());
            currenttime.add(Calendar.MONTH, -1);
            fechaIni = new java.sql.Date((currenttime.getTime()).getTime());

            accion = request.getParameter("accion");

            if(accion == null){accion = "";}
            // LA ACCION ES BLANCO, INICIALIZA
            if("".compareTo(accion) == 0){
                feIni = formatoFecha.format(fechaIni);
                feFin = formatoFecha.format(fechaFin);
                // PONE LOS DATOS EN BLANCO
                // DATOS ELEGIDOS MAS LISTADO OBTENIDO
                forma.setAccion(      "1");
                forma.setFechaInicio( feIni);
                forma.setFechaFinal(  feFin);
                forma.setBancosE(     bancosE);
                forma.setCamarasA(    camarasA);
                forma.setMarcas(      marcas);
                session.setAttribute("datos", forma);
            // LA ACCION ES 0, CANCELAR
            }else if("0".compareTo(accion) == 0){
                url = "/index.jsp";
            }else{
                try{
                    // OBTIENE LOS CRITERIOS ELEGIDOS
                    feIni           = request.getParameter("fechaInicio");
                    feFin           = request.getParameter("fechaFinal");
                    // PONE LOS VALORES DEFAULT, SI ESTAN EN BLANCO
                    if("".compareTo(feIni) == 0){
                        feIni = formatoFecha.format(fechaIni);
                    }
                    if("".compareTo(feFin) == 0){
                        feFin = formatoFecha.format(fechaFin);
                    }
                    // PONE LOS CRITERIOS
                    criterios.setIni(         feIni);
                    criterios.setFin(         feFin);
                    criterios.setBancoEmi(    request.getParameterValues("bancoEmi"));
                    criterios.setCamaraAdq(   request.getParameterValues("camaraAdq"));
                    criterios.setMarca(       request.getParameterValues("marca"));
                    criterios.setOwner(       owner);

                    fis                         = new FileInputStream(rutaReportes + "/SICCMR0001.jasper");
                    bufferedInputStream         = new BufferedInputStream(fis);
                    reporte                     = (JasperReport) JRLoader.loadObject(bufferedInputStream);

                    parametros.put("logo",      icono.getImage());
                    parametros.put("usuario",   usuario);
                    parametros.put("ini",       criterios.getIni());
                    parametros.put("fin",       criterios.getFin());
                    parametros.put("marca",     modelo.descripcionesListaMarcas(request.getParameterValues("marca")));
                    parametros.put("camara",    modelo.descripcionesListaCamaras(request.getParameterValues("camaraAdq")));
                    parametros.put("emisor",    modelo.entidadesListaBancos(request.getParameterValues("bancoEmi")));

                    formatoSalida = request.getParameter("formato");
                    // HTML
                    if("0".compareTo(formatoSalida) == 0){
                        parametros.put("titulo",   new Integer(1));
                    // EXCEL
                    }else if("1".compareTo(formatoSalida) == 0){
                        parametros.put("titulo",   new Integer(0));
                    // PDF
                    }else{
                        parametros.put("titulo",   new Integer(1));
                    }

                    if(logger != null){
                        logger.info(session.getId()+":"+"El usuario " + this.session.getAttribute("login").toString() +
                                " genero el reporte SICCMR0001 con parametros:FechaIni["+
                                criterios.getIni() + "],FechaFin[" + criterios.getFin() + "],Emisor[" +
                                modelo.listaCadenas(request.getParameterValues("bancoEmi")) +
                                "],Marca[" + modelo.descripcionesListaMarcas(request.getParameterValues("marca")) +
                                "],CamaraAdq[" + modelo.descripcionesListaCamaras(request.getParameterValues("camaraAdq")) + "]");
                    }
                    // GENERA EL REPORTE
                    resultados  = modelo.consultarSICCMR0001(criterios);
                    dsR         = new JRBeanCollectionDataSource(resultados);
                    jasperPrint = JasperFillManager.fillReport(reporte, parametros, dsR);

                    request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

                    response.setHeader("Pragma",        "no-cache");
                    response.setHeader("Cache-control", "private");
                    response.setDateHeader("Expires",   0);

                    // HTML
                    if("0".compareTo(formatoSalida) == 0){
                        response.setContentType("text/html");
                        response.setHeader("Content-Disposition", "inline; filename=\"SICCMR0001.html\"");
                        exportador = new JRHtmlExporter();
                        exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                        exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                        exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI,"image?image=");
                        exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                        exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(1.5));
                        exportador.exportReport();
                        servletOutputStream = response.getOutputStream();
                        response.setContentLength(baos.size());
                        baos.writeTo(servletOutputStream);
                    // EXCEL
                    }else if("1".compareTo(formatoSalida) == 0){
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
                    }else{
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
                }catch(Exception ex){
                    System.out.println(" Error al generar SICCMR001:" + ex);
                    ex.printStackTrace();
                }
            }
        }
        else if(action.equals("SICCMR0002"))
        {
            Collection                  listado             = new ArrayList();
            String                      accion              = "";
            String                      feIni               = "";
            String                      feFin               = "";
            SICCMRDAO                   modelo              = new SICCMRDAO();
            Collection                  bancosE             = new ArrayList();
            Collection                  bancosA             = new ArrayList();
            Collection                  camarasE            = new ArrayList();
            Collection                  marcas              = new ArrayList();
            Collection                  resultados          = new ArrayList();
            CriteriosObj                criterios           = new CriteriosObj();
            SimpleDateFormat            formatoFecha        = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date               fechaIni            = null;
            java.sql.Date               fechaFin            = null;
            Calendar                    currenttime         = Calendar.getInstance();
            SICCMR0002Form              forma               = new SICCMR0002Form();
            String                      grupo               = (String)session.getAttribute("role");
            String                      fiidUsuario         = (String)session.getAttribute("numFiid");
            String                      owner               = "";
            String                      rutaReportes        = getServletContext().getRealPath("reports");
            String                      rutaImagenes        = getServletContext().getRealPath("pics");
            ImageIcon                   icono               = new ImageIcon(ImageIO.read(new File(rutaImagenes + "/logoProsa.png")));
            FileInputStream             fis                 = null;
            BufferedInputStream         bufferedInputStream = null;
            JasperReport                reporte             = null;
            JRBeanCollectionDataSource  dsR                 = null;
            JasperPrint                 jasperPrint         = null;
            JRExporter                  exportador          = null;
            ServletOutputStream         servletOutputStream = null;
            Map                         parametros          = new HashMap();
            String                      usuario             = (String)session.getAttribute("login");
            String                      formatoSalida       = null;
            ByteArrayOutputStream       baos                = new ByteArrayOutputStream();

            url = "/SICCMR0002.jsp";

            // OBTIENE LA FECHA ACTUAL, ZONA HORARIA DE MEXICO
            currenttime.setTimeZone(TimeZone.getTimeZone("GMT-06:00"));

            // OBTIENE LAS LISTAS DE CATALOGOS
            // LOS USUARIOS DE BANCOS SOLO VEN SUS PROPIOS DATOS
            if(("administrador".compareTo(grupo) == 0) || ("operador".compareTo(grupo) == 0)){
                bancosA   = modelo.listarBancos();
                owner     = "%";
            }else{
                bancosA   = modelo.nombresBancos(modelo.convierteCadena(fiidUsuario));
                owner     = fiidUsuario;
            }

            bancosE   = modelo.listarBancos001002();
            camarasE  = modelo.listarCamaras();
            marcas    = modelo.listarMarcas();

            // OBTIENE LA FECHA DEFAULT DE INICIO Y FIN
            // FIN ES LA FECHA ACTUAL, INICIO ES UN MES ATRAS
            fechaFin = new java.sql.Date((currenttime.getTime()).getTime());
            currenttime.add(Calendar.MONTH, -1);
            fechaIni = new java.sql.Date((currenttime.getTime()).getTime());

            accion = request.getParameter("accion");

            if(accion == null){accion = "";}

            // LA ACCION ES BLANCO, INICIALIZA
            if("".compareTo(accion) == 0){
                feIni = formatoFecha.format(fechaIni);
                feFin = formatoFecha.format(fechaFin);
                // PONE LOS DATOS EN BLANCO
                // DATOS ELEGIDOS MAS LISTADO OBTENIDO
                forma.setAccion(      "1");
                forma.setFechaInicio( feIni);
                forma.setFechaFinal(  feFin);
                forma.setBancosA(     bancosA);
                forma.setBancosE(     bancosE);
                forma.setCamarasE(    camarasE);
                forma.setMarcas(      marcas);
                session.setAttribute("datos", forma);
            // LA ACCION ES 0, CANCELAR
            }else if("0".compareTo(accion) == 0){
                url = "/index.jsp";
            }else{
                try{
                    // PONE LOS CRITERIOS
                    criterios.setIni(           request.getParameter("fechaInicio"));
                    criterios.setFin(           request.getParameter("fechaFinal"));
                    criterios.setBancoEmi(      request.getParameterValues("bancoEmi"));
                    criterios.setBancoAdq(      request.getParameterValues("bancoAdq"));
                    criterios.setCamaraEmi(     request.getParameterValues("camaraEmi"));
                    criterios.setMarca(         request.getParameterValues("marca"));
                    criterios.setOwner(         owner);

                    fis                         = new FileInputStream(rutaReportes + "/SICCMR0002.jasper");
                    bufferedInputStream         = new BufferedInputStream(fis);
                    reporte                     = (JasperReport) JRLoader.loadObject(bufferedInputStream);

                    parametros.put("logo",      icono.getImage());
                    parametros.put("usuario",   usuario);
                    parametros.put("ini",       criterios.getIni());
                    parametros.put("fin",       criterios.getFin());
                    parametros.put("marca",     modelo.descripcionesListaMarcas(request.getParameterValues("marca")));
                    parametros.put("camara",    modelo.descripcionesListaCamaras(request.getParameterValues("camaraEmi")));
                    parametros.put("emisor",    modelo.entidadesListaBancos(request.getParameterValues("bancoEmi")));
                    parametros.put("adquirente",modelo.entidadesListaBancos(request.getParameterValues("bancoAdq")));

                    formatoSalida = request.getParameter("formato");
                    // HTML
                    if("0".compareTo(formatoSalida) == 0){
                        parametros.put("titulo",   new Integer(1));
                    // EXCEL
                    }else if("1".compareTo(formatoSalida) == 0){
                        parametros.put("titulo",   new Integer(0));
                    // PDF
                    }else{
                        parametros.put("titulo",   new Integer(1));
                    }

                    if(logger != null){
                        logger.info(session.getId()+":"+"El usuario " + this.session.getAttribute("login").toString() +
                                " genero el reporte SICCMR0002 con parametros:FechaIni["+
                                criterios.getIni() + "],FechaFin[" + criterios.getFin() + "],Emisor[" +
                                modelo.listaCadenas(request.getParameterValues("bancoEmi")) + "],Adquirente[" +
                                modelo.listaCadenas(request.getParameterValues("bancoAdq")) +
                                "],Marca[" + modelo.descripcionesListaMarcas(request.getParameterValues("marca")) +
                                "],CamaraEmi[" + modelo.descripcionesListaCamaras(request.getParameterValues("camaraEmi")) + "]");
                    }

                    // GENERA EL REPORTE
                    resultados  = modelo.consultarSICCMR0002(criterios);
                    dsR         = new JRBeanCollectionDataSource(resultados);
                    jasperPrint = JasperFillManager.fillReport(reporte, parametros, dsR);

                    request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

                    response.setHeader("Pragma",        "no-cache");
                    response.setHeader("Cache-control", "private");
                    response.setDateHeader("Expires",   0);

                    // HTML
                    if("0".compareTo(formatoSalida) == 0){
// GSOF-MVR-P-53-2727-14 Marca de Inicio
if(logger != null){
    logger.info(session.getId()+":"+"processRequestContinua2. Generando HTML del reporte SICCMR0002");
}
// GSOF-MVR-P-53-2727-14 Marca de Terminacion
                        response.setContentType("text/html");
                        response.setHeader("Content-Disposition", "inline; filename=\"SICCMR0002.html\"");
                        exportador = new JRHtmlExporter();
                        exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                        exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                        exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI,"image?image=");
                        exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                        exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(1.5));
                        exportador.exportReport();
                        servletOutputStream = response.getOutputStream();
                        response.setContentLength(baos.size());
                        baos.writeTo(servletOutputStream);
                    // EXCEL
                    }else if("1".compareTo(formatoSalida) == 0){
// GSOF-MVR-P-53-2727-14 Marca de Inicio
if(logger != null){
    logger.info(session.getId()+":"+"processRequestContinua2. Generando EXCEL del reporte SICCMR0002");
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
                    }else{
// GSOF-MVR-P-53-2727-14 Marca de Inicio
if(logger != null){
    logger.info(session.getId()+":"+"processRequestContinua2. Generando PDF del reporte SICCMR0002");
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
                }catch(Exception ex){
                    System.out.println(" Error al generar SICCMR0002:" + ex);
                    ex.printStackTrace();
                }
            }
        }
        else if(action.equals("SICCMR0050"))
        {
            Collection                  listado             = new ArrayList();
            String                      accion              = "";
            String                      feIni               = "";
            String                      feFin               = "";
            SICCMRDAO                   modelo              = new SICCMRDAO();
            Collection                  bancosE             = new ArrayList();
            Collection                  camarasE            = new ArrayList();
            Collection                  resultados          = new ArrayList();
            CriteriosObj                criterios           = new CriteriosObj();
            SimpleDateFormat            formatoFecha        = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date               fechaIni            = null;
            java.sql.Date               fechaFin            = null;
            Calendar                    currenttime         = Calendar.getInstance();
            SICCMR0050Form              forma               = new SICCMR0050Form();
            String                      grupo               = (String)session.getAttribute("role");
            String                      fiidUsuario         = (String)session.getAttribute("numFiid");
            String                      owner               = "";
            String                      rutaReportes        = getServletContext().getRealPath("reports");
            String                      rutaImagenes        = getServletContext().getRealPath("pics");
            ImageIcon                   icono               = new ImageIcon(ImageIO.read(new File(rutaImagenes + "/logoProsa.png")));
            FileInputStream             fis                 = null;
            BufferedInputStream         bufferedInputStream = null;
            JasperReport                reporte             = null;
            JRBeanCollectionDataSource  dsR                 = null;
            JasperPrint                 jasperPrint         = null;
            JRExporter                  exportador          = null;
            ServletOutputStream         servletOutputStream = null;
            Map                         parametros          = new HashMap();
            String                      usuario             = (String)session.getAttribute("login");
            String                      formatoSalida       = null;
            ByteArrayOutputStream       baos                = new ByteArrayOutputStream();

            url = "/SICCMR0050.jsp";

            // OBTIENE LA FECHA ACTUAL, ZONA HORARIA DE MEXICO
            currenttime.setTimeZone(TimeZone.getTimeZone("GMT-06:00"));

            // OBTIENE LAS LISTAS DE CATALOGOS
            bancosE   = modelo.listarBancosTodos();
            camarasE  = modelo.listarCamarasEglo();

            // LOS USUARIOS DE BANCOS SOLO VEN SUS PROPIOS DATOS
            if(("administrador".compareTo(grupo) == 0) || ("operador".compareTo(grupo) == 0)){
                owner     = "%";

                // AGREGA EL ELEMENTO CONSOLIDADO
                EstructuraListaObj consolidado = new EstructuraListaObj();
                consolidado.setClave("999999");
                consolidado.setDescripcion("CONSOLIDADO");
                bancosE.add(consolidado);
            }else{
                owner     = fiidUsuario;
            }

            // OBTIENE LA FECHA DEFAULT DE INICIO Y FIN
            // FIN ES LA FECHA ACTUAL, INICIO ES UN MES ATRAS
            fechaFin = new java.sql.Date((currenttime.getTime()).getTime());
            currenttime.add(Calendar.MONTH, -1);
            fechaIni = new java.sql.Date((currenttime.getTime()).getTime());

            accion = request.getParameter("accion");

            if(accion == null){accion = "";}

            // LA ACCION ES BLANCO, INICIALIZA
            if("".compareTo(accion) == 0){
                feIni = formatoFecha.format(fechaIni);
                feFin = formatoFecha.format(fechaFin);
                // PONE LOS DATOS EN BLANCO
                // DATOS ELEGIDOS MAS LISTADO OBTENIDO
                forma.setAccion(      "1");
                forma.setFechaInicio( feIni);
                forma.setFechaFinal(  feFin);
                forma.setBancosE(     bancosE);
                forma.setCamarasE(    camarasE);
                session.setAttribute("datos", forma);
            // LA ACCION ES 0, CANCELAR
            }else if("0".compareTo(accion) == 0){
                url = "/index.jsp";
            }else{
                try{
                    // PONE LOS CRITERIOS
                    criterios.setIni(           request.getParameter("fechaInicio"));
                    criterios.setFin(           request.getParameter("fechaFinal"));
                    criterios.setBancoEmi(      request.getParameterValues("bancoEmi"));
                    criterios.setCamaraEmi(     request.getParameterValues("camaraEmi"));
                    criterios.setOwner(         owner);

                    fis                         = new FileInputStream(rutaReportes + "/SICCMR0050.jasper");
                    bufferedInputStream         = new BufferedInputStream(fis);
                    reporte                     = (JasperReport) JRLoader.loadObject(bufferedInputStream);

                    parametros.put("logo",      icono.getImage());
                    parametros.put("usuario",   usuario);
                    parametros.put("ini",       criterios.getIni());
                    parametros.put("fin",       criterios.getFin());
                    parametros.put("camara",    modelo.descripcionesListaCamaras(request.getParameterValues("camaraEmi")));

                    formatoSalida = request.getParameter("formato");
                    // HTML
                    if("0".compareTo(formatoSalida) == 0){
                        parametros.put("titulo",   new Integer(1));
                    // EXCEL
                    }else if("1".compareTo(formatoSalida) == 0){
                        parametros.put("titulo",   new Integer(0));
                    // PDF
                    }else{
                        parametros.put("titulo",   new Integer(1));
                    }

                    if(criterios.getBancoEmi().indexOf("999999") > -1){
                        parametros.put("banco",  "CONSOLIDADO");
                    }else{
                        parametros.put("banco",  modelo.listaCadenas(request.getParameterValues("bancoEmi")));
                    }

                    if(logger != null){
                        logger.info(session.getId()+":"+"El usuario " + this.session.getAttribute("login").toString() +
                                " genero el reporte SICCMR0050 con parametros:FechaIni["+
                                criterios.getIni() + "],FechaFin[" + criterios.getFin() + "],Emisor[" +
                                modelo.listaCadenas(request.getParameterValues("bancoEmi")) +
                                "],CamaraEmi[" + modelo.descripcionesListaCamaras(request.getParameterValues("camaraEmi")) + "]");
                    }

                    // GENERA EL REPORTE
                    resultados  = modelo.consultar0050(criterios);
                    dsR         = new JRBeanCollectionDataSource(resultados);
                    jasperPrint = JasperFillManager.fillReport(reporte, parametros, dsR);

                    request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

                    response.setHeader("Pragma",        "no-cache");
                    response.setHeader("Cache-control", "private");
                    response.setDateHeader("Expires",   0);

                    // HTML
                    if("0".compareTo(formatoSalida) == 0){
                        response.setContentType("text/html");
                        response.setHeader("Content-Disposition", "inline; filename=\"SICCMR0050.html\"");
                        exportador = new JRHtmlExporter();
                        exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                        exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                        exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI,"image?image=");
                        exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                        exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(1.5));
                        exportador.exportReport();
                        servletOutputStream = response.getOutputStream();
                        response.setContentLength(baos.size());
                        baos.writeTo(servletOutputStream);
                    // EXCEL
                    }else if("1".compareTo(formatoSalida) == 0){
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
                    }else{
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
                }catch(Exception ex){
                    System.out.println(" Error al generar SICCMR0050:" + ex);
                    ex.printStackTrace();
                }
            }
        }
        else if(action.equals("SICCMR0060"))
        {
            Collection                  listado             = new ArrayList();
            String                      accion              = "";
            String                      feIni               = "";
            String                      feFin               = "";
            SICCMRDAO                   modelo              = new SICCMRDAO();
            Collection                  bancosA             = new ArrayList();
            Collection                  camarasA            = new ArrayList();
            Collection                  resultados          = new ArrayList();
            CriteriosObj                criterios           = new CriteriosObj();
            SimpleDateFormat            formatoFecha        = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date               fechaIni            = null;
            java.sql.Date               fechaFin            = null;
            Calendar                    currenttime         = Calendar.getInstance();
            SICCMR0060Form              forma               = new SICCMR0060Form();
            String                      grupo               = (String)session.getAttribute("role");
            String                      fiidUsuario         = (String)session.getAttribute("numFiid");
            String                      owner               = "";
            String                      rutaReportes        = getServletContext().getRealPath("reports");
            String                      rutaImagenes        = getServletContext().getRealPath("pics");
            ImageIcon                   icono               = new ImageIcon(ImageIO.read(new File(rutaImagenes + "/logoProsa.png")));
            FileInputStream             fis                 = null;
            BufferedInputStream         bufferedInputStream = null;
            JasperReport                reporte             = null;
            JRBeanCollectionDataSource  dsR                 = null;
            JasperPrint                 jasperPrint         = null;
            JRExporter                  exportador          = null;
            ServletOutputStream         servletOutputStream = null;
            Map                         parametros          = new HashMap();
            String                      usuario             = (String)session.getAttribute("login");
            String                      formatoSalida       = null;
            ByteArrayOutputStream       baos                = new ByteArrayOutputStream();

            url = "/SICCMR0060.jsp";

            // OBTIENE LA FECHA ACTUAL, ZONA HORARIA DE MEXICO
            currenttime.setTimeZone(TimeZone.getTimeZone("GMT-06:00"));

            // OBTIENE LAS LISTAS DE CATALOGOS
            // LOS USUARIOS DE BANCOS SOLO VEN SUS PROPIOS DATOS
            if(("administrador".compareTo(grupo) == 0) || ("operador".compareTo(grupo) == 0)){
                bancosA   = modelo.listarBancosTodos();
                owner     = "";

                // AGREGA EL ELEMENTO CONSOLIDADO
                EstructuraListaObj consolidado = new EstructuraListaObj();
                consolidado.setClave("999999");
                consolidado.setDescripcion("CONSOLIDADO");
                bancosA.add(consolidado);
            }else{
                bancosA   = modelo.nombresBancos(modelo.convierteCadena(modelo.entidadBanco(fiidUsuario)));
                owner     = fiidUsuario;
            }

            camarasA  = modelo.listarCamarasProsa();

            // OBTIENE LA FECHA DEFAULT DE INICIO Y FIN
            // FIN ES LA FECHA ACTUAL, INICIO ES UN MES ATRAS
            fechaFin = new java.sql.Date((currenttime.getTime()).getTime());
            currenttime.add(Calendar.MONTH, -1);
            fechaIni = new java.sql.Date((currenttime.getTime()).getTime());

            accion = request.getParameter("accion");

            if(accion == null){accion = "";}

            // LA ACCION ES BLANCO, INICIALIZA
            if("".compareTo(accion) == 0){
                feIni = formatoFecha.format(fechaIni);
                feFin = formatoFecha.format(fechaFin);
                // PONE LOS DATOS EN BLANCO
                // DATOS ELEGIDOS MAS LISTADO OBTENIDO
                forma.setAccion(      "1");
                forma.setFechaInicio( feIni);
                forma.setFechaFinal(  feFin);
                forma.setBancosA(     bancosA);
                forma.setCamarasA(    camarasA);
                session.setAttribute("datos", forma);
            // LA ACCION ES 0, CANCELAR
            }else if("0".compareTo(accion) == 0){
                url = "/index.jsp";
            }else{
                try{
                    // PONE LOS CRITERIOS
                    criterios.setIni(           request.getParameter("fechaInicio"));
                    criterios.setFin(           request.getParameter("fechaFinal"));
                    criterios.setBancoAdq(      request.getParameterValues("bancoAdq"));
                    criterios.setCamaraAdq(     request.getParameterValues("camaraAdq"));
                    criterios.setOwner(         owner);

                    fis                         = new FileInputStream(rutaReportes + "/SICCMR0060.jasper");
                    bufferedInputStream         = new BufferedInputStream(fis);
                    reporte                     = (JasperReport) JRLoader.loadObject(bufferedInputStream);

                    parametros.put("logo",      icono.getImage());
                    parametros.put("usuario",   usuario);
                    parametros.put("ini",       criterios.getIni());
                    parametros.put("fin",       criterios.getFin());
                    parametros.put("camara",    modelo.descripcionesListaCamaras(request.getParameterValues("camaraAdq")));

                    formatoSalida = request.getParameter("formato");
                    // HTML
                    if("0".compareTo(formatoSalida) == 0){
                        parametros.put("titulo",   new Integer(1));
                    // EXCEL
                    }else if("1".compareTo(formatoSalida) == 0){
                        parametros.put("titulo",   new Integer(0));
                    // PDF
                    }else{
                        parametros.put("titulo",   new Integer(1));
                    }

                    if(criterios.getBancoAdq().indexOf("999999") > -1){
                        parametros.put("banco",  "CONSOLIDADO");
                    }else{
                        parametros.put("banco",  modelo.listaCadenas(request.getParameterValues("bancoAdq")));
                    }

                    if(logger != null){
                        logger.info(session.getId()+":"+"El usuario " + this.session.getAttribute("login").toString() +
                                " genero el reporte SICCMR0060 con parametros:FechaIni["+
                                criterios.getIni() + "],FechaFin[" + criterios.getFin() + "],Adquirente[" +
                                modelo.listaCadenas(request.getParameterValues("bancoAdq")) +
                                "],CamaraAdq[" + modelo.descripcionesListaCamaras(request.getParameterValues("camaraAdq")) + "]");
                    }

                    // GENERA EL REPORTE
                    resultados  = modelo.consultar0060(criterios);
                    dsR         = new JRBeanCollectionDataSource(resultados);
                    jasperPrint = JasperFillManager.fillReport(reporte, parametros, dsR);

                    request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

                    response.setHeader("Pragma",        "no-cache");
                    response.setHeader("Cache-control", "private");
                    response.setDateHeader("Expires",   0);

                    // HTML
                    if("0".compareTo(formatoSalida) == 0){
                        response.setContentType("text/html");
                        response.setHeader("Content-Disposition", "inline; filename=\"SICCMR0060.html\"");
                        exportador = new JRHtmlExporter();
                        exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                        exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                        exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI,"image?image=");
                        exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                        exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(1.5));
                        exportador.exportReport();
                        servletOutputStream = response.getOutputStream();
                        response.setContentLength(baos.size());
                        baos.writeTo(servletOutputStream);
                    // EXCEL
                    }else if("1".compareTo(formatoSalida) == 0){
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
                    }else{
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
                }catch(Exception ex){
                    System.out.println(" Error al generar SICCMR0060:" + ex);
                    ex.printStackTrace();
                }
            }
        }
        else if(action.equals("SICCMR0065"))
        {
            Collection                  listado             = new ArrayList();
            String                      accion              = "";
            String                      feIni               = "";
            String                      feFin               = "";
            SICCMRDAO                   modelo              = new SICCMRDAO();
            Collection                  bancos              = new ArrayList();
            Collection                  resultados          = new ArrayList();
            CriteriosObj                criterios           = new CriteriosObj();
            SimpleDateFormat            formatoFecha        = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date               fechaIni            = null;
            java.sql.Date               fechaFin            = null;
            Calendar                    currenttime         = Calendar.getInstance();
            SICCMR0065Form              forma               = new SICCMR0065Form();
            String                      grupo               = (String)session.getAttribute("role");
            String                      fiidUsuario         = (String)session.getAttribute("numFiid");
            String                      owner               = "";
            String                      rutaReportes        = getServletContext().getRealPath("reports");
            String                      rutaImagenes        = getServletContext().getRealPath("pics");
            ImageIcon                   icono               = new ImageIcon(ImageIO.read(new File(rutaImagenes + "/logoProsa.png")));
            FileInputStream             fis                 = null;
            BufferedInputStream         bufferedInputStream = null;
            JasperReport                reporte             = null;
            JRBeanCollectionDataSource  dsR                 = null;
            JasperPrint                 jasperPrint         = null;
            JRExporter                  exportador          = null;
            ServletOutputStream         servletOutputStream = null;
            Map                         parametros          = new HashMap();
            String                      usuario             = (String)session.getAttribute("login");
            String                      formatoSalida       = null;
            ByteArrayOutputStream       baos                = new ByteArrayOutputStream();

            url = "/SICCMR0065.jsp";

            // OBTIENE LA FECHA ACTUAL, ZONA HORARIA DE MEXICO
            currenttime.setTimeZone(TimeZone.getTimeZone("GMT-06:00"));

            // OBTIENE LAS LISTAS DE CATALOGOS
            // LOS USUARIOS DE BANCOS SOLO VEN SUS PROPIOS DATOS
            if(("administrador".compareTo(grupo) == 0) || ("operador".compareTo(grupo) == 0)){
                owner     = "%";
                bancos    = modelo.listarBancos0065();
            }else{
                owner     = fiidUsuario;
                bancos    = modelo.nombresBancos(modelo.convierteCadena(fiidUsuario));
            }

            // OBTIENE LA FECHA DEFAULT DE INICIO Y FIN
            // FIN ES LA FECHA ACTUAL, INICIO ES UN MES ATRAS
            fechaFin = new java.sql.Date((currenttime.getTime()).getTime());
            currenttime.add(Calendar.MONTH, -1);
            fechaIni = new java.sql.Date((currenttime.getTime()).getTime());

            accion = request.getParameter("accion");

            if(accion == null){accion = "";}

            // LA ACCION ES BLANCO, INICIALIZA
            if("".compareTo(accion) == 0){
                feIni = formatoFecha.format(fechaIni);
                feFin = formatoFecha.format(fechaFin);
                // PONE LOS DATOS EN BLANCO
                // DATOS ELEGIDOS MAS LISTADO OBTENIDO
                forma.setAccion(      "1");
                forma.setFechaInicio( feIni);
                forma.setFechaFinal(  feFin);
                forma.setBancos (     bancos );
                session.setAttribute("datos", forma);
            // LA ACCION ES 0, CANCELAR
            }else if("0".compareTo(accion) == 0){
                url = "/index.jsp";
            }else{
                try{
                    // PONE LOS CRITERIOS
                    criterios.setIni(           request.getParameter("fechaInicio"));
                    criterios.setFin(           request.getParameter("fechaFinal"));
                    criterios.setBanco(         request.getParameterValues("banco"));
                    criterios.setOwner(         owner);

                    fis                         = new FileInputStream(rutaReportes + "/SICCMR0065.jasper");
                    bufferedInputStream         = new BufferedInputStream(fis);
                    reporte                     = (JasperReport) JRLoader.loadObject(bufferedInputStream);

                    parametros.put("logo",      icono.getImage());
                    parametros.put("usuario",   usuario);
                    parametros.put("ini",       criterios.getIni());
                    parametros.put("fin",       criterios.getFin());
                    parametros.put("banco",     modelo.entidadesListaBancos(request.getParameterValues("banco")));

                    formatoSalida = request.getParameter("formato");
                    // HTML
                    if("0".compareTo(formatoSalida) == 0){
                        parametros.put("titulo",   new Integer(1));
                    // EXCEL
                    }else if("1".compareTo(formatoSalida) == 0){
                        parametros.put("titulo",   new Integer(0));
                    // PDF
                    }else{
                        parametros.put("titulo",   new Integer(1));
                    }

                    if(logger != null){
                        logger.info(session.getId()+":"+"El usuario " + this.session.getAttribute("login").toString() +
                                " genero el reporte SICCMR0065 con parametros:FechaIni["+
                                criterios.getIni() + "],FechaFin[" + criterios.getFin() + "],Banco[" +
                                modelo.listaCadenas(request.getParameterValues("banco")) +
                                "]");
                    }

                    // GENERA EL REPORTE
                    resultados  = modelo.consultarSICCMR0065(criterios);
                    dsR         = new JRBeanCollectionDataSource(resultados);
                    jasperPrint = JasperFillManager.fillReport(reporte, parametros, dsR);

                    request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

                    response.setHeader("Pragma",        "no-cache");
                    response.setHeader("Cache-control", "private");
                    response.setDateHeader("Expires",   0);

                    // HTML
                    if("0".compareTo(formatoSalida) == 0){
                        response.setContentType("text/html");
                        response.setHeader("Content-Disposition", "inline; filename=\"SICCMR0065.html\"");
                        exportador = new JRHtmlExporter();
                        exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                        exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                        exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI,"image?image=");
                        exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                        exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(1.5));
                        exportador.exportReport();
                        servletOutputStream = response.getOutputStream();
                        response.setContentLength(baos.size());
                        baos.writeTo(servletOutputStream);
                    // EXCEL
                    }else if("1".compareTo(formatoSalida) == 0){
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
                    }else{
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
                }catch(Exception ex){
                    System.out.println(" Error al generar SICCMR0065:" + ex);
                    ex.printStackTrace();
                }
            }
        }
        else if(action.equals("SICCMR0077"))
        {
            Collection                  listado             = new ArrayList();
            String                      accion              = "";
            String                      feIni               = "";
            String                      feFin               = "";
            SICCMRDAO                   modelo              = new SICCMRDAO();
            Collection                  camarasA            = new ArrayList();
            Collection                  marcas              = new ArrayList();
            Collection                  resultados          = new ArrayList();
            CriteriosObj                criterios           = new CriteriosObj();
            SimpleDateFormat            formatoFecha        = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date               fechaIni            = null;
            java.sql.Date               fechaFin            = null;
            Calendar                    currenttime         = Calendar.getInstance();
            SICCMR0077Form              forma               = new SICCMR0077Form();
            String                      grupo               = (String)session.getAttribute("role");
            String                      fiidUsuario         = (String)session.getAttribute("numFiid");
            String                      owner               = "";
            String                      rutaReportes        = getServletContext().getRealPath("reports");
            String                      rutaImagenes        = getServletContext().getRealPath("pics");
            ImageIcon                   icono               = new ImageIcon(ImageIO.read(new File(rutaImagenes + "/logoProsa.png")));
            FileInputStream             fis                 = null;
            BufferedInputStream         bufferedInputStream = null;
            JasperReport                reporte             = null;
            JRBeanCollectionDataSource  dsR                 = null;
            JasperPrint                 jasperPrint         = null;
            JRExporter                  exportador          = null;
            ServletOutputStream         servletOutputStream = null;
            Map                         parametros          = new HashMap();
            String                      usuario             = (String)session.getAttribute("login");
            String                      formatoSalida       = null;
            ByteArrayOutputStream       baos                = new ByteArrayOutputStream();

            url = "/SICCMR0077.jsp";

            // OBTIENE LA FECHA ACTUAL, ZONA HORARIA DE MEXICO
            currenttime.setTimeZone(TimeZone.getTimeZone("GMT-06:00"));

            // OBTIENE LAS LISTAS DE CATALOGOS
            // LOS USUARIOS DE BANCOS SOLO VEN SUS PROPIOS DATOS
            if(("administrador".compareTo(grupo) == 0) || ("operador".compareTo(grupo) == 0)){
                owner     = "%";
            }else{
                owner     = fiidUsuario;
            }

            camarasA  = modelo.listarCamarasProsa();
            marcas    = modelo.listarMarcas();

            // OBTIENE LA FECHA DEFAULT DE INICIO Y FIN
            // FIN ES LA FECHA ACTUAL, INICIO ES UN MES ATRAS
            fechaFin = new java.sql.Date((currenttime.getTime()).getTime());
            currenttime.add(Calendar.MONTH, -1);
            fechaIni = new java.sql.Date((currenttime.getTime()).getTime());

            accion = request.getParameter("accion");

            if(accion == null){accion = "";}

            // LA ACCION ES BLANCO, INICIALIZA
            if("".compareTo(accion) == 0){
                feIni = formatoFecha.format(fechaIni);
                feFin = formatoFecha.format(fechaFin);
                // PONE LOS DATOS EN BLANCO
                // DATOS ELEGIDOS MAS LISTADO OBTENIDO
                forma.setAccion(      "1");
                forma.setFechaInicio( feIni);
                forma.setFechaFinal(  feFin);
                forma.setCamarasA(    camarasA);
                forma.setMarcas(      marcas);
                session.setAttribute("datos", forma);
            // LA ACCION ES 0, CANCELAR
            }else if("0".compareTo(accion) == 0){
                url = "/index.jsp";
            }else{
                try{
                    // PONE LOS CRITERIOS
                    criterios.setIni(           request.getParameter("fechaInicio"));
                    criterios.setFin(           request.getParameter("fechaFinal"));
                    criterios.setCamaraAdq(     request.getParameterValues("camaraAdq"));
                    criterios.setMarca(         request.getParameterValues("marca"));
                    criterios.setOwner(         owner);

                    fis                         = new FileInputStream(rutaReportes + "/SICCMR0077.jasper");
                    bufferedInputStream         = new BufferedInputStream(fis);
                    reporte                     = (JasperReport) JRLoader.loadObject(bufferedInputStream);

                    parametros.put("logo",      icono.getImage());
                    parametros.put("usuario",   usuario);
                    parametros.put("ini",       criterios.getIni());
                    parametros.put("fin",       criterios.getFin());

                    // PONE TODAS SI SE ELIGIERON TODAS LAS MARCAS
                    if(request.getParameterValues("marca").length != 4){
                        parametros.put("marca",     modelo.descripcionesListaMarcas(request.getParameterValues("marca")));
                    }else{
                        parametros.put("marca",     "TODAS");
                    }
                    parametros.put("camara",    modelo.descripcionesListaCamaras(request.getParameterValues("camaraAdq")));

                    formatoSalida = request.getParameter("formato");
                    // HTML
                    if("0".compareTo(formatoSalida) == 0){
                        parametros.put("titulo",   new Integer(1));
                    // EXCEL
                    }else if("1".compareTo(formatoSalida) == 0){
                        parametros.put("titulo",   new Integer(0));
                    // PDF
                    }else{
                        parametros.put("titulo",   new Integer(1));
                    }

                    if(logger != null){
                        logger.info(session.getId()+":"+"El usuario " + this.session.getAttribute("login").toString() +
                                " genero el reporte SICCMR0077 con parametros:FechaIni["+
                                criterios.getIni() + "],FechaFin[" + criterios.getFin() + "],Marca[" + modelo.descripcionesListaMarcas(request.getParameterValues("marca")) +
                                "],CamaraAdq[" + modelo.descripcionesListaCamaras(request.getParameterValues("camaraAdq")) + "]");
                    }

                    // GENERA EL REPORTE
                    resultados  = modelo.consultarSICCMR0077(criterios);
                    dsR         = new JRBeanCollectionDataSource(resultados);
                    jasperPrint = JasperFillManager.fillReport(reporte, parametros, dsR);

                    request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

                    response.setHeader("Pragma",        "no-cache");
                    response.setHeader("Cache-control", "private");
                    response.setDateHeader("Expires",   0);

                    // HTML
                    if("0".compareTo(formatoSalida) == 0){
                        response.setContentType("text/html");
                        response.setHeader("Content-Disposition", "inline; filename=\"SICCMR0077.html\"");
                        exportador = new JRHtmlExporter();
                        exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                        exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                        exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI,"image?image=");
                        exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                        exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(1.5));
                        exportador.exportReport();
                        servletOutputStream = response.getOutputStream();
                        response.setContentLength(baos.size());
                        baos.writeTo(servletOutputStream);
                    // EXCEL
                    }else if("1".compareTo(formatoSalida) == 0){
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
                    }else{
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
                }catch(Exception ex){
                    System.out.println(" Error al generar SICCMR0077:" + ex);
                    ex.printStackTrace();
                }
            }
        }
        else if(action.equals("SICCMR0087"))
        {
            Collection                  listado             = new ArrayList();
            String                      accion              = "";
            String                      feIni               = "";
            String                      feFin               = "";
            SICCMRDAO                   modelo              = new SICCMRDAO();
            Collection                  camarasE            = new ArrayList();
            Collection                  marcas              = new ArrayList();
            Collection                  resultados          = new ArrayList();
            CriteriosObj                criterios           = new CriteriosObj();
            SimpleDateFormat            formatoFecha        = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date               fechaIni            = null;
            java.sql.Date               fechaFin            = null;
            Calendar                    currenttime         = Calendar.getInstance();
            SICCMR0087Form              forma               = new SICCMR0087Form();
            String                      grupo               = (String)session.getAttribute("role");
            String                      fiidUsuario         = (String)session.getAttribute("numFiid");
            String                      owner               = "";
            String                      rutaReportes        = getServletContext().getRealPath("reports");
            String                      rutaImagenes        = getServletContext().getRealPath("pics");
            ImageIcon                   icono               = new ImageIcon(ImageIO.read(new File(rutaImagenes + "/logoProsa.png")));
            FileInputStream             fis                 = null;
            BufferedInputStream         bufferedInputStream = null;
            JasperReport                reporte             = null;
            JRBeanCollectionDataSource  dsR                 = null;
            JasperPrint                 jasperPrint         = null;
            JRExporter                  exportador          = null;
            ServletOutputStream         servletOutputStream = null;
            Map                         parametros          = new HashMap();
            String                      usuario             = (String)session.getAttribute("login");
            String                      formatoSalida       = null;
            ByteArrayOutputStream       baos                = new ByteArrayOutputStream();

            url = "/SICCMR0087.jsp";

            // OBTIENE LA FECHA ACTUAL, ZONA HORARIA DE MEXICO
            currenttime.setTimeZone(TimeZone.getTimeZone("GMT-06:00"));

            // OBTIENE LAS LISTAS DE CATALOGOS
            // LOS USUARIOS DE BANCOS SOLO VEN SUS PROPIOS DATOS
            if(("administrador".compareTo(grupo) == 0) || ("operador".compareTo(grupo) == 0)){
                owner     = "%";
            }else{
                owner     = fiidUsuario;
            }

            camarasE  = modelo.listarCamarasEglo();
            marcas    = modelo.listarMarcas();

            // OBTIENE LA FECHA DEFAULT DE INICIO Y FIN
            // FIN ES LA FECHA ACTUAL, INICIO ES UN MES ATRAS
            fechaFin = new java.sql.Date((currenttime.getTime()).getTime());
            currenttime.add(Calendar.MONTH, -1);
            fechaIni = new java.sql.Date((currenttime.getTime()).getTime());

            accion = request.getParameter("accion");

            if(accion == null){accion = "";}

            // LA ACCION ES BLANCO, INICIALIZA
            if("".compareTo(accion) == 0){
                feIni = formatoFecha.format(fechaIni);
                feFin = formatoFecha.format(fechaFin);
                // PONE LOS DATOS EN BLANCO
                // DATOS ELEGIDOS MAS LISTADO OBTENIDO
                forma.setAccion(      "1");
                forma.setFechaInicio( feIni);
                forma.setFechaFinal(  feFin);
                forma.setCamarasE(    camarasE);
                forma.setMarcas(      marcas);
                session.setAttribute("datos", forma);
            // LA ACCION ES 0, CANCELAR
            }else if("0".compareTo(accion) == 0){
                url = "/index.jsp";
            }else{
                try{
                    // PONE LOS CRITERIOS
                    criterios.setIni(           request.getParameter("fechaInicio"));
                    criterios.setFin(           request.getParameter("fechaFinal"));
                    criterios.setCamaraEmi(     request.getParameterValues("camaraEmi"));
                    criterios.setMarca(         request.getParameterValues("marca"));
                    criterios.setOwner(         owner);

                    fis                         = new FileInputStream(rutaReportes + "/SICCMR0087.jasper");
                    bufferedInputStream         = new BufferedInputStream(fis);
                    reporte                     = (JasperReport) JRLoader.loadObject(bufferedInputStream);

                    parametros.put("logo",      icono.getImage());
                    parametros.put("usuario",   usuario);
                    parametros.put("ini",       criterios.getIni());
                    parametros.put("fin",       criterios.getFin());

                    // PONE TODAS SI SE ELIGIERON TODAS LAS MARCAS
                    if(request.getParameterValues("marca").length != 4){
                        parametros.put("marca",     modelo.descripcionesListaMarcas(request.getParameterValues("marca")));
                    }else{
                        parametros.put("marca",     "TODAS");
                    }
                    parametros.put("camara",    modelo.descripcionesListaCamaras(request.getParameterValues("camaraEmi")));

                    formatoSalida = request.getParameter("formato");
                    // HTML
                    if("0".compareTo(formatoSalida) == 0){
                        parametros.put("titulo",   new Integer(1));
                    // EXCEL
                    }else if("1".compareTo(formatoSalida) == 0){
                        parametros.put("titulo",   new Integer(0));
                    // PDF
                    }else{
                        parametros.put("titulo",   new Integer(1));
                    }

                    if(logger != null){
                        logger.info(session.getId()+":"+"El usuario " + this.session.getAttribute("login").toString() +
                                " genero el reporte SICCMR0087 con parametros:FechaIni["+
                                criterios.getIni() + "],FechaFin[" + criterios.getFin() + "],Marca[" + modelo.descripcionesListaMarcas(request.getParameterValues("marca")) +
                                "],CamaraEmi[" + modelo.descripcionesListaCamaras(request.getParameterValues("camaraEmi")) + "]");
                    }

                    // GENERA EL REPORTE
                    resultados  = modelo.consultarSICCMR0087(criterios);
                    dsR         = new JRBeanCollectionDataSource(resultados);
                    jasperPrint = JasperFillManager.fillReport(reporte, parametros, dsR);

                    request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

                    response.setHeader("Pragma",        "no-cache");
                    response.setHeader("Cache-control", "private");
                    response.setDateHeader("Expires",   0);

                    // HTML
                    if("0".compareTo(formatoSalida) == 0){
                        response.setContentType("text/html");
                        response.setHeader("Content-Disposition", "inline; filename=\"SICCMR0087.html\"");
                        exportador = new JRHtmlExporter();
                        exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                        exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                        exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI,"image?image=");
                        exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                        exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(1.5));
                        exportador.exportReport();
                        servletOutputStream = response.getOutputStream();
                        response.setContentLength(baos.size());
                        baos.writeTo(servletOutputStream);
                    // EXCEL
                    }else if("1".compareTo(formatoSalida) == 0){
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
                    }else{
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
                }catch(Exception ex){
                    System.out.println(" Error al generar SICCMR0087:" + ex);
                    ex.printStackTrace();
                }
            }
        }
        else if(action.equals("SICCMRC200"))
        {
            Collection                  listado             = new ArrayList();
            String                      accion              = "";
            String                      feIni               = "";
            String                      feFin               = "";
            SICCMRDAO                   modelo              = new SICCMRDAO();
            Collection                  bancos              = new ArrayList();
            Collection                  resultados          = new ArrayList();
            CriteriosObj                criterios           = new CriteriosObj();
            SimpleDateFormat            formatoFecha        = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date               fechaIni            = null;
            java.sql.Date               fechaFin            = null;
            Calendar                    currenttime         = Calendar.getInstance();
            SICCMRC200Form              forma               = new SICCMRC200Form();
            String                      grupo               = (String)session.getAttribute("role");
            String                      fiidUsuario         = (String)session.getAttribute("numFiid");
            String                      owner               = "";
            String                      rutaReportes        = getServletContext().getRealPath("reports");
            String                      rutaImagenes        = getServletContext().getRealPath("pics");
            ImageIcon                   icono               = new ImageIcon(ImageIO.read(new File(rutaImagenes + "/logoProsa.png")));
            FileInputStream             fis                 = null;
            BufferedInputStream         bufferedInputStream = null;
            JasperReport                reporte             = null;
            JRBeanCollectionDataSource  dsR                 = null;
            JasperPrint                 jasperPrint         = null;
            JRExporter                  exportador          = null;
            ServletOutputStream         servletOutputStream = null;
            Map                         parametros          = new HashMap();
            String                      usuario             = (String)session.getAttribute("login");
            String                      formatoSalida       = null;
            ByteArrayOutputStream       baos                = new ByteArrayOutputStream();

            url = "/SICCMRC200.jsp";

            // OBTIENE LA FECHA ACTUAL, ZONA HORARIA DE MEXICO
            currenttime.setTimeZone(TimeZone.getTimeZone("GMT-06:00"));

            // OBTIENE LAS LISTAS DE CATALOGOS
            // LOS USUARIOS DE BANCOS SOLO VEN SUS PROPIOS DATOS
            if(("administrador".compareTo(grupo) == 0) || ("operador".compareTo(grupo) == 0)){
                owner     = "%";
                bancos    = modelo.listarBancos0200();
            }else{
                owner     = fiidUsuario;
                bancos    = modelo.nombresBancos(modelo.convierteCadena(modelo.entidadBanco(fiidUsuario)));
            }

            // OBTIENE LA FECHA DEFAULT DE INICIO Y FIN
            // FIN ES LA FECHA ACTUAL, INICIO ES UN MES ATRAS
            fechaFin = new java.sql.Date((currenttime.getTime()).getTime());
            currenttime.add(Calendar.MONTH, -1);
            fechaIni = new java.sql.Date((currenttime.getTime()).getTime());

            accion = request.getParameter("accion");

            if(accion == null){accion = "";}

            // LA ACCION ES BLANCO, INICIALIZA
            if("".compareTo(accion) == 0){
                feIni = formatoFecha.format(fechaIni);
                feFin = formatoFecha.format(fechaFin);
                // PONE LOS DATOS EN BLANCO
                // DATOS ELEGIDOS MAS LISTADO OBTENIDO
                forma.setAccion(      "1");
                forma.setFechaInicio( feIni);
                forma.setFechaFinal(  feFin);
                forma.setBancos (     bancos );
                session.setAttribute("datos", forma);
            // LA ACCION ES 0, CANCELAR
            }else if("0".compareTo(accion) == 0){
                url = "/index.jsp";
            }else{
                try{
                    // PONE LOS CRITERIOS
                    criterios.setIni(           request.getParameter("fechaInicio"));
                    criterios.setFin(           request.getParameter("fechaFinal"));
                    criterios.setBanco(         request.getParameterValues("banco"));
                    criterios.setOwner(         owner);

                    fis                         = new FileInputStream(rutaReportes + "/SICCMRC200.jasper");
                    bufferedInputStream         = new BufferedInputStream(fis);
                    reporte                     = (JasperReport) JRLoader.loadObject(bufferedInputStream);

                    parametros.put("logo",      icono.getImage());
                    parametros.put("usuario",   usuario);
                    parametros.put("ini",       criterios.getIni());
                    parametros.put("fin",       criterios.getFin());
                    parametros.put("banco",     modelo.entidadesListaBancos(request.getParameterValues("banco")));

                    formatoSalida = request.getParameter("formato");
                    // HTML
                    if("0".compareTo(formatoSalida) == 0){
                        parametros.put("titulo",   new Integer(1));
                    // EXCEL
                    }else if("1".compareTo(formatoSalida) == 0){
                        parametros.put("titulo",   new Integer(0));
                    // PDF
                    }else{
                        parametros.put("titulo",   new Integer(1));
                    }

                    if(logger != null){
                        logger.info(session.getId()+":"+"El usuario " + this.session.getAttribute("login").toString() +
                                " genero el reporte SICCMRC200 con parametros:FechaIni["+
                                criterios.getIni() + "],FechaFin[" + criterios.getFin() + "],Banco[" +
                                modelo.listaCadenas(request.getParameterValues("banco")) + "]");
                    }

                    // GENERA EL REPORTE
                    resultados  = modelo.consultar0200(criterios);
                    dsR         = new JRBeanCollectionDataSource(resultados);
                    jasperPrint = JasperFillManager.fillReport(reporte, parametros, dsR);

                    request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

                    response.setHeader("Pragma",        "no-cache");
                    response.setHeader("Cache-control", "private");
                    response.setDateHeader("Expires",   0);

                    // HTML
                    if("0".compareTo(formatoSalida) == 0){
                        response.setContentType("text/html");
                        response.setHeader("Content-Disposition", "inline; filename=\"SICCMRC200.html\"");
                        exportador = new JRHtmlExporter();
                        exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                        exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                        exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI,"image?image=");
                        exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                        exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(1.5));
                        exportador.exportReport();
                        servletOutputStream = response.getOutputStream();
                        response.setContentLength(baos.size());
                        baos.writeTo(servletOutputStream);
                    // EXCEL
                    }else if("1".compareTo(formatoSalida) == 0){
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
                    }else{
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
                }catch(Exception ex){
                    System.out.println(" Error al generar SICCMRC200:" + ex);
                    ex.printStackTrace();
                }
            }
        }
        else if(action.equals("SICCMRC320"))
        {
            Collection                  listado             = new ArrayList();
            String                      accion              = "";
            String                      feIni               = "";
            String                      feFin               = "";
            SICCMRDAO                   modelo              = new SICCMRDAO();
            Collection                  resultados          = new ArrayList();
            Collection                  resultados2         = new ArrayList();
            CriteriosObj                criterios           = new CriteriosObj();
            SimpleDateFormat            formatoFecha        = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date               fechaIni            = null;
            java.sql.Date               fechaFin            = null;
            Calendar                    currenttime         = Calendar.getInstance();
            SICCMRC320Form              forma               = new SICCMRC320Form();
            String                      grupo               = (String)session.getAttribute("role");
            String                      fiidUsuario         = (String)session.getAttribute("numFiid");
            String                      owner               = "";
            String                      rutaReportes        = getServletContext().getRealPath("reports");
            String                      rutaImagenes        = getServletContext().getRealPath("pics");
            ImageIcon                   icono               = new ImageIcon(ImageIO.read(new File(rutaImagenes + "/logoProsa.png")));
            FileInputStream             fis                 = null;
            BufferedInputStream         bufferedInputStream = null;
            JasperReport                reporte             = null;
            JRBeanCollectionDataSource  dsR                 = null;
            JasperPrint                 jasperPrint         = null;
            JRExporter                  exportador          = null;
            ServletOutputStream         servletOutputStream = null;
            Map                         parametros          = new HashMap();
            String                      usuario             = (String)session.getAttribute("login");
            String                      formatoSalida       = null;
            ByteArrayOutputStream       baos                = new ByteArrayOutputStream();
            Collection                  camaras             = new ArrayList();

            url = "/SICCMRC320.jsp";

            // OBTIENE LA FECHA ACTUAL, ZONA HORARIA DE MEXICO
            currenttime.setTimeZone(TimeZone.getTimeZone("GMT-06:00"));

            // OBTIENE LAS LISTAS DE CATALOGOS
            // LOS USUARIOS DE BANCOS SOLO VEN SUS PROPIOS DATOS
            if(("administrador".compareTo(grupo) == 0) || ("operador".compareTo(grupo) == 0)){
                owner     = "%";
            }else{
                owner     = fiidUsuario;
            }
            camaras  = modelo.listarCamaras320();

            // OBTIENE LA FECHA DEFAULT DE INICIO Y FIN
            // FIN ES LA FECHA ACTUAL, INICIO ES UN MES ATRAS
            fechaFin = new java.sql.Date((currenttime.getTime()).getTime());
            currenttime.add(Calendar.MONTH, -1);
            fechaIni = new java.sql.Date((currenttime.getTime()).getTime());

            accion = request.getParameter("accion");

            if(accion == null){accion = "";}

            // LA ACCION ES BLANCO, INICIALIZA
            if("".compareTo(accion) == 0){
                feIni = formatoFecha.format(fechaIni);
                feFin = formatoFecha.format(fechaFin);
                // PONE LOS DATOS EN BLANCO
                // DATOS ELEGIDOS MAS LISTADO OBTENIDO
                forma.setAccion(      "1");
                forma.setFechaInicio( feIni);
                forma.setFechaFinal(  feFin);
                forma.setCamarasA(    camaras);
                session.setAttribute("datos", forma);
            // LA ACCION ES 0, CANCELAR
            }else if("0".compareTo(accion) == 0){
                url = "/index.jsp";
            }else{
                try{
                    // PONE LOS CRITERIOS
                    criterios.setIni(           request.getParameter("fechaInicio"));
                    criterios.setFin(           request.getParameter("fechaFinal"));
                    criterios.setCamaraAdq(     request.getParameterValues("camaraAdq"));

                    fis                         = new FileInputStream(rutaReportes + "/SICCMRC320.jasper");
                    bufferedInputStream         = new BufferedInputStream(fis);
                    reporte                     = (JasperReport) JRLoader.loadObject(bufferedInputStream);

                    parametros.put("logo",      icono.getImage());
                    parametros.put("usuario",   usuario);
                    parametros.put("ini",       criterios.getIni());
                    parametros.put("fin",       criterios.getFin());
                    parametros.put("camara",    modelo.descripcionesListaCamaras(request.getParameterValues("camaraAdq")));
                    parametros.put("SUBREPORT_DIR",rutaReportes + "/");

                    formatoSalida = request.getParameter("formato");
                    // HTML
                    if("0".compareTo(formatoSalida) == 0){
                        parametros.put("titulo2",   new Integer(1));
                    // EXCEL
                    }else if("1".compareTo(formatoSalida) == 0){
                        parametros.put("titulo2",   new Integer(0));
                    // PDF
                    }else{
                        parametros.put("titulo2",   new Integer(1));
                    }

                    if(logger != null){
                        logger.info(session.getId()+":"+"El usuario " + this.session.getAttribute("login").toString() +
                                " genero el reporte SICCMRC320 con parametros:FechaIni["+
                                criterios.getIni() + "],FechaFin[" + criterios.getFin() + "],Camara[" + modelo.descripcionesListaCamaras(request.getParameterValues("camaraAdq")) + "]");
                    }

                    // GENERA EL REPORTE
                    resultados  = modelo.consultarSICCMRC320(criterios);
                    resultados2 = modelo.consultarSICCMRC320_2(criterios);
                    parametros.put("datos2",    resultados2);
                    parametros.put("titulo",    "Camara de Compensacion");
                    dsR         = new JRBeanCollectionDataSource(resultados);
                    jasperPrint = JasperFillManager.fillReport(reporte, parametros, dsR);

                    request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

                    response.setHeader("Pragma",        "no-cache");
                    response.setHeader("Cache-control", "private");
                    response.setDateHeader("Expires",   0);

                    // HTML
                    if("0".compareTo(formatoSalida) == 0){
                        response.setContentType("text/html");
                        response.setHeader("Content-Disposition", "inline; filename=\"SICCMRC320.html\"");
                        exportador = new JRHtmlExporter();
                        exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                        exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                        exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI,"image?image=");
                        exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                        exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(1.5));
                        exportador.exportReport();
                        servletOutputStream = response.getOutputStream();
                        response.setContentLength(baos.size());
                        baos.writeTo(servletOutputStream);
                    // EXCEL
                    }else if("1".compareTo(formatoSalida) == 0){
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
                    }else{
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
                }catch(Exception ex){
                    System.out.println(" Error al generar SICCMRC320:" + ex);
                    ex.printStackTrace();
                }
            }
        }
        else if(action.equals("SICCMRC330"))
        {
            Collection                  listado             = new ArrayList();
            String                      accion              = "";
            String                      feIni               = "";
            String                      feFin               = "";
            SICCMRDAO                   modelo              = new SICCMRDAO();
            Collection                  resultados          = new ArrayList();
            Collection                  resultados2         = new ArrayList();
            CriteriosObj                criterios           = new CriteriosObj();
            SimpleDateFormat            formatoFecha        = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date               fechaIni            = null;
            java.sql.Date               fechaFin            = null;
            Calendar                    currenttime         = Calendar.getInstance();
            SICCMRC330Form              forma               = new SICCMRC330Form();
            String                      grupo               = (String)session.getAttribute("role");
            String                      fiidUsuario         = (String)session.getAttribute("numFiid");
            String                      owner               = "";
            String                      rutaReportes        = getServletContext().getRealPath("reports");
            String                      rutaImagenes        = getServletContext().getRealPath("pics");
            ImageIcon                   icono               = new ImageIcon(ImageIO.read(new File(rutaImagenes + "/logoProsa.png")));
            FileInputStream             fis                 = null;
            BufferedInputStream         bufferedInputStream = null;
            JasperReport                reporte             = null;
            JRBeanCollectionDataSource  dsR                 = null;
            JasperPrint                 jasperPrint         = null;
            JRExporter                  exportador          = null;
            ServletOutputStream         servletOutputStream = null;
            Map                         parametros          = new HashMap();
            String                      usuario             = (String)session.getAttribute("login");
            String                      formatoSalida       = null;
            ByteArrayOutputStream       baos                = new ByteArrayOutputStream();
            Collection                  marcas              = new ArrayList();

            url = "/SICCMRC330.jsp";

            // OBTIENE LA FECHA ACTUAL, ZONA HORARIA DE MEXICO
            currenttime.setTimeZone(TimeZone.getTimeZone("GMT-06:00"));

            // OBTIENE LAS LISTAS DE CATALOGOS
            // LOS USUARIOS DE BANCOS SOLO VEN SUS PROPIOS DATOS
            if(("administrador".compareTo(grupo) == 0) || ("operador".compareTo(grupo) == 0)){
                owner     = "%";
            }else{
                owner     = fiidUsuario;
            }
            marcas  = modelo.listarMarcas330();

            // OBTIENE LA FECHA DEFAULT DE INICIO Y FIN
            // FIN ES LA FECHA ACTUAL, INICIO ES UN MES ATRAS
            fechaFin = new java.sql.Date((currenttime.getTime()).getTime());
            currenttime.add(Calendar.MONTH, -1);
            fechaIni = new java.sql.Date((currenttime.getTime()).getTime());

            accion = request.getParameter("accion");

            if(accion == null){accion = "";}

            // LA ACCION ES BLANCO, INICIALIZA
            if("".compareTo(accion) == 0){
                feIni = formatoFecha.format(fechaIni);
                feFin = formatoFecha.format(fechaFin);
                // PONE LOS DATOS EN BLANCO
                // DATOS ELEGIDOS MAS LISTADO OBTENIDO
                forma.setAccion(      "1");
                forma.setFechaInicio( feIni);
                forma.setFechaFinal(  feFin);
                forma.setMarcas(      marcas);
                session.setAttribute("datos", forma);
            // LA ACCION ES 0, CANCELAR
            }else if("0".compareTo(accion) == 0){
                url = "/index.jsp";
            }else{
                try{
                    // PONE LOS CRITERIOS
                    criterios.setIni(           request.getParameter("fechaInicio"));
                    criterios.setFin(           request.getParameter("fechaFinal"));
                    criterios.setMarca(         request.getParameterValues("marca"));

                    fis                         = new FileInputStream(rutaReportes + "/SICCMRC330.jasper");
                    bufferedInputStream         = new BufferedInputStream(fis);
                    reporte                     = (JasperReport) JRLoader.loadObject(bufferedInputStream);

                    parametros.put("logo",      icono.getImage());
                    parametros.put("usuario",   usuario);
                    parametros.put("ini",       criterios.getIni());
                    parametros.put("fin",       criterios.getFin());
                    parametros.put("marca",     modelo.descripcionesListaMarcas(request.getParameterValues("marca")));
                    parametros.put("SUBREPORT_DIR",rutaReportes + "/");

                    formatoSalida = request.getParameter("formato");
                    // HTML
                    if("0".compareTo(formatoSalida) == 0){
                        parametros.put("titulo2",   new Integer(1));
                    // EXCEL
                    }else if("1".compareTo(formatoSalida) == 0){
                        parametros.put("titulo2",   new Integer(0));
                    // PDF
                    }else{
                        parametros.put("titulo2",   new Integer(1));
                    }

                    if(logger != null){
                        logger.info(session.getId()+":"+"El usuario " + this.session.getAttribute("login").toString() +
                                " genero el reporte SICCMRC330 con parametros:FechaIni["+
                                criterios.getIni() + "],FechaFin[" + criterios.getFin() + "], Marca[" + modelo.descripcionesListaMarcas(request.getParameterValues("marca")) + "]");
                    }

                    // GENERA EL REPORTE
                    resultados  = modelo.consultarSICCMRC330(criterios);
                    resultados2 = modelo.consultarSICCMRC330_2(criterios);
                    parametros.put("datos2",    resultados2);
                    parametros.put("titulo",    "Marca");
                    dsR         = new JRBeanCollectionDataSource(resultados);
                    jasperPrint = JasperFillManager.fillReport(reporte, parametros, dsR);

                    request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

                    response.setHeader("Pragma",        "no-cache");
                    response.setHeader("Cache-control", "private");
                    response.setDateHeader("Expires",   0);

                    // HTML
                    if("0".compareTo(formatoSalida) == 0){
                        response.setContentType("text/html");
                        response.setHeader("Content-Disposition", "inline; filename=\"SICCMRC330.html\"");
                        exportador = new JRHtmlExporter();
                        exportador.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
                        exportador.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                        exportador.setParameter(JRHtmlExporterParameter.IMAGES_URI,"image?image=");
                        exportador.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, baos);
                        exportador.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(1.5));
                        exportador.exportReport();
                        servletOutputStream = response.getOutputStream();
                        response.setContentLength(baos.size());
                        baos.writeTo(servletOutputStream);
                    // EXCEL
                    }else if("1".compareTo(formatoSalida) == 0){
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
                    }else{
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
                }catch(Exception ex){
                    System.out.println(" Error al generar SICCMRC330:" + ex);
                    ex.printStackTrace();
                }
            }
        }
// GSOF-MVR-P-53-2727-14 Marca de Terminacion

        else
        {
            url = "/login.jsp";
        }

        pC.setUrl(url);
        pC.setIsAnswerReport(isAnswerReport);
    }
    // GSOF-MVR-B-54-2092-15 Marca de Terminacion

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, WellException, JDOMException, ParseException {

        String action ;
        String parameter;
        String url ;
        Validador value;
        //fiidManager  inicia = new fiidManager();
        boolean isAnswerReport;
        String diaHabAnt7;
        String diaHabAnt7Historico;
        SimpleDateFormat formato1= new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formato2= new SimpleDateFormat("MM/dd/yyyy");
        String fechaHoy;
/* Inicio modificacion Wellcom N-04-2207-13 14-10-2014*/
        String horaHoy;
/* Fin    modificacion Wellcom N-04-2207-13 14-10-2014*/

        response.setContentType("text/html;charset=UTF-8");

        /**
         * Sesssion Management
         */
        this.session = request.getSession(true);
        this.sessionId = session.getId();
        System.out.println("ControllerServlet session: " + this.sessionId);
        this.session.setMaxInactiveInterval(2400);
        verifySessionConnection(request);
        /**********************************************************************/

        session.setAttribute("FILAS_POR_PAGINA", new Integer(100));
        session.setAttribute("rutaContext", rutaContext);
        SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");


        Date fechaActual = new Date();
/* Inicio modificacion Wellcom N-04-2207-13 14-10-2014*/
                SimpleDateFormat formatoHora= new SimpleDateFormat("HH:mm:ss");
                horaHoy = formatoHora.format(fechaActual);
                session.setAttribute( "horaHoy", horaHoy);
/* Fin    modificacion Wellcom N-04-2207-13 14-10-2014*/
        fechaHoy = formato.format(fechaActual);

        Date fechaAnterior = new Date();
        long fechaAntes = fechaAnterior.getTime() - 8*(24*60*60*1000);
        long fechaAntesHistorico = fechaAnterior.getTime() - 1*(24*60*60*1000);
        diaHabAnt7 = formato.format(fechaAntes);
        diaHabAnt7Historico = formato.format(fechaAntesHistorico);
        session.setAttribute("diaHabAnt7", diaHabAnt7);
        session.setAttribute("diaHabAnt7", diaHabAnt7Historico);

        session.setAttribute( "fechaHoy", fechaHoy);
        try {
            String diaHabAnt = formato.format(TimeUtils.getDiaHabilAnt(session, formato.parse(fechaHoy)));
            session.setAttribute( "diaHabAnt", diaHabAnt);
        } catch (WellException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        /**
         * tg_GGE2
         * En esta parte se pegan las lineas siguientes
         */
        String posicion = request.getParameter("p");
        posicion = Posicion(posicion);

        /**
         * fin de las lineas a pegar
         */

        session.setAttribute("pos", posicion);

        /**
         * Action Management
         */
        action = request.getParameter("action");
        parameter = null;
        url = "/login.jsp";
        value = new Validador();
        //fiidManager  inicia = new fiidManager();
        isAnswerReport=false;

        if(this.session.getAttribute("baseURL")==null)
            this.session.setAttribute("baseURL", this.baseURL);

       if(session.getAttribute("viewerManager")==null){

            viewerManager=new ViewerManager();
            session.setAttribute("viewerManager", viewerManager);
        }else
            viewerManager=(ViewerManager)session.getAttribute("viewerManager");


        try{
        if(action != null)
        {


            if(this.session.getAttribute("APP_LOGGER_FILE")==null)
                this.session.setAttribute("APP_LOGGER_FILE", getServletContext().getRealPath( getServletContext().getInitParameter("APP_LOGGER_NAME")));
            if(this.session.getAttribute("APP_LOGGER_LEVEL")==null)
                this.session.setAttribute("APP_LOGGER_LEVEL", getServletContext().getInitParameter("APP_LOGGER_LEVEL"));
            String active=getServletContext().getInitParameter("APP_LOGGER_ACTIVE");
            if(active!=null &&active.toUpperCase().equals("TRUE")){
                // GSOF-MVR-B-54-2092-15 Marca de Inicio
                logger=session.getAttribute(session.getId()+"_Log")==null?Logger.getLogger("default"):(Logger)session.getAttribute(session.getId()+"_Log");
                // GSOF-MVR-B-54-2092-15 Marca de Terminacion
                logger.info(session.getId()+":"+"El usuario " + this.session.getAttribute("login").toString() + " solicito la accion: "+action);

            }
                if(action.equals("login"))
                {
                    session.invalidate();
                    url = "/login.jsp";

                }
                else if(action.equals("index"))
                {
                    session.setAttribute( "PRSA_DBL_FIID", this.PRSA_DBL_FIID);
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    try
                    {
                        if(session.getAttribute("inicio")==null||session.getAttribute("inicio").equals("true")){
                            fiidManager  inicia = new fiidManager();
                            inicia.NumeroProsa(session);
                            session.setAttribute("inicio", "false");
                            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                            }
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }String rolSesion = (String)session.getAttribute( "role" ).toString();
                    String est = "";
                    new Mantenimiento();
                    est = Mantenimiento.leeEstado("aplicacion",rutaContext);
                    if(est.equals("2") &&  rolSesion!="administrador")
                    {url = "/indexman.jsp";}
                    else{
                    url = "/index.jsp";
                    }

                }

                /**************     Opciones Menu     *******************/

                else if(action.equals("opcionReportes"))
                {
                    url = "/opcionReportes.jsp";
                }

                else if(action.equals("menu"))
                {
                    url = "/menu.jsp&p="+posicion;
                }

                else if(action.equals("opcionMonitoreoCifras"))
                {
                    url = "/opcionMonitoreoCifras.jsp";
                }

                else if (action.equals("opcionCifrasControl"))
                {
                    url = "/opcionCifrasControl.jsp";
                }

                else if(action.equals("opcionLiquidacion"))
                {
                    url = "/opcionLiquidacion.jsp";
                }

                else if(action.equals("opcionIntegracion"))
                {
                    url = "/opcionIntegracion.jsp";
                }

                else if(action.equals("opcionInterredes"))
                {
                    url = "/opcionInterredes.jsp";
                }

                else if(action.equals("opcionIntercambio"))
                {
                    url = "/opcionIntercambio.jsp";
                }

                else if(action.equals("opcionProsa"))
                {
                    url = "/opcionProsa.jsp";
                }

                else if(action.equals("opcionMonitoreoTransacc"))
                {
                    url = "/opcionMonitoreoTransacc.jsp";
                }
                else if(action.equals("manto"))
                {

                    url = "/mantenimientoHeader.jsp";
                }

                /*Modificacion: Marca de inicio ENOVA-VHMG Z-04-3155-11*/
                else if(action.equals("SICLIF0301"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    session.setAttribute( "PRSA_TIPOS_TRANSACCION", this.PRSA_TIPOS_TRANSACCION);
                    session.setAttribute( "SZ_TC_GRP", this.SZ_TC_GRP);
                    session.setAttribute( "PRSA_ARCHIVOS", this.PRSA_ARCHIVOS);

                    url = "/SICLIF0301F.jsp";
                }
                /*Modificacion: Marca de terminacion ENOVA-VHMG Z-04-3155-11*/

                else if(action.equals("CONSTRUCCION"))
                {

                    url = "/construccionHeader.jsp";
                }

                /**************     Reportes   *********************/

                //else if(action.equals("reintegro")) {
                //  url = "/reintegro.jsp";
                //}
                else if(action.equals("SICMOR0200H")) {
                    url = "/SICMOR0200H.jsp";
                }
                else if(action.equals("SICMOR0300H")) {
                    url = "/SICMOR0300H.jsp";
                }
                else if(action.equals("SICMOR0301H")){
                    url = "/SICMOR0301H.jsp";
                }
                else if(action.equals("SICMOR0330H")) {
                    url = "/SICMOR0330H.jsp";
                }
            //  ---------------------------------------------------------------------------------//
            //  -- Marca del Cambio : WELL-EMQ-P-02-1202-09 Inicia la Modificacion   08/02/2010 -//
            //  ---------------------------------------------------------------------------------//
                //pantalla prefijos 2
                else if (action.equals("inserta"))
                {
                    url = "/insertar.jsp";
                }
                else if (action.equals("losprefijos"))
                {
                    url = "/losprefijosheader.jsp";
                }
                else if (action.equals("losprefijosmain"))
                {
                    url = "/losprefijosmain.jsp";
                }
                else if (action.equals("elimodprefijo") || action.equals("modificaprefijo"))
                {
                    url = "/elimodprefijo.jsp";
                }
            //  -----------------------------------------------------------------------------------//
            //  -- Marca del Cambio : WELL-EMQ-P-02-1202-09 Finaliza la Modificacion   08/02/2010 -//
            //  -----------------------------------------------------------------------------------//
	/*  ---------------------------------------------------------------------------------
    -- Marca del Cambio : SAS-LERC-C-52-8021-16 Inicia la Modificacion 05/09/2016
    ---------------------------------------------------------------------------------*/     
			//Reporte 0810
               /* else if(action.equals("SICMOR0810"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICMOR0810Header.jsp";
                }
                else if(action.equals("SICMOR0810Main"))
                {
                String txtfStartDate = request.getParameter("txtfStartDate");
                String txtfEndDate = request.getParameter("txtfEndDate");
                String determinante = request.getParameter("determinante");
                String []entidadArray = request.getParameterValues("interred");
                String []divisiones = request.getParameterValues("division"); //120


                String interredesStr="";
                for(String interred:entidadArray){
                    if(!interredesStr.equals(""))
                        interredesStr+=",";
                    interredesStr+=interred;
                }

                String divisionesStr="";
                for(String division:divisiones){
                    if(!divisionesStr.equals(""))
                        divisionesStr+=",";
                    divisionesStr+=division;
                }


                    session.setAttribute( "txtfStartDate", txtfStartDate);
                    session.setAttribute( "txtfEndDate", txtfEndDate);
                    session.setAttribute( "entidad", interredesStr);
                    session.setAttribute( "division", divisionesStr);
                    session.setAttribute( "determinante", determinante);
                    try
                    {
                        url = value.valida(session, txtfStartDate, txtfEndDate, "SICMOR0810");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }
*/
	/*  ---------------------------------------------------------------------------------
    -- Marca del Cambio : SAS-LERC-C-52-8021-16 Fin la Modificacion 05/09/2016
    ---------------------------------------------------------------------------------*/		
                // SICMIF0150
                else if(action.equals("SICMIF0150"))
                    {
                        session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                        session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                        session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                        url = "/SICMIF0150Header.jsp";
                    }
                    else if(action.equals("SICMIF0150Main"))
                    {
                        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                        String initDate = request.getParameter("txtfStartDate");
                        String endDate = request.getParameter("txtfEndDate");
                        String banco = request.getParameter("banco");
                        String btnLstTOC = request.getParameter("btnLstTOC");

                        session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                        session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                        session.setAttribute("txtfStartDate", initDate);
                        session.setAttribute("txtfEndDate", endDate);
                        session.setAttribute("banco", banco);
                        if(btnLstTOC.equals("Detalle Tx Electro."))
                            session.setAttribute("tipo", "1");
                        else if(btnLstTOC.equals("Total Tx Electro."))
                            session.setAttribute("tipo", "2");
                        else if(btnLstTOC.equals("Detalle Tx Papel"))
                            session.setAttribute("tipo", "3");
                        else if(btnLstTOC.equals("Total Tx Papel"))
                            session.setAttribute("tipo", "4");
                        else if(btnLstTOC.equals("Contrecargos y Representaciones"))
                            session.setAttribute("tipo", "5");
                        else
                            session.setAttribute("tipo", null);
                        try
                        {
                            try
                            {
                                if(format.parse(initDate).compareTo(format.parse(diaHabAnt7))>0)
                                {
                            url = value.valida(session, initDate, endDate, "Sicmif0150");
                            viewerManager.setUpViewer(this, request, response, url);
                            isAnswerReport=true;
                                }
                                else
                                    url = "/fechasInvalidas.jsp?noPantalla=4";
                            }
                            catch(Exception ex)
                            {
                                throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                            }
                        }
                        catch (WellException e)
                        {
                            e.printStackTrace();
                        }
                    }


              /*--------------------------------------------------------------------------- */
                /* Marca del Cambio: AXIA-MN-P-60-2646-14 Inicia  la Modificacion 24/02/2015 */
                /*----------------------------------------------------------------------------*/
                
              /*----------------------------------------------------------------------------*/
              /*Marca del Cambio :  AXIA-FJC-P-60-2126-16 Inicia  la Modificacion 31/07/2017*/
              /*----------------------------------------------------------------------------*/
                ///=======Inicia Marca de cambio WELLCOM P-06-2233-13 15-05-2015 =======================
                                //Reporte SICLICI200
                                    else if(action.equals("SICLICI200"))
                                {
                                    url = "/SICLICI200Header.jsp";
                                }
                                else if(action.equals("SICLICI200Main"))
                                {
                                    String initDate = request.getParameter("txtfStartDate");
                                    String endDate = request.getParameter("txtfEndDate");
                                    String natCon = request.getParameter("natCon");

                                    System.out.println("SICLICI200");

                                    String []bancosAdq = request.getParameterValues("bancoAdq");
                                    String bancosAdqStr="";
                                    for(String bancoAdqr:bancosAdq){
                                        if(!bancosAdqStr.equals(""))
                                            bancosAdqStr+=",";
                                        bancosAdqStr+=bancoAdqr;
                                    }
                                        String []bancosEmi = request.getParameterValues("bancoEmi");
                                    String bancosEmiStr="";
                                    for(String bancoEmir:bancosEmi){
                                        if(!bancosEmiStr.equals(""))
                                            bancosEmiStr+=",";
                                        bancosEmiStr+=bancoEmir;
                                    }
                                    

                                    session.setAttribute( "txtfStartDate", initDate);
                                    session.setAttribute( "txtfEndDate", endDate);
                                    session.setAttribute( "bancoAdq", bancosAdqStr);
                                    session.setAttribute( "bancoEmi", bancosEmiStr);
                                    session.setAttribute( "natCon", natCon);

                                    try
                                    {
                                        url = value.valida(session, initDate, endDate, "SICLICI200");
                                        viewerManager.setUpViewer(this, request, response, url);
                                        isAnswerReport=true;
                                    }
                                    catch (WellException e)
                                    {
                                        e.printStackTrace();
                                    }
                                }

                                //Reporte SICLICP200
                                else if(action.equals("SICLICP200"))
                                {
                                    url = "/SICLICP200Header.jsp";
                                }
                                else if(action.equals("SICLICP200Main"))
                                {
                                    String initDate = request.getParameter("txtfStartDate");
                                    String endDate = request.getParameter("txtfEndDate");
                                    String natCon = request.getParameter("natCon");

                                    System.out.println("SICLICP200");

                                    String []bancosAdq = request.getParameterValues("bancoAdq");
                                    String bancosAdqStr="";
                                    for(String bancoAdqr:bancosAdq){
                                        if(!bancosAdqStr.equals(""))
                                            bancosAdqStr+=",";
                                        bancosAdqStr+=bancoAdqr;
                                    }
                                        String []bancosEmi = request.getParameterValues("bancoEmi");
                                    String bancosEmiStr="";
                                    for(String bancoEmir:bancosEmi){
                                        if(!bancosEmiStr.equals(""))
                                            bancosEmiStr+=",";
                                        bancosEmiStr+=bancoEmir;
                                    }

                                    session.setAttribute( "txtfStartDate", initDate);
                                    session.setAttribute( "txtfEndDate", endDate);
                                    session.setAttribute( "bancoAdq", bancosAdqStr);
                                    session.setAttribute( "bancoEmi", bancosEmiStr);
                                    session.setAttribute( "natCon", natCon);

                                    try
                                    {
                                        url = value.valida(session, initDate, endDate, "SICLICP200");
                                        viewerManager.setUpViewer(this, request, response, url);
                                        isAnswerReport=true;
                                    }
                                    catch (WellException e)
                                    {
                                        e.printStackTrace();
                                    }
                                }


                                //Reporte SICLICC200
                                else if(action.equals("SICLICC200"))
                                {
                                    url = "/SICLICC200Header.jsp";
                                }
                                else if(action.equals("SICLICC200Main"))
                                {
                                    String initDate = request.getParameter("txtfStartDate");
                                    String endDate = request.getParameter("txtfEndDate");
                                    String natCon = request.getParameter("natCon");

                                    System.out.println("SICLICC200");

                                    String []bancosAdq = request.getParameterValues("bancoAdq");
                                    String bancosAdqStr="";
                                    for(String bancoAdqr:bancosAdq){
                                        if(!bancosAdqStr.equals(""))
                                            bancosAdqStr+=",";
                                        bancosAdqStr+=bancoAdqr;
                                    }
                                        String []bancosEmi = request.getParameterValues("bancoEmi");
                                    String bancosEmiStr="";
                                    for(String bancoEmir:bancosEmi){
                                        if(!bancosEmiStr.equals(""))
                                            bancosEmiStr+=",";
                                        bancosEmiStr+=bancoEmir;
                                    }

                                    session.setAttribute( "txtfStartDate", initDate);
                                    session.setAttribute( "txtfEndDate", endDate);
                                    session.setAttribute( "bancoAdq", bancosAdqStr);
                                    session.setAttribute( "bancoEmi", bancosEmiStr);
                                    session.setAttribute( "natCon", natCon);

                                    try
                                    {
                                        url = value.valida(session, initDate, endDate, "SICLICC200");
                                        viewerManager.setUpViewer(this, request, response, url);
                                        isAnswerReport=true;
                                    }
                                    catch (WellException e)
                                    {
                                        e.printStackTrace();
                                    }
                                }

                                //Reporte SICLICE300
                                else if(action.equals("SICLICE300"))
                                {
                                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                                    session.setAttribute( "SICLICC", "SICLICE300" );
                                    url = "/SICLICE300Header.jsp";
                                }
                                else if(action.equals("SICLICE300Main"))
                                {
                                    SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                                    String diaHabAnt = (String)session.getAttribute("diaHabAnt");
                                    String initDate = request.getParameter("txtfStartDate");
                                    String endDate = request.getParameter("txtfEndDate");

                                    String []bancosAdq = request.getParameterValues("bancoAdq");
                                    String bancosAdqStr="";
                                    for(String bancoAdqr:bancosAdq){
                                        if(!bancosAdqStr.equals(""))
                                            bancosAdqStr+=",";
                                        bancosAdqStr+=bancoAdqr;
                                    }

                                        String []bancosEmi = request.getParameterValues("bancoEmi");
                                    String bancosEmiStr="";
                                    for(String bancoEmir:bancosEmi){
                                        if(!bancosEmiStr.equals(""))
                                            bancosEmiStr+=",";
                                        bancosEmiStr+=bancoEmir;
                                    }

                                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                                    session.setAttribute( "txtfStartDate", initDate);
                                    session.setAttribute( "txtfEndDate", endDate);
                                    session.setAttribute( "bancoAdq", bancosAdqStr);
                                    session.setAttribute( "bancoEmi", bancosEmiStr);

                                    try
                                    {
                                        try
                                        {
//                                          if(format.parse(initDate).compareTo(format.parse(diaHabAnt7))>0)
//                                          {
                                                Oparticion(initDate);
                                                url = "/reportsjsp/managerReports.jsp"+"?report="+"SICLICE300";
                                                viewerManager.setUpViewer(this, request, response, url);
                                                isAnswerReport=true;
//                                          }
//                                          else
//                                              url = "/fechasInvalidas.jsp?noPantalla=4";
                                        }
                                        catch(Exception ex)
                                        {
                                            throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                                        }
                                    }
                                    catch (WellException e)
                                    {
                                        e.printStackTrace();
                                    }
                                }
                              
                              /*----------------------------------------------------------------------------*/
                              /*Marca del Cambio :  AXIA-FJC-P-60-2126-16 Termina la Modificacion 31/07/2017*/
                              /*----------------------------------------------------------------------------*/
                                 //Reporte c110
                                else if(action.equals("SICLIRC110"))
                                {
                                    url = "/SICLIRC110Header.jsp";
                                }
                                else if(action.equals("SICLIRC110Main"))
                                {
                                    SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                                    String initDate = request.getParameter("txtfStartDate");
                                    String endDate = request.getParameter("txtfEndDate");

                                    String []bancoEmiArray = request.getParameterValues("bancoEmi");
                                    String bancosEmi="";
                                    for(String banco:bancoEmiArray){
                                        if(!bancosEmi.equals(""))
                                            bancosEmi+=",";
                                        bancosEmi+=banco;
                                    }
                                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                                    session.setAttribute("txtfStartDate", initDate);
                                    session.setAttribute("txtfEndDate", endDate);
                                    session.setAttribute("bancoEmi", bancosEmi);
                                    try
                                    {
                                        url = value.valida(session, initDate, endDate, "Siclirc110");
                                        viewerManager.setUpViewer(this, request, response, url);
                                        isAnswerReport=true;
                                    }
                                    catch (WellException e)
                                    {
                                        e.printStackTrace();
                                    }
                                }

                                 //Reporte c120
                                else if(action.equals("SICLIRC120"))
                                {
                                    url = "/SICLIRC120Header.jsp";
                                }
                                else if(action.equals("SICLIRC120Main"))
                                {
                                    SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                                    String initDate = request.getParameter("txtfStartDate");
                                    String endDate = request.getParameter("txtfEndDate");

                                    String []bancoEmiArray = request.getParameterValues("bancoEmi");
                                    String bancosEmi="";
                                    for(String banco:bancoEmiArray){
                                        if(!bancosEmi.equals(""))
                                            bancosEmi+=",";
                                        bancosEmi+=banco;
                                    }
                                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                                    session.setAttribute("txtfStartDate", initDate);
                                    session.setAttribute("txtfEndDate", endDate);
                                    session.setAttribute("bancoEmi", bancosEmi);
                                    try
                                    {
                                        url = value.valida(session, initDate, endDate, "Siclirc120");
                                        viewerManager.setUpViewer(this, request, response, url);
                                        isAnswerReport=true;
                                    }
                                    catch (WellException e)
                                    {
                                        e.printStackTrace();
                                    }
                                }


                                //Reporte SICLICA170
                                else if(action.equals("SICLICA170"))
                                {
                                    url = "/SICLICA170Header.jsp";
                                }
                                else if(action.equals("SICLICA170Main"))
                                {
                                    String initDate = request.getParameter("txtfStartDate");
                                    String endDate = request.getParameter("txtfEndDate");

                                    System.out.println("SICLICA170");

                                    String []bancosAdq = request.getParameterValues("bancoAdq");
                                    String bancosAdqStr="";
                                    for(String bancoAdqr:bancosAdq){
                                        if(!bancosAdqStr.equals(""))
                                            bancosAdqStr+=",";
                                        bancosAdqStr+=bancoAdqr;
                                    }
                                    session.setAttribute( "txtfStartDate", initDate);
                                    session.setAttribute( "txtfEndDate", endDate);
                                    session.setAttribute( "bancoAdq", bancosAdqStr);

                                    try
                                    {
                                        url = value.valida(session, initDate, endDate, "SICLICA170");
                                        viewerManager.setUpViewer(this, request, response, url);
                                        isAnswerReport=true;
                                    }
                                    catch (WellException e)
                                    {
                                        e.printStackTrace();
                                    }
                                }

                                //Reporte SICLICE170
                                else if(action.equals("SICLICE170"))
                                {
                                    url = "/SICLICE170Header.jsp";
                                }
                                else if(action.equals("SICLICE170Main"))
                                {
                                    String initDate = request.getParameter("txtfStartDate");
                                    String endDate = request.getParameter("txtfEndDate");

                                    System.out.println("SICLICE170");

                                    String []bancosEmi = request.getParameterValues("bancoEmi");//bancoEmi
                                    String bancosEmiStr="";
                                    for(String bancoEmir:bancosEmi){
                                        if(!bancosEmiStr.equals(""))
                                            bancosEmiStr+=",";
                                        bancosEmiStr+=bancoEmir;
                                    }
                                    session.setAttribute( "txtfStartDate", initDate);
                                    session.setAttribute( "txtfEndDate", endDate);
                                    session.setAttribute( "bancoEmi", bancosEmiStr);

                                    try
                                    {
                                        url = value.valida(session, initDate, endDate, "SICLICE170");
                                        viewerManager.setUpViewer(this, request, response, url);
                                        isAnswerReport=true;
                                    }
                                    catch (WellException e)
                                    {
                                        e.printStackTrace();
                                    }
                                }
                ///=======Fin Marca de cambio WELLCOM P-06-2233-13 15-05-2015 =======================
                /*--------------------------------------------------------------------------- */
                /* Marca del Cambio: AXIA-MN-P-60-2646-14 Termina la Modificacion 24/02/2015 */
                /*----------------------------------------------------------------------------*/
                // SICMIF0150H
                    else if(action.equals("SICMIF0150H"))
                        {
                            session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                            session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                            session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                            url = "/SICMIF0150HHeader.jsp";
                        }
                        else if(action.equals("SICMIF0150HMain"))
                        {
                            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                            String initDate = request.getParameter("txtfStartDate");
                            String endDate = request.getParameter("txtfEndDate");
                            String banco = request.getParameter("banco");
                            String btnLstTOC = request.getParameter("btnLstTOC");

                            session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                            session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                            session.setAttribute("txtfStartDate", initDate);
                            session.setAttribute("txtfEndDate", endDate);
                            session.setAttribute("banco", banco);
                            if(btnLstTOC.equals("Detalle Tx Electro."))
                                session.setAttribute("tipo", "1");
                            else if(btnLstTOC.equals("Total Tx Electro."))
                                session.setAttribute("tipo", "2");
                            else if(btnLstTOC.equals("Detalle Tx Papel"))
                                session.setAttribute("tipo", "3");
                            else if(btnLstTOC.equals("Total Tx Papel"))
                                session.setAttribute("tipo", "4");
                            else if(btnLstTOC.equals("Contrecargos y Representaciones"))
                                session.setAttribute("tipo", "5");
                            else
                                session.setAttribute("tipo", null);
                            try
                            {
                                try
                                {
                                            if(format.parse(initDate).compareTo(format.parse(diaHabAnt7Historico))<=0 && format.parse(endDate).compareTo(format.parse(diaHabAnt7Historico))<=0)
                                    {
                                url = value.valida(session, initDate, endDate, "Sicmif0150H");
                                viewerManager.setUpViewer(this, request, response, url);
                                isAnswerReport=true;
                                    }
                                            else
                                                url = "/fechasInvalidas.jsp?noPantalla=5";
                                        }
                                        catch(Exception ex)
                                        {
                                            throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                                        }
                            }
                            catch (WellException e)
                            {
                                e.printStackTrace();
                            }
                        }

                //Reporte 0127_master
/*----------------------------------------------------------------------------*/
/*Marca del Cambio :  AXIA-GGB-P-02-0060-12 Inicia  la Modificacion 19/09/2013*/
/*----------------------------------------------------------------------------*/
/*Marca del Cambio :  AXIA-AHH-P-40-2187-15 Inicia  la Modificacion 30/08/2016*/
/*----------------------------------------------------------------------------*/
                        else if(action.equals("SICMIR0127_MASTER"))
                        {
                            url = "/SICMIR0127_MASTERHeader.jsp";
                        } else if(action.equals("SICMIR0127_MASTERMain")) {

                            SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
                            String inicial = request.getParameter("txtfStartDate");
                            String banco = request.getParameter("banco");
                            String bancoCad = request.getParameter("banco");
                            String ciclo = request.getParameter("ciclo");
                            String dcc = request.getParameter("dcc");

                            if(banco.length()<2)
                            {
                                banco="000"+banco;
                            }
                            else if(banco.length()<3)
                            {
                                banco="00"+banco;
                            }else if(banco.length()<4)
                            {
                                banco="0"+banco;
                            }

                            try
                            {
                            session.setAttribute( "ciclo", ciclo);
                            inicial = formateo.format(formateo.parse(inicial));


                            ArrayList dias;
                            ArrayList tienumero;

                            String SQL="SELECT TO_CHAR(TO_DATE('"+inicial+"','DD/MM/YYYY'),'DDD') FROM DUAL";

                            db.setQuerySelect(SQL);
                            db.executeQuerySelect();
                            dias=db.getRSColsData();
                            db.closeResultSet();


                            String[] vv =(String[]) dias.get(0);
                            session.setAttribute( "initDate", vv[0]);

                        String SQL2="SELECT DISTINCT PE.TIE_NUMERO FROM PMADMIN.PRSA_ENTIDADES PE WHERE PE.NUMERO_PROSA = "+bancoCad;

                            db.setQuerySelect(SQL2);
                            db.executeQuerySelect();
                            tienumero=db.getRSColsData();

                            String[] vv2 =(String[]) tienumero.get(0);

                            String sFichero = "";

                            String tTipo = "";
                            if (vv2[0].equals("1"))//pesos
                            {
                                if (dcc.equals("i")) {
                                  if (banco.equals("0007")) {
                                     banco = "0109";
                                     sFichero = "//aplic//prod//pmt//pmr//mcd//T14004023"+vv[0]+"0"+ciclo;
                                     tTipo ="T14004023";
                                  } else {
                                     sFichero = "//aplic//prod//pmt//pmr//mcd//T14005073"+vv[0]+"0"+ciclo;
                                     tTipo ="T14005073";
                                  }
                                } else {
                                  sFichero = "//aplic//prod//pmt//pmr//mcd//T14002449"+vv[0]+"0"+ciclo;
                                  tTipo ="T14002449";
                                }
                            }
                            else if (vv2[0].equals("9") || banco.equals("1003"))//dolares
                            {
                                sFichero = "//aplic//prod//pmt//pmr//mcd//T14003287"+vv[0]+"0"+ciclo;
                                tTipo ="T14003287";
                            }

                            File fichero = new File(sFichero);
                            if (fichero.exists()) {
                              session.setAttribute( "tipo", tTipo);
                              session.setAttribute( "banco", banco);
                              url = "/reportsjsp/managerReports.jsp"+"?report="+"SICMIR0127_MASTER";
                              viewerManager.setUpViewer(this, request, response, url);
                                    isAnswerReport=true;
                            } else
                              url = "/reportsjsp/Error.jsp";
                            } catch (Exception e) {
                                      e.printStackTrace();
                                  }
                        }
/*----------------------------------------------------------------------------*/
/*Marca del Cambio :  AXIA-AHH-P-40-2187-15 Termina la Modificacion 30/08/2016*/
/*----------------------------------------------------------------------------*/
/*Marca del Cambio :  AXIA-GGB-P-02-0060-12 Termina la Modificacion 19/09/2013*/
/*----------------------------------------------------------------------------*/

                //Reporte B127_master
                else if(action.equals("SICMIRB127_MASTER"))
                {
                    url = "/SICMIRB127_MASTERHeader.jsp";
                }
                else if(action.equals("SICMIRB127_MASTERMain"))
                {

                    SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
                    String inicial = request.getParameter("txtfStartDate");
                    String banco = request.getParameter("banco");
                    String bancoCad = request.getParameter("banco");
                    String ciclo = request.getParameter("ciclo");

                    if(banco.length()<2)
                    {
                        banco="000"+banco;
                    }
                    else if(banco.length()<3)
                    {
                        banco="00"+banco;
                    }else if(banco.length()<4)
                    {
                        banco="0"+banco;
                    }

                    try
                    {
                    session.setAttribute( "banco", banco);
                    session.setAttribute( "ciclo", ciclo);
                    inicial = formateo.format(formateo.parse(inicial));

                    ArrayList dias;
                    ArrayList tienumero;

                    String SQL="SELECT TO_CHAR(TO_DATE('"+inicial+"','DD/MM/YYYY'),'DDD') FROM DUAL";

                    db.setQuerySelect(SQL);
                    db.executeQuerySelect();
                    dias=db.getRSColsData();
                    db.closeResultSet();

                    String[] vv =(String[]) dias.get(0);
                    session.setAttribute( "initDate", vv[0]);

                    String SQL2="SELECT DISTINCT PE.TIE_NUMERO FROM PMADMIN.PRSA_ENTIDADES PE WHERE PE.NUMERO_PROSA = "+bancoCad;

                    db.setQuerySelect(SQL2);
                    db.executeQuerySelect();
                    tienumero=db.getRSColsData();

                    String[] vv2 =(String[]) tienumero.get(0);
                    String sFichero = "";

                    if (vv2[0].equals("1"))//pesos
                    {
                        sFichero = "//aplic//prod//pmt//pmr//mcd//T14002449"+vv[0]+"0"+ciclo;
                        session.setAttribute( "tipo", "T14002449");
                    }
                    else if (vv2[0].equals("9") && (banco.equals("1001")|| banco.equals("1003")|| banco.equals("1004") || banco.equals("1064")))//dolares
                    {
                        sFichero = "//aplic//prod//pmt//pmr//mcd//T14003287"+vv[0]+"0"+ciclo;
                        session.setAttribute( "tipo", "T14003287");
                    }
                    else if (vv2[0].equals("9"))//entidades en dolares, archivo nacional (pesos)
                    {
                        sFichero = "//aplic//prod//pmt//pmr//mcd//T14002449"+vv[0]+"0"+ciclo;
                        session.setAttribute( "tipo", "T14002449");
                    }

                    File fichero = new File(sFichero);
                    System.out.println("Archivo:"+fichero+":");
                    if (fichero.exists())
                    {
                      url = "/reportsjsp/managerReports.jsp"+"?report="+"SICMIRB127_MASTER";
                      viewerManager.setUpViewer(this, request, response, url);
                      isAnswerReport=true;
                    }
                    else
                        url = "/reportsjsp/Error.jsp";
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }

/*----------------------------------------------------------------------------*/
/*Marca del Cambio: AXIA-AHH-P-40-2187-15-D23 Inicia   Modificacion 25/01/2017*/
/*----------------------------------------------------------------------------*/
                //Reporte 0127_bines
                else if(action.equals("SICMIR0127_BINES"))
                {
                    url = "/SICMIR0127_BINESHeader.jsp";
                }
                else if(action.equals("SICMIR0127_BINESMain"))
                {

                    SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat formateo2 = new SimpleDateFormat("yyMMdd");
                    String inicial = request.getParameter("txtfStartDate");
                    String banco = request.getParameter("banco");
                    if(banco.length()<2)
                    {
                        banco="000"+banco;
                        System.out.println("Variable banco es " + banco );
                    }
                    else if(banco.length()<3)
                    {
                        banco="00"+banco;
                        System.out.println("Variable banco es " + banco );
                    }else if(banco.length()<4)
                    {
                        banco="0"+banco;
                        System.out.println("Variable banco es " + banco );
                    }

                    try
                    {
                    session.setAttribute( "banco", banco);
                    String inicial2 = formateo2.format(formateo.parse(inicial));
                    session.setAttribute( "initDate", inicial2);

                    String sFichero = "";

                    if ( banco.equals("1001"))
                    {
                        sFichero = "//aplic//prod//pmt//pmr//vsa//049"+inicial2+"_102";
                        session.setAttribute( "prefijo", "102");
                    }
                    else if (banco.equals("1002") || banco.equals("1003"))
                    {
                        sFichero = "//aplic//prod//pmt//pmr//vsa//049"+inicial2+"_103";
                        session.setAttribute( "prefijo", "103");
                    }
                    else if (banco.equals("0111"))
                    {
                        sFichero = "//aplic//prod//pmt//pmr//vsa//049"+inicial2+"_105";
                        session.setAttribute( "prefijo", "105");
                    }
                    else
                    {
                        sFichero = "//aplic//prod//pmt//pmr//vsa//049"+inicial2+"_101";
                        session.setAttribute( "prefijo", "101");
                    }

                    File fichero = new File(sFichero);
                    if (fichero.exists())
                    {
                      url = "/reportsjsp/managerReports.jsp"+"?report="+"SICMIR0127_BINES";
                      viewerManager.setUpViewer(this, request, response, url);
                      isAnswerReport=true;
                    }
                    else
                        url = "/reportsjsp/Error.jsp";
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
/*----------------------------------------------------------------------------*/
/*Marca del Cambio: AXIA-AHH-P-40-2187-15-D23 Termina  Modificacion 25/01/2017*/
/*----------------------------------------------------------------------------*/


                 //Reporte 0127_vss
/*----------------------------------------------------------------------------*/
/*Marca del Cambio :  AXIA-GGB-P-02-0060-12 Inicia  la Modificacion 19/09/2013*/
/*----------------------------------------------------------------------------*/
/*Marca del Cambio :  AXIA-AHH-P-40-2187-15 Inicia  la Modificacion 30/08/2016*/
/*----------------------------------------------------------------------------*/
/*Marca del Cambio: AXIA-AHH-P-40-2187-15-D23 Inicia   Modificacion 25/01/2017*/
/*----------------------------------------------------------------------------*/
                      else if(action.equals("SICMIR0127_VSS")) {
                        url = "/SICMIR0127_VSSHeader.jsp";
                      } else if(action.equals("SICMIR0127_VSSMain")) {

                            SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
                            SimpleDateFormat formateo2 = new SimpleDateFormat("yyMMdd");
                            String inicial = request.getParameter("txtfStartDate");
                            String banco = request.getParameter("banco");
                            String dcc = request.getParameter("dcc");
                            String prefijo = request.getParameter("prefijo");
                            if(banco.length()<2) {
                                banco="000"+banco;
                            } else if(banco.length()<3) {
                                banco="00"+banco;
                            } else if(banco.length()<4) {
                                banco="0"+banco;
                            }

                            try {
                              session.setAttribute( "banco", banco);
                              String inicial2 = formateo2.format(formateo.parse(inicial));
                              session.setAttribute( "initDate", inicial2);

                              /*----------------------------------------------------------------------------*/
                              /*Marca del Cambio :  AXIA-FJC-P-40-2187-15 Inicia  la Modificacion 13/03/2017*/
                              /*----------------------------------------------------------------------------*/
                              String sFichero = "//aplic//prod//pmt//pmr//vsa//";
                              
                              String sArchivo = "";

                          if(!banco.equals("0000")) {
                          if ( banco.equals("1001") && (prefijo == null || prefijo.equals("102")) && !dcc.equals("i")) {
                                        sArchivo = "049"+inicial2+"_102";
                                     session.setAttribute( "prefijo", "102");
                                      url = "/reportsjsp/managerReports.jsp"+"?report="+"SICMIR0127_VSS";
                          } else if ((banco.equals("1002") || banco.equals("1003")) && (prefijo == null || prefijo.equals("103"))&& !dcc.equals("i")) {
                                        sArchivo = "049"+inicial2+"_103";
                                     session.setAttribute( "prefijo", "103");
                                      url = "/reportsjsp/managerReports.jsp"+"?report="+"SICMIR0127_VSS";
                          } else  if ( banco.equals("0111")) {
                        	     if ( dcc.equals("i") && (prefijo == null || prefijo.equals("105"))) {
                                            banco = "0111";
                                            sArchivo = "049"+inicial2+"_105";
                                            session.setAttribute( "prefijo", "105");
                                            session.setAttribute( "banco", banco);
                                            url = "/reportsjsp/managerReports.jsp"+"?report="+"SICMIR0127_VSS";
                        	     } else {
                        		         url = "/reportsjsp/Error.jsp";
                        	     }
                          } else if ( banco.equals("0007") || banco.equals("0109") ) {
                        	     if ( dcc.equals("i") && (prefijo == null || prefijo.equals("101"))) {
                                   banco = "0109";
                                       sArchivo = "1049"+inicial2+"_101";
                                   session.setAttribute( "prefijo", "101");
                                   session.setAttribute( "banco", banco);
                                   url = "/reportsjsp/managerReports.jsp"+"?report="+"SICMIR0127_VSS";
                               }else if(prefijo == null || prefijo.equals("101")){
                               	   sArchivo = "049"+inicial2+"_101";
                                   session.setAttribute( "prefijo", "101");
                                   url = "/reportsjsp/managerReports.jsp"+"?report="+"SICMIR0127_VSS";
                               } else {
                               	   url = "/reportsjsp/Error.jsp";
                               }
                          } else {
                        	    if ((prefijo == null || prefijo.equals("101")) && !dcc.equals("i")){
                                            sArchivo = "049"+inicial2+"_101";
                                         session.setAttribute( "prefijo", "101");
                                         url = "/reportsjsp/managerReports.jsp"+"?report="+"SICMIR0127_VSS";
                        	    } else {
                        		       url = "/reportsjsp/Error.jsp";
                              }
                          }
                                 sFichero += sArchivo;
                                 File fichero = new File(sFichero);
                                 if (fichero.exists()) {
                                   session.setAttribute( "dcc", dcc);
                                   session.setAttribute( "sArchivo", sArchivo);
                                   
                                 } else
                                    url = "/reportsjsp/Error.jsp";
                           viewerManager.setUpViewer(this, request, response, url);
                           isAnswerReport=true;
                          } else {
                                //for(int i=1;i<=3;i++){
                                if (banco.equals("0111")) {
                                    session.setAttribute( "prefijo", prefijo);
                                    sArchivo = "049"+inicial2+"_"+prefijo;
                                    url = "/reportsjsp/managerReports.jsp"+"?report="+"SICMIR0127_VSS";
                                } else {
                                    prefijo = request.getParameter("prefijo");
                                    if ( dcc.equals("i")) {
                                        sArchivo = "1049"+inicial2+"_" +prefijo;
                                    } else {
                                        sArchivo = "049"+inicial2+"_"+prefijo;
                                    }
                                    
                                    url = "/reportsjsp/managerReports.jsp"+"?report="+"SICMIR0127_VSS";
                                }
                                sFichero += sArchivo;
                                File fichero = new File(sFichero);
                                if (fichero.exists()) {
                                    session.setAttribute( "prefijo", prefijo);
                                    session.setAttribute( "dcc", dcc);
                                    session.setAttribute( "sArchivo", sArchivo);
                                } else {
                                     url = "/reportsjsp/Error.jsp";
                                    
                                }
                                viewerManager.setUpViewer(this, request, response, url);
                                isAnswerReport=true;
                          }
                            }   catch (Exception e) {
                                      e.printStackTrace();
                                  }
                        }
/*----------------------------------------------------------------------------*/
/*Marca del Cambio :  AXIA-FJC-P-40-2187-15 Termina la Modificacion 13/03/2017*/
/*----------------------------------------------------------------------------*/
/*Marca del Cambio: AXIA-AHH-P-40-2187-15-D23 Inicia   Modificacion 25/01/2017*/
/*----------------------------------------------------------------------------*/
/*Marca del Cambio :  AXIA-AHH-P-40-2187-15 Termina la Modificacion 30/08/2016*/
/*----------------------------------------------------------------------------*/
/*Marca del Cambio :  AXIA-GGB-P-02-0060-12 Termina la Modificacion 19/09/2013*/
/*----------------------------------------------------------------------------*/
                //Reporte D127_vss
                else if(action.equals("SICMIRD127_VSS"))
                {
                    url = "/SICMIRD127_VSSHeader.jsp";
                }
                else if(action.equals("SICMIRD127_VSSMain"))
                {

                    SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat formateo2 = new SimpleDateFormat("yyMMdd");
                    String inicial = request.getParameter("txtfStartDate");
                    String banco = request.getParameter("banco");
                    if(banco.length()<2)
                    {
                        banco="000"+banco;
                    }
                    else if(banco.length()<3)
                    {
                        banco="00"+banco;
                    }else if(banco.length()<4)
                    {
                        banco="0"+banco;
                    }

                    try
                    {
                    session.setAttribute( "banco", banco);
                    String inicial2 = formateo2.format(formateo.parse(inicial));
                    session.setAttribute( "initDate", inicial2);

                        String sFichero = "";

                    if ( banco.equals("1001"))
                    {
                        sFichero = "//aplic//prod//pmt//pmr//vsa//049"+inicial2+"_102";
                        session.setAttribute( "prefijo", "102");
                    }
                    else if (banco.equals("1002") || banco.equals("1003"))
                    {
                        sFichero = "//aplic//prod//pmt//pmr//vsa//049"+inicial2+"_103";
                        session.setAttribute( "prefijo", "103");
                    }
                    else
                    {
                        sFichero = "//aplic//prod//pmt//pmr//vsa//049"+inicial2+"_101";
                        session.setAttribute( "prefijo", "101");
                    }

                    File fichero = new File(sFichero);
                    if (fichero.exists())
                    {
                      url = "/reportsjsp/managerReports.jsp"+"?report="+"SICMIRD127_VSS";
                      viewerManager.setUpViewer(this, request, response, url);
                      isAnswerReport=true;
                    }
                    else
                        url = "/reportsjsp/Error.jsp";
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte B127_vss
                else if(action.equals("SICMIRB127_VSS"))
                {
                    //session.setAttribute( "ENTIDADES", this.ENTIDADES );
                    url = "/SICMIRB127_VSSHeader.jsp";
                }
                else if(action.equals("SICMIRB127_VSSMain"))
                {

                    SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat formateo2 = new SimpleDateFormat("yyMMdd");
                    String inicial = request.getParameter("txtfStartDate");
                    String banco = request.getParameter("banco");
                    if(banco.length()<2)
                    {
                        banco="000"+banco;
                        System.out.println("Variable banco es " + banco );
                    }
                    else if(banco.length()<3)
                    {
                        banco="00"+banco;
                        System.out.println("Variable banco es " + banco );
                    }else if(banco.length()<4)
                    {
                        banco="0"+banco;
                        System.out.println("Variable banco es " + banco );
                    }

                    try
                    {
                    session.setAttribute( "banco", banco);
                    String inicial2 = formateo2.format(formateo.parse(inicial));
                    session.setAttribute( "initDate", inicial2);

                        String sFichero = "";

                    if ( banco.equals("1001"))
                    {
                        sFichero = "//aplic//prod//pmt//pmr//vsa//049"+inicial2+"_102";
                        session.setAttribute( "prefijo", "102");
                    }
                    else if (banco.equals("1002") || banco.equals("1003"))
                    {
                        sFichero = "//aplic//prod//pmt//pmr//vsa//049"+inicial2+"_103";
                        session.setAttribute( "prefijo", "103");
                    }
                    else
                    {
                        sFichero = "//aplic//prod//pmt//pmr//vsa//049"+inicial2+"_101";
                        session.setAttribute( "prefijo", "101");
                    }


                    File fichero = new File(sFichero);
                    System.out.println("El fichero es: " + sFichero );
                    if (fichero.exists())
                    {
                        System.out.println("El fichero " + sFichero + " existe");
                      url = "/reportsjsp/managerReports.jsp"+"?report="+"SICMIRB127_VSS";
                      viewerManager.setUpViewer(this, request, response, url);
                      isAnswerReport=true;
                    }
                    else
                        url = "/reportsjsp/Error.jsp";
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
/*----------------------------------------------------------------------------*/
/*Marca del Cambio :  AXIA-GGB-P-04-3027-13 Inicia  la Modificacion 23/12/2013*/
/*----------------------------------------------------------------------------*/
                 //Reporte 0127_vss Liverpool

                 else if(action.equals("SICMIR0127_LIV"))
                         url = "/SICMIR0127_LIVHeader.jsp";
                 else if(action.equals("SICMIR0127_LIVMain")) {
                   SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
                   SimpleDateFormat formateo2 = new SimpleDateFormat("yyMMdd");
                   String inicial = request.getParameter("txtfStartDate");
                   String corte = request.getParameter("corte");
                   String sFichero = "";
                   String banco = request.getParameter("banco");
                       if(banco.length()<2)
                         banco="000"+banco;
                       else if(banco.length()<3)
                         banco="00"+banco;
                       else if(banco.length()<4)
                     banco="0"+banco;

                   try {

                         String inicial2 = formateo2.format(formateo.parse(inicial));
                         session.setAttribute( "initDate", inicial2);
                         session.setAttribute( "banco", banco);
                         sFichero = "//aplic//prod//pmt//pmr//vsa//VSAINCLIVPD" + inicial2 + "EE0" + corte + ".DAT";
                         session.setAttribute( "prefijo", corte);

                         File fichero = new File(sFichero);
                         if (fichero.exists()) {
                           url = "/reportsjsp/managerReports.jsp"+"?report="+"SICMIR0127_LIV";
                           viewerManager.setUpViewer(this, request, response, url);
                           isAnswerReport=true;
                         } else
                           url = "/reportsjsp/Error.jsp";
                       } catch (Exception e) {
                     e.printStackTrace();
                   }
                }
/*----------------------------------------------------------------------------*/
/*Marca del Cambio :  AXIA-GGB-P-04-3027-13 Termina la Modificacion 23/12/2013*/
/*----------------------------------------------------------------------------*/
                //Reporte 0147
                else if(action.equals("SICMIR0147"))
                {
                    url = "/SICMIR0147Header.jsp";
                }
                else if(action.equals("SICMIR0147Main"))
                {

                    SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat formateo2 = new SimpleDateFormat("yyMMdd");
                    String inicial = request.getParameter("txtfStartDate");
                    String banco = request.getParameter("banco");

                    try
                    {
                    session.setAttribute( "banco", banco);
                    String inicial2 = formateo2.format(formateo.parse(inicial));
                    session.setAttribute( "initDate", inicial2);

                    String sFichero = "//aplic//prod//pmt//pmr//mcd//728"+inicial2+"_"+banco;
                    File fichero = new File(sFichero);
                    System.out.println("El fichero es: " + sFichero );
                    if (fichero.exists())
                    {
                      url = "/reportsjsp/managerReports.jsp"+"?report="+"SICMIR0147";
                      viewerManager.setUpViewer(this, request, response, url);
                      isAnswerReport=true;
                    }
                    else
                        url = "/reportsjsp/Error.jsp";
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte 0148
                else if(action.equals("SICMIR0148"))
                {
                    //session.setAttribute( "ENTIDADES", this.ENTIDADES );
                    url = "/SICMIR0148Header.jsp";
                }
                else if(action.equals("SICMIR0148Main"))
                {

                    SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat formateo2 = new SimpleDateFormat("yyMMdd");
                    String inicial = request.getParameter("txtfStartDate");
                    String icaBanco = request.getParameter("banco");

                    try
                    {
                    String inicial2 = formateo2.format(formateo.parse(inicial));
                    session.setAttribute( "initDate", inicial2);
                    session.setAttribute( "icaBanco", icaBanco);

                    String sFichero = "//aplic//prod//pmt//pmr//mcd//851"+inicial2;
                    File fichero = new File(sFichero);
                    if (fichero.exists())
                    {
                      url = "/reportsjsp/managerReports.jsp"+"?report="+"SICMIR0148";
                      viewerManager.setUpViewer(this, request, response, url);
                      isAnswerReport=true;
                    }
                    else
                        url = "/reportsjsp/Error.jsp";
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte 0148b
                else if(action.equals("SICMIR0148b"))
                {
                    //session.setAttribute( "ENTIDADES", this.ENTIDADES );
                    url = "/SICMIR0148bHeader.jsp";
                }
                else if(action.equals("SICMIR0148bMain"))
                {

                    SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat formateo2 = new SimpleDateFormat("yyMMdd");
                    String inicial = request.getParameter("txtfStartDate");

                    try
                    {
                    String inicial2 = formateo2.format(formateo.parse(inicial));
                    session.setAttribute( "initDate", inicial2);

                    String sFichero = "//aplic//prod//pmt//pmr//mcd//852"+inicial2;
                    File fichero = new File(sFichero);
                    System.out.println("El fichero es: " + sFichero );
                    if (fichero.exists())
                    {
                      url = "/reportsjsp/managerReports.jsp"+"?report="+"SICMIR0148b";
                      viewerManager.setUpViewer(this, request, response, url);
                      isAnswerReport=true;
                    }
                    else
                        url = "/reportsjsp/Error.jsp";
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte B148
                else if(action.equals("SICMIRB148"))
                {
                    //session.setAttribute( "ENTIDADES", this.ENTIDADES );
                    url = "/SICMIRB148Header.jsp";
                }
                else if(action.equals("SICMIRB148Main"))
                {

                    SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat formateo2 = new SimpleDateFormat("yyMMdd");
                    String inicial = request.getParameter("txtfStartDate");

                    try
                    {
                    String inicial2 = formateo2.format(formateo.parse(inicial));
                    session.setAttribute( "initDate", inicial2);

                    String sFichero = "//aplic//prod//pmt//pmr//mcd//851"+inicial2;
                    File fichero = new File(sFichero);
                    System.out.println("El fichero es: " + sFichero );
                    if (fichero.exists())
                    {
                        //System.out.println("El fichero " + sFichero + " existe");
                      url = "/reportsjsp/managerReports.jsp"+"?report="+"SICMIRB148";
                      viewerManager.setUpViewer(this, request, response, url);
                      isAnswerReport=true;
                    }
                    else
                      //System.out.println("Pues va a ser que no");
                        url = "/reportsjsp/Error.jsp";
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte mpd0450
                else if(action.equals("SICMPD0450"))
                {
                    session.setAttribute( "PRSA_TIPOS_TRANSACCION", this.PRSA_TIPOS_TRANSACCION );
                    session.setAttribute( "PRSA_CIFRAS_CTRL", this.PRSA_CIFRAS_CTRL );
                    url = "/SICMPD0450Header.jsp";
                }

                else if(action.equals("SICMPD0450Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");

                    //String banco = request.getParameter("banco");
                    String []bancolst = request.getParameterValues("banco");
                    String banco="";
                    for(String banco1:bancolst){
                        if(!banco.equals(""))
                            banco+=",";
                        banco+=banco1;
                    }

                    String []bancolst2 = request.getParameterValues("banco2");
                    String banco2="";
                    for(String banco12:bancolst2){
                        if(!banco2.equals(""))
                            banco2+=",";
                        banco2+=banco12;
                    }

                    String liquidacion = request.getParameter("liquidacion");
                    String esquema = request.getParameter("esquema");
                    String []ttrlst = request.getParameterValues("ttrnumero");
                    String ttr="";
                    for(String ttr1:ttrlst){
                        if(!ttr.equals(""))
                            ttr+=",";
                        ttr+=ttr1;
                    }

                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute( "initDate", initDate);
                    session.setAttribute( "endDate", endDate);
                    session.setAttribute( "banco", banco);
                    session.setAttribute( "banco2", banco2);
                    session.setAttribute( "esquema", esquema);
                    session.setAttribute( "ttrnumero", ttr);
                    session.setAttribute( "liquidacion", liquidacion);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicmpd0450");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte MIRB040
                else if(action.equals("SICMIRB040"))
                {
                    url = "/SICMIRB040Header.jsp";
                }
                else if(action.equals("SICMIRB040Main"))
                {
                    SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String comercio=request.getParameter("scomercio");
                    String []bancolst = request.getParameterValues("banco");
                    String banco="";
                    for(String banco1:bancolst){
                        if(!banco.equals(""))
                            banco+=",";
                        banco+=banco1;
                    }

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("banco", banco);
                    session.setAttribute("comercio", comercio);

                    try
                    {
                        if(format.parse(initDate).compareTo(format.parse(diaHabAnt7))>0)
                        {
                    url = "/reportsjsp/managerReports.jsp"+"?report="+"Sicmirb040";
                    viewerManager.setUpViewer(this, request, response, url);
                    isAnswerReport=true;
                        }
                        else
                            url = "/fechasInvalidas.jsp?noPantalla=4";
                    }
                    catch(Exception ex)
                    {
                        throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                    }
                    }

                //Reporte MIRB040h
                else if(action.equals("SICMIRB040H"))
                {
                    url = "/SICMIRB040HHeader.jsp";
                }
                else if(action.equals("SICMIRB040HMain"))
                {
                    SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String comercio=request.getParameter("scomercio");
                    String []bancolst = request.getParameterValues("banco");
                    String banco="";
                    for(String banco1:bancolst){
                        if(!banco.equals(""))
                            banco+=",";
                        banco+=banco1;
                    }

                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("banco", banco);
                    session.setAttribute("comercio", comercio);

                    try
                    {
                        if(format.parse(initDate).compareTo(format.parse(diaHabAnt7))<=0)
                        {
                    url = "/reportsjsp/managerReports.jsp"+"?report="+"Sicmirb040H";
                    viewerManager.setUpViewer(this, request, response, url);
                    isAnswerReport=true;
                        }
                        else
                            url = "/fechasInvalidas.jsp?noPantalla=5";
                    }
                    catch(Exception ex)
                    {
                        throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                    }
                    }

                //Reporte B210
                else if(action.equals("SICMORB210"))
                {
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("SZ_TC_GRP", SZ_TC_GRP);
                    url = "/SICMORB210Header.jsp";
                }
                else if(action.equals("SICMORB210Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String []bancoAdqArray = request.getParameterValues("bancoAdq");
                    String bancoAdq="";
                    for(String banco:bancoAdqArray){
                        if(!bancoAdq.equals(""))
                            bancoAdq+=",";
                        bancoAdq+=banco;
                    }
                    String typsRechStr=request.getParameter("typeRech");


                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancoAdq);
                    session.setAttribute("typeRech", typsRechStr);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicmorb210");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte B200
                else if(action.equals("SICMORB200"))
                {
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("SZ_TC_GRP", SZ_TC_GRP);
                    url = "/SICMORB200Header.jsp";
                }
                else if(action.equals("SICMORB200Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String []bancoAdqArray = request.getParameterValues("bancoAdq");
                    String []bancoEmiArray = request.getParameterValues("bancoEmi");
                    String []Fuente = request.getParameterValues("fuente");
                    String []transaccionArray = request.getParameterValues("transaccion");
                    String naturaleza = request.getParameter("naturaleza");

                    String bancoAdq="";
                    for(String banco:bancoAdqArray){
                        if(!bancoAdq.equals(""))
                            bancoAdq+=",";
                        bancoAdq+=banco;
                    }

                    String bancoEmi="";
                    for(String banco:bancoEmiArray){
                        if(!bancoEmi.equals(""))
                            bancoEmi+=",";
                        bancoEmi+=banco;
                    }

                    String fuente="";
                    for(String fte:Fuente){
                        if(!fuente.equals(""))
                            fuente+=",";
                        fuente+=fte;
                    }

                    String transaccionstr="";
                    for(String txn:transaccionArray){
                        if(!transaccionstr.equals(""))
                            transaccionstr+=",";
                        transaccionstr+=txn;
                    }

                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoAdq", bancoAdq);
                    session.setAttribute("bancoEmi", bancoEmi);
                    session.setAttribute("fuente", fuente);
                    session.setAttribute("transaccion", transaccionstr);
                    session.setAttribute("naturaleza", naturaleza);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicmorb200");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }


                //Reporte siclir0560
                else if(action.equals("SICLIR0560"))
                {
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute( "PRSA_TIPOS_TRANSACCION", this.PRSA_TIPOS_TRANSACCION );
                    session.setAttribute( "PRSA_CIFRAS_CTRL", this.PRSA_CIFRAS_CTRL );
                    url = "/SICLIR0560Header.jsp";
                }

                else if(action.equals("SICLIR0560Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String banco = request.getParameter("banco");
                    String tipo = request.getParameter("tipo");
                    String []bancoArray = request.getParameterValues("banco");
                    String bancoAdq="";
                    for(String banco:bancoArray){
                        if(!bancoAdq.equals(""))
                            bancoAdq+=",";
                        bancoAdq+=banco;
                    }


                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute( "initDate", initDate);
                    session.setAttribute( "endDate", endDate);
                    session.setAttribute( "banco", bancoAdq);
                    session.setAttribute( "tipo", tipo);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Siclir0560");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte 0440
                else if(action.equals("SICLIR0440"))
                {
                    url = "/SICLIR0440Header.jsp";
                }

                else if(action.equals("SICLIR0440Main"))
                {
                    SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String estado = request.getParameter("estado");
                    String []bancoArray = request.getParameterValues("banco");
                    String bancos="";
                    for(String banco:bancoArray){
                        if(!bancos.equals(""))
                            bancos+=",";
                        bancos+=banco;
                    }

                    session.setAttribute( "initDate", initDate);
                    session.setAttribute( "endDate", endDate);
                    session.setAttribute( "estado", estado);
                    session.setAttribute( "banco", bancos);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Siclir0440");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                }

                //Reporte PTLF
                else if(action.equals("SICMORPTLF"))
                {
            /********** Inicio Modificacion WELLCOM N-08-2253-12  **********/
            fechas(session);
            if(request.getParameter("mostrarTabla")!=null){
                session.setAttribute("mostrarTabla","true");
            }else
                session.setAttribute("mostrarTabla","false");
            /********** Fin    Modificacion WELLCOM N-08-2253-12  **********/
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICMORPTLFHeader.jsp";
                }
                else if(action.equals("SICMORPTLFMain"))
                {
                    //String initDate = request.getParameter("txtfStartDate");
                    String afiliacion = request.getParameter("afiliacion");
                    String mes = request.getParameter("mes");
                    String year = request.getParameter("year");
                    String cuenta = request.getParameter("cuenta");
                    String []bancoArray = request.getParameterValues("banco");
                    String bancoAdq="";
                    for(String banco:bancoArray){
                        if(!bancoAdq.equals(""))
                            bancoAdq+=",";
                        bancoAdq+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    //session.setAttribute( "txtfStartDate", initDate);
                    session.setAttribute( "banco", bancoAdq);
                    session.setAttribute( "cuenta", cuenta);
                    session.setAttribute( "afiliacion", afiliacion);
                    session.setAttribute( "mes", mes);
                    session.setAttribute( "year", year);

                    url = "/reportsjsp/managerReports.jsp"+"?report="+"SicmorPTLF";
                    fechas(session);
                    viewerManager.setUpViewer(this, request, response, url);
                    isAnswerReport=true;
                }
                /*---- Marca del Cambio : WELL-JMQ-N-08-2379-12 Inicia la Modificacion     25/06/2012 ---- */
                //Reporte RECH
                else if(action.equals("SICMORRECH"))
                {

                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICMORRECHHeader.jsp";
                }
                else if(action.equals("SICMORRECHMain"))
                {
                    String afiliacion = request.getParameter("afiliacion");
                    String mes = request.getParameter("mes");
                    String year = request.getParameter("year");
                    String cuenta = request.getParameter("cuenta");
                    String codigo = request.getParameter("codigo");
                    String []bancoArray = request.getParameterValues("banco");
                    String bancoAdq="";
                    for(String banco:bancoArray){
                        if(!bancoAdq.equals(""))
                            bancoAdq+=",";
                        bancoAdq+=banco;
                    }

                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute( "banco", bancoAdq);
                    session.setAttribute( "cuenta", cuenta);
                    session.setAttribute( "codigo", codigo);
                    session.setAttribute( "afiliacion", afiliacion);
                    session.setAttribute( "mes", mes);
                    session.setAttribute( "year", year);

                    System.out.println("codigo:"+codigo);
                    url = "/reportsjsp/managerReports.jsp"+"?report="+"SicmorRECH";
                    fechas(session);
                    viewerManager.setUpViewer(this, request, response, url);
                    isAnswerReport=true;
                }
                /*---- Marca del Cambio : WELL-JMQ-N-08-2379-12 Finaliza la Modificacion   25/06/2012 ---- */

                //Reporte SICMOR0310
                else if(action.equals("SICMOR0310"))
                {
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    session.setAttribute( "SZ_TC_GRP", this.SZ_TC_GRP);
                    url = "/SICMOR0310Header.jsp";
                }
                else if(action.equals("SICMOR0310Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String comercio = request.getParameter("comercio");


                    String []bancoAdqArray = request.getParameterValues("bancoAdq");
                    String bancoAdq="";
                    for(String banco:bancoAdqArray){
                        if(!bancoAdq.equals(""))
                            bancoAdq+=",";
                        bancoAdq+=banco;
                    }


                  String []bancoEmiArray = request.getParameterValues("bancoEmi");
                    String bancoEmi="";
                    for(String banco:bancoEmiArray){
                        if(!bancoEmi.equals(""))
                            bancoEmi+=",";
                        bancoEmi+=banco;
                    }


                   String []tipoTransArray = request.getParameterValues("tipoTransac");
                    String tipoTrans="";
                    for(String tipo:tipoTransArray){
                        if(!tipoTrans.equals(""))
                            tipoTrans+=",";
                        tipoTrans+=tipo;
                    }

                   String []tipoLiquidacionArray = request.getParameterValues("tipoLiquidacion");
                    String tipoLiquidacion="";
                    for(String tipo:tipoLiquidacionArray){
                        if(!tipoLiquidacion.equals(""))
                            tipoLiquidacion+=",";
                        tipoLiquidacion+=tipo;
                    }

                    String []fuenteArray = request.getParameterValues("archivoAdq");
                    String fuentes="";
                    for(String tipo:fuenteArray){
                        if(!fuentes.equals(""))
                            fuentes+=",";
                        fuentes+=tipo;
                    }


                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute( "txtfStartDate", initDate);
                    session.setAttribute( "txtfEndDate", endDate);
                    session.setAttribute( "bancoAdq", bancoAdq);
                    session.setAttribute( "bancoEmi", bancoEmi);
                    session.setAttribute( "tipoTransac", tipoTrans);
                    session.setAttribute( "tipoLiquidacion", tipoLiquidacion);
                    session.setAttribute( "fuente", fuentes);
                    session.setAttribute( "comercio", comercio);

                    try
                    {
                        Oparticiones(initDate, endDate);
                        url = value.valida(session, initDate, endDate, "Sicmor0310");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte 0150
                else if(action.equals("SICMOR0150"))
                {
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute( "PRSA_TIPOS_TRANSACCION", this.PRSA_TIPOS_TRANSACCION );
                    session.setAttribute( "PRSA_CIFRAS_CTRL", this.PRSA_CIFRAS_CTRL );
                    session.setAttribute( "PRSA_BITACORA_ARCHIVOS", this.PRSA_BITACORA_ARCHIVOS );
                    url = "/SICMOR0150Header.jsp";
                }

                else if(action.equals("SICMOR0150Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String tipoTrans = request.getParameter("tipoTrans");
                    //String archivo = request.getParameter("archivo");
                    String []tiposTran = request.getParameterValues("tipoTrans");
                    String tiposTranStr="";
                    for(String tipoTran:tiposTran){
                        if(!tiposTranStr.equals(""))
                            tiposTranStr+=",";
                        tiposTranStr+=tipoTran;
                    }
                    String []archivos = request.getParameterValues("archivo");
                    String archivosStr="";
                    for(String archivo:archivos){
                        if(!archivosStr.equals(""))
                            archivosStr+=",";
                        archivosStr+="'"+archivo+"'";
                    }
                    System.out.println(":"+archivosStr+":");
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute( "initDate", initDate);
                    session.setAttribute( "endDate", endDate);
                    session.setAttribute( "tipoTrans", tiposTranStr);
                    session.setAttribute( "archivo", archivosStr);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicmor0150");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

	/*  ---------------------------------------------------------------------------------
    -- Marca del Cambio : SAS-LERC-C-52-8021-16 Inicia la Modificacion 05/09/2016
    ---------------------------------------------------------------------------------*/
                //Reporte 0180
                /*else if(action.equals("SICMOR0180"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICMOR0180Header.jsp";
                }
                else if(action.equals("SICMOR0180Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoEmi = request.getParameter("bancoEmi");
                    String []bancoSocioArray = request.getParameterValues("bancoSocio");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoSocio", bancosSocios);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicmor0180");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }
				*/
	/*  ---------------------------------------------------------------------------------
    -- Marca del Cambio : SAS-LERC-C-52-8021-16 Fin la Modificacion 05/09/2016
    ---------------------------------------------------------------------------------*/		
                //Reporte MIR0370
                else if(action.equals("SICMIR0370"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICMIR0370Header.jsp";
                }
                else if(action.equals("SICMIR0370Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String []bancoSocioArray = request.getParameterValues("banco");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosSocios);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicmir0370");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte MIRD370
                else if(action.equals("SICMIRD370"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICMIRD370Header.jsp";
                }
                else if(action.equals("SICMIRD370Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String []bancoSocioArray = request.getParameterValues("banco");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosSocios);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicmird370");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte MIR0380
                else if(action.equals("SICMIR0380"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICMIR0380Header.jsp";
                }
                else if(action.equals("SICMIR0380Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String []bancoSocioArray = request.getParameterValues("banco");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosSocios);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicmir0380");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte VSA0010
                else if(action.equals("SICVSA0010"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICVSA0010Header.jsp";
                }
                else if(action.equals("SICVSA0010Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String []bancoSocioArray = request.getParameterValues("banco");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosSocios);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicvsa0010");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte VSA0020
                else if(action.equals("SICVSA0020"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICVSA0020Header.jsp";
                }
                else if(action.equals("SICVSA0020Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String []bancoSocioArray = request.getParameterValues("banco");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosSocios);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicvsa0020");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte VSA0030
                else if(action.equals("SICVSA0030"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICVSA0030Header.jsp";
                }
                else if(action.equals("SICVSA0030Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String []bancoSocioArray = request.getParameterValues("banco");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosSocios);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicvsa0030");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte VSA0040
                else if(action.equals("SICVSA0040"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICVSA0040Header.jsp";
                }
                else if(action.equals("SICVSA0040Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String []bancoSocioArray = request.getParameterValues("banco");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosSocios);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicvsa0040");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte VSA0050
                else if(action.equals("SICVSA0050"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICVSA0050Header.jsp";
                }
                else if(action.equals("SICVSA0050Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String Tipo = request.getParameter("Tipo");
                    String []bancoSocioArray = request.getParameterValues("banco");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosSocios);
                    session.setAttribute("Tipo", Tipo);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicvsa0050");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }
/*----------------------------------------------------------------------------*/
/*Marca del Cambio :  AXIA-GGB-P-02-0496-10 Inicia  la Modificacion 11/12/2012*/
/*----------------------------------------------------------------------------*/
/*Marca del Cambio :  AXIA-GGB-P-02-0060-12 Inicia  la Modificacion 19/09/2013*/
/*----------------------------------------------------------------------------*/
                else if(action.equals("SICDCC0010")) {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICDCC0010Header.jsp";
                } else if(action.equals("SICDCC0010Main")) {
                  String initDate = request.getParameter("txtfStartDate");
                  String endDate = request.getParameter("txtfEndDate");
                  String []bancoSocioArray = request.getParameterValues("banco");
                  String bancosSocios="";
                  for(String banco:bancoSocioArray){
                    if(!bancosSocios.equals(""))
                      bancosSocios+=",";
                     bancosSocios+=banco;
                  }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                  session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                  session.setAttribute("txtfStartDate", initDate);
                  session.setAttribute("txtfEndDate", endDate);
                  session.setAttribute("banco", bancosSocios);
                  try {
                      url = value.valida(session, initDate, endDate, "SICDCC0010");
                      viewerManager.setUpViewer(this, request, response, url);
                      isAnswerReport=true;
                    } catch (WellException e){
                      e.printStackTrace();
                    }
                }
                else if(action.equals("SICDCC0020")) {
                  session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                  session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                  session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                  url = "/SICDCC0020Header.jsp";
                } else if(action.equals("SICDCC0020Main")) {
                  String initDate = request.getParameter("txtfStartDate");
                  String endDate = request.getParameter("txtfEndDate");
                  String []bancoSocioArray = request.getParameterValues("banco");
                  String bancosSocios="";
                  for(String banco:bancoSocioArray){
                    if(!bancosSocios.equals(""))
                      bancosSocios+=",";
                     bancosSocios+=banco;
                  }
                  session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                  session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                  session.setAttribute("txtfStartDate", initDate);
                  session.setAttribute("txtfEndDate", endDate);
                  session.setAttribute("banco", bancosSocios);
                  try {
                    url = value.valida(session, initDate, endDate, "SICDCC0020");
                    viewerManager.setUpViewer(this, request, response, url);
                    isAnswerReport=true;
                  } catch (WellException e){
                    e.printStackTrace();
                  }
                }
                //Reporte DCC0030
                else if(action.equals("SICDCC0030")) {
                  session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                  session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                  session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                  url = "/SICDCC0030Header.jsp";
                } else if(action.equals("SICDCC0030Main")) {
                  String initDate = request.getParameter("txtfStartDate");
                  String endDate = request.getParameter("txtfEndDate");
                  String []bancoSocioArray = request.getParameterValues("banco");
                  String bancosSocios="";
                  for(String banco:bancoSocioArray){
                    if(!bancosSocios.equals(""))
                      bancosSocios+=",";
                     bancosSocios+=banco;
                  }
                  session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                  session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                  session.setAttribute("txtfStartDate", initDate);
                  session.setAttribute("txtfEndDate", endDate);
                  session.setAttribute("banco", bancosSocios);
                  try {
                    url = value.valida(session, initDate, endDate, "SICDCC0030");
                    viewerManager.setUpViewer(this, request, response, url);
                    isAnswerReport=true;
                  } catch (WellException e){
                    e.printStackTrace();
                  }
                }
                //Reporte DCC0040
                else if(action.equals("SICDCC0040")) {
                  session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                  session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                  session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                  url = "/SICDCC0040Header.jsp";
                } else if(action.equals("SICDCC0040Main")) {
                  String initDate = request.getParameter("txtfStartDate");
                  String endDate = request.getParameter("txtfEndDate");
                  String []bancoSocioArray = request.getParameterValues("banco");
                  String bancosSocios="";
                  for(String banco:bancoSocioArray){
                    if(!bancosSocios.equals(""))
                      bancosSocios+=",";
                     bancosSocios+=banco;
                  }
                  session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                  session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                  session.setAttribute("txtfStartDate", initDate);
                  session.setAttribute("txtfEndDate", endDate);
                  session.setAttribute("banco", bancosSocios);
                  try {
                    url = value.valida(session, initDate, endDate, "SICDCC0040");
                    viewerManager.setUpViewer(this, request, response, url);
                    isAnswerReport=true;
                  } catch (WellException e){
                    e.printStackTrace();
                  }
                }
                //Reporte DCC0050
                else if(action.equals("SICDCC0050")) {
                  session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                  session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                  session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                  url = "/SICDCC0050Header.jsp";
                } else if(action.equals("SICDCC0050Main")) {
                  String initDate = request.getParameter("txtfStartDate");
                  String endDate = request.getParameter("txtfEndDate");
                  String []bancoSocioArray = request.getParameterValues("banco");
                  String bancosSocios="";
                  for(String banco:bancoSocioArray){
                    if(!bancosSocios.equals(""))
                      bancosSocios+=",";
                     bancosSocios+=banco;
                  }
                  session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                  session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                  session.setAttribute("txtfStartDate", initDate);
                  session.setAttribute("txtfEndDate", endDate);
                  session.setAttribute("banco", bancosSocios);
                  try {
                    url = value.valida(session, initDate, endDate, "SICDCC0050");
                    viewerManager.setUpViewer(this, request, response, url);
                    isAnswerReport=true;
                  } catch (WellException e){
                    e.printStackTrace();
                  }
                }
                //Reporte DCC0080
                else if(action.equals("SICDCC0080")) {
                  session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                  session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                  session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                  url = "/SICDCC0080Header.jsp";
                } else if(action.equals("SICDCC0080Main")) {
                  String initDate = request.getParameter("txtfStartDate");
                  String endDate = request.getParameter("txtfEndDate");
                  String []bancoSocioArray = request.getParameterValues("banco");
                  String bancosSocios="";
                  for(String banco:bancoSocioArray){
                    if(!bancosSocios.equals(""))
                      bancosSocios+=",";
                     bancosSocios+=banco;
                  }
                  session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                  session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                  session.setAttribute("txtfStartDate", initDate);
                  session.setAttribute("txtfEndDate", endDate);
                  session.setAttribute("banco", bancosSocios);
                  try {
                    url = value.valida(session, initDate, endDate, "SICDCC0080");
                    viewerManager.setUpViewer(this, request, response, url);
                    isAnswerReport=true;
                  } catch (WellException e){
                    e.printStackTrace();
                  }
                }
                //Reporte DCC0090
                else if(action.equals("SICDCC0090")) {
                  session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                  session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                  session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                  url = "/SICDCC0090Header.jsp";
                } else if(action.equals("SICDCC0090Main")) {
                  String initDate = request.getParameter("txtfStartDate");
                  String endDate = request.getParameter("txtfEndDate");
                  String []bancoSocioArray = request.getParameterValues("banco");
                  String bancosSocios="";
                  for(String banco:bancoSocioArray){
                    if(!bancosSocios.equals(""))
                      bancosSocios+=",";
                     bancosSocios+=banco;
                  }
                  session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                  session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                  session.setAttribute("txtfStartDate", initDate);
                  session.setAttribute("txtfEndDate", endDate);
                  session.setAttribute("banco", bancosSocios);
                  try {
                    url = value.valida(session, initDate, endDate, "SICDCC0090");
                    viewerManager.setUpViewer(this, request, response, url);
                    isAnswerReport=true;
                  } catch (WellException e){
                    e.printStackTrace();
                  }
                }
                //Reporte DCC0060
                else if(action.equals("SICDCC0060")) {
                  session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                  session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                  session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                  url = "/SICDCC0060Header.jsp";
                } else if(action.equals("SICDCC0060Main")) {
                  String initDate = request.getParameter("txtfStartDate");
                  String endDate = request.getParameter("txtfEndDate");
                  String tipo = request.getParameter("tipo");
                  /*String []bancoSocioArray = request.getParameterValues("banco");
                  String bancosSocios="";
                  for(String banco:bancoSocioArray){
                    if(!bancosSocios.equals(""))
                      bancosSocios+=",";
                     bancosSocios+=banco;
                  }*/
                  session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                  session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                  session.setAttribute("txtfStartDate", initDate);
                  session.setAttribute("txtfEndDate", endDate);
                  session.setAttribute("tipo", tipo);
                  try {
                    url = value.valida(session, initDate, endDate, "SICDCC0060");
                    viewerManager.setUpViewer(this, request, response, url);
                    isAnswerReport=true;
                  } catch (WellException e){
                    e.printStackTrace();
                  }
                }
                //Reporte DCC0070
                else if(action.equals("SICDCC0070")) {
                  session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                  session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                  session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                  url = "/SICDCC0070Header.jsp";
                } else if(action.equals("SICDCC0070Main")) {
                  String initDate = request.getParameter("txtfStartDate");
                  String endDate = request.getParameter("txtfEndDate");
                  String mapr = request.getParameter("mapr");
                  /*String []bancoSocioArray = request.getParameterValues("banco");
                  String bancosSocios="";
                  for(String banco:bancoSocioArray){
                    if(!bancosSocios.equals(""))
                      bancosSocios+=",";
                     bancosSocios+=banco;
                  }*/
                  session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                  session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                  session.setAttribute("txtfStartDate", initDate);
                  session.setAttribute("txtfEndDate", endDate);
                  session.setAttribute("mapr", mapr);
                  try {
                    url = value.valida(session, initDate, endDate, "SICDCC0070");
                    viewerManager.setUpViewer(this, request, response, url);
                    isAnswerReport=true;
                  } catch (WellException e){
                    e.printStackTrace();
                  }
                }
                //Reporte DCC0100
                else if(action.equals("SICDCC0100")) {
                  session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                  session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                  session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                  url = "/SICDCC0100Header.jsp";
                } else if(action.equals("SICDCC0100Main")) {
                  String initDate = request.getParameter("txtfStartDate");
                  String endDate = request.getParameter("txtfEndDate");
                  String []bancoSocioArray = request.getParameterValues("banco");
                  String bancosSocios="";
                  String fuente = request.getParameter("fuente");
                  String ttr = request.getParameter("ttr");
                  for(String banco:bancoSocioArray){
                    if(!bancosSocios.equals(""))
                      bancosSocios+=",";
                     bancosSocios+=banco;
                  }
                  session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                  session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                  session.setAttribute("txtfStartDate", initDate);
                  session.setAttribute("txtfEndDate", endDate);
                  session.setAttribute("banco", bancosSocios);
                  session.setAttribute("fuente", fuente);
                  session.setAttribute("ttr", ttr);
                  try {
                    url = value.valida(session, initDate, endDate, "SICDCC0100");
                    viewerManager.setUpViewer(this, request, response, url);
                    isAnswerReport=true;
                  } catch (WellException e){
                    e.printStackTrace();
                  }
                }
/*----------------------------------------------------------------------------*/
/*Marca del Cambio :  AXIA-GGB-P-02-0060-12 Termina la Modificacion 19/09/2013*/
/*----------------------------------------------------------------------------*/
/*Marca del Cambio :  AXIA-GGB-P-02-0496-10 Termina la Modificacion 11/12/2012*/
/*----------------------------------------------------------------------------*/
               
/*  ---------------------------------------------------------------------------------
    -- Marca del Cambio : SAS-LERC-C-52-8021-16 Inicia la Modificacion 05/09/2016
    ---------------------------------------------------------------------------------*/
			   //Reporte 0240
            /*    else if(action.equals("SICMOR0240"))
                {
                    url = "/SICMOR0240Header.jsp";
                }
                else if(action.equals("SICMOR0240Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String corte = request.getParameter("corte");
                    String []fuenteEntArray = request.getParameterValues("fuente");
                    String fuenteEnt="";
                    for(String banco:fuenteEntArray){
                        if(!fuenteEnt.equals(""))
                            fuenteEnt+=",";
                        fuenteEnt+=banco;
                    }

                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("corte", corte);
                    session.setAttribute("fuente", fuenteEnt);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicmor0240");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }
*/
                //Reporte 0280
                else if(action.equals("SICMOR0280"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICMOR0280Header.jsp";
                }
                else if(action.equals("SICMOR0280Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoEmi = request.getParameter("bancoEmi");
                    String []bancoSocioArray = request.getParameterValues("bancoSocio");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoSocio", bancosSocios);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicmor0280");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }
/*
                //Reporte 0270
                else if(action.equals("SICMOR0270"))
                {
                    url = "/SICMOR0270Header.jsp";
                }
                else if(action.equals("SICMOR0270Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String corte = request.getParameter("corte");
                    String fuente = request.getParameter("fuente");
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("corte", corte);
                    session.setAttribute("fuente", fuente);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicmor0270");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }
*/
                //Reporte 0280
                else if(action.equals("SICMOR0280"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICMOR0280Header.jsp";
                }
                else if(action.equals("SICMOR0280Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoEmi = request.getParameter("bancoEmi");
                    String []bancoSocioArray = request.getParameterValues("bancoSocio");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoSocio", bancosSocios);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicmor0280");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }
                
	/*  ---------------------------------------------------------------------------------
    -- Marca del Cambio : SAS-LERC-C-52-8021-16 Fin la Modificacion 05/09/2016
    ---------------------------------------------------------------------------------*/	
                //Reporte D280
                else if(action.equals("SICMORD280"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICMORD280Header.jsp";
                }
                else if(action.equals("SICMORD280Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoEmi = request.getParameter("bancoEmi");
                    String []bancoSocioArray = request.getParameterValues("bancoSocio");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoSocio", bancosSocios);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicmord280");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte 0290
                else if(action.equals("SICMOR0290"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICMOR0290Header.jsp";
                }
                else if(action.equals("SICMOR0290Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoEmi = request.getParameter("bancoEmi");
                    String []bancoSocioArray = request.getParameterValues("bancoSocio");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoSocio", bancosSocios);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicmor0290");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Monitor
                else if(action.equals("Monitor"))
                {
                    url = "/MonitorHeader.jsp";
                }

                //Siclir0010
                else if(action.equals("SICLIR0010"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICLIR0010Header.jsp";
                }
                else if(action.equals("SICLIR0010Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoEmi = request.getParameter("bancoEmi");
                    String []bancoSocioArray = request.getParameterValues("banco");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    String []tipoLiqArray = request.getParameterValues("tipoLiq");
                    String tiposLiq="";
                    for(String tipoLiq:tipoLiqArray){
                        if(!tiposLiq.equals(""))
                            tiposLiq+=",";
                        tiposLiq+=tipoLiq;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosSocios);
                    session.setAttribute("tipoLiq", tiposLiq);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Siclir0010");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Siclir0011
                else if(action.equals("SICLIR0011"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICLIR0011Header.jsp";
                }
                else if(action.equals("SICLIR0011Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String []bancoSocioArray = request.getParameterValues("banco");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("banco", bancosSocios);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Siclir0011");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }


                //Reporte 0030
                else if(action.equals("SICLIR0030"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICLIR0030Header.jsp";
                }
                else if(action.equals("SICLIR0030Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");

                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);

                    try
                    {
                        Oparticionesdiaant(initDate, endDate, initDate, endDate);
                        url = value.valida(session, initDate, endDate, "Siclir0030");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte D030
                else if(action.equals("SICLIRD030"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICLIRD030Header.jsp";
                }
                else if(action.equals("SICLIRD030Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");

                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);

                    try
                    {
                        Oparticionesdiaant(initDate, endDate, initDate, endDate);
                        url = value.valida(session, initDate, endDate, "Siclird030");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }


                //Reporte 0040
                else if(action.equals("SICLIR0040"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICLIR0040Header.jsp";
                }
                else if(action.equals("SICLIR0040Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");

                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);

                    try
                    {
                        Oparticionesdiaant(initDate, endDate, initDate, endDate);
                        url = value.valida(session, initDate, endDate, "Siclir0040");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte D040
                else if(action.equals("SICLIRD040"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICLIRD040Header.jsp";
                }
                else if(action.equals("SICLIRD040Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");

                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);

                    try
                    {
                        url = value.valida(session, initDate, endDate, "Siclird040");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }


                //Reporte 0170
                else if(action.equals("SICMOR0170"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICMOR0170Header.jsp";
                }
                else if(action.equals("SICMOR0170Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoAdq = request.getParameter("bancoAdq");
                    String []bancoAdqArray = request.getParameterValues("bancoAdq");
                    String bancoAdq="";
                    for(String banco:bancoAdqArray){
                        if(!bancoAdq.equals(""))
                            bancoAdq+=",";
                        bancoAdq+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute( "txtfStartDate", initDate);
                    session.setAttribute( "txtfEndDate", endDate);
                    session.setAttribute( "bancoAdq", bancoAdq);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicmor0170");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte SICMOR0171
                else if(action.equals("SICMOR0171"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICMOR0171Header.jsp";
                }
                else if(action.equals("SICMOR0171Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String []bancoAdqArray = request.getParameterValues("bancoAdq");
                    String bancoAdq="";
                    for(String banco:bancoAdqArray){
                        if(!bancoAdq.equals(""))
                            bancoAdq+=",";
                        bancoAdq+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute( "txtfStartDate", initDate);
                    session.setAttribute( "txtfEndDate", endDate);
                    session.setAttribute( "bancoAdq", bancoAdq);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicmor0171");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }
                //Modificacion: Marca de inicio IDSYS-CMDELCR-  N-08-2033-13 30/08/2013
                else if(action.equals("Miscelaneos.do")){
                        String usuario;
                        ResultSet rs = null;
                        String descripcion = "MODIFICACION DE PARAMETROS EN MISCELANEO 103";
                        String []list_ant = new String[6];
                        String []list_act = new String[6];
                        ArrayList list_aux = null;
                        String txtCreVen = request.getParameter("txtCreVen");
                        String txtCrePag = request.getParameter("txtCrePag");
                        String txtCreDev = request.getParameter("txtCreDev");
                        String txtDebVen = request.getParameter("txtDebVen");
                        String txtDebPag = request.getParameter("txtDebPag");
                        String txtDebDev = request.getParameter("txtDebDev");
                        String obs = request.getParameter("observ");

                        //Numero total de Registros
                        String sql= "SELECT PP_VALOR FROM PRSA_PARAMETROS "+
                                     "WHERE PP_ID_PARAMETRO='EGLOMISC_103'";

                        String sqlU1 = "UPDATE PRSA_PARAMETROS "+
                                           "SET PP_VALOR='"+txtCreVen+"' "+
                                           "WHERE PP_ID_PARAMETRO='EGLOMISC_103' "+
                                           "AND PP_CLAVE='01MISC_CR'";

                       String sqlU2= "UPDATE PRSA_PARAMETROS "+
                                          "SET PP_VALOR='"+txtCrePag+"' "+
                                         "WHERE PP_ID_PARAMETRO='EGLOMISC_103' "+
                                         "AND PP_CLAVE='20MISC_CR'";

                       String sqlU3= "UPDATE PRSA_PARAMETROS  "+
                                          "SET PP_VALOR='"+txtCreDev+"' "+
                                          "WHERE PP_ID_PARAMETRO='EGLOMISC_103' "+
                                          "AND PP_CLAVE='21MISC_CR'";

                       String sqlU4= "UPDATE PRSA_PARAMETROS "+
                                          "SET PP_VALOR='"+txtDebVen+"' "+
                                          "WHERE PP_ID_PARAMETRO='EGLOMISC_103' "+
                                          "AND PP_CLAVE='01MISC_DB'";

                       String sqlU5= "UPDATE PRSA_PARAMETROS "+
                                          "SET PP_VALOR='"+txtDebPag+"' "+
                                          "WHERE PP_ID_PARAMETRO='EGLOMISC_103' "+
                                          "AND PP_CLAVE='20MISC_DB'";

                       String sqlU6="UPDATE PRSA_PARAMETROS "+
                                         "SET PP_VALOR='"+txtDebDev+"' "+
                                         "WHERE PP_ID_PARAMETRO='EGLOMISC_103' "+
                                         "AND PP_CLAVE='21MISC_DB'";
                       usuario = (String)session.getAttribute("login");

                        try {
                            db.setQuerySelect(sql);
                            db.executeQuerySelect();
                            rs = db.getResultSet();
                        }
                        catch (Exception ex){
                            /*throw new WellException("com.wellcom.ReloadServlet.validacion: " + ex);*/
                            System.out.println("Error Query1:-------->"+ex);
                        }

                        for(int i=0;i<6;i++){
                            try {
                                rs.next();
                                list_ant[i] = rs.getString(1).replaceAll(" ","");
                              //  System.out.println("Val rs: " + list_ant[i] + " - " + rs.getString(1));
                            } catch (SQLException ex) {
                                System.out.println("Error al obtener los registros");
                            }
                        }

                        int bandera = 0, val_aux = 0, valid = 0;
                        //Verifica los valores obtenidos de los textbox, si son diferentes de null los guarda en la base de datos
                        if(obs.contentEquals(" ")){
                            obs = "Se cambia el valor de";
                            val_aux = 1;
                        }

                        if(!(txtCreVen.equals("") && txtCrePag.equals("") && txtCreDev.equals("") &&
                                txtDebVen.equals("") && txtDebPag.equals("") && txtDebDev.equals(""))){
                            try{
                                if(!txtCreVen.equals("")) System.out.println(Float.parseFloat(txtCreVen));
                                if(!txtCrePag.equals("")) System.out.println(Float.parseFloat(txtCrePag));
                                if(!txtCreDev.equals("")) System.out.println(Float.parseFloat(txtCreDev));
                                if(!txtDebVen.equals("")) System.out.println(Float.parseFloat(txtDebVen));
                                if(!txtDebPag.equals("")) System.out.println(Float.parseFloat(txtDebPag));
                                if(!txtDebDev.equals("")) System.out.println(Float.parseFloat(txtDebDev));
                            }
                            catch(NumberFormatException ex){
                                valid++;
                            }
                        }System.out.println("valid: " + valid);
                        if(valid == 0){
                            try {
                                //System.out.println("Lista anterior: " + list_ant[0] + list_ant[1] + list_ant[2] + list_ant[3] + list_ant[4] + list_ant[5]);
                                if(!txtCreVen.equals("")){
                                    db.setQueryUpdate(sqlU1);
                                    db.executeQueryUpdate();
                                    list_act[0] = txtCreVen;
                                    if(val_aux == 1)
                                        obs += " credito en ventas a " + txtCreVen;
                                    bandera = 1;
                                }
                                if(!txtCrePag.equals("")){
                                    db.setQueryUpdate(sqlU2);
                                    db.executeQueryUpdate();
                                    list_act[1] = txtCrePag;
                                    if(val_aux == 1)
                                        obs += " credito en pagos a " + txtCrePag;
                                    bandera = 1;
                                }
                                if(!txtCreDev.equals("")){
                                    db.setQueryUpdate(sqlU3);
                                    db.executeQueryUpdate();
                                    list_act[2] = txtCreDev;
                                    if(val_aux == 1)
                                        obs += " credito en devoluciones a " + txtCreDev;
                                    bandera = 1;
                                }
                                if(!txtDebVen.equals("")){
                                    db.setQueryUpdate(sqlU4);
                                    db.executeQueryUpdate();
                                    list_act[3] = txtDebVen;
                                    if(val_aux == 1)
                                        obs += " debito en ventas a " + txtDebVen;
                                    bandera = 1;
                                }
                                if(!txtDebPag.equals("")){
                                    db.setQueryUpdate(sqlU5);
                                    db.executeQueryUpdate();
                                    list_act[4] = txtDebPag;
                                    if(val_aux == 1)
                                        obs += " debito en pagos a " + txtDebPag;
                                    bandera = 1;
                                }
                                if(!txtDebDev.equals("")){
                                    db.setQueryUpdate(sqlU6);
                                    db.executeQueryUpdate();
                                    list_act[5] = txtDebDev;
                                    if(val_aux == 1)
                                        obs += " debito en devoluciones a " + txtDebDev;
                                    bandera = 1;
                                }
                            }
                            catch (Exception ex){
                                /*throw new WellException("com.wellcom.ReloadServlet.validacion: " + ex.toString());*/
                                System.out.println("Error Query2:-------->"+ex.getMessage());
                            }
                        }

                        //Prepara el query para actualizar PMT_PARAMETROS_BITACORA
                        String query = "INSERT INTO PMT_PARAMETROS_BITACORA (USUARIO,FECH_MOD,DESCRIPCION,OBSERVACIONES,"
                                + "VALOR_ANTERIOR,VALOR_ACTUAL) VALUES('" +
                                usuario + "',sysdate,'" + descripcion + "','" + obs + "','";

                        if(bandera == 1){
                            for(int i=0;i<6;i++){
                                if(i != 5)
                                    query += list_ant[i] + ",";
                                else
                                    query += list_ant[i] + "','";
                            }

                            for(int i=0;i<6;i++){
                                if(list_act[i] == null)
                                    list_act[i] = list_ant[i];
                                if(i != 5)
                                    query += list_act[i] + ",";
                                else
                                    query += list_act[i] + "')";
                            }System.out.println("Query: " + query);
                            //Guarda los cambios en PMT_PARAMETROS_BITACORA
                            try{
                                db.setQueryInsert(query) ;
                                db.executeQueryInsert();
                            }
                            catch (Exception ex){
                                 System.out.println("Error ACT:-------->"+ex);
                            }
                        }
                        else
                            System.out.println("No se hara ningun cambio en miscelaneos");
                        if(valid == 0)
                        url = "/Miscelaneos.jsp";
                        else
                            url = "/ErrorMiscelaneos.jsp";
                }
                //Modificacion: Marca de termino IDSYS-CMDELCR-  N-08-2033-13 30/08/2013

                //Reporte B170
                else if(action.equals("SICMORB170"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICMORB170Header.jsp";
                }
                else if(action.equals("SICMORB170Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    //String bancoAdq = request.getParameter("bancoAdq");
                    String []bancoAdqArray = request.getParameterValues("bancoAdq");
                    String bancoAdq="";
                    for(String banco:bancoAdqArray){
                        if(!bancoAdq.equals(""))
                            bancoAdq+=",";
                        bancoAdq+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute( "txtfStartDate", initDate);
                    session.setAttribute( "txtfEndDate", endDate);
                    session.setAttribute( "bancoAdq", bancoAdq);
                    try
                    {
                        url = value.valida(session, initDate, endDate, "Sicmorb170");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte 001
                else if(action.equals("SICPRO001"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICPRO001Header.jsp";
                }
                else if(action.equals("SICPRO001Main"))
                {
                    SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String tipo = request.getParameter("tipo");
                    String comercio = request.getParameter("comercio");

                    if(tipo.equals("None"))
                    {
                        tipo="Ambos";
                    }
                    if(comercio.equals(""))
                    {
                        comercio="";
                    }

                    String []bancoSocioArray = request.getParameterValues("bancoSocio");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoSocio", bancosSocios);
                    session.setAttribute("tipo", tipo);
                    session.setAttribute("comercio", comercio);

                    try
                    {
                        try
                        {
                            if(format.parse(initDate).compareTo(format.parse(diaHabAnt7))>0)
                            {
                                Oparticiones(initDate, endDate);
                                url = value.valida(session, initDate, endDate, "Sicpro001");
                                viewerManager.setUpViewer(this, request, response, url);
                                isAnswerReport=true;
                            }
                            else
                                url = "/fechasInvalidas.jsp?noPantalla=4";
                        }
                        catch(Exception ex)
                        {
                            throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                        }
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte 001H
                else if(action.equals("SICPRO001H"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICPRO001HHeader.jsp";
                }
                else if(action.equals("SICPRO001HMain"))
                {
                    SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String tipo = request.getParameter("tipo");
                    String comercio = request.getParameter("comercio");

                    if(tipo.equals("None"))
                    {
                        tipo="Ambos";
                    }
                    if(comercio.equals(""))
                    {
                        comercio="";
                    }

                    String []bancoSocioArray = request.getParameterValues("bancoSocio");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoSocio", bancosSocios);
                    session.setAttribute("tipo", tipo);
                    session.setAttribute("comercio", comercio);

                    try
                    {
                        try
                        {
                            if(format.parse(initDate).compareTo(format.parse(diaHabAnt7Historico))<=0 && format.parse(endDate).compareTo(format.parse(diaHabAnt7Historico))<=0)
                            {
                        Oparticiones(initDate, endDate);
                        url = value.valida(session, initDate, endDate, "Sicpro001H");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                            }
                            else
                                url = "/fechasInvalidas.jsp?noPantalla=5";
                        }
                        catch(Exception ex)
                        {
                            throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                        }
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte 002
                else if(action.equals("SICPRO002"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICPRO002Header.jsp";
                }
                else if(action.equals("SICPRO002Main"))
                {
                    SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String tipo = request.getParameter("tipo");

                    if(tipo.equals("None"))
                    {
                        tipo="Ambos";
                    }

                    String []bancoSocioArray = request.getParameterValues("bancoSocio");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoSocio", bancosSocios);
                    session.setAttribute("tipo", tipo);

                    try
                    {
                        try
                        {
                            if(format.parse(initDate).compareTo(format.parse(diaHabAnt7))>0)
                            {
                        Oparticiones(initDate, endDate);
                        url = value.valida(session, initDate, endDate, "Sicpro002");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                            }
                            else
                                url = "/fechasInvalidas.jsp?noPantalla=4";
                        }
                        catch(Exception ex)
                        {
                            throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                        }
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte 002A
                else if(action.equals("SICPRO002A"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICPRO002AHeader.jsp";
                }
                else if(action.equals("SICPRO002AMain"))
                {
                    SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String tipo = request.getParameter("tipo");

                    if(tipo.equals("None"))
                    {
                        tipo="Ambos";
                    }

                    String []bancoSocioArray = request.getParameterValues("bancoSocio");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoSocio", bancosSocios);
                    session.setAttribute("tipo", tipo);

                    try
                    {
                        try
                        {
                            if(format.parse(initDate).compareTo(format.parse(diaHabAnt7))>0)
                            {
                        Oparticiones(initDate, endDate);
                        url = value.valida(session, initDate, endDate, "Sicpro002A");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                            }
                            else
                                url = "/fechasInvalidas.jsp?noPantalla=4";
                        }
                        catch(Exception ex)
                        {
                            throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                        }
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte 002H
                else if(action.equals("SICPRO002H"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICPRO002HHeader.jsp";
                }
                else if(action.equals("SICPRO002HMain"))
                {
                    SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String tipo = request.getParameter("tipo");

                    if(tipo.equals("None"))
                    {
                        tipo="Ambos";
                    }

                    String []bancoSocioArray = request.getParameterValues("bancoSocio");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoSocio", bancosSocios);
                    session.setAttribute("tipo", tipo);

                    try
                    {
                        try
                        {
                            if(format.parse(initDate).compareTo(format.parse(diaHabAnt7Historico))<=0 && format.parse(endDate).compareTo(format.parse(diaHabAnt7Historico))<=0)
                            {
                        Oparticiones(initDate, endDate);
                        url = value.valida(session, initDate, endDate, "Sicpro002H");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                            }
                            else
                                url = "/fechasInvalidas.jsp?noPantalla=5";
                        }
                        catch(Exception ex)
                        {
                            throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                        }
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte 003
                else if(action.equals("SICPRO003"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICPRO003Header.jsp";
                }
                else if(action.equals("SICPRO003Main"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String tipo = request.getParameter("tipo");

                    if(tipo.equals("None"))
                    {
                        tipo="Ambos";
                    }

                    String []bancoSocioArray = request.getParameterValues("bancoSocio");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoSocio", bancosSocios);
                    session.setAttribute("tipo", tipo);
                    try
                    {
                        Oparticiones(initDate, endDate);
                        url = value.valida(session, initDate, endDate, "Sicpro003");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }
                //Reporte 003H
                else if(action.equals("SICPRO003H"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICPRO003HHeader.jsp";
                }
                else if(action.equals("SICPRO003HMain"))
                {
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String tipo = request.getParameter("tipo");

                    if(tipo.equals("None"))
                    {
                        tipo="Ambos";
                    }

                    String []bancoSocioArray = request.getParameterValues("bancoSocio");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoSocio", bancosSocios);
                    session.setAttribute("tipo", tipo);
                    try
                    {
                        Oparticiones(initDate, endDate);
                        url = value.valida(session, initDate, endDate, "Sicpro003H");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte Q200
                else if(action.equals("SICMORQ200"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICMORQ200Header.jsp";
                }
                else if(action.equals("SICMORQ200Main"))
                {
                    SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String tipo = request.getParameter("tipo");

                    if(tipo.equals("None"))
                    {
                        tipo="Ambos";
                    }

                    String []bancoSocioArray = request.getParameterValues("bancoSocio");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoSocio", bancosSocios);
                    session.setAttribute("tipo", tipo);
                    try
                    {
                        try
                        {
                            if(format.parse(initDate).compareTo(format.parse(diaHabAnt7))>0)
                            {
                                Oparticiones(initDate, endDate);
                        url = value.valida(session, initDate, endDate, "Sicmorq200");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                            }
                            else
                                url = "/fechasInvalidas.jsp?noPantalla=4";
                        }
                        catch(Exception ex)
                        {
                            throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                        }
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte Q200H
                else if(action.equals("SICMORQ200H"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICMORQ200HHeader.jsp";
                }
                else if(action.equals("SICMORQ200HMain"))
                {
                    SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String tipo = request.getParameter("tipo");

                    if(tipo.equals("None"))
                    {
                        tipo="Ambos";
                    }

                    String []bancoSocioArray = request.getParameterValues("bancoSocio");
                    String bancosSocios="";
                    for(String banco:bancoSocioArray){
                        if(!bancosSocios.equals(""))
                            bancosSocios+=",";
                        bancosSocios+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute("txtfStartDate", initDate);
                    session.setAttribute("txtfEndDate", endDate);
                    session.setAttribute("bancoSocio", bancosSocios);
                    session.setAttribute("tipo", tipo);
                    try
                    {
                        try
                        {
                                    if(format.parse(initDate).compareTo(format.parse(diaHabAnt7Historico))<=0 && format.parse(endDate).compareTo(format.parse(diaHabAnt7Historico))<=0)
                            {
                        url = value.valida(session, initDate, endDate, "Sicmorq200H");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                            }
                                    else
                                        url = "/fechasInvalidas.jsp?noPantalla=5";
                                }
                                catch(Exception ex)
                                {
                                    throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
                                }
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }


                //Reporte 0460
                else if(action.equals("SICLIR0460"))
                {
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICLIR0460Header.jsp";
                }
                else if(action.equals("SICLIR0460Main"))
                {
                    SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String []bancoEmiArray = request.getParameterValues("bancoEmi");
                    String bancoEmi="";
                    for(String banco:bancoEmiArray){
                        if(!bancoEmi.equals(""))
                            bancoEmi+=",";
                        bancoEmi+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute( "txtfStartDate", initDate);
                    session.setAttribute( "txtfEndDate", endDate);
                    session.setAttribute( "bancoEmi", bancoEmi);
                    try
                    {
                        Oparticiones(initDate, endDate);
                        url = value.valida(session, initDate, endDate, "Siclir0460");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }
/* Marca del Cambio : SAS-JAGG-Z-02-2675-12 Inicia la Modificacion     13/02/2013 */

            //repvtDetAdq reporte detalle adquiriente
            else if(action.equals("repvtDetAdq"))
            {
                url = "/repvtDetAdq_Header.jsp";
            }
            else if(action.equals("XXXXrepvtDetAdq"))
            {
                String initDate = request.getParameter("txtfStartDate");
                String endDate = request.getParameter("txtfEndDate");
                String []bancos = request.getParameterValues("banco");
                String bancosStr="";
                for(String banco:bancos){
                    if(!bancosStr.equals(""))
                        bancosStr+=",";
                    bancosStr+=banco;
                }
                session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                session.setAttribute("initDate", initDate);
                session.setAttribute("endDate", endDate);
                session.setAttribute("Adquiriente", bancosStr);
                try
                {
                    url = value.valida(session, initDate, endDate, "reporteAdquirienteDetalle");
                    viewerManager.setUpViewer(this, request, response, url);
                    isAnswerReport=true;
                }
                catch (WellException e)
                {
                    e.printStackTrace();
                }
            }
            // fin repvtDetAdq reporte detalle adquiriente

            // incio reporte Telefonica detalle
            else if(action.equals("repvtDetTel"))
            {
                url = "/repvtDetTel_Header.jsp";
            }
            else if(action.equals("XXXXrepvtDetTel"))
            {
                String initDate = request.getParameter("txtfStartDate");
                String endDate = request.getParameter("txtfEndDate");
                String []bancos = request.getParameterValues("telefonica");
                String bancosStr="";
                for(String banco:bancos){
                    if(!bancosStr.equals(""))
                        bancosStr+=",";
                    bancosStr+=banco;
                }
                session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                session.setAttribute("initDate", initDate);
                session.setAttribute("endDate", endDate);
                session.setAttribute("Telefonica", bancosStr);
                try
                {
                    url = value.valida(session, initDate, endDate, "reporteTelefonicaDetalle");
                    viewerManager.setUpViewer(this, request, response, url);
                    isAnswerReport=true;
                }
                catch (WellException e)
                {
                    e.printStackTrace();
                }
            }

            // fin  reporte Telefonica detalle

            //  inicio reporte distribuidor detalle
            else if(action.equals("repvtDetDis"))
            {
                url = "/repvtDetDis_Header.jsp";
            }
            else if(action.equals("XXXXrepvtDetDis"))
            {
                String initDate = request.getParameter("txtfStartDate");
                String endDate = request.getParameter("txtfEndDate");
                String []bancos = request.getParameterValues("banco");
                String bancosStr="";
                for(String banco:bancos){
                    if(!bancosStr.equals(""))
                        bancosStr+=",";
                    bancosStr+=banco;
                }
                session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                session.setAttribute("initDate", initDate);
                session.setAttribute("endDate", endDate);
                session.setAttribute("Distribuidor", bancosStr);
                try
                {
                    url = value.valida(session, initDate, endDate, "reporteDistribuidorDetalle");
                    viewerManager.setUpViewer(this, request, response, url);
                    isAnswerReport=true;
                }
                catch (WellException e)
                {
                    e.printStackTrace();
                }
            }
            // fin reporte distribuidor detalle

            // inicio adquiriente acumulado
            else if(action.equals("repvtAcuAdq"))
            {
                url = "/repvtAcuAdq_Header.jsp";
            }
            else if(action.equals("XXXXrepvtAcuAdq"))
            {
                String initDate = request.getParameter("txtfStartDate");
                String endDate = request.getParameter("txtfEndDate");
                String []bancos = request.getParameterValues("banco");
                String bancosStr="";
                for(String banco:bancos){
                    if(!bancosStr.equals(""))
                        bancosStr+=",";
                    bancosStr+=banco;
                }
                session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                session.setAttribute("initDate", initDate);
                session.setAttribute("endDate", endDate);
                session.setAttribute("Adquiriente", bancosStr);
                try
                {
                    url = value.valida(session, initDate, endDate, "reporteAcumuladoAdquiriente");
                    viewerManager.setUpViewer(this, request, response, url);
                    isAnswerReport=true;
                }
                catch (WellException e)
                {
                    e.printStackTrace();
                }
            }
            // fin adquiriente acumulado

            //inicio telefonica acumulado
            else if(action.equals("repvtAcuTel"))
            {
                url = "/repvtAcuTel_Header.jsp";
            }
            else if(action.equals("XXXXrepvtAcuTel"))
            {
                String initDate = request.getParameter("txtfStartDate");
                String endDate = request.getParameter("txtfEndDate");
                String []telefonica = request.getParameterValues("banco");
                String telefonicaStr="";
                for(String banco:telefonica){
                    if(!telefonicaStr.equals(""))
                        telefonicaStr+=",";
                    telefonicaStr+=banco;
                }
                session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                session.setAttribute("initDate", initDate);
                session.setAttribute("endDate", endDate);
                session.setAttribute("Telefonica", telefonicaStr);
                try
                {
                    url = value.valida(session, initDate, endDate, "reporteAcumuladoTelefonica");
                    viewerManager.setUpViewer(this, request, response, url);
                    isAnswerReport=true;
                }
                catch (WellException e)
                {
                    e.printStackTrace();
                }
            }

            //  fin telefonica acumulado

            //  inicio distribuidor acumulado
            else if(action.equals("repvtAcuDis"))
            {
                url = "/repvtAcuDis_Header.jsp";
            }
            else if(action.equals("XXXXrepvtAcuDis"))
            {
                String initDate = request.getParameter("txtfStartDate");
                String endDate = request.getParameter("txtfEndDate");
                String []bancos = request.getParameterValues("banco");
                String bancosStr="";
                for(String banco:bancos){
                    if(!bancosStr.equals(""))
                        bancosStr+=",";
                    bancosStr+=banco;
                }
                session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                session.setAttribute("initDate", initDate);
                session.setAttribute("endDate", endDate);
                session.setAttribute("Distribuidor", bancosStr);
                try
                {
                    url = value.valida(session, initDate, endDate, "reporteAcumuladoDistribuidor");
                    viewerManager.setUpViewer(this, request, response, url);
                    isAnswerReport=true;
                }
                catch (WellException e)
                {
                    e.printStackTrace();
                }
            }

            // fin de distribudor acumulado

            // inicio distribuidor acumulado Tipo pago
            else if(action.equals("repvtAcuDisTipoPago"))
            {
                url = "/repvtAcuDis_Header_Tipo_Pago.jsp";
            }
            else if(action.equals("XXXXrepvtAcuDisTipoPago"))
            {
                String initDate = request.getParameter("txtfStartDate");
                String endDate = request.getParameter("txtfEndDate");
                String []bancos = request.getParameterValues("banco");
                String bancosStr="";
                for(String banco:bancos){
                    if(!bancosStr.equals(""))
                        bancosStr+=",";
                    bancosStr+=banco;
                }
                session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                session.setAttribute("initDate", initDate);
                session.setAttribute("endDate", endDate);
                session.setAttribute("Distribuidor", bancosStr);
                try
                {
                    url = value.valida(session, initDate, endDate, "reporteAcumuladoDistribuidorTipoPago");
                    viewerManager.setUpViewer(this, request, response, url);
                    isAnswerReport=true;
                }
                catch (WellException e)
                {
                    e.printStackTrace();
                }
            }
           // fin de distribudor acumulado tipo pago
          /* Marca del Cambio : SAS-JAGG-Z-02-2675-12 finaliza la Modificacion     13/02/2013 */

                    //Inicia de  acumulado comercio
            /* Marca del Cambio : SAS-DRT-P-20-0500-11 y Z-02-2675-12  Inicia la Modificacion     28/06/2016 */
            else if(action.equals("repvtAcuCom"))
            {
                url = "/repvtAcuComHeader.jsp";
            }
            else if(action.equals("repvtAcuComMain"))
            {
                String initDate = request.getParameter("txtfStartDate");
                String endDate = request.getParameter("txtfEndDate");
                String []bancos = request.getParameterValues("banco");
                String bancosStr="";
                for(String banco:bancos){
                    if(!bancosStr.equals(""))
                        bancosStr+=",";
                    bancosStr+=banco;
                }
                String []tipoPago = request.getParameterValues("tipoPago");
                String tipoPagoStr="";
                for(String pago:tipoPago){
                    if(!tipoPagoStr.equals(""))
                        tipoPagoStr+=",";
                    tipoPagoStr+=pago;
                }
                String []distribuidor = request.getParameterValues("distribuidor");
                String distribuidorStr="";
                for(String distri:distribuidor){
                    if(!distribuidorStr.equals(""))
                        distribuidorStr+=",";
                    distribuidorStr+=distri;
                }
                String []telefonica = request.getParameterValues("telefonica");
                String telefonicaStr="";
                for(String telef:telefonica){
                    if(!telefonicaStr.equals(""))
                        telefonicaStr+=",";
                    telefonicaStr+=telef;
                }
                session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                session.setAttribute("initDate", initDate);
                session.setAttribute("endDate", endDate);
                session.setAttribute("bancoS", bancosStr);
                session.setAttribute("tipoPagoS", tipoPagoStr);
                session.setAttribute("distribuidorS", distribuidorStr);
                session.setAttribute("telefonicaS", telefonicaStr);
                try
                {
                    url = value.valida(session, initDate, endDate, "reporteAcumuladoComercio");
                    viewerManager.setUpViewer(this, request, response, url);
                    isAnswerReport=true;
                }
                catch (WellException e)
                {
                    e.printStackTrace();
                }
            }


                //Reporte 0460H
                else if(action.equals("SICLIR0460H"))
                {
                    System.out.println("460h");
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    url = "/SICLIR0460HHeader.jsp";
                }
                else if(action.equals("SICLIR0460HMain"))
                {
                    SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String []bancoEmiArray = request.getParameterValues("bancoEmi");
                    String bancoEmi="";
                    for(String banco:bancoEmiArray){
                        if(!bancoEmi.equals(""))
                            bancoEmi+=",";
                        bancoEmi+=banco;
                    }
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute( "txtfStartDate", initDate);
                    session.setAttribute( "txtfEndDate", endDate);
                    session.setAttribute( "bancoEmi", bancoEmi);
                    try
                    {
                        Oparticiones(initDate, endDate);
                        url = value.valida(session, initDate, endDate, "Siclir0460H");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }
                }

                //Reporte 0350
                else if(action.equals("SICLIR0350"))
                {
                    session.setAttribute( "PRSA_SETL_IND", this.PRSA_SETL_IND);
                    session.setAttribute( "PRSA_RPT_IND", this.PRSA_RPT_IND);
                    session.setAttribute( "PRSA_ENTIDADES", this.PRSA_ENTIDADES );
                    session.setAttribute( "VW_BUS_ACQ", this.VW_BUS_ACQ );
                    session.setAttribute( "VW_BUS_EMI", this.VW_BUS_EMI );
                    session.setAttribute( "CD_TXN_CD", this.CD_TXN_CD );
                    url = "/SICLIR0350Header.jsp";
                }
                else if(action.equals("SICLIR0350Main"))
                {
                    SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                    String initDate = request.getParameter("txtfStartDate");
                    String endDate = request.getParameter("txtfEndDate");
                    String []bancoArray = request.getParameterValues("banco");
                    String banco="";
                    for(String bancoFor:bancoArray){
                        if(!banco.equals(""))
                            banco+=",";
                        banco+=bancoFor;
                    }
                 String []tipoProcArray = request.getParameterValues("tipoProc");
                    String tipoProc="";
                    for(String tipoProcTmp:tipoProcArray){
                        if(!tipoProc.equals(""))
                            tipoProc+=",";
                        tipoProc+=tipoProcTmp;
                    }
                    String []numMiscArray = request.getParameterValues("numMisc");
                    String numMisc="";
                    for(String numMiscTmp:numMiscArray){
                        if(!numMisc.equals(""))
                            numMisc+=",";
                        numMisc+=numMiscTmp;
                    }
                    String agrTotales=request.getParameter("agrTotales");
                    String tipoEmiAdq=request.getParameter("tipoEmiAdq");
                    if(agrTotales==null)
                        agrTotales="false";
                    else
                        agrTotales="true";
                    session.setAttribute( "txtfStartDate", initDate);
                    session.setAttribute( "txtfEndDate", endDate);
                    session.setAttribute( "banco", banco);
                    session.setAttribute( "numMisc", numMisc);
                    session.setAttribute( "tipoProc", tipoProc);
                    session.setAttribute("agrTotales", agrTotales);
                    session.setAttribute("tipoEmiAdq", tipoEmiAdq);

                    try
                    {
                        session.setAttribute("initDateHabAnt", format.format(TimeUtils.getDiaHabilAnt(session, format.parse(initDate))));
                        session.setAttribute("endDateHabAnt", format.format(TimeUtils.getDiaHabilAnt(session, format.parse(endDate))));
                        url = value.valida(session, initDate, endDate, "Siclir0350");
                        viewerManager.setUpViewer(this, request, response, url);
                        isAnswerReport=true;
                    }
                    catch (WellException e)
                    {
                        e.printStackTrace();
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
/*--------------------------------------------------------------------------- */
/* Marca del Cambio: AXIA-GGB-P-53-2933-14 Inicia  la Modificacion 25/05/2015 */
/*--------------------------------------------------------------------------- */
                } else if(    action.equals("rlqMontosHeader")
                               || action.equals("rlqMontosHeaderAct")
                               || action.equals("rlqMontosHeaderPrc")
                               || action.indexOf("SICLIQ") >= 0
                           )
                {
                    proc = new RlqMontos();
                    url = proc.procesaPeticion(request);
                    if (!url.equals("login.jsp"))
                        if (action.indexOf("SICLIQ") >= 0) {
                              if (action.indexOf("Main") >= 0) {
                                    viewerManager.setUpViewer(this, request, response, url);
                                    isAnswerReport=true;
                              }
                        }
                    proc = null;
/*--------------------------------------------------------------------------- */
/* Marca del Cambio: AXIA-GGB-P-53-2933-14 Termina la Modificacion 25/05/2015 */
/*--------------------------------------------------------------------------- */
                }else{
                    ParametrosCompartidos pC=new ParametrosCompartidos();
                    pC.setUrl(url);
                    pC.setIsAnswerReport(isAnswerReport);
                    processRequestContinua(request, response,pC);
                    url=pC.getUrl();
                    isAnswerReport=pC.getIsAnswerReport();

                }




        }
        }catch (NullPointerException npe) {
            // TODO: handle exception
            System.out.println("Aplicacion: NullpointerException");
        }

        if(!isAnswerReport){
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        }  catch (WellException e) {
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

    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
            rutaContext=this.getServletContext().getRealPath("");
        }  catch (WellException e) {
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

    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>

    /**
     * tg_GGE3
     * Lineas a pegar
     */
    /*VHF*/
    public String Posicion(String posicion)
    {
        String retorno = "a0";

        //if posicion is null, wont show open menu
        if(posicion  == null)
            return retorno;
        else
        {
            //'posicion' always must be 2 lenght and start with the letter 'a'
            if(posicion.length() != 2 || !posicion.startsWith("a") )
                return retorno;
            else
            {
                int n = 0;

                try
                {
                    n = Integer.parseInt(posicion.substring(1));
                }
                catch (NumberFormatException e)
                {
                    return retorno;
                }

                if(n > 2 || n == 0)
                    return retorno;
                else
                    retorno = posicion;
            }
        }

        return retorno;
    }
    /**
     * fin de lineas a pegar tg_GGE3
     *
     */

    // GSOF-MVR-C-08-2129-12 Marca de Inicio
    // VALIDA LA AFILIACION
    private String validaAfiliacion(String cuenta){
        BigInteger numero;
        String regreso = "";
    // GSOF-MVR-C-08-2129-12 Marca de Inicio
        AltasDAO modelo = new AltasDAO();

        if(cuenta.length() == 0){
            return regreso;
        }

        if(modelo.existeAfiliacion(cuenta) == true){
            return "La Afiliacion ya existe";
        }
    // GSOF-MVR-C-08-2129-12 Marca de Terminacion

        try {
            numero = new BigInteger(cuenta);

            if(numero.compareTo(new BigInteger("0")) <= 0){
                regreso = "El campo debe ser positivo";
            }
        } catch(Exception ex){
            regreso = "El campo debe ser num&eacute;rico";
        }
        return regreso;
    }

    // VALIDA LA CUENTA IMPORTANDO LA LONGITUD (ALTA)
    private String validaCuenta(String cuenta){
        BigInteger numero;
        String regreso = "";
    // GSOF-MVR-C-08-2129-12 Marca de Inicio
        AltasDAO modelo = new AltasDAO();

        if(cuenta.length() == 0){
            return regreso;
        }

        if(modelo.existeCuenta(cuenta) == true){
            return "La Cuenta ya existe";
        }
    // GSOF-MVR-C-08-2129-12 Marca de Terminacion

        // LA CUENTA DEBE SER NUMERICA SI SE CAPTURA
        if(cuenta.length() >= 16){
            try {
                numero = new BigInteger(cuenta);

                if(numero.compareTo(new BigInteger("0")) <= 0){
                    regreso = "El campo debe ser positivo";
                }
            } catch(Exception ex){
                regreso = "El campo debe ser num&eacute;rico";
            }
        }else{
            regreso = "Debe ser num&eacute;rico de m&iacute;nimo 16 d&iacute;gitos";
        }

        return regreso;
    }

    //VALIDA UNA CUENTA SIN IMPORTAR LA LONGITUD
    private String validaCuentaSin(String cuenta){
        BigInteger numero;
        String regreso = "";
    // GSOF-MVR-C-08-2129-12 Marca de Inicio
        AltasDAO modelo = new AltasDAO();

        if(cuenta.length() == 0){
            return regreso;
        }

        if(modelo.existeCuenta(cuenta) == true){
            return "La Cuenta ya existe";
        }
    // GSOF-MVR-C-08-2129-12 Marca de Terminacion

        try {
            numero = new BigInteger(cuenta);

            if(numero.compareTo(new BigInteger("0")) <= 0){
                regreso = "El campo debe ser positivo";
            }
        } catch(Exception ex){
            regreso = "El campo debe ser num&eacute;rico";
        }
        return regreso;
    }
    // GSOF-MVR-C-08-2129-12 Marca de Terminacion
    class ParametrosCompartidos{
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
/*--------------------------------------------------------------------------- */
/* Marca del Cambio: AXIA-GGB-P-02-0275-12 Inicia  la Modificacion 18/12/2014 */
/*----------------------------------------------------------------------------*/
      private String getTipo(String banco) throws WellException {
      ArrayList tienumero;
      String tRes="";
      String bancoCad=banco;
      String SQL2="SELECT DISTINCT PE.TIE_NUMERO FROM PMADMIN.PRSA_ENTIDADES PE WHERE PE.NUMERO_FIID IN('"+bancoCad+ "')";

      db.setQuerySelect(SQL2);
      db.executeQuerySelect();
      tienumero=db.getRSColsData();

      String[] vv2 =(String[]) tienumero.get(0);
      tRes = vv2[0];

      return tRes;
    }
/*--------------------------------------------------------------------------- */
/* Marca del Cambio: AXIA-GGB-P-02-0275-12 Termina la Modificacion 18/12/2014 */
/*----------------------------------------------------------------------------*/
}
