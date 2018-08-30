// ----------------------------------------------------------------------------
// Nombre del Programa : SICLIRPA01Form
// Autor               : Manuel Villalobos
// Compania            : GSOF
// Proyecto/Procliente : B-54-2092-15                    Fecha: 11/MAY/2015
// Descripcion General : CLASE STRUTS QUE REPRESENTA LOS DATOS DE LA PANTALLA SICLIR0060
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

package com.wellcom.struts;

import java.util.*;
import java.text.*;

public class SICLIRPA01Form {
    public SICLIRPA01Form() {}

    private String     accion = "";
    public String      getAccion() {return this.accion;}
    public void        setAccion(String accion) {this.accion = accion;}

    private String     fechaInicio = "";
    public String      getFechaInicio() {return this.fechaInicio;}
    public void        setFechaInicio(String fechaInicio) {this.fechaInicio = fechaInicio;}

    private String     fechaFinal = "";
    public String      getFechaFinal() {return this.fechaFinal;}
    public void        setFechaFinal(String fechaFinal) {this.fechaFinal = fechaFinal;}

    private String     error = "";
    public String      getError() {return this.error;}
    public void        setError(String error) {this.error = error;}

    private String     formato = "";
    public String      getFormato() {return this.formato;}
    public void        setFormato(String formato) {this.formato = formato;}
}
