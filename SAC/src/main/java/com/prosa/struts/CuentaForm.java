// ----------------------------------------------------------------------------
// Nombre del Programa : CuentaForm
// Autor               : Manuel Villalobos
// Compania            : GSOF
// Proyecto/Procliente : C-08-2129-12                        Fecha: 07/AGO/2013
// Descripcion General : CLASE STRUTS QUE REPRESENTA LA FORMA DE AFILIACION
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

public class CuentaForm {
    private String Accion       = "";
    private String cuenta       = "";
    private String error        = "";

    public CuentaForm(){
    }

    public String getAccion() {
        return this.Accion;
    }

    public void setAccion(String Accion) {
        this.Accion = Accion;
    }

    public String getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
