<%
/*###############################################################################
# Nombre del Programa :  SICMOR0810Header.jsp                                   #
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
%>
<%@ page import="com.wellcom.io.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>
<%@page import="java.io.IOException"%>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%ArrayList cbInterRedValues;
	ArrayList cbDivisionValues ;
	String prueba;
	HTML comboBox;
	HTML inputText;
	ComboBox myComboBox;%>
<%
    if(!ga.AccessGranted(session, "grantAccess"))
    {
        response.sendRedirect("login.jsp");
    }
    myComboBox = new ComboBox();
    cbInterRedValues  = myComboBox.getBancoAdqInterRed(session);
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
        var showTextInterred = false;
        var showTextDivision = false;
         var showTextDeterminante = false;
        
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
                
                else if(showTextInterred)
        		{
        			span = document.getElementById('txtInterred');
        			span.style.display = 'none';
        			showTextInterred = false;
        		}
                
                else if(showTextDivision)
        		{
        			span = document.getElementById('txtDivision');
        			span.style.display = 'none';
        			showTextDivision = false;
        		}
        		else if(showTextDeterminante)
        		{
        			span = document.getElementById('txtDeterminante');
        			span.style.display = 'none';
        			showTextDeterminante = false;
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
        		
        		else if(document.frmTOCHeader.interred.value == "None")
        		{
        			span = document.getElementById('txtInterred');
        			span.style.display = 'inline';
        			showTextInterred = true;
        			return false;
        		}
        		
        		else if(document.frmTOCHeader.division.value == "None")
        		{
        				span = document.getElementById('txtDivision');
        				span.style.display = 'inline';
        				showTextDivision = true;
        				return false;
        		} 
        		else if(document.frmTOCHeader.determinante.value == "None" || document.frmTOCHeader.determinante.value == "")
        		{
        				span = document.getElementById('txtDeterminante');
        				span.style.display = 'inline';
        				showTextDeterminante = true;
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
            <form action="ControllerServlet?action=SICMOR0810Main" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
                <table width="100%" border="0" cellspacing="0" id="tabla">
                <tr>
                   <th id= "tituloTab" width="100%" colspan="5" align="left" ><font color="#000000">SICMOR0810 - Reporte de Cifras para Custodia de Vouchers  
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
                                <span id = "txtInitDate" class="ocultar">Selecciona una fecha</span>
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
                 	<td align="left"><strong>Banco:</strong></td>
                 	<td align="left">
                 		<% 
                 			comboBox = new HTML();
	                        out.println( "" + comboBox.getListBox( "interred", cbInterRedValues , "onchange", "javascript:sendData('interred','division','comboBoxDivision');", "Selecciona un Banco" ));
	                    %><br/>
	                    <span id = "txtInterred" class="ocultar">Elije una Opción</span>
                 	 	</td>
                 	<td align="left"><strong>Divisi&oacute;n:</strong></td>
                 	<td align="left" id="comboBoxDivision">
                 		<select multiple="multiple">
                 			<option selected="selected" value="None">Selecciona una Divisi&oacute;n</option>
                 		</select>
                 	</td> 
                 </tr>
                 <tr>
                  		<td>&nbsp;</td>
                  		<td align="left"><strong>Determinante:</strong></td>
                  		<td align="left">
                  			<%
	                        	inputText = new HTML();
	                        	out.println( "" + inputText.getinputText( "determinante", 20,20 ) );
                  				//comboBox = new HTML();
	                        	//out.println( "" + comboBox.getListBox( "determinante", cbDeterminante, "Selecciona un Determinante" ) );
	                        %><br/>
	                        <span id = "txtDeterminante" class="ocultar">Ingrese un Determinante</span>
                  		</td>
                  		<td><br/></td>
                  		<td><br/></td>
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
