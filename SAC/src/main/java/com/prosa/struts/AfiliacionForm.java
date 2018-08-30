// ----------------------------------------------------------------------------
// Nombre del Programa : AfiliacionForm
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

public class AfiliacionForm {
    private String Accion       = "";
    private String afiliacion   = "";
    private String error        = "";

    public AfiliacionForm(){
    }

    public String getAccion() {
        return this.Accion;
    }

    public void setAccion(String Accion) {
        this.Accion = Accion;
    }

    public String getAfiliacion() {
        return this.afiliacion;
    }

    public void setAfiliacion(String afiliacion) {
        this.afiliacion = afiliacion;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
