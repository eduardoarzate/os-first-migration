<%
/*###############################################################################
# Nombre del Programa :  fechasInvalidas.jsp                                    #
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
# Modificaci?      :                                                         #
#-----------------------------------------------------------------------------  #
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String noPantalla=request.getParameter("noPantalla");
 %>

<html>
	<head>
		<meta HTTP-EQUIV="Content-Type" CONTENT="text/html;charset=UTF-8" />
		<title>SAC 2</title>
		<style>
			body {
				font-family: arial, verdana, Geneva, Arial, Helvetica, sans-serif;
				font-size: 1.1em;
				background-color: #F8F8F8;
			}
			
			.header
			{
				background-image: url(../pics/framesup.jpg);
				width: 917px;
				height: 51px;
			}
			
			.errorHeader {
				font-size: 1.6em;
				background-color: #6392C6;
				color: white;
				font-weight: bold;
				padding: 3px;
				margin-bottom: 10px;
			}
			
			.errorBody {
			background-color:#F4F4F4;
			border: 1px solid #CCCCCC;
			padding:20px;
			width:700px;
			}
			
			.errorDescrip{
			background-color:#FFFFFF;
			border:1px solid #333333;
			height: 100px;
			}
			
			.errorFooter {
				background-color: #5F7BBA; 
				height: 20px; 
				width:917px;
				font-family: Verdana, Arial, Helvetica, sans-serif; 
				font-size:12px; 
				text-align:left;   
				color:#FFFFFF;
			}
			
			.errorMessage {
				font-weight: bold;
				font-family: tahoma, arial, verdana;
				font-size: 11px;
				color: #6F6F6F;
				text-align: left;
				line-height: 1.3em;
				width:500px;
				position: relative;
				top: 15px;
				border: 0px solid #ccc;
				float: right;
				position: relative;
				right:50px;
			}
			
			.errorExceptions {
				
			}
			
			.errorExceptionStack {
				width:917px;
				margin-top: 5px;
				padding: 1px;
				border: 1px solid #CCCCCC;
				background-color: #F4F4F4;
				font-family: tahoma, arial, verdana;
				font-size: 11px;
				color: #6F6F6F;
				text-align: left;
				line-height: 1.3em;
			}
			
			.errorExceptionCause {
				font-size: 1.1em;
				padding: 3px;
				border-style: solid;
				border-width: 1px;
				border-color: #9F9F9F;
				background-color: #E0E0E0;
			}
			
			.errorException {
				font-size: 1.0em;
			}
			
			img {
				
				border:none;
				position:relative;
				top: 23px;
				left: 50px;
				float:left;
			}
		</style>
		
	</head>
	<body>		
	<br/><br/><br/>
	<center>
	<div style="width:917px;background-color: #5F7BBA;padding-top:3px;">
		<span style="background-color: #5F7BBA;font-family: Verdana, Arial, Helvetica, sans-serif; font-size:12px;float:left;color:#FFFFFF;">PMR</span>
		<span style="background-color: #5F7BBA;font-family:font-family:Verdana, Arial, Helvetica, sans-serif; font-size:12px;float:right;color:#FFFFFF;">PMR</span>
		&nbsp;
	</div>
	</center>
	<br/>
	<div align="center">	
        <div align="center" class="errorBody">
	        <% if(noPantalla!=null&&noPantalla.equals("1")){ %>
				<div style="position:relative;margin:0 auto;">
				<span style="font-size:28px;color:#FF0022;font-weight:bold;">CIFRAS NO LIBERADAS</span></div>
			<%} else{ if(noPantalla!=null&&noPantalla.equals("2")){ %>
				<div style="position:relative;margin:0 auto;">
				<span style="font-size:28px;color:#FF0022;font-weight:bold;">LA FECHA INICIAL ES MAYOR A LA FINAL</span></div>
			<%} else{ if(noPantalla!=null&&noPantalla.equals("3")){ %>
				<div style="position:relative;margin:0 auto;">
				<span style="font-size:28px;color:#FF0022;font-weight:bold;">DATOS NO DISPONIBLES PARA ESTA FECHA INICIAL</span></div>
			<%} else{ if(noPantalla!=null&&noPantalla.equals("4")){ %>
				<div style="position:relative;margin:0 auto;">
				<span style="font-size:28px;color:#FF0022;font-weight:bold;">CONSULTAR REPORTES HISTORICOS<br></span></div>
			<%} else{ if(noPantalla!=null&&noPantalla.equals("5")){ %>
				<div style="position:relative;margin:0 auto;">
				<span style="font-size:28px;color:#FF0022;font-weight:bold;">CONSULTAR REPORTES NO HISTORICOS<br></span></div>
			<%} else{ if(noPantalla!=null&&noPantalla.equals("6")){ %>
				<div style="position:relative;margin:0 auto;">
				<span style="font-size:28px;color:#FF0022;font-weight:bold;">LIQUIDACION EN CONTINGENCIA<br></span></div>
			<%}else{ %>
				<div style="position:relative;margin:0 auto;">
				<span style="font-size:28px;color:#FF0022;font-weight:bold;">VALOR NULO</span></div>
			<%} %>
			<%} %>
			<%} %>
			<%} %>
			<%} %>
			<%} %>
        </div>
    </div>
        <div align="center">
        <div id="errorMoreDetails" align="center" style="display:none" class="errorExceptionStack"></div>
        <br/><br/>
        <div align="center" class="errorFooter">
			SISTEMA ADQUIRENTE CARNET
		</div>
	</div>
	</body>
</html>