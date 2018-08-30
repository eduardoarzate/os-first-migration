<%
/*###############################################################################
# Nombre del Programa :  menu.jsp		                                        #
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
# Autor               : ERIKA A. MOJICA                                         #
# Compania            : WELLCOM SA DE CV                                        #
# Proyecto/Procliente : P-02-1202-09                 Fecha:  08/02/2010         #
# Modificación        : AUTOMATIZACION DE PREPAGO                               #
#-----------------------------------------------------------------------------  #
# Autor               :                                                         #
# Compania            :                                                         #
# Proyecto/Procliente :                              Fecha:                     #
# Modificación        :                                                         #
#-----------------------------------------------------------------------------  #
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>

<%
    response.sendRedirect("login.jsp");
    if(!ga.AccessGranted(session, "grantAccess"))
    {
        response.sendRedirect("login.jsp");
    }
    String emi  = (String) session.getAttribute("emisor");
    String adq  = (String) session.getAttribute("adquirente");
	String inte = (String) session.getAttribute("interred");
	String rol  = (String) session.getAttribute("role");
	System.out.println("Permisos: " + " emisor: "+ emi + " adquirente: " + adq + " interred: " + inte);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-cache"/>
<script type="text/javascript" src="scripts/resize.js"></script>
<script type="text/javascript" src="scripts/menu.js"></script>
<script type="text/javascript" src="scripts/cleanNavigator.js"></script>
<link href="css/menu.css" rel="stylesheet" type="text/css"></link>
</head>
<body style="font-family: 'Times New Roman'; font-size: 13px; color: #A0A0A0;">
<br/><br/>	
<div class="sample2">

<div class="menu">
<img src="pics/icons/report.gif" class="icon_menu" /><a id="report" href="#" style="width:180px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Reportes</a>
<br/><br/>
<% if( rol.equals("administrador")||rol.equals("operador")) {%>
	<img src="pics/icons/tools.gif" class="icon_menu"/><a id="tools" href="#"  style="width:180px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Herramientas</a>
	<br/><br/>
<%} %>

<img src="pics/icons/help.png" class="icon_menu"/><a id="help" href="#"  style="width:180px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ayuda</a>
<br/><br/>
<img src="pics/icons/sign_in.png" class="icon_menu"/><a id="leave" href="ControllerServlet?action=login" style="width:180px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Salir</a>
<br clear="both" />
</div>

<script type="text/javascript">
//Arreglos de objetos notacion json 

var submenu_Prosa      = {"-"                           : "",
						 "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICMIR0290 Reporte Integral de Transacciones Recibidas en Prosa" : {"pics/icons/report.gif" : {"Adquirente" : "ControllerServlet?action=SICMIR0290"}},
						 "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICMIR0300 Reporte Integral de Transacciones Emisor" : {"pics/icons/report.gif" : {"Emisor" : "ControllerServlet?action=SICMIR0300"}},
						  "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICMIR0420 Reporte Resumen de Adquirente" : {"pics/icons/report.gif" : {"Adquirente" : "ControllerServlet?action=SICMIR0420"}}};

var submenu_Pos ={"-"                           : "",
								"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICMIR0450 Reporte Consolidado de Transacciones por Banco" : {"pics/icons/report.gif" : {"Adquirente" : "ControllerServlet?action=SICMIR0450"}}};													

var submenuInter       = { "-"                          : "",
			    		   "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Prosa" : {"pics/icons/report.gif" : {"350px" :submenu_Prosa}},
			    		   "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Pos" : {"pics/icons/report.gif" : {"350px" :submenu_Pos}} };
													 
var submenu_InteRInter = { "-"                          : "",
						   "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Reportes de Intercambio" : {"pics/icons/report.gif" : {"100px" : submenuInter} },
						   "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICMIR0054 Reportes Cifras Contro de Archivos a Transmitir" : {"pics/icons/report.gif" : {"" : "ControllerServlet?action=SICMIR0054"}} };
													
var submenu_Interred  = { "-"                          : "",
                         "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0110 Liquidaci\u00f3n de la Compensaci\u00f3n de Interredes por Banco Socio" : {"pics/icons/report.gif" : {"Emisor" : "ControllerServlet?action=SICLIR0110"}},
                         "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0120 Reporte de la Liquidaci\u00f3n de Interredes de Cadenas Comerciales" : {"pics/icons/report.gif" : {"Interred" : "ControllerServlet?action=SICLIR0120"}},
                         "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0130 Consolidado de la Liquidaci\u00f3n de Interredes por Banco Socio" : {"pics/icons/report.gif" : {"Prosa" : "ControllerServlet?action=SICLIR0130"}} ,
                         "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0140 Reporte Consolidado de la Liquidaci\u00f3n Interredes de Cadenas Comerciales" : {"pics/icons/report.gif" : {"Prosa" : "ControllerServlet?action=SICLIR0140"}},
                         "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0430 Dep\u00f3sitos por Banco e Interred" : {"pics/icons/report.gif" : {"Interred" : "ControllerServlet?action=SICLIR0430"}},
                         "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICMOR0360 Reporte de trx. Aceptadas Interredes por Emisor (Detalle)" : {"pics/icons/report.gif" : {"Emisor" : "ControllerServlet?action=SICMOR0360"}} };


var submenu_Bmr_Bmx  = { "-"                          : "",
                          "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0050 Reporte de la Liquidaci\u00f3n Entrante" : {"pics/icons/report.gif" : {"Emisor" : "ControllerServlet?action=SICLIR0050"}},
                          "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0060 Reporte de la Liquidaci\u00f3n Saliente" : {"pics/icons/report.gif" : {"Emisor" : "ControllerServlet?action=SICLIR0060"}},
                           "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0077 Reporte Consolidado Saliente E-Global" : {"pics/icons/report.gif" : {"Emisor" : "ControllerServlet?action=SICLIR0077"}},
                          "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0087 Reporte Consolidado Entrante E-Global" : {"pics/icons/report.gif" : {"Emisor" : "ControllerServlet?action=SICLIR0087"}},
                          "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0090 Reporte de Saldos Con E-Global" : {"pics/icons/report.gif" : {"Prosa" : "ControllerServlet?action=SICLIR0090"}},
                          "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0100 Reporte de la Compensaci\u00f3n Bmr / Bmx Entrante-Saliente" : {"pics/icons/report.gif" : {"Prosa" : "ControllerServlet?action=SICLIR0100"}},
                           "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0105 Reporte de la Liquidaci\u00f3n Banco Fà¢©l Paguitos" : {"pics/icons/report.gif" : {"Emisor" : "ControllerServlet?action=SICLIR0105"}},
                          "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0350 Reporte de Miscelà­¥os" : {"pics/icons/report.gif" : {"" : "ControllerServlet?action=SICLIR0350"}},
                          "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0360 Reporte de Contracargos y Representaciones " : {"pics/icons/report.gif" : {"" : "ControllerServlet?action=SICLIR0360"}},
                           "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0450 Reporte de Diferencias de Comisiones de E-Global" : {"pics/icons/report.gif" : {"Prosa" : "ControllerServlet?action=SICLIR0450"}},
                          "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0460 Reporte de Transacciones Extermporà­¥as por Emisor" : {"pics/icons/report.gif" : {"Emisor" : "ControllerServlet?action=SICLIR0460"}},
                          "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0461 Reporte de Transacciones Extermporà­¥as por Adquirente" : {"pics/icons/report.gif" : {"Prosa" : "ControllerServlet?action=SICLIR0461"}}};


var submenu_BncScs  = { "-"                          : "",
                          "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0010 Reporte de Liquidaciones Complementarias" : {"pics/icons/report.gif" : {"" : "ControllerServlet?action=SICLIR0010"}},
                          "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0020 Reporte de la Liquidaci\u00f3n Circuito Local" : {"pics/icons/report.gif" : {"" : "ControllerServlet?action=SICLIR0020"}},
                          "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0030 Reporte Consolidado de la Liquidaci\u00f3n Circuito Local" : {"pics/icons/report.gif" : {"Prosa" : "ControllerServlet?action=SICLIR0030"}},
                          "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0040 Reporte de Saldos Entre Bancos Socios" : {"pics/icons/report.gif" : {"Prosa" : "ControllerServlet?action=SICLIR0040"}}
                          };


var submenu_Liq  =      { "-"                            : "",
                         "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Interredes" : {"pics/icons/report.gif" : {"430px" : submenu_Interred}} ,
                         "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;E-Global" : {"pics/icons/report.gif" : {"430px" : submenu_Bmr_Bmx}} ,
                         "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Circuito Local" : {"pics/icons/report.gif" : {"430px" : submenu_BncScs}} ,
                         "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIF0060 Saldos Diarios de Entidades por Tipos de Liquidaci\u00f3n" : {"pics/icons/report.gif" : {"" : "ControllerServlet?action=SICLIF0060"}},
                         "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIF0065 Saldos Diarios de Grupos por Tipo de Liquidaci\u00f3n" : {"pics/icons/report.gif" : {"" : "ControllerServlet?action=SICLIF0065"}}, 
                         "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0200 Reporte Consolidado de la Liquidaci\u00f3n" : {"pics/icons/report.gif" : {"" : "ControllerServlet?action=SICLIR0200"}},
                         "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0320 Reporte Consolidado de Saldos" : {"pics/icons/report.gif" : {"Prosa" :"ControllerServlet?action=SICLIR0320"}} };

var submenu_Transacc = { "-" 														 : "",
						 "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0310 Transacciones Rechazadas de Sintà·©s por Bancomer/Banamex/E-Global" : {"pics/icons/report.gif" : {"" : "ControllerServlet?action=SICLIR0310"}},
						 <%if (rol.equals("banco")){%>
						 	"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICMOF0100 Consulta de Transacciones Aceptadas Adquirente" : {"pics/icons/report.gif" : {"" : "ControllerServlet?action=SICMOF0100&tipo=adq"}},
						 	"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICMOF0100 Consulta de Transacciones Aceptadas Emisor" : {"pics/icons/report.gif" : {"" : "ControllerServlet?action=SICMOF0100&tipo=emi"}},
						 <%}else {%>
						 	"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICMOF0100 Consulta de Transacciones Aceptadas" : {"pics/icons/report.gif" : {"" : "ControllerServlet?action=SICMOF0100"}},
						 <%}%>
						 "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICMOR0100 Reporte de Transacciones Aceptadas (Por Comercio)" : {"pics/icons/report.gif" : {"" : "ControllerServlet?action=SICMOR0100"}},
					     "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICMOR0205 Log de Transacciones" : {"pics/icons/report.gif" : {"" : "ControllerServlet?action=SICMOR0205"}},						 
					     "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICMOR0210 Reporte de Transacciones Rechazadas" : {"pics/icons/report.gif" : {"Adquirente" : "ControllerServlet?action=SICMOR0210"}},
					     "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICMOR0305 Reporte tx's aceptadas (Totales por Emisor ) " : {"pics/icons/report.gif" : {"Emisor" : "ControllerServlet?action=SICMOR0305"}},
						 "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICMOR0330 Verificador de Transacciones Enviadas por E-Global." : {"pics/icons/report.gif" : {"" : "ControllerServlet?action=SICMOR0330"}},
						 "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICMOR0340 Reporte de Rechazos de Sintà·©s por Emisor." : {"pics/icons/report.gif" : {"" : "ControllerServlet?action=SICMOR0340"}},
             "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICMORPTLF Reporte de Log de autorizaciones" : {"pics/icons/report.gif" : {"" : "ControllerServlet?action=SICMORPTLF"}}};
												 
var submenu_Control  = { "-"														 : "",
						 "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICMOR0150 Comparaci\u00f3n de Cifras de Control por Archivo" : {"pics/icons/report.gif" : {"Prosa" : "ControllerServlet?action=SICMOR0150"}},
						 "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICMOR0170 Reporte de Cifras de Control de Archivos de Entrada" : {"pics/icons/report.gif" : {"Prosa" : "ControllerServlet?action=SICMOR0170"}},
						 "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICMOR0810 Reporte de Cifras para Custodia de Vouchers." : {"pics/icons/report.gif" : {"Prosa" : "ControllerServlet?action=SICMOR0810"}}};
												 
var submenu_MyC = 	   { "-"														 : "", 
						   "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cifra de Control" : {"pics/icons/report.gif" : {"340px" : submenu_Control}},
						   "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Monitoreo de Transacciones" : {"pics/icons/report.gif" : {"430px" : submenu_Transacc}} };

var submenu_cont ={"-"                           : "",
						"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0640 Reporte de Ingresos y Gastos Liquidaciò¬ŸŽormal " : {"pics/icons/report.gif" : {"" : "ControllerServlet?action=SICLIR0640"}},						
                          "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0670 Reporte de Cuotas Pagadas a E-Global" : {"pics/icons/report.gif" : {"" : "ControllerServlet?action=SICLIR0670"}},
                          "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0680 Reporte de Cuotas Cobradas a E-Global" : {"pics/icons/report.gif" : {"" : "ControllerServlet?action=SICLIR0680"}}};													

var submenu_tesor ={"-"                           : "",
                          "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLIR0440 Reporte de Liquidaciones Complementaras de Tesorería" : {"pics/icons/report.gif" : {"" : "ControllerServlet?action=SICLIR0440"}},
                          "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICLMPDA450 TRANSACCIONES CON PROMOCIÓN" : {"pics/icons/report.gif" : {"" : "ControllerServlet?action=SICMPDA450"}}};

//  ---------------------------------------------------------------------------------//
//  -- Marca del Cambio : WELL-EMQ-P-02-1202-09 Inicia la Modificacion   08/02/2010 -//
//  ---------------------------------------------------------------------------------//
var submenu_prepago ={"-"                           : "",
						 "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICPRE001 Saldos por Cuenta Carnet Emisor Prepago." : {"pics/icons/report.gif" : {"Prosa" : "ControllerServlet?action=SICPRE001"}},
						 "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICPRE002 Transacciones pendientes de presentar a compensación." : {"pics/icons/report.gif" : {"Prosa" : "ControllerServlet?action=SICPRE002"}},
						 "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICPRE003 Resumen de transacciones." : {"pics/icons/report.gif" : {"Prosa" : "ControllerServlet?action=SICPRE003"}},
						 "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SICPRE004 Estado de Resultados Prepago" : {"pics/icons/report.gif" : {"Prosa" : "ControllerServlet?action=SICPRE004"}}};


var submenu_interF = 	   { "-"														 : "", 
						   "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Contabilidad" : {"pics/icons/report.gif" : {"430px" : submenu_cont}},
						   "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tesoreria" : {"pics/icons/report.gif" : {"430px" : submenu_tesor}} };


var submenu_report =   { "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Monitoreo y Cifras de Control" : {"pics/icons/report.gif" : {"180px;" : submenu_MyC} },
                         "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Liquidaci\u00f3n"    : {"pics/icons/report.gif" : {"350px" : submenu_Liq} },
                         "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Integraci\u00f3n / Respuesta de Intercambio" : {"pics/icons/report.gif" : {"330px" : submenu_InteRInter}},
                         "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Interfaces"    : {"pics/icons/report.gif" : {"200px" : submenu_interF} },
                         "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Prepago"    : {"pics/icons/report.gif" : {"400px" : submenu_prepago} }};

var submenu_tools    = { "-"                                      : "", 
						 "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Liberaci\u00f3n de Cifras" : {"" : {"Prosa" : "ControllerServlet?action=lstGrpSacii"}},
						 "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Reintegros" : {"" : {"Prosa" : "ControllerServlet?action=reintegro"}},
						 "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Prefijos" : {"" : {"Prosa" : "ControllerServlet?action=losprefijos"}}};
						 
//  -----------------------------------------------------------------------------------//
//  -- Marca del Cambio : WELL-EMQ-P-02-1202-09 Finaliza la Modificacion   08/02/2010 -//
//  -----------------------------------------------------------------------------------//

var submenu_help     = { "-"                                      : "",
						 "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Acerca de..." : {"" : {"" : "#"}} };
												 												 
if("<%=rol%>"== "administrador"||"<%=rol%>"== "operador"){
	var menu = { "report" : {"pics/icons/report.gif" : {"230px" : submenu_report} },
			 "tools"  : {"pics/icons/liberacion.gif" : {"150px" : submenu_tools} },
			 "help"   : {"pics/icons/about.gif" : {"120px" : submenu_help} },
			 "leave"  : {"" : {"" : ""}}  };
}else{
	var menu = { "report" : {"pics/icons/report.gif" : {"230px" : submenu_report} },
			 "help"   : {"pics/icons/about.gif" : {"120px" : submenu_help} },
			 "leave"  : {"" : {"" : ""}}  };
}

dhtmlmenu_build(menu,'<%=emi%>','<%=adq%>','<%=inte%>','<%=rol%>'); 
</script>
</div>
</body>
</html>