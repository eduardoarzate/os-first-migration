<%
/*###############################################################################
# Nombre del Programa :  SICLIF0065.jsp								            #
# Autor               :  JOAQUIN MOJICA Q.                                      #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-08-299-04                 	   FECHA:15/10/2008     #
# Descripcion General :															#
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :											                #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :															#
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
<%@ taglib uri="/birt.tld" prefix="birt"%>
<%@page import="com.wellcom.io.HTML"%>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%
    if(!ga.AccessGranted(session, "grantAccess"))
    {
        response.sendRedirect("login.jsp");
    }
%>
<%!
    HTML html;
    String btnLstTOC;
    String initDate;
    String endDate;  
     String initDateHabAnt;
    String endDateHabAnt; 
	String banco;
	String diaant;
	String ejecuto;
	String role;
%>
 
<%
	
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";			
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
	</head>

	<body>
		<%
           		initDate = (String)session.getAttribute("txtfStartDate");
                endDate = (String)session.getAttribute("txtfEndDate");
                initDateHabAnt = (String)session.getAttribute("initDateHabAnt");
         		endDateHabAnt = (String)session.getAttribute("endDateHabAnt");
                banco = (String)session.getAttribute("banco");
                diaant = (String)session.getAttribute("susparticionesdiaant");
                ejecuto = session.getAttribute("login").toString();  
                role = session.getAttribute("role").toString();                                      
       %>
		<birt:viewer   id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/siclif0065.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 SICLIF065" showToolBar="true">
			<birt:param name="initDate" value="<%=initDate%>" />
			<birt:param name="endDate" value="<%=endDate%>" />
			<birt:param name="initDateHabAnt"    value="<%=initDateHabAnt%>" />
			<birt:param name="endDateHabAnt"  value="<%=endDateHabAnt%>" />
			<birt:param name="banco" value="<%=banco%>" />
			<birt:param name="diaant" value="<%=diaant%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="role" value="<%=role%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
		</birt:viewer>
	</body>
</html>