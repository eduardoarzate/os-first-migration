/*###############################################################################
# Nombre del Programa :  fiidManager.java                                       #
# Autor               :  JOAQUIN MOJICA Q.                                      #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-08-299-04                 	   FECHA:15/10/2008     #
# Descripcion General :										        	        #
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :  Acceder al sistema                                     #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :  A Peticion del web, se pueden ejecutar n instancias    #
#################################################################################
#								MODIFICACIONES                                  #
#-------------------------------------------------------------------------------#
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 12/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
package com.wellcom.prosa.sacii;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import com.wellcom.exceptions.WellException;
/*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
import com.wellcom.conexion.*;
//import com.wellcom.sql.Database;

/*#Marca de cambio:  SAS-DRT F-52-8063-16  Fin Modificación #  */
public class fiidManager {

    private String rol;
    private String numFiid;
    private boolean elPrimero;
    /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
    ConexionORACLE conOracle = null;

    /*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */
    public void NumeroProsa(HttpSession session) throws WellException {
        /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
 /*String sessionID;
        Database db;
        String PRSA_ENTIDADES;
        String PRSA_DBL_FIID;
        String VW_BUS_EMI;
        String VW_BUS_ACQ;
         */
        String valuesNoProsa[] = null;
        String numerosProsa = null;
        elPrimero = true;
        ArrayList cbValues;
        ArrayList result;
        ArrayList result1;
        ArrayList result2;
        conOracle = new ConexionORACLE();
        /*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */
        try {
            /*
            sessionID = session.getId() + "db";
	    db = (Database)session.getAttribute( sessionID );
	    PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
	    VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
	    VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
            PRSA_DBL_FIID = (String)session.getAttribute( "PRSA_DBL_FIID" );
             */
            rol = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            elPrimero = true;

            //Obtener los numeros prosa 
            if (rol.equals("banco")) {
                String query = "";

                if (numFiid.equals("AMEX")) {
                    numFiid = "B106";
                }

                if (fiidManager.specialFiid(session, numFiid)) {

                    query = " select distinct hijas.numero_prosa "
                            + " from PMADMIN.PRSA_ENTIDADES hijas, PMADMIN.PRSA_ENTIDADES padre "
                            + " where "
                            + " hijas.entidad_padre != hijas.numero_prosa "
                            + " and hijas.numero_fiid != padre.numero_fiid "
                            + " and hijas.entidad_padre = padre.numero_prosa "
                            + " and hijas.tie_numero = 1 "
                            + " and hijas.numero_fiid= upper('" + numFiid + "') "
                            + " or hijas.numero_fiid in( "
                            + " select DBL_FIID_PROSA "
                            + " from  PMADMIN.PRSA_DBL_FIID "
                            + " where FIID_PROSA in (upper('" + numFiid + "')) "
                            + "  ) ";
                } else {
                    //query =	" select distinct entidad_padre "+ 
                    query = " select distinct numero_prosa "
                            + " from PMADMIN.PRSA_ENTIDADES "
                            + " where numero_fiid in(upper('" + numFiid + "')) "
                            + " or numero_fiid in( "
                            + " select dbl_fiid_prosa "
                            + " from PMADMIN.PRSA_DBL_FIID "
                            + " where fiid_prosa in(upper('" + numFiid + "')) "
                            + " ) "
                            + " union "
                            + " select distinct hijas.numero_prosa "
                            + " from PMADMIN.PRSA_ENTIDADES hijas, PMADMIN.PRSA_ENTIDADES padre "
                            + " where "
                            + " hijas.entidad_padre != hijas.numero_prosa "
                            + " and hijas.entidad_padre = padre.numero_prosa "
                            + " and hijas.tie_numero=1 "
                            + " and padre.numero_fiid= upper('" + numFiid + "') "
                            + " and ( "
                            + " (hijas.ENTIDAD_PADRE not in (select numero_prosa from PMADMIN.VW_BUS_EMI)"
                            + " and hijas.NUMERO_PROSA  in (select numero_prosa from PMADMIN.VW_BUS_EMI)) "
                            + " or (hijas.ENTIDAD_PADRE not in(select numero_prosa from PMADMIN.VW_BUS_ACQ) "
                            + " and hijas.NUMERO_PROSA  in(select numero_prosa from PMADMIN.VW_BUS_ACQ) ) "
                            + " ) ";
                }
                /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
                //db.setQuerySelect( query );
                //db.executeQuerySelect();
                conOracle.Conectar();
                conOracle.Consultar(query);
                cbValues = conOracle.getRSColsData();

                Iterator it = cbValues.iterator();
                while (it.hasNext()) {
                    valuesNoProsa = (String[]) it.next();
                    if (elPrimero) {
                        numerosProsa = valuesNoProsa[0];
                        elPrimero = false;
                    } else {
                        numerosProsa += "," + valuesNoProsa[0];
                    }
                }

                query = "select * from pmadmin.vw_bus_acq where numero_prosa in(" + numerosProsa + ")";
                conOracle.Consultar(query);
                result = conOracle.getRSColsData();
                //db.setQuerySelect( query );
                //db.executeQuerySelect();

                if (result.size() == 0) {
                    session.setAttribute("adquirente", "false");
                } else {
                    session.setAttribute("adquirente", "true");
                    Integer rolAccVal = (Integer) session.getAttribute("rolAccVal");
                    rolAccVal += 4;
                    session.setAttribute("rolAccVal", rolAccVal);
                }
                query = "select * from pmadmin.vw_bus_emi where numero_prosa in(" + numerosProsa + ")";
                //.setQuerySelect( query );
                //db.executeQuerySelect();
                conOracle.Consultar(query);
                result1 = conOracle.getRSColsData();

                if (result1.size() == 0) {
                    session.setAttribute("emisor", "false");
                } else {
                    session.setAttribute("emisor", "true");
                    Integer rolAccVal = (Integer) session.getAttribute("rolAccVal");
                    rolAccVal += 8;
                    session.setAttribute("rolAccVal", rolAccVal);
                }

                query = "select * from pmadmin.vw_bus_acq where tie_numero=2 and numero_prosa in(" + numerosProsa + ")";
                conOracle.Consultar(query);
                result2 = conOracle.getRSColsData();
                //db.setQuerySelect( query );
                //db.executeQuerySelect();

                if (result2.size() == 0) {
                    session.setAttribute("interred", "false");
                } else {
                    session.setAttribute("interred", "true");
                    Integer rolAccVal = (Integer) session.getAttribute("rolAccVal");
                    rolAccVal += 16;
                    session.setAttribute("rolAccVal", rolAccVal);
                }
                session.setAttribute("numerosProsaEnSession", numerosProsa);
            }
            System.out.println("Entidades: " + numerosProsa);
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.fiidManager: " + ex.toString());
        } finally {
            conOracle.Desconectar();
            /*#Marca de cambio:  SAS-DRT F-52-8063-16  FIN Modificación #  */
        }
    }

    static private boolean specialFiid(HttpSession session, String numFiid) throws WellException {
        boolean result = false;
        String query;
        /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
        //String PRSA_ENTIDADES;
        //String sessionID;
        String valuesCount[] = null;
        //Database db;
        //PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
        ConexionORACLE conOracle = new ConexionORACLE();
        ArrayList result3;

        try {
            //sessionID = session.getId() + "db";
            //db = (Database) session.getAttribute(sessionID);
            query = " select * "
                    + " from PMADMIN.PRSA_ENTIDADES hijas, PMADMIN.PRSA_ENTIDADES padre "
                    + " where "
                    + " hijas.entidad_padre != hijas.numero_prosa "
                    + " and hijas.numero_fiid != padre.NUMERO_FIID "
                    + " and hijas.entidad_padre = padre.numero_prosa "
                    + " and hijas.tie_numero=1 "
                    + " and hijas.numero_fiid in (upper('" + numFiid + "'))";

            conOracle.Conectar();
            conOracle.Consultar(query);
            //db.setQuerySelect(query);
            //db.executeQuerySelect();
            result3 = conOracle.getRSColsData();

            if (result3.size() > 0) {
                result = true;
            }

            return result;
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoEmiInterRed: " + ex.toString());
        } finally {
            conOracle.Desconectar();
            /*#Marca de cambio:  SAS-DRT F-52-8063-16  FIN Modificación #  */
        }
    }
}
