/*###############################################################################
# Nombre del Programa :  SessionConnetion.java                                  #
# Autor               :  JOAQUIN MOJICA Q.                                      #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-08-299-04                 	   FECHA:15/10/2008     #
# Descripcion General :	 Clase para el manejo de la seguridad                   #
#                                                                               #
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

package com.wellcom.sql;

import java.sql.*;
import javax.servlet.http.*;

import com.wellcom.exceptions.*;

public class SessionConnection
  implements HttpSessionBindingListener {

  private Connection connection;

  public SessionConnection() {

    connection = null;
  } 

  public SessionConnection(Connection value) {

    this.connection = value;
  }

  public Connection getConnection() {

    return this.connection;
  }

  public void setConnection(Connection value) throws WellException {

    if (value != null) {
      this.connection = value;
    }
    else {
      throw new WellException("com.wellcom.sql.setConnection : "
                              + "Parametro NULL");
    }
  }

  public void valueBound(HttpSessionBindingEvent value) {

    if (this.connection != null) {

      System.out.println("Binding a valid connection");
    }
    else {
      System.out.println("Binding a null connection");
    }
  }

  public void valueUnbound(HttpSessionBindingEvent value) {

    if (this.connection != null) {

      System.out.println("Closing the bound connection...");

      try {
        this.connection.close();
      }
      catch (SQLException e) {
        System.out.println(e.toString());
      }
    }
  }
}
