// ----------------------------------------------------------------------------
// Nombre del Programa : SICCMRObj.java
// Autor               : Manuel Villalobos
// Compania            : GSOF
// Proyecto/Procliente : P-53-2727-14                    Fecha: 26/MAY/2015
// Descripcion General : CLASE QUE REPRESENTA UN OBJETO ELEMENTO DE UN REPORTE SICCMR
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
import java.math.BigDecimal;

public class SICCMRObj implements Serializable{
    public SICCMRObj() {}

    private String  bin;
    public String   getBin() {return this.bin;}
    public void     setBin(String bin) {this.bin = bin;}

    private String  fiidEmi;
    public String   getFiidEmi() {return this.fiidEmi;}
    public void     setFiidEmi(String fiidEmi) {this.fiidEmi = fiidEmi;}

    private String  fiidAdq;
    public String   getFiidAdq() {return this.fiidAdq;}
    public void     setFiidAdq(String fiidAdq) {this.fiidAdq = fiidAdq;}

    private Integer trx;
    public Integer  getTrx() {return this.trx;}
    public void     setTrx(Integer trx) {this.trx = trx;}

    private Double  importe;
    public Double   getImporte() {return this.importe;}
    public void     setImporte(Double importe) {this.importe = redondea(importe);}

    private Integer trx2;
    public Integer  getTrx2() {return this.trx2;}
    public void     setTrx2(Integer trx2) {this.trx2 = trx2;}

    private Double  importe2;
    public Double   getImporte2() {return this.importe2;}
    public void     setImporte2(Double importe2) {this.importe2 = redondea(importe2);}

    private Double  cuota;
    public Double   getCuota() {return this.cuota;}
    public void     setCuota(Double cuota) {this.cuota = redondea(cuota);}

    private Double  comision;
    public Double   getComision() {return this.comision;}
    public void     setComision(Double comision) {this.comision = redondea(comision);}

    private Double  iva;
    public Double   getIva() {return this.iva;}
    public void     setIva(Double iva) {this.iva = redondea(iva);}

    private Double  comision2;
    public Double   getComision2() {return this.comision2;}
    public void     setComision2(Double comision2) {this.comision2 = redondea(comision2);}

    private Double  iva2;
    public Double   getIva2() {return this.iva2;}
    public void     setIva2(Double iva2) {this.iva2 = redondea(iva2);}

    private Integer camaraEmi;
    public Integer  getCamaraEmi() {return this.camaraEmi;}
    public void     setCamaraEmi(Integer camaraEmi) {this.camaraEmi = camaraEmi;}

    private String  camaraEmiDs;
    public String   getCamaraEmiDs() {return this.camaraEmiDs;}
    public void     setCamaraEmiDs(String camaraEmiDs) {this.camaraEmiDs = camaraEmiDs;}

    private Integer camaraAdq;
    public Integer  getCamaraAdq() {return this.camaraAdq;}
    public void     setCamaraAdq(Integer camaraAdq) {this.camaraAdq = camaraAdq;}

    private String  camaraAdqDs;
    public String   getCamaraAdqDs() {return this.camaraAdqDs;}
    public void     setCamaraAdqDs(String camaraAdqDs) {this.camaraAdqDs = camaraAdqDs;}

    private Integer camara;
    public Integer  getCamara() {return this.camara;}
    public void     setCamara(Integer camara) {this.camara = camara;}

    private String  camaraDs;
    public String   getCamaraDs() {return this.camaraDs;}
    public void     setCamaraDs(String camaraDs) {this.camaraDs = camaraDs;}

    private String  moneda;
    public String   getMoneda() {return this.moneda;}
    public void     setMoneda(String moneda) {this.moneda = moneda;}

    private Integer marca;
    public Integer  getMarca() {return this.marca;}
    public void     setMarca(Integer marca) {this.marca = marca;}

    private String  marcaDs;
    public String   getMarcaDs() {return this.marcaDs;}
    public void     setMarcaDs(String marcaDs) {this.marcaDs = marcaDs;}

    private String  fecha;
    public String   getFecha() {return this.fecha;}
    public void     setFecha(String fecha) {this.fecha = fecha;}

    private Integer mcc;
    public Integer  getMcc() {return this.mcc;}
    public void     setMcc(Integer mcc) {this.mcc = mcc;}

    private String  concepto;
    public String   getConcepto() {return this.concepto;}
    public void     setConcepto(String concepto) {this.concepto = concepto;}

    private Double  consecutivo;
    public Double   getConsecutivo() {return this.consecutivo;}
    public void     setConsecutivo(Double consecutivo) {this.consecutivo = consecutivo;}

    private Integer entidadEmi;
    public Integer  getEntidadEmi() {return this.entidadEmi;}
    public void     setEntidadEmi(Integer entidadEmi) {this.entidadEmi = entidadEmi;}

    private Integer entidadAdq;
    public Integer  getEntidadAdq() {return this.entidadAdq;}
    public void     setEntidadAdq(Integer entidadAdq) {this.entidadAdq = entidadAdq;}

    private Integer entidad;
    public Integer  getEntidad() {return this.entidad;}
    public void     setEntidad(Integer entidad) {this.entidad = entidad;}

    private String  nombreBanco;
    public String   getNombreBanco() {return this.nombreBanco;}
    public void     setNombreBanco(String nombreBanco) {this.nombreBanco = nombreBanco;}

    private Integer ttr;
    public Integer  getTtr() {return this.ttr;}
    public void     setTtr(Integer ttr) {this.ttr = ttr;}

    private String  ttrDs;
    public String   getTtrDs() {return this.ttrDs;}
    public void     setTtrDs(String ttrDs) {this.ttrDs = ttrDs;}

    public String toString(){
        return "Bin [" + bin + "], fiidEmi [" + fiidEmi + "], fiidAdq [" + fiidAdq + "], trx [" + trx + "], importe [" + importe +
               "] trx2 [" + trx2 + "], importe2 [" + importe2 + "], cuota [" + cuota + "], comision [" + comision + "], iva [" + iva +
               "] camaraEmi [" + camaraEmi + "], camaraEmiDs [" + camaraEmiDs + "], camaraAdq [" + camaraAdq + "], camaraAdqDs [" + camaraAdqDs + "], camara [" + camara +
               "] camaraDs [" + camaraDs + "], moneda [" + moneda + "], marca [" + marca + "], marcaDs [" + marcaDs + "], fecha [" + fecha +
               "] MCC [" + mcc + "], concepto [" + concepto + "], consecutivo [" + consecutivo + "], entidad [" + entidad + "], nombreBanco [" + nombreBanco +
               "] ttr [" + ttr + "], ttrDs [" + ttrDs + "], entidadEmi [" + entidadEmi + "], entidadAdq [" + entidadAdq + "]";
    }

    // REALIZA UN REDONDEO A DOS DECIMALES
    public double redondea(double numero){
        BigDecimal res = new BigDecimal(numero).setScale(2, BigDecimal.ROUND_HALF_DOWN);
        return res.doubleValue();
    }
}
