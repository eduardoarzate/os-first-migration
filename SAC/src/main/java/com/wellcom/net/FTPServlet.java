/*###############################################################################
# Nombre del Programa :  FTPServlet.java                                        #
# Autor               :  JOAQUIN MOJICA Q.                                      #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-08-299-04                 	   FECHA:15/10/2008     #
# Descripcion General :	 Clase para el manejo de la seguridad, creacion de      #
#              			 archivos .xsl. 								        #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :  Acceder al sistema                                     #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :  A Peticion del web, se pueden ejecutar n instancias    #
#################################################################################
#								MODIFICACIONES                                  #
# Autor               :                                                         #
# Compania            :                                                         #
# Proyecto/Procliente :                              Fecha:                     #
# Modificación        :                                                         #
#-----------------------------------------------------------------------------  #
# Numero de Parametros: 0                                                       #
###############################################################################*/

package com.wellcom.net;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * <p>Título: ExcelServlet</p>
 * <p>Descripción: Servlet para la creación de archivos .xls</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Compañía: Wellcom</p>
 * @author M. en C. Armando F. Ibarra
 */
public class FTPServlet
  extends HttpServlet implements Serializable {

  static final private String CONTENT_TYPE = "application/octet-stream";

  public void init(ServletConfig config) throws ServletException {

    super.init(config);
  }

  /**
   * Atiende a las peticiones "GET" y "POST"
   * @param request de éste parámetro se obtienen los valores necesarios
   * para regresar un archivo de tipo .xls
   * @param response -
   * @throws ServletException
   */
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException {

    try {

      // Stream de salida
      ByteArrayOutputStream bOut;

      HttpSession session = request.getSession(true);
      String sessionID = session.getId() + "FTP";
      String ftpID = request.getParameter("sessionIDFTP");
      String fileName = request.getParameter("fileName");
      if (fileName == null) {
        fileName = "archivo";
      }

      if (sessionID.equals(ftpID)) {

        bOut = (ByteArrayOutputStream) session.getAttribute(ftpID);
        StringBuffer attachment = new StringBuffer();
        attachment.append("attachment; filename=\"");
        attachment.append(fileName);
        attachment.append(".xls\"");
        response.setContentType(CONTENT_TYPE);
        response.setHeader("Content-Disposition",
                           attachment.toString());
        response.setHeader("Content-Description",
                           "Archivo Microsoft Excel");
        ServletOutputStream out = response.getOutputStream();
        bOut.writeTo(out);
        out.flush();
        out.close();
      }
    }
    catch (Exception ex) {
      System.out.println(ex.toString());
    }
  }

  public void doPost(HttpServletRequest request,
                     HttpServletResponse response) throws ServletException {

    this.doGet(request, response);
  }
}
