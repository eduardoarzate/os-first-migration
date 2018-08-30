/*###############################################################################
# Nombre del Programa :  LanzadorCondicionCtm.java                              #
# Autor               :  CARLOS MENDEZ DL                                       #
# Compania            :  PROSA                                                  #
# Proyecto/Procliente :  P-08-299-04                       FECHA:19/07/2012     #
# Descripcion General :                                                         #
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :  Acceder al sistema                                     #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :  A Peticion del web, se pueden ejecutar n instancias    #
#################################################################################
#								MODIFICACIONES                                                  #
# Autor               : CMDL                                                    #
# Compania            : PROSA                                                   #
# Proyecto/Procliente : B-52-2114-14                       FECHA:25/03/2014     #
# Modificación        : Cambio por alias en CTM                                 #
#-----------------------------------------------------------------------------  #
# Numero de Parametros: 0                                                       #
###############################################################################*/

package com.wellcom.prosa.sacii;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class LanzadorCondicionCtm{

	/**
	 * Lanza proceso a CTM para agregar o borrar condiciones de la liberacion de
	 * las liquidaciones y captura de tipo de cambio 
	 * @param cond - Nombrfe de la condicion
	 * @param fecha - Fecha de la condicion MMDD
	 * @param edo - Agrega o elimina ( 1, 0)
	 */
	public static void lanzaCondicion(String cond, String fecha, int edo) {
		String estado = edo == 1 ? " -ADD " : " -DELETE ";
		/* Inicia modificacion B-52-2114-14 */
		StringBuffer command = new StringBuffer("ssh emapp0 -l ctm640 ctmcontb");
		/* Termina modificacion B-52-2114-14 */
		command.append(estado);
		command.append(cond);
		command.append(" ");
		command.append(fecha);
		
			Process process;
			try {
				process = Runtime.getRuntime().exec(command.toString());
				InputStream input = process.getInputStream();
				InputStream err = process.getErrorStream();
				int sal = process.waitFor();
				
				if(sal == 0){
					System.out.println(new Scanner(input).useDelimiter("\\A").next() );
				}else{
					System.out.println(new Scanner(err).useDelimiter("\\A").next() );
				}
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			} catch (InterruptedException e) {
				System.out.println("Error: " + e.getMessage());
			} catch (NoSuchElementException e) {
				System.out.println("Error: " + e.getMessage());
			}
	}
}
