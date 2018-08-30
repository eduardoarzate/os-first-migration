/*###############################################################################
# Nombre del Programa :  WellException.java                                     #
# Autor               :  JOAQUIN MOJICA Q.                                      #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-08-299-04                 	   FECHA:15/10/2008     #
# Descripcion General :	 Manejo de Excepciones				                    #
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :  Acceder al sistema                                     #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :  A Peticion del web, se pueden ejecutar n instancias    #
#################################################################################
#								MODIFICACIONES                                  #
# Autor               :                                                         #
# Compania            :                                                         #
# Proyecto/Procliente :                              Fecha:                     #
# Modificación        :                                                         #
#-----------------------------------------------------------------------------  #
# Numero de Parametros: 0                                                       #
###############################################################################*/

package com.wellcom.exceptions;

/**
 *
 * <p>Título: Clase WellException</p>
 * <p>Descripción: Manejo de excepciones</p>
 * <p>Compañía: Wellcom</p>
 * @author M. en C. Armando F. Ibarra
 */
public class WellException
  extends Exception {

  public WellException() {

    super();
  }

  public WellException(String value) {

    super(value);
  }
}
