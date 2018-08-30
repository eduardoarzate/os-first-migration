/*###############################################################################
# Nombre del Programa :  ControllerMethod.java                                  #
#-------------------------------------------------------------------------------#
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017         #
# Modificacion        :  Mejora Conexiones  SAC2                                #
# Marca del Cambio    :  SAS-DRT F-52-8063-16                                   #
#-------------------------------------------------------------------------------#
# Numero de Parametros: 0                                                       #
###############################################################################*/
package com.wellcom.prosa.Controladores;

import com.wellcom.exceptions.WellException;
import com.wellcom.conexion.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import java.util.Date;

public class ControllerMethod {

    ConexionORACLE conOracle = null;

    public ControllerMethod() {
        conOracle = new ConexionORACLE();
    }

    public void Oparticiones(String fechaA, String fechaB, HttpSession session) {
        ArrayList fechas;
        String SQL = "";
        try {

            SQL = "SELECT PMADMIN.FN_PARTITION_ID(TO_DATE('" + fechaA + "','DD/MM/YYYY'))||' AND '||PMADMIN.FN_PARTITION_ID(TO_DATE('" + fechaB + "','DD/MM/YYYY')) FROM DUAL";

            conOracle.Conectar();
            conOracle.Consultar(SQL);
            fechas = conOracle.getRSColsData();

            String[] susparticiones = (String[]) fechas.get(0);
            session.setAttribute("susparticiones", susparticiones[0]);
            System.out.println(susparticiones + "::");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conOracle.Desconectar();
        }
    }

    public void Oparticionesdiaant(String fechaA, String fechaB, String fechaC, String fechaD, HttpSession session) {

        ArrayList fechas;
        ArrayList fechas2;
        String SQL = "";
        String SQL2 = "";

        try {

            SQL = "SELECT PMADMIN.FN_PARTITION_ID(TO_DATE('" + fechaA + "','DD/MM/YYYY'))||' AND '||PMADMIN.FN_PARTITION_ID(TO_DATE('" + fechaB + "','DD/MM/YYYY')) FROM DUAL";
            SQL2 = "SELECT PMADMIN.FN_PARTITION_ID(TO_DATE('" + fechaA + "','DD/MM/YYYY')-1)||' AND '||PMADMIN.FN_PARTITION_ID(TO_DATE('" + fechaB + "','DD/MM/YYYY')-1) FROM DUAL";

            conOracle.Conectar();
            conOracle.Consultar(SQL);
            fechas = conOracle.getRSColsData();

            conOracle.Consultar(SQL2);
            fechas2 = conOracle.getRSColsData();

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
    }

    public void Oparticion(String fechaA, HttpSession session) {
        ArrayList fechas0;
        String SQL0 = "";

        try {
            SQL0 = "SELECT PMADMIN.FN_PARTITION_ID(TO_DATE('" + fechaA + "','DD/MM/YYYY')) FROM DUAL ";

            conOracle.Conectar();
            conOracle.Consultar(SQL0);
            fechas0 = conOracle.getRSColsData();

            String[] suparticion = (String[]) fechas0.get(0);
            session.setAttribute("suparticion", suparticion[0]);
            System.out.println(suparticion + "::");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conOracle.Desconectar();
        }
    }

    public void Oparticioneshabant(String fechaA, String fechaB, String fechaC, String fechaD, HttpSession session) {

        ArrayList fechas;
        ArrayList fechas2;
        String SQL = "";
        String SQL2 = "";

        try {
            SQL = "SELECT PMADMIN.FN_PARTITION_ID(TO_DATE('" + fechaA + "','DD/MM/YYYY'))||' AND '||PMADMIN.FN_PARTITION_ID(TO_DATE('" + fechaB + "','DD/MM/YYYY')) FROM DUAL";
            SQL2 = "SELECT PMADMIN.FN_PARTITION_ID(TO_DATE('" + fechaC + "','DD/MM/YYYY'))||' AND '||PMADMIN.FN_PARTITION_ID(TO_DATE('" + fechaD + "','DD/MM/YYYY')) FROM DUAL";

            conOracle.Conectar();
            conOracle.Consultar(SQL);
            fechas = conOracle.getRSColsData();

            conOracle.Conectar();
            conOracle.Consultar(SQL2);
            fechas2 = conOracle.getRSColsData();

            String[] susparticiones = (String[]) fechas.get(0);
            String[] susparticioneshabant = (String[]) fechas2.get(0);

            session.setAttribute("susparticiones", susparticiones[0]);
            session.setAttribute("susparticionesHabAnt", susparticioneshabant[0]);

            System.out.println(susparticiones + "::");
            System.out.println(susparticioneshabant + "::");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conOracle.Desconectar();
        }
    }

    /**
     * ***
     */
}
