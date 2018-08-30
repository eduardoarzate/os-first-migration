package com.wellcom.prosa.sacii;
/*
#################################################################################
# Nombre              :  SacIIRequest.java                                      #
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
import javax.servlet.http.HttpServletRequest;
import com.wellcom.exceptions.WellException;

public interface SacIIRequest {
	public String procesaPeticion(HttpServletRequest req) throws WellException;	
}
