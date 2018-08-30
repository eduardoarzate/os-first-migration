/*
#################################################################################
# Nombre del Programa :  CreateQueryTable.java                                  #
# Autor               :  Carlos Mendez                                          #
# Compania            :  PROSA                                                  #
# Proyecto/Procliente :  P-08-0299-04                   FECHA:10/18/2012        #
# Descripcion General :	 Queries para resultados del objeto Table.java          #
#################################################################################
#								MODIFICACIONES                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-08-2253-12                Fecha: 27/08/2012          #
# Modificación        :  Adicionar indicadores ABM a Reporte de log certificado #
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-08-2253-12                Fecha: 13/02/2013          #
# Modificación        :  Adicionar indicadores ABM a Reporte de log certificado #
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-08-2253-12                Fecha: 13/05/2013          #
# Modificación        :  Adicionar indicadores ABM a Reporte de log certificado #
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-08-2253-12                Fecha: 29/05/2013          #
# Modificación        :  Adicionar indicadores ABM a Reporte de log certificado #
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-04-2207-13                Fecha: 21/08/2013          #
# Modificación        :  Adicionar indicadores ABM a Reporte de log certificado #
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-04-2207-13                Fecha: 05/09/2013          #
# Modificación        :  Adicionar indicadores ABM a Reporte de log certificado #
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-04-2207-13                Fecha: 20/02/2014          #
# Modificación        :  Formateo a decimal 									#
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-04-2207-13                Fecha: 24/02/2014          #
# Modificación        :  Adicionar funcionalidad de Afiliacion					#
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-04-2207-13                Fecha: 11/03/2014          #
# Modificación        :  Cambio de FIID's                          				#
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-04-2207-13                Fecha: 25/03/2014          #
# Modificación        :  Se elimina Header y se cambia formto del importe2		#
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-04-2207-13                Fecha: 02/05/2014          #
# Modificación        :  Modificacion de la forma de hacer inner join de tablas #
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-04-2207-13                Fecha: 04/06/2014          #
# Modificación        :  Modificacion del Header de tokens para reporte 205H    #
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-51-2098-14                Fecha: 16/01/2015          #
# Modificación        :  Modificacion del token full EMV                        #
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-51-2098-14                Fecha: 18/02/2015          #
# Modificación        :  Modificacion del token full EMV                        #
#-----------------------------------------------------------------------------  #  
#								MODIFICACIONES                                                  #  
# Autor               :  German Gonzalez                                        #  
# Compania            :  WELLCOM S.A. DE C.V.                                   #  
# Proyecto/Procliente :  P-02-0256-12                Fecha: 20/08/2015          #  
# Modificación        :  Modificacion de reporte Banistmo                       #  
#-----------------------------------------------------------------------------  #  
#								MODIFICACIONES                                  #  
# Autor               :  Laura Maleni Ramirez Vazquez                           #  
# Compania            :  SAS				                                    #  
# Proyecto/Procliente :  N-51-2390-15                Fecha: 12/04/2016          #  
# Modificación        :  Modificacion del token B2 y B3- y token r4             #  
#-----------------------------------------------------------------------------  #  
#								MODIFICACIONES                                  #  
# Autor               :  Laura Maleni Ramirez Vazquez                           #  
# Compania            :  SAS S.A DE C.V.	                                    #  
# Proyecto/Procliente :  N-51-2823-15                Fecha: 11/08/2016          #  
# Modificación        :  Implementación del Log de autorización Token CZ        #  
#-----------------------------------------------------------------------------  #  
#								MODIFICACIONES                                                  #  
# Autor               :  German Gonzalez                                        #  
# Compania            :  WELLCOM S.A. DE C.V.                                   #  
# Proyecto/Procliente :  D-52-8122-17                Fecha: 22/08/2017          #  
# Modificación        :  Mejoras a reporteador                                  #  
#-----------------------------------------------------------------------------  #  
#								MODIFICACIONES                                                  #  
# Autor               :  Gustavo Ramirez                                        #  
# Compania            :  PROSA S.A. DE C.V.                                     #  
# Proyecto/Procliente :  F-52-8181-17                Fecha: 22/08/2017          #  
# Modificación        :  Mejoras a reporteador                                  #  
#-----------------------------------------------------------------------------  #  
################################################################################# 
*/

package com.wellcom.prosa.sacii;

public class CreateQueryTable {

	/**
	 * Metodo que genera query para reporte SICMOF0100
	 * @param params
	 * @return 
	 */

	/********** Inicio Modificacion WELLCOM N-08-2253-12  **********/
		public static String SICMOR0205(TableParams params)
	{
		String query = "";
		System.out.println("Entro 205");
		
		String cadena = "xxx";
		if (params.initDate.substring(3, 5).toString().equals("01"))
			cadena = "ENE";
		else if (params.initDate.substring(3, 5).toString().equals("02"))
			cadena = "FEB";
		else if (params.initDate.substring(3, 5).toString().equals("03"))
			cadena = "MAR";
		else if (params.initDate.substring(3, 5).toString().equals("04"))
			cadena = "ABR";
		else if (params.initDate.substring(3, 5).toString().equals("05"))
			cadena = "MAY";
		else if (params.initDate.substring(3, 5).toString().equals("06"))
			cadena = "JUN";
		else if (params.initDate.substring(3, 5).toString().equals("07"))
			cadena = "JUL";
		else if (params.initDate.substring(3, 5).toString().equals("08"))
			cadena = "AGO";
		else if (params.initDate.substring(3, 5).toString().equals("09"))
			cadena = "SEP";
		else if (params.initDate.substring(3, 5).toString().equals("10"))
			cadena = "OCT";
		else if (params.initDate.substring(3, 5).toString().equals("11"))
			cadena = "NOV";
		else if (params.initDate.substring(3, 5).toString().equals("12"))
			cadena = "DIC";
		
		
		/* Inicia Marca de Cambio WELLCOM   N-08-2253-12   29-05-2013 */
		query = 
/*			" SELECT TO_CHAR(PTA.TA_WH_SEQ) NUMERO \n"+                // 00
			" 		,PTA.ENT_NUMERO_PROSA_ADQ ADQ \n"+                 // 01
			"       ,PTA.ENT_NUMERO_PROSA_EMI EMI \n"+                 // 02
			"       ,PTA.ARCH_NUMERO FUENTE \n"+                       // 03
			"       ,PTA.PROC_NUMERO PROC \n"+                         // 04
			"       ,PTA.FIID_EMISOR BANCO_EMISOR \n"+                 // 05
			"       ,PTA.CUENTA CUENTA \n"+                            // 06
			"       ,PTA.TTR_NUMERO CVE_TXN \n"+                       // 07
			"       ,PTA.TC||'  '||PTA.TYP TYP \n"+                    // 08
			"       ,PTA.NUMERO_AUTORIZACION NO_AUT \n"+               // 09
			"       ,PTA.IMPORTE_TOTAL_TRANSAC IMPORTE \n"+            // 10
			"       ,PTA.FECHA_CONSUMO_TRANSAC||' '||TO_CHAR(PTA.FECHA_CONSUMO_TRANSAC,'HH:mm:SS') FECHA_CONSUMO_TRANSAC \n"+//11
			"       ,PTA.MODO_ENTRADA_POS MODO_ENT \n"+                // 12
			"       ,PTA.TIPO_CAPTURA TIPO_CAPTURA \n"+                // 13
			" 		,PTA.TIPO_CAPTURA IND_EMV \n"+                     // 14
			"       ,PTA.IND_TER_CAP TERM_CAP \n"+                     // 15
			"       ,PTA.CODIGO_RESPUESTA_ISO COD_ISO \n"+             // 16
			"       ,PTA.IND_COM_ELEC ICE \n"+			               // 17
			"       ,PTK1.TKQ1 \n"+         			               // 18
			"       ,PTK1.TKQ2 \n"+         			               // 19
			"       ,PTK1.TKQ6 \n"+         			               // 20
			"       ,PTK1.TK04 \n"+         			               // 21
			"       ,PTK1.TKC0 \n"+         			               // 22
			"       ,PTK2.TKC4 \n"+         			               // 23
			"       ,PTK2.TKC6 \n"+         			               // 24
			"       ,PTK1.TKCE \n"+         			               // 25
			
			"       ,VBA.NUMERO_FIID BANCO_ADQUIRENTE \n"+             // 26
			"       ,TO_CHAR(PTA.NUMERO_COMERCIO) NUMERO_COMERCIO \n"+ // 27
			"       ,PTA.NOMBRE_COMERCIO NOMBRE_COMERCIO \n"+          // 28
			"       ,PTA.RED_LOGICA RED_LOGICA_ADQ \n"+                // 29
			"       ,PTA.RED_LOGICA_EMI RED_LOGICA \n"+                // 30
			"       ,VBA.DESCRIPCION DESC_ADQ \n"+                     // 31
			"       ,PE.DESCRIPCION DESC_EMI \n"+                      // 32
			"       ,PTA.FIID_EMISOR BANCO_EMISOR \n"+                 // 33
			*/
					" SELECT TO_CHAR(PTA.TA_WH_SEQ) NUMERO \n"+                // 00
			" 		,PTA.ENT_NUMERO_PROSA_ADQ ADQ \n"+                 // 01
			"       ,PTA.ENT_NUMERO_PROSA_EMI EMI \n"+                 // 02
			"       ,PTA.ARCH_NUMERO FUENTE \n"+                       // 03
			"       ,PTA.PROC_NUMERO PROC \n"+                         // 04
			"       ,PTA.FIID_EMISOR BANCO_EMISOR \n"+                 // 05
			"       ,PTA.CUENTA CUENTA \n"+                            // 06
			"       ,PTA.TTR_NUMERO CVE_TXN \n"+                       // 07
			"       ,PTA.TC||'  '||PTA.TYP TYP \n"+                    // 08
			"       ,PTA.NUMERO_AUTORIZACION NO_AUT \n"+               // 09
			"       ,PTA.IMPORTE_TOTAL_TRANSAC IMPORTE \n"+            // 10
			"       ,PTA.FECHA_CONSUMO_TRANSAC||' '||TO_CHAR(PTA.FECHA_CONSUMO_TRANSAC,'HH:mm:SS') FECHA_CONSUMO_TRANSAC \n"+//11
			"       ,PTA.MODO_ENTRADA_POS MODO_ENT \n"+                // 12
			"       ,PTA.TIPO_CAPTURA TIPO_CAPTURA \n"+                // 13
			" 		,DECODE(SUBSTR(PTK2.TKB4,5,1),NULL,'B',0,'B','1','A','C') IND_EMV \n"+                     // 14
			"       ,PTA.IND_TER_CAP TERM_CAP \n"+                     // 15
			"       ,PTA.CODIGO_RESPUESTA_ISO COD_ISO \n"+             // 16
			"       ,PTA.IND_COM_ELEC ICE \n"+			               // 17
			"       ,PTK1.TKQ1 \n"+         			               // 18
			"       ,PTK1.TKQ2 \n"+         			               // 19
			"       ,PTK1.TKQ6 \n"+         			               // 20
			"       ,PTK1.TK04 \n"+         			               // 21
			"       ,PTK1.TKC0 \n"+         			               // 22
			"       ,PTK2.TKC4 \n"+         			               // 23
			"       ,PTK2.TKC6 \n"+         			               // 24
			"       ,PTK1.TKCE \n"+         			               // 25
			
			"       ,VBA.NUMERO_FIID BANCO_ADQUIRENTE \n"+             // 26
			"       ,TO_CHAR(PTA.NUMERO_COMERCIO) NUMERO_COMERCIO \n"+ // 27
			"       ,PTA.NOMBRE_COMERCIO NOMBRE_COMERCIO \n"+          // 28
			"       ,PTA.RED_LOGICA RED_LOGICA_ADQ \n"+                // 29
			"       ,PTA.RED_LOGICA_EMI RED_LOGICA \n"+                // 30
			"       ,VBA.DESCRIPCION DESC_ADQ \n"+                     // 31
			"       ,PE.DESCRIPCION DESC_EMI \n"+                      // 32
			"       ,PTA.FIID_EMISOR BANCO_EMISOR \n"+                 // 33
			
			"       ,SUBSTR(PTK1.TKQ1,1,1) TKQ1_S01 \n"+	           // 34
			"       ,SUBSTR(PTK1.TKQ1,2,1) TKQ1_S02 \n"+	           // 35
			
			"       ,SUBSTR(PTK1.TKQ2,1,2) TKQ2_S01 \n"+	           // 36
			
			"       ,SUBSTR(PTK1.TKC0,1,4) TKC0_S01 \n"+               // 37
			"       ,SUBSTR(PTK1.TKC0,5,1) TKC0_S02 \n"+               // 38
			"       ,SUBSTR(PTK1.TKC0,6,3) TKC0_S03 \n"+               // 39
			"       ,SUBSTR(PTK1.TKC0,10,10) TKC0_S04 \n"+             // 40
			"       ,SUBSTR(PTK1.TKC0,21,1) TKC0_S05 \n"+              // 41
			"       ,SUBSTR(PTK1.TKC0,22,1) TKC0_S06 \n"+              // 42
			"       ,SUBSTR(PTK1.TKC0,23,1) TKC0_S07 \n"+              // 43
			"       ,SUBSTR(PTK1.TKC0,24,1) TKC0_S08 \n"+              // 44
			"       ,SUBSTR(PTK1.TKC0,25,1) TKC0_S09 \n"+              // 45
			"       ,SUBSTR(PTK1.TKC0,26,1) TKC0_S10 \n"+              // 46
			"       ,SUBSTR(PTK1.TKC0,27,1) TKC0_S11 \n"+              // 47
			"       ,SUBSTR(PTK1.TKC0,28,1) TKC0_S12 \n"+              // 48
			
			"       ,SUBSTR(PTK2.TKC4,1,1) TKC4_S01 \n"+               // 49
			"       ,SUBSTR(PTK2.TKC4,2,1) TKC4_S02 \n"+               // 50
			"       ,SUBSTR(PTK2.TKC4,3,1) TKC4_S03 \n"+               // 51
			"       ,SUBSTR(PTK2.TKC4,4,1) TKC4_S04 \n"+               // 52
			"       ,SUBSTR(PTK2.TKC4,5,1) TKC4_S05 \n"+               // 53
			"       ,SUBSTR(PTK2.TKC4,6,1) TKC4_S06 \n"+               // 54
			"       ,SUBSTR(PTK2.TKC4,7,1) TKC4_S07 \n"+               // 55
			"       ,SUBSTR(PTK2.TKC4,8,1) TKC4_S08 \n"+               // 56
			"       ,SUBSTR(PTK2.TKC4,9,1) TKC4_S09 \n"+               // 57
			"       ,SUBSTR(PTK2.TKC4,10,1) TKC4_S10 \n"+              // 58
			"       ,SUBSTR(PTK2.TKC4,11,1) TKC4_S11 \n"+              // 59
			"       ,SUBSTR(PTK2.TKC4,12,1) TKC4_S12 \n"+              // 60
			
			"       ,SUBSTR(PTK1.TK04,1,1) TK04_S01 \n"+               // 61
			"       ,SUBSTR(PTK1.TK04,2,11) TK04_S02 \n"+              // 62
			"       ,SUBSTR(PTK1.TK04,13,1) TK04_S03 \n"+              // 63
			"       ,SUBSTR(PTK1.TK04,14,5) TK04_S04 \n"+              // 64
			"       ,SUBSTR(PTK1.TK04,19,1) TK04_S05 \n"+              // 65
			"       ,SUBSTR(PTK1.TK04,20,1) TK04_S06 \n"+              // 66
			
			"       ,SUBSTR(PTK1.TKQ6,1,2) TKQ6_S01 \n"+               // 67
			"       ,SUBSTR(PTK1.TKQ6,3,2) TKQ6_S02 \n"+               // 68
			"       ,SUBSTR(PTK1.TKQ6,5,2) TKQ6_S03 \n"+               // 69
			
			"       ,SUBSTR(PTK2.TKC6,1,40) TKC6_S01 \n"+              // 70
			"       ,SUBSTR(PTK2.TKC6,41,40) TKC6_S02 \n"+             // 71
			
			"       ,SUBSTR(PTK1.TKCE,1,40) TKCE_S01 \n"+              // 72
			"       ,SUBSTR(PTK1.TKCE,41,40) TKCE_S02 \n"+             // 73
		/* Fin Marca de Cambio WELLCOM   N-08-2253-12   29-05-2013 */

		/* Inicia modificacion WELLCOM   N-51-2098-14   13-08-2014 */

			/********** Inicio    Modificacion WELLCOM N-51-2098-14  18/02/2015 **********/
			" 		,SUBSTR(PTK2.TKB2,9,2) TKB2_S01 \n"+                //74
			" 		,SUBSTR(PTK2.TKB2,11,10)  TKB2_S02 \n"+             //75
			" 		,SUBSTR(PTK2.TKB2,21,16) TKB2_S03 \n"+              //76
			" 		,SUBSTR(PTK2.TKB2,37,12) TKB2_S04 \n"+              //77
			" 		,SUBSTR(PTK2.TKB2,49,12) TKB2_S05 \n"+              //78
			" 		,SUBSTR(PTK2.TKB2,61,4)  TKB2_S06 \n"+              //79
			" 		,SUBSTR(PTK2.TKB2,65,4)  TKB2_S07 \n"+              //80
			" 		,SUBSTR(PTK2.TKB2,69,3)  TKB2_S08 \n"+              //81
			" 		,SUBSTR(PTK2.TKB2,72,3)  TKB2_S09 \n"+              //82
			" 		,SUBSTR(PTK2.TKB2,75,6)  TKB2_S10 \n"+              //83
			" 		,SUBSTR(PTK2.TKB2,81,2)  TKB2_S11 \n"+              //84
			" 		,SUBSTR(PTK2.TKB2,83,8)  TKB2_S12 \n"+              //85
			" 		,SUBSTR(PTK2.TKB2,95,64) TKB2_S13 \n"+              //86
			
			" 		,SUBSTR(PTK2.TKB3,5,8) TKB3_S01 \n"+                //87
			" 		,SUBSTR(PTK2.TKB3,13,8) TKB3_S02 \n"+               //88
			" 		,SUBSTR(PTK2.TKB3,33,2) TKB3_S03 \n"+               //89
			" 		,SUBSTR(PTK2.TKB3,35,4) TKB3_S04 \n"+               //90
			" 		,SUBSTR(PTK2.TKB3,39,6) TKB3_S05 \n"+               //91
			" 		,SUBSTR(PTK2.TKB3,49,32) TKB3_S06 \n"+              //92
			
			" 		,SUBSTR(PTK2.TKB4,1,3) TKB4_S01 \n"+               //93
			" 		,SUBSTR(PTK2.TKB4,4,1) TKB4_S02 \n"+               //94
			" 		,SUBSTR(PTK2.TKB4,5,1) TKB4_S03 \n"+               //95
			" 		,SUBSTR(PTK2.TKB4,6,1) TKB4_S04	\n"+               //96
			" 		,SUBSTR(PTK2.TKB4,7,2) TKB4_S05	\n"+               //97
			" 		,SUBSTR(PTK2.TKB4,9,6) TKB4_S06	\n"+               //98
			" 		,SUBSTR(PTK2.TKB4,15,4) TKB4_S07 \n"+              //99
			" 		,SUBSTR(PTK2.TKB4,19,1) TKB4_S08 \n"+              //100
			" 		,SUBSTR(PTK2.TKB4,20,1) TKB4_S09 \n"+              //101
			
			" 		,SUBSTR(PTK2.TKB5,1,4) TKB5_S01 \n"+               //102
			" 		,SUBSTR(PTK2.TKB5,5,16) TKB5_S02 \n"+              //103
			" 		,SUBSTR(PTK2.TKB5,21,16) TKB5_S03 \n"+             //104
			" 		,SUBSTR(PTK2.TKB5,37,1) TKB5_S04 \n"+              //105
			" 		,SUBSTR(PTK2.TKB5,38,1) TKB5_S05 \n"+              //106
			/********** Fin    Modificacion WELLCOM N-51-2098-14  18/02/2015 **********/
		/* INICIO   Modificacion SAS N-51-2390-15  12/02/2016 */
			",CASE SUBSTR(PTK2.TKB2,15,2)"+  //107
			"	WHEN NULL THEN			"+  //107
			"		 ''					"+	//107
			"	WHEN '' THEN 			"+  //107
			"		 ''					"+	//107
			"	WHEN '00' THEN			"+	//107
			"		 'Exitoso'			"+	//107
			"	ELSE					"+	//107
			"		 		DECODE(SUBSTR(lpad(PMADMIN.FN_DEC_BIN(to_number(ltrim(rtrim(SUBSTR(PTK2.TKB2,15,2))),'XXXXXX')),8,0),1,1),'0','Exitoso','1','Fallido')"+						//107
			"END TVR,	"+//107
			"CASE		"+ //108
            "WHEN SUBSTR(PTA.CUENTA,1,1)='5' OR SUBSTR(PTA.CUENTA,1,1)='2' THEN	"+ //108
			"CASE 						"+ //108
			"	WHEN SUBSTR(PTK2.TKB2,97,2)=''THEN   "+ //108
			"		DECODE(SUBSTR(lpad(PMADMIN.FN_DEC_BIN(TO_NUMBER(ltrim(rtrim(SUBSTR(PTK2.TKB2,101,2))),'XX')),8,0),6,1),'0','No','1','Si')"+ //108
			"	WHEN SUBSTR(PTK2.TKB2,97,2)='00'THEN "+ //108
			"		DECODE(SUBSTR(lpad(nvl(PMADMIN.FN_DEC_BIN(TO_NUMBER(ltrim(rtrim(SUBSTR(PTK2.TKB2,101,2))),'XX')),'00'),8,0),6,1),'0','No','1','Si')" + //108
			"	WHEN SUBSTR(PTK2.TKB2,97,2)='01' THEN"+ //108
			"		DECODE(SUBSTR(lpad(nvl(PMADMIN.FN_DEC_BIN(TO_NUMBER(ltrim(rtrim(SUBSTR(PTK2.TKB2,101,2))),'XX')),'00'),8,0),6,1),'0','No','1','Si')	" + //108
			"	WHEN SUBSTR(PTK2.TKB2,97,2)!='01' THEN" + //108
			"		DECODE(SUBSTR(lpad(PMADMIN.FN_DEC_BIN(TO_NUMBER(ltrim(rtrim(SUBSTR(PTK2.TKB2,99,2))),'XX')),8,0),6,1),'0','No','1','Si')"+ //108
			"END				"+ //108
			"END ||				"+ //108
			"CASE				"+ //108
            "WHEN  SUBSTR(PTA.CUENTA,1,1)='4'THEN  		"+ //108
            "CASE                         "+ //108
            " WHEN SUBSTR(PTK2.TKB2,99,2)='0A'THEN   "+ //108
            "  DECODE(SUBSTR(lpad(PMADMIN.FN_DEC_BIN(TO_NUMBER(ltrim(rtrim(SUBSTR(PTK2.TKB2,103,2))),'XX')),8,0),6,1),'0','No','1','Si')"+//108
			"END 	"+ //108
			"END CVRPIN,				"+		 //108
			"CASE						"+ //109
			"WHEN SUBSTR(PTA.CUENTA,1,1)='5' OR SUBSTR(PTA.CUENTA,1,1)='2' THEN	"+ //109
			"CASE 						"+ //109
			"	WHEN SUBSTR(PTK2.TKB2,97,2)='00' THEN  "+ //109
			"	  DECODE(SUBSTR(lpad(nvl(PMADMIN.FN_DEC_BIN(TO_NUMBER(ltrim(rtrim(SUBSTR(PTK2.TKB2,101,2))),'XX')),'00'),8,0),7,1) "+  //109
			"	  ,'1','Exitoso','01','Exitoso','10','Exitoso','11','Exitoso','0','Fallido','00','Fallido')"+//109
			"	WHEN SUBSTR(PTK2.TKB2,97,2)='01' THEN  "+//109
			"	  DECODE(SUBSTR(lpad(PMADMIN.FN_DEC_BIN(TO_NUMBER(ltrim(rtrim(SUBSTR(PTK2.TKB2,101,2))),'XX')),8,0),7,1) "+//109
			"	  ,'1','Fallido','01','Fallido','10','Fallido','11','Fallido','0','Exitoso','00','Exitoso')"+//109
			"	WHEN ltrim(rtrim(SUBSTR(PTK2.TKB2,97,2)))!='01' THEN"+//109
			"	  DECODE(SUBSTR(lpad(PMADMIN.FN_DEC_BIN(TO_NUMBER(ltrim(rtrim(SUBSTR(PTK2.TKB2,99,2))),'XX')),8,0),7,2)"+//109
			"	  ,'1','Exitoso','01','Exitoso','10','Exitoso','11','Exitoso','0','Fallido','00','Fallido')"+//109
			"END                            "+//109
			"END    ||                      "+//109
			"CASE				"+ //109
            "WHEN  SUBSTR(PTA.CUENTA,1,1)='4'THEN  		"+ //109
            "CASE                         "+ //109
            " WHEN SUBSTR(PTK2.TKB2,99,2)='0A'THEN   "+ //109
            "  DECODE(SUBSTR(lpad(PMADMIN.FN_DEC_BIN(TO_NUMBER(ltrim(rtrim(SUBSTR(PTK2.TKB2,103,2))),'XX')),8,0),7,1),'0','Exitoso','1','Fallido')"+//109
			"END 	"+ //109
			"END CVRESULTS,				"+//109
			"CASE  "+//110
			"	WHEN SUBSTR(PTK2.TKB3,39,2)='' THEN "+//110
			"		DECODE(nvl(PMADMIN.FN_DEC_BIN(TO_NUMBER(ltrim(rtrim(SUBSTR(PTK2.TKB3,39,2))),'XXXXXX')),'000000'),'000000','Falló CVM','000001'	 "+//110
			"		,'Verificación del PIN en texto plano realizada por el ICC', '000010','Verificación en línea del PIN cifrado'  "+//110
			"		,'000011','Verificación del PIN en texto plano realizada por el ICC y firma (papel)','000100' "+//110
			"		,'Verificación del PIN cifrado realizada por el ICC','000101','Verificación del PIN cifrado realizada por el ICC y firma (papel)','011110','Firma (papel)','011111','No se requirió CVM')"+//110
			"	WHEN SUBSTR(PTK2.TKB3,39,2)='00' THEN  "+//110
			"		DECODE(nvl(PMADMIN.FN_DEC_BIN(TO_NUMBER(ltrim(rtrim(SUBSTR(PTK2.TKB3,39,2))),'XXXXXX')),'000000'),'000000','Falló CVM','000001'	 "+//110
			"		,'Verificación del PIN en texto plano realizada por el ICC', '000010','Verificación en línea del PIN cifrado'  "+//110
			"		,'000011','Verificación del PIN en texto plano realizada por el ICC y firma (papel)','000100' "+//110
			"		,'Verificación del PIN cifrado realizada por el ICC','000101','Verificación del PIN cifrado realizada por el ICC y firma (papel)','011110','Firma (papel)','011111','No se requirió CVM')"+//110
			"	ELSE "+//110
			"		DECODE(SUBSTR(lpad(PMADMIN.FN_DEC_BIN(TO_NUMBER(ltrim(rtrim(SUBSTR(PTK2.TKB3,39,2))),'XXXXXX')),8,0),3,6),'000000','Falló CVM','000001'	 "+//110
			"		,'Verificación del PIN en texto plano realizada por el ICC', '000010','Verificación en línea del PIN cifrado'  "+//110
			"		,'000011','Verificación del PIN en texto plano realizada por el ICC y firma (papel)','000100' "+//110
			"		,'Verificación del PIN cifrado realizada por el ICC','000101','Verificación del PIN cifrado realizada por el ICC y firma (papel)','011110','Firma (papel)','011111','No se requirió CVM')"+//110
			"END CVMRESULTS"+//110
			",DECODE(SUBSTR(PTK2.TKB3,43,2),'00','Desconocido','01','Fallido','02','Exitoso')CVM "+//111
		/**************** FIN   Modificacion SAS N-51-2390-15  12/02/2016***********************/	
		/*	********** INICIO Implementación SAS N-51-2823-15  11/08/2016  *************** */
			",CASE SUBSTR(PTK2.TKB2,+15,2) WHEN NULL THEN ''	" +//112
			"WHEN '' THEN ''	"+//112
			"WHEN '00' THEN '0'	"+//112
			"ELSE SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(PTK2.TKB2,+15,2))),'XX')),8,0),4,1)	"+//112
			"END TVRPINB	"+//112
			",CASE SUBSTR(PTK2.TKB2,+15,2) WHEN NULL THEN ''	"+//113
			"WHEN '' THEN ''	"+//113
			"WHEN '00' THEN '0'	"+//113
			"ELSE SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(PTK2.TKB2,+15,2))),'XX')),8,0),5,1)	END TVRQPSPIN	"+//113
			",CASE SUBSTR(PTK3.TKCZ,+5,2)	"+//114
			"WHEN '' THEN ''	"+//114
			"WHEN SUBSTR(PTK3.TKCZ,+5,2) THEN SUBSTR(PTK3.TKCZ,+5,2) END TOKNCZ		"+//114
			/* ********** FIN Implementación SAS N-51-2823-15  11/08/2016  *************** */	
		/* Fin    modificacion WELLCOM   N-51-2098-14   13-08-2014 */
			" FROM PMADMIN.PRSA_TXN_ACEPTADAS PTA \n"+
			" INNER JOIN PMADMIN.VW_BUS_ACQ VBA \n"+
			"     ON VBA.NUMERO_PROSA = PTA.ENT_NUMERO_PROSA_ADQ \n"+
			" INNER JOIN PMADMIN.PRSA_ENTIDADES PE \n"+
			"     ON PE.NUMERO_PROSA = PTA.ENT_NUMERO_PROSA_EMI \n"+
			" INNER JOIN PMADMIN.PRSA_TIPOS_TRANSACCION PTT \n"+
			"     ON PTT.NUMERO = PTA.TTR_NUMERO \n"+
			" LEFT JOIN PMTW.POS_T_TKN1 PTK1  \n"+
			"     ON PTK1.PARTITION_ID = PTA.PARTITION_ID  \n"+
			"     AND PTK1.POS_TRAN_ID_KEY = PTA.TA_WH_SEQ \n"+
			" LEFT JOIN PMTW.POS_T_TKN2 PTK2  \n"+
			"     ON PTK2.PARTITION_ID = PTA.PARTITION_ID  \n"+
			"     AND PTK2.POS_TRAN_ID_KEY = PTA.TA_WH_SEQ \n"+
			/*	********** INICIO Implementación SAS N-51-2823-15  11/08/2016  *************** */
			" LEFT JOIN PMTW.POS_T_TKN3 PTK3	\n"+
			"  ON PTK3.PARTITION_ID = PTA.PARTITION_ID \n"+
			"	 AND PTK3.POS_TRAN_ID_KEY = PTA.TA_WH_SEQ  \n"+
			/*	********** FIN Implementación SAS N-51-2823-15  11/08/2016  *************** */
			" WHERE PTA.PARTITION_ID BETWEEN (SELECT PMADMIN.FN_PARTITION_ID(TO_DATE('"+params.initDate+"','DD/MM/YYYY')) FROM DUAL) \n"+
			"                            AND (SELECT PMADMIN.FN_PARTITION_ID(TO_DATE('"+params.endDate+"','DD/MM/YYYY')) FROM DUAL) \n"+
			" AND PTA.CUENTA = '"+params.cuenta+"' ";
			if (!params.session.getAttribute("fechaXML").toString().equals("01/01/2000")){
			query+=" AND PTA.PARTITION_ID >= (SELECT PMADMIN.FN_PARTITION_ID(TO_DATE('"+params.session.getAttribute("fechaXML").toString()+"','DD/MM/YYYY')) FROM DUAL) \n";
		}

		if ((params.referencia!="") && (params.referencia!=null) && (params.referencia!="null"))
		{
			query+=" AND PTA.NUMERO_REFERENCIA = "+params.referencia+" ";
		}

		if ((params.comercio!="") && (params.comercio!=null) && (params.comercio!="null"))
		{
			query+=" AND PTA.NUMERO_COMERCIO = "+params.comercio+" ";
		}

		return query;
	}
	/********** Fin    Modificacion WELLCOM N-08-2253-12  **********/

	/********** Inicio    Modificacion WELLCOM N-08-2253-12  13/05/2013 **********/
	public static String SICMORPTLF(TableParams params)
	{
		String query = "";
		String where = "";
			if (params.initDate.toString().equals("01"))
			{
				query = " SELECT /*index (TA ENE51_NDX51)*/ \n";
	/********** Inicio    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
				where = " FROM SSAUD.TANDEMENE51@LG_PMTU_PTLF TA \n";
	/********** Fin    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
			}
			else if (params.initDate.toString().equals("02"))
			{
				query = " SELECT /*index (TA FEB51_NDX51)*/ \n";
	/********** Inicio    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
				where = " FROM SSAUD.TANDEMFEB51@LG_PMTU_PTLF TA \n";
	/********** Fin    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
			}
			else if (params.initDate.toString().equals("03"))
			{
				query = " SELECT /*index (TA MAR51_NDX51)*/ \n";
	/********** Inicio    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
				where = " FROM SSAUD.TANDEMMAR51@LG_PMTU_PTLF TA \n";
	/********** Fin    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
			}
			else if (params.initDate.toString().equals("04"))
			{
				query = " SELECT /*index (TA ABR51_NDX51)*/ \n";
	/********** Inicio    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
				where = " FROM SSAUD.TANDEMABR51@LG_PMTU_PTLF TA \n";
	/********** Fin    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
			}
			else if (params.initDate.toString().equals("05"))
			{
				query = " SELECT /*index (TA MAY51_NDX51)*/ \n";
	/********** Inicio    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
				where = " FROM SSAUD.TANDEMMAY51@LG_PMTU_PTLF TA \n";
	/********** Fin    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
			}
			else if (params.initDate.toString().equals("06"))
			{
				query = " SELECT /*index (TA JUN51_NDX51)*/ \n";
	/********** Inicio    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
				where = " FROM SSAUD.TANDEMJUN51@LG_PMTU_PTLF TA \n";
	/********** Fin    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
			}
			else if (params.initDate.toString().equals("07"))
			{
				query = " SELECT /*index (TA JUL51_NDX51)*/ \n";
	/********** Inicio    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
				where = " FROM SSAUD.TANDEMJUL51@LG_PMTU_PTLF TA \n";
	/********** Fin    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
			}
			else if (params.initDate.toString().equals("08"))
			{
				query = " SELECT /*index (TA AGO51_NDX51)*/ \n";
	/********** Inicio    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
				where = " FROM SSAUD.TANDEMAGO51@LG_PMTU_PTLF TA \n";
	/********** Fin    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
			}
			else if (params.initDate.toString().equals("09"))
			{
				query = " SELECT /*index (TA SEP51_NDX51)*/ \n";
	/********** Inicio    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
				where = " FROM SSAUD.TANDEMSEP51@LG_PMTU_PTLF TA \n";
	/********** Fin    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
			}
			else if (params.initDate.toString().equals("10"))
			{
				query = " SELECT /*index (TA OCT51_NDX51)*/ \n";
	/********** Inicio    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
				where = " FROM SSAUD.TANDEMOCT51@LG_PMTU_PTLF TA \n";
	/********** Fin    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
			}
			else if (params.initDate.toString().equals("11"))
			{
				query = " SELECT /*index (TA NOV51_NDX51)*/ \n";
	/********** Inicio    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
				where = " FROM SSAUD.TANDEMNOV51@LG_PMTU_PTLF TA \n";
	/********** Fin    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
			}
			else if (params.initDate.toString().equals("12"))
			{
				query = " SELECT /*index (TA DIC51_NDX51)*/ \n";
	/********** Inicio    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
				where = " FROM SSAUD.TANDEMDIC51@LG_PMTU_PTLF TA \n";
	/********** Fin    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
			}
		
		query+=
		" TA.NUMERO NUMERO \n "+																						//00
		/********** Inicio    Modificacion WELLCOM N-04-2207-12  11/03/2014 **********/	
		//" ,(SELECT DISTINCT PE.ENTIDAD_PADRE FROM PMADMIN.PRSA_ENTIDADES PE WHERE PE.NUMERO_FIID = TA.FIIDC) ADQ \n "+
		//" ,(SELECT DISTINCT PE.ENTIDAD_PADRE FROM PMADMIN.PRSA_ENTIDADES PE WHERE PE.NUMERO_FIID = TA.FIID) EMI \n "+
		// INICIA MODIFICACION WELL-D-52-8122-17 22-08-2017
		//" ,(SELECT DISTINCT PE.ENTIDAD_PADRE FROM PMADMIN.PRSA_ENTIDADES PE WHERE PE.NUMERO_FIID = DECODE(TA.FIIDC,'EGLO','EOTR',TA.FIIDC)) ADQ \n "+  //01
		" ,(SELECT DISTINCT PE.ENTIDAD_PADRE FROM PMADMIN.PRSA_ENTIDADES PE WHERE PE.NUMERO_FIID = DECODE(TA.FIIDC,'EGLO','EOTR',TA.FIIDC) AND ROWNUM=1) ADQ \n "+  //01
		// FIN MODIFICACION WELL-D-52-8122-17 22-08-2017
		" ,(SELECT DISTINCT PE.ENTIDAD_PADRE FROM PMADMIN.PRSA_ENTIDADES PE WHERE PE.NUMERO_FIID = DECODE(TA.FIID ,'EGLO','EOTR',TA.FIID ) AND ROWNUM=1) EMI \n "+  //02
		/********** Fin    Modificacion WELLCOM N-04-2207-12  11/03/2014 **********/	
		" ,TA.FIID FIID_EMISOR \n "+																					//03
		" ,TA.NUM CUENTA \n "+																							//04
		" ,TA.TC||' '||TA.TYP CLAVE_TXS \n "+																			//05
		" ,TA.APPRV_CDE AUTORIZACION \n "+																				//06
	/********** Inicio    Modificacion WELLCOM N-04-2207-12  03/03/2014 **********/		
		" ,TO_CHAR(TO_NUMBER(SUBSTR(AMT_1,0,16)||'.'||SUBSTR(AMT_1,17,18)),'9,999,999,999,999,999.99') IMPORTE \n "+	//07
	/********** Fin       Modificacion WELLCOM N-04-2207-12  03/03/2014 **********/
		" ,TA.PT_SRV_ENTRY_MDE MODO_ENTRADA \n "+																		//08
		" ,SUBSTR(CH.TKN_C4,21,1) TER_CAP \n "+																			//09
		" ,CH.TKN_Q1 TK1 \n "+																							//10
		" ,CH.TKN_Q2_ID_ACCESO TK2 \n "+																				//11
		" ,CH.TKN_Q6 TK3 \n "+																							//12
		" ,CH.TKN_04 TK4 \n "+																							//13
		" ,TT.C0_01||TT.C0_02||TT.C0_03||TT.C0_04||TT.C0_05||TT.C0_06||TT.C0_07||TT.C0_08||TT.C0_09"+
				  "||TT.C0_10||TT.C0_11||TT.C0_12 TK5 \n "+																//14
		" ,CH.TKN_C4 TK6 \n "+																									//15
		" ,CH.TKN_C6 TK7 \n "+																							//16
		" ,CH.TKN_CE TK8 \n "+																							//17
		" ,TA.LN RED_LOGICA \n "+																						//18
		" ,TA.TERM_ID TERMINAL_ID \n "+																					//19
		" ,TA.TC TC \n "+																								//20
		/********** Inicio    Modificacion WELLCOM N-04-2207-12  03/03/2014 **********/
		" ,TA.YYA||'-'||MMA||'-'||DDA||' '||HHA||':'||MMAA||':'||SSA FECHA_CONSUMO \n "+								//21
		/********** Fin       Modificacion WELLCOM N-04-2207-12  03/03/2014 **********/
		" ,TA.RETAILER_ID NUM_COMERCIO \n "+																			//22
		" ,DECODE(TA.T,1,'C',2,'D','X') NAT_CON \n "+																	//23
		" ,TA.RESP_CDE CODIGO_RESPUESTA \n "+																			//24
		" ,DECODE(SUBSTR(CH.TKN_Q9,13,1),'2','A','6','A','1','B','5','B','C') SERV_CODE \n "+							//25
		" ,TA.TERM_CITY CIUDAD \n "+																					//26
		" ,TA.TERM_CNTRY_CDE PAIS \n "+																					//27
		" ,TTE.B4_ARQC_VRFY ARQC \n "+																					//28
		" ,TA.RETL_SIC_CDE GIRO \n "+																					//29
		/********** Inicio    Modificacion WELLCOM N-04-2207-12  25/03/2014 **********/
		" ,TO_CHAR(TO_NUMBER(NVL(SUBSTR(AMT_2,0,7),0)||'.'||NVL(SUBSTR(AMT_2,8,9),0)),'9,999,999.99') IMPORTE \n "+		//30
		/********** Fin       Modificacion WELLCOM N-04-2207-12  25/03/2014 **********/
		" ,TA.TERM_ID TERM_NUM \n "+																					//31
		" ,SUBSTR(CH.TKN_C4,21,1) IND_CAP_TERM \n "+																	//32
		" ,TT.C0_05 IND_COM \n "+																								//33
		
		/********** Inicio    Modificacion WELLCOM N-04-2207-12  25/03/2014 **********/
		" ,SUBSTR(SUBSTR(CH.TKN_Q1,11,LENGTH(CH.TKN_Q1)),1,1) TKQ1_S01 \n "+											//34
		" ,SUBSTR(SUBSTR(CH.TKN_Q1,11,LENGTH(CH.TKN_Q1)),2,1) TKQ1_S02 \n "+											//35
		/********** Fin       Modificacion WELLCOM N-04-2207-12  25/03/2014 **********/
		
		" ,CH.TKN_Q2_ID_ACCESO TKQ2_S01 \n "+																			//36
		
		" ,TT.C0_01 TKC0_S01 \n "+																						//37
		" ,TT.C0_02 TKC0_S02 \n "+																						//38
		" ,TT.C0_03 TKC0_S03 \n "+																						//39
		" ,TT.C0_04 TKC0_S04 \n "+																						//40
		" ,TT.C0_05 TKC0_S05 \n "+																						//41
		" ,TT.C0_06 TKC0_S06 \n "+																						//42
		" ,TT.C0_07 TKC0_S07 \n "+																						//43
		" ,TT.C0_08 TKC0_S08 \n "+																						//44
		" ,TT.C0_09 TKC0_S09 \n "+																						//45
		" ,TT.C0_10 TKC0_S10 \n "+																						//46
		" ,TT.C0_11 TKC0_S11 \n "+																						//47
		" ,TT.C0_12 TKC0_S12 \n "+																						//48
		
		/********** Inicio    Modificacion WELLCOM N-04-2207-12  25/03/2014 **********/
		" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),1,1) TKC4_S01 \n "+											//49
		" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),2,1) TKC4_S02 \n "+											//50
		" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),3,1) TKC4_S03 \n "+											//51
		" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),4,1) TKC4_S04 \n "+											//52
		" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),5,1) TKC4_S05 \n "+											//53
		" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),6,1) TKC4_S06 \n "+											//54
		" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),7,1) TKC4_S07 \n "+											//55
		" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),8,1) TKC4_S08 \n "+											//56
		" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),9,1) TKC4_S09 \n "+											//57
		" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),10,1) TKC4_S010 \n "+											//58
		" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),11,1) TKC4_S011 \n "+											//59
		" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),12,1) TKC4_S012 \n "+											//60
		
		" ,SUBSTR(SUBSTR(CH.TKN_04,11,LENGTH(CH.TKN_04)),1,1) TK04_S01 \n "+											//61
		" ,SUBSTR(SUBSTR(CH.TKN_04,11,LENGTH(CH.TKN_04)),2,11) TK04_S02 \n "+											//62
		" ,SUBSTR(SUBSTR(CH.TKN_04,11,LENGTH(CH.TKN_04)),13,1) TK04_S03 \n "+											//63
		" ,SUBSTR(SUBSTR(CH.TKN_04,11,LENGTH(CH.TKN_04)),14,5) TK04_S04 \n "+											//64
		" ,SUBSTR(SUBSTR(CH.TKN_04,11,LENGTH(CH.TKN_04)),19,1) TK04_S05 \n "+											//65
		" ,SUBSTR(SUBSTR(CH.TKN_04,11,LENGTH(CH.TKN_04)),20,1) TK04_S06 \n "+											//66
		
		" ,SUBSTR(SUBSTR(CH.TKN_Q6,11,LENGTH(CH.TKN_Q6)),1,2) TKQ6_S01 \n "+											//67
		" ,SUBSTR(SUBSTR(CH.TKN_Q6,11,LENGTH(CH.TKN_Q6)),3,2) TKQ6_S02 \n "+											//68
		" ,SUBSTR(SUBSTR(CH.TKN_Q6,11,LENGTH(CH.TKN_Q6)),5,2) TKQ6_S03 \n "+											//69
		
		" ,SUBSTR(SUBSTR(CH.TKN_C6,11,LENGTH(CH.TKN_C6)),1,40) TKC6_S01 \n "+											//70
		" ,SUBSTR(SUBSTR(CH.TKN_C6,11,LENGTH(CH.TKN_C6)),41,40) TKC6_S02 \n "+											//71
		
		" ,SUBSTR(SUBSTR(CH.TKN_CE,11,LENGTH(CH.TKN_CE)),1,40) TKCE_S01 \n "+											//72
		" ,SUBSTR(SUBSTR(CH.TKN_CE,11,LENGTH(CH.TKN_CE)),41,40) TKCE_S02 \n "+											//73
		/********** Fin    Modificacion WELLCOM N-04-2207-12  25/03/2014 **********/

		/********** Inicio    Modificacion WELLCOM N-51-2098-14  14/08/2014 **********/
		/********** Inicio    Modificacion WELLCOM N-51-2098-14  18/02/2015 **********/
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+18,2) TKB2_S01 \n"+           //74
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+20,10) TKB2_S02 \n"+          //75
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+30,16) TKB2_S03 \n"+          //76
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+46,12) TKB2_S04 \n"+          //77
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+58,12) TKB2_S05 \n"+          //78
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+70,4) TKB2_S06 \n"+           //79
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+74,4) TKB2_S07 \n"+           //80
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+78,3) TKB2_S08 \n"+           //81
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+81,3) TKB2_S09 \n"+           //82
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+84,6) TKB2_S10 \n"+           //83
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+90,2) TKB2_S11 \n"+           //84
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+92,8) TKB2_S12 \n"+           //85
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+104,64) TKB2_S13 \n"+         //86
		
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+14,8) TKB3_S01 \n"+          //87
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+22,8) TKB3_S02 \n"+          //88
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+42,2) TKB3_S03 \n"+          //89
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+44,4) TKB3_S04 \n"+          //90
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+48,6) TKB3_S05 \n"+          //91
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+58,32) TKB3_S06 \n"+         //92
		
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+10,3) TKB4_S01 \n"+          //93
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+13,1) TKB4_S02 \n"+          //94
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+14,1) TKB4_S03 \n"+          //95
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+15,1) TKB4_S04 \n"+          //96
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+16,2) TKB4_S05 \n"+          //97
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+18,6) TKB4_S06 \n"+          //98
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+24,4) TKB4_S07 \n"+          //99
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+28,1) TKB4_S08 \n"+          //100
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+29,1) TKB4_S09 \n"+          //101
		
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B5')+10,4) TKB5_S01 \n"+          //102
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B5')+14,16) TKB5_S02 \n"+         //103
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B5')+30,16) TKB5_S03 \n"+         //104
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B5')+46,1) TKB5_S04 \n"+          //105
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B5')+47,1) TKB5_S05 \n"+          //106
		/**************** INICIO   Modificacion SAS N-51-2390-15  12/02/2016***********************/
		",CASE SUBSTR(CH.TKN_EMVFULL ,INSTR(CH.TKN_EMVFULL,'! B2')+24,2) "+//107
		"    WHEN NULL THEN      	 "+//107
		"         ''				 "+//107
		"    WHEN '' THEN  			 "+//107
		"         ''				 "+//107
		"    WHEN '00' THEN  		 "+//107
		"         'Exitoso'			 "+//107
		"    ELSE								 "+//107
		"         DECODE(SUBSTR(lpad(PMADMIN.FN_DEC_BIN(to_number(ltrim(rtrim(SUBSTR(CH.TKN_EMVFULL  "+//107
		"         ,INSTR(CH.TKN_EMVFULL,'! B2')+24,2))),'XXXXXX')),8,0),1,1),'0','Exitoso','1','Fallido')		"+//107
		"END TVR,			"+//107
		 "  CASE 	"+//108
		 "   WHEN SUBSTR(TA.NUM,1,1)='5' OR SUBSTR(TA.NUM,1,1)='2' THEN 	"+//108
		 "     CASE	"+//108
		 "      WHEN LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+106,2)))='00' THEN 	"+//108
		 "         DECODE(SUBSTR(LPAD(NVL(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL     	"+//108
		 "         ,INSTR(CH.TKN_EMVFULL,'! B2')+110,2))),'XX')),'00'),8,0),6,1),'0','No','1','Si')	"+//108
		 "      WHEN LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+106,2)))!='01' THEN 	"+//108
		 "         DECODE(SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL  	"+//108   
		 "         ,INSTR(CH.TKN_EMVFULL,'! B2')+108,2))),'XX')),8,0),6,1) ,'0','No','1','Si') 	"+//108
		 "      WHEN LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+106,2)))='01' THEN 	"+//108
		 "         DECODE(SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL "+//108
		 "         ,INSTR(CH.TKN_EMVFULL,'! B2')+110,2))),'XX')),8,0),6,1),'0','No','1','Si')   "+//108
		 "     END 	"+//108
		 "  END || 	"+//108
		 "      CASE WHEN SUBSTR(TA.NUM,1,1)='4' THEN	"+//108
		 "          CASE SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+108,2)  "+//108
		 "           WHEN NULL THEN '' WHEN '' THEN '' WHEN '00' THEN 'No'  "+//108
		 "          ELSE DECODE(SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+112,2))),'XX')) "+//108
		 "           ,8,0),6,1),'0','No','1','Si') "+//108
		 "          END 	"+//108
		 "      END CVRPIN,	"+//108
		 "CASE "+ //109
		 "  WHEN SUBSTR(TA.NUM,1,1)='5' OR SUBSTR(TA.NUM,1,1)='2' THEN	"+ //109
		 " CASE 	"+ //109
		 "  WHEN LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+106,2)))='00' THEN  	"+ //109
		 "     DECODE(SUBSTR(LPAD(NVL(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL     	"+ //109
		 "     ,INSTR(CH.TKN_EMVFULL,'! B2')+110,2))),'XX')),'00'),8,0),7,1),'1','Exitoso','01','Exitoso','10','Exitoso','11','Exitoso','0','Fallido','00','Fallido') "+ //109
		 "  WHEN LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+106,2)))='01' THEN  "+ //109
		 "     DECODE(SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL  "+ //109   
		 "     ,INSTR(CH.TKN_EMVFULL,'! B2')+110,2))),'XX')),8,0),7,1),'1','Fallido','01','Fallido','10','Fallido','11','Fallido','0','Exitoso','00','Exitoso') 	"+ //109
		 "  WHEN LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+106,2)))!='01' THEN 	"+ //109
		 "     DECODE(SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL    	"+ //109  
		 "     ,INSTR(CH.TKN_EMVFULL,'! B2')+108,2))),'XX')),8,0),7,2),'1','Exitoso','01','Exitoso','10','Exitoso','11','Exitoso','0','Fallido','00','Fallido')	"+ //109
		 " END	"+ //109
		 "END ||	"+ //109
		 "CASE WHEN SUBSTR(TA.NUM,1,1)='4' THEN	"+ //109
		 "          CASE SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+108,2) "+ //109
		 "             WHEN NULL THEN '' WHEN '' THEN '' WHEN '00' THEN 'Fallido' "+ //109
		 "           ELSE  DECODE(SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+112,2))),'XX'))	"+ //109 
		 "             ,8,0),7,1),'0','Exitoso','1','Fallido') 	"+ //109
		 "          END 	"+ //109
		 "END CVRRESULT,	"+ //109
		"CASE "+//110
		"    WHEN SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+48,2)=''THEN "+//110
		"         DECODE(NVL(PMADMIN.FN_DEC_BIN(to_number(ltrim(rtrim(SUBSTR(CH.TKN_EMVFULL  "+//110
		"        ,INSTR(CH.TKN_EMVFULL,'! B3')+48,2))),'XXXXXX')),'000000'),'000000','Falló CVM','000001'   "+//110
		"        ,'Verificación del PIN en texto plano realizada por el ICC', '000010','Verificación en línea del PIN cifrado'   "+//110
		"        ,'000011','Verificación del PIN en texto plano realizada por el ICC y firma (papel)','000100' "+//110
		"        ,'Verificación del PIN cifrado realizada por el ICC','000101','Verificación del PIN cifrado realizada por el ICC y firma (papel)','011110','Firma (papel)','011111','No se requirió CVM') "+//110
		"    WHEN SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+48,2)= NULL THEN "+//110
		"         DECODE(NVL(PMADMIN.FN_DEC_BIN(to_number(ltrim(rtrim(SUBSTR(CH.TKN_EMVFULL   "+//110
		"        ,INSTR(CH.TKN_EMVFULL,'! B3')+48,2))),'XXXXXX')),'000000'),'000000','Falló CVM','000001' "+//110
		"        ,'Verificación del PIN en texto plano realizada por el ICC', '000010','Verificación en línea del PIN cifrado'   "+//110
		"        ,'000011','Verificación del PIN en texto plano realizada por el ICC y firma (papel)','000100' "+//110
		"        ,'Verificacion del PIN cifrado realizada por el ICC','000101','Verificación del PIN cifrado realizada por el ICC y firma (papel)','011110','Firma (papel)','011111','No se requirió CVM') "+//110
		"    WHEN SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+48,2)='00' THEN  "+//110
		"        DECODE(NVL(PMADMIN.FN_DEC_BIN(to_number(ltrim(rtrim(SUBSTR(CH.TKN_EMVFULL    "+//110
		"        ,INSTR(CH.TKN_EMVFULL,'! B3')+48,2))),'XXXXXX')),'000000'),'000000','Falló CVM','000001' "+//110
		"        ,'Verificación del PIN en texto plano realizada por el ICC', '000010','Verificación en línea del PIN cifrado'  "+//110
		"        ,'000011','Verificación del PIN en texto plano realizada por el ICC y firma (papel)','000100'  "+//110
		"        ,'Verificación del PIN cifrado realizada por el ICC','000101','Verificación del PIN cifrado realizada por el ICC y firma (papel)','011110','Firma (papel)','011111','No se requirió CVM') "+//110
		" ELSE   "+//110
		"        DECODE(SUBSTR(lpad(PMADMIN.FN_DEC_BIN(to_number(ltrim(rtrim(SUBSTR(CH.TKN_EMVFULL      "+//110
		"        ,INSTR(CH.TKN_EMVFULL,'! B3')+48,2))),'XXXXXX')),8,0),3,6),'000000','Falló CVM','000001'    "+//110  
		"        ,'Verificación del PIN en texto plano realizada por el ICC', '000010','Verificación en línea del PIN cifrado'  "+//110
		"        ,'000011','Verificación del PIN en texto plano realizada por el ICC y firma (papel)','000100'  "+//110
		"        ,'Verificación del PIN cifrado realizada por el ICC','000101','Verificación del PIN cifrado realizada por el ICC y firma (papel)'  "+//110
		"        ,'011110','Firma (papel)','011111','No se requirio CVM') "+//110
		"END CVMRESULT "+//110
		",DECODE(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+52,2),'00','Desconocido','01','Fallido','02','Exitoso') CVR "+//111
		//	" ,SUBSTR(SUBSTR(CH.TKN_R4,11,LENGTH(CH.TKN_R4)),1,20) TKN_R4 \n"+				   //112
		/**************** FIN   Modificacion SAS N-51-2390-15  12/02/2016***********************/
		/***************  INICIO Implementación SAS N-51-2823-15_LMRV  11/08/2016  ****************/
		",CASE		  	"+//112
			"SUBSTR(TTE.B2_TVR,+5,2)	"+//112
			"WHEN '00'  THEN '0' 	"+//112
			"ELSE SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(TTE.B2_TVR,+5,2))),'XX')),8,0),4,1) 	"+//112
		"END TVRPINBPSH 	"+//112
		",CASE  	"+//113
			"SUBSTR(TTE.B2_TVR,+5,2)		"+//113
			"WHEN '00'  THEN '0' 		"+//113
			"ELSE SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(TTE.B2_TVR,+5,2))),'XX')),8,0),5,1)		"+//113
		"END TVRQPSSPSH 	"+//113
		",CASE SUBSTR(TTQH.TKN_CZ,INSTR(TTQH.TKN_CZ,'! CZ')+15,2) 	"+//114
			"WHEN '' THEN ''	"+//114
			"WHEN NULL THEN ''		"+//114
			"WHEN SUBSTR(TTQH.TKN_CZ,INSTR(TTQH.TKN_CZ,'! CZ')+15,2) 		"+//114
			"THEN SUBSTR(TTQH.TKN_CZ,INSTR(TTQH.TKN_CZ,'! CZ')+15,2) END TKCZ		";//114
		/***************  FIN Implementación SAS N-51-2823-15_LMRV  11/08/2016  ****************/	
		/********** Fin       Modificacion WELLCOM N-51-2098-14  18/02/2015 **********/
		/********** Fin       Modificacion WELLCOM N-51-2098-14  14/08/2014 **********/
		query=query+where+
	/********** Inicio    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
			" LEFT JOIN SSAUD.TBL_PTLFCHIP@LG_PMTU_PTLF CH \n"+
	/********** Fin    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
			" ON TA.NUMERO = CH.NUMERO \n"+
	/********** Inicio    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
			" LEFT JOIN SSAUD.TBL_TKNS_EMV@LG_PMTU_PTLF TTE \n"+ 
	/********** Fin    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
			" ON TA.NUMERO = TTE.NUMERO \n"+
	/********** Inicio    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
			" LEFT JOIN SSAUD.TBL_TOKENC0@LG_PMTU_PTLF TT \n"+ 
	/********** Fin    Modificacion WELLCOM N-04-2207-12  21/08/2013 **********/
	/********** Inicio    Modificacion WELLCOM N-04-2207-12  24/02/2014 **********/
			" ON TA.NUMERO = TT.NUMERO \n"+		
			/***************  INICIO Implementación SAS N-51-2823-15_LMRV  11/08/2016  ****************/
			" LEFT JOIN SSAUD.TBL_TOKENQH@LG_PMTU_PTLF TTQH \n"+
			"     ON TA.NUMERO = TTQH.NUMERO \n"+
			/***************  FIN Implementación SAS N-51-2823-15_LMRV  11/08/2016  ****************/			
			" WHERE 1=1 \n"+
			" AND TA.NUM = '"+params.comercio+"' \n";
	// INICIA MODIFICACION WELL-F-52-8181-17 17-10-2017		
	//		" AND TA.NUM = '"+params.comercio+"' \n"+
	//" AND TO_DATE((TA.DDA||'/'||TA.MMA||'/'||TA.YYA),'DD/MM/YY') >= TO_DATE('01/"+params.initDate+'/'+params.endDate+"','DD/MM/YYYY') \n";
	// FIN MODIFICACION WELL-F-52-8181-17 17-10-2017
			if ((params.cuenta!="") && (params.cuenta!=null) && (params.cuenta!="null"))
				query+=" AND TA.RETAILER_ID IN ("+params.cuenta+") \n";			
	/********** Fin    Modificacion WELLCOM N-04-2207-12  24/02/2014 **********/	
	/* ====== WELLCOM P-02-0256-12 20/08/2015 Inicia Cambio de Banistmo ====== */
			
			query+=
			" UNION ALL \n"+
				" SELECT /*index (TP NDX_NUM_PMM)*/ \n"+                                  
				" TP.RCRD_NUM NUMERO  \n"+                  //00
				" ,(SELECT DISTINCT PE.ENTIDAD_PADRE FROM PMADMIN.PRSA_ENTIDADES PE WHERE PE.NUMERO_FIID = DECODE(TP.FIIDC,'EGLO','EOTR',TP.FIIDC)) ADQ \n"+  //01 
				" ,(SELECT DISTINCT PE.ENTIDAD_PADRE FROM PMADMIN.PRSA_ENTIDADES PE WHERE PE.TIE_NUMERO = 13 AND PE.NUMERO_FIID = DECODE(TP.FIID ,'EGLO','EOTR',TP.FIID )) EMI \n"+ //02 
				" ,TP.FIID FIID_EMISOR  \n"+ //03
				" ,TP.NUM CUENTA  \n"+   //04
				" ,TP.TC||' '||TP.TYP CLAVE_TXS \n"+ //05 
				" ,TP.APPRV_CDE AUTORIZACION  \n"+ //06
				" ,TO_CHAR(TO_NUMBER(SUBSTR(TP.AMT_1,0,16)||'.'||SUBSTR(TP.AMT_1,17,18)),'9,999,999,999,999,999.99') IMPORTE \n"+    //07 
				" ,TP.PT_SRV_ENTRY_MDE MODO_ENTRADA  \n"+    //08
				" ,SUBSTR(CH.TKN_C4,21,1) TER_CAP  \n"+    //09
				" ,CH.TKN_Q1 TK1  \n"+    //10
				" ,CH.TKN_Q2_ID_ACCESO TK2 \n"+    //11 
				" ,CH.TKN_Q6 TK3  \n"+    //12
				" ,CH.TKN_04 TK4  \n"+    //13
				" ,TT.C0_01||TT.C0_02||TT.C0_03||TT.C0_04||TT.C0_05||TT.C0_06||TT.C0_07||TT.C0_08||TT.C0_09||TT.C0_10||TT.C0_11||TT.C0_12 TK5 \n"+     //14
				" ,CH.TKN_C4 TK6  \n"+    //15
				" ,CH.TKN_C6 TK7  \n"+    //16
				" ,CH.TKN_CE TK8  \n"+    //17
				" ,TP.LN RED_LOGICA  \n"+    //18
				" ,TP.TERM_ID TERMINAL_ID  \n"+    //19
				" ,TP.TC TC  \n"+    //20
				" ,TP.YYA||'-'||TP.MMA||'-'||TP.DDA||' '||TP.HHA||':'||TP.MMAA||':'||SSA FECHA_CONSUMO \n"+    //21 
				" ,TP.RETAILER_ID NUM_COMERCIO  \n"+    //22
				" ,DECODE(TP.T,1,'C',2,'D','X') NAT_CON \n"+     //23
				" ,TP.RESP_CDE CODIGO_RESPUESTA  \n"+    //24
				" ,DECODE(SUBSTR(CH.TKN_Q9,13,1),'2','A','6','A','1','B','5','B','C') SERV_CODE \n"+    //25 
				" ,TP.TERM_CITY CIUDAD  \n"+    //26
				" ,TP.TERM_CNTRY_CDE PAIS  \n"+    //27
				" ,TTE.B4_ARQC_VRFY ARQC  \n"+    //28
				" ,TP.RETL_SIC_CDE GIRO  \n"+    //29
				" ,'0' IMPORTE --Este campo no existe en esta tabla \n"+    //30 
				" ,TP.TERM_ID TERM_NUM  \n"+    //31
				" ,SUBSTR(CH.TKN_C4,21,1) IND_CAP_TERM \n"+    //32 
				" ,TT.C0_05 IND_COM  \n"+    //33
				" ,SUBSTR(SUBSTR(CH.TKN_Q1,11,LENGTH(CH.TKN_Q1)),1,1) TKQ1_S01 \n"+    //34 
				" ,SUBSTR(SUBSTR(CH.TKN_Q1,11,LENGTH(CH.TKN_Q1)),2,1) TKQ1_S02  \n"+    //35
				" ,CH.TKN_Q2_ID_ACCESO TKQ2_S01  \n"+    //36
				" ,TT.C0_01 TKC0_S01  \n"+    //37
				" ,TT.C0_02 TKC0_S02  \n"+    //38
				" ,TT.C0_03 TKC0_S03  \n"+    //39
				" ,TT.C0_04 TKC0_S04  \n"+    //40
				" ,TT.C0_05 TKC0_S05  \n"+    //41
				" ,TT.C0_06 TKC0_S06  \n"+    //42
				" ,TT.C0_07 TKC0_S07  \n"+    //43
				" ,TT.C0_08 TKC0_S08  \n"+    //44
				" ,TT.C0_09 TKC0_S09  \n"+    //45
				" ,TT.C0_10 TKC0_S10  \n"+    //46
				" ,TT.C0_11 TKC0_S11  \n"+    //47
				" ,TT.C0_12 TKC0_S12  \n"+    //48
				" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),1,1) TKC4_S01 \n"+    //49
				" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),2,1) TKC4_S02  \n"+    //50
				" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),3,1) TKC4_S03  \n"+    //51
				" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),4,1) TKC4_S04  \n"+    //52
				" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),5,1) TKC4_S05  \n"+    //53
				" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),6,1) TKC4_S06  \n"+    //54
				" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),7,1) TKC4_S07  \n"+    //55
				" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),8,1) TKC4_S08  \n"+    //56
				" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),9,1) TKC4_S09  \n"+    //57
				" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),10,1) TKC4_S010  \n"+    //58
				" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),11,1) TKC4_S011  \n"+    //59
				" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),12,1) TKC4_S012  \n"+    //60
				" ,SUBSTR(SUBSTR(CH.TKN_04,11,LENGTH(CH.TKN_04)),1,1) TK04_S01  \n"+    //61
				" ,SUBSTR(SUBSTR(CH.TKN_04,11,LENGTH(CH.TKN_04)),2,11) TK04_S02  \n"+    //62
				" ,SUBSTR(SUBSTR(CH.TKN_04,11,LENGTH(CH.TKN_04)),13,1) TK04_S03  \n"+    //63
				" ,SUBSTR(SUBSTR(CH.TKN_04,11,LENGTH(CH.TKN_04)),14,5) TK04_S04  \n"+    //64
				" ,SUBSTR(SUBSTR(CH.TKN_04,11,LENGTH(CH.TKN_04)),19,1) TK04_S05  \n"+    //65
				" ,SUBSTR(SUBSTR(CH.TKN_04,11,LENGTH(CH.TKN_04)),20,1) TK04_S06  \n"+    //66
				" ,SUBSTR(SUBSTR(CH.TKN_Q6,11,LENGTH(CH.TKN_Q6)),1,2) TKQ6_S01  \n"+    //67
				" ,SUBSTR(SUBSTR(CH.TKN_Q6,11,LENGTH(CH.TKN_Q6)),3,2) TKQ6_S02  \n"+    //68
				" ,SUBSTR(SUBSTR(CH.TKN_Q6,11,LENGTH(CH.TKN_Q6)),5,2) TKQ6_S03  \n"+    //69
				" ,SUBSTR(SUBSTR(CH.TKN_C6,11,LENGTH(CH.TKN_C6)),1,40) TKC6_S01  \n"+    //70
				" ,SUBSTR(SUBSTR(CH.TKN_C6,11,LENGTH(CH.TKN_C6)),41,40) TKC6_S02  \n"+    //71
				" ,SUBSTR(SUBSTR(CH.TKN_CE,11,LENGTH(CH.TKN_CE)),1,40) TKCE_S01  \n"+    //72
				" ,SUBSTR(SUBSTR(CH.TKN_CE,11,LENGTH(CH.TKN_CE)),41,40) TKCE_S02  \n"+    //73
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+18,2) TKB2_S01 \n"+           //74
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+20,10) TKB2_S02 \n"+          //75
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+30,16) TKB2_S03 \n"+          //76
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+46,12) TKB2_S04 \n"+          //77
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+58,12) TKB2_S05 \n"+          //78
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+70,4) TKB2_S06 \n"+           //79
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+74,4) TKB2_S07 \n"+           //80
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+78,3) TKB2_S08 \n"+           //81
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+81,3) TKB2_S09 \n"+           //82
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+84,6) TKB2_S10 \n"+           //83
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+90,2) TKB2_S11 \n"+           //84
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+92,8) TKB2_S12 \n"+           //85
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+100,64) TKB2_S13 \n"+         //86
				
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+18,8) TKB3_S01 \n"+          //87
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+26,8) TKB3_S02 \n"+          //88
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+46,2) TKB3_S03 \n"+          //89
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+48,4) TKB3_S04 \n"+          //90
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+52,6) TKB3_S05 \n"+          //91
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+58,32) TKB3_S06 \n"+         //92
				
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+18,3) TKB4_S01 \n"+          //93
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+21,1) TKB4_S02 \n"+          //94
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+22,1) TKB4_S03 \n"+          //95
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+23,1) TKB4_S04 \n"+          //96
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+24,2) TKB4_S05 \n"+          //97
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+26,6) TKB4_S06 \n"+          //98
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+32,4) TKB4_S07 \n"+          //99
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+36,1) TKB4_S08 \n"+          //100
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+37,1) TKB4_S09 \n"+          //101
				
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B5')+18,4) TKB5_S01 \n"+          //102
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B5')+22,16) TKB5_S02 \n"+         //103
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B5')+38,16) TKB5_S03 \n"+         //104
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B5')+54,1) TKB5_S04 \n"+          //105
				" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B5')+55,1) TKB5_S05 \n"+          //106
				/**************** INICIO   Modificacion SAS N-51-2390-15  12/02/2016***********************/
				",CASE SUBSTR(CH.TKN_EMVFULL ,INSTR(CH.TKN_EMVFULL,'! B2')+24,2) "+//107
				"    WHEN NULL THEN      	 "+//107
				"         ''				 "+//107
				"    WHEN '' THEN  			 "+//107
				"         ''				 "+//107
				"    WHEN '00' THEN  		 "+//107
				"         'Exitoso'			 "+//107
				"    ELSE								 "+//107
				"         DECODE(SUBSTR(lpad(PMADMIN.FN_DEC_BIN(to_number(ltrim(rtrim(SUBSTR(CH.TKN_EMVFULL  "+//107
				"         ,INSTR(CH.TKN_EMVFULL,'! B2')+24,2))),'XXXXXX')),8,0),1,1),'0','Exitoso','1','Fallido')		"+//107
				"END TVR,			"+//107
				 "  CASE 	"+//108
				 "   WHEN SUBSTR(TP.NUM,1,1)='5' OR SUBSTR(TP.NUM,1,1)='2' THEN 	"+//108
				 "     CASE	"+//108
				 "      WHEN LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+106,2)))='00' THEN 	"+//108
				 "         DECODE(SUBSTR(LPAD(NVL(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL     	"+//108
				 "         ,INSTR(CH.TKN_EMVFULL,'! B2')+110,2))),'XX')),'00'),8,0),6,1),'0','No','1','Si')	"+//108
				 "      WHEN LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+106,2)))!='01' THEN 	"+//108
				 "         DECODE(SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL  	"+//108   
				 "         ,INSTR(CH.TKN_EMVFULL,'! B2')+108,2))),'XX')),8,0),6,1),'0','No','1','Si') 	"+//108
				 "      WHEN LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+106,2)))='01' THEN 	"+//108
				 "         DECODE(SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL "+//108
				 "         ,INSTR(CH.TKN_EMVFULL,'! B2')+110,2))),'XX')),8,0),6,1),'0','No','1','Si')   "+//108
				 "     END 	"+//108
				 "  END || 	"+//108
				 "      CASE WHEN SUBSTR(TP.NUM,1,1)='4' THEN	"+//108
				 "          CASE SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+108,2) "+//108
				 "           WHEN NULL THEN '' WHEN '' THEN '' WHEN '00' THEN 'No' "+//108
				 "          ELSE DECODE(SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+112,2))),'XX')) "+//108
				 "           ,8,0),6,1),'0','No','1','Si') "+//108
				 "          END 	"+//108
				 "      END CVRPIN,	"+//108
				 "CASE "+ //109
				 "  WHEN SUBSTR(TP.NUM,1,1)='5' OR SUBSTR(TP.NUM,1,1)='2'THEN	"+ //109
				 " CASE 	"+ //109
				 "  WHEN LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+106,2)))='00' THEN  	"+ //109
				 "     DECODE(SUBSTR(LPAD(NVL(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL     	"+ //109
				 "     ,INSTR(CH.TKN_EMVFULL,'! B2')+110,2))),'XX')),'00'),8,0),7,1),'1','Exitoso','01','Exitoso','10','Exitoso','11','Exitoso','0','Fallido','00','Fallido') "+ //109
				 "  WHEN LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+106,2)))='01' THEN  "+ //109
				 "     DECODE(SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL  "+ //109   
				 "     ,INSTR(CH.TKN_EMVFULL,'! B2')+110,2))),'XX')),8,0),7,1),'1','Fallido','01','Fallido','10','Fallido','11','Fallido','0','Exitoso','00','Exitoso') 	"+ //109
				 "  WHEN LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+106,2)))!='01' THEN 	"+ //109
				 "     DECODE(SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL    	"+ //109  
				 "     ,INSTR(CH.TKN_EMVFULL,'! B2')+108,2))),'XX')),8,0),7,2),'1','Exitoso','01','Exitoso','10','Exitoso','11','Exitoso','0','Fallido','00','Fallido')	"+ //109
				 " END	"+ //109
				 "END ||	"+ //109
				 "CASE WHEN SUBSTR(TP.NUM,1,1)='4' THEN	"+ //109
				 "          CASE SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+108,2)"+ //109
				 "             WHEN NULL THEN '' WHEN '' THEN '' WHEN '00' THEN 'Fallido' "+ //109
				 "          ELSE   DECODE(SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+112,2))),'XX'))	"+ //109 
				 "             ,8,0),7,1),'0','Exitoso','1','Fallido') 	"+ //109
				 "          END 	"+ //109
				 "END CVRRESULT,	"+ //109
				"CASE "+//110
				"    WHEN SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+48,2)=''THEN "+//110
				"         DECODE(NVL(PMADMIN.FN_DEC_BIN(to_number(ltrim(rtrim(SUBSTR(CH.TKN_EMVFULL  "+//110
				"        ,INSTR(CH.TKN_EMVFULL,'! B3')+48,2))),'XXXXXX')),'000000'),'000000','Falló CVM','000001'   "+//110
				"        ,'Verificación del PIN en texto plano realizada por el ICC', '000010','Verificación en línea del PIN cifrado'   "+//110
				"        ,'000011','Verificación del PIN en texto plano realizada por el ICC y firma (papel)','000100' "+//110
				"        ,'Verificación del PIN cifrado realizada por el ICC','000101','Verificación del PIN cifrado realizada por el ICC y firma (papel)','011110','Firma (papel)','011111','No se requirió CVM') "+//110
				"    WHEN SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+48,2)= NULL THEN "+//110
				"         DECODE(NVL(PMADMIN.FN_DEC_BIN(to_number(ltrim(rtrim(SUBSTR(CH.TKN_EMVFULL   "+//110
				"        ,INSTR(CH.TKN_EMVFULL,'! B3')+48,2))),'XXXXXX')),'000000'),'000000','Falló CVM','000001' "+//110
				"        ,'Verificación del PIN en texto plano realizada por el ICC', '000010','Verificación en línea del PIN cifrado'   "+//110
				"        ,'000011','Verificación del PIN en texto plano realizada por el ICC y firma (papel)','000100' "+//110
				"        ,'Verificacion del PIN cifrado realizada por el ICC','000101','Verificación del PIN cifrado realizada por el ICC y firma (papel)','011110','Firma (papel)','011111','No se requirió CVM') "+//110
				"    WHEN SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+48,2)='00' THEN  "+//110
				"        DECODE(NVL(PMADMIN.FN_DEC_BIN(to_number(ltrim(rtrim(SUBSTR(CH.TKN_EMVFULL    "+//110
				"        ,INSTR(CH.TKN_EMVFULL,'! B3')+48,2))),'XXXXXX')),'000000'),'000000','Falló CVM','000001' "+//110
				"        ,'Verificación del PIN en texto plano realizada por el ICC', '000010','Verificación en línea del PIN cifrado'  "+//110
				"        ,'000011','Verificación del PIN en texto plano realizada por el ICC y firma (papel)','000100'  "+//110
				"        ,'Verificación del PIN cifrado realizada por el ICC','000101','Verificación del PIN cifrado realizada por el ICC y firma (papel)','011110','Firma (papel)','011111','No se requirió CVM') "+//110
				" ELSE   "+//110
				"        DECODE(SUBSTR(lpad(PMADMIN.FN_DEC_BIN(to_number(ltrim(rtrim(SUBSTR(CH.TKN_EMVFULL      "+//110
				"        ,INSTR(CH.TKN_EMVFULL,'! B3')+48,2))),'XXXXXX')),8,0),3,6),'000000','Falló CVM','000001'    "+//110  
				"        ,'Verificación del PIN en texto plano realizada por el ICC', '000010','Verificación en línea del PIN cifrado'  "+//110
				"        ,'000011','Verificación del PIN en texto plano realizada por el ICC y firma (papel)','000100'  "+//110
				"        ,'Verificación del PIN cifrado realizada por el ICC','000101','Verificación del PIN cifrado realizada por el ICC y firma (papel)'  "+//110
				"        ,'011110','Firma (papel)','011111','No se requirio CVM') "+//110
				"END CVMRESULT "+//110
				",DECODE(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+52,2),'00','Desconocido','01','Fallido','02','Exitoso') CVR "+//111			
				//	" ,SUBSTR(SUBSTR(CH.TKN_R4,11,LENGTH(CH.TKN_R4)),1,20) TKN_R4 \n"+				   //112
				/**************** FIN   Modificacion SAS N-51-2390-15  12/02/2016***********************/				
				/***************  INICIO Implementación SAS N-51-2823-15_LMRV  11/08/2016  ****************/
				",CASE		  	"+//112
					"SUBSTR(TTE.B2_TVR,+5,2)"+//112
					"WHEN '00'  THEN '0' 	"+//112
					"ELSE SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(TTE.B2_TVR,+5,2))),'XX')),8,0),4,1) 	"+//112
				"END TVRPINBPSH 	"+//112
				",CASE  	"+//113
					"SUBSTR(TTE.B2_TVR,+5,2)		"+//113
					"WHEN '00'  THEN '0' 		"+//113
					"ELSE SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(TTE.B2_TVR,+5,2))),'XX')),8,0),5,1)		"+//113
				"END TVRQPSSPSH 	"+//113
				",CASE SUBSTR(TTQH.TKN_CZ,INSTR(TTQH.TKN_CZ,'! CZ')+15,2) 	"+//114
					"WHEN '' THEN ''	"+//114
					"WHEN NULL THEN ''		"+//114
					"WHEN SUBSTR(TTQH.TKN_CZ,INSTR(TTQH.TKN_CZ,'! CZ')+15,2) 		"+//114
					"THEN SUBSTR(TTQH.TKN_CZ,INSTR(TTQH.TKN_CZ,'! CZ')+15,2) END TKCZ		"+//114
				/***************  FIN Implementación SAS N-51-2823-15_LMRV  11/08/2016  ****************/
				" FROM PMM.TBL_PTLFMMHIST@LG_PMTU_PTLF TP  \n"+
				" LEFT JOIN SSAUD.TBL_PTLFCHIP@LG_PMTU_PTLF CH  \n"+
				" ON TP.RCRD_NUM = CH.NUMERO  \n"+
				" LEFT JOIN SSAUD.TBL_TKNS_EMV@LG_PMTU_PTLF TTE \n"+ 
				" ON TP.RCRD_NUM = TTE.NUMERO  \n"+
				" LEFT JOIN SSAUD.TBL_TOKENC0@LG_PMTU_PTLF TT \n"+ 
				" ON TP.RCRD_NUM = TT.NUMERO  \n"+
				/***************  INICIO Implementación SAS N-51-2823-15_LMRV  11/08/2016  ****************/
				" LEFT JOIN SSAUD.TBL_TOKENQH@LG_PMTU_PTLF TTQH \n"+
				"     ON TP.RCRD_NUM = TTQH.NUMERO \n"+
				/***************  FIN Implementación SAS N-51-2823-15_LMRV  11/08/2016  ****************/
				" WHERE 1=1  \n"+
				" AND TP.NUM = '"+params.comercio+"' \n"+
				" AND TO_CHAR(TP.FECHA_PROCESO_TRANSAC,'MM/YYYY') = '"+params.initDate+'/'+params.endDate+"' \n";
			
	/* ====== WELLCOM P-02-0256-12 20/08/2015 Fin    Cambio de Banistmo ====== */
	
		return query;
	}
	

	public static String SICMOR0205H(TableParams params)
	{
		// INICIA MODIFICACION WELLCOM N-08-2207-13 02-05-2014
				String cadena = "xxx";
		if (params.initDate.substring(3, 5).toString().equals("01"))
			cadena = "ENE";
		else if (params.initDate.substring(3, 5).toString().equals("02"))
			cadena = "FEB";
		else if (params.initDate.substring(3, 5).toString().equals("03"))
			cadena = "MAR";
		else if (params.initDate.substring(3, 5).toString().equals("04"))
			cadena = "ABR";
		else if (params.initDate.substring(3, 5).toString().equals("05"))
			cadena = "MAY";
		else if (params.initDate.substring(3, 5).toString().equals("06"))
			cadena = "JUN";
		else if (params.initDate.substring(3, 5).toString().equals("07"))
			cadena = "JUL";
		else if (params.initDate.substring(3, 5).toString().equals("08"))
			cadena = "AGO";
		else if (params.initDate.substring(3, 5).toString().equals("09"))
			cadena = "SEP";
		else if (params.initDate.substring(3, 5).toString().equals("10"))
			cadena = "OCT";
		else if (params.initDate.substring(3, 5).toString().equals("11"))
			cadena = "NOV";
		else if (params.initDate.substring(3, 5).toString().equals("12"))
			cadena = "DIC";
		// FIN MODIFICACION WELLCOM N-08-2207-13 02-05-2014
		
		String query = "";
		
		query = 
			" SELECT TO_CHAR(PTA.NUMERO) NUMERO \n"+            	   // 00
			" 		,PTA.ENT_NUMERO_PROSA_ADQ ADQ \n"+                 // 01
			"       ,PTA.ENT_NUMERO_PROSA_EMI EMI \n"+                 // 02
			"       ,PTA.ARCH_NUMERO FUENTE \n"+                       // 03
			"       ,PTA.PROC_NUMERO PROC \n"+                         // 04
			"       ,PTA.FIID_EMISOR BANCO_EMISOR \n"+                 // 05
			"       ,PTA.CUENTA CUENTA \n"+                            // 06
			"       ,PTA.TTR_NUMERO CVE_TXN \n"+                       // 07
			"       ,PTA.TC||'  '||PTA.TYP TYP \n"+                    // 08
			"       ,PTA.NUMERO_AUTORIZACION NO_AUT \n"+               // 09
			/********** Inicio    Modificacion WELLCOM N-04-2207-12  03/03/2014 **********/
			"       ,TO_CHAR(PTA.IMPORTE_TOTAL_TRANSAC,'9,999,999,999,999,999.99') IMPORTE \n"+ // 10
			/********** Fin       Modificacion WELLCOM N-04-2207-12  03/03/2014 **********/
			"       ,PTA.FECHA_CONSUMO_TRANSAC||' '||TO_CHAR(PTA.FECHA_CONSUMO_TRANSAC,'HH:mm:SS') FECHA_CONSUMO_TRANSAC \n"+//11
			"       ,PTA.MODO_ENTRADA_POS MODO_ENT \n"+                // 12
			"       ,PTA.TIPO_CAPTURA TIPO_CAPTURA \n"+                // 13
/*   Inicia modificacion Wellcom N-04-2207-13 */
			"       ,DECODE(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+14,1),NULL,'B',0,'B','1','A','C') IND_EMV \n"+// 14
/*   Fin    modificacion Wellcom N-04-2207-13 */
			"       ,PTA.IND_TER_CAP TERM_CAP \n"+                     // 15
			"       ,PTA.CODIGO_RESPUESTA_ISO COD_ISO \n"+             // 16
			"       ,PTA.IND_COM_ELEC ICE \n"+			               // 17
			" ,CH.TKN_Q1 TK1 "+
			" ,CH.TKN_Q2_ID_ACCESO TK2 "+
			" ,CH.TKN_Q6 TK3 "+
			" ,CH.TKN_04 TK4 "+
			" ,TT.C0_01||TT.C0_02||TT.C0_03||TT.C0_04||TT.C0_05||TT.C0_06||TT.C0_07||TT.C0_08||TT.C0_09||TT.C0_10||TT.C0_11||TT.C0_12 TK5 "+
			" ,CH.TKN_C4 TK6 "+
			" ,CH.TKN_C6 TK7 "+ 
			" ,CH.TKN_CE TK8 "+
			
			"       ,VBA.NUMERO_FIID BANCO_ADQUIRENTE \n"+             // 26
			"       ,TO_CHAR(PTA.NUMERO_COMERCIO) NUMERO_COMERCIO \n"+ // 27
			"       ,PTA.NOMBRE_COMERCIO NOMBRE_COMERCIO \n"+          // 28
			"       ,PTA.RED_LOGICA RED_LOGICA_ADQ \n"+                // 29
			"       ,PTA.RED_LOGICA_EMI RED_LOGICA \n"+                // 30
			"       ,VBA.DESCRIPCION DESC_ADQ \n"+                     // 31
			"       ,PE.DESCRIPCION DESC_EMI \n"+                      // 32
			"       ,PTA.FIID_EMISOR BANCO_EMISOR \n"+                 // 33
			
			/********** Inicio    Modificacion WELLCOM N-04-2207-12  04/06/2014 **********/
			" 		,SUBSTR(SUBSTR(CH.TKN_Q1,11,LENGTH(CH.TKN_Q1)),1,1) TKQ1_S01 \n"+
			" 		,SUBSTR(SUBSTR(CH.TKN_Q1,11,LENGTH(CH.TKN_Q1)),2,1) TKQ1_S02 \n"+
			/********** Fin    Modificacion WELLCOM N-04-2207-12  04/06/2014 **********/
			
			" 		,CH.TKN_Q2_ID_ACCESO TKQ2_S01 \n"+
			
			" 		,TT.C0_01 TKC0_S01 \n"+
			" 		,TT.C0_02 TKC0_S02 \n"+
			" 		,TT.C0_03 TKC0_S03 \n"+
			" 		,TT.C0_04 TKC0_S04 \n"+
			" 		,TT.C0_05 TKC0_S05 \n"+
			" 		,TT.C0_06 TKC0_S06 \n"+
			" 		,TT.C0_07 TKC0_S07 \n"+
			" 		,TT.C0_08 TKC0_S08 \n"+
			" 		,TT.C0_09 TKC0_S09 \n"+
			" 		,TT.C0_10 TKC0_S10 \n"+
			" 		,TT.C0_11 TKC0_S11 \n"+ 
			" 		,TT.C0_12 TKC0_S12 \n"+


			/********** Inicio    Modificacion WELLCOM N-04-2207-12  04/06/2014 **********/
		" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),1,1) TKC4_S01 \n "+											//49
		" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),2,1) TKC4_S02 \n "+											//50
		" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),3,1) TKC4_S03 \n "+											//51
		" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),4,1) TKC4_S04 \n "+											//52
		" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),5,1) TKC4_S05 \n "+											//53
		" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),6,1) TKC4_S06 \n "+											//54
		" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),7,1) TKC4_S07 \n "+											//55
		" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),8,1) TKC4_S08 \n "+											//56
		" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),9,1) TKC4_S09 \n "+											//57
		" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),10,1) TKC4_S010 \n "+											//58
		" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),11,1) TKC4_S011 \n "+											//59
		" ,SUBSTR(SUBSTR(CH.TKN_C4,11,LENGTH(CH.TKN_C4)),12,1) TKC4_S012 \n "+											//60
		
		" ,SUBSTR(SUBSTR(CH.TKN_04,11,LENGTH(CH.TKN_04)),1,1) TK04_S01 \n "+											//61
		" ,SUBSTR(SUBSTR(CH.TKN_04,11,LENGTH(CH.TKN_04)),2,11) TK04_S02 \n "+											//62
		" ,SUBSTR(SUBSTR(CH.TKN_04,11,LENGTH(CH.TKN_04)),13,1) TK04_S03 \n "+											//63
		" ,SUBSTR(SUBSTR(CH.TKN_04,11,LENGTH(CH.TKN_04)),14,5) TK04_S04 \n "+											//64
		" ,SUBSTR(SUBSTR(CH.TKN_04,11,LENGTH(CH.TKN_04)),19,1) TK04_S05 \n "+											//65
		" ,SUBSTR(SUBSTR(CH.TKN_04,11,LENGTH(CH.TKN_04)),20,1) TK04_S06 \n "+											//66
		
		" ,SUBSTR(SUBSTR(CH.TKN_Q6,11,LENGTH(CH.TKN_Q6)),1,2) TKQ6_S01 \n "+											//67
		" ,SUBSTR(SUBSTR(CH.TKN_Q6,11,LENGTH(CH.TKN_Q6)),3,2) TKQ6_S02 \n "+											//68
		" ,SUBSTR(SUBSTR(CH.TKN_Q6,11,LENGTH(CH.TKN_Q6)),5,2) TKQ6_S03 \n "+											//69
		
		" ,SUBSTR(SUBSTR(CH.TKN_C6,11,LENGTH(CH.TKN_C6)),1,40) TKC6_S01 \n "+											//70
		" ,SUBSTR(SUBSTR(CH.TKN_C6,11,LENGTH(CH.TKN_C6)),41,40) TKC6_S02 \n "+											//71
		
		" ,SUBSTR(SUBSTR(CH.TKN_CE,11,LENGTH(CH.TKN_CE)),1,40) TKCE_S01 \n "+											//72
		" ,SUBSTR(SUBSTR(CH.TKN_CE,11,LENGTH(CH.TKN_CE)),41,40) TKCE_S02 \n "+											//73
			/********** Fin    Modificacion WELLCOM N-04-2207-12  04/06/2014 **********/

		/********** Inicio    Modificacion WELLCOM N-51-2098-14  14/08/2014 **********/
		/********** Inicio    Modificacion WELLCOM N-51-2098-14  18/02/2015 **********/
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+18,2) TKB2_S01 \n"+           //74
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+20,10) TKB2_S02 \n"+          //75
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+30,16) TKB2_S03 \n"+          //76
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+46,12) TKB2_S04 \n"+          //77
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+58,12) TKB2_S05 \n"+          //78
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+70,4) TKB2_S06 \n"+           //79
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+74,4) TKB2_S07 \n"+           //80
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+78,3) TKB2_S08 \n"+           //81
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+81,3) TKB2_S09 \n"+           //82
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+84,6) TKB2_S10 \n"+           //83
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+90,2) TKB2_S11 \n"+           //84
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+92,8) TKB2_S12 \n"+           //85
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+104,64) TKB2_S13 \n"+         //86
		
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+14,8) TKB3_S01 \n"+          //87
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+22,8) TKB3_S02 \n"+          //88
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+42,2) TKB3_S03 \n"+          //89
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+44,4) TKB3_S04 \n"+          //90
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+48,6) TKB3_S05 \n"+          //91
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+58,32) TKB3_S06 \n"+         //92
		
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+10,3) TKB4_S01 \n"+          //93
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+13,1) TKB4_S02 \n"+          //94
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+14,1) TKB4_S03 \n"+          //95
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+15,1) TKB4_S04 \n"+          //96
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+16,2) TKB4_S05 \n"+          //97
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+18,6) TKB4_S06 \n"+          //98
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+24,4) TKB4_S07 \n"+          //99
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+28,1) TKB4_S08 \n"+          //100
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B4')+29,1) TKB4_S09 \n"+          //101
		
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B5')+10,4) TKB5_S01 \n"+          //102
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B5')+14,16) TKB5_S02 \n"+         //103
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B5')+30,16) TKB5_S03 \n"+         //104
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B5')+46,1) TKB5_S04 \n"+          //105
		" ,SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B5')+47,1) TKB5_S05 \n"+          //106
		/********** Fin       Modificacion WELLCOM N-51-2098-14  18/02/2015 **********/
		/********** Fin       Modificacion WELLCOM N-51-2098-14  14/08/2014 **********/
		/**************** INICIO   Modificacion SAS N-51-2390-15  12/02/2016***********************/
		",CASE SUBSTR(CH.TKN_EMVFULL ,INSTR(CH.TKN_EMVFULL,'! B2')+24,2) "+//107
		"    WHEN NULL THEN      	 "+//107
		"         ''				 "+//107
		"    WHEN '' THEN  			 "+//107
		"         ''				 "+//107
		"    WHEN '00' THEN  		 "+//107
		"         'Exitoso'			 "+//107
		"    ELSE								 "+//107
		"         DECODE(SUBSTR(lpad(PMADMIN.FN_DEC_BIN(to_number(ltrim(rtrim(SUBSTR(CH.TKN_EMVFULL  "+//107
		"         ,INSTR(CH.TKN_EMVFULL,'! B2')+24,2))),'XXXXXX')),8,0),1,1),'0','Exitoso','1','Fallido')		"+//107
		"END TVR,			"+//107
		"  CASE 	"+//108
		 "   WHEN SUBSTR(PTA.CUENTA,1,1)='5' OR SUBSTR(PTA.CUENTA,1,1)='2'THEN 	"+//108
		 "     CASE	"+//108
		 "      WHEN LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+106,2)))='00' THEN 	"+//108
		 "         DECODE(SUBSTR(LPAD(NVL(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL     	"+//108
		 "         ,INSTR(CH.TKN_EMVFULL,'! B2')+110,2))),'XX')),'00'),8,0),6,1),'0','No','1','Si')	"+//108
		 "      WHEN LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+106,2)))!='01' THEN 	"+//108
		 "         DECODE(SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL  	"+//108   
		 "         ,INSTR(CH.TKN_EMVFULL,'! B2')+108,2))),'XX')),8,0),6,1) ,'0','No','1','Si') 	"+//108
		 "      WHEN LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+106,2)))='01' THEN 	"+//108
		 "         DECODE(SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL "+//108
		 "         ,INSTR(CH.TKN_EMVFULL,'! B2')+110,2))),'XX')),8,0),6,1),'0','No','1','Si')   "+//108
		 "     END 	"+//108
		 "  END || 	"+//108
		 "      CASE WHEN SUBSTR(PTA.CUENTA,1,1)='4' THEN	"+//108
		 "          CASE SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+108,2)"+//108
		 "           WHEN NULL THEN '' WHEN '' THEN '' WHEN '00' THEN 'No'  "+//108
		 "          ELSE DECODE(SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+112,2))),'XX')) "+//108
		 "           ,8,0),6,1),'0','No','1','Si') "+//108
		 "          END 	"+//108
		 "      END CVRPIN,	"+//108
		 "CASE "+ //109
		 "  WHEN SUBSTR(PTA.CUENTA,1,1)='5' OR SUBSTR(PTA.CUENTA,1,1)='2' THEN	"+ //109
		 " CASE 	"+ //109
		 "  WHEN LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+106,2)))='00' THEN  	"+ //109
		 "     DECODE(SUBSTR(LPAD(NVL(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL     	"+ //109
		 "     ,INSTR(CH.TKN_EMVFULL,'! B2')+110,2))),'XX')),'00'),8,0),7,1),'1','Exitoso','01','Exitoso','10','Exitoso','11','Exitoso','0','Fallido','00','Fallido') "+ //109
		 "  WHEN LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+106,2)))='01' THEN  "+ //109
		 "     DECODE(SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL  "+ //109   
		 "     ,INSTR(CH.TKN_EMVFULL,'! B2')+110,2))),'XX')),8,0),7,1),'1','Fallido','01','Fallido','10','Fallido','11','Fallido','0','Exitoso','00','Exitoso') 	"+ //109
		 "  WHEN LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+106,2)))!='01' THEN 	"+ //109
		 "     DECODE(SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL    	"+ //109  
		 "     ,INSTR(CH.TKN_EMVFULL,'! B2')+108,2))),'XX')),8,0),7,2),'1','Exitoso','01','Exitoso','10','Exitoso','11','Exitoso','0','Fallido','00','Fallido')	"+ //109
		 " END	"+ //109
		 "END ||	"+ //109
		 "CASE WHEN SUBSTR(PTA.CUENTA,1,1)='4' THEN	"+ //109
		 "          CASE SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+108,2)	"+ //109
		 "             WHEN NULL THEN '' WHEN '' THEN '' WHEN '00' THEN 'Fallido'"+ //109
		 "          ELSE   DECODE(SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B2')+112,2))),'XX'))	"+ //109 
		 "             ,8,0),7,1),'0','Exitoso','1','Fallido') 	"+ //109
		 "          END 	"+ //109
		 "END CVRRESULT,	"+ //109
		"CASE "+//110
		"    WHEN SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+48,2)=''THEN "+//110
		"         DECODE(NVL(PMADMIN.FN_DEC_BIN(to_number(ltrim(rtrim(SUBSTR(CH.TKN_EMVFULL  "+//110
		"        ,INSTR(CH.TKN_EMVFULL,'! B3')+48,2))),'XXXXXX')),'000000'),'000000','Falló CVM','000001'   "+//110
		"        ,'Verificación del PIN en texto plano realizada por el ICC', '000010','Verificación en línea del PIN cifrado'   "+//110
		"        ,'000011','Verificación del PIN en texto plano realizada por el ICC y firma (papel)','000100' "+//110
		"        ,'Verificación del PIN cifrado realizada por el ICC','000101','Verificación del PIN cifrado realizada por el ICC y firma (papel)','011110','Firma (papel)','011111','No se requirió CVM') "+//110
		"    WHEN SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+48,2)= NULL THEN "+//110
		"         DECODE(NVL(PMADMIN.FN_DEC_BIN(to_number(ltrim(rtrim(SUBSTR(CH.TKN_EMVFULL   "+//110
		"        ,INSTR(CH.TKN_EMVFULL,'! B3')+48,2))),'XXXXXX')),'000000'),'000000','Falló CVM','000001' "+//110
		"        ,'Verificación del PIN en texto plano realizada por el ICC', '000010','Verificación en línea del PIN cifrado'   "+//110
		"        ,'000011','Verificación del PIN en texto plano realizada por el ICC y firma (papel)','000100' "+//110
		"        ,'Verificacion del PIN cifrado realizada por el ICC','000101','Verificación del PIN cifrado realizada por el ICC y firma (papel)','011110','Firma (papel)','011111','No se requirió CVM') "+//110
		"    WHEN SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+48,2)='00' THEN  "+//110
		"        DECODE(NVL(PMADMIN.FN_DEC_BIN(to_number(ltrim(rtrim(SUBSTR(CH.TKN_EMVFULL    "+//110
		"        ,INSTR(CH.TKN_EMVFULL,'! B3')+48,2))),'XXXXXX')),'000000'),'000000','Falló CVM','000001' "+//110
		"        ,'Verificación del PIN en texto plano realizada por el ICC', '000010','Verificación en línea del PIN cifrado'  "+//110
		"        ,'000011','Verificación del PIN en texto plano realizada por el ICC y firma (papel)','000100'  "+//110
		"        ,'Verificación del PIN cifrado realizada por el ICC','000101','Verificación del PIN cifrado realizada por el ICC y firma (papel)','011110','Firma (papel)','011111','No se requirió CVM') "+//110
		" ELSE   "+//110
		"        DECODE(SUBSTR(lpad(PMADMIN.FN_DEC_BIN(to_number(ltrim(rtrim(SUBSTR(CH.TKN_EMVFULL      "+//110
		"        ,INSTR(CH.TKN_EMVFULL,'! B3')+48,2))),'XXXXXX')),8,0),3,6),'000000','Falló CVM','000001'    "+//110  
		"        ,'Verificación del PIN en texto plano realizada por el ICC', '000010','Verificación en línea del PIN cifrado'  "+//110
		"        ,'000011','Verificación del PIN en texto plano realizada por el ICC y firma (papel)','000100'  "+//110
		"        ,'Verificación del PIN cifrado realizada por el ICC','000101','Verificación del PIN cifrado realizada por el ICC y firma (papel)'  "+//110
		"        ,'011110','Firma (papel)','011111','No se requirio CVM') "+//110
		"END CVMRESULT "+//110
		",DECODE(SUBSTR(CH.TKN_EMVFULL,INSTR(CH.TKN_EMVFULL,'! B3')+52,2),'00','Desconocido','01','Fallido','02','Exitoso') CVR "+//111			
		//	" ,SUBSTR(SUBSTR(CH.TKN_R4,11,LENGTH(CH.TKN_R4)),1,20) TKN_R4 \n"+				   //112
		/**************** FIN   Modificacion SAS N-51-2390-15  12/02/2016***********************/	
		/***************  INICIO Implementación SAS N-51-2823-15_LMRV  11/08/2016  ****************/
		",CASE		  	"+//112
			"SUBSTR(TTE.B2_TVR,+5,2)"+//112
			"WHEN '00'  THEN '0' 	"+//112
			"ELSE SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(TTE.B2_TVR,+5,2))),'XX')),8,0),4,1) 	"+//112
		"END TVRPINBPSH 	"+//112
		",CASE  	"+//113
			"SUBSTR(TTE.B2_TVR,+5,2)		"+//113
			"WHEN '00'  THEN '0' 		"+//113
			"ELSE SUBSTR(LPAD(PMADMIN.FN_DEC_BIN(TO_NUMBER(LTRIM(RTRIM(SUBSTR(TTE.B2_TVR,+5,2))),'XX')),8,0),5,1)		"+//113
		"END TVRQPSSPSH 	"+//113
	    ",CASE SUBSTR(TTQH.TKN_CZ,INSTR(TTQH.TKN_CZ,'! CZ')+15,2) 	"+//114
			"WHEN '' THEN ''	"+//114
			"WHEN NULL THEN ''		"+//114
			"WHEN SUBSTR(TTQH.TKN_CZ,INSTR(TTQH.TKN_CZ,'! CZ')+15,2) 		"+//114
			"THEN SUBSTR(TTQH.TKN_CZ,INSTR(TTQH.TKN_CZ,'! CZ')+15,2) END TKCZ		"+//114
		/***************  FIN Implementación SAS N-51-2823-15_LMRV  11/08/2016  ****************/
	/********** Inicio    Modificacion WELLCOM N-04-2207-12  05/09/2013 **********/
			" FROM SUPERSIC.TRANSACCIONES_ACEPTADAS@LG_PMTU_SICB PTA \n"+
			// Inicia marca de cambio N-04-2207-13 
        //" FROM SUPERSIC.TRANSACCIONES_ACEPTADAS@LG_PMTU_SICB2 PTA \n"+
			// Termina N-04-2207-13 	
	/********** Inicio    Modificacion WELLCOM N-04-2207-12  05/09/2013 **********/
			" INNER JOIN PMADMIN.VW_BUS_ACQ VBA \n"+
			"     ON VBA.NUMERO_PROSA = PTA.ENT_NUMERO_PROSA_ADQ \n"+
			" INNER JOIN PMADMIN.PRSA_ENTIDADES PE \n"+
			"     ON PE.NUMERO_PROSA = PTA.ENT_NUMERO_PROSA_EMI \n"+
			" INNER JOIN PMADMIN.PRSA_TIPOS_TRANSACCION PTT \n"+
			"     ON PTT.NUMERO = PTA.TTR_NUMERO \n"+
			// INICIA CAMBIO N-08-2207-13 02-05-2014 WELLCOM
			" LEFT JOIN SSAUD.TANDEM"+cadena.toString()+"51@LG_PMTU_PTLF TA \n"+
			"  	ON TA.NUM = PTA.CUENTA \n"+
			"	AND TA.APPRV_CDE = PTA.NUMERO_AUTORIZACION \n"+
		    "   AND TRIM(PTA.NUMERO_COMERCIO) = TRIM(TA.ID) \n"+
			" LEFT JOIN SSAUD.TBL_PTLFCHIP@LG_PMTU_PTLF CH \n"+ 
			" 	  ON TA.NUMERO = CH.NUMERO \n"+
			" LEFT JOIN SSAUD.TBL_TOKENC0@LG_PMTU_PTLF TT \n"+ 
			" 	  ON TA.NUMERO = TT.NUMERO \n"+
			// ***************  INICIO Implementación SAS N-51-2823-15_LMRV  11/08/2016  ****************/
			" LEFT JOIN SSAUD.TBL_TOKENQH@LG_PMTU_PTLF TTQH \n"+
            "     ON TA.NUMERO = TTQH.NUMERO \n"+
            " LEFT JOIN SSAUD.TBL_TKNS_EMV@LG_PMTU_PTLF TTE \n"+
            "     ON TA.NUMERO = TTE.NUMERO \n"+
			// ***************  FIN Implementación SAS N-51-2823-15_LMRV  11/08/2016  ****************/
			// INICIA CAMBIO N-08-2207-13 02-05-2014 WELLCOM
			" WHERE PTA.FECHA_PROCESO_TRANSAC BETWEEN TO_DATE('"+params.initDate+"','DD/MM/YYYY') AND TO_DATE('"+params.endDate+"','DD/MM/YYYY') \n"+
			" AND PTA.CUENTA = '"+params.cuenta+"' ";

		if ((params.referencia!="") && (params.referencia!=null) && (params.referencia!="null"))
			{
				query+=" AND PTA.NUMERO_REFERENCIA = "+params.referencia+" ";
			}

		if ((params.comercio!="") && (params.comercio!=null) && (params.comercio!="null"))
			{
				query+=" AND PTA.NUMERO_COMERCIO = "+params.comercio+" ";
			}
		
		return query;
	}
	/********** Fin    Modificacion WELLCOM N-08-2253-12  13/05/2013 **********/
	
	public static String SICMOF0100(TableParams params){
		String query = "";
		
		query=
			" SELECT /*+ INDEX(PTA NDX_TAC_CUENTA) */ PTA.ARCH_NUMERO FUENTE \n"+
			"   ,PA.DESCRIPCION \n"+
			"   ,PTA.NOMBRE_ARCHIVO \n"+
			"   ,PTA.FECHA_CONSUMO_TRANSAC F_CONSUMO \n"+
			"   ,PTA.FECHA_PROCESO_TRANSAC F_PROCESO \n"+
			"   ,PTA.ENT_NUMERO_PROSA_ADQ ENT_ADQ \n"+
			"   ,VBA.DESCRIPCION ADQ_DESCRIPCION \n"+
			"   ,VBA.BU_TX_ADQ BU_ADQ \n"+
			"   ,PTA.ENT_NUMERO_PROSA_EMI ENT_EMI \n"+
			"   ,PEE.DESCRIPCION EMI_DESCRIPCION \n"+
			"   ,(SELECT DISTINCT DECODE(VBE.BU_TX_PARENT,641,522,VBE.BU_TX_PARENT) FROM PMADMIN.VW_BUS_EMI VBE WHERE VBE.NUMERO_PROSA = PTA.ENT_NUMERO_PROSA_EMI) BU_EMI \n"+
			"   ,PTA.NUMERO_AUTORIZACION NO_AUTORIZACION \n"+
			"   ,PTA.NUMERO_REFERENCIA NO_REFERENCIA \n"+
			"   ,PTA.CUENTA \n"+
			"   ,PTA.TTR_NUMERO CLAVE_TXS \n"+
			"   ,PTT.DESCRIPCION DESCRIPCION_CLAVE_TXS \n"+
			"   ,PTA.NUMERO_COMERCIO NO_COMERCIO \n"+
			"   ,PTA.NOMBRE_COMERCIO \n"+
			"   ,PTA.BDU_SIC_CVE GIRO \n"+
			"   ,TO_CHAR(PTA.IMPORTE_TOTAL_TRANSAC,'999,999,999.99') IMP_TRANS \n"+
			"   ,PTA.IMPORTE_CUOTA_INTERCAMBIO IMP_INTERCAMBIO \n"+
			"   ,PTA.IMPORTE_IVA_INTERCAMBIO IVA_INT \n"+
			"   ,PTA.PREF_NUMERO PREFIJO \n"+
			"   ,PTA.MODO_ENTRADA_POS MODO_POS \n"+
			"   ,PTA.BDU_COM_CAT_CRE CATEGORIA \n"+ 
			"   ,PTA.CLAVE_FACTOR_COMERCIO FACTOR_COM \n"+
			"   ,PTA.CLAVE_FACTOR_INTERCAMBIO FACTOR_INT \n"+
			"   ,PTA.CUOTA_INTERCAMBIO CUOTA_INT \n"+
			"   ,PTA.IMPORTE_IVA_COMERCIO IVA_COM /* PENDIENTE */ \n"+
			"   ,PTA.CUENTA_CHEQUES REF_CHEQ \n"+
			"   ,PTA.RUTEO \n"+
			"   ,PTA.MAPR_NUMERO MARCA \n"+
			"   ,PTA.TLI_NUMERO LIQ \n"+
			"   ,PTA.RED_LOGICA RED_LOGICA_ADQ \n"+
			"   ,PTA.RED_LOGICA_EMI \n"+
			"   ,PTA.TTR_NUMERO TIPO_TXS \n"+
			"   ,PTA.FECHA_CONSUMO_TRANSAC HORA_CONSUMO /* PENDIENTE */ \n"+
			"   ,PTA.CODIGO_RAZON \n"+
			"   ,PTA.IND_TER_CAP TERM_CAP \n"+
			"   ,PTA.TERM_ID TERMINAL \n"+
			"   ,PTA.BDU_COM_VIG TB_VIG \n"+
			"   ,PTA.BDU_COM_CAT_CRE TB_CAT_DR \n"+
			"   ,(SELECT PP_VALOR FROM PMADMIN.PRSA_PARAMETROS WHERE PP_ID_PARAMETRO = 'IVA_PARM') IVA \n"+
			"   ,PTA.PROC_NUMERO PROCEDENCIA \n"+
			"   ,PTA.CODIGO_RESPUESTA_AUT \n"+
			"   ,PTA.TIPO_CAPTURA \n"+
			"   ,PTA.CODIGO_RESPUESTA_ISO \n"+
			"   ,PTA.TA_WH_SEQ NUMERO \n"+
			"   ,PTA.IND_TER_ACT \n"+
			"   ,PTA.IND_TER_CAP \n"+
			"   ,PTA.CUOTA_INTERCAMBIO TARIFA_TASA \n"+
			"   ,PTA.IND_COM_ELEC ICE \n"+
			"   ,PTA.ES_NACIONAL PBIN_GLOBAL_LOCALE_S \n"+
			"   ,PTA.IMPORTE_CUOTA_COMERCIO IMPORTE_COMERCIO \n"+
			"   ,PTA.CUOTA_COMERCIO CUOTA_COM \n"+
			"   ,PTA.TIPO_CAPTURA IND_EMV \n"+
			"   ,PTA.IND_PD IND_DIF \n"+
			"   ,PTA.TC \n"+
			"   ,PTA.TYP \n"+
			"   ,PTA.TIER_CODIGO_MONEDA MONEDA \n"+
			" FROM PMADMIN.PRSA_TXN_ACEPTADAS PTA \n"+
			" INNER JOIN PMADMIN.VW_BUS_ACQ VBA \n"+
			" ON VBA.NUMERO_PROSA = PTA.ENT_NUMERO_PROSA_ADQ \n"+
			" INNER JOIN PMADMIN.PRSA_ENTIDADES PEE \n"+
			" ON PEE.NUMERO_PROSA = PTA.ENT_NUMERO_PROSA_EMI \n"+
			" INNER JOIN PMADMIN.PRSA_TIPOS_TRANSACCION PTT \n"+
			" ON PTT.NUMERO = PTA.TTR_NUMERO \n"+
			" INNER JOIN PMADMIN.PRSA_ARCHIVOS PA \n"+
			" ON PA.NUMERO = PTA.ARCH_NUMERO  \n";
		
		if(!params.tipoTransaccion.equals("None"))
				{
					query+=" INNER JOIN PMADMIN.PRSA_TIPOS_SAC PTS \n"+
					" ON PTS.PTS_TIPO_SAC = PTA.TTR_NUMERO \n";
				}
			
			query+=
			" WHERE PTA.TTR_NUMERO NOT IN (10,11,51,52,53,54) \n";
		
		if (!params.session.getAttribute("fechaXML").toString().equals("01/01/2000")){
			query+=" AND PTA.PARTITION_ID >= (SELECT PMADMIN.FN_PARTITION_ID(TO_DATE('"+params.session.getAttribute("fechaXML").toString()+"','DD/MM/YYYY')) FROM DUAL) \n";
		}
		query+=" AND PTA.PARTITION_ID >= (SELECT PMADMIN.FN_PARTITION_ID(TO_DATE (TO_CHAR(SYSDATE-7,'DD-MM-YYYY'),'DD-MM-YYYY')) FROM DUAL) \n";
		
		if(!params.tipoTransaccion.equals("None")){
			query+=" AND PTS.TIPO_PMT IN ( "+params.tipoTransaccion+") /* PARAMETRO */ \n";
		}
		
		
		if(params.rol.equals("banco")){
			if(params.bancoRecep.equals("None")&&params.bancoEmi.equals("None")){
				query+=" AND (VBA.ENTIDAD_PADRE IN ("+params.numerosProsa+") /* PARAMETRO */ \nOR PEE.ENTIDAD_PADRE IN ("+params.numerosProsa+")) /* PARAMETRO */ \n";
			}else{
				query+=" AND VBA.ENTIDAD_PADRE IN ("+params.bancoRecep+") /* PARAMETRO */ \n";
			}
			
			if(!params.bancoEmi.equals("None")){
				query+=" AND PEE.ENTIDAD_PADRE IN ("+params.bancoEmi+") /* PARAMETRO */ \n";
			}
		}else{
			if(!params.bancoRecep.equals("None")){
				query+=" AND VBA.ENTIDAD_PADRE IN ("+params.bancoRecep+") /* PARAMETRO */ \n";
			}
			if(!params.bancoEmi.equals("None")){
				query+=" AND PEE.ENTIDAD_PADRE IN ("+params.bancoEmi+") /* PARAMETRO */ \n";
			}
		}
		
		if(!params.numeroCuenta.equals("")){
			query+=" AND PTA.CUENTA = '"+params.numeroCuenta+"' /* PARAMETRO */ \n";
		}
		
		if(!params.numeroAutorizacion.equals("")){
			query+=" AND PTA.NUMERO_AUTORIZACION = '"+params.numeroAutorizacion+"' /* PARAMETRO */ \n";
		}
		
		if(!params.numeroRef.equals("")){
			query+=" AND PTA.NUMERO_REFERENCIA = '"+params.numeroRef+"' /* PARAMETRO */ \n";
		}
		
		if(!params.numeroComercio.equals("")){
			query+=" AND PTA.NUMERO_COMERCIO IN ("+params.numeroComercio+") /* PARAMETRO */ \n";
		}
		
		if(!params.nombreComercio.equals("")){
			query+=" AND PTA.NOMBRE_COMERCIO = '"+params.nombreComercio+"' /* PARAMETRO */ \n";
		}
		
		if(!params.importe.equals("")){
			query+=" AND PTA.IMPORTE_TOTAL_TRANSAC = "+params.importe+" /* PARAMETRO */ \n";
		}

		return query;
	}

	/**
	 * Metodo que genera query para reporte SICMOF0100 historico
	 * @param params
	 * @return 
	 */
	public static String SICMOF1000(TableParams params){
		if(params.cuenta != null){
			
		}
		
		String query=" SELECT  \n";
		if(params.cuenta != null){
			query+=" //*+ INDEX(TA TAC2_CUENTA_FK_I) */ \n";
		}else if (params.cuenta == null && params.referencia != null){
			query+=" //*+ INDEX(TA NDX_NUM_REF) */ \n";
		}
		
		query+=" TA.ARCH_NUMERO FUENTE, \n"+
		" A.DESCRIPCION,  \n"+
		" TA.NOMBRE_ARCHIVO, \n"+
		" TO_CHAR(TA.FECHA_CONSUMO_TRANSAC,'DD/MM/YYYY') F_CONSUMO, \n"+
		" TO_CHAR(TA.FECHA_PROCESO_TRANSAC,'DD/MM/YYYY') F_PROCESO, \n"+
		" TA.ENT_NUMERO_PROSA_ADQ ENT_ADQ, \n"+
		" EADQ.NOMBRE ADQ_DESCRIPCION, \n"+
		" '' BU_ADQ, \n"+
		" TA.ENT_NUMERO_PROSA_EMI ENT_EMI, \n"+
		" EEMI.NOMBRE EMI_DESCRIPCION, \n"+
		" '' BU_EMI, \n"+
		" TA.NUMERO_AUTORIZACION NO_AUTORIZACION, \n"+
		" TA.NUMERO_REFERENCIA NO_REFERENCIA, \n"+
		" TA.CUENTA, \n"+
		" TA.TTR_NUMERO NO_TIPO_TRANSACCION, \n"+
		" TT.DESCRIPCION TIPO_TRANSACCION, \n"+
		" TA.NUMERO_COMERCIO, \n"+
		" TA.NOMBRE_COMERCIO, \n"+
		" TA.BDU_SIC_CVE GIRO_COMERCIO, \n"+
		" TRIM(TO_CHAR(TA.IMPORTE_TOTAL_TRANSAC,'999,999,999.99')) IMPORTE_TOTAL_TRANSAC, \n"+
		" TA.IMPORTE_CUOTA_INTERCAMBIO, \n"+
		" TA.IMPORTE_IVA_INTERCAMBIO, \n"+
		" TA.PREF_NUMERO, \n"+
		" TA.MODO_ENTRADA_POS, \n"+
		" TA.BDU_COM_CATEGORIA, \n"+
		" TA.CLAVE_FACTOR_COMERCIO, \n"+
		" TA.CLAVE_FACTOR_INTERCAMBIO, \n"+
		" TA.CUOTA_INTERCAMBIO, \n"+
		" TA.IMPORTE_IVA_COMERCIO, \n"+
		" TA.CUENTA_CHEQUES REFERENCIA_CHEQUES, \n"+
		" TA.RUTEO, \n"+
		" TA.MAPR_NUMERO MARCA, \n"+
		" TA.TLI_NUMERO, \n"+
		" TA.RED_LOGICA, \n"+
		" TA.RED_LOGICA_EMI, \n"+
		" TA.TTR_NUMERO, \n"+
		" TO_CHAR(TA.FECHA_CONSUMO_TRANSAC,'HH24:mi:ss') HORAS, \n"+
		" TA.CODIGO_RAZON, \n"+
		" TA.IND_TER_CAP, \n"+
		" TA.TERM_ID, \n"+
		" TA.BDU_COM_VIG, \n"+
		" TA.BDU_COM_CAT_DEB TB_CAT_DR, \n"+
		" (SELECT VALOR_NUMERICO FROM SUPERSIC.PARAMETROS_COMPENSACION WHERE NUMERO=50) IVA, \n"+
		" TA.PROC_NUMERO, \n"+
		" TA.CODIGO_RESPUESTA_AUT, \n"+
		" TA.TIPO_CAPTURA, \n"+
		" TA.CODIGO_RESPUESTA_ISO, \n"+
		" TA.NUMERO, \n"+
		" TA.IND_TER_ACT, \n"+
		" TA.IND_TER_CAP, \n"+
		" TA.CUOTA_INTERCAMBIO TARIFA_TASA, \n"+
		" TA.IND_COM_ELEC ICE, \n"+
		" TA.ES_NACIONAL, \n"+
		" TA.IMPORTE_CUOTA_COMERCIO, \n"+
		" TA.CUOTA_COMERCIO, \n"+
		" TA.TIPO_CAPTURA IND_EMV, \n"+
		" TA.IND_PD, \n"+
		" TA.ESTATUS_TRANSACCION, \n"+
		" TA.TYP , \n"+
		" TA.TIER_CODIGO_MONEDA \n"+
		" FROM SUPERSIC.TRANSACCIONES_ACEPTADAS TA \n"+
		" JOIN SUPERSIC.ARCHIVOS A ON TA.ARCH_NUMERO=A.NUMERO \n"+
		" JOIN SUPERSIC.ENTIDADES EADQ ON EADQ.NUMERO_PROSA=TA.ENT_NUMERO_PROSA_ADQ \n"+
		" JOIN SUPERSIC.ENTIDADES EEMI ON EEMI.NUMERO_PROSA=TA.ENT_NUMERO_PROSA_EMI \n"+
		" JOIN SUPERSIC.TIPOS_TRANSACCION TT ON TT.NUMERO=TA.TTR_NUMERO \n"+
		" WHERE ";
		
		if(!params.initDate.contains("None")){
			query+=" TRUNC(TA.FECHA_PROCESO_TRANSAC,'MONTH')=TO_DATE('"+params.initDate+"' ,'dd-MM-yyyy') \n"+
            	   "  AND TA.FECHA_PROCESO_TRANSAC >= TO_DATE('"+params.session.getAttribute("fechaXML").toString()+"','DD/MM/YYYY') ";
		}else{
			query+= " 0=0 ";
		}
		
		if (!params.numeroFuente.equals("None")){
			query+=" AND TA.ARCH_NUMERO in("+params.numeroFuente+") ";
		}
		
		if(!params.tipoTransaccion.equals("None")){
			query+=" AND TA.TTR_NUMERO in( "+params.tipoTransaccion+") ";
		}
		
		if(params.rol.equals("banco")){
			if(params.bancoRecep.equals("None")&&params.bancoEmi.equals("None")){
				query+="and (TA.ENT_NUMERO_PROSA_EMI in ("+params.numerosProsa+") or TA.ENT_NUMERO_PROSA_ADQ in("+params.numerosProsa+"))";
			}else{
				query+=" AND TA.ENT_NUMERO_PROSA_ADQ in("+params+")";
			}
			
			if(!params.bancoEmi.equals("None")){
				query+=" AND TA.ENT_NUMERO_PROSA_EMI in("+params.bancoEmi+")";
			}
		}else{
			if(!params.bancoRecep.equals("None")){
				query+=" AND TA.ENT_NUMERO_PROSA_ADQ in("+params.bancoRecep+")";
			}
			if(!params.bancoEmi.equals("None")){
				query+=" AND TA.ENT_NUMERO_PROSA_EMI in("+params.bancoEmi+") ";
			}
		}
		
		if(!params.numeroCuenta.equals("")){
			query+= " AND TA.CUENTA = '"+params.numeroCuenta+"' ";
		}
		
		if(!params.numeroAutorizacion.equals("")){
			query+="  AND TA.NUMERO_AUTORIZACION = '"+params.numeroAutorizacion+"'  ";
		}
		
		if(!params.numeroRef.equals("")){
			query+=" AND TA.NUMERO_REFERENCIA ='"+params.numeroRef+"' ";
		}
		
		if(!params.numeroComercio.equals("")){
			query+=" AND TA.NUMERO_COMERCIO in ("+params.numeroComercio+") ";
		}
		
		if(!params.nombreComercio.equals("")){
			query+=" AND TRIM(TA.NOMBRE_COMERCIO) ='"+params.nombreComercio+"' ";
		}
		
		if(!params.importe.equals("")){
			query+=" AND  TA.IMPORTE_TOTAL_TRANSAC ="+params.importe+" ";
		}
		
		return query;
		
	}

	/**
	 * Metodo que genera query para reporte SICMOF0120
	 * @param params
	 * @return 
	 */
	public static String SICMOF0120(TableParams params) {
		String query ="	SELECT  "+
		"   PTD.TD_SRCE_NBR FUENTE  \n"+
		" , PA.DESCRIPCION  \n"+
		" , case "+
		"                    when  substr(CTF_FILE_CNTXT,1,3) like '005%' "+
		"                       then "+
		"                          rtrim(CTF_FILE_CNTXT)||ctb_btch_id||'.PROC' "+
		"                       else "+
		"                          rtrim(CTF_FILE_CNTXT)||'.PROC' "+
		"                 end NOMBRE_ARCHIVO  \n"+ 
		" , TO_CHAR(CPT.PT_DT,'DD/MM/YYYY') F_CONSUMO   \n"+
		" , TO_CHAR(CPT.PT_LOAD_PROC_DT,'DD/MM/YYYY') F_PROCESO   \n"+
		" , PTD.TD_PROSA_ACQ_ENTITY ENT_ADQ   \n"+
		" , PEACQ.DESCRIPCION ADQ_DESCRIPCION  \n"+ 
		" , PTD.TD_ACQ_BU BU_ADQ   \n"+
		" , PTD.TD_PROSA_ISS_ENTITY ENT_EMI  \n"+
		" , PEEMI.DESCRIPCION EMI_DESCRIPCION  \n"+  
		" , PTD.TD_ISS_BU BU_EMI    \n"+
		" , CPT.PT_AUTH_CD No_AUTORIZACION   \n"+
		" , DECODE(PTD.TD_SRCE_NBR,48,CPT.PT_ACQ_REF_NUM,49,CPT.PT_ACQ_REF_NUM,CTC.TCLR_ACQ_REF_NUM ) No_REFERENCIA  \n"+  
		" , TRIM(CPT.PT_TI_ID) CUENTA    \n"+
		" , PTT.NUMERO CLAVE_TXS   \n"+
		" , PTT.DESCRIPCION DESCRIPCION_CLAVE_TXS   \n"+
		" , CASE \n" +
		"		WHEN PTD.TD_SRCE_NBR IN (49) THEN LTRIM(PT_RTLR_ID,0)   \n" +
		"        WHEN PTD.TD_SRCE_NBR IN (48,2848,2948,1148,2548,2648) THEN TRIM(SUBSTR(IR_DE42,1,9)) \n "+
		"		WHEN PTD.TD_PROC_NBR IN (8,9) THEN LTRIM(CPT.PT_RTLR_ID,0) \n"+
		"       ELSE LTRIM(PTB.TB_AFFL,0) \n"+                                        
		"  END No_COMERCIO \n"+
		" , TRIM(PTB.TB_COM_NAME) NOMBRE_COMERCIO  \n"+ 
		" , PTB.TB_SIC_CVE GIRO    \n"+
		" , TRIM(TO_CHAR(CPT.PT_REQ_AMT,'999,999,999,999,999.99')) IMP_TRANS  \n"+
		" , PT_FACTOR_COMERCIO CUOTA_COM   \n"+
		" , PPT.PT_MRCH_IVA_AMT IVA_COM   \n"+
		"-- , TO_NUMBER(DECODE(PTD.TD_PROSA_ISS_ENTITY,94,SUBSTR(CPT.PT_TI_ID,1,6),98,SUBSTR(CPT.PT_TI_ID,1,6),CUT.UT_ISS_BIN)) PREFIJO  \n"+
		" ,PTD.TD_BIN_BIN PREFIJO \n"+
		" , REPLACE(PTD.TD_POS_ENTRY_MOD,' ',NULL) MODO_POS    \n"+
		" , DECODE(PTD.TD_USG_TYP_ID,1,PTB.TB_CATEGORIA,PTB.TB_CAT_DR) CATEGORIA  \n"+ 
		" , DECODE(PTD.TD_USG_TYP_ID,1,PTB.TB_COM_CVE_DESC_CREDITO,2,PTB.TB_COM_CVE_DESC_DEBITO) FACTOR_COM   \n"+
		" , DECODE(PTD.TD_USG_TYP_ID,1,PTB.TB_COM_CVE_INT_CREDITO,2,PTB.TB_COM_CVE_INT_DEBITO) FACTOR_INT   \n"+
		" , DECODE(PTD.TD_USG_TYP_ID,1,PTB.TB_COM_VALOR_INT_CREDITO,2,PTB.TB_COM_VALOR_INT_DEBITO) CUOTA_INT   \n"+
		" , PPT.PT_INTCHG_IVA_AMT IVA_INT   \n"+
		" , TRIM(' ' FROM PTD.TD_CHECKING_ACCOUNT) REF_CHEQ  \n"+ 
		" , PTD.TD_RUTEO RUTEO   \n"+
		" , PTD.TD_TI_BRAND MARCA    \n"+
		" , PTD.TD_LIQUIDACION LIQ    \n"+
		" , PTD.TD_ACQ_LN RED_LOGICA_ADQ   \n"+
		" , REPLACE(PTD.TD_ISS_LN,' ',NULL) RED_LOGICA_EMI  \n"+  
		"-- , CUT.UT_TYP TIPO_TXS    \n"+
		" , PTD.TD_TC_GRP_ID TIPO_TXS    \n"+
		" , REPLACE(CPT.PT_TIM,'.',':' )HORA_CONSUMO   \n"+
		" , PTD.TD_RSN_CD CODIGO_RAZON    \n"+
		" , PTD.TD_POS_TERM_CAP TERM_CAP  \n"+
		" , TRIM(CPT.PT_RTLR_ID)||SUBSTR(TRIM(PTD.TD_TERM_NUM),LENGTH(TRIM(PTD.TD_TERM_NUM))-2,LENGTH(TRIM(PTD.TD_TERM_NUM))) TERMINAL  \n"+
		"  , PTB.TB_VIG   \n"+
		" , PTB.TB_CAT_DR   " +
		" ,DECODE(PTB.TB_IVA,1,(SELECT PP_VALOR FROM PMADMIN.PRSA_PARAMETROS WHERE PP_ID_PARAMETRO = 'IVA_PARM'),NULL) IVA \n"+
		" , PTD.TD_PROC_NBR PROCEDENCIA   \n"+
		" ,null CODIGO_RESPUESTA_AUT "+
		" , CASE "+
		"   WHEN PTD.TD_PROC_NBR IN (1,22,24) \n"+
		"       AND PTD.TD_SRCE_NBR NOT IN (125)  \n"+
		"      THEN 'B' \n"+
		"   WHEN PTD.TD_PROC_NBR IN (23) \n"+
		"       AND (PTD.TD_SRCE_NBR IN (35) AND PTD.TD_POS_ENTRY_MOD IN ('01','90',' ')) \n"+
		"       OR PTD.TD_SRCE_NBR IN (214,218,270,275,1008,1010,1013,2110) \n"+
		"       THEN 'B' \n"+
		"   WHEN PTD.TD_PROC_NBR IN (23) \n"+
		"       AND (PTD.TD_SRCE_NBR IN (35) AND PTD.TD_POS_ENTRY_MOD NOT IN ('01','90',' ')) \n"+
		"       OR PTD.TD_SRCE_NBR NOT IN (214,218,270,275,1008,1010,1013,2110) \n"+
		"       THEN '0'  \n"+
		"   WHEN PTD.TD_SRCE_NBR IN (125) \n"+
		"       THEN NULL \n"+
		"   ELSE DECODE (PTD.TD_PROC_NBR,6,TD_CAPT_TYP_BMXR,NULL) \n"+
		" END TIPO_CAPTURA \n"+
		" ,PMADMIN.FN_RESPONSE_CODE(TRIM(CPT.PT_RESP_C))  CODIGO_RESPUESTA_ISO \n"+
		"  ,PTD.TD_WH_SEQ  NUMERO \n"+
		"  ,(CASE \n" +
		"            WHEN PTD.TD_PROC_NBR <> 22 THEN NULL \n" +
		"            WHEN PTD.TD_PROC_NBR = 22 THEN TRIM(SUBSTR(PTK2.TKC4,10,1))\n" +
		"       END)   IND_TER_ACT \n"+
		"  ,(CASE \n"+
		"        WHEN PTD.TD_PROC_NBR=6 THEN TD_POS_TERM_CAP " +
		"        WHEN PTD.TD_PROC_NBR <> 22 THEN NULL \n"+
		"        WHEN PTD.TD_PROC_NBR = 22 THEN TRIM(SUBSTR(PTK2.TKC4,11,1)) \n"+
		"   END) IND_TER_CAP\n"+
		" ,DECODE(PTD.TD_PROC_NBR,1,DECODE(PTD.TD_USG_TYP_ID,1,PTB.TB_COM_VALOR_DESC_CREDITO,2,PTB.TB_COM_VALOR_INT_DEBITO),DECODE(PTD.TD_USG_TYP_ID,1,PTB.TB_ELECTR_CR,2,PTB.TB_ELECTR_DR)) TARIFA_TASA  \n"+   
		" ,SUBSTR(PTD.TD_ELEC_COMM_IND,1,1) ICE \n"+
		", PB.PBIN_GLOBAL_LOCALE_S \n"+
		" , ppt.PT_INTCHG_FEE_AMT imp_intercambio \n"+
		" , ppt.pt_MRCH_FEE_AMT   importe_comercio \n"+
		" ,DECODE(SUBSTR(PTK2.TKB4,5,1),NULL,'B',0,'B','1','A','C') IND_EMV \n"+
		" ,PPT.PT_IND_PAGOS_DIFERIDOS IND_DIF"+
		" ,(select max (pqm_msg_code||'  '||pqm_msg_text) from pmadmin.PRSA_QMS_MESSAGES where to_char(pqm_codigo_razon)= ltrim(trim(ptd.TD_RSN_CD),'0') ) "+
		" ,SUBSTR(CPT.PT_ORIG_TXN_CD,1,2) TC \n"+
		" ,TO_CHAR(PTD.TD_TYP) TYP \n"+
		" ,CPT.PT_TXN_CRNCY_CD moneda \n"+
		" FROM     CORE.CZ_PRCD_TXN CPT \n";
		
		if(!params.initDate.contains("None")){
			query+="   INNER JOIN CORE.BS_PARTMDATA CBS    \n"+
			"                                     ON CPT.PARTITION_ID = CBS.PARTITION_ID    \n"+
			"                                   AND CBS.OBJECT_NAME = 'CORE.CZ_PRCD_TXN'    \n"+
			"                                    AND part_group_id='802'  \n"+
			"                                     AND CPT.PARTITION_ID = CBS.PARTITION_ID    \n"+
			"                                  AND trunc(START_TS,'MONTH')=TO_DATE('"+params.initDate+"' ,'dd-MM-yyyy')   \n"+
			"								  AND START_TS >= TO_DATE('"+params.session.getAttribute("fechaXML").toString()+"','DD/MM/YYYY') ";
		}
		
		
		query+="                           LEFT JOIN PMADMIN.PRSA_TXN_BDU PTB    \n"+
		"                                  ON CPT.PARTITION_ID = PTB.PARTITION_ID    \n"+
		"                                    AND CPT.PT_WH_GRP = PTB.TB_WH_GRP    \n"+
		"                                  AND CPT.PT_WH_SEQ = PTB.TB_WH_SEQ    \n"+
		"                         LEFT JOIN PMADMIN.PRSA_TXN_DATA PTD    \n"+
		"                                  ON CPT.PARTITION_ID = PTD.PARTITION_ID    \n"+
		"                                 AND CPT.PT_WH_GRP = PTD.TD_WH_GRP    \n"+
		"                                  AND CPT.PT_WH_SEQ = PTD.TD_WH_SEQ    \n"+
		"                         LEFT JOIN PMADMIN.PRSA_PRCD_TXN PPT    \n"+
		"                                      ON  CPT.PARTITION_ID= PPT.PARTITION_ID    \n"+
		"                                     AND  CPT.PT_WH_GRP= PPT.PT_WH_GRP   \n"+
		"                                     AND  CPT.PT_WH_SEQ= PPT.PT_WH_SEQ    \n"+
		"                           LEFT JOIN CORE.CZ_UNPRCD_TXN CUT    \n"+
		"                                     ON  CPT.PARTITION_ID= CUT.UT_PRCD_PART_ID    \n"+
		"                                     AND CPT.PT_WH_GRP = CUT.UT_WH_GRP    \n"+
		"                                     AND CPT.PT_WH_SEQ = CUT.UT_WH_SEQ \n"+
		" LEFT JOIN CORE.CZ_TXN_CLEAR CTC "+
		"                                                 ON CPT.PARTITION_ID=CTC.PARTITION_ID \n"+
		"                                                 AND CPT.PT_WH_GRP=CTC.TCLR_TH_GRP  \n"+
		"                                                 AND CPT.PT_WH_SEQ=CTC.TCLR_TH_SEQ  \n"+
		" 	       				LEFT JOIN PMADMIN.PRSA_BIN PB    "+
		"             						ON  PBIN_BIN = substr(CPT.PT_TI_ID,0,6)  "+
		" 		   				 LEFT JOIN PMADMIN.PRSA_ENTIDADES PEACQ ON PEACQ.NUMERO_PROSA=PTD.TD_PROSA_ACQ_ENTITY  "+
		" 	        				 LEFT JOIN PMADMIN.PRSA_ENTIDADES PEEMI ON PEEMI.NUMERO_PROSA=PTD.TD_PROSA_ISS_ENTITY  "+
		" 		   				LEFT JOIN PMADMIN.PRSA_ARCHIVOS PA ON PTD.TD_SRCE_NBR= PA.NUMERO   "+
		" 	                        INNER JOIN CORE.CZ_T_BTCH CTB ON CTB.CTB_BTCH_SIN = PTD.TD_BTCH_SIN   "+
		" 		                    INNER JOIN CORE.CZ_T_FILE CTF ON CTF.CTF_FILE_SIN = CTB.CTB_FILE_SIN  "+
		" 		                    INNER JOIN PMADMIN.SZ_TC_GRP STG ON STG.TCG_GRP_ID = PTD.TD_TC_GRP_ID  "+
		"                 LEFT JOIN PMTW.POS_T_TKN2 PTK2 "+
		"                 ON PTK2.PARTITION_ID = PTD.PARTITION_ID "+
		"                 AND PTK2.POS_TRAN_ID_KEY = PTD.TD_WH_SEQ "+
		" INNER JOIN PMADMIN.PRSA_TIPOS_TRANSACCION PTT "+
		" ON PTT.NUMERO = PTD.TD_TXN_TYP \n"+
		" LEFT JOIN IPM.IPM_REC IR "+
		"  ON CPT.PARTITION_ID = IR.PARTITION_ID "+
		"  AND CPT.PT_WH_SEQ = IR.IR_RECORDKEY "+
		" 		   	WHERE 	 "+
		" 		   PTD.TD_TC_GRP_ID IN (281,120) "+
		"    AND PEACQ.TIE_NUMERO<>9 ";
		
		if(!params.numeroCuenta.contains("None")){
			query+="   AND CPT.PT_TI_ID = '"+params.numeroCuenta+"'    \n";
		}
		
		return query;
	}


	/**
	 * Metodo para generar query de rechazos
	 * @param params
	 * @return
	 */
	public static String rechazos(TableParams params){
		String query = " SELECT    \n"+
	"              PRT.PRT_SRCE_NBR FUENTE,    \n"+
	"              PA.DESCRIPCION FUENTE_DES,    \n"+
	"              TRIM(PRT.PRT_FILENAME)||'.PROC' NOMBRE_ARCHIVO,   \n"+
	"              TO_CHAR(PRT.PRT_TRAN_DT,'DD/MM/YYYY') F_CONSUMO,   \n"+
	"              TO_CHAR(PRT.PRT_PROC_DTE,'DD/MM/YYYY') F_PROCESO,    \n"+
	"              PEACQ.NUMERO_PROSA ENT_ADQ,    \n"+
	"              PEACQ.DESCRIPCION ADQ_DESC,    \n"+
	"              PEACQ.BU_TX_ADQ ADQ_BU,    \n"+
	"              PEEMI.NUMERO_PROSA ENT_EMI,    \n"+
	"              PEEMI.DESCRIPCION EMI_DESC,    \n"+
	"              PEEMI.BU_TX_ISS EMI_BU,    --10  \n"+
	"              PRT.PRT_AUTH_NBR NO_AUTORIZACION,    \n"+
	"              PRT.PRT_REFERENCE_NBR NO_REFERENCIA,    \n"+
	"              PRT.PRT_TI_ID CUENTA,    \n"+
	"              CASE \n" +
	"				WHEN (SUBSTR(PRT_B24_TC,1,2) = '10' AND PRT_B24_TIPO_MENSAJE = '0420') THEN 21 \n" +
	"               ELSE PRT.PRT_TRAN_TYP \n" +
	"			   END CLAVE_TXS,    \n"+
	"              CASE \n" +
	"				WHEN (SUBSTR(PRT_B24_TC,1,2) = '10' AND PRT_B24_TIPO_MENSAJE = '0420') THEN 'DEVOLUCIONES' \n" +
	"               ELSE PTT.DESCRIPCION \n" +
	"              END DESCRIPCION_CLAVE_TXS,    \n"+
	"              PRT.PRT_MRCH_NBR NO_COMERCIO,    \n"+
	"              TBBC.COM_NOMBRE NOM_COMERCIO, \n"+ 
	"              NULL GIRO,    \n"+
	"              TRIM(TO_CHAR(PRT.PRT_TRAN_AMT,'999,999,999,999,999.99')) IMP_TANS,    \n"+
	"              PRT.PRT_MRCH_FEE_AMT CUOTA_COM,   --20  \n"+
	"              PRT.PRT_MRCH_IVA_AMT IVA_COM,    \n"+
	"              PRT.PRT_BIN_BIN,    \n"+
	"              REPLACE(PRT.PRT_POS_ENTRY_BMXR,' ',NULL) MOD_POS,    \n"+
	"              --PRT.PRT_USG_CDE_BMXR,    \n"+
	"              DECODE(PRT_BIN_TI_USG_TYP,1,TBBC.COM_CATEGORIA,2,TBBC.COM_CAT_DEB) CATEGORIA,    \n"+
	"               DECODE(PRT_BIN_TI_USG_TYP,1,TBBCB.COM_CVE_DESC_CREDITO ,2,TBBCB.COM_CVE_DESC_DEBITO ) FACTOR_COMERCIO,    \n"+
	"               DECODE(PRT_BIN_TI_USG_TYP,1,TBBC.COM_CVE_INT_CREDITO ,2,TBBC.COM_CVE_INT_DEBITO ) FACTOR_INT,    \n"+
	"              PRT.PRT_INTCHG_FEE_AMT,    \n"+
	"              PRT.PRT_INTCHG_IVA_AMT,    \n"+
	"              PRT.PRT_CHECKING_ACCOUNT,    \n"+
	"              NULL RUTEO,   --No disponible --30  \n"+
	"              NULL MARCA,    \n"+
	"              NULL LIQ,     --No disponible  \n"+
	"              PRT.PRT_LN RED_LOGICA_ADQ,    \n"+
	"              PEEMI.NUMERO_LN RED_LOGICA_EMI,    \n"+
	"              PRT.PRT_TRAN_TYP TIPOS_TXS,    \n"+
	"              DECODE(PRT.PRT_SRCE_NBR,5,SUBSTR(PRT.PRT_TRAN_TM,0,2)||':'||SUBSTR(PRT.PRT_TRAN_TM,3,2)||':'||SUBSTR(PRT.PRT_TRAN_TM,5,2),PRT.PRT_TRAN_TM) HORA_CONSUMO,    \n"+
	"              PRT.PRT_RSN_CD CODIGO_RAZON,    \n"+
	"              PRT.PRT_MEDIA_ACCESS_IND TERM_CAP,   \n"+
	"              TRIM(PRT.PRT_MRCH_NBR)||SUBSTR(TRIM(PRT.PRT_TERM_NBR),LENGTH(TRIM(PRT.PRT_TERM_NBR))-2,LENGTH(TRIM(PRT.PRT_TERM_NBR))) TERMINAL,     \n"+
	"              NULL TB_VIG, --40 --No disponible  \n"+
	"              NULL TB_CAT_DR,   \n"+
	"              (SELECT PP_VALOR FROM PMADMIN.PRSA_PARAMETROS WHERE PP_ID_PARAMETRO = 'IVA_PARM') IVA,   \n"+
	"              PRT.PRT_PROCEDENCIA_NBR PROCEDENCIA,   \n"+
	"              NULL CODIGO_RESP,   \n"+
	"              PRT.PRT_CAPT_MDE TIPO_CAPTURA,   \n"+
	"              PRT.PRT_RESP_C CODIGO_RESPUESTA_ISO,   \n"+
	"              PRT.PRT_WH_SEQ NUMERO,   \n"+
	"              NULL IND_TER_ACT,    \n"+
	"              NULL IND_TER_CAP,     \n"+
	"              DECODE(PRT.PRT_PROCEDENCIA_NBR,1,DECODE(PRT_BIN_TI_USG_TYP,1,TBBCB.COM_VALOR_DESC_CREDITO ,2,TBBCB.COM_VALOR_DESC_DEBITO ),DECODE(PRT_BIN_TI_USG_TYP,1,TBBC.CAT_COMISION_MANUAL_CRE ,2,TBBC.CAT_COMISION_MANUAL_DEB )) TARIFA_TASA, --50  \n"+
	"              substr(prt.PRT_ELECTRONIC_IND,1,1) ice,   \n"+
	"              PB.PBIN_GLOBAL_LOCALE_S ,   \n"+
	"              prt.PRT_MRCH_FEE_AMT imp_comercio,    \n"+
	"              prt.PRT_INTCHG_FEE_AMT imp_intercambio,   \n"+
	"              NULL IND_EMV,   \n"+
	"              NULL PAGOS_DIF,  --56  \n"+
	"              PRT.PRT_REJ_RSN ||' '||PQM.PQM_MSG_TEXT \n" +
	"              ,SUBSTR(PRT_B24_TC,1,2) TC \n"+
	"              ,PRT_B24_TIPO_MENSAJE TYP \n"+
	"              ,PRT.PRT_TXN_CRNCY_CD moneda \n"+
	"              FROM PMADMIN.PRSA_REJECTED_TXN PRT   \n"+
	"              LEFT JOIN PMADMIN.PRSA_ARCHIVOS PA ON PRT.PRT_SRCE_NBR= PA.NUMERO   \n"+
	"              LEFT JOIN PMADMIN.VW_BUS_ACQ PEACQ ON PEACQ.BU_TX_ADQ =PRT.PRT_ACQ_BU     \n"+
	"              LEFT JOIN PMADMIN.VW_BUS_EMI PEEMI ON PEEMI.BU_TX_ISS =PRT.PRT_ISS_BU      \n"+
	"              LEFT JOIN PMADMIN.PRSA_TIPOS_TRANSACCION PTT ON PRT.PRT_TRAN_TYP=PTT.NUMERO  \n"+
	"              LEFT JOIN PMADMIN.TBL_BDU_BIT_COM TBBC ON TO_CHAR(TBBC.COM_AFILIACION)=TRIM(PRT.PRT_MRCH_NBR)  \n"+
	"              LEFT JOIN PMADMIN.TBL_BDU_BIT_COM_BCO TBBCB ON TO_CHAR(TBBCB.COM_AFILIACION )=TRIM(PRT.PRT_MRCH_NBR) AND TBBCB.BCO_FIID = PEACQ.NUMERO_FIID   \n"+
	"              LEFT JOIN PMADMIN.PRSA_QMS_MESSAGES PQM    ON TRIM(PRT.PRT_REJ_RSN) = TRIM(PQM.PQM_MSG_CODE)    \n "+
	"              LEFT JOIN PMADMIN.PRSA_BIN PB ON PBIN_BIN = SUBSTR(PRT.PRT_TI_ID,0,6) "+
	" WHERE   \n";
		
		if(!params.initDate.contains("None")){
			query+=" TRUNC(PRT.PRT_PROC_DTE,'MONTH')= TO_DATE('"+params.initDate+"' ,'dd-MM-yyyy') \n"+
			"  AND PRT.PRT_PROC_DTE >= TO_DATE('"+params.session.getAttribute("fechaXML").toString()+"','DD/MM/YYYY') ";
		}else{
				query+=" 0=0 ";			
		}
		
		if (!params.numeroFuente.equals("None")){
			query+=" AND PRT_SRCE_NBR in("+params.numeroFuente+")";
		}
		
		if(params.rol.equals("banco")){
			if(params.bancoRecep.equals("None")&&params.bancoEmi.equals("None")){
				query+=" and (PEEMI.entidad_padre in ("+params.numerosProsa+") or PEACQ.entidad_padre in("+params.numerosProsa+"))";
			}

			if(!params.bancoRecep.equals("None")){
				query+=" AND PEACQ.ENTIDAD_PADRE in("+params.bancoRecep+")";
			}
			
			if(!params.bancoEmi.equals("None")){
				query+=" AND PEEMI.ENTIDAD_PADRE in("+params.bancoEmi+") ";
			}
		}else{
			if(!params.bancoRecep.equals("None")){
				query+=" AND PEACQ.ENTIDAD_PADRE in("+params.bancoRecep+")";
			}
			if(!params.bancoEmi.equals("None")){
				query+=" AND PEEMI.ENTIDAD_PADRE in("+params.bancoEmi+") ";
			}
		}
		
		if(!params.numeroCuenta.equals("")){
			query+=" AND PRT.PRT_TI_ID = '"+params.numeroCuenta+"' ";
		}
		
		if(!params.numeroAutorizacion.equals("")){
			query+="  AND PRT_AUTH_NBR ='"+params.numeroAutorizacion+"'  ";
		}
		
		if(!params.numeroRef.equals("")){
			query+=" AND PRT_REFERENCE_NBR ='"+params.numeroRef+"' ";
		}
		
		if(!params.numeroComercio.equals("")){
			query+=" AND TO_NUMBER(PRT_MRCH_NBR) in ("+params.numeroComercio+") ";
		}
		
		if(!params.nombreComercio.equals("")){
			query+=" AND TRIM(PRT_MRCH_NAM_BMXR) ='"+params.nombreComercio+"' ";
		}
		
		if(!params.importe.equals("")){
			query+=" AND  PRT_TRAN_AMT ="+params.importe+" ";
		}
		
		if(params.reporte==120){
			query+="    AND PEACQ.TIE_NUMERO<>9 ";
		}else if(params.reporte==121){
			query+="    AND PEACQ.TIE_NUMERO=9 ";
		}
		
		
		return query;
	}

	
	
	/**
	 * Metodo que genera query para reporte SICMOF0121
	 * @param params
	 * @return 
	 */
	public static String SICMOF0121(TableParams params) {
		String query = "		SELECT  "+
		"   PTD.TD_SRCE_NBR FUENTE  \n"+
		" , PA.DESCRIPCION  \n"+
		" , case "+
		"                    when  substr(CTF_FILE_CNTXT,1,3) like '005%' "+
		"                       then "+
		"                          rtrim(CTF_FILE_CNTXT)||ctb_btch_id||'.PROC' "+
		"                       else "+
		"                          rtrim(CTF_FILE_CNTXT)||'.PROC' "+
		"                 end NOMBRE_ARCHIVO  \n"+ 
		" , TO_CHAR(CPT.PT_DT,'DD/MM/YYYY') F_CONSUMO   \n"+
		" , TO_CHAR(CPT.PT_LOAD_PROC_DT,'DD/MM/YYYY') F_PROCESO   \n"+
		" , PTD.TD_PROSA_ACQ_ENTITY ENT_ADQ   \n"+
		" , PEACQ.DESCRIPCION ADQ_DESCRIPCION  \n"+ 
		" , PTD.TD_ACQ_BU BU_ADQ   \n"+
		" , PTD.TD_PROSA_ISS_ENTITY ENT_EMI  \n"+
		" , PEEMI.DESCRIPCION EMI_DESCRIPCION  \n"+  
		" , PTD.TD_ISS_BU BU_EMI    \n"+
		" , CPT.PT_AUTH_CD No_AUTORIZACION   \n"+
		" , DECODE(PTD.TD_SRCE_NBR,48,CPT.PT_ACQ_REF_NUM,49,CPT.PT_ACQ_REF_NUM,CTC.TCLR_ACQ_REF_NUM ) No_REFERENCIA  \n"+  
		" , TRIM(CPT.PT_TI_ID) CUENTA    \n"+
		// CAMBIO GERMAN TXN
		//" , PTD.TD_TC_GRP_ID CLAVE_TXS   \n"+
		//" , STG.TCG_GRP_NAM DESCRIPCION_CLAVE_TXS   \n"+
		" , PTT.NUMERO CLAVE_TXS   \n"+
		" , PTT.DESCRIPCION DESCRIPCION_CLAVE_TXS   \n"+
		// FIN CAMBIO GERMAN TXN			
		" , PTB.TB_AFFL No_COMERCIO   \n"+
		" , TRIM(PTB.TB_COM_NAME) NOMBRE_COMERCIO  \n"+ 
		" , PTB.TB_SIC_CVE GIRO    \n"+
		" , TRIM(TO_CHAR(CPT.PT_REQ_AMT,'999,999,999,999,999.99')) IMP_TRANS  \n"+
		" , PT_FACTOR_COMERCIO CUOTA_COM   \n"+
		" , PPT.PT_MRCH_IVA_AMT IVA_COM   \n"+
		"-- , TO_NUMBER(DECODE(PTD.TD_PROSA_ISS_ENTITY,94,SUBSTR(CPT.PT_TI_ID,1,6),98,SUBSTR(CPT.PT_TI_ID,1,6),CUT.UT_ISS_BIN)) PREFIJO  \n"+
		" ,PTD.TD_BIN_BIN PREFIJO \n"+
		" , REPLACE(PTD.TD_POS_ENTRY_MOD,' ',NULL) MODO_POS    \n"+
		" , DECODE(PTD.TD_USG_TYP_ID,1,PTB.TB_CATEGORIA,PTB.TB_CAT_DR) CATEGORIA  \n"+ 
		" , DECODE(PTD.TD_USG_TYP_ID,1,PTB.TB_COM_CVE_DESC_CREDITO,2,PTB.TB_COM_CVE_DESC_DEBITO) FACTOR_COM   \n"+
		" , DECODE(PTD.TD_USG_TYP_ID,1,PTB.TB_COM_CVE_INT_CREDITO,2,PTB.TB_COM_CVE_INT_DEBITO) FACTOR_INT   \n"+
		" , DECODE(PTD.TD_USG_TYP_ID,1,PTB.TB_COM_VALOR_INT_CREDITO,2,PTB.TB_COM_VALOR_INT_DEBITO) CUOTA_INT   \n"+
		" , PPT.PT_INTCHG_IVA_AMT IVA_INT   \n"+
		" , TRIM(' ' FROM PTD.TD_CHECKING_ACCOUNT) REF_CHEQ  \n"+ 
		" , PTD.TD_RUTEO RUTEO   \n"+
		" , PTD.TD_TI_BRAND MARCA    \n"+
		" , PTD.TD_LIQUIDACION LIQ    \n"+
		" , PTD.TD_ACQ_LN RED_LOGICA_ADQ   \n"+
		" , REPLACE(PTD.TD_ISS_LN,' ',NULL) RED_LOGICA_EMI  \n"+  
		"-- , CUT.UT_TYP TIPO_TXS    \n"+
		" , PTD.TD_TC_GRP_ID TIPO_TXS    \n"+
		" , REPLACE(CPT.PT_TIM,'.',':' )HORA_CONSUMO   \n"+
		" , PTD.TD_RSN_CD CODIGO_RAZON    \n"+
		//" , PTD.TD_MEDIA_ACCESS_IND TERM_CAP  \n"+ 
		" , PTD.TD_POS_TERM_CAP TERM_CAP  \n"+
		" , TRIM(CPT.PT_RTLR_ID)||SUBSTR(TRIM(PTD.TD_TERM_NUM),LENGTH(TRIM(PTD.TD_TERM_NUM))-2,LENGTH(TRIM(PTD.TD_TERM_NUM))) TERMINAL  \n"+
		"  , PTB.TB_VIG   \n"+
		" , PTB.TB_CAT_DR   " +
		" ,DECODE(PTB.TB_IVA,1,(SELECT PP_VALOR FROM PMADMIN.PRSA_PARAMETROS WHERE PP_ID_PARAMETRO = 'IVA_PARM'),NULL) IVA \n"+
		//" Faltan el valor para el tipo 2 del iva \n"+
		" , PTD.TD_PROC_NBR PROCEDENCIA   \n"+
		" ,null CODIGO_RESPUESTA_AUT "+
		//" ,DECODE (PTD.TD_PROC_NBR,6,TD_CAPT_TYP_BMXR,NULL) TIPO_CAPTURA \n"+
		" , CASE "+
		"   WHEN PTD.TD_PROC_NBR IN (1,22,24) \n"+
		"       AND PTD.TD_SRCE_NBR NOT IN (125)  \n"+
		"      THEN 'B' \n"+
		"   WHEN PTD.TD_PROC_NBR IN (23) \n"+
		"       AND (PTD.TD_SRCE_NBR IN (35) AND PTD.TD_POS_ENTRY_MOD IN ('01','90',' ')) \n"+
		"       OR PTD.TD_SRCE_NBR IN (214,218,270,275,1008,1010,1013,2110) \n"+
		"       THEN 'B' \n"+
		"   WHEN PTD.TD_PROC_NBR IN (23) \n"+
		"       AND (PTD.TD_SRCE_NBR IN (35) AND PTD.TD_POS_ENTRY_MOD NOT IN ('01','90',' ')) \n"+
		"       OR PTD.TD_SRCE_NBR NOT IN (214,218,270,275,1008,1010,1013,2110) \n"+
		"       THEN '0'  \n"+
		"   WHEN PTD.TD_SRCE_NBR IN (125) \n"+
		"       THEN NULL \n"+
		"   ELSE DECODE (PTD.TD_PROC_NBR,6,TD_CAPT_TYP_BMXR,NULL) \n"+
		" END TIPO_CAPTURA \n"+
		" ,PMADMIN.FN_RESPONSE_CODE(TRIM(CPT.PT_RESP_C))  CODIGO_RESPUESTA_ISO \n"+
		"  ,PTD.TD_WH_SEQ  NUMERO \n"+
		"  ,(CASE \n" +
		"            WHEN PTD.TD_PROC_NBR <> 22 THEN NULL \n" +
		"            WHEN PTD.TD_PROC_NBR = 22 THEN TRIM(SUBSTR(PTK2.TKC4,10,1))\n" +
		"       END)   IND_TER_ACT \n"+
		"  ,(CASE \n"+
		"        WHEN PTD.TD_PROC_NBR=6 THEN TD_POS_TERM_CAP " +
		"        WHEN PTD.TD_PROC_NBR <> 22 THEN NULL \n"+
		"        WHEN PTD.TD_PROC_NBR = 22 THEN TRIM(SUBSTR(PTK2.TKC4,11,1)) \n"+
		"   END) IND_TER_CAP\n"+
		" ,DECODE(PTD.TD_PROC_NBR,1,DECODE(PTD.TD_USG_TYP_ID,1,PTB.TB_COM_VALOR_DESC_CREDITO,2,PTB.TB_COM_VALOR_INT_DEBITO),DECODE(PTD.TD_USG_TYP_ID,1,PTB.TB_ELECTR_CR,2,PTB.TB_ELECTR_DR)) TARIFA_TASA  \n"+   
		" ,SUBSTR(PTD.TD_ELEC_COMM_IND,1,1) ICE \n"+
		", PB.PBIN_GLOBAL_LOCALE_S \n"+
		" , ppt.PT_INTCHG_FEE_AMT imp_intercambio \n"+
		" , ppt.pt_MRCH_FEE_AMT   importe_comercio \n"+
		" ,DECODE(SUBSTR(PTK2.TKB4,5,1),'0','B','1','A',NULL,'C',SUBSTR(PTK2.TKB4,5,1)) IND_EMV \n"+
		" ,PPT.PT_IND_PAGOS_DIFERIDOS IND_DIF"+
		" ,(select max (pqm_msg_code||'  '||pqm_msg_text) from pmadmin.PRSA_QMS_MESSAGES where to_char(pqm_codigo_razon)= ltrim(trim(ptd.TD_RSN_CD),'0') ) "+
		// CAMBIO DE JULIO 13/05/2011
		" ,SUBSTR(CPT.PT_ORIG_TXN_CD,1,2) TC \n"+
		" ,TO_CHAR(PTD.TD_TYP) TYP \n"+
		// FIN CAMBIO JULIO 13/05/2011
		" ,CPT.PT_TXN_CRNCY_CD moneda \n"+
		" FROM     CORE.CZ_PRCD_TXN CPT \n";
		if(!params.initDate.contains("None")){
			query+="   INNER JOIN CORE.BS_PARTMDATA CBS    \n"+
			"                                     ON CPT.PARTITION_ID = CBS.PARTITION_ID    \n"+
			"                                   AND CBS.OBJECT_NAME = 'CORE.CZ_PRCD_TXN'    \n"+
			"                                    AND part_group_id='802'  \n"+
			"                                     AND CPT.PARTITION_ID = CBS.PARTITION_ID    \n"+
			"                                  AND trunc(START_TS,'MONTH')=TO_DATE('"+params.initDate+"' ,'dd-MM-yyyy')   \n";
		}

		query+="                           LEFT JOIN PMADMIN.PRSA_TXN_BDU PTB    \n"+
		"                                  ON CPT.PARTITION_ID = PTB.PARTITION_ID    \n"+
		"                                    AND CPT.PT_WH_GRP = PTB.TB_WH_GRP    \n"+
		"                                  AND CPT.PT_WH_SEQ = PTB.TB_WH_SEQ    \n"+
		"                         LEFT JOIN PMADMIN.PRSA_TXN_DATA PTD    \n"+
		"                                  ON CPT.PARTITION_ID = PTD.PARTITION_ID    \n"+
		"                                 AND CPT.PT_WH_GRP = PTD.TD_WH_GRP    \n"+
		"                                  AND CPT.PT_WH_SEQ = PTD.TD_WH_SEQ    \n"+
		"                         LEFT JOIN PMADMIN.PRSA_PRCD_TXN PPT    \n"+
		"                                      ON  CPT.PARTITION_ID= PPT.PARTITION_ID    \n"+
		"                                     AND  CPT.PT_WH_GRP= PPT.PT_WH_GRP   \n"+
		"                                     AND  CPT.PT_WH_SEQ= PPT.PT_WH_SEQ    \n"+
		"                           LEFT JOIN CORE.CZ_UNPRCD_TXN CUT    \n"+
		"                                     ON  CPT.PARTITION_ID= CUT.UT_PRCD_PART_ID    \n"+
		"                                     AND CPT.PT_WH_GRP = CUT.UT_WH_GRP    \n"+
		"                                     AND CPT.PT_WH_SEQ = CUT.UT_WH_SEQ \n"+
		" LEFT JOIN CORE.CZ_TXN_CLEAR CTC "+
		"                                                 ON CPT.PARTITION_ID=CTC.PARTITION_ID \n"+
		"                                                 AND CPT.PT_WH_GRP=CTC.TCLR_TH_GRP  \n"+
		"                                                 AND CPT.PT_WH_SEQ=CTC.TCLR_TH_SEQ  \n"+
		" 	       				LEFT JOIN PMADMIN.PRSA_BIN PB    "+
		"             						ON  PBIN_BIN = substr(CPT.PT_TI_ID,0,6)  "+
		" 		   				 LEFT JOIN PMADMIN.PRSA_ENTIDADES PEACQ ON PEACQ.NUMERO_PROSA=PTD.TD_PROSA_ACQ_ENTITY  "+
		" 	        				 LEFT JOIN PMADMIN.PRSA_ENTIDADES PEEMI ON PEEMI.NUMERO_PROSA=PTD.TD_PROSA_ISS_ENTITY  "+
		" 		   				LEFT JOIN PMADMIN.PRSA_ARCHIVOS PA ON PTD.TD_SRCE_NBR= PA.NUMERO   "+
		" 	                        INNER JOIN CORE.CZ_T_BTCH CTB ON CTB.CTB_BTCH_SIN = PTD.TD_BTCH_SIN   "+
		" 		                    INNER JOIN CORE.CZ_T_FILE CTF ON CTF.CTF_FILE_SIN = CTB.CTB_FILE_SIN  "+
		" 		                    INNER JOIN PMADMIN.SZ_TC_GRP STG ON STG.TCG_GRP_ID = PTD.TD_TC_GRP_ID  "+
		"                 LEFT JOIN PMTW.POS_T_TKN2 PTK2 "+
		"                 ON PTK2.PARTITION_ID = PTD.PARTITION_ID "+
		"                 AND PTK2.POS_TRAN_ID_KEY = PTD.TD_WH_SEQ "+
		// CAMBIO GERMAN TXN
		" INNER JOIN PMADMIN.PRSA_TIPOS_TRANSACCION PTT "+
		" ON PTT.NUMERO = PTD.TD_TXN_TYP "+
		// FIN CAMBIO GERMAN TXN
		" 		   	WHERE 	 "+
		" 		   PTD.TD_TC_GRP_ID IN (281,120) "+
		//"        AND PTD.TD_PROSA_ISS_ENTITY <> 107 "+
		//"    AND cpt.PT_ORIG_CRNCY_CD=484 "+
		"    AND PEACQ.TIE_NUMERO<>9 ";
		
		if(!params.numeroCuenta.contains("None")){
			query+="   AND CPT.PT_TI_ID = '"+params.numeroCuenta+"'    \n";
		}
		
		
			
			
		return query;
	}


	/**
	 * Metodo que genera query para reporte SICMOF0101
	 * @param params
	 * @return 
	 */
	public static String SICMOF0101(TableParams params){
		String query=" SELECT  \n"+
		"   PTD.TD_SRCE_NBR FUENTE  \n"+                                                     //1
		" , PA.DESCRIPCION  \n"+                                                             //2
		" , case "+
		"                    when  substr(CTF_FILE_CNTXT,1,3) like '005%' "+
		"                       then "+
		"                          rtrim(CTF_FILE_CNTXT)||ctb_btch_id||'.PROC' "+
		"                       else "+
		"                          rtrim(CTF_FILE_CNTXT)||'.PROC' "+
		"                 end NOMBRE_ARCHIVO  \n"+                                            //3
		" , TO_CHAR(CPT.PT_DT,'DD/MM/YYYY') F_CONSUMO   \n"+                                                        //4
		" , TO_CHAR(CPT.PT_LOAD_PROC_DT,'DD/MM/YYYY') F_PROCESO   \n"+                                              //5
		" , PTD.TD_PROSA_ACQ_ENTITY ENT_ADQ   \n"+                                            //6
		" , PEACQ.DESCRIPCION ADQ_DESCRIPCION  \n"+                                           //7
		" , PTD.TD_ACQ_BU BU_ADQ   \n"+                                                       //8
		" , PTD.TD_PROSA_ISS_ENTITY ENT_EMI  \n"+                                             //9
		" , PEEMI.DESCRIPCION EMI_DESCRIPCION  \n"+                                           //10
		" , PTD.TD_ISS_BU BU_EMI    \n"+                                                      //11
		" , CPT.PT_AUTH_CD No_AUTORIZACION   \n"+                                             //12
		" , DECODE(PTD.TD_SRCE_NBR,48,CPT.PT_ACQ_REF_NUM,49,CPT.PT_ACQ_REF_NUM,CTC.TCLR_ACQ_REF_NUM ) No_REFERENCIA  \n"+ //13  
		" , TRIM(CPT.PT_TI_ID) CUENTA    \n"+                                                 //14
		// CAMBIO GERMAN TXN
		//" , PTD.TD_TC_GRP_ID CLAVE_TXS   \n"+
		//" , STG.TCG_GRP_NAM DESCRIPCION_CLAVE_TXS   \n"+
		" , PTT.NUMERO CLAVE_TXS   \n"+                                                       //15
		" , PTT.DESCRIPCION DESCRIPCION_CLAVE_TXS   \n"+                                      //16
		// FIN CAMBIO GERMAN TXN			
		" , TO_NUMBER(PTB.TB_AFFL) No_COMERCIO   \n"+                                         //17
		" , TRIM(PTB.TB_COM_NAME) NOMBRE_COMERCIO  \n"+                                       //18
		" , PTB.TB_SIC_CVE GIRO    \n"+                                                       //19
		" , TRIM(TO_CHAR(CPT.PT_REQ_AMT,'999,999,999,999,999.99')) IMP_TRANS  \n"+            //20
		" , ppt.PT_INTCHG_FEE_AMT imp_intercambio \n"+                                        //21
		" , PPT.PT_INTCHG_IVA_AMT IVA_INT   \n"+                                              //22
		"-- , TO_NUMBER(DECODE(PTD.TD_PROSA_ISS_ENTITY,94,SUBSTR(CPT.PT_TI_ID,1,6),98,SUBSTR(CPT.PT_TI_ID,1,6),CUT.UT_ISS_BIN)) PREFIJO  \n"+
		" ,PTD.TD_BIN_BIN PREFIJO \n"+                                                        //23
		" , REPLACE(PTD.TD_POS_ENTRY_MOD,' ',NULL) MODO_POS    \n"+                           //24
		" , DECODE(PTD.TD_USG_TYP_ID,1,PTB.TB_CATEGORIA,PTB.TB_CAT_DR) CATEGORIA  \n"+        //25
		" , DECODE(PTD.TD_USG_TYP_ID,1,PTB.TB_COM_CVE_DESC_CREDITO,2,PTB.TB_COM_CVE_DESC_DEBITO) FACTOR_COM   \n"+    //26
		" , DECODE(PTD.TD_USG_TYP_ID,1,PTB.TB_COM_CVE_INT_CREDITO,2,PTB.TB_COM_CVE_INT_DEBITO) FACTOR_INT   \n"+      //27
		" , DECODE(PTD.TD_USG_TYP_ID,1,PTB.TB_COM_VALOR_INT_CREDITO,2,PTB.TB_COM_VALOR_INT_DEBITO) CUOTA_INT   \n"+   //28
		" , PPT.PT_MRCH_IVA_AMT IVA_COM   \n"+                                                //29
		" , TRIM(' ' FROM PTD.TD_CHECKING_ACCOUNT) REF_CHEQ  \n"+                             //30
		" , PTD.TD_RUTEO RUTEO   \n"+                                                         //31
		" , PTD.TD_TI_BRAND MARCA    \n"+                                                     //32
		" , PTD.TD_LIQUIDACION LIQ    \n"+                                                    //33
		" , PTD.TD_ACQ_LN RED_LOGICA_ADQ   \n"+                                               //34
		" , REPLACE(PTD.TD_ISS_LN,' ',NULL) RED_LOGICA_EMI  \n"+                              //35
		"-- , CUT.UT_TYP TIPO_TXS    \n"+
		" , PTD.TD_TC_GRP_ID TIPO_TXS    \n"+                                                 //36
		" , REPLACE(CPT.PT_TIM,'.',':' )HORA_CONSUMO   \n"+                                   //37
		" , PTD.TD_RSN_CD CODIGO_RAZON    \n"+                                                //38
		//" , PTD.TD_MEDIA_ACCESS_IND TERM_CAP  \n"+ 
		" , PTD.TD_POS_TERM_CAP TERM_CAP  \n"+                                                //39
		//" , TRIM(CPT.PT_RTLR_ID)||SUBSTR(TRIM(PTD.TD_TERM_NUM),LENGTH(TRIM(PTD.TD_TERM_NUM))-2,LENGTH(TRIM(PTD.TD_TERM_NUM))) TERMINAL  \n"+ //40
		" , CPT.PT_TRMID TERMINAL  \n"+//40
		"  , PTB.TB_VIG   \n"+                                                                //41
		" , PTB.TB_CAT_DR   " +                                                               //42
		" ,DECODE(PTB.TB_IVA,1,(SELECT PP_VALOR FROM PMADMIN.PRSA_PARAMETROS WHERE PP_ID_PARAMETRO = 'IVA_PARM'),NULL) IVA \n"+ //43
		//" Faltan el valor para el tipo 2 del iva \n"+
		" , PTD.TD_PROC_NBR PROCEDENCIA   \n"+                                                //44
		" ,null CODIGO_RESPUESTA_AUT "+                                                       //45
		//" ,DECODE (PTD.TD_PROC_NBR,6,TD_CAPT_TYP_BMXR,NULL) TIPO_CAPTURA \n"+
		" , CASE "+
		"   WHEN PTD.TD_PROC_NBR IN (1,22,24) \n"+
		"       AND PTD.TD_SRCE_NBR NOT IN (125)  \n"+
		"      THEN 'B' \n"+
		"   WHEN PTD.TD_PROC_NBR IN (23) \n"+
		"       AND (PTD.TD_SRCE_NBR IN (35) AND PTD.TD_POS_ENTRY_MOD IN ('01','90',' ')) \n"+
		"       OR PTD.TD_SRCE_NBR IN (214,218,270,275,1008,1010,1013,2110) \n"+
		"       THEN 'B' \n"+
		"   WHEN PTD.TD_PROC_NBR IN (23) \n"+
		"       AND (PTD.TD_SRCE_NBR IN (35) AND PTD.TD_POS_ENTRY_MOD NOT IN ('01','90',' ')) \n"+
		"       OR PTD.TD_SRCE_NBR NOT IN (214,218,270,275,1008,1010,1013,2110) \n"+
		"       THEN '0'  \n"+
		"   WHEN PTD.TD_SRCE_NBR IN (125) \n"+
		"       THEN NULL \n"+
		"   ELSE DECODE (PTD.TD_PROC_NBR,6,TD_CAPT_TYP_BMXR,NULL) \n"+
		" END TIPO_CAPTURA \n"+                                                                //46
		" ,PMADMIN.FN_RESPONSE_CODE(TRIM(CPT.PT_RESP_C))  CODIGO_RESPUESTA_ISO \n"+            //47
		"  ,PTD.TD_WH_SEQ  NUMERO \n"+                                                         //48
		"  ,(CASE \n" +        
		"            WHEN PTD.TD_PROC_NBR <> 22 THEN NULL \n" +
		"            WHEN PTD.TD_PROC_NBR = 22 THEN TRIM(SUBSTR(PTK2.TKC4,10,1))\n" +
		"       END)   IND_TER_ACT \n"+                                                        //49
		"  ,(CASE \n"+
		"        WHEN PTD.TD_PROC_NBR=6 THEN TD_POS_TERM_CAP " +
		"        WHEN PTD.TD_PROC_NBR <> 22 THEN NULL \n"+
		"        WHEN PTD.TD_PROC_NBR = 22 THEN TRIM(SUBSTR(PTK2.TKC4,11,1)) \n"+
		"   END) IND_TER_CAP\n"+                                                               //50
		" ,DECODE(PTD.TD_PROC_NBR,1,DECODE(PTD.TD_USG_TYP_ID,1,PTB.TB_COM_VALOR_DESC_CREDITO,2,PTB.TB_COM_VALOR_INT_DEBITO),DECODE(PTD.TD_USG_TYP_ID,1,PTB.TB_ELECTR_CR,2,PTB.TB_ELECTR_DR)) TARIFA_TASA  \n"+ //51   
		" ,SUBSTR(PTD.TD_ELEC_COMM_IND,1,1) ICE \n"+                                           //52
		", PB.PBIN_GLOBAL_LOCALE_S \n"+                                                        //53
		// CAMBIO FACTOR COMERCIO ANGTON 07 JUN 11
		" , PT_FACTOR_COMERCIO CUOTA_COM   \n"+  //54
		" , ppt.pt_MRCH_FEE_AMT   importe_comercio \n"+                                        //55
		" ,DECODE(SUBSTR(PTK2.TKB4,5,1),NULL,'B',0,'B','1','A','C') IND_EMV \n"+  //56
		" ,PPT.PT_IND_PAGOS_DIFERIDOS IND_DIF"+                                                //57
		// CAMBIO DE JULIO 13/05/2011 
		" ,SUBSTR(CPT.PT_ORIG_TXN_CD,1,2) TC \n"+                                              //58
		" ,PTD.TD_TYP TYP \n"+                                                                 //59
		// FIN CAMBIO JULIO 13/05/2011
		" ,CPT.PT_TXN_CRNCY_CD moneda \n"+                                                     //60
		" FROM     CORE.CZ_PRCD_TXN CPT \n";
		
		if(!params.initDate.contains("None")){
			query+="   INNER JOIN CORE.BS_PARTMDATA CBS    \n"+
			"                                     ON CPT.PARTITION_ID = CBS.PARTITION_ID    \n"+
			"                                   AND CBS.OBJECT_NAME = 'CORE.CZ_PRCD_TXN'    \n"+
			"                                    AND part_group_id='802'  \n"+
			"                                     AND CPT.PARTITION_ID = CBS.PARTITION_ID    \n"+
			"                                  AND trunc(START_TS,'MONTH')=TO_DATE('"+params.initDate+"' ,'dd-MM-yyyy')   \n";
		}

		query+="                           LEFT JOIN PMADMIN.PRSA_TXN_BDU PTB    \n"+
		"                                  ON CPT.PARTITION_ID = PTB.PARTITION_ID    \n"+
		"                                    AND CPT.PT_WH_GRP = PTB.TB_WH_GRP    \n"+
		"                                  AND CPT.PT_WH_SEQ = PTB.TB_WH_SEQ    \n"+
		"                         LEFT JOIN PMADMIN.PRSA_TXN_DATA PTD    \n"+
		"                                  ON CPT.PARTITION_ID = PTD.PARTITION_ID    \n"+
		"                                 AND CPT.PT_WH_GRP = PTD.TD_WH_GRP    \n"+
		"                                  AND CPT.PT_WH_SEQ = PTD.TD_WH_SEQ    \n"+
		"                         LEFT JOIN PMADMIN.PRSA_PRCD_TXN PPT    \n"+
		"                                      ON  CPT.PARTITION_ID= PPT.PARTITION_ID    \n"+
		"                                     AND  CPT.PT_WH_GRP= PPT.PT_WH_GRP   \n"+
		"                                     AND  CPT.PT_WH_SEQ= PPT.PT_WH_SEQ    \n"+
		"--                           LEFT JOIN CORE.CZ_UNPRCD_TXN CUT    \n"+
		"--                                     ON  CPT.PARTITION_ID= CUT.UT_PRCD_PART_ID    \n"+
		"--                                     AND CPT.PT_WH_GRP = CUT.UT_WH_GRP    \n"+
		"--                                     AND CPT.PT_WH_SEQ = CUT.UT_WH_SEQ \n"+
		"                          LEFT JOIN CORE.CZ_TXN_CLEAR CTC "+
		"                                                 ON CPT.PARTITION_ID=CTC.PARTITION_ID \n"+
		"                                                 AND CPT.PT_WH_GRP=CTC.TCLR_TH_GRP  \n"+
		"                                                 AND CPT.PT_WH_SEQ=CTC.TCLR_TH_SEQ  \n"+
		"				LEFT JOIN PMADMIN.PRSA_BIN PB   \n"+
		"						ON  PBIN_BIN = substr(CPT.PT_TI_ID,0,6) \n"+
		"				 LEFT JOIN PMADMIN.PRSA_ENTIDADES PEACQ ON PEACQ.NUMERO_PROSA=PTD.TD_PROSA_ACQ_ENTITY \n"+
		" 				 LEFT JOIN PMADMIN.PRSA_ENTIDADES PEEMI ON PEEMI.NUMERO_PROSA=PTD.TD_PROSA_ISS_ENTITY \n"+
		"				LEFT JOIN PMADMIN.PRSA_ARCHIVOS PA ON PTD.TD_SRCE_NBR= PA.NUMERO  \n"+
		"                 INNER JOIN CORE.CZ_T_BTCH CTB ON CTB.CTB_BTCH_SIN = PTD.TD_BTCH_SIN  \n"+
		"                 INNER JOIN CORE.CZ_T_FILE CTF ON CTF.CTF_FILE_SIN = CTB.CTB_FILE_SIN \n"+
		"                 INNER JOIN PMADMIN.SZ_TC_GRP STG ON STG.TCG_GRP_ID = PTD.TD_TC_GRP_ID \n"+
		"                 LEFT JOIN PMTW.POS_T_TKN2 PTK2 "+
		"                 ON PTK2.PARTITION_ID = PTD.PARTITION_ID "+
		"                 AND PTK2.POS_TRAN_ID_KEY = PTD.TD_WH_SEQ "+
		// CAMBIO GERMAN TXN
		" INNER JOIN PMADMIN.PRSA_TIPOS_TRANSACCION PTT "+
		" ON PTT.NUMERO = PTD.TD_TXN_TYP "+
		// FIN CAMBIO GERMAN TXN
		"	WHERE \n"+	
		"    PTD.TD_TC_GRP_ID NOT IN (0,111,112,115,116,120,281,321,322) "+
		"    AND PEACQ.TIE_NUMERO=9 ";
		//"    AND (PEACQ.NUMERO_PROSA IN(1001,1002,1003,1004,1005,1006,1007)) \n";
		//"    AND cpt.PT_ORIG_CRNCY_CD=840 ";// CAMBIO POR EMMA YA QUE CAYO UNA TRANSACCION DE DOLARES CON UN 484
	
		if (!params.numeroFuente.equals("None")){
			query+=" AND PTA.ARCH_NUMERO IN ("+params.numeroFuente+") /* PARAMETRO */ \n";
		}

		if(!params.tipoTransaccion.equals("None")){
			query+=" AND TD_TC_GRP_ID in( "+params.tipoTransaccion+") ";
		}
		
		
		if(params.rol.equals("banco")){
			if(params.bancoRecep.equals("None")&&params.bancoEmi.equals("None")){
				query+="and (PEEMI.entidad_padre in ("+params.numerosProsa+") or PEACQ.entidad_padre in("+params.numerosProsa+"))";
			}else
				if(!params.bancoRecep.equals("None")){
					query+=" AND PEACQ.ENTIDAD_PADRE in("+params.bancoRecep+")";
			}
			if(!params.bancoEmi.equals("None")){
				query+=" AND PEEMI.ENTIDAD_PADRE in("+params.bancoEmi+") ";
			}
		}else{
			if(!params.bancoRecep.equals("None")){
				query+=" AND PEACQ.ENTIDAD_PADRE in("+params.bancoRecep+")";
			}
			if(!params.bancoEmi.equals("None")){
				query+=" AND PEEMI.ENTIDAD_PADRE in("+params.bancoEmi+") ";
			}
		}

		if(!params.numeroCuenta.equals("")){
			query+=" AND CPT.PT_TI_ID = '"+params.numeroCuenta+"' ";
		}
		if(!params.numeroAutorizacion.equals("")){
			query+="  AND PT_AUTH_CD = '"+params.numeroAutorizacion+"'  ";
		}
		if(!params.numeroRef.equals("")){
			query+=" AND CTC.TCLR_ACQ_REF_NUM ='"+params.numeroRef+"' ";
		}
		if(!params.numeroComercio.equals("")){
			query+=" AND TO_NUMBER(PTB.TB_AFFL) in ("+params.numeroComercio+") ";
		}
		if(!params.nombreComercio.equals("")){
			query+=" AND TRIM(PTB.TB_COM_NAME) ='"+params.nombreComercio+"' ";
		}
		if(!params.importe.equals("")){
			query+=" AND  CPT.PT_REQ_AMT ="+params.importe+" ";
		}
			
		return query;
	}
	


	/**
	 * Metodo que genera query para reporte SICMOFM100
	 * @param params
	 * @return 
	 */
	public static String SICMOFM100(TableParams params){
		String query = "";
		
		query=
			" SELECT /*+ INDEX(PTLV NDX_PRSA_LOC_VIS_CTA) */PTLV.ARCH_NUMERO FUENTE , \n"+
			"   PA.DESCRIPCION , \n"+
			"   PTLV.NOMBRE_ARCHIVO , \n"+
			"   PTLV.FECHA_CONSUMO_TRANSAC F_CONSUMO , \n"+
			"   PTLV.FECHA_PROCESO_TRANSAC F_PROCESO , \n"+
			"   PTLV.ENT_NUMERO_PROSA_ADQ ENT_ADQ , \n"+
			"   VBA.DESCRIPCION ADQ_DESCRIPCION , \n"+
			"   VBA.BU_TX_ADQ BU_ADQ , \n"+
			"   PTLV.ENT_NUMERO_PROSA_EMI ENT_EMI , \n"+
			"   PEE.DESCRIPCION EMI_DESCRIPCION , \n"+
			"   (SELECT DISTINCT DECODE(VBE.BU_TX_PARENT,641,522,VBE.BU_TX_PARENT) \n"+
			"   FROM PMADMIN.VW_BUS_EMI VBE \n"+
			"   WHERE VBE.NUMERO_PROSA = PTLV.ENT_NUMERO_PROSA_EMI \n"+
			"   ) BU_EMI , \n"+
			"   PTLV.NUMERO_AUTORIZACION NO_AUTORIZACION , \n"+
			"   PTLV.NUMERO_REFERENCIA NO_REFERENCIA , \n"+
			"   TO_CHAR(PTLV.CUENTA) CUENTA , \n"+
			"   PTLV.TTR_NUMERO CLAVE_TXS , \n"+
			"   PTT.DESCRIPCION DESCRIPCION_CLAVE_TXS , \n"+
			"   PTLV.NUMERO_COMERCIO NO_COMERCIO , \n"+
			"   PTLV.NOMBRE_COMERCIO , \n"+
			"   PTLV.BDU_SIC_CVE GIRO , \n"+
			"   TO_CHAR(PTLV.IMPORTE_TOTAL_TRANSAC,'999,999,999.99') IMP_TRANS , \n"+
			"   PTLV.IMPORTE_CUOTA_INTERCAMBIO IMP_INTERCAMBIO , \n"+
			"   PTLV.IMPORTE_IVA_INTERCAMBIO IVA_INT , \n"+
			"   PTLV.PREF_NUMERO PREFIJO , \n"+
			"   PTLV.MODO_ENTRADA_POS MODO_POS, \n"+
			"   NULL CATEGORIA, \n"+ //PTLV.BDU_COM_CAT_CRE CATEGORIA 
			"   NULL FACTOR_COM, \n"+ //PTLV.CLAVE_FACTOR_COMERCIO FACTOR_COM 
			"   PTLV.CLAVE_FACTOR_INTERCAMBIO FACTOR_INT, \n"+
			"   NULL CUOTA_INT, \n"+ //PTLV.CUOTA_INTERCAMBIO CUOTA_INT
			"   NULL IVA_COM, \n"+ //PTLV.IMPORTE_IVA_COMERCIO IVA_COM 
			"   PTLV.CUENTA_CHEQUES REF_CHEQ, \n"+
			"   NULL RUTEO, \n"+ //PTLV.RUTEO 
			"   PTLV.MAPR_NUMERO MARCA, \n"+
			"   NULL LIQ, \n "+ //PTLV.TLI_NUMERO LIQ
			"   NULL RED_LOGICA_ADQ, \n"+ //PTLV.RED_LOGICA RED_LOGICA_ADQ 
			"   NULL RED_LOGICA_EMI, \n"+ //PTLV.RED_LOGICA_EMI
			"   PTLV.TTR_NUMERO TIPO_TXS , \n"+
			"   PTLV.FECHA_CONSUMO_TRANSAC HORA_CONSUMO, \n"+
			"   PTLV.CODIGO_RAZON, \n"+
			"   NULL TERM_CAP, \n"+ //PTLV.IND_TER_CAP TERM_CAP 
			"   PTLV.TERM_ID TERMINAL, \n"+
			"   NULL TB_VIG, \n"+ //PTLV.BDU_COM_VIG TB_VIG 
			"   NULL TB_CAT_DR, \n"+ //PTLV.BDU_COM_CAT_CRE TB_CAT_DR 
			"   (SELECT PP_VALOR \n"+
			"   FROM PMADMIN.PRSA_PARAMETROS \n"+
			"   WHERE PP_ID_PARAMETRO = 'IVA_PARM' \n"+
			"   ) IVA , \n"+
			"   PTLV.PROC_NUMERO PROCEDENCIA , \n"+
			"   PTLV.CODIGO_RESPUESTA_AUT , \n"+
			"   PTLV.TIPO_CAPTURA, \n"+
			"   NULL CODIGO_RESPUESTA_ISO, \n"+ //PTLV.CODIGO_RESPUESTA_ISO 
			"   PTLV.LV_WH_SEQ NUMERO, \n"+
			"   NULL IND_TER_ACT, \n"+ //PTLV.IND_TER_ACT 
			"   NULL IND_TER_CAP, \n"+ //PTLV.IND_TER_CAP 
			"   PTLV.IMPORTE_CUOTA_INTERCAMBIO TARIFA_TASA , \n"+
			"   PTLV.INDICADOR_COM_ELEC ICE , \n"+
			"   PTLV.ES_NACIONAL PBIN_GLOBAL_LOCALE_S , \n"+
			"   PTLV.IMPORTE_CUOTA_COMERCIO IMPORTE_COMERCIO , \n"+
			"   PTLV.CUOTA_COMERCIO CUOTA_COM , \n"+
			"   PTLV.TIPO_CAPTURA IND_EMV , \n"+
			"   NULL IND_DIF, \n"+
			"   NULL TC, \n"+ //PTLV.TC 
			"   NULL TYP, \n"+ //PTLV.TYP 
			"   PTLV.TIER_CODIGO_MONEDA MONEDA \n"+
			" FROM PMADMIN.PRSA_TXN_LOCALES_VISA PTLV \n"+
			" INNER JOIN PMADMIN.VW_BUS_ACQ VBA \n"+
			" ON VBA.NUMERO_PROSA = PTLV.ENT_NUMERO_PROSA_ADQ \n"+
			" INNER JOIN PMADMIN.PRSA_ENTIDADES PEE \n"+
			" ON PEE.NUMERO_PROSA = PTLV.ENT_NUMERO_PROSA_EMI \n"+
			" INNER JOIN PMADMIN.PRSA_TIPOS_TRANSACCION PTT \n"+
			" ON PTT.NUMERO = PTLV.TTR_NUMERO \n"+
			" INNER JOIN PMADMIN.PRSA_ARCHIVOS PA \n"+
			" ON PA.NUMERO = PTLV.ARCH_NUMERO \n";
		
		if(!params.tipoTransaccion.equals("None"))
				{
					query+=" INNER JOIN PMADMIN.PRSA_TIPOS_SAC PTS \n"+
					" ON PTS.PTS_TIPO_SAC = PTA.TTR_NUMERO \n";
				}
			
			query+=
			" WHERE PTLV.TTR_NUMERO NOT IN (10,11,51,52,53,54) \n";
		
		if (!params.session.getAttribute("fechaXML").toString().equals("01/01/2000")){
			query+=" AND PTLV.PARTITION_ID >= (SELECT PMADMIN.FN_PARTITION_ID(TO_DATE('"+params.session.getAttribute("fechaXML").toString()+"','DD/MM/YYYY')) FROM DUAL) \n";
		}
		query+=" AND PTLV.PARTITION_ID >= (SELECT PMADMIN.FN_PARTITION_ID(TO_DATE (TO_CHAR(SYSDATE-7,'DD-MM-YYYY'),'DD-MM-YYYY')) FROM DUAL) \n";
		
		if(!params.tipoTransaccion.equals("None")){
			query+=" AND PTS.TIPO_PMT IN ( "+params.tipoTransaccion+") /* PARAMETRO */ \n";
		}
		
		
		if(params.rol.equals("banco")){
			if(params.bancoRecep.equals("None")&&params.bancoEmi.equals("None")){
				query+=" AND (VBA.ENTIDAD_PADRE IN ("+params.numerosProsa+") /* PARAMETRO */ \nOR PEE.ENTIDAD_PADRE IN ("+params.numerosProsa+")) /* PARAMETRO */ \n";
			}else{
				query+=" AND VBA.ENTIDAD_PADRE IN ("+params.bancoRecep+") /* PARAMETRO */ \n";
			}
			
			if(!params.bancoEmi.equals("None")){
				query+=" AND PEE.ENTIDAD_PADRE IN ("+params.bancoEmi+") /* PARAMETRO */ \n";
			}
		}else{
			if(!params.bancoRecep.equals("None")){
				query+=" AND VBA.ENTIDAD_PADRE IN ("+params.bancoRecep+") /* PARAMETRO */ \n";
			}
			if(!params.bancoEmi.equals("None")){
				query+=" AND PEE.ENTIDAD_PADRE IN ("+params.bancoEmi+") /* PARAMETRO */ \n";
			}
		}
		
		if(!params.numeroCuenta.equals("")){
			query+=" AND PTLV.CUENTA = '"+params.numeroCuenta+"' /* PARAMETRO */ \n";
		}
		
		if(!params.numeroAutorizacion.equals("")){
			query+=" AND PTLV.NUMERO_AUTORIZACION = '"+params.numeroAutorizacion+"' /* PARAMETRO */ \n";
		}
		
		if(!params.numeroRef.equals("")){
			query+=" AND PTLV.NUMERO_REFERENCIA = '"+params.numeroRef+"' /* PARAMETRO */ \n";
		}
		
		if(!params.numeroComercio.equals("")){
			query+=" AND PTLV.NUMERO_COMERCIO IN ("+params.numeroComercio+") /* PARAMETRO */ \n";
		}
		
		if(!params.nombreComercio.equals("")){
			query+=" AND PTLV.NOMBRE_COMERCIO = '"+params.nombreComercio+"' /* PARAMETRO */ \n";
		}
		
		if(!params.importe.equals("")){
			query+=" AND PTLV.IMPORTE_TOTAL_TRANSAC = "+params.importe+" /* PARAMETRO */ \n";
		}
	
		return query;
	}
}


