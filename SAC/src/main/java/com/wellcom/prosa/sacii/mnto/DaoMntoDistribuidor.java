																																																																																																																																																																																																																																																																																																																																																																																																																												/*###############################################################################
# Nombre del Programa :  DaoMntoDistribuidor.java                               #
# Autor               :  JOAQUIN MOJICA                                         #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  z-02-2675-12                   FECHA:30/10/2008        #
# Descripcion General :	 Pantalla que muestra los contracargos.                 #
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :  DAO de objetos del sistema                             #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :  A Peticion del web, se pueden ejecutar n instancias    #
#-------------------------------------------------------------------------------#
#                                                              Modificaciones   #
#-------------------------------------------------------------------------------#
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-------------------------------------------------------------------------------#
 */
package com.wellcom.prosa.sacii.mnto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;
import com.wellcom.exceptions.WellException;
/*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
import com.wellcom.conexion.*;
/*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */

public class DaoMntoDistribuidor {

    private Integer vtc_id_distr;
    private String vtc_nom_distr;
    private Double vtc_imp_tarifa;
    private Integer vtc_ent_numero;
    private String vtc_estatus;
    private String vtc_usuario_registro;
    private Date vtc_fecha_registro;
    private String vtc_usuario_modifica;
    private Date vtc_fecha_modifica;
    /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
    ConexionORACLE conOracle = null;

    public DaoMntoDistribuidor() {
        conOracle = new ConexionORACLE();
    }

    /*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */
    public void buscaDatosDistribuidor(HttpSession session, String distribuidor)
            throws WellException {
        String busqueda = " select vtc_id_distr, "
                + "   vtc_nom_distr, "
                + "   vtc_imp_tarifa, "
                + "   vtc_ent_numero, "
                + "   vtc_estatus, "
                + "   vtc_usuario_registro, "
                + "   vtc_fecha_registro, "
                + "   vtc_usuario_modifica, "
                + "   vtc_fecha_modifica "
                + "   from VTC.tbl_vtc_cat_distribuidor@LG_PMTU_PMTWEB_IFO2_VTC"
                + "   where vtc_id_distr=" + distribuidor;

        /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
        try {
            conOracle.Conectar();
            conOracle.Consultar(busqueda);
            ResultSet rs = conOracle.getResultSet();
            while (rs.next()) {
                setVtc_id_distr(rs.getInt("vtc_id_distr"));
                setVtc_nom_distr(rs.getString("vtc_nom_distr"));
                setVtc_imp_tarifa(rs.getDouble("vtc_imp_tarifa"));
                setVtc_ent_numero(rs.getInt("vtc_ent_numero"));
                setVtc_estatus(rs.getString("vtc_estatus"));
                setVtc_usuario_registro(rs.getString("vtc_usuario_registro"));
                setVtc_fecha_registro(rs.getDate("vtc_fecha_registro"));
                setVtc_usuario_modifica(rs.getString("vtc_usuario_modifica"));
                setVtc_fecha_modifica(rs.getDate("vtc_fecha_modifica"));

            }
        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            throw new WellException("com.wellcom.prosa.sacii.mnto.DaoMntoDistribuidor: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        /*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */

    }

    public void guardaDatosDistribuidor(HttpSession session, String distribuidor)
            throws WellException {
        /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
        try {
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            String update = " update VTC.tbl_vtc_cat_distribuidor@LG_PMTU_PMTWEB_IFO2_VTC"
                    + "set  vtc_imp_tarifa = " + getVtc_imp_tarifa()
                    + " ,vtc_ent_numero= " + getVtc_ent_numero()
                    + " ,vtc_estatus= '" + getVtc_estatus() + "'"
                    + " ,vtc_usuario_modifica= '" + session.getAttribute("login") + "'"
                    + " ,vtc_fecha_modifica = '" + df.format(new Date()) + "'"
                    + " ,vtc_fecha_modifica = TO_DATE('" + df.format(new Date()) + "','DD/MM/YYYY')"
                    + " where vtc_id_distr=" + distribuidor;
            conOracle.Conectar();
            conOracle.Modificar(update);
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.mnto.guardaDatosDistribuidor: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        /*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */

    }

    public Integer getVtc_id_distr() {
        return vtc_id_distr;
    }

    public void setVtc_id_distr(Integer vtc_id_distr) {
        this.vtc_id_distr = vtc_id_distr;
    }

    public String getVtc_nom_distr() {
        return vtc_nom_distr;
    }

    public void setVtc_nom_distr(String vtc_nom_distr) {
        this.vtc_nom_distr = vtc_nom_distr;
    }

    public Double getVtc_imp_tarifa() {
        return vtc_imp_tarifa;
    }

    public void setVtc_imp_tarifa(Double vtc_imp_tarifa) {
        this.vtc_imp_tarifa = vtc_imp_tarifa;
    }

    public Integer getVtc_ent_numero() {
        return vtc_ent_numero;
    }

    public void setVtc_ent_numero(Integer vtc_ent_numero) {
        this.vtc_ent_numero = vtc_ent_numero;
    }

    public String getVtc_estatus() {
        return vtc_estatus;
    }

    public void setVtc_estatus(String vtc_estatus) {
        this.vtc_estatus = vtc_estatus;
    }

    public String getVtc_usuario_registro() {
        return vtc_usuario_registro;
    }

    public void setVtc_usuario_registro(String vtc_usuario_registro) {
        this.vtc_usuario_registro = vtc_usuario_registro;
    }

    public Date getVtc_fecha_registro() {
        return vtc_fecha_registro;
    }

    public void setVtc_fecha_registro(Date vtc_fecha_registro) {
        this.vtc_fecha_registro = vtc_fecha_registro;
    }

    public String getVtc_usuario_modifica() {
        return vtc_usuario_modifica;
    }

    public void setVtc_usuario_modifica(String vtc_usuario_modifica) {
        this.vtc_usuario_modifica = vtc_usuario_modifica;
    }

    public Date getVtc_fecha_modifica() {
        return vtc_fecha_modifica;
    }

    public void setVtc_fecha_modifica(Date vtc_fecha_modifica) {
        this.vtc_fecha_modifica = vtc_fecha_modifica;
    }

}
