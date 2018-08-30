<%@page import="com.wellcom.prosa.sacii.Table"%><%
/*###############################################################################
# Nombre del Programa :  detailsSICMOR205Header.jsp                            #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-08-2253-12                	   FECHA:27/08/2012     #
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
# Autor               : German Gonzalez                             #
# Compania            :  WELLCOM                                      #
# Proyecto/Procliente :  N-04-2207-13             Fecha:  08/05/2013        #
# Modificación        : Adicionar Indicadores ABM                       #
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                                  #
# Autor               : German Gonzalez                                         #
# Compania            : WELLCOM                                                 #
# Proyecto/Procliente : N-51-2098-14                 Fecha: 06-05-2015          #
# Modificación        : Nuevos Token Full MV                                    #
#-----------------------------------------------------------------------------  #  
#								MODIFICACIONES                                  #  
# Autor               :  Laura Maleni Ramirez Vazquez                           #  
# Compania            :  SAS				                                    #  
# Proyecto/Procliente :  N-51-2390-15               Fecha: 07/04/2016           #  
# Modificación        :  Modificacion del token B2 y B3- y token r4             #  
#------------------------------------------------------------------------------#
# Autor               :  Daniel Ramirez Torres                                 #
# Compania            :  SAS S.A. DE C.V.                                      #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 01/03/2017        #
# Modificacion        :  Mejora Conexiones  SAC2                               #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                  #
#------------------------------------------------------------------------------#     
#								MODIFICACIONES #  
# Autor               :  Laura Maleni Ramirez Vazquez                           #  
# Compania            :  SAS S.A DE C.V.	                                #  
# Proyecto/Procliente :  N-51-2823-15                Fecha: 11/07/2017          #  
# Modificación        :  Implementación del Log de autorización Token CZ        #  
#-----------------------------------------------------------------------------  #  
################################################################################*/

%>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%@ page import="com.wellcom.io.*" %>
<%@ page import="java.util.ArrayList" %>
<%
    if(!ga.AccessGranted(session, "grantAccess"))
    {
        response.sendRedirect("login.jsp");
    }
   
    String dataElement[] = null;
    ArrayList cbValues = (ArrayList)session.getAttribute("ValuesSICMOR0205");
    String numfil = request.getParameter("numFil");
    int element = Integer.parseInt(numfil);
    dataElement = (String[])cbValues.get(element);    
    System.out.println("Checar dataElement: "+dataElement);
    System.out.println("Checar dataElement lenght: "+dataElement.length);
    HTML inputText;
    session.setAttribute("mostrarTabla","true");
    
    
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>SAC2 - REPORTES</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css">
        <script type="text/javascript">
            function imprimirInformacion() {
                var c, tmp;
                c = document.getElementById('printDiv');
                tmp = window.open(" ", "impresion");
                tmp.document.open();
                tmp.document.write("<head>");
                tmp.document.write("<link href=\"css/print.css\" rel=\"stylesheet\" type=\"text/css\"/>");
                tmp.document.write("</head>");
                tmp.document.write("<body>");
                tmp.document.write(c.innerHTML);
                tmp.document.write("</body>");
                tmp.document.close();
                tmp.print();
                tmp.close();
            }
        </script>
    </head>

    <body>
        <div id="printDiv" align="center">
            <form  method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
                <!-- Inicia Marca de Cambio N-51-2098-14 06-05-2015 -->
                <table width="100%" border="0" cellspacing="0" id="tabla" >
                    <tr>
                        <td width="35%" rowspan="3"><img src="pics/Carnet_header.jpg"></td>
                        <td colspan="4" align="center"><b>PROMOCION Y OPERACION S.A. DE C.V.</b></td>
                        <td colspan="3" align="right"><b>Fecha de Proceso: <%=session.getAttribute("fechaHoy")%></b></td>
                    </tr>
                    <tr>
                        <td colspan="4" align="center"><b>Reporte LOG de Autorizaciones</b></td>
                        <td colspan="3" align="right"><b>Hora de Proceso:<%=session.getAttribute("horaHoy")%></b></td>
                    </tr>
                    <tr>
                        <td colspan="4" align="center"><b>Fecha del:  <%=session.getAttribute("FechaInicial")%>  al:  <%=session.getAttribute("FechaFinal")%></b></td>
                        <td colspan="3" align="right"><b>Pagina  1  de  1</b></td>
                    </tr>
                    <tr>
                        <td colspan="8"><hr width="100%" size="2" color="#C0C0C0"><br/></td>
                    </tr>
                    <tr>
                        <td align="left" colspan="4">FIID Adq:
                            <% 
            inputText = new HTML();
            out.println( "" + inputText.getinputLabel("FiidAdq",dataElement[26])); 
                            %>
                        </td>
                        <td align="left" colspan="4">Afiliación:
                            <% 
                    inputText = new HTML();
                    out.println( "" + inputText.getinputLabel("Afiliacion",dataElement[27])); 
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="4">Banco Adq:
                            <% 
                    inputText = new HTML();
                    out.println( "" + inputText.getinputLabel("BancoAdq",dataElement[1])); 
                            %>
                        </td>
                        <td align="left" colspan="4">Comercio:
                            <% 
                    inputText = new HTML();
                    out.println( "" + inputText.getinputLabel("Comercio",dataElement[28])); 
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="8">Red logica Adq:
                            <% 
                    inputText = new HTML();
                    out.println( "" + inputText.getinputLabel("RedLogAdq",dataElement[29])); 
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="8"><hr width="100%" size="2" color="#C0C0C0"><br/></td>
                    </tr>
                    <tr>
                        <td align="left">Numero:</td>
                        <td width="8%"><% 
                                            inputText = new HTML();
                                            out.println( "" + inputText.getinputLabel("Numero",dataElement[0])); 
                            %></td>
                        <td width="7%"></td>
                        <td width="11%" align="left">Red Logica Emi:</td>
                        <td colspan="2"><% 
                                            inputText = new HTML();
                                            out.println( "" + inputText.getinputLabel("RedLogEmi",dataElement[30])); 
                            %></td>
                        <td width="5%" align="left">Modo de Entrada:</td>
                        <td width="14%" colspan="2"><% 
                        inputText = new HTML();
                        out.println( "" + inputText.getinputLabel("ModEnt",dataElement[12])); 
                            %></td>
                    </tr>
                    <tr>
                        <td align="left">Adquirente:</td>
                        <td colspan="2"><% 
                                            inputText = new HTML();
                                            out.println( "" + inputText.getinputLabel("NomAdq",dataElement[31])); 
                            %></td>
                        <td align="left">Clave Tx:</td>
                        <td colspan="2"><% 
                        inputText = new HTML();
                        out.println( "" + inputText.getinputLabel("ClaveTx",dataElement[7])); 
                            %></td>
                        <td align="left">Tipo Cap:</td>
                        <td><% 
                        inputText = new HTML();
                        out.println( "" + inputText.getinputLabel("TipoCap",dataElement[13])); 
                            %></td>
                    </tr>
                    <tr>
                        <td align="left">Emisor:</td>
                        <td colspan="2"><% 
                                            inputText = new HTML();
                                            out.println( "" + inputText.getinputLabel("NomEmi",dataElement[32])); 
                            %></td>
                        <td align="left">Clave Tipo Tx:</td>
                        <td colspan="2"><% 
                        inputText = new HTML();
                        out.println( "" + inputText.getinputLabel("ClaveTipTx",dataElement[8])); 
                            %></td>
                        <td align="left">Ind EMV:</td>
                        <td><% 
                        inputText = new HTML();
                        out.println( "" + inputText.getinputLabel("indEmv",dataElement[14])); 
                            %></td>
                    </tr>
                    <tr>
                        <td align="left">Fuente:</td>
                        <td colspan="2"><% 
                                            inputText = new HTML();
                                            out.println( "" + inputText.getinputLabel("Fuente",dataElement[3])); 
                            %></td>
                        <td align="left">Autorización:</td>
                        <td colspan="2"><% 
                        inputText = new HTML();
                        out.println( "" + inputText.getinputLabel("NumAutorizacion",dataElement[9])); 
                            %></td>
                        <td align="left">Terminal Capability:</td>
                        <td><% 
                        inputText = new HTML();
                        out.println( "" + inputText.getinputLabel("TermCap",dataElement[15])); 
                            %></td>
                    </tr>
                    <tr>
                        <td align="left">Proc:</td>
                        <td colspan="2"><% 
                                            inputText = new HTML();
                                            out.println( "" + inputText.getinputLabel("Proc",dataElement[4])); 
                            %></td>
                        <td align="left">Importe:</td>
                        <td colspan="2"><% 
                        inputText = new HTML();
                        out.println( "" + inputText.getinputLabel("Importe",dataElement[10])); 
                            %></td>
                        <td align="left">Cod ISO:</td>
                        <td><% 
                        inputText = new HTML();
                        out.println( "" + inputText.getinputLabel("ISO",dataElement[16])); 
                            %></td>
                    </tr>
                    <tr>
                        <td align="left">FIID Emisora:</td>
                        <td colspan="2"><% 
                                            inputText = new HTML();
                                            out.println( "" + inputText.getinputLabel("FiidEmi",dataElement[33])); 
                            %></td>
                        <td align="left">Fecha Origen:</td>
                        <td colspan="2"><% 
                                             inputText = new HTML();
                                             out.println( "" + inputText.getinputLabel("FechaOrigen",dataElement[11])); 
                            %></td>
                        <td align="left">ICE:</td>
                        <td><% 
                        inputText = new HTML();
                        out.println( "" + inputText.getinputLabel("ICE",dataElement[17])); 
                            %></td>
                    </tr>
                    <tr>
                        <td align="left">Cuenta:</td>
                        <td colspan="7"><% 
                        inputText = new HTML();
                        out.println( "" + inputText.getinputLabel("Cuenta",dataElement[6])); 
                            %></td>
                    </tr>
                    <tr>
                        <td colspan="8"><hr width="100%" size="2" color="#C0C0C0"><br/></td>
                    </tr>
                    <tr>
                        <td align="left" colspan="8"><b>Tokens ABM:</b></td>
                    </tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr>
                        <td align="left" colspan="3"><b>Token Q1: ID EN RESP MODO AUTORIZACIÓN</b></td>
                        <td align="left" colspan="5"><b>Token Q2: ID MEDIO DE ACCESO</b></td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s1[01] Id modo de autorización:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenQ1",dataElement[34])); 
                            %>
                        </td>
                        <td align="left" colspan="4">s1[02] Medio de Acceso:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenQ2",dataElement[36])); 
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s2[01] Modo validación criptograma:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenQ1",dataElement[35])); 
                            %>
                        </td>
                        <td align="left" colspan="5"></td>
                    </tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr>
                        <td align="left" colspan="3"><b>Token C0: CÓDIGO DE VALIDACIÓN</b></td>
                        <td align="left" colspan="5"><b>Token C4: DATOS DEL PUNTO DE SERVICIO O TERMINAL</b></td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s1[04] Codigo de validación:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC0",dataElement[37])); 
                            %>
                        </td>
                        <td align="left" colspan="4">s1[01] Terminal atendida por Adq:</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC4",dataElement[49])); 
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s2[01] Estatus de Retransmisión:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC0",dataElement[38])); 
                            %>
                        </td>
                        <td align="left" colspan="4">s2[01] TERM-OPER-IND</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC4",dataElement[50])); 
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s3[03] Contador de Retransmisión:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC0",dataElement[39])); 
                            %>
                        </td>
                        <td align="left" colspan="4">s3[01] Localización de la Terminal:</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC4",dataElement[51])); 
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s4[10] Código Postal de comercio:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC0",dataElement[40])); 
                            %>
                        </td>
                        <td align="left" colspan="4">s4[01] Presencia del TH:</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC4",dataElement[52])); 
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s5[01] Indicador de Comercio Electr&oacute;nico:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC0",dataElement[41])); 
                            %>
                        </td>
                        <td align="left" colspan="4">s5[01] Presencia de Tarjeta:</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC4",dataElement[53])); 
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s6[01] Tipo de Tarjeta:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC0",dataElement[42])); 
                            %>
                        </td>
                        <td align="left" colspan="4">s6[01] Capacidad captura de tarjeta:</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC4",dataElement[54])); 
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s7[01] Indicador Información adicional:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC0",dataElement[43])); 
                            %>
                        </td>
                        <td align="left" colspan="4">s7[01] Estatus:</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC4",dataElement[55])); 
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s8[01] Indicador CV 2 presente:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC0",dataElement[44])); 
                            %>
                        </td>
                        <td align="left" colspan="4">s8[01] Nivel Seguridad del Adq:</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC4",dataElement[56])); 
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s9[01] Transacción forzada (preventa):</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC0",dataElement[45])); 
                            %>
                        </td>
                        <td align="left" colspan="4">s9[01] Routing:</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC4",dataElement[57])); 
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s10[01] Indicador de colector de autenticación:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC0",dataElement[46])); 
                            %>
                        </td>
                        <td align="left" colspan="4">s10[01] Activación de la terminal por el TH:</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC4",dataElement[58])); 
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s11[01] Propensión de fraude:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC0",dataElement[47])); 
                            %>
                        </td>
                        <td align="left" colspan="4">s11[01] Terminal:</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC4",dataElement[59])); 
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s12[04] Resultado validación CAV V:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC0",dataElement[48])); 
                            %>
                        </td>
                        <td align="left" colspan="4">s12[01] Método identificación TH:</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC4",dataElement[60])); 
                            %>
                        </td>
                    </tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr>
                        <td align="left" colspan="3"><b>Token 04: VALIDACIÓN TOKEN C0</b></td>
                        <td align="left" colspan="5"><b>Token Q6: PAGOS DIFERIDOS</b></td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s1[01] Bandera error información adicional tx:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("Token04",dataElement[61])); 
                            %>
                        </td>
                        <td align="left" colspan="4">s1[02] Diferimiento:</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenQ6",dataElement[67])); 
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s2[11] Grupo de ruteo:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("Token04",dataElement[62])); 
                            %>
                        </td>
                        <td align="left" colspan="4">s2[02] Números de pago:</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenQ6",dataElement[68])); 
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s3[01] Bandera error información adicional tx:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("Token04",dataElement[63])); 
                            %>
                        </td>
                        <td align="left" colspan="4">s3[02] Tipo de plan:</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenQ6",dataElement[69])); 
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s4[05] Extensión de la ciudad:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("Token04",dataElement[64])); 
                            %>
                        </td>
                        <td align="left" colspan="5"></td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s5[01] Contenido del track 1 o track 2:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("Token04",dataElement[65])); 
                            %>
                        </td>
                        <td align="left" colspan="5"></td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s6[01] Archivo de cumulación de usos:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("Token04",dataElement[66])); 
                            %>
                        </td>
                        <td align="left" colspan="5"></td>
                    </tr>				
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr>
                        <td align="left" colspan="3"><b>Token B2: REQUEST DATA TOKEN</b></td>
                        <td align="left" colspan="5"><b>Token B3:EMV DISCRETIONARY TOKEN</b></td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s3[02] Cryptogram Information Data:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB2",dataElement[74])); 
                            %>
                        </td>
                        <td align="left" colspan="4">s2[08] IFD - Interface Device Number:</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB3",dataElement[87])); 
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s4[10] TVR - Terminal Verification Results:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB2",dataElement[75])); 
                            %>
                        </td>
                        <td align="left" colspan="4">s3[08] EMV Terminal Capabilities:</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB3",dataElement[90])); 
                            %>
                        </td>
                    </tr>
                    <!--Marca INICIO de modificación -N-51-2823-15_LMRV -->
                    <tr>
                        <td style="padding-left:20px" colspan="2">s4.b3 [01] TVR - PIN Bypass:</td>				
                        <td >
                            <% 
                            inputText = new HTML();
                            out.println( "" + inputText.getinputLabel("TokenB2",dataElement[112])); 
                            %>
                        </td>
                    <!--Marca TERMINO de modificación -N-51-2823-15_LMRV -->
						<td align="left" colspan="4">s6[02] EMV Terminal Type:</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB3",dataElement[89])); 
                            %>
                        </td>
					</tr>
                    <tr>
                    <!--Marca INICIO de modificación -N-51-2823-15_LMRV -->
                        <td style="padding-left:20px" colspan="2">s4.b3 [01] TVR - QPS sin PIN:</td>	
					<td >
                            <% 
                            inputText = new HTML();
                            out.println( "" + inputText.getinputLabel("TokenB2",dataElement[113])); 
                            %>
                        </td>
                    <!--Marca TERMINO de modificación -N-51-2823-15_LMRV -->
						<td align="left" colspan="4">s7[04] Application Version Number:</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB3",dataElement[89])); 
                            %>
                        </td>	
					</tr>
					<tr>
                        <td align="left" colspan="3">s5[16] ARQC - The authorization request cryptogram:</td>
                        <td align="left" colspan="4">s8[06] CVM Results:</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB3",dataElement[91])); 
                            %>
                        </td>
                        </tr>
                        <tr>
                        <td align="left" colspan="8">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB2",dataElement[76])); 
                            %>
                        </td>
					
                        
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s6[12] Authorized Amount:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB2",dataElement[77])); 
                            %>
                        </td>
					 <td align="left" colspan="4">s10[32] Dedicated file name / Application ID:</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB3",dataElement[92])); 
                            %>
                        </td>	
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s7[12] Secondary Amount:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB2",dataElement[78])); 
                            %>
                        </td>
                        
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s8[04] AIP - Application Interchange Profile:</td>
                        <td align="left" >
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB2",dataElement[79])); 
                            %>
                        </td>
                       
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s9[04] ATC - Application transaction counter:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB2",dataElement[80])); 
                            %>
                        </td>

                    </tr>
                    <tr>
                        <td align="left" colspan="2">s10[03] Terminal Country Code:</td>
                        <td align="left" colspan="6">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB2",dataElement[81])); 
                            %>
                        </td>

                    </tr>
                    <tr>
                        <td align="left" colspan="2">s11[03] Transaction Currency Code:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB2",dataElement[82])); 
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s12[06] Transaction Date:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB2",dataElement[83])); 
                            %>
                        </td>
                        <td align="left" colspan="5"></td>					
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s13[02] Transaction Type:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB2",dataElement[84])); 
                            %>
                        </td>
                        <td align="left" colspan="5"></td>					
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s14[08] Unpredictable Number:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB2",dataElement[85])); 
                            %>
                        </td>
                        <td align="left" colspan="5"></td>					
                    </tr>
                    <tr>
                        <td align="left" colspan="8">s16[64] Issuer Application Data:</td>					
                    </tr>
                    <tr>
                        <td align="left" colspan="8">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB2",dataElement[86])); 
                            %>
                        </td>
                    </tr>

                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr>
                        <td align="left" colspan="3"><b>Token B4: STATUS TOKEN</b></td>
                        <td align="left" colspan="5"><b>Token B5:RESPONSE DATA TOKEN</b></td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s1[03] POS Entry Mode:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB4",dataElement[93])); 
                            %>
                        </td>
                        <td align="left" colspan="4">s1[04] Issuer Authoritation Data Length:</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB5",dataElement[102])); 
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s2[01] Terminal Entry Capability:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB4",dataElement[94])); 
                            %>
                        </td>
                        <td align="left" colspan="4">s2[16] ARPC - Authorization Response Cryptogram:</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB5",dataElement[103])); 
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s3[01]&nbsp; Last EMV Status:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB4",dataElement[95])); 
                            %>
                        </td>
                        <td align="left" colspan="4">s3[16] Additional Issuer Authentication Data:</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB5",dataElement[104])); 
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s4[01] Data Suspect:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB4",dataElement[96])); 
                            %>
                        </td>
                        <td align="left" colspan="4">s4[01] Send Card Block:</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB5",dataElement[105])); 
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s5[02] PAN Sequence Number:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB4",dataElement[97])); 
                            %>
                        </td>
                        <td align="left" colspan="4">s5[01] Send Put Data:</td>
                        <td align="left" colspan="1">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB5",dataElement[106])); 
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s6[06] Device Information:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB4",dataElement[98])); 
                            %>
                        </td>
                        <td align="left" colspan="5"></td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s7[04]Reason Online Code:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB4",dataElement[99])); 
                            %>
                        </td>
                        <td align="left" colspan="5"></td>					
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s8 [01] ARQC Verify:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB4",dataElement[100])); 
                            %>
                        </td>
                        <td align="left" colspan="5"><b>Token CZ: DEVICE TYPE INDICATOR</b></td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s9[01] ISO Response Code Indicator:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenB4",dataElement[101])); 
                            %>
                        </td>
                        <!--Marca INICIO de modificación -N-51-2823-15_LMRV -->
                        <td align="left" colspan="4">s2 [02] Cardholder Device Type:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenCZ",dataElement[114])); 
                            %>
                        </td>
                        <!--Marca TERMINO de modificación -N-51-2823-15_LMRV -->					
                    </tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr>
                        <td align="left" colspan="8"><b>Token C6: DATOS DE AUTENTICACIÓN DEL CAAV</b></td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s1[40] XID:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC6",dataElement[70])); 
                            %>
                        </td>
                        <td align="left" colspan="5"></td>					
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s2[40] CAV V:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenC6",dataElement[71])); 
                            %>
                        </td>
                        <td align="left" colspan="5"></td>					
                    </tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr>
                        <td align="left" colspan="8"><b>Token CE: DATOS DE AUTENTICACIÓN DEL AAV</b></td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s1[40] XID:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenCE",dataElement[72])); 
                            %>
                        </td>
                        <td align="left" colspan="5"></td>					
                    </tr>
                    <tr>
                        <td align="left" colspan="2">s2[40] AVV:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputLabel("TokenCE",dataElement[73])); 
                            %>
                        </td>
                        <td align="left" colspan="5"></td>					
                    </tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <tr><td align="left" colspan="8">   </td></tr>
                    <!--Marca Inicio de modificación -N-51-2390-15 SAS -->
                    <tr>
                        <td align="left" colspan="8"><b>Análisis PIN</b></td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2" >TVR- Bandera de Verificación del tarjetahabiente (B2 sub4 - Byte3)</td>
                        <td align="left" colspan="6">
                            <% 
                                    inputText = new HTML();
                                                out.println( "" + inputText.getinputLabel("TokenB2",dataElement[107])); 
			
                            %>

                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2" >CVR- Verificación realizada de PIN Off-line (B2 sub16 - Byte1-2)</td>
                        <td align="left" colspan="6">
                            <% 
                                    inputText = new HTML();
                                                            out.println( "" + inputText.getinputLabel("TokenB2",dataElement[108]));
                            %>

                        </td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2" >CVR- Verificación PIN Off-line (B2 sub16 - Byte1-2):</td>
                        <td align="left" colspan="6">
                            <% 
                                    inputText = new HTML();
                                                            out.println( "" + inputText.getinputLabel("TokenB2",dataElement[109]));
                            %>

                        </td>
                    </tr> 
                    <tr> 
                        <td align="left" colspan="2">CVMR -CVM Realizado (B3 sub8 - Byte1)</td>
                        <td align="left" colspan="6">
                            <% 
                                    inputText = new HTML();
                                                            out.println( "" + inputText.getinputLabel("TokenB3",dataElement[110])); 
                            %>
                        </td>
                    </tr>  
                    <tr>
                        <td align="left" colspan="2">CVMR Resultado (B3 sub8 - Byte3)</td>
                        <td align="left" colspan="6">
                            <% 
                                    inputText = new HTML();
                                                            out.println( "" + inputText.getinputLabel("TokenB3",dataElement[111])); 
                            %>
                        </td>
                    </tr>
                    <!--<tr>
                                             <td align="left" colspan="8"><b>Token R4</b></td>
                                             <tr>
                                             <td align="left" colspan="2" >Número de Congtracargo y Cargo Recurente </td>
                                             <td align="left" colspan="6">
                         </td>
                                     </tr>-->
                    <!--Fin de modificación -N-51-2390-15 SAS-->
                    <tr>
                        <td colspan="8"><hr width="100%" size="1" color="#000000"><br/></td>
                    </tr>				
                    <tr>
                        <td colspan="4" align="left" >SICMOR0205<br/></td>
                        <td colspan="4" align="right">Usuario:<%=session.getAttribute("login")%></td>
                    </tr>
                    <tr>				
                        <td colspan="1">
                            <div align="left"><input align="left" type="button" onclick="javascript:imprimirInformacion();" value="Imprimir"></input></div>
                        </td>
                        <td colspan="6"></td>
                        <td colspan="1">
                            <div>
                                <!--Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación -->
                                <p align="left" style="font-size: 12px;font-weight: bold;cursor: pointer;cursor: hand;font-weight: bold;color: blue;text-decoration: underline;" onclick="cambioPaginaReload('ControllerServletMonitoreo?action=SICMOR0205&mostrarTabla=true&p=a1', 'rightPanel');">Regresar</p>
                                <!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación -->
                            </div>
                        </td>
                    </tr>
                </table>
                <!-- Fin Marca de Cambio N-51-2098-14 06-05-2015 -->
            </form>
        </div>
    </body>
</html>
