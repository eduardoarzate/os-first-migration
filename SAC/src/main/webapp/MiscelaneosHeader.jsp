<%
/*###############################################################################
# Nombre del Programa :  MiscelaneosHeader.java                                 #
# Autor               :  Melany Arenas Ayala                                    #
# Compania            :  IDSYS S.A. DE C.V.                                     #
# Proyecto/Procliente :  N-08-2033-13                      FECHA:15/05/2013     #
# Descripcion General :                                                         #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :                                                         #
# Dias de ejecucion   :                                                         #
#################################################################################
#                MODIFICACIONES                                                 #
#------------------------------------------------------------------------------ #
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#------------------------------------------------------------------------------ #
# Numero de Parametros: 0                                                       #
###############################################################################*/
%>
<jsp:useBean id="ga" scope="session" class="com.wellcom.prosa.sacii.GrantAccess"/>

<%--
    if(!ga.AccessGranted(session, "grantAccess")){
        response.sendRedirect("login.jsp");
    }
--%>

<%@page contentType="text/html" errorPage="errorPage.jsp"%>
<%@page pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <!--title>MISCELANEOS 103</title-->
        <link href="css/styles.css" rel="stylesheet" type="text/css">
        <!--script type="text/javascript">
            function valida(){
                var text = document.getElementById("val_misc");
                if(text.value != '')
                    if (!(/^\d+$|(^\d+\.?\d+$)/.test(text.value))){
                        alert("El número introducido no es válido");
                        return false;
                    }
                return true;
            }
        </script-->
    </head>

    <body>
        <div align="center">
            <!--Modificacion: SAS-DRT F-52-8063-16 Marca de inicio-->
            <form action="ControllerServletMisc?action=Miscelaneos.do" method="post" name="frmTipoCambioHeader">
                <!--Modificacion: SAS-DRT F-52-8063-16 Marca de fin-->
                <table  width="100%" border="0" cellspacing="0" cellpadding="0" class="tbl_border" >
                    <thead>
                        <tr>
                            <th id= "tituloTab" width="100%" colspan=5 ><font color="#000000">Miscelaneos Cr&eacutedito y D&eacutebito</font><font color="#000000"></font><br></th>
                        </tr>
                        <tr></tr>
                    </thead>
                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="3"><br/></td>
                    </tr>

                    <tbody>
                        <tr>
                            <td align="rigth">Miscelaneo Cr&eacutedito Ventas:</td>
                            <td align="rigth"><input id="val_misc" name="txtCreVen"  type="text"  size="15" maxlength="5" value="" AUTOCOMPLETE="OFF" /></td>
                        </tr>

                        <tr>
                            <td align="rigth">Miscelaneo Cr&eacutedito Pago:</td>
                            <td align="rigth"><input id="val_misc" name="txtCrePag"  type="text" size="15" maxlength="5" value="" AUTOCOMPLETE="OFF" /></td>
                        </tr>

                        <tr>
                            <td align="rigth">Miscelaneo Cr&eacutedito Devoluciones:</td>
                            <td align="rigth"><input id="val_misc" name="txtCreDev"  type="text" size="15" maxlength="5" value="" AUTOCOMPLETE="OFF" /></td>
                        </tr>

                        <tr></tr>
                        <tr></tr>

                        <tr>
                            <td align="rigth">Miscelaneo D&eacutebito Ventas:</td>
                            <td align="rigth"><input id="val_misc" name="txtDebVen"  type="text" size="15" maxlength="5" value="" AUTOCOMPLETE="OFF" /></td>
                        </tr>

                        <tr>
                            <td align="rigth">Miscelaneo D&eacutebito Pago:</td>
                            <td align="rigth"><input id="val_misc" name="txtDebPag"  type="text" size="15" maxlength="5" value="" AUTOCOMPLETE="OFF" /></td>
                        </tr>

                        <tr>
                            <td align="rigth">Miscelaneo D&eacutebito Devoluciones:</td>
                            <td align="rigth"><input id="val_misc" name="txtDebDev"  type="text" size="15" maxlength="5" value="" AUTOCOMPLETE="OFF" /></td>
                        </tr>

                        <tr> </tr>
                        <tr> </tr>
                        <tr>
                            <td align="left" colspan="2">Observaciones:</td>
                        </tr>
                        <tr>
                            <td align="center" colspan="2"><textarea name="observ" maxlength="200" rows="4" cols="40" AUTOCOMPLETE="OFF"> </textarea></td>
                        </tr>
                        <tr> </tr>
                        <tr> </tr>

                        <tr bgcolor="#CC0000">
                            <td colspan="2">
                                <div align="center">
                                    <input type="submit" name=btnGuardar"  value="Guardar"/>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html>
