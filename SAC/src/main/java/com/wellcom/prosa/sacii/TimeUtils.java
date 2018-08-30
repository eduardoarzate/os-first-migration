/*###############################################################################
# Nombre del Programa :  TimeUtils.java                                         #
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
#								MODIFICACIONES  #
#-------------------------------------------------------------------------------#
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
package com.wellcom.prosa.sacii;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import com.wellcom.exceptions.WellException;
/*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
import com.wellcom.conexion.*;
/*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */

public class TimeUtils {

    private static String twoDigits;

    public static String get2Digits(String value) {

        twoDigits = (value.length() == 1 ? "0" + value : value);

        return twoDigits;
    }

    public static Date getDiaHabilAnt(HttpSession session, Date diaActual) throws WellException {
        Date diaHabilAnt = new Date(diaActual.getTime() - 86400000);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        if (diaHabilAnt.getDay() == 0 || diaHabilAnt.getDay() == 6) {
            diaHabilAnt = getDiaHabilAnt(session, diaHabilAnt);
        } else {
            /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
            ConexionORACLE conOracle = new ConexionORACLE();
            try {
                conOracle.Conectar();
                int numRows;
                String query = "select * from core.cz_nonprocess_day where ch_nonprocess_date=to_date('" + format.format(diaHabilAnt) + "','dd-MM-yyyy')";
                conOracle.Consultar(query);
                numRows = conOracle.getNumRowsRS();
                if (numRows > 0) {
                    diaHabilAnt = getDiaHabilAnt(session, diaHabilAnt);
                }
            } catch (Exception ex) {
                throw new WellException("com.wellcom.Validador.valida: " + ex.toString());
            } finally {
                conOracle.Desconectar();
            }
            /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
        }
        return diaHabilAnt;
    }

    public static Date getDiaNatAnt(HttpSession session, Date diaActual) throws WellException {
        Date diaHabilAnt = new Date(diaActual.getTime() - 86400000);
        return diaHabilAnt;
    }
}
