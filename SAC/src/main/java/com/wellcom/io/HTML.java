/*###############################################################################
# Nombre del Programa :  HTML.java		                                        #
# Autor               :  JOAQUIN MOJICA Q.                                      #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-08-299-04                 	   FECHA:15/10/2008     #
# Descripcion General :												           	#
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :  Acceder al sistema                                     #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :  A Peticion del web, se pueden ejecutar n instancias    #
#################################################################################
#								MODIFICACIONES                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-08-2253-12                Fecha: 13/02/2013          #
# Modificación        :  Adicionar indicadores ABM a Reporte de log certificado #
#-------------------------------------------------------------------------------#
# Autor               :  Gerardo G. Burguete                                    #
# Compania            :  Axia, consultores, S.A. DE C.V.                        #
# Proyecto/Procliente :  P-53-2933-14                 Fecha: 25/05/2015         #
# Modificacion        :  Re-calculo de compensación y administración de umbrales#
# Marca del Cambio    :  AXIA-GGB-P-53-2933-14                                  #
#-------------------------------------------------------------------------------#
# Autor               :                                                         #
# Compania            :                                                         #
# Proyecto/Procliente :                              Fecha:                     #
# Modificación        :                                                         #
#-----------------------------------------------------------------------------  #
# Numero de Parametros: 0                                                       #
###############################################################################*/

package com.wellcom.io;

import java.util.*;

import com.wellcom.exceptions.*;
//import org.apache.commons.validator.*;
import java.text.NumberFormat;

public class HTML {
    
    public HTML() {
        
        //this.comboBox = "";
        this.fieldsToValidate = null;
        this.cssTable = "";
        this.cssTRHeaderTable = "";
        this.cssTRDataTable = "";      
        //this.genericValidator = null;
    }
    
    public double getTotalSum(ArrayList rowValues, int idx) throws WellException {
        try {
            if (rowValues == null) {
                throw new WellException(
                    "com.wellcom.io.HTML.getTotalSum: Parámetros inválidos");
            }
            
            double result = 0.00;
            String rv[] = null;
            
            Iterator it = rowValues.iterator();
            while (it.hasNext()) {
                
                rv = (String[]) it.next();
                if (rv[idx] != null) {
                    Double rslt = Double.valueOf(rv[idx]);
                    result += rslt.doubleValue();
                }
            }
            return result;
            
        } catch (Exception ex) {
            System.out.println("result: ");
            return 0;
            
        }
    }
    
    /**
     * Se obtiene un "combobox" a partir de un conjunto de valores
     * @param name variable de tipo "String" que establece el nombre del
     * combobox
     * @param values variable de tipo "ArrayList" que contiene los valores
     * que mostrará el "combobox"
     * @return una cadena que describe un "combobox" con ciertos valores
     * @throws WellException
     */
    public String getComboBox(String name, ArrayList values, String label) throws WellException {
        
        if ( (name.length() <= 0) || (values == null)) {
            throw new WellException(
                "com.wellcom.io.HTML.getComboBox: Parámetros inválidos");
        }
        
        String result = "<select name=\"" + name + "\" id=\"" + name + "\">";
        result += "<option value=\"None\" selected>"+ label + "</option>";
       
        Iterator it = values.iterator();
        String cbValues[] = null;
        while (it.hasNext()) {
            
            cbValues = (String[]) it.next();
            
            result += "<option value=\""
                + cbValues[0] + "\">";
                
            if(cbValues.length == 1) {
                result += cbValues[0] + "</option>";
            } else {
                result += cbValues[1] + "</option>";
            }
        }       
        result += "</select>";
        return result;
    }
   
   
    
    //getComboBox con Evento
    /**
     * Se obtiene un "combobox" a partir de un conjunto de valores
     * @param name variable de tipo "String" que establece el nombre del
     * combobox
     * @param values variable de tipo "ArrayList" que contiene los valores
     * que mostrará el "combobox"
     * @param event Nombre del evento qu ocurra sobre el objecto
     * ej. onClick, onChange, onMouseMove,etc...
     * @param execute Nombre de la funcion javascript a ejecutar al ocurrir el evento
     * que contenga event
     * @param label texto que aparece cuando se muestra el comboBox por primea vez
     * @return una cadena que describe un "combobox" con ciertos valores
     * @throws WellException
     */
    public String getComboBox(String name, ArrayList values, String event, String execute, String label) throws WellException {
        
        if ( (name.length() <= 0) || (values == null)) {
            throw new WellException(
                "com.wellcom.io.HTML.getComboBox: Parámetros inválidos");
        }
        
        String result = "<select name=\"" + name + "\" id=\"" +name+ "\" " +event+ " = \"" + execute + "\">";
        result += "<option value=\"None\" selected>" + label + "</option>";
        Iterator it = values.iterator();
        String cbValues[] = null;
        while (it.hasNext()) {
            
            cbValues = (String[]) it.next();
            
            result += "<option value=\""
                + cbValues[0] + "\">";
                
            if(cbValues.length == 1) {
                result += cbValues[0] + "</option>";
            } else {
                result += cbValues[1] + "</option>";
            }
        }  
        result += "</select>";
        return result;
    }
    
    /**
     * Se obtiene un "ListBox" a partir de un conjunto de valores
     * @param name variable de tipo "String" que establece el nombre del
     * combobox
     * @param values variable de tipo "ArrayList" que contiene los valores
     * que mostrará el "combobox"
     * @return una cadena que describe un "combobox" con ciertos valores
     * @throws WellException
     */
    public String getListBox(String name, ArrayList values, String label) throws WellException {
        
        if ( (name.length() <= 0) || (values == null)) {
            throw new WellException(
                "com.wellcom.io.HTML.getComboBox: Parámetros inválidos");
        }
        
        String result = "<select name=\"" + name + "\" id=\"" + name + "\" multiple=\"multiple\">";
        result += "<option value=\"None\" selected>"+ label + "</option>";
        Iterator it = values.iterator();
        String cbValues[] = null;
        while (it.hasNext()) {
            
            cbValues = (String[]) it.next();
            
            result += "<option value=\""
                + cbValues[0] + "\">";
                
            if(cbValues.length == 1) {
                result += cbValues[0] + "</option>";
            } else {
                result += cbValues[1] + "</option>";
            }
        }       
        result += "</select>";
        return result;
    }
    
    /**
     * Se obtiene un "ListBox" a partir de un conjunto de valores
     * @param name variable de tipo "String" que establece el nombre del
     * combobox
     * @param values variable de tipo "ArrayList" que contiene los valores
     * que mostrará el "combobox"
     * @param event Nombre del evento qu ocurra sobre el objecto
     * ej. onClick, onChange, onMouseMove,etc...
     * @param execute Nombre de la funcion javascript a ejecutar al ocurrir el evento
     * que contenga event
     * @param label texto que aparece cuando se muestra el comboBox por primea vez
     * @return una cadena que describe un "combobox" con ciertos valores
     * @throws WellException
     */
    public String getListBox(String name, ArrayList values, String event, String execute, String label) throws WellException {
        
        if ( (name.length() <= 0) || (values == null)) {
            throw new WellException(
                "com.wellcom.io.HTML.getComboBox: Parámetros inválidos");
        }
        
        String result = "<select name=\"" + name + "\" id=\"" +name+ "\" " +event+ " = \"" + execute + "\" multiple=\"multiple\">";
        result += "<option value=\"None\" selected>" + label + "</option>";
        Iterator it = values.iterator();
        String cbValues[] = null;
        while (it.hasNext()) {
            
            cbValues = (String[]) it.next();
            
            result += "<option value=\""
                + cbValues[0] + "\">";
                
            if(cbValues.length == 1) {
                result += cbValues[0] + "</option>";
            } else {
                result += cbValues[1] + "</option>";
            }
        }
        result += "</select>";
        return result;
    }
/*--------------------------------------------------------------------------- */
/* Marca del Cambio: AXIA-GGB-P-53-2933-14 Inicia  la Modificacion 25/05/2015 */
/*----------------------------------------------------------------------------*/
    /**
     * Se obtiene un "combobox" a partir de un conjunto de valores
     * @param name variable de tipo "String" que establece el nombre del
     * combobox
     * @param values variable de tipo "ArrayList" que contiene los valores
     * que mostrará el "combobox"
     * @return una cadena que describe un "combobox" con ciertos valores
     * @throws WellException
     */
    public String getComboBox(String name, ArrayList values, String label, String selected) throws WellException {
        
        if ( (name.length() <= 0) || (values == null)) {
            throw new WellException(
                "com.wellcom.io.HTML.getComboBox: Parámetros inválidos");
        }
        
        String result = "<select name=\"" + name + "\" id=\"" + name + "\">";
        result += "<option value=\"None\" selected>"+ label + "</option>";
       
        Iterator it = values.iterator();
        String cbValues[] = null;
        while (it.hasNext()) {
            
            cbValues = (String[]) it.next();
            
            result += "<option value=\""
                + cbValues[0] + "\"" + (selected.equalsIgnoreCase(cbValues[0]) ? " SELECTED " : "") + ">";
                
            if(cbValues.length == 1) {
                result += cbValues[0] + "</option>";
            } else {
                result += cbValues[1] + "</option>";
            }
        }       
        result += "</select>";
        return result;
    }
/*--------------------------------------------------------------------------- */
/* Marca del Cambio: AXIA-GGB-P-53-2933-14 Termina la Modificacion 25/05/2015 */
/*----------------------------------------------------------------------------*/

     /**
     * Valida los campos de la Forma HTML especificados por el usuario con la
     * función <em>addFieldToValidate</em>
     * @return Un arreglo de cadenas que especifica los campos inválidos. En
     * caso de que todos sean válidos el resultado es null.
     * @throws WellException
     */
    public ArrayList validateFields() throws WellException {
        ArrayList invalidFields = new ArrayList(0);
        
        if (this.fieldsToValidate == null) {
            return invalidFields;
        }
    /*            throw new WellException(
     "com.wellcom.io.HTML.validateFields: No ha especificado "
                        + "ningún campo para validar." );
     */
        Set set = this.fieldsToValidate.entrySet();
        Iterator it = set.iterator();
        String fieldValue = "";
        
        while (it.hasNext()) {
            
            Map.Entry me = (Map.Entry) it.next();
            fieldValue = (String) me.getValue();
      /*
       * Modificado el 08/Mar/07 por AFI
       */
            //if (!fieldValue.equals("") && !fieldValue.equals("None")) {
            if(!fieldValue.equals("")
                && !fieldValue.equals("None")) {
                it.remove();
            } else {
                invalidFields.add( (String) me.getKey());
            }
        }
        
        return invalidFields;
    }
    
    /**
     * Agrega un nuevo elemento a la lista de campos que serán validados de
     * una Forma HTML
     * @param value cadena que especifica el nombre del campo a ser validado
     * @throws WellException
     */
    public void addFieldToValidate(String fieldName, String value) throws
        WellException {
        
        if ( (fieldName.length() <= 0)) {
            throw new WellException(
                "com.wellcom.io.HTML.AddFieldToValidate: "
                + "Parámetros inválidos.");
        }
        
        if (this.fieldsToValidate == null) {
            this.fieldsToValidate = new HashMap(1);
        }
        
        this.fieldsToValidate.put(fieldName, value);
    }
    
    /**
     * Limpia la lista de campos a validar
     */
    public void clearFieldsToValidate() {
        
        if (this.fieldsToValidate != null) {
            this.fieldsToValidate.clear();
        }
    }
    
    public void setCSSTable(String value) {
        
        if (value.length() > 0) {
            this.cssTable = value;
        }
    }
    
    public void setCSSTRHeaderTable(String value) {
        
        if (value.length() > 0) {
            this.cssTRHeaderTable = value;
        }
    }
    
    public void setCSSTRDataTable(String value) {
        
        if (value.length() > 0) {
            this.cssTRDataTable = value;
        }
    }
    
    public void setCSSTRTable(String value) {
        
        if (value.length() > 0) {
            this.cssTRDataTable = value;
        }
    }
    
    public void setCSSTDDateTable(String value)
    {
    	if(value.length() > 0)
    	{
    		this.cssTDDateTable = value;
    	}
    	
    }
    
    /**
     * Genera un campo de texto
     * @param id Identificardor del cuadro de texto
     * @param maxlength Tamano maximo que puede escribir
     * en el cuadro de texto
     * @param size Tamano del cuadro de texto
     * @return una cadena que describe un "inputText"
     * @throws WellException
     */
    public String getinputText(String id, int maxlength, int size) throws WellException
    {
    	String result = "<input id=\"" + id + "\" name=\"" + id + "\" type=\"text\" maxlength=\""+ maxlength + "\" size=" + size +"/>";
    	return  result;
    }
    
    public String getinputPwdText(String id, String value, int maxlength,  int size) throws WellException
    {
    	String result = "<input id=\"" + id + "\" name=\"" + id + "\" type=\"text\"  maxlength=\""+ maxlength + "\" size=" + size +" value=\""+value+"\"/>";
    	return  result;
    }

    /**
     * Genera un campo de texto que esta bloqueado
     * @param id Identificardor del cuadro de texto
     * @param value Valor que contiene el inputText
     * @param maxlength Tamano maximo que puede escribir
     * en el cuadro de texto
     * @param size Tamano del cuadro de texto
     * @return una cadena que describe un "inputText"
     * @throws WellException
     */
    public String getinputTextBlock(String id, String value, int maxlength, int size) throws WellException
    {
    	if(value == "" || value == null || value.equals(" "))
    		value = "\"\"";
    	
    	String result = "<input id=\"" + id + "\" name=\"" + id + "\" type=\"text\" value = \"" + value + "\" maxlength=\""+ maxlength + "\" size=" + size + " readonly='readonly'/>";
    	return  result;
    }

	/********** Inicio Modificacion WELLCOM N-08-2253-12  **********/
	    public String getinputLabel(String id, String value) throws WellException
    {
    	if(value == "" || value == null || value.equals(" "))
    		value = "";
    	else if(value=="-1")
    		value = "sin valor";
    	
    	String result = "<label id=\"" + id + "\" name=\"" + id + "\">"+ value +"</label>";
    	return  result;
    }
	/********** Fin    Modificacion WELLCOM N-08-2253-12  **********/

    /**
     * Genera una Tabla HTML
     * @param id Coloca el identificardor a la tabla
     * @param colTitles Arreglo de cadenas que contiene
     * los títulos de las columnas
     * @Param numCols Numero de columnas que se crearan en la tabla
     * @param rowValues variable que contiene los valores de
     * las filas de la tabla
     * @param eventOnClick nombre de la funcion javascript a ejecutar
     * cuando ocurra el evento click sobre una fila
     * @param eventOnMouseover nombre de la funcion javascript a ejecutar
     * cuando el puntero del mouse se posicione encima del elemento
     * @param eventOnMouseout nombre de la funcion javascript a ejecutar
     * cuando el puntero del mouse este fuera del objeto
     * @return Una cadena que específica una Tabla HTML
     * @throws WellException
     */
    public String getTable(String id, String[] colTitles, int numCols ,ArrayList rowValues, String eventOnClick, String eventOnMouseover, String eventOnMouseout) throws
        WellException {
        
        String result = "";
        String rowValue = "";
        
        if ( (colTitles == null) || (rowValues == null)) 
        {
            throw new WellException(
                "com.wellcom.io.HTML.getTable: "
                + "Parámetros inválidos.");
        }

        result =
            "<table id=\"" + id + "\" class=\"" + this.cssTable + "\" width=\"100%\" border=\"0\" cellspacing=\"1\" cellpadding=\"1\">"
            + "<tr class=\"" + this.cssTRHeaderTable + "\">";
        
        //Encabezados de Columna
        
        //int numColTitles = colTitles.length;
        for (int i = 0; i < numCols; i++) 
        {       
            result += "<td style='border-right:1px solid #ccc;'>" + colTitles[i] + "</td>";
        }
        result += "</tr>";
        
        //Filas
      
        Iterator it = rowValues.iterator();
        
        while (it.hasNext()) 
        {    
            String rowVals[] = (String[]) it.next();
            int rowLength = rowVals.length;
            result += "<tr class=\"" + this.cssTRDataTable + "\" onclick = \"" + eventOnClick + 
            "\" onmouseover= \"" +	eventOnMouseover + "\" onmouseout= \"" + eventOnMouseout +  "\">";
            
            for (int i = 0; i < numCols; i++) 
            {
                rowValue = rowVals[i];
                result += "<td class=\""+ this.cssTDDateTable + "\">" + rowValue + "</td>";
            }
         }
            result += "</tr>";
        result += "</table>";      
        return result;
    }
    
    /**
     * Genera una Tabla HTML
     * @param id Coloca el identificardor a la tabla
     * @param colTitles Arreglo de cadenas que contiene
     * los títulos de las columnas
     * @param rowValues variable que contiene los valores de
     * las filas de la tabla
     * @param eventOnClick nombre de la funcion javascript a ejecutar
     * cuando ocurra el evento click sobre una fila
     * @param eventOnMouseover nombre de la funcion javascript a ejecutar
     * cuando el puntero del mouse se posicione encima del elemento
     * @param eventOnMouseout nombre de la funcion javascript a ejecutar
     * cuando el puntero del mouse este fuera del objeto
     * @return Una cadena que específica una Tabla HTML
     * @throws WellException
     */
    public String getTable(String id, String[] colTitles ,ArrayList rowValues, String eventOnClick, String eventOnMouseover, String eventOnMouseout) throws
        WellException {
        
        String result = "";
        String rowValue = "";
        
        if ( (colTitles == null) || (rowValues == null)) 
        {
            throw new WellException(
                "com.wellcom.io.HTML.getTable: "
                + "Parámetros inválidos.");
        }

        result =
            "<table id=\"" + id + "\" class=\"" + this.cssTable + "\" width=\"100%\" border=\"0\" cellspacing=\"1\" cellpadding=\"1\">"
            + "<tr class=\"" + this.cssTRHeaderTable + "\">";
        
        //Encabezados de Columna
        
        int numColTitles = colTitles.length;
        for (int i = 0; i < numColTitles; i++) 
        {       
            result += "<td style='border-right:1px solid #ccc;'>" + colTitles[i] + "</td>";
        }
        result += "</tr>";
        
        //Filas
      
        Iterator it = rowValues.iterator();
        
        while (it.hasNext()) 
        {    
            String rowVals[] = (String[]) it.next();
            int rowLength = rowVals.length;
            result += "<tr class=\"" + this.cssTRDataTable + "\" onclick = \"" + eventOnClick + 
            "\" onmouseover= \"" +	eventOnMouseover + "\" onmouseout= \"" + eventOnMouseout +  "\">";
            
            for (int i = 0; i < rowLength; i++) 
            {
                rowValue = rowVals[i];
                result += "<td class=\""+ this.cssTDDateTable + "\">" + rowValue + "</td>";
            }
         }
            result += "</tr>";
        result += "</table>";      
        return result;
    }
    
    /**
     * Genera una Tabla HTML
     * @param colTitles Arreglo de cadenas que contiene
     * los títulos de las columnas
     * @param rowValues variable que contiene los valores de
     * las filas de la tabla
     * @return Una cadena que específica una Tabla HTML
     * @throws WellException
     */
    public String getTableRadioBtn(String[] colTitles, ArrayList rowValues) throws
        WellException {
        
        String result = "";
        int j = 0;
        
        if ( (colTitles == null) || (rowValues == null)) {
            throw new WellException(
                "com.wellcom.io.HTML.getTable: "
                + "Parámetros inválidos.");
        }
        
        result =
            "<table width=\"95%\" border=\"1\" cellspacing=\"1\" cellpadding=\"1\">"
            + "<tr class=\"" + this.cssTable + "\">";
        
        int numColTitles = colTitles.length;
        for (int i = 0; i < numColTitles; i++) {
            
            //Agregado el 27/Abr/2006 por Armando F. Ibarra
            colTitles[i] = colTitles[i].replaceAll("\r\n|\n", "");
            
            result += "<td><div align=\"center\">" + colTitles[i] + "</div></td>";
        }
        result += "</tr>";
        
        Iterator it = rowValues.iterator();
        while (it.hasNext()) {
            
            String rowVals[] = (String[]) it.next();
            int rowLength = rowVals.length;
            result += "<tr class=\"" + this.cssTRDataTable + "\">";
            
            for (int i = 0; i < rowLength; i++) {
                //Agregado el 27/Abr/2006 por Armando F. Ibarra
                rowVals[i].replaceAll("\r\n|\n", "");
                result += "<td>" + rowVals[i] + "</td>";
                //Agregado el 03/Sep/2006 por Armando F. Ibarra
                if (i == (rowLength - 1)) {
                    //result += "<td>" + "<input name=\"" + j + "\" type=\"radio\" value=\"" + j + "\">" + "</td>";
                    result += "<td>" + "<input name=\"rbtn\" type=\"radio\" value=\"" + j +
                        "\">" + "</td>";
                    
                    j++;
                }
            }
            result += "</tr>";
        }
        result += "</table>";
        
        return result;
    }
    
    public static void main(String[] args) {
        HTML HTML1 = new HTML();
    }
    
  /*
   * Campos
   */
    //private String comboBox;
    private HashMap fieldsToValidate;
    private String cssTable;
    private String cssTRHeaderTable = "";
    private String cssTRDataTable = "";
    private String cssTDDateTable = "";
    //private org.apache.commons.validator.GenericValidator genericValidator;
}
