<%@page contentType="text/html; charset=iso-8859-1"%>
<%@page import="java.io.File"%>
<%@page import="com.wellcom.io.FtS"%>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>

<%
/*
#-----------------------------------------------------------------------------#
# Autor               : Salvador Montiel                                      #
# Compania            : AM Estudio                                            #
# Proyecto/Procliente : P-54-2940-14               Fecha: 23/04/2015          #
# Modificacion        : Soporte Interactivo (FAQs,Tutoriales,Manuales)        #
# Marca del Cambio    : P-54-2940-14 AMEstudio 23.04.2015                     #
#-----------------------------------------------------------------------------#
# Autor               :  Daniel Ramírez Torres                                #
# Compania            :  SAS S.A. DE C.V.                                     #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017       #
# Modificacion        :  Mejora Conexiones  SAC2                              #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                 #
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
        System.out.println("Permisos: " + " emisor: "+ emi + " adquirente: " + adq + " interred: " + inte + " Posicion: " + posicion);
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
                dhxAccord.closeItem("a9");


                dhxAccord.addItem("a1", "Reportes");
                dhxAccord.setIcon("a1", "reportes3.png");
                dhxAccord.closeItem("a1");

//Marca inicio:  P-54-2940-14 AMEstudio 23.04.2015  
                dhxAccord.addItem("a7", "Soporte interactivo");
                dhxAccord.setIcon("a7", "soporte.png");
                dhxAccord.closeItem("a7");
//Marca fin:  P-54-2940-14 AMEstudio 23.04.2015  

                dhxAccord.addItem("a2", "Herramientas");
                dhxAccord.setIcon("a2", "configuracion.png");
                dhxAccord.closeItem("a2");

                dhxAccord.addItem("a3", "Ayuda");
                dhxAccord.setIcon("a3", "ayuda.png");
                dhxAccord.closeItem("a3");

                dhxAccord.addItem("a4", "Salir");
                dhxAccord.setIcon("a4", "salir.png");
                dhxAccord.closeItem("a4");





                dhxAccord.attachEvent("onBeforeActive", function (itemId)
                {
                    var allow = (itemId != "a4");


                    if (dhxAccord.cells(itemId).getText() == 'Salir')
                        /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
                        window.location.href = "ControllerServletGen?action=Salir";
                    /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
                    return allow;
                });

                dhxAccord.attachEvent("onBeforeActive", function (itemId)
                {
                    if (dhxAccord.cells(itemId).getText() == 'Salir')
                        /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */
                        window.location.href = "ControllerServletGen?action=Salir";
                    /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */
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
                                window.location.href = "ControllerServlet?action=" + tree1.getUserData(id, "href") + "&p=a1";

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
                            if (tree2.getUserData(id, "href") != undefined)
                                window.location.href = "ControllerServlet?action=" + tree2.getUserData(id, "href") + "&p=a7";
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
//Marca fin:--------

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
                                window.location.href = "ControllerServlet?action=" + tree2.getUserData(id, "href") + "&p=a2";
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


                var tree3 = dhxAccord.cells("a3").attachTree();
                tree3.setSkin("dhx_skyblue");
                tree3.setImagePath("pics/icons/");
                tree3.enableTreeImages(true);
                tree3.enableTreeLines(true);
                tree3.attachEvent("onClick",
                        function (id)
                        {
                            /*if(id!="archivos")
                             {
                             var link ="ControllerServlet?action=" + tree3.getUserData(id,"href") + "&p=a3";
                             
                             if(id=="archivos_1")
                             {
                             link="ControllerServlet?action=" + tree3.getUserData(id,"href") + "&tarjetas=0&p=a3";
                             //alert("ControllerServlet?action=" + tree3.getUserData(id,"href") + "&tarjetas=0&p=a3");
                             }
                             else if (id=="archivos_2")
                             {	
                             link = "ControllerServlet?action=" + tree3.getUserData(id,"href") + "&tarjetas=1&p=a3";
                             //alert("ControllerServlet?action=" + tree3.getUserData(id,"href") + "&tarjetas=1&p=a3");
                             }
                             else if(id=="contraseñas")
                             {
                             link ="ControllerServlet?action=" + tree3.getUserData(id,"href") + "&vistaAdmin=false&p=a3";
                             //alert("ControllerServlet?action=" + tree3.getUserData(id,"href") + "&vistaAdmin=false&p=a3");
                             }*/
                            //if(tree3.getUserData(id,"href")!=undefined)									
                            //window.location.href="ControllerServlet?action=" + tree3.getUserData(id,"href") + "&p=a3";
                            //	if(id=="acerca")
                            //window.open(tree3.getUserData(id,"href"),"", "width=383,height=200,location=yes,resizable=no");
                            //else
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

                /* var tree4 = dhxAccord.cells("a4").attachTree();
                 tree4.setSkin("dhx_skyblue");
                 tree4.setImagePath("pics/icons/");
                 tree4.enableTreeImages(true);
                 tree4.enableTreeLines(true);
                 tree4.attachEvent("onClick", 
                 function(id)
                 {
                 window.location.href="ControllerServlet?action=" + tree4.getUserData(id,"href") + "&p=a4";
                 });
                 tree4.loadXML("/scripts/dhtmlxTree/common/Configuracion.xml");
                 
                 var tree5 = dhxAccord.cells("a5").attachTree();
                 tree5.setSkin("dhx_skyblue");
                 tree5.setImagePath("pics/icons/");
                 tree5.enableTreeImages(true);
                 tree5.enableTreeLines(true);
                 tree5.attachEvent("onClick", 
                 function(id)
                 {
                 window.location.href="ControllerServlet?action=" + tree5.getUserData(id,"href") + "&p=a5";
                 });
                 tree5.loadXML("/scripts/dhtmlxTree/common/Organizacion.xml");
                 
                 var tree6 = dhxAccord.cells("a6").attachTree();
                 tree6.setSkin("dhx_skyblue");
                 tree6.setImagePath("pics/icons/");
                 tree6.enableTreeImages(true);
                 tree6.enableTreeLines(true);
                 tree6.attachEvent("onClick", 
                 function(id)
                 {
                 if(id!="valeE" && id!="Rprepago")
                 window.location.href="ControllerServlet?action=" + tree6.getUserData(id,"href") + "&p=a6";
                 });
                 tree6.loadXML("/scripts/dhtmlxTree/common/Reportes.xml");
                 var tree7 = dhxAccord.cells("a7").attachTree();
                 tree7.setSkin("dhx_skyblue");
                 tree7.setImagePath("pics/icons/");
                 tree7.enableTreeImages(true);
                 tree7.enableTreeLines(true);
                 tree7.attachEvent("onClick", 
                 function(id)
                 {
                 if(id=="acerca")
                 window.open(tree7.getUserData(id,"href"),"", "width=383,height=200,location=yes,resizable=no");
                 else
                 window.open(tree7.getUserData(id,"href"),"", "width=1024,height=768,location=yes,resizable=yes");
                 });
                 tree7.loadXML("/scripts/dhtmlxTree/common/Ayuda.xml");	    
                 //OnLoadMenu();*/
            }
        </script>
    </body>
</html>