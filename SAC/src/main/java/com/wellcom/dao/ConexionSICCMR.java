// ----------------------------------------------------------------------------
// Nombre del Programa : ConexionSICCMR
// Autor               : Manuel Villalobos
// Compania            : GSOF
// Proyecto/Procliente : B-54-2092-15                        Fecha: 04/MAY/2015
// Descripcion General : CLASE QUE REPRESENTA UNA CONEXION A LA BD PMT
// Programa Dependiente: N/A
// Programa Subsecuente: N/A
// Cond. de ejecucion  : N/A
// Dias de ejecucion   : N/A                                 Horario: N/A
//                              MODIFICACIONES
// ----------------------------------------------------------------------------
// Numero de Parametros:
// Parametros Entrada  :                                    Formato:
//
// Parametros Salida   : N/A                                Formato: N/A
// ----------------------------------------------------------------------------

package com.wellcom.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConexionSICCMR {
    private static ConexionSICCMR ref=null;
    private static DataSource ds;

    public ConexionSICCMR() {
        try {
            Context initCtx = new InitialContext();
            ds = (DataSource) initCtx.lookup("PMTUDBP");
        } catch (NamingException ne){
            System.out.println(ne.toString());
            ne.printStackTrace();
        }
    }

    public static DataSource getInstance(){
        if (ref == null) {
            ref = new ConexionSICCMR();
        }
        System.out.println(ref.getClass());
        return ds;
    }
}
