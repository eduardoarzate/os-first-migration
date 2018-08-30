/*##############################################################################
# Nombre del Programa : findrev.java                                           #
# Autor               : Victor H. Montoya G.                                   #
# Compania            : eNova                                                  #
# Proyecto/Procliente : Z-04-3155-11                         Fecha:27/12/2011  #
# Descripcion General : servlet                                                #
# Programa Dependiente:                                                        #
# Programa Subsecuente:                                                        #
# Cond. de ejecucion  :                                                        #
# Dias de ejecucion   :                                      Horario: hh:mm    #
#                              MODIFICACIONES                                  #
################################################################################
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 12/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
################################################################################
# Numero de Parametros:                                                        #
# Parametros Entrada  :                                      Formato:          #
# Parametros Salida   :                                      Formato:          #
##############################################################################*/
package com.prosa.mx.pmr.servlet;

import com.prosa.mx.pmr.dto.Reverso;
/*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
import com.wellcom.conexion.ConexionORACLE;
/*import com.wellcom.sql.Database;
import com.wellcom.sql.SessionConnection;*/
/*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */
import com.wellcom.exceptions.WellException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author home
 */
public class findrev extends HttpServlet {

    /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
    ConexionORACLE conOracle = null;

    /*#Marca de cambio:  SAS-DRT F-52-8063-16  Fin Modificación #  */
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
        conOracle = new ConexionORACLE();
        /*#Marca de cambio:  SAS-DRT F-52-8063-16  Fin Modificación #  */
        RequestDispatcher rd = request.getRequestDispatcher("/SICLIF0301Header.jsp");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = request.getParameter("txtfStartDate") == null ? "" : request.getParameter("txtfStartDate");
        String cuenta = request.getParameter("cuenta") == null ? "" : request.getParameter("cuenta");
        String ref = request.getParameter("ref") == null ? "" : request.getParameter("ref");
        String auth = request.getParameter("auth") == null ? "" : request.getParameter("auth");
        String comer = request.getParameter("comer") == null ? "" : request.getParameter("comer");
        String send = request.getParameter("send");
        /*send = 0:buscar, send=1:guardar*/

        try {
            if (fecha.equals("") == false) {
                sdf.parse(fecha);
            }
        } catch (ParseException ex) {
            request.setAttribute("msg", "Fecha no valida");
            rd.forward(request, response);
            return;
        }

        if (cuenta.equals("") && ref.equals("")) {
            request.setAttribute("msg", "Debe indicar al menos un criterio de cuenta o referencia");
            rd.forward(request, response);
            return;
        }

        ArrayList<Reverso> rows = new ArrayList();
        Reverso item = null;

        try {
            /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
            //Database db = null;
            HttpSession s = request.getSession();
            /*db = (Database) s.getAttribute(s.getId() + "db");
            Connection conn = db.getConnection();
            Statement stu = conn.createStatement();*/
            if (send.equals("1")) {
                String[] vals = request.getParameterValues("check");
                String upd = "";
                if (vals != null) {
                    for (String val : vals) {
                        System.out.println("val " + val);
                        upd = "UPDATE PMADMIN.PRSA_TXN_ACEPTADAS SET IND_BENEFICIOS = 1 WHERE TA_WH_SEQ = " + val;
                        conOracle.Conectar();
                        conOracle.Modificar(upd);
                        //stu.executeUpdate(upd);
            /*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */
                    }
                }
            }

            // Statement st = conn.createStatement();
            StringBuffer sb = new StringBuffer("");
            sb.append("SELECT ta.ta_wh_seq, ta.cuenta, ta.numero_autorizacion, ta.fecha_proceso_transac, ta.fecha_consumo_transac, ta.numero_comercio, ta.nombre_comercio, ta.ttr_numero, ");
            sb.append(" ttr.descripcion as tipo_tx, ta.ent_numero_prosa_emi, ent.descripcion as emisor, ta.importe_total_transac, ta.nombre_archivo, ta.numero_referencia, ta.ind_beneficios ");
            sb.append(" FROM PMADMIN.PRSA_TXN_ACEPTADAS ta, PMADMIN.PRSA_TIPOS_TRANSACCION ttr, PMADMIN.PRSA_ENTIDADES ENT");
            //sb.append(" FROM PRSA_TXN_ACEPTADAS ta, PRSA_TIPOS_TRANSACCION ttr, PRSA_ENTIDADES ENT");
            sb.append(" WHERE ");
            sb.append(" ent_numero_prosa_adq ='3' ");
            sb.append(" AND ent_numero_prosa_emi IN ('98','94')");
            sb.append(" AND TTR_numero IN ('1','21')");
            sb.append(" AND tier_codigo_moneda = '484'");
            sb.append(" AND arch_numero = '5'");

            if (fecha.equals("") == false) {
                sb.append(" AND FECHA_PROCESO_TRANSAC = TO_DATE('" + fecha + "', 'DD/MM/YYYY')");
            }
            if (cuenta.equals("") == false) {
                sb.append(" AND ta.cuenta = '" + cuenta.trim() + "'");
            }
            if (ref.equals("") == false) {
                sb.append(" AND ta.numero_referencia = '" + ref.trim() + "'");
            }
            if (auth.equals("") == false) {
                sb.append(" AND ta.numero_autorizacion = '" + auth.trim() + "'");
            }
            if (auth.equals("") == false) {
                sb.append(" AND ta.numero_comercio = '" + comer.trim() + "'");
            }

            sb.append(" AND ta.ttr_numero = ttr.numero ");
            sb.append(" AND ta.ent_numero_prosa_emi = ent.numero_prosa");
            System.out.println(sb.toString());
            /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
            conOracle.Consultar(sb.toString());
            ResultSet rs = conOracle.getResultSet();

            while (rs.next()) {
                item = new Reverso(rs);
                rows.add(item);
            }
            System.out.println("rows " + rows.size());
            //rs.close();
            //st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(findrev.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WellException ex) {
            Logger.getLogger(findrev.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conOracle.Desconectar();
        }
        /*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */
        request.setAttribute("items", rows);

        rd.forward(request, response);
        return;

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
