/*###############################################################################
# Nombre del Programa :  Validador.java                                         #
# Autor               :  JOAQUIN MOJICA Q.                                      #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-08-299-04                 	   FECHA:15/10/2008     #
# Descripcion General :	 Clase para el manejo de la seguridad                   #
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :  Acceder al sistema                                     #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :  A Peticion del web, se pueden ejecutar n instancias    #
#-------------------------------------------------------------------------------#
#                                                              Modificaciones   #
#-------------------------------------------------------------------------------#
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
package com.wellcom.Validator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.wellcom.exceptions.WellException;
import com.wellcom.Validator.Mantenimiento;
/*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
import com.wellcom.conexion.*;
/*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */

public class Validador {

    private String role;
    private String query, query2, query3;
    /*#Marca de cambio:  SAS-DRT F-52-8063-16  inico Modificación #  */
    ConexionORACLE conOracle = null;

    /*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */
    public String valida(HttpSession session, String initDate, String endDate, String report) throws WellException {
        String Fiid;
        String ruta;
        role = (String) session.getAttribute("role");
        Fiid = (String) session.getAttribute("numFiid");
        ruta = (String) session.getAttribute("rutaContext");
        System.err.println("los datos: " + role + "--" + Fiid + "--" + ruta + "--");
        ArrayList cbValues, cbValues2, cbValues3;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        if (role != null && role.equals("banco")) {
            try {
                /*#Marca de cambio:  SAS-DRT F-52-8063-16  inico Modificación #  */
                conOracle = new ConexionORACLE();
                /*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */
                query = " SELECT *  "
                        + "  FROM  PMADMIN.PRSA_SETL_IND, PMADMIN.PRSA_RPT_IND "
                        + "  WHERE TRUNC(PSI_REC_DT) BETWEEN TO_DATE('" + initDate + "','dd-MM-yyyy')  "
                        + "  and TO_DATE('" + endDate + "','dd-MM-yyyy')  "
                        + "  AND PSI_NSI_CLR_ID=PRI_NSI_CLR_ID  "
                        + "  AND UPPER(TRIM(PRI_RPT_ID))=UPPER('" + report + "')  "
                        + "  AND PSI_IND=1 ";

                query2 = " SELECT *  "
                        + "  FROM PMADMIN.PRSA_RPT_IND "
                        + " JOIN  PMADMIN.PRSA_SETL_IND "
                        + " ON PSI_NSI_CLR_ID=PRI_NSI_CLR_ID "
                        + "  WHERE UPPER(TRIM(PRI_RPT_ID))=UPPER('" + report + "') "
                        + " AND ROWNUM <= 10 ";

                query3 = " SELECT *  "
                        + "  FROM  PMADMIN.PRSA_SETL_IND, PMADMIN.PRSA_RPT_IND "
                        + "  WHERE TRUNC(PSI_REC_DT) BETWEEN TO_DATE('" + initDate + "','dd-MM-yyyy')  "
                        + "  and TO_DATE('" + endDate + "','dd-MM-yyyy')  "
                        + "  AND PSI_NSI_CLR_ID=PRI_NSI_CLR_ID  "
                        + "  AND UPPER(TRIM(PRI_RPT_ID))=UPPER('" + report + "')  "
                        + "  AND PSI_IND=2 ";
                /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
                conOracle.Conectar();
                conOracle.Consultar(query);
                cbValues = conOracle.getRSColsData();

                conOracle.Consultar(query2);
                cbValues2 = conOracle.getRSColsData();

                conOracle.Consultar(query3);
                cbValues3 = conOracle.getRSColsData();
                /*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */
                if (cbValues.size() == 0 && cbValues2.size() > 0 && cbValues3.size() == 0) {
                    return "/fechasInvalidas.jsp?noPantalla=1";
                }

                if (cbValues3.size() > 0) {
                    return "/fechasInvalidas.jsp?noPantalla=6";
                }
            } catch (Exception ex) {
                throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
             /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
            } finally {
                conOracle.Desconectar();
            }/*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */
            try {
                new Mantenimiento();
                if (format.parse(initDate).compareTo(format.parse(Mantenimiento.fechasLib(Fiid, initDate, ruta))) < 0) {
                    return "/fechasInvalidas.jsp?noPantalla=3";
                }
            } catch (Exception ex) {
                throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
            }
        }

        try {
            if (format.parse(initDate).compareTo(format.parse(endDate)) > 0) {
                return "/fechasInvalidas.jsp?noPantalla=2";
            }
        } catch (Exception ex) {
            throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
        }
        return "/reportsjsp/managerReports.jsp" + "?report=" + report;
    }
}
