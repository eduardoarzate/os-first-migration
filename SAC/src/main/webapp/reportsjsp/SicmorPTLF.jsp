<%
/*###############################################################################
# Nombre del Programa :  SICMORPTLF.jsp											#
# Autor               :  JOAQUIN MOJICA Q.                                      #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-08-299-04                 	   FECHA:15/10/2008     #
# Descripcion General :															#
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :															#
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
    //String initDate;
    String mes;
    String year;
    String cuenta;
    String afiliacion;
    String banco; 
    String ejecuto;
    String fechaXML; 
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
                    ejecuto= session.getAttribute("login").toString();
                    cuenta=session.getAttribute("cuenta").toString();
                    fechaXML = session.getAttribute("fechaXML").toString();
                    mes=session.getAttribute("mes").toString();
                    year=session.getAttribute("year").toString();
                    banco=session.getAttribute("banco").toString();
                    if(banco.equals("None"))
                    	banco=null;
                    afiliacion=session.getAttribute("afiliacion").toString();
		%>
		<birt:viewer  id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/sicmorPTLF.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 SICMORPTLF" showToolBar="true" >			
			<birt:param name="cuenta" value="<%=cuenta%>" />
			<birt:param name="adq" value="<%=banco%>" />
			<birt:param name="fechaXML" value="<%=fechaXML%>" />
			<birt:param name="mes" value="<%=mes%>" />
			<birt:param name="year" value="<%=year%>" />
			<birt:param name="afiliacion" value="<%=afiliacion%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
		</birt:viewer>
	</body>
</html>