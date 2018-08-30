// ----------------------------------------------------------------------------
// Nombre del Programa : CriteriosObj.java
// Autor               : Manuel Villalobos
// Compania            : GSOF
// Proyecto/Procliente : P-53-2727-14                    Fecha: 23/ENE/2015
// Descripcion General : CLASE QUE REPRESENTA UN OBJETO DE CRITERIOS DE CONSULTA
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
import java.util.*;

public class CriteriosObj implements Serializable{
    public CriteriosObj() {}

    private String owner = "";
    public String  getOwner() {return this.owner;}
    public void    setOwner(String owner) {this.owner = owner;}

    private String ini = "";
    public String  getIni() {return this.ini;}
    public void    setIni(String ini) {this.ini = ini;}

    private String fin = "";
    public String  getFin() {return this.fin;}
    public void    setFin(String fin) {this.fin = fin;}

    private String banco = "";
    public String  getBanco() {return this.banco;}
    public void    setBanco(String[] banco) {this.banco = listaCadenas(banco);}

    private String bancoEmi = "";
    public String  getBancoEmi() {return this.bancoEmi;}
    public void    setBancoEmi(String[] bancoEmi) {this.bancoEmi = listaCadenas(bancoEmi);}

    private String bancoAdq = "";
    public String  getBancoAdq() {return this.bancoAdq;}
    public void    setBancoAdq(String[] bancoAdq) {this.bancoAdq = listaCadenas(bancoAdq);}

    private String camaraEmi = "";
    public String  getCamaraEmi() {return this.camaraEmi;}
    public void    setCamaraEmi(String[] camaraEmi) {this.camaraEmi = listaNumeros(camaraEmi);}

    private String camaraAdq = "";
    public String  getCamaraAdq() {return this.camaraAdq;}
    public void    setCamaraAdq(String[] camaraAdq) {this.camaraAdq = listaNumeros(camaraAdq);}

    private String marca = "";
    public String  getMarca() {return this.marca;}
    public void    setMarca(String[] marca) {this.marca = listaNumeros(marca);}

    // CONVIERTE UN ARRAY DE CADENAS A UNA LISTA DE CADENAS SEPARADAS POR COMA, CON APOSTROFE
    private String listaCadenas(String[] lista){
        String valor = "";
        if(lista != null){
            // PROCESA LA LISTA DE VALORES
            for(int i = 0; i < lista.length; i++){
                if(i == 0){
                    valor = "'" + lista[i] + "'";
                }else{
                    valor = valor + ",'" + lista[i] + "'";
                }
            }
        }
        return valor;
    }

    // CONVIERTE UN ARRAY DE NUMEROS A UNA LISTA DE NUMEROS SEPARADAS POR COMA
    private String listaNumeros(String[] lista){
        String valor = "";
        if(lista != null){
            // PROCESA LA LISTA DE VALORES
            for(int i = 0; i < lista.length; i++){
                if(i == 0){
                    valor = lista[i];
                }else{
                    valor = valor + "," + lista[i];
                }
            }
        }
        return valor;
    }
}
