<%@page import="com.wellcom.prosa.sacii.Table"%><%
/*###############################################################################
# Nombre del Programa :  detailsSICMOFB100Header.jsp                            #
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
#------------------------------------------------------------------------------#
# Autor               :  Daniel Ramirez Torres                                 #
# Compania            :  SAS S.A. DE C.V.                                      #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 01/03/2017        #
# Modificacion        :  Mejora Conexiones  SAC2                               #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                  #
#------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
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
    ArrayList cbValues = (ArrayList)session.getAttribute("ValuesSICMOFB100");
    String numfil = request.getParameter("numFil");
    int element = Integer.parseInt(numfil);
    dataElement = (String[])cbValues.get(element);
    HTML inputText;
    session.setAttribute("mostrarTabla","true");
    
    
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>SACIIRPT - REPORTES</title>
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
                <table width="100%" border="0" cellspacing="0" id="tabla" >
                    <tr>
                        <th id="tituloTab" width="100%" colspan="8" align="left"><font color="#000000">SICMOFB100 Consulta de Transacciones Aceptadas</font></th>
                    </tr>

                    <tr>
                        <td colspan="5"><br/></td>
                    </tr>

                    <tr>
                        <td align="left">Archivo:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("archivo",dataElement[2],40,40)); 
                            %>
                        </td>

                        <td align="left">Fecha Consumo:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("fechaConsumo",dataElement[3],10,10)); 
                            %>
                        </td>

                        <td align="left">Fecha Proceso:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("fechaProceso",dataElement[4],10,10)); 
                            %>
                        </td>

                        <td align="left">Nacional:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("nacional",(dataElement[52].equals("1"))?"S":"N",3,3)); 
                            %>
                        </td>
                    </tr>

                    <tr>
                        <td align="left" colspan="1">Fuente:</td>
                        <td align="left" colspan="3">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("fuente",dataElement[0]+" "+dataElement[1],45,45)); 
                            %>
                        </td>

                        <td align="left" colspan="2">Procedencia:</td>
                        <td align="left" colspan="2">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("procedencia",dataElement[43],10,10)); 
                            %>
                        </td>
                    </tr>

                    <tr>
                        <td align="left" colspan="1">Banco Adquiriente:</td>
                        <td align="left" colspan="2">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("bancoAdq",dataElement[5]+" "+dataElement[6]+" "+dataElement[7],45,45)); 
                            %>
                        </td>

                        <td align="right" >Banco Emisor:</td>
                        <td align="left" colspan="2">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("bancoEmi",dataElement[8]+" "+dataElement[9]+" "+dataElement[10],45,45)); 
                            %>
                        </td>				
                    </tr>

                    <tr>
                        <td align="left">No. de Autorización:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("noAutorizacion",dataElement[11],10,10)); 
                            %>
                        </td>

                        <td align="right" colspan="2">No. de Referencia:</td>
                        <td align="left" colspan="2">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("noReferencia",dataElement[12],25,25)); 
                            %>
                        </td>

                        <td align="left">No. de Cuenta:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("noCuenta",dataElement[13],19,19)); 
                            %>
                        </td>
                    </tr>

                    <tr>
                        <td align="left">No. de Comercio:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("noComercio",dataElement[16],10,10)); 
                            %>
                        </td>

                        <td align="left" colspan="2">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("noComercio1",dataElement[17],25,25)); 
                            %>
                        </td>

                        <td align="left">Terminal:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("terminal",dataElement[39],10,10)); 
                            %>
                        </td>

                        <td align="left">Modo Pos:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("modoPos",dataElement[23],3,3)); 
                            %>
                        </td>
                    </tr>

                    <tr>
                        <td align="left">Categoría:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("categoria",dataElement[24],3,3)); 
                            %>
                        </td>

                        <td align="left">Débito:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("debito",dataElement[41],3,3)); 
                            %>
                        </td>

                        <td align="left">% IVA:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("iva",dataElement[42],3,3)); 
                            %>
                        </td>

                        <td align="left">Vigencia:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("vigencia",dataElement[40],3,3)); 
                            %>
                        </td>
                    </tr>

                    <tr>
                        <td align="left">Importe Transac:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("importeTransac",dataElement[19],9,9)); 
                            %>
                        </td>
                        <td align="left">Codigo Moneda Destino:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("moneda",dataElement[59],4,4)); 
                            %>
                        </td>
                    </tr>

                    <tr>
                        <td align="left">Factor com.:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("factorComercial",dataElement[25],3,3)); 
                            %>
                        </td>

                        <td align="left"> Cuota:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("cuotaCom",dataElement[53],3,3)); 
                            %>
                        </td>
                        <td align="left">Imp:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("impCom",dataElement[54],3,3)); 
                            %>
                        </td>
                        <td align="left">IVA:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("ivaCom",dataElement[28],3,3)); 
                            %>
                        </td>
                    </tr>

                    <tr>
                        <td align="left">Factor int.:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("factorIntercambio",dataElement[26],3,3)); 
                            %>
                        </td>

                        <td align="left">Cuota:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("cuotaInt",dataElement[27],3,3)); 
                            %>
                        </td>
                        <td align="left">Imp:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("impInt",dataElement[20],3,3)); 
                            %>
                        </td>                     
                        <td align="left">IVA:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("ivaInt",dataElement[21],3,3)); 
                            %>
                        </td>
                    </tr>

                    <tr>
                        <td align="left">Cuenta de Cheques:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("cuentaCheques",dataElement[29],10,16)); 
                            %>
                        </td>


                        <td align="left" >Ruteo:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("ruteo",dataElement[30],3,3)); 
                            %>

                        </td>
                    </tr>

                    <tr>
                        <td align="left" >Marca:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("marca",dataElement[31],3,3)); 
                            %>

                        </td>

                        <td align="left" >Respuesta:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("respuesta",dataElement[44],3,3)); 
                            %>                	
                        </td>

                        <td align="left" >Codigo:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("codigo",dataElement[37],3,3)); 
                            %>                	
                        </td>

                        <td align="left" >Liquidación:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("liquidacion",dataElement[32],3,3)); 
                            %>                	
                        </td>
                    </tr>

                    <tr>
                        <td align="left" >Ind. EMV:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("indiceEMV",dataElement[55],3,3)); 
                            %>                	
                        </td>

                        <td align="left" >TERM. CAPAB. EMV:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("termCAPAB",dataElement[49],3,3)); 
                            %>                	
                        </td>

                        <td align="left" >ISO:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("ISO",dataElement[46],3,3)); 
                            %>                	
                        </td>
                        <td align="left" >Tipo Trx.:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("tipoTrx",dataElement[15],25,25)); 
                            %>                	
                        </td>
                    </tr>


                    <tr>
                        <td align="left" >Prefijo:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("Prefijo",dataElement[22],3,3)); 
                            %>                	
                        </td>

                        <td align="left" >Red Lóg. Adq.:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("RedLogAdq",dataElement[33],3,3)); 
                            %>                	
                        </td>

                        <td align="left" >Red Lóg. Emi:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("RedLogEmi",dataElement[34],3,3)); 
                            %>                	
                        </td>
                    </tr>


                    <tr>


                        <td align="left" >Term. Cap.:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("TermCap",dataElement[38],3,3)); 
                            %>                	
                        </td>
                        <td align="left" >TC:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("TC",dataElement[57],3,3)); 
                            %>                	
                        </td>
                        <td align="left" >Typ:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("Typ",dataElement[58],3,3)); 
                            %>                	
                        </td>
                    </tr>
                    <tr>

                        <td align="left" >Tarifa/Tasa:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("HoraConsumo",dataElement[50],7,7)); 
                            %>                	
                        </td>

                        <td align="left" >ICE:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("TermCap",dataElement[51],3,3)); 
                            %>                	
                        </td>
                        <td align="left" >Tipo Captura:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("TermCap",dataElement[45],3,3)); 
                            %>                	
                        </td>
                        <td align="left" >Pagos Diferidos:</td>
                        <td align="left">
                            <% 
                                    inputText = new HTML();
                                    out.println( "" + inputText.getinputTextBlock("pagDif",dataElement[56],2,2)); 
                            %>                	
                        </td>
                    </tr>
                    <tr>
                        <td colspan="8"><br/></td>
                    </tr>
                    <tr>				
                        <td colspan="4">
                            <div align="left"><input align="left" type="button" onclick="javascript:imprimirInformacion();" value="Imprimir"></input></div>
                        <td colspan="4">
                            <div>
                                <!--Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación -->
                                <p align="left" style="font-size: 12px;font-weight: bold;cursor: pointer;cursor: hand;font-weight: bold;color: blue;text-decoration: underline;" onclick="cambioPaginaReload('ControllerServletAdquirente?action=SICMOFB100&mostrarTabla=true&p=a1', 'rightPanel');">Regresar</p>
                                <!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación -->
                            </div>
                        </td>

                    </tr>

                </table>

            </form>
        </div>
    </body>
</html>
