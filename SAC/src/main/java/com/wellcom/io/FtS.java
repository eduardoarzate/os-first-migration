package com.wellcom.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FtS 
{
	public String fileToString(File archivoAConvertir) 
	{
		String texto = "";
		try 
		{
			// Lo primero que hacemos es abrir el archivo.
			FileInputStream fis = new FileInputStream(archivoAConvertir.getAbsolutePath());

			// Ahora creamos un buffered reader para este archivo.
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));

			// Ahora para cada linea de este archivo lo concatenamos al texto

			String linea = "";

			while ((linea = br.readLine()) != null) 
			{
				texto = texto.concat(linea);
			}

		} catch (FileNotFoundException fenfe) {
			texto = "";
			fenfe.printStackTrace();

		} catch (IOException ioe) {
			texto = "";
			ioe.printStackTrace();
		}
		return texto;
	}

}
