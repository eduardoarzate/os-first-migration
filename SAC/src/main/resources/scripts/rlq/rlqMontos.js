/*
#################################################################################
# Nombre del Programa :  rlqMontos.js                                           #
# Autor               :  Gerardo G. Burguete                                    #
# Compania            :  Axia, S.A. de C.V.                                     #
# Proyecto/Procliente :  P-53-2933-14                 	   FECHA:04/06/2015     #
# Descripcion General :	 Re-cálculo de compensación y administración de umbrales#
#################################################################################
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :						                                    #
# Dias de ejecucion   :														    #
#################################################################################
#								MODIFICACIONES                                  #
# Autor               :                                                         #
# Compania            :                                                         #
# Proyecto/Procliente :                              Fecha:                     #
# Modificación        :                                                         #
#-----------------------------------------------------------------------------  #
# Numero de Parametros: 0                                                       #
#################################################################################
*/
	var span = null;
	var obj  = null;
  
    function flt() {
      Alert("Si furula");
      if (document.getElementById("listado").style.display == "none")
        document.getElementById("listado").style.display = 'block';
      else
        document.getElementById("listado").style.display = 'none';
    }	
	
    function validaBco0(num) {

        try {

      	  if(    document.getElementById("ent" + num).value == "None" 
              || document.getElementById("ent" + num).value == null
            ) {              
            span = document.getElementById("txtMsg");
            span.innerHTML="Debe seleccionar una entidad";
            span.style.display = 'inline';
            return false;

      	  } else if ( document.getElementById("desc" + num).value == "" || document.getElementById("desc" + num).value == null || document.getElementById("desc" + num).value.length >= 40) {
            span = document.getElementById("txtMsg");
            span.innerHTML="El campo Descipci&oacute;n no puede estar vac&iacute;o";
            span.style.display = 'inline';           
            return false;

      	  } else if ( document.getElementById("porcP" + num).value == "" || document.getElementById("porcP" + num).value == null) {
            span = document.getElementById("txtMsg");
            span.innerHTML="El campo Porcentaje Prosa no puede estar vac&iacute;o";
            span.style.display = 'inline';            
            return false;          

          } else if ( document.getElementById("porcP" + num).value.length > 0 ) {
          	
            for(i=0;i<document.getElementById("porcP" + num).value.length; i++ ) {              
              if ( "0123456789.".indexOf(document.getElementById("porcP" + num).value.substring(i,i+1)) == -1) {
                span = document.getElementById("txtMsg");
                span.innerHTML="El campo Porcentaje Prosa debe ser n&uacute;merico";
                span.style.display = 'inline';
                return false;                            
              }                            
            }
          }        

          if ( document.getElementById("porcB" + num).value == "" || document.getElementById("porcB" + num).value == null) {
            span = document.getElementById("txtMsg");
            span.innerHTML="El campo Porcentaje Banco no puede estar vac&iacute;o";
            span.style.display = 'inline';            
            return false;          

          } else if ( document.getElementById("porcB" + num).value.length > 0 ) {
              
            for(i=0;i<document.getElementById("porcB" + num).value.length; i++ ) {              
              if ( "0123456789.".indexOf(document.getElementById("porcB" + num).value.substring(i,i+1)) == -1) {
                span = document.getElementById("txtMsg");
                span.innerHTML="El campo Porcentaje Banco debe ser n&uacute;merico";
                span.style.display = 'inline';
                return false;                            
              } else
                return true;
            }          
      	  } else {
            return true;
          }
          
        } catch(e) {
          alert(e);
          return false;
        }
    }

    
    function valida () {

        var val1 = false;
        var val2 = false;
        var val3 = false;
        var val4 = false;
        var val5 = false;
        var val6 = false;
        var val7 = false;
        var val8 = false;      
        var val9 = false;
        var val10 = false;      

        var chk1 = false;
        var chk2 = false;
        var chk3 = false;
        var chk4 = false;
        var chk5 = false;
        var chk6 = false;
        var chk7 = false;
        var chk8 = false;      
        var chk9 = false;
        var chk10 = false;      

        chk1 = document.frmTOCHeader.act1.checked;
        chk2 = document.frmTOCHeader.act2.checked;
        chk3 = document.frmTOCHeader.act3.checked;
        chk4 = document.frmTOCHeader.act4.checked;      
        chk5 = document.frmTOCHeader.act5.checked;
        chk6 = document.frmTOCHeader.act6.checked;
        chk7 = document.frmTOCHeader.act7.checked;
        chk8 = document.frmTOCHeader.act8.checked;      
        chk9 = document.frmTOCHeader.act9.checked;
        chk10 = document.frmTOCHeader.act10.checked;      

     
        if(chk1)      
            val1 = validaBco0(1);
        if(chk2)      
            val2 = validaBco0(2);
        if(chk3)      
            val3 = validaBco0(3);
        if(chk4)      
            val4 = validaBco0(4);      
        if(chk5)      
    	    val5 = validaBco0(5);
        if(chk6)      
            val6 = validaBco0(6);
        if(chk7)      
            val7 = validaBco0(7);
        if(chk8)      
            val8 = validaBco0(8);      
        if(chk9)      
            val9 = validaBco0(9);
        if(chk10)      
            val10 = validaBco0(10);        

        //alert(chk2);
        //alert(val2);
      
        if (!val1 && chk1) {
            span = document.getElementById("txtNum1");
            span.style.display = 'inline';
            return false;
        }
        if (!val2 && chk2) {
            span = document.getElementById("txtNum2");
            span.style.display = 'inline';
            return false;
        }      
        if (!val3 && chk3) {
            span = document.getElementById("txtNum3");
            span.style.display = 'inline';
            return false;
        }      
        if (!val4 && chk4) {
            span = document.getElementById("txtNum4");
            span.style.display = 'inline';
            return false;
        }      
        if (!val5 && chk5) {
            span = document.getElementById("txtNum5");
            span.style.display = 'inline';
            return false;
        }
        if (!val6 && chk6) {
            span = document.getElementById("txtNum6");
            span.style.display = 'inline';
            return false;
        }      
        if (!val7 && chk7) {
            span = document.getElementById("txtNum7");
            span.style.display = 'inline';
            return false;
        }      
        if (!val8 && chk8) {
            span = document.getElementById("txtNum8");
            span.style.display = 'inline';
            return false;
        }
        if (!val9 && chk9) {
            span = document.getElementById("txtNum9");
            span.style.display = 'inline';
            return false;
        }      
        if (!val10 && chk10) {
            span = document.getElementById("txtNum10");
            span.style.display = 'inline';
            return false;
        }   
        
        
        if (!(chk1 || chk2 || chk3 || chk4 || chk5 || chk6 || chk7 || chk8 || chk9 || chk10)) {
            span = document.getElementById("txtMsg");
            span.innerHTML="Hay que seleccionar al menos un Banco, marque la casilla Actualizar...!";
            span.style.display = 'inline';
            return false;
        } else {
            return ((val1 && chk1) || (val2 && chk2) || (val3 && chk3) || (val4 && chk4) || (val5 && chk5) || (val6 && chk6) || (val7 && chk7) || (val8 && chk8) || (val9 && chk9) || (val10 && chk10))
        }      
        
    }
    