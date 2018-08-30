// ----------------------------------------------------------------------------
// Nombre del Programa : EstructuraListaObj.java
// Autor               : Manuel Villalobos
// Compania            : GSOF
// Proyecto/Procliente : P-53-2727-14                    Fecha: 23/ENE/2015
// Descripcion General : CLASE QUE REPRESENTA UN OBJETO PARA UNA LISTA
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

package com.wellcom.beans;

import java.io.*;

public class EstructuraListaObj implements Serializable{
    public EstructuraListaObj() {}

    private String clave;
    public String getClave() {return this.clave;}
    public void setClave(String clave) {this.clave = clave;}

    private String descripcion;
    public String getDescripcion() {return this.descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
}
