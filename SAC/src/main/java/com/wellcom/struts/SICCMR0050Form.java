// ----------------------------------------------------------------------------
// Nombre del Programa : SICCMR0050Form
// Autor               : Manuel Villalobos
// Compania            : GSOF
// Proyecto/Procliente : P-53-2727-14                    Fecha: 23/ENE/2015
// Descripcion General : CLASE STRUTS QUE REPRESENTA LOS DATOS DE LA PANTALLA SICCMR0050
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

public class SICCMR0050Form {
    public SICCMR0050Form() {}

    private String     fechaInicio = "";
    public String      getFechaInicio() {return this.fechaInicio;}
    public void        setFechaInicio(String fechaInicio) {this.fechaInicio = fechaInicio;}

    private String     fechaFinal = "";
    public String      getFechaFinal() {return this.fechaFinal;}
    public void        setFechaFinal(String fechaFinal) {this.fechaFinal = fechaFinal;}

    private String[]   bancoEmi = null;
    public String[]    getBancoEmi() {return this.bancoEmi;}
    public void        setBancoEmi(String[] bancoEmi) {this.bancoEmi = bancoEmi;}

    private String[]   camaraEmi = null;
    public String[]    getCamaraEmi() {return this.camaraEmi;}
    public void        setCamaraEmi(String[] camaraEmi) {this.camaraEmi = camaraEmi;}

    private String     accion = "";
    public String      getAccion() {return this.accion;}
    public void        setAccion(String accion) {this.accion = accion;}

    private Collection bancosE = new ArrayList();
    public Collection  getBancosE() {return this.bancosE;}
    public void        setBancosE(Collection bancosE) {this.bancosE = bancosE;}

    private Collection camarasE = new ArrayList();
    public Collection  getCamarasE() {return this.camarasE;}
    public void        setCamarasE(Collection camarasE) {this.camarasE = camarasE;}

    private String     error = "";
    public String      getError() {return this.error;}
    public void        setError(String error) {this.error = error;}

    private String     formato = "";
    public String      getFormato() {return this.formato;}
    public void        setFormato(String formato) {this.formato = formato;}
}
