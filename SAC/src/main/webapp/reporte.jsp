 <!--
/*###############################################################################
# Nombre del Programa :  reporte.jsp                                            #
# Autor               :  Salvador Montiel                                       #
# Compania            :  AM Estudio                                             #
# Proyecto/Procliente :  P-54-2940-14                     FECHA:27/04/2015      #
# Descripcion General :  Soporte interactivo (Chat FAQ Tutoriales y Manuales)   #
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :                                                         #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :                                                         #
#################################################################################
#                               MODIFICACIONES                                  #
# Autor               :                                                         #
# Compania            :                                                         #
# Proyecto/Procliente :                                                         #
#                                                        Fecha:                 #
# Modificación        :                                                         #
#                                                                               #
#-----------------------------------------------------------------------------  #
# Numero de Parametros: 0                                                       #
###############################################################################*/
-->
<%
 response.setHeader("Pragma","no-cache");
 response.setHeader("Cache-Control","no-cache");
 response.setHeader("Expires","0");
%>

<%
    HttpSession sesion = request.getSession();
    byte[] bytes = (byte[])sesion.getAttribute("bytes");
    
    if(bytes != null)
    {
          response.setContentType("application/pdf");
          response.setContentLength(bytes.length);
          ServletOutputStream ouputStream = null;
          ouputStream = response.getOutputStream();
          ouputStream.write(bytes, 0, bytes.length);
          ouputStream.flush();
          ouputStream.close();
    }
%>
