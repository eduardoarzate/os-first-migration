/*###############################################################################
# Nombre del Programa :  Table.java		                                        #
# Autor               :  JOAQUIN MOJICA Q.                                      #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-08-299-04                 	   FECHA:15/10/2008     #
# Descripcion General :										        	        #
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :  Acceder al sistema                                     #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :  A Peticion del web, se pueden ejecutar n instancias    #
#################################################################################
#								MODIFICACIONES                                  #
# Autor               :  Carlos Mendez                                          #
# Compania            :  PROSA                                                  #
# Proyecto/Procliente :                              Fecha:  10/08/2012         #
# Modificación        :  Se sacan los queries al objeto CreateQueryTable.java   #
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-08-2253-12                Fecha: 13/02/2013          #
# Modificación        :  Adicionar indicadores ABM a Reporte de log certificado #
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-08-2253-12                Fecha: 08/04/2013          #
# Modificación        :  Adicionar indicadores ABM a Reporte de log certificado #
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                  #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  N-04-2207-13                Fecha: 02/12/2013          #
# Modificación        :  Actualización de LOG CERTIFICADO con Indicadores ABM a #
#						             detalle 											                        	#
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                                  #
# Autor               :  Gustavo Alberto Ramírez Franco                         #
# Compania            :  PROSA S.A. DE C.V.                                     #
# Proyecto/Procliente :  B-52-2251-14                Fecha: 25/03/2014          #
# Modificación        :  Se elimina el UNION con tabla de Visa por duplicar txns#
#-------------------------------------------------------------------------------#
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 13/03/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-------------------------------------------------------------------------------#
# Autor               :  German Gonzalez                                        #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  D-52-8122-17                 Fecha: 28/06/2017         #
# Modificacion        :  Mejora Reporteador  SC2                                #
# Marca del Cambio    :  WELL    D-52-8122-17                                   #
#-------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
package com.wellcom.prosa.sacii;

import com.wellcom.exceptions.WellException;
import com.wellcom.io.HTML;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
/*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
import com.wellcom.conexion.*;
/*#Marca de cambio:  SAS-DRT F-52-8063-16  Fin Modificación #  */
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Table {

    private static final int NUMERO_FILAS_PAGINA = 100;
    private String resultTable = null;
    private String[] titleCols = {"", "Fuente", "Archivo", "Fecha de Consumo", "Fecha de Proceso", "", "Banco Adquirente", "", "", "Banco Emisor", "", "No. de Autorizaci&oacute;n", "No. de Referencia", "No. de Cuenta", "", "Tipo de Transacci&oacute;n", "No. de Comercio", "Nombre del Comercio", "Giro Comercial", "Importe Total Transacci&oacute;n", "Importe Cuota", "Iva Cuota"};
    /**
     * ******** Inicio Modificacion WELLCOM N-08-2253-12 *********
     */
    private String[] titleCols205 = {"Número", "Adq", "Emi", "Fte", "Proc", "FIID Emisora", "Cuenta", "Clave Tx", "Clave Tipo Tx", "No. Aut", "Importe", "Fecha Origen", "Modo Ent", "Tipo Cap", "ind EMV", "Term Cap", "Cod ISO", "ICE", "Q1", "Q2", "Q6", "04", "C0", "C4", "C6", "CE"};
    /**
     * ******** Fin Modificacion WELLCOM N-08-2253-12 *********
     */
    /* Inicia cambio WELLCOM N-04-2207-13 29/11/2013 */
    private String[] titleColsPTLF = {"Número", "Adq", "Emi", "FIID Emisora", "Cuenta", "Tipo. Tx", "No. Aut", "Importe", "Modo Ent", "Term Cap", "Q1", "Q2", "Q6", "04", "C0", "C4", "C6", "CE"};
    /* Fin cambio WELLCOM N-04-2207-13 29/11/2013 */
    private ArrayList cbValues;
    private int paginaActual;
    private int numRows;
    HTML table = new HTML();
    /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
    ConexionORACLE conOracle = null;
    /* Incia cambio WELLCOM N-04-2207-13 29/11/2013 */
    ConexionORACLEH conOracleH = null;
    /* Termina cambio WELLCOM N-04-2207-13 29/11/2013 */
    /*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */

 /* Incia cambio WELLCOM N-04-2207-13 29/11/2013 */
    public String getTableRowsValuesPTLF(HttpSession session, String initDateM, String initDateY, String afiliacion,
            String cuenta, String banco, int accion, int reporte) throws WellException {
        System.out.println("PTLF Tabla");
        /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
        /*Inicia marca de cambio WELL D-52-8122-17 28/06/2017 */
        if (accion == 0)
        	conOracle = new ConexionORACLE();
        /*Fin marca de cambio WELL D-52-8122-17 28/06/2017 */
        try {
            if (accion == 0) {
                String query = this.calculaQueryPTLF(session, initDateM, initDateY, afiliacion, cuenta, banco, reporte);
                paginaActual = 0;
                System.out.println(query);
                conOracle.Conectar();
                conOracle.Consultar(query);
                numRows = conOracle.getNumRowsRS();
                cbValues = conOracle.getNextResultSetData(NUMERO_FILAS_PAGINA);
            } else if (accion == 1 && (paginaActual + 1) * NUMERO_FILAS_PAGINA < numRows) {
                cbValues = conOracle.getNextResultSetData(NUMERO_FILAS_PAGINA);
                paginaActual += 1;
            } else if (accion == 2 && paginaActual > 0) {
                cbValues = conOracle.getPrevResultSetData(NUMERO_FILAS_PAGINA);
                paginaActual -= 1;
            }

            if (numRows > 0) {
                session.setAttribute("ValuesSICMORPTLF", cbValues);
                resultTable = createTable(reporte);
            } else {
                resultTable = "No Hay Resultados <br/>";
            }
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.Table: " + ex.toString());
        } finally {
          /*Inicia marca de cambio WELL D-52-8122-17 28/06/2017 */
            //conOracle.Desconectar();
            if (accion == 0)
				try {
					conOracle.Tiempo();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
          /*Fin marca de cambio WELL D-52-8122-17 28/06/2017 */
        }
        /*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */
        return resultTable;
    }

    /* Fin cambio WELLCOM N-04-2207-13 29/11/2013 */
    /**
     * ******** Inicio Modificacion WELLCOM N-08-2253-12 *********
     */
    public String getTableRowsValues205(HttpSession session, String initDate, String endDate, String cuenta,
            String comercio, String referencia, int accion, int reporte) throws WellException {
        /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
        /*Inicia marca de cambio WELL D-52-8122-17 28/06/2017 */
        if (accion == 0)
        	conOracle = new ConexionORACLE();
        /*Fin marca de cambio WELL D-52-8122-17 28/06/2017 */
        try {
            if (accion == 0) {
                String query = this.calculaQuery205(session, initDate, endDate, cuenta, comercio, referencia, reporte);
                paginaActual = 0;
                System.out.println(query);
                conOracle.Conectar();
                conOracle.Consultar(query);
                numRows = conOracle.getNumRowsRS();
                cbValues = conOracle.getNextResultSetData(NUMERO_FILAS_PAGINA);
            } else if (accion == 1 && (paginaActual + 1) * NUMERO_FILAS_PAGINA < numRows) {
                cbValues = conOracle.getNextResultSetData(NUMERO_FILAS_PAGINA);
                paginaActual += 1;
            } else if (accion == 2 && paginaActual > 0) {
                cbValues = conOracle.getPrevResultSetData(NUMERO_FILAS_PAGINA);
                paginaActual -= 1;
            }
            if (numRows > 0) {
                session.setAttribute("ValuesSICMOR0205", cbValues);
                resultTable = createTable(reporte);
            } else {
                resultTable = "No Hay Resultados <br/>";
            }
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.Table: " + ex.toString());
        } finally {
          /*Inicia marca de cambio WELL D-52-8122-17 28/06/2017 */
            //conOracle.Desconectar();
            if (accion == 0)
				try {
					conOracle.Tiempo();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
          /*Fin marca de cambio WELL D-52-8122-17 28/06/2017 */
        }
        /*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */
        return resultTable;

    }

    /**
     * ******** Fin Modificacion WELLCOM N-08-2253-12 *********
     */
    /**
     * ******** Inicio Modificacion WELLCOM N-08-2253-12 *********
     */
    public String getTableRowsValues205H(HttpSession session, String initDate, String endDate, String cuenta,
            String comercio, String referencia, int accion, int reporte) throws WellException {
        /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
        /*Inicia marca de cambio WELL D-52-8122-17 28/06/2017 */
        if (accion == 0)
        	conOracle = new ConexionORACLE();
        /*Fin marca de cambio WELL D-52-8122-17 28/06/2017 */
        try {
            if (accion == 0) {
                String query = this.calculaQuery205H(session, initDate, endDate, cuenta, comercio, referencia, reporte);
                paginaActual = 0;
                System.out.println(query);
                conOracle.Conectar();
                conOracle.Consultar(query);
                numRows = conOracle.getNumRowsRS();
                cbValues = conOracle.getNextResultSetData(NUMERO_FILAS_PAGINA);
            } else if (accion == 1 && (paginaActual + 1) * NUMERO_FILAS_PAGINA < numRows) {
                cbValues = conOracle.getNextResultSetData(NUMERO_FILAS_PAGINA);
                paginaActual += 1;
            } else if (accion == 2 && paginaActual > 0) {
                cbValues = conOracle.getPrevResultSetData(NUMERO_FILAS_PAGINA);
                paginaActual -= 1;
            }

            if (numRows > 0) {
                session.setAttribute("ValuesSICMOR0205H", cbValues);
                resultTable = createTable(reporte);
            } else {
                resultTable = "No Hay Resultados <br/>";
            }
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.Table: " + ex.toString());
        } finally {
          /*Inicia marca de cambio WELL D-52-8122-17 28/06/2017 */
            //conOracle.Desconectar();
            if (accion == 0)
				try {
					conOracle.Tiempo();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
          /*Fin marca de cambio WELL D-52-8122-17 28/06/2017 */
        }
        /*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */
        return resultTable;
    }

    /**
     * ******** Fin Modificacion WELLCOM N-08-2253-12 *********
     */
    public String getTableRowsValues(HttpSession session, String initDate, String bancoAdq,
            String bancoEmi, String noTrans, String fuente, String importe,
            String noCuenta, String noAuto, String noRef, String noComer, String nomComer, String giroComer, int accion, int reporte) throws WellException {
        /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
        try {
            if (reporte == 1000) {
            	/*Inicia marca de cambio WELL D-52-8122-17 28/06/2017 */
            	if (accion == 0)
            		conOracleH = new ConexionORACLEH();
            	/*Fin marca de cambio WELL D-52-8122-17 28/06/2017 */
                try {

                    if (accion == 0) {
                        String query = this.calculaQuery(session, initDate, bancoAdq,
                                bancoEmi, noTrans, fuente, importe,
                                noCuenta, noAuto, noRef, noComer, nomComer, giroComer, reporte);
                        paginaActual = 0;
                        System.out.println("reporte: " + reporte);
                        System.out.println(query);
                        conOracleH.Conectar();
                        conOracleH.Consultar(query);
                        numRows = conOracleH.getNumRowsRS();
                        cbValues = conOracleH.getNextResultSetData(NUMERO_FILAS_PAGINA);
                    } else if (accion == 1 && (paginaActual + 1) * NUMERO_FILAS_PAGINA < numRows) {
                        cbValues = conOracleH.getNextResultSetData(NUMERO_FILAS_PAGINA);
                        paginaActual += 1;
                    } else if (accion == 2 && paginaActual > 0) {
                        cbValues = conOracleH.getPrevResultSetData(NUMERO_FILAS_PAGINA);
                        paginaActual -= 1;
                    }
                    if (numRows > 0) {
                        if (reporte == 100 || reporte == 120 || reporte == 1000) {
                            session.setAttribute("ValuesSICMOF0" + reporte, cbValues);
                        } else if (reporte == 101 || reporte == 121) {
                            session.setAttribute("ValuesSICMOFB" + (reporte - 1), cbValues);
                        }
                        resultTable = createTable(reporte);
                    } else {
                        resultTable = "No Hay Resultados <br/>";
                    }
                } catch (Exception ex) {
                    throw new WellException("com.wellcom.prosa.sacii.Table: Consulta Historico " + ex.toString());
                } finally {
                    /*Inicia marca de cambio WELL D-52-8122-17 28/06/2017 */
                    //conOracle.Desconectar();
            if (accion == 0)
            	conOracleH.Tiempo();
          /*Fin marca de cambio WELL D-52-8122-17 28/06/2017 */
                }
            } else {
                 /*Inicia marca de cambio WELL D-52-8122-17 28/06/2017 */
                 if (accion == 0)
                 	conOracle = new ConexionORACLE();
                 /*Fin marca de cambio WELL D-52-8122-17 28/06/2017 */
                try {
                    if (accion == 0) {
                        String query = this.calculaQuery(session, initDate, bancoAdq,
                                bancoEmi, noTrans, fuente, importe,
                                noCuenta, noAuto, noRef, noComer, nomComer, giroComer, reporte);
                        paginaActual = 0;
                        System.out.println("reporte: " + reporte);
                        System.out.println(query);
                        conOracle.Conectar();
                        conOracle.Consultar(query);
                        numRows = conOracle.getNumRowsRS();
                        cbValues = conOracle.getNextResultSetData(NUMERO_FILAS_PAGINA);
                    } else if (accion == 1 && (paginaActual + 1) * NUMERO_FILAS_PAGINA < numRows) {
                        cbValues = conOracle.getNextResultSetData(NUMERO_FILAS_PAGINA);
                        paginaActual += 1;
                    } else if (accion == 2 && paginaActual > 0) {
                        cbValues = conOracle.getPrevResultSetData(NUMERO_FILAS_PAGINA);
                        paginaActual -= 1;
                    }
                    if (numRows > 0) {
                        if (reporte == 100 || reporte == 120 || reporte == 1000) {
                            session.setAttribute("ValuesSICMOF0" + reporte, cbValues);
                        } else if (reporte == 101 || reporte == 121) {
                            session.setAttribute("ValuesSICMOFB" + (reporte - 1), cbValues);
                        }
                        resultTable = createTable(reporte);
                    } else {
                        resultTable = "No Hay Resultados <br/>";
                    }
                } catch (Exception ex) {
                    throw new WellException("com.wellcom.prosa.sacii.Table: Consulta PMT " + ex.toString());
                } finally {
                  /*Inicia marca de cambio WELL D-52-8122-17 28/06/2017 */
                  //conOracle.Desconectar();
                  if (accion == 0)
                  	conOracle.Tiempo();
                  /*Fin marca de cambio WELL D-52-8122-17 28/06/2017 */
                }
            }
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.Table: " + ex.toString());
        }
        /*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */
        return resultTable;
    }

    public String createTable(int reporte) {
        String result = null;
        try {
            table.setCSSTable("tableDetails");
            table.setCSSTRHeaderTable("tableHeader");
            table.setCSSTRDataTable("tableRow");
            table.setCSSTDDateTable("tableRowValues");
            if (reporte == 100 || reporte == 120 || reporte == 1000) {
                result = table.getTable("tableSICMOF", titleCols, 22, cbValues, "viewDatas(this.rowIndex-1," + reporte + ")", "selected(this.rowIndex,'tableSICMOF')", "normal(this.rowIndex,'tableSICMOF')");
            } else if (reporte == 101 || reporte == 121) //B100 Y B120
            {
                result = table.getTable("tableSICMOFB", titleCols, 22, cbValues, "viewDatas(this.rowIndex-1," + reporte + ")", "selected(this.rowIndex,'tableSICMOFB')", "normal(this.rowIndex,'tableSICMOFB')");
            } /**
             * ******** Inicio Modificacion WELLCOM N-08-2253-12 *********
             */
            else if (reporte == 205) {
                result = table.getTable("tableSICMOR0205", titleCols205, 26, cbValues, "viewDatas(this.rowIndex-1," + reporte + ")", "selected(this.rowIndex,'tableSICMOR0205')", "normal(this.rowIndex,'tableSICMOR0205')");
            } /**
             * ******** Fin Modificacion WELLCOM N-08-2253-12 *********
             */
            /**
             * ******** Inicio Modificacion WELLCOM N-08-2253-12 *********
             */
            else if (reporte == 2050) {
                result = table.getTable("tableSICMOR0205H", titleCols205, 26, cbValues, "viewDatas(this.rowIndex-1," + reporte + ")", "selected(this.rowIndex,'tableSICMOR0205H')", "normal(this.rowIndex,'tableSICMOR0205H')");
            } /**
             * ******** Fin Modificacion WELLCOM N-08-2253-12 *********
             */
            /* Inicia cambio WELLCOM N-04-2207-13 29/11/2013 */ else if (reporte == 10) {
                result = table.getTable("tableSICMORPTLF", titleColsPTLF, 18, cbValues, "viewDatas(this.rowIndex-1," + reporte + ")", "selected(this.rowIndex,'tableSICMORPTLF')", "normal(this.rowIndex,'tableSICMORPTLF')");
            }
            /* Fin cambio WELLCOM N-04-2207-13 29/11/2013 */
        } catch (WellException e) {
            e.printStackTrace();

        }

        return result;
    }

    /**
     * ******** Inicio Modificacion WELLCOM N-08-2253-12 *********
     */
    private String calculaQuery205(HttpSession session, String initDate, String endDate, String cuenta,
            String comercio, String referencia, int reporte) {
        TableParams params = new TableParams(session, initDate, endDate, cuenta, comercio, referencia, reporte);
        String query = "";

        query = CreateQueryTable.SICMOR0205(params);

        return query;
    }

    /**
     * ******** Fin Modificacion WELLCOM N-08-2253-12 *********
     */
    /**
     * ******** Inicio Modificacion WELLCOM N-08-2253-12 *********
     */
    private String calculaQuery205H(HttpSession session, String initDate, String endDate, String cuenta,
            String comercio, String referencia, int reporte) {
        System.out.println("initH:" + initDate + ":");
        TableParams params = new TableParams(session, initDate, endDate, cuenta, comercio, referencia, reporte);
        String query = "";

        query = CreateQueryTable.SICMOR0205H(params);
        return query;
    }

    /**
     * ******** Fin Modificacion WELLCOM N-08-2253-12 *********
     */

    /* Inicia modificacion WELLCOM N-04-2207-13 29/11/2013 */
    private String calculaQueryPTLF(HttpSession session, String initDateM, String initDateY, String afiliacion,
            String cuenta, String banco, int reporte) {
        System.out.println("initH:" + initDateM + "|" + initDateY + ":");
        TableParams params = new TableParams(session, initDateM, initDateY, afiliacion, cuenta, banco, reporte);
        String query = "";

        query = CreateQueryTable.SICMORPTLF(params);
        return query;
    }

    /* Fin modificacion WELLCOM N-04-2207-13 29/11/2013 */
    private String calculaQuery(HttpSession session, String initDate, String bancoRecep,
            String bancoEmi, String tipoTransaccion, String numeroFuente, String importe,
            String numeroCuenta, String numeroAutorizacion, String numeroRef, String numeroComercio, String nombreComercio, String giroComercio, int reporte) {

        TableParams params = new TableParams(session, initDate, bancoRecep, bancoEmi, tipoTransaccion, numeroFuente, importe, numeroCuenta, numeroAutorizacion, numeroRef, numeroComercio, nombreComercio, giroComercio, reporte);
        int mi = 0;

        //mi = validaPrefijo(session, numeroCuenta);
        String query = "";

        switch (reporte) {
            case 100:
                query = CreateQueryTable.SICMOF0100(params);
                /**
                 * Inicio Modificación B-52-2251-14 por duplicidad de
                 * transaccion en la pantalla aceptadas y visa *
                 */
                //	query+= " UNION ALL \n";
                //	query+= CreateQueryTable.SICMOFM100(params);
                /**
                 * Fin Modificación B-52-2251-14 por duplicidad de transaccion
                 * en la pantalla aceptadas y visa	*
                 */
                /*
				if (mi == 0){
					query = CreateQueryTable.SICMOF0100(params);
				}else{
					query = CreateQueryTable.SICMOFM100(params);
				}
                 */
                break;
            case 101:
                query = CreateQueryTable.SICMOF0101(params);
                break;
            case 120:
                query = CreateQueryTable.SICMOF0120(params);
                query += " UNION ALL ";
                query += CreateQueryTable.rechazos(params);
                break;
            case 121:
                query = CreateQueryTable.SICMOF0121(params);
                query += " UNION ALL ";
                query += CreateQueryTable.rechazos(params);
                break;
            case 1000:
                query = CreateQueryTable.SICMOF1000(params);
                break;
        }

        return query;
    }

    /**
     * Valida si el prefijo es de mercados internacionales
     *
     * @param session
     * @param numeroCuenta
     */
    private int validaPrefijo(HttpSession session, String numeroCuenta) {
        int valor = 0;
        String query = "SELECT distinct PP.NUMERO "
                + " FROM PMADMIN.PRSA_TXN_LOCALES_VISA PTLV INNER JOIN PMADMIN.PRSA_PREFIJOS PP "
                + " ON REGEXP_LIKE(PTLV.CUENTA, '^('||PP.NUMERO||')') "
                + " INNER JOIN PMADMIN.PRSA_ENTIDADES PE ON (PE.NUMERO_PROSA =  PP.ENT_NUMERO_PROSA AND PE.TIE_NUMERO BETWEEN 8 AND 19) "
                + " WHERE PTLV.CUENTA = '" + numeroCuenta + "'";
        try {
            /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicia Modificación #  */
            conOracle.Conectar();
            conOracle.Consultar(query);
            @SuppressWarnings("rawtypes")
            ArrayList datos = conOracle.getRSColsData();
            valor = datos.size();

        } catch (WellException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conOracle.Desconectar();
        }
        /*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */
        return valor;

    }

}
