// ----------------------------------------------------------------------------
// Nombre del Programa : ListadoObj
// Autor               : Manuel Villalobos
// Compania            : GSOF
// Proyecto/Procliente : C-08-2129-12                        Fecha: 07/AGO/2013
// Descripcion General : CLASE QUE REPRESENTA UN OBJETO RESULTADO DE CONSULTA
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

package com.prosa.beans;

import java.io.*;

public class ListadoObj implements Serializable{

    public ListadoObj() {
    }

    private String numero_comercio;
    private String fiid;
    private String cuenta;
    private String importe_total_transac;
    private String numero_autorizacion;
    private String fecha_consumo_transac;
    private String ttr_numero;

    public String getNumero_comercio() {
        return this.numero_comercio;
    }

    public void setNumero_comercio(String numero_comercio) {
        this.numero_comercio = numero_comercio;
    }

    public String getFiid() {
        return this.fiid;
    }

    public void setFiid(String fiid) {
        this.fiid = fiid;
    }

    public String getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getImporte_total_transac() {
        return this.importe_total_transac;
    }

    public void setImporte_total_transac(String importe_total_transac) {
        this.importe_total_transac = importe_total_transac;
    }

    public String getNumero_autorizacion() {
        return this.numero_autorizacion;
    }

    public void setNumero_autorizacion(String numero_autorizacion) {
        this.numero_autorizacion = numero_autorizacion;
    }

    public String getFecha_consumo_transac() {
        return this.fecha_consumo_transac;
    }

    public void setFecha_consumo_transac(String fecha_consumo_transac) {
        this.fecha_consumo_transac = fecha_consumo_transac;
    }

    public String getTtr_numero() {
        return this.ttr_numero;
    }

    public void setTtr_numero(String ttr_numero) {
        this.ttr_numero = ttr_numero;
    }
}
