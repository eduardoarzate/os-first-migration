/*###############################################################################
# Nombre del Programa :  menu.js                                                #
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

// **** Variables ****
var emi=null;
var adq=null;
var inte=null;
var rol=null;
var nivel=0;
function at_display(x)
{
  var win = window.open();
  for (var i in x) win.document.write(i+' = '+x[i]+'<br>');  
}

// ***** DropDown Control ******************************************************

var at_timeout = 100;

// ***** Show Aux *****

function at_show_aux(parent, child)
{
  var p = document.getElementById(parent);
  var c = document.getElementById(child);
  p.className        = "active";
   if (c.offsetWidth <= 0)
  {
    c.style.position   = "absolute";
    c.style.visibility = "visible";
    c.style.display    = "block";
  }
  
  var direction = undefined;
  if (p.parentNode && p.parentNode["at_position"] == "x")
    direction = p.parentNode["at_direction"];

  var top   = (c["at_position"] == "y") ?  p.offsetHeight : 0;
  var left1 = (c["at_position"] == "x") ?  p.offsetWidth  : 0;
  var left2 = (c["at_position"] == "x") ? -c.offsetWidth  : 0;
  var left3 = (c["at_position"] == "x") ?  p.offsetWidth  : 0;
 
  for (; p; p = p.offsetParent)
  {
    if (p.style.position != 'absolute')
    {
      left1 += p.offsetLeft;
      left2 += p.offsetLeft;
      top   += p.offsetTop;
    }
    left3 += p.offsetLeft;
  }

  if (direction)
  {
    left = (direction == 'right') ? left1 : left2;
    c['at_direction'] = direction;
  }
  else
  {
    left = (left3+c.offsetWidth < document.body.offsetWidth) ? left1 : left2;
    c['at_direction'] = (left3+c.offsetWidth < document.body.offsetWidth) ? 'right' : 'left';
  }

  c.style.position   = "absolute";
  c.style.visibility = "visible";
  c.style.display    = "block";
  c.style.top        = top +'px';
  c.style.left       = left+'px';  	
  var f= document.getElementsByTagName("iframe");
  if(f!=null){
	  for(var i=0;i<f.length;i++){
	  if(f[i].parentNode==c)
	  	if(c.style.width!='')
	  		f[i].style.width=parseInt(c.style.width)+5;
	  	else
	  		f[i].style.width=5;
	  }
 }
}

// ***** Hide Aux *****

function at_hide_aux(parent, child)
{
  document.getElementById(parent).className        = "parent";
  document.getElementById(child ).style.visibility = "hidden";
  document.getElementById(child ).style.display    = "block";
 
}

// ***** Show *****

function at_show(e)
{
  nivel+=1;
  var p = document.getElementById(this["at_parent"]);
  var c = document.getElementById(this["at_child" ]);
  at_show_aux(p.id, c.id);
  clearTimeout(c["at_timeout"]); 
}

// ***** Hide *****

function at_hide()
{
  nivel-=1;
  var c = document.getElementById(this["at_child"]);

  c["at_timeout"] = setTimeout("at_hide_aux('"+this["at_parent"]+"', '"+this["at_child" ]+"')", at_timeout);
}

// ***** Attach *****

function at_attach(parent, child, position)
{
  p = document.getElementById(parent);
  c = document.getElementById(child);

  p["at_child"]    = c.id;
  c["at_child"]    = c.id;
  p["at_parent"]   = p.id;
  c["at_parent"]   = p.id;
  c["at_position"] = position;

  p.onmouseover = at_show;
  p.onmouseout  = at_hide;
  c.onmouseover = at_show;
  c.onmouseout  = at_hide;
}

// ***** DropDown Menu *********************************************************

// ***** Build Aux *****

function dhtmlmenu_build_aux(parent, child, position, image, width)
{	
	document.write('<div class="vert_menu" id="'+parent+'_child" style="width:'+width+'"> <iframe></iframe>');
	var n = 0;
	    		
  for (var i in child)
  {
  	for (var j in child[i])
  	{
  		for(var k in child[i][j])
  		{
    		if (i == '-')
    		{
      			document.getElementById(parent).href = child[i][j][k];
      			continue;
    		}

    		if (typeof child[i][j][k] == "object")
    		{
      			document.write('<img src="'+image+'" class="icon_menu" />');
      			document.write('<a id="'+parent+'_'+n+'" href="" style="background-image: url(pics/icons/expandMenu.gif);background-position: right;background-repeat:no-repeat;width:'+width+';">'+i+''+'</a>');
      			dhtmlmenu_build_aux(parent+'_'+n, child[i][j][k], "x",j,k);
    		}
    		else 
    		{	
	    		if((k == 'Emisor' && rol == 'banco' && emi == 'true'))
	    		{
	    			document.write('<img src="'+image+'" class="icon_menu" />');
	    			document.write('<a id="'+parent+'_'+n+'" href="'+child[i][j][k]+'" style="width:'+width+'">'+i+'</a>');
	    		}
	    		    	
	    		else if(k == 'Adquirente' && rol == 'banco' && adq == 'true')
	    		{
	    			document.write('<img src="'+image+'" class="icon_menu" />');
	    			document.write('<a id="'+parent+'_'+n+'" href="'+child[i][j][k]+'" style="width:'+width+'">'+i+'</a>');
	    		}
	    		
	    		else if(k == 'Interred' && rol == 'banco' && inte == 'true')
	    		{
	    			document.write('<img src="'+image+'" class="icon_menu" />');
	    			document.write('<a id="'+parent+'_'+n+'" href="'+child[i][j][k]+'" style="width:'+width+'">'+i+'</a>');
	    		}

	    		else if(k == 'Prosa' && (rol == 'administrador' || rol == 'operador'))
	    		{
	    			document.write('<img src="'+image+'" class="icon_menu" />');
	    			document.write('<a id="'+parent+'_'+n+'" href="'+child[i][j][k]+'" style="width:'+width+'">'+i+'</a>');
	    		}
	    		else if((k == '' || emi == 'null' || adq == 'null' || inte == 'null') && (rol == 'administrador' || rol == 'operador' || rol == 'banco'))
	    		{
	    			document.write('<img src="'+image+'" class="icon_menu" />');
	    			document.write('<a id="'+parent+'_'+n+'" href="'+child[i][j][k]+'" style="width:'+width+'">'+i+'</a>');
	    		}
	    		
	    		else
	    		{
	    		}  		
    		}
    		n+=1;
    	}
    }
  }
  document.write('</div>'); 
  at_attach(parent, parent+"_child", position);
}

// ***** Build *****

function dhtmlmenu_build(menu, emi, adq, inte, rol)
{
  this.emi = emi;
  this.adq = adq;
  this.inte = inte;
  this.rol = rol;
 
  for (var i in menu) 
  {
  	for(var j in menu[i])
  	{
  		for(var k in menu[i][j])
  		{
   			dhtmlmenu_build_aux(i, menu[i][j][k], "x", j, k);
   		}		
  	}
  }
}
