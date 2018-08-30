
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
    	out.println(" ");
    }
%>
<!-- Inicia Modificacion N-08-2253-12 26/04/2013 -->
<!-- <div id="footer">
<table width="100%" border="0" cellpadding="0" cellspacing="2" style="font-family: Verdana, Arial, Helvetica, sans-erif; font-size:10px; color:#FFFFFF;">
<tr>
			<td align="left"><%=basePath%></td>
			<td align="center">SISTEMA ADQUIRENTE CARNET</td>
			<td align="right">Bienvenido, <%=user%></td>
		</tr>
	</table>
	</div> -->
<div width="100%">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" style="font-family: Verdana, Arial, Helvetica, sans-erif; font-size:10px; color:#FFFFFF;">
		<tr>
			<td id="hm4" align="left"><%=basePath%>
			</td>
			<td id="hm5" align="center">SISTEMA ADQUIRENTE CARNET	
			</td>
			<td id="hm6" align="right">Bienvenido, <%=user%>
			</td>
		</tr>
	</table>
</div>
<!-- Fin Modificacion N-08-2253-12 26/04/2013 -->