// ----------------------------------------------------------------------------
// Nombre del Programa : AfiliacionObj
// Autor               : Manuel Villalobos
// Compania            : GSOF
// Proyecto/Procliente : C-08-2129-12                        Fecha: 07/AGO/2013
// Descripcion General : CLASE QUE REPRESENTA UN OBJETO AFILIACION
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

public class AfiliacionObj implements Serializable{

    public AfiliacionObj() {
    }

    private String afiliacion;

    public String getAfiliacion() {
        return this.afiliacion;
    }

    public void setAfiliacion(String afiliacion) {
        this.afiliacion = afiliacion;
    }
}
