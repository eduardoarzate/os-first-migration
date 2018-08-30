/*###############################################################################
# Nombre del Programa :  resize.js                                              #
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
# Autor               :                                                         #
# Compania            :                                                         #
# Proyecto/Procliente :                              Fecha:                     #
# Modificación        :                                                         #
#-----------------------------------------------------------------------------  #
# Numero de Parametros: 0                                                       #
###############################################################################*/
var ieVer=/*@cc_on function(){ switch(@_jscript_version){ case 1.0:return 3; case 3.0:return 4; case 5.0:return 5; case 5.1:return 5; case 5.5:return 5.5; case 5.6:return 6; case 5.7:return 7; }}()||@*/0;
var myWidth = 0, myHeight = 0;
var left = null;
var right = null;
var styleLeft = null;
var styleRight = null;

function resize() 
{
	if(ieVer == 5 || ieVer == 6 )
	{
		//myWidth = document.body.clientWidth;
    	myHeight = document.body.clientHeight-50;
	}
	
	else if(ieVer == 7)
	{
		//myWidth = document.body.clientWidth;
    	myHeight = document.body.clientHeight - 50;
    }
    
    else
    {
		//myWidth = window.innerWidth;
    	myHeight = window.innerHeight - 30;
  	}

  style(myHeight);
}

function resizeReports() 
{
	if(ieVer == 5 || ieVer == 6 )
	{
		//myWidth = document.documentElement.clientWidth;
    	myHeight = document.documentElement.clientHeight - 50;
	}
	
	else if(ieVer == 7)
	{
		//myWidth = document.documentElement.clientWidth;
    	myHeight = document.documentElement.clientHeight - 75;
    }
    
    else
    {
		//myWidth = window.innerWidth;
    	myHeight = window.innerHeight - 30;
  	}

  style(myHeight);
}

function style(height)
{
	left = document.getElementById("leftColumns");
	right = document.getElementById("rightColumns");
	styleLeft = "border-right: 1px solid #452FFF;padding: 10px; height:"+height+"px;";
	left.setAttribute('style',styleLeft);
	left.style.padding = "10px;";
	left.style.height = height+"px";
	left.style.borderRight = "1px solid #452FFF";
	
	styleRight = "padding: 20px; height:"+height+"px;";
	right.setAttribute('style',styleRight);
	right.style.padding = "20px";
	right.style.height = height;	
}
