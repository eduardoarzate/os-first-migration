<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>

<%
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
    }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
<link href="css/styles.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="scripts/resize.js"></script>
<title>Reversos</title>
</head>

<body >
		<div id="wrapper">
		<table   >
	        <tr>
	    		<td id="leftPanel" valign="top"><jsp:include page="menu.jsp"/></td>
	    		<td id="rightPanel" valign="top" ><jsp:include page="MonitorHeader.jsp"/></td>
	  		</tr>
		</table>

			<jsp:include page="footer.jsp"/>

		</div>
</body>
</html>