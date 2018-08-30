<%
/*###############################################################################
# Nombre del Programa : rlqMontosHeader.jsp                                     #
# Autor               : Gerardo G. Burguete                                     #
# Compania            : Axia, Consultores, S.A. de C.V.                         #
# Proyecto/Procliente : P-53-2933-14                     FECHA:04/06/2015       #
# Descripcion General : Re-cálculo de compensación y administración de umbrales #
#################################################################################
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :                                                         #
# Dias de ejecucion   :                                                         #
#################################################################################
#               MODIFICACIONES                                                  #
#------------------------------------------------------------------------------#
# Autor               :  Daniel Ramirez Torres                                 #
# Compania            :  SAS S.A. DE C.V.                                      #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017        #
# Modificacion        :  Mejora Conexiones  SAC2                               #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                  #
#------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<%@ page import="com.wellcom.io.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wellcom.prosa.sacii.*" %>
<%@ page import="com.wellcom.Validator.Mantenimiento" %>
<%@ page import="com.wellcom.prosa.sacii.rlq.RlqMontosParamsVO" %>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%!
  ArrayList cbBancos;
  HTML comboBox;
    /* Modificacion: Marca de inicio    SAS-DRT F-52-8063-16  */  
        ComboBoxGen myComboBox;
%>
<%
  String tMsg = new String("");
  String path = request.getContextPath();
  if(!ga.AccessGranted(session, "grantAccess")){
    response.sendRedirect("login.jsp");
  }
  myComboBox = new ComboBoxGen();
    /* Modificacion: Marca de fin    SAS-DRT F-52-8063-16  */  
  cbBancos = myComboBox.getBancoAdqSinMer(session);
  RlqMontosParamsVO monto = (RlqMontosParamsVO)request.getAttribute("monto");
  if (monto == null) 
          monto = new RlqMontosParamsVO();
  tMsg = monto.getMsg();
  
%>

<%! String estado, ruta; %>

<%

  ruta = (String)session.getAttribute("rutaContext");
  if(request.getParameter("btnLstTOC") != null) {
    estado=request.getParameter("estado");
    estado =(estado == null ? "0" : estado);
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
        <script type="text/javascript" src="scripts/rlq/rlqMontos.js"></script>
        <script type="text/javascript">
            function prc() {
                document.frmTOCHeader.action.value = "rlqMontosHeaderPrc";
                var r = confirm("Quiere activar los procesos de Prorrateo...!!!");
                if (r == true) {
                    document.frmTOCHeader.submit();
                }
            }
        </script>
    </head>
    <body>
        <div align="center" >      
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación -->
            <form action="<%=path %>/ControllerServletReLQ" method="post" name="frmTOCHeader">      
            <!--Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación -->
                <input type="hidden" name="action" value="rlqMontosHeaderAct">        
                <table width="100%" border="0" cellspacing="0" id="tabla">
                    <tr>
                        <th id="tituloTab" width="100%" colspan="9" align="left">
                            <font color="#000000">Re-c&aacute;lculo de Compensaci&oacute;n y Administraci&oacute;n de Umbrales.<br></font>
                        </th>
                    </tr>
                    <tr>
                        <td colspan="3"><br/></td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <table width="70%" border="0" cellspacing="0" align="center" id="tablam">              
                                <tr>
                                    <td>Banco</td>
                                    <td>Importe.</td>
                                    <td colspan="2">Fecha Liq.</td>
                                    <td>Estatus</td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td align="center">
                                        <%
                                          comboBox = new HTML();
                                          out.println( "" + comboBox.getComboBox( "ent", cbBancos, "Selecciona un Banco" , monto.getEnt()) );
                                        %>
                                        <span id = "txtEnt" class="ocultar">Elija una Opci&oacute;n</span>
                                    </td>
                                    <td width="50%" align="left" valign="bottom">
                                        &nbsp;
                                        <input name      ="imp" 
                                               value     ="<%=monto.getImp()%>" 
                                               type      ="text" 
                                               id        ="imp" 
                                               size      ="40" 
                                               maxlength ="14"
                                               align     ="middle"
                                               >
                                        <br><br>  
                                        <span id = "txtImp" class="ocultar">Ingrese un Monto</span>    
                                    </td>

                                    <td>
                                        <input name="txtfStartDate" type="text" id="txtfStartDate" size="15" maxlength="10" value=<%=(monto.getFecha().equalsIgnoreCase("") ? session.getAttribute("fechaHoy"): monto.getFecha())%>>
                                    </td>
                                    <td>
                                        <div align="left">
                                            <br>
                                            <a href="javascript:void(0)" onclick="if (self.gfPop)
                                    gfPop.fPopCalendar(document.frmTOCHeader.txtfStartDate);
                                return false;" hidefocus>
                                                <img name="popcalStart" src="scripts/calendar/calbtn.jpg"  border="0" alt="">
                                            </a>
                                            <br></br>                     
                                            <span id = "txtInitDate" class="ocultar">Selecciona una Fecha</span>
                                        </div>    
                                    </td>
                                    <td width="50%" align="left" colspan="2" valign="bottom">
                                        &nbsp;
                                        <select name="est" id="estatus">
                                            <option value="A" <%= monto.getEstatus().equalsIgnoreCase("A") ? " SELECTED " : "" %> >Activo</option>
                                            <option value="I" <%= monto.getEstatus().equalsIgnoreCase("I") ? " SELECTED " : "" %>>Inactivo</option>
                                        </select>
                                        <br><br>  
                                        <span id = "txtEstatus" class="ocultar">Seleccione una Opci&oacute;n</span>    
                                    </td>                    

                                </tr>
                                <tr>
                                    <td colspan="6">                    
                                        <span id = "txtMsg" class="ocultar">&nbsp;&nbsp;</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="6">
                                        <font color="#FF0000">
                                            <%=tMsg %>
                                        </font>   
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3"><br/></td>
                    </tr>
                    <tr>
                        <td align="left" width="30%">
                            &nbsp;&nbsp;
                            <a href="javascript:prc();">
                                <img alt="Ejecutar Prorrateo" src="<%=path%>/pics/icons/Gear.png">
                                Prorrateo.
                            </a>
                        </td>
                        <td align="center" width="40%">
                            &nbsp;
                            <input name   ="btnLstTOC" 
                                   type   ="submit" 
                                   id     ="btnLstTOC" 
                                   value  ="Aceptar" 
                                   onclick="javascript:return valida(this.form);"
                                   >                
                        </td>
                        <td width="30%" align="left">
                            &nbsp;
                        </td>
                    </tr>          
                    <tr>
                        <td colspan="3"><br/></td>
                    </tr>
                </table>
            </form> 
        </div>
        <iframe width="174" height="189" name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="scripts/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
        </iframe>
    </body>
</html>