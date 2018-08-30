<%
/*###############################################################################
# Nombre del Programa :  cierreDifCuotas.jsp                                    #
# Autor               :  Carlos Mendez                                          #
# Compania            :  PROSA                                                  #
# Proyecto/Procliente : C-04-3035-13                            Fecha:11/12/2013#
# Modificacion        : Generacion de Proceso de Diferencia de Cuota de         #
#                       Intercambio de EGLO SAC2                                #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :                                                         #
#                                                                               #
#                                                                               #
#################################################################################
#                               MODIFICACIONES                                  #
# Autor               :                                                         #
# Compania            :                                                         #
# Proyecto/Procliente :                              Fecha:                     #
# Modificación        :                                                         #
#-----------------------------------------------------------------------------  #
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<%@ page import="com.wellcom.io.*" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>

<%
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
    }
    session.setAttribute("accion","consulta");
%>

<%
    /**
    * Action type
    */
    String valor = null;
    String txtfUsuario;
    String role;
    
    txtfUsuario = (String)session.getAttribute("login");
    role = (String)session.getAttribute("role");
    

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>CIERRE DE PERIODO DE DIFERENCIA DE CIFRAS - ARBITRO</title>
        
       <script type="text/javascript">
       var span = null;
        var showTextInitDate = false;
        var showFiid = false;
        var numPage=0;
        function valida(form1,accion)
        {   		
	        	
	        	try
	        	{
	           	sendDatas("txtfStartDate","txtfStartDate","cierreDCAccion","tableTablaPrincipal");
	           	return true;
	        	}catch(e){
	        	}
        	}
        </script>
        <script type="text/javascript" src="scripts/envio.js"></script>
    </head>
    
    <body>
        <div align="center">
            <form action="cierreDifCuotas.jsp" method="post" name="frmCierreDCHeader" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tbl_border" >
                <tr>
                   <th id= "tituloTab" width="100%" colspan=5 ><font color="#000000">CIERRE DE PERIODO DE DIFERENCIA DE CIFRAS - ARBITRO</font><font color="#000000"></font><br></th>
                </tr>
<tr>
					<td>&nbsp;</td>
					<td colspan="3"><br/></td>
				</tr>
                    <tr>
                        <td><div align="left">
                                &nbsp;
                                Oprime el bot&oacute;n "Buscar" para mostrar los registros existentes
                                <input name="txtfStartDate" type="hidden" id="txtfStartDate" size="15" maxlength="15" value=<%=session.getAttribute("fechaHoy")%>>
                                </a><br/>
                        </div></td>
                    </tr>
                    <tr>
                        <td colspan="6"><div align="center">
                               <input name="btnCierreDC" type="button" id="btnCierreDC" value="BUSCAR" onclick="javascript:return valida(this.form);">
                        </div></td>
                    </tr>
                    <tr>
                    <td colspan="4">
                    <div id="divTablaPrincipal" align="center" >
        			<br/>
        			<br/>
        			<div id="tableTablaPrincipal" ><jsp:include page="cierreDifCuotasMain.jsp"/></div>
        			
        		</div>
                    </td>
                    </tr>
                    
                </table>
        		
          </form>
        </div>
        <iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="scripts/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
        </iframe>
    </body>
</html>
