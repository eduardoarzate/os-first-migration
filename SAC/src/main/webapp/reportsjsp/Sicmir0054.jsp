<%
/*###############################################################################
# Nombre del Programa :  SICMIR0054.jsp											#
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
#-----------------------------------------------------------------------------  #
# Autor               :  Daniel Ramírez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 09/03/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<!--Modificacion: SAS-DRT F-52-8063-16 Marca de inicio-->
<%@page import="com.wellcom.conexion.*"%>
<%/*@page import="com.wellcom.sql.Database"*/%>
<!--Modificacion: SAS-DRT F-52-8063-16 Marca de fin-->
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%><%@ taglib uri="/birt.tld" prefix="birt"%>
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
	String bancoEmi;
	String archivo;
	String ejecuto;
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
                    bancoEmi = (String)session.getAttribute("bancoEmi");
                    archivo = (String)session.getAttribute("archivoEmi");
                    System.out.println("aqui mero:"+archivo+":");
                    ejecuto= session.getAttribute("login").toString();
                    String sessionID = session.getId() + "db";
					/*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
					ConexionORACLE conOracle = null;
					conOracle = new ConexionORACLE();
					//Database db = (Database)session.getAttribute( sessionID );

	    			conOracle.Conectar();
					conOracle.Consultar(
					" SELECT /*+ FULL(PA) */ 1 "+
					" FROM PMADMIN.PRSA_BITACORA_ARCHIVOS PBA "+
					" INNER JOIN  PMADMIN.PRSA_ARCHIVOS PA "+
					" ON (PA.BAIN_NUMERO = TO_NUMBER(REGEXP_REPLACE(REGEXP_SUBSTR(PBA.BA_ARCHIVO,  '[^.]+'),'[[:alpha:]]','')) "+ 
					"      OR (NOT REGEXP_LIKE(REGEXP_REPLACE(REGEXP_SUBSTR(PBA.BA_ARCHIVO,  '\\.[^.]+\\.'),'(\\.)',''),'[[:alpha:]]') "+ 
					"      AND PA.BAIN_NUMERO = TO_NUMBER(REGEXP_REPLACE(REGEXP_SUBSTR(PBA.BA_ARCHIVO,  '\\.[^.]+\\.'),'(\\.)','')))) "+
					" INNER JOIN  PMADMIN.PRSA_ENTIDADES PE "+
					" ON PA.ENT_NUMERO_PROSA = PE.NUMERO_PROSA "+
					" WHERE PBA.BA_FCH_PROC BETWEEN TO_DATE('"+initDate+"','dd-MM-yyyy') AND TO_DATE('"+endDate+"','dd-MM-yyyy') "+
					" AND PBA.BA_T_ARCH = 'O' "+
					" AND PA.ENT_NUMERO_PROSA IN ("+bancoEmi+") "+
					" AND (PBA.BA_NUM_ARCH = " +archivo+ " OR PA.BAIN_NUMERO = " +archivo+ ") "+ 
					" AND ROWNUM = NVL(1, UID) "
					);
					
					ArrayList resultLst= conOracle.getRSColsData();
					conOracle.Desconectar();
				  /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
					System.out.println("Esto es get0");
					String[] AqueryStr;
					if(resultLst.size()==0)
					AqueryStr=null;
					else
					AqueryStr=(String[])resultLst.get(0);
					
					String queryStr;
					if(AqueryStr!=null)
					queryStr=AqueryStr[0];
					else
					queryStr=null;            
		%>
		<%if(queryStr!=null){ %>
		<birt:viewer  id="birtViewer" reportDesign="<%=getServletContext().getInitParameter(\"UBICACION_REPORTES\")+\"/sicmir0054.rptdesign\"%>"
			showParameterPage="false" showTitle="true" pattern="frameset"
			format="HTML" isHostPage="true" title="SISTEMA ADQUIRENTE CARNET SAC 2 SICMIR0054" showToolBar="true" >
			<birt:param name="initDate" value="<%=initDate%>" />
			<birt:param name="endDate" value="<%=endDate%>" />
			<birt:param name="bancoEmi" value="<%=bancoEmi%>" />
			<birt:param name="archivo" value="<%=archivo%>" />
			<birt:param name="ejecuto" value="<%=ejecuto%>" />
			<birt:param name="srvImgLcl" value="<%=getServletContext().getInitParameter(\"SERV_IMG_LOCAL\")%>" />
			<birt:param name="srvImgRmt" value="<%=getServletContext().getInitParameter(\"SERV_IMG_REMOTO\")%>" />
		</birt:viewer>
		<%}else{ %>
			EL ARCHIVO NO ES VALIDO
		<%} %>
</body>
</html>