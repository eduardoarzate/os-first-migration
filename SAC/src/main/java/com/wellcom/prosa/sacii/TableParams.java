/*
#################################################################################
# Nombre del Programa :  TableParams.java                                       #
# Autor               :  Carlos Mendez                                          #
# Compania            :  PROSA                                                  #
# Proyecto/Procliente :  P-08-0299-04                   FECHA:10/18/2012        #
# Descripcion General :	 Parametros para creacion de CreateQueryTable.java      #
#################################################################################
#								MODIFICACIONES                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-08-2253-12                Fecha: 13/02/2013          #
# Modificación        :  Adicionar indicadores ABM a Reporte de log certificado #
#-----------------------------------------------------------------------------  #
*/
package com.wellcom.prosa.sacii;

import javax.servlet.http.HttpSession;

public class TableParams {
	
	HttpSession session = null;
	/********** Inicio Modificacion WELLCOM N-08-2253-12  **********/
String initDate, endDate, bancoRecep, bancoEmi, 
	       tipoTransaccion, numeroFuente, importe, cuenta,  
	       numeroCuenta, numeroAutorizacion, numeroRef, comercio, 
	       numeroComercio, nombreComercio, giroComercio, referencia,
	       rol, numerosProsa;
	int reporte;
	/********** Fin    Modificacion WELLCOM N-08-2253-12  **********/

	/********** Inicio Modificacion WELLCOM N-08-2253-12  **********/
	public TableParams(HttpSession session, String initDate, String endDate, String cuenta, 
			                                String comercio, String referencia, int reporte)
	{
		this.rol = (String) session.getAttribute("role");
		this.numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
		this.session = session;
		this.initDate = initDate;
		this.endDate = endDate;
		this.cuenta = cuenta;
		this.comercio = comercio;
		this.referencia = referencia;
		this.reporte = reporte;
	}
		/********** Fin    Modificacion WELLCOM N-08-2253-12  **********/
	
	public TableParams(HttpSession session, String initDate,  String bancoRecep,
			String bancoEmi, String tipoTransaccion, String numeroFuente, String importe,  
			String numeroCuenta, String numeroAutorizacion, String numeroRef, String numeroComercio, String nombreComercio, String giroComercio,int reporte){
	
		this.rol = (String) session.getAttribute("role");
		this.numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
		this.session = session;
		this.initDate = initDate;
		this.bancoRecep = bancoRecep;
		this.bancoEmi = bancoEmi;
		this.tipoTransaccion = tipoTransaccion;
		this.numeroFuente = numeroFuente;
		this.importe = importe;
		this.numeroCuenta = numeroCuenta;
		this.numeroAutorizacion = numeroAutorizacion;
		this.numeroRef = numeroRef;
		this.numeroComercio = numeroComercio;
		this.nombreComercio = nombreComercio;
		this.giroComercio = giroComercio;
		this.reporte = reporte;
	}

}
