<%
/*###############################################################################
# Nombre del Programa :  SICLIR0130Header.jsp                                   #
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
<%@ page import="com.wellcom.Validator.Mantenimiento" %>


<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>

<%
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
   }

%>

<% String estado, ruta; %>

<%

ruta = (String)session.getAttribute("rutaContext");

if(request.getParameter("btnLstTOC") != null)
{
estado=request.getParameter("estado");

new Mantenimiento();
Mantenimiento.guardaEstado(estado,ruta);
};

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>SAC 2</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css">
    </head>    
    <body>
       <div align="center">       
          <%
          out.println("<form action=mantenimiento.jsp method=post >");
          out.println("<table width=100% border=0 cellspacing=0 id=tabla>");
          out.println("<tr>");
          out.println("<th id=tituloTab width=100% colspan=9 align=left>");
          out.println("<font color=#000000>Mantenimiento<br></font>");
          out.println("</th>");
          out.println("</tr>");   
          out.println("<tr>");						
		  out.println("<td colspan=1><br/></td>");
		  out.println("</tr>");
	      out.println("<tr>"); 
          out.println("<td colspan=1>");
          out.println("<table width=51% border=0 bordercolor=#ECBE19 cellspacing=0 align=center id=tablam>");
		  out.println("<tr>");		
	      out.println("<td width=33% align=center><strong>Disponible</strong></td>");
		  out.println("<td width=33% align=center><strong>No Disponible</strong></td>");
		  out.println("</tr>");
		  out.println("<tr>");
		  %>
		  <% 
			if(Mantenimiento.leeEstado("aplicacion",ruta).equals("1")){
			out.println("<td align=center>");
			out.println("<input id=1 name=estado type=radio value=1 checked>");
			out.println("</td>");
			out.println("<td align=center>");
			out.println("<input id=2 name=estado type=radio value=2>");
			out.println("</td>");}
			else {
			out.println("<td align=center>");
			out.println("<input id=1 name=estado type=radio value=1>");
			out.println("</td>");
			out.println("<td align=center>");
			out.println("<input id=2 name=estado type=radio value=2 checked>");
			out.println("</td>");
			}
		  %> 
			<%  
			out.println("</tr>");					
	        out.println("</table>");
            out.println("</td>");
            out.println("</tr>"); 
            out.println("<td>"); 
            %>
            <%
            if(request.getParameter("btnLstTOC") != null)
              {  
              out.println("Datos Guardados"+"<br>");
             };
            %>
            <% 
            out.println("</td>");
            out.println("<tr>");						
			out.println("<td colspan=1><br/></td>");
			out.println("</tr>");                  
            out.println("<tr>");                    	
            out.println("<td colspan=1 align=center>");
            out.println("<input name=btnLstTOC type=submit id=btnLstTOC value=Guardar >");
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");						
			out.println("<td colspan=1><br/></td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("<div>");					
			out.println("</div>");                
            out.println("</form>");
            %> 
            </div>             
    </body>
</html>
