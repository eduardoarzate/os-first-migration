/*###############################################################################
# Nombre del Programa :  ComboBoxGen.java                                       #
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
#################################################################################
# Autor               :  Juan Rodriguez Gonzalez                                #
# Compania            :  IDSYS S.A. DE C.V.                                     #
# Proyecto/Procliente :  P-22-0136-14                Fecha: 12/04/2017          #
# Modificacion        :  Reportes de transacodificadas                          #
# Marca de cambio     :  IDSYS-JRG-P-22-0136-14                                 #
#-------------------------------------------------------------------------------#
# Autor               :  Daniel Ramírez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  P-20-0115-16                 Fecha: 14/09/2017         #
# Modificacion        :  Incorporación de American Express (AMEX) a PROSA para  #
#                        transacciones POS                                      #
# Marca del Cambio    :  SAS-DRT-P-20-0115-16                                   #
#################################################################################
#                                                              Modificaciones   #
#-------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
package com.wellcom.prosa.sacii;

import com.wellcom.exceptions.WellException;
import com.wellcom.conexion.*;

import java.sql.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import javax.servlet.ServletException;
import java.util.Date;

public class ComboBoxGen {

    private String numFiid;
    private String role;
    private String query;
    private String fiid;
    private String login;
    private Connection conexion;
    ConexionORACLE conOracle = null;

    public ComboBoxGen() {
        conOracle = new ConexionORACLE();
    }

    public void getTipoTXS() {
        //System.out.println("Inicia Metodo getTipoTXS ");
        ResultSet rDatos = null;

        String sql = " SELECT COUNT(*) FROM PMADMIN.PRSA_REJECTED_TXN WHERE PRT_PROC_DTE = TO_DATE('27/07/2016','DD/MM/YYYY') ";

        try {
            conOracle.Conectar();
            rDatos = conOracle.Consultar(sql);

            while (rDatos.next()) {
                //System.out.println("Datos de result Set : " + rDatos.getString(1) + " : " + rDatos.getString(2));
                System.out.println("Datos de result Set : " + rDatos.getString(1));
            }

            rDatos.close();
            //System.out.println("FIN CLOSE Metodo getTipoTXS ");
        } catch (Exception e) {
            System.out.println(" Error al obtener Consulta:" + e);
        } finally {
            conOracle.Desconectar();
        }

    }

    public ArrayList getGrupoTrxs2(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");

            query = " select TCG_GRP_ID, (TCG_GRP_ID || ' ' || TCG_GRP_NAM) descripcion  "
                    + " from settlement.SZ_TC_GRP "
                    + " where TCG_GRP_ID not in(0,102,111,112,114,115,116,117,120,141,161,162,221,224,225,281,321,322,381,401)";

            query += " ORDER BY tcg_grp_id ";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getGrupoTrxs2: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancoAdqFiid(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");
            String tipo = session.getAttribute("tipo") == null ? "" : (String) session.getAttribute("tipo");
            query = "select distinct decode(tblExt.numero_fiid, 'EOTR', 'EGLO', tblExt.numero_fiid), "
                    + " (tblExt.numero_fiid || ' ' || tblExt.entidad_padre || ' ' || pe.descripcion  || ' ' || bu_tx_parent),tblExt.entidad_padre descripcion "
                    + " FROM pmadmin.VW_BUS_ACQ tblExt join pmadmin.prsa_entidades pe on pe.numero_prosa=tblExt.entidad_padre";
            query += " UNION ALL\n";
            query += "     SELECT NUMERO_FIID\n";
            query += "           ,NUMERO_FIID || ' ' || NUMERO_PROSA || ' '||DESCRIPCION\n";
            query += "           ,NUMERO_PROSA\n";
            query += "  FROM pmadmin.PRSA_ENTIDADES en\n";
            query += " WHERE en.NUMERO_PROSA = 2805\n";
            query += "ORDER BY 3\n";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoAdqFiid: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancoIntEntHijas(HttpSession session) throws WellException {
        HttpServletRequest request = null;
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");
            String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");

            if (role.equals("banco")) {
                query = " select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent )descripcion"
                        + " from PMADMIN.VW_BUS_ACQ tblext "
                        + " where "
                        + "  entidad_padre in (" + numerosProsa + ") "
                        + " union "
                        + " select distinct numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent )descripcion"
                        + " from PMADMIN.VW_BUS_EMI  "
                        + " where tie_numero=1 "
                        + " and numero_fiid not like 'U%' "
                        + " and entidad_padre in (" + numerosProsa + ")";
            } else {
                query = " select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent )descripcion"
                        + " from  PMADMIN.VW_BUS_ACQ  tblext "
                        + " where NUMERO_PROSA NOT IN (94,95,96,97,98) "
                        + " UNION SELECT 131 num, '131 CONCENTRADORA PESOS PROSA 461' DES from dual "
                        + " union "
                        + " select distinct numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent )descripcion"
                        + " from PMADMIN.VW_BUS_EMI "
                        + " where tie_numero=1 "
                        + " and entidad_padre=numero_prosa "
                        + " and bu_tx_parent not in (461,641) "
                        + " and numero_fiid not like 'U%' "
                        + " AND NUMERO_PROSA NOT IN (94,95,96,97,98) "
                        + " union "
                        + " select  numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent)descripcion"
                        + " from PMADMIN.VW_BUS_EMI "
                        + " where numero_prosa in("
                        + " select distinct hijas.numero_prosa "
                        + " from PMADMIN.PRSA_ENTIDADES  hijas, "
                        + " PMADMIN.PRSA_ENTIDADES padre "
                        + " where "
                        + " hijas.entidad_padre != hijas.numero_prosa "
                        + " and hijas.tie_numero=1 "
                        + " and bu_tx_parent not in (461,641) "
                        + ") "
                        + " and numero_fiid not like 'U%' "
                        + " AND NUMERO_PROSA NOT IN (94,95,96,97,98) ";
            }

            if (numerosProsa != null) {
                if (numerosProsa.contains("81") || !(role.equals("banco"))) {
                    query += " union  select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent)descripcion "
                            + " from PMADMIN.VW_BUS_EMI "
                            + " where  numero_prosa in(81) "
                            + " and numero_fiid not like 'U%' ";
                } else if (numerosProsa.contains("72") && (role.equals("banco"))) {
                    if (numerosProsa.contains("721")) {
                    }
                } else {
                }
            }

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoIntEntHijas: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancoAdqEmiConsol(HttpSession session) throws WellException {
        HttpServletRequest request = null;
        ArrayList cbValues;
        System.out.println(" Combo BoX Gen");
        try {
            role = (String) session.getAttribute("role");

            query = " select numero_prosa, descripcion from(	"
                    + " select entidad_padre, numero_prosa,  (numero_prosa||' '|| descripcion||' '||bu_tx_parent) descripcion "
                    + "  FROM PMADMIN.VW_BUS_ACQ "
                    + "  WHERE tie_numero=1 "
                    + "  union "
                    + "  select entidad_padre,numero_prosa, (numero_prosa||' '|| descripcion||' '||bu_tx_parent) descripcion "
                    + "  FROM PMADMIN.VW_BUS_EMI   "
                    + "  WHERE tie_numero=1 "
                    + "  and bu_tx_parent not in (461,641) "
                    + "  and numero_fiid not like 'U%' "
                    + " ) ";

            if (role.equals("banco")) {
                String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
                query += " where entidad_padre  in (" + numerosProsa + ") ";
            }
            query += " order by numero_prosa";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

            String[] consol = new String[2];
            if (!role.equals("banco")) {
                consol[0] = "0";
                consol[1] = "Consolidado";
                cbValues.add(consol);
            }
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoAdqEmiConsol: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getTipoTrxs(HttpSession session) throws WellException {
        HttpServletRequest request = null;
        ArrayList cbValues;

        try {
            query = " select numero,(numero || ' ' || descripcion) descripcion  "
                    + " from PMADMIN.PRSA_TIPOS_TRANSACCION "
                    + " WHERE numero not in(101,999) "
                    + " order by numero";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getTipoTrxs: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancoAdqSinDol(HttpSession session) throws WellException {
        HttpServletRequest request = null;
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");
            String tipo = session.getAttribute("tipo") == null ? "" : (String) session.getAttribute("tipo");

            query = "select distinct tblExt.entidad_padre, (tblExt.entidad_padre || ' ' || pe.descripcion  || ' ' || bu_tx_parent) descripcion "
                    + " FROM pmadmin.VW_BUS_ACQ tblExt join pmadmin.prsa_entidades pe on pe.numero_prosa=tblExt.entidad_padre ";

            if (role.equals("banco") || tipo.equals("emi")) {
                if (tipo.equals("emi")) {
                    query += " where tblExt.entidad_padre = pe.numero_prosa and tblExt.tie_numero<>9 ";
                } else {
                    String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
                    query += " where tblExt.entidad_padre  in (" + numerosProsa + ") and tblExt.tie_numero<>9 ";
                }
            } else {
                query += " where tblExt.entidad_padre = tblExt.numero_prosa and tblExt.tie_numero<>9 ";
            }
            query += "\n order by 1";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoAdq: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancosAdqsHijos(HttpSession session) throws WellException {
        HttpServletRequest request = null;
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");
            query = " select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion"
                    + " FROM PMADMIN.VW_BUS_ACQ "
                    + " WHERE NUMERO_PROSA NOT IN (SELECT DISTINCT VBA.ENTIDAD_PADRE FROM PMADMIN.VW_BUS_ACQ VBA WHERE VBA.TIE_NUMERO = 2 AND VBA.ENTIDAD_PADRE <> VBA.NUMERO_PROSA) ";

            if (role.equals("banco")) {
                String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
                query = " select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion"
                        + " FROM PMADMIN.VW_BUS_ACQ "
                        + " where entidad_padre  in (" + numerosProsa + ") \n"
                        + " AND NUMERO_PROSA NOT IN (SELECT DISTINCT VBA.ENTIDAD_PADRE FROM PMADMIN.VW_BUS_ACQ VBA WHERE VBA.TIE_NUMERO = 2 AND VBA.ENTIDAD_PADRE <> VBA.NUMERO_PROSA) "
                        + "";
            } else {
                ;
            }
            query += " order by numero_prosa ";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancosAdqsHijos: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;

    }

    public ArrayList getArchivoEntrada(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
            if (role.equals("banco")) {
                query = " select distinct numero, (numero || ' ' || descripcion)descripcion "
                        + " from  PMADMIN.PRSA_ARCHIVOS "
                        + " where entrada in (1) "
                        + " and ent_numero_prosa in (" + numerosProsa + ")"
                        + " order by numero ";
            } else {
                query = " select distinct numero, (numero || ' ' || descripcion)descripcion "
                        + " from  PMADMIN.PRSA_ARCHIVOS "
                        + " where entrada in (1) "
                        + " order by numero ";
            }
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.prosa.sacii.getArchivoEntrada: "
                    + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getCiclo(HttpSession session, String num) throws WellException {
        HttpServletRequest request = null;
        String nume;
        ArrayList cbValues;
        nume = num;
        try {

            if (num.equals("A")) {
                query = "select 1 from dual union select 2 from dual union select 3 from dual union select 4 from dual union select 5 from dual union select 6 from dual";
            } else if (num.equals("B")) {
                query = "select 101 from dual union select 102 from dual union select 103 from dual union select 104 from dual";
            } else if (num.equals("C")) {
                query = "select 1 from dual union select 2 from dual ";
            }

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.prosa.sacii.getCiclo: "
                    + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getPTLFPapel(HttpSession session) {
        ArrayList cbValues = new ArrayList(2);
        String[] ptlf = new String[2];
        String[] papel = new String[2];
        ptlf[0] = "5";
        ptlf[1] = "PTLF";
        papel[0] = "'Papel'";
        papel[1] = "Fuentes Papel";
        cbValues.add(ptlf);
        cbValues.add(papel);
        return cbValues;
    }

    public ArrayList getBancosSociosMI(HttpSession session) throws WellException {

        HttpServletRequest request = null;
        ArrayList cbValues;

        try {

            role = (String) session.getAttribute("role");
            query = " select numero_prosa,numero_prosa||' '||descripcion||' '||(select max(bu_tx_parent) from( "
                    + " select distinct numero_prosa,bu_tx_parent from pmadmin.vw_bus_emi "
                    + " union "
                    + " select distinct numero_prosa,bu_tx_parent from pmadmin.vw_bus_acq)where numero_prosa = ext.numero_prosa ) "
                    + " from pmadmin.prsa_entidades ext "
                    + " where "
                    + " TIE_NUMERO NOT IN (2) ";

            if (role.equals("banco")) {
                String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
                query += " and entidad_padre in( " + numerosProsa + ")";

            }
            query += " order by numero_prosa ";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoSocioMI: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancoAdqInterRed(HttpSession session) throws WellException {
        HttpServletRequest request = null;
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");
            String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");

            if (role.equals("banco")) {
                query = " select distinct entidad_padre,(entidad_padre || ' ' || descripcion || ' ' || bu_tx_parent)descripcion"
                        + " from  PMADMIN.VW_BUS_ACQ "
                        + " where tie_numero=2 "
                        + " and numero_prosa in (" + numerosProsa + ")"
                        + " and numero_prosa=entidad_padre "
                        + " order by entidad_padre";
            } else {
                query = " select Distinct entidad_padre, (entidad_padre || ' ' || descripcion || ' ' || bu_tx_parent)descripcion"
                        + " from  PMADMIN.VW_BUS_ACQ "
                        + " where tie_numero=2 "
                        + " and entidad_padre=numero_prosa "
                        + " order by entidad_padre";
            }

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoAdqInterRed: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    //  -- Marca del Cambio : SAS-DRT-P-53-2004-15 Inicia la Modificacion
    public ArrayList getTipoEntSal(HttpSession session) {
        ArrayList cbValues = new ArrayList(2);
        String[] entrante = new String[2];
        String[] saliente = new String[2];
        entrante[0] = "2";
        entrante[1] = "Entrante";
        saliente[0] = "3";
        saliente[1] = "Saliente";
        cbValues.add(entrante);
        cbValues.add(saliente);
        return cbValues;
    }
    //  -- Marca del Cambio : SAS-DRT-P-53-2004-15 Finaliza la Modificacion     

    public ArrayList getNaturalezaContable(HttpSession session) {
        ArrayList cbValues = new ArrayList(3);
        String[] consolidado = new String[2];
        String[] credito = new String[2];
        String[] debito = new String[2];
        consolidado[0] = "CD";
        consolidado[1] = "Consolidado";
        credito[0] = "C";
        credito[1] = "Credito";
        debito[0] = "D";
        debito[1] = "Debito";
        cbValues.add(consolidado);
        cbValues.add(credito);
        cbValues.add(debito);
        return cbValues;
    }

    public ArrayList getBancosEglo(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            if (session.getAttribute("report") != null && session.getAttribute("report").equals("580")) {
                query = " SELECT 0 NUMERO_PROSA, '0 CONSOLIDADO' DESCRIPCION FROM DUAL UNION ";
            } else {
                query = "";
            }
            query += "	select distinct numero_prosa, (numero_prosa||' '||descripcion||' '||bu_tx_parent) descripcion from  PMADMIN.VW_BUS_EMI where numero_ln='EGLO'  ";
            query += " order by numero_prosa";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

            String[] consol = new String[2];
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancosEGLO: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancoAdqEmi(HttpSession session) throws WellException {
        HttpServletRequest request = null;
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");

            query = "	select numero_prosa, descripcion from (  "
                    + "	 select entidad_padre,numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion "
                    + "  FROM PMADMIN.VW_BUS_ACQ "
                    + "  WHERE tie_numero=1 "
                    + "  union "
                    + "  select entidad_padre,numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion"
                    + "  FROM PMADMIN.VW_BUS_EMI  "
                    + "  WHERE tie_numero=1 "
                    + "  and bu_tx_parent not in (461,641) "
                    + "  ) ";

            if (role.equals("banco")) {
                String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
                query += " where entidad_padre  in (" + numerosProsa + ") ";
            }

            query += " order by numero_prosa";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoAdqEmi: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getMiscelaneos(HttpSession session) throws WellException {
        HttpServletRequest request = null;
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");

            query = " select distinct 1||TCX_TXN_CD_SFX, 1||TCX_TXN_CD_SFX||' '||replace(TCX_D,'+') "
                    + " from PMADMIN.CD_TXN_CD  "
                    + " where tcx_srce_c = 902 "
                    + " and tcx_proc_cd in (2) order by  1||TCX_TXN_CD_SFX ";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.prosa.sacii.getMiscelaneo: "
                    + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getTipoProc(HttpSession session) {
        ArrayList cbValues = new ArrayList(3);
        String[] entrante = new String[2];
        String[] saliente = new String[2];
        String[] circuitoLocal = new String[2];
        entrante[0] = "45";
        entrante[1] = "Entrante";
        circuitoLocal[0] = "774";
        circuitoLocal[1] = "Circuito Local";
        saliente[0] = "100";
        saliente[1] = "Saliente";
        cbValues.add(circuitoLocal);
        cbValues.add(entrante);
        cbValues.add(saliente);
        return cbValues;
    }

    public ArrayList getEmiAdq2(HttpSession session) {
        ArrayList cbValues = new ArrayList(2);
        String[] bco1 = new String[2];
        String[] bco2 = new String[2];
        bco1[0] = "ADQ";
        bco1[1] = "BANCO";
        bco2[0] = "EMI";
        bco2[1] = "PROSA";
        cbValues.add(bco1);
        cbValues.add(bco2);
        return cbValues;
    }

    public ArrayList getBancoAdqEmiSinEglo(HttpSession session) throws WellException {
        HttpServletRequest request = null;
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");

            query = "	select numero_prosa, descripcion from (  "
                    + "	 select entidad_padre,numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion "
                    + "  FROM PMADMIN.VW_BUS_ACQ "
                    + "  WHERE tie_numero=1 and numero_ln not in ('EGLO')"
                    + "  union "
                    + "  select entidad_padre,numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion"
                    + "  FROM PMADMIN.VW_BUS_EMI  "
                    + "  WHERE tie_numero=1 and numero_ln not in ('EGLO')"
                    + "  AND numero_fiid not like 'U%' "
                    + "  and bu_tx_parent not in (461,641) "
                    + "  ) ";

            if (role.equals("banco")) {
                String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
                query += " where entidad_padre  in (" + numerosProsa + ") ";
            }

            query += " order by numero_prosa";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoAdq: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    //  -- Marca del Cambio : SAS-DRT-P-53-2004-15 Inicia la Modificacion	
    public ArrayList getTipoDif(HttpSession session) {
        ArrayList cbValues = new ArrayList(3);
        String[] positiva = new String[2];
        String[] negativa = new String[2];
        String[] inexistente = new String[2];
        positiva[0] = "1";
        positiva[1] = "Positiva";
        inexistente[0] = "0";
        inexistente[1] = "Inexistente";
        negativa[0] = "-1";
        negativa[1] = "Negativa";
        cbValues.add(inexistente);
        cbValues.add(negativa);
        cbValues.add(positiva);
        return cbValues;
    }
//  -- Marca del Cambio : SAS-DRT-P-53-2004-15 Finaliza la Modificacion

    public ArrayList getBancosEmisHijos(HttpSession session) throws WellException {
        HttpServletRequest request = null;
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");

            if (role.equals("banco")) {
                String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");

                query = " select distinct numero_prosa, (numero_prosa || ' ' ||descripcion|| ' ' || bu_tx_parent) descripcion "
                        + " from PMADMIN.VW_BUS_EMI  tblext "
                        + " where entidad_padre in (" + numerosProsa + ") "
                        + " order by numero_prosa ";
            } else {
                query = " select distinct numero_prosa, (numero_prosa || ' ' ||descripcion|| ' ' || bu_tx_parent) descripcion "
                        + " from  PMADMIN.VW_BUS_EMI  tblext "
                        + " where bu_tx_parent not in (461,641) "
                        + " order by numero_prosa ";
            }
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancosEmisHijos: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancoBuAdq(HttpSession session) throws WellException {
        HttpServletRequest request = null;
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");
            String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");

            if (role.equals("banco")) {
                query = " SELECT VBA.NUMERO_PROSA, (VBA.NUMERO_PROSA||' '||VBA.DESCRIPCION||' '|| VBA.BU_TX_PARENT) BANCO "
                        + " FROM PMADMIN.VW_BUS_ACQ VBA "
                        + " WHERE NUMERO_PROSA IN (" + numerosProsa + ") "
                        + " ORDER BY 1 ";

            } else {
                query = " SELECT VBA.NUMERO_PROSA, (VBA.NUMERO_PROSA||' '||VBA.DESCRIPCION||' '|| VBA.BU_TX_PARENT) banco "
                        + " FROM PMADMIN.VW_BUS_ACQ VBA "
                        + " ORDER BY 1 ";

            }

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.prosa.sacii.getBancoBuAdq: "
                    + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancosSocios(HttpSession session) throws WellException {

        HttpServletRequest request = null;
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");

            query = " select numero_prosa,numero_prosa||' '||descripcion||' '||(select max(bu_tx_parent) from( "
                    + " select distinct numero_prosa,bu_tx_parent from pmadmin.vw_bus_emi "
                    + " where numero_fiid not like 'U%' "
                    + " union "
                    + " select distinct numero_prosa,bu_tx_parent "
                    + "    from pmadmin.vw_bus_acq)where numero_prosa = ext.numero_prosa "
                    + "    and bu_tx_parent not in (461,641)) "
                    + " from pmadmin.prsa_entidades ext "
                    + " where "
                    + " banco_socio='S' ";

            if (role.equals("banco")) {
                String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
                query += " and entidad_padre in( " + numerosProsa + ")";

            }
            query += " order by numero_prosa ";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoSocio: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getTipoLiq10(HttpSession session) {
        ArrayList cbValues = new ArrayList(5);
        String[] circuitoLocal = new String[2];
        String[] interred = new String[2];
        circuitoLocal[0] = "22";
        circuitoLocal[1] = "Liquidacion Circuito Local";
        interred[0] = "26";
        interred[1] = "Liquidacion Interredes";
        cbValues.add(circuitoLocal);
        cbValues.add(interred);
        return cbValues;
    }

    public ArrayList getBancoAdq(HttpSession session) throws WellException {

        HttpServletRequest request = null;
        ArrayList cbValues;

        try {

            role = (String) session.getAttribute("role");
            String tipo = session.getAttribute("tipo") == null ? "" : (String) session.getAttribute("tipo");

            query = "select distinct tblExt.entidad_padre, (tblExt.entidad_padre || ' ' || pe.descripcion  || ' ' || bu_tx_parent) descripcion "
                    + " FROM pmadmin.VW_BUS_ACQ tblExt join pmadmin.prsa_entidades pe on pe.numero_prosa=tblExt.entidad_padre ";

            if (role.equals("banco") || tipo.equals("emi")) {
                if (tipo.equals("emi")) {
                    query += " where tblExt.entidad_padre = pe.numero_prosa  ";
                } else {
                    String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
                    query += " where tblExt.entidad_padre  in (" + numerosProsa + ") ";
                }
            } else {
                query += " where tblExt.entidad_padre = tblExt.numero_prosa";
            }
            query += "\n order by 1";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoAdq: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancoEmiSinEgloVM(HttpSession session) throws WellException {
        HttpServletRequest request = null;
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");

            if (role.equals("banco")) {
                String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");

                query = " select distinct entidad_padre, (entidad_padre || ' ' ||(select  descripcion from pmadmin.prsa_entidades where numero_prosa in(tblext.entidad_padre))|| ' ' || bu_tx_parent) descripcion "
                        + " from PMADMIN.VW_BUS_EMI  tblext "
                        + " where "
                        + " tie_numero=1 "
                        + " and entidad_padre in (" + numerosProsa + ") "
                        + " and numero_fiid not like 'U%' "
                        + " and  numero_prosa not in(94,95,96,97,98) "
                        + " order by entidad_padre ";
            } else {
                query = "select distinct entidad_padre,(entidad_padre || ' ' || (select Distinct descripcion "
                        + " from  PMADMIN.PRSA_ENTIDADES "
                        + " where numero_prosa = tblext.ENTIDAD_PADRE) || ' ' || bu_tx_parent) descripcion "
                        + " from  PMADMIN.VW_BUS_EMI "
                        + " tblext where tie_numero=1 "
                        + " and  numero_prosa not in(95,96,97,94,98) "
                        + " and bu_tx_parent not in (461,641) "
                        + " and numero_fiid not like 'U%' "
                        + " order by entidad_padre";
            }

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoEmiSinEgloVM: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancoAdqInterRedSinFIltro(HttpSession session) throws WellException {

        HttpServletRequest request = null;
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");
            String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");

            query = " select entidad_padre, (entidad_padre || ' ' || descripcion || ' ' || bu_tx_parent)descripcion"
                    + " from PMADMIN.VW_BUS_ACQ "
                    + " where entidad_padre=numero_prosa "
                    + " and tie_numero = 2"
                    + " order by entidad_padre";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoAdqInterRedSinFIltro: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancoEmi(HttpSession session) throws WellException {
        HttpServletRequest request = null;
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");
            String tipo = session.getAttribute("tipo") == null ? "" : (String) session.getAttribute("tipo");

            if (role.equals("banco") || tipo.equals("adq")) {
                String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
                if (tipo.equals("adq")) {
                    query = "select distinct entidad_padre,(entidad_padre || ' ' || (select Distinct descripcion "
                            + " from PMADMIN.PRSA_ENTIDADES  "
                            + " where numero_prosa = tblext.ENTIDAD_PADRE) || ' ' || bu_tx_parent) descripcion "
                            + " from PMADMIN.VW_BUS_EMI "
                            + " tblext where tie_numero = 1 "
                            + " and numero_fiid not like 'U%' "
                            + " order by entidad_padre";
                } else {
                    query = " select distinct entidad_padre, (entidad_padre || ' ' ||(select  descripcion from pmadmin.prsa_entidades where numero_prosa in(tblext.entidad_padre))|| ' ' || bu_tx_parent) descripcion "
                            + " from  PMADMIN.VW_BUS_EMI  tblext "
                            + " where "
                            + " tie_numero=1 "
                            + " and entidad_padre in (" + numerosProsa + ") "
                            + " and numero_fiid not like 'U%' "
                            + " order by entidad_padre ";
                }
            } else {
                query = "select distinct entidad_padre,(entidad_padre || ' ' || (select Distinct descripcion "
                        + " from PMADMIN.PRSA_ENTIDADES "
                        + " where numero_prosa = tblext.ENTIDAD_PADRE) || ' ' || bu_tx_parent) descripcion "
                        + " from PMADMIN.VW_BUS_EMI "
                        + " tblext where tie_numero=1 "
                        + " and numero_fiid not like 'U%' "
                        + " order by entidad_padre";
            }
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoEmi: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getTipoTrxs(HttpSession session, String tiposTxn) throws WellException {
        HttpServletRequest request = null;
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");

            query = " select numero,(numero || ' ' || descripcion) descripcion  "
                    + " from PMADMIN.PRSA_TIPOS_TRANSACCION  "
                    + " WHERE numero in(" + tiposTxn + ") "
                    + " order by numero";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getTipoTrxs: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getTipMoneda(HttpSession session) {
        ArrayList cbValues = new ArrayList(2);
        String[] mon1 = new String[2];
        String[] mon2 = new String[2];
        mon1[0] = "0";
        mon1[1] = "0 Dolares";
        mon2[0] = "1";
        mon2[1] = "1 Nacional";
        cbValues.add(mon1);
        cbValues.add(mon2);
        return cbValues;
    }

    public ArrayList getBancoSac(HttpSession session) throws WellException {
        HttpServletRequest request = null;
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");
            String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");

            if (role.equals("banco")) {
                query = "SELECT DISTINCT NUMERO_PROSA, (NUMERO_PROSA || ' ' || DESCRIPCION) ENTIDADES "
                        + " FROM PMADMIN.PRSA_ENTIDADES PE "
                        + "        WHERE PE.TIE_NUMERO = 1 "
                        + "        AND PE.ENTIDAD_PADRE IN (" + numerosProsa + ") "
                        + "        ORDER BY 1 ";
            } else {
                query = "SELECT DISTINCT NUMERO_PROSA, (NUMERO_PROSA || ' ' || DESCRIPCION) ENTIDADES "
                        + " FROM PMADMIN.PRSA_ENTIDADES PE "
                        + "        WHERE PE.TIE_NUMERO = 1 "
                        + " UNION SELECT 0, 'CONSOLIDADO' FROM DUAL ORDER BY 1";
            }

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoSac: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    //----------------------------------------------------------------------------//
//--Marca del Cambio : AXIA-FJCC-P-60-2646-14 Inicia  Modificacion 12/04/2016-//
//----------------------------------------------------------------------------//
    public ArrayList getBancosAdqsHijosSinFiltros(HttpSession session) throws WellException {
        HttpServletRequest request = null;
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");

            if (role.equals("banco")) {
                String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");

                query = " select distinct numero_prosa, (numero_prosa || ' ' ||descripcion|| ' ' || bu_tx_parent) descripcion "
                        + " from PMADMIN.VW_BUS_ACQ  tblext "
                        + " where entidad_padre in (" + numerosProsa + ") "
                        + " AND NUMERO_PROSA NOT IN (SELECT DISTINCT VBA.ENTIDAD_PADRE FROM PMADMIN.VW_BUS_ACQ VBA WHERE VBA.TIE_NUMERO = 2 AND VBA.ENTIDAD_PADRE <> VBA.NUMERO_PROSA) "
                        + " order by numero_prosa ";
            } else {
                query = " select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion"
                        + " FROM PMADMIN.VW_BUS_ACQ "
                        + " WHERE NUMERO_PROSA NOT IN (SELECT DISTINCT VBA.ENTIDAD_PADRE FROM PMADMIN.VW_BUS_ACQ VBA WHERE VBA.TIE_NUMERO = 2 AND VBA.ENTIDAD_PADRE <> VBA.NUMERO_PROSA) "
                        + " UNION SELECT 0, 'CONSOLIDADO' FROM DUAL ";

                query += " order by numero_prosa ";
            }

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancosAdqsHijosSinFiltros: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;

    }
//----------------------------------------------------------------------------//
//--Marca del Cambio : AXIA-FJCC-P-60-2646-14 Termina Modificacion 12/04/2016-//
//----------------------------------------------------------------------------//

    public ArrayList getBancosEmisHijos2(HttpSession session) throws WellException {
        HttpServletRequest request = null;
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");

            query = " select distinct numero_prosa, (numero_prosa || ' ' ||descripcion|| ' ' || bu_tx_parent) descripcion "
                    + " from PMADMIN.VW_BUS_EMI  tblext "
                    + " where bu_tx_parent not in (461,641) "
                    + " order by numero_prosa ";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancosEmisHijos2: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getTipoLiq2_1(HttpSession session) throws WellException {
        HttpServletRequest request = null;
        ArrayList cbValues;

        try {
            query = " SELECT DISTINCT SNCI.NCI_NSI_CLR_ID N, "
                    + " SNCI.NCI_NSI_CLR_D  D "
                    + " FROM PMADMIN.SV_NSI_CLR_ID SNCI "
                    + " WHERE SNCI.NCI_NSI_CLR_ID NOT IN (1,2,55) "
                    + " ORDER BY 1";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getTipoLiq2_1: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancosAdqsHijosSinFiltros2(HttpSession session) throws WellException {
        HttpServletRequest request = null;
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");

            query = " select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion"
                    + " FROM PMADMIN.VW_BUS_ACQ "
                    + " WHERE NUMERO_PROSA NOT IN (SELECT DISTINCT VBA.ENTIDAD_PADRE FROM PMADMIN.VW_BUS_ACQ VBA WHERE VBA.TIE_NUMERO = 2 AND VBA.ENTIDAD_PADRE <> VBA.NUMERO_PROSA) ";

            query += " order by numero_prosa ";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancosAdqsHijosSinFiltros2: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancoAdqSinDolNal(HttpSession session) throws WellException {
        HttpServletRequest request = null;
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");
            String tipo = session.getAttribute("tipo") == null ? "" : (String) session.getAttribute("tipo");

            query = "select distinct tblExt.entidad_padre, (tblExt.entidad_padre || ' ' || pe.descripcion  || ' ' || bu_tx_parent) descripcion "
                    + " FROM pmadmin.VW_BUS_ACQ tblExt join pmadmin.prsa_entidades pe on pe.numero_prosa=tblExt.entidad_padre ";

            if (role.equals("banco") || tipo.equals("emi")) {
                if (tipo.equals("emi")) {
                    query += " where tblExt.entidad_padre = pe.numero_prosa and tblExt.tie_numero not in (8,9) and tblExt.tie_numero not between 10 and 20 ";
                } else {
                    String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
                    query += " where tblExt.entidad_padre  in (" + numerosProsa + ") and tblExt.tie_numero not in (8,9) and tblExt.tie_numero not between 10 and 20 ";
                }
            } else {
                query += " where tblExt.entidad_padre = tblExt.numero_prosa and tblExt.tie_numero not in (8,9) and tblExt.tie_numero not between 10 and 20 ";
            }
            query += "\n order by 1";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoAdqSinDolNal: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancoEmiTodos(HttpSession session) throws WellException {
        HttpServletRequest request = null;
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");
            String tipo = session.getAttribute("tipo") == null ? "" : (String) session.getAttribute("tipo");

            if (role.equals("banco") || tipo.equals("adq")) {
                String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
                if (tipo.equals("adq")) {
                    query = "select distinct numero_prosa,(numero_prosa || ' ' || (select Distinct descripcion "
                            + " from PMADMIN.PRSA_ENTIDADES "
                            + " where numero_prosa = tblext.numero_prosa) || ' ' || bu_tx_parent) descripcion "
                            + " from PMADMIN.VW_BUS_EMI "
                            + " tblext "
                            + " order by numero_prosa";
                } else {
                    query = " select distinct numero_prosa, (numero_prosa || ' ' ||(select  descripcion from pmadmin.prsa_entidades where numero_prosa in(tblext.numero_prosa))|| ' ' || bu_tx_parent) descripcion "
                            + " from PMADMIN.VW_BUS_EMI  tblext "
                            + " where "
                            + " entidad_padre in (" + numerosProsa + ") "
                            + " and bu_tx_parent not in (461,641) "
                            + " order by numero_prosa ";
                }
            } else {
                query = "select distinct numero_prosa,(numero_prosa || ' ' || (select Distinct descripcion "
                        + " from PMADMIN.PRSA_ENTIDADES "
                        + " where numero_prosa = tblext.numero_prosa) || ' ' || bu_tx_parent) descripcion "
                        + " from PMADMIN.VW_BUS_EMI "
                        + " tblext "
                        + " where bu_tx_parent not in (461,641) "
                        + " UNION SELECT 0, 'CONSOLIDADO' FROM DUAL "
                        + " order by numero_prosa";
            }

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoEmiTodos: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancoIntEntPadre(HttpSession session) throws WellException {
        HttpServletRequest request = null;
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");
            String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");

            if (role.equals("banco")) {
                query = " select entidad_padre, (entidad_padre || ' ' || (select  descripcion from pmadmin.prsa_entidades where numero_prosa =tblExt.entidad_padre) || ' ' || bu_tx_parent )descripcion "
                        + " from PMADMIN.VW_BUS_ACQ tblExt "
                        + " where tie_numero in (1,2) "
                        + " and entidad_padre in (" + numerosProsa + ")"
                        + " union select entidad_padre, (entidad_padre || ' ' || (select  descripcion from pmadmin.prsa_entidades where numero_prosa =tblExt.entidad_padre) || ' ' || bu_tx_parent)descripcion "
                        + " from PMADMIN.VW_BUS_EMI tblExt "
                        + " where tie_numero=1 "
                        + " and numero_fiid not like 'U%' "
                        + " and entidad_padre  in (" + numerosProsa + " )";
            } else {
                query = " select  va.entidad_padre, (va.entidad_padre || ' ' || ent_padre.descripcion || ' ' || bu_tx_parent)descripcion"
                        + " from PMADMIN.VW_BUS_ACQ   va,  PMADMIN.PRSA_ENTIDADES  ent_padre "
                        + " where va.tie_numero in (1,2) "
                        + " and va.entidad_padre=ent_padre.numero_prosa "
                        + " AND VA.ENTIDAD_PADRE NOT IN (94,95,96,97,98) "
                        + " union "
                        + " select distinct ve.entidad_padre, (ve.entidad_padre || ' ' || ent_padre.descripcion || ' ' || bu_tx_parent)descripcion "
                        + " from PMADMIN.VW_BUS_EMI  ve, PMADMIN.PRSA_ENTIDADES  ent_padre "
                        + " where ve.tie_numero=1 "
                        + " and ve.entidad_padre=ent_padre.numero_prosa"
                        + " and ve.numero_fiid not like 'U%' "
                        + " AND VE.ENTIDAD_PADRE NOT IN (94,95,96,97,98) "
                        + " and ve.bu_tx_parent not in (461,641) "
                        + " UNION SELECT 131 NUM, '131 CONCENTRADORA PESOS PROSA 461' DES FROM DUAL ";
            }

            if (numerosProsa != null) {
                if (numerosProsa.contains("72") && (role.equals("banco"))) {
                    if (numerosProsa.contains("721")) {
                    }
                } else {
//						query+= " union  select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent)descripcion " +
//						    	" from " + VW_BUS_ACQ+
//						    	" where  numero_prosa in(30) ";
                }
            }

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.comboBoxBancoIntEntPadre: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getTipoLiqCorresponsal(HttpSession session) {
        ArrayList cbValues = new ArrayList(5);
        String[] circuitoLocal = new String[2];
        String[] entrante = new String[2];
        String[] saliente = new String[2];
        String[] interred = new String[2];
        String[] visaMasterCard = new String[2];
        String[] corresponsal = new String[2];
        circuitoLocal[0] = "22";
        circuitoLocal[1] = "Liquidacion Circuito Local";
        entrante[0] = "32";
        entrante[1] = "Liquidacion Entrante";
        saliente[0] = "33";
        saliente[1] = "Liquidacion Saliente";
        interred[0] = "26";
        interred[1] = "Liquidacion Interredes";
        visaMasterCard[0] = "6";
        visaMasterCard[1] = "Liquidacion Visa y Mastercard";
        corresponsal[0] = "60";
        corresponsal[1] = "Liquidacion Corresponsal";
        cbValues.add(circuitoLocal);
        cbValues.add(entrante);
        cbValues.add(saliente);
        cbValues.add(interred);
        cbValues.add(visaMasterCard);
        cbValues.add(corresponsal);
        return cbValues;
    }

    public ArrayList getBancoEmiDolConsol(HttpSession session) throws WellException {
        HttpServletRequest request = null;
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");

            query = " select numero_prosa, descripcion from(	"
                    + "  select entidad_padre,numero_prosa, (numero_prosa||' '|| descripcion||' '||bu_tx_parent) descripcion "
                    + "  FROM PMADMIN.VW_BUS_EMI "
                    + "  WHERE NUMERO_FIID LIKE 'U%' "
                    + " ) ";

            if (role.equals("banco")) {
                String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
                query += " where entidad_padre  in (" + numerosProsa + ") ";
            }

            query += " order by numero_prosa";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

            String[] consol = new String[2];

        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoEmiDolConsol: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getTipoLiqSac(HttpSession session) {
        ArrayList cbValues = new ArrayList(5);
        String[] circuitoLocal = new String[2];
        String[] entrante = new String[2];
        String[] saliente = new String[2];
        String[] interred = new String[2];
        String[] visaMasterCard = new String[2];
        String[] corresponsal = new String[2];
        circuitoLocal[0] = "21";
        circuitoLocal[1] = "Liquidacion Circuito Local";
        entrante[0] = "22";
        entrante[1] = "Liquidacion Entrante";
        saliente[0] = "23";
        saliente[1] = "Liquidacion Saliente";
        interred[0] = "25";
        interred[1] = "Liquidacion Interredes";
        corresponsal[0] = "60";
        corresponsal[1] = "Liquidacion Corresponsales";
        //visaMasterCard[0]="21";
        visaMasterCard[0] = "26";
        visaMasterCard[1] = "Liquidacion Visa y Mastercard";
        cbValues.add(circuitoLocal);
        cbValues.add(entrante);
        cbValues.add(saliente);
        cbValues.add(interred);
        cbValues.add(visaMasterCard);
        cbValues.add(corresponsal);
        return cbValues;
    }

    public ArrayList getBancoEmiLiqDol(HttpSession session) throws WellException {
        HttpServletRequest request = null;
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");

            query = " SELECT VBE.NUMERO_PROSA, VBE.NUMERO_PROSA||' '||VBE.DESCRIPCION "
                    + " FROM PMADMIN.VW_BUS_EMI VBE "
                    + " WHERE VBE.NUMERO_LN = 'DLMN' ";

            if (role.equals("banco")) {
                String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
                query += " AND VBE.ENTIDAD_PADRE IN (" + numerosProsa + ") ";
            }

            query += " ORDER BY VBE.NUMERO_PROSA";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoEmiLiqDol: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getClvmoneda(HttpSession session) throws WellException {
        ArrayList cbValues = new ArrayList();
        try {
            query = " SELECT CRNCY_CD, CRNCY_D||' '||CRNCY_CD FROM CORE.CZ_CRNCY_CD WHERE CRNCY_ALPHA IN ('USD','MXN') ORDER BY 2 ";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getClvmoneda: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getGrupoRechazo(HttpSession session) throws WellException {

        ArrayList cbValues = new ArrayList();
        cbValues.add(new String[]{"221", "Computador"});
        cbValues.add(new String[]{"120", "Sintaxis"});
        return cbValues;
    }

    public ArrayList getBancoDol2(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");
            query = " SELECT PE.NUMERO_PROSA, PE.NUMERO_PROSA||' '||PE.DESCRIPCION "
                    + " FROM PMADMIN.PRSA_ENTIDADES PE "
                    + " WHERE PE.NUMERO_PROSA > 1000 "
                    + " AND PE.TIE_NUMERO = 1 "
                    + " AND PE.NUMERO_PROSA <> 1031 ";
            if (role.equals("banco")) {
                String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
                query += " AND PE.ENTIDAD_PADRE IN (" + numerosProsa + ") ";
            }
            query += " ORDER BY PE.NUMERO_PROSA";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoEmiLiqDol: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancoDol(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");

            query = " SELECT PE.NUMERO_PROSA, PE.NUMERO_PROSA||' '||PE.DESCRIPCION "
                    + " FROM PMADMIN.PRSA_ENTIDADES PE "
                    + " WHERE (PE.NUMERO_PROSA > 1000 OR PE.NUMERO_PROSA = 169) "
                    + " AND PE.TIE_NUMERO = 1 ";

            if (role.equals("banco")) {
                String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
                query += " AND PE.ENTIDAD_PADRE IN (" + numerosProsa + ") ";
            }
            query += " ORDER BY PE.NUMERO_PROSA";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoEmiLiqDol: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getTipoTrxsMisc(HttpSession session) throws WellException {
        ArrayList cbValues = new ArrayList(2);
        String[] misc1 = new String[2];
        String[] misc2 = new String[2];
        misc1[0] = "10";
        misc1[1] = "10 MISCELANEOS (EN CONTRA)";
        misc2[0] = "20";
        misc2[1] = "20 MISCELANEOS (A FAVOR)";
        cbValues.add(misc1);
        cbValues.add(misc2);
        return cbValues;

    }

    public ArrayList getTipoLiq(HttpSession session) {
        //--Modificacion: LIQ 15 Marca de inicio SAS-JPM P-06-0527-12 11/08/2014
        ArrayList cbValues = new ArrayList(7);
        String[] interredEspecial = new String[2];
        //--Modificacion: LIQ 15 Marca de fin SAS-JPM P-06-0527-12 11/08/2014 
        String[] circuitoLocal = new String[2];
        String[] entrante = new String[2];
        String[] saliente = new String[2];
        String[] interred = new String[2];
        String[] visaMasterCard = new String[2];
        String[] corresponsal = new String[2];
        //--Modificacion: LIQ 15 Marca de inicio SAS-JPM P-06-0527-12 11/08/2014 
        interredEspecial[0] = "15";
        interredEspecial[1] = "Liquidacion Interredes Esp.";
        //--Modificacion: LIQ 15 Marca de fin SAS-JPM P-06-0527-12 11/08/2014 
        circuitoLocal[0] = "22";
        circuitoLocal[1] = "Liquidacion Circuito Local";
        entrante[0] = "32";
        entrante[1] = "Liquidacion Entrante";
        saliente[0] = "33";
        saliente[1] = "Liquidacion Saliente";
        interred[0] = "26";
        interred[1] = "Liquidacion Interredes";
        //visaMasterCard[0]="21";
        visaMasterCard[0] = "6";
        visaMasterCard[1] = "Liquidacion Visa y Mastercard";
        corresponsal[0] = "60";
        corresponsal[1] = "Liquidacion Corresponsales";
        //--Modificacion: LIQ 15 Marca de inicio SAS-JPM P-06-0527-12 11/08/2014 
        cbValues.add(interredEspecial);
        //--Modificacion: LIQ 15 Marca de fin SAS-JPM P-06-0527-12 11/08/2014 
        cbValues.add(circuitoLocal);
        cbValues.add(entrante);
        cbValues.add(saliente);
        cbValues.add(corresponsal);
        cbValues.add(interred);
        cbValues.add(visaMasterCard);
        return cbValues;
    }

    public ArrayList getBancoAdqDet(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");
            String tipo = session.getAttribute("tipo") == null ? "" : (String) session.getAttribute("tipo");
            query = "select distinct tblExt.numero_prosa, (tblExt.numero_prosa || ' ' || pe.descripcion  || ' ' || bu_tx_parent) descripcion "
                    + " FROM pmadmin.VW_BUS_ACQ tblExt join pmadmin.prsa_entidades pe on pe.numero_prosa=tblExt.numero_prosa ";

            if (role.equals("banco") || tipo.equals("emi")) {
                if (tipo.equals("emi")) {
                    query += " where tblExt.numero_prosa = pe.numero_prosa  "
                            + " AND PE.NUMERO_PROSA NOT IN (SELECT DISTINCT VBA.ENTIDAD_PADRE FROM PMADMIN.VW_BUS_ACQ VBA WHERE VBA.TIE_NUMERO = 2 AND VBA.ENTIDAD_PADRE <> VBA.NUMERO_PROSA) ";
                } else {
                    String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
                    query += " where tblExt.entidad_padre  in (" + numerosProsa + ") "
                            + " AND PE.NUMERO_PROSA NOT IN (SELECT DISTINCT VBA.ENTIDAD_PADRE FROM PMADMIN.VW_BUS_ACQ VBA WHERE VBA.TIE_NUMERO = 2 AND VBA.ENTIDAD_PADRE <> VBA.NUMERO_PROSA) ";

                }
            } else {
                query += " where tblExt.numero_prosa = tblExt.numero_prosa"
                        + " AND PE.NUMERO_PROSA NOT IN (SELECT DISTINCT VBA.ENTIDAD_PADRE FROM PMADMIN.VW_BUS_ACQ VBA WHERE VBA.TIE_NUMERO = 2 AND VBA.ENTIDAD_PADRE <> VBA.NUMERO_PROSA) ";
            }
            query += "\n order by 1";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoAdqDet: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getTipoTrxsVenDev(HttpSession session) throws WellException {
        HttpServletRequest request = null;
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");

            query = " select numero,(numero || ' ' || descripcion) descripcion  "
                    // Inicia cambio wellcom 07-08-2014 P-54-2452-14 
                    //+ " from " + PRSA_TIPOS_TRANSACCION
                    + " from PMADMIN.PRSA_TIPOS_TRANSACCION "
                    // Fin cambio wellcom 07-08-2014 P-54-2452-14 
                    + " WHERE numero in(1,21) "
                    + " order by numero";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getTipoTrxs: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancosSinDol(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");
            String tipo = session.getAttribute("tipo") == null ? "" : (String) session.getAttribute("tipo");
            query = "select distinct tblExt.entidad_padre, (tblExt.entidad_padre || ' ' || pe.descripcion  || ' ' || bu_tx_parent) descripcion "
                    + " FROM (SELECT * FROM pmadmin.VW_BUS_ACQ UNION SELECT * FROM PMADMIN.VW_BUS_EMI) tblExt join pmadmin.prsa_entidades pe on pe.numero_prosa=tblExt.entidad_padre ";

            if (role.equals("banco") || tipo.equals("emi")) {
                if (tipo.equals("emi")) {
                    query += " where tblExt.entidad_padre = pe.numero_prosa and tblExt.tie_numero<>9 ";
                } else {
                    String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
                    query += " where tblExt.entidad_padre  in (" + numerosProsa + ") and tblExt.tie_numero<>9 ";

                }
            } else {
                query += " where tblExt.entidad_padre = tblExt.numero_prosa and tblExt.tie_numero<>9 ";
            }
            query += " and tblExt.bu_tx_parent not in (461,641) "
                    + "\n order by 1";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancosSinDol: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getDetallesn(HttpSession session) {
        ArrayList cbValues = new ArrayList(2);
        String[] si = new String[2];
        String[] no = new String[2];
        si[0] = "S";
        si[1] = "Si";
        no[0] = "N";
        no[1] = "No";
        cbValues.add(si);
        cbValues.add(no);
        return cbValues;
    }

    public ArrayList getTipoTrxs2(HttpSession session) throws WellException {
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");

            query = " select numero,(numero || ' ' || descripcion) descripcion  "
                    + " from PMADMIN.PRSA_TIPOS_TRANSACCION"
                    + " WHERE numero in (1,2,20,21) "
                    + " order by numero";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getTipoTrxs2: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getEntidadFuente(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");
            String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");

            if (role.equals("banco")) {
                query = " select distinct ent_numero_prosa , (ent_numero_prosa || ' ' || PE.descripcion)descripcion "
                        + " from  PMADMIN.PRSA_ARCHIVOS PA "
                        + " INNER JOIN PMADMIN.PRSA_ENTIDADES PE "
                        + " ON PA.ENT_NUMERO_PROSA = PE.NUMERO_PROSA "
                        + " WHERE PA.SALIDA = 1 "
                        + " AND PA.ent_numero_prosa in (" + numerosProsa + ") "
                        + " order by 1 ";
            } else {
                query = " select distinct ent_numero_prosa , (ent_numero_prosa || ' ' || PE.descripcion)descripcion "
                        + " from  PMADMIN.PRSA_ARCHIVOS PA "
                        + " INNER JOIN PMADMIN.PRSA_ENTIDADES PE "
                        + " ON PA.ENT_NUMERO_PROSA = PE.NUMERO_PROSA "
                        + " WHERE PA.SALIDA = 1 "
                        + " order by 1 ";
            }
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.prosa.sacii.getEntidadFuente: "
                    + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancoBSADMI(HttpSession session) throws WellException {
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");

            query = "	select numero_prosa, descripcion from (  "
                    + "	select entidad_padre,numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion "
                    + "    FROM PMADMIN.VW_BUS_ACQ ";
            if (role.equals("banco")) {
                query += "  WHERE tie_numero  in (1, 9, 13, 17) ";
            } else {
                query += "  WHERE tie_numero  in (1, 2, 9, 13, 17) ";
            }
            query += "  and NUMERO_LN NOT IN ('EGLO','VISA','MDS') "
                    + "  union "
                    + "  select entidad_padre,numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion"
                    + "  FROM PMADMIN.VW_BUS_EMI "
                    + "  WHERE NUMERO_LN NOT IN ('EGLO','VISA','MDS') ";
            if (role.equals("banco")) {
                query += "  and tie_numero = 1";
            } else {
                query += "  and tie_numero IN (1,2)";
            }
            query += "  union "
                    + "  select entidad_padre,numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion "
                    + "  FROM pmadmin.VW_BUS_ACQ "
                    + "  where numero_prosa in (2101) "
                    + "  ) ";

//Marca de cambio:  F-52-2173-15  Fin de Modificacion  SAS-LERC F-52-2173-15    #
            if (role.equals("banco")) {
                String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
                query += " where entidad_padre  in (" + numerosProsa + ") ";
            }

            query += " order by numero_prosa";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoBSADMI: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancoAdqDol(HttpSession session) throws WellException {
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");

            String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");

            if (role.equals("banco")) {
                query = "select distinct numero_prosa,(numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion "
                        + " from pmadmin.VW_BUS_ACQ "
                        + " where tie_numero in (9) and entidad_padre in (" + numerosProsa + " ) "
                        + " order by 1";
            } else {
                query = " select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent)descripcion "
                        + " from  pmadmin.VW_BUS_ACQ"
                        + " where tie_numero in (9) "
                        + " order by 1";
            }

            if (numerosProsa != null) {
                if (numerosProsa.contains("81") || !(role.equals("banco"))) {
                    query += " union  select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent)descripcion "
                            + " from  pmadmin.VW_BUS_EMI "
                            + " where  numero_prosa in(81) ";
                }
            }
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.comboBoxBancoAdqDol2: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getLiq(HttpSession session) {
        ArrayList cbValues = new ArrayList(2);
        String[] a = new String[2];
        String[] b = new String[2];
        a[0] = "VISA";
        a[1] = "94 VISA";
        b[0] = "BNET','MDS";
        b[1] = "98 MASTERCARD";
        cbValues.add(a);
        cbValues.add(b);
        return cbValues;
    }

    public ArrayList getGrupoTrxs(HttpSession session) throws WellException {
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");

            query = " select TCG_GRP_ID, (TCG_GRP_ID || ' ' || TCG_GRP_NAM) descripcion  "
                    + " from settlement.SZ_TC_GRP"
                    + " where TCG_GRP_ID in(101,103,104,105,106,107,108,109,137,140)";
            query += " ORDER BY tcg_grp_id ";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getGrupoTrxs: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getArchivoFuente(HttpSession session) throws WellException {
        ArrayList cbValues;

        try {

            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");

            query = " select distinct numero, (numero || ' ' || descripcion)descripcion "
                    + " from  PMADMIN.PRSA_ARCHIVOS "
                    + " order by numero ";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.prosa.sacii.getArchivoFuente: "
                    + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getMeses(HttpSession session) throws WellException {
        ArrayList cbValues = new ArrayList(5);
        String[] enero = new String[2];
        String[] febrero = new String[2];
        String[] marzo = new String[2];
        String[] abril = new String[2];
        String[] mayo = new String[2];
        String[] junio = new String[2];
        String[] julio = new String[2];
        String[] agosto = new String[2];
        String[] septiembre = new String[2];
        String[] octubre = new String[2];
        String[] noviembre = new String[2];
        String[] diciembre = new String[2];
        enero[0] = "01";
        enero[1] = "Enero";
        febrero[0] = "02";
        febrero[1] = "Febrero";
        marzo[0] = "03";
        marzo[1] = "Marzo";
        abril[0] = "04";
        abril[1] = "Abril";
        mayo[0] = "05";
        mayo[1] = "Mayo";
        junio[0] = "06";
        junio[1] = "Junio";
        julio[0] = "07";
        julio[1] = "Julio";
        agosto[0] = "08";
        agosto[1] = "Agosto";
        septiembre[0] = "09";
        septiembre[1] = "Septiembre";
        octubre[0] = "10";
        octubre[1] = "Octubre";
        noviembre[0] = "11";
        noviembre[1] = "Noviembre";
        diciembre[0] = "12";
        diciembre[1] = "Diciembre";
        cbValues.add(enero);
        cbValues.add(febrero);
        cbValues.add(marzo);
        cbValues.add(abril);
        cbValues.add(mayo);
        cbValues.add(junio);
        cbValues.add(julio);
        cbValues.add(agosto);
        cbValues.add(septiembre);
        cbValues.add(octubre);
        cbValues.add(noviembre);
        cbValues.add(diciembre);
        return cbValues;
    }

    public ArrayList getYears(HttpSession session) throws WellException {
        ArrayList cbValues = new ArrayList(5);
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        Integer actual = Integer.parseInt(format.format(new Date()));
        Integer anterior = actual - 1;
        Integer siguiente = actual + 1;
        cbValues.add(new String[]{(anterior).toString(), anterior.toString()});
        cbValues.add(new String[]{(actual).toString(), actual.toString()});
        //cbValues.add(new String[]{(siguiente).toString(),siguiente.toString()});
        return cbValues;
    }

    public ArrayList getTTCharbacks(HttpSession session) throws WellException {

        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");

            query = "SELECT NUMERO, "
                    + "       CASE "
                    + "          WHEN NUMERO = 15 THEN 'CONTRACARGO (VENTAS)' "
                    + "          WHEN NUMERO = 16 THEN 'CONTRACARGO (DEVOLUCION)' "
                    + "          WHEN NUMERO = 17 THEN 'CONTRACARGO (DISPOSICION)' "
                    + "          WHEN NUMERO = 18 THEN 'SEGUNDO CONTRACARGO (VENTAS)' "
                    + "          WHEN NUMERO = 19 THEN 'SEGUNDO CONTRACARGO (DEVOLUCION)' "
                    + "          ELSE DESCRIPCION "
                    + "       END DESCRIPCION "
                    + "FROM PMADMIN.PRSA_TIPOS_TRANSACCION "
                    + "WHERE DESCRIPCION LIKE '%CONTRACARGO%' "
                    + "AND NUMERO NOT IN (12,24) "
                    + "ORDER BY NUMERO ";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getTTCharbacks: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getTTCharbacks2(HttpSession session) throws WellException {

        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");

            query = "SELECT NUMERO, DECODE(DESCRIPCION,'PAGOS','MISCELANEOS(CREDITO)',DESCRIPCION) FROM SUPERSIC.TIPOS_TRANSACCION@LG_PMTU_SIC WHERE NUMERO IN (10,20)";
            //query = " select TCG_GRP_ID, (TCG_GRP_ID || ' ' || TCG_GRP_NAM) descripcion  " 
            //      + " from " + SZ_TC_GRP
            //	  + " where TCG_GRP_ID in(118,119,113)";
            //query += " ORDER BY tcg_grp_id ";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getTTCharbacks2: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getIca2(HttpSession session) throws WellException {
        ArrayList cbValues;

        try {

            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");

            String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");

            query = " SELECT MM.MCM_MBR_ID ICA_RECEPTOR, MM.MCM_MBR_ID||' '||VB.DESCRIPCION ICAS "
                    + " FROM IPM.MC_MBR MM "
                    + " INNER JOIN ( "
                    + " SELECT BU_TX_ADQ, DESCRIPCION, NUMERO_PROSA FROM PMADMIN.VW_BUS_ACQ WHERE TIE_NUMERO = 9 "
                    + " UNION "
                    + " SELECT BU_TX_ISS, DESCRIPCION, NUMERO_PROSA FROM PMADMIN.VW_BUS_EMI WHERE TIE_NUMERO = 9) VB "
                    + " ON VB.BU_TX_ADQ = MM.MCM_BU ";

            if (role.equals("banco")) {
                query += " WHERE VB.NUMERO_PROSA IN (" + numerosProsa + ") ";
            }

            query += " ORDER BY 1";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.comboBoxIca2: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getIcasSac(HttpSession session) throws WellException {
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");

            String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");

            if (role.equals("banco")) {
//----------------------------------------------------------------------------//
//--Marca del Cambio : AXIA-FJCC-P-02-0256-12 Inicia  Modificacion 09/09/2016-//
//----------------------------------------------------------------------------//
                query = " select DISTINCT ICA_RECEPTOR,(ICA_RECEPTOR || ' ' || EN.NOMBRE) ICAS "
                        + " FROM SUPERSIC.ENTIDADES@LG_PMTU_SIC EN, "
                        + " SUPERSIC.visa_miscelaneos@LG_PMTU_SIC VM "
                        + //" where tie_numero=2 AND"+
                        " WHERE VM.ICA_RECEPTOR not in (3985,4406,11551,11882) "
                        + " AND (VM.ICA_RECEPTOR = EN.NUMERO_MASTERCARD  "
                        + " OR  VM.ICA_RECEPTOR = EN.BIN_SPONSOR_MASTERCARD) "
                        + " AND EN.ENT_NUMERO_PROSA IN (" + numerosProsa + ") "
                        + " ORDER BY 1 ";
            } else {
                query = " select DISTINCT ICA_RECEPTOR,(ICA_RECEPTOR || ' ' || EN.NOMBRE) ICAS  "
                        + " FROM SUPERSIC.ENTIDADES@LG_PMTU_SIC EN, "
                        + //" where tie_numero=2 AND"+
                        " SUPERSIC.VISA_MISCELANEOS@LG_PMTU_SIC VM "
                        + " WHERE VM.ICA_RECEPTOR not in (3985,4406,11551,11882) "
                        + " AND (VM.ICA_RECEPTOR = EN.NUMERO_MASTERCARD  "
                        + " OR  VM.ICA_RECEPTOR = EN.BIN_SPONSOR_MASTERCARD) "
                        + " ORDER BY 1,2  ";
////----------------------------------------------------------------------------//
////-Marca del Cambio : AXIA-FJCC-P-02-0256-12 Termina  Modificacion 09/09/2016-//
////----------------------------------------------------------------------------//
            }

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.comboBoxIcasSac: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getIcasSac2(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");

            String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");

            query = " SELECT MM.MCM_MBR_ID ICA_RECEPTOR, MM.MCM_MBR_ID||' '||VB.DESCRIPCION ICAS "
                    + " FROM IPM.MC_MBR MM "
                    + " INNER JOIN ( "
                    + " SELECT BU_TX_ADQ, DESCRIPCION, NUMERO_PROSA FROM PMADMIN.VW_BUS_ACQ WHERE TIE_NUMERO LIKE '1%' "
                    + " UNION "
                    + " SELECT BU_TX_ISS, DESCRIPCION, NUMERO_PROSA FROM PMADMIN.VW_BUS_EMI WHERE TIE_NUMERO LIKE '1%') VB "
                    + " ON VB.BU_TX_ADQ = MM.MCM_BU ";

            if (role.equals("banco")) {
                query += " WHERE VB.NUMERO_PROSA IN (" + numerosProsa + ") ";
            }

            query += " ORDER BY 1";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.comboBoxIcasSac2: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancoInt(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");

            String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");

            if (role.equals("banco")) {
                query = "select distinct numero_prosa,(numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion "
                        + " from PMADMIN.VW_BUS_ACQ "
                        + " where tie_numero in (2,1) and entidad_padre in (" + numerosProsa + " ) "
                        + " union "
                        + "select distinct numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion "
                        + " from PMADMIN.VW_BUS_EMI"
                        + " where tie_numero=1 and entidad_padre in (" + numerosProsa + " )";
                /*" select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion " +
							" from " + VW_BUS_ACQ +
							" where tie_numero=2 " +
							" and numero_prosa in (" + numerosProsa + 
							" ) union select numero_prosa,(numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion " +
							" from " +  VW_BUS_EMI +
							" where tie_numero=1 " +
							" and numero_prosa in (" + numerosProsa +" )";*/
            } else {
                query = " select  numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent)descripcion "
                        + " from PMADMIN.VW_BUS_ACQ "
                        + " union select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent)descripcion "
                        + " from PMADMIN.VW_BUS_EMI "
                        + " where tie_numero=1 "
                        + " union "
                        + " select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent)descripcion"
                        + " from PMADMIN.VW_BUS_EMI "
                        + " where numero_prosa in(select distinct hijas.numero_prosa "
                        + " from PMADMIN.PRSA_ENTIDADES hijas, "
                        + " PMADMIN.PRSA_ENTIDADES padre "
                        + " where hijas.entidad_padre != hijas.numero_prosa "
                        + " and hijas.numero_fiid !=padre.numero_fiid "
                        + " and hijas.entidad_padre= padre.numero_prosa "
                        + " and hijas.tie_numero=1)";
            }

            if (numerosProsa != null) {
                if (numerosProsa.contains("81") || !(role.equals("banco"))) {
                    query += " union  select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent)descripcion "
                            + " from PMADMIN. VW_BUS_EMI "
                            + " where  numero_prosa in(81) ";
                }
            }
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.comboBoxBancoInt: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getIcasSac2_mir148(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");

            String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");

            query = " SELECT DISTINCT NUMERO_MASTERCARD, NUMERO_MASTERCARD || ' ' || E.DESCRIPCION FROM ( "
                    + " SELECT NUMERO_PROSA, NUMERO_MASTERCARD, NOMBRE "
                    + " FROM SUPERSIC.entidades@LG_PMTU_SIC "
                    + " UNION "
                    + " SELECT NUMERO_PROSA, BIN_SEGURIZADO_MASTERCARD, NOMBRE "
                    + " FROM SUPERSIC.entidades@LG_PMTU_SIC "
                    + " ) ICA INNER JOIN PMADMIN.PRSA_ENTIDADES E "
                    + "     ON E.NUMERO_PROSA = ICA.NUMERO_PROSA "
                    + "     AND E.TIE_NUMERO = 1 "
                    + " WHERE ICA.NUMERO_MASTERCARD NOT IN (3985,4406,11551,11882) ";

            if (!role.equals("banco")) {
                query += " UNION SELECT 0, 'CONSOLIDADO' FROM DUAL ";
            }
            if (role.equals("banco")) {
                query += " AND E.NUMERO_PROSA IN (" + numerosProsa + ") ";
            }
            query += " ORDER BY 1";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.comboBoxIcasSac: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancoAdqConsol(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");
            query
                    = " SELECT * FROM ("
                    + " SELECT DISTINCT "
                    + " PE.NUMERO_PROSA ENTIDAD_PADRE,  "
                    + " PE.ENTIDAD_PADRE||' '||PE.DESCRIPCION||' '||DECODE(VBA.BU_TX_PARENT,641,522,VBA.BU_TX_PARENT) DESCRIPCION "
                    + " FROM PMADMIN.VW_BUS_ACQ VBA   "
                    + " JOIN PMADMIN.PRSA_ENTIDADES PE   "
                    + " ON VBA.ENTIDAD_PADRE=PE.NUMERO_PROSA "
                    + " WHERE PE.TIE_NUMERO=1 ) PE ";
            if (role.equals("banco")) {
                String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
                query += " WHERE PE.ENTIDAD_PADRE IN (" + numerosProsa + ") ";
            }
            query += " ORDER BY 1";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
            String[] consol = new String[2];
            if (!role.equals("banco")) {
                consol[0] = "0";
                consol[1] = "Consolidado";
                cbValues.add(consol);
            }
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoAdqDolConsol: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancoAdqMultimoneda(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");
            String tipo = session.getAttribute("tipo") == null ? "" : (String) session.getAttribute("tipo");

            query = "select distinct tblExt.entidad_padre, (tblExt.entidad_padre || ' ' || pe.descripcion  || ' ' || bu_tx_parent) descripcion "
                    + " FROM pmadmin.VW_BUS_ACQ tblExt join pmadmin.prsa_entidades pe on pe.numero_prosa=tblExt.entidad_padre ";

            if (role.equals("banco") || tipo.equals("emi")) {

                String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
                query += " where tblExt.entidad_padre  in (" + numerosProsa + ") and tblExt.TIE_NUMERO not in (1,2,5,9)   ";

            } else {
                query += " where tblExt.entidad_padre = tblExt.numero_prosa and tblExt.TIE_NUMERO not in (1,2,5,9) ";
            }
            query += "\n order by 1";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoAdq: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getMovimiento(HttpSession session) {
        ArrayList cbValues = new ArrayList(2);
//		String[] local=new String[2] ;
        String[] internacional = new String[2];
//		local[0]="I";	
//		local[1]="Local";
        internacional[0] = "V";
        internacional[1] = "Internacional";
//		cbValues.add(local);
        cbValues.add(internacional);
        return cbValues;
    }

    public ArrayList getDrawDown2(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");
            query = "SELECT NUMERO_PROSA, NUMERO_PROSA||' '||NOMBRE FROM SUPERSIC.ENTIDADES@LG_PMTU_SIC WHERE IND_LIQ_VISA IN (1,2,3,4) AND NUMERO_PROSA = ENT_NUMERO_PROSA AND NUMERO_PROSA <> 38 ORDER BY NUMERO_PROSA ";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getDrawDown2: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getDrawDown(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");
            String tipo = session.getAttribute("tipo") == null ? "" : (String) session.getAttribute("tipo");
            String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");

            if (role.equals("banco")) {
                query = "SELECT NUMERO_PROSA, NUMERO_PROSA||' '||NOMBRE FROM SUPERSIC.ENTIDADES@LG_PMTU_SIC WHERE IND_LIQ_VISA IN (1,2,3,4) AND NUMERO_PROSA = ENT_NUMERO_PROSA AND NUMERO_PROSA IN (" + numerosProsa + ") ORDER BY NUMERO_PROSA";
            } else {
                query = "SELECT NUMERO_PROSA, NUMERO_PROSA||' '||NOMBRE FROM SUPERSIC.ENTIDADES@LG_PMTU_SIC WHERE IND_LIQ_VISA IN (1,2,3,4) AND NUMERO_PROSA = ENT_NUMERO_PROSA ORDER BY NUMERO_PROSA ";

            }
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getDrawDown: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getTipo(HttpSession session) {
        ArrayList cbValues = new ArrayList(2);
        String[] a = new String[2];
        String[] b = new String[2];
        String[] c = new String[2];
        a[0] = "ICBS";
        a[1] = "REPORTES DE ICBS";
        b[0] = "SAC1";
        b[1] = "REPORTES DE EP1,EP2,VISA";
        c[0] = "VSA1";
        c[1] = "REPORTES DEGRADADAS (TC40)";
        cbValues.add(a);
        cbValues.add(b);
        cbValues.add(c);
        return cbValues;
    }

    public ArrayList getTipoLiq0010(HttpSession session) throws WellException {
        ArrayList cbValues = new ArrayList();
        try {
            query = " select numero,descripcion from pmadmin.prsa_tipos_liquidacion where numero in(1,5) order by numero ";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getTipoLiquidacion0010: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getMarcasRLN(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            query = "SELECT MARCA, DESCRIPCION "
                    + "FROM PMADMIN.PRSA_MARCA WHERE MARCA IN (1,2,3,99,999) "
                    + "ORDER BY MARCA ASC";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
            String[] consol = new String[2];
            consol[0] = "1,2,3,99,999";
            consol[1] = "TODAS LAS MARCAS";
            cbValues.add(consol);
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getMarcasRLN: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getEntidadesRLN(HttpSession session, String tipo) throws WellException {
        ArrayList cbValues;
        try {
            if (tipo.equals("INTERRED")) {
                query = "SELECT NUMERO_PROSA, (NUMERO_PROSA || ' ' || DESCRIPCION) ENTIDADES "
                        + "FROM PMADMIN.PRSA_ENTIDADES "
                        + "WHERE TIE_NUMERO = 2 "
                        + " AND NUMERO_FIID NOT LIKE 'U%' "
                        + " AND DESCRIPCION NOT LIKE '%DOLARES%'";
            } else if (tipo.equals("POS")) {
                query = "SELECT NUMERO_PROSA, (NUMERO_PROSA || ' ' || DESCRIPCION) ENTIDADES "
                        + "FROM PMADMIN.PRSA_ENTIDADES "
                        + "WHERE TIE_NUMERO != 2 "
                        + " AND NUMERO_FIID NOT LIKE 'U%' "
                        + " AND DESCRIPCION NOT LIKE '%DOLARES%' "
                        + "AND BANCO_SOCIO = 'S' "
                        + "ORDER BY 1";
            } else if (tipo.equals("TODOS")) {
                query = "SELECT NUMERO_PROSA, (NUMERO_PROSA || ' ' || DESCRIPCION) ENTIDADES "
                        + "FROM PMADMIN.PRSA_ENTIDADES "
                        + " AND NUMERO_FIID NOT LIKE 'U%' "
                        + " AND DESCRIPCION NOT LIKE '%DOLARES%'";
            }
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

            String[] consol = new String[2];
            consol[0] = "-1";
            consol[1] = "TODOS LOS BANCOS";
            cbValues.add(consol);
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getEntidadesRLN: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getEdoCompl(HttpSession session) {
        ArrayList cbValues = new ArrayList(2);
        String[] aplica = new String[2];
        String[] consulta = new String[2];
        aplica[0] = "A";
        aplica[1] = "Aplica";
        consulta[0] = "C";
        consulta[1] = "Consulta";
        cbValues.add(aplica);
        cbValues.add(consulta);
        return cbValues;
    }

    public String getMarcasCaratula(HttpSession session, String idMarcas) throws WellException {
        ArrayList cbValues;
        String value = "";
        try {
            query = "SELECT MARCA, DESCRIPCION "
                    + "FROM PMADMIN.PRSA_MARCA WHERE MARCA IN (" + idMarcas + ") "
                    + "ORDER BY MARCA ASC";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
            for (Object obj : cbValues) {
                String arrVal[] = (String[]) obj;
                value += arrVal[1].trim() + ", ";
            }
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getMarcasCaratula: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }

        return value.substring(0, value.length() - 2);
    }

    public String getLiquidacionCaratula(HttpSession session, String idLiquidacion) throws WellException {
        ArrayList cbValues;
        String value = "";
        try {
            query = "select NUMERO, DESCRIPCION "
                    + "FROM PMADMIN.PRSA_TIPOS_LIQUIDACION WHERE NUMERO IN (" + idLiquidacion + ") "
                    + "ORDER BY NUMERO ASC";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
            for (Object obj : cbValues) {
                String arrVal[] = (String[]) obj;
                value += arrVal[1].trim() + ", ";
            }
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getLiquidacionCaratula: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return value.substring(0, value.length() - 2);
    }

    public ArrayList getLiqEGLCL(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            query = "SELECT NUMERO, DESCRIPCION "
                    + "FROM PMADMIN.PRSA_TIPOS_LIQUIDACION WHERE NUMERO IN(1,2,3) "
                    + "ORDER BY NUMERO ASC";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
            String[] consol = new String[2];
            consol[0] = "1,2,3";
            consol[1] = "TODAS LAS LIQUIDACIONES";
            cbValues.add(consol);
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getMarcasRLN: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBanList001(HttpSession session, String tipo) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");
            String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
            if (role.equals("banco")) {
                query = " select distinct NUMERO_PROSA, (NUMERO_PROSA || ' ' || NOMBRE) "
                        + " from CCA.tbl_cca_entidades@LG_PMTU_PMTWEB_IFO_CCA "
                        + " WHERE NUMERO_PROSA IN (" + numerosProsa + ") ";
                if (tipo.equals("ADQ")) {
                    query += "AND IND_LEALTAD_ADQ=1 ORDER BY 1";
                } else if (tipo.equals("EMI")) {
                    query += "AND IND_LEALTAD_EMI=1 ORDER BY 1";
                }
            } else {
                query = " select distinct NUMERO_PROSA, (NUMERO_PROSA || ' ' || NOMBRE)  "
                        + " from CCA.tbl_cca_entidades@LG_PMTU_PMTWEB_IFO_CCA ";
                if (tipo.equals("ADQ")) {
                    query += " WHERE IND_LEALTAD_ADQ=1  ORDER BY 1";
                } else if (tipo.equals("EMI")) {
                    query += " WHERE IND_LEALTAD_EMI=1  ORDER BY 1";
                }
            }
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoAdqEmiConsol: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancoEmiHub(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");
            String tipo = session.getAttribute("tipo") == null ? "" : (String) session.getAttribute("tipo");

            if (role.equals("banco") || tipo.equals("adq")) {
                String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
                if (tipo.equals("adq")) {
                    query = "select distinct entidad_padre, "
                            + "(entidad_padre || ' ' || (select Distinct nombre from   HUB.TBL_HUB_ENTIDADES@LG_PMTU_PMTWEB_PWS_HUB where numero_prosa = tblext.ENTIDAD_PADRE)) descripcion "
                            + "from HUB.TBL_HUB_ENTIDADES@LG_PMTU_PMTWEB_PWS_HUB tblext "
                            + "where tie_numero = 1 "
                            + "and IND_HUB_EMI = 0 "
                            + "and numero_fiid not like 'U%' "
                            + "order by entidad_padre";

                } else {
                    query = "select distinct entidad_padre, (entidad_padre || ' ' ||(select  nombre from HUB.TBL_HUB_ENTIDADES@LG_PMTU_PMTWEB_PWS_HUB where numero_prosa in(tblext.entidad_padre))) descripcion "
                            + "from  HUB.TBL_HUB_ENTIDADES@LG_PMTU_PMTWEB_PWS_HUB  tblext "
                            + "where "
                            + "tie_numero=1 "
                            + "and IND_HUB_EMI = 1 "
                            + "and entidad_padre in (" + numerosProsa + ") "
                            + "and numero_fiid not like 'U%' "
                            + "order by entidad_padre";
                }
            } else {
                query = "select distinct entidad_padre, "
                        + "(entidad_padre || ' ' || (select Distinct nombre from   HUB.TBL_HUB_ENTIDADES@LG_PMTU_PMTWEB_PWS_HUB where numero_prosa = tblext.ENTIDAD_PADRE)) descripcion "
                        + "from HUB.TBL_HUB_ENTIDADES@LG_PMTU_PMTWEB_PWS_HUB tblext "
                        + "where tie_numero = 1 "
                        + "and IND_HUB_EMI = 1 "
                        + "and numero_fiid not like 'U%' "
                        + "order by entidad_padre";
            }

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoEmiHub: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancoAdqHub(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");

            String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");

            if (role.equals("banco")) {
                query = "select distinct entidad_padre,(entidad_padre || ' ' || nombre)descripcion "
                        + "from HUB.TBL_HUB_ENTIDADES@LG_PMTU_PMTWEB_PWS_HUB "
                        + "where tie_numero = 1 "
                        + "and IND_HUB_EMI=0 "
                        + "and numero_prosa in (" + numerosProsa + ") "
                        + "and numero_prosa=entidad_padre "
                        + "order by entidad_padre";
            } else {
                query = "select distinct entidad_padre,(entidad_padre || ' ' || nombre)descripcion "
                        + " from HUB.TBL_HUB_ENTIDADES@LG_PMTU_PMTWEB_PWS_HUB  "
                        + " where tie_numero = 2 "
                        + "and IND_HUB_EMI=0 "
                        + " and entidad_padre=numero_prosa "
                        + " order by entidad_padre";
            }

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoAdqHub: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }

        return cbValues;
    }

    public ArrayList getBancoAdqTelefonica(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");
            query = "select numero_prosa, descripcion from(	"
                    + " select entidad_padre, numero_prosa,  (numero_prosa||' '|| descripcion||' '||bu_tx_parent) descripcion "
                    + " FROM PMADMIN.VW_BUS_ACQ "
                    + " WHERE tie_numero=1 "
                    + " union "
                    + " select entidad_padre,numero_prosa, (numero_prosa||' '|| descripcion||' '||bu_tx_parent) descripcion "
                    + " FROM PMADMIN.VW_BUS_EMI "
                    + " WHERE tie_numero=1 "
                    + " ) ";
            if (role.equals("banco")) {
                String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
                query += " where entidad_padre  in (" + numerosProsa + ") ";
            }
            query += " order by numero_prosa";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
            //String []consol= new String[2];
            //if(!role.equals("banco")){
            //	consol[0]="-1";
            //	consol[1]="Todos Los bancos";
            //	cbValues.add(consol);
            //}
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoAdqEmiConsol: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getTelefonica(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");
            query = "select vtc_cve_telef, vtc_nom_telef "
                    + "from VTC.tbl_vtc_cat_telefonicas@LG_PMTU_PMTWEB_IFO2_VTC";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
            //String []consol= new String[2];
            //consol[0]="-1";
            //consol[1]="Todas las Telefonicas";
            //cbValues.add(consol);
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getTelefonica: " + ex.toString());
        }
        cbValues = conOracle.getRSColsData();
        return cbValues;
    }

    public ArrayList getTelefonicaMantenimiento(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");
            query = "select vtc_cve_telef, vtc_nom_telef "
                    + "from VTC.tbl_vtc_cat_telefonicas@LG_PMTU_PMTWEB_IFO2_VTC";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getTelefonicaMantenimiento: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getDistribuidor(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            query = "select vtc_id_distr, vtc_nom_distr "
                    + "from VTC.TBL_VTC_CAT_DISTRIBUIDOR@LG_PMTU_PMTWEB_IFO2_VTC";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

            //String []consol= new String[2];
            //consol[0]="-1";
            //consol[1]="Todas los Distribuidores";
            //cbValues.add(consol);
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoAdqEmiConsol: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getDistribuidorMantenimiento(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            query = "select vtc_id_distr, vtc_nom_distr "
                    + "from VTC.TBL_VTC_CAT_DISTRIBUIDOR@LG_PMTU_PMTWEB_IFO2_VTC";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoAdqEmiConsol: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getDrawDownDcc(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            String tipo = session.getAttribute("tipo") == null ? "" : (String) session.getAttribute("tipo");
            String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");
            if (role.equals("banco")) {
                query = "SELECT NUMERO_PROSA, NUMERO_PROSA||' '||NOMBRE FROM supersic.ENTIDADES@LG_PMTU_IFO_01 WHERE IND_LIQ_VISA IN ('1', '3') AND IND_DCC IN('1', '2') AND NUMERO_PROSA = ENT_NUMERO_PROSA AND NUMERO_PROSA IN(" + numerosProsa + ") ORDER BY NUMERO_PROSA ";
            } else {
                query = "SELECT 0 NUMERO_PROSA, 'TODAS LAS ENTIDADES' NOMBRE FROM DUAL UNION SELECT NUMERO_PROSA, NUMERO_PROSA||' '||NOMBRE FROM supersic.ENTIDADES@LG_PMTU_IFO_01 WHERE IND_LIQ_VISA IN ('1', '3') AND IND_DCC IN('1', '2') AND NUMERO_PROSA = ENT_NUMERO_PROSA ORDER BY NUMERO_PROSA ";
            }
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getDrawDown2: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getDrawDownDccPMTU(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");
            String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
            if (role.equals("banco")) {
                query = "SELECT pm.NUMERO_PROSA\n       ,pm.DESCRIPCION NOMBRE\n   FROM pmadmin.PRSA_ENTIDADES pm\n       ,supersic.ENTIDADES@LG_PMTU_IFO_01 en\n  WHERE pm.NUMERO_FIID LIKE 'M%'\n    AND pm.GCO_NUMERO IS NULL\n    AND en.NUMERO_PROSA IN(" + numerosProsa + ")\n    AND pm.NUMERO_PROSA = DECODE(en.NUMERO_PROSA, 7, 109, 58, 120, 3, 121, en.NUMERO_PROSA)\n  ORDER\n     BY NUMERO_PROSA\n";
            } else {
                query = "SELECT 0 NUMERO_PROSA, 'TODAS LAS ENTIDADES' NOMBRE FROM DUAL UNION Select NUMERO_PROSA, DESCRIPCION NOMBRE  From pmadmin.PRSA_ENTIDADES WHERE NUMERO_FIID Like 'M%' And GCO_NUMERO IS NULL ORDER BY NUMERO_PROSA ";
            }
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getDrawDown2: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getEmiAdq3(HttpSession session) {
        ArrayList cbValues = new ArrayList(2);
        String[] bco1 = new String[2];
        String[] bco2 = new String[2];
        bco1[0] = "ADQ";
        bco1[1] = "Adquirente";
        bco2[0] = "EMI";
        bco2[1] = "Emisor";
        cbValues.add(bco1);
        cbValues.add(bco2);
        return cbValues;
    }

    public ArrayList getBancoAdqSinMer(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");
            String tipo = session.getAttribute("tipo") == null ? "" : (String) session.getAttribute("tipo");
            query = "select distinct tblExt.entidad_padre, (tblExt.entidad_padre || ' ' || pe.descripcion  || ' ' || bu_tx_parent) descripcion   "
                    + "    FROM pmadmin.VW_BUS_ACQ tblExt join pmadmin.prsa_entidades pe on pe.numero_prosa=tblExt.entidad_padre    "
                    + "    AND PE.TIE_NUMERO = 1    "
                    + "    AND TBLEXT.NUMERO_FIID NOT LIKE 'M%'   "
                    + "    AND TBLEXT.NUMERO_FIID NOT LIKE 'D%'   "
                    + "    AND TBLEXT.NUMERO_FIID <> 'PEMD'   "
                    + "    and TBLEXT.NUMERO_PROSA NOT IN ('4','9','31','31','31','94','682','694')   "
                    + "    UNION    "
                    + "    select distinct tblExt.entidad_padre, (tblExt.entidad_padre || ' ' || pe.descripcion  || ' ' || bu_tx_parent)   "
                    + "    FROM pmadmin.VW_BUS_EMI tblExt join pmadmin.prsa_entidades pe on pe.numero_prosa=tblExt.entidad_padre    "
                    + "    where PE.TIE_NUMERO = 1   "
                    + "    AND TBLEXT.NUMERO_FIID NOT LIKE 'M%'   "
                    + "    AND TBLEXT.NUMERO_FIID NOT LIKE 'U%'   "
                    + "    and TBLEXT.NUMERO_FIID <> 'BAND'   "
                    + "    and TBLEXT.NUMERO_PROSA NOT IN ('4','9','31','31','31','94','682','694')   ";

            if (role.equals("banco") || tipo.equals("emi")) {
                String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
                query += " AND tblExt.entidad_padre  in (" + numerosProsa + ") and tblExt.tie_numero not in (8,9,14,15,17,18) ";

            }
            query += "\n order by 1";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoAdqSinMer: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getES(String num) throws WellException {
        String nume;
        nume = num;
        ArrayList cbValues = new ArrayList(2);
        if (nume.equals("774")) {
            String[] invalido = new String[2];
            String[] valido = new String[2];
            invalido[0] = "E";
            invalido[1] = "Prosa";
            valido[0] = "S";
            valido[1] = "Banco";
            cbValues.add(invalido);
            cbValues.add(valido);
            return cbValues;
        } else {
            String[] invalido = new String[2];
            invalido[0] = "A";
            invalido[1] = "    ";
            cbValues.add(invalido);
            return cbValues;
        }
    }

    public ArrayList getComercioBu(String num) throws WellException {
        String nume;
        ArrayList cbValues;
        nume = num;
        try {
            query = "SELECT DISTINCT CPT.PT_RTLR_ID, CPT.PT_RTLR_ID FROM CORE.CZ_PRCD_TXN CPT WHERE CPT.PT_ACQ_BU IN (" + nume + ")";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.prosa.sacii.getComercioBu: "
                    + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getPrefijoPRE(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            query = "SELECT DISTINCT ENTIDAD_PROSA, ENTIDAD_PROSA FROM PRE.TBL_PRE_PREFIJO";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.prosa.sacii.getPrefijoPRE: "
                    + ex.toString());
        }
        return cbValues;
    }

    public ArrayList getPrefijoPREFIID(String fiid) throws WellException {
        String lfiid;
        ArrayList cbValues;
        lfiid = fiid;
        try {
            query = "SELECT DISTINCT PREFIJO, PREFIJO LPREFIJO FROM PRE.TBL_PRE_PREFIJO WHERE ENTIDAD_PROSA =" + lfiid;
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.prosa.sacii.getPrefijoPREFIID: "
                    + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getDivision(HttpSession session, String interred) throws WellException {
        ArrayList cbValues = null;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");
            query = " select numero_prosa, (numero_prosa || ' ' || descripcion  || ' ' || bu_tx_adq) descripcion "
                    + " from pmadmin.VW_BUS_ACQ "
                    + " WHERE tie_numero=2 "
                    + " and entidad_padre in( "
                    + interred + ") order by numero_prosa ";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.prosa.sacii.getDivision: "
                    + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getDivisionDol(HttpSession session, String interred) throws WellException {
        ArrayList cbValues = null;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");
            query = " SELECT VBE.NUMERO_PROSA, VBE.NUMERO_PROSA||' '||VBE.DESCRIPCION "
                    + " FROM PMADMIN.VW_BUS_EMI VBE "
                    + " WHERE VBE.NUMERO_LN = 'DLMN' "
                    + " AND VBE.ENTIDAD_PADRE IN (" + interred + ")";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.prosa.sacii.getDivisionDol: "
                    + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getArchivo(HttpSession session, String initDate, String endDate) throws WellException {
        ArrayList cbValues;
        try {
            String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
            role = (String) session.getAttribute("role");
            if (role.equals("banco")) {
                query = "SELECT DISTINCT DECODE(BA.BA_NUM_ARCH,1005,'1'||TRIM(BA.BA_ARCHIVO)||'.PROC',TRIM(BA.BA_ARCHIVO)||'.PROC') FROM PMADMIN.PRSA_BITACORA_ARCHIVOS BA ";
                if (initDate != null && endDate != null) {
                    query += " WHERE BA.BA_FCH_PROC BETWEEN TO_DATE('" + initDate + "','DD/MM/YYYY') AND TO_DATE('" + endDate + "','DD/MM/YYYY') "
                            + " AND BA.BA_T_ARCH = 'I' "
                            + " AND BA.BA_ENT_EMI IN (" + numerosProsa + ") "
                            + " ORDER BY 1";
                }
            } else {
                query = "SELECT DISTINCT DECODE(BA.BA_NUM_ARCH,1005,'1'||TRIM(BA.BA_ARCHIVO)||'.PROC',TRIM(BA.BA_ARCHIVO)||'.PROC') FROM PMADMIN.PRSA_BITACORA_ARCHIVOS BA";
                // CAMBIO PARA MIGRACION INTERREDES
                //" INNER JOIN PMADMIN.VW_BUS_ACQ VBA "+
                //" ON VBA.NUMERO_PROSA = BA.BA_ENT_ADQ "+
                //" AND VBA.TIE_NUMERO = 2 ";
                // FIN CAMBIO PARA MIGRACION INTERREDES		
                if (initDate != null && endDate != null) {
                    query += " WHERE BA.BA_FCH_PROC BETWEEN TO_DATE('" + initDate + "','DD/MM/YYYY') AND TO_DATE('" + endDate + "','DD/MM/YYYY') "
                            + " AND BA.BA_T_ARCH = 'I' "
                            + " ORDER BY 1";
                }
            }
            System.out.println("Valor db: " + query);
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getArchivo: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getArchivoAdqC(HttpSession session, String bancoAdq, String initDate) throws WellException {
        ArrayList cbValues;
        try {
            query
                    = " SELECT DISTINCT PBA.BA_NUM_ARCH, PBA.BA_NUM_ARCH||' '||PA.DESCRIPCION "
                    + "   FROM SSP.PRSA_BITACORA_ARCHIVOS@LG_PMTU_PMTWEB_IFO2_SSP PBA "
                    + "  INNER JOIN SSP.PRSA_ARCHIVOS@LG_PMTU_PMTWEB_IFO2_SSP PA "
                    + " 	  ON PA.NUMERO = PBA.BA_NUM_ARCH "
                    + "  WHERE PBA.BA_FCH_PROC BETWEEN TO_DATE('" + initDate + "','dd-MM-yyyy') AND SYSDATE "
                    + " 	 AND PBA.BA_ENT_ADQ = " + bancoAdq + " "
                    + " 	 AND PBA.BA_T_ARCH = 'I' "
                    + "  ORDER BY 1 ";
            System.out.println("Fuente :" + query + ":");
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.prosa.sacii.getArchivoAdqC: "
                    + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getArchivoAdq2(HttpSession session, String bancoAdq, String initDate) throws WellException {
        ArrayList cbValues;
        try {
            query = " SELECT DISTINCT PBA.BA_NUM_ARCH, PBA.BA_NUM_ARCH||' '||PA.DESCRIPCION "
                    + " FROM PMADMIN.PRSA_BITACORA_ARCHIVOS PBA "
                    + " INNER JOIN PMADMIN.PRSA_ARCHIVOS PA "
                    + " 	ON PA.NUMERO = PBA.BA_NUM_ARCH "
                    + " WHERE PBA.BA_FCH_PROC = TO_DATE('" + initDate + "','dd-MM-yyyy') "
                    + " 	AND PBA.BA_ENT_ADQ = " + bancoAdq + " "
                    + " 	AND PBA.BA_T_ARCH = 'I' "
                    + " ORDER BY 1 ";
            System.out.println("Fuente :" + query + ":");

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();

        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.prosa.sacii.getArchivoAdq2: "
                    + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getLiquidacionxBcoAdq(HttpSession session, String bancoAdq) throws WellException {
        ArrayList cbValues;
        try {
            query
                    = " SELECT DISTINCT "
                    + //" SN.NSI_CLR_ID LIQ "+
                    //"   ,CASE  "+
                    //"     WHEN SN.NSI_CLR_ID IN (25,31,53,52,54,28,29) THEN 'LIQUIDACION MERCADOS INTERNACIONALES' "+
                    //"     ELSE SNCI.NCI_NSI_CLR_D "+
                    //"   END LIQ_DES "+
                    " SNCI.NCI_NSI_CLR_ID N, "
                    + " SNCI.NCI_NSI_CLR_D  D "
                    + " FROM SETTLEMENT.SZ_B4_CONV_NSI SBCN "
                    + " INNER JOIN PMADMIN.VW_BUS_ACQ VBA "
                    + " ON SBCN.CNSI_BU = VBA.BU_TX_ADQ "
                    + " INNER JOIN SETTLEMENT.SV_NSI SN "
                    + " ON SBCN.CNSI_NSI = SN.NSI_ID "
                    + " INNER JOIN PMADMIN.SV_NSI_CLR_ID SNCI "
                    + " ON SNCI.NCI_NSI_CLR_ID = SN.NSI_CLR_ID "
                    + " WHERE VBA.NUMERO_PROSA IN (" + bancoAdq + ") "
                    + " AND SN.NSI_CLR_ID NOT IN (1,2,55)";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.prosa.sacii.getLiquidacionxBcoAdq: "
                    + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getRechazo(HttpSession session, String banco, String initDate) throws WellException {
        ArrayList cbValues;
        try {
            query = " SELECT DISTINCT PRT.PRT_TXT_MSG_BMXR, "
                    + " DECODE(TRIM(PRT.PRT_TXT_MSG_BMXR),'REVERSOS CON ORIGINAL','REVERSOS CON ORIGINAL' "
                    + // CAMBIO POR EMMA 30/08/2011 SE CAMBIO LA LEYENDA 
                    //"                            ,'REVERSOS SIN VENTA O DISPOSICION ASOCIADA','02 - REVERSOS SIN ORIGINAL' "+
                    "                            ,'REVERSOS SIN ORIGINAL','REVERSOS SIN ORIGINAL' "
                    + // FIN CAMBIO POR EMMA 30/08/2011 SE CAMBIO LA LEYENDA 
                    "                              ,'CANCELACIONES CON ORIGINAL','CANCELACIONES CON ORIGINAL' "
                    + "                              ,'AJUSTES DE VENTA/DEVOLUCION SIN ORIGINAL','AJUSTES SIN ORIGINAL' "
                    + "                              ,'DUPLICADAS EN 4 CAMPOS','DUPLICADAS EN CUATRO CAMPOS' "
                    + "                              ,'DUPLICADAS EN 5 CAMPOS','DUPLICADAS EN CINCO CAMPOS' "
                    + "                              ,'EL IMPORTE TOTAL DE LA TRANSACCION DEBE SER MAYOR QUE CERO','TRANSACCIONES CON IMPORTE 0' "
                    + "                              ,'DEVOLUCION SOSPECHOSA','DEVOLUCION SOSPECHOSA' "
                    + "                              ,'TRANSACCION EXTEMPORANEA','TRANSACCION EXTEMPORANEA DE PTLF' "
                    + "                              ,'RECHAZO DE TRANSACCIONES MILLONARIAS','TRANSACCIONES MILLONARIAS' "
                    + "                              ,TRIM(PRT.PRT_TXT_MSG_BMXR)) X "
                    + " FROM PMADMIN.PRSA_REJECTED_TXN PRT "
                    + " WHERE TRIM(PRT.PRT_TXT_MSG_BMXR) IS NOT NULL "
                    + " AND PRT.PRT_PROC_DTE = TO_DATE('" + initDate + "','DD/MM/YYYY') "
                    + //" AND (PRT.PRT_PROSA_ISS_ENTITY IN ("+banco+") OR PRT.PRT_PROSA_ACQ_ENTITY IN ("+banco+")) "+
                    " AND RTRIM(PRT.PRT_REJ_RSN) IN ( "
                    + " 'VAL-00032',  "
                    + " 'VAL-00051',  "
                    + " 'VAL-00052',  "
                    + " 'VAL-00059',  "
                    + " 'VAL-00060',  "
                    + " 'VAL-00061',  "
                    + " 'VAL-00062',  "
                    + " 'VAL-00069',  "
                    + " 'VAL-00071',  "
                    + " 'VAL-00072',  "
                    + " 'VAL-00075',  "
                    + " 'VAL-00076',  "
                    + " 'VAL-00077',  "
                    + " 'VAL-00100',  "
                    + " 'VAL-00105',  "
                    + " 'VAL-00106',  "
                    + " 'VAL-00107', "
                    + " 'VAL-00108', "
                    + " 'VAL-00109', "
                    + " 'VAL-PTLF','VAL-00001') "
                    + " ORDER BY 2 ";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.prosa.sacii.getRechazo: "
                    + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getPrefijos(HttpSession session, String num) throws WellException {

        ArrayList cbValues;
        String entidad = num;
        try {
            query = "select distinct pbin_bin,pbin_bin from pmadmin.prsa_bin WHERE PBIN_ISS_ENTITY IN (" + entidad + ") order by 1";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.prosa.sacii.getMiscelaneo: "
                    + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getLiquidacionxBcoEmi(HttpSession session, String bancoEmi) throws WellException {
        ArrayList cbValues;
        try {
            query
                    = " SELECT DISTINCT "
                    + " SNCI.NCI_NSI_CLR_ID N, "
                    + " SNCI.NCI_NSI_CLR_D  D "
                    + " FROM SETTLEMENT.SZ_B4_CONV_NSI SBCN "
                    + " INNER JOIN PMADMIN.VW_BUS_EMI VBE "
                    + " ON SBCN.CNSI_BU_ALT = VBE.BU_TX_ISS "
                    + " INNER JOIN SETTLEMENT.SV_NSI SN "
                    + " ON SBCN.CNSI_NSI = SN.NSI_ID "
                    + " INNER JOIN PMADMIN.SV_NSI_CLR_ID SNCI "
                    + " ON SNCI.NCI_NSI_CLR_ID = SN.NSI_CLR_ID "
                    + " WHERE VBE.NUMERO_PROSA IN (" + bancoEmi + ") "
                    + " AND SN.NSI_CLR_ID NOT IN (1,2,55)";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.prosa.sacii.getLiquidacionxBcoEmi: "
                    + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getArchivoEmi(HttpSession session, String bancoEmi) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");

            query
                    = " SELECT PA1.NUMERO, PA1.NUMERO||' '||PA2.DESCRIPCION "
                    + " FROM PMADMIN.PRSA_ARCHIVOS PA1 "
                    + " INNER JOIN PMADMIN.PRSA_ARCHIVOS PA2 "
                    + " 	ON PA1.NUMERO = PA2.BAIN_NUMERO "
                    + " 	AND PA2.NUMERO = PA1.BAIN_NUMERO "
                    + " WHERE PA1.ENT_NUMERO_PROSA IN (" + bancoEmi + ") "
                    + " UNION "
                    + " SELECT DATOS.BAIN_NUMERO, DATOS.BAIN_NUMERO||' '||DATOS.DESCRIPCION "
                    + " FROM ( "
                    + " SELECT PA3.NUMERO, PA3.BAIN_NUMERO, PA3.DESCRIPCION "
                    + " FROM PMADMIN.PRSA_ARCHIVOS PA3 "
                    + " WHERE PA3.BAIN_NUMERO IS NOT NULL "
                    + " AND PA3.BAIN_NUMERO != 0 "
                    + " AND PA3.ENT_NUMERO_PROSA IN (" + bancoEmi + ") "
                    + " MINUS "
                    + " SELECT PA1.NUMERO, PA2.BAIN_NUMERO, PA1.DESCRIPCION "
                    + " FROM PMADMIN.PRSA_ARCHIVOS PA1 "
                    + " INNER JOIN PMADMIN.PRSA_ARCHIVOS PA2 "
                    + " 	ON PA1.NUMERO = PA2.BAIN_NUMERO "
                    + " 	AND PA2.NUMERO = PA1.BAIN_NUMERO "
                    + " ) DATOS "
                    + " ORDER BY 1 ";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.prosa.sacii.getArchivoEmi: "
                    + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getArchivoAdq(HttpSession session, String bancoAdq) throws WellException {
        ArrayList cbValues;
        try {
            if (bancoAdq.contains("96") || bancoAdq.contains("97")) {
                query = "select numero,(numero || ' ' || descripcion) descripcion "
                        + " from pmadmin.PRSA_ARCHIVOS "
                        + " where ent_numero_prosa in( select numero_prosa from pmadmin.vw_bus_acq where numero_prosa in( " + bancoAdq + ")) "
                        + " and entrada=1 and ent_numero_prosa not in(96,97)"
                        + " union "
                        + "select numero,(numero || ' ' || descripcion) descripcion "
                        + " from pmadmin.PRSA_ARCHIVOS "
                        + "where numero=45";
            } else //System.out.println("Fecha:"+fecha);
            {
                query = "select numero,(numero || ' ' || descripcion) descripcion "
                        + " from pmadmin.PRSA_ARCHIVOS "
                        + " where "
                        + " ( ent_numero_prosa in( select numero_prosa from pmadmin.vw_bus_acq where numero_prosa in( " + bancoAdq + ")) "
                        + " OR ent_numero_prosa in( select ENTIDAD_PADRE from pmadmin.vw_bus_acq where numero_prosa in( " + bancoAdq + "))) "
                        + " and entrada=1 "
                        + //" order by numero "+
                        " UNION "
                        + " SELECT DISTINCT 2105,'2105 TRANSACCIONES POS PROSA-PUERTO RICO' "
                        + " FROM PMADMIN.PRSA_ENTIDADES PE "
                        + " WHERE PE.TIE_NUMERO = 8 "
                        + " AND PE.NUMERO_PROSA IN (" + bancoAdq + ") "
                        + " UNION "
                        + " SELECT DISTINCT 1005,'1005 ADQUIRENTES DOLARES BANCOS SOCIOS MEXICO' "
                        + " FROM PMADMIN.PRSA_ENTIDADES PE "
                        + " WHERE PE.TIE_NUMERO = 9 "
                        + " AND PE.NUMERO_PROSA IN (" + bancoAdq + ") "
                        + " UNION "
                        + " SELECT DISTINCT 5,'5 TRANSACCIONES POS PROSA' "
                        + " FROM PMADMIN.PRSA_ENTIDADES PE "
                        + " WHERE PE.TIE_NUMERO NOT IN (2,9) "
                        + " AND PE.NUMERO_LN NOT IN ('EGLO','VISA','MDS') "
                        + " AND PE.NUMERO_PROSA IN (" + bancoAdq + ")"
                        + " UNION "
                        + " SELECT 105, '105 INTEGRACION POR SISTEMAS' FROM DUAL";
            }
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.prosa.sacii.getArchivoAdq: "
                    + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getArchivoAdqDol(HttpSession session, String bancoAdq) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");

            query = " select distinct numero, (numero || ' ' || descripcion) descripcion"
                    + " from pmadmin.PRSA_ARCHIVOS "
                    + " where ent_numero_prosa in(" + bancoAdq + ") AND SALIDA=1"
                    + " order by numero ";

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.prosa.sacii.getArchivoAdqDol: "
                    + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getArchivoEntrada(HttpSession session, String banco, String fechaIni, String fechaFin, String tipo) throws WellException {
        ArrayList cbValues;
        try {
            query = " select distinct numero, (numero || ' ' || descripcion)descripcion "
                    + " from  PMADMIN.PRSA_BITACORA_ARCHIVOS PBA INNER JOIN "
                    + " PMADMIN.PRSA_ARCHIVOS PA  ON PBA.BA_NUM_ARCH = PA.NUMERO "
                    + " where PA.entrada in (1) ";
            if (tipo.equals("bancoAdq")) {
                query += " and PBA.BA_ENT_ADQ in (" + banco + ") ";
            }
            if (tipo.equals("bancoEmi")) {
                query += " and PBA.BA_ENT_EMI in (" + banco + ") ";
            }
            query += " AND PBA.BA_FCH_PROC BETWEEN TO_DATE('" + fechaIni + "','dd-MM-yyyy') AND TO_DATE('" + fechaFin + "','dd-MM-yyyy') "
                    + " and PBA.BA_T_ARCH='I' "
                    + " order by numero ";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.prosa.sacii.getArchivoEntrada: "
                    + ex.toString());
        }
        return cbValues;
    }

    public ArrayList getArchivoSalida(HttpSession session, String banco, String fechaIni, String fechaFin, String tipo) throws WellException {
        ArrayList cbValues;
        try {
            query = " select distinct numero, (numero || ' ' || descripcion)descripcion "
                    + " from  PMADMIN.PRSA_BITACORA_ARCHIVOS PBA INNER JOIN "
                    + " PMADMIN.PRSA_ARCHIVOS PA  ON PBA.BA_NUM_ARCH = PA.NUMERO "
                    + " where PA.salida in (1) ";
            if (tipo.equals("bancoAdq")) {
                query += " and PBA.BA_ENT_ADQ in (" + banco + ") ";
            }
            if (tipo.equals("bancoEmi")) {
                query += " and PBA.BA_ENT_EMI in (" + banco + ") ";
            }
            query += " AND PBA.BA_FCH_PROC BETWEEN TO_DATE('" + fechaIni + "','dd-MM-yyyy') AND TO_DATE('" + fechaFin + "','dd-MM-yyyy') "
                    + " and PBA.BA_T_ARCH='O' "
                    + " order by numero ";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.prosa.sacii.getArchivoEntrada: "
                    + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getEntidadesTx(HttpSession session, String valores) throws WellException {
        ArrayList cbValues;
        try {
            query = "SELECT NUMERO_PROSA, (NUMERO_PROSA || ' ' || DESCRIPCION) ENTIDADES "
                    + "FROM PMADMIN.PRSA_ENTIDADES where NUMERO_PROSA IN (" + valores + ") ORDER BY 1";
//							+" AND NUMERO_FIID NOT LIKE 'U%' " 
//                            +" AND DESCRIPCION NOT LIKE '%DOLARES%'";							
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.ComboBox.getEntidadesTx: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBinInternacionEntidad(HttpSession session, String valores) throws WellException {
        ArrayList cbValues;
        try {
            query = "SELECT DISTINCT PB.PBIN_BIN, (PB.PBIN_BIN || ' ' || DESCRIPCION) DESCRIPCION\n"
                    + "FROM PMADMIN.PRSA_ENTIDADES PE\n"
                    + "INNER JOIN PMADMIN.PRSA_BIN PB\n"
                    + "ON PE.NUMERO_PROSA = PB.PBIN_ISS_ENTITY\n"
                    + "WHERE PB.PBIN_BIN IN (" + valores + ")\n"
                    + "UNION ALL\n"
                    + "SELECT DISTINCT CBA.BINA_BIN, (CBA.BINA_BIN || ' ' || DESCRIPCION) DESCRIPCION\n"
                    + "FROM PMADMIN.VW_BUS_ACQ VBA\n"
                    + "INNER JOIN CORE.CZ_BIN_ACQ CBA\n"
                    + "ON VBA.BU_TX_ADQ = CBA.BINA_BU\n"
                    + "WHERE CBA.BINA_BIN in (" + valores + ")\n"
                    + "UNION ALL\n"
                    + "SELECT DISTINCT CBI.BINI_BIN, (CBI.BINI_BIN || ' ' || DESCRIPCION) DESCRIPCION\n"
                    + "FROM PMADMIN.VW_BUS_EMI VBE\n"
                    + "INNER JOIN CORE.CZ_BIN_ISS CBI\n"
                    + "ON VBE.BU_TX_ISS = CBI.BINI_OWN_BU\n"
                    + "WHERE CBI.BINI_OWN_BU in (" + valores + ")";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.ComboBox.getBinInternacionEntidad: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getValInval(HttpSession session) {
        ArrayList cbValues = new ArrayList(2);
        String[] invalido = new String[2];
        String[] valido = new String[2];
        invalido[0] = "I";
        invalido[1] = "Invalido";
        valido[0] = "V";
        valido[1] = "Valido";
        cbValues.add(invalido);
        cbValues.add(valido);
        return cbValues;
    }

    public ArrayList getEmiAdq(HttpSession session) {
        ArrayList cbValues = new ArrayList(2);
        String[] bco1 = new String[2];
        String[] bco2 = new String[2];
        bco1[0] = "ADQ";
        bco1[1] = "918 Adquirente Prosa";
        bco2[0] = "EMI";
        bco2[1] = "945 Emisor Prosa";
        cbValues.add(bco1);
        cbValues.add(bco2);
        return cbValues;
    }

    public ArrayList getBancosBU(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");
            query = "SELECT * FROM ( "
                    + " SELECT BU, TIPO FROM ( "
                    + " SELECT VBA.BU_TX_ADQ BU, "
                    + " CASE "
                    + "    WHEN VBA.BU_TX_ADQ = 1033 THEN '1031 EMISOR DOLARES' "
                    + "    ELSE VBA.ENTIDAD_PADRE||' '||VBA.DESCRIPCION "
                    + " END TIPO "
                    + " FROM PMADMIN.VW_BUS_ACQ VBA ";
            if ("nvoTC".equals((String) session.getAttribute("accion"))) {
                query += " WHERE VBA.ENTIDAD_PADRE IN (31,194,230,694,1031,10001) ";
            } else {
                query += " WHERE VBA.ENTIDAD_PADRE IN (31,94,98,194,230,694,1031,10001) ";
            }
            query += " UNION "
                    + " SELECT 194, '194 PROSA LIQUIDACION' FROM DUAL "
                    + " UNION "
                    + " SELECT 230, '230 DIARIO OFICIAL' FROM DUAL) "
                    + " ORDER BY 2 "
                    + ")";
            if (role.equals("banco")) {
                query += " WHERE BU IN (196,211) ";
            }

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.prosa.sacii.getBancoBU: "
                    + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getTipoDoc(HttpSession session) throws WellException {
        ArrayList cbValues;
        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");
            query = "SELECT DISTINCT(tipo) FROM PMADMIN.TBL_PMT_SOPORTE";
            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException(
                    "com.wellcom.prosa.sacii.getTipoDoc: "
                    + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

    public ArrayList getBancoSinEgloInteCons(HttpSession session) throws WellException {
        String sessionID;
        ArrayList cbValues;

        try {
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");

            query = " SELECT VBA.NUMERO_PROSA, VBA.NUMERO_PROSA||' '||VBA.DESCRIPCION DES FROM PMADMIN.VW_BUS_ACQ VBA WHERE VBA.NUMERO_LN NOT IN ('EGLO') AND VBA.TIE_NUMERO NOT IN (2) ";

            if (role.equals("banco")) {
                String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
                query += " AND VBA.NUMERO_PROSA IN (" + numerosProsa + ") ";
            } else {
                query += " UNION ALL SELECT 0, 'CONSOLIDADO' FROM DUAL ";
            }

            conOracle.Conectar();
            conOracle.Consultar(query);
            cbValues = conOracle.getRSColsData();
        } catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBancoSinEgloInteCons: " + ex.toString());
        } finally {
            conOracle.Desconectar();
        }
        return cbValues;
    }

/*-----------------------------------------------------------------------*/
/*Modificacion: Marca de Inicio  IDSYS-JRG-P-22-0136-14    12/04/2017    */
/*-----------------------------------------------------------------------*/
	public ArrayList getBancoTranscod(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;

	    try {
	    	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
                        fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");

           query =   " SELECT UNIQUE MA.NUMERO_PROSA, MA.NUMERO_PROSA||' '||MA.DESCRIPCION"+
                     "   FROM PMADMIN.PRSA_ENTIDADES MA"+
                     "  WHERE TRANSCOD = '1'";

			if(role.equals("banco"))
			{
				String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
				query += " AND NUMERO_PROSA IN (" + numerosProsa + ") ";
			}
				query += " ORDER BY 1";
                                System.out.println(query);
                        conOracle.Conectar();
                        conOracle.Consultar(query);

                        /*db.setQuerySelect( query );
			db.executeQuerySelect();*/
			cbValues = conOracle.getRSColsData();
                                //db.getRSColsData();
	    }
	    catch (Exception ex)
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoEmiLiqDol: " + ex.toString());
	    }finally {
            conOracle.Desconectar();
            }
		return cbValues;
	}

        public ArrayList getBancoTranscod2(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		//Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;

	    try {
	    	/*sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );*/

			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");

           query =   " SELECT UNIQUE NUMERO_FIID"+
                     "   FROM PMADMIN.PRSA_ENTIDADES"+
                     "  WHERE TRANSCOD = '1'";

			if(role.equals("banco"))
			{
				String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
				query += " AND NUMERO_PROSA IN (" + numerosProsa + ") ";
			}
				query += " ORDER BY 1";

                        /*db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();*/
                        conOracle.Conectar();
                        conOracle.Consultar(query);
                        cbValues = conOracle.getRSColsData();
	    }
	    catch (Exception ex)
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoEmiLiqDol: " + ex.toString());
	    }finally {
            conOracle.Desconectar();
            }
		return cbValues;
	}
/*-----------------------------------------------------------------------*/
/*Modificacion: Marca de Termina IDSYS-JRG-P-22-0136-14    12/04/2017    */
/*-----------------------------------------------------------------------*/

/* Modificacion: Marca de inicio SAS-DRT-P-20-0115-16 */
    public ArrayList getOpcionesEpape(HttpSession session) {
        ArrayList cbValues = new ArrayList(2);
        String[] soc = new String[2];
        String[] roc = new String[2];
        soc[0] = "S";
        soc[1] = "SOC";
        roc[0] = "R";
        roc[1] = "ROC";
        cbValues.add(soc);
        cbValues.add(roc);
        return cbValues;
    }

// 1.- AMEX PROSA CONCILIADAS
// 2.- AMEX PROSA PENDIENTES
// 3.- AMEX PENDIENTES 
// 4.- PROSA PENDIENTES
    public ArrayList getOpcionesConc(HttpSession session) {
        ArrayList cbValues = new ArrayList(2);
        String[] conc = new String[2];
        String[] app = new String[2];
        String[] ap = new String[2];
        String[] pp = new String[2];
        conc[0] = "1";
        conc[1] = "CONCILIADAS AMEX/PROSA";
        app[0] = "2";
        app[1] = "PENDIENTES AMEX/PROSA";
        ap[0] = "3";
        ap[1] = "PENDIENTES AMEX";
        pp[0] = "4";
        pp[1] = "PENDIENTES PROSA";
        cbValues.add(conc);
        cbValues.add(app);
        cbValues.add(ap);
        cbValues.add(pp);
        return cbValues;
    }
    /* Modificacion: Marca de FIN SAS-DRT-P-20-0115-16 */

    /*
     
      conOracle.Conectar();
    conOracle.Consultar(query); 
    cbValues = conOracle.getRSColsData();
     
      finally{ conOracle.Desconectar(); }
     */
}
