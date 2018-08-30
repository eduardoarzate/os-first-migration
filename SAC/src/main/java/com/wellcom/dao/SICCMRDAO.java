// ----------------------------------------------------------------------------
// Nombre del Programa : SICCMRDAO.java
// Autor               : Manuel Villalobos
// Compania            : GSOF
// Proyecto/Procliente : P-53-2727-14                        Fecha: 12/JUL/2017
// Descripcion General : CLASE QUE REPRESENTA UN OBJETO DAO PARA REPORTES SICCMR
// Programa Dependiente: N/A
// Programa Subsecuente: N/A
// Cond. de ejecucion  : N/A
// Dias de ejecucion   : N/A                                 Horario: N/A
//                              MODIFICACIONES
// ----------------------------------------------------------------------------
// Numero de Parametros:
// Parametros Entrada  :                                    Formato:
//
// Parametros Salida   : N/A                                Formato: N/A
// ----------------------------------------------------------------------------

package com.wellcom.dao;

import java.sql.*;
import java.util.*;

import com.wellcom.beans.*;

// ESTA CLASE DEFINE LOS ACCESOS A BD PARA REPORTES
public class SICCMRDAO {
    private Connection conexion;

    public SICCMRDAO() {
    }

    // OBTIENE UNA CONEXION DE PMT
    private void obtieneConexion(){
        try {
            this.conexion = ConexionSICCMR.getInstance().getConnection();
        } catch (SQLException ex) {
            System.out.println("Error al inicializar SICCMRDAO, " + ex.toString());
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

    // OBTIENE EL LISTADO DE MARCAS
    public ArrayList listarMarcas() {
        EstructuraListaObj  objeto = new EstructuraListaObj();
        ArrayList           lista  = null;

        try{
            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                String sSQL = "SELECT marca, descripcion FROM PMADMIN.PRSA_MARCA WHERE marca in (1, 2, 3, 999) ORDER BY descripcion";

                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt  = conexion.prepareStatement(sSQL);
                rDatos = pStmt.executeQuery();
                lista  = new ArrayList();

                while(rDatos.next()){
                    objeto = new EstructuraListaObj();
                    objeto.setClave(       rDatos.getString(1));
                    objeto.setDescripcion( rDatos.getString(2));
                    lista.add(objeto);
                }
                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al listar Marcas " + ", " + e.toString());
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

    // OBTIENE EL LISTADO DE MARCAS REPORTE 330
    // EXCLUYE LAS QUE DIGAN INTERNACIONAL Y LA 99 (LIQUIDACIONES COMPLEMENTARIAS)
    public ArrayList listarMarcas330() {
        EstructuraListaObj  objeto = new EstructuraListaObj();
        ArrayList           lista  = null;

        try{
            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                String sSQL = "SELECT marca, descripcion FROM PMADMIN.PRSA_MARCA WHERE DESCRIPCION NOT LIKE '%INTERNAC%' AND MARCA != 99 ORDER BY descripcion";

                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt  = conexion.prepareStatement(sSQL);
                rDatos = pStmt.executeQuery();
                lista  = new ArrayList();

                while(rDatos.next()){
                    objeto = new EstructuraListaObj();
                    objeto.setClave(       rDatos.getString(1));
                    objeto.setDescripcion( rDatos.getString(2));
                    lista.add(objeto);
                }
                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al listar Marcas330 " + ", " + e.toString());
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

    // OBTIENE EL LISTADO DE CAMARAS
    public ArrayList listarCamaras() {
        EstructuraListaObj  objeto = new EstructuraListaObj();
        ArrayList           lista  = null;

        try{
            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                String sSQL = "SELECT camara, descripcion FROM PMADMIN.PRSA_CAMARA WHERE camara in (1,2) ORDER BY descripcion";

                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt  = conexion.prepareStatement(sSQL);
                rDatos = pStmt.executeQuery();
                lista  = new ArrayList();

                while(rDatos.next()){
                    objeto = new EstructuraListaObj();
                    objeto.setClave(       rDatos.getString(1));
                    objeto.setDescripcion( rDatos.getString(2));
                    lista.add(objeto);
                }
                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al listar Camaras " + ", " + e.toString());
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

    // OBTIENE EL LISTADO DE CAMARAS REPORTE 320
    public ArrayList listarCamaras320() {
        EstructuraListaObj  objeto = new EstructuraListaObj();
        ArrayList           lista  = null;

        try{
            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                String sSQL = "SELECT camara, descripcion FROM PMADMIN.PRSA_CAMARA  WHERE DESCRIPCION NOT LIKE '%INTERNAC%' ORDER BY descripcion";

                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt  = conexion.prepareStatement(sSQL);
                rDatos = pStmt.executeQuery();
                lista  = new ArrayList();

                while(rDatos.next()){
                    objeto = new EstructuraListaObj();
                    objeto.setClave(       rDatos.getString(1));
                    objeto.setDescripcion( rDatos.getString(2));
                    lista.add(objeto);
                }
                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al listar Camaras320 " + ", " + e.toString());
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

    // OBTIENE EL LISTADO DE CAMARAS EGLO
    public ArrayList listarCamarasEglo() {
        EstructuraListaObj  objeto = new EstructuraListaObj();
        ArrayList           lista  = null;

        try{
            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                String sSQL = "SELECT camara, descripcion FROM PMADMIN.PRSA_CAMARA WHERE camara in (2) ORDER BY descripcion";

                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt  = conexion.prepareStatement(sSQL);
                rDatos = pStmt.executeQuery();
                lista  = new ArrayList();

                while(rDatos.next()){
                    objeto = new EstructuraListaObj();
                    objeto.setClave(       rDatos.getString(1));
                    objeto.setDescripcion( rDatos.getString(2));
                    lista.add(objeto);
                }
                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al listar Camaras Eglo " + ", " + e.toString());
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

    // OBTIENE EL LISTADO DE CAMARAS PROSA
    public ArrayList listarCamarasProsa() {
        EstructuraListaObj  objeto = new EstructuraListaObj();
        ArrayList           lista  = null;

        try{
            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                String sSQL = "SELECT camara, descripcion FROM PMADMIN.PRSA_CAMARA WHERE camara in (1) ORDER BY descripcion";

                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt  = conexion.prepareStatement(sSQL);
                rDatos = pStmt.executeQuery();
                lista  = new ArrayList();

                while(rDatos.next()){
                    objeto = new EstructuraListaObj();
                    objeto.setClave(       rDatos.getString(1));
                    objeto.setDescripcion( rDatos.getString(2));
                    lista.add(objeto);
                }
                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al listar Camaras Prosa " + ", " + e.toString());
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

    // OBTIENE EL LISTADO DE BANCOS
    public ArrayList listarBancos() {
        EstructuraListaObj  objeto = new EstructuraListaObj();
        ArrayList           lista  = null;

        try{
            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                String sSQL = "SELECT numero_fiid, substr(descripcion, 1, 30), numero_prosa FROM PMADMIN.PRSA_ENTIDADES " +
                "WHERE entidad_padre = numero_prosa AND UPPER(descripcion) NOT LIKE '%DCC%' AND UPPER(descripcion) NOT LIKE '%DOLARES%' " +
                "AND NUMERO_PROSA NOT IN (94,98) " +
                "AND numero_fiid IS NOT NULL ORDER BY numero_prosa";

                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt  = conexion.prepareStatement(sSQL);
                rDatos = pStmt.executeQuery();
                lista  = new ArrayList();

                while(rDatos.next()){
                    objeto = new EstructuraListaObj();
                    objeto.setClave(       rDatos.getString(1));
                    objeto.setDescripcion( rDatos.getString(3) + " " + rDatos.getString(2));
                    lista.add(objeto);
                }
                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al listar Bancos " + ", " + e.toString());
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

    // OBTIENE EL LISTADO DE BANCOS REPORTES 001 Y 002
    public ArrayList listarBancos001002() {
        EstructuraListaObj  objeto = new EstructuraListaObj();
        ArrayList           lista  = null;

        try{
            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                String sSQL = "SELECT numero_fiid, substr(descripcion, 1, 30), numero_prosa FROM PMADMIN.PRSA_ENTIDADES " +
                "WHERE entidad_padre = numero_prosa AND UPPER(descripcion) NOT LIKE '%DCC%' AND UPPER(descripcion) NOT LIKE '%DOLARES%' " +
                "AND NUMERO_PROSA NOT IN (94,98) " +
                "AND numero_fiid IS NOT NULL ORDER BY numero_prosa";

                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt  = conexion.prepareStatement(sSQL);
                rDatos = pStmt.executeQuery();
                lista  = new ArrayList();

                while(rDatos.next()){
                    objeto = new EstructuraListaObj();
                    objeto.setClave(       rDatos.getString(1));
                    objeto.setDescripcion( rDatos.getString(3) + " " + rDatos.getString(2));
                    lista.add(objeto);
                }
                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al listar Bancos001002 " + ", " + e.toString());
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

    // OBTIENE EL LISTADO DE BANCOS REPORTE 0065
    public ArrayList listarBancos0065() {
        EstructuraListaObj  objeto = new EstructuraListaObj();
        ArrayList           lista  = null;

        try{
            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                String sSQL = "SELECT numero_fiid, substr(descripcion, 1, 30), numero_prosa FROM PMADMIN.PRSA_ENTIDADES " +
                "WHERE entidad_padre = numero_prosa AND UPPER(descripcion) NOT LIKE '%DCC%' AND UPPER(descripcion) NOT LIKE '%DOLARES%' " +
                "AND NUMERO_PROSA NOT IN (94,95,96,97,98) " +
                "AND numero_fiid IS NOT NULL ORDER BY numero_prosa";

                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt  = conexion.prepareStatement(sSQL);
                rDatos = pStmt.executeQuery();
                lista  = new ArrayList();

                while(rDatos.next()){
                    objeto = new EstructuraListaObj();
                    objeto.setClave(       rDatos.getString(1));
                    objeto.setDescripcion( rDatos.getString(3) + " " + rDatos.getString(2));
                    lista.add(objeto);
                }
                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al listar Bancos001002 " + ", " + e.toString());
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

    // OBTIENE EL LISTADO DE BANCOS REPORTE 0200
    public ArrayList listarBancos0200() {
        EstructuraListaObj  objeto = new EstructuraListaObj();
        ArrayList           lista  = null;

        try{
            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                String sSQL = "SELECT numero_fiid, substr(descripcion, 1, 30), numero_prosa FROM PMADMIN.PRSA_ENTIDADES " +
                "WHERE entidad_padre = numero_prosa AND UPPER(descripcion) NOT LIKE '%DCC%' AND UPPER(descripcion) NOT LIKE '%DOLARES%' AND UPPER(descripcion) NOT LIKE '%EGLO%' " +
                "AND NUMERO_PROSA NOT IN (94,98) " +
                "AND numero_fiid IS NOT NULL ORDER BY numero_prosa";

                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt  = conexion.prepareStatement(sSQL);
                rDatos = pStmt.executeQuery();
                lista  = new ArrayList();

                while(rDatos.next()){
                    objeto = new EstructuraListaObj();
                    objeto.setClave(       rDatos.getString(1));
                    objeto.setDescripcion( rDatos.getString(3) + " " + rDatos.getString(2));
                    lista.add(objeto);
                }
                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al listar Bancos0200 " + ", " + e.toString());
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

    // OBTIENE EL LISTADO DE BANCOS TODOS
    public ArrayList listarBancosTodos() {
        EstructuraListaObj  objeto = new EstructuraListaObj();
        ArrayList           lista  = null;

        try{
            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                String sSQL = "SELECT numero_prosa, substr(descripcion, 1, 30) FROM PMADMIN.PRSA_ENTIDADES " +
                "WHERE UPPER(descripcion) NOT LIKE '%DCC%' AND UPPER(descripcion) NOT LIKE '%DOLARES%' " +
                "AND NUMERO_PROSA NOT IN (94,98) ORDER BY numero_prosa";

                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt  = conexion.prepareStatement(sSQL);
                rDatos = pStmt.executeQuery();
                lista  = new ArrayList();

                while(rDatos.next()){
                    objeto = new EstructuraListaObj();
                    objeto.setClave(       rDatos.getString(1));
                    objeto.setDescripcion( rDatos.getString(1) + " " + rDatos.getString(2));
                    lista.add(objeto);
                }
                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al listar BancosTodos " + ", " + e.toString());
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

    // OBTIENE EL LISTADO DE BANCOS TODOS, EXCEPTO EGLOBAL
    public ArrayList listarBancosTodos2() {
        EstructuraListaObj  objeto = new EstructuraListaObj();
        ArrayList           lista  = null;

        try{
            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                String sSQL = "SELECT numero_prosa, substr(descripcion, 1, 30) FROM PMADMIN.PRSA_ENTIDADES " +
                "WHERE UPPER(descripcion) NOT LIKE '%DCC%' AND UPPER(descripcion) NOT LIKE '%DOLARES%' AND UPPER(descripcion) NOT LIKE '%EGLO%' " +
                "AND NUMERO_PROSA NOT IN (94,98) ORDER BY numero_prosa";

                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt  = conexion.prepareStatement(sSQL);
                rDatos = pStmt.executeQuery();
                lista  = new ArrayList();

                while(rDatos.next()){
                    objeto = new EstructuraListaObj();
                    objeto.setClave(       rDatos.getString(1));
                    objeto.setDescripcion( rDatos.getString(1) + " " + rDatos.getString(2));
                    lista.add(objeto);
                }
                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al listar BancosTodos " + ", " + e.toString());
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

    // APLICA LA CONSULTA DE SICCMR0001
    public ArrayList consultarSICCMR0001(CriteriosObj criterios) {
        SICCMRObj objeto = new SICCMRObj();
        ArrayList lista  = null;

        try{
            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                String sSQL =
                    "SELECT BIN, NUMERO_FIID_EMI, SUM(NUMERO_TRANSACCIONES), SUM(TOTAL_IMPORTE), SUM(IMPORTE_COMISION_INTERCAMB), " +
                    "SUM(IVA_COMISION_INTERCAMB), CODIGO_MONEDA, MARCA, MARCA_DESC, CAMARA_EMI, CAMARA_DESC, FE_LIQ, ENTIDAD_DESC FROM (" +
                    "SELECT BIN, NUMERO_FIID_EMI, NUMERO_TRANSACCIONES, TOTAL_IMPORTE, IMPORTE_COMISION_INTERCAMB, IVA_COMISION_INTERCAMB, CODIGO_MONEDA, A.MARCA MARCA, " +
                    "TRIM(B.DESCRIPCION) MARCA_DESC, CAMARA_EMI, TRIM(C.DESCRIPCION) CAMARA_DESC,  TO_CHAR(FECHA_LIQ, 'DD/MM/YYYY') FE_LIQ, TRIM(D.DESCRIPCION) ENTIDAD_DESC " +
                    "FROM PMADMIN.PRSA_MARCA_POSICIONES A, PMADMIN.PRSA_MARCA B, PMADMIN.PRSA_CAMARA C, PMADMIN.PRSA_ENTIDADES D " +

                    "WHERE (   " +
                    "        (A.FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY')-1 AND TO_DATE(?, 'DD/MM/YYYY')-1  " +
                    "        AND A.TTR_NUMERO NOT IN (20,23,24) AND TLI_NUMERO IN (1) ) " +
                    "     OR (A.FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                    "        AND A.TTR_NUMERO IN (23) AND A.TLI_NUMERO IN (1)) " +
                    "     OR (A.FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                    "        AND A.TTR_NUMERO IN (1, 21, 10, 11, 15, 18, 9, 16, 19, 23) AND A.TLI_NUMERO IN (2,5)) " +
                    "     OR (A.FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                    "        AND A.TTR_NUMERO IN (1, 21, 10, 11, 15, 18, 9, 16, 19, 23) AND A.TLI_NUMERO IN (3)) " +
                    "     OR (A.FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                    "        AND A.TTR_NUMERO IN (20, 24)) " +
                    ") " +
                    "AND A.MARCA IN (" + criterios.getMarca() + ") " +
                    "AND D.NUMERO_PROSA = A.ENT_NUMERO_PROSA_EMI " +
                    "AND A.MARCA = B.MARCA " +
                    "AND A.CAMARA_ADQ IN (" + criterios.getCamaraAdq() + ") " +
                    "AND A.CAMARA_EMI = C.CAMARA " +
                    "AND A.NUMERO_FIID_EMI IN (" + criterios.getBancoEmi() + ") " +
                    "AND A.NUMERO_FIID_ADQ LIKE ? " +
                    "AND A.TLI_NUMERO IN (1,2,3,5) AND A.TTR_NUMERO IN (1,21,20,10,11,15,16,17,9,18,19,23) " +
                    "AND TRIM(A.NOMBRE_ARCHIVO) NOT IN ('MISC (A FAVOR)','MISC (EN CONTRA)','CZDCS030') " +
                    "AND A.STTR_NUMERO NOT IN (120,322,281,321) " +

                    "UNION ALL " +
                    "SELECT BIN, NUMERO_FIID_EMI, NUMERO_TRANSACCIONES, TOTAL_IMPORTE, IMPORTE_COMISION_INTERCAMB, IVA_COMISION_INTERCAMB, CODIGO_MONEDA, A.MARCA MARCA, " +
                    "TRIM(B.DESCRIPCION) MARCA_DESC, CAMARA_EMI, TRIM(C.DESCRIPCION) CAMARA_DESC, TO_CHAR(FECHA_LIQ, 'DD/MM/YYYY') FE_LIQ, TRIM(D.DESCRIPCION) ENTIDAD_DESC " +
                    "FROM PMADMIN.PRSA_MARCA_POSICIONES A, PMADMIN.PRSA_MARCA B, PMADMIN.PRSA_CAMARA C, PMADMIN.PRSA_ENTIDADES D " +
                    "WHERE (   " +
                    "        (A.FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY')-1 AND TO_DATE(?, 'DD/MM/YYYY')-1  " +
                    "        AND A.TTR_NUMERO NOT IN (20,23,24) AND TLI_NUMERO IN (1) ) " +
                    "     OR (A.FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                    "        AND A.TTR_NUMERO IN (23) AND A.TLI_NUMERO IN (1)) " +
                    "     OR (A.FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                    "        AND A.TTR_NUMERO IN (1, 21, 10, 11, 15, 18, 9, 16, 19, 23) AND A.TLI_NUMERO IN (2,5)) " +
                    "     OR (A.FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                    "        AND A.TTR_NUMERO IN (1, 21, 10, 11, 15, 18, 9, 16, 19, 23) AND A.TLI_NUMERO IN (3)) " +
                    "     OR (A.FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                    "        AND A.TTR_NUMERO IN (20, 24)) " +
                    ") " +
                    "AND A.MARCA IN (" + criterios.getMarca() + ") " +
                    "AND D.NUMERO_PROSA = A.ENT_NUMERO_PROSA_EMI " +
                    "AND A.MARCA = B.MARCA " +
                    "AND A.CAMARA_ADQ IN (" + criterios.getCamaraAdq() + ") " +
                    "AND A.CAMARA_EMI = C.CAMARA " +
                    "AND A.NUMERO_FIID_EMI IN (" + criterios.getBancoEmi() + ") " +
                    "AND A.NUMERO_FIID_ADQ LIKE ? " +
                    "AND A.TLI_NUMERO IN (1,2,3,5) AND A.TTR_NUMERO IN (1,9,15,17,18) AND A.STTR_NUMERO IN (120,322) " +

                    "UNION ALL " +
                    "SELECT BIN, NUMERO_FIID_EMI, NUMERO_TRANSACCIONES, TOTAL_IMPORTE*-1, IMPORTE_COMISION_INTERCAMB*-1, IVA_COMISION_INTERCAMB, CODIGO_MONEDA, A.MARCA MARCA, " +
                    "TRIM(B.DESCRIPCION) MARCA_DESC, CAMARA_EMI, TRIM(C.DESCRIPCION) CAMARA_DESC, TO_CHAR(FECHA_LIQ, 'DD/MM/YYYY') FE_LIQ, TRIM(D.DESCRIPCION) ENTIDAD_DESC " +
                    "FROM PMADMIN.PRSA_MARCA_POSICIONES A, PMADMIN.PRSA_MARCA B, PMADMIN.PRSA_CAMARA C, PMADMIN.PRSA_ENTIDADES D " +
                    "WHERE (   " +
                    "        (A.FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY')-1 AND TO_DATE(?, 'DD/MM/YYYY')-1  " +
                    "        AND A.TTR_NUMERO NOT IN (20,23,24) AND TLI_NUMERO IN (1) ) " +
                    "     OR (A.FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                    "        AND A.TTR_NUMERO IN (23) AND A.TLI_NUMERO IN (1)) " +
                    "     OR (A.FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                    "        AND A.TTR_NUMERO IN (1, 21, 10, 11, 15, 18, 9, 16, 19, 23) AND A.TLI_NUMERO IN (2,5)) " +
                    "     OR (A.FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                    "        AND A.TTR_NUMERO IN (1, 21, 10, 11, 15, 18, 9, 16, 19, 23) AND A.TLI_NUMERO IN (3)) " +
                    "     OR (A.FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                    "        AND A.TTR_NUMERO IN (20, 24)) " +
                    ") " +
                    "AND A.MARCA IN (" + criterios.getMarca() + ") " +
                    "AND D.NUMERO_PROSA = A.ENT_NUMERO_PROSA_EMI " +
                    "AND A.MARCA = B.MARCA " +
                    "AND A.CAMARA_ADQ IN (" + criterios.getCamaraAdq() + ") " +
                    "AND A.CAMARA_EMI = C.CAMARA " +
                    "AND A.NUMERO_FIID_EMI IN (" + criterios.getBancoEmi() + ") " +
                    "AND A.NUMERO_FIID_ADQ LIKE ? " +
                    "AND A.TLI_NUMERO IN (1,2,3,5) AND A.TTR_NUMERO IN (16,19,20,21) AND A.STTR_NUMERO IN (281,321) ) " +
                    "GROUP BY BIN, NUMERO_FIID_EMI, CODIGO_MONEDA, MARCA, MARCA_DESC, CAMARA_EMI, CAMARA_DESC, FE_LIQ, ENTIDAD_DESC ORDER BY 2, 1 ";
System.out.println("Reporte SICCMR0001:" + sSQL);
                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt = conexion.prepareStatement(sSQL);
                pStmt.setString( 1, criterios.getIni());
                pStmt.setString( 2, criterios.getFin());
                pStmt.setString( 3, criterios.getIni());
                pStmt.setString( 4, criterios.getFin());
                pStmt.setString( 5, criterios.getIni());
                pStmt.setString( 6, criterios.getFin());
                pStmt.setString( 7, criterios.getIni());
                pStmt.setString( 8, criterios.getFin());
                pStmt.setString( 9, criterios.getIni());
                pStmt.setString(10, criterios.getFin());
                pStmt.setString(11, criterios.getOwner());

                pStmt.setString(12, criterios.getIni());
                pStmt.setString(13, criterios.getFin());
                pStmt.setString(14, criterios.getIni());
                pStmt.setString(15, criterios.getFin());
                pStmt.setString(16, criterios.getIni());
                pStmt.setString(17, criterios.getFin());
                pStmt.setString(18, criterios.getIni());
                pStmt.setString(19, criterios.getFin());
                pStmt.setString(20, criterios.getIni());
                pStmt.setString(21, criterios.getFin());
                pStmt.setString(22, criterios.getOwner());

                pStmt.setString(23, criterios.getIni());
                pStmt.setString(24, criterios.getFin());
                pStmt.setString(25, criterios.getIni());
                pStmt.setString(26, criterios.getFin());
                pStmt.setString(27, criterios.getIni());
                pStmt.setString(28, criterios.getFin());
                pStmt.setString(29, criterios.getIni());
                pStmt.setString(30, criterios.getFin());
                pStmt.setString(31, criterios.getIni());
                pStmt.setString(32, criterios.getFin());
                pStmt.setString(33, criterios.getOwner());

                rDatos = pStmt.executeQuery();
                lista = new ArrayList();

                while(rDatos.next()){
                    objeto = new SICCMRObj();
                    objeto.setBin(          rDatos.getString(1));
                    objeto.setFiidEmi(      rDatos.getString(13));
                    objeto.setTrx(          new Integer(rDatos.getString(3)));
                    objeto.setImporte(      new Double(rDatos.getString(4)));
                    objeto.setCuota(        new Double(rDatos.getString(5)));
                    objeto.setIva(          new Double(rDatos.getString(6)));
                    objeto.setMoneda(       rDatos.getString(7));
                    objeto.setMarca(        new Integer(rDatos.getString(8)));
                    objeto.setMarcaDs(      rDatos.getString(9));
                    objeto.setCamara(       new Integer(rDatos.getString(10)));
                    objeto.setCamaraDs(     rDatos.getString(11));
                    objeto.setFecha(        rDatos.getString(12));
                    lista.add(objeto);
                }

                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al consultar SICCMR0001 " + ", " + e.toString());
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

    // APLICA LA CONSULTA DE SICCMR0002
    public ArrayList consultarSICCMR0002(CriteriosObj criterios) {
        SICCMRObj objeto = new SICCMRObj();
        ArrayList lista  = null;

        try{
            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                String sSQL =
                    "SELECT NUMERO_FIID_ADQ, NUMERO_FIID_EMI, SUM(NUMERO_TRANSACCIONES), SUM(TOTAL_IMPORTE), CODIGO_DE_COMERCIO, " +
                    "CAMARA_ADQ, CAMARA_DESC, MARCA, MARCA_DESC, FELIQ, ADQ_DESC, EMI_DESC FROM (" +
                    "SELECT NUMERO_FIID_ADQ, NUMERO_FIID_EMI, NUMERO_TRANSACCIONES, TOTAL_IMPORTE, CODIGO_DE_COMERCIO, CAMARA_ADQ, TRIM(C.DESCRIPCION) CAMARA_DESC, " +
                    "A.MARCA MARCA, TRIM(B.DESCRIPCION) MARCA_DESC, TO_CHAR(FECHA_LIQ, 'DD/MM/YYYY') FELIQ, TRIM(D.DESCRIPCION) ADQ_DESC, TRIM(E.DESCRIPCION) EMI_DESC " +
                    "FROM PMADMIN.PRSA_MARCA_POSICIONES A, PMADMIN.PRSA_MARCA B, PMADMIN.PRSA_CAMARA C, PMADMIN.PRSA_ENTIDADES D, PMADMIN.PRSA_ENTIDADES E " +
                    "WHERE (   " +
                    "        (A.FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY')-1 AND TO_DATE(?, 'DD/MM/YYYY')-1  " +
                    "        AND A.TTR_NUMERO NOT IN (20,23,24) AND TLI_NUMERO IN (1) ) " +
                    "     OR (A.FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                    "        AND A.TTR_NUMERO IN (23) AND A.TLI_NUMERO IN (1)) " +
                    "     OR (A.FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                    "        AND A.TTR_NUMERO IN (1, 21, 10, 11, 15, 18, 9, 16, 19, 23) AND A.TLI_NUMERO IN (2,5)) " +
                    "     OR (A.FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                    "        AND A.TTR_NUMERO IN (1, 21, 10, 11, 15, 18, 9, 16, 19, 23) AND A.TLI_NUMERO IN (3)) " +
                    "     OR (A.FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                    "        AND A.TTR_NUMERO IN (20, 24)) " +
                    ") " +
                    "AND A.MARCA IN (" + criterios.getMarca() + ") " +
                    "AND D.NUMERO_PROSA = A.ENT_NUMERO_PROSA_ADQ " +
                    "AND E.NUMERO_PROSA = A.ENT_NUMERO_PROSA_EMI " +
                    "AND A.MARCA = B.MARCA " +
                    "AND A.CAMARA_EMI IN (" + criterios.getCamaraEmi() + ") " +
                    "AND A.CAMARA_ADQ = C.CAMARA " +
                    "AND A.NUMERO_FIID_ADQ IN (" + criterios.getBancoAdq() + ") " +
                    "AND A.NUMERO_FIID_EMI IN (" + criterios.getBancoEmi() + ") " +
                    "AND A.TLI_NUMERO IN (1,2,3,5) AND A.TTR_NUMERO IN (1,21,20,10,11,15,16,17,9,18,19,23) " +
                    "AND TRIM(A.NOMBRE_ARCHIVO) NOT IN ('MISC (A FAVOR)','MISC (EN CONTRA)','CZDCS030') " +
                    "AND A.STTR_NUMERO NOT IN (120,322,281,321) " +

                    "UNION ALL " +
                    "SELECT NUMERO_FIID_ADQ, NUMERO_FIID_EMI, NUMERO_TRANSACCIONES, TOTAL_IMPORTE, CODIGO_DE_COMERCIO, CAMARA_ADQ, TRIM(C.DESCRIPCION) CAMARA_DESC, " +
                    "A.MARCA MARCA, TRIM(B.DESCRIPCION) MARCA_DESC, TO_CHAR(FECHA_LIQ, 'DD/MM/YYYY') FELIQ, TRIM(D.DESCRIPCION) ADQ_DESC, TRIM(E.DESCRIPCION) EMI_DESC " +
                    "FROM PMADMIN.PRSA_MARCA_POSICIONES A, PMADMIN.PRSA_MARCA B, PMADMIN.PRSA_CAMARA C, PMADMIN.PRSA_ENTIDADES D, PMADMIN.PRSA_ENTIDADES E " +
                    "WHERE (   " +
                    "        (A.FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY')-1 AND TO_DATE(?, 'DD/MM/YYYY')-1  " +
                    "        AND A.TTR_NUMERO NOT IN (20,23,24) AND TLI_NUMERO IN (1) ) " +
                    "     OR (A.FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                    "        AND A.TTR_NUMERO IN (23) AND A.TLI_NUMERO IN (1)) " +
                    "     OR (A.FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                    "        AND A.TTR_NUMERO IN (1, 21, 10, 11, 15, 18, 9, 16, 19, 23) AND A.TLI_NUMERO IN (2,5)) " +
                    "     OR (A.FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                    "        AND A.TTR_NUMERO IN (1, 21, 10, 11, 15, 18, 9, 16, 19, 23) AND A.TLI_NUMERO IN (3)) " +
                    "     OR (A.FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                    "        AND A.TTR_NUMERO IN (20, 24)) " +
                    ") " +
                    "AND A.MARCA IN (" + criterios.getMarca() + ") " +
                    "AND D.NUMERO_PROSA = A.ENT_NUMERO_PROSA_ADQ " +
                    "AND E.NUMERO_PROSA = A.ENT_NUMERO_PROSA_EMI " +
                    "AND A.MARCA = B.MARCA " +
                    "AND A.CAMARA_EMI IN (" + criterios.getCamaraEmi() + ") " +
                    "AND A.CAMARA_ADQ = C.CAMARA " +
                    "AND A.NUMERO_FIID_ADQ IN (" + criterios.getBancoAdq() + ") " +
                    "AND A.NUMERO_FIID_EMI IN (" + criterios.getBancoEmi() + ") " +
                    "AND A.TLI_NUMERO IN (1,2,3,5) AND A.TTR_NUMERO IN (1,9,15,17,18) AND A.STTR_NUMERO IN (120,322) " +

                    "UNION ALL " +
                    "SELECT NUMERO_FIID_ADQ, NUMERO_FIID_EMI, NUMERO_TRANSACCIONES, TOTAL_IMPORTE*-1, CODIGO_DE_COMERCIO, CAMARA_ADQ, TRIM(C.DESCRIPCION) CAMARA_DESC, " +
                    "A.MARCA MARCA, TRIM(B.DESCRIPCION) MARCA_DESC, TO_CHAR(FECHA_LIQ, 'DD/MM/YYYY') FELIQ, TRIM(D.DESCRIPCION) ADQ_DESC, TRIM(E.DESCRIPCION) EMI_DESC " +
                    "FROM PMADMIN.PRSA_MARCA_POSICIONES A, PMADMIN.PRSA_MARCA B, PMADMIN.PRSA_CAMARA C, PMADMIN.PRSA_ENTIDADES D, PMADMIN.PRSA_ENTIDADES E " +
                    "WHERE (   " +
                    "        (A.FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY')-1 AND TO_DATE(?, 'DD/MM/YYYY')-1  " +
                    "        AND A.TTR_NUMERO NOT IN (20,23,24) AND TLI_NUMERO IN (1) ) " +
                    "     OR (A.FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                    "        AND A.TTR_NUMERO IN (23) AND A.TLI_NUMERO IN (1)) " +
                    "     OR (A.FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                    "        AND A.TTR_NUMERO IN (1, 21, 10, 11, 15, 18, 9, 16, 19, 23) AND A.TLI_NUMERO IN (2,5)) " +
                    "     OR (A.FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                    "        AND A.TTR_NUMERO IN (1, 21, 10, 11, 15, 18, 9, 16, 19, 23) AND A.TLI_NUMERO IN (3)) " +
                    "     OR (A.FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                    "        AND A.TTR_NUMERO IN (20, 24)) " +
                    ") " +
                    "AND A.MARCA IN (" + criterios.getMarca() + ") " +
                    "AND D.NUMERO_PROSA = A.ENT_NUMERO_PROSA_ADQ " +
                    "AND E.NUMERO_PROSA = A.ENT_NUMERO_PROSA_EMI " +
                    "AND A.MARCA = B.MARCA " +
                    "AND A.CAMARA_EMI IN (" + criterios.getCamaraEmi() + ") " +
                    "AND A.CAMARA_ADQ = C.CAMARA " +
                    "AND A.NUMERO_FIID_ADQ IN (" + criterios.getBancoAdq() + ") " +
                    "AND A.NUMERO_FIID_EMI IN (" + criterios.getBancoEmi() + ") " +
                    "AND A.TLI_NUMERO IN (1,2,3,5) AND A.TTR_NUMERO IN (16,19,20,21) AND A.STTR_NUMERO IN (281,321) ) " +
                    "GROUP BY NUMERO_FIID_ADQ, NUMERO_FIID_EMI, CODIGO_DE_COMERCIO, CAMARA_ADQ, CAMARA_DESC, MARCA, MARCA_DESC, FELIQ, ADQ_DESC, EMI_DESC " +
                    "ORDER BY 1, 2 ";
System.out.println("Reporte SICCMR0002:" + sSQL);
                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt = conexion.prepareStatement(sSQL);
                pStmt.setString( 1, criterios.getIni());
                pStmt.setString( 2, criterios.getFin());
                pStmt.setString( 3, criterios.getIni());
                pStmt.setString( 4, criterios.getFin());
                pStmt.setString( 5, criterios.getIni());
                pStmt.setString( 6, criterios.getFin());
                pStmt.setString( 7, criterios.getIni());
                pStmt.setString( 8, criterios.getFin());
                pStmt.setString( 9, criterios.getIni());
                pStmt.setString(10, criterios.getFin());

                pStmt.setString(11, criterios.getIni());
                pStmt.setString(12, criterios.getFin());
                pStmt.setString(13, criterios.getIni());
                pStmt.setString(14, criterios.getFin());
                pStmt.setString(15, criterios.getIni());
                pStmt.setString(16, criterios.getFin());
                pStmt.setString(17, criterios.getIni());
                pStmt.setString(18, criterios.getFin());
                pStmt.setString(19, criterios.getIni());
                pStmt.setString(20, criterios.getFin());

                pStmt.setString(21, criterios.getIni());
                pStmt.setString(22, criterios.getFin());
                pStmt.setString(23, criterios.getIni());
                pStmt.setString(24, criterios.getFin());
                pStmt.setString(25, criterios.getIni());
                pStmt.setString(26, criterios.getFin());
                pStmt.setString(27, criterios.getIni());
                pStmt.setString(28, criterios.getFin());
                pStmt.setString(29, criterios.getIni());
                pStmt.setString(30, criterios.getFin());
                rDatos = pStmt.executeQuery();
                lista = new ArrayList();

                while(rDatos.next()){
                    objeto = new SICCMRObj();
                    objeto.setFiidAdq(      rDatos.getString(11));
                    objeto.setFiidEmi(      rDatos.getString(12));
                    objeto.setTrx(          new Integer(rDatos.getString(3)));
                    objeto.setImporte(      new Double(rDatos.getString(4)));
                    objeto.setMcc(          new Integer(rDatos.getString(5)));
                    objeto.setCamara(       new Integer(rDatos.getString(6)));
                    objeto.setCamaraDs(     rDatos.getString(7));
                    objeto.setMarca(        new Integer(rDatos.getString(8)));
                    objeto.setMarcaDs(      rDatos.getString(9));
                    objeto.setFecha(        rDatos.getString(10));
                    lista.add(objeto);
                }
                rDatos.close();

            } catch (Exception e) {
                System.out.println("Error al consultar SICCMR0002 " + ", " + e.toString());
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

    // APLICA LA CONSULTA DE SICCMR0065
    public ArrayList consultarSICCMR0065(CriteriosObj criterios) {
        SICCMRObj objeto = new SICCMRObj();
        ArrayList lista  = null;
        String    liq    = "";

        try{
            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                String sSQL =
                "SELECT ENTIDAD, TRIM(C.DESCRIPCION), TLI_NUMERO, SUM(IMPORTE) FROM ( " +

                "SELECT B.ENT_NUMERO_PROSA, C.ENTIDAD_PADRE ENTIDAD, B.TLI_NUMERO, B.TTR_NUMERO,  " +
                "DECODE(B.TTR_NUMERO,  " +
                "  11, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) , " +
                "  15, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) , " +
                "  16, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) * -1, " +
                "  17, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) * -1, " +
                "  18, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) , " +
                "  19, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) * -1, " +
                "  20, -(NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) - (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)), " +
                "  21, -((NVL(ABS(TOTAL_IMPORTE_EMI), 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) + (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0))), " +
                "      (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) + (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) ) IMPORTE " +
                "FROM  PMADMIN.PRSA_MARCA_POS_FINALES B, PMADMIN.PRSA_ENTIDADES C  " +
                "WHERE ((FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') AND B.TTR_NUMERO in (1,21,15,16,17,9,18,19,101,10,11) ) " +
                "       OR FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') AND B.TTR_NUMERO in (20,24)) " +
                "AND   (TTR_NUMERO IN (11) AND STTR_NUMERO NOT IN (100) OR TTR_NUMERO NOT IN (11)) " +
                "AND B.ENT_NUMERO_PROSA IN (SELECT NUMERO_PROSA FROM PMADMIN.PRSA_ENTIDADES WHERE ENTIDAD_PADRE IN (SELECT NUMERO_PROSA FROM PMADMIN.PRSA_ENTIDADES WHERE NUMERO_FIID IN (" + criterios.getBanco() + "))) " +
                "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA AND B.TLI_NUMERO IN (2) " +
                "AND B.TTR_NUMERO IN (1,21,20,10,11,15,16,17,9,18,19,101) " +

                "UNION ALL " +
                "SELECT B.ENT_NUMERO_PROSA, C.ENTIDAD_PADRE ENTIDAD, B.TLI_NUMERO, B.TTR_NUMERO,  " +
                "DECODE(B.TTR_NUMERO,  " +
                "  15, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) , " +
                "  16, (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) - (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) , " +
                "  17, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) , " +
                "  18, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) , " +
                "  19, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) , " +
                "  20, (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) - (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) * -1, " +
                "  21, (NVL(ABS(TOTAL_IMPORTE_EMI), 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) + (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)), " +
                "      (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0))*-1 - (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) ) IMPORTE " +
                "FROM  PMADMIN.PRSA_MARCA_POS_FINALES B, PMADMIN.PRSA_ENTIDADES C  " +
                "WHERE FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                "AND B.ENT_NUMERO_PROSA IN (SELECT NUMERO_PROSA FROM PMADMIN.PRSA_ENTIDADES WHERE ENTIDAD_PADRE IN (SELECT NUMERO_PROSA FROM PMADMIN.PRSA_ENTIDADES WHERE NUMERO_FIID IN (" + criterios.getBanco() + "))) " +
                "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA AND B.TLI_NUMERO IN (3) " +
                "AND B.TTR_NUMERO IN (1,21,20,15,16,17,9,18,19) " +

                "UNION ALL " +
                "SELECT  B.ENT_NUMERO_PROSA_EMI ENT_NUMERO_PROSA, CASE " +
                "             WHEN C.ENTIDAD_PADRE IN (95,96,97) THEN D.ENTIDAD_PADRE  " +
                "             ELSE C.ENTIDAD_PADRE  " +
                "        END ENTIDAD, " +
                "        B.TLI_NUMERO, DECODE(B.TTR_NUMERO,11,10,B.TTR_NUMERO) TTR_NUMERO, CASE " +
                "             WHEN B.TTR_NUMERO IN (21,20,16,19) THEN B.TOTAL_IMPORTE  " +
                "             WHEN B.TTR_NUMERO IN (10) AND TRIM(B.NOMBRE_ARCHIVO) = 'CZDCS025_112_A' THEN B.TOTAL_IMPORTE " +
                "             WHEN B.TTR_NUMERO IN (11) AND TRIM(B.NOMBRE_ARCHIVO) <> 'CZDCS035' THEN ABS(B.TOTAL_IMPORTE) " +
                "             WHEN B.TTR_NUMERO IN (10) AND TRIM(B.NOMBRE_ARCHIVO) <> 'CZDCS025_112_A' THEN ABS(B.TOTAL_IMPORTE)*-1 " +
                "             ELSE -B.TOTAL_IMPORTE  " +
                "        END IMPORTE  " +
                "FROM  PMADMIN.PRSA_MARCA_POSICIONES B  " +
                "INNER JOIN PMADMIN.PRSA_ENTIDADES C ON C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ  " +
                "INNER JOIN PMADMIN.PRSA_ENTIDADES D ON D.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI  " +
                "WHERE FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                "AND (B.ENT_NUMERO_PROSA_EMI IN (SELECT NUMERO_PROSA FROM PMADMIN.PRSA_ENTIDADES WHERE ENTIDAD_PADRE IN (SELECT NUMERO_PROSA FROM PMADMIN.PRSA_ENTIDADES WHERE NUMERO_FIID IN ( " + criterios.getBanco() + " ))) " +
                "     OR B.ENT_NUMERO_PROSA_ADQ IN (SELECT NUMERO_PROSA FROM PMADMIN.PRSA_ENTIDADES WHERE ENTIDAD_PADRE IN (SELECT NUMERO_PROSA FROM PMADMIN.PRSA_ENTIDADES WHERE NUMERO_FIID IN ( " + criterios.getBanco() + " ))) ) " +
                "AND TRIM(B.NOMBRE_ARCHIVO) NOT IN ('MISC (A FAVOR)','MISC (EN CONTRA)','CZDCS030') " +
                "AND B.TLI_NUMERO IN (3) AND B.TTR_NUMERO in (10,11)  " +

                "UNION ALL " +
                "SELECT B.ENT_NUMERO_PROSA, C.ENTIDAD_PADRE ENTIDAD, 3 TLI_NUMERO, 101 TTR_NUMERO,  " +
                "DECODE(B.TTR_NUMERO,  " +
                "  15, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) * -1, " +
                "  17, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) * -1, " +
                "  18, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) * -1, " +
                "      (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) - (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) * -1) * -1 IMPORTE " +
                "FROM  PMADMIN.PRSA_MARCA_POS_FINALES B, PMADMIN.PRSA_ENTIDADES C  " +
                "WHERE FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                "AND B.ENT_NUMERO_PROSA IN (SELECT NUMERO_PROSA FROM PMADMIN.PRSA_ENTIDADES WHERE ENTIDAD_PADRE IN (SELECT NUMERO_PROSA FROM PMADMIN.PRSA_ENTIDADES WHERE NUMERO_FIID IN (" + criterios.getBanco() + "))) " +
                "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA AND B.TLI_NUMERO IN (2,3) AND B.TTR_NUMERO IN (1,9,15,17,18) AND B.STTR_NUMERO IN (120,322) " +

                "UNION ALL " +
                "SELECT B.ENT_NUMERO_PROSA, C.ENTIDAD_PADRE ENTIDAD, 3 TLI_NUMERO, 101 TTR_NUMERO,  " +
                "DECODE(B.TTR_NUMERO,  " +
                "  16, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) * -1, " +
                "  19, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) * -1, " +
                "  20, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  21, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "      (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) - (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) * -1) * -1 IMPORTE " +
                "FROM  PMADMIN.PRSA_MARCA_POS_FINALES B, PMADMIN.PRSA_ENTIDADES C  " +
                "WHERE FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                "AND B.ENT_NUMERO_PROSA IN (SELECT NUMERO_PROSA FROM PMADMIN.PRSA_ENTIDADES WHERE ENTIDAD_PADRE IN (SELECT NUMERO_PROSA FROM PMADMIN.PRSA_ENTIDADES WHERE NUMERO_FIID IN (" + criterios.getBanco() + "))) " +
                "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA AND B.TLI_NUMERO IN (2,3) " +
                "AND B.TTR_NUMERO IN (16,19,20,21) AND B.STTR_NUMERO IN (281,321) " +
                ") A, PMADMIN.PRSA_ENTIDADES C  " +
                "WHERE C.NUMERO_PROSA = A.ENTIDAD GROUP BY ENTIDAD, TRIM(C.DESCRIPCION), TLI_NUMERO ORDER BY ENTIDAD, TLI_NUMERO";
System.out.println("Reporte SICCMR0065:" + sSQL);
                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt = conexion.prepareStatement(sSQL);
                pStmt.setString( 1, criterios.getIni());
                pStmt.setString( 2, criterios.getFin());
                pStmt.setString( 3, criterios.getIni());
                pStmt.setString( 4, criterios.getFin());

                pStmt.setString( 5, criterios.getIni());
                pStmt.setString( 6, criterios.getFin());

                pStmt.setString( 7, criterios.getIni());
                pStmt.setString( 8, criterios.getFin());

                pStmt.setString( 9, criterios.getIni());
                pStmt.setString(10, criterios.getFin());

                pStmt.setString(11, criterios.getIni());
                pStmt.setString(12, criterios.getFin());
                rDatos = pStmt.executeQuery();
                lista = new ArrayList();

                while(rDatos.next()){
                    objeto = new SICCMRObj();
                    objeto.setEntidad(      new Integer(rDatos.getString(1)));
                    objeto.setNombreBanco(  rDatos.getString(2));
                    liq = rDatos.getString(3);
                    if("3".compareTo(liq) == 0){
                        objeto.setCamara(       1);
                        objeto.setCamaraDs(     nombreCamara("1"));
                    }
                    if("2".compareTo(liq) == 0){
                        objeto.setCamara(       2);
                        objeto.setCamaraDs(     nombreCamara("2"));
                    }
                    objeto.setImporte(      new Double(rDatos.getString(4)));
                    lista.add(objeto);
                }

                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al consultar SICCMR0065 " + ", " + e.toString());
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

    // APLICA LA CONSULTA DE SICCMR0077
    public ArrayList consultarSICCMR0077(CriteriosObj criterios) {
        SICCMRObj objeto = new SICCMRObj();
        ArrayList lista  = null;

        try{
            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                String sSQL =
                    "SELECT ENTIDAD, TRIM(C.DESCRIPCION), TTR_NUMERO, SUM(IMPORTE) " +
                    "FROM (" +

                    "SELECT B.ENT_NUMERO_PROSA_ADQ, C.ENTIDAD_PADRE ENTIDAD, B.TTR_NUMERO TTR_NUMERO, " +
                    "DECODE(TTR_NUMERO, 20, (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0)), "+
                    "                   21, (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0)) , "+
                    "                   16, (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0)) , "+
                    "                   19, (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0)) , "+
                    "                       (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0))* -1 ) IMPORTE "+
                    "FROM PMADMIN.PRSA_MARCA_POSICIONES B, PMADMIN.PRSA_ENTIDADES C " +
                    "WHERE FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') " +
                    "AND B.CAMARA_ADQ IN (" + criterios.getCamaraAdq() + ") " +
                    "AND B.MARCA IN (" + criterios.getMarca() + ") " +
                    "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ " +
                    "AND C.NUMERO_PROSA NOT IN (94,95,96,97,98) " +
                    "AND B.TLI_NUMERO IN (3) AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND B.TTR_NUMERO IN (1,21,20,9) " +

                    "UNION ALL " +
                    "SELECT B.ENT_NUMERO_PROSA_ADQ, C.ENTIDAD_PADRE ENTIDAD, B.TTR_NUMERO TTR_NUMERO, " +
                    "(CASE WHEN TTR_NUMERO IN (11) AND trim(NOMBRE_ARCHIVO) <> 'CZDCS035' THEN abs(TOTAL_IMPORTE) " +
                    "      ELSE -TOTAL_IMPORTE  " +
                    "END) IMPORTE " +
                    "FROM PMADMIN.PRSA_MARCA_POSICIONES B, PMADMIN.PRSA_ENTIDADES C " +
                    "WHERE FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') " +
                    "AND B.CAMARA_ADQ IN (" + criterios.getCamaraAdq() + ") " +
                    "AND B.MARCA IN (" + criterios.getMarca() + ") " +
                    "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ " +
                    "AND C.NUMERO_PROSA NOT IN (94,95,96,97,98) " +
                    "AND B.TLI_NUMERO IN (3) AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) " +
                    "AND (TTR_NUMERO = 11 AND STTR_NUMERO = 112) " +
                    "AND NOMBRE_ARCHIVO NOT IN ('MISC (A FAVOR)','MISC (EN CONTRA)','CZDCS030') " +

                    "UNION ALL " +
                    "SELECT B.ENT_NUMERO_PROSA_EMI, C.ENTIDAD_PADRE ENTIDAD, B.TTR_NUMERO TTR_NUMERO, " +
                    "(CASE WHEN TTR_NUMERO IN (16) THEN (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0)) " +
                    "ELSE (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0))* -1 " +
                    "END) IMPORTE " +
                    "FROM PMADMIN.PRSA_MARCA_POSICIONES B, PMADMIN.PRSA_ENTIDADES C " +
                    "WHERE FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') " +
                    "AND B.CAMARA_EMI IN (" + criterios.getCamaraAdq() + ") " +
                    "AND B.MARCA IN (" + criterios.getMarca() + ") " +
                    "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI " +
                    "AND C.NUMERO_PROSA NOT IN (94,95,96,97,98) " +
                    "AND B.TLI_NUMERO IN (3) AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND B.TTR_NUMERO IN (15,16,17,18,19) " +

                    "UNION ALL " +
                    "SELECT B.ENT_NUMERO_PROSA_EMI, " +
                    "CASE WHEN D.ENTIDAD_PADRE IN (95,96,97) THEN C.ENTIDAD_PADRE " +
                    "     ELSE D.ENTIDAD_PADRE " +
                    "END ENTIDAD, " +
                    "10 TTR_NUMERO, (CASE WHEN TTR_NUMERO IN (10) AND trim(NOMBRE_ARCHIVO) =  'CZDCS025_112_A' THEN TOTAL_IMPORTE " +
                    "                     WHEN TTR_NUMERO IN (11) AND trim(NOMBRE_ARCHIVO) <> 'CZDCS035' THEN abs(TOTAL_IMPORTE) " +
                    "                     WHEN TTR_NUMERO IN (10) AND trim(NOMBRE_ARCHIVO) <> 'CZDCS025_112_A' THEN abs(TOTAL_IMPORTE) * -1 " +
                    "                     ELSE -TOTAL_IMPORTE  " +
                    "               END) IMPORTE  " +
                    "FROM PMADMIN.PRSA_MARCA_POSICIONES B, PMADMIN.PRSA_ENTIDADES C, PMADMIN.PRSA_ENTIDADES D  " +
                    "WHERE FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                    "AND (B.CAMARA_EMI IN (" + criterios.getCamaraAdq() + ") OR B.CAMARA_ADQ IN (" + criterios.getCamaraAdq() + ") ) " +
                    "AND B.MARCA IN ("  + criterios.getMarca() +  ")  " +
                    "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI  " +
                    "AND D.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ " +
                    "AND B.TLI_NUMERO IN (3) AND TTR_NUMERO in (10,11) " +
                    "AND trim(NOMBRE_ARCHIVO) not in ('MISC (A FAVOR)','MISC (EN CONTRA)','CZDCS030') " +

                    "UNION ALL " +
                    "SELECT B.ENT_NUMERO_PROSA_EMI, C.ENTIDAD_PADRE ENTIDAD, 101 TTR_NUMERO, " +
                    "DECODE(TTR_NUMERO, 20, (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0)) , " +
                    "                   21, (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0)) , " +
                    "                   16, (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0)) , " +
                    "                   19, (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0)) , " +
                    "                       (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0)) * -1) IMPORTE " +
                    "FROM PMADMIN.PRSA_MARCA_POSICIONES B, PMADMIN.PRSA_ENTIDADES C " +
                    "WHERE FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') " +
                    "AND B.CAMARA_EMI IN (" + criterios.getCamaraAdq() + ") " +
                    "AND B.MARCA IN (" + criterios.getMarca() + ") " +
                    "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI " +
                    "AND C.NUMERO_PROSA NOT IN (94,95,96,97,98) AND B.TLI_NUMERO IN (2,3) " +
                    "AND ( (TTR_NUMERO IN (1,9,15,17,18) AND STTR_NUMERO IN (120,322)) OR (TTR_NUMERO IN (20,21,16,19) AND STTR_NUMERO IN (281,321)) ) " +
                    ") A, PMADMIN.PRSA_ENTIDADES C " +
                    "WHERE C.NUMERO_PROSA = A.ENTIDAD " +
                    "GROUP BY ENTIDAD, TRIM(C.DESCRIPCION), TTR_NUMERO ";
System.out.println("Reporte SICCMR0077:" + sSQL);
                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt = conexion.prepareStatement(sSQL);
                pStmt.setString(1, criterios.getIni());
                pStmt.setString(2, criterios.getFin());
                pStmt.setString(3, criterios.getIni());
                pStmt.setString(4, criterios.getFin());
                pStmt.setString(5, criterios.getIni());
                pStmt.setString(6, criterios.getFin());
                pStmt.setString(7, criterios.getIni());
                pStmt.setString(8, criterios.getFin());
                pStmt.setString(9, criterios.getIni());
                pStmt.setString(10,criterios.getFin());
                rDatos = pStmt.executeQuery();
                lista = new ArrayList();

                while(rDatos.next()){
                    objeto = new SICCMRObj();
                    objeto.setEntidad(      new Integer(rDatos.getString(1)));
                    objeto.setNombreBanco(  rDatos.getString(2));
                    // PAGOS Y DEVOLUCIONES POSITIVOS, RESTO NEGATIVOS
                    if("1".compareTo(rDatos.getString(3)) == 0)       {
                        objeto.setTtr(      1);
                        objeto.setTtrDs(    "Ventas");
                        objeto.setImporte(  new Double(rDatos.getString(4)));
                    }
                    else if("21".compareTo(rDatos.getString(3)) == 0) {
                        objeto.setTtr(      2);
                        objeto.setTtrDs(    "Devoluciones");
                        objeto.setImporte(  new Double(rDatos.getString(4)));
                    }
                    else if("20".compareTo(rDatos.getString(3)) == 0) {
                        objeto.setTtr(      3);
                        objeto.setTtrDs(    "Pagos");
                        objeto.setImporte(  new Double(rDatos.getString(4)));
                    }
                    else if("11".compareTo(rDatos.getString(3)) == 0) {
                        objeto.setTtr(      4);
                        objeto.setTtrDs(    "Miscel\u00e1neos");
                        objeto.setImporte(  new Double(rDatos.getString(4)));
                    }
                    else if("10".compareTo(rDatos.getString(3)) == 0) {
                        objeto.setTtr(      4);
                        objeto.setTtrDs(    "Miscel\u00e1neos");
                        objeto.setImporte(  new Double(rDatos.getString(4)));
                    }
                    else if("15".compareTo(rDatos.getString(3)) == 0)  {
                        objeto.setTtr(      5);
                        objeto.setTtrDs(    "1\\B0 Contracargo");
                        objeto.setImporte(  new Double(rDatos.getString(4)));
                    }
                    else if("16".compareTo(rDatos.getString(3)) == 0)  {
                        objeto.setTtr(      5);
                        objeto.setTtrDs(    "1\\B0 Contracargo");
                        objeto.setImporte(  new Double(rDatos.getString(4)));
                    }
                    else if("17".compareTo(rDatos.getString(3)) == 0)  {
                        objeto.setTtr(      5);
                        objeto.setTtrDs(    "1\\B0 Contracargo");
                        objeto.setImporte(  new Double(rDatos.getString(4)));
                    }
                    else if("9".compareTo(rDatos.getString(3)) == 0)  {
                        objeto.setTtr(      6);
                        objeto.setTtrDs(    "Representaciones");
                        objeto.setImporte(  new Double(rDatos.getString(4)));
                    }
                    else if("18".compareTo(rDatos.getString(3)) == 0)  {
                        objeto.setTtr(      7);
                        objeto.setTtrDs(    "2\\B0 Contracargo");
                        objeto.setImporte(  new Double(rDatos.getString(4)));
                    }
                    else if("19".compareTo(rDatos.getString(3)) == 0)  {
                        objeto.setTtr(      7);
                        objeto.setTtrDs(    "2\\B0 Contracargo");
                        objeto.setImporte(  new Double(rDatos.getString(4)));
                    }
                    else if("101".compareTo(rDatos.getString(3)) == 0){
                        objeto.setTtr(      8);
                        objeto.setTtrDs(    "Rechazos de Sintaxis");
                        objeto.setImporte(  new Double(rDatos.getString(4)));
                    }

                    lista.add(objeto);
                }
                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al consultar SICCMR0077 " + ", " + e.toString());
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

    // APLICA LA CONSULTA DE SICCMR0087
    public ArrayList consultarSICCMR0087(CriteriosObj criterios) {
        SICCMRObj objeto = new SICCMRObj();
        ArrayList lista  = null;

        try{
            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                String sSQL =
                    "SELECT ENTIDAD, TRIM(C.DESCRIPCION), TTR_NUMERO, SUM(IMPORTE) " +
                    "FROM (" +
                    "SELECT B.ENT_NUMERO_PROSA_EMI, C.ENTIDAD_PADRE ENTIDAD, B.TTR_NUMERO TTR_NUMERO, " +
                    "ROUND(CASE WHEN B.TTR_NUMERO IN(11,16,19,20,21) THEN -(B.TOTAL_IMPORTE - B.IMPORTE_COMISION_INTERCAMB - B.IVA_COMISION_INTERCAMB) " +
                               "ELSE B.TOTAL_IMPORTE - B.IMPORTE_COMISION_INTERCAMB - B.IVA_COMISION_INTERCAMB " +
                    "END,2) IMPORTE " +
                    "FROM PMADMIN.PRSA_MARCA_POSICIONES B, PMADMIN.PRSA_ENTIDADES C " +
                    "WHERE ( FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') AND TTR_NUMERO IN (1, 21, 10, 11, 15, 18, 9, 16, 19) " +
                        "OR FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') AND TTR_NUMERO IN (20, 24) ) " +
                    "AND B.CAMARA_ADQ IN (" + criterios.getCamaraEmi() + ") " +
                    "AND B.MARCA IN (" + criterios.getMarca() + ") " +
                    "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI " +
                    "AND C.NUMERO_PROSA NOT IN (94,95,96,97,98) " +
                    "AND B.TLI_NUMERO IN (2) " +
                    "AND (TTR_NUMERO IN (10, 11) AND STTR_NUMERO NOT IN (100) OR TTR_NUMERO NOT IN (10, 11))" +
                    "AND B.TTR_NUMERO IN (1,21,20,9,10,11) " +
                    "UNION ALL "+
                    "SELECT B.ENT_NUMERO_PROSA_ADQ, C.ENTIDAD_PADRE ENTIDAD, B.TTR_NUMERO TTR_NUMERO, " +
                    "(NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0)) IMPORTE " +
                    "FROM PMADMIN.PRSA_MARCA_POSICIONES B, PMADMIN.PRSA_ENTIDADES C " +
                    "WHERE ( FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') AND TTR_NUMERO IN (1, 21, 10, 11, 15, 18, 9, 16, 19) " +
                        "OR FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') AND TTR_NUMERO IN (20, 24) ) " +
                    "AND B.CAMARA_EMI IN (" + criterios.getCamaraEmi() + ") " +
                    "AND B.MARCA IN (" + criterios.getMarca() + ") " +
                    "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ " +
                    "AND C.NUMERO_PROSA NOT IN (94,95,96,97,98) " +
                    "AND B.TLI_NUMERO IN (2) AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND B.TTR_NUMERO IN (15,16,17,18,19) " +
                    "AND C.NUMERO_FIID IS NOT NULL " +
                    "UNION ALL " +
                    "SELECT B.ENT_NUMERO_PROSA_ADQ, C.ENTIDAD_PADRE ENTIDAD, 101 TTR_NUMERO, " +
                    "(CASE " +
                    "             WHEN TTR_NUMERO IN (0,1,9,15,18,10,11) THEN (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0)) " +
                    "             WHEN TTR_NUMERO IN (20,21,16,19)       THEN (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0)) * -1 " +
                    "             ELSE (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0)) " +
                    "        END) IMPORTE " +
                    "FROM PMADMIN.PRSA_MARCA_POSICIONES B, PMADMIN.PRSA_ENTIDADES C " +
                    "WHERE ( FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') AND TTR_NUMERO IN (1, 21, 10, 11, 15, 18, 9, 16, 19) " +
                        "OR FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') AND TTR_NUMERO IN (20, 24) ) " +
                    "AND B.CAMARA_ADQ IN (" + criterios.getCamaraEmi() + ") " +
                    "AND B.MARCA IN (" + criterios.getMarca() + ") " +
                    "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ " +
                    "AND C.NUMERO_PROSA NOT IN (94,95,96,97,98) AND B.TLI_NUMERO IN (2) " +
                    "AND ( (TTR_NUMERO IN (1,9,15,17,18) AND STTR_NUMERO IN (281,321)) OR (TTR_NUMERO IN (20,21,16,19) AND STTR_NUMERO IN (120,322)) )" +
                    "AND C.NUMERO_FIID IS NOT NULL " +
                    ") A, PMADMIN.PRSA_ENTIDADES C " +
                    "WHERE C.NUMERO_PROSA = A.ENTIDAD " +
                    "GROUP BY ENTIDAD, TRIM(C.DESCRIPCION), TTR_NUMERO ";
System.out.println("Reporte SICCMR0087:" + sSQL);
                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt = conexion.prepareStatement(sSQL);
                pStmt.setString( 1, criterios.getIni());
                pStmt.setString( 2, criterios.getFin());
                pStmt.setString( 3, criterios.getIni());
                pStmt.setString( 4, criterios.getFin());
                pStmt.setString( 5, criterios.getIni());
                pStmt.setString( 6, criterios.getFin());
                pStmt.setString( 7, criterios.getIni());
                pStmt.setString( 8, criterios.getFin());
                pStmt.setString( 9, criterios.getIni());
                pStmt.setString(10, criterios.getFin());
                pStmt.setString(11, criterios.getIni());
                pStmt.setString(12, criterios.getFin());
                rDatos = pStmt.executeQuery();
                lista = new ArrayList();

                while(rDatos.next()){
                    objeto = new SICCMRObj();
                    objeto.setEntidad(      new Integer(rDatos.getString(1)));
                    objeto.setNombreBanco(  rDatos.getString(2));
                    // PAGOS Y DEVOLUCIONES NEGATIVOS, RESTO POSITIVOS
                    if("1".compareTo(rDatos.getString(3)) == 0)       {
                        objeto.setTtr(      1);
                        objeto.setTtrDs(    "Ventas");
                        objeto.setImporte(  new Double(rDatos.getString(4)));
                    }
                    else if("21".compareTo(rDatos.getString(3)) == 0) {
                        objeto.setTtr(      2);
                        objeto.setTtrDs(    "Devoluciones");
                        objeto.setImporte(  new Double(rDatos.getString(4)));
                    }
                    else if("20".compareTo(rDatos.getString(3)) == 0) {
                        objeto.setTtr(      3);
                        objeto.setTtrDs(    "Pagos");
                        objeto.setImporte(  new Double(rDatos.getString(4)));
                    }
                    else if("11".compareTo(rDatos.getString(3)) == 0) {
                        objeto.setTtr(      4);
                        objeto.setTtrDs(    "Miscel\u00e1neos");
                        objeto.setImporte(  new Double(rDatos.getString(4)));
                    }
                    else if("10".compareTo(rDatos.getString(3)) == 0) {
                        objeto.setTtr(      4);
                        objeto.setTtrDs(    "Miscel\u00e1neos");
                        objeto.setImporte(  new Double(rDatos.getString(4)));
                    }
                    else if("15".compareTo(rDatos.getString(3)) == 0)  {
                        objeto.setTtr(      5);
                        objeto.setTtrDs(    "1\\B0 Contracargo");
                        objeto.setImporte(  new Double(rDatos.getString(4)));
                    }
                    else if("16".compareTo(rDatos.getString(3)) == 0)  {
                        objeto.setTtr(      5);
                        objeto.setTtrDs(    "1\\B0 Contracargo");
                        objeto.setImporte(  new Double(rDatos.getString(4)));
                    }
                    else if("17".compareTo(rDatos.getString(3)) == 0)  {
                        objeto.setTtr(      5);
                        objeto.setTtrDs(    "1\\B0 Contracargo");
                        objeto.setImporte(  new Double(rDatos.getString(4)));
                    }
                    else if("9".compareTo(rDatos.getString(3)) == 0)  {
                        objeto.setTtr(      6);
                        objeto.setTtrDs(    "Representaciones");
                        objeto.setImporte(  new Double(rDatos.getString(4)));
                    }
                    else if("18".compareTo(rDatos.getString(3)) == 0)  {
                        objeto.setTtr(      7);
                        objeto.setTtrDs(    "2\\B0 Contracargo");
                        objeto.setImporte(  new Double(rDatos.getString(4)));
                    }
                    else if("19".compareTo(rDatos.getString(3)) == 0)  {
                        objeto.setTtr(      7);
                        objeto.setTtrDs(    "2\\B0 Contracargo");
                        objeto.setImporte(  new Double(rDatos.getString(4)));
                    }
                    else if("101".compareTo(rDatos.getString(3)) == 0){
                        objeto.setTtr(      8);
                        objeto.setTtrDs(    "Rechazos de Sint\u00e1xis");
                        objeto.setImporte(  new Double(rDatos.getString(4)));
                    }

                    lista.add(objeto);
                }
                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al consultar SICCMR0087 " + ", " + e.toString());
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

    // APLICA LA CONSULTA DE SICCMRC320
    public ArrayList consultarSICCMRC320(CriteriosObj criterios) {
        SICCMRObj objeto = new SICCMRObj();
        ArrayList lista  = null;
        String    liq    = "";

        try{
            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                String sSQL =
                "SELECT ENTIDAD, TRIM(C.DESCRIPCION), TLI_NUMERO, SUM(IMPORTE) FROM ( " +

                "SELECT B.ENT_NUMERO_PROSA, C.ENTIDAD_PADRE ENTIDAD, B.TLI_NUMERO, B.TTR_NUMERO, " +
                "DECODE(B.TTR_NUMERO, " +
                "11,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "15,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "16,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) * -1, " +
                "17,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "18,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "19,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "20, -(NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "21, -(NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "     (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) + (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0))) IMPORTE " +
                "FROM  PMADMIN.PRSA_MARCA_POS_FINALES B, PMADMIN.PRSA_ENTIDADES C " +
                "WHERE ((FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') AND B.TTR_NUMERO in (1,21,15,16,17,9,18,19,101,10,11) ) " +
                "         OR FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') AND B.TTR_NUMERO in (20,24)) " +
                "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA AND B.CAMARA IN (" + criterios.getCamaraAdq() + ") " +
                "AND B.TLI_NUMERO IN (2) " +
                "AND C.NUMERO_PROSA NOT IN (94,95,96,97,98) " +
                "AND (TTR_NUMERO IN (11) AND STTR_NUMERO NOT IN (100) OR TTR_NUMERO NOT IN (11)) " +
                "AND B.TTR_NUMERO IN (1,21,20,10,11,15,16,17,9,18,19,101) " +

                "UNION ALL " +
                "SELECT B.ENT_NUMERO_PROSA, C.ENTIDAD_PADRE ENTIDAD, B.TLI_NUMERO, B.TTR_NUMERO, " +
                "DECODE(B.TTR_NUMERO, " +
                "  10,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  15,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  16,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  17,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  18, -(NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  19, -(NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  20,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  21,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) + (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "      -(NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) - (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0))) IMPORTE " +
                "FROM  PMADMIN.PRSA_MARCA_POS_FINALES B, PMADMIN.PRSA_ENTIDADES C " +
                "WHERE FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') " +
                "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA AND B.CAMARA IN (" + criterios.getCamaraAdq() + ") " +
                "AND B.TLI_NUMERO IN (3) " +
                "AND C.NUMERO_PROSA NOT IN (94,95,96,97,98) " +
                "AND B.TTR_NUMERO IN (1,21,20,15,16,17,9,18,19) AND B.STTR_NUMERO NOT IN (120,322,281,321) " +

                "UNION ALL " +
                "SELECT B.ENT_NUMERO_PROSA_ADQ, CASE  WHEN C.ENTIDAD_PADRE IN (95,96,97) THEN D.ENTIDAD_PADRE  ELSE C.ENTIDAD_PADRE  END ENTIDAD, B.TLI_NUMERO, DECODE(B.TTR_NUMERO,11,10,B.TTR_NUMERO) TTR_NUMERO,  " +
                "CASE WHEN B.TTR_NUMERO IN (21,20,16,19) THEN B.TOTAL_IMPORTE " +
                "     WHEN B.TTR_NUMERO IN (10) AND TRIM(B.NOMBRE_ARCHIVO) =  'CZDCS025_112_A' THEN B.TOTAL_IMPORTE " +
                "     WHEN B.TTR_NUMERO IN (11) AND TRIM(B.NOMBRE_ARCHIVO) <> 'CZDCS035' THEN ABS(B.TOTAL_IMPORTE) " +
                "     WHEN B.TTR_NUMERO IN (10) AND TRIM(B.NOMBRE_ARCHIVO) <> 'CZDCS025_112_A' THEN ABS(B.TOTAL_IMPORTE) * -1 " +
                "     ELSE -B.TOTAL_IMPORTE END IMPORTE " +
                "FROM  PMADMIN.PRSA_MARCA_POSICIONES B " +
                "INNER JOIN PMADMIN.PRSA_ENTIDADES C ON C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ " +
                "INNER JOIN PMADMIN.PRSA_ENTIDADES D ON D.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI " +
                "WHERE FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ AND B.TLI_NUMERO IN (3) " +
                "AND (B.CAMARA_EMI IN ( " + criterios.getCamaraAdq() + " ) or B.CAMARA_ADQ IN ( " + criterios.getCamaraAdq() + " )) " +
                "AND B.TTR_NUMERO IN (10,11) AND B.STTR_NUMERO NOT IN (120,322,281,321) AND TRIM(B.NOMBRE_ARCHIVO) NOT IN ('MISC (A FAVOR)','MISC (EN CONTRA)','CZDCS030')  " +

                "UNION ALL " +
                "SELECT B.ENT_NUMERO_PROSA, C.ENTIDAD_PADRE ENTIDAD,3 TLI_NUMERO, 101 TTR_NUMERO, " +
                "DECODE(B.TTR_NUMERO, " +
                " 20, (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) - (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)), " +
                " 21, (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) - (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)), " +
                "    -(NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) - (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0))) IMPORTE " +
                "FROM  PMADMIN.PRSA_MARCA_POS_FINALES B, PMADMIN.PRSA_ENTIDADES C " +
                "WHERE FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') " +
                "AND C.NUMERO_PROSA NOT IN (94,95,96,97,98) " +
                "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA AND B.CAMARA IN (" + criterios.getCamaraAdq() + ") " +
                "AND B.TLI_NUMERO IN (2,3) " +
                "AND ( (B.TTR_NUMERO IN (1,9,15,17,18) AND B.STTR_NUMERO IN (120,322)) OR (B.TTR_NUMERO IN (20,21,16,19) AND B.STTR_NUMERO IN (281,321)) )" +
                ") A, PMADMIN.PRSA_ENTIDADES C " +
                "WHERE C.NUMERO_PROSA = A.ENTIDAD GROUP BY ENTIDAD, TRIM(C.DESCRIPCION), TLI_NUMERO ORDER BY ENTIDAD, TLI_NUMERO";
System.out.println("Reporte SICCMR0320_1:" + sSQL);
                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt = conexion.prepareStatement(sSQL);
                pStmt.setString( 1, criterios.getIni());
                pStmt.setString( 2, criterios.getFin());
                pStmt.setString( 3, criterios.getIni());
                pStmt.setString( 4, criterios.getFin());

                pStmt.setString( 5, criterios.getIni());
                pStmt.setString( 6, criterios.getFin());

                pStmt.setString( 7, criterios.getIni());
                pStmt.setString( 8, criterios.getFin());

                pStmt.setString( 9, criterios.getIni());
                pStmt.setString(10, criterios.getFin());
                rDatos = pStmt.executeQuery();
                lista = new ArrayList();

                while(rDatos.next()){
                    objeto = new SICCMRObj();
                    objeto.setEntidad(      new Integer(rDatos.getString(1)));
                    objeto.setNombreBanco(  rDatos.getString(2));
                    liq = rDatos.getString(3);
                    if("3".compareTo(liq) == 0){
                        objeto.setCamara(       1);
                        objeto.setCamaraDs(     nombreCamara("1"));
                    }
                    if("2".compareTo(liq) == 0){
                        objeto.setCamara(       2);
                        objeto.setCamaraDs(     nombreCamara("2"));
                    }
                    objeto.setImporte(      new Double(rDatos.getString(4)));
                    lista.add(objeto);
                }

                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al consultar SICCMRC320 " + ", " + e.toString());
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

    // APLICA LA CONSULTA DE SICCMRC330
    public ArrayList consultarSICCMRC330(CriteriosObj criterios) {
        SICCMRObj objeto = new SICCMRObj();
        ArrayList lista  = null;

        try{
            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                String sSQL =
                "SELECT ENTIDAD, TRIM(C.DESCRIPCION), A.MARCA, A.DSMARCA, SUM(IMPORTE) FROM ( " +

                "SELECT B.ENT_NUMERO_PROSA, C.ENTIDAD_PADRE ENTIDAD, B.TTR_NUMERO, B.MARCA, TRIM(D.DESCRIPCION) DSMARCA, " +
                "DECODE(B.TTR_NUMERO,  " +
                "  11, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  15, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  16, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) * -1, " +
                "  17, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  18, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  19, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  20,-(NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  21,-(NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "      (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) + (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0))) IMPORTE " +
                "FROM  PMADMIN.PRSA_MARCA_POS_FINALES B, PMADMIN.PRSA_ENTIDADES C, PMADMIN.PRSA_MARCA D " +
                "WHERE ((FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') AND B.TTR_NUMERO in (1,21,15,16,17,9,18,19,101,10,11) ) " +
                "         OR FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') AND B.TTR_NUMERO in (20,24)) " +
                "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA AND B.MARCA = D.MARCA AND D.MARCA IN (" + criterios.getMarca() + ") " +
                "AND B.TLI_NUMERO IN (2) " +
                "AND C.NUMERO_PROSA NOT IN (94,95,96,97,98) " +
                "AND (TTR_NUMERO IN (11) AND STTR_NUMERO NOT IN (100) OR TTR_NUMERO NOT IN (11))  " +
                "AND B.TTR_NUMERO IN (1,21,20,10,11,15,16,17,9,18,19,101) " +

                "UNION ALL " +
                "SELECT B.ENT_NUMERO_PROSA, C.ENTIDAD_PADRE ENTIDAD, B.TTR_NUMERO, B.MARCA, TRIM(D.DESCRIPCION) DSMARCA, " +
                "DECODE(B.TTR_NUMERO,  " +
                "  10, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  15, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  16, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  17, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  18,-(NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  19,-(NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  20, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  21, (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) + (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "     -(NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) - (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0))) IMPORTE " +
                "FROM  PMADMIN.PRSA_MARCA_POS_FINALES B, PMADMIN.PRSA_ENTIDADES C, PMADMIN.PRSA_MARCA D " +
                "WHERE FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA AND B.MARCA = D.MARCA AND D.MARCA IN (" + criterios.getMarca() + ") " +
                "AND B.TLI_NUMERO IN (3) " +
                "AND C.NUMERO_PROSA NOT IN (94,95,96,97,98) " +
                "AND B.TTR_NUMERO IN (1,21,20,15,16,17,9,18,19) AND B.STTR_NUMERO NOT IN (120,322,281,321) " +


                "UNION ALL " +
                "SELECT B.ENT_NUMERO_PROSA_ADQ, CASE  WHEN C.ENTIDAD_PADRE IN (95,96,97) THEN D.ENTIDAD_PADRE  ELSE C.ENTIDAD_PADRE  END ENTIDAD, DECODE(B.TTR_NUMERO,11,10,B.TTR_NUMERO) TTR_NUMERO, B.MARCA, TRIM(E.DESCRIPCION) DSMARCA, " +
                "CASE WHEN B.TTR_NUMERO IN (21,20,16,19) THEN B.TOTAL_IMPORTE " +
                "     WHEN B.TTR_NUMERO IN (10) AND TRIM(B.NOMBRE_ARCHIVO) = 'CZDCS025_112_A' THEN B.TOTAL_IMPORTE " +
                "     WHEN B.TTR_NUMERO IN (11) AND TRIM(B.NOMBRE_ARCHIVO) <> 'CZDCS035' THEN ABS(B.TOTAL_IMPORTE) " +
                "     WHEN B.TTR_NUMERO IN (10) AND TRIM(B.NOMBRE_ARCHIVO) <> 'CZDCS025_112_A' THEN ABS(B.TOTAL_IMPORTE) * -1 " +
                "     ELSE -B.TOTAL_IMPORTE END IMPORTE " +
                "FROM  PMADMIN.PRSA_MARCA_POSICIONES B " +
                "INNER JOIN PMADMIN.PRSA_ENTIDADES C ON C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ " +
                "INNER JOIN PMADMIN.PRSA_ENTIDADES D ON D.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI " +
                "INNER JOIN PMADMIN.PRSA_MARCA E ON E.MARCA = B.MARCA " +
                "WHERE FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ AND B.TLI_NUMERO IN (3) " +
                "AND E.MARCA IN (" + criterios.getMarca() + ") " +
                "AND B.TTR_NUMERO IN (10,11) AND B.STTR_NUMERO NOT IN (120,322,281,321) AND TRIM(B.NOMBRE_ARCHIVO) NOT IN ('MISC (A FAVOR)','MISC (EN CONTRA)','CZDCS030') " +

                "UNION ALL " +
                "SELECT B.ENT_NUMERO_PROSA, C.ENTIDAD_PADRE ENTIDAD, 101 TTR_NUMERO, B.MARCA, TRIM(D.DESCRIPCION) DSMARCA, " +
                "DECODE(B.TTR_NUMERO,  " +
                "  20,  (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) - (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)), " +
                "  21,  (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) - (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)), " +
                "      -(NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) - (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0))) IMPORTE " +
                "FROM  PMADMIN.PRSA_MARCA_POS_FINALES B, PMADMIN.PRSA_ENTIDADES C , PMADMIN.PRSA_MARCA D " +
                "WHERE FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                "AND C.NUMERO_PROSA NOT IN (94,95,96,97,98)  " +
                "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA AND B.MARCA = D.MARCA AND D.MARCA IN (" + criterios.getMarca() + ") " +
                "AND B.TLI_NUMERO IN (2,3)  " +
                "AND ( (B.TTR_NUMERO IN (1,9,15,17,18) AND B.STTR_NUMERO IN (120,322)) OR (B.TTR_NUMERO IN (20,21,16,19) AND B.STTR_NUMERO IN (281,321)) ) " +
                ") A, PMADMIN.PRSA_ENTIDADES C  " +
                "WHERE C.NUMERO_PROSA = A.ENTIDAD GROUP BY ENTIDAD, TRIM(C.DESCRIPCION), A.MARCA, A.DSMARCA ORDER BY ENTIDAD, A.MARCA";
System.out.println("Reporte SICCMR0330_1:" + sSQL);
                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt = conexion.prepareStatement(sSQL);
                pStmt.setString( 1, criterios.getIni());
                pStmt.setString( 2, criterios.getFin());
                pStmt.setString( 3, criterios.getIni());
                pStmt.setString( 4, criterios.getFin());

                pStmt.setString( 5, criterios.getIni());
                pStmt.setString( 6, criterios.getFin());

                pStmt.setString( 7, criterios.getIni());
                pStmt.setString( 8, criterios.getFin());

                pStmt.setString( 9, criterios.getIni());
                pStmt.setString(10, criterios.getFin());
                rDatos = pStmt.executeQuery();
                lista = new ArrayList();

                while(rDatos.next()){
                    objeto = new SICCMRObj();
                    objeto.setEntidad(      new Integer(rDatos.getString(1)));
                    objeto.setNombreBanco(  rDatos.getString(2));
                    objeto.setMarca(        new Integer(rDatos.getString(3)));
                    objeto.setMarcaDs(      rDatos.getString(4));
                    objeto.setImporte(      new Double(rDatos.getString(5)));
                    lista.add(objeto);
                }

                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al consultar SICCMRC330 " + ", " + e.toString());
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

    // APLICA LA CONSULTA DE SICCMRC320, MARCAS
    public ArrayList consultarSICCMRC320_2(CriteriosObj criterios) {
        SICCMRObj objeto = new SICCMRObj();
        ArrayList lista  = null;
        String    liq    = "";

        try{
            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                String sSQL =
                "SELECT ENTIDAD, TRIM(C.DESCRIPCION), A.TLI_NUMERO, A.MARCA, A.DSMARCA, SUM(IMPORTE) FROM ( " +

                "SELECT B.ENT_NUMERO_PROSA, C.ENTIDAD_PADRE ENTIDAD, B.TTR_NUMERO, B.MARCA, TRIM(D.DESCRIPCION) DSMARCA, B.TLI_NUMERO, " +
                "DECODE(B.TTR_NUMERO, " +
                "11,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "15,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "16,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) * -1, " +
                "17,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "18,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "19,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "20, -(NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "21, -(NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "     (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) + (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0))) IMPORTE " +
                "FROM  PMADMIN.PRSA_MARCA_POS_FINALES B, PMADMIN.PRSA_ENTIDADES C, PMADMIN.PRSA_MARCA D " +
                "WHERE ((FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') AND B.TTR_NUMERO in (1,21,15,16,17,9,18,19,101,10,11) ) " +
                "         OR FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') AND B.TTR_NUMERO in (20,24)) " +
                "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA AND B.CAMARA IN (" + criterios.getCamaraAdq() + ") " +
                "AND B.TLI_NUMERO IN (2) " +
                "AND C.NUMERO_PROSA NOT IN (94,95,96,97,98) " +
                "AND (TTR_NUMERO IN (11) AND STTR_NUMERO NOT IN (100) OR TTR_NUMERO NOT IN (11)) " +
                "AND B.TTR_NUMERO IN (1,21,20,10,11,15,16,17,9,18,19,101) " +
                "AND B.MARCA = D.MARCA AND D.MARCA IN (1, 2, 3, 999) " +

                "UNION ALL " +
                "SELECT B.ENT_NUMERO_PROSA, C.ENTIDAD_PADRE ENTIDAD, B.TTR_NUMERO, B.MARCA, TRIM(D.DESCRIPCION) DSMARCA, B.TLI_NUMERO, " +
                "DECODE(B.TTR_NUMERO, " +
                "  10,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  15,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  16,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  17,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  18, -(NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  19, -(NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  20,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "  21,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) + (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "      -(NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) - (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0))) IMPORTE " +
                "FROM  PMADMIN.PRSA_MARCA_POS_FINALES B, PMADMIN.PRSA_ENTIDADES C, PMADMIN.PRSA_MARCA D " +
                "WHERE FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA AND B.CAMARA IN (" + criterios.getCamaraAdq() + ") " +
                "AND B.TLI_NUMERO IN (3) " +
                "AND C.NUMERO_PROSA NOT IN (94,95,96,97,98) " +
                "AND B.TTR_NUMERO IN (1,21,20,15,16,17,9,18,19) AND B.STTR_NUMERO NOT IN (120,322,281,321) " +
                "AND B.MARCA = D.MARCA AND D.MARCA IN (1, 2, 3, 999) " +

                "UNION ALL " +
                "SELECT B.ENT_NUMERO_PROSA_ADQ, CASE  WHEN C.ENTIDAD_PADRE IN (95,96,97) THEN D.ENTIDAD_PADRE  ELSE C.ENTIDAD_PADRE  END ENTIDAD, B.TTR_NUMERO, B.MARCA, TRIM(E.DESCRIPCION) DSMARCA, B.TLI_NUMERO,   " +
                "CASE WHEN B.TTR_NUMERO IN (10) AND TRIM(B.NOMBRE_ARCHIVO) =  'CZDCS025_112_A' THEN B.TOTAL_IMPORTE " +
                "     WHEN B.TTR_NUMERO IN (11) AND TRIM(B.NOMBRE_ARCHIVO) <> 'CZDCS035' THEN ABS(B.TOTAL_IMPORTE) " +
                "     WHEN B.TTR_NUMERO IN (10) AND TRIM(B.NOMBRE_ARCHIVO) <> 'CZDCS025_112_A' THEN ABS(B.TOTAL_IMPORTE) * -1 " +
                "     ELSE -B.TOTAL_IMPORTE END IMPORTE " +
                "FROM  PMADMIN.PRSA_MARCA_POSICIONES B, PMADMIN.PRSA_ENTIDADES C, PMADMIN.PRSA_ENTIDADES D, PMADMIN.PRSA_MARCA E  " +
                "WHERE FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ " +
                "AND D.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI AND B.TLI_NUMERO IN (3) " +
                "AND B.TTR_NUMERO IN (10,11) AND B.STTR_NUMERO NOT IN (120,322,281,321) " +
                "AND TRIM(B.NOMBRE_ARCHIVO) NOT IN ('MISC (A FAVOR)','MISC (EN CONTRA)','CZDCS030') " +
                "AND B.MARCA = E.MARCA AND E.MARCA IN (1, 2, 3, 999) " +

                "UNION ALL " +
                "SELECT B.ENT_NUMERO_PROSA, C.ENTIDAD_PADRE ENTIDAD, 101 TTR_NUMERO, B.MARCA, TRIM(D.DESCRIPCION) DSMARCA, 3 TLI_NUMERO, " +
                "DECODE(B.TTR_NUMERO, " +
                " 20, (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) - (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)), " +
                " 21, (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) - (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)), " +
                "    -(NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) - (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0))) IMPORTE " +
                "FROM  PMADMIN.PRSA_MARCA_POS_FINALES B, PMADMIN.PRSA_ENTIDADES C, PMADMIN.PRSA_MARCA D " +
                "WHERE FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                "AND C.NUMERO_PROSA NOT IN (94,95,96,97,98) " +
                "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA AND B.CAMARA IN (" + criterios.getCamaraAdq() + ") " +
                "AND B.TLI_NUMERO IN (2,3) " +
                "AND ( (B.TTR_NUMERO IN (1,9,15,17,18) AND B.STTR_NUMERO IN (120,322)) OR (B.TTR_NUMERO IN (20,21,16,19) AND B.STTR_NUMERO IN (281,321)) ) " +
                "AND B.MARCA = D.MARCA AND D.MARCA IN (1, 2, 3, 999) " +
                ") A, PMADMIN.PRSA_ENTIDADES C  " +
                "WHERE C.NUMERO_PROSA = A.ENTIDAD GROUP BY ENTIDAD, TRIM(C.DESCRIPCION), A.TLI_NUMERO, A.MARCA, A.DSMARCA ORDER BY ENTIDAD, A.MARCA";
System.out.println("Reporte SICCMR0320_2:" + sSQL);
                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt = conexion.prepareStatement(sSQL);
                pStmt.setString( 1, criterios.getIni());
                pStmt.setString( 2, criterios.getFin());
                pStmt.setString( 3, criterios.getIni());
                pStmt.setString( 4, criterios.getFin());

                pStmt.setString( 5, criterios.getIni());
                pStmt.setString( 6, criterios.getFin());

                pStmt.setString( 7, criterios.getIni());
                pStmt.setString( 8, criterios.getFin());

                pStmt.setString( 9, criterios.getIni());
                pStmt.setString(10, criterios.getFin());
                rDatos = pStmt.executeQuery();
                lista = new ArrayList();

                while(rDatos.next()){
                    objeto = new SICCMRObj();
                    liq = rDatos.getString(3);
                    if("3".compareTo(liq) == 0){
                        objeto.setEntidad(       1);
                        objeto.setNombreBanco(   nombreCamara("1"));
                    }
                    if("2".compareTo(liq) == 0){
                        objeto.setEntidad(       2);
                        objeto.setNombreBanco(   nombreCamara("2"));
                    }
                    objeto.setTtr(          new Integer(rDatos.getString(4)));
                    objeto.setTtrDs(        rDatos.getString(5));
                    objeto.setImporte(      new Double(rDatos.getString(6)));
                    lista.add(objeto);
                }

                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al consultar SICCMRC320_2 " + ", " + e.toString());
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

    // APLICA LA CONSULTA DE SICCMRC330, CAMARAS
    public ArrayList consultarSICCMRC330_2(CriteriosObj criterios) {
        SICCMRObj objeto = new SICCMRObj();
        ArrayList lista  = null;
        String    liq    = "";

        try{
            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                String sSQL =
                "SELECT ENTIDAD, TRIM(C.DESCRIPCION), TLI_NUMERO, A.MARCA, A.DSMARCA, SUM(IMPORTE) FROM (" +

                "SELECT B.ENT_NUMERO_PROSA, C.ENTIDAD_PADRE ENTIDAD, B.TLI_NUMERO, B.TTR_NUMERO, B.MARCA, TRIM(D.DESCRIPCION) DSMARCA, " +
                "DECODE(B.TTR_NUMERO, " +
                "11,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "15,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "16,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) * -1, " +
                "17,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "18,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "19,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "20, -(NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "21, -(NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "     (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) + (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0))) IMPORTE " +
                "FROM  PMADMIN.PRSA_MARCA_POS_FINALES B, PMADMIN.PRSA_ENTIDADES C, PMADMIN.PRSA_MARCA D " +
                "WHERE ((FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') AND B.TTR_NUMERO in (1,21,15,16,17,9,18,19,101,10,11) ) " +
                "         OR FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') AND B.TTR_NUMERO in (20,24)) " +
                "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA AND B.MARCA = D.MARCA AND D.MARCA IN (" + criterios.getMarca() + ") " +
                "AND B.TLI_NUMERO IN (2) " +
                "AND C.NUMERO_PROSA NOT IN (94,95,96,97,98) " +
                "AND (TTR_NUMERO IN (11) AND STTR_NUMERO NOT IN (100) OR TTR_NUMERO NOT IN (11)) " +
                "AND B.TTR_NUMERO IN (1,21,20,10,11,15,16,17,9,18,19,101) " +

                "UNION ALL " +
                "SELECT B.ENT_NUMERO_PROSA, C.ENTIDAD_PADRE ENTIDAD, B.TLI_NUMERO, B.TTR_NUMERO, B.MARCA, TRIM(D.DESCRIPCION) DSMARCA, " +
                "DECODE(B.TTR_NUMERO, " +
                "10,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "15,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "16,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "17,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "18, -(NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "19, -(NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "20,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) - (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "21,  (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)) + (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)), " +
                "    -(NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) - (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0))) IMPORTE " +
                "FROM  PMADMIN.PRSA_MARCA_POS_FINALES B, PMADMIN.PRSA_ENTIDADES C, PMADMIN.PRSA_MARCA D " +
                "WHERE FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') " +
                "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA AND B.MARCA = D.MARCA AND D.MARCA IN (" + criterios.getMarca() + ") " +
                "AND B.TLI_NUMERO IN (3) " +
                "AND C.NUMERO_PROSA NOT IN (94,95,96,97,98) " +
                "AND B.TTR_NUMERO IN (1,21,20,15,16,17,9,18,19) AND B.STTR_NUMERO NOT IN (120,322,281,321) " +

                "UNION ALL " +
                "SELECT B.ENT_NUMERO_PROSA_ADQ, CASE  WHEN C.ENTIDAD_PADRE IN (95,96,97) THEN D.ENTIDAD_PADRE  ELSE C.ENTIDAD_PADRE  END ENTIDAD, B.TLI_NUMERO, DECODE(B.TTR_NUMERO,11,10,B.TTR_NUMERO) TTR_NUMERO , B.MARCA, TRIM(E.DESCRIPCION) DSMARCA, " +
                "CASE WHEN B.TTR_NUMERO IN (21,20,16,19) THEN B.TOTAL_IMPORTE " +
                "     WHEN B.TTR_NUMERO IN (10) AND TRIM(B.NOMBRE_ARCHIVO) = 'CZDCS025_112_A' THEN B.TOTAL_IMPORTE " +
                "     WHEN B.TTR_NUMERO IN (11) AND TRIM(B.NOMBRE_ARCHIVO) <> 'CZDCS035' THEN ABS(B.TOTAL_IMPORTE) " +
                "     WHEN B.TTR_NUMERO IN (10) AND TRIM(B.NOMBRE_ARCHIVO) <> 'CZDCS025_112_A' THEN ABS(B.TOTAL_IMPORTE)*-1 " +
                "     ELSE -B.TOTAL_IMPORTE END IMPORTE " +
                "FROM  PMADMIN.PRSA_MARCA_POSICIONES B " +
                "INNER JOIN PMADMIN.PRSA_ENTIDADES C ON C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ " +
                "INNER JOIN PMADMIN.PRSA_ENTIDADES D ON D.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI " +
                "INNER JOIN PMADMIN.PRSA_MARCA E ON E.MARCA = B.MARCA " +
                "WHERE FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY')  " +
                "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ AND B.TLI_NUMERO IN (3) " +
                "AND E.MARCA IN (" + criterios.getMarca() + ") " +
                "AND B.TTR_NUMERO IN (10,11) AND B.STTR_NUMERO NOT IN (120,322,281,321) AND TRIM(B.NOMBRE_ARCHIVO) NOT IN ('MISC (A FAVOR)','MISC (EN CONTRA)','CZDCS030') " +

                "UNION ALL " +
                "SELECT B.ENT_NUMERO_PROSA, C.ENTIDAD_PADRE ENTIDAD, 3 TLI_NUMERO, B.TTR_NUMERO, B.MARCA, TRIM(D.DESCRIPCION) DSMARCA, " +
                "DECODE(B.TTR_NUMERO, " +
                " 20, (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) - (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)), " +
                " 21, (NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) - (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0)), " +
                "    -(NVL(TOTAL_IMPORTE_EMI, 0) - NVL(TOTAL_COM_INTERCAMB_EMI, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_EMI, 0)) - (NVL(TOTAL_IMPORTE_ADQ, 0) - NVL(TOTAL_COM_INTERCAMB_ADQ, 0) - NVL(TOTAL_IVA_COM_INTERCAMB_ADQ, 0))) IMPORTE " +
                "FROM  PMADMIN.PRSA_MARCA_POS_FINALES B, PMADMIN.PRSA_ENTIDADES C , PMADMIN.PRSA_MARCA D " +
                "WHERE FECHA_LIQ BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') " +
                "AND C.NUMERO_PROSA NOT IN (94,95,96,97,98) " +
                "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA AND B.MARCA = D.MARCA AND D.MARCA IN (" + criterios.getMarca() + ") " +
                "AND B.TLI_NUMERO IN (2,3) " +
                "AND ( (B.TTR_NUMERO IN (1,9,15,17,18) AND B.STTR_NUMERO IN (120,322)) OR (B.TTR_NUMERO IN (20,21,16,19) AND B.STTR_NUMERO IN (281,321)) ) " +

                ") A, PMADMIN.PRSA_ENTIDADES C " +
                "WHERE C.NUMERO_PROSA = A.ENTIDAD GROUP BY ENTIDAD, TRIM(C.DESCRIPCION), TLI_NUMERO, A.MARCA, A.DSMARCA ORDER BY ENTIDAD, TLI_NUMERO, A.MARCA";
System.out.println("Reporte SICCMR0330_2:" + sSQL);
                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt = conexion.prepareStatement(sSQL);
                pStmt.setString( 1, criterios.getIni());
                pStmt.setString( 2, criterios.getFin());
                pStmt.setString( 3, criterios.getIni());
                pStmt.setString( 4, criterios.getFin());

                pStmt.setString( 5, criterios.getIni());
                pStmt.setString( 6, criterios.getFin());

                pStmt.setString( 7, criterios.getIni());
                pStmt.setString( 8, criterios.getFin());

                pStmt.setString( 9, criterios.getIni());
                pStmt.setString(10, criterios.getFin());
                rDatos = pStmt.executeQuery();
                lista = new ArrayList();

                while(rDatos.next()){
                    objeto = new SICCMRObj();
                    objeto.setEntidad(      new Integer(rDatos.getString(4)));
                    objeto.setNombreBanco(  rDatos.getString(5));
                    liq = rDatos.getString(3);
                    if("3".compareTo(liq) == 0){
                        objeto.setTtr(       1);
                        objeto.setTtrDs(     nombreCamara("1"));
                    }
                    if("2".compareTo(liq) == 0){
                        objeto.setTtr(       2);
                        objeto.setTtrDs(     nombreCamara("2"));
                    }
                    objeto.setImporte(      new Double(rDatos.getString(6)));
                    lista.add(objeto);
                }

                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al consultar SICCMRC330_2 " + ", " + e.toString());
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

    // OBTIENE UNA LISTA DE BANCOS (FIID Y NOMBRE) A PARTIR DE UNA LISTA DE FIIDS
    public ArrayList nombresBancos(ArrayList entrada) {
        ArrayList lista                = new ArrayList();
        PreparedStatement pStmt        = null;
        ResultSet rDatos               = null;
        EstructuraListaObj elemento    = null;
        String sSQL                    = "";
        String valor                   = "";
        String fiid                    = "";
        Iterator it                    = entrada.iterator();

        sSQL = "SELECT numero_fiid, descripcion From PMADMIN.PRSA_ENTIDADES Where numero_fiid LIKE ? and entidad_padre = numero_prosa";
        try {
            obtieneConexion();

            while(it.hasNext()){
                fiid = (String)it.next();

                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt = conexion.prepareStatement(sSQL);
                pStmt.setString(1, fiid);
                rDatos = pStmt.executeQuery();

                // BARRE LOS REGISTROS OBTENIDOS
                while(rDatos.next()){
                    elemento = new EstructuraListaObj();
                    elemento.setClave(      rDatos.getString(1));
                    elemento.setDescripcion(rDatos.getString(2));
                    lista.add(elemento);
                }
                pStmt.close();
                rDatos.close();
            }
        } catch(Exception e ) {
            System.out.println(" Error al obtener NombresBancos:" + e);
            System.out.println(",");
        } finally{
            cierraConexion();
        }

        return lista;
    }

    // OBTIENE EL NOMBRE DE LA FIID DE UN BANCO
    public String nombreBanco(String fiid) {
        PreparedStatement pStmt        = null;
        ResultSet rDatos               = null;
        String sSQL                    = "";
        String valor                   = "";

        sSQL = "SELECT TRIM(descripcion) From PMADMIN.PRSA_ENTIDADES Where numero_fiid LIKE ? and entidad_padre = numero_prosa";
        try {
            obtieneConexion();

            // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
            pStmt = conexion.prepareStatement(sSQL);
            pStmt.setString(1, fiid);
            rDatos = pStmt.executeQuery();

            // BARRE LOS REGISTROS OBTENIDOS
            while(rDatos.next()){
                valor = rDatos.getString(1);
            }
            pStmt.close();
            rDatos.close();
        } catch(Exception e ) {
            System.out.println(" Error al obtener NombreBanco:" + e);
            System.out.println(",");
        } finally{
            cierraConexion();
        }

        return valor;
    }

    // OBTIENE EL NOMBRE DE LA FIID DE UN BANCO
    public String nombreBanco2(String fiid) {
        PreparedStatement pStmt        = null;
        ResultSet rDatos               = null;
        String sSQL                    = "";
        String valor                   = "";

        sSQL = "SELECT TRIM(descripcion) From PMADMIN.PRSA_ENTIDADES Where numero_prosa = " + fiid;
        try {
            obtieneConexion();

            // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
            pStmt = conexion.prepareStatement(sSQL);
            rDatos = pStmt.executeQuery();

            // BARRE LOS REGISTROS OBTENIDOS
            while(rDatos.next()){
                valor = rDatos.getString(1);
            }
            pStmt.close();
            rDatos.close();
        } catch(Exception e ) {
            System.out.println(" Error al obtener NombreBanco2:" + e);
            System.out.println(",");
        } finally{
            cierraConexion();
        }

        return valor;
    }

    // OBTIENE LA ENTIDAD Y NOMBRE DE LA FIID DE UN BANCO
    public String entidadNombreBanco(String fiid) {
        PreparedStatement pStmt        = null;
        ResultSet rDatos               = null;
        String sSQL                    = "";
        String valor                   = "";

        sSQL = "SELECT numero_prosa, TRIM(descripcion) From PMADMIN.PRSA_ENTIDADES Where numero_fiid IN (" + fiid + ")";
        try {
            obtieneConexion();

            // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
            pStmt = conexion.prepareStatement(sSQL);
            rDatos = pStmt.executeQuery();

            // BARRE LOS REGISTROS OBTENIDOS
            while(rDatos.next()){
                valor = rDatos.getString(1) + " " + rDatos.getString(2);
            }
            pStmt.close();
            rDatos.close();
        } catch(Exception e ) {
            System.out.println(" Error al obtener NombreBanco:" + e);
            System.out.println(",");
        } finally{
            cierraConexion();
        }

        return valor;
    }

    // OBTIENE LA ENTIDAD Y NOMBRE DE LA ENTIDAD DE UN BANCO
    public String entidadNombreBanco2(String fiid) {
        PreparedStatement pStmt        = null;
        ResultSet rDatos               = null;
        String sSQL                    = "";
        String valor                   = "";

        sSQL = "SELECT numero_prosa, TRIM(descripcion) From PMADMIN.PRSA_ENTIDADES Where numero_prosa IN (" + fiid + ")";
        try {
            obtieneConexion();

            // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
            pStmt = conexion.prepareStatement(sSQL);
            rDatos = pStmt.executeQuery();

            // BARRE LOS REGISTROS OBTENIDOS
            while(rDatos.next()){
                valor = rDatos.getString(1) + " " + rDatos.getString(2);
            }
            pStmt.close();
            rDatos.close();
        } catch(Exception e ) {
            System.out.println(" Error al obtener NombreBanco2:" + e);
            System.out.println(",");
        } finally{
            cierraConexion();
        }

        return valor;
    }

    // OBTIENE EL NOMBRE DE UNA MARCA
    public String nombreMarca(String clave) {
        PreparedStatement pStmt        = null;
        ResultSet rDatos               = null;
        String sSQL                    = "";
        String valor                   = "";

        sSQL = "SELECT TRIM(descripcion) From PMADMIN.PRSA_MARCA Where marca LIKE ?";
        try {
            obtieneConexion();

            // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
            pStmt = conexion.prepareStatement(sSQL);
            pStmt.setString(1, clave);
            rDatos = pStmt.executeQuery();

            // BARRE LOS REGISTROS OBTENIDOS
            while(rDatos.next()){
                valor = rDatos.getString(1);
            }
            pStmt.close();
            rDatos.close();
        } catch(Exception e ) {
            System.out.println(" Error al obtener NombreMarca:" + e);
            System.out.println(",");
        } finally{
            cierraConexion();
        }

        return valor;
    }

    // OBTIENE LA ENTIDAD DE UN BANCO
    public String entidadBanco(String clave) {
        PreparedStatement pStmt        = null;
        ResultSet rDatos               = null;
        String sSQL                    = "";
        String valor                   = "";

        sSQL = "SELECT numero_prosa FROM PMADMIN.PRSA_ENTIDADES " +
        "WHERE entidad_padre = numero_prosa AND rownum = 1 AND numero_fiid like ?";
        try {
            obtieneConexion();

            // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
            pStmt = conexion.prepareStatement(sSQL);
            pStmt.setString(1, clave);
            rDatos = pStmt.executeQuery();

            // BARRE LOS REGISTROS OBTENIDOS
            while(rDatos.next()){
                valor = rDatos.getString(1);
            }
            pStmt.close();
            rDatos.close();
        } catch(Exception e ) {
            System.out.println(" Error al obtener EntidadBanco:" + e);
            System.out.println(",");
        } finally{
            cierraConexion();
        }

        return valor;
    }

    // OBTIENE EL NOMBRE DE UNA CAMARA
    public String nombreCamara(String clave) {
        PreparedStatement pStmt        = null;
        ResultSet rDatos               = null;
        String sSQL                    = "";
        String valor                   = "";

        sSQL = "SELECT TRIM(descripcion) From PMADMIN.PRSA_CAMARA Where camara LIKE ?";
        try {
            obtieneConexion();

            // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
            pStmt = conexion.prepareStatement(sSQL);
            pStmt.setString(1, clave);
            rDatos = pStmt.executeQuery();

            // BARRE LOS REGISTROS OBTENIDOS
            while(rDatos.next()){
                valor = rDatos.getString(1);
            }
            pStmt.close();
            rDatos.close();
        } catch(Exception e ) {
            System.out.println(" Error al obtener NombreCamara:" + e);
            System.out.println(",");
        } finally{
            cierraConexion();
        }

        return valor;
    }

    // OBTIENE LAS DESCRIPCIONES DE CADA UNA DE LAS MARCAS EN UNA LISTA
    public String descripcionesListaMarcas(String[] lista){
        String valor = "";
        if(lista != null){
            // PROCESA LA LISTA DE VALORES
            for(int i = 0; i < lista.length; i++){
                if(i == 0){
                    valor = nombreMarca(lista[i]);
                }else{
                    valor = valor + "," + nombreMarca(lista[i]);
                }
            }
        }
        return valor;
    }

    // OBTIENE LAS DESCRIPCIONES DE CADA UNA DE LAS MARCAS EN UNA LISTA
    public String descripcionesListaCamaras(String[] lista){
        String valor = "";
        if(lista != null){
            // PROCESA LA LISTA DE VALORES
            for(int i = 0; i < lista.length; i++){
                if(i == 0){
                    valor = nombreCamara(lista[i]);
                }else{
                    valor = valor + "," + nombreCamara(lista[i]);
                }
            }
        }
        return valor;
    }

    // OBTIENE LAS ENTIDADES DE CADA UNO DE LAS FIIDS DE BANCO EN UNA LISTA
    public String entidadesListaBancos(String[] lista){
        String valor = "";
        if(lista != null){
            // PROCESA LA LISTA DE VALORES
            for(int i = 0; i < lista.length; i++){
                if(i == 0){
                    valor = entidadBanco(lista[i]);
                }else{
                    valor = valor + ", " + entidadBanco(lista[i]);
                }
            }
        }
        return valor;
    }

    // CONVIERTE UN ARRAY DE CADENAS A UNA LISTA DE CADENAS SEPARADAS POR COMA, SIN APOSTROFE
    public String listaCadenas(String[] lista){
        String valor = "";
        if(lista != null){
            // PROCESA LA LISTA DE VALORES
            for(int i = 0; i < lista.length; i++){
                if(i == 0){
                    valor = lista[i];
                }else{
                    valor = valor + "," + lista[i];
                }
            }
        }
        return valor;
    }

    // CONVIERTE UN ARRAY DE CADENAS A UNA LISTA DE CADENAS SEPARADAS POR COMA, SIN APOSTROFE
    public String listaCadenas2(String[] lista){
        String valor = "";
        if(lista != null){
            // PROCESA LA LISTA DE VALORES
            for(int i = 0; i < lista.length; i++){
                if(i == 0){
                    valor = "'" + lista[i] + "'";
                }else{
                    valor = valor + ",'" + lista[i] + "'";
                }
            }
        }
        return valor;
    }

    // CONVIERTE UNA CADENA EN UNA LISTA
    public ArrayList convierteCadena(String cadena) {
        ArrayList lista         = new ArrayList();
        String fiid             = null;
        StringTokenizer tokens  = new StringTokenizer(cadena, ",");

        try {

            // BARRE LOS REGISTROS OBTENIDOS
            while(tokens.hasMoreTokens()){
                fiid = tokens.nextToken().replaceAll("'", " ").trim();
                lista.add(fiid);
            }
        } catch (Exception e) {
            System.out.println(" Error al convertir cadena en array:" + e);
            System.out.println(",");
        }

        return lista;
    }

    // LLENA UN BLOQUE DE ELEMENTO PANEL CON EL CONTENIDO DE UNA LISTA, TODOS ENCENDIDOS
    public ArrayList listaAPanelTodos(Collection lista){
        EstructuraListaObj  elemento    = new EstructuraListaObj();
        ArrayList           listado     = new ArrayList();
        PanelObj            panel       = null;
        int                 contador    = 1;
        int                 tambloque   = 5;
        Iterator            it          = lista.iterator();

        try{
            while(it.hasNext()){
                elemento = (EstructuraListaObj) it.next();

                if(contador == 1){
                    panel = new PanelObj();
                    panel.setInd01(elemento.getClave());
                    panel.setCol01(elemento.getDescripcion());
                }
                if(contador == 2){
                    panel.setInd02(elemento.getClave());
                    panel.setCol02(elemento.getDescripcion());
                }
                if(contador == 3){
                    panel.setInd03(elemento.getClave());
                    panel.setCol03(elemento.getDescripcion());
                }
                if(contador == 4){
                    panel.setInd04(elemento.getClave());
                    panel.setCol04(elemento.getDescripcion());
                }
                if(contador == 5){
                    panel.setInd05(elemento.getClave());
                    panel.setCol05(elemento.getDescripcion());
                    listado.add(panel);
                    contador = 0;
                    panel = null;
                }
                contador = contador + 1;
            }

            // INCLUYE EL ULTIMO BLOQUE
            if(panel != null){
                listado.add(panel);
            }
        }catch(Exception ex){
            System.out.println("Error en listaAPanelTodos:" + ex.getMessage());
        }
        return listado;
    }

    // APLICA LA CONSULTA DE SICCMR0060
    public ArrayList consultar0060(CriteriosObj criterios) {
        SICCMRObj       objeto = new SICCMRObj();
        ArrayList       lista  = new ArrayList();
        ArrayList       bancos = convierteCadena(criterios.getBancoAdq());
        Iterator        it     = bancos.iterator();
        String          banco  = null;
System.out.println("Reporte SICCMR0060. Subqueries:");
        // SI LOS BANCOS SELECCIONADOS INCLUYE AL CONSOLIDADO (999999)
        if(bancos.indexOf("999999") > -1){
            // OBTIENE SOLAMENTE EL CONSOLIDADO
            lista.addAll(obtieneConcepto0060(criterios,  1.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios,  1.1, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios,  1.2, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios,  1.3, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios,  2.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios,  2.1, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios,  2.2, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios,  2.3, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios,  3.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios,  3.1, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios,  3.2, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios,  3.3, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios,  4.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios,  4.1, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios,  4.2, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios,  4.3, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios,  5.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios,  6.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios,  7.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios,  8.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios,  9.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios, 10.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios, 11.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios, 12.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios, 13.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios, 14.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios, 14.1, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios, 14.2, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0060(criterios, 14.3, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
        }else{
            // POR CADA BANCO SELECCIONADO
            while(it.hasNext()){
                banco = (String)it.next();
                lista.addAll(obtieneConcepto0060(criterios,  1.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios,  1.1, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios,  1.2, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios,  1.3, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios,  2.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios,  2.1, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios,  2.2, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios,  2.3, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios,  3.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios,  3.1, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios,  3.2, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios,  3.3, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios,  4.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios,  4.1, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios,  4.2, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios,  4.3, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios,  5.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios,  6.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios,  7.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios,  8.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios,  9.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios, 10.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios, 11.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios, 12.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios, 13.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios, 14.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios, 14.1, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios, 14.2, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0060(criterios, 14.3, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
            }
        }

        return lista;
    }


    // OBTIENE LOS DATOS DE UN CONCEPTO 60
    public ArrayList obtieneConcepto0060(CriteriosObj criterios, Double consecutivo, String tabla, String banco) {
        SICCMRObj   objeto  = new SICCMRObj();
        ArrayList       lista   = new ArrayList();
        ArrayList       adqs    = convierteCadena(criterios.getCamaraAdq());
        String          sSQL    = "";
        String          adq     = "";
        Iterator        it2     = adqs.iterator();
        ArrayList       marcas  = convierteCadena("1,2,3,999");
        Iterator        it3     = marcas.iterator();
        String          marca   = "";

        // DEFINE LA CONSULTA A EJECUTAR EN BASE AL CONSECUTIVO
        if(consecutivo == 1.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(TOTAL_IMPORTE),0) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(TOTAL_IMPORTE),0) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Ventas D\u00e9bito (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 1.1){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0)  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0)  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Comisi\u00f3n Cuota Intercambio (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 1.2){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(IVA_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0)  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(IVA_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0)  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TTR_NUMERO = 1 AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Iva Comisi\u00f3n Cuota Intercambio (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 1.3){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), 0 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), 0 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Total Ventas D\u00e9bito (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 2.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(TOTAL_IMPORTE),0)  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(TOTAL_IMPORTE),0)  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Devoluciones D\u00e9bito (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 2.1){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Comisi\u00f3n Cuota Intercambio (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 2.2){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(IVA_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(IVA_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Iva Comisi\u00f3n Cuota Intercambio (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 2.3){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), 0 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), 0 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Total Devoluciones D\u00e9bito (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 3.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(TOTAL_IMPORTE),0) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(TOTAL_IMPORTE),0) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Ventas Cr\u00e9dito (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 3.1){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0)  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0)  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Comisi\u00f3n Cuota Intercambio (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 3.2){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(IVA_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0)  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(IVA_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0)  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Iva Comisi\u00f3n Cuota Intercambio (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 3.3){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), 0 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), 0 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Total Ventas Cr\u00e9dito (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 4.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(TOTAL_IMPORTE),0)  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(TOTAL_IMPORTE),0)  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Devoluciones Cr\u00e9dito (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 4.1){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Comisi\u00f3n Cuota Intercambio (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 4.2){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(IVA_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(IVA_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Iva Comisi\u00f3n Cuota Intercambio (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 4.3){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), 0 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), 0 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Total Devoluciones Cr\u00e9dito (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 5.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0))  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 20 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " " ;
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0))  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                             "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND TTR_NUMERO = 20 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Pagos Cr\u00e9dito (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 6.0){
            SICCMRObj objeto2 = null;
            String sSQL2 = "";

            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), " +
                                "SUM(CASE " +
                                "WHEN TTR_NUMERO IN (10) AND trim(NOMBRE_ARCHIVO) = 'CZDCS025_112_A' THEN TOTAL_IMPORTE " +
                                "WHEN TTR_NUMERO IN (11) AND trim(NOMBRE_ARCHIVO) <> 'CZDCS035' THEN abs(TOTAL_IMPORTE) " +
                                "WHEN TTR_NUMERO IN (10) AND trim(NOMBRE_ARCHIVO) <> 'CZDCS025_112_A' THEN abs(TOTAL_IMPORTE)*-1 " +
                                "ELSE -TOTAL_IMPORTE " +
                                "END) * -1 TOTAL_IMPORTE, " +
                                "SUM(CASE " +
                                "WHEN TTR_NUMERO IN (10) AND trim(NOMBRE_ARCHIVO) = 'CZDCS025_112_A' THEN TOTAL_IMPORTE " +
                                "WHEN TTR_NUMERO IN (11) AND trim(NOMBRE_ARCHIVO) <> 'CZDCS035' THEN abs(TOTAL_IMPORTE) " +
                                "WHEN TTR_NUMERO IN (10) AND trim(NOMBRE_ARCHIVO) <> 'CZDCS025_112_A' THEN abs(TOTAL_IMPORTE)*-1 " +
                                "ELSE -TOTAL_IMPORTE " +
                                "END) TOTAL_IMPORTE2 " +
                              "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C, PMADMIN.PRSA_ENTIDADES D " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI AND D.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ " +
                              "AND TTR_NUMERO IN (10,11) AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) " +
                              "AND TLI_NUMERO IN (3) AND trim(NOMBRE_ARCHIVO) not in ('MISC (A FAVOR)','MISC (EN CONTRA)','CZDCS030','CZDCS025_112_A') " +
                              "AND (CAMARA_EMI = " + adq + " OR CAMARA_ADQ = " + adq + ") AND MARCA = " + marca + " " ;
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), " +
                                "SUM(CASE " +
                                "WHEN TTR_NUMERO IN (10) AND trim(NOMBRE_ARCHIVO) = 'CZDCS025_112_A' THEN TOTAL_IMPORTE " +
                                "WHEN TTR_NUMERO IN (11) AND trim(NOMBRE_ARCHIVO) <> 'CZDCS035' THEN abs(TOTAL_IMPORTE) " +
                                "WHEN TTR_NUMERO IN (10) AND trim(NOMBRE_ARCHIVO) <> 'CZDCS025_112_A' THEN abs(TOTAL_IMPORTE)*-1 " +
                                "ELSE -TOTAL_IMPORTE " +
                                "END) * -1 TOTAL_IMPORTE, " +
                                "SUM(CASE " +
                                "WHEN TTR_NUMERO IN (10) AND trim(NOMBRE_ARCHIVO) = 'CZDCS025_112_A' THEN TOTAL_IMPORTE " +
                                "WHEN TTR_NUMERO IN (11) AND trim(NOMBRE_ARCHIVO) <> 'CZDCS035' THEN abs(TOTAL_IMPORTE) " +
                                "WHEN TTR_NUMERO IN (10) AND trim(NOMBRE_ARCHIVO) <> 'CZDCS025_112_A' THEN abs(TOTAL_IMPORTE)*-1 " +
                                "ELSE -TOTAL_IMPORTE " +
                                "END) TOTAL_IMPORTE2 " +
                              "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C, PMADMIN.PRSA_ENTIDADES D " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI AND D.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ AND (C.ENTIDAD_PADRE = " + banco + " or D.ENTIDAD_PADRE = " + banco + ") " +
                              "AND TTR_NUMERO IN (10,11) AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) " +
                              "AND TLI_NUMERO IN (3) AND trim(NOMBRE_ARCHIVO) not in ('MISC (A FAVOR)','MISC (EN CONTRA)','CZDCS030','CZDCS025_112_A') " +
                              "AND (CAMARA_EMI = " + adq + " OR CAMARA_ADQ = " + adq + ") AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
//                    sSQL = sSQL + " GROUP BY CAMARA_EMI";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Miscel\u00e1neos A Favor (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 7.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), " +
                                "SUM(CASE " +
                                "WHEN TTR_NUMERO IN (11) AND trim(NOMBRE_ARCHIVO) <> 'CZDCS035' THEN abs(TOTAL_IMPORTE) " +
                                "ELSE -TOTAL_IMPORTE " +
                                "END) TOTAL_IMPORTE,  " +
                                "SUM(CASE " +
                                "WHEN TTR_NUMERO IN (11) AND trim(NOMBRE_ARCHIVO) <> 'CZDCS035' THEN abs(TOTAL_IMPORTE) " +
                                "ELSE -TOTAL_IMPORTE " +
                                "END)*-1 TOTAL_IMPORTE2  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO IN (10,11) AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TLI_NUMERO IN (3) " +
                              "AND trim(NOMBRE_ARCHIVO) in ('CZDCS025_112_A') " +
                              "AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " " ;
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), " +
                                "SUM(CASE " +
                                "WHEN TTR_NUMERO IN (11) AND trim(NOMBRE_ARCHIVO) <> 'CZDCS035' THEN abs(TOTAL_IMPORTE) " +
                                "ELSE -TOTAL_IMPORTE " +
                                "END) TOTAL_IMPORTE,  " +
                                "SUM(CASE " +
                                "WHEN TTR_NUMERO IN (11) AND trim(NOMBRE_ARCHIVO) <> 'CZDCS035' THEN abs(TOTAL_IMPORTE) " +
                                "ELSE -TOTAL_IMPORTE " +
                                "END)*-1 TOTAL_IMPORTE2  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                             "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO IN (10,11) AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TLI_NUMERO IN (3) " +
                             "AND trim(NOMBRE_ARCHIVO) in ('CZDCS025_112_A') " +
                             "AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " " ;
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Miscel\u00e1neos En Contra (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 8.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 15 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TLI_NUMERO IN (3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO = 15 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TLI_NUMERO IN (3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_EMI";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "1\\B0 Contracargo Ventas (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 9.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0))  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 16 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TLI_NUMERO IN (3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0))  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO = 16 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TLI_NUMERO IN (3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_EMI";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "1\\B0 Contracargo Devoluciones (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 10.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 17 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TLI_NUMERO IN (3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO = 17 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TLI_NUMERO IN (3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_EMI";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "1\\B0 Contracargo Pagos (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 11.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 9 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND TTR_NUMERO = 9 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TLI_NUMERO IN (3) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Representaci\u00f3n Ventas (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 12.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 18 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TLI_NUMERO IN (3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO = 18 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TLI_NUMERO IN (3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_EMI";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "2\\B0 Contracargo Ventas (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo ==13.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0))  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 19 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TLI_NUMERO IN (3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0))  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO = 19 AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND TLI_NUMERO IN (3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_EMI";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "2\\B0 Contracargo Devoluciones (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 14.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(TRX),0), NVL(SUM(IMP1),0), NVL(SUM(IMP2),0)*-1 FROM (" +
                              "SELECT SUM(NUMERO_TRANSACCIONES) TRX, SUM(TOTAL_IMPORTE) IMP1, SUM(TOTAL_IMPORTE) IMP2  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND (TTR_NUMERO IN (1,9,15,17,18) AND STTR_NUMERO IN (120,322)) AND TLI_NUMERO IN (2,3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " " +
                              "UNION ALL " +
                              "SELECT SUM(NUMERO_TRANSACCIONES) TRX, SUM(TOTAL_IMPORTE)*-1 IMP1, SUM(TOTAL_IMPORTE)*-1 IMP2  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND (TTR_NUMERO IN (16,19,20,21) AND STTR_NUMERO IN (281,321)) AND TLI_NUMERO IN (2,3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " " +
                              ")";
                    }else{
                        sSQL ="SELECT NVL(SUM(TRX),0), NVL(SUM(IMP1),0), NVL(SUM(IMP2),0)*-1 FROM (" +
                              "SELECT SUM(NUMERO_TRANSACCIONES) TRX, SUM(TOTAL_IMPORTE) IMP1, SUM(TOTAL_IMPORTE) IMP2  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND (TTR_NUMERO IN (1,9,15,17,18) AND STTR_NUMERO IN (120,322)) AND TLI_NUMERO IN (2,3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " " +
                              "UNION ALL " +
                              "SELECT SUM(NUMERO_TRANSACCIONES) TRX, SUM(TOTAL_IMPORTE)*-1 IMP1, SUM(TOTAL_IMPORTE)*-1 IMP2  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND (TTR_NUMERO IN (16,19,20,21) AND STTR_NUMERO IN (281,321)) AND TLI_NUMERO IN (2,3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " " +
                              ")";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if((objeto != null)){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Rechazo de Sintaxis (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 14.1){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(IMP1),0), NVL(SUM(IMP2),0) FROM (" +
                              "SELECT SUM(IMPORTE_COMISION_INTERCAMB) IMP1, SUM(IMPORTE_COMISION_INTERCAMB) IMP2  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND (TTR_NUMERO IN (1,9,15,17,18) AND STTR_NUMERO IN (120,322)) AND TLI_NUMERO IN (2,3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " " +
                              "UNION ALL " +
                              "SELECT SUM(IMPORTE_COMISION_INTERCAMB)*-1 IMP1, SUM(IMPORTE_COMISION_INTERCAMB)*-1 IMP2  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND (TTR_NUMERO IN (16,19,20,21) AND STTR_NUMERO IN (281,321)) AND TLI_NUMERO IN (2,3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " " +
                              ")";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(IMP1),0), NVL(SUM(IMP2),0) FROM (" +
                              "SELECT SUM(IMPORTE_COMISION_INTERCAMB) IMP1, SUM(IMPORTE_COMISION_INTERCAMB) IMP2  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND (TTR_NUMERO IN (1,9,15,17,18) AND STTR_NUMERO IN (120,322)) AND TLI_NUMERO IN (2,3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " " +
                              "UNION ALL " +
                              "SELECT SUM(IMPORTE_COMISION_INTERCAMB)*-1 IMP1, SUM(IMPORTE_COMISION_INTERCAMB)*-1 IMP2  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND (TTR_NUMERO IN (16,19,20,21) AND STTR_NUMERO IN (281,321)) AND TLI_NUMERO IN (2,3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " " +
                              ")";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if((objeto != null)){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Comisi\u00f3n Cuota Intercambio (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 14.2){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(IMP1),0), NVL(SUM(IMP2),0) FROM (" +
                              "SELECT SUM(IVA_COMISION_INTERCAMB) IMP1, SUM(IVA_COMISION_INTERCAMB) IMP2  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND (TTR_NUMERO IN (1,9,15,17,18) AND STTR_NUMERO IN (120,322)) AND TLI_NUMERO IN (2,3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " " +
                              "UNION ALL " +
                              "SELECT SUM(IVA_COMISION_INTERCAMB)*-1 IMP1, SUM(IVA_COMISION_INTERCAMB)*-1 IMP2  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND (TTR_NUMERO IN (16,19,20,21) AND STTR_NUMERO IN (281,321)) AND TLI_NUMERO IN (2,3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " " +
                              ")";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(IMP1),0), NVL(SUM(IMP2),0) FROM (" +
                              "SELECT SUM(IVA_COMISION_INTERCAMB) IMP1, SUM(IVA_COMISION_INTERCAMB) IMP2  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND (TTR_NUMERO IN (1,9,15,17,18) AND STTR_NUMERO IN (120,322)) AND TLI_NUMERO IN (2,3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " " +
                              "UNION ALL " +
                              "SELECT SUM(IVA_COMISION_INTERCAMB)*-1 IMP1, SUM(IVA_COMISION_INTERCAMB)*-1 IMP2  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND (TTR_NUMERO IN (16,19,20,21) AND STTR_NUMERO IN (281,321)) AND TLI_NUMERO IN (2,3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " " +
                              ")";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if((objeto != null)){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Iva Comisi\u00f3n Cuota Intercambio (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 14.3){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(IMP1),0), 0 FROM (" +
                              "SELECT -(SUM(TOTAL_IMPORTE) - SUM(IMPORTE_COMISION_INTERCAMB) - SUM(IVA_COMISION_INTERCAMB)) IMP1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND (TTR_NUMERO IN (1,9,15,17,18) AND STTR_NUMERO IN (120,322)) AND TLI_NUMERO IN (2,3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " " +
                              "UNION ALL " +
                              "SELECT (SUM(TOTAL_IMPORTE) - SUM(IMPORTE_COMISION_INTERCAMB) - SUM(IVA_COMISION_INTERCAMB)) IMP1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND (TTR_NUMERO IN (16,19,20,21) AND STTR_NUMERO IN (281,321)) AND TLI_NUMERO IN (2,3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " " +
                              ")";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(IMP1),0), 0 FROM (" +
                              "SELECT -(SUM(TOTAL_IMPORTE) - SUM(IMPORTE_COMISION_INTERCAMB) - SUM(IVA_COMISION_INTERCAMB)) IMP1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND (TTR_NUMERO IN (1,9,15,17,18) AND STTR_NUMERO IN (120,322)) AND TLI_NUMERO IN (2,3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " " +
                              "UNION ALL " +
                              "SELECT (SUM(TOTAL_IMPORTE) - SUM(IMPORTE_COMISION_INTERCAMB) - SUM(IVA_COMISION_INTERCAMB)) IMP1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND (TTR_NUMERO IN (16,19,20,21) AND STTR_NUMERO IN (281,321)) AND TLI_NUMERO IN (2,3) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " " +
                              ")";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if((objeto != null)){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Total Rechazo de Sintaxis (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }

        return lista;
    }

    // APLICA OBTIENE LOS DATOS DE UN CONCEPTO
    public SICCMRObj aplicaConsulta(String consulta) {
        SICCMRObj   objeto  = null;
        String      valor1  = null;
        String      valor2  = null;
        String      valor3  = null;
System.out.println(consulta);
        try{
            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt = conexion.prepareStatement(consulta);
                rDatos = pStmt.executeQuery();

                while(rDatos.next()){
                    objeto  = new SICCMRObj();
                    valor1 = rDatos.getString(1);
                    valor2 = rDatos.getString(2);
                    valor3 = rDatos.getString(3);
                    if(valor1 == null){ valor1 = "0";}
                    if(valor2 == null){ valor2 = "0.0";}
                    if(valor3 == null){ valor3 = "0.0";}
                    objeto.setTrx(          new Integer(valor1));
                    objeto.setImporte(      new Double(valor2));
                    objeto.setImporte2(     new Double(valor3));
                }
                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al consultar [" + consulta + "], " + e.toString());
                e.printStackTrace();
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

        return objeto;
    }

    // APLICA OBTIENE EL IMPORTE DE UN CONCEPTO
    public SICCMRObj aplicaConsulta2(String consulta) {
        SICCMRObj   objeto  = null;
        String      valor1  = null;
        String      valor2  = null;
        String      valor3  = null;
System.out.println(consulta);
        try{
            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt = conexion.prepareStatement(consulta);
                rDatos = pStmt.executeQuery();

                while(rDatos.next()){
                    objeto  = new SICCMRObj();
                    valor1 = rDatos.getString(1);
                    valor2 = rDatos.getString(2);
                    valor3 = rDatos.getString(3);
                    if(valor1 == null){ valor1 = "0";}
                    if(valor3 == null){ valor3 = "0.0";}
                    objeto.setEntidad(      new Integer(valor1));
                    objeto.setNombreBanco(  valor2);
                    objeto.setImporte(      new Double(valor3));
                }
                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al consultar [" + consulta + "], " + e.toString());
                e.printStackTrace();
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

        return objeto;
    }

    // APLICA LA CONSULTA DE SICCMR0050
    public ArrayList consultar0050(CriteriosObj criterios) {
        SICCMRObj       objeto = new SICCMRObj();
        ArrayList       lista  = new ArrayList();
        ArrayList       bancos = convierteCadena(criterios.getBancoEmi());
        Iterator        it     = bancos.iterator();
        String          banco  = null;
System.out.println("Reporte SICCMR0050. Subqueries:");
        // SI LOS BANCOS SELECCIONADOS INCLUYE AL CONSOLIDADO (999999)
        if(bancos.indexOf("999999") > -1){
            // OBTIENE SOLAMENTE EL CONSOLIDADO
            lista.addAll(obtieneConcepto0050(criterios,  1.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios,  1.1, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios,  1.2, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios,  1.3, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios,  2.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios,  2.1, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios,  2.2, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios,  2.3, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios,  3.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios,  3.1, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios,  3.2, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios,  3.3, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios,  4.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios,  4.1, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios,  4.2, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios,  4.3, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios,  5.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios,  6.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios,  7.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios,  8.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios,  9.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios, 10.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios, 11.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios, 12.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios, 13.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios, 14.0, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios, 14.1, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios, 14.2, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
            lista.addAll(obtieneConcepto0050(criterios, 14.3, "PMADMIN.PRSA_MARCA_POSICIONES", "%"));
        }else{
            // POR CADA BANCO SELECCIONADO
            while(it.hasNext()){
                banco = (String)it.next();
                lista.addAll(obtieneConcepto0050(criterios,  1.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios,  1.1, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios,  1.2, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios,  1.3, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios,  2.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios,  2.1, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios,  2.2, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios,  2.3, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios,  3.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios,  3.1, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios,  3.2, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios,  3.3, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios,  4.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios,  4.1, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios,  4.2, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios,  4.3, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios,  5.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios,  6.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios,  7.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios,  8.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios,  9.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios, 10.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios, 11.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios, 12.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios, 13.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios, 14.0, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios, 14.1, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios, 14.2, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
                lista.addAll(obtieneConcepto0050(criterios, 14.3, "PMADMIN.PRSA_MARCA_POSICIONES", banco));
            }
        }

        return lista;
    }


    // OBTIENE LOS DATOS DE UN CONCEPTO 50
    public ArrayList obtieneConcepto0050(CriteriosObj criterios, Double consecutivo, String tabla, String banco) {
        SICCMRObj   objeto  = new SICCMRObj();
        ArrayList       lista   = new ArrayList();
        ArrayList       adqs    = convierteCadena(criterios.getCamaraEmi());
        String          sSQL    = "";
        String          adq     = "";
        Iterator        it2     = adqs.iterator();
        ArrayList       marcas  = convierteCadena("1, 2, 3, 999");
        Iterator        it3     = marcas.iterator();
        String          marca   = "";

        // DEFINE LA CONSULTA A EJECUTAR EN BASE AL CONSECUTIVO
        if(consecutivo == 1.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(TOTAL_IMPORTE),0) " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(TOTAL_IMPORTE),0) " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Ventas D\u00e9bito (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 1.1){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Comisi\u00f3n Cuota Intercambio (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 1.2){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(IVA_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(IVA_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Iva Comisi\u00f3n Cuota Intercambio (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 1.3){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), 0 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), 0 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Total Ventas D\u00e9bito (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 2.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(TOTAL_IMPORTE),0) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(TOTAL_IMPORTE),0) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = null;
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Devoluciones D\u00e9bito (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 2.1){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = null;
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Comisi\u00f3n Cuota Intercambio (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 2.2){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(IVA_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(IVA_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = null;
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Iva Comisi\u00f3n Cuota Intercambio (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 2.3){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), 0 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), 0 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = null;
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Total Devoluciones D\u00e9bito (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 3.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(TOTAL_IMPORTE),0) " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(TOTAL_IMPORTE),0) " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Ventas Cr\u00e9dito (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 3.1){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Comisi\u00f3n Cuota Intercambio (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 3.2){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(IVA_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(IVA_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Iva Comisi\u00f3n Cuota Intercambio (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 3.3){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), 0 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), 0 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO = 1 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Total Ventas Cr\u00e9dito (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 4.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(TOTAL_IMPORTE),0) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(TOTAL_IMPORTE),0) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Devoluciones Cr\u00e9dito (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 4.1){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Comisi\u00f3n Cuota Intercambio (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 4.2){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(IVA_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(IVA_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Iva Comisi\u00f3n Cuota Intercambio (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 4.3){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), 0 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT -1, NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), 0 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO = 21 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Total Devoluciones Cr\u00e9dito (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 5.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 20 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                             "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO = 20 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Pagos Cr\u00e9dito (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 6.0){
            SICCMRObj objeto2 = null;
            String sSQL2 = "";

            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) * -1, (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 11 AND NVL(STTR_NUMERO,0) NOT IN (100,321,322) AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) * -1, (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                             "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO = 11 AND NVL(STTR_NUMERO,0) NOT IN (100,321,322) AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Miscel\u00e1neos A Favor (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 7.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 10 AND NVL(STTR_NUMERO,0) NOT IN (100,321,322) AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                             "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO = 10 AND NVL(STTR_NUMERO,0) NOT IN (100,321,322) AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Miscel\u00e1neos En Contra (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 8.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 15 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TLI_NUMERO IN (2) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND TTR_NUMERO = 15 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TLI_NUMERO IN (2) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "1\\B0 Contracargo Ventas (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 9.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 16 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TLI_NUMERO IN (2) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND TTR_NUMERO = 16 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TLI_NUMERO IN (2) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "1\\B0 Contracargo Devoluciones (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 10.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 17 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TLI_NUMERO IN (2) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND TTR_NUMERO = 17 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TLI_NUMERO IN (2) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "1\\B0 Contracargo Pagos (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 11.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 9 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_EMI = " + banco + " AND TTR_NUMERO = 9 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Representaci\u00f3n Ventas (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 12.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 18 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TLI_NUMERO IN (2) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND TTR_NUMERO = 18 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TLI_NUMERO IN (2) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "2\\B0 Contracargo Ventas (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo ==13.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND TTR_NUMERO = 19 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TLI_NUMERO IN (2) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " ";
                    }else{
                        sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0), (NVL(SUM(TOTAL_IMPORTE),0) - NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) - NVL(SUM(IVA_COMISION_INTERCAMB),0)) * -1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND TTR_NUMERO = 19 AND NVL(STTR_NUMERO,0) NOT IN (321,322) AND TLI_NUMERO IN (2) AND CAMARA_EMI = " + adq + " AND MARCA = " + marca + " ";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    sSQL = sSQL + " GROUP BY CAMARA_ADQ";
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if(objeto != null){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "2\\B0 Contracargo Devoluciones (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 14.0){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT NVL(SUM(TRX),0), NVL(ABS(SUM(IMP1)),0), NVL(SUM(IMP2),0) * -1 FROM (" +
                              "SELECT SUM(NUMERO_TRANSACCIONES) TRX, DECODE(TTR_NUMERO, 21, SUM(TOTAL_IMPORTE), 20, SUM(TOTAL_IMPORTE), SUM(TOTAL_IMPORTE))      IMP1, " +
                                                                    "DECODE(TTR_NUMERO, 21, SUM(TOTAL_IMPORTE), 20, SUM(TOTAL_IMPORTE), SUM(TOTAL_IMPORTE) * -1) IMP2 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND (TTR_NUMERO IN (1,9,15,17,18) AND STTR_NUMERO IN (321)) AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " GROUP BY TTR_NUMERO " +
                              "UNION ALL " +
                              "SELECT SUM(NUMERO_TRANSACCIONES) TRX, DECODE(TTR_NUMERO, 21, SUM(TOTAL_IMPORTE), 20, SUM(TOTAL_IMPORTE), SUM(TOTAL_IMPORTE))      IMP1, " +
                                                                    "DECODE(TTR_NUMERO, 21, SUM(TOTAL_IMPORTE), 20, SUM(TOTAL_IMPORTE), SUM(TOTAL_IMPORTE) * -1) IMP2 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND (TTR_NUMERO IN (16,19,20,21) AND STTR_NUMERO IN (322)) AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " GROUP BY TTR_NUMERO " +
                              ")";
                    }else{
                        sSQL ="SELECT NVL(SUM(TRX),0), NVL(ABS(SUM(IMP1)),0), NVL(SUM(IMP2),0) * -1 FROM (" +
                              "SELECT SUM(NUMERO_TRANSACCIONES) TRX, DECODE(TTR_NUMERO, 21, SUM(TOTAL_IMPORTE), 20, SUM(TOTAL_IMPORTE), SUM(TOTAL_IMPORTE))      IMP1, " +
                                                                    "DECODE(TTR_NUMERO, 21, SUM(TOTAL_IMPORTE), 20, SUM(TOTAL_IMPORTE), SUM(TOTAL_IMPORTE) * -1) IMP2 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND (TTR_NUMERO IN (1,9,15,17,18) AND STTR_NUMERO IN (321)) AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " GROUP BY TTR_NUMERO " +
                              "UNION ALL " +
                              "SELECT SUM(NUMERO_TRANSACCIONES) TRX, DECODE(TTR_NUMERO, 21, SUM(TOTAL_IMPORTE), 20, SUM(TOTAL_IMPORTE), SUM(TOTAL_IMPORTE))      IMP1, " +
                                                                    "DECODE(TTR_NUMERO, 21, SUM(TOTAL_IMPORTE), 20, SUM(TOTAL_IMPORTE), SUM(TOTAL_IMPORTE) * -1) IMP2 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND (TTR_NUMERO IN (16,19,20,21) AND STTR_NUMERO IN (322)) AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " GROUP BY TTR_NUMERO " +
                              ")";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if((objeto != null)){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Rechazo de Sintaxis (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 14.1){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(ABS(SUM(IMP1)),0), NVL(SUM(IMP2),0) * -1 FROM (" +
                              "SELECT DECODE(TTR_NUMERO, 21, SUM(IMPORTE_COMISION_INTERCAMB)*-1, 20, SUM(IMPORTE_COMISION_INTERCAMB)*-1, SUM(IMPORTE_COMISION_INTERCAMB)) IMP1, " +
                                     "DECODE(TTR_NUMERO, 21, SUM(IMPORTE_COMISION_INTERCAMB)*-1, 20, SUM(IMPORTE_COMISION_INTERCAMB)*-1, SUM(IMPORTE_COMISION_INTERCAMB)) IMP2  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND (TTR_NUMERO IN (1,9,15,17,18) AND STTR_NUMERO IN (321)) AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " GROUP BY TTR_NUMERO " +
                              "UNION ALL " +
                              "SELECT DECODE(TTR_NUMERO, 21, SUM(IMPORTE_COMISION_INTERCAMB)*-1, 20, SUM(IMPORTE_COMISION_INTERCAMB)*-1, SUM(IMPORTE_COMISION_INTERCAMB)) IMP1, " +
                                     "DECODE(TTR_NUMERO, 21, SUM(IMPORTE_COMISION_INTERCAMB)*-1, 20, SUM(IMPORTE_COMISION_INTERCAMB)*-1, SUM(IMPORTE_COMISION_INTERCAMB)) IMP2  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND (TTR_NUMERO IN (16,19,20,21) AND STTR_NUMERO IN (322)) AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " GROUP BY TTR_NUMERO " +
                              ")";
                    }else{
                        sSQL ="SELECT -1, NVL(ABS(SUM(IMP1)),0), NVL(SUM(IMP2),0) * -1 FROM (" +
                              "SELECT DECODE(TTR_NUMERO, 21, SUM(IMPORTE_COMISION_INTERCAMB)*-1, 20, SUM(IMPORTE_COMISION_INTERCAMB)*-1, SUM(IMPORTE_COMISION_INTERCAMB)) IMP1, " +
                                     "DECODE(TTR_NUMERO, 21, SUM(IMPORTE_COMISION_INTERCAMB)*-1, 20, SUM(IMPORTE_COMISION_INTERCAMB)*-1, SUM(IMPORTE_COMISION_INTERCAMB)) IMP2  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND (TTR_NUMERO IN (1,9,15,17,18) AND STTR_NUMERO IN (321)) AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " GROUP BY TTR_NUMERO " +
                              "UNION ALL " +
                              "SELECT DECODE(TTR_NUMERO, 21, SUM(IMPORTE_COMISION_INTERCAMB)*-1, 20, SUM(IMPORTE_COMISION_INTERCAMB)*-1, SUM(IMPORTE_COMISION_INTERCAMB)) IMP1, " +
                                     "DECODE(TTR_NUMERO, 21, SUM(IMPORTE_COMISION_INTERCAMB)*-1, 20, SUM(IMPORTE_COMISION_INTERCAMB)*-1, SUM(IMPORTE_COMISION_INTERCAMB)) IMP2  " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND (TTR_NUMERO IN (16,19,20,21) AND STTR_NUMERO IN (322)) AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " GROUP BY TTR_NUMERO " +
                              ")";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if((objeto != null)){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Comisi\u00f3n Cuota Intercambio (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 14.2){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(ABS(SUM(IMP1)),0), NVL(SUM(IMP2),0) * -1 FROM (" +
                              "SELECT DECODE(TTR_NUMERO, 21, SUM(IVA_COMISION_INTERCAMB)*-1, 20, SUM(IVA_COMISION_INTERCAMB)*-1, SUM(IVA_COMISION_INTERCAMB)) IMP1, " +
                                     "DECODE(TTR_NUMERO, 21, SUM(IVA_COMISION_INTERCAMB)*-1, 20, SUM(IVA_COMISION_INTERCAMB)*-1, SUM(IVA_COMISION_INTERCAMB)) IMP2 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND (TTR_NUMERO IN (1,9,15,17,18) AND STTR_NUMERO IN (321)) AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " GROUP BY TTR_NUMERO " +
                              "UNION ALL " +
                              "SELECT DECODE(TTR_NUMERO, 21, SUM(IVA_COMISION_INTERCAMB)*-1, 20, SUM(IVA_COMISION_INTERCAMB)*-1, SUM(IVA_COMISION_INTERCAMB)) IMP1, " +
                                     "DECODE(TTR_NUMERO, 21, SUM(IVA_COMISION_INTERCAMB)*-1, 20, SUM(IVA_COMISION_INTERCAMB)*-1, SUM(IVA_COMISION_INTERCAMB)) IMP2 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND (TTR_NUMERO IN (16,19,20,21) AND STTR_NUMERO IN (322)) AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " GROUP BY TTR_NUMERO " +
                              ")";
                    }else{
                        sSQL ="SELECT -1, NVL(ABS(SUM(IMP1)),0), NVL(SUM(IMP2),0) * -1 FROM (" +
                              "SELECT DECODE(TTR_NUMERO, 21, SUM(IVA_COMISION_INTERCAMB)*-1, 20, SUM(IVA_COMISION_INTERCAMB)*-1, SUM(IVA_COMISION_INTERCAMB)) IMP1, " +
                                     "DECODE(TTR_NUMERO, 21, SUM(IVA_COMISION_INTERCAMB)*-1, 20, SUM(IVA_COMISION_INTERCAMB)*-1, SUM(IVA_COMISION_INTERCAMB)) IMP2 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND (TTR_NUMERO IN (1,9,15,17,18) AND STTR_NUMERO IN (321)) AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " GROUP BY TTR_NUMERO " +
                              "UNION ALL " +
                              "SELECT DECODE(TTR_NUMERO, 21, SUM(IVA_COMISION_INTERCAMB)*-1, 20, SUM(IVA_COMISION_INTERCAMB)*-1, SUM(IVA_COMISION_INTERCAMB)) IMP1, " +
                                     "DECODE(TTR_NUMERO, 21, SUM(IVA_COMISION_INTERCAMB)*-1, 20, SUM(IVA_COMISION_INTERCAMB)*-1, SUM(IVA_COMISION_INTERCAMB)) IMP2 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND (TTR_NUMERO IN (16,19,20,21) AND STTR_NUMERO IN (322)) AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " GROUP BY TTR_NUMERO " +
                              ")";
                    }


                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if((objeto != null)){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Iva Comisi\u00f3n Cuota Intercambio (-)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }else if(consecutivo == 14.3){
            while(it3.hasNext()){
                marca = (String)it3.next();
                it2     = adqs.iterator();
                while(it2.hasNext()){
                    adq = (String)it2.next();
                    if(banco.compareTo("%") == 0){
                        sSQL ="SELECT -1, NVL(ABS(SUM(IMP1)),0), 0 FROM (" +
                              "SELECT DECODE(TTR_NUMERO, 21, (SUM(TOTAL_IMPORTE) - SUM(IMPORTE_COMISION_INTERCAMB) - SUM(IVA_COMISION_INTERCAMB))*-1, " +
                                                        "20, (SUM(TOTAL_IMPORTE) - SUM(IMPORTE_COMISION_INTERCAMB) - SUM(IVA_COMISION_INTERCAMB))*-1, " +
                                                            "(SUM(TOTAL_IMPORTE) - SUM(IMPORTE_COMISION_INTERCAMB) - SUM(IVA_COMISION_INTERCAMB))) IMP1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND (TTR_NUMERO IN (1,9,15,17,18) AND STTR_NUMERO IN (321)) AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " GROUP BY TTR_NUMERO " +
                              "UNION ALL " +
                              "SELECT DECODE(TTR_NUMERO, 21, (SUM(TOTAL_IMPORTE) - SUM(IMPORTE_COMISION_INTERCAMB) - SUM(IVA_COMISION_INTERCAMB))*-1, " +
                                                        "20, (SUM(TOTAL_IMPORTE) - SUM(IMPORTE_COMISION_INTERCAMB) - SUM(IVA_COMISION_INTERCAMB))*-1, " +
                                                            "(SUM(TOTAL_IMPORTE) - SUM(IMPORTE_COMISION_INTERCAMB) - SUM(IVA_COMISION_INTERCAMB))) IMP1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND (TTR_NUMERO IN (16,19,20,21) AND STTR_NUMERO IN (322)) AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " GROUP BY TTR_NUMERO " +
                              ")";
                    }else{
                        sSQL ="SELECT -1, NVL(ABS(SUM(IMP1)),0), 0 FROM (" +
                              "SELECT DECODE(TTR_NUMERO, 21, (SUM(TOTAL_IMPORTE) - SUM(IMPORTE_COMISION_INTERCAMB) - SUM(IVA_COMISION_INTERCAMB))*-1, " +
                                                        "20, (SUM(TOTAL_IMPORTE) - SUM(IMPORTE_COMISION_INTERCAMB) - SUM(IVA_COMISION_INTERCAMB))*-1, " +
                                                            "(SUM(TOTAL_IMPORTE) - SUM(IMPORTE_COMISION_INTERCAMB) - SUM(IVA_COMISION_INTERCAMB))) IMP1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND (TTR_NUMERO IN (1,9,15,17,18) AND STTR_NUMERO IN (321)) AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " GROUP BY TTR_NUMERO " +
                              "UNION ALL " +
                              "SELECT DECODE(TTR_NUMERO, 21, (SUM(TOTAL_IMPORTE) - SUM(IMPORTE_COMISION_INTERCAMB) - SUM(IVA_COMISION_INTERCAMB))*-1, " +
                                                        "20, (SUM(TOTAL_IMPORTE) - SUM(IMPORTE_COMISION_INTERCAMB) - SUM(IVA_COMISION_INTERCAMB))*-1, " +
                                                            "(SUM(TOTAL_IMPORTE) - SUM(IMPORTE_COMISION_INTERCAMB) - SUM(IVA_COMISION_INTERCAMB))) IMP1 " +
                              "FROM " + tabla + " " +
                              "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                              "AND ENT_NUMERO_PROSA_ADQ = " + banco + " AND (TTR_NUMERO IN (16,19,20,21) AND STTR_NUMERO IN (322)) AND TLI_NUMERO IN (2) AND CAMARA_ADQ = " + adq + " AND MARCA = " + marca + " GROUP BY TTR_NUMERO " +
                              ")";
                    }

                    // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
                    objeto = aplicaConsulta(sSQL);

                    // COLOCA LOS DEMAS DATOS DEL ELEMENTO
                    if((objeto != null) ){
                        if(banco.compareTo("%") != 0){
                            objeto.setEntidad(      new Integer(banco));
                            objeto.setNombreBanco(  nombreBanco2(banco));
                        }else{
                            objeto.setNombreBanco(  "CONSOLIDADO");
                        }
                        objeto.setConsecutivo(  consecutivo);
                        objeto.setConcepto(     "Total Rechazo de Sintaxis (+)");
                        objeto.setMarca(        new Integer(marca));
                        objeto.setMarcaDs(      nombreMarca(marca));

                        // AGREGA EL ELEMENTO A LA LISTA
                        lista.add(objeto);
                    }
                }
            }
        }

        return lista;
    }

    // APLICA OBTIENE LOS DATOS DE UN CONCEPTO 200 EMISOR
    public SICCMRObj aplicaConsulta200E(String consulta) {
        SICCMRObj   objeto  = null;
System.out.println(consulta);
        try{
            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt = conexion.prepareStatement(consulta);
                rDatos = pStmt.executeQuery();

                while(rDatos.next()){
                    objeto  = new SICCMRObj();
                    objeto.setTrx(          new Integer(rDatos.getString(1)));
                    objeto.setImporte(      new Double(rDatos.getString(2)));
                    objeto.setComision(     new Double(rDatos.getString(3)));
                    objeto.setIva(          new Double(rDatos.getString(4)));
                }
                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al consultar200E [" + consulta + "], " + e.toString());
                e.printStackTrace();
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

        return objeto;
    }

    // APLICA OBTIENE LOS DATOS DE UN CONCEPTO 200 ADQUIRENTE
    public SICCMRObj aplicaConsulta200A(String consulta) {
        SICCMRObj   objeto  = null;
System.out.println(consulta);
        try{
            obtieneConexion();
            PreparedStatement   pStmt  = null;
            ResultSet           rDatos = null;

            try {
                // PREPARA LA SENTENCIA, PONE LOS PARAMETROS Y LA EJECUTA
                pStmt = conexion.prepareStatement(consulta);
                rDatos = pStmt.executeQuery();

                while(rDatos.next()){
                    objeto  = new SICCMRObj();
                    objeto.setTrx2(          new Integer(rDatos.getString(1)));
                    objeto.setImporte2(      new Double(rDatos.getString(2)));
                    objeto.setComision2(     new Double(rDatos.getString(3)));
                    objeto.setIva2(          new Double(rDatos.getString(4)));
                }
                rDatos.close();
            } catch (Exception e) {
                System.out.println("Error al consultar200A [" + consulta + "], " + e.toString());
                e.printStackTrace();
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

        return objeto;
    }

    // APLICA LA CONSULTA DE SICCMR0200
    public ArrayList consultar0200(CriteriosObj criterios) {
        SICCMRObj       objeto = new SICCMRObj();
        ArrayList       lista  = new ArrayList();
        ArrayList       bancos = convierteCadena(criterios.getBanco());
        Iterator        it     = bancos.iterator();
        String          banco  = null;
System.out.println("Reporte SICCMR0200. Subqueries:");
        // POR CADA BANCO SELECCIONADO
        while(it.hasNext()){
            banco = (String)it.next();
            // OBTIENE LOS CONCEPTOS
            lista.addAll(obtieneConcepto0200(criterios,  1.0, "PMADMIN.PRSA_MARCA_POS_PARCIALES", entidadBanco(banco)));
            lista.addAll(obtieneConcepto0200(criterios,  2.0, "PMADMIN.PRSA_MARCA_POS_PARCIALES", entidadBanco(banco)));
            lista.addAll(obtieneConcepto0200(criterios,  3.0, "PMADMIN.PRSA_MARCA_POS_PARCIALES", entidadBanco(banco)));
            lista.addAll(obtieneConcepto0200(criterios,  4.0, "PMADMIN.PRSA_MARCA_POS_PARCIALES", entidadBanco(banco)));
            lista.addAll(obtieneConcepto0200(criterios,  5.0, "PMADMIN.PRSA_MARCA_POS_PARCIALES", entidadBanco(banco)));
            lista.addAll(obtieneConcepto0200(criterios,  6.0, "PMADMIN.PRSA_MARCA_POS_PARCIALES", entidadBanco(banco)));
            lista.addAll(obtieneConcepto0200(criterios,  7.0, "PMADMIN.PRSA_MARCA_POS_PARCIALES", entidadBanco(banco)));
            lista.addAll(obtieneConcepto0200(criterios,  8.0, "PMADMIN.PRSA_MARCA_POS_PARCIALES", entidadBanco(banco)));
            lista.addAll(obtieneConcepto0200(criterios,  9.0, "PMADMIN.PRSA_MARCA_POSICIONES",    entidadBanco(banco)));
            lista.addAll(obtieneConcepto0200(criterios, 10.0, "PMADMIN.PRSA_MARCA_POSICIONES",    entidadBanco(banco)));
            lista.addAll(obtieneConcepto0200(criterios, 11.0, "PMADMIN.PRSA_MARCA_POS_PARCIALES", entidadBanco(banco)));
            lista.addAll(obtieneConcepto0200(criterios, 12.0, "PMADMIN.PRSA_MARCA_POS_PARCIALES", entidadBanco(banco)));
            lista.addAll(obtieneConcepto0200(criterios, 13.0, "PMADMIN.PRSA_MARCA_POS_PARCIALES", entidadBanco(banco)));
            lista.addAll(obtieneConcepto0200(criterios, 14.0, "PMADMIN.PRSA_MARCA_POS_PARCIALES", entidadBanco(banco)));
            lista.addAll(obtieneConcepto0200(criterios, 15.0, "PMADMIN.PRSA_MARCA_POS_PARCIALES", entidadBanco(banco)));
        }

        return lista;
    }

    // OBTIENE LOS DATOS DE UN CONCEPTO 200
    public ArrayList obtieneConcepto0200(CriteriosObj criterios, Double consecutivo, String tabla, String banco) {
        SICCMRObj       objeto  = new SICCMRObj();
        SICCMRObj       objeto2 = new SICCMRObj();
        SICCMRObj       objeto3 = new SICCMRObj();
        ArrayList       lista   = new ArrayList();
        String          sSQL    = "";
        String          sSQL2   = "";

        // DEFINE LA CONSULTA A EJECUTAR EN BASE AL CONSECUTIVO
        if(consecutivo == 1.0){
            sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), -NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) " +
                  "AND TTR_NUMERO = 1 AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (3) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";
            sSQL2 ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), -NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), -NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND TTR_NUMERO = 1 AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (2) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";

            // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
            objeto2 = aplicaConsulta200E(sSQL);
            objeto3 = aplicaConsulta200A(sSQL2);

            // COLOCA LOS DEMAS DATOS DEL ELEMENTO
            objeto.setEntidad(      new Integer(banco));
            objeto.setNombreBanco(  nombreBanco2(banco));
            objeto.setConsecutivo(  consecutivo);
            objeto.setConcepto(     "Ventas Cr\u00e9dito");
            if(objeto2 != null){
                objeto.setTrx2(      objeto2.getTrx());
                objeto.setImporte2(  objeto2.getImporte());
                objeto.setComision2( objeto2.getComision());
                objeto.setIva2(      objeto2.getIva());
            }
            if(objeto3 != null){
                objeto.setTrx(     objeto3.getTrx2());
                objeto.setImporte( objeto3.getImporte2());
                objeto.setComision(objeto3.getComision2());
                objeto.setIva(     objeto3.getIva2());
            }
            // SE AGREGA EL ELEMENTO SIS E TIENEN DATOS DE EMISOR O ADQUIRENTE
            if((objeto2 != null) || (objeto3 != null) ){
                // AGREGA EL ELEMENTO A LA LISTA
                lista.add(objeto);
            }
        }else if(consecutivo == 2.0){
            sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), -NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) " +
                  "AND TTR_NUMERO = 1 AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (3) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";
            sSQL2 ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), -NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), -NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND TTR_NUMERO = 1 AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (2) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";

            // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
            objeto2 = aplicaConsulta200E(sSQL);
            objeto3 = aplicaConsulta200A(sSQL2);

            objeto.setEntidad(      new Integer(banco));
            objeto.setNombreBanco(  nombreBanco2(banco));
            objeto.setConsecutivo(  consecutivo);
            objeto.setConcepto(     "Ventas D\u00e9bito");
            if(objeto2 != null){
                objeto.setTrx2(      objeto2.getTrx());
                objeto.setImporte2(  objeto2.getImporte());
                objeto.setComision2( objeto2.getComision());
                objeto.setIva2(      objeto2.getIva());
            }
            if(objeto3 != null){
                objeto.setTrx(     objeto3.getTrx2());
                objeto.setImporte( objeto3.getImporte2());
                objeto.setComision(objeto3.getComision2());
                objeto.setIva(     objeto3.getIva2());
            }
            // SE AGREGA EL ELEMENTO SIS E TIENEN DATOS DE EMISOR O ADQUIRENTE
            if((objeto2 != null) || (objeto3 != null) ){
                // AGREGA EL ELEMENTO A LA LISTA
                lista.add(objeto);
            }
        }else if(consecutivo == 3.0){
            sSQL2 ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), -NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND TTR_NUMERO = 15 AND TLI_NUMERO IN (2) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";
            sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), -NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) " +
                  "AND TTR_NUMERO = 15 AND TLI_NUMERO IN (3) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";

            // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
            objeto2 = aplicaConsulta200E(sSQL);
            objeto3 = aplicaConsulta200A(sSQL2);

            objeto.setEntidad(      new Integer(banco));
            objeto.setNombreBanco(  nombreBanco2(banco));
            objeto.setConsecutivo(  consecutivo);
            objeto.setConcepto(     "1\\B0 Contracargo Ventas");
            if(objeto2 != null){
                objeto.setTrx2(      objeto2.getTrx());
                objeto.setImporte2(  objeto2.getImporte());
                objeto.setComision2( objeto2.getComision());
                objeto.setIva2(      objeto2.getIva());
            }
            if(objeto3 != null){
                objeto.setTrx(     objeto3.getTrx2());
                objeto.setImporte( objeto3.getImporte2());
                objeto.setComision(objeto3.getComision2());
                objeto.setIva(     objeto3.getIva2());
            }
            // SE AGREGA EL ELEMENTO SIS E TIENEN DATOS DE EMISOR O ADQUIRENTE
            if((objeto2 != null) || (objeto3 != null) ){
                // AGREGA EL ELEMENTO A LA LISTA
                lista.add(objeto);
            }
        }else if(consecutivo == 4.0){
            sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), -NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) " +
                  "AND TTR_NUMERO = 9 AND TLI_NUMERO IN (3) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";
            sSQL2 ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND TTR_NUMERO = 9 AND TLI_NUMERO IN (2) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";

            // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
            objeto2 = aplicaConsulta200E(sSQL);
            objeto3 = aplicaConsulta200A(sSQL2);

            objeto.setEntidad(      new Integer(banco));
            objeto.setNombreBanco(  nombreBanco2(banco));
            objeto.setConsecutivo(  consecutivo);
            objeto.setConcepto(     "Representaciones");
            if(objeto2 != null){
                objeto.setTrx2(      objeto2.getTrx());
                objeto.setImporte2(  objeto2.getImporte());
                objeto.setComision2( objeto2.getComision());
                objeto.setIva2(      objeto2.getIva());
            }
            if(objeto3 != null){
                objeto.setTrx(     objeto3.getTrx2());
                objeto.setImporte( objeto3.getImporte2());
                objeto.setComision(objeto3.getComision2());
                objeto.setIva(     objeto3.getIva2());
            }
            // SE AGREGA EL ELEMENTO SIS E TIENEN DATOS DE EMISOR O ADQUIRENTE
            if((objeto2 != null) || (objeto3 != null) ){
                // AGREGA EL ELEMENTO A LA LISTA
                lista.add(objeto);
            }
        }else if(consecutivo == 5.0){
            sSQL2 ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND TTR_NUMERO = 18 AND TLI_NUMERO IN (2) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";
            sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), -NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) " +
                  "AND TTR_NUMERO = 18 AND TLI_NUMERO IN (3) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";

            // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
            objeto2 = aplicaConsulta200E(sSQL);
            objeto3 = aplicaConsulta200A(sSQL2);

            objeto.setEntidad(      new Integer(banco));
            objeto.setNombreBanco(  nombreBanco2(banco));
            objeto.setConsecutivo(  consecutivo);
            objeto.setConcepto(     "2\\B0 Contracargo Ventas");
            if(objeto2 != null){
                objeto.setTrx2(      objeto2.getTrx());
                objeto.setImporte2(  objeto2.getImporte());
                objeto.setComision2( objeto2.getComision());
                objeto.setIva2(      objeto2.getIva());
            }
            if(objeto3 != null){
                objeto.setTrx(     objeto3.getTrx2());
                objeto.setImporte( objeto3.getImporte2());
                objeto.setComision(objeto3.getComision2());
                objeto.setIva(     objeto3.getIva2());
            }
            // SE AGREGA EL ELEMENTO SIS E TIENEN DATOS DE EMISOR O ADQUIRENTE
            if((objeto2 != null) || (objeto3 != null) ){
                // AGREGA EL ELEMENTO A LA LISTA
                lista.add(objeto);
            }
        }else if(consecutivo == 6.0){
            sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) " +
                  "AND TTR_NUMERO = 20 AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (3) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";
            sSQL2 ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), -NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND TTR_NUMERO = 20 AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (2) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";

            // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
            objeto2 = aplicaConsulta200E(sSQL);
            objeto3 = aplicaConsulta200A(sSQL2);

            objeto.setEntidad(      new Integer(banco));
            objeto.setNombreBanco(  nombreBanco2(banco));
            objeto.setConsecutivo(  consecutivo);
            objeto.setConcepto(     "Pagos Cr\u00e9dito");
            if(objeto2 != null){
                objeto.setTrx2(      objeto2.getTrx());
                objeto.setImporte2(  objeto2.getImporte());
                objeto.setComision2( objeto2.getComision());
                objeto.setIva2(      objeto2.getIva());
            }
            if(objeto3 != null){
                objeto.setTrx(     objeto3.getTrx2());
                objeto.setImporte( objeto3.getImporte2());
                objeto.setComision(objeto3.getComision2());
                objeto.setIva(     objeto3.getIva2());
            }
            // SE AGREGA EL ELEMENTO SIS E TIENEN DATOS DE EMISOR O ADQUIRENTE
            if((objeto2 != null) || (objeto3 != null) ){
                // AGREGA EL ELEMENTO A LA LISTA
                lista.add(objeto);
            }
        }else if(consecutivo == 7.0){
            sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) " +
                  "AND TTR_NUMERO = 20 AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (3) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";
            sSQL2 ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND TTR_NUMERO = 20 AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (2) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";

            // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
            objeto2 = aplicaConsulta200E(sSQL);
            objeto3 = aplicaConsulta200A(sSQL2);

            objeto.setEntidad(      new Integer(banco));
            objeto.setNombreBanco(  nombreBanco2(banco));
            objeto.setConsecutivo(  consecutivo);
            objeto.setConcepto(     "Pagos D\u00e9bito");
            if(objeto2 != null){
                objeto.setTrx2(      objeto2.getTrx());
                objeto.setImporte2(  objeto2.getImporte());
                objeto.setComision2( objeto2.getComision());
                objeto.setIva2(      objeto2.getIva());
            }
            if(objeto3 != null){
                objeto.setTrx(     objeto3.getTrx2());
                objeto.setImporte( objeto3.getImporte2());
                objeto.setComision(objeto3.getComision2());
                objeto.setIva(     objeto3.getIva2());
            }
            // SE AGREGA EL ELEMENTO SIS E TIENEN DATOS DE EMISOR O ADQUIRENTE
            if((objeto2 != null) || (objeto3 != null) ){
                // AGREGA EL ELEMENTO A LA LISTA
                lista.add(objeto);
            }
        }else if(consecutivo == 8.0){
            sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND TTR_NUMERO = 17 AND TLI_NUMERO IN (2) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";
            sSQL2 ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), -NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) " +
                  "AND TTR_NUMERO = 17 AND TLI_NUMERO IN (3) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";

            // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
            objeto2 = aplicaConsulta200E(sSQL);
            objeto3 = aplicaConsulta200A(sSQL2);

            objeto.setEntidad(      new Integer(banco));
            objeto.setNombreBanco(  nombreBanco2(banco));
            objeto.setConsecutivo(  consecutivo);
            objeto.setConcepto(     "1\\B0 Contracargo Pagos");
            if(objeto2 != null){
                objeto.setTrx2(      objeto2.getTrx());
                objeto.setImporte2(  objeto2.getImporte());
                objeto.setComision2( objeto2.getComision());
                objeto.setIva2(      objeto2.getIva());
            }
            if(objeto3 != null){
                objeto.setTrx(     objeto3.getTrx2());
                objeto.setImporte( objeto3.getImporte2());
                objeto.setComision(objeto3.getComision2());
                objeto.setIva(     objeto3.getIva2());
            }
            // SE AGREGA EL ELEMENTO SIS E TIENEN DATOS DE EMISOR O ADQUIRENTE
            if((objeto2 != null) || (objeto3 != null) ){
                // AGREGA EL ELEMENTO A LA LISTA
                lista.add(objeto);
            }
        }else if(consecutivo == 9.0){
            sSQL ="SELECT NVL(SUM(decode(ttr_numero,10,NUMERO_TRANSACCIONES,0)),0), NVL(SUM(CASE WHEN TTR_NUMERO IN (10) AND trim(NOMBRE_ARCHIVO) =  'CZDCS025_112_A' THEN TOTAL_IMPORTE " +
                  "                                                      WHEN TTR_NUMERO IN (11) AND trim(NOMBRE_ARCHIVO) <> 'CZDCS035' THEN abs(TOTAL_IMPORTE) " +
                  "                                                      WHEN TTR_NUMERO IN (10) AND trim(NOMBRE_ARCHIVO) <> 'CZDCS025_112_A' THEN abs(TOTAL_IMPORTE) * -1 " +
                  "                                                      ELSE -TOTAL_IMPORTE END),0), " +
                  "NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) " +
                  "AND trim(nombre_archivo) not in ('MISC (A FAVOR)','MISC (EN CONTRA)','CZDCS030') " +
                  "AND TTR_NUMERO IN (10,11) AND TLI_NUMERO IN (3) AND (C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI OR C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ) AND C.ENTIDAD_PADRE = " + banco + " GROUP BY decode(TTR_NUMERO,11,10,TTR_NUMERO)";
            sSQL2 ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND (TTR_NUMERO = 10 AND STTR_NUMERO NOT IN (100)) AND TLI_NUMERO IN (2) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";

            // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
            objeto2 = aplicaConsulta200E(sSQL);
            objeto3 = aplicaConsulta200A(sSQL2);

            objeto.setEntidad(      new Integer(banco));
            objeto.setNombreBanco(  nombreBanco2(banco));
            objeto.setConsecutivo(  consecutivo);
            objeto.setConcepto(     "Miscel\u00e1neos En Contra");
            if(objeto2 != null){
                objeto.setTrx2(      objeto2.getTrx());
                objeto.setImporte2(  objeto2.getImporte());
                objeto.setComision2( objeto2.getComision());
                objeto.setIva2(      objeto2.getIva());
            }
            if(objeto3 != null){
                objeto.setTrx(     objeto3.getTrx2());
                objeto.setImporte( objeto3.getImporte2());
                objeto.setComision(objeto3.getComision2());
                objeto.setIva(     objeto3.getIva2());
            }
            // SE AGREGA EL ELEMENTO SIS E TIENEN DATOS DE EMISOR O ADQUIRENTE
            if((objeto2 != null) || (objeto3 != null) ){
                // AGREGA EL ELEMENTO A LA LISTA
                lista.add(objeto);
            }
        }else if(consecutivo == 10.0){
            sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND NOMBRE_ARCHIVO not in ('CZDCS030','CZDCS035','153161011_061') " +
                  "AND TTR_NUMERO = 11 AND TLI_NUMERO IN (3) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";
            sSQL2 ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), -NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM PMADMIN.PRSA_MARCA_POS_PARCIALES B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND (TTR_NUMERO IN (11) AND STTR_NUMERO NOT IN (100)) " +
                  "AND TTR_NUMERO = 11 AND TLI_NUMERO IN (2) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";

            // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
            objeto2 = aplicaConsulta200E(sSQL);
            objeto3 = aplicaConsulta200A(sSQL2);

            objeto.setEntidad(      new Integer(banco));
            objeto.setNombreBanco(  nombreBanco2(banco));
            objeto.setConsecutivo(  consecutivo);
            objeto.setConsecutivo(  consecutivo);
            objeto.setConcepto(     "Miscel\u00e1neos A Favor");
            if(objeto2 != null){
                objeto.setTrx2(      objeto2.getTrx());
                objeto.setImporte2(  objeto2.getImporte());
                objeto.setComision2( objeto2.getComision());
                objeto.setIva2(      objeto2.getIva());
            }
            if(objeto3 != null){
                objeto.setTrx(     objeto3.getTrx2());
                objeto.setImporte( objeto3.getImporte2());
                objeto.setComision(objeto3.getComision2());
                objeto.setIva(     objeto3.getIva2());
            }
            // SE AGREGA EL ELEMENTO SIS E TIENEN DATOS DE EMISOR O ADQUIRENTE
            if((objeto2 != null) || (objeto3 != null) ){
                // AGREGA EL ELEMENTO A LA LISTA
                lista.add(objeto);
            }
        }else if(consecutivo == 11.0){
            sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) * -1, NVL(SUM(IVA_COMISION_INTERCAMB),0) * -1 " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) " +
                  "AND TTR_NUMERO = 21 AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (3) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";
            sSQL2 ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), -NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND TTR_NUMERO = 21 AND TIPO_TARJETA = 'C' AND TLI_NUMERO IN (2) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";

            // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
            objeto2 = aplicaConsulta200E(sSQL);
            objeto3 = aplicaConsulta200A(sSQL2);

            objeto.setEntidad(      new Integer(banco));
            objeto.setNombreBanco(  nombreBanco2(banco));
            objeto.setConsecutivo(  consecutivo);
            objeto.setConcepto(     "Devoluciones Cr\u00e9dito");
            if(objeto2 != null){
                objeto.setTrx2(      objeto2.getTrx());
                objeto.setImporte2(  objeto2.getImporte());
                objeto.setComision2( objeto2.getComision());
                objeto.setIva2(      objeto2.getIva());
            }
            if(objeto3 != null){
                objeto.setTrx(     objeto3.getTrx2());
                objeto.setImporte( objeto3.getImporte2());
                objeto.setComision(objeto3.getComision2());
                objeto.setIva(     objeto3.getIva2());
            }
            // SE AGREGA EL ELEMENTO SIS E TIENEN DATOS DE EMISOR O ADQUIRENTE
            if((objeto2 != null) || (objeto3 != null) ){
                // AGREGA EL ELEMENTO A LA LISTA
                lista.add(objeto);
            }
        }else if(consecutivo == 12.0){
            sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) * -1, NVL(SUM(IVA_COMISION_INTERCAMB),0) * -1 " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) " +
                  "AND TTR_NUMERO = 21 AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (3) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";
            sSQL2 ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), -NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND TTR_NUMERO = 21 AND TIPO_TARJETA = 'D' AND TLI_NUMERO IN (2) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";

            // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
            objeto2 = aplicaConsulta200E(sSQL);
            objeto3 = aplicaConsulta200A(sSQL2);

            objeto.setEntidad(      new Integer(banco));
            objeto.setNombreBanco(  nombreBanco2(banco));
            objeto.setConsecutivo(  consecutivo);
            objeto.setConcepto(     "Devoluciones D\u00e9bito");
            if(objeto2 != null){
                objeto.setTrx2(      objeto2.getTrx());
                objeto.setImporte2(  objeto2.getImporte());
                objeto.setComision2( objeto2.getComision());
                objeto.setIva2(      objeto2.getIva());
            }
            if(objeto3 != null){
                objeto.setTrx(     objeto3.getTrx2());
                objeto.setImporte( objeto3.getImporte2());
                objeto.setComision(objeto3.getComision2());
                objeto.setIva(     objeto3.getIva2());
            }
            // SE AGREGA EL ELEMENTO SIS E TIENEN DATOS DE EMISOR O ADQUIRENTE
            if((objeto2 != null) || (objeto3 != null) ){
                // AGREGA EL ELEMENTO A LA LISTA
                lista.add(objeto);
            }
        }else if(consecutivo ==13.0){
            sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND TTR_NUMERO = 16 AND TLI_NUMERO IN (2) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";
            sSQL2 ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) " +
                  "AND TTR_NUMERO = 16 AND TLI_NUMERO IN (3) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";

            // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
            objeto2 = aplicaConsulta200E(sSQL);
            objeto3 = aplicaConsulta200A(sSQL2);

            objeto.setEntidad(      new Integer(banco));
            objeto.setNombreBanco(  nombreBanco2(banco));
            objeto.setConsecutivo(  consecutivo);
            objeto.setConcepto(     "1\\B0 Contracargo Devoluciones");
            if(objeto2 != null){
                objeto.setTrx2(      objeto2.getTrx());
                objeto.setImporte2(  objeto2.getImporte());
                objeto.setComision2( objeto2.getComision());
                objeto.setIva2(      objeto2.getIva());
            }
            if(objeto3 != null){
                objeto.setTrx(     objeto3.getTrx2());
                objeto.setImporte( objeto3.getImporte2());
                objeto.setComision(objeto3.getComision2());
                objeto.setIva(     objeto3.getIva2());
            }
            // SE AGREGA EL ELEMENTO SIS E TIENEN DATOS DE EMISOR O ADQUIRENTE
            if((objeto2 != null) || (objeto3 != null) ){
                // AGREGA EL ELEMENTO A LA LISTA
                lista.add(objeto);
            }
        }else if(consecutivo == 14.0){
            sSQL ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND TTR_NUMERO = 19 AND TLI_NUMERO IN (2) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";
            sSQL2 ="SELECT NVL(SUM(NUMERO_TRANSACCIONES),0), -NVL(SUM(TOTAL_IMPORTE),0), NVL(SUM(IMPORTE_COMISION_INTERCAMB),0), NVL(SUM(IVA_COMISION_INTERCAMB),0) " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) " +
                  "AND TTR_NUMERO = 19 AND TLI_NUMERO IN (3) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI AND C.ENTIDAD_PADRE = " + banco + " GROUP BY TTR_NUMERO";

            // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
            objeto2 = aplicaConsulta200E(sSQL);
            objeto3 = aplicaConsulta200A(sSQL2);

            objeto.setEntidad(      new Integer(banco));
            objeto.setNombreBanco(  nombreBanco2(banco));
            objeto.setConsecutivo(  consecutivo);
            objeto.setConcepto(     "2\\B0 Contracargo Devoluciones");
            if(objeto2 != null){
                objeto.setTrx2(      objeto2.getTrx());
                objeto.setImporte2(  objeto2.getImporte());
                objeto.setComision2( objeto2.getComision());
                objeto.setIva2(      objeto2.getIva() * -1);
            }
            if(objeto3 != null){
                objeto.setTrx(     objeto3.getTrx2());
                objeto.setImporte( objeto3.getImporte2());
                objeto.setComision(objeto3.getComision2());
                objeto.setIva(     objeto3.getIva2());
            }
            // SE AGREGA EL ELEMENTO SIS E TIENEN DATOS DE EMISOR O ADQUIRENTE
            if((objeto2 != null) || (objeto3 != null) ){
                // AGREGA EL ELEMENTO A LA LISTA
                lista.add(objeto);
            }
        }else if(consecutivo == 15.0){

            sSQL ="SELECT SUM(COL1), SUM(COL2), SUM(COL3), SUM(COL4) FROM (" +
                  "SELECT NVL(SUM(NUMERO_TRANSACCIONES),0) COL1, NVL(SUM(TOTAL_IMPORTE),0) * -1 COL2, NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) COL3, NVL(SUM(IVA_COMISION_INTERCAMB),0) COL4 " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND STTR_NUMERO IN (120,281) AND TTR_NUMERO IN (1,9,15,17,18) " +
                  "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI AND C.ENTIDAD_PADRE = " + banco + " " +
                  "UNION ALL " +
                  "SELECT NVL(SUM(NUMERO_TRANSACCIONES),0) COL1, NVL(SUM(TOTAL_IMPORTE),0) COL2, NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) * -1 COL3, NVL(SUM(IVA_COMISION_INTERCAMB),0) * -1 COL4 " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') " +
                  "AND STTR_NUMERO IN (120,281) AND TTR_NUMERO IN (16,19,20,21) " +
                  "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI AND C.ENTIDAD_PADRE = " + banco + ")";
            sSQL2="SELECT SUM(COL1), SUM(COL2), SUM(COL3), SUM(COL4) FROM (" +
                  "SELECT NVL(SUM(NUMERO_TRANSACCIONES),0) COL1, NVL(SUM(TOTAL_IMPORTE),0) COL2, NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) * -1 COL3, NVL(SUM(IVA_COMISION_INTERCAMB),0) * -1 COL4 " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE (FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') AND TTR_NUMERO IN (1, 21, 10, 11, 15, 18, 9, 16, 19) " +
                  "      OR FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') AND TTR_NUMERO IN (20, 24)) " +
                  "AND STTR_NUMERO IN (321,322) AND TTR_NUMERO IN (1,9,15,17,18) " +
                  "AND TLI_NUMERO IN (2) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ AND C.ENTIDAD_PADRE = " + banco + " " +
                  "UNION ALL " +
                  "SELECT NVL(SUM(NUMERO_TRANSACCIONES),0) COL1, NVL(SUM(TOTAL_IMPORTE),0) * -1 COL2, NVL(SUM(IMPORTE_COMISION_INTERCAMB),0) COL3, NVL(SUM(IVA_COMISION_INTERCAMB),0) COL4 " +
                  "FROM " + tabla + " B, PMADMIN.PRSA_ENTIDADES C " +
                  "WHERE (FECHA_PROCESO BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') AND TTR_NUMERO IN (1, 21, 10, 11, 15, 18, 9, 16, 19) " +
                  "      OR FECHA_LIQ BETWEEN TO_DATE('" + criterios.getIni() + "', 'DD/MM/YYYY') AND TO_DATE('" + criterios.getFin() + "', 'DD/MM/YYYY') AND TTR_NUMERO IN (20, 24)) " +
                  "AND STTR_NUMERO IN (321,322) AND TTR_NUMERO IN (16,19,20,21) " +
                  "AND TLI_NUMERO IN (2) AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ AND C.ENTIDAD_PADRE = " + banco + ")";

            // APLICA LA CONSULTA (OBTIENE TRX, IMPORTE E IMPORTE2)
            objeto2 = aplicaConsulta200E(sSQL);
            objeto3 = aplicaConsulta200A(sSQL2);

            objeto.setEntidad(      new Integer(banco));
            objeto.setNombreBanco(  nombreBanco2(banco));
            objeto.setConsecutivo(  consecutivo);
            objeto.setConcepto(     "Rechazo de Sintaxis");
            if((objeto2 != null) && (objeto2.getTrx() > 0)){
                objeto.setTrx2(      objeto2.getTrx());
                objeto.setImporte2(  objeto2.getImporte());
                objeto.setComision2( objeto2.getComision());
                objeto.setIva2(      objeto2.getIva());
            }
            if((objeto3 != null)  && (objeto3.getTrx2() > 0)){
                objeto.setTrx(     objeto3.getTrx2());
                objeto.setImporte( objeto3.getImporte2());
                objeto.setComision(objeto3.getComision2());
                objeto.setIva(     objeto3.getIva2());
            }
            // SE AGREGA EL ELEMENTO SIS E TIENEN DATOS DE EMISOR O ADQUIRENTE
            if(((objeto2 != null)  && (objeto2.getTrx() > 0)) || ((objeto3 != null) && (objeto3.getTrx2() > 0))){
                // AGREGA EL ELEMENTO A LA LISTA
                lista.add(objeto);
            }
        }

        return lista;
    }

}
