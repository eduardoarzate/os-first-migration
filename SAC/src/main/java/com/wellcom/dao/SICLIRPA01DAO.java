// ----------------------------------------------------------------------------
// Nombre del Programa : SICLIRPA01DAO.java
// Autor               : Manuel Villalobos
// Compania            : GSOF
// Proyecto/Procliente : B-54-2092-15                        Fecha: 29/OCT/2015
// Descripcion General : CLASE QUE REPRESENTA UN OBJETO DAO PARA REPORTES SICCMR
// Programa Dependiente: N/A
// Programa Subsecuente: N/A
// Cond. de ejecucion  : N/A
// Dias de ejecucion   : N/A                                 Horario: N/A
//                              MODIFICACIONES
// ----------------------------------------------------------------------------
// Autor               : MANUEL VILLALOBOS
// Compania            : GSOF CONSULTING
// Proyecto/Procliente : B-54-2092-15                 Fecha: 06/ENE/2016
// Marca del Cambio    : GSOF-MVR-B-54-2092-15
// Modificación        : SE CAMBIA LA MANERA DE OBTENER LOS DATOS DEL REPORTE
// ----------------------------------------------------------------------------
// Numero de Parametros:
// Parametros Entrada  :                                    Formato:
//
// Parametros Salida   : N/A                                Formato: N/A
// ----------------------------------------------------------------------------

package com.wellcom.dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.wellcom.beans.*;
import java.text.SimpleDateFormat;

// ESTA CLASE DEFINE LOS ACCESOS A BD PARA REPORTES
public class SICLIRPA01DAO {
    private Connection          conexion;
    private SimpleDateFormat    formato  = new SimpleDateFormat("dd-MMM-yyyy", new Locale("es","MX"));
    private SimpleDateFormat    formato2 = new SimpleDateFormat("dd/MM/yyyy",  new Locale("es","MX"));

    public SICLIRPA01DAO() {
    }

    // OBTIENE UNA CONEXION DE PMT
    private void obtieneConexion(){
        try {
            this.conexion = ConexionSICCMR.getInstance().getConnection();
        } catch (SQLException ex) {
            System.out.println("Error al inicializar SICLIRPA01DAO, " + ex.toString());
            ex.printStackTrace();
        }
    }

    // CIERRA LA CONEXION
    private void cierraConexion(){
        try{
            // LA CIERRA SOLO SI NO HA SIDO CERRADA
            if(!conexion.isClosed()){
                // CIERRA LA CONEXION
                conexion.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error al cerrar conexion, " + ex.toString());
            ex.printStackTrace();
        }
    }

// GSOF-MVR-B-54-2092-15 Marca de Inicio
    // APLICA OBTIENE LOS DATOS DE UN CONCEPTO
    public ArrayList consultaSICLIRPA01(String feIni, String feFin) {
        ArrayList       resultado    = new ArrayList();
        SICLIRPA01Obj   objeto1      = null;
        SICLIRPA01Obj   objeto2      = null;
        SICLIRPA01Obj   sumary       = null;
        String          sSQLCorte2   ="SELECT COUNT(1), SUM(IMPORTE_TOTAL_TRANSAC) FROM SUPERSIC.TRANSACCIONES_ACEPTADAS@LG_PMTU_SICB " +
                                      "WHERE FECHA_PROCESO_TRANSAC BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') " +
                                      "AND ENT_NUMERO_PROSA_EMI = 61 AND TTR_NUMERO = 20 AND CUTOVER_IND = 2";
        String          sSQLCorte1   ="SELECT COUNT(1), SUM(IMPORTE_TOTAL_TRANSAC) FROM SUPERSIC.TRANSACCIONES_ACEPTADAS@LG_PMTU_SICB " +
                                      "WHERE FECHA_PROCESO_TRANSAC BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') " +
                                      "AND ENT_NUMERO_PROSA_EMI = 61 AND TTR_NUMERO = 20 AND CUTOVER_IND = 1";
        String          fecha1       = "";
        String          fecha2       = "";
        String          fecha3       = "";
        String          fecha4       = "";
        Double          imp1         = 0.0;
        Integer         trx1         = 0;
        Double          imp2         = 0.0;
        Integer         trx2         = 0;

        try{
            // OBTIENE LAS 4 FECHAS
            fecha1 = fecha1(feIni);
            fecha2 = fecha2(feIni);
            fecha3 = fecha3(feIni);
            fecha4 = fecha4(feFin);

            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt = conexion.prepareStatement(sSQLCorte1);
                pStmt.setString(1, fecha3);
                pStmt.setString(2, fecha4);
                rDatos = pStmt.executeQuery();

                while(rDatos.next()){
                    trx1 = new Integer(rDatos.getString(1));
                    imp1 = new Double(rDatos.getString(2));
                }

                pStmt  = null;
                rDatos = null;

                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt = conexion.prepareStatement(sSQLCorte2);
                pStmt.setString(1, fecha1);
                pStmt.setString(2, fecha2);
                rDatos = pStmt.executeQuery();

                while(rDatos.next()){
                    trx2 = new Integer(rDatos.getString(1));
                    imp2 = new Double(rDatos.getString(2));
                }
                rDatos.close();

                objeto1 = new SICLIRPA01Obj();
                objeto2 = new SICLIRPA01Obj();
                sumary  = new SICLIRPA01Obj();

                objeto2.setFechaD(   new Date(formato2.parse(fecha1).getTime()));
                objeto2.setFecha(    formato.format(objeto2.getFechaD()));
                objeto2.setFechaliqD(new Date(formato2.parse(feFin).getTime()));
                objeto2.setFechaliq( formato.format(objeto2.getFechaliqD()));
                objeto2.setTrx(      trx2);
                objeto2.setImporte(  imp2);
                objeto2.setCorte(    2);
                objeto2.setLiqcompl( liqComplContra(feIni, feFin));
                objeto2.setMisc(     liqMiscContra(feIni, feFin));
                resultado.add(objeto2);

                objeto1.setFechaD(   new Date(formato2.parse(fecha3).getTime()));
                objeto1.setFecha(    formato.format(objeto1.getFechaD()));
                objeto1.setFechaliqD(new Date(formato2.parse(feFin).getTime()));
                objeto1.setFechaliq( formato.format(objeto1.getFechaliqD()));
                objeto1.setTrx(      trx1);
                objeto1.setImporte(  imp1);
                objeto1.setCorte(    1);
                objeto1.setLiqcompl( liqComplFavor(feIni, feFin));
                objeto1.setMisc(     liqMiscFavor(feIni, feFin));
                resultado.add(objeto1);

                sumary.setFecha(     "Total");
                sumary.setFechaliqD( new Date(formato2.parse(feFin).getTime()));
                sumary.setFechaliq(  formato.format(sumary.getFechaliqD()));
                sumary.setTrx(       trx1 + trx2);
                sumary.setImporte(   imp1 + imp2);
                sumary.setLiqemi(    liqEmi(fecha1, fecha2, fecha3, fecha4));
                sumary.setLiqadq(    liqAdq(feIni, feFin));
                sumary.setLiqcompl(  liqCompl(feIni, feFin));
                sumary.setMisc(      liqMisc(feIni, feFin));
                sumary.setTotamex(   liqAmex(feIni, feFin, fecha1, fecha2, fecha3, fecha4));
                sumary.setSabana(    sabana(feIni, feFin));
                sumary.setDifcortes( difCortes(feIni, feFin, fecha1, fecha2, fecha3, fecha4));
                sumary.setDiferencia(sumary.getTotamex() - sumary.getSabana());
                sumary.setDifreal(   sumary.getDiferencia() - sumary.getDifcortes());
                resultado.add(sumary);
            } catch (Exception e) {
                System.out.println("Error en consultaSICLIPA01, " + e.toString());
                e.printStackTrace();
                resultado = null;
            } finally {
                try{
                    if(pStmt != null) pStmt.close();
                }catch(Exception e){
                }
            }
        } catch(Exception e ) {
            System.out.println(" e " + e);
            System.out.println(",");
        } finally{
            cierraConexion();
        }

        return resultado;
    }

    // OBTIENE LA FECHA1
    public String fecha1(String fecha) {
        PreparedStatement pStmt        = null;
        ResultSet rDatos               = null;
        String sSQL                    = "SELECT TO_CHAR(PMADMIN.FN_DIA_LIQ_ANT_INT(PMADMIN.FNC_DIA_LIQ_NOR_ANTERIOR(TO_DATE(?,'DD/MM/YYYY')-1)),'DD/MM/YYYY') FROM DUAL";
        String regreso                 = "";

        try {
            obtieneConexion();

            // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
            pStmt = conexion.prepareStatement(sSQL);
            pStmt.setString(1, fecha);
            rDatos = pStmt.executeQuery();

            // BARRE LOS REGISTROS OBTENIDOS
            while(rDatos.next()){
                regreso = rDatos.getString(1);
            }
            pStmt.close();
            rDatos.close();
        } catch(Exception e ) {
            System.out.println(" Error al obtener fecha1:" + e);
            System.out.println(",");
            regreso = null;
        } finally{
            cierraConexion();
        }

        return regreso;
    }

    // OBTIENE LA FECHA2
    public String fecha2(String fecha) {
        PreparedStatement pStmt        = null;
        ResultSet rDatos               = null;
        String sSQL                    = "SELECT TO_CHAR(PMADMIN.FNC_DIA_LIQ_NOR_ANTERIOR(TO_DATE(?,'DD/MM/YYYY')-1),'DD/MM/YYYY') FROM DUAL";
        String regreso                 = "";

        try {
            obtieneConexion();

            // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
            pStmt = conexion.prepareStatement(sSQL);
            pStmt.setString(1, fecha);
            rDatos = pStmt.executeQuery();

            // BARRE LOS REGISTROS OBTENIDOS
            while(rDatos.next()){
                regreso = rDatos.getString(1);
            }
            pStmt.close();
            rDatos.close();
        } catch(Exception e ) {
            System.out.println(" Error al obtener fecha2:" + e);
            System.out.println(",");
            regreso = null;
        } finally{
            cierraConexion();
        }

        return regreso;
    }

    // OBTIENE LA FECHA3
    public String fecha3(String fecha) {
        PreparedStatement pStmt        = null;
        ResultSet rDatos               = null;
        String sSQL                    = "SELECT TO_CHAR(PMADMIN.FN_DIA_LIQ_ANT_INT(TO_DATE(?,'DD/MM/YYYY')-1),'DD/MM/YYYY') FROM DUAL";
        String regreso                 = "";

        try {
            obtieneConexion();

            // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
            pStmt = conexion.prepareStatement(sSQL);
            pStmt.setString(1, fecha);
            rDatos = pStmt.executeQuery();

            // BARRE LOS REGISTROS OBTENIDOS
            while(rDatos.next()){
                regreso = rDatos.getString(1);
            }
            pStmt.close();
            rDatos.close();
        } catch(Exception e ) {
            System.out.println(" Error al obtener fecha3:" + e);
            System.out.println(",");
            regreso = null;
        } finally{
            cierraConexion();
        }

        return regreso;
    }

    // OBTIENE LA FECHA4
    public String fecha4(String fecha) {
        PreparedStatement pStmt        = null;
        ResultSet rDatos               = null;
        String sSQL                    = "SELECT TO_CHAR(PMADMIN.FNC_DIA_LIQ_NOR_ANTERIOR(TO_DATE(?,'DD/MM/YYYY')),'DD/MM/YYYY') FROM DUAL";
        String regreso                 = "";

        try {
            obtieneConexion();

            // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
            pStmt = conexion.prepareStatement(sSQL);
            pStmt.setString(1, fecha);
            rDatos = pStmt.executeQuery();

            // BARRE LOS REGISTROS OBTENIDOS
            while(rDatos.next()){
                regreso = rDatos.getString(1);
            }
            pStmt.close();
            rDatos.close();
        } catch(Exception e ) {
            System.out.println(" Error al obtener fecha4:" + e);
            System.out.println(",");
            regreso = null;
        } finally{
            cierraConexion();
        }

        return regreso;
    }

    // OBTIENE EL LIQEMI
    public Double liqEmi(String fecha1, String fecha2, String fecha3, String fecha4) {
        PreparedStatement pStmt        = null;
        ResultSet rDatos               = null;
        String sSQL                    = "SELECT NVL(SUM(IMPORTECORTE),0) FROM (" +
                                         "SELECT SUM(IMPORTE_TOTAL_TRANSAC) IMPORTECORTE FROM SUPERSIC.TRANSACCIONES_ACEPTADAS@LG_PMTU_SICB  " +
                                         "WHERE FECHA_PROCESO_TRANSAC BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') " +
                                         "AND ENT_NUMERO_PROSA_EMI = 61 AND TTR_NUMERO = 20 AND CUTOVER_IND = 2 " +
                                         "UNION ALL " +
                                         "SELECT SUM(IMPORTE_TOTAL_TRANSAC) IMPORTECORTE FROM SUPERSIC.TRANSACCIONES_ACEPTADAS@LG_PMTU_SICB " +
                                         "WHERE FECHA_PROCESO_TRANSAC BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') " +
                                         "AND ENT_NUMERO_PROSA_EMI = 61 AND TTR_NUMERO = 20 AND CUTOVER_IND = 1) ";
        Double regreso                 = 0.0;

        try {
            obtieneConexion();

            // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
            pStmt = conexion.prepareStatement(sSQL);
            pStmt.setString(1, fecha1);
            pStmt.setString(2, fecha2);
            pStmt.setString(3, fecha3);
            pStmt.setString(4, fecha4);
            rDatos = pStmt.executeQuery();

            // BARRE LOS REGISTROS OBTENIDOS
            while(rDatos.next()){
                regreso = new Double(rDatos.getString(1));
            }
            pStmt.close();
            rDatos.close();
        } catch(Exception e ) {
            System.out.println(" Error al obtener liqEmi:" + e);
            System.out.println(",");
            regreso = null;
        } finally{
            cierraConexion();
        }

        return regreso;
    }

    // OBTIENE EL LIQADQ
    public Double liqAdq(String inicio, String fin) {
        PreparedStatement pStmt        = null;
        ResultSet rDatos               = null;
        String sSQL                    = "SELECT NVL(SUM(IMPORTE),0) FROM (" +
                                         "SELECT NVL(SUM(TOTAL_IMPORTE),0) IMPORTE FROM PMADMIN.PRSA_POSICIONES " +
                                         "WHERE FECHA_PROCESO BETWEEN (SELECT PMADMIN.FNC_DIA_LIQ_NOR_ANTERIOR(TO_DATE(?,'DD/MM/YYYY')) FROM DUAL) AND TO_DATE(?,'DD/MM/YYYY')-1 " +
                                         "AND ENT_NUMERO_PROSA_ADQ = 61 AND TTR_NUMERO = 20 " +
                                         "UNION ALL " +
                                         "SELECT NVL(SUM(CASE WHEN FMI_DB_CLR_BU = 172 " +
                                            "THEN -FMI_CHRG_AMT ELSE FMI_CHRG_AMT END),0) IMPORTE "+
                                         "FROM SETTLEMENT.SV_FM_INT_TXN " +
                                         "WHERE FMI_DT BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') " +
                                         "AND (FMI_DB_CLR_BU IN (172) OR FMI_CR_CLR_BU IN (172)) AND FMI_NSI_CLR_ID IN (22,33)) ";
        Double regreso                 = 0.0;

        try {
            obtieneConexion();

            // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
            pStmt = conexion.prepareStatement(sSQL);
            pStmt.setString(1, inicio);
            pStmt.setString(2, fin);
            pStmt.setString(3, inicio);
            pStmt.setString(4, fin);
            rDatos = pStmt.executeQuery();

            // BARRE LOS REGISTROS OBTENIDOS
            while(rDatos.next()){
                regreso = new Double(rDatos.getString(1));
            }
            pStmt.close();
            rDatos.close();
        } catch(Exception e ) {
            System.out.println(" Error al obtener liqAdq:" + e);
            System.out.println(",");
            regreso = null;
        } finally{
            cierraConexion();
        }

        return regreso;
    }

    // OBTIENE EL LIQCOMPL
    public Double liqCompl(String inicio, String fin) {
        PreparedStatement pStmt        = null;
        ResultSet rDatos               = null;
        String sSQL                    = "SELECT NVL(SUM(FMI_CHRG_AMT),0) "+
                                         "FROM SETTLEMENT.SV_FM_INT_TXN " +
                                         "WHERE FMI_DT BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') " +
                                         "AND (FMI_DB_CLR_BU IN (322) OR FMI_CR_CLR_BU IN (322)) AND FMI_NSI_CLR_ID IN (22) ";
        Double regreso                 = 0.0;

        try {
            obtieneConexion();

            // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
            pStmt = conexion.prepareStatement(sSQL);
            pStmt.setString(1, inicio);
            pStmt.setString(2, fin);
            rDatos = pStmt.executeQuery();

            // BARRE LOS REGISTROS OBTENIDOS
            while(rDatos.next()){
                regreso = new Double(rDatos.getString(1));
            }
            pStmt.close();
            rDatos.close();
        } catch(Exception e ) {
            System.out.println(" Error al obtener liqcompl:" + e);
            System.out.println(",");
            regreso = null;
        } finally{
            cierraConexion();
        }

        return regreso;
    }

    // OBTIENE EL LIQMISCL
    public Double liqMisc(String inicio, String fin) {
        PreparedStatement pStmt        = null;
        ResultSet rDatos               = null;
        String sSQL                    = "SELECT NVL(SUM(FMI_CHRG_AMT),0) "+
                                         "FROM SETTLEMENT.SV_FM_INT_TXN " +
                                         "WHERE FMI_DT BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') " +
                                         "AND (FMI_DB_CLR_BU IN (322) OR FMI_CR_CLR_BU IN (322)) AND FMI_NSI_CLR_ID IN (33) ";
        Double regreso                 = 0.0;

        try {
            obtieneConexion();

            // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
            pStmt = conexion.prepareStatement(sSQL);
            pStmt.setString(1, inicio);
            pStmt.setString(2, fin);
            rDatos = pStmt.executeQuery();

            // BARRE LOS REGISTROS OBTENIDOS
            while(rDatos.next()){
                regreso = new Double(rDatos.getString(1));
            }
            pStmt.close();
            rDatos.close();
        } catch(Exception e ) {
            System.out.println(" Error al obtener liqmisc:" + e);
            System.out.println(",");
            regreso = null;
        } finally{
            cierraConexion();
        }

        return regreso;
    }

    // OBTIENE EL AMEX
    public Double liqAmex(String inicio, String fin, String fecha1, String fecha2, String fecha3, String fecha4) {
        PreparedStatement pStmt        = null;
        ResultSet rDatos               = null;
        String sSQL                    = "SELECT SUM(IMPORTE_NETO) FROM ( " +
                                         "SELECT NVL(SUM(IMPORTE_TOTAL_TRANSAC),0) AS IMPORTE_NETO " +
                                         "FROM SUPERSIC.TRANSACCIONES_ACEPTADAS@LG_PMTU_SICB " +
                                         "WHERE FECHA_PROCESO_TRANSAC BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') " +
                                         "AND ENT_NUMERO_PROSA_EMI = 61 AND TTR_NUMERO = 20 AND CUTOVER_IND = 2 " +
                                         "UNION ALL " +
                                         "SELECT NVL(SUM(IMPORTE_TOTAL_TRANSAC),0) IMPORTE_NETO " +
                                         "FROM SUPERSIC.TRANSACCIONES_ACEPTADAS@LG_PMTU_SICB " +
                                         "WHERE FECHA_PROCESO_TRANSAC BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') " +
                                         "AND ENT_NUMERO_PROSA_EMI = 61 AND TTR_NUMERO = 20 AND CUTOVER_IND = 1 " +
                                         "UNION ALL " +
                                         "SELECT NVL(SUM(CASE WHEN FMI_DB_CLR_BU = 322 " +
                                             "THEN -FMI_CHRG_AMT ELSE FMI_CHRG_AMT END),0) IMPORTE_NETO " +
                                         "FROM SETTLEMENT.SV_FM_INT_TXN " +
                                         "WHERE FMI_DT BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') " +
                                         "AND (FMI_DB_CLR_BU IN (322) OR FMI_CR_CLR_BU IN (322)) AND FMI_NSI_CLR_ID IN (22,33)) ";
        Double regreso                 = 0.0;

        try {
            obtieneConexion();

            // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
            pStmt = conexion.prepareStatement(sSQL);
            pStmt.setString(1, fecha1);
            pStmt.setString(2, fecha2);
            pStmt.setString(3, fecha3);
            pStmt.setString(4, fecha4);
            pStmt.setString(5, inicio);
            pStmt.setString(6, fin);
            rDatos = pStmt.executeQuery();

            // BARRE LOS REGISTROS OBTENIDOS
            while(rDatos.next()){
                regreso = new Double(rDatos.getString(1));
            }
            pStmt.close();
            rDatos.close();
        } catch(Exception e ) {
            System.out.println(" Error al obtener liqAmex:" + e);
            System.out.println(",");
            regreso = null;
        } finally{
            cierraConexion();
        }

        return regreso;
    }

    // OBTIENE EL SABANA
    public Double sabana(String inicio, String fin) {
        PreparedStatement pStmt        = null;
        ResultSet rDatos               = null;
        String sSQL                    = "SELECT SUM(IMPORTE_NETO) FROM ( " +
                                         "SELECT SUM(TOTAL_IMPORTE) AS IMPORTE_NETO " +
                                         "FROM PMADMIN.PRSA_POSICIONES " +
                                         "WHERE FECHA_PROCESO BETWEEN (SELECT PMADMIN.FNC_DIA_LIQ_NOR_ANTERIOR(TO_DATE(?,'DD/MM/YYYY')) FROM DUAL) AND  TO_DATE(?,'DD/MM/YYYY')-1 " +
                                         "AND ENT_NUMERO_PROSA_EMI = 61 AND TTR_NUMERO = 20 " +
                                         "UNION ALL " +
                                         "SELECT NVL(SUM(CASE WHEN FMI_DB_CLR_BU = 322 " +
                                             "THEN -FMI_CHRG_AMT ELSE FMI_CHRG_AMT END),0) IMPORTE_NETO " +
                                         "FROM SETTLEMENT.SV_FM_INT_TXN " +
                                         "WHERE FMI_DT BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') " +
                                         "AND (FMI_DB_CLR_BU IN (322) OR FMI_CR_CLR_BU IN (322)) AND FMI_NSI_CLR_ID IN (22,33)) ";
        Double regreso                 = 0.0;

        try {
            obtieneConexion();

            // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
            pStmt = conexion.prepareStatement(sSQL);
            pStmt.setString(1, inicio);
            pStmt.setString(2, fin);
            pStmt.setString(3, inicio);
            pStmt.setString(4, fin);
            rDatos = pStmt.executeQuery();

            // BARRE LOS REGISTROS OBTENIDOS
            while(rDatos.next()){
                regreso = new Double(rDatos.getString(1));
            }
            pStmt.close();
            rDatos.close();
        } catch(Exception e ) {
            System.out.println(" Error al obtener sabana:" + e);
            System.out.println(",");
            regreso = null;
        } finally{
            cierraConexion();
        }

        return regreso;
    }

    // OBTIENE EL DIFCORTES
    public Double difCortes(String inicio, String fin, String fecha1, String fecha2, String fecha3, String fecha4) {
        PreparedStatement pStmt        = null;
        ResultSet rDatos               = null;
        String sSQL                    = "SELECT SUM(IMPORTE_NETO) FROM ( " +
                                         "SELECT -SUM(TOTAL_IMPORTE) IMPORTE_NETO " +
                                         "FROM PMADMIN.PRSA_POSICIONES " +
                                         "WHERE FECHA_PROCESO BETWEEN (SELECT PMADMIN.FNC_DIA_LIQ_NOR_ANTERIOR(TO_DATE(?,'DD/MM/YYYY')) FROM DUAL) AND TO_DATE(?,'DD/MM/YYYY')-1 " +
                                         "AND ENT_NUMERO_PROSA_EMI = 61 AND TTR_NUMERO = 20 " +
                                         "UNION ALL " +
                                         "SELECT SUM(IMPORTE_TOTAL_TRANSAC) IMPORTE_NETO " +
                                         "FROM SUPERSIC.TRANSACCIONES_ACEPTADAS@LG_PMTU_SICB " +
                                         "WHERE FECHA_PROCESO_TRANSAC BETWEEN TO_DATE(?,'DD/MM/YYYY') AND  TO_DATE(?,'DD/MM/YYYY') " +
                                         "AND ENT_NUMERO_PROSA_EMI = 61 AND TTR_NUMERO = 20 AND CUTOVER_IND = 2 " +
                                         "UNION ALL " +
                                         "SELECT SUM(IMPORTE_TOTAL_TRANSAC) IMPORTE_NETO " +
                                         "FROM SUPERSIC.TRANSACCIONES_ACEPTADAS@LG_PMTU_SICB " +
                                         "WHERE FECHA_PROCESO_TRANSAC BETWEEN TO_DATE(?,'DD/MM/YYYY') AND  TO_DATE(?,'DD/MM/YYYY') " +
                                         "AND ENT_NUMERO_PROSA_EMI = 61 AND TTR_NUMERO = 20 AND CUTOVER_IND = 1) ";
        Double regreso                 = 0.0;

        try {
            obtieneConexion();

            // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
            pStmt = conexion.prepareStatement(sSQL);
            pStmt.setString(1, inicio);
            pStmt.setString(2, fin);
            pStmt.setString(3, fecha1);
            pStmt.setString(4, fecha2);
            pStmt.setString(5, fecha3);
            pStmt.setString(6, fecha4);
            rDatos = pStmt.executeQuery();

            // BARRE LOS REGISTROS OBTENIDOS
            while(rDatos.next()){
                regreso = new Double(rDatos.getString(1));
            }
            pStmt.close();
            rDatos.close();
        } catch(Exception e ) {
            System.out.println(" Error al obtener difCortes:" + e);
            System.out.println(",");
            regreso = null;
        } finally{
            cierraConexion();
        }

        return regreso;
    }

    // OBTIENE EL LIQCOMPL A FAVOR
    public Double liqComplFavor(String inicio, String fin) {
        PreparedStatement pStmt        = null;
        ResultSet rDatos               = null;
        String sSQL                    = "SELECT NVL(SUM(FMI_CHRG_AMT),0) "+
                                         "FROM SETTLEMENT.SV_FM_INT_TXN " +
                                         "WHERE FMI_DT BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') " +
                                         "AND FMI_CR_CLR_BU IN (322) AND FMI_NSI_CLR_ID IN (22) ";
        Double regreso                 = 0.0;

        try {
            obtieneConexion();

            // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
            pStmt = conexion.prepareStatement(sSQL);
            pStmt.setString(1, inicio);
            pStmt.setString(2, fin);
            rDatos = pStmt.executeQuery();

            // BARRE LOS REGISTROS OBTENIDOS
            while(rDatos.next()){
                regreso = new Double(rDatos.getString(1));
            }
            pStmt.close();
            rDatos.close();
        } catch(Exception e ) {
            System.out.println(" Error al obtener liqcomplFavor:" + e);
            System.out.println(",");
            regreso = null;
        } finally{
            cierraConexion();
        }

        return regreso;
    }

    // OBTIENE EL LIQCOMPL EN CONTRA
    public Double liqComplContra(String inicio, String fin) {
        PreparedStatement pStmt        = null;
        ResultSet rDatos               = null;
        String sSQL                    = "SELECT NVL(SUM(FMI_CHRG_AMT),0) "+
                                         "FROM SETTLEMENT.SV_FM_INT_TXN " +
                                         "WHERE FMI_DT BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') " +
                                         "AND FMI_DB_CLR_BU IN (322) AND FMI_NSI_CLR_ID IN (22) ";
        Double regreso                 = 0.0;

        try {
            obtieneConexion();

            // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
            pStmt = conexion.prepareStatement(sSQL);
            pStmt.setString(1, inicio);
            pStmt.setString(2, fin);
            rDatos = pStmt.executeQuery();

            // BARRE LOS REGISTROS OBTENIDOS
            while(rDatos.next()){
                regreso = new Double(rDatos.getString(1));
            }
            pStmt.close();
            rDatos.close();
        } catch(Exception e ) {
            System.out.println(" Error al obtener liqcomplContra:" + e);
            System.out.println(",");
            regreso = null;
        } finally{
            cierraConexion();
        }

        return regreso;
    }

    // OBTIENE EL LIQMISCL A FAVOR
    public Double liqMiscFavor(String inicio, String fin) {
        PreparedStatement pStmt        = null;
        ResultSet rDatos               = null;
        String sSQL                    = "SELECT NVL(SUM(FMI_CHRG_AMT),0) "+
                                         "FROM SETTLEMENT.SV_FM_INT_TXN " +
                                         "WHERE FMI_DT BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') " +
                                         "AND FMI_CR_CLR_BU IN (322) AND FMI_NSI_CLR_ID IN (33) ";
        Double regreso                 = 0.0;

        try {
            obtieneConexion();

            // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
            pStmt = conexion.prepareStatement(sSQL);
            pStmt.setString(1, inicio);
            pStmt.setString(2, fin);
            rDatos = pStmt.executeQuery();

            // BARRE LOS REGISTROS OBTENIDOS
            while(rDatos.next()){
                regreso = new Double(rDatos.getString(1));
            }
            pStmt.close();
            rDatos.close();
        } catch(Exception e ) {
            System.out.println(" Error al obtener liqmiscFavor:" + e);
            System.out.println(",");
            regreso = null;
        } finally{
            cierraConexion();
        }

        return regreso;
    }

    // OBTIENE EL LIQMISCL EN CONTRA
    public Double liqMiscContra(String inicio, String fin) {
        PreparedStatement pStmt        = null;
        ResultSet rDatos               = null;
        String sSQL                    = "SELECT NVL(SUM(FMI_CHRG_AMT),0) "+
                                         "FROM SETTLEMENT.SV_FM_INT_TXN " +
                                         "WHERE FMI_DT BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') " +
                                         "AND FMI_DB_CLR_BU IN (322) AND FMI_NSI_CLR_ID IN (33) ";
        Double regreso                 = 0.0;

        try {
            obtieneConexion();

            // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
            pStmt = conexion.prepareStatement(sSQL);
            pStmt.setString(1, inicio);
            pStmt.setString(2, fin);
            rDatos = pStmt.executeQuery();

            // BARRE LOS REGISTROS OBTENIDOS
            while(rDatos.next()){
                regreso = new Double(rDatos.getString(1));
            }
            pStmt.close();
            rDatos.close();
        } catch(Exception e ) {
            System.out.println(" Error al obtener liqmiscContra:" + e);
            System.out.println(",");
            regreso = null;
        } finally{
            cierraConexion();
        }

        return regreso;
    }

// GSOF-MVR-B-54-2092-15 Marca de Terminacion
}
