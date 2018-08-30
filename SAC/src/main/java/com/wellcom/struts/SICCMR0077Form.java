// ----------------------------------------------------------------------------
// Nombre del Programa : SICCMR0077Form
// Autor               : Manuel Villalobos
// Compania            : GSOF
// Proyecto/Procliente : P-53-2727-14                    Fecha: 23/ENE/2015
// Descripcion General : CLASE STRUTS QUE REPRESENTA LOS DATOS DE LA PANTALLA SICCMR0077
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

public class SICCMR0077Form {
    public SICCMR0077Form() {}

    private String     fechaInicio = "";
    public String      getFechaInicio() {return this.fechaInicio;}
    public void        setFechaInicio(String fechaInicio) {this.fechaInicio = fechaInicio;}

    private String     fechaFinal = "";
    public String      getFechaFinal() {return this.fechaFinal;}
    public void        setFechaFinal(String fechaFinal) {this.fechaFinal = fechaFinal;}

    private String[]   camaraAdq = null;
    public String[]    getCamaraAdq() {return this.camaraAdq;}
    public void        setCamaraAdq(String[] camaraAdq) {this.camaraAdq = camaraAdq;}

    private String[]   marca = null;
    public String[]    getMarca() {return this.marca;}
    public void        setMarca(String[] marca) {this.marca = marca;}

    private String     accion = "";
    public String      getAccion() {return this.accion;}
    public void        setAccion(String accion) {this.accion = accion;}

    private Collection camarasA = new ArrayList();
    public Collection  getCamarasA() {return this.camarasA;}
    public void        setCamarasA(Collection camarasA) {this.camarasA = camarasA;}

    private Collection marcas = new ArrayList();
    public Collection  getMarcas() {return this.marcas;}
    public void        setMarcas(Collection marcas) {this.marcas = marcas;}

    private String     error = "";
    public String      getError() {return this.error;}
    public void        setError(String error) {this.error = error;}

    private String     formato = "";
    public String      getFormato() {return this.formato;}
    public void        setFormato(String formato) {this.formato = formato;}
}
