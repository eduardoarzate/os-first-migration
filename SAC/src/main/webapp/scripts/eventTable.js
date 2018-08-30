/*###############################################################################
# Nombre del Programa :  eventTable.js                                          #
# Autor               :  JOAQUIN MOJICA Q.                                      #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-08-299-04                 	   FECHA:15/10/2008     #
# Descripcion General :										                    #
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :						                                    #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :														    #
#################################################################################
#								MODIFICACIONES                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-08-2253-12                Fecha: 13/02/2013          #
# Modificación        :  Adicionar indicadores ABM a Reporte de log certificado #
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-08-2253-12                Fecha: 08/04/2013          #
# Modificación        :  Adicionar indicadores ABM a Reporte de log certificado #
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-04-2207-13                Fecha:02/12/2013           #
# Modificación        :  Actualización de LOG CERTIFICADO con Indicadores ABM a #
#                        detalle                                                #
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                  #
# Autor               :                                                         #
# Compania            :                                                         #
# Proyecto/Procliente :                              Fecha:                     #
# Modificación        :                                                         #
#-----------------------------------------------------------------------------  #
# Numero de Parametros: 0                                                       #
###############################################################################*/

var row = null;

function viewDatas(numRow,reporte)
{
	//alert(reporte)
	if(reporte==100){
	//document.location='ReloadServlet?action=detailsSICMOF0100&numFil='+numRow;
		cambioPaginaReload('ReloadServlet?action=detailsSICMOF0100&numFil='+numRow,'rightPanel');
	}else if(reporte==120){
	//document.location='ReloadServlet?action=detailsSICMOF0120&numFil='+numRow;
		cambioPaginaReload('ReloadServlet?action=detailsSICMOF0120&numFil='+numRow,'rightPanel');
	}else if(reporte==1000){
	//document.location='ReloadServlet?action=detailsSICMOF0100H&numFil='+numRow;
		cambioPaginaReload('ReloadServlet?action=detailsSICMOF0100H&numFil='+numRow,'rightPanel');
	}
	else if(reporte==101){//B100
		//document.location='ReloadServlet?action=detailsSICMOFB100&numFil='+numRow;
		cambioPaginaReload('ReloadServlet?action=detailsSICMOFB100&numFil='+numRow,'rightPanel');
    }else if(reporte ==121){//B120
    	//document.location='ReloadServlet?action=detailsSICMOFB120&numFil='+numRow;
    	cambioPaginaReload('ReloadServlet?action=detailsSICMOFB120&numFil='+numRow,'rightPanel');
    }	
	/********** Inicio Modificacion WELLCOM N-08-2253-12  **********/
		else if(reporte ==205){//205
    	cambioPaginaReload('ReloadServlet?action=detailsSICMOR0205&numFil='+numRow,'rightPanel');
		//cambioPaginaReload('ControllerServlet?action=Sicmor0205Details&numFil='+numRow,'rightPanel');
    }
	/********** Fin    Modificacion WELLCOM N-08-2253-12  **********/
	/********** Inicio Modificacion WELLCOM N-08-2253-12  **********/
	else if(reporte ==2050){//205
    	cambioPaginaReload('ReloadServlet?action=detailsSICMOR0205H&numFil='+numRow,'rightPanel');
    }
	/********** Inicio Modificacion WELLCOM N-08-2253-12  **********/
/* Inicio cambio WELLCOM N-04-2207-13 29/11/2013 */
	else if(reporte ==10){//PTLF
    	cambioPaginaReload('ReloadServlet?action=detailsSICMORPTLF&numFil='+numRow,'rightPanel');
    }
/* Fin cambio WELLCOM N-04-2207-13 29/11/2013 */
}

function selected(numRow,tabla)
{
	row  = document.getElementById(tabla).getElementsByTagName('tr');
	row[numRow].className='selectedRow';	
}


function normal(numRow,tabla)
{
	row  = document.getElementById(tabla).getElementsByTagName('tr');
	row[numRow].className='normalRow';
}