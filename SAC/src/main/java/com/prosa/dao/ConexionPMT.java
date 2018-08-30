// ----------------------------------------------------------------------------
// Nombre del Programa : ConexionPMT
// Autor               : Manuel Villalobos
// Compania            : GSOF
// Proyecto/Procliente : C-08-2129-12                        Fecha: 07/AGO/2013
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

package com.prosa.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConexionPMT {
    private static ConexionPMT ref=null;
    private static DataSource ds;

    public ConexionPMT() {
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
            ref = new ConexionPMT();
        }
        System.out.println(ref.getClass());
        return ds;
    }
}
