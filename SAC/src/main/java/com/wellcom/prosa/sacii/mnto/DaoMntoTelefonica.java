/*###############################################################################
# Nombre del Programa :  DaoMntoTelefonica.java                                 #
# Autor               :  JUan Antonio Guzman Gomez                              #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  z-02-2675-12                   FECHA:05/03/2013        #
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
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import com.wellcom.exceptions.WellException;
/*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
import com.wellcom.conexion.*;
/*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */

public class DaoMntoTelefonica {

    private Integer vtc_cve_telef;
    private String vtc_nom_telef;
    private String vtc_tipo_dato;
    private Double vtc_tasa_com_int_cre;
    private Double vtc_tasa_com_adq_cre;
    private Double vtc_tasa_com_com_cre;
    private Double vtc_tasa_com_int_deb;
    private Double vtc_tasa_com_adq_deb;
    private Double vtc_tasa_com_com_deb;
    private Double vtc_tasa_com_int_efe;
    private Double vtc_tasa_com_adq_efe;
    private Double vtc_tasa_com_com_efe;
    private Double vtc_tasa_iva;
    private String usuario_registro;
    private Date fecha_registro;
    private String estatus;
    private String usuario_modifica;
    private Date fecha_modifica;
    /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
    ConexionORACLE conOracle = null;

    public DaoMntoTelefonica() {
        conOracle = new ConexionORACLE();
    }

    /*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */
    public void buscaDatosTelefonica(HttpSession session, String telefonica) throws WellException {
        String busqueda
                = "	select "
                + "	 vtc_cve_telef, "
                + "	   vtc_nom_telef, "
                + "	   vtc_tipo_dato, "
                + "	   vtc_tasa_com_int_cre, "
                + /// tasa comision intercambio credito 
                "	   vtc_tasa_com_adq_cre, "
                + // tasa comision adquiriente credito
                "	   vtc_tasa_com_com_cre, "
                + // tasa comision comercio credito
                "	   vtc_tasa_com_int_deb, "
                + // tasa comision intercambio debito
                "	   vtc_tasa_com_adq_deb, "
                + // tasa comision adquiriente debito
                "	   vtc_tasa_com_com_deb, "
                + // tasa comision comercio debito
                "	   vtc_tasa_com_int_efe, "
                + // tasa comision intercambio efectivo
                "	   vtc_tasa_com_adq_efe, "
                + // tasa comision adquiriente efectivo
                "	   vtc_tasa_com_com_efe, "
                + // tasa comision comercio efectivo
                "	   vtc_tasa_iva,         "
                + // tasa iva 
                "	   usuario_registro,     "
                + "	   fecha_registro,       "
                + "	   estatus,              "
                + // estatus
                "	   usuario_modifica,     "
                + "	   fecha_modifica        "
                + "	from VTC.tbl_vtc_cat_telefonicas@LG_PMTU_PMTWEB_IFO2_VTC"
                + "   where vtc_cve_telef = " + telefonica;

        try {
            /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
            conOracle.Conectar();
            conOracle.Consultar(busqueda);
            ResultSet rs = conOracle.getResultSet();
            /*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */
            while (rs.next()) {

                setVtc_cve_telef(rs.getInt("vtc_cve_telef"));
                setVtc_nom_telef(rs.getString("vtc_nom_telef"));
                setVtc_tipo_dato(rs.getString("vtc_tipo_dato"));
                setVtc_tasa_com_int_cre(rs.getDouble("vtc_tasa_com_int_cre"));

                setVtc_tasa_com_adq_cre(rs.getDouble("vtc_tasa_com_adq_cre"));
                setVtc_tasa_com_com_cre(rs.getDouble("vtc_tasa_com_com_cre"));
                setVtc_tasa_com_int_deb(rs.getDouble("vtc_tasa_com_int_deb"));
                setVtc_tasa_com_adq_deb(rs.getDouble("vtc_tasa_com_adq_deb"));
                setVtc_tasa_com_com_deb(rs.getDouble("vtc_tasa_com_com_deb"));
                setVtc_tasa_com_int_efe(rs.getDouble("vtc_tasa_com_int_efe"));
                setVtc_tasa_com_adq_efe(rs.getDouble("vtc_tasa_com_adq_efe"));
                setVtc_tasa_com_com_efe(rs.getDouble("vtc_tasa_com_com_efe"));
                setVtc_tasa_iva(rs.getDouble("vtc_tasa_iva"));

                setEstatus(rs.getString("estatus"));

            }

        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.mnto.buscaDatosTelefonica: " + ex.toString());
        /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
        } finally {
            conOracle.Desconectar();
        }
        /*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */
    }

    public void guardaDatosTelefonica(HttpSession session, String telefonica) throws WellException {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        try {
            String update
                    = " update  VTC.tbl_vtc_cat_telefonicas@LG_PMTU_PMTWEB_IFO2_VTC"
                    + "	 set   vtc_tasa_com_int_cre= " + getVtc_tasa_com_int_cre()
                    + "	   ,vtc_tasa_com_adq_cre = " + getVtc_tasa_com_adq_cre()
                    + "	   ,vtc_tasa_com_com_cre= " + getVtc_tasa_com_com_cre()
                    + "	   ,vtc_tasa_com_int_deb= " + getVtc_tasa_com_int_deb()
                    + "	   ,vtc_tasa_com_adq_deb= " + getVtc_tasa_com_adq_deb()
                    + "	   ,vtc_tasa_com_com_deb= " + getVtc_tasa_com_com_deb()
                    + "	   ,vtc_tasa_com_int_efe= " + getVtc_tasa_com_int_efe()
                    + "	   ,vtc_tasa_com_adq_efe= " + getVtc_tasa_com_adq_efe()
                    + "	   ,vtc_tasa_com_com_efe= " + getVtc_tasa_com_com_efe()
                    + "	   ,vtc_tasa_iva=         " + getVtc_tasa_iva()
                    + "	   ,estatus=              '" + getEstatus() + "'"
                    + "	   ,usuario_modifica=     '" + session.getAttribute("login") + "'"
                    + "	   ,fecha_modifica= TO_DATE('" + df.format(new Date()) + "','DD/MM/YYYY')"
                    + "   where vtc_cve_telef = " + telefonica;
        /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
            conOracle.Conectar();
            conOracle.Modificar(update);
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.mnto.guardaDatosTelefonica: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        /*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */
    }

    public Integer getVtc_cve_telef() {
        return vtc_cve_telef;
    }

    public void setVtc_cve_telef(Integer vtc_cve_telef) {
        this.vtc_cve_telef = vtc_cve_telef;
    }

    public String getVtc_nom_telef() {
        return vtc_nom_telef;
    }

    public void setVtc_nom_telef(String vtc_nom_telef) {
        this.vtc_nom_telef = vtc_nom_telef;
    }

    public String getVtc_tipo_dato() {
        return vtc_tipo_dato;
    }

    public void setVtc_tipo_dato(String vtc_tipo_dato) {
        this.vtc_tipo_dato = vtc_tipo_dato;
    }

    public Double getVtc_tasa_com_int_cre() {
        return vtc_tasa_com_int_cre;
    }

    public void setVtc_tasa_com_int_cre(Double vtc_tasa_com_int_cre) {
        this.vtc_tasa_com_int_cre = vtc_tasa_com_int_cre;
    }

    public Double getVtc_tasa_com_adq_cre() {
        return vtc_tasa_com_adq_cre;
    }

    public void setVtc_tasa_com_adq_cre(Double vtc_tasa_com_adq_cre) {
        this.vtc_tasa_com_adq_cre = vtc_tasa_com_adq_cre;
    }

    public Double getVtc_tasa_com_com_cre() {
        return vtc_tasa_com_com_cre;
    }

    public void setVtc_tasa_com_com_cre(Double vtc_tasa_com_com_cre) {
        this.vtc_tasa_com_com_cre = vtc_tasa_com_com_cre;
    }

    public Double getVtc_tasa_com_int_deb() {
        return vtc_tasa_com_int_deb;
    }

    public void setVtc_tasa_com_int_deb(Double vtc_tasa_com_int_deb) {
        this.vtc_tasa_com_int_deb = vtc_tasa_com_int_deb;
    }

    public Double getVtc_tasa_com_adq_deb() {
        return vtc_tasa_com_adq_deb;
    }

    public void setVtc_tasa_com_adq_deb(Double vtc_tasa_com_adq_deb) {
        this.vtc_tasa_com_adq_deb = vtc_tasa_com_adq_deb;
    }

    public Double getVtc_tasa_com_com_deb() {
        return vtc_tasa_com_com_deb;
    }

    public void setVtc_tasa_com_com_deb(Double vtc_tasa_com_com_deb) {
        this.vtc_tasa_com_com_deb = vtc_tasa_com_com_deb;
    }

    public Double getVtc_tasa_com_int_efe() {
        return vtc_tasa_com_int_efe;
    }

    public void setVtc_tasa_com_int_efe(Double vtc_tasa_com_int_efe) {
        this.vtc_tasa_com_int_efe = vtc_tasa_com_int_efe;
    }

    public Double getVtc_tasa_com_adq_efe() {
        return vtc_tasa_com_adq_efe;
    }

    public void setVtc_tasa_com_adq_efe(Double vtc_tasa_com_adq_efe) {
        this.vtc_tasa_com_adq_efe = vtc_tasa_com_adq_efe;
    }

    public Double getVtc_tasa_com_com_efe() {
        return vtc_tasa_com_com_efe;
    }

    public void setVtc_tasa_com_com_efe(Double vtc_tasa_com_com_efe) {
        this.vtc_tasa_com_com_efe = vtc_tasa_com_com_efe;
    }

    public Double getVtc_tasa_iva() {
        return vtc_tasa_iva;
    }

    public void setVtc_tasa_iva(Double vtc_tasa_iva) {
        this.vtc_tasa_iva = vtc_tasa_iva;
    }

    public String getUsuario_registro() {
        return usuario_registro;
    }

    public void setUsuario_registro(String usuario_registro) {
        this.usuario_registro = usuario_registro;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getUsuario_modifica() {
        return usuario_modifica;
    }

    public void setUsuario_modifica(String usuario_modifica) {
        this.usuario_modifica = usuario_modifica;
    }

    public Date getFecha_modifica() {
        return fecha_modifica;
    }

    public void setFecha_modifica(Date fecha_modifica) {
        this.fecha_modifica = fecha_modifica;
    }

}
