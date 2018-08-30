<%@ page import="java.lang.management.*" %>
<%@ page import="java.util.*" %>
<html>
<head>
  <title>SAC 2 - JVM Memory Monitor</title>
<link rel="stylesheet" href="../css/styles.css" type="text/css" />
</head>
<body>
<form method="post"" name="frmTOCHeader" id="frmTOCHeader">
<table width="100%" border="0" cellspacing="0" class="tableIframe"  style="border: 1px #98AAB1 solid;">
<tr>
                   <th colspan="5" align="left" class="headerIframe"  id= "tituloTab" >Memory MXBean</th>
 </tr>
<%
        Iterator iter = ManagementFactory.getMemoryPoolMXBeans().iterator();
        while (iter.hasNext()) {
            MemoryPoolMXBean item = (MemoryPoolMXBean) iter.next();
%>

<tr ><td width="200">Heap Memory Usage</td><td><%=ManagementFactory.getMemoryMXBean().getHeapMemoryUsage()%></td></tr>
<tr><td>Non-Heap Memory Usage</td><td><%=ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage()%></td></tr>
<tr><td colspan="2">&nbsp;</td></tr>

<%} %>
</table><br/>
<table  width="100%" border="0" cellspacing="0" class="tableIframe" style="border: 1px #98AAB1 solid;">
<tr>
                   <th colspan="5" align="left" class="headerIframe"  id= "tituloTab" >Memory Pool MXBeans</th>
 </tr>
<%
/*
        Iterator iter = ManagementFactory.getMemoryPoolMXBeans().iterator();
*/
        iter = ManagementFactory.getMemoryPoolMXBeans().iterator();
        while (iter.hasNext()) {
            MemoryPoolMXBean item = (MemoryPoolMXBean) iter.next();
%>

<tr><td colspan="2" align="left"><b><%= item.getName() %></b></td></tr>
<tr><td width="200">Type</td><td><%= item.getType() %></td></tr>
<tr><td>Usage</td><td><%= item.getUsage() %></td></tr>
<tr><td>Peak Usage</td><td><%= item.getPeakUsage() %></td></tr>
<tr><td>Collection Usage</td><td><%= item.getCollectionUsage() %></td></tr>
<tr><td colspan="2">&nbsp;</td></tr>
<%
}
%>

</table>
</form>
</body>
</html>