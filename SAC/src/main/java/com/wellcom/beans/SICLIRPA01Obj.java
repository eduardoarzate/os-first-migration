// ----------------------------------------------------------------------------
// Nombre del Programa : SICLIRPA01Obj.java
// Autor               : Manuel Villalobos
// Compania            : GSOF
// Proyecto/Procliente : B-54-2092-15                    Fecha: 04/MAY/2015
// Descripcion General : CLASE QUE REPRESENTA UN OBJETO ELEMENTO DE UN REPORTE SICLIRPA01
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
import java.sql.Date;
import java.math.BigDecimal;

public class SICLIRPA01Obj implements Serializable{
    public SICLIRPA01Obj() {}

    private Integer trx;
    public Integer  getTrx() {return this.trx;}
    public void     setTrx(Integer trx) {this.trx = trx;}

    private Double  importe;
    public Double   getImporte() {return this.importe;}
    public void     setImporte(Double importe) {this.importe = redondea(importe);}

    private String  fecha;
    public String   getFecha() {return this.fecha;}
    public void     setFecha(String fecha) {this.fecha = fecha;}

    private Date    fechaD;
    public Date     getFechaD() {return this.fechaD;}
    public void     setFechaD(Date fechaD) {this.fechaD = fechaD;}

    private Integer corte;
    public Integer  getCorte() {return this.corte;}
    public void     setCorte(Integer corte) {this.corte = corte;}

    private String  fechaliq;
    public String   getFechaliq() {return this.fechaliq;}
    public void     setFechaliq(String fechaliq) {this.fechaliq = fechaliq;}

    private Date    fechaliqD;
    public Date     getFechaliqD() {return this.fechaliqD;}
    public void     setFechaliqD(Date fechaliqD) {this.fechaliqD = fechaliqD;}

    private String  fechaliq2;
    public String   getFechaliq2() {return this.fechaliq2;}
    public void     setFechaliq2(String fechaliq2) {this.fechaliq2 = fechaliq2;}

    private Double  liqemi;
    public Double   getLiqemi() {return this.liqemi;}
    public void     setLiqemi(Double liqemi) {this.liqemi = redondea(liqemi);}

    private Double  liqadq;
    public Double   getLiqadq() {return this.liqadq;}
    public void     setLiqadq(Double liqadq) {this.liqadq = redondea(liqadq);}

    private Double  liqcompl;
    public Double   getLiqcompl() {return this.liqcompl;}
    public void     setLiqcompl(Double liqcompl) {this.liqcompl = redondea(liqcompl);}

    private Double  misc;
    public Double   getMisc() {return this.misc;}
    public void     setMisc(Double misc) {this.misc = redondea(misc);}

    private Double  totamex;
    public Double   getTotamex() {return this.totamex;}
    public void     setTotamex(Double totamex) {this.totamex = redondea(totamex);}

    private Double  sabana;
    public Double   getSabana() {return this.sabana;}
    public void     setSabana(Double sabana) {this.sabana = redondea(sabana);}

    private Double  diferencia;
    public Double   getDiferencia() {return this.diferencia;}
    public void     setDiferencia(Double diferencia) {this.diferencia = redondea(diferencia);}

    private Double  difcortes;
    public Double   getDifcortes() {return this.difcortes;}
    public void     setDifcortes(Double difcortes) {this.difcortes = redondea(difcortes);}

    private Double  difreal;
    public Double   getDifreal() {return this.difreal;}
    public void     setDifreal(Double difreal) {this.difreal = redondea(difreal);}

    public String toString(){
        return "FechaProc [" + fechaD + "], FeLiq [" + fechaliqD + "], Corte [" + corte + "], Trx [" + trx + "], Importe [" + importe + "]";
    }
    public String toString2(){
        return "FechaProc [" + fecha + "], FeLiq [" + fechaliq + "], Corte [" + corte + "], Trx [" + trx + "], Importe [" + importe + "], LiqEmi [" + liqemi +
               "] LiqAdq [" + liqadq + "], liqcompl [" + liqcompl + "], Misc [" + misc + "], TotAMEX [" + totamex + "] Sabana [" + sabana +
               "], Diferencia [" + diferencia + "], DifCortes [" + difcortes + "], DifReal [" + difreal + "]";
    }

    // REALIZA UN REDONDEO A DOS DECIMALES
    public double redondea(double numero){
        BigDecimal res = new BigDecimal(numero).setScale(2, BigDecimal.ROUND_HALF_DOWN);
        return res.doubleValue();
    }
}
