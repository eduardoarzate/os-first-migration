// ----------------------------------------------------------------------------
// Nombre del Programa : AltasDAO.java
// Autor               : Manuel Villalobos
// Compania            : GSOF
// Proyecto/Procliente : C-08-2129-12                        Fecha: 07/AGO/2013
// Descripcion General : CLASE QUE REPRESENTA UN OBJETO DAO DE LACPI
// Programa Dependiente: N/A
// Programa Subsecuente: N/A
// Cond. de ejecucion  : N/A
// Dias de ejecucion   : N/A                                 Horario: N/A
//                              MODIFICACIONES
// ----------------------------------------------------------------------------
// Autor               : MANUEL VILLALOBOS
// Compania            : GSOF CONSULTING
// Proyecto/Procliente : C-08-2129-12                        Fecha: 18/SEP/2015
// Marca del Cambio    : GSOF-MVR-C-08-2129-12
// Modificación        : CONSULTA DE DEVOLUCIONES FUENTE 1189 Y SIN DUPLICADOS
// ----------------------------------------------------------------------------
// Numero de Parametros:
// Parametros Entrada  :                                    Formato:
//
// Parametros Salida   : N/A                                Formato: N/A
// ----------------------------------------------------------------------------

package com.prosa.dao;

import java.sql.*;
import java.util.Collection;
import java.util.ArrayList;

import com.prosa.beans.AfiliacionObj;
import com.prosa.beans.CuentaObj;
import com.prosa.beans.ListadoObj;
import com.wellcom.beans.*;

// ESTA CLASE DEFINE LOS ACCESOS A BD PARA LACPI
public class AltasDAO {
    private Connection conexion;

    public AltasDAO() {
    }

    // OBTIENE UNA CONEXION DE PMT
    private void obtieneConexion(){
        try {
            this.conexion = ConexionPMT.getInstance().getConnection();
        } catch (SQLException ex) {
            System.out.println("Error al inicializar AltasDAO, " + ex.toString());
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

    // INSERTA UNA AFILIACION
    public boolean crearAfiliacion(AfiliacionObj objeto) {
        boolean regreso = false;

        try{
            obtieneConexion();
            PreparedStatement pStmt = null;

            try {
                String sSQL = "insert into tbl_afiliaciona_lacpi (afiliacion, creado_por, creado_fecha, modificado_por, modificado_fecha) " +
                            "values(?, 'WEB', SYSDATE, NULL, NULL) " ;

                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt = conexion.prepareStatement(sSQL);
                pStmt.setString(1, objeto.getAfiliacion());
                pStmt.executeUpdate();
                conexion.commit();

                regreso = true;
            } catch (Exception e) {
                System.out.println("Error al insertar Afiliacion " + objeto.getAfiliacion() + ", " + e.toString());
                e.printStackTrace();
                regreso = false;
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

        return regreso;
    }

    // INSERTA UNA CUENTA
    public boolean crearCuenta(CuentaObj objeto) {
        boolean regreso = false;

        try{
            obtieneConexion();
            PreparedStatement pStmt = null;

            try {
                String sSQL = "insert into tbl_cuentas_lacpi (cuenta, creado_por, creado_fecha, modificado_por, modificado_fecha) " +
                            "values(?, 'WEB', SYSDATE, NULL, NULL) " ;

                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt = conexion.prepareStatement(sSQL);
                pStmt.setString(1, objeto.getCuenta());
                pStmt.executeUpdate();
                conexion.commit();

                regreso = true;
            } catch (Exception e) {
                System.out.println("Error al insertar Cuenta " + objeto.getCuenta() + ", " + e.toString());
                e.printStackTrace();
                regreso = false;
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

        return regreso;
    }

    // BORRA UNA AFILIACION
    public boolean borrarAfiliacion(String llave) {
        boolean regreso = false;

        try{
            obtieneConexion();
            PreparedStatement pStmt = null;

            try {
                String sSQL = "delete from tbl_afiliaciona_lacpi where afiliacion = ? " ;

                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt = conexion.prepareStatement(sSQL);
                pStmt.setString(1, llave);
                pStmt.executeUpdate();
                conexion.commit();

                regreso = true;
            } catch (Exception e) {
                System.out.println("Error al borrar Afiliacion: " + llave + ", " + e.toString());
                e.printStackTrace();
                regreso = false;
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

        return regreso;
    }

    // BORRA UNA CUENTA
    public boolean borrarCuenta(String llave) {
        boolean regreso = false;

        try{
            obtieneConexion();
            PreparedStatement pStmt = null;

            try {
                String sSQL = "delete from tbl_cuentas_lacpi where cuenta = ? " ;

                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt = conexion.prepareStatement(sSQL);
                pStmt.setString(1, llave);
                pStmt.executeUpdate();
                conexion.commit();

                regreso = true;
            } catch (Exception e) {
                System.out.println("Error al borrar Cuenta: " + llave + ", " + e.toString());
                e.printStackTrace();
                regreso = false;
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

        return regreso;
    }

    // OBTIENE EL LISTADO DE AFILIACIONES
    public ArrayList listarAfiliaciones() {
        AfiliacionObj objeto = new AfiliacionObj();
        ArrayList lista = null;

        try{
            obtieneConexion();
            PreparedStatement pStmt = null;
            ResultSet rDatos = null;

            try {
                String sSQL = "Select afiliacion From tbl_afiliaciona_lacpi order by afiliacion";

                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt = conexion.prepareStatement(sSQL);
                rDatos = pStmt.executeQuery();
                lista = new ArrayList();

                while(rDatos.next()){
                    objeto = new AfiliacionObj();
                    objeto.setAfiliacion(   rDatos.getString(1));
                    lista.add(objeto);
                }
                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al listar afiliaciones " + ", " + e.toString());
                e.printStackTrace();
                lista = new ArrayList();
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

        return lista;
    }

    // OBTIENE EL LISTADO DE CUENTAS
    public ArrayList listarCuentas() {
        CuentaObj objeto = new CuentaObj();
        ArrayList lista = null;

        try{
            obtieneConexion();
            PreparedStatement pStmt = null;
            ResultSet rDatos = null;

            try {
                String sSQL = "Select cuenta From tbl_cuentas_lacpi order by cuenta";

                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt = conexion.prepareStatement(sSQL);
                rDatos = pStmt.executeQuery();
                lista = new ArrayList();

                while(rDatos.next()){
                    objeto = new CuentaObj();
                    objeto.setCuenta(   rDatos.getString(1));
                    lista.add(objeto);
                }
                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al listar cuentas " + ", " + e.toString());
                e.printStackTrace();
                lista = new ArrayList();
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

        return lista;
    }

    // APLICA LA CONSULTA DE DEVOLUCIONES
    // EL NUMERO DE CUENTA SE ENMASCARA DE ACUERDO A LA NORMATIVA PCI
    public ArrayList consultarDevoluciones(String pFechaIni, String pFechaFin, String pAfiliacion, String pCuenta) {
        ListadoObj objeto = new ListadoObj();
        ArrayList lista = null;

        try{
            obtieneConexion();
            PreparedStatement pStmt = null;
            ResultSet rDatos = null;

            try {
// GSOF-MVR-C-08-2129-12 Marca de Inicio
                String sSQL = "SELECT B.PT_RTLR_ID, A.TD_ACQ_FIID, B.PT_TI_ID, TO_CHAR(B.PT_REQ_AMT, '999,999,999.99'), " +
                            "B.PT_AUTH_CD, TO_CHAR(B.PT_DT, 'dd/mm/yyyy'), TO_CHAR(B.PT_LOAD_PROC_DT, 'dd/mm/yyyy') " +
                            "FROM PRSA_TXN_DATA A, CZ_PRCD_TXN B " +
                            "Where TRUNC(B.PT_LOAD_PROC_DT) BETWEEN TO_DATE(?, 'dd/mm/yyyy') AND TO_DATE(?, 'dd/mm/yyyy') " +
                            "AND   A.TD_TXN_TYP         = 21 " +
                            "AND   A.TD_SRCE_NBR        = 1189 " +
                            "AND   RTRIM(B.PT_RTLR_ID)  LIKE ? " +
                            "AND   RTRIM(B.PT_TI_ID)    LIKE ? " +
                            "AND   A.PARTITION_ID       = B.PARTITION_ID " +
                            "AND   A.TD_WH_GRP          = B.PT_WH_GRP " +
                            "AND   A.TD_WH_SEQ          = B.PT_WH_SEQ " +
                            "AND   RTRIM(B.PT_RTLR_ID)  IN (SELECT AFILIACION FROM TBL_AFILIACIONA_LACPI) " +
                            "AND   RTRIM(B.PT_TI_ID)    IN (SELECT CUENTA FROM TBL_CUENTAS_LACPI) " +
                            "ORDER BY B.PT_DT, B.PT_RTLR_ID, A.TD_ACQ_FIID, B.PT_TI_ID, A.TD_TXN_TYP" ;
// GSOF-MVR-C-08-2129-12 Marca de Terminacion

                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt = conexion.prepareStatement(sSQL);
                pStmt.setString(1, pFechaIni);
                pStmt.setString(2, pFechaFin);
                pStmt.setString(3, pAfiliacion + "%");
                pStmt.setString(4, pCuenta + "%");
                rDatos = pStmt.executeQuery();
                lista = new ArrayList();

                while(rDatos.next()){
                    objeto = new ListadoObj();
                    objeto.setNumero_comercio(      rDatos.getString(1));
                    objeto.setFiid(                 rDatos.getString(2));
                    objeto.setCuenta(               rDatos.getString(3));
                    objeto.setImporte_total_transac(rDatos.getString(4));
                    objeto.setNumero_autorizacion(  rDatos.getString(5));
                    objeto.setFecha_consumo_transac(rDatos.getString(6));
                    objeto.setTtr_numero(           rDatos.getString(7));
                    lista.add(objeto);
                }
                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al consultar transacciones de terminales LACPI " + ", " + e.toString());
                e.printStackTrace();
                lista = new ArrayList();
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

        return lista;
    }

// GSOF-MVR-C-08-2129-12 Marca de Inicio
    // VERIFICA LA EXISTENCIA DE UNA AFILIACION
    public boolean existeAfiliacion(String clave) {
        boolean regreso = false;
        int valor = 0;

        try{
            obtieneConexion();
            PreparedStatement pStmt = null;
            ResultSet rDatos = null;

            try {
                String sSQL = "SELECT COUNT(1) FROM TBL_AFILIACIONA_LACPI WHERE AFILIACION = ? ";

                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt = conexion.prepareStatement(sSQL);
                pStmt.setString(1, clave);
                rDatos = pStmt.executeQuery();

                while(rDatos.next()){
                    valor = Integer.parseInt(rDatos.getString(1));
                    if(valor > 0){ regreso = true;}
                }
                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al verificar existencia de afiliacion " + ", " + e.toString());
                e.printStackTrace();
                regreso = false;
            } finally {
                try{
                    if(pStmt != null) pStmt.close();
                }catch(Exception e){
                }
            }
        } catch(Exception e ) {
            System.out.println(" e " + e);
            System.out.println(",");
            regreso = false;
        } finally{
            cierraConexion();
        }

        return regreso;
    }

    // VERIFICA LA EXISTENCIA DE UNA CUENTA
    public boolean existeCuenta(String clave) {
        boolean regreso = false;
        int valor = 0;

        try{
            obtieneConexion();
            PreparedStatement pStmt = null;
            ResultSet rDatos = null;

            try {
                String sSQL = "SELECT COUNT(1) FROM TBL_CUENTAS_LACPI WHERE CUENTA = ? ";

                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt = conexion.prepareStatement(sSQL);
                pStmt.setString(1, clave);
                rDatos = pStmt.executeQuery();

                while(rDatos.next()){
                    valor = Integer.parseInt(rDatos.getString(1));
                    if(valor > 0){ regreso = true;}
                }
                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al verificar existencia de cuenta " + ", " + e.toString());
                e.printStackTrace();
                regreso = false;
            } finally {
                try{
                    if(pStmt != null) pStmt.close();
                }catch(Exception e){
                }
            }
        } catch(Exception e ) {
            System.out.println(" e " + e);
            System.out.println(",");
            regreso = false;
        } finally{
            cierraConexion();
        }

        return regreso;
    }
// GSOF-MVR-C-08-2129-12 Marca de Terminacion
}
