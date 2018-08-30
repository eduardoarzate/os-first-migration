<%
/*###############################################################################
# Nombre del Programa :  AMEX_CONC_Header.jsp                                   #
# Autor               :  Luis Eduardo Ramírez Castillo                          #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :                    	   FECHA: 28/07/2017            #
# Descripcion General :							        #
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :						                #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :							        #
#################################################################################
#								MODIFICACIONES  #
# Autor               :                                                         #
# Compania            :                                                         #
# Proyecto/Procliente :                              Fecha:                     #
# Modificación        :                                                         #
#-----------------------------------------------------------------------------  #
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<%@ page import="com.wellcom.io.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>
<%@page import="java.io.IOException"%>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%
        ArrayList cbTipoEpape;
		ArrayList cbIntValuesAdq;
        HTML comboBox;
        HTML inputText;
        ComboBoxGen myComboBox;
%>
<%
    if(!ga.AccessGranted(session, "grantAccess"))
    {
        response.sendRedirect("login.jsp");
    }
    if(session.getAttribute("numFiid").equals("") || !session.getAttribute("numFiid").equals("AMEX")  ){
    myComboBox = new ComboBoxGen(); 
        cbTipoEpape= myComboBox.getOpcionesEpape(session);	
		cbIntValuesAdq = myComboBox.getBancoAdqConsol(session);	
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>SAC 2</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css">

    </head>
    <script type="text/javascript">
        var span = null;
        var showTextInitDate = false;
        var showTextEndDate = false;
		var showTextBanco = false;
		var showTipoLiq = false;

        function valida()
        {
            try
            {
                if (showTextInitDate)
                {
                    span = document.getElementById("txtInitDate");
                    span.style.display = 'none';
                    showTextInitDate = false;
                } else if (showTextEndDate)
                {
                    span = document.getElementById('txtEndDate');
                    span.style.display = 'none';
                    showTextEndDate = false;
                }else if (showTextBanco) {
                    span = document.getElementById('txtBanco');
                    span.style.display = 'none';
                    showTextBanco = false;
                }else if (showTipoLiq) {
                    span = document.getElementById('txtTipoLiq');
                    span.style.display = 'none';
                    showTipoLiq = false;
                }

                if (document.frmTOCHeader.txtfStartDate.value == "" || document.frmTOCHeader.txtfStartDate.value == null)
                {
                    span = document.getElementById("txtInitDate");
                    span.style.display = 'inline';
                    showTextInitDate = true;
                    return false;
                } else if (document.frmTOCHeader.txtfEndDate.value == "" || document.frmTOCHeader.txtfEndDate.value == null)
                {
                    span = document.getElementById('txtEndDate');
                    span.style.display = 'inline';
                    showTextEndDate = true;
                    return false;
                }else if (document.frmTOCHeader.Adquirente.value == "None") {
                    span = document.getElementById('txtBanco');
                    span.style.display = 'inline';
                    showTextBanco = true;
                    return false;
                }else if (document.frmTOCHeader.tipoEpape.value == "None") {
                    span = document.getElementById('txtTipoLiq');
                    span.style.display = 'inline';
                    showTipoLiq = true;
                    return false;
                } else{
                    return true;
                }
            } catch (e)
            {

            }

        }
    </script>
    <body>
        <div align="center">
            <form action="ControllerServletAmex?action=rptAmexEpapeMain" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
                <table width="100%" border="0" cellspacing="0" id="tabla">
                    <tr>
                        <th id="tituloTab" width="100%" colspan="5" align="left" ><font color="#000000">  - Reporte de EPAPE AMEX ROC, SOC   
                            </font></th>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Fecha Inicio:</strong></td>
                        <td align="left">
                            <input name="txtfStartDate" type="text" id="txtfStartDate" size="15" readonly maxlength="15" value=<%=session.getAttribute("fechaHoy")%>>
                            <a href="javascript:void(0)" onclick="if (self.gfPop)
                                        gfPop.fPopCalendar(document.frmTOCHeader.txtfStartDate);
                                    return false;" hidefocus>
                                <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg" border="0" alt="">
                            </a><br/>
                            <span id = "txtInitDate" class="ocultar">Selecciona una fecha</span>
                        </td>
                        <td align="left"><strong>Fecha Fin:</strong></td>
                        <td align="left">
                            <input name="txtfEndDate" type="text" id="txtfEndDate" size="15" readonly maxlength="15" value=<%=session.getAttribute("fechaHoy")%>>
                            <a href="javascript:void(0)" onclick="if (self.gfPop)
                                        gfPop.fPopCalendar(document.frmTOCHeader.txtfEndDate);
                                    return false;" hidefocus>
                                <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg" border="0" alt="">
                            </a><br/>
                            <span id = "txtEndDate" class="ocultar">Selecciona una fecha</span>
                        </td>
                    </tr>
					
					<tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>
                    </tr>
					
					<tr>
                        <td>&nbsp;</td>
                        <td align="left"><strong>Adquirente :</strong></td>
                        <td align="left">
                            <%
                                    comboBox = new HTML();
                                    out.println(""
                                                    + comboBox.getListBox("Adquirente", cbIntValuesAdq,
                                                                    "Selecciona un Adquirente"));
                            %><br /> <span id="txtBanco" class="ocultar">Elije
                                una Opción</span>
                        </td>
						
						
						<td align="left">
						<strong>No. Industria (Opcional):</strong>
						<br/>
						<br/>
						<strong>No. Comercio (Opcional):</strong>
						</td>
						
                        <td align="left">
                            <%
								inputText = new HTML();
								out.println( "" + inputText.getinputText( "numeroIndustria", 20,20 ) );
                            %>
                        <br/>
						<br/>
                            <%
								inputText = new HTML();
								out.println( "" + inputText.getinputText( "numeroComercio", 20,20 ) );
                            %>
                        </td>	
                    </tr>
					
					<tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>
                    </tr>
					
                    <tr>
						<td>&nbsp;</td>
						<td align="left"><strong>Tipo Epape :</strong></td>
                        <td align="left">
                            <%
                                    HTML cb = new HTML();
                                    out.println( "" + cb.getComboBox( "tipoEpape", cbTipoEpape, "Selecciona un Tipo EPAPE." ) );
                            %><br/>
                            <span id = "txtTipoLiq" class="ocultar">Selecciona Opción</span>
                        </td>
                    </tr>
					
					<tr>
                        <td>&nbsp;</td>
                        <td align="left"></td>
                        
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4" align="left">
                            <input name="btnLstTOC" type="submit" id="btnLstTOC" value="Mostrar Reporte" onclick="javascript:return valida(this.form);">
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="4"><br/></td>
                    </tr>
                </table>
            </form>
        </div>
        <iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="scripts/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
        </iframe>
    </body>
</html>
<%}else{%>
<style>
    body {
        font-family: arial, verdana, Geneva, Arial, Helvetica, sans-serif;
        font-size: 1.1em;
        background-color: #F8F8F8;
    }

    .header
    {
        background-image: url(../pics/framesup.jpg);
        width: 917px;
        height: 51px;
    }

    .errorHeader {
        font-size: 1.6em;
        background-color: #6392C6;
        color: white;
        font-weight: bold;
        padding: 3px;
        margin-bottom: 10px;
    }

    .errorBody {
        background-color:#F4F4F4;
        border: 1px solid #CCCCCC;
        padding:20px;
        width:700px;
    }

    .errorDescrip{
        background-color:#FFFFFF;
        border:1px solid #333333;
        height: 100px;
    }

    .errorFooter {
        background-color: #5F7BBA; 
        height: 20px; 
        width:917px;
        font-family: Verdana, Arial, Helvetica, sans-serif; 
        font-size:12px; 
        text-align:left;   
        color:#FFFFFF;
    }

    .errorMessage {
        font-weight: bold;
        font-family: tahoma, arial, verdana;
        font-size: 11px;
        color: #6F6F6F;
        text-align: left;
        line-height: 1.3em;
        width:500px;
        position: relative;
        top: 15px;
        border: 0px solid #ccc;
        float: right;
        position: relative;
        right:50px;
    }

    .errorExceptions {

    }

    .errorExceptionStack {
        width:917px;
        margin-top: 5px;
        padding: 1px;
        border: 1px solid #CCCCCC;
        background-color: #F4F4F4;
        font-family: tahoma, arial, verdana;
        font-size: 11px;
        color: #6F6F6F;
        text-align: left;
        line-height: 1.3em;
    }

    .errorExceptionCause {
        font-size: 1.1em;
        padding: 3px;
        border-style: solid;
        border-width: 1px;
        border-color: #9F9F9F;
        background-color: #E0E0E0;
    }

    .errorException {
        font-size: 1.0em;
    }

</style>
<br/><br/><br/>
<center>
    <div style="width:917px;background-color: #5F7BBA;padding-top:3px;">
        <span style="background-color: #5F7BBA;font-family: Verdana, Arial, Helvetica, sans-serif; font-size:12px;float:left;color:#FFFFFF;">PMR</span>
        <span style="background-color: #5F7BBA;font-family:Verdana, Arial, Helvetica, sans-serif; font-size:12px;float:right;color:#FFFFFF;">PMR</span>
        &nbsp;
    </div>
</center>
<br/>
<div align="center">	
    <div align="center" class="errorBody">
        <div style="position:relative;margin:0 auto;">
            <span style="font-size:28px;color:#FF0022;font-weight:bold;">No tiene permiso para visualizar este reporte (Reporte de EPAPE AMEX ROC, SOC).</span></div>
    </div>
</div>
<div align="center">
    <div id="errorMoreDetails" align="center" style="display:none" class="errorExceptionStack"></div>
    <br/><br/>
    <div align="center" class="errorFooter">
        SISTEMA ADQUIRENTE CARNET
    </div>
</div>
<%}%>