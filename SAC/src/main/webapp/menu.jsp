<%@page contentType="text/html; charset=iso-8859-1"%>
<%@page import="java.io.File"%>
<%@page import="com.wellcom.io.FtS"%>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>

<%
/*
#-----------------------------------------------------------------------------#
# Autor               : Gerardo G. Burguete.                                  #
# Compania            : Axia Consultores, S.A. de C.V.                        #
# Proyecto/Procliente : P-02-0496-10              Fecha: 22/11/2012           #
# Modificacion        : Evaluacion e implementacion del Servicio DCC          #
# Marca del Cambio    : AXIA-GGB-P-02-0496-10                                 #
#-----------------------------------------------------------------------------#
# Nombre del Programa : menu.jsp                                              #
# Autor               : Carolina Martin del Campo Rodriguez                   #
# Compania            : IDSys S.A. de C.V.                                    #
# Proyecto/Procliente : N-08-2033-13                       Fecha:  30/08/2013 #
# Modificacion        : Reporte para Abono Inmediato                          #
# Marca cambio        : IDSYS-CMDELCR-N-08-2033-13                            #
#-----------------------------------------------------------------------------#
# Autor               : Salvador Montiel                                      #
# Compania            : AM Estudio                                            #
# Proyecto/Procliente : P-54-2940-14               Fecha: 23/04/2015          #
# Modificacion        : Soporte Interactivo (FAQs,Tutoriales,Manuales)        #
# Marca del Cambio    : P-54-2940-14 AMEstudio 23.04.2015                     #
#-----------------------------------------------------------------------------#
# Autor               : Gerardo G. Burguete                                   #
# Compania            : Axia, consultores, S.A. DE C.V.                       #
# Proyecto/Procliente : P-53-2933-14                 Fecha: 25/05/2015        #
# Descripcion General : Recalculo de compensacion y administracion de umbrales#
# Modificacion        : sustituir la palabra Liquidación por compensación     #
# Marca del Cambio    : AXIA-GGB-P-53-2933-14                                 #
#-----------------------------------------------------------------------------#
# Autor               :  Daniel Ramírez Torres                                #
# Compania            :  SAS S.A. DE C.V.                                     #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017       #
# Modificacion        :  Mejora Conexiones  SAC2                              #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                 #
#-----------------------------------------------------------------------------#
# Autor               : Juan Rodriguez Gonzalez                               #
# Compania            : IDSys S.A. de C.V.                                    #
# Proyecto/Procliente : P-22-0136-14                       Fecha:  31/05/2017 #
# Modificacion        : Reporte de transacodiifcadas                          #
# Marca cambio        : IDSYS-JRG-P-22-0136-14                                #
#-----------------------------------------------------------------------------#
# Autor               :  Daniel Ramírez Torres                                #
# Compania            :  SAS S.A. DE C.V.                                     #
# Proyecto/Procliente :  P-20-0115-16                 Fecha: 14/09/2017       #
# Modificacion        :  Incorporación de American Express (AMEX) a PROSA para#
#                        transacciones POS                                    #
# Marca del Cambio    :  SAS-DRT-P-20-0115-16                                 #
#-----------------------------------------------------------------------------#
# Autor               :  German Gonzalez Esquivel                             #
# Compania            :  Wellcom S.A. DE C.V.                                 #
# Proyecto/Procliente :  F-52-8181-17                 Fecha: 13/10/2017       #
# Modificacion        :  Desviacion 02 - Correccion de reimpacto de proyecto  #
#                        de transacciones Trascodificadas                     #
# Marca del Cambio    :  Well-F-52-8181-17                                    #
#-----------------------------------------------------------------------------#
# Autor               :  Francisco Javier Cuamatzi Cuamatzi                   #
# Compania            :  Axia, consultores, S.A. DE C.V.                      #
# Proyecto/Procliente :  P-25-5216-16                 Fecha: 05/10/2017       #
# Modificacion        :  Reintegro de mercados internacionales                #
#                                                                             #
# Marca del Cambio    :  AXIA-FJCC-P-25-5216-16                               #
#-----------------------------------------------------------------------------#
*/
    //response.sendRedirect("login.jsp");
    if(!ga.AccessGranted(session, "grantAccess"))
    {
        response.sendRedirect("login.jsp");
    }
    String emi  = (String) session.getAttribute("emisor");
    String adq  = (String) session.getAttribute("adquirente");
        String inte = (String) session.getAttribute("interred");
        String roles  = (String) session.getAttribute("roles");
        String posicion = (String) session.getAttribute("pos");
//Modificacion: Marca de Inicio IDSYS-CMDELCR-N-08-2033-13 30/08/2013
        String myrole = (String) session.getAttribute("role");
        //System.out.println("myrole: " + myrole);
//Modificacion: Marca de Fin IDSYS-CMDELCR-N-08-2033-13 30/08/2013
        System.out.println("Permisos: " + " emisor: "+ emi + " adquirente: " + adq + " interred: " + inte + " Posicion: " + posicion);
         String numFiid=(String)session.getAttribute("numFiid");
         String usuario=(String)session.getAttribute("login");
         if (usuario.equals("")){
        usuario=null;
    }

    if (numFiid!=null&&numFiid.equals("")){
    numFiid="b999";
    }
        //LoginManager controlUsuario=(LoginManager)session.getAttribute("controlUsuario");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
        <link rel="stylesheet" type="text/css" href="scripts/dhtmlxAccordion/codebase/skins/dhtmlxaccordion_dhx_black.css"/>
        <script src="scripts/dhtmlxAccordion/codebase/dhtmlxcommon.js"></script>
        <script src="scripts/dhtmlxAccordion/codebase/dhtmlxaccordion.js"></script>
        <script src="scripts/dhtmlxAccordion/codebase/dhtmlxcontainer.js"></script>

        <link rel="stylesheet" type="text/css" href="scripts/dhtmlxTree/codebase/dhtmlxtree.css" />
        <script src="scripts/dhtmlxTree/codebase/dhtmlxcommon.js"></script>
        <script src="scripts/dhtmlxTree/codebase/dhtmlxtree.js"></script>
        <script>
            function cambioPaginaReload(url, idPos)
            {

                //url = urlCambioPagina(action);
                //alert(url);
                if (window.XMLHttpRequest)
                {
                    // Si es Mozilla, Safari etc
                    pagina_requerida = new XMLHttpRequest();
                } else if (window.ActiveXObject)
                {
                    // pero si es IE
                    try
                    {
                        pagina_requerida = new ActiveXObject("Msxml2.XMLHTTP");
                    } catch (e)
                    {
                        // en caso que sea una versión antigua
                        try
                        {
                            pagina_requerida = new ActiveXObject("Microsoft.XMLHTTP");
                        } catch (e)
                        {
                        }
                    }
                } else
                    return false;
                pagina_requerida.onreadystatechange = function ()
                {
                    // función de respuesta
                    cargarpaginaR(pagina_requerida, idPos);
                }
                pagina_requerida.open('POST', url, true); // asignamos los métodos open y send
                pagina_requerida.send(null);
            }




            function cambioPagina(action, idPos)
            {

                url = urlCambioPagina(action);
                //alert(url);
                if (window.XMLHttpRequest)
                {
                    // Si es Mozilla, Safari etc
                    pagina_requerida = new XMLHttpRequest();
                } else if (window.ActiveXObject)
                {
                    // pero si es IE
                    try
                    {
                        pagina_requerida = new ActiveXObject("Msxml2.XMLHTTP");
                    } catch (e)
                    {
                        // en caso que sea una versión antigua
                        try
                        {
                            pagina_requerida = new ActiveXObject("Microsoft.XMLHTTP");
                        } catch (e)
                        {
                        }
                    }
                } else
                    return false;
                pagina_requerida.onreadystatechange = function ()
                {
                    // función de respuesta
                    cargarpaginaR(pagina_requerida, idPos);
                }
                pagina_requerida.open('POST', url, true); // asignamos los métodos open y send
                pagina_requerida.send(null);
            }
            <%
        /*--------------------------------------------------------------------------- */
        /* Marca del Cambio: SAS-DRT Inicia de la Modificacion */
        /*----------------------------------------------------------------------------*/
            %>
/* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */                
            function urlCambioPagina(action)
            {
                var urlTmp = "ControllerServletGen?action=" + action;
                return urlTmp;
            }

            function cambioPaginaModulo(action, modulo, idPos)
            {
                url = urlCambioPaginaModulo(action, modulo);
                //alert("CambioPaginaModulo : "+url);
                if (window.XMLHttpRequest)
                {
                    // Si es Mozilla, Safari etc
                    pagina_requerida = new XMLHttpRequest();
                } else if (window.ActiveXObject)
                {
                    // pero si es IE
                    try
                    {
                        pagina_requerida = new ActiveXObject("Msxml2.XMLHTTP");
                    } catch (e)
                    {
                        // en caso que sea una versión antigua
                        try
                        {
                            pagina_requerida = new ActiveXObject("Microsoft.XMLHTTP");
                        } catch (e)
                        {
                        }
                    }
                } else
                    return false;
                pagina_requerida.onreadystatechange = function ()
                {
                    cargarpaginaR(pagina_requerida, idPos);
                }
                pagina_requerida.open('POST', url, true); // asignamos los métodos open y send
                pagina_requerida.send(null);
            }
            
            function urlCambioPaginaModulo(action, modulo)
            {
                //alert("Action : "+action+" Modulo : "+modulo );
                var urlTmp = "ControllerServlet?action=" + action;
                if (modulo == "promociones")
                {
                    urlTmp = "ControllerServletPromociones?action=" + action;
                } else if (modulo == "Monitoreo")
                {
                    urlTmp = "ControllerServletMonitoreo?action=" + action;
                } else if (modulo == "Compensacion")
                {
                    urlTmp = "ControllerServletCompensacion?action=" + action;
                } else if (modulo == "Informativa")
                {
                    urlTmp = "ControllerServletInformativa?action=" + action;
                } else if (modulo == "emisorDolares")
                {
                    urlTmp = "ControllerServletEmisorDolares?action=" + action;
                } else if (modulo == "integracion")
                {
                    urlTmp = "ControllerServletIntegracion?action=" + action;
                } else if (modulo == "adquirenteD")
                {
                    urlTmp = "ControllerServletAdquirente?action=" + action;
                } else if (modulo == "Extem")
                {
                    urlTmp = "ControllerServletExt?action=" + action;
                } else if (modulo == "Promoc")
                {
                    urlTmp = "ControllerServletProm?action=" + action;
                } else if (modulo == "mastervisa")
                {
                    urlTmp = "ControllerServletMasVi?action=" + action;
                } else if (modulo == "interfac")
                {
                    urlTmp = "ControllerServletInterf?action=" + action;
                } else if (modulo == "Prepago")
                {
                    urlTmp = "ControllerServletPrep?action=" + action;
                } else if (modulo == "Click")
                {
                    urlTmp = "ControllerServletClick?action=" + action;
                } else if (modulo == "HubCarn")
                {
                    urlTmp = "ControllerServletHub?action=" + action;
                } else if (modulo == "VentaTA")
                {
                    urlTmp = "ControllerServletVTA?action=" + action;
                } else if (modulo == "RepDCC")
                {
                    urlTmp = "ControllerServletReDCC?action=" + action;
                } else if (modulo == "RepLIQ")
                {
                    urlTmp = "ControllerServletReLQ?action=" + action;
                } else if (modulo == "MonitoreCCH")
                {
                    urlTmp = "ControllerServletMonitH?action=" + action;
                } else if (modulo == "LiquidacionH")
                {
                    urlTmp = "ControllerServletLiqH?action=" + action;
                } else if (modulo == "IntegracionH")
                {
                    urlTmp = "ControllerServletIntegH?action=" + action;
                } else if (modulo == "AdquirienteH")
                {
                    urlTmp = "ControllerServletAdquiH?action=" + action;
                } else if (modulo == "PromocionesH")
                {
                    urlTmp = "ControllerServletPromoH?action=" + action;

                } else if (modulo == "Herramientas")
                {
                    urlTmp = "ControllerServletHerr?action=" + action;
                } else if (modulo == "Miscelaneos")
                {
                    urlTmp = "ControllerServletMisc?action=" + action;
 //Modificacion: Marca de inicio  IDSYS-JRG-P-02-0136-14 31/05/2017
                } else if (modulo == "Trascodificada")
                {
                    urlTmp = "ControllerServletTrascod?action=" + action;
                }
 //Modificacion: Marca de termino IDSYS-JRG-P-02-0136-14 31/05/2017
 //Modificacion: SAS-DRT P-20-0115-16 Marca de Inicio
                else if (modulo == "AmeX")
                {
                    urlTmp = "ControllerServletAmex?action=" + action;
                }
 //Modificacion: SAS-DRT P-20-0115-16 Marca de Fin
                return urlTmp;
            }
            /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
        </script>


    </head>

    <body onload="OnLoadMenu();">
        <div id="accordObj"  style="width: 350px; height: 470px;"` ></div>

        <script>

            var dhxAccord;
            function OnLoadMenu()
            {
                dhxAccord = new dhtmlXAccordion("accordObj");
                dhxAccord.setSkin("dhx_black");
                dhxAccord.setIconsPath("pics/icons/");

                dhxAccord.addItem("a9", "Inicio");
                dhxAccord.setIcon("a9", "home.png");

                dhxAccord.addItem("a1", "Reportes");
                dhxAccord.setIcon("a1", "reportes3.png");
            <%
/*--------------------------------------------------------------------------- */
/* Marca del Cambio: AXIA-GGB-P-02-0496-10 Inicia  la Modificacion 22/12/2012 */
/*----------------------------------------------------------------------------*/
            %>
                dhxAccord.addItem("a6", "Reportes DCC");
                dhxAccord.setIcon("a6", "reportes3.png");
            <%
/*--------------------------------------------------------------------------- */
/* Marca del Cambio: AXIA-GGB-P-02-0496-10 Termina la Modificacion 22/12/2012 */
/*----------------------------------------------------------------------------*/
/* Marca del Cambio: AXIA-GGB-P-53-2933-14 Inicia  la Modificacion 25/05/2015 */
/*----------------------------------------------------------------------------*/
            %>
                dhxAccord.addItem("a8", "Liquidacion y Reportes de Liquidacion");
                dhxAccord.setIcon("a8", "reportes3.png");
            <%
/*----------------------------------------------------------------------------*/
/* Marca del Cambio: AXIA-GGB-P-53-2933-14 Termina la Modificacion 25/05/2015 */
/*----------------------------------------------------------------------------*/
            %>
                dhxAccord.addItem("a5", "Reportes Históricos a Detalle");
                dhxAccord.setIcon("a5", "reportes3.png");

//Marca inicio:  P-54-2940-14 AMEstudio 23.04.2015 
                dhxAccord.addItem("a7", "Soporte interactivo");
                dhxAccord.setIcon("a7", "soporte.png");
//Marca fin:  P-54-2940-14 AMEstudio 23.04.2015    	

                dhxAccord.addItem("a2", "Herramientas");
                dhxAccord.setIcon("a2", "configuracion.png");


//Modificacion: Marca de inicio IDSYS-CMDELCR-N-08-2033-13 30/08/2013
                var role = '<%=myrole%>';
                if (role == "operador") {
                    dhxAccord.addItem("ar", "Parametros intercambio");
                    dhxAccord.setIcon("ar", "configuracion.png");
                }
                //Modificacion: Marca de termino IDSYS-CMDELCR-N-08-2033-13 30/08/2013
 //Modificacion: Marca de inicio IDSYS-JRG-P-02-0136-14 31/05/2017
            dhxAccord.addItem("a10", "Reportes Sigue Mi Tarjeta");
            dhxAccord.setIcon("a10", "reportes3.png");
  //Modificacion: Marca de termino IDSYS-JRG-P-02-0136-14 31/05/2017

                dhxAccord.addItem("a3", "Ayuda");
                dhxAccord.setIcon("a3", "ayuda.png");

                dhxAccord.addItem("a4", "Salir");
                dhxAccord.setIcon("a4", "salir.png");
                dhxAccord.closeItem("a4");



                dhxAccord.attachEvent("onActive", function (itemId)
                {
                    if (dhxAccord.cells(itemId).getText() == 'Salir')
                        window.location.href = "ControllerServletGen?action=Salir";
                });
                dhxAccord.attachEvent("onClick", function (itemId)
                {
                    if (dhxAccord.cells(itemId).getText() == 'Salir')
                        window.location.href = "ControllerServletGen?action=Salir";
                });

                dhxAccord.attachEvent("onBeforeActive", function (itemId)
                {
                    var allow = (itemId != "a9");

                    if (dhxAccord.cells(itemId).getText() == 'Inicio')
                        window.location.href = "ControllerServletGen?action=index";

                    return allow;
                });

                dhxAccord._enableOpenEffect = true;
            <%if (!posicion.equals("a0")){%>
                dhxAccord.cells("<%= posicion%>").open();
            <%}%>

                // tg_GGE
                /**
                 * El siguiente codigo es practicamente copiar y pegar,
                 * lo unico que cambia es la entrada "a1",
                 * se crea el evento y se le envia p=a1 que es la posicion.
                 */

                var tree1 = dhxAccord.cells("a1").attachTree();
                tree1.setSkin("dhx_skyblue");
                tree1.setImagePath("pics/icons/");
                tree1.enableTreeImages(true);
                tree1.enableTreeLines(true);
                tree1.attachEvent("onClick",
                        function (id)
                        {
                            //alert(tree1.getUserData(id,"href"));}

                            if (tree1.getUserData(id, "href") != undefined)
                                if (tree1.getUserData(id, "href") != null && tree1.getUserData(id, "href") == "SICMOR0200") {
                                    window.open('https://aplicpm.prosa.com.mx/det/acceso.jsp?nombreReporte=sicmor0200c&uid=' + '<%=usuario%>');
                                } else
                                    //cambioPagina(tree1.getUserData(id,"href"),"rightPanel");
                                    /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
                                    cambioPaginaModulo(tree1.getUserData(id, "href"), tree1.getUserData(id, "modulo"), "rightPanel");
                            /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
                            //window.location.href="ControllerServlet?action=" + tree1.getUserData(id,"href") + "&p=a1";

                        });
                //tree1.loadXML("/scripts/dhtmlxTree/common/Reportes.xml",function()
            <%
                String path= session.getServletContext().getRealPath("/");

        File xml = new File(path + "/scripts/dhtmlxTree/common/Reportes.xml" );
        FtS fts = new FtS();
        String xmlString = fts.fileToString(xml).replaceAll("\"", "\\\\\"");
        //System.out.println(xmlString);
            %>
                var xmlcatalogo = '<%= xmlString%>';
                tree1.loadXMLString(xmlcatalogo, function ()
                {
                    var x = tree1.getAllSubItems("0").split(",");
                    //alert(tree1.getAllChildless());
                    for (i = 0; i < x.length; i++) {
                        if (tree1.getUserData(x[i], "rolAccMin") != undefined) {
                            var val = tree1.getUserData(x[i], "rolAccMin");
                            var rolVal =<%=session.getAttribute("rolAccVal")%>
                            //alert(x[i]+": "+val+","+rolVal+" :"+ (val<=rolVal))
                            if (val >= rolVal)
                                tree1.deleteItem(x[i]);
                        }
                    }

                });


                //tree1.loadXMLString();

                /**
                 * Aqui termina el codigo a copiar.
                 */


                var tree5 = dhxAccord.cells("a5").attachTree();
                tree5.setSkin("dhx_skyblue");
                tree5.setImagePath("pics/icons/");
                tree5.enableTreeImages(true);
                tree5.enableTreeLines(true);
                tree5.attachEvent("onClick",
                        function (id)
                        {
                            if (tree5.getUserData(id, "href") != undefined)
                                if (tree5.getUserData(id, "href") != null && tree5.getUserData(id, "href") == "SICMOR0200H") {
                                    window.open('https://aplicpm.prosa.com.mx/det/acceso.jsp?nombreReporte=sicmor0200b&uid=' + '<%=usuario%>');
                                } else if (tree5.getUserData(id, "href") != null && tree5.getUserData(id, "href") == "SICMOR0300H") {
                                    window.open('https://aplicpm.prosa.com.mx/det/acceso.jsp?nombreReporte=sicmor0300b&uid=' + '<%=usuario%>');
                                } else if (tree5.getUserData(id, "href") != null && tree5.getUserData(id, "href") == "SICMOR0301H") {
                                    window.open('https://aplicpm.prosa.com.mx/det/acceso.jsp?nombreReporte=sicmor0301&uid=' + '<%=usuario%>');
                                } else if (tree5.getUserData(id, "href") != null && tree5.getUserData(id, "href") == "SICMOR0330H") {
                                    window.open('https://aplicpm.prosa.com.mx/det/acceso.jsp?nombreReporte=sicmor0330&uid=' + '<%=usuario%>');
                                } else
                                    //cambioPagina(tree5.getUserData(id,"href"),"rightPanel");
                                    /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
                                    cambioPaginaModulo(tree5.getUserData(id, "href"), tree5.getUserData(id, "modulo"), "rightPanel");
                            /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
                        });
                //tree1.loadXML("/scripts/dhtmlxTree/common/Reportes.xml",function()
            <%
                path= session.getServletContext().getRealPath("/");

        xml = new File(path + "/scripts/dhtmlxTree/common/ReportesHistoricos.xml" );
        fts = new FtS();
        xmlString = fts.fileToString(xml).replaceAll("\"", "\\\\\"");
        //System.out.println(xmlString);
            %>
                var xmlcatalogo = '<%= xmlString%>';
                tree5.loadXMLString(xmlcatalogo, function ()
                {
                    var x = tree5.getAllSubItems("0").split(",");
                    //alert(tree1.getAllChildless());
                    for (i = 0; i < x.length; i++) {
                        if (tree5.getUserData(x[i], "rolAccMin") != undefined) {
                            var val = tree5.getUserData(x[i], "rolAccMin");
                            var rolVal =<%=session.getAttribute("rolAccVal")%>
                            //alert(x[i]+": "+val+","+rolVal+" :"+ (val<=rolVal))
                            if (val >= rolVal)
                                tree5.deleteItem(x[i]);
                        }
                    }

                });


                //tree1.loadXMLString();
//Marca inicio:
                var tree7 = dhxAccord.cells("a7").attachTree();
                tree7.setSkin("dhx_skyblue");
                tree7.setImagePath("pics/icons/");
                tree7.enableTreeImages(true);
                tree7.enableTreeLines(true);
                tree7.attachEvent("onClick",
                        function (id)
                        {
                            //if(id!="reporte")
                            if (tree7.getUserData(id, "href") != undefined)
                                if (tree7.getUserData(id, "href") != null && tree7.getUserData(id, "href") == "reintegro") {
                                    window.open('https://aplicpm.prosa.com.mx/reintegro/reintegro.jsp?user=<%=usuario%>', '', 'directories=0,location=0,menubar=0,resizable=1,scrollbars=1,status=0,titlebar=0,toolbar=0');
                                } else
                                    // cambioPagina(tree7.getUserData(id, "href"), "rightPanel");
                                    /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
                                    cambioPaginaModulo(tree7.getUserData(id, "href"), tree7.getUserData(id, "modulo"), "rightPanel");
                            /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
                            //window.location.href="ControllerServlet?action=" + tree2.getUserData(id,"href") + "&p=a2";
                        }
                );

            <%

        xml = new File(path + "/scripts/dhtmlxTree/common/Soporte.xml" );
        fts = new FtS();
        xmlString = fts.fileToString(xml).replaceAll("\"", "\\\\\"");
        //System.out.println(xmlString);
            %>
                xmlcatalogo = '<%= xmlString%>';


                tree7.loadXMLString(xmlcatalogo, function ()
                {
                    var x = tree7.getAllChildless().split(",");
                    for (i = 0; i < x.length; i++) {
                        if (tree7.getUserData(x[i], "rolAccMin") != undefined) {
                            var val = tree7.getUserData(x[i], "rolAccMin");
                            var rolVal =<%=session.getAttribute("rolAccVal")%>
                            //alert(x[i]+": "+val+","+rolVal+" :"+ (val<=rolVal))
                            if (val >= rolVal)
                                tree7.deleteItem(x[i]);
                        }
                    }

                });
//Marca fin:
                var tree2 = dhxAccord.cells("a2").attachTree();
                tree2.setSkin("dhx_skyblue");
                tree2.setImagePath("pics/icons/");
                tree2.enableTreeImages(true);
                tree2.enableTreeLines(true);
                tree2.attachEvent("onClick",
                        function (id)
                        {
                            //if(id!="reporte")
                            if (tree2.getUserData(id, "href") != undefined)
                                if (tree2.getUserData(id, "href") != null && tree2.getUserData(id, "href") == "reintegro") {
                                    window.open('https://aplicpm.prosa.com.mx/reintegro/reintegro.jsp?user=<%=usuario%>', '', 'directories=0,location=0,menubar=0,resizable=1,scrollbars=1,status=0,titlebar=0,toolbar=0');
                                } 
                                 /*--------------------------------------------------------------------------- */
                             /* Marca del Cambio: AXIA-FJCC-P-25-5216-16 Inicia la Modificacion 05/10/2017 */
                             /*----------------------------------------------------------------------------*/
                             else if(tree2.getUserData(id,"href")!=null&&tree2.getUserData(id,"href")=="reintegromi"){
                                 //window.open('https://10.255.220.68:38081/reintegro_MI/reintegro.jsp?user=<%=usuario%>','','directories=0,location=0,menubar=0,resizable=1,scrollbars=1,status=0,titlebar=0,toolbar=0');
                                 window.open('https://aplicpm.prosa.com.mx/reintegro_MI/reintegro.jsp?user=<%=usuario%>','','directories=0,location=0,menubar=0,resizable=1,scrollbars=1,status=0,titlebar=0,toolbar=0');
                                }
                                
                             /*--------------------------------------------------------------------------- */
                             /* Marca del Cambio: AXIA-FJCC-P-25-5216-16 Termina la Modificacion 05/10/2017 */
                             /*----------------------------------------------------------------------------*/
                             else
                                    //cambioPagina(tree2.getUserData(id, "href"), "rightPanel");
                                    /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
                                    cambioPaginaModulo(tree2.getUserData(id, "href"), tree2.getUserData(id, "modulo"), "rightPanel");
                            /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
                            //window.location.href="ControllerServlet?action=" + tree2.getUserData(id,"href") + "&p=a2";
                        }
                );

            <%

        xml = new File(path + "/scripts/dhtmlxTree/common/Herramientas.xml" );
        fts = new FtS();
        xmlString = fts.fileToString(xml).replaceAll("\"", "\\\\\"");
        //System.out.println(xmlString);
            %>
                xmlcatalogo = '<%= xmlString%>';


                tree2.loadXMLString(xmlcatalogo, function ()
                {
                    var x = tree2.getAllChildless().split(",");
                    for (i = 0; i < x.length; i++) {
                        if (tree2.getUserData(x[i], "rolAccMin") != undefined) {
                            var val = tree2.getUserData(x[i], "rolAccMin");
                            var rolVal =<%=session.getAttribute("rolAccVal")%>
                            //alert(x[i]+": "+val+","+rolVal+" :"+ (val<=rolVal))
                            if (val >= rolVal)
                                tree2.deleteItem(x[i]);
                        }
                    }

                });

//Modificacion: Marca de Inicio IDSYS-CMDELCR-N-08-2033-13 30/08/2013
                //session.setAttribute("role", myRole);
                //System.out.println();
                var role = '<%=myrole%>';
                if (role == "operador") {
                    var treer = dhxAccord.cells("ar").attachTree();
                    treer.setSkin("dhx_skyblue");
                    treer.setImagePath("pics/icons/");
                    treer.enableTreeImages(true);
                    treer.enableTreeLines(true);
                    treer.enableTreeLines(true);
                    treer.attachEvent("onClick",
                            function (id) {
                                /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
                                cambioPaginaModulo(treer.getUserData(id, "href"), treer.getUserData(id, "modulo"), "rightPanel");
                                /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
                                //cambioPagina(treer.getUserData(id, "href"), "rightPanel");
                            });

            <%
            xml = new File(path + "/scripts/dhtmlxTree/common/Miscelaneos.xml" );
            fts = new FtS();
            xmlString = fts.fileToString(xml).replaceAll("\"", "\\\\\"");
            %>

                    xmlcatalogo = '<%= xmlString%>';

                    if (role == "operador")
                        treer.loadXMLString(xmlcatalogo);
                }
//Modificacion: Marca de termino IDSYS-CMDELCR-N-08-2033-13 30/08/2013
//Modificacion: Marca de Inicio Well-F-52-8181-17 13/10/2017
//Modificacion: Marca de Inicio IDSYS-JRG-P-22-0136-14 23/09/2014
        var tree10 = dhxAccord.cells("a10").attachTree();
        tree10.setSkin("dhx_skyblue");
        tree10.setImagePath("pics/icons/");
        tree10.enableTreeImages(true);
        tree10.enableTreeLines(true);
        tree10.enableTreeLines(true);
        tree10.attachEvent("onClick",
        function(id){
        if(tree10.getUserData(id,"href")!=undefined)
           if(tree10.getUserData(id,"href")!=null&&tree10.getUserData(id,"href")=="SICTRC001HIST"){
             window.open('https://aplicpm.prosa.com.mx/det/acceso.jsp?nombreReporte=SICTRC001b&uid='+'<%=usuario%>');
           }else
           {
             cambioPaginaModulo(tree10.getUserData(id, "href"), tree10.getUserData(id, "modulo"), "rightPanel");
           }
        });

        <%
           xml = new File(path + "/scripts/dhtmlxTree/common/Transcodificadas.xml" );
           fts = new FtS();
           xmlString = fts.fileToString(xml).replaceAll("\"", "\\\\\"");
        %>

        xmlcatalogo = '<%= xmlString%>';
        //tree10.loadXMLString(xmlcatalogo);
        tree10.loadXMLString(xmlcatalogo,function()
        {
          var x=tree10.getAllSubItems("0").split(",");
          for(i=0;i<x.length;i++){
             if(tree10.getUserData(x[i],"rolAccMin")!=undefined){
              var val=tree10.getUserData(x[i],"rolAccMin");
              var rolVal=<%=session.getAttribute("rolAccVal")%>
              if(val>=rolVal)
                  tree10.deleteItem(x[i]);
             }
          }
        });
//Modificacion: Marca de termino IDSYS-JRG-P-22-0136-14 23/09/2014
//Modificacion: Marca de termino Well-F-52-8181-17 13/10/2017

                var tree3 = dhxAccord.cells("a3").attachTree();
                tree3.setSkin("dhx_skyblue");
                tree3.setImagePath("pics/icons/");
                tree3.enableTreeImages(true);
                tree3.enableTreeLines(true);
                tree3.attachEvent("onClick",
                        function (id)
                        {

                            window.open(tree3.getUserData(id, "href"), "", "width=1024,height=768,location=yes,resizable=yes");
                        }

                // }
                );

            <%

            xml = new File(path + "/scripts/dhtmlxTree/common/Ayuda.xml" );
            fts = new FtS();
            xmlString = fts.fileToString(xml).replaceAll("\"", "\\\\\"");
            //System.out.println(xmlString);
            %>
                xmlcatalogo = '<%= xmlString%>';


                tree3.loadXMLString(xmlcatalogo);

            <%
/*--------------------------------------------------------------------------- */
/* Marca del Cambio: AXIA-GGB-P-02-0496-10 Inicia  la Modificacion 22/12/2012 */
/*----------------------------------------------------------------------------*/
            %>
                var tree6 = dhxAccord.cells("a6").attachTree();
                tree6.setSkin("dhx_skyblue");
                tree6.setImagePath("pics/icons/");
                tree6.enableTreeImages(true);
                tree6.enableTreeLines(true);
                tree6.attachEvent("onClick",
                        function (id)
                        {
                            if (tree6.getUserData(id, "href") != undefined)
                                if (tree6.getUserData(id, "href") != null && tree6.getUserData(id, "href") == "SICMOR0200H") {
                                    window.open('https://aplicpm.prosa.com.mx/det/acceso.jsp?nombreReporte=sicmor0200b&uid=' + '<%=usuario%>');
                                } else if (tree6.getUserData(id, "href") != null && tree5.getUserData(id, "href") == "SICMOR0300H") {
                                    window.open('https://aplicpm.prosa.com.mx/det/acceso.jsp?nombreReporte=sicmor0300b&uid=' + '<%=usuario%>');
                                } else if (tree6.getUserData(id, "href") != null && tree5.getUserData(id, "href") == "SICMOR0330H") {
                                    window.open('https://aplicpm.prosa.com.mx/det/acceso.jsp?nombreReporte=sicmor0330&uid=' + '<%=usuario%>');
                                } else
                                    //cambioPagina(tree6.getUserData(id,"href"),"rightPanel");
                                    /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
                                    cambioPaginaModulo(tree6.getUserData(id, "href"), tree6.getUserData(id, "modulo"), "rightPanel");
                            /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
                        });
                //tree1.loadXML("/scripts/dhtmlxTree/common/Reportes.xml",function()
            <%
                path= session.getServletContext().getRealPath("/");

        xml = new File(path + "/scripts/dhtmlxTree/common/ReportesDCC.xml" );
        //xml = new File(path + "/scripts/dhtmlxTree/common/Reportes.xml" );
        fts = new FtS();
        xmlString = fts.fileToString(xml).replaceAll("\"", "\\\\\"");
        //System.out.println(xmlString);
            %>
                var xmlcatalogo = '<%= xmlString%>';
                tree6.loadXMLString(xmlcatalogo, function ()
                {
                    var x = tree6.getAllSubItems("0").split(",");
                    //alert(tree1.getAllChildless());
                    for (i = 0; i < x.length; i++) {
                        if (tree6.getUserData(x[i], "rolAccMin") != undefined) {
                            var val = tree6.getUserData(x[i], "rolAccMin");
                            var rolVal =<%=session.getAttribute("rolAccVal")%>
                            //alert(x[i]+": "+val+","+rolVal+" :"+ (val<=rolVal))
                            if (val >= rolVal)
                                tree6.deleteItem(x[i]);
                        }
                    }

                });
            <%
/*--------------------------------------------------------------------------- */
/* Marca del Cambio: AXIA-GGB-P-02-0496-10 Termina la Modificacion 22/12/2012 */
/*----------------------------------------------------------------------------*/
/* Marca del Cambio: AXIA-GGB-P-53-2933-14 Inicia  la Modificacion 25/05/2015 */
/*----------------------------------------------------------------------------*/
            %>
                var tree8 = dhxAccord.cells("a8").attachTree();
                tree8.setSkin("dhx_skyblue");
                tree8.setImagePath("pics/icons/");
                tree8.enableTreeImages(true);
                tree8.enableTreeLines(true);
                tree8.attachEvent("onClick",
                        function (id)
                        {
                            if (tree8.getUserData(id, "href") != undefined)
                                if (tree8.getUserData(id, "href") != null && tree8.getUserData(id, "href") == "SICMOR0200H") {
                                    window.open('https://aplicpm.prosa.com.mx/det/acceso.jsp?nombreReporte=sicmor0200b&uid=' + '<%=usuario%>');
                                } else if (tree8.getUserData(id, "href") != null && tree8.getUserData(id, "href") == "SICMOR0300H") {
                                    window.open('https://aplicpm.prosa.com.mx/det/acceso.jsp?nombreReporte=sicmor0300b&uid=' + '<%=usuario%>');
                                } else if (tree8.getUserData(id, "href") != null && tree8.getUserData(id, "href") == "SICMOR0330H") {
                                    window.open('https://aplicpm.prosa.com.mx/det/acceso.jsp?nombreReporte=sicmor0330&uid=' + '<%=usuario%>');
                                } else
                                    // cambioPagina(tree8.getUserData(id,"href"),"rightPanel");
                                    /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
                                    cambioPaginaModulo(tree8.getUserData(id, "href"), tree8.getUserData(id, "modulo"), "rightPanel");
                            /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
                        });
            <%
    path= session.getServletContext().getRealPath("/");

  xml = new File(path + "/scripts/dhtmlxTree/common/ReportesRLQ.xml" );
  fts = new FtS();
  xmlString = fts.fileToString(xml).replaceAll("\"", "\\\\\"");
            %>
                var xmlcatalogo = '<%= xmlString%>';
                tree8.loadXMLString(xmlcatalogo, function ()
                {
                    var x = tree8.getAllSubItems("0").split(",");
                    for (i = 0; i < x.length; i++) {
                        if (tree8.getUserData(x[i], "rolAccMin") != undefined) {
                            var val = tree8.getUserData(x[i], "rolAccMin");
                            var rolVal =<%=session.getAttribute("rolAccVal")%>
                            if (val >= rolVal)
                                tree8.deleteItem(x[i]);
                        }
                    }

                });
            <%
/*----------------------------------------------------------------------------*/
/* Marca del Cambio: AXIA-GGB-P-53-2933-14 Termina la Modificacion 25/05/2015 */
/*----------------------------------------------------------------------------*/
            %>

            }
        </script>
    </body>
</html>
