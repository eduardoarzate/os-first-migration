// ----------------------------------------------------------------------------
// Nombre del Programa : ConsultaForm
// Autor               : Manuel Villalobos
// Compania            : GSOF
// Proyecto/Procliente : C-08-2129-12                        Fecha: 07/AGO/2013
// Descripcion General : CLASE STRUTS QUE REPRESENTA LA LISTA DE LOG DE EVENTOS
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

package com.prosa.struts;

import java.util.*;
import java.text.*;

public class ConsultaForm {
    private String fechaInicio  = "";
    private String fechaFinal   = "";
    private String cuenta       = "";
    private String afiliacion   = "";
    private String accion       = "";
    private Collection listado  = new ArrayList();
    private String error        = "";
    private String error2       = "";

    public ConsultaForm() {
    }

    public String getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return this.fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getAfiliacion() {
        return this.afiliacion;
    }

    public void setAfiliacion(String afiliacion) {
        this.afiliacion = afiliacion;
    }

    public String getAccion() {
        return this.accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Collection getListado() {
        return this.listado;
    }

    public void setListado(Collection listado) {
        this.listado = listado;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError2() {
        return this.error2;
    }

    public void setError2(String error2) {
        this.error2 = error2;
    }
}
