// ----------------------------------------------------------------------------
// Nombre del Programa : ConsultaWrapper
// Autor               : Manuel Villalobos
// Compania            : GSOF
// Proyecto/Procliente : C-08-2129-12                        Fecha: 07/AGO/2013
// Descripcion General : CLASE QUE REPRESENTA UN DECORADOR PARA LISTADO DE RESULTADOS
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

package com.prosa.wrapper;

import com.prosa.beans.ListadoObj;
import com.wellcom.beans.*;
import java.util.*;
import java.text.*;
import org.displaytag.decorator.TableDecorator;

public class ConsultaWrapper extends TableDecorator
{
    public ConsultaWrapper()
    {
        super();
    }

    // REQUERIDO, SIEMPRE DEVUELVE NULO
    public String getNullValue()
    {
        return null;
    }

    // DEVUELVE EL TIPO
    public String getTipo()
    {
        if(((ListadoObj)this.getCurrentRowObject()).getTtr_numero().compareTo("1") == 0){
            return "Venta";
        } else {
            return "Devolución";
        }
    }

    // DEVUELVE LA CUENTA ENMASCARADA
    public String getEnmascarada()
    {
        String cuenta = ((ListadoObj)this.getCurrentRowObject()).getCuenta();
        return cuenta.substring(0, 6) + "******" + cuenta.substring(12);
    }
}
