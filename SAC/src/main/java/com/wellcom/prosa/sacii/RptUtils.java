/*###############################################################################
# Nombre del Programa : RptUtils.java                                           #
# Autor               : CARLOS MENDEZ DL                                        #
# Compania            : PROSA                                                   #
# Proyecto/Procliente : C-04-3035-13                            Fecha:11/12/2013#
# Modificacion        : Generacion de Proceso de Diferencia de Cuota de         #
#                       Intercambio de EGLO SAC2                                #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :  Acceder al sistema                                     #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :  A Peticion del web, se pueden ejecutar n instancias    #
#################################################################################
#                               MODIFICACIONES                                  #
# Autor               :                                                         #
# Compania            :                                                         #
# Proyecto/Procliente :                              Fecha:                     #
# Modificación        :                                                         #
#-----------------------------------------------------------------------------  #
# Numero de Parametros: 0                                                       #
###############################################################################*/

package com.wellcom.prosa.sacii;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class RptUtils{

	/**
	 * Lanza proceso a CTM para agregar o borrar condiciones de la liberacion de
	 * las liquidaciones y captura de tipo de cambio 
	 * @param cond - Nombrfe de la condicion
	 * @param fecha - Fecha de la condicion MMDD
	 * @param edo - Agrega o elimina ( 1, 0)
	 */
	public void lanzaCondicion(String cond, String fecha, int edo) {
		String estado = edo == 1 ? " -ADD " : " -DELETE ";
		StringBuffer command = new StringBuffer("ssh emapp0 -l ctm640 ctmcontb");
		command.append(estado);
		command.append(cond);
		command.append(" ");
		command.append(fecha);
		
			Process process;
			try {
				System.out.println("Agregando condicion a CTM...");
				System.out.println(command.toString());
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
	
	/**
	 * Crea un archivo en el dominioG1 con las fechas para la creacion de reportes
	 * @param rpt - nombre reporte
	 * @param fIni - fecha inicio
	 * @param fFin - fecha fin
	 */
	public void creaArchFechas(String rpt, String fIni, String fFin, String usr) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy H:mm:ss");
		Date fecha = Calendar.getInstance().getTime();
		String rutaRemota = "/aplic/prod/pmt/rpt/log/";
		String archRemota = "RPTUPMTB999.LOG";
		
		StringBuffer command = new StringBuffer("ssh dominioG1 -l ctm640 echo ");
		command.append(sdf.format(fecha));
		command.append("-");
		command.append(rpt.toUpperCase());
		command.append("-");
		command.append(fIni);
		command.append("-");
		command.append(fFin);
		command.append("-");
		command.append(usr);
		command.append(" >> ");
		command.append(rutaRemota);
		command.append(archRemota);
		
			Process process;
			try {
				System.out.println("Agregando fechas a archivo...");
				System.out.println(command.toString());
				process = Runtime.getRuntime().exec(command.toString());
				InputStream input = process.getInputStream();
				InputStream err = process.getErrorStream();
				int sal = process.waitFor();
				
				if(sal == 0){
					System.out.println(" - Registro creado corrcetamente");
					sdf.applyPattern("MMdd");
					lanzaCondicion("PMT"+rpt.toUpperCase()+"_W", sdf.format(fecha), 1);

					System.out.println(new Scanner(input).useDelimiter("\\A").next() + " - Registro creado correctamente" );
				}else{
					System.out.println(new Scanner(err).useDelimiter("\\A").next() );
				}
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			} catch (InterruptedException e) {
				System.out.println("Error: " + e.getMessage());
			} catch (NoSuchElementException e) {
				//System.out.println("Error: " + e.getMessage());
			}
	}
	
	/**
	 * Formatea fecha al formato deseado
	 * @param fecha - en formato [dd-mm-yyyy] [dd/mm/yyyy]
	 * @param formato
	 * @return
	 */
	public String convertFecha(String fecha, String formato){
		String separador = fecha.indexOf("/") > 0 ? "/" : "-";
		String[] fec = fecha.split(separador);
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(fec[2]), Integer.parseInt(fec[1])-1, Integer.parseInt(fec[0]));

		Date fecha2 = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(formato);
		
		return sdf.format(fecha2);
		
		
		
	}
}
