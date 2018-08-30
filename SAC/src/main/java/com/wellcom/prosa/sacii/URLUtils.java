/*###############################################################################
# Nombre del Programa :  URLUtils.java                                          #
# Autor               :  Carlos Mendez                                          #
# Compania            :  PROSA                                                  #
# Proyecto/Procliente :  P-08-299-04                 	     FECHA:25/10/2011     #
# Descripcion General :	 Validacion de URL                          	          #
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :  Acceder al sistema                                     #
#                                                                               #
#################################################################################
*/
package com.wellcom.prosa.sacii;

import java.net.HttpURLConnection;
import java.net.URL;

public class URLUtils {
	
	public static boolean checkIfURLExists(String targetUrl) {
		HttpURLConnection httpUrlConn;
		try {
			httpUrlConn = (HttpURLConnection) new URL(targetUrl).openConnection();

			// HEAD es similar a una peticion GET, exepto que este pide al 
			// servidor solo el header y no el recurso actual
			httpUrlConn.setRequestMethod("HEAD");

			// Timeouts en milisegundos
			httpUrlConn.setConnectTimeout(30000);
			httpUrlConn.setReadTimeout(30000);

			// Imprime el estatus HTTP (codigo/mensaje)
			System.out.println("Response Code: "
					+ httpUrlConn.getResponseCode());
			System.out.println("Response Message: "
					+ httpUrlConn.getResponseMessage());

			return (httpUrlConn.getResponseCode() == HttpURLConnection.HTTP_OK);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
	}

}
