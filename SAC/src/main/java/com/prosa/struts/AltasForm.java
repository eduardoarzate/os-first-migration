// ----------------------------------------------------------------------------
// Nombre del Programa : AltasForm
// Autor               : Manuel Villalobos
// Compania            : GSOF
// Proyecto/Procliente : C-08-2129-12                        Fecha: 07/AGO/2013
// Descripcion General : CLASE STRUTS QUE REPRESENTA LA FORMA DE ALTAS LACPI
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

public class AltasForm {
    private String accion       = "";
    private Collection listado  = null;
    private String numListado   = "";
    private String numListado3  = "";
    private Collection listado3 = null;
    private String error        = "";

    public AltasForm(){
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

    public String getNumListado() {
        return this.numListado;
    }

    public void setNumListado(String numListado) {
        this.numListado = numListado;
    }

    public Collection getListado3() {
        return this.listado3;
    }

    public void setListado3(Collection listado3) {
        this.listado3 = listado3;
    }

    public String getNumListado3() {
        return this.numListado3;
    }

    public void setNumListado3(String numListado3) {
        this.numListado3 = numListado3;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
