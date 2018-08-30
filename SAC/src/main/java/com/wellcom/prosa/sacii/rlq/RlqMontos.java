package com.wellcom.prosa.sacii.rlq;

/*
#################################################################################
# Nombre              :  RlqMontos.java                                         #
# Autor               :  Gerardo G. Burguete                                    #
# Compania            :  Axia Consultores, S.A. de C.V.                         #
# Proyecto/Procliente :  P-53-2933-14                 	       FECHA:04/06/2015 #
# Descripcion General :	 Recalculo de compensacion y administracion de umbrales #
#-------------------------------------------------------------------------------#
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :  Acceder al sistema                                     #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :  A Peticion del web, se pueden ejecutar n instancias    #
#-------------------------------------------------------------------------------#
#                               MODIFICACIONES                                  #
#-------------------------------------------------------------------------------#
# Autor               : Ascencion Hernandez Huerta                              #
# Compania            : Axia Consultores, S.A. DE C.V.                          #
# Proyecto/Procliente : P-53-2933-14                           Fecha:20/06/2016 #
# Descripcion General : Re-calculo de compensacion y administracion de umbrales #
# Modificación        : Incorporar nuevo reporte SICLIQR320                     #
# Marca del Cambio    : AXIA-AHH-P-53-2933-14                                   #
#-------------------------------------------------------------------------------#
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-------------------------------------------------------------------------------#
 */
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.wellcom.Validator.Validador;
/*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
import com.wellcom.conexion.ConexionORACLE;
/*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */
import com.wellcom.exceptions.WellException;
import com.wellcom.prosa.sacii.SacIIRequest;
import com.wellcom.prosa.sacii.TimeUtils;
import java.text.ParseException;

import com.wellcom.sql.Database;

public class RlqMontos implements SacIIRequest {

    public RlqMontos() {
    }
    /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
    ConexionORACLE conOracle = null;

    /*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */
    public String procesaPeticion(HttpServletRequest req) throws WellException {

        String tRes = "/login.jsp";
        String accion = req.getParameter("action");

        if (accion == null) {
            accion = "";
        }
        if (accion.equals("rlqMontosHeader")) {
            tRes = "/rlq/rlqMontosHeader.jsp";
        } else if (accion.equals("rlqMontosHeaderAct")) {
            tRes = procesaMontos(req);
        } else if (accion.equals("rlqMontosHeaderPrc")) {
            tRes = liberaProrrateo(req);
        } else if (accion.indexOf("SICLIQ") >= 0) {
            tRes = processRequest(req);
        }
        return tRes;
    }

    private String liberaProrrateo(HttpServletRequest req) throws WellException {

        String tRes = "/index.jsp";
        RlqMontosParamsVO monto = validaCampos(req, "s");
        req.setAttribute("pant", "/rlq/rlqMontosHeader.jsp");

        int iReg = insertaReg(req, monto, "s");
        System.out.println("iReg->" + iReg);
        if (iReg == 1) {
            monto.setMsg("Se ha liberado el prorrateo...!!!");
        } else if (iReg == -1) {
            monto.setMsg("El Registro de prorrateo se actualizo correctamente...!!!");
        } else {
            monto.setMsg("Hay error insertando/actualizado el registro del prorrateo, Verifique con su administrador...!!!");
        }

        tRes = "/index.jsp";
        req.setAttribute("monto", monto);

        return tRes;

    }

    private String procesaMontos(HttpServletRequest req) throws WellException {

        String tRes = "/index.jsp";

        RlqMontosParamsVO monto = validaCampos(req, "n");
        req.setAttribute("pant", "/rlq/rlqMontosHeader.jsp");
        if (monto.getDatoValido() == 1) {
            int iReg = insertaReg(req, monto, "n");
            System.out.println("iReg->" + iReg);
            if (iReg == 1) {
                monto.setMsg("El Registro se inserto correctamente...!!!");
            } else if (iReg == -1) {
                monto.setMsg("El Registro se actualizo correctamente...!!!");
            } else {
                monto.setMsg("Hay error insertando el registro, Verifique con su administrador...!!!");
            }
        }
        tRes = "/index.jsp";
        req.setAttribute("monto", monto);
        return tRes;
    }

    private int insertaReg(HttpServletRequest req, RlqMontosParamsVO monto, String tProrrateo) throws WellException {

        int iRes = 0;
        StringBuffer bQuery = new StringBuffer();
        /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
        conOracle = new ConexionORACLE();
        //Connection        con = null;
        PreparedStatement ps = null;

        bQuery.append("INSERT\n");
        bQuery.append("  INTO rlq.TBL_POSNES_BANCOS_AJUSTES_LIQ@LG_PMTU_IFO_01\n");
        bQuery.append("       ( ENT_NUMERO_PROSA\n");
        bQuery.append("        ,IMPORTE_LIQUIDA\n");
        bQuery.append("        ,FECHA_LIQUIDACION\n");
        bQuery.append("        ,USUARIO_REGISTRA\n");
        bQuery.append("        ,ESTATUS\n");
        bQuery.append("       ) VALUES (\n");
        bQuery.append("        ?, ?, ?, ?, ?\n");
        bQuery.append("       )\n");
        System.out.println(bQuery.toString());
        //sessionID = req.getRequestedSessionId();
        HttpSession ses = req.getSession(true);
        String tLogin = (String) ses.getAttribute("login");
        //db = (Database)ses.getAttribute(sessionID + "db");

        try {
            conOracle.Conectar();
            //con = db.getConnection();
            Date fecha = new Date(convierteFecha(monto.getFecha()));
            ps = conOracle.getConnection().prepareStatement(bQuery.toString());
            if (tProrrateo.equalsIgnoreCase("s")) {
                ps.setInt(1, Integer.valueOf("31").intValue());
                ps.setDouble(2, Double.valueOf("0.0").doubleValue());
                ps.setDate(3, fecha);
                ps.setString(4, tLogin);
                ps.setString(5, "X");
            } else {
                ps.setInt(1, Integer.valueOf(monto.getEnt()).intValue());
                ps.setDouble(2, Double.valueOf(monto.getImp()).doubleValue());
                ps.setDate(3, fecha);
                ps.setString(4, tLogin);
                ps.setString(5, monto.getEstatus());
            }

            iRes = ps.executeUpdate();
            if (iRes != 1) {
                iRes = -5;
                //con.rollback();
                conOracle.getConnection().rollback();
            } else {
                conOracle.getConnection().commit();
                //con.commit();
            }

        } catch (SQLException sqlEx) {
            if (sqlEx.getMessage().indexOf("unique constraint") != 0) {
                iRes = ActualizaReg(conOracle.getConnection(), monto, tLogin, tProrrateo);
            } else {
                iRes = -10;
            }
        } catch (Exception ex) {
            iRes = -20;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                }
            }
            conOracle.Desconectar();
            /*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */
        }
        return iRes;
    }

    private int ActualizaReg(Connection con, RlqMontosParamsVO monto, String tLogin, String tProrrateo) throws WellException {

        int iRes = 0;
        StringBuffer bQuery = new StringBuffer();

        PreparedStatement ps = null;

        bQuery.append("UPDATE rlq.TBL_POSNES_BANCOS_AJUSTES_LIQ@LG_PMTU_IFO_01\n");
        bQuery.append("   SET IMPORTE_LIQUIDA   = ?\n");
        bQuery.append("      ,USUARIO_MODIFICA  = ?\n");
        bQuery.append("      ,ESTATUS           = ?\n");
        bQuery.append(" WHERE ENT_NUMERO_PROSA  = ?\n");
        bQuery.append("   AND FECHA_LIQUIDACION = ?\n");
        System.out.println(bQuery.toString());

        try {

            Date fecha = new Date(convierteFecha(monto.getFecha()));
            ps = con.prepareStatement(bQuery.toString());
            if (tProrrateo.equalsIgnoreCase("n")) {
                ps.setDouble(1, Double.valueOf(monto.getImp()).doubleValue());
                ps.setString(2, tLogin);
                ps.setString(3, monto.getEstatus());
                ps.setInt(4, Integer.valueOf(monto.getEnt()).intValue());
                ps.setDate(5, fecha);
            } else {
                ps.setDouble(1, Double.valueOf("0.00").doubleValue());
                ps.setString(2, tLogin);
                ps.setString(3, "X");
                ps.setInt(4, Integer.valueOf("31").intValue());
                ps.setDate(5, fecha);
            }

            iRes = ps.executeUpdate();
            if (iRes != 1) {
                iRes = -5000;
                con.rollback();
            } else {
                con.commit();
                iRes = -1;
            }

        } catch (SQLException sqlEx) {
            try {
                con.rollback();
            } catch (SQLException se) {
            }
            iRes = -1000;
        } catch (Exception ex) {
            iRes = -20000;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                }
            }
        }
        return iRes;
    }

    private RlqMontosParamsVO validaCampos(HttpServletRequest req, String tProrrateo) {

        boolean fDatoValido = false;
        RlqMontosParamsVO monto = new RlqMontosParamsVO();
        monto.setEnt(req.getParameter("ent"));
        monto.setImp(req.getParameter("imp"));
        monto.setFecha(req.getParameter("txtfStartDate"));
        monto.setEstatus(req.getParameter("est"));

        fDatoValido = validaNumerico(monto.getEnt(), 4);
        if (!fDatoValido) {
            monto.setMsg("Error en el campo Entidad, Verificar...!!!");
            return monto;
        }
        fDatoValido = false;
        fDatoValido = validaDoble(monto.getImp(), 14);
        if (!fDatoValido) {
            monto.setMsg("Error en el campo Monto, Verificar...!!!");
            return monto;
        }
        fDatoValido = false;
        fDatoValido = validaFecha(monto.getFecha());
        if (!fDatoValido) {
            monto.setMsg("Error en el campo Fecha, Verificar...!!!");
            return monto;
        }

        String tEstatus = req.getParameter("est");
        if (tEstatus.length() != 1) {
            monto.setMsg("Error en el campo Estatus, Verificar...!!!");
            return monto;
        }
        if (tEstatus.equalsIgnoreCase("A") || tEstatus.equalsIgnoreCase("I") || (tProrrateo.equalsIgnoreCase("s"))) {
            monto.setDatoValido(1);
            return monto;
        } else {
            monto.setEstatus("Error en el campo Estatus, Verificar...!!!");
        }
        return monto;
    }

    public boolean validaFecha(String fecha) {
        try {
            fecha += " 0:00:00";
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy H:mm:ss", new Locale("es", "MX"));
            java.util.Date fa = df.parse(fecha);
            Calendar cal = Calendar.getInstance(new Locale("es", "MX"));
            cal.setTime(fa);
            if (cal.get(Calendar.DATE) != Integer.valueOf(fecha.substring(0, 2)).intValue()) {
                return false;
            }
            int mesCal = cal.get(Calendar.MONTH) + 1;
            int mesFec = Integer.valueOf(fecha.substring(3, 5)).intValue();
            if (mesCal != mesFec) {
                return false;
            }
            return true;
        } catch (Exception ignore) {
            return false;
        }
    }

    public long convierteFecha(String fecha) throws Exception {

        fecha += " 0:00:00";
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy H:mm:ss", new Locale("es", "MX"));
        java.util.Date fa = df.parse(fecha);
        return fa.getTime();
    }

    private boolean validaDoble(String val, int len) {
        boolean fRes = false;
        int pos = val.indexOf(".");
        if (pos == -1) {
            pos = len;
        } else {
            pos += 1;
        }
        String tReg = "-?\\d{1," + pos + "}?\\.??\\d{0,2}";
        if (val.length() > len) {
            return fRes;
        }
        if (val.matches(tReg)) {
            fRes = true;
        }
        return fRes;
    }

    private boolean validaNumerico(String tNum, int largo) {
        boolean fRes = false;
        try {
            @SuppressWarnings("unused")
            Integer num = new Integer(tNum);
        } catch (NumberFormatException ignore) {
            return false;
        }
        if (tNum.length() > 0 && tNum.length() <= largo) {
            fRes = true;
        } else {
            fRes = false;
        }
        return fRes;
    }

    private String processRequest(HttpServletRequest request)
            throws WellException {

        String action = request.getParameter("action");
        HttpSession session = request.getSession(true);
        String url = "";
        Validador value = new Validador();

        if (action.equals("SICLIQ0020")) {
            url = "/SICLIQ0020Header.jsp";
        } else if (action.equals("SICLIQ0020Main")) {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String[] bancoSocioArray = request.getParameterValues("bancoSocio");
            String bancosSocios = "";
            for (String banco : bancoSocioArray) {
                if (!bancosSocios.equals("")) {
                    bancosSocios += ",";
                }
                bancosSocios += banco;
            }
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoSocio", bancosSocios);
            Oparticionesdiaant(initDate, endDate, initDate, endDate, request);
            url = value.valida(session, initDate, endDate, "SICLIQ0020");
        } else if (action.equals("SICLIQ0030")) {
            url = "/SICLIQ0030Header.jsp";
        } else if (action.equals("SICLIQ0030Main")) {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            try {
                Oparticionesdiaant(initDate, endDate, initDate, endDate, request);
                url = value.valida(session, initDate, endDate, "SICLIQ0030");
            } catch (WellException e) {
                e.printStackTrace();
            }
        } else if (action.equals("SICLIQ0040")) {
            url = "/SICLIQ0040Header.jsp";
        } else if (action.equals("SICLIQ0040Main")) {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            try {
                Oparticionesdiaant(initDate, endDate, initDate, endDate, request);
                url = value.valida(session, initDate, endDate, "SICLIQ0040");
            } catch (WellException e) {
                e.printStackTrace();
            }
        } else if (action.equals("SICLIQ0087")) {
            url = "/SICLIQ0087Header.jsp";
        } else if (action.equals("SICLIQ0087Main")) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String natCont = request.getParameter("natCont");
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("natCont", natCont);
            try {
                session.setAttribute("txtfStartDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("txtfEndDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                url = value.valida(session, initDate, endDate, "SICLIQ0087");
            } catch (WellException e) {
                e.printStackTrace();
            } catch (ParseException pe) {
                pe.printStackTrace();
            }
        } else if (action.equals("SICLIQ0320")) {
            url = "/SICLIQ0320Header.jsp";
        } else if (action.equals("SICLIQ0320Main")) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String[] tipoLiq = request.getParameterValues("tipoLiq");
            String tipoLiqStr = "";
            for (String tipoL : tipoLiq) {
                if (!tipoLiqStr.equals("")) {
                    tipoLiqStr += ",";
                }
                tipoLiqStr += tipoL;
            }
            if (tipoLiqStr.contains("21")) {
                tipoLiqStr += ",27";
            }
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("tipoLiq", tipoLiqStr);
            try {
                session.setAttribute("initDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("endDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                url = value.valida(session, initDate, endDate, "SICLIQ0320");
            } catch (WellException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
//----------------------------------------------------------------------------//
//--Marca del Cambio : AXIA-AHH-P-53-2933-14 Inicia  Modificacion 20/06/2016 -//
//----------------------------------------------------------------------------//
        } else if (action.equals("SICLIQR320")) {
            url = "/SICLIQR320Header.jsp";
        } else if (action.equals("SICLIQR320Main")) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String[] tipoLiq = request.getParameterValues("tipoLiq");
            String tipoLiqStr = "";
            for (String tipoL : tipoLiq) {
                if (!tipoLiqStr.equals("")) {
                    tipoLiqStr += ",";
                }
                tipoLiqStr += tipoL;
            }
            if (tipoLiqStr.contains("21")) {
                tipoLiqStr += ",27";
            }
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("tipoLiq", tipoLiqStr);
            try {
                session.setAttribute("initDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("endDateHabAnt", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                url = value.valida(session, initDate, endDate, "SICLIQR320");
            } catch (WellException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
//----------------------------------------------------------------------------//
//--Marca del Cambio : AXIA-AHH-P-53-2933-14 Termina Modificacion 20/06/2016 -//
//----------------------------------------------------------------------------//
        } else if (action.equals("SICLIQ0500")) {
            url = "/SICLIQ0500Header.jsp";
        } else if (action.equals("SICLIQ0500Main")) {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String[] bancoSocioArray = request.getParameterValues("bancoSocio");
            String bancosSocios = "";
            for (String banco : bancoSocioArray) {
                if (!bancosSocios.equals("")) {
                    bancosSocios += ",";
                }
                bancosSocios += banco;
            }
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoSocio", bancosSocios);
            try {
                url = value.valida(session, initDate, endDate, "SICLIQ0500");
            } catch (WellException e) {
                e.printStackTrace();
            }
        } else if (action.equals("SICLIQ0510")) {
            url = "/SICLIQ0510Header.jsp";
        } else if (action.equals("SICLIQ0510Main")) {
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String[] bancoSocioArray = request.getParameterValues("bancoSocio");
            String bancosSocios = "";
            for (String banco : bancoSocioArray) {
                if (!bancosSocios.equals("")) {
                    bancosSocios += ",";
                }
                bancosSocios += banco;
            }
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoSocio", bancosSocios);
            try {
                url = value.valida(session, initDate, endDate, "SICLIQ0510");
            } catch (WellException e) {
                e.printStackTrace();
            }
        } else if (action.equals("SICLIQ0077")) {
            url = "/SICLIQ0077Header.jsp";
        } else if (action.equals("SICLIQ0077Main")) {

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String natCont = request.getParameter("natCont");

            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("natCont", natCont);

            try {
                url = value.valida(session, initDate, endDate, "SICLIQ0077");
            } catch (WellException e) {
                e.printStackTrace();
            }
        } else if (action.equals("SICLIQ0090")) {
            url = "/SICLIQ0090Header.jsp";
        } else if (action.equals("SICLIQ0090Main")) {

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String initDate = request.getParameter("txtfStartDate");
            String endDate = request.getParameter("txtfEndDate");
            String[] bancos = request.getParameterValues("banco");
            String bancosStr = "";
            for (String banco : bancos) {
                if (!bancosStr.equals("")) {
                    bancosStr += ",";
                }
                bancosStr += banco;
            }

            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("banco", bancosStr);

            try {

                session.setAttribute("txtfStartDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(initDate))));
                session.setAttribute("txtfEndDatePrev", format.format(TimeUtils.getDiaNatAnt(session, format.parse(endDate))));
                url = value.valida(session, initDate, endDate, "SICLIQ0090");

            } catch (WellException e) {
                e.printStackTrace();
            } catch (ParseException pe) {
                pe.printStackTrace();
            }
        }
        return url;
    }

    private void Oparticionesdiaant(String fechaA, String fechaB, String fechaC, String fechaD, HttpServletRequest request) {

        ArrayList fechas;
        ArrayList fechas2;
        String SQL = "";
        String SQL2 = "";

        /*#Marca de cambio:  SAS-DRT F-52-8063-16  inicio Modificación #  */
        //sessionID = request.getRequestedSessionId();
        HttpSession session = request.getSession(true);
        conOracle = new ConexionORACLE();
        //db = (Database)session.getAttribute(sessionID + "db");

        try {

            SQL = "SELECT PMADMIN.FN_PARTITION_ID(TO_DATE('" + fechaA + "','DD/MM/YYYY'))||' AND '||PMADMIN.FN_PARTITION_ID(TO_DATE('" + fechaB + "','DD/MM/YYYY')) FROM DUAL";
            SQL2 = "SELECT PMADMIN.FN_PARTITION_ID(TO_DATE('" + fechaA + "','DD/MM/YYYY')-1)||' AND '||PMADMIN.FN_PARTITION_ID(TO_DATE('" + fechaB + "','DD/MM/YYYY')-1) FROM DUAL";
            conOracle.Conectar();
            conOracle.Consultar(SQL);
            fechas = conOracle.getRSColsData();
            /*
            db.setQuerySelect(SQL);
            db.executeQuerySelect();
            db.closeResultSet();
             */

            conOracle.Consultar(SQL2);
            fechas2 = conOracle.getRSColsData();
            /* db.setQuerySelect(SQL2);
            db.executeQuerySelect();
            db.closeResultSet();*/

            String[] susparticiones = (String[]) fechas.get(0);
            String[] susparticioneshabant = (String[]) fechas2.get(0);

            session.setAttribute("susparticiones", susparticiones[0]);
            session.setAttribute("susparticionesdiaant", susparticioneshabant[0]);

            System.out.println(susparticiones + "::");
            System.out.println(susparticioneshabant + "::");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conOracle.Desconectar();
        }
        /*#Marca de cambio:  SAS-DRT F-52-8063-16  fin Modificación #  */
    }

}
