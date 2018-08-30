<%@ page import="com.wellcom.io.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>

<%
	ArrayList cbCICLO;
	ArrayList cbBCOEMI;	
	ArrayList cbPREFIJO;
	HTML comboBox;
	ComboBox myComboBox;
%>
<%
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
   }
   HTML inputText;
   myComboBox = new ComboBox();;      
   cbBCOEMI = myComboBox.getBancoEmiDol(session);   
   cbPREFIJO = myComboBox.getCiclo(session,"B");
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
        var verbanco = false;        
        var verprefijo = false;
        
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
                
                else if(verbanco)
        		{
        			span = document.getElementById('spambanco');
        			span.style.display = 'none';
        			verbanco = false;
                }
                else if(verprefijo)
        		{
        			span = document.getElementById('spamprefijo');
        			span.style.display = 'none';
        			verprefijo = false;
                }
                               
 				if(document.frmTOCHeader.txtfStartDate.value == "" || document.frmTOCHeader.txtfStartDate.value == null)
        		{
        			span = document.getElementById("txtInitDate");
           			span.style.display = 'inline';
           			showTextInitDate = true;
           			return false;
        		}
        		
        		else if(document.frmTOCHeader.banco.value == 'None')
        		{
        			span = document.getElementById('spambanco');
        			span.style.display = 'inline';
        			verbanco = true;
        			return false;
        		} 		        		
        		else if(document.frmTOCHeader.prefijo.value == 'None')
        		{
        			span = document.getElementById('spamprefijo');
        			span.style.display = 'inline';
        			verprefijo = true;
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
            <form action="ControllerServlet?action=SICMIRD127_VSSMain" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
                <table width="100%" border="0" cellspacing="0" id="tabla">
                <tr>
                   <th id="tituloTab" width="100%" colspan="5" align="left" ><font color="#000000">SICMIRD127_VSS - Reporte VSS Visa</font><br></th>
                </tr>
				
				<tr>
					<td>&nbsp;</td>
					<td colspan="4"><br/></td>
				</tr>
				
                    <tr>
                    	<td>&nbsp;</td>
                        <td align="left"><strong>Fecha:</strong></td>
                        <td align="left">
                                <input name="txtfStartDate" type="text" id="txtfStartDate" size="15" readonly maxlength="15" value=<%=session.getAttribute("fechaHoy")%>>
                                <a href="javascript:void(0)" onclick="if(self.gfPop)gfPop.fPopCalendar(document.frmTOCHeader.txtfStartDate);return false;" hidefocus>
                                    <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg" border="0" alt="">
                                </a><br/>
                                <span id = "txtInitDate" class="ocultar">Selecciona una fecha</span><%//agregar class%>
                        </td>
                        <td align="left"><strong>Banco:</strong></td>
                        <td align="left">
                                <%
	                        	inputText = new HTML();
	                        	out.println( "" + inputText.getComboBox( "banco", cbBCOEMI,"Seleccione un Banco" ) );
	                        %><br/>
	                        <span id = "spambanco" class="ocultar">Selecciona un banco</span>
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
