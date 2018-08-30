<%
/*###############################################################################
# Nombre del Programa :  header.jsp			                                    #
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
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%
 String user = "";
%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
    }
    try
    {	
    	    user = session.getAttribute("login").toString();
    }
    catch(Exception e)
    {
    	out.println("Exception"+e);
    }
%>
	<div width="100%">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" style="font-family: Verdana, Arial, Helvetica, sans-erif; font-size:10px; color:#000000;">
		<tr>
		<td id="hm1">
		</td>
		<td id="hm2">&nbsp;	
		</td>
		<td id="hm3">
		</td>
	</tr>
		<!-- <tr>
			<td align="left"><%=basePath%></td>
			<td align="center">SISTEMA ADQUIRENTE CARNET</td>
			<td align="right">Bienvenido, <%=user%></td>
		</tr> -->
	</table>
	</div>
	