package com.wellcom.prosa.sacii.rlq;
/*
#################################################################################
# Nombre              :  RlqMontosParamsVO.java                                 #
# Autor               :  Gerardo G. Burguete                                    #
# Compania            :  Axia Consultores, S.A. de C.V.                         #
# Proyecto/Procliente :  P-53-2933-14                 	       FECHA:05/06/2015 #
# Descripcion General :	 Re-cálculo de compensación y administración de umbrales#
#-------------------------------------------------------------------------------#
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :  Acceder al sistema                                     #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :  A Peticion del web, se pueden ejecutar n instancias    #
#-------------------------------------------------------------------------------#
#								MODIFICACIONES                                  #
#-------------------------------------------------------------------------------#
# Autor               :                                                         #
# Compania            :                                                         #
# Proyecto/Procliente :                              Fecha:                     #
# Modificación        :                                                         #
#-------------------------------------------------------------------------------#
*/

public class RlqMontosParamsVO {

  String ent        = "";
  String imp        = "";
  String fecha      = "";
  String estatus    = "";;
  String msg        = "";;
  int    datoValido = 0;

  public String getEnt() {
    return ent;
  }
  public String getImp() {
	return imp;
  }
  public String getFecha() {
    return fecha;
  }
  public String getEstatus() {
    return estatus;
  }
  public String getMsg() {
    return msg;
  }
 
  public void setEnt(String ent) {
    this.ent = ent;
  }
  public void setImp(String imp) {
    this.imp = imp;
  }
  public void setFecha(String fecha) {
    this.fecha = fecha;
  }
  public void setEstatus(String estatus) {
    this.estatus = estatus;
  }
  public void setMsg(String msg) {
    this.msg = msg;
  }
  public void setDatoValido(int datoValido) {
    this.datoValido = datoValido;
  }
  public int getDatoValido() {
    return datoValido;
  }
}
