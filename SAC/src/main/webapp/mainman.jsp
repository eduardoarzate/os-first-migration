<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<jsp:useBean id="myJndi" scope="session" class="com.wellcom.directory.Jndi"/>

<%
    String myRole;
    String myRolAct;
    String myEstAct;
    String myEstado;
    String estado;
%>

<% myRole = myJndi.loadUidRoles(myJndi.appDn, myJndi.uid).toString();
   myRolAct = (String)session.getAttribute( "rolact" );
   myEstAct = (String)session.getAttribute( "estatusact" );
   myEstado = (String)session.getAttribute( "estado" );
   System.out.println("myRole: " + myRole);
   if((myRole.toLowerCase()).indexOf("administrador") >= 0) {
                    myRole = "administrador";                    
                } else if((myRole.toLowerCase()).indexOf("banco") >= 0) {
                    myRole = "banco";
                } else if((myRole.toLowerCase()).indexOf("operador") >= 0) {
                    myRole = "operador";
                } else {
                    throw new Exception(
                        "Usuario sin Roles de acceso al Sistema.");
                }
                System.out.println("par:  "+myRolAct+"  "+myEstAct);
                System.out.println("est:  "+myEstado);
                if(myEstado==null)
            	     estado = "0";
                %>
    <center>
     		<div id="rightPanel">
			<div id="bar" class= "td_header_p" align="center">SISTEMA ADQUIRENTE CARNET</div>
			<br></br>
			<br></br>
			<!--  <div id="marketing">
			<div id="marketing_left">
		 		<a  id="imageLink" title="Wellcom Reportes"><img src="pics/reportes.png" id="imageSalida" /></a>
         		<p id="title_marketing"><img src="pics/tituloreporte.png" alt="Reporte" /></p>
         		<p id="marketing_left_text">Consulte los informes que su área requiera para entender y medir el rendimiento de los procesos clave del negocio.  Cada informe está estructurado para brindar un panorama completo y detallado del estado de los indicadores, definidos sobre una misma contextualización.<br />
            	<!-- <a href="#" id="links">Ver m&aacute;s</a></p> -->
		<!--	</div>
			<div id="marketing_center">
				<a id="imageLink" title="Wellcom Herramientas"><img src="pics/herramientas.png" alt="Wellcom Herramientas" id="imageSalida" /></a>
        		<p id="title_marketing"><img src="pics/tituloherramientas.png" alt="Herramientas" /></p>
				<p id="marketing_center_text">Configure y administré todas las propiedades relativas a las operaciones y tareas de nivel de sistema por medio de componentes avanzados que se activan de manera sencilla.<br />
            	<!-- <a href="#" id="links">Ver m&aacute;s</a></p>  -->
		<!--	</div>
			<div id="marketing_right">
				<a id="imageLink" title="Wellcom Ayuda"><img src="pics/ayuda.png" alt="Wellcom Ayuda" id="imageSalida" /></a>
         		<p id="title_marketing"><img src="pics/tituloayuda.png" alt="Herramientas" /></p>
         		<p id="marketing_right_text">Encuentre respuestas, sugerencias, condiciones de uso y otra información de soporte relacionada con temas de cada uno de los módulos y herramientas del sistema.<br />
            	<!--  <a href="#" id="links">Ver m&aacute;s</a></p> -->
			<!-- </div>
			</div> -->
				<div style="position:relative;margin:0 auto;">
				<span style="font-size:28px;color:#FF0022;font-weight:bold;">Sistema Adquirente Carnet SAC 2</span></div>
				<div style="position:relative;margin:0 auto;">
				<span style="font-size:28px;color:#FF0022;font-weight:bold;">En Mantenimiento</span></div>
			</div>
			

    </center> 		
