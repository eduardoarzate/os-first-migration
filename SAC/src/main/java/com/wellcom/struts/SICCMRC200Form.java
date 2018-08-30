// ----------------------------------------------------------------------------
// Nombre del Programa : SICCMRC200Form
// Autor               : Manuel Villalobos
// Compania            : GSOF
// Proyecto/Procliente : P-53-2727-14                    Fecha: 23/ENE/2015
// Descripcion General : CLASE STRUTS QUE REPRESENTA LOS DATOS DE LA PANTALLA SICCMRC200
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

public class SICCMRC200Form {
    public SICCMRC200Form() {}

    private String     fechaInicio = "";
    public String      getFechaInicio() {return this.fechaInicio;}
    public void        setFechaInicio(String fechaInicio) {this.fechaInicio = fechaInicio;}

    private String     fechaFinal = "";
    public String      getFechaFinal() {return this.fechaFinal;}
    public void        setFechaFinal(String fechaFinal) {this.fechaFinal = fechaFinal;}

    private String[]   banco = null;
    public String[]    getBanco() {return this.banco;}
    public void        setBanco(String[] cuenta) {this.banco = banco;}

    private String     accion = "";
    public String      getAccion() {return this.accion;}
    public void        setAccion(String accion) {this.accion = accion;}

    private Collection bancos = new ArrayList();
    public Collection  getBancos() {return this.bancos;}
    public void        setBancos(Collection bancos) {this.bancos = bancos;}

    private String     error = "";
    public String      getError() {return this.error;}
    public void        setError(String error) {this.error = error;}

    private String     formato = "";
    public String      getFormato() {return this.formato;}
    public void        setFormato(String formato) {this.formato = formato;}
}
