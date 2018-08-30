<%@ page import="com.wellcom.io.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
   }
%>

<%ArrayList cbBancoAdqValues;
	ArrayList cbBancoEmiValues;
	ArrayList cbTipoRechValues;
	ArrayList cbFuenteValues;
	ArrayList cbTransaccionValues;
	ArrayList cbNatConValues;	
	HTML comboBox;
	ComboBox myComboBox;%>
<%
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
   }
   myComboBox = new ComboBox();;
   cbBancoAdqValues = myComboBox.getBancoAdqDol(session);
   cbBancoEmiValues = myComboBox.getMCVS(session);
   cbTipoRechValues = myComboBox.getGrupoRechazo(session);   
   cbFuenteValues = myComboBox.getArchivoAdqDol(session);
   cbTransaccionValues = myComboBox.getTipoTrxsTodos(session);
   cbNatConValues = myComboBox.getNaturalezaContable(session);
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
        var showTextBancoAdq = false;
        var showTextBancoEmi = false;
        var showTextNaturaleza = false;
        var showTextTransaccion = false;
        var showTextFuente = false;
        
        function valida()
        {   		
        	try
        	{
        		if(showTextInitDate)
        		{
           			span = document.getElementById("txtInitDate");
           			span.style.display = 'none';
           			showTextInitDate = false;
                }
                
                else if(showTextEndDate)
        		{
        			span = document.getElementById('txtEndDate');
        			span.style.display = 'none';
        			showTextEndDate = false;
                }
                
                else if(showTextBancoAdq)
                {
                	span = document.getElementById('txtBancoAdq');
                	span.style.display = 'none';
                	showTextBancoAdq = false;
                }

                else if(showTextBancoEmi)
                {
                	span = document.getElementById('txtBancoEmi');
                	span.style.display = 'none';
                	showTextBancoEmi = false;
                }
                
                else if(showTextNaturaleza)
                {
                	span = document.getElementById('txtNaturaleza');
                	span.style.display = 'none';
                	showTextNaturaleza = false;
                }
                
                else if(showTextFuente)
                {
                	span = document.getElementById('txtFuente');
                	span.style.display = 'none';
                	showTextFuente = false;
                }
                
                else if(showTextTransaccion)
                {
                	span = document.getElementById('txtTransaccion');
                	span.style.display = 'none';
                	showTextTransaccion = false;
                }
                
               if(document.frmTOCHeader.txtfStartDate.value == "" || document.frmTOCHeader.txtfStartDate.value == null)
        		{
        			span = document.getElementById("txtInitDate");
           			span.style.display = 'inline';
           			showTextInitDate = true;
           			return false;
        		}
        		
        		else if(document.frmTOCHeader.txtfEndDate.value == "" || document.frmTOCHeader.txtfEndDate.value == null)
        		{
        			span = document.getElementById('txtEndDate');
        			span.style.display = 'inline';
        			showTextEndDate = true;
        			return false;
        		}
        		
        		
        		else if(document.frmTOCHeader.bancoAdq.value == "None")
        		{
        			span = document.getElementById('txtBancoAdq');
        			span.style.display = 'inline';
        			showTextBancoAdq = true;
        			return false;
        		}
        		
        		else if(document.frmTOCHeader.bancoEmi.value == "None")
        		{
        			span = document.getElementById('txtBancoEmi');
        			span.style.display = 'inline';
        			showTextBancoEmi = true;
        			return false;
        		}
        		 
        		else if(document.frmTOCHeader.naturaleza.value == "None")
        		{
        			span = document.getElementById('txtNaturaleza');
        			span.style.display = 'inline';
        			showTextNaturaleza = true;
        			return false;
        		}
        		
        		else if(document.frmTOCHeader.fuente.value == "None")
        		{
        			span = document.getElementById('txtFuente');
        			span.style.display = 'inline';
        			showTextFuente = true;
        			return false;
        		}
        		
        		else if(document.frmTOCHeader.transaccion.value == "None")
        		{
        			span = document.getElementById('txtTransaccion');
        			span.style.display = 'inline';
        			showTextTransaccion = true;
        			return false;
        		}
        		    		        		
        		else
        		{
        			return true;
        		}
        		}
        		catch(e)
        		{
        		
        		}     		
        	}
        </script>
    <body>
        <div align="center">
            <form action="ControllerServlet?action=SICMORB200Main" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
                <table width="100%" border="0" cellspacing="0" id="tabla">
                <tr>
                   <th id="tituloTab" width="100%" colspan="5" align="left" ><font color="#000000">SICMORB200 - Reporte de Transacciones Aceptadas 
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
                                <a href="javascript:void(0)" onclick="if(self.gfPop)gfPop.fPopCalendar(document.frmTOCHeader.txtfStartDate);return false;" hidefocus>
                                    <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg" border="0" alt="">
                                </a><br/>
                                <span id = "txtInitDate" class="ocultar">Selecciona una fecha</span><%//agregar class%>
                        </td>
                        <td align="left"><strong>Fecha Fin:</strong></td>
                        <td align="left">
                                <input name="txtfEndDate" type="text" id="txtfEndDate" size="15" readonly maxlength="15" value=<%=session.getAttribute("fechaHoy")%>>
                                <a href="javascript:void(0)" onclick="if(self.gfPop)gfPop.fPopCalendar(document.frmTOCHeader.txtfEndDate);return false;" hidefocus>
                                    <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg" border="0" alt="">
                                </a><br/>
                                <span id = "txtEndDate" class="ocultar">Selecciona una fecha</span>
                        </td>
                 </tr>
                 
                 <tr>
                 	<td>&nbsp;</td>
                 	<td align="left"><strong>Naturaleza Contable:</strong> </td>
                 	<td align="left">
                 		<% 
                 			comboBox = new HTML();
	                        out.println( "" + comboBox.getComboBox( "naturaleza", cbNatConValues, "Selecciona una Naturaleza") );
	                    %>
	                    <br/>
	                        <span id = "txtNaturaleza" class="ocultar">Elije una Opción</span>
                 	</td>
                 	<td align="left"><strong>Banco Adquirente:</strong> </td>
                 	<td align="left">
                 		<% 
                 			comboBox = new HTML();
	                        out.println( "" + comboBox.getListBox( "bancoAdq", cbBancoAdqValues, "Selecciona un Banco") );
	                    %>
	                    <br/>
	                        <span id = "txtBancoAdq" class="ocultar">Elije una Opción</span>
                 	</td> 
                 </tr>
                 <tr>
                 	<td>&nbsp;</td>
                 	<td align="left"><strong>Banco Emisor:</strong></td>
                 	<td align="left">
                 		<% 
                 			comboBox = new HTML();
	                        out.println( "" + comboBox.getListBox( "bancoEmi", cbBancoEmiValues, "Selecciona un Banco") );
	                    %>
                 	    <br/>
	                        <span id = "txtBancoEmi" class="ocultar">Elije una Opción</span>
                 	 	</td>
                 	<td align="left"><strong>Fuente:</strong> </td>
                 	<td align="left">
                 		<% 
                 			comboBox = new HTML();
	                        out.println( "" + comboBox.getListBox( "fuente", cbFuenteValues, "Selecciona una fuente") );
	                    %>
	                    <br/>
	                        <span id = "txtFuente" class="ocultar">Elije una Opción</span>
                 	</td> 
                 </tr>
                 <tr>
                 	<td>&nbsp;</td>
                 	<td align="left"><strong>Tipo Transacción:</strong></td>
                 	<td align="left">
                 		<% 
                 			comboBox = new HTML();
	                        out.println( "" + comboBox.getListBox( "transaccion", cbTransaccionValues, "Selecciona una Transaccon") );
	                    %>
                 	    <br/>
	                        <span id = "txtTransaccion" class="ocultar">Elije una Opción</span>
                 	 	</td>                 	
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