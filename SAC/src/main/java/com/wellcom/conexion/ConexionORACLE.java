/*###############################################################################
# Nombre del Programa :  ConexionORACLE.java                                    #
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 13/03/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
#################################################################################
#                                                              Modificaciones   #
# Nombre del Programa :  ConexionORACLE.java                                    #
# Autor               :  German Gonzalez                                        #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  D-52-8122-17                 Fecha: 28/06/2017         #
# Modificacion        :  Mejora Reporteador  SC2                                #
#-------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
package com.wellcom.conexion;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.DataSource;

import com.wellcom.exceptions.*;

public class ConexionORACLE {

    String url = "";
    String baseDeDatos = "";
    String drName = "";
    String usuarioMySQL = "";
    String contrasena = "";
    String jndi = "";
    public static Connection con = null;
    static DataSource ds = null;
    Statement stmt = null;

    private ResultSet resultSet;
    private ResultSetMetaData rsMetaData;

    private String rsColumnsTitles[];
    private String rsColumnsData[][];
    private boolean colsDataAsArray;
    private ArrayList rsColsDataArray;
    private ListIterator rsColsDataIterator;
    private int numRowsRS;

    public int getNumRowsRS() {
        return numRowsRS;
    }

    public ConexionORACLE() {
        //this.resultSet = null;
        this.rsMetaData = null;
        this.rsColumnsTitles = null;
        this.rsColumnsData = null;
        this.colsDataAsArray = false;
        this.rsColsDataArray = null;
        this.rsColsDataIterator = null;
        this.jndi = "PMTUDBP";
        this.numRowsRS = 0;
    }

    public ConexionORACLE(String jndi) {
        //this.resultSet = null;
        this.rsMetaData = null;
        this.rsColumnsTitles = null;
        this.rsColumnsData = null;
        this.colsDataAsArray = false;
        this.rsColsDataArray = null;
        this.rsColsDataIterator = null;
        this.jndi = jndi;
        this.numRowsRS = 0;
    }

    class cerrarConexion {

        Timer timer = new Timer(); // El timer que se encarga de administrar los tiempo de repeticion
        public int segundos; // manejar el valor del contador
        public boolean frozen; // manejar el estado del contador TIMER AUTOMATICO -- True Detenido | False Corriendo
        
        /*Inicia modificacion WELL-D-52-8122-17 28/06/2017 */
        class Actividad extends TimerTask{

        	@Override
        	public void run() {
        	// TODO Auto-generated method stub
        	System.out.println(":CERRO:SS:"+segundos+":SS:"+timer.toString()+":");
                if (!frozen)
                {
                	System.out.println(":Desconecta:SS:");
                	Desconectar();
                	Stop();
                }
                
        	}
        }
        /*Fin    modificacion WELL-D-52-8122-17 28/06/2017 */
        
        class MiTarea extends TimerTask {

            public void run() {
                segundos++;
                System.out.println(segundos);
                Desconectar();
            }// end run()
        }// end SincronizacionAutomatica

        public void Start(int pSeg) throws Exception {
            frozen = false;
            // le asignamos una tarea al timer
            timer.schedule(new MiTarea(), 0, pSeg * 1000 * 60);
        }// end Start

        /*Inicia modificacion WELL-D-52-8122-17 28/06/2017 */
        public void IniciaTarea(int pSeg) throws Exception {
            frozen = false;
            System.out.println(":SS:Entro al Start:");
            timer.schedule(new Actividad(), pSeg * 1000 * 60);
            
        }
        /*Fin    modificacion WELL-D-52-8122-17 28/06/2017 */
        
        public void Stop() {
            System.out.println("Stop");
            frozen = true;
        }// end Stop

        public void Reset() {
            System.out.println("Reset");
            frozen = true;
            segundos = 0;
        }// end Reset
    }

    public ConexionORACLE(String url, String baseDeDatos, String usuarioMySQL, String contrasena) {
        this.url = url;
        this.baseDeDatos = baseDeDatos;
        this.usuarioMySQL = usuarioMySQL;
        this.contrasena = contrasena;
        con = null;
        this.stmt = null;
    }

    public Connection getConnection() {
        return this.con;
    }

    public void setConnection(Connection conection) {
        this.con = conection;
    }

    /*Inicia modificacion WELL-D-52-8122-17 28/06/2017 */
    public void Tiempo() throws Exception  {
    	cerrarConexion apagaTiempo = new cerrarConexion();
    	System.out.println("paso por aqui");
    	apagaTiempo.IniciaTarea(10);
    }
    /*Fin    modificacion WELL-D-52-8122-17 28/06/2017 */

    public void Desconectar() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                con = null;
            }
            //if (this.stmt != null && !stmt.isClosed()) {
            if (this.stmt != null) {
                this.stmt.close();
                this.stmt = null;
            }
            if (this.resultSet != null) {
                this.resultSet.close();
                this.resultSet = null;
            }
            System.out.println("FIN Desconexion ");
            //return true;
        } catch (Exception e) {
            System.err.println(" DBCONECTION:No se ha podido cerrar la conexion " + this.jndi);
            System.out.println(e.getMessage());
            //return false;
        }
    }

    public void Conectar() {
        try {
            if (ds == null) {
                ds = getPruebasource();
                con = ds.getConnection();
                System.out.println(" DBCONECTION:Conexion satisfactoria a la base de datos " + this.jndi);
            }else if (con != null) {
                if (con.isClosed()) {
                    con = ds.getConnection();
                } else {
                    System.out.println(" DBCONECTION: La conexion ya se encontraba establecida " + this.jndi);
                }
            } else if (con == null) {
                con = ds.getConnection();
            }
            if (stmt == null) {
                stmt = con.createStatement();
            }
            //return true;
            //Class.forName(drName).newInstance();
            //con = DriverManager.getConnection(url + baseDeDatos, usuarioMySQL,
            //        contrasena);
        } catch (Exception e) {
            System.err.println(" DBCONECTION:Conexion rechazada a " + this.jndi);
            System.out.println(e.getMessage());
            Desconectar();
            //return false;
        }
    }

    private DataSource getPruebasource() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("" + this.jndi);
    }

    public int Insertar(String sqlQuery) throws SQLException {
        if (con == null) {
            Conectar();
        } else if (con.isClosed()) {
            Conectar();
        }
        stmt = con.createStatement();
        int val = stmt.executeUpdate(sqlQuery);
        return val;
    }

    public int Eliminar(String sqlQuery) throws SQLException {
        if (con == null) {
            Conectar();
        } else if (con.isClosed()) {
            Conectar();
        }
        stmt = con.createStatement();
        int val = stmt.executeUpdate(sqlQuery);
        return val;
    }

    public int Modificar(String sqlQuery) throws SQLException {
        if (con == null) {
            Conectar();
        } else if (con.isClosed()) {
            Conectar();
        }
        stmt = con.createStatement();
        int val = stmt.executeUpdate(sqlQuery);
        return val;
    }

    public ResultSet Consultar(String sqlQuery) throws SQLException {
        if (con == null) {
            Conectar();
        } else if (con.isClosed()) {
            Conectar();
        }

        Statement stmt = this.con.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        //stmt = con.createStatement();
        resultSet = stmt.executeQuery(sqlQuery);
        // System.err.println("del result set"+ this.resultSet.get);

        System.err.println("del result set" + this.resultSet.getRow());
        if (this.resultSet.last()) {
            this.numRowsRS = this.resultSet.getRow();
            this.resultSet.beforeFirst();
        }
        //this.numRowsRS = this.resultSet.getRow();
        System.err.println("del numero set" + this.numRowsRS);
        return resultSet;
    }

    public CallableStatement PrepararSP(String sqlQuery) throws SQLException {
        if (con == null) {
            Conectar();
        } else if (con.isClosed()) {
            Conectar();
        }
        CallableStatement cstmt = con.prepareCall("{CALL ".concat(sqlQuery).concat("}"));
        return cstmt;
    }

    /* private DataSource getPruebasource() throws NamingException {
		InitialContext initCtx = new InitialContext();
	  Context envCtx = (Context) initCtx.lookup("java:comp/env");
        //return (DataSource) c.lookup("java:comp/env/pruebasource");
        DataSource dataSource = (DataSource)envCtx.lookup("PMTUDBP");
		return dataSource;
    }*/
 /* COMIENZAN METODOS */
    public ArrayList getRSColsData() throws WellException {

        int numRows, numCols;

        try {
            if (this.resultSet != null) {
                this.rsMetaData = this.resultSet.getMetaData();
                numCols = this.rsMetaData.getColumnCount();
                this.resultSet.last();
                numRows = this.resultSet.getRow();
                /*
         * Procurar que siempre se indique en el
         * constructor del ArrayList el tamaño deseado
                 */
                this.rsColsDataArray = new ArrayList(numRows);
                this.rsColumnsData = new String[numRows][numCols];
                this.resultSet.first();
                for (int i = 0; i < numRows; i++) {

                    for (int j = 0; j < numCols; j++) {
                        this.setRSData(
                                this.rsMetaData.getColumnType(j + 1), i, j);
                    }
                    this.rsColsDataArray.add(this.rsColumnsData[i]);

                    this.resultSet.next();
                }

                this.rsColsDataIterator = this.rsColsDataArray.listIterator();
                this.rsColumnsData = null;
            } else {
                throw new WellException(
                        "com.wellcom.sql.Database.getRSColumnsData: "
                        + "this.resultSet = null");
            }
        } catch (Exception ex) {
            new WellException("com.wellcom.sql.Database.getRSColsAsArray: "
                    + ex.toString());
        }

        return this.rsColsDataArray;
    }

    private void setRSData(int type, int rowIdx, int colIdx) throws WellException {
        try {

            switch (type) {

                case Types.CHAR:
                case Types.VARCHAR:
                case Types.LONGVARCHAR:
                    if (this.resultSet.getString(colIdx + 1) != null) {
                        this.rsColumnsData[rowIdx][colIdx]
                                = this.resultSet.getString(colIdx + 1);
                    } else {
                        this.rsColumnsData[rowIdx][colIdx] = "";
                    }
                    break;

                case Types.NUMERIC:
                case Types.DECIMAL:
                    if (this.resultSet.getBigDecimal(colIdx + 1) != null) {
                        this.rsColumnsData[rowIdx][colIdx]
                                = resultSet.getBigDecimal(colIdx + 1).toString();
                    } else {
                        this.rsColumnsData[rowIdx][colIdx] = "";
                    }
                    break;

                case Types.BIT:
                    this.rsColumnsData[rowIdx][colIdx]
                            = String.valueOf(this.resultSet.
                                    getBoolean(colIdx + 1));
                    break;

                case Types.TINYINT:
                    this.rsColumnsData[rowIdx][colIdx]
                            = new Byte(this.resultSet.
                                    getByte(colIdx + 1)).toString();
                    break;

                case Types.SMALLINT:
                    this.rsColumnsData[rowIdx][colIdx]
                            = new Short(this.resultSet.
                                    getShort(colIdx + 1)).toString();
                    break;

                case Types.INTEGER:
                    this.rsColumnsData[rowIdx][colIdx]
                            = String.valueOf(this.resultSet.
                                    getInt(colIdx + 1));
                    break;

                case Types.BIGINT:
                    this.rsColumnsData[rowIdx][colIdx]
                            = String.valueOf(this.resultSet.
                                    getLong(colIdx + 1));
                    break;

                case Types.FLOAT:
                    this.rsColumnsData[rowIdx][colIdx]
                            = String.valueOf(this.resultSet.
                                    getFloat(colIdx + 1));
                    break;

                case Types.DOUBLE:
                    this.rsColumnsData[rowIdx][colIdx]
                            = String.valueOf(this.resultSet.
                                    getDouble(colIdx + 1));
                    break;

                case Types.DATE:
                    if (this.resultSet.getDate(colIdx + 1) != null) {
                        this.rsColumnsData[rowIdx][colIdx]
                                = this.resultSet.getDate(colIdx + 1).toString();
                    } else {
                        this.rsColumnsData[rowIdx][colIdx] = "";
                    }
                    break;

                case Types.TIME:
                    if (this.resultSet.getTime(colIdx + 1) != null) {
                        this.rsColumnsData[rowIdx][colIdx]
                                = this.resultSet.getTime(colIdx + 1).toString();
                    } else {
                        this.rsColumnsData[rowIdx][colIdx] = "";
                    }
                    break;

                case Types.TIMESTAMP:
                    if (resultSet.getTimestamp(colIdx + 1) != null) {
                        this.rsColumnsData[rowIdx][colIdx]
                                = resultSet.getTimestamp(colIdx + 1).toString();
                    } else {
                        this.rsColumnsData[rowIdx][colIdx] = "";
                    }
                    break;

                case Types.NULL:
                    this.rsColumnsData[rowIdx][colIdx] = "";
            }
        } catch (SQLException sqlEx) {
            throw new WellException("com.wellcom.sql.Database.setRSData: "
                    + sqlEx.toString());
        } catch (Exception ex) {
            throw new WellException("com.wellcom.sql.Database.setRSData: "
                    + ex.toString());
        }
    }

    public ResultSet getResultSet() throws WellException {
        if (this.resultSet != null) {
            return this.resultSet;
        } else {
            throw new WellException("com.wellcom.Database.getResultSet: "
                    + "this.resultSet = null");
        }
    }

    public ArrayList getNextResultSetData(int value) throws WellException {

        int i = 0;
        int j = 0;
        int numCols = 0;
        int numRows = 0;
        int currentRow = 0;
        int lastRows = 0;

        if (this.resultSet == null) {
            throw new WellException(
                    "com.wellcom.sql.Database.getNextResultSetData: "
                    + "ResultSet = null "
            );
        }

        try {

            //Obtener numero de columnas
            this.rsMetaData = this.resultSet.getMetaData();
            numCols = this.rsMetaData.getColumnCount();

            if (this.resultSet.isBeforeFirst()) {
                this.resultSet.first();
            }

            //Posicion actual del cursor
            currentRow = this.resultSet.getRow();

            /*
      //Obtener numero de filas
      this.resultSet.last();
      //Posicion actual del cursor que en este caso nos
      //indica el numero total de registros
      numRows = this.resultSet.getRow();
      //Se establece al cursor en su posicion original
      if (currentRow > 0) {
        this.resultSet.absolute(currentRow);
      }
             */
            //Obtener numero de filas
            numRows = this.getNumRowsRS();

            //ResultSet - Contiene datos?
            if (numRows > 0) {

                //Se establece el tamanio del ArrayList de resultado
                this.rsColsDataArray = new ArrayList(value);
                this.rsColumnsData = new String[value][numCols];

                //El cursor se encuentra en el ultimo o
                //despues del ultimo registro?
                //if ((this.resultSet.isLast()) || (this.resultSet.isAfterLast())) {
                if (this.resultSet.isAfterLast()) {

                    //value es multiplo de rowNums?
                    lastRows = numRows % value;

                    if (lastRows == 0) {
                        //for (i = 1; i < value; i++) {
                        for (i = 0; i < value; i++) {
                            this.resultSet.previous();
                        }
                    } else if (lastRows != 0) {
                        //for (i = 1; i < lastRows; i++) {
                        for (i = 0; i < lastRows; i++) {
                            this.resultSet.previous();
                        }
                    }
                }

                //Mientras no se alcance el ultimo registro, desplegar datos.
                for (i = 0; i < value; i++) {

                    if (!this.resultSet.isAfterLast()) {
                        for (j = 0; j < numCols; j++) {
                            this.setRSData(
                                    this.rsMetaData.getColumnType(j + 1), i, j
                            );
                        }

                        this.rsColsDataArray.add(this.rsColumnsData[i]);
                        this.resultSet.next();
                    }
                }
                this.rsColsDataArray.trimToSize();
            }
        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.sql.Database.getNextResultSetData: "
                    + ex.toString()
            );
        }

        return this.rsColsDataArray;
    }

    public ArrayList getPrevResultSetData(int value) throws WellException {

        int i = 0;
        int j = 0;
        int numCols = 0;
        int numRows = 0;
        int currentRow = 0;
        int lastRows = 0;

        if (this.resultSet == null) {
            throw new WellException(
                    "com.wellcom.sql.Database.getPrevResultSetData: "
                    + "ResultSet = null "
            );
        }

        try {

            //Obtener numero de columnas
            this.rsMetaData = this.resultSet.getMetaData();
            numCols = this.rsMetaData.getColumnCount();

            currentRow = this.resultSet.getRow();

            //El cursor se encuentra en el ultimo o
            //despues del ultimo registro?
            //if ( (this.resultSet.isLast()) || (this.resultSet.isAfterLast())) {
            if (this.resultSet.isAfterLast()) {

                //Se posiciona el cursor en el ultimo registro
                this.resultSet.last();
                /*
        //Se obtiene y almacena la posicion actual del cursor,
        //que en este caso nos indica el numero de registros
        numRows = this.resultSet.getRow();
                 */
                //Se obtiene el numero de registros
                numRows = this.getNumRowsRS();

                //value es multiplo de rowNums?
                lastRows = numRows % value;

                if (lastRows == 0) {
                    //for (i = 1; i < ((value * 2) + 1); i++) {
                    for (i = 1; i < (value * 2); i++) {
                        this.resultSet.previous();
                    }
                } else if (lastRows != 0) {
                    for (i = 1; i < (value + lastRows); i++) {
                        this.resultSet.previous();
                    }
                }
                currentRow = this.resultSet.getRow();
            } //La posicion del cursor es distinta a la posicion del ultimo registro?
            else {
                currentRow = this.resultSet.getRow();
                this.resultSet.last();
                numRows = this.resultSet.getRow();
                this.resultSet.absolute(currentRow);

                for (i = 1; i < ((value * 2) + 1); i++) {
                    //for(i = 1;i < (value * 2);i++) {
                    if (!this.resultSet.isBeforeFirst()) {
                        this.resultSet.previous();
                    }
                }
            }
            currentRow = this.resultSet.getRow();
            if (this.resultSet.isBeforeFirst()) {
                this.resultSet.first();
            }

            //ResultSet - Contiene datos?
            if (numRows > 0) {

                //Se establece el tamanio del ArrayList de resultado
                this.rsColsDataArray = new ArrayList(value);
                this.rsColumnsData = new String[value][numCols];

                //Mientras no se alcance el ultimo registro, desplegar datos.
                for (i = 0; i < value; i++) {

                    if (!this.resultSet.isAfterLast()) {
                        for (j = 0; j < numCols; j++) {
                            this.setRSData(
                                    this.rsMetaData.getColumnType(j + 1), i, j
                            );
                        }

                        this.rsColsDataArray.add(this.rsColumnsData[i]);
                        this.resultSet.next();
                    }
                }
                this.rsColsDataArray.trimToSize();
                currentRow = this.resultSet.getRow();
            }
        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.sql.Database.getPrevResultSetData: "
                    + ex.toString()
            );
        }

        return this.rsColsDataArray;
    }
}
