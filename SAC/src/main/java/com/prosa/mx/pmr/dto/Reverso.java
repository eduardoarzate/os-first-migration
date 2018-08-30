/*##############################################################################
# Nombre del Programa : Reverso.java                                           #
# Autor               : Victor H. Montoya G.                                   #
# Compania            : eNova                                                  #
# Proyecto/Procliente : Z-04-3155-11                         Fecha: 02-ene-2012#
# Descripcion General : dto reversos                                           #
# Programa Dependiente:                                                        #
# Programa Subsecuente:                                                        #
# Cond. de ejecucion  :                                                        #
# Dias de ejecucion   :                                      Horario: hh:mm    #
#                              MODIFICACIONES                                  #
################################################################################
# Autor               :                                                        #
# Compania            :                                                        #
# Proyecto/Procliente :                                      Fecha: dd/mm/yyyy #
# Modificacion        :                                                        #
################################################################################
# Numero de Parametros:                                                        #
# Parametros Entrada  :                                      Formato:          #
# Parametros Salida   :                                      Formato:          #
##############################################################################*/

package com.prosa.mx.pmr.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;


public class Reverso {
    private String id;
    private String cuenta;
    private String autorizacion;
    private String fechaProceso;
    private String fechaConsumo;
    private String comercio;
    private String nombreComercio;
    private String tipoTransaccion;
    private String bancoEmisor;
    private String importeTotal;
    private String archivo;
    private String referencia;
    private String indBenef;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
    public Reverso(){

    }

    public Reverso(ResultSet rs) throws SQLException{
        id = rs.getString("ta_wh_seq");
        cuenta = rs.getString("cuenta");
        autorizacion = rs.getString("numero_autorizacion");
        fechaProceso = sdf.format(rs.getDate("fecha_proceso_transac"));
        fechaConsumo = sdf.format(rs.getDate("fecha_consumo_transac"));
        comercio = rs.getString("numero_comercio");
        nombreComercio = rs.getString("nombre_comercio");
        tipoTransaccion = rs.getString("tipo_tx");
        bancoEmisor = rs.getString("emisor");
        importeTotal = rs.getString("importe_total_transac");
        archivo = rs.getString("nombre_archivo");
        referencia = rs.getString("numero_referencia");
        if(rs.getString("ind_beneficios")!=null && rs.getString("ind_beneficios").equals("1")){
            indBenef =  "checked";
        }

    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the cuenta
     */
    public String getCuenta() {
        return cuenta;
    }

    /**
     * @param cuenta the cuenta to set
     */
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * @return the autorizacion
     */
    public String getAutorizacion() {
        return autorizacion;
    }

    /**
     * @param autorizacion the autorizacion to set
     */
    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    /**
     * @return the fechaProceso
     */
    public String getFechaProceso() {
        return fechaProceso;
    }

    /**
     * @param fechaProceso the fechaProceso to set
     */
    public void setFechaProceso(String fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    /**
     * @return the fechaConsumo
     */
    public String getFechaConsumo() {
        return fechaConsumo;
    }

    /**
     * @param fechaConsumo the fechaConsumo to set
     */
    public void setFechaConsumo(String fechaConsumo) {
        this.fechaConsumo = fechaConsumo;
    }

    /**
     * @return the comercio
     */
    public String getComercio() {
        return comercio;
    }

    /**
     * @param comercio the comercio to set
     */
    public void setComercio(String comercio) {
        this.comercio = comercio;
    }

    /**
     * @return the tipoTransaccion
     */
    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    /**
     * @param tipoTransaccion the tipoTransaccion to set
     */
    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    /**
     * @return the bancoEmisor
     */
    public String getBancoEmisor() {
        return bancoEmisor;
    }

    /**
     * @param bancoEmisor the bancoEmisor to set
     */
    public void setBancoEmisor(String bancoEmisor) {
        this.bancoEmisor = bancoEmisor;
    }

    /**
     * @return the importeTotal
     */
    public String getImporteTotal() {
        BigDecimal bd = new BigDecimal(importeTotal);
        NumberFormat format = new DecimalFormat("$#,###,###.00");
        return format.format(bd);
    }

    /**
     * @param importeTotal the importeTotal to set
     */
    public void setImporteTotal(String importeTotal) {
        this.importeTotal = importeTotal;
    }

    /**
     * @return the archivo
     */
    public String getArchivo() {
        return archivo;
    }

    /**
     * @param archivo the archivo to set
     */
    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the nombreComercio
     */
    public String getNombreComercio() {
        return nombreComercio;
    }

    /**
     * @param nombreComercio the nombreComercio to set
     */
    public void setNombreComercio(String nombreComercio) {
        this.nombreComercio = nombreComercio;
    }

    /**
     * @return the indBenef
     */
    public String getIndBenef() {
        return indBenef;
    }

    /**
     * @param indBenef the indBenef to set
     */
    public void setIndBenef(String indBenef) {
        this.indBenef = indBenef;
    }

    
}
