<%
/*###############################################################################
# Nombre del Programa :  SICTRC0001Header.jsp                                   #
# Autor               :  Juan Rodriguez Gonzalez.                               #
# Compania            :  IDSYS S.A. DE C.V.                                     #
# Proyecto/Procliente :  P-22-0136-14                      FECHA:10/11/2014     #
# Descripcion General :                                                         #
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :                                                         #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :                                                         #
#################################################################################
#                MODIFICACIONES                                                 #
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
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>
<%!ArrayList cbBancoAdqInterRedValues;
  HTML comboBox;
  ComboBoxGen myComboBox;%>
<%
    if(!ga.AccessGranted(session, "grantAccess"))
    {
        response.sendRedirect("login.jsp");
    }
   myComboBox = new ComboBoxGen();
   //cbBancoAdqInterRedValues  = myComboBox.getBancoSacD065(session);
   cbBancoAdqInterRedValues = myComboBox.getBancoTranscod(session);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>SAC 2</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css">
    </head>
    <script type="text/javascript">
        var span = null;
        var showTextInitDate = false;
        var showTextEndDate = false;
        var showTextBanco = false;
        var showTextCtaOri = false;
        var showTexteCtaDes = false;

        function valida()
        {
          try
          {
            if(showTextInitDate)
            {
                 span = document.getElementById("txtInitDate");
                 span.style.display = 'none';
                 showTextInitDate = false;
                }

                else if(showTextEndDate)
            {
              span = document.getElementById('txtEndDate');
              span.style.display = 'none';
              showTextEndDate = false;
                }

                else if(showTextBanco)
            {
              span = document.getElementById('txtBanco');
              span.style.display = 'none';
              showTextBanco = false;
            }
   else if(showTextCtaOri)
            {
              span = document.getElementById('txtfCtaOri');
              span.style.display = 'none';
              showTextCtaOri = false;

            }   else if(showTexteCtaDes)
            {
              span = document.getElementById('txtfCtaDes');
              span.style.display = 'none';
              showTexteCtaDes = false;
            }
         if(document.frmTOCHeader.txtfStartDate.value == "" || document.frmTOCHeader.txtfStartDate.value == null)
            {
              span = document.getElementById("txtInitDate");
                 span.style.display = 'inline';
                 showTextInitDate = true;
                 return false;
            }

            else if(document.frmTOCHeader.txtfEndDate.value == "" || document.frmTOCHeader.txtfEndDate.value == null)
            {
              span = document.getElementById('txtEndDate');
              span.style.display = 'inline';
              showTextEndDate = true;
              return false;
            }

            else if(document.frmTOCHeader.banco.value == "None")
            {
              span = document.getElementById('txtBanco');
              span.style.display = 'inline';
              showTextBanco = true;
              return false;
            }
            else if(document.frmTOCHeader.CtaOri.value == "None")
            {
              span = document.getElementById('txtCtaOri');
              span.style.display = 'inline';
              showTextCtaOri = true;
              return false;
            }
else if(document.frmTOCHeader.CtaDes.value == "None")
            {
              span = document.getElementById('txtCtaDes');
              span.style.display = 'inline';
              showTextCtaDes = true;
              return false;
            }

            else
            {
              return true;
            }
            }
            catch(e)
            {

            }

          }
        </script>
    <body>
        <div align="center">
            <form action="ControllerServletTrascod?action=SICTRC0001Main" method="post" name="frmTOCHeader" target="mainFrameTOC" id="frmTOCHeader">
                <table width="100%" border="0" cellspacing="0" id="tabla">
                <tr>
                   <th id="tituloTab" width="100%" colspan="5" align="left"><font color="#000000">SICTRC0001 - Consulta de cuentas trascodificadas<br></font></th>
                </tr>

        <tr>
          <td>&nbsp;</td>
          <td colspan="4"><br/></td>
        </tr>

                    <tr>
                      <td>&nbsp;</td>
                        <td align="left"><strong>Fecha Inicio:</strong></td>
                        <td align="left">
                                <input name="txtfStartDate" type="text" id="txtfStartDate" size="15" readonly maxlength="15" value=<%=session.getAttribute("fechaHoy")%>>
                                <a href="javascript:void(0)" onclick="if(self.gfPop)gfPop.fPopCalendar(document.frmTOCHeader.txtfStartDate);return false;" hidefocus>
                                    <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg" border="0" alt="">
                                </a><br/>
                                <span id = "txtInitDate" class="ocultar">Selecciona una fecha</span> <%//agregar class%>
                        </td>
                        <td align="left"><strong>Fecha Fin:</strong></td>
                        <td align="left">
                                <input name="txtfEndDate" type="text" id="txtfEndDate" size="15" readonly maxlength="15" value=<%=session.getAttribute("fechaHoy")%>>
                                <a href="javascript:void(0)" onclick="if(self.gfPop)gfPop.fPopCalendar(document.frmTOCHeader.txtfEndDate);return false;" hidefocus>
                                    <img name="popcalStart" align="absmiddle" src="scripts/calendar/calbtn.jpg" border="0" alt="">
                                </a><br/>
                                <span id = "txtEndDate" class="ocultar">Selecciona una fecha</span>
                        </td>
                    </tr>

            <tr>
              <td>&nbsp;</td>
              <td align="left"><strong>Banco:</strong></td>
              <td align="left">
                <% comboBox = new HTML();
                             out.println( "" + comboBox.getListBox( "numFiid", cbBancoAdqInterRedValues, "Selecciona la Entidad" ) );
                          %><br/>
                          <span id = "numFiid" class="ocultar">Elije una Opciónn</span>
              </td>
              <td><br/></td>
              <td><br/></td>
            </tr>

            <tr>
            <td>&nbsp;</td>
            <td colspan="4"><br/></td>
          </tr>

            <tr>
                <td>&nbsp;</td>
                <td align="left"><strong>Cuenta Origen:</strong></td>
                        <td align="left">
                          <input name="txtfCtaOri" type="text" id="txtfCtaOri" size="20"  maxlength="20" value="" >
                     <span id = "txtfCtaOri" class="ocultar">Escribe la cuenta origen</span>
                        </td>
                <td align="left"><strong>Cuenta Destino:</strong></td>
                        <td align="left">
                          <input name="txtfCtaDest" type="text" id="txtfCtaDest" size="20" maxlength="20" value="" >
                   <span id = "txtfCtaDest" class="ocultar">Escribe la cuenta destino</span>
                        </td>
            </tr>

            <tr>
                <td>&nbsp;</td>
                <td colspan="4" align="left">
                    <input name="btnLstTOC" type="submit" id="btnLstTOC" value="Mostrar Reporte" onclick="javascript:return valida(this.form);">
                </td>
            </tr>

            <tr>
                <td>&nbsp;</td>
                <td colspan="4"><br/></td>
            </tr>
                </table>
          </form>
        </div>
        <iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="scripts/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
      </iframe>
    </body>
</html>
