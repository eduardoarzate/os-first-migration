// ----------------------------------------------------------------------------
// Nombre del Programa : CatalogoWrapper
// Autor               : Manuel Villalobos
// Compania            : GSOF
// Proyecto/Procliente : C-08-2129-12                        Fecha: 07/AGO/2013
// Descripcion General : CLASE QUE REPRESENTA UN DECORADOR PARA LISTADO DE CATALOGOS
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

import com.prosa.beans.AfiliacionObj;
import com.prosa.beans.CuentaObj;
import com.wellcom.beans.*;
import java.util.*;
import java.text.*;
import org.displaytag.decorator.TableDecorator;

public class CatalogoWrapper extends TableDecorator
{
    public CatalogoWrapper()
    {
        super();
    }

    // REQUERIDO, SIEMPRE DEVUELVE NULO
    public String getNullValue()
    {
        return null;
    }

    // DEVUELVE EL CHECKBOX
    public String getCheckCuenta()
    {
        String liga     = "&nbsp";
        String clave    = ((CuentaObj)this.getCurrentRowObject()).getCuenta();

        try {
            // SE COLOCA EL CHECKBOX EN CADA ELEMENTO
            liga = "<input type=\"checkbox\" name=\"idcuenta\" value=\"" + clave
            + "\" onclick=\"javascript:unSoloCheckBox(this)\"> ";
        } catch (Exception e) {
            return "";
        }

        return liga;
    }

    // DEVUELVE EL CHECKBOX
    public String getCheckAfiliacion()
    {
        String liga     = "&nbsp";
        String clave    = ((AfiliacionObj)this.getCurrentRowObject()).getAfiliacion();

        try {
            // SE COLOCA EL CHECKBOX EN CADA ELEMENTO
            liga = "<input type=\"checkbox\" name=\"idafiliacion\" value=\"" + clave
            + "\" onclick=\"javascript:unSoloCheckBox(this)\"> ";
        } catch (Exception e) {
            return "";
        }

        return liga;
    }
}
