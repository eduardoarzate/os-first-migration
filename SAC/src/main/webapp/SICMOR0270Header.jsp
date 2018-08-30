<%
/*###############################################################################
# Nombre del Programa :  SICMOR0270Header.jsp                                   #
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
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>

<%
	ArrayList cbCORTE;
	ArrayList cbPTLFPapel;	
	HTML comboBox;
	ComboBox myComboBox;
%>

<%
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
   }
   HTML inputText;
   myComboBox = new ComboBox();;      
   cbPTLFPapel = myComboBox.getPTLFPapel(session);   
   cbCORTE = myComboBox.getCiclo(session,"C");
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
        var vercorte = false;
        var verfuente = false;
        
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
                else if(vercorte)
        		{
        			span = document.getElementById('spamcorte');
        			span.style.display = 'none';
        			vercorte = false;
                }
                
                else if(verfuente)
        		{
        			span = document.getElementById('spamfuente');
        			span.style.display = 'none';
        			verfuente = false;
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
        		else if(document.frmTOCHeader.corte.value == 'None')
        		{
        			span = document.getElementById('spamcorte');
        			span.style.display = 'inline';
        			vercorte = true;
        			return false;
        		}
        		
        		else if(document.frmTOCHeader.fuente.value == 'None')
        		{
        			span = document.getElementById('spamfuente');
        			span.style.display = 'inline';
        			verfuente = true;
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
            <form action="ControllerServlet?action=SICMOR0270Main" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
                <table width="100%" border="0" cellspacing="0" id="tabla">
                <tr>
                   <th id="tituloTab" width="100%" colspan="5" align="left" ><font color="#000000">SICMOR0270 - Reporte de Archivos Enviados a Tsys</font></th>
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
						<td colspan="4"><br/></td>
					</tr>
					
					<tr>
				    	<td>&nbsp;</td>
                        <td align="left"><strong>Corte:</strong></td>
                        <td align="left">
                                <%
	                        	comboBox = new HTML();
	                        	out.println( "" + comboBox.getComboBox( "corte",  cbCORTE, "Selecciona un Corte"  ) );
	                        %><br/>
	                        <span id = "spamcorte" class="ocultar">Selecciona un corte</span></td>
	                        <td align="left"><strong>Fuente:</strong></td>
                        <td align="left">
                                <%
	                        	comboBox = new HTML();
	                        	out.println( "" + comboBox.getComboBox( "fuente",  cbPTLFPapel, "Selecciona una Fuente"  ) );
	                        %><br/>
	                        <span id = "spamfuente" class="ocultar">Selecciona una fuente</span></td>
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
