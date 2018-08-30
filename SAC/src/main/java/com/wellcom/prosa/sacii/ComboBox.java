/*###############################################################################
# Nombre del Programa :  ComboBox.java                                          #
# Autor               :  JOAQUIN MOJICA                                         #
# Compania            :  WELLCOM S.A. DE C.V.                                   #
# Proyecto/Procliente :  P-08-0299-04                   FECHA:30/10/2008        #
# Descripcion General :	 Pantalla que muestra los contracargos.                 #
#                                                                               #
# Programa Dependiente:                                                         #
# Programa Subsecuente:                                                         #
# Cond. de ejecucion  :  Controlador de objetos del sistema                     #
#                                                                               #
#                                                                               #
# Dias de ejecucion   :  A Peticion del web, se pueden ejecutar n instancias    #
#################################################################################
#								MODIFICACIONES                                  #
# Autor               : ERIKA A. MOJICA                                         #
# Compania            : WELLCOM SA DE CV                                        #
# Proyecto/Procliente : P-02-1202-09                 Fecha: 08/02/2010          #
# Modificación        : AUTOMATIZACION DE PREPAGO                               #
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                                  #
# Autor               : Gerardo G. Burguete                                     #
# Compania            : Axia, consultores, S.A. DE C.V.                         #
# Proyecto/Procliente : P-02-0496-10                 Fecha: 22/11/2012          #
# Modificacion        : Evaluacion e implementacion del Servicio DCC.           #
# Marca del Cambio    : AXIA-GGB-P-02-0496-10                                   #
#-----------------------------------------------------------------------------  #
#								MODIFICACIONES                                                  #
# Autor               : Gerardo G. Burguete                                     #
# Compania            : Axia, consultores, S.A. DE C.V.                         #
# Proyecto/Procliente : P-02-0060-12                 Fecha: 19/09/2013          #
# Modificacion        : DCC (Dynamic Currency Conversion) Banorte con Planet    #
#                     : Payment                                                 #
# Marca del Cambio    : AXIA-GGB-P-02-0060-12                                   #
#-----------------------------------------------------------------------------  #
# Autor               :  Velasco Palacios Miguel                                #
# Compania            :  SAS S.A. DE C.V.                                  	    #
# Proyecto/Procliente :  P-02-0216-12                Fecha: 03/06/2014          #
#                     :  Implementacion de Servicios Lealtad Max Value PROSA    #
# Numero de Parametros: 0                                                       #
#-----------------------------------------------------------------------------  #
# Autor               :  German Gonzalez Esquivel                               #
# Compania            :  wellcom S.A. DE C.V.                                  	#
# Proyecto/Procliente :  P-54-2452-14                Fecha: 07/08/2014          #
#                     :  Nuevo reporte de Transacciones con reverso             #
# Numero de Parametros: 0                                                       #
#-----------------------------------------------------------------------------  #
# Autor               : Gerardo G. Burguete                                     #
# Compania            : Axia, consultores, S.A. DE C.V.                         #
# Proyecto/Procliente : P-02-0275-12                 Fecha: 18/12/2014          #
# Modificacion        : Servicios Adquirente POS para Banco de Occidente.       #
# Marca del Cambio    : AXIA-GGB-P-02-0275-12                                   #
#-----------------------------------------------------------------------------  #
# Autor               :  German Gonzalez Esquivel                               #
# Compania            :  wellcom S.A. DE C.V.                                  	#
# Proyecto/Procliente :  P-06-2233-13                Fecha: 10/11/2014          #
#                     :  Integracion de reportes Corresponsales                 #
# Numero de Parametros: 0                                                       #
#-----------------------------------------------------------------------------  #
# Autor               :  Jose Pablo Lugo Correa                                 #
# Compania            :  SAS S.A. DE C.V.                                  		#
# Proyecto/Procliente :  P-53-2934-14                Fecha: 11/03/2015          #
#                     :  Implementación de Reporte para liquidacion nacional    #
#-----------------------------------------------------------------------------  #
# Autor               :                                                         #
# Compania            :                                                         #
# Proyecto/Procliente :                              Fecha:                     #
# Modificación        :                                                         #
#-----------------------------------------------------------------------------  #
# Autor               : Salvador Montiel                                        #
# Compania            : AM Estudio                                              #
# Proyecto/Procliente : P-54-2940-14               Fecha: 23/04/2015            #
# Modificacion        : Soporte Interactivo (FAQs,Tutoriales,Manuales)          #
# Marca del Cambio    : P-54-2940-14 AMEstudio 23.04.2015                       #
#-------------------------------------------------------------------------------#
# Autor               :  Luis Eduardo Ramírez Castillo                          #
# Compania            :  SAS S.A. DE C.V.                                  		#
# Proyecto/Procliente :  F-52-2173-15                Fecha: 24/07/2015          #
#                     :  Mejoras reportes SICLIR0090, SICMOR0340 y SICLIFD060   #
#-----------------------------------------------------------------------------  #
# Autor               : Juan Antonio Guzman Gomez                               #
# Compania            : SAS S.A. DE C.V.                                  	    #
# Proyecto/Procliente : Z-02-2675-12                Fecha: 14/02/2013           #
# Modificacion        : Venta de tiempo aire en terminales punto de venta       #
# Numero de Parametros: 0                                                       #
#-------------------------------------------------------------------------------#
# Autor               :  Jesus Parra Martinez                                   #
# Compania            :  SAS S.A. DE C.V.                                    	#
# Proyecto/Procliente :  P-06-0527-11                Fecha: 20/08/2014          #
#                     :  Implementación de Hub de Pagos en PROSA                #
# Numero de Parametros: 0                                                       #
#-----------------------------------------------------------------------------  #
# Autor               :  Jesus Parra Mtz.                                       #
# Compania            :  SAS S.A. DE C.V.                                  		#
# Proyecto/Procliente :  P-53-2934-14                Fecha: 11/03/2015          #
#                     :  Implementación de Reporte para liquidacion nacional    #
#-----------------------------------------------------------------------------  #
# Autor               :  Gerardo G. Burguete.                                   #
# Compania            :  Axia Consultores, S.A. DE C.V.                         #
# Proyecto/Procliente :  P-20-0452-14                Fecha: 27/10/2015          #
#                     :  Alta de Nuevo Emisor MC Dólares para Cuallix           #
#-----------------------------------------------------------------------------  #
# Autor               :  Laura Maleni Vazquez Ramirez                           #
# Compania            :  SAS S.A. DE C.V.                                  	    #
# Proyecto/Procliente :  P-02-0216-12                Fecha: 22/02/2016          #
#                     :  Implementacion de Servicios Lealtad Max Value PROSA    #
# Numero de Parametros: 0                                                       #
#-----------------------------------------------------------------------------  #
#                MODIFICACIONES                                                 #
# Autor               : Miguel Nieto                                            #
# Compania            : Axia, consultores, S.A. DE C.V.                         #
# Proyecto/Procliente : P-60-2646-14                 Fecha: 03/02/2016          #
# Modificacion        : Incorporacion Consubanco a Corresponsales con Chedraui  #
# Marca del Cambio    : AXIA-MNR-P-60-2646-14                                   #
#-------------------------------------------------------------------------------#
# Autor               :  Laura Maleni Ramirez Vazquez                           #
# Compania            :  SAS, S.A. DE C.V.                       				#
# Proyecto/Procliente :  P-53-2934-14                Fecha: 07/04/2016          #
#                     :  Reportes para Liquidacion Nacional de Marca	        #
#-----------------------------------------------------------------------------  #
# Autor               : Francisco Javier Cuamatzi Cuamatzi                      #
# Compania            : Axia, consultores, S.A. DE C.V.                         #
# Proyecto/Procliente : P-60-2646-14                 Fecha: 12/04/2016          #
# Descripcion General : Incorporacion Consubanco a Corresponsales con Chedraui  #
# Modificacion        : Incorporacion Consolidado de Entidades                  #
# Marca del Cambio    : AXIA-FJCC-P-60-2646-14                                  #
#-------------------------------------------------------------------------------#
# Autor               :  Daniel Ramirez Torres                                  #
# Compania            :  SAS, S.A. DE C.V.                       		#
# Proyecto/Procliente :  P-53-2004-15                Fecha: 17/05/2016          #
# Modificacion        :  Diferencia de cuotas entre cámaras	                #
# Marca del Cambio    :  SAS-DRT-P-53-2004-15                                   #
#-----------------------------------------------------------------------------  #
# Autor               : Francisco Javier Cuamatzi Cuamatzi                      #
# Compania            : Axia Consultores, S.A. DE C.V.                          #
# Proyecto/Procliente : P-53-2933-14                          Fecha: 05/07/2016 #
# Descripcion General : Re-calculo de compensacion y administracion de umbrales #
# Modificacion        : Se agrego funcionalidad de emisores CREDOMATIC          #
# Marca del Cambio    : AXIA-FJCC-P-53-2933-14                                  #
#-------------------------------------------------------------------------------#
#                          MODIFICACIONES                                       #
# Autor               : Daniel Ramirez Torres                                   #
# Compania            : SAS S.A. DE C.V.                                        #
# Proyecto/Procliente : P-20-0096-15                 Fecha: 13/07/2016          #
# Descripcion General : Fase 2 del Programa Súper Ofertas Santander sobretasa 0 #
# Modificacion        :                                                         #
# Marca del Cambio    : SAS-DRT-P-20-0096-15                                    #
#-----------------------------------------------------------------------------  #
# Autor               :  Daniel Ramírez Torres                                  #
# Compania            :  SAS S.A. DE C.V.                                       #
# Proyecto/Procliente :  B-54-2904-15                 Fecha: 25/08/2016         #
# Modificacion        :  Mejorar Reportería SAC2                                #
# Marca del Cambio    :  SAS-DRT B-54-2904-15                                   #
#-------------------------------------------------------------------------------#
# Autor               : Ascencion Hernandez Huerta                              #
# Compania            : Axia Consultores, S.A. de C.V.                          #
# Proyecto/Procliente : P-40-2187-15                          Fecha: 30/08/2016 #
# Descripcion General : Incorporacion Banorte a producto DCC (Fintrax)          #
# Modificacion        : Formateo e identificacion de Reportes Vss y T140 de Dcc #
# Marca del Cambio    : AXIA-AHH-P-40-2187-15                                   #
#-----------------------------------------------------------------------------  #
# Autor               : Francisco Javier Cuamatzi Cuamatzi                      #
# Compania            : Axia Consultores, S.A. DE C.V.                          #
# Proyecto/Procliente : P-02-0256-12                          Fecha: 09/09/2016 #
# Descripcion General : Servicios Adquirente POS para HSBC-Panama               #
# Modificacion        : Atencion al GAP84                                       #
# Marca del Cambio    : AXIA-FJCC-P-02-0256-12                                  #
#-------------------------------------------------------------------------------#
# Autor               : Ascencion Hernandez Huerta                              #
# Compania            : Axia Consultores, S.A. de C.V.                          #
# Proyecto/Procliente : P-21-0049-16                          Fecha: 19/10/2016 #
# Descripcion General : Integracion de Intercam en DCC Fintrax                  #
# Modificacion        : Correcion de Combo de Entidades de DCC                  #
# Marca del Cambio    : AXIA-AHH-P-21-0049-16                                   #
#-------------------------------------------------------------------------------#
#                          MODIFICACIONES                                       #
# Autor               : Daniel Ramirez Torres                                   #
# Compania            : SAS S.A. DE C.V.                                        #
# Proyecto/Procliente : P-20-0096-15                 Fecha: 01/12/2016          #
# Descripcion General : Fase 2 del Programa Súper Ofertas Santander sobretasa 0 #
# Modificacion        : Correccion de combo Entidades Emisor/Aquiriente Clicash #
# Marca del Cambio    : SAS-DRT-P-20-0096-15 01/12/2016                         #
#-----------------------------------------------------------------------------  #
#################################################################################
# Numero de Parametros: 0                                                       #
###############################################################################*/

package com.wellcom.prosa.sacii;

import com.wellcom.exceptions.WellException;
import com.wellcom.sql.Database;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//Marca inicio: P-54-2940-14 AMEstudio 23.04.2015
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
//Marca fin: P-54-2940-14 AMEstudio 23.04.2015
import java.util.Date;

public class ComboBox 

{
	private String numFiid;
	private String role; 
	private String query;
	private String fiid;
	private String login;
	
// Marca inicio: P-54-2940-14 AMEstudio 23.04.2015 
	public ArrayList getTipoDoc(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ARCHIVOS;
		ArrayList cbValues;
		
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	role = (String)session.getAttribute("role");
				numFiid = (String)session.getAttribute("numFiid");
				fiid = (String)session.getAttribute("fiid");
				login = (String)session.getAttribute("login");
		    	
				
					query = "SELECT DISTINCT(tipo) FROM PMADMIN.TBL_PMT_SOPORTE";
			
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) {
		      throw new WellException(
		        "com.wellcom.prosa.sacii.getBancoBU: "
		        + ex.toString());
		    }	 
		return cbValues;
	}

//Marca fin: P-54-2940-14 AMEstudio 23.04.2015 

	public ArrayList getMovimiento(HttpSession session){
		ArrayList cbValues=new ArrayList(2);
//		String[] local=new String[2] ;
		String[] internacional=new String[2] ;
//		local[0]="I";	
//		local[1]="Local";
		internacional[0]="V";	
		internacional[1]="Internacional";
//		cbValues.add(local);
		cbValues.add(internacional);
		return cbValues;
	}
	

	public ArrayList getValInval(HttpSession session){
		ArrayList cbValues=new ArrayList(2);
		String[] invalido=new String[2] ;
		String[] valido=new String[2] ;
		invalido[0]="I";	
		invalido[1]="Inválido";
		valido[0]="V";	
		valido[1]="Válido";
		cbValues.add(invalido);
		cbValues.add(valido);
		return cbValues;
	}
	
	
	public ArrayList getBancoSacDol(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");

			String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");

			if(role.equals("banco"))
			{
				
				query = " SELECT DISTINCT NUMERO_PROSA, (NUMERO_PROSA || ' ' || NOMBRE) ENTIDADES " +
						" FROM SUPERSIC.entidades@LG_PMTU_SIC EN "+
                        " WHERE " +
                        //" EN.TIE_NUMERO = 1 "+
                        //" AND EN.IND_LIQ_VISA IN (1,2,3) "+
                        //" AND EN.NUMERO_PROSA NOT IN (999) "+
                        " IND_LIQ_PESOS_DLLS=1 OR EN.NUMERO_VISA = 9 "+
                        " AND EN.ENT_NUMERO_PROSA IN (" + numerosProsa + ") "+
                        " ORDER BY 1 ";	
			}
			else
			{
				
		    query = " SELECT DISTINCT NUMERO_PROSA, (NUMERO_PROSA || ' ' || NOMBRE) ENTIDADES " +
		    		" FROM SUPERSIC.entidades@LG_PMTU_SIC EN "+
                " WHERE " +
                //" EN.TIE_NUMERO = 1 "+
                //" AND EN.IND_LIQ_VISA IN (1,2,3) "+
                //" AND EN.NUMERO_PROSA NOT IN (999) "+
                //" ORDER BY 1	"+
                " IND_LIQ_PESOS_DLLS=1 OR EN.NUMERO_VISA = 9 "+
                " UNION SELECT 0, 'CONSOLIDADO' FROM DUAL ORDER BY 1";
			}
				
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoSac: " + ex.toString());
	    }
		return cbValues;
	}

	/* Modificacion: Marca de inicio SAS-MEVP P-02-0216-12  */
 public ArrayList getBanList001(HttpSession session, String tipo) throws WellException {
        HttpServletRequest request = null;
        String sessionID;
        Database db;
        String PRSA_ENTIDADES;
        String VW_BUS_ACQ;
        String VW_BUS_EMI;
        ArrayList cbValues;

        try {

            sessionID = session.getId() + "db";
            db = (Database) session.getAttribute(sessionID);

            PRSA_ENTIDADES = (String) session.getAttribute("PRSA_ENTIDADES");
            VW_BUS_ACQ = (String) session.getAttribute("VW_BUS_ACQ");
            VW_BUS_EMI = (String) session.getAttribute("VW_BUS_EMI");
            role = (String) session.getAttribute("role");
            numFiid = (String) session.getAttribute("numFiid");
            fiid = (String) session.getAttribute("fiid");
            login = (String) session.getAttribute("login");
            /* Modificacion: Marca de inicio 22-02-2016 SAS-LMRV P-02-0216-12  */
            String numerosProsa = (String) session.getAttribute("numerosProsaEnSession");
            /* Modificacion: Marca de inicio SAS-DRT-P-20-0096-15  */
            if (role.equals("banco")) {
            /* Modificacion: Marca de inicio SAS-DRT-P-20-0096-15 01/12/2016 */
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
            /* Modificacion: Marca de fin SAS-DRT-P-20-0096-15 01/12/2016 */
            /* Modificacion: Marca de fin SAS-DRT-P-20-0096-15  */
            }
            db.setQuerySelect(query);
            db.executeQuerySelect();
            cbValues = db.getRSColsData();
        } /* Modificacion: Marca de inicio 22-02-2016 SAS-LMRV P-02-0216-12  */ 
        catch (Exception ex) {
            throw new WellException("com.wellcom.prosa.sacii.getBanList001: " + ex.toString());
        }
        return cbValues;
    }
/* Modificacion: Marca de fin    SAS-MEVP P-02-0216-12  */

/* Modificacion: Marca de Inicio SAS-JAGG-Z-02-2675-12 */
			
			public ArrayList getBancoAdqTelefonica(HttpSession session) throws WellException
			{
				HttpServletRequest request = null;
				String sessionID;
				Database db;
				String PRSA_ENTIDADES;
				String VW_BUS_ACQ;
				String VW_BUS_EMI;
				ArrayList cbValues;
			    try {
			    	sessionID = session.getId() + "db";
			    	db = (Database)session.getAttribute( sessionID );
					PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
					VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
					VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
					role = (String)session.getAttribute("role");
					numFiid = (String)session.getAttribute("numFiid");
					fiid = (String)session.getAttribute("fiid");
					login = (String)session.getAttribute("login");
					query = "select numero_prosa, descripcion from(	"+
					" select entidad_padre, numero_prosa,  (numero_prosa||' '|| descripcion||' '||bu_tx_parent) descripcion " +
					" FROM " + VW_BUS_ACQ+ 
					" WHERE tie_numero=1 "+
					" union "+
					" select entidad_padre,numero_prosa, (numero_prosa||' '|| descripcion||' '||bu_tx_parent) descripcion " +
					" FROM " + VW_BUS_EMI+
					" WHERE tie_numero=1 "+
					" ) ";
					if(role.equals("banco"))
					{
						String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
						query += " where entidad_padre  in (" + numerosProsa + ") ";
					}
					query += " order by numero_prosa";
					db.setQuerySelect( query );
					db.executeQuerySelect();
					cbValues = db.getRSColsData();
					//String []consol= new String[2];
					//if(!role.equals("banco")){
					//	consol[0]="-1";
					//	consol[1]="Todos Los bancos";
					//	cbValues.add(consol);
					//}
			    }
			    catch (Exception ex)
			    {
			      throw new WellException("com.wellcom.prosa.sacii.getBancoAdqEmiConsol: " + ex.toString());
			    }
				return cbValues;
			}
			
			/* Telefonica */

			public ArrayList getTelefonica(HttpSession session) throws WellException
			{
				HttpServletRequest request = null;
				String sessionID;
				Database db;
				String PRSA_ENTIDADES;
				String VW_BUS_ACQ;
				String VW_BUS_EMI;
				ArrayList cbValues;
			    try {
			    	sessionID = session.getId() + "db";
			    	db = (Database)session.getAttribute( sessionID );
					PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
					VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
					VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
					role = (String)session.getAttribute("role");
					numFiid = (String)session.getAttribute("numFiid");
					fiid = (String)session.getAttribute("fiid");
					login = (String)session.getAttribute("login");
					query = "select vtc_cve_telef, vtc_nom_telef "+
							"from VTC.tbl_vtc_cat_telefonicas@LG_PMTU_PMTWEB_IFO2_VTC";
					db.setQuerySelect( query );
					db.executeQuerySelect();
					cbValues = db.getRSColsData();
					//String []consol= new String[2];
					//consol[0]="-1";
					//consol[1]="Todas las Telefonicas";
					//cbValues.add(consol);
			    }
			    catch (Exception ex)
			    {
			      throw new WellException("com.wellcom.prosa.sacii.getBancoAdqEmiConsol: " + ex.toString());
			    }
			    return cbValues;
			}
			
			public ArrayList getTelefonicaMantenimiento(HttpSession session) throws WellException
			{
				HttpServletRequest request = null;
				String sessionID;
				Database db;
				String PRSA_ENTIDADES;
				String VW_BUS_ACQ;
				String VW_BUS_EMI;
				ArrayList cbValues;
			    try {
			    	sessionID = session.getId() + "db";
			    	db = (Database)session.getAttribute( sessionID );
					PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
					VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
					VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
					role = (String)session.getAttribute("role");
					numFiid = (String)session.getAttribute("numFiid");
					fiid = (String)session.getAttribute("fiid");
					login = (String)session.getAttribute("login");
					query =	"select vtc_cve_telef, vtc_nom_telef "+
							"from VTC.tbl_vtc_cat_telefonicas@LG_PMTU_PMTWEB_IFO2_VTC";
					db.setQuerySelect( query );
			        db.executeQuerySelect();
			        cbValues = db.getRSColsData();
			    }
			    catch (Exception ex)
			    {
			      throw new WellException("com.wellcom.prosa.sacii.getBancoAdqEmiConsol: " + ex.toString());
			    }
			    return cbValues;
			}
			
			public ArrayList getDistribuidor(HttpSession session) throws WellException
			{
				HttpServletRequest request = null;
				String sessionID;
				Database db;
				String PRSA_ENTIDADES;
				String VW_BUS_ACQ;
				String VW_BUS_EMI;
				ArrayList cbValues;
			    try {
			    	sessionID = session.getId() + "db";
			    	db = (Database)session.getAttribute( sessionID );
					PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
					VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
					VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
                    query = "select vtc_id_distr, vtc_nom_distr "+
						    "from VTC.TBL_VTC_CAT_DISTRIBUIDOR@LG_PMTU_PMTWEB_IFO2_VTC";
					db.setQuerySelect( query );
					db.executeQuerySelect();
					cbValues = db.getRSColsData();
					//String []consol= new String[2];
					//consol[0]="-1";
					//consol[1]="Todas los Distribuidores";
					//cbValues.add(consol);
			    }
			    catch (Exception ex) 
			    {
			      throw new WellException("com.wellcom.prosa.sacii.getBancoAdqEmiConsol: " + ex.toString());
			    }
			    return cbValues;
			}
			
			public ArrayList getDistribuidorMantenimiento(HttpSession session) throws WellException
			{
				HttpServletRequest request = null;
				String sessionID;
				Database db;
				String PRSA_ENTIDADES;
				String VW_BUS_ACQ;
				String VW_BUS_EMI;
				ArrayList cbValues;
			    try {
			    	sessionID = session.getId() + "db";
			    	db = (Database)session.getAttribute( sessionID );
					PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
					VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
					VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
					query = "select vtc_id_distr, vtc_nom_distr "+
						    "from VTC.TBL_VTC_CAT_DISTRIBUIDOR@LG_PMTU_PMTWEB_IFO2_VTC";
			        db.setQuerySelect( query );
			        db.executeQuerySelect();
			        cbValues = db.getRSColsData();
			    }
			    catch (Exception ex) 
			    {
			      throw new WellException("com.wellcom.prosa.sacii.getBancoAdqEmiConsol: " + ex.toString());
			    }
			    return cbValues;
			}
			
/* Modificacion: Marca de Fin SAS-JAGG-Z-02-2675-12 */

	/*    Modificación: Marca INICIO   P-53-2934-14 SAS -LMRV */
		/* ---------------------------------------------------------*/
/* Modificacion: Marca de inicio    SAS-JPM P-53-2934-14  */

	public ArrayList getMarcasRLN(HttpSession session) throws WellException {
		String sessionID;
		Database db;
		ArrayList cbValues;
				
		try {
			sessionID = session.getId() + "db";
			db = (Database)session.getAttribute( sessionID );
			query = "SELECT MARCA, DESCRIPCION " 
					+"FROM PMADMIN.PRSA_MARCA WHERE MARCA IN (1,2,3,99,999) "
					+"ORDER BY MARCA ASC";
			db.setQuerySelect(query);
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
			String []consol= new String[2];
			consol[0]="1,2,3,99,999";
			consol[1]="TODAS LAS MARCAS";
			cbValues.add(consol);
		} catch (Exception ex) {
			      throw new WellException("com.wellcom.prosa.sacii.getMarcasRLN: " + ex.toString());
		}
		return cbValues;
	}
		/*  Modificación: Marca FIN   P-53-2934-14 SAS -LMRV       */
	/* ---------------------------------------------------------*/
	public ArrayList getLiqEGLCL(HttpSession session) throws WellException {
		String sessionID;
		Database db;
		ArrayList cbValues;
				
		try {
			sessionID = session.getId() + "db";
			db = (Database)session.getAttribute( sessionID );
			query = "SELECT NUMERO, DESCRIPCION " 
					+"FROM PMADMIN.PRSA_TIPOS_LIQUIDACION WHERE NUMERO IN(1,2,3) "
					+"ORDER BY NUMERO ASC";
			db.setQuerySelect(query);
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
			String []consol= new String[2];
			consol[0]="1,2,3";
			consol[1]="TODAS LAS LIQUIDACIONES";
			cbValues.add(consol);
		} catch (Exception ex) {
			      throw new WellException("com.wellcom.prosa.sacii.getMarcasRLN: " + ex.toString());
		}
		return cbValues;
	}
	

	/*     Modificación: Marca INICIO   P-53-2934-14 SAS -LMRV  */ 
	/* ---------------------------------------------------------*/	
	public ArrayList getEntidadesRLN(HttpSession session, String tipo) throws WellException {
		String sessionID;
		Database db;
		ArrayList cbValues;
		
		try {
			sessionID = session.getId() + "db";
			db = (Database)session.getAttribute( sessionID );
			if(tipo.equals("INTERRED"))
				query = "SELECT NUMERO_PROSA, (NUMERO_PROSA || ' ' || DESCRIPCION) ENTIDADES "
							+"FROM PMADMIN.PRSA_ENTIDADES "
							+"WHERE TIE_NUMERO = 2 "
							+" AND NUMERO_FIID NOT LIKE 'U%' " 
                            +" AND DESCRIPCION NOT LIKE '%DOLARES%'";
			else if(tipo.equals("POS"))
				query = "SELECT NUMERO_PROSA, (NUMERO_PROSA || ' ' || DESCRIPCION) ENTIDADES "
							+"FROM PMADMIN.PRSA_ENTIDADES "
							+"WHERE TIE_NUMERO != 2 "
							+" AND NUMERO_FIID NOT LIKE 'U%' " 
                            +" AND DESCRIPCION NOT LIKE '%DOLARES%' "
							+"AND BANCO_SOCIO = 'S' "
							+"ORDER BY 1";
			else if(tipo.equals("TODOS"))
				query = "SELECT NUMERO_PROSA, (NUMERO_PROSA || ' ' || DESCRIPCION) ENTIDADES "
							+"FROM PMADMIN.PRSA_ENTIDADES "
							+" AND NUMERO_FIID NOT LIKE 'U%' " 
                            +" AND DESCRIPCION NOT LIKE '%DOLARES%'";							
			db.setQuerySelect(query);
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
			String []consol= new String[2];
			consol[0]="-1";
			consol[1]="TODOS LOS BANCOS";
			cbValues.add(consol);
		} catch (Exception ex) {
			      throw new WellException("com.wellcom.prosa.sacii.getEntidadesRLN: " + ex.toString());
		}
		return cbValues;
	}
		/*     Modificación: Marca FIN P-53-2934-14 SAS -LMRV       */ 
	/* ---------------------------------------------------------*/
	public String getMarcasCaratula(HttpSession session, String idMarcas) throws WellException  {
		String sessionID;
		Database db;
		ArrayList cbValues;
		String value = "";
		try {
			sessionID = session.getId() + "db";
			db = (Database)session.getAttribute( sessionID );
			query = "SELECT MARCA, DESCRIPCION " 
					+"FROM PMADMIN.PRSA_MARCA WHERE MARCA IN ("+idMarcas+") "
					+"ORDER BY MARCA ASC";				
			db.setQuerySelect(query);
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
			for(Object obj : cbValues) {
				String arrVal[] = (String[]) obj;
				value += arrVal[1].trim() + ", ";
			}
		} catch (Exception ex) {
			      throw new WellException("com.wellcom.prosa.sacii.getMarcasCaratula: " + ex.toString());
		}
		return value.substring(0, value.length() - 2);
	}
	public String getLiquidacionCaratula(HttpSession session, String idLiquidacion) throws WellException  {
	String sessionID;
	Database db;
	ArrayList cbValues;
	String value = "";
	try {
		sessionID = session.getId() + "db";
		db = (Database)session.getAttribute( sessionID );
		query = "select NUMERO, DESCRIPCION " 
				+"FROM PMADMIN.PRSA_TIPOS_LIQUIDACION WHERE NUMERO IN ("+idLiquidacion+") "
				+"ORDER BY NUMERO ASC";				
		db.setQuerySelect(query);
		db.executeQuerySelect();
		cbValues = db.getRSColsData();
		for(Object obj : cbValues) {
			String arrVal[] = (String[]) obj;
			value += arrVal[1].trim() + ", ";
		}
	} catch (Exception ex) {
			  throw new WellException("com.wellcom.prosa.sacii.getLiquidacionCaratula: " + ex.toString());
	}
	return value.substring(0, value.length() - 2);
	}
/* Modificacion: Marca de fin  SAS-JPM P-53-2934-14 */
	
	public ArrayList getTipo(HttpSession session){
		ArrayList cbValues=new ArrayList(2);
		String[] a=new String[2] ;
		String[] b=new String[2] ;
		String[] c=new String[2] ;
		a[0]="ICBS";	
		a[1]="REPORTES DE ICBS";
		b[0]="SAC1";	
		b[1]="REPORTES DE EP1,EP2,VISA";
		c[0]="VSA1";	
		c[1]="REPORTES DEGRADADAS (TC40)";
		cbValues.add(a);
		cbValues.add(b);
		cbValues.add(c);
		return cbValues;
	}

	public ArrayList getLiq(HttpSession session){
		ArrayList cbValues=new ArrayList(2);
		String[] a=new String[2] ;
		String[] b=new String[2] ;
		a[0]="VISA";	
		a[1]="94 VISA";
		b[0]="BNET','MDS";	
		b[1]="98 MASTERCARD";
		cbValues.add(a);
		cbValues.add(b);
		return cbValues;
	}


	public ArrayList getLiquidacionxBcoAdq(HttpSession session, String bancoAdq) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ARCHIVOS;
		ArrayList cbValues;
		
		try
		{
			sessionID = session.getId() + "db";
			db = (Database)session.getAttribute( sessionID );
			
			query = 
				" SELECT DISTINCT " +
				//" SN.NSI_CLR_ID LIQ "+
				//"   ,CASE  "+
				//"     WHEN SN.NSI_CLR_ID IN (25,31,53,52,54,28,29) THEN 'LIQUIDACION MERCADOS INTERNACIONALES' "+
				//"     ELSE SNCI.NCI_NSI_CLR_D "+
				//"   END LIQ_DES "+
				" SNCI.NCI_NSI_CLR_ID N, "+
		    	" SNCI.NCI_NSI_CLR_D  D "+
				" FROM SETTLEMENT.SZ_B4_CONV_NSI SBCN "+
				" INNER JOIN PMADMIN.VW_BUS_ACQ VBA "+
				" ON SBCN.CNSI_BU = VBA.BU_TX_ADQ "+
				" INNER JOIN SETTLEMENT.SV_NSI SN "+
				" ON SBCN.CNSI_NSI = SN.NSI_ID "+
				" INNER JOIN PMADMIN.SV_NSI_CLR_ID SNCI "+
				" ON SNCI.NCI_NSI_CLR_ID = SN.NSI_CLR_ID "+
				" WHERE VBA.NUMERO_PROSA IN ("+bancoAdq+") "+
				" AND SN.NSI_CLR_ID NOT IN (1,2,55)";
			
			
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
		}
		catch(Exception ex)
		{
			throw new WellException(
				"com.wellcom.prosa.sacii.getLiquidacionxBcoAdq: "
				+ex.toString());
		}
		return cbValues;
 	}

//  -----------------------------------------------------------------------------------//
//  -- Marca del Cambio : WELL-EMQ-P-06-2233-13 Inicia la Modificacion   10/11/2014   -//
//  -----------------------------------------------------------------------------------//

	public ArrayList getArchivoAdqCorresponsal(HttpSession session, String bancoAdq) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;		
		ArrayList cbValues;
		
		try
		{
			sessionID = session.getId() + "db";
			db = (Database)session.getAttribute( sessionID );
			
			query = " SELECT DISTINCT PBA.BA_NUM_ARCH, PBA.BA_NUM_ARCH||' '||PA.DESCRIPCION "+
				" FROM SSP.PRSA_BITACORA_ARCHIVOS@LG_PMTU_PMTWEB_IFO2_SSP PBA "+
				" INNER JOIN SSP.PRSA_ARCHIVOS@LG_PMTU_PMTWEB_IFO2_SSP PA "+
				" 	ON PA.NUMERO = PBA.BA_NUM_ARCH "+
				" WHERE PBA.BA_ENT_ADQ = "+bancoAdq+" "+
				" 	AND PBA.BA_T_ARCH = 'I' "+
				" ORDER BY 1 ";
			
			System.out.println("Fuente :"+ query +":");
			
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
		}
		catch(Exception ex)
		{
			throw new WellException(
				"com.wellcom.prosa.sacii.getArchivoAdq2: "
				+ex.toString());
		}
		return cbValues;
 	}

	public ArrayList getArchivoBinCorresponsal(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;		
		ArrayList cbValues;
		
		try
		{
			sessionID = session.getId() + "db";
			db = (Database)session.getAttribute( sessionID );
			
			query = " SELECT DISTINCT PTA.PREF_NUMERO pref "+
                    "       ,PTA.PREF_NUMERO pref2 "+
                    " FROM SSP.PRSA_TXN_ACEPTADAS@LG_PMTU_PMTWEB_IFO2_SSP PTA "+
				    " ORDER BY 1 ";

			System.out.println("Fuente :"+ query +":");
			
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
			
		}
		catch(Exception ex)
		{
			throw new WellException(
				"com.wellcom.prosa.sacii.getArchivoBin: "
				+ex.toString());
		}
		return cbValues;
 	}

	public ArrayList getLiquidacionCorresponsal(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ARCHIVOS;
		ArrayList cbValues;
		
		try
		{
			sessionID = session.getId() + "db";
			db = (Database)session.getAttribute( sessionID );
			
			query = " SELECT '60' NUM, '60'||' '||'LIQUIDACION CORRESPONSAL' FROM DUAL ";
			
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
		}
		catch(Exception ex)
		{
			throw new WellException(
				"com.wellcom.prosa.sacii.getLiquidacionxBcoAdq: "
				+ex.toString());
		}
		return cbValues;
 	}

	public ArrayList getTrxsCorresponsal(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		ArrayList cbValues;
		
	    try 
	    {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			query = " SELECT '50' NUM, '50 '||'PAGOS A TARJETA DE CREDITO' DESCR FROM DUAL "+
					" UNION ALL "+
					" SELECT '51' NUM, '51 '||'DEPOSITOS A CUENTAS' DESCR FROM DUAL ";
	
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getGrupoTrxsCorresponsal: " + ex.toString());
	    }
		return cbValues;
	}

	public ArrayList getTipoLiqCorresponsal(HttpSession session){
		ArrayList cbValues=new ArrayList(5);
		String[] circuitoLocal=new String[2] ;
		String[] entrante=new String[2] ;
		String[] saliente=new String[2] ;
		String[] interred=new String[2] ;
		String[] visaMasterCard=new String[2] ;
		String[] corresponsal=new String[2] ;
		circuitoLocal[0]="22";
		circuitoLocal[1]="Liquidación Circuito Local";
		entrante[0]="32";
		entrante[1]="Liquidación Entrante";
		saliente[0]="33";
		saliente[1]="Liquidación Saliente";
		interred[0]="26";
		interred[1]="Liquidación Interredes";
		visaMasterCard[0]="6";
		visaMasterCard[1]="Liquidación Visa y Mastercard";
		corresponsal[0]="60";
		corresponsal[1]="Liquidación Corresponsal";
		cbValues.add(circuitoLocal);
		cbValues.add(entrante);
		cbValues.add(saliente);
		cbValues.add(interred);
		cbValues.add(visaMasterCard);
		cbValues.add(corresponsal);
		return cbValues;
	}

		public ArrayList getBancoAdqSinDolNal(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
			String tipo=session.getAttribute("tipo")==null?"":(String)session.getAttribute("tipo");
			query ="select distinct tblExt.entidad_padre, (tblExt.entidad_padre || ' ' || pe.descripcion  || ' ' || bu_tx_parent) descripcion "+
                   " FROM pmadmin.VW_BUS_ACQ tblExt join pmadmin.prsa_entidades pe on pe.numero_prosa=tblExt.entidad_padre ";
			
			if(role.equals("banco")||tipo.equals("emi"))
			{
				if(tipo.equals("emi")){
					query += " where tblExt.entidad_padre = pe.numero_prosa and tblExt.tie_numero not in (8,9) and tblExt.tie_numero not between 10 and 20 "; 	
				}else{
					String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
					query += " where tblExt.entidad_padre  in (" + numerosProsa + ") and tblExt.tie_numero not in (8,9) and tblExt.tie_numero not between 10 and 20 ";
					
				}
			}
			
			else 
			{
				query += " where tblExt.entidad_padre = tblExt.numero_prosa and tblExt.tie_numero not in (8,9) and tblExt.tie_numero not between 10 and 20 "; 	
			}
				query += "\n order by 1";
				
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoAdq: " + ex.toString());
	    }
		return cbValues;
	}

//  -----------------------------------------------------------------------------------//
//  -- Marca del Cambio : WELL-EMQ-P-06-2233-14 Finaliza la Modificacion   14/04/2014 -//
//  -----------------------------------------------------------------------------------//


	public ArrayList getLiquidacionxBcoEmi(HttpSession session, String bancoEmi) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ARCHIVOS;
		ArrayList cbValues;
		
		try
		{
			sessionID = session.getId() + "db";
			db = (Database)session.getAttribute( sessionID );
			
			query = 
				" SELECT DISTINCT " +
				" SNCI.NCI_NSI_CLR_ID N, "+
		    	" SNCI.NCI_NSI_CLR_D  D "+
				" FROM SETTLEMENT.SZ_B4_CONV_NSI SBCN "+
				" INNER JOIN PMADMIN.VW_BUS_EMI VBE "+
				" ON SBCN.CNSI_BU_ALT = VBE.BU_TX_ISS "+
				" INNER JOIN SETTLEMENT.SV_NSI SN "+
				" ON SBCN.CNSI_NSI = SN.NSI_ID "+
				" INNER JOIN PMADMIN.SV_NSI_CLR_ID SNCI "+
				" ON SNCI.NCI_NSI_CLR_ID = SN.NSI_CLR_ID "+
				" WHERE VBE.NUMERO_PROSA IN ("+bancoEmi+") "+
				" AND SN.NSI_CLR_ID NOT IN (1,2,55)";
			
			
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
		}
		catch(Exception ex)
		{
			throw new WellException(
				"com.wellcom.prosa.sacii.getLiquidacionxBcoEmi: "
				+ex.toString());
		}
		return cbValues;
 	}


	
	public ArrayList getES(HttpSession session, String num) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		String nume;
		Database db;		
		nume=num;
		ArrayList cbValues=new ArrayList(2);
		
		if (nume.equals("774"))
		{			
			String[] invalido=new String[2] ;
			String[] valido=new String[2] ;
			invalido[0]="E";	
			invalido[1]="Prosa";
			valido[0]="S";	
			valido[1]="Banco";
			cbValues.add(invalido);
			cbValues.add(valido);
			return cbValues;
		}	
		else
		{
			String[] invalido=new String[2] ;		
			invalido[0]="A";	
			invalido[1]="    ";
			cbValues.add(invalido);			
			return cbValues;
		}		
	}
	
	
	
	public ArrayList getEmiAdq(HttpSession session){
		ArrayList cbValues=new ArrayList(2);
		String[] bco1=new String[2] ;
		String[] bco2=new String[2] ;
		bco1[0]="ADQ";	
		bco1[1]="918 Adquirente Prosa";
		bco2[0]="EMI";	
		bco2[1]="945 Emisor Prosa";
		cbValues.add(bco1);
		cbValues.add(bco2);
		return cbValues;
	}
	
	public ArrayList getTipMoneda(HttpSession session){
		ArrayList cbValues=new ArrayList(2);
		String[] mon1=new String[2] ;
		String[] mon2=new String[2] ;
		mon1[0]="0";	
		mon1[1]="0 Dolares";
		mon2[0]="1";	
		mon2[1]="1 Nacional";
		cbValues.add(mon1);
		cbValues.add(mon2);
		return cbValues;
	}
	
	public ArrayList getEmiAdq2(HttpSession session){
		ArrayList cbValues=new ArrayList(2);
		String[] bco1=new String[2] ;
		String[] bco2=new String[2] ;
		bco1[0]="ADQ";	
		bco1[1]="BANCO";
		bco2[0]="EMI";	
		bco2[1]="PROSA";
		cbValues.add(bco1);
		cbValues.add(bco2);
		return cbValues;
	}
	
	public ArrayList getEmiAdq3(HttpSession session){
		ArrayList cbValues=new ArrayList(2);
		String[] bco1=new String[2] ;
		String[] bco2=new String[2] ;
		bco1[0]="ADQ";	
		bco1[1]="Adquirente";
		bco2[0]="EMI";	
		bco2[1]="Emisor";
		cbValues.add(bco1);
		cbValues.add(bco2);
		return cbValues;
	}
	
	public ArrayList getIca(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;		
		Database db;
		String CD_TXN_CD;
		ArrayList cbValues;		
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	
		    		query ="SELECT DISTINCT ICA FROM SUPERSIC.PREFIJOS_INTERNACIONALES@LG_PMTU_SIC WHERE TRIM(ICA) IS NOT NULL ORDER BY ICA ";
					
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) {
		      throw new WellException(
		        "com.wellcom.prosa.sacii.getIca: "
		        + ex.toString());
		    }	 
		return cbValues;
	}

	public ArrayList getIca2(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;		
		Database db;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		String PRSA_ENTIDADES;
		ArrayList cbValues;		
		
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
		    	VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
		    	PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
				role = (String)session.getAttribute("role");
				numFiid = (String)session.getAttribute("numFiid");
				fiid = (String)session.getAttribute("fiid");
				login = (String)session.getAttribute("login");
				
				String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
				
					query = " SELECT MM.MCM_MBR_ID ICA_RECEPTOR, MM.MCM_MBR_ID||' '||VB.DESCRIPCION ICAS "+
					" FROM IPM.MC_MBR MM "+
					" INNER JOIN ( "+
					" SELECT BU_TX_ADQ, DESCRIPCION, NUMERO_PROSA FROM PMADMIN.VW_BUS_ACQ WHERE TIE_NUMERO = 9 "+
					" UNION "+
					" SELECT BU_TX_ISS, DESCRIPCION, NUMERO_PROSA FROM PMADMIN.VW_BUS_EMI WHERE TIE_NUMERO = 9) VB "+
					" ON VB.BU_TX_ADQ = MM.MCM_BU ";					
				
				if(role.equals("banco")){
					query += " WHERE VB.NUMERO_PROSA IN ("+numerosProsa+") ";
				}
				
				query += " ORDER BY 1";
		    	
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) 
		    {
		      throw new WellException("com.wellcom.prosa.sacii.comboBoxIca2: " + ex.toString());
		    }	 
		return cbValues;
	}
	
	public ArrayList getComercioBu(HttpSession session, String num) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		String nume;
		Database db;
		String CD_TXN_CD;
		ArrayList cbValues;
		nume=num;
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	
		    		query ="SELECT DISTINCT CPT.PT_RTLR_ID, CPT.PT_RTLR_ID FROM CORE.CZ_PRCD_TXN CPT WHERE CPT.PT_ACQ_BU IN ("+nume+")";
					
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) {
		      throw new WellException(
		        "com.wellcom.prosa.sacii.getComercioBu: "
		        + ex.toString());
		    }	 
		return cbValues;
	}

	public ArrayList getRechazo(HttpSession session, String banco, String initDate) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;		
		Database db;		
		ArrayList cbValues;		
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	
		    	query = " SELECT DISTINCT PRT.PRT_TXT_MSG_BMXR, "+
		    		" DECODE(TRIM(PRT.PRT_TXT_MSG_BMXR),'REVERSOS CON ORIGINAL','REVERSOS CON ORIGINAL' "+
		    		// CAMBIO POR EMMA 30/08/2011 SE CAMBIO LA LEYENDA 
		    		//"                            ,'REVERSOS SIN VENTA O DISPOSICION ASOCIADA','02 - REVERSOS SIN ORIGINAL' "+
		    		"                            ,'REVERSOS SIN ORIGINAL','REVERSOS SIN ORIGINAL' "+
		    		// FIN CAMBIO POR EMMA 30/08/2011 SE CAMBIO LA LEYENDA 
		    		"                              ,'CANCELACIONES CON ORIGINAL','CANCELACIONES CON ORIGINAL' "+
		    		"                              ,'AJUSTES DE VENTA/DEVOLUCIÓN SIN ORIGINAL','AJUSTES SIN ORIGINAL' "+
		    		"                              ,'DUPLICADAS EN 4 CAMPOS','DUPLICADAS EN CUATRO CAMPOS' "+
		    		"                              ,'DUPLICADAS EN 5 CAMPOS','DUPLICADAS EN CINCO CAMPOS' "+
		    		"                              ,'EL IMPORTE TOTAL DE LA TRANSACCION DEBE SER MAYOR QUE CERO','TRANSACCIONES CON IMPORTE 0' "+
		    		"                              ,'DEVOLUCIÓN SOSPECHOSA','DEVOLUCIÓN SOSPECHOSA' "+
		    		"                              ,'TRANSACCION EXTEMPORANEA','TRANSACCION EXTEMPORANEA DE PTLF' "+
		    		"                              ,'RECHAZO DE TRANSACCIONES MILLONARIAS','TRANSACCIONES MILLONARIAS' "+
		    		"                              ,TRIM(PRT.PRT_TXT_MSG_BMXR)) X "+ 
		    		" FROM PMADMIN.PRSA_REJECTED_TXN PRT "+ 
		    		" WHERE TRIM(PRT.PRT_TXT_MSG_BMXR) IS NOT NULL "+
		    		" AND PRT.PRT_PROC_DTE = TO_DATE('"+initDate+"','DD/MM/YYYY') "+
            //" AND (PRT.PRT_PROSA_ISS_ENTITY IN ("+banco+") OR PRT.PRT_PROSA_ACQ_ENTITY IN ("+banco+")) "+
		    		" AND RTRIM(PRT.PRT_REJ_RSN) IN ( "+ 
		    		" 'VAL-00032',  "+
		    		" 'VAL-00051',  "+
		    		" 'VAL-00052',  "+
		    		" 'VAL-00059',  "+
		    		" 'VAL-00060',  "+
		    		" 'VAL-00061',  "+
		    		" 'VAL-00062',  "+
		    		" 'VAL-00069',  "+
		    		" 'VAL-00071',  "+
		    		" 'VAL-00072',  "+
		    		" 'VAL-00075',  "+
		    		" 'VAL-00076',  "+
		    		" 'VAL-00077',  "+
		    		" 'VAL-00100',  "+
		    		" 'VAL-00105',  "+
		    		" 'VAL-00106',  "+
		    		" 'VAL-00107', "+
		    		" 'VAL-00108', "+ 
		    		" 'VAL-00109', "+
		    		" 'VAL-PTLF','VAL-00001') "+
		    		" ORDER BY 2 ";		    		
					
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) {
		      throw new WellException(
		        "com.wellcom.prosa.sacii.getRechazo: "
		        + ex.toString());
		    }	 
		return cbValues;
	}

	
/*----------------------------------------------------------------------------*/
/*Marca del Cambio :  AXIA-AHH-P-40-2187-15 Inicia  la Modificacion 30/08/2016*/
/*----------------------------------------------------------------------------*/
	public ArrayList getCiclo(HttpSession session, String num) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		String nume;
		Database db;
		String CD_TXN_CD;
		ArrayList cbValues;
		nume=num;
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	
		    	if (num.equals("A"))
		    	{
					query ="select 1 from dual union select 2 from dual union select 3 from dual union select 4 from dual union select 5 from dual union select 6 from dual";
		    	}
				else if (num.equals("B"))
				{
					query ="select 101 from dual union select 102 from dual union select 103 from dual union select 104 from dual union select 105 from dual";
				}
				else if (num.equals("C"))
		    	{
					query ="select 1 from dual union select 2 from dual ";
		    	}
					
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) {
		      throw new WellException(
		        "com.wellcom.prosa.sacii.getCiclo: "
		        + ex.toString());
		    }	 
		return cbValues;
	}
/*----------------------------------------------------------------------------*/
/*Marca del Cambio :  AXIA-AHH-P-40-2187-15 Termina la Modificacion 30/08/2016*/
/*----------------------------------------------------------------------------*/
	
	public ArrayList getMCVS(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		String nume;
		Database db;
		String CD_TXN_CD;
		ArrayList cbValues;
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	
					query ="SELECT VBA.NUMERO_PROSA, VBA.NUMERO_PROSA||' '||VBA.DESCRIPCION FROM PMADMIN.VW_BUS_ACQ VBA WHERE VBA.BU_TX_PARENT = 41";
					
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) {
		      throw new WellException(
		        "com.wellcom.prosa.sacii.getMCVS: "
		        + ex.toString());
		    }	 
		return cbValues;
	}
	
	public ArrayList getTipoTrxsVenDev(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_TIPOS_TRANSACCION;
		ArrayList cbValues;
		
	    try 
	    {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
	    	PRSA_TIPOS_TRANSACCION = (String)session.getAttribute( "PRSA_TIPOS_TRANSACCION" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");

			query = " select numero,(numero || ' ' || descripcion) descripcion  " 
// Inicia cambio wellcom 07-08-2014 P-54-2452-14 
			      //+ " from " + PRSA_TIPOS_TRANSACCION
			      + " from PMADMIN.PRSA_TIPOS_TRANSACCION "
// Fin cambio wellcom 07-08-2014 P-54-2452-14 
		          + " WHERE numero in(1,21) "
			      +" order by numero";
	
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getTipoTrxs: " + ex.toString());
	    }
		return cbValues;
	}
	
	public ArrayList getTipoTrxsMisc(HttpSession session) throws WellException
	{
		ArrayList cbValues=new ArrayList(2);
		String[] misc1=new String[2] ;
		String[] misc2=new String[2] ;
		misc1[0]="10";	
		misc1[1]="10 MISCELANEOS (EN CONTRA)";
		misc2[0]="20";	
		misc2[1]="20 MISCELANEOS (A FAVOR)";
		cbValues.add(misc1);
		cbValues.add(misc2);
		return cbValues;
		
	    
	}
	
	
	public ArrayList getDetallesn(HttpSession session){
		ArrayList cbValues=new ArrayList(2);
		String[] si=new String[2] ;
		String[] no=new String[2] ;
		si[0]="S";	
		si[1]="Si";
		no[0]="N";	
		no[1]="No";
		cbValues.add(si);
		cbValues.add(no);
		return cbValues;
	}
	
	public ArrayList getPTLFPapel(HttpSession session){
		ArrayList cbValues=new ArrayList(2);
		String[] ptlf=new String[2] ;
		String[] papel=new String[2] ;
		ptlf[0]="5";	
		ptlf[1]="PTLF";
		papel[0]="'Papel'";	
		papel[1]="Fuentes Papel";
		cbValues.add(ptlf);
		cbValues.add(papel);
		return cbValues;
	}
	
	
	
	public ArrayList getLimpio(HttpSession session){
		ArrayList cbValues=new ArrayList(2);
		String[] limpio=new String[2] ;		
		limpio[0]=null;	
		limpio[1]="Todo(a)s";
		cbValues.add(limpio);		
		return cbValues;
	}
	
	public ArrayList getBancoBuAdq(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ARCHIVOS;
		ArrayList cbValues;
		
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	role = (String)session.getAttribute("role");
				numFiid = (String)session.getAttribute("numFiid");
				fiid = (String)session.getAttribute("fiid");
				login = (String)session.getAttribute("login");
		    	
		    	String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
				if (role.equals("banco"))
				{
					query = " SELECT VBA.NUMERO_PROSA, (VBA.NUMERO_PROSA||' '||VBA.DESCRIPCION||' '|| VBA.BU_TX_PARENT) BANCO " +
							" FROM PMADMIN.VW_BUS_ACQ VBA " +
					        " WHERE NUMERO_PROSA IN ("+numerosProsa+") "+
					        " ORDER BY 1 ";
					 				
				}
				else
				{
					query = " SELECT VBA.NUMERO_PROSA, (VBA.NUMERO_PROSA||' '||VBA.DESCRIPCION||' '|| VBA.BU_TX_PARENT) banco " +
							" FROM PMADMIN.VW_BUS_ACQ VBA " +
					        " ORDER BY 1 ";
					
				}
				
				
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) {
		      throw new WellException(
		        "com.wellcom.prosa.sacii.getBancoBuAdq: "
		        + ex.toString());
		    }	 
		return cbValues;
	}
	
	public ArrayList getBancosBU(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ARCHIVOS;
		ArrayList cbValues;
		
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	role = (String)session.getAttribute("role");
				numFiid = (String)session.getAttribute("numFiid");
				fiid = (String)session.getAttribute("fiid");
				login = (String)session.getAttribute("login");
		    	
				
					query = "SELECT * FROM ( "+
					  " SELECT BU, TIPO FROM ( "+
						" SELECT VBA.BU_TX_ADQ BU, "+
						" CASE "+
						"    WHEN VBA.BU_TX_ADQ = 1033 THEN '1031 EMISOR DOLARES' "+
						"    ELSE VBA.ENTIDAD_PADRE||' '||VBA.DESCRIPCION "+
						" END TIPO "+
						" FROM PMADMIN.VW_BUS_ACQ VBA ";
					    if ("nvoTC".equals((String)session.getAttribute("accion"))){
					    query +=" WHERE VBA.ENTIDAD_PADRE IN (31,194,230,694,1031,10001) ";
					    }else{
					    query +=" WHERE VBA.ENTIDAD_PADRE IN (31,94,98,194,230,694,1031,10001) ";	
					    }
						query+=" UNION "+
						" SELECT 194, '194 PROSA LIQUIDACION' FROM DUAL "+
						" UNION "+
						" SELECT 230, '230 DIARIO OFICIAL' FROM DUAL) "+
						" ORDER BY 2 "+
						")";
					if(role.equals("banco")){
						query += " WHERE BU IN (196,211) ";
					}

					
				
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) {
		      throw new WellException(
		        "com.wellcom.prosa.sacii.getBancoBU: "
		        + ex.toString());
		    }	 
		return cbValues;
	}
	
	public ArrayList getTipoTrxs(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_TIPOS_TRANSACCION;
		ArrayList cbValues;
		
	    try 
	    {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
	    	PRSA_TIPOS_TRANSACCION = (String)session.getAttribute( "PRSA_TIPOS_TRANSACCION" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");

			query = " select numero,(numero || ' ' || descripcion) descripcion  " 
			      + " from PMADMIN.PRSA_TIPOS_TRANSACCION"
		          + " WHERE numero not in(101,999) "
			      +" order by numero";
	
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getTipoTrxs: " + ex.toString());
	    }
		return cbValues;
	}
	
	public ArrayList getTipoTrxs2(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_TIPOS_TRANSACCION;
		ArrayList cbValues;
		
	    try 
	    {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
	    	PRSA_TIPOS_TRANSACCION = (String)session.getAttribute( "PRSA_TIPOS_TRANSACCION" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");

			query = " select numero,(numero || ' ' || descripcion) descripcion  " 
			      + " from PMADMIN.PRSA_TIPOS_TRANSACCION"
		          + " WHERE numero in (1,2,20,21) "
			      +" order by numero";
	
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getTipoTrxs2: " + ex.toString());
	    }
		return cbValues;
	}

	public ArrayList getTipoTrxs(HttpSession session,String tiposTxn) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_TIPOS_TRANSACCION;
		ArrayList cbValues;
		
	    try 
	    {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
	    	PRSA_TIPOS_TRANSACCION = (String)session.getAttribute( "PRSA_TIPOS_TRANSACCION" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");

			query = " select numero,(numero || ' ' || descripcion) descripcion  " 
			      + " from " + PRSA_TIPOS_TRANSACCION
		          + " WHERE numero in("+tiposTxn+") "
			      +" order by numero";
	
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getTipoTrxs: " + ex.toString());
	    }
		return cbValues;
	}
	
	public ArrayList getTipoTrxsTodos(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_TIPOS_TRANSACCION;
		ArrayList cbValues;
		
	    try 
	    {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
	    	PRSA_TIPOS_TRANSACCION = (String)session.getAttribute( "PRSA_TIPOS_TRANSACCION" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");

			query = " select numero, (numero||' '||descripcion)  " 
			      + " from  PMADMIN.PRSA_TIPOS_TRANSACCION " +
			      		"where numero not in (999)" +
			      		"order by 1 ";
	
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getTipoTrxs: " + ex.toString());
	    }
		return cbValues;
	}

	public ArrayList getClvmoneda(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		ArrayList cbValues=new ArrayList();
	    try {
	    	
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			query=" SELECT CRNCY_CD, CRNCY_D||' '||CRNCY_CD FROM CORE.CZ_CRNCY_CD WHERE CRNCY_ALPHA IN ('USD','MXN') ORDER BY 2 ";
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getClvmoneda: " + ex.toString());
	    }
		return cbValues;
	}
	
	public ArrayList getArchivo(HttpSession session, String initDate, String endDate) throws WellException
	{

		System.out.println("Entraste");
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_CIFRAS_CTRL;
		String PRSA_BITACORA_ARCHIVOS;
		String dinamicWhere="where";
		ArrayList cbValues;
		
	    try 
	    {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	    	String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
	    	role = (String)session.getAttribute("role");
	        //PRSA_CIFRAS_CTRL = (String)session.getAttribute( "PRSA_CIFRAS_CTRL" );
	    	PRSA_BITACORA_ARCHIVOS = (String)session.getAttribute( "PRSA_BITACORA_ARCHIVOS" );
	    	
	    	if (role.equals("banco"))
    		{
    			query = "SELECT DISTINCT DECODE(BA.BA_NUM_ARCH,1005,'1'||TRIM(BA.BA_ARCHIVO)||'.PROC',TRIM(BA.BA_ARCHIVO)||'.PROC') FROM PMADMIN.PRSA_BITACORA_ARCHIVOS BA " ;
    					
    			if (initDate != null && endDate != null)
    	    	{
    	    		query += " WHERE BA.BA_FCH_PROC BETWEEN TO_DATE('"+initDate+"','DD/MM/YYYY') AND TO_DATE('"+endDate+"','DD/MM/YYYY') " +
    	    				 " AND BA.BA_T_ARCH = 'I' "+
    	    				 " AND BA.BA_ENT_EMI IN ("+numerosProsa+") " +
    	    				 " ORDER BY 1" ;    	    		
    	    	}    					
    		}
	    	else {
	    	
	    	query = "SELECT DISTINCT DECODE(BA.BA_NUM_ARCH,1005,'1'||TRIM(BA.BA_ARCHIVO)||'.PROC',TRIM(BA.BA_ARCHIVO)||'.PROC') FROM PMADMIN.PRSA_BITACORA_ARCHIVOS BA" ;
	    	// CAMBIO PARA MIGRACION INTERREDES
			//" INNER JOIN PMADMIN.VW_BUS_ACQ VBA "+
            //" ON VBA.NUMERO_PROSA = BA.BA_ENT_ADQ "+
            //" AND VBA.TIE_NUMERO = 2 ";
            // FIN CAMBIO PARA MIGRACION INTERREDES		
	    	
	    	if (initDate != null && endDate != null)
	    	{
	    		query += " WHERE BA.BA_FCH_PROC BETWEEN TO_DATE('"+initDate+"','DD/MM/YYYY') AND TO_DATE('"+endDate+"','DD/MM/YYYY') " +	    		         
	    				 " AND BA.BA_T_ARCH = 'I' "+
	    		         " ORDER BY 1" ;
	    		
	    	}	
	    }
					
	     System.out.println("Valor db: " + query);
			db.setQuerySelect(query);
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getArchivo: " + ex.toString());
	    }
		return cbValues;
	}

	public ArrayList getBancoAdq(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
			String tipo=session.getAttribute("tipo")==null?"":(String)session.getAttribute("tipo");
			query ="select distinct tblExt.entidad_padre, (tblExt.entidad_padre || ' ' || pe.descripcion  || ' ' || bu_tx_parent) descripcion "+
                   " FROM pmadmin.VW_BUS_ACQ tblExt join pmadmin.prsa_entidades pe on pe.numero_prosa=tblExt.entidad_padre ";
			
			if(role.equals("banco")||tipo.equals("emi"))
			{
				if(tipo.equals("emi")){
					query += " where tblExt.entidad_padre = pe.numero_prosa  "; 	
				}else{
					String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
					query += " where tblExt.entidad_padre  in (" + numerosProsa + ") ";
					
				}
			}
			
			else 
			{
				query += " where tblExt.entidad_padre = tblExt.numero_prosa"; 	
			}
				query += "\n order by 1";
				
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoAdq: " + ex.toString());
	    }
		return cbValues;
	}
	
	public ArrayList getBancoAdqDet(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
			String tipo=session.getAttribute("tipo")==null?"":(String)session.getAttribute("tipo");
			query ="select distinct tblExt.numero_prosa, (tblExt.numero_prosa || ' ' || pe.descripcion  || ' ' || bu_tx_parent) descripcion "+
                   " FROM pmadmin.VW_BUS_ACQ tblExt join pmadmin.prsa_entidades pe on pe.numero_prosa=tblExt.numero_prosa ";
			
			if(role.equals("banco")||tipo.equals("emi"))
			{
				if(tipo.equals("emi")){
					query += " where tblExt.numero_prosa = pe.numero_prosa  "+
					" AND PE.NUMERO_PROSA NOT IN (SELECT DISTINCT VBA.ENTIDAD_PADRE FROM PMADMIN.VW_BUS_ACQ VBA WHERE VBA.TIE_NUMERO = 2 AND VBA.ENTIDAD_PADRE <> VBA.NUMERO_PROSA) ";
				}else{
					String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
					query += " where tblExt.entidad_padre  in (" + numerosProsa + ") "+
					" AND PE.NUMERO_PROSA NOT IN (SELECT DISTINCT VBA.ENTIDAD_PADRE FROM PMADMIN.VW_BUS_ACQ VBA WHERE VBA.TIE_NUMERO = 2 AND VBA.ENTIDAD_PADRE <> VBA.NUMERO_PROSA) ";
					
				}
			}
			
			else 
			{
				query += " where tblExt.numero_prosa = tblExt.numero_prosa"+
				" AND PE.NUMERO_PROSA NOT IN (SELECT DISTINCT VBA.ENTIDAD_PADRE FROM PMADMIN.VW_BUS_ACQ VBA WHERE VBA.TIE_NUMERO = 2 AND VBA.ENTIDAD_PADRE <> VBA.NUMERO_PROSA) ";
			}
				query += "\n order by 1";
				
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoAdqDet: " + ex.toString());
	    }
		return cbValues;
	}
	
	public ArrayList getBancosSinDol(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
			String tipo=session.getAttribute("tipo")==null?"":(String)session.getAttribute("tipo");
			query ="select distinct tblExt.entidad_padre, (tblExt.entidad_padre || ' ' || pe.descripcion  || ' ' || bu_tx_parent) descripcion "+
                   " FROM (SELECT * FROM pmadmin.VW_BUS_ACQ UNION SELECT * FROM PMADMIN.VW_BUS_EMI) tblExt join pmadmin.prsa_entidades pe on pe.numero_prosa=tblExt.entidad_padre ";
			
			if(role.equals("banco")||tipo.equals("emi"))
			{
				if(tipo.equals("emi")){
					query += " where tblExt.entidad_padre = pe.numero_prosa and tblExt.tie_numero<>9 "; 	
				}else{
					String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
					query += " where tblExt.entidad_padre  in (" + numerosProsa + ") and tblExt.tie_numero<>9 ";
					
				}
			}
			
			else 
			{
				query += " where tblExt.entidad_padre = tblExt.numero_prosa and tblExt.tie_numero<>9 "; 	
			}
				query += " and tblExt.bu_tx_parent not in (461,641) "+
				"\n order by 1";
				
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancosSinDol: " + ex.toString());
	    }
		return cbValues;
	}

	public ArrayList getBancoAdqSinDol(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
			String tipo=session.getAttribute("tipo")==null?"":(String)session.getAttribute("tipo");
			query ="select distinct tblExt.entidad_padre, (tblExt.entidad_padre || ' ' || pe.descripcion  || ' ' || bu_tx_parent) descripcion "+
                   " FROM pmadmin.VW_BUS_ACQ tblExt join pmadmin.prsa_entidades pe on pe.numero_prosa=tblExt.entidad_padre ";
			
			if(role.equals("banco")||tipo.equals("emi"))
			{
				if(tipo.equals("emi")){
					query += " where tblExt.entidad_padre = pe.numero_prosa and tblExt.tie_numero<>9 "; 	
				}else{
					String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
					query += " where tblExt.entidad_padre  in (" + numerosProsa + ") and tblExt.tie_numero<>9 ";
					
				}
			}
			
			else 
			{
				query += " where tblExt.entidad_padre = tblExt.numero_prosa and tblExt.tie_numero<>9 "; 	
			}
				query += "\n order by 1";
				
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoAdq: " + ex.toString());
	    }
		return cbValues;
	}
	
//----------------------------------------------------------------------------//
//--Marca del Cambio : AXIA-FJCC-P-53-2933-14 Inicia  Modificacion 05/07/2016-//
//----------------------------------------------------------------------------//
	public ArrayList getBancoAdqSinMer(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
			String tipo=session.getAttribute("tipo")==null?"":(String)session.getAttribute("tipo");
			
//          query ="SELECT ENTIDAD_PADRE, (NUMERO_PROSA || ' ' || DESCRIPCION) DESCRIPCION "
//                +"  FROM PMADMIN.PRSA_ENTIDADES "
//                +" WHERE TIE_NUMERO = 1 "
//                +"   AND NUMERO_FIID NOT LIKE 'U%' " 
//                +"   AND DESCRIPCION NOT LIKE '%DOLARES%' "
//                +"   AND DESCRIPCION NOT LIKE '%DCC%' "
//                +" ORDER BY 1";
            query ="select distinct tblExt.entidad_padre, (tblExt.entidad_padre || ' ' || pe.descripcion  || ' ' || bu_tx_parent) descripcion   "+
            "    FROM pmadmin.VW_BUS_ACQ tblExt join pmadmin.prsa_entidades pe on pe.numero_prosa=tblExt.entidad_padre    "+
            "    AND PE.TIE_NUMERO = 1    "+
            "    AND TBLEXT.NUMERO_FIID NOT LIKE 'M%'   "+
            "    AND TBLEXT.NUMERO_FIID NOT LIKE 'D%'   "+
            "    AND TBLEXT.NUMERO_FIID <> 'PEMD'   "+
            "    and TBLEXT.NUMERO_PROSA NOT IN ('4','9','31','31','31','94','682','694')   "+
            "    UNION    "+
            "    select distinct tblExt.entidad_padre, (tblExt.entidad_padre || ' ' || pe.descripcion  || ' ' || bu_tx_parent)   "+
            "    FROM pmadmin.VW_BUS_EMI tblExt join pmadmin.prsa_entidades pe on pe.numero_prosa=tblExt.entidad_padre    "+
            "    where PE.TIE_NUMERO = 1   "+
            "    AND TBLEXT.NUMERO_FIID NOT LIKE 'M%'   "+
            "    AND TBLEXT.NUMERO_FIID NOT LIKE 'U%'   "+
            "    and TBLEXT.NUMERO_FIID <> 'BAND'   "+
            "    and TBLEXT.NUMERO_PROSA NOT IN ('4','9','31','31','31','94','682','694')   ";
            
            
			if(role.equals("banco")||tipo.equals("emi"))
			{
					String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
					query += " AND tblExt.entidad_padre  in (" + numerosProsa + ") and tblExt.tie_numero not in (8,9,14,15,17,18) ";
			
			}
				query += "\n order by 1";
				
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoSinMer: " + ex.toString());
	    }
		return cbValues;
	}
//----------------------------------------------------------------------------//
//--Marca del Cambio : AXIA-FJCC-P-53-2933-14 Termina Modificacion 05/07/2016-//
//----------------------------------------------------------------------------//
	
	
	
	public ArrayList getDrawDown(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
			String tipo=session.getAttribute("tipo")==null?"":(String)session.getAttribute("tipo");
			String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
			
			if (role.equals("banco"))
			{
				query="SELECT NUMERO_PROSA, NUMERO_PROSA||' '||NOMBRE FROM SUPERSIC.ENTIDADES@LG_PMTU_SIC WHERE IND_LIQ_VISA IN (1,2,3,4) AND NUMERO_PROSA = ENT_NUMERO_PROSA AND NUMERO_PROSA IN ("+numerosProsa+") ORDER BY NUMERO_PROSA";				
			}
			else
			{
				query="SELECT NUMERO_PROSA, NUMERO_PROSA||' '||NOMBRE FROM SUPERSIC.ENTIDADES@LG_PMTU_SIC WHERE IND_LIQ_VISA IN (1,2,3,4) AND NUMERO_PROSA = ENT_NUMERO_PROSA ORDER BY NUMERO_PROSA ";
				
			}
				
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getDrawDown: " + ex.toString());
	    }
		return cbValues;
	}
	
	public ArrayList getDrawDown2(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
			
			query="SELECT NUMERO_PROSA, NUMERO_PROSA||' '||NOMBRE FROM SUPERSIC.ENTIDADES@LG_PMTU_SIC WHERE IND_LIQ_VISA IN (1,2,3,4) AND NUMERO_PROSA = ENT_NUMERO_PROSA AND NUMERO_PROSA <> 38 ORDER BY NUMERO_PROSA ";
			
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getDrawDown2: " + ex.toString());
	    }
		return cbValues;
	}
/*--------------------------------------------------------------------------- */
/* Marca del Cambio: AXIA-GGB-P-02-0496-10 Inicia  la Modificacion 22/12/2012 */
/*----------------------------------------------------------------------------*/
	public ArrayList getDrawDownTTRDCC(HttpSession session ) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;

	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );

			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
			query="SELECT NUMERO, NUMERO||' '||DESCRIPCION FROM PRSA_TIPOS_TRANSACCION WHERE NUMERO IN (1,21,9,15)";

			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex)
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getDrawDown2: " + ex.toString());
	    }
		return cbValues;
	}
/*----------------------------------------------------------------------------*/
/* Marca del Cambio: AXIA-GGB-P-02-0060-12 Inicia  la Modificacion 19/09/2013 */
/*----------------------------------------------------------------------------*/	
	public ArrayList getDrawDownDcc(HttpSession session ) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;

	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );

			String tipo=session.getAttribute("tipo")==null?"":(String)session.getAttribute("tipo");
			String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");	    	
	    	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
			if (role.equals("banco"))
			  query="SELECT NUMERO_PROSA, NUMERO_PROSA||' '||NOMBRE FROM supersic.ENTIDADES@LG_PMTU_IFO_01 WHERE IND_LIQ_VISA IN ('1', '3') AND IND_DCC IN('1', '2') AND NUMERO_PROSA = ENT_NUMERO_PROSA AND NUMERO_PROSA IN(" + numerosProsa + ") ORDER BY NUMERO_PROSA ";
			else
			  query="SELECT 0 NUMERO_PROSA, 'TODAS LAS ENTIDADES' NOMBRE FROM DUAL UNION SELECT NUMERO_PROSA, NUMERO_PROSA||' '||NOMBRE FROM supersic.ENTIDADES@LG_PMTU_IFO_01 WHERE IND_LIQ_VISA IN ('1', '3') AND IND_DCC IN('1', '2') AND NUMERO_PROSA = ENT_NUMERO_PROSA ORDER BY NUMERO_PROSA ";
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex)
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getDrawDown2: " + ex.toString());
	    }
		return cbValues;
	}
/*----------------------------------------------------------------------------*/
/* Marca del Cambio: AXIA-GGB-P-02-0060-12 Termina la Modificacion 19/09/2013 */
/*----------------------------------------------------------------------------*/
/* Marca del Cambio: AXIA-AHH-P-21-0049-16 Inicia  la Modificacion 19/10/2016 */
/*----------------------------------------------------------------------------*/
	public ArrayList getDrawDownDccPMTU(HttpSession session ) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;

	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );

			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
			String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
			if (role.equals("banco"))
			    query="SELECT pm.NUMERO_PROSA\n       ,pm.DESCRIPCION NOMBRE\n   FROM pmadmin.PRSA_ENTIDADES pm\n       ,supersic.ENTIDADES@LG_PMTU_IFO_01 en\n  WHERE pm.NUMERO_FIID LIKE 'M%'\n    AND pm.GCO_NUMERO IS NULL\n    AND en.NUMERO_PROSA IN(" + numerosProsa +")\n    AND pm.NUMERO_PROSA = DECODE(en.NUMERO_PROSA, 7, 109, 58, 120, 3, 121, en.NUMERO_PROSA)\n  ORDER\n     BY NUMERO_PROSA\n";
			else
			    query="SELECT 0 NUMERO_PROSA, 'TODAS LAS ENTIDADES' NOMBRE FROM DUAL UNION Select NUMERO_PROSA, DESCRIPCION NOMBRE  From pmadmin.PRSA_ENTIDADES WHERE NUMERO_FIID Like 'M%' And GCO_NUMERO IS NULL ORDER BY NUMERO_PROSA ";

			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex)
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getDrawDown2: " + ex.toString());
	    }
		return cbValues;
	}	
/*--------------------------------------------------------------------------- */
/* Marca del Cambio: AXIA-GGB-P-02-0496-10 Termina la Modificacion 22/12/2012 */
/*----------------------------------------------------------------------------*/
/* Marca del Cambio: AXIA-AHH-P-21-0049-16 Termina la Modificacion 19/10/2016 */
/*----------------------------------------------------------------------------*/
/* Marca del Cambio: AXIA-GGB-P-02-0275-12 Inicia  la Modificacion 18/12/2014 */
/*----------------------------------------------------------------------------*/
	public ArrayList getBancoAdqFiid(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
			String tipo=session.getAttribute("tipo")==null?"":(String)session.getAttribute("tipo");
			query ="select distinct decode(tblExt.numero_fiid, 'EOTR', 'EGLO', tblExt.numero_fiid), "+
			       " (tblExt.numero_fiid || ' ' || tblExt.entidad_padre || ' ' || pe.descripcion  || ' ' || bu_tx_parent),tblExt.entidad_padre descripcion "+
             " FROM pmadmin.VW_BUS_ACQ tblExt join pmadmin.prsa_entidades pe on pe.numero_prosa=tblExt.entidad_padre";

			query+=" UNION ALL\n";
			query+="     SELECT NUMERO_FIID\n";
			query+="           ,NUMERO_FIID || ' ' || NUMERO_PROSA || ' '||DESCRIPCION\n";
			query+="           ,NUMERO_PROSA\n";
			query+="  FROM pmadmin.PRSA_ENTIDADES en\n";
			query+=" WHERE en.NUMERO_PROSA = 2805\n";
			query+="ORDER BY 3\n";

			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoAdqFiid: " + ex.toString());
	    }
		return cbValues;
	}
/*----------------------------------------------------------------------------*/
/* Marca del Cambio: AXIA-GGB-P-02-0275-12 Termina la Modificacion 18/12/2014 */
/*----------------------------------------------------------------------------*/
	public ArrayList getGrupoRechazo(HttpSession session) throws WellException
	{

		ArrayList cbValues=new ArrayList();	
		cbValues.add(new String[]{"221","Computador"});
		cbValues.add(new String[]{"120","Sintaxis"});
		return cbValues;
	}
	
	public ArrayList getGrupoTrxs(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String SZ_TC_GRP;
		ArrayList cbValues;
		
	    try 
	    {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
	    	SZ_TC_GRP = (String)session.getAttribute( "SZ_TC_GRP" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
	
			query = " select TCG_GRP_ID, (TCG_GRP_ID || ' ' || TCG_GRP_NAM) descripcion  " 
			      + " from settlement.SZ_TC_GRP"
				  + " where TCG_GRP_ID in(101,103,104,105,106,107,108,109,137,140)";
			query += " ORDER BY tcg_grp_id ";
	
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getGrupoTrxs: " + ex.toString());
	    }
		return cbValues;
	}
	
	public ArrayList getGrupoTrxs2(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String SZ_TC_GRP;
		ArrayList cbValues;
		
	    try 
	    {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
	    	SZ_TC_GRP = (String)session.getAttribute( "SZ_TC_GRP" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
	
			query = " select TCG_GRP_ID, (TCG_GRP_ID || ' ' || TCG_GRP_NAM) descripcion  " 
			      + " from settlement.SZ_TC_GRP " 
				  + " where TCG_GRP_ID not in(0,102,111,112,114,115,116,117,120,141,161,162,221,224,225,281,321,322,381,401)";
				  
			query += " ORDER BY tcg_grp_id ";
	
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getGrupoTrxs: " + ex.toString());
	    }
		return cbValues;
	}
	
	public ArrayList getArchivoAdq(HttpSession session, String bancoAdq) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ARCHIVOS;
		ArrayList cbValues;
		
		try
		{
			sessionID = session.getId() + "db";
			db = (Database)session.getAttribute( sessionID );
			PRSA_ARCHIVOS = (String)session.getAttribute( "PRSA_ARCHIVOS" );
			if( bancoAdq.contains("96")||bancoAdq.contains("97")){
				query = "select numero,(numero || ' ' || descripcion) descripcion " +
				" from " + PRSA_ARCHIVOS +
				" where ent_numero_prosa in( select numero_prosa from pmadmin.vw_bus_acq where numero_prosa in( "+ bancoAdq +")) "+ 
				" and entrada=1 and ent_numero_prosa not in(96,97)"+
				" union "+
				 "select numero,(numero || ' ' || descripcion) descripcion " +
					" from " + PRSA_ARCHIVOS +" " +
					 "where numero=45";
				
			}else
				//System.out.println("Fecha:"+fecha);
			query = "select numero,(numero || ' ' || descripcion) descripcion " +
					" from " + PRSA_ARCHIVOS +
					" where " +
					" ( ent_numero_prosa in( select numero_prosa from pmadmin.vw_bus_acq where numero_prosa in( "+ bancoAdq +")) "+
					" OR ent_numero_prosa in( select ENTIDAD_PADRE from pmadmin.vw_bus_acq where numero_prosa in( "+ bancoAdq +"))) "+
					" and entrada=1 "+
					//" order by numero "+
					" UNION "+
					" SELECT DISTINCT 2105,'2105 TRANSACCIONES POS PROSA-PUERTO RICO' "+
					" FROM PMADMIN.PRSA_ENTIDADES PE "+
					" WHERE PE.TIE_NUMERO = 8 "+
					" AND PE.NUMERO_PROSA IN ("+ bancoAdq +") "+
					" UNION "+
					" SELECT DISTINCT 1005,'1005 ADQUIRENTES DOLARES BANCOS SOCIOS MEXICO' "+
					" FROM PMADMIN.PRSA_ENTIDADES PE "+
					" WHERE PE.TIE_NUMERO = 9 "+
					" AND PE.NUMERO_PROSA IN ("+ bancoAdq +") "+
					" UNION "+
					" SELECT DISTINCT 5,'5 TRANSACCIONES POS PROSA' "+
					" FROM PMADMIN.PRSA_ENTIDADES PE "+
					" WHERE PE.TIE_NUMERO NOT IN (2,9) "+
					" AND PE.NUMERO_LN NOT IN ('EGLO','VISA','MDS') "+
					" AND PE.NUMERO_PROSA IN ("+ bancoAdq +")"+
					" UNION "+
					" SELECT 105, '105 INTEGRACION POR SISTEMAS' FROM DUAL";
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
		}
		catch(Exception ex)
		{
			throw new WellException(
				"com.wellcom.prosa.sacii.getArchivoAdq: "
				+ex.toString());
		}
		return cbValues;
 	}

	public ArrayList getArchivoAdq2(HttpSession session, String bancoAdq, String initDate) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;		
		ArrayList cbValues;
		
		try
		{
			sessionID = session.getId() + "db";
			db = (Database)session.getAttribute( sessionID );
			
			query = " SELECT DISTINCT PBA.BA_NUM_ARCH, PBA.BA_NUM_ARCH||' '||PA.DESCRIPCION "+
				" FROM PMADMIN.PRSA_BITACORA_ARCHIVOS PBA "+
				" INNER JOIN PMADMIN.PRSA_ARCHIVOS PA "+
				" 	ON PA.NUMERO = PBA.BA_NUM_ARCH "+
				" WHERE PBA.BA_FCH_PROC = TO_DATE('"+initDate+"','dd-MM-yyyy') "+
				" 	AND PBA.BA_ENT_ADQ = "+bancoAdq+" "+
				" 	AND PBA.BA_T_ARCH = 'I' "+
				" ORDER BY 1 ";
			
			System.out.println("Fuente :"+ query +":");
			
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
		}
		catch(Exception ex)
		{
			throw new WellException(
				"com.wellcom.prosa.sacii.getArchivoAdq2: "
				+ex.toString());
		}
		return cbValues;
 	}

	public ArrayList getArchivoAdqC(HttpSession session, String bancoAdq, String initDate) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;		
		ArrayList cbValues;
		
		try
		{
			sessionID = session.getId() + "db";
			db = (Database)session.getAttribute( sessionID );
			
			query =  
				" SELECT DISTINCT PBA.BA_NUM_ARCH, PBA.BA_NUM_ARCH||' '||PA.DESCRIPCION "+
				"   FROM SSP.PRSA_BITACORA_ARCHIVOS@LG_PMTU_PMTWEB_IFO2_SSP PBA "+
				"  INNER JOIN SSP.PRSA_ARCHIVOS@LG_PMTU_PMTWEB_IFO2_SSP PA "+
				" 	  ON PA.NUMERO = PBA.BA_NUM_ARCH "+
				"  WHERE PBA.BA_FCH_PROC BETWEEN TO_DATE('"+initDate+"','dd-MM-yyyy') AND SYSDATE "+
				" 	 AND PBA.BA_ENT_ADQ = "+bancoAdq+" "+
				" 	 AND PBA.BA_T_ARCH = 'I' "+
				"  ORDER BY 1 ";
			
			System.out.println("Fuente :"+ query +":");
			
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
		}
		catch(Exception ex)
		{
			throw new WellException(
				"com.wellcom.prosa.sacii.getArchivoAdqC: "
				+ex.toString());
		}
		return cbValues;
 	}
	
	public ArrayList getArchivoAdq3(HttpSession session, String bancoAdq, String initDate) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;		
		ArrayList cbValues;
		
		try
		{
			sessionID = session.getId() + "db";
			db = (Database)session.getAttribute( sessionID );
			
			query = " SELECT DISTINCT PBA.BA_NUM_ARCH, PBA.BA_NUM_ARCH||' '||PA.DESCRIPCION "+
			" FROM PMADMIN.PRSA_BITACORA_ARCHIVOS PBA "+
			" INNER JOIN PMADMIN.PRSA_ARCHIVOS PA "+
			" 	ON PA.NUMERO = PBA.BA_NUM_ARCH "+
			" WHERE PBA.BA_FCH_PROC = TO_DATE('"+initDate+"','dd-MM-yyyy') "+
			" 	AND PBA.BA_ENT_ADQ = "+bancoAdq+" "+
			" 	AND PBA.BA_T_ARCH = 'I' "+
			" ORDER BY 1 ";
			
//			query = " SELECT A.NUMERO, A.NUMERO||' '||A.DESCRIPCION DES \n"+
//					" FROM PMADMIN.PRSA_ARCHIVOS A \n"+
//					" WHERE A.ENTRADA = 1 \n"+
			//					" AND A.ENT_NUMERO_PROSA = CASE \n"+
			//												" WHEN TO_NUMBER("+bancoAdq+") IN (401,403,404,405,406,407) THEN 400 \n"+
			//												" WHEN TO_NUMBER("+bancoAdq+") IN (715,716,717,718,719,720) THEN 723 \n"+
			//												" ELSE TO_NUMBER("+bancoAdq+") \n"+
			//											 " END \n"+
			//					" UNION \n"+ 
			//					" SELECT 5, '5 TRANSACCIONES POS PROSA' \n"+
			//					" FROM DUAL D \n"+
			//					" INNER JOIN SUPERSIC.ENTIDADES@LG_PMTU_SICB E \n"+ 
			//						" ON E.TIE_NUMERO = 1 \n"+
			//						" AND E.ENT_NUMERO_PROSA = "+bancoAdq+" \n"+
			//					" UNION \n"+
			//					" SELECT 105, '105 INTEGRACION POR SISTEMAS' \n"+
			//					" FROM DUAL D \n"+
			//					" INNER JOIN SUPERSIC.ENTIDADES@LG_PMTU_SICB E \n"+ 
			//						" ON E.TIE_NUMERO = 1 \n"+
			//						" AND E.ENT_NUMERO_PROSA = "+bancoAdq+" \n"+
			//					" UNION \n"+
			//					" SELECT 35, '35 INVERLAT FORANEA' \n"+
			//					" FROM DUAL D \n"+
			//					" WHERE 86 = "+bancoAdq+" \n";
			
			System.out.println("Fuente :"+ query +":");
			
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
		}
		catch(Exception ex)
		{
			throw new WellException(
				"com.wellcom.prosa.sacii.getArchivoAdq3: "
				+ex.toString());
		}
		return cbValues;
 	}
	
	public ArrayList getArchivoAdqFecha(HttpSession session, String bancoAdq, String initDate, String endDate) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;		
		ArrayList cbValues;
		
		try
		{
			sessionID = session.getId() + "db";
			db = (Database)session.getAttribute( sessionID );
			
			query = " SELECT DISTINCT PTD.TD_SRCE_NBR, PTD.TD_SRCE_NBR||' '||PA.DESCRIPCION "+ 
					" FROM PMADMIN.PRSA_TXN_DATA PTD "+
					" INNER JOIN PMADMIN.PRSA_ARCHIVOS PA "+
					"    ON PA.NUMERO = PTD.TD_SRCE_NBR "+
					" INNER JOIN CORE.BS_PARTMDATA CBS   "+
					"     ON PTD.PARTITION_ID = CBS.PARTITION_ID "+   
					"     AND CBS.OBJECT_NAME = 'PMADMIN.PRSA_TXN_DATA' "+   
					//"     AND START_TS BETWEEN TO_DATE('"+initDate+"','dd-MM-yyyy') AND TO_DATE('"+endDate+"','dd-MM-yyyy') "+
					"     AND START_TS = TO_DATE('"+initDate+"','dd-MM-yyyy') "+
					" WHERE PTD.TD_PROSA_ACQ_ENTITY IN ("+bancoAdq+") ";
			
			System.out.println("Fuente :"+ query +":");
			
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
		}
		catch(Exception ex)
		{
			throw new WellException(
				"com.wellcom.prosa.sacii.getArchivoAdqFechas: "
				+ex.toString());
		}
		return cbValues;
 	}
	
	public ArrayList getBancoEmi(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
			String tipo=session.getAttribute("tipo")==null?"":(String)session.getAttribute("tipo");
			
			
			
			if(role.equals("banco")||tipo.equals("adq"))
			{
				String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
				if(tipo.equals("adq")){
					query = "select distinct entidad_padre,(entidad_padre || ' ' || (select Distinct descripcion " +
					" from " + PRSA_ENTIDADES +
					" where numero_prosa = tblext.ENTIDAD_PADRE) || ' ' || bu_tx_parent) descripcion " + 
					" from " + VW_BUS_EMI +
					" tblext where tie_numero = 1 " +
					" and numero_fiid not like 'U%' "+
					" order by entidad_padre";
					
				}else{
						query = " select distinct entidad_padre, (entidad_padre || ' ' ||(select  descripcion from pmadmin.prsa_entidades where numero_prosa in(tblext.entidad_padre))|| ' ' || bu_tx_parent) descripcion " +
						" from " + VW_BUS_EMI +" tblext "+
						" where " +
						" tie_numero=1 " + 
						" and entidad_padre in (" + numerosProsa + ") " +
						" and numero_fiid not like 'U%' "+
						" order by entidad_padre ";
					}
			}
			else
			{
				query = "select distinct entidad_padre,(entidad_padre || ' ' || (select Distinct descripcion " +
				" from " + PRSA_ENTIDADES +
				" where numero_prosa = tblext.ENTIDAD_PADRE) || ' ' || bu_tx_parent) descripcion " + 
				" from " + VW_BUS_EMI +
				" tblext where tie_numero=1 " +
				" and numero_fiid not like 'U%' "+
				" order by entidad_padre";
			}
			
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoEmi: " + ex.toString());
	    }
		return cbValues;
	}
	

//----------------------------------------------------------------------------//
//--Marca del Cambio : AXIA-FJCC-P-60-2646-14 Inicia  Modificacion 12/04/2016-//
//----------------------------------------------------------------------------//
	public ArrayList getBancoEmiTodos(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
			String tipo=session.getAttribute("tipo")==null?"":(String)session.getAttribute("tipo");
			
			
			
			if(role.equals("banco")||tipo.equals("adq"))
			{
				String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
				if(tipo.equals("adq")){
					query = "select distinct numero_prosa,(numero_prosa || ' ' || (select Distinct descripcion " +
					" from " + PRSA_ENTIDADES +
					" where numero_prosa = tblext.numero_prosa) || ' ' || bu_tx_parent) descripcion " + 
					" from " + VW_BUS_EMI +
					" tblext " +
					//" where tie_numero = 1 " +
					" order by numero_prosa";
					
				}else{
						query = " select distinct numero_prosa, (numero_prosa || ' ' ||(select  descripcion from pmadmin.prsa_entidades where numero_prosa in(tblext.numero_prosa))|| ' ' || bu_tx_parent) descripcion " +
						" from " + VW_BUS_EMI +" tblext "+
						" where " +
						//" tie_numero=1 " + 
						" entidad_padre in (" + numerosProsa + ") " +
						" and bu_tx_parent not in (461,641) "+
						" order by numero_prosa ";
					}
			}
			else
			{
				query = "select distinct numero_prosa,(numero_prosa || ' ' || (select Distinct descripcion " +
				" from " + PRSA_ENTIDADES +
				" where numero_prosa = tblext.numero_prosa) || ' ' || bu_tx_parent) descripcion " + 
				" from " + VW_BUS_EMI +
				" tblext " +
				//" where tie_numero=1 " +
				" where bu_tx_parent not in (461,641) "+
				" UNION SELECT 0, 'CONSOLIDADO' FROM DUAL "+
				" order by numero_prosa";
			}
			
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoEmiTodos: " + ex.toString());
	    }
		return cbValues;
	}
//----------------------------------------------------------------------------//
//--Marca del Cambio : AXIA-FJCC-P-60-2646-14 Termina Modificacion 12/04/2016-//
//----------------------------------------------------------------------------//
	
	public ArrayList getEntidadFuente(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ARCHIVOS;
		ArrayList cbValues;
		
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	PRSA_ARCHIVOS = (String)session.getAttribute( "PRSA_ARCHIVOS" );
				role = (String)session.getAttribute("role");
				numFiid = (String)session.getAttribute("numFiid");
				fiid = (String)session.getAttribute("fiid");
				login = (String)session.getAttribute("login");
				String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
				
				if(role.equals("banco"))
				{
					query = " select distinct ent_numero_prosa , (ent_numero_prosa || ' ' || PE.descripcion)descripcion "
						  + " from  PMADMIN.PRSA_ARCHIVOS PA "
						  + " INNER JOIN PMADMIN.PRSA_ENTIDADES PE "
	                      + " ON PA.ENT_NUMERO_PROSA = PE.NUMERO_PROSA "
	                      + " WHERE PA.SALIDA = 1 "
	                      + " AND PA.ent_numero_prosa in ("+numerosProsa+") "
						  + " order by 1 ";
				}
				else
				{
					query = " select distinct ent_numero_prosa , (ent_numero_prosa || ' ' || PE.descripcion)descripcion "
					  + " from  PMADMIN.PRSA_ARCHIVOS PA "
					  + " INNER JOIN PMADMIN.PRSA_ENTIDADES PE "
                      + " ON PA.ENT_NUMERO_PROSA = PE.NUMERO_PROSA "
                      + " WHERE PA.SALIDA = 1 "
					  + " order by 1 ";
				}
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) {
		      throw new WellException(
		        "com.wellcom.prosa.sacii.getEntidadFuente: "
		        + ex.toString());
		    }	 
		return cbValues;
	}
	
	
	public ArrayList getArchivoFuente(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ARCHIVOS;
		ArrayList cbValues;
		
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	PRSA_ARCHIVOS = (String)session.getAttribute( "PRSA_ARCHIVOS" );
				role = (String)session.getAttribute("role");
				numFiid = (String)session.getAttribute("numFiid");
				fiid = (String)session.getAttribute("fiid");
				login = (String)session.getAttribute("login");								
					
				query = " select distinct numero, (numero || ' ' || descripcion)descripcion "
					  + " from  PMADMIN.PRSA_ARCHIVOS "
					  + " order by numero ";
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) {
		      throw new WellException(
		        "com.wellcom.prosa.sacii.getArchivoFuente: "
		        + ex.toString());
		    }	 
		return cbValues;
	}
	
	public ArrayList getArchivoEntrada(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ARCHIVOS;
		ArrayList cbValues;
		
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	PRSA_ARCHIVOS = (String)session.getAttribute( "PRSA_ARCHIVOS" );
				role = (String)session.getAttribute("role");
				numFiid = (String)session.getAttribute("numFiid");
				fiid = (String)session.getAttribute("fiid");
				login = (String)session.getAttribute("login");
				String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
				
				if(role.equals("banco"))
				{
					query = " select distinct numero, (numero || ' ' || descripcion)descripcion "
						  + " from  PMADMIN.PRSA_ARCHIVOS "
						  + " where entrada in (1) "
						  + " and ent_numero_prosa in ("+numerosProsa+")"
						  + " order by numero ";	
				}
				else
					{
					query = " select distinct numero, (numero || ' ' || descripcion)descripcion "
						  + " from  PMADMIN.PRSA_ARCHIVOS "
						  + " where entrada in (1) "
						  + " order by numero ";
					}
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) {
		      throw new WellException(
		        "com.wellcom.prosa.sacii.getArchivoEntrada: "
		        + ex.toString());
		    }	 
		return cbValues;
	}
	
	public ArrayList getArchivoAdqDol(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ARCHIVOS;
		ArrayList cbValues;
		
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	PRSA_ARCHIVOS = (String)session.getAttribute( "PRSA_ARCHIVOS" );
				role = (String)session.getAttribute("role");
				numFiid = (String)session.getAttribute("numFiid");
				fiid = (String)session.getAttribute("fiid");
				login = (String)session.getAttribute("login");
				query = " select distinct numero, (numero || ' ' || descripcion)descripcion "
					  + " from  PMADMIN.PRSA_ARCHIVOS "
					  + " where ent_numero_prosa in (1001,1002,1003,1004,1005,1006,1007)"
					  + " order by numero ";
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) {
		      throw new WellException(
		        "com.wellcom.prosa.sacii.getArchivoAdqDol: "
		        + ex.toString());
		    }	 
		return cbValues;
	}
	
	public ArrayList getArchivoEmi(HttpSession session, String bancoEmi) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ARCHIVOS;
		ArrayList cbValues;
		
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	PRSA_ARCHIVOS = (String)session.getAttribute( "PRSA_ARCHIVOS" );
				role = (String)session.getAttribute("role");
				numFiid = (String)session.getAttribute("numFiid");
				fiid = (String)session.getAttribute("fiid");
				login = (String)session.getAttribute("login");
				
				query = 
					" SELECT PA1.NUMERO, PA1.NUMERO||' '||PA2.DESCRIPCION "+
					" FROM PMADMIN.PRSA_ARCHIVOS PA1 "+
					" INNER JOIN PMADMIN.PRSA_ARCHIVOS PA2 "+
					" 	ON PA1.NUMERO = PA2.BAIN_NUMERO "+
					" 	AND PA2.NUMERO = PA1.BAIN_NUMERO "+
					" WHERE PA1.ENT_NUMERO_PROSA IN ("+bancoEmi+") "+
					" UNION "+
					" SELECT DATOS.BAIN_NUMERO, DATOS.BAIN_NUMERO||' '||DATOS.DESCRIPCION "+
					" FROM ( "+
					" SELECT PA3.NUMERO, PA3.BAIN_NUMERO, PA3.DESCRIPCION "+
					" FROM PMADMIN.PRSA_ARCHIVOS PA3 "+
					" WHERE PA3.BAIN_NUMERO IS NOT NULL "+
					" AND PA3.BAIN_NUMERO != 0 "+
					" AND PA3.ENT_NUMERO_PROSA IN ("+bancoEmi+") "+
					" MINUS "+
					" SELECT PA1.NUMERO, PA2.BAIN_NUMERO, PA1.DESCRIPCION "+
					" FROM PMADMIN.PRSA_ARCHIVOS PA1 "+
					" INNER JOIN PMADMIN.PRSA_ARCHIVOS PA2 "+
					" 	ON PA1.NUMERO = PA2.BAIN_NUMERO "+
					" 	AND PA2.NUMERO = PA1.BAIN_NUMERO "+
					" ) DATOS "+
					" ORDER BY 1 ";
				
//				query = " select distinct numero, (numero || ' ' || descripcion) descripcion"
//					  + " from " +  PRSA_ARCHIVOS
//					  + " where ent_numero_prosa in(" + bancoEmi + ") AND SALIDA=1" 
//					  + " order by numero ";
				
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) {
		      throw new WellException(
		        "com.wellcom.prosa.sacii.getArchivoEmi: "
		        + ex.toString());
		    }	 
		return cbValues;
	}
	
	public ArrayList getArchivoAdqDol(HttpSession session, String bancoAdq) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ARCHIVOS;
		ArrayList cbValues;
		
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	PRSA_ARCHIVOS = (String)session.getAttribute( "PRSA_ARCHIVOS" );
				role = (String)session.getAttribute("role");
				numFiid = (String)session.getAttribute("numFiid");
				fiid = (String)session.getAttribute("fiid");
				login = (String)session.getAttribute("login");
				
				query = " select distinct numero, (numero || ' ' || descripcion) descripcion"
					  + " from " +  PRSA_ARCHIVOS
					  + " where ent_numero_prosa in(" + bancoAdq + ") AND SALIDA=1" 
					  + " order by numero ";
				
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) {
		      throw new WellException(
		        "com.wellcom.prosa.sacii.getArchivoAdqDol: "
		        + ex.toString());
		    }	 
		return cbValues;
	}
	
	public ArrayList getBancoAdqDol(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		String PRSA_ENTIDADES;
		ArrayList cbValues;
		
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
		    	VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
		    	PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
				role = (String)session.getAttribute("role");
				numFiid = (String)session.getAttribute("numFiid");
				fiid = (String)session.getAttribute("fiid");
				login = (String)session.getAttribute("login");
				
				String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
				
				if(role.equals("banco"))
				{
					query =  "select distinct numero_prosa,(numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion "+
								 " from "+  VW_BUS_ACQ +
								 " where tie_numero in (9) and entidad_padre in ("+numerosProsa+" ) "+
								 " order by 1";
				}
				else 
				{
					query = " select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent)descripcion " + 
							" from " + VW_BUS_ACQ + 
							" where tie_numero in (9) "+
							" order by 1";
				}
				
				if(numerosProsa != null)
					if(numerosProsa.contains("81") || !(role.equals("banco")) )
					{
						query += " union  select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent)descripcion " +
						    	 " from " + VW_BUS_EMI+
						    	 " where  numero_prosa in(81) ";
					}				
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) 
		    {
		      throw new WellException("com.wellcom.prosa.sacii.comboBoxBancoAdqDol2: " + ex.toString());
		    }	 
		return cbValues;
	}
	
	
	public ArrayList getBancoInt(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		String PRSA_ENTIDADES;
		ArrayList cbValues;
		
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
		    	VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
		    	PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
				role = (String)session.getAttribute("role");
				numFiid = (String)session.getAttribute("numFiid");
				fiid = (String)session.getAttribute("fiid");
				login = (String)session.getAttribute("login");
				
				String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
				
				if(role.equals("banco"))
				{
					query =  "select distinct numero_prosa,(numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion "+
								 " from "+  VW_BUS_ACQ +
								 " where tie_numero in (2,1) and entidad_padre in ("+numerosProsa+" ) "+
								 " union "+
								 "select distinct numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion "+
								 " from "+  VW_BUS_EMI +
								 " where tie_numero=1 and entidad_padre in ("+numerosProsa+" )";
							/*" select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion " +
							" from " + VW_BUS_ACQ +
							" where tie_numero=2 " +
							" and numero_prosa in (" + numerosProsa + 
							" ) union select numero_prosa,(numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion " +
							" from " +  VW_BUS_EMI +
							" where tie_numero=1 " +
							" and numero_prosa in (" + numerosProsa +" )";*/
				}
				else 
				{
					query = " select  numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent)descripcion " + 
							" from " + VW_BUS_ACQ + 
							" union select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent)descripcion " + 
							" from " + VW_BUS_EMI + 
							" where tie_numero=1 " +
							" union " +
							" select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent)descripcion" +
							" from " + VW_BUS_EMI +
							" where numero_prosa in(select distinct hijas.numero_prosa " +
							" from " + PRSA_ENTIDADES +	" hijas, " + 
							  PRSA_ENTIDADES + " padre " +
							" where hijas.entidad_padre != hijas.numero_prosa " + 
							" and hijas.numero_fiid !=padre.numero_fiid " +
							" and hijas.entidad_padre= padre.numero_prosa " +
							" and hijas.tie_numero=1)";	
				}
				
				if(numerosProsa != null)
					if(numerosProsa.contains("81") || !(role.equals("banco")) )
					{
						query += " union  select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent)descripcion " +
						    	 " from " + VW_BUS_EMI+
						    	 " where  numero_prosa in(81) ";
					}				
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) 
		    {
		      throw new WellException("com.wellcom.prosa.sacii.comboBoxBancoInt: " + ex.toString());
		    }	 
		return cbValues;
	}
	
	public ArrayList getBancoIntEntHijas(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		String PRSA_ENTIDADES;
		ArrayList cbValues;
		
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
		    	VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
		    	PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
				role = (String)session.getAttribute("role");
				numFiid = (String)session.getAttribute("numFiid");
				fiid = (String)session.getAttribute("fiid");
				login = (String)session.getAttribute("login");
				
				String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
				System.out.println(":"+numerosProsa+":");
				
				if(role.equals("banco"))
				{
					query = " select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent )descripcion" +
							" from " + VW_BUS_ACQ + " tblext " +
							//" where tie_numero=2 AND"+
							" where "+
							"  entidad_padre in ("+numerosProsa+") " +
							" union " +
							" select distinct numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent )descripcion"+
							" from " + VW_BUS_EMI  + 
							" where tie_numero=1 " +
							" and numero_fiid not like 'U%' " +
							" and entidad_padre in (" + numerosProsa + ")";			
				}
				else 
				{
					query = " select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent )descripcion" +
							" from " + VW_BUS_ACQ + " tblext " +
							" where NUMERO_PROSA NOT IN (94,95,96,97,98) " +
							" UNION SELECT 131 num, '131 CONCENTRADORA PESOS PROSA 461' DES from dual "+
							" union " +
							" select distinct numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent )descripcion" +
							" from " + VW_BUS_EMI + 
							" where tie_numero=1 " +
							" and entidad_padre=numero_prosa " +
							" and bu_tx_parent not in (461,641) " +
							" and numero_fiid not like 'U%' " +
							" AND NUMERO_PROSA NOT IN (94,95,96,97,98) "+
							" union " +
							" select  numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent)descripcion" +
							" from " + VW_BUS_EMI + 
							" where numero_prosa in(" +
							" select distinct hijas.numero_prosa " +
							" from " + PRSA_ENTIDADES + " hijas, " +
							PRSA_ENTIDADES + " padre " +
							" where " + 
							" hijas.entidad_padre != hijas.numero_prosa " +
							" and hijas.tie_numero=1 " +
							" and bu_tx_parent not in (461,641) " +
							") "+
							" and numero_fiid not like 'U%' "+		
							" AND NUMERO_PROSA NOT IN (94,95,96,97,98) ";
				}

				if(numerosProsa != null)
					if(numerosProsa.contains("81") || !(role.equals("banco")) )
					{
						query+= " union  select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent)descripcion " +
						    	" from " + VW_BUS_EMI+
						    	" where  numero_prosa in(81) "+
						    	" and numero_fiid not like 'U%' ";
					}
					else if(numerosProsa.contains("72") && (role.equals("banco")) )
					{
						if (numerosProsa.contains("721"))
						{}
					}
					else
				{
//				query+= " union  select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent)descripcion " +
//					    	" from " + VW_BUS_ACQ+
//					    	" where  numero_prosa in (30) ";
				}
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) 
		    {
		      throw new WellException("com.wellcom.prosa.sacii.comboBoxBancoIntEntHijas: " + ex.toString());
		    }	 
		return cbValues;
	}
	
	public ArrayList getIcasSac(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		String PRSA_ENTIDADES;
		ArrayList cbValues;
		
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
		    	VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
		    	PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
				role = (String)session.getAttribute("role");
				numFiid = (String)session.getAttribute("numFiid");
				fiid = (String)session.getAttribute("fiid");
				login = (String)session.getAttribute("login");
				
				String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
				
				if(role.equals("banco"))
				{
//----------------------------------------------------------------------------//
//--Marca del Cambio : AXIA-FJCC-P-02-0256-12 Inicia  Modificacion 09/09/2016-//
//----------------------------------------------------------------------------//
					query = " select DISTINCT ICA_RECEPTOR,(ICA_RECEPTOR || ' ' || EN.NOMBRE) ICAS " +
					        " FROM SUPERSIC.ENTIDADES@LG_PMTU_SIC EN, "+
							" SUPERSIC.visa_miscelaneos@LG_PMTU_SIC VM " +
							//" where tie_numero=2 AND"+
							" WHERE VM.ICA_RECEPTOR not in (3985,4406,11551,11882) "+
			        " AND (VM.ICA_RECEPTOR = EN.NUMERO_MASTERCARD  "+
			        " OR  VM.ICA_RECEPTOR = EN.BIN_SPONSOR_MASTERCARD) "+
							" AND EN.ENT_NUMERO_PROSA IN ("+numerosProsa+") " +
			                " ORDER BY 1 ";
				}
				else 
				{
					query = " select DISTINCT ICA_RECEPTOR,(ICA_RECEPTOR || ' ' || EN.NOMBRE) ICAS  " +
					" FROM SUPERSIC.ENTIDADES@LG_PMTU_SIC EN, " +
					//" where tie_numero=2 AND"+
					" SUPERSIC.VISA_MISCELANEOS@LG_PMTU_SIC VM "+
			        " WHERE VM.ICA_RECEPTOR not in (3985,4406,11551,11882) "+
			        " AND (VM.ICA_RECEPTOR = EN.NUMERO_MASTERCARD  "+
			        " OR  VM.ICA_RECEPTOR = EN.BIN_SPONSOR_MASTERCARD) "+
	                " ORDER BY 1,2  ";		
////----------------------------------------------------------------------------//
////-Marca del Cambio : AXIA-FJCC-P-02-0256-12 Termina  Modificacion 09/09/2016-//
////----------------------------------------------------------------------------//
				}
				
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) 
		    {
		      throw new WellException("com.wellcom.prosa.sacii.comboBoxIcasSac: " + ex.toString());
		    }	 
		return cbValues;
	}
	
	public ArrayList getIcasSac2(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		String PRSA_ENTIDADES;
		ArrayList cbValues;
		
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
		    	VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
		    	PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
				role = (String)session.getAttribute("role");
				numFiid = (String)session.getAttribute("numFiid");
				fiid = (String)session.getAttribute("fiid");
				login = (String)session.getAttribute("login");
				
				String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
				
					query = " SELECT MM.MCM_MBR_ID ICA_RECEPTOR, MM.MCM_MBR_ID||' '||VB.DESCRIPCION ICAS "+
					" FROM IPM.MC_MBR MM "+
					" INNER JOIN ( "+
					" SELECT BU_TX_ADQ, DESCRIPCION, NUMERO_PROSA FROM PMADMIN.VW_BUS_ACQ WHERE TIE_NUMERO LIKE '1%' "+
					" UNION "+
					" SELECT BU_TX_ISS, DESCRIPCION, NUMERO_PROSA FROM PMADMIN.VW_BUS_EMI WHERE TIE_NUMERO LIKE '1%') VB "+
					" ON VB.BU_TX_ADQ = MM.MCM_BU ";					
				
				if(role.equals("banco")){
					query += " WHERE VB.NUMERO_PROSA IN ("+numerosProsa+") ";
				}
				
				
				query += " ORDER BY 1";
				
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) 
		    {
		      throw new WellException("com.wellcom.prosa.sacii.comboBoxIcasSac: " + ex.toString());
		    }	 
		return cbValues;
	}
	
		public ArrayList getIcasSac2_mir148(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		String PRSA_ENTIDADES;
		ArrayList cbValues;
		
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
		    	VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
		    	PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
				role = (String)session.getAttribute("role");
				numFiid = (String)session.getAttribute("numFiid");
				fiid = (String)session.getAttribute("fiid");
				login = (String)session.getAttribute("login");
				
				String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
				
					query = " SELECT DISTINCT NUMERO_MASTERCARD, NUMERO_MASTERCARD || ' ' || E.DESCRIPCION FROM ( "+
									" SELECT NUMERO_PROSA, NUMERO_MASTERCARD, NOMBRE "+
									" FROM SUPERSIC.entidades@LG_PMTU_SIC "+
									" UNION "+
									" SELECT NUMERO_PROSA, BIN_SEGURIZADO_MASTERCARD, NOMBRE "+
									" FROM SUPERSIC.entidades@LG_PMTU_SIC "+
									" ) ICA INNER JOIN PMADMIN.PRSA_ENTIDADES E "+
									"     ON E.NUMERO_PROSA = ICA.NUMERO_PROSA "+
									"     AND E.TIE_NUMERO = 1 "+
									" WHERE ICA.NUMERO_MASTERCARD NOT IN (3985,4406,11551,11882) ";
									
				if(!role.equals("banco")){
					query += " UNION SELECT 0, 'CONSOLIDADO' FROM DUAL ";
				}
				
				if(role.equals("banco")){
					query += " AND E.NUMERO_PROSA IN ("+numerosProsa+") ";
				}
				
				
				query += " ORDER BY 1"; 
				
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) 
		    {
		      throw new WellException("com.wellcom.prosa.sacii.comboBoxIcasSac: " + ex.toString());
		    }	 
		return cbValues;
	}

	public ArrayList getBancoEntHijas(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		String PRSA_ENTIDADES;
		ArrayList cbValues;
		
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
		    	VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
		    	PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
				role = (String)session.getAttribute("role");
				numFiid = (String)session.getAttribute("numFiid");
				fiid = (String)session.getAttribute("fiid");
				login = (String)session.getAttribute("login");
				
				String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
				
				if(role.equals("banco"))
				{
					query = " select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent )descripcion" +
							" from " + VW_BUS_ACQ + " tblext " +
							" where entidad_padre in ("+numerosProsa+") " +
							" union " +
							" select distinct numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent )descripcion"+
							" from " + VW_BUS_EMI  + 
							" where tie_numero=1 " +
							" and entidad_padre in (" + numerosProsa + ")";			
				}
				else 
				{
					query = " select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent )descripcion" +
							" from " + VW_BUS_ACQ + " tblext " +
							" union " +
							" select distinct numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent )descripcion" +
							" from " + VW_BUS_EMI + 
							" where tie_numero=1 " +
							" and entidad_padre=numero_prosa " +
							" union " +
							" select  numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent)descripcion" +
							" from " + VW_BUS_EMI + 
							" where numero_prosa in(" +
							" select distinct hijas.numero_prosa " +
							" from " + PRSA_ENTIDADES + " hijas, " +
							PRSA_ENTIDADES + " padre " +
							" where " + 
							" hijas.entidad_padre != hijas.numero_prosa " +
							" and hijas.tie_numero=1 " +
							")";		
				}
				if(numerosProsa != null)
					if(numerosProsa.contains("81") || !(role.equals("banco")) )
					{
						query+= " union  select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent)descripcion " +
						    	" from " + VW_BUS_EMI+
						    	" where  numero_prosa in(81) ";
					}
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) 
		    {
		      throw new WellException("com.wellcom.prosa.sacii.comboBoxBancoIntEntHijas: " + ex.toString());
		    }	 
		return cbValues;
	}
	
	
	
	
	public ArrayList getBancoIntEntPadre(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		String PRSA_ENTIDADES;
		ArrayList cbValues;
		
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
		    	VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
		    	PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
				role = (String)session.getAttribute("role");
				numFiid = (String)session.getAttribute("numFiid");
				fiid = (String)session.getAttribute("fiid");
				login = (String)session.getAttribute("login");
				
				String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
				
				if(role.equals("banco"))
				{
					query = " select entidad_padre, (entidad_padre || ' ' || (select  descripcion from pmadmin.prsa_entidades where numero_prosa =tblExt.entidad_padre) || ' ' || bu_tx_parent )descripcion " +
						    " from " + VW_BUS_ACQ + " tblExt "+
						    " where tie_numero in (1,2) " + 
						    " and entidad_padre in (" + numerosProsa+ ")" +  
						    " union select entidad_padre, (entidad_padre || ' ' || (select  descripcion from pmadmin.prsa_entidades where numero_prosa =tblExt.entidad_padre) || ' ' || bu_tx_parent)descripcion " + 
						    " from " + VW_BUS_EMI + " tblExt "+
						    " where tie_numero=1 " +
						    " and numero_fiid not like 'U%' "+ 
						    " and entidad_padre  in (" + numerosProsa + " )";			
				}
				else 
				{
					query = " select  va.entidad_padre, (va.entidad_padre || ' ' || ent_padre.descripcion || ' ' || bu_tx_parent)descripcion"+
							" from " + VW_BUS_ACQ +	" va, " + PRSA_ENTIDADES + " ent_padre " +
							" where va.tie_numero in (1,2) " +
							" and va.entidad_padre=ent_padre.numero_prosa " +
							" AND VA.ENTIDAD_PADRE NOT IN (94,95,96,97,98) "+
							" union " + 
							" select distinct ve.entidad_padre, (ve.entidad_padre || ' ' || ent_padre.descripcion || ' ' || bu_tx_parent)descripcion " +
							" from " + VW_BUS_EMI + " ve," + PRSA_ENTIDADES + " ent_padre " + 
							" where ve.tie_numero=1 " +
							" and ve.entidad_padre=ent_padre.numero_prosa" +
							" and ve.numero_fiid not like 'U%' "+
							" AND VE.ENTIDAD_PADRE NOT IN (94,95,96,97,98) "+
							" and ve.bu_tx_parent not in (461,641) "+
							" UNION SELECT 131 NUM, '131 CONCENTRADORA PESOS PROSA 461' DES FROM DUAL ";
				}
				
				if(numerosProsa != null)
					if(numerosProsa.contains("72") && (role.equals("banco")) )
					{
						if (numerosProsa.contains("721"))
						{}
					}
					else
					{
//						query+= " union  select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent)descripcion " +
//						    	" from " + VW_BUS_ACQ+
//						    	" where  numero_prosa in(30) ";
					}	
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) 
		    {
		      throw new WellException("com.wellcom.prosa.sacii.comboBoxBancoIntEntPadre: " + ex.toString());
		    }	 
		return cbValues;
	}
	
	public ArrayList getBancoEmiDol(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");

			query =   " select numero_prosa, descripcion from(	"+
				
			/*" select entidad_padre, numero_prosa,  (numero_prosa||' '|| descripcion||' '||bu_tx_parent) descripcion " +
								"  FROM " + VW_BUS_ACQ+ 
								"  WHERE tie_numero=1 "+			
						"  union "+*/
			"  select entidad_padre,numero_prosa, (numero_prosa||' '|| descripcion||' '||bu_tx_parent) descripcion " +
			"  FROM " + VW_BUS_EMI+
			"  WHERE numero_prosa in (107) "+
			" ) ";
			
			if(role.equals("banco"))
			{
				String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
				query += " where entidad_padre  in (" + numerosProsa + ") ";	
			}
			
				query += " order by numero_prosa";
				
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
			
		
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoEmiDol: " + ex.toString());
	    }
		return cbValues;
	}
	
	public ArrayList getBancoSinEgloInteCons(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");

			query =" SELECT VBA.NUMERO_PROSA, VBA.NUMERO_PROSA||' '||VBA.DESCRIPCION DES FROM PMADMIN.VW_BUS_ACQ VBA WHERE VBA.NUMERO_LN NOT IN ('EGLO') AND VBA.TIE_NUMERO NOT IN (2) ";
			
			if(role.equals("banco"))
			{
				String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
				query+=" AND VBA.NUMERO_PROSA IN ("+numerosProsa+") ";
			}
			else
			{
				query+=" UNION ALL SELECT 0, 'CONSOLIDADO' FROM DUAL ";
			}
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();			
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoSinEgloInteCons: " + ex.toString());
	    }
		return cbValues;
	}
	
	public ArrayList getBancoEmiLiqDol(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");

			query =   " SELECT VBE.NUMERO_PROSA, VBE.NUMERO_PROSA||' '||VBE.DESCRIPCION "+
					  " FROM PMADMIN.VW_BUS_EMI VBE "+
					  " WHERE VBE.NUMERO_LN = 'DLMN' ";
			
			if(role.equals("banco"))
			{
				String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
				query += " AND VBE.ENTIDAD_PADRE IN (" + numerosProsa + ") ";	
			}
			
				query += " ORDER BY VBE.NUMERO_PROSA";
				
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
			
		
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoEmiLiqDol: " + ex.toString());
	    }
		return cbValues;
	}
	
	public ArrayList getBancoEmiLiqDolConc(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");

			query =   " select numero_prosa, descripcion from(	"+
				
			/*" select entidad_padre, numero_prosa,  (numero_prosa||' '|| descripcion||' '||bu_tx_parent) descripcion " +
								"  FROM " + VW_BUS_ACQ+ 
								"  WHERE tie_numero=1 "+			
						"  union "+*/
			"  select entidad_padre,numero_prosa, (numero_prosa||' '|| descripcion||' '||bu_tx_parent) descripcion " +
			"  FROM " + VW_BUS_EMI+
			"  WHERE numero_prosa in (1031) "+
			" ) ";
			
			if(role.equals("banco"))
			{
				String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
				query += " where entidad_padre  in (" + numerosProsa + ") ";	
			}
			
				query += " order by numero_prosa";
				
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
			String []consol= new String[2];
			
			if(!role.equals("banco")){
				consol[0]="1031";	
				consol[1]="1031 CONCENTRADORA DOLARES PROSA";
				
					cbValues.add(consol);
					
				}
		
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoEmiLiqDol: " + ex.toString());
	    }
		return cbValues;
	}
	
	public ArrayList getBancoEmiLiqDolConsol(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");

			query =   " select numero_prosa, descripcion from(	"+
				
			/*" select entidad_padre, numero_prosa,  (numero_prosa||' '|| descripcion||' '||bu_tx_parent) descripcion " +
								"  FROM " + VW_BUS_ACQ+ 
								"  WHERE tie_numero=1 "+			
						"  union "+*/
			"  select numero_prosa, (numero_prosa||' '|| descripcion||' '||bu_tx_parent) descripcion " +
			"  FROM " + VW_BUS_EMI+
			"  WHERE numero_prosa in (1507,1031) "+
			" ) ";
			
			if(role.equals("banco"))
			{
				String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
				query += " where entidad_padre  in (" + numerosProsa + ") ";	
			}
			
				query += " order by numero_prosa";
				
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
			String []consol= new String[2];
			String []b2= new String[2];
			String []b1= new String[2];
			if(!role.equals("banco")){	
				b1[0]="1031";	
				b1[1]="1031 CONCENTRADORA DOLARES PROSA";
				b2[0]="1507";	
				b2[1]="1507 BANORTE TARJETA DOLARES";
				consol[0]="0";	
				consol[1]="Consolidado";
				    cbValues.add(b1);
					cbValues.add(b2);
					cbValues.add(consol);
					
				}
		
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoEmiLiqDolConsol: " + ex.toString());
	    }
		return cbValues;
	}
	
	
	public ArrayList getBancoEntPadre(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		String PRSA_ENTIDADES;
		ArrayList cbValues;
		
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
		    	VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
		    	PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
				role = (String)session.getAttribute("role");
				numFiid = (String)session.getAttribute("numFiid");
				fiid = (String)session.getAttribute("fiid");
				login = (String)session.getAttribute("login");
				
				String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
				
				if(role.equals("banco"))
				{
					query = " select entidad_padre, (entidad_padre || ' ' || (select  descripcion from pmadmin.prsa_entidades where numero_prosa =tblExt.entidad_padre) || ' ' || bu_tx_parent )descripcion " +
						    " from " + VW_BUS_ACQ + " tblExt "+
						    //" where tie_numero=2 " + 
						    //" and entidad_padre in (" + numerosProsa+ ")" +
						    " where entidad_padre in (" + numerosProsa+ ")" +
						    " union select entidad_padre, (entidad_padre || ' ' || (select  descripcion from pmadmin.prsa_entidades where numero_prosa =tblExt.entidad_padre) || ' ' || bu_tx_parent)descripcion " + 
						    " from " + VW_BUS_EMI + " tblExt "+
						    " where tie_numero=1 " + 
						    " and entidad_padre  in (" + numerosProsa + " )";			
				}
				else 
				{
					query = " select  va.entidad_padre, (va.entidad_padre || ' ' || ent_padre.descripcion || ' ' || bu_tx_parent)descripcion"+
							" from " + VW_BUS_ACQ +	" va, " + PRSA_ENTIDADES + " ent_padre " +
							//" where va.tie_numero=2 " +
							//" and va.entidad_padre=ent_padre.numero_prosa " +
							" where va.entidad_padre=ent_padre.numero_prosa " +
							" union " + 
							" select distinct ve.entidad_padre, (ve.entidad_padre || ' ' || ent_padre.descripcion || ' ' || bu_tx_parent)descripcion " +
							" from " + VW_BUS_EMI + " ve," + PRSA_ENTIDADES + " ent_padre " + 
							" where ve.tie_numero=1 " +
							" and ve.entidad_padre=ent_padre.numero_prosa";
				}
				
				/*if(numerosProsa != null)
					if(numerosProsa.contains("81") || !(role.equals("banco")) )
					{
						query+= " union  select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent)descripcion " +
						    	" from " + VW_BUS_EMI+
						    	" where  numero_prosa in(81) ";
					}*/		
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) 
		    {
		      throw new WellException("com.wellcom.prosa.sacii.comboBoxBancoIntEntPadre: " + ex.toString());
		    }	 
		return cbValues;
	}	
	
	
	public ArrayList getInterRed(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");			      
			
			String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
			
			if (role.equals("banco"))
			{
			   query = " select distinct entidad_padre, (entidad_padre || ' ' || descripcion || ' ' || bu_tx_parent)descripcion" +
				       " from " + VW_BUS_ACQ +
				       " where tie_numero = 2 " +
				       " and numero_prosa in (" + numerosProsa + " )"+
				       " and numero_prosa=entidad_padre " + 
				       " order by entidad_padre)";
			}
			else
			{
				query = " select Distinct entidad_padre, (entidad_padre || ' ' || descripcion || ' ' || bu_tx_parent)descripcion" +
						" from " + VW_BUS_ACQ +
						" where tie_numero=2 " +
						" and entidad_padre=numero_prosa" +
						" order by entidad_padre";
			}
			
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) {
	      throw new WellException(
	        "com.wellcom.prosa.sacii.getInterRed: "
	        + ex.toString());
	    }
		return cbValues;
	}
	
	public ArrayList getBancoAdqInterRed(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
	
			String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
			
			if(role.equals("banco"))
			{
				query = " select distinct entidad_padre,(entidad_padre || ' ' || descripcion || ' ' || bu_tx_parent)descripcion" +
						" from " + VW_BUS_ACQ +
						" where tie_numero=2 " +
						" and numero_prosa in (" + numerosProsa + ")" +
						" and numero_prosa=entidad_padre " + 
						" order by entidad_padre";
			}
			
			else
			{
				query = " select Distinct entidad_padre, (entidad_padre || ' ' || descripcion || ' ' || bu_tx_parent)descripcion" +
						" from "+ VW_BUS_ACQ +
						" where tie_numero=2 " +
						" and entidad_padre=numero_prosa " +
						" order by entidad_padre";
			}
			
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoAdqInterRed: " + ex.toString());
	    }

		return cbValues;
	}
	
	public ArrayList getDivision(HttpSession session, String interred) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		String VW_BUS_ACQ;
		Database db;
		String PRSA_TIPOS_TRANSACCION;
		ArrayList cbValues = null;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	    	VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
			query = " select numero_prosa, (numero_prosa || ' ' || descripcion  || ' ' || bu_tx_adq) descripcion "
				  + " from " +  VW_BUS_ACQ
				  + " WHERE tie_numero=2 "
				  + " and entidad_padre in( "
				  + interred + ") order by numero_prosa ";
	        db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) {
	      throw new WellException(
	        "com.wellcom.prosa.sacii.getDivision: "
	        + ex.toString());
	    }
		return cbValues;
	}
	
	public ArrayList getDivisionDol(HttpSession session, String interred) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		String VW_BUS_ACQ;
		Database db;
		String PRSA_TIPOS_TRANSACCION;
		ArrayList cbValues = null;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	    	VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
			query = " SELECT VBE.NUMERO_PROSA, VBE.NUMERO_PROSA||' '||VBE.DESCRIPCION "+
					" FROM PMADMIN.VW_BUS_EMI VBE "+
					" WHERE VBE.NUMERO_LN = 'DLMN' "+
					" AND VBE.ENTIDAD_PADRE IN ("+ interred +")";
						
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) {
	      throw new WellException(
	        "com.wellcom.prosa.sacii.getDivisionDol: "
	        + ex.toString());
	    }
		return cbValues;
	}

	public ArrayList getBancoAdqInterRedSinFIltro(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
	
			String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
			
			query =  " select entidad_padre, (entidad_padre || ' ' || descripcion || ' ' || bu_tx_parent)descripcion" +
						" from "+ VW_BUS_ACQ +
						" where entidad_padre=numero_prosa " +
						" and tie_numero = 2"+
						" order by entidad_padre";
			
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoAdqInterRed: " + ex.toString());
	    }
		return cbValues;
	}
		
	public String getNumFiid() {
		return numFiid;
	}

	public void setNumFiid(String numFiid) {
		this.numFiid = numFiid;
	}

	public String getRole() {
		return role;
	}

	public void setRol(String rol) {
		this.role = rol;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getFiid() {
		return fiid;
	}

	public void setFiid(String fiid) {
		this.fiid = fiid;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public ArrayList getBancoAdqEmiConsol(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");

			query = " select numero_prosa, descripcion from(	"+
			" select entidad_padre, numero_prosa,  (numero_prosa||' '|| descripcion||' '||bu_tx_parent) descripcion " +
								"  FROM " + VW_BUS_ACQ+ 
								"  WHERE tie_numero=1 "+			
						"  union "+
			"  select entidad_padre,numero_prosa, (numero_prosa||' '|| descripcion||' '||bu_tx_parent) descripcion " +
			"  FROM " + VW_BUS_EMI+
			"  WHERE tie_numero=1 "+
			"  and bu_tx_parent not in (461,641) " +
			"  and numero_fiid not like 'U%' "+
			" ) ";
			
			if(role.equals("banco"))
			{
				String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
				query += " where entidad_padre  in (" + numerosProsa + ") ";	
			}
			
				query += " order by numero_prosa";
				
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
			String []consol= new String[2];
		if(!role.equals("banco")){
			consol[0]="0";	
			consol[1]="Consolidado";
				cbValues.add(consol);
			}
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoAdqEmiConsol: " + ex.toString());
	    }
		return cbValues;
	}
	
	public ArrayList getBancoAdqEmiSinEgloConsol(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");

			query = "	select numero_prosa, descripcion from (  "+
							"	 select entidad_padre,numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion " +
								"  FROM " + VW_BUS_ACQ+
								"  WHERE tie_numero=1 and numero_ln not in ('EGLO')"+
								"  union "+
								"  select entidad_padre,numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion" +
								"  FROM " + VW_BUS_EMI+
								"  WHERE tie_numero=1 and numero_ln not in ('EGLO')"+
								"  AND numero_fiid not like 'U%' "+
					"  ) ";			
			
			
			if(role.equals("banco"))
			{
				String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
				query +=" where entidad_padre  in (" + numerosProsa + ") ";	
			}
			else
			{
				query += "  union"+
							"  select 0, 'Consolidado'from dual"+
							" order by numero_prosa";
			}	
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoAdqEmiSinEgloConsol: " + ex.toString());
	    }
		return cbValues;
	}
	
	public ArrayList getBancoSac(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");

			String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");

			if(role.equals("banco"))
			{
				/*
				query = " SELECT DISTINCT NUMERO_PROSA, (NUMERO_PROSA || ' ' || NOMBRE) ENTIDADES " +
						" FROM SUPERSIC.entidades@LG_PMTU_SIC EN "+
                        " WHERE " +
                        " EN.TIE_NUMERO = 1 "+
                        " AND EN.IND_LIQ_VISA IN (1,2,3) "+
                        " AND EN.NUMERO_PROSA NOT IN (999) "+
                        " AND EN.ENT_NUMERO_PROSA IN (" + numerosProsa + ") "+
                        " ORDER BY 1 ";	
         */
         query = "SELECT DISTINCT NUMERO_PROSA, (NUMERO_PROSA || ' ' || DESCRIPCION) ENTIDADES " +
                 " FROM PMADMIN.PRSA_ENTIDADES PE " +
                 "        WHERE PE.TIE_NUMERO = 1 " +
                 "        AND PE.ENTIDAD_PADRE IN (" + numerosProsa + ") " +
                 "        ORDER BY 1 ";
			}
			else
			{
				/*
		    query = " SELECT DISTINCT NUMERO_PROSA, (NUMERO_PROSA || ' ' || NOMBRE) ENTIDADES " +
		    		" FROM SUPERSIC.entidades@LG_PMTU_SIC EN "+
                " WHERE " +
                " EN.TIE_NUMERO = 1 "+
                " AND EN.IND_LIQ_VISA IN (1,2,3) "+
                " AND EN.NUMERO_PROSA NOT IN (999) "+
                //" ORDER BY 1	"+
                " UNION SELECT 0, 'CONSOLIDADO' FROM DUAL ORDER BY 1";
         */
         query = "SELECT DISTINCT NUMERO_PROSA, (NUMERO_PROSA || ' ' || DESCRIPCION) ENTIDADES " +
                 " FROM PMADMIN.PRSA_ENTIDADES PE " +
                 "        WHERE PE.TIE_NUMERO = 1 " +
                 " UNION SELECT 0, 'CONSOLIDADO' FROM DUAL ORDER BY 1";
			}
				
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoSac: " + ex.toString());
	    }
		return cbValues;
	}
	
	public ArrayList getBancoEmiDolConsol(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");

			query =   " select numero_prosa, descripcion from(	"+
				
			/*" select entidad_padre, numero_prosa,  (numero_prosa||' '|| descripcion||' '||bu_tx_parent) descripcion " +
								"  FROM " + VW_BUS_ACQ+ 
								"  WHERE tie_numero=1 "+			
						"  union "+*/
			"  select entidad_padre,numero_prosa, (numero_prosa||' '|| descripcion||' '||bu_tx_parent) descripcion " +
			"  FROM " + VW_BUS_EMI+
			"  WHERE NUMERO_FIID LIKE 'U%' "+
			" ) ";
			
			if(role.equals("banco"))
			{
				String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
				query += " where entidad_padre  in (" + numerosProsa + ") ";	
			}
			
				query += " order by numero_prosa";
				
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
			String []consol= new String[2];
		//if(!role.equals("banco")){
		//	consol[0]="0";	
		//	consol[1]="Consolidado";
		//		cbValues.add(consol);
		//	}
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoEmiDolConsol: " + ex.toString());
	    }
		return cbValues;
	}
	
	public ArrayList getBancoAdqEmiSinEglo(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");

			query = "	select numero_prosa, descripcion from (  "+
							"	 select entidad_padre,numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion " +
								"  FROM " + VW_BUS_ACQ+
								"  WHERE tie_numero=1 and numero_ln not in ('EGLO')"+
								"  union "+
								"  select entidad_padre,numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion" +
								"  FROM " + VW_BUS_EMI+
								"  WHERE tie_numero=1 and numero_ln not in ('EGLO')"+
								"  AND numero_fiid not like 'U%' "+
								"  and bu_tx_parent not in (461,641) "+
					"  ) ";			
			
			
			if(role.equals("banco"))
			{
				String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
				query += " where entidad_padre  in (" + numerosProsa + ") ";	
			}
			
				query += " order by numero_prosa";
				
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoAdq: " + ex.toString());
	    }
		return cbValues;
	}

	
	
	public ArrayList getBancoAdqEmi(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");

			query = "	select numero_prosa, descripcion from (  "+
							"	 select entidad_padre,numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion " +
								"  FROM " + VW_BUS_ACQ+
								"  WHERE tie_numero=1 "+
								"  union "+
								"  select entidad_padre,numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion" +
								"  FROM " + VW_BUS_EMI+
								"  WHERE tie_numero=1 "+
								"  and bu_tx_parent not in (461,641) "+
					"  ) ";			
			
			
			if(role.equals("banco"))
			{
				String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
				query += " where entidad_padre  in (" + numerosProsa + ") ";	
			}
			
				query += " order by numero_prosa";
				
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoAdqEmi: " + ex.toString());
	    }
		return cbValues;
	}
	
/*--------------------------------------------------------------------------- */
/* Marca del Cambio: AXIA-GGB-P-02-0275-12 Inicia  la Modificacion 18/12/2014 */
/*----------------------------------------------------------------------------*/	
	public ArrayList getBancoBSADMI(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");

//Marca de cambio:  F-52-2173-15  Inicia Modificación  SAS-LERC F-52-2173-15    #		
			/*
			query = "	select numero_prosa, descripcion from (  "+
							"	 select entidad_padre,numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion " +
								"  FROM " + VW_BUS_ACQ+
								"  WHERE tie_numero  in (1, 9, 13, 17) "+
                                "  and NUMERO_LN NOT IN ('EGLO','VISA','MDS') "+
								"  union "+
								"  select entidad_padre,numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion" +
								"  FROM " + VW_BUS_EMI+
								"  where NUMERO_LN NOT IN ('EGLO','VISA','MDS') " +
								"  and tie_numero = 1"+
								"  union "+
                                "  select entidad_padre,numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion "+
                                "  FROM pmadmin.VW_BUS_ACQ "+
                                "  where numero_prosa in (2101) "+
					"  ) ";			
			*/
			
			query = "	select numero_prosa, descripcion from (  "+
							"	select entidad_padre,numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion " +
							"    FROM " + VW_BUS_ACQ + "";
				if(role.equals("banco")){
					query += "  WHERE tie_numero  in (1, 9, 13, 17) ";
				}else{
					query += "  WHERE tie_numero  in (1, 2, 9, 13, 17) ";			
				}
                    query += "  and NUMERO_LN NOT IN ('EGLO','VISA','MDS') "+
								"  union "+
								"  select entidad_padre,numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion" +
								"  FROM " + VW_BUS_EMI+
								"  WHERE NUMERO_LN NOT IN ('EGLO','VISA','MDS') ";
				if(role.equals("banco")){
					query +=    "  and tie_numero = 1";
				}else{
					query +=    "  and tie_numero IN (1,2)";			
				}				
					query += 	"  union "+
                                "  select entidad_padre,numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion "+
                                "  FROM pmadmin.VW_BUS_ACQ "+
                                "  where numero_prosa in (2101) "+
					"  ) ";			
			
//Marca de cambio:  F-52-2173-15  Fin de Modificación  SAS-LERC F-52-2173-15    #
			
			
			if(role.equals("banco"))
			{
				String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
				query += " where entidad_padre  in (" + numerosProsa + ") ";	
			}
			
				query += " order by numero_prosa";
				
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoBSADMI: " + ex.toString());
	    }
		return cbValues;
	}
/*--------------------------------------------------------------------------- */
/* Marca del Cambio: AXIA-GGB-P-02-0275-12 Termina la Modificacion 18/12/2014 */
/*----------------------------------------------------------------------------*/
	
	
	public ArrayList getBancosEglo(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
			if (session.getAttribute("report") != null && session.getAttribute("report").equals("580")){
				query  = " SELECT 0 NUMERO_PROSA, '0 CONSOLIDADO' DESCRIPCION FROM DUAL UNION ";
			}else{
				query  = "";
			}
			query += "	select distinct numero_prosa, (numero_prosa||' '||descripcion||' '||bu_tx_parent) descripcion from " +VW_BUS_EMI+" where numero_ln='EGLO'  ";			
			query += " order by numero_prosa";
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
			String []consol= new String[2];
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancosEGLO: " + ex.toString());
	    }
		return cbValues;
	}

	
	public ArrayList getBancosEmisHijos(HttpSession session) throws WellException{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
	
			if(role.equals("banco"))
			{
				String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
				
				query = " select distinct numero_prosa, (numero_prosa || ' ' ||descripcion|| ' ' || bu_tx_parent) descripcion " +
						" from " + VW_BUS_EMI +" tblext "+
						//" where " +
						//" tie_numero in (1,8) " + 
						" where entidad_padre in (" + numerosProsa + ") " +
						" order by numero_prosa ";
			}
			else
			{
				query = " select distinct numero_prosa, (numero_prosa || ' ' ||descripcion|| ' ' || bu_tx_parent) descripcion " +
				" from " + VW_BUS_EMI +" tblext "+
				//" where " +
				//" tie_numero in (1,8) " + 
				" where bu_tx_parent not in (461,641) "+
				" order by numero_prosa ";
			}
			
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoEmi: " + ex.toString());
	    }
		return cbValues;
	}
		
		public ArrayList getBancosEmisHijos2(HttpSession session) throws WellException{
			HttpServletRequest request = null;
			String sessionID;
			Database db;
			String PRSA_ENTIDADES;
			String VW_BUS_ACQ;
			String VW_BUS_EMI;
			ArrayList cbValues;
			
		    try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		
				PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
				VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
				VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
				role = (String)session.getAttribute("role");
				numFiid = (String)session.getAttribute("numFiid");
				fiid = (String)session.getAttribute("fiid");
				login = (String)session.getAttribute("login");
		
					query = " select distinct numero_prosa, (numero_prosa || ' ' ||descripcion|| ' ' || bu_tx_parent) descripcion " +
					" from " + VW_BUS_EMI +" tblext "+
					//" where " +
					//" tie_numero in (1,8) " + 
					" where bu_tx_parent not in (461,641) "+
					" order by numero_prosa ";
				
				db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) 
		    {
		      throw new WellException("com.wellcom.prosa.sacii.getBancoEmi: " + ex.toString());
		    }
			return cbValues;		
	}
	
		
//----------------------------------------------------------------------------//
//--Marca del Cambio : AXIA-FJCC-P-60-2646-14 Inicia  Modificacion 12/04/2016-//
//----------------------------------------------------------------------------//
	public ArrayList getBancosAdqsHijosSinFiltros(HttpSession session)throws WellException{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
			
			if(role.equals("banco"))
			{
				String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
				
				query = " select distinct numero_prosa, (numero_prosa || ' ' ||descripcion|| ' ' || bu_tx_parent) descripcion " +
						" from " + VW_BUS_ACQ +" tblext "+
						//" where " +
						//" tie_numero in (1,8) " + 
						" where entidad_padre in (" + numerosProsa + ") " +
						" AND NUMERO_PROSA NOT IN (SELECT DISTINCT VBA.ENTIDAD_PADRE FROM PMADMIN.VW_BUS_ACQ VBA WHERE VBA.TIE_NUMERO = 2 AND VBA.ENTIDAD_PADRE <> VBA.NUMERO_PROSA) "+
						" order by numero_prosa ";
			}
			else
			{
			query = " select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion" +
			" FROM " + VW_BUS_ACQ +" "+
			" WHERE NUMERO_PROSA NOT IN (SELECT DISTINCT VBA.ENTIDAD_PADRE FROM PMADMIN.VW_BUS_ACQ VBA WHERE VBA.TIE_NUMERO = 2 AND VBA.ENTIDAD_PADRE <> VBA.NUMERO_PROSA) " +
                 " UNION SELECT 0, 'CONSOLIDADO' FROM DUAL ";
			
    		query += " order by numero_prosa ";
			}
			
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoAdq: " + ex.toString());
	    }
		return cbValues;

	}
//----------------------------------------------------------------------------//
//--Marca del Cambio : AXIA-FJCC-P-60-2646-14 Termina Modificacion 12/04/2016-//
//----------------------------------------------------------------------------//

	public ArrayList getBancosAdqsHijosSinFiltros2(HttpSession session)throws WellException{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
			
			query = " select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion" +
			" FROM " + VW_BUS_ACQ +" "+
			" WHERE NUMERO_PROSA NOT IN (SELECT DISTINCT VBA.ENTIDAD_PADRE FROM PMADMIN.VW_BUS_ACQ VBA WHERE VBA.TIE_NUMERO = 2 AND VBA.ENTIDAD_PADRE <> VBA.NUMERO_PROSA) ";
			
    		query += " order by numero_prosa ";
			
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoAdq: " + ex.toString());
	    }
		return cbValues;

	}

	public ArrayList getBancosAdqsHijosInterredes(HttpSession session) throws WellException{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
			query = " select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion" +
			" FROM " + VW_BUS_ACQ +" "+
			" WHERE NUMERO_PROSA NOT IN (SELECT DISTINCT VBA.ENTIDAD_PADRE FROM PMADMIN.VW_BUS_ACQ VBA WHERE VBA.TIE_NUMERO = 2 AND VBA.ENTIDAD_PADRE <> VBA.NUMERO_PROSA) ";
			//" AND TIE_NUMERO = 2";
			
			if(role.equals("banco"))
			{
				String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
				query = " select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion" +
				" FROM " + VW_BUS_ACQ +
				" where entidad_padre  in (" + numerosProsa + ") \n"+
				" AND NUMERO_PROSA NOT IN (SELECT DISTINCT VBA.ENTIDAD_PADRE FROM PMADMIN.VW_BUS_ACQ VBA WHERE VBA.TIE_NUMERO = 2 AND VBA.ENTIDAD_PADRE <> VBA.NUMERO_PROSA) ";
				//" AND TIE_NUMERO = 2 ";	
			}
			
			else 
			{
				;
			}
				query += " order by numero_prosa ";
				
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoAdqInterredes: " + ex.toString());
	    }
		return cbValues;
	}
	
	public ArrayList getBancosAdqsHijos(HttpSession session) throws WellException{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
			query = " select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion" +
			" FROM " + VW_BUS_ACQ +" "+
			" WHERE NUMERO_PROSA NOT IN (SELECT DISTINCT VBA.ENTIDAD_PADRE FROM PMADMIN.VW_BUS_ACQ VBA WHERE VBA.TIE_NUMERO = 2 AND VBA.ENTIDAD_PADRE <> VBA.NUMERO_PROSA) ";
			
			if(role.equals("banco"))
			{
				String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
				query = " select numero_prosa, (numero_prosa || ' ' || descripcion || ' ' || bu_tx_parent) descripcion" +
				" FROM " + VW_BUS_ACQ +
				" where entidad_padre  in (" + numerosProsa + ") \n"+
				" AND NUMERO_PROSA NOT IN (SELECT DISTINCT VBA.ENTIDAD_PADRE FROM PMADMIN.VW_BUS_ACQ VBA WHERE VBA.TIE_NUMERO = 2 AND VBA.ENTIDAD_PADRE <> VBA.NUMERO_PROSA) "+
								"";	
			}
			
			else 
			{
				;
			}
				query += " order by numero_prosa ";
				
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoAdq: " + ex.toString());
	    }
		return cbValues;

	}
	
	public ArrayList getBancoEmiBancoFacil(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
	
			if(role.equals("banco"))
			{
				String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
				
				query = " select distinct entidad_padre, (entidad_padre || ' ' ||(select  descripcion from pmadmin.prsa_entidades where numero_prosa in(tblext.entidad_padre))|| ' ' || bu_tx_parent) descripcion " +
						" from " + VW_BUS_EMI +" tblext "+
						" where " +
						" tie_numero=1 " + 
						" and entidad_padre in (" + numerosProsa + ") " +
						" order by entidad_padre ";
			}
			else
			{
				query = "select distinct entidad_padre,(entidad_padre || ' ' || (select Distinct descripcion " +
				" from " + PRSA_ENTIDADES +
				" where numero_prosa = tblext.ENTIDAD_PADRE) || ' ' || bu_tx_parent) descripcion " + 
				" from " + VW_BUS_EMI +
				" tblext where tie_numero=1 " +
				" and numero_prosa in( 91 )"+
				" order by entidad_padre";
			}
			
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoEmiBancoFacil: " + ex.toString());
	    }
		return cbValues;
	}
	
	public ArrayList getMiscelaneos(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String CD_TXN_CD;
		ArrayList cbValues;
		
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	CD_TXN_CD = (String)session.getAttribute( "CD_TXN_CD" );
				role = (String)session.getAttribute("role");
				numFiid = (String)session.getAttribute("numFiid");
				fiid = (String)session.getAttribute("fiid");
				login = (String)session.getAttribute("login");
				
				query =" select distinct 1||TCX_TXN_CD_SFX, 1||TCX_TXN_CD_SFX||' '||replace(TCX_D,'+') "+
				" from "+CD_TXN_CD +" "+
				" where tcx_srce_c = 902 "+ 
				" and tcx_proc_cd in (2) order by  1||TCX_TXN_CD_SFX "; 
				
				
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) {
		      throw new WellException(
		        "com.wellcom.prosa.sacii.getMiscelaneo: "
		        + ex.toString());
		    }	 
		return cbValues;
	}
	public ArrayList getTipoProc(HttpSession session){
		ArrayList cbValues=new ArrayList(3);
		String[] entrante=new String[2] ;
		String[] saliente=new String[2] ;		
		String[] circuitoLocal=new String[2] ;
		entrante[0]="45";	
		entrante[1]="Entrante";
		circuitoLocal[0]="774";	
		circuitoLocal[1]="Circuito Local";
		saliente[0]="100";	
		saliente[1]="Saliente";
		cbValues.add(circuitoLocal);
		cbValues.add(entrante);
		cbValues.add(saliente);
		return cbValues;
	}
//  ---------------------------------------------------------------------------------//
//  -- Marca del Cambio : WELL-EMQ-P-02-1202-09 Inicia la Modificacion   08/02/2010 -//
//  ---------------------------------------------------------------------------------//
	public ArrayList getPrefijoPRE(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;		
		//String TBL_PRE_PREFIJO;		
		ArrayList cbValues;		
		
		 try {
		    	sessionID = session.getId() + "db";
		    	//System.out.println("Valor db: " + sessionID2);
		    	db = (Database)session.getAttribute( sessionID);
		    	System.out.println("Valor db2: " + db);
		    	//TBL_PRE_PREFIJO = (String)session.getAttribute( "TBL_PRE_PREFIJO" );
		    	
				
		    	query ="SELECT DISTINCT ENTIDAD_PROSA, ENTIDAD_PROSA FROM PRE.TBL_PRE_PREFIJO";
		    	//query ="SELECT DISTINCT FIID, FIID LFIID FROM(SELECT 826 FIID,506215 PREFIJO FROM DUAL UNION SELECT 826 FIID,506214 PREFIJO FROM DUAL)";
				
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) {
		      throw new WellException(
		        "com.wellcom.prosa.sacii.getPrefijoPRE: "
		        + ex.toString());
		    }	 
		return cbValues;
	}
	
	public ArrayList getPrefijoPREFIID(HttpSession session,String fiid) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;		
		String lfiid;				
		ArrayList cbValues;		
		lfiid = fiid;
		
		 try {
		    	sessionID = session.getId() + "db";
		    	//System.out.println("Valor db: " + sessionID2);
		    	db = (Database)session.getAttribute( sessionID);
		    	System.out.println("Valor lfiid: " + lfiid);
		    	//TBL_PRE_PREFIJO = (String)session.getAttribute( "TBL_PRE_PREFIJO" );
		    	
				
		    	query ="SELECT DISTINCT PREFIJO, PREFIJO LPREFIJO FROM PRE.TBL_PRE_PREFIJO WHERE ENTIDAD_PROSA ="+lfiid;
		    	//query ="SELECT DISTINCT PREFIJO, PREFIJO LPREFIJO FROM(SELECT 826 FIID,506215 PREFIJO FROM DUAL UNION SELECT 826 FIID,506214 PREFIJO FROM DUAL)WHERE FIID ="+lfiid;
				
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) {
		      throw new WellException(
		        "com.wellcom.prosa.sacii.getPrefijoPRE: "
		        + ex.toString());
		    }	 
		return cbValues;
	}
//  -----------------------------------------------------------------------------------//
//  -- Marca del Cambio : WELL-EMQ-P-02-1202-09 Finaliza la Modificacion   08/02/2010 -//
//  -----------------------------------------------------------------------------------//

//--Modificacion: Entidades HUB Marca de inicio SAS-JPM P-06-0527-12 16/01/2015

	public ArrayList getBancoAdqHub(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
	
			String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
			
			if(role.equals("banco"))
			{		
				query = "select distinct entidad_padre,(entidad_padre || ' ' || nombre)descripcion "
						+"from HUB.TBL_HUB_ENTIDADES@LG_PMTU_PMTWEB_PWS_HUB "
						+"where tie_numero = 1 "
						+"and IND_HUB_EMI=0 "
						+"and numero_prosa in (" + numerosProsa + ") "
						+"and numero_prosa=entidad_padre "
						+"order by entidad_padre";
			}
			
			else
			{
				query = "select distinct entidad_padre,(entidad_padre || ' ' || nombre)descripcion " +
						" from HUB.TBL_HUB_ENTIDADES@LG_PMTU_PMTWEB_PWS_HUB  "+
						" where tie_numero = 2 "+
						"and IND_HUB_EMI=0 "+
						" and entidad_padre=numero_prosa "+
						" order by entidad_padre";
			}
			
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoAdqHub: " + ex.toString());
	    }

		return cbValues;
	}

	
	public ArrayList getBancoEmiHub(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
	
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
			String tipo=session.getAttribute("tipo")==null?"":(String)session.getAttribute("tipo");
			
			if(role.equals("banco")||tipo.equals("adq"))
			{
				String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
				if(tipo.equals("adq")){
					query = "select distinct entidad_padre, "+
							"(entidad_padre || ' ' || (select Distinct nombre from   HUB.TBL_HUB_ENTIDADES@LG_PMTU_PMTWEB_PWS_HUB where numero_prosa = tblext.ENTIDAD_PADRE)) descripcion "+
							"from HUB.TBL_HUB_ENTIDADES@LG_PMTU_PMTWEB_PWS_HUB tblext "+
							"where tie_numero = 1 "+
							"and IND_HUB_EMI = 0 "+
							"and numero_fiid not like 'U%' "+ 
							"order by entidad_padre";
					
				}else{
						query = "select distinct entidad_padre, (entidad_padre || ' ' ||(select  nombre from HUB.TBL_HUB_ENTIDADES@LG_PMTU_PMTWEB_PWS_HUB where numero_prosa in(tblext.entidad_padre))) descripcion "+
								"from  HUB.TBL_HUB_ENTIDADES@LG_PMTU_PMTWEB_PWS_HUB  tblext "+
								"where "+ 
								"tie_numero=1 "+ 
								"and IND_HUB_EMI = 1 "+
								"and entidad_padre in (" + numerosProsa + ") "+ 
								"and numero_fiid not like 'U%' "+
								"order by entidad_padre";
					}
			}
			else
			{
				query = "select distinct entidad_padre, "+
							"(entidad_padre || ' ' || (select Distinct nombre from   HUB.TBL_HUB_ENTIDADES@LG_PMTU_PMTWEB_PWS_HUB where numero_prosa = tblext.ENTIDAD_PADRE)) descripcion "+
							"from HUB.TBL_HUB_ENTIDADES@LG_PMTU_PMTWEB_PWS_HUB tblext "+
							"where tie_numero = 1 "+
							"and IND_HUB_EMI = 1 "+
							"and numero_fiid not like 'U%' "+ 
							"order by entidad_padre";
			}
			
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoEmiHub: " + ex.toString());
	    }
		return cbValues;
	}

//--Modificacion: Entidades HUB Marca de fin SAS-JPM P-06-0527-12 16/01/2015
	public ArrayList getTipoLiq(HttpSession session){
        //--Modificacion: LIQ 15 Marca de inicio SAS-JPM P-06-0527-12 11/08/2014
		ArrayList cbValues=new ArrayList(7);		 
		String[] interredEspecial=new String[2];
		//--Modificacion: LIQ 15 Marca de fin SAS-JPM P-06-0527-12 11/08/2014 
		String[] circuitoLocal=new String[2] ;
		String[] entrante=new String[2] ;
		String[] saliente=new String[2] ;
		String[] interred=new String[2] ;
		String[] visaMasterCard=new String[2] ;
		String[] corresponsal=new String[2] ;
        //--Modificacion: LIQ 15 Marca de inicio SAS-JPM P-06-0527-12 11/08/2014 
		interredEspecial[0]="15";
		interredEspecial[1]="Liquidación Interredes Esp.";
		//--Modificacion: LIQ 15 Marca de fin SAS-JPM P-06-0527-12 11/08/2014 
		circuitoLocal[0]="22";
		circuitoLocal[1]="Liquidación Circuito Local";
        entrante[0]="32";
        entrante[1]="Liquidación Entrante";
		saliente[0]="33";
		saliente[1]="Liquidación Saliente";
		interred[0]="26";
		interred[1]="Liquidación Interredes";
	   //visaMasterCard[0]="21";
		visaMasterCard[0]="6";
		visaMasterCard[1]="Liquidación Visa y Mastercard";
		corresponsal[0]="60";
		corresponsal[1]="Liquidación Corresponsales";
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

	public ArrayList getTipoLiqSac(HttpSession session){
		ArrayList cbValues=new ArrayList(5);
		String[] circuitoLocal=new String[2] ;
		String[] entrante=new String[2] ;
		String[] saliente=new String[2] ;
		String[] interred=new String[2] ;
		String[] visaMasterCard=new String[2] ;
		String[] corresponsal=new String[2] ;
		circuitoLocal[0]="21";
		circuitoLocal[1]="Liquidación Circuito Local";
        entrante[0]="22";
        entrante[1]="Liquidación Entrante";
		saliente[0]="23";
		saliente[1]="Liquidación Saliente";
		interred[0]="25";
		interred[1]="Liquidación Interredes";
		corresponsal[0]="60";
		corresponsal[1]="Liquidación Corresponsales";
	   //visaMasterCard[0]="21";
		visaMasterCard[0]="26";
		visaMasterCard[1]="Liquidación Visa y Mastercard";
		cbValues.add(circuitoLocal);
		cbValues.add(entrante);
		cbValues.add(saliente);
		cbValues.add(interred);
		cbValues.add(visaMasterCard);
		cbValues.add(corresponsal);
		return cbValues;
	}

	
	public ArrayList getTipoLiq2(HttpSession session){
		ArrayList cbValues=new ArrayList(5);
		String[] circuitoLocal=new String[2] ;
		String[] entrante=new String[2] ;
		String[] saliente=new String[2] ;
		String[] interred=new String[2] ;
		String[] visaMasterCard=new String[2] ;
		circuitoLocal[0]="22";
		circuitoLocal[1]="Liquidación Circuito Local";
        entrante[0]="32";
        entrante[1]="Liquidación Entrante";
		saliente[0]="33";
		saliente[1]="Liquidación Saliente";
		interred[0]="26";
		interred[1]="Liquidación Interredes";
	   visaMasterCard[0]="21,27";
		//visaMasterCard[0]="6";
		visaMasterCard[1]="Liquidación Visa y Mastercard";
		cbValues.add(circuitoLocal);
		cbValues.add(entrante);
		cbValues.add(saliente);
		cbValues.add(interred);
		cbValues.add(visaMasterCard);
		return cbValues;
	}

	public ArrayList getTipoLiq2_1(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String CD_TXN_CD;
		ArrayList cbValues;
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	
				
		    	query =
		    		//" SELECT DISTINCT DECODE(SNCI.NCI_NSI_CLR_ID,'21','21','22','22','23','23','24','24','26','26','27','27','32','32','33','33','25,28,29,31,52,53,54') N "+
		    	  //  "  ,DECODE(SNCI.NCI_NSI_CLR_ID "+
		    	   // "          ,'21',SNCI.NCI_NSI_CLR_D "+
		    	   // "          ,'22',SNCI.NCI_NSI_CLR_D "+
		    	   // "          ,'23',SNCI.NCI_NSI_CLR_D "+
		    	   // "          ,'24',SNCI.NCI_NSI_CLR_D "+
		    	    //"          ,'26',SNCI.NCI_NSI_CLR_D "+
		    	   /// "          ,'27',SNCI.NCI_NSI_CLR_D "+
		    	    //"          ,'32','LIQUIDACION ENTRANTE' "+
		    	   // "          ,'33','LIQUIDACION SALIENTE' "+
		    	   // "          ,'LIQUIDACION MERCADOS INTERNACIONALES') D "+
		    	    " SELECT DISTINCT SNCI.NCI_NSI_CLR_ID N, "+
			    	" SNCI.NCI_NSI_CLR_D  D "+
		    	" FROM PMADMIN.SV_NSI_CLR_ID SNCI "+
		    	" WHERE SNCI.NCI_NSI_CLR_ID NOT IN (1,2,55) "+
		    	" ORDER BY 1";
				
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) {
		      throw new WellException(
		        "com.wellcom.prosa.sacii.getLiquidacionesNSI: "
		        + ex.toString());
		    }	 
		return cbValues;
	}
	
	public ArrayList getEdoCompl(HttpSession session){
		ArrayList cbValues=new ArrayList(2);
		String[] aplica=new String[2] ;
		String[] consulta=new String[2] ;
		aplica[0]="A";	
		aplica[1]="Aplica";
		consulta[0]="C";	
		consulta[1]="Consulta";
		cbValues.add(aplica);
		cbValues.add(consulta);
		return cbValues;
	}
	
//  -- Marca del Cambio : SAS-DRT-P-53-2004-15 Inicia la Modificacion	
	public ArrayList getTipoDif(HttpSession session){
		ArrayList cbValues=new ArrayList(3);
		String[] positiva=new String[2] ;
		String[] negativa=new String[2] ;
		String[] inexistente=new String[2] ;
		positiva[0]="1";	
		positiva[1]="Positiva";
		inexistente[0]="0";	
		inexistente[1]="Inexistente";
		negativa[0]="-1";	
		negativa[1]="Negativa";
		cbValues.add(inexistente);
		cbValues.add(negativa);
		cbValues.add(positiva);
		return cbValues;
	}
//  -- Marca del Cambio : SAS-DRT-P-53-2004-15 Finaliza la Modificacion
	
	public ArrayList getNaturalezaContable(HttpSession session){
		ArrayList cbValues=new ArrayList(3);
		String[] consolidado=new String[2] ;
		String[] credito=new String[2] ;
		String[] debito=new String[2] ;
		consolidado[0]="CD";	
		consolidado[1]="Consolidado";
		credito[0]="C";	
		credito[1]="Crédito";
		debito[0]="D";	
		debito[1]="Débito";
		cbValues.add(consolidado);
		cbValues.add(credito);
		cbValues.add(debito);
		return cbValues;
	}
	
	public ArrayList getPrefijos(HttpSession session, String num) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String CD_TXN_CD;
		ArrayList cbValues;
		String entidad = num;
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
		    	
				
		    	query ="select distinct pbin_bin,pbin_bin from pmadmin.prsa_bin WHERE PBIN_ISS_ENTITY IN ("+entidad+") order by 1"; 
				
		        db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) {
		      throw new WellException(
		        "com.wellcom.prosa.sacii.getMiscelaneo: "
		        + ex.toString());
		    }	 
		return cbValues;
	}
	
	public ArrayList getMeses(HttpSession session) throws WellException
	{
		ArrayList cbValues=new ArrayList(5);
		String[] enero=new String[2] ;
		String[] febrero=new String[2] ;
		String[] marzo=new String[2] ;
		String[] abril=new String[2] ;
		String[] mayo=new String[2] ;
		String[] junio=new String[2] ;
		String[] julio=new String[2] ;
		String[] agosto=new String[2] ;
		String[] septiembre=new String[2] ;
		String[] octubre=new String[2] ;
		String[] noviembre=new String[2] ;
		String[] diciembre=new String[2] ;
		enero[0]="01";
		enero[1]="Enero";
		febrero[0]="02";
		febrero[1]="Febrero";
		marzo[0]="03";
		marzo[1]="Marzo";
		abril[0]="04";
		abril[1]="Abril";
		mayo[0]="05";
		mayo[1]="Mayo";
		junio[0]="06";
		junio[1]="Junio";
		julio[0]="07";
		julio[1]="Julio";
		agosto[0]="08";
		agosto[1]="Agosto";
		septiembre[0]="09";
		septiembre[1]="Septiembre";
		octubre[0]="10";
		octubre[1]="Octubre";
		noviembre[0]="11";
		noviembre[1]="Noviembre";
		diciembre[0]="12";
		diciembre[1]="Diciembre";
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
	
	public ArrayList getYears(HttpSession session) throws WellException
	{
		ArrayList cbValues=new ArrayList(5);
		SimpleDateFormat format=new SimpleDateFormat("yyyy");
		Integer actual=Integer.parseInt(format.format(new Date()));
		Integer anterior=actual-1;
		Integer siguiente=actual+1;
		cbValues.add(new String[]{(anterior).toString(),anterior.toString()});
		cbValues.add(new String[]{(actual).toString(),actual.toString()});
		//cbValues.add(new String[]{(siguiente).toString(),siguiente.toString()});
		return cbValues;
	}
	
	public ArrayList getBancoEmiSinEglo(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
	
			if(role.equals("banco"))
			{
				String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
				
				query = " select distinct entidad_padre, (entidad_padre || ' ' ||(select  descripcion from pmadmin.prsa_entidades where numero_prosa in(tblext.entidad_padre))|| ' ' || bu_tx_parent) descripcion " +
						" from " + VW_BUS_EMI +" tblext "+
						" where " +
						" tie_numero=1 " + 
						" and entidad_padre in (" + numerosProsa + ") " +
						" and  numero_prosa not in(95,96,97) "+
						" order by entidad_padre ";
			}
			else
			{
				query = "select distinct entidad_padre,(entidad_padre || ' ' || (select Distinct descripcion " +
				" from " + PRSA_ENTIDADES +
				" where numero_prosa = tblext.ENTIDAD_PADRE) || ' ' || bu_tx_parent) descripcion " + 
				" from " + VW_BUS_EMI +
				" tblext where tie_numero=1 " +
				" and  numero_prosa not in(95,96,97) "+
				" order by entidad_padre";
			}
			
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoEmi: " + ex.toString());
	    }
		return cbValues;
	}
	
	
	public ArrayList getBancoEmiSinEgloVM(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
	
			if(role.equals("banco"))
			{
				String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
				
				query = " select distinct entidad_padre, (entidad_padre || ' ' ||(select  descripcion from pmadmin.prsa_entidades where numero_prosa in(tblext.entidad_padre))|| ' ' || bu_tx_parent) descripcion " +
						" from " + VW_BUS_EMI +" tblext "+
						" where " +
						" tie_numero=1 " + 
						" and entidad_padre in (" + numerosProsa + ") " +
						" and numero_fiid not like 'U%' " +
						" and  numero_prosa not in(94,95,96,97,98) "+
						" order by entidad_padre ";
			}
			else
			{
				query = "select distinct entidad_padre,(entidad_padre || ' ' || (select Distinct descripcion " +
				" from " + PRSA_ENTIDADES +
				" where numero_prosa = tblext.ENTIDAD_PADRE) || ' ' || bu_tx_parent) descripcion " + 
				" from " + VW_BUS_EMI +
				" tblext where tie_numero=1 " +
				" and  numero_prosa not in(95,96,97,94,98) "+
				" and bu_tx_parent not in (461,641) "+
				" and numero_fiid not like 'U%' "+
				" order by entidad_padre";
			}
			
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoEmi: " + ex.toString());
	    }
		return cbValues;
	}
	
	public ArrayList getBancosSocios(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
			query=" select numero_prosa,numero_prosa||' '||descripcion||' '||(select max(bu_tx_parent) from( "+
            " select distinct numero_prosa,bu_tx_parent from pmadmin.vw_bus_emi "+
            " where numero_fiid not like 'U%' "+ 
            " union "+ 
            " select distinct numero_prosa,bu_tx_parent "+
            "    from pmadmin.vw_bus_acq)where numero_prosa = ext.numero_prosa "+
            "    and bu_tx_parent not in (461,641)) "+ 
            " from pmadmin.prsa_entidades ext "+
            " where "+ 
            " banco_socio='S' ";
			if(role.equals("banco"))
			{
				String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
				query+= " and entidad_padre in( "+numerosProsa+")";
				
			}
			query+=" order by numero_prosa ";
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoSocio: " + ex.toString());
	    }
		return cbValues;
	}
	
	public ArrayList getBancosSociosMI(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
			query=" select numero_prosa,numero_prosa||' '||descripcion||' '||(select max(bu_tx_parent) from( "+
            " select distinct numero_prosa,bu_tx_parent from pmadmin.vw_bus_emi "+ 
            " union "+ 
            " select distinct numero_prosa,bu_tx_parent from pmadmin.vw_bus_acq)where numero_prosa = ext.numero_prosa ) "+ 
            " from pmadmin.prsa_entidades ext "+
            " where "+
            " TIE_NUMERO NOT IN (2) ";
            //" banco_socio='S' ";
			if(role.equals("banco"))
			{
				String numerosProsa=(String)session.getAttribute("numerosProsaEnSession");
				query+= " and entidad_padre in( "+numerosProsa+")";
				
			}
			query+=" order by numero_prosa ";
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoSocioMI: " + ex.toString());
	    }
		return cbValues;
	}

	public ArrayList getTipoReorte640(HttpSession session){
		ArrayList cbValues=new ArrayList(2);
		String[] gastos=new String[2] ;
		String[] ingresos=new String[2] ;
		gastos[0]="G";	
		gastos[1]="Gastos";
		ingresos[0]="I";	
		ingresos[1]="Ingresos";
		cbValues.add(gastos);
		cbValues.add(ingresos);
		return cbValues;
	}
    public ArrayList getTipoLiq0010(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		ArrayList cbValues=new ArrayList();
	    try {
	    	
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			query=" select numero,descripcion from pmadmin.prsa_tipos_liquidacion where numero in(1,5) order by numero ";
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getTipoLiquidacion0010: " + ex.toString());
	    }
		return cbValues;
	}
    
    public ArrayList getTipoLiq10(HttpSession session){
		ArrayList cbValues=new ArrayList(5);
		String[] circuitoLocal=new String[2] ;
		String[] interred=new String[2] ;
		circuitoLocal[0]="22";
		circuitoLocal[1]="Liquidación Circuito Local";
        interred[0]="26";
		interred[1]="Liquidación Interredes";
		cbValues.add(circuitoLocal);
		cbValues.add(interred);
		return cbValues;
	}
    
    public ArrayList getNegocio(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		ArrayList cbValues=new ArrayList();
	    try {
	    	
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			query=" select valor_caracter, descripcion from pmadmin.prsa_parametros_compensacion where numero >= 25 AND NUMERO <= 32 and tipo_dato <> 0 order by numero asc ";
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getnegocio: " + ex.toString());
	    }
		return cbValues;
	}
    
	public ArrayList getEstado(HttpSession session){
		ArrayList cbValues=new ArrayList(4);
		String[] apli=new String[2] ;
		String[] con=new String[2] ;
		String[] pen=new String[2] ;
		String[] can=new String[2] ;
		apli[0]="A";	
		apli[1]="Aplica";
		con[0]="C";	
		con[1]="Consulta";
		pen[0]="P";	
		pen[1]="Pendiente";
		can[0]="N";	
		can[1]="Cancelada";
		cbValues.add(apli);
		cbValues.add(con);
		cbValues.add(pen);
		cbValues.add(can);
		return cbValues;
	}

	
	public ArrayList getBancoAdqDolConsol(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");

			query =
				
			" SELECT   "+
		    " PE.NUMERO_PROSA ENTIDAD_PADRE,  "+
		    " PE.NUMERO_PROSA||' '||PE.DESCRIPCION||' '||DECODE(VBE.BU_TX_PARENT,641,522,VBE.BU_TX_PARENT) DESCRIPCION "+ 
				" FROM PMADMIN.VW_BUS_EMI VBE   "+
				" JOIN PMADMIN.PRSA_ENTIDADES PE   "+
				" ON VBE.NUMERO_PROSA=PE.NUMERO_PROSA "+ 
				" WHERE PE.TIE_NUMERO=9 ";
			if(role.equals("banco"))
			{
				String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
				query += " and vbe.entidad_padre  in (" + numerosProsa + ") ";	
			}
			query+=" UNION  "+
				" SELECT   "+
				" PE.NUMERO_PROSA ENTIDAD_PADRE,  "+
				" PE.NUMERO_PROSA||' '||PE.DESCRIPCION||' '||DECODE(VBA.BU_TX_PARENT,641,522,VBA.BU_TX_PARENT) DESCRIPCION "+
				" FROM PMADMIN.VW_BUS_ACQ VBA   "+
				" JOIN PMADMIN.PRSA_ENTIDADES PE   "+
				" ON VBA.NUMERO_PROSA=PE.NUMERO_PROSA "+ 
				" WHERE PE.TIE_NUMERO=9 ";
			
			if(role.equals("banco"))
			{
				String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
				query += " and vba.entidad_padre  in (" + numerosProsa + ") ";	
			}
			
				query += " order by 1";
				
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
			String []consol= new String[2];
		if(!role.equals("banco")){
			consol[0]="0";	
			consol[1]="Consolidado";
				cbValues.add(consol);
			}
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoAdqDolConsol: " + ex.toString());
	    }
		return cbValues;
	}

	public ArrayList getBancoAdqConsol(HttpSession session) throws WellException
	{
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");

			query =
			" SELECT * FROM ("+
				" SELECT DISTINCT "+
				" PE.NUMERO_PROSA ENTIDAD_PADRE,  "+
				" PE.ENTIDAD_PADRE||' '||PE.DESCRIPCION||' '||DECODE(VBA.BU_TX_PARENT,641,522,VBA.BU_TX_PARENT) DESCRIPCION "+
				" FROM PMADMIN.VW_BUS_ACQ VBA   "+
				" JOIN PMADMIN.PRSA_ENTIDADES PE   "+
				" ON VBA.ENTIDAD_PADRE=PE.NUMERO_PROSA "+ 
				" WHERE PE.TIE_NUMERO=1 ) PE ";
			
			if(role.equals("banco"))
			{
				String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
				query += " WHERE PE.ENTIDAD_PADRE IN (" + numerosProsa + ") ";	
			}
			
				query += " ORDER BY 1";
				
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
			String []consol= new String[2];
		if(!role.equals("banco")){
			consol[0]="0";	
			consol[1]="Consolidado";
				cbValues.add(consol);
			}
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoAdqDolConsol: " + ex.toString());
	    }
		return cbValues;
	}
	
	public ArrayList getTTCharbacks(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String SZ_TC_GRP;
		ArrayList cbValues;
		
	    try 
	    {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
	    	SZ_TC_GRP = (String)session.getAttribute( "SZ_TC_GRP" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
	
			query = "SELECT NUMERO, "+
              "       CASE "+
              "          WHEN NUMERO = 15 THEN 'CONTRACARGO (VENTAS)' "+
              "          WHEN NUMERO = 16 THEN 'CONTRACARGO (DEVOLUCION)' "+
              "          WHEN NUMERO = 17 THEN 'CONTRACARGO (DISPOSICION)' "+
              "          WHEN NUMERO = 18 THEN 'SEGUNDO CONTRACARGO (VENTAS)' "+
              "          WHEN NUMERO = 19 THEN 'SEGUNDO CONTRACARGO (DEVOLUCION)' "+
              "          ELSE DESCRIPCION "+
              "       END DESCRIPCION "+
              "FROM PMADMIN.PRSA_TIPOS_TRANSACCION "+
              "WHERE DESCRIPCION LIKE '%CONTRACARGO%' "+
              "AND NUMERO NOT IN (12,24) "+
              "ORDER BY NUMERO ";
	
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getGrupoTrxs: " + ex.toString());
	    }
		return cbValues;
	}

	public ArrayList getTTCharbacks2(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String SZ_TC_GRP;
		ArrayList cbValues;
		
	    try 
	    {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
	    	SZ_TC_GRP = (String)session.getAttribute( "SZ_TC_GRP" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
	
			query = "SELECT NUMERO, DECODE(DESCRIPCION,'PAGOS','MISCELANEOS(CREDITO)',DESCRIPCION) FROM SUPERSIC.TIPOS_TRANSACCION@LG_PMTU_SIC WHERE NUMERO IN (10,20)";
			//query = " select TCG_GRP_ID, (TCG_GRP_ID || ' ' || TCG_GRP_NAM) descripcion  " 
			//      + " from " + SZ_TC_GRP
			//	  + " where TCG_GRP_ID in(118,119,113)";
			//query += " ORDER BY tcg_grp_id ";
	
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getGrupoTrxs: " + ex.toString());
	    }
		return cbValues;
	}

	
	public ArrayList getBancoAdqMultimoneda(HttpSession session) throws WellException
	{

		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");
			String tipo=session.getAttribute("tipo")==null?"":(String)session.getAttribute("tipo");

			query ="select distinct tblExt.entidad_padre, (tblExt.entidad_padre || ' ' || pe.descripcion  || ' ' || bu_tx_parent) descripcion "+
                   " FROM pmadmin.VW_BUS_ACQ tblExt join pmadmin.prsa_entidades pe on pe.numero_prosa=tblExt.entidad_padre ";
			
			if(role.equals("banco")||tipo.equals("emi"))
			{
				
					String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
					query += " where tblExt.entidad_padre  in (" + numerosProsa + ") and tblExt.TIE_NUMERO not in (1,2,5,9)   ";
				
			}
			
			else 
			{
				query += " where tblExt.entidad_padre = tblExt.numero_prosa and tblExt.TIE_NUMERO not in (1,2,5,9) "; 	
			}
				query += "\n order by 1";
				
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoAdq: " + ex.toString());
	    }
		return cbValues;
	}
	
/*--------------------------------------------------------------------------- */
/* Marca del Cambio: AXIA-GGB-P-20-0452-14 Inicia  la Modificacion 27/10/2015 */
/*----------------------------------------------------------------------------*/
		public ArrayList getBancoDol(HttpSession session) throws WellException{
	
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");

			query = " SELECT PE.NUMERO_PROSA, PE.NUMERO_PROSA||' '||PE.DESCRIPCION "+
					  " FROM PMADMIN.PRSA_ENTIDADES PE "+
					  " WHERE (PE.NUMERO_PROSA > 1000 OR PE.NUMERO_PROSA = 169) "+
					  " AND PE.TIE_NUMERO = 1 ";
			
			if(role.equals("banco"))
			{
				String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
				query += " AND PE.ENTIDAD_PADRE IN (" + numerosProsa + ") ";	
			}
			
				query += " ORDER BY PE.NUMERO_PROSA";
				
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
			
		
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoEmiLiqDol: " + ex.toString());
	    }
		return cbValues;
	}
/*--------------------------------------------------------------------------- */
/* Marca del Cambio: AXIA-GGB-P-20-0452-14 Termina la Modificacion 27/10/2015 */
/*----------------------------------------------------------------------------*/
	
			public ArrayList getBancoDol2(HttpSession session) throws WellException{
	
		HttpServletRequest request = null;
		String sessionID;
		Database db;
		String PRSA_ENTIDADES;
		String VW_BUS_ACQ;
		String VW_BUS_EMI;
		ArrayList cbValues;
		
	    try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
	
			PRSA_ENTIDADES = (String)session.getAttribute( "PRSA_ENTIDADES" );
			VW_BUS_ACQ = (String)session.getAttribute( "VW_BUS_ACQ" );
			VW_BUS_EMI = (String)session.getAttribute( "VW_BUS_EMI" );
			role = (String)session.getAttribute("role");
			numFiid = (String)session.getAttribute("numFiid");
			fiid = (String)session.getAttribute("fiid");
			login = (String)session.getAttribute("login");

			query = " SELECT PE.NUMERO_PROSA, PE.NUMERO_PROSA||' '||PE.DESCRIPCION "+
					  " FROM PMADMIN.PRSA_ENTIDADES PE "+
					  " WHERE PE.NUMERO_PROSA > 1000 "+
					  " AND PE.TIE_NUMERO = 1 "+
					  " AND PE.NUMERO_PROSA <> 1031 ";
			
			if(role.equals("banco"))
			{
				String numerosProsa = (String)session.getAttribute("numerosProsaEnSession");
				query += " AND PE.ENTIDAD_PADRE IN (" + numerosProsa + ") ";	
			}
			
				query += " ORDER BY PE.NUMERO_PROSA";
				
			db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
			
		
	    }
	    catch (Exception ex) 
	    {
	      throw new WellException("com.wellcom.prosa.sacii.getBancoEmiLiqDol: " + ex.toString());
	    }
		return cbValues;
	}
//  -- Marca del Cambio : SAS-DRT-P-53-2004-15 Inicia la Modificacion
	public ArrayList getTipoEntSal(HttpSession session){
		ArrayList cbValues=new ArrayList(2);
		String[] entrante=new String[2] ;
		String[] saliente=new String[2] ;		
		entrante[0]="2";	
		entrante[1]="Entrante";
		saliente[0]="3";	
		saliente[1]="Saliente";
		cbValues.add(entrante);
		cbValues.add(saliente);
		return cbValues;
	}	
	//  -- Marca del Cambio : SAS-DRT-P-53-2004-15 Finaliza la Modificacion   
/*Marca de cambio:  SAS-DRT B-54-2904-15  Inicia Modificación*/	
         public ArrayList getArchivoEntrada(HttpSession session,String banco,String fechaIni,String fechaFin,String tipo) throws WellException
	{
		String sessionID;
		Database db;
		ArrayList cbValues;
		 try {
		    	sessionID = session.getId() + "db";
		    	db = (Database)session.getAttribute( sessionID );
				 query = " select distinct numero, (numero || ' ' || descripcion)descripcion "
					  + " from  PMADMIN.PRSA_BITACORA_ARCHIVOS PBA INNER JOIN "
                                          + " PMADMIN.PRSA_ARCHIVOS PA  ON PBA.BA_NUM_ARCH = PA.NUMERO "
				          + " where PA.entrada in (1) ";
                                           if(tipo.equals("bancoAdq")){
                                            query+= " and PBA.BA_ENT_ADQ in ("+banco+") ";
                                            }if(tipo.equals("bancoEmi")){
                                            query+= " and PBA.BA_ENT_EMI in ("+banco+") ";
                                            }
                                  query+= " AND PBA.BA_FCH_PROC BETWEEN TO_DATE('"+fechaIni+"','dd-MM-yyyy') AND TO_DATE('"+fechaFin+"','dd-MM-yyyy') "
                                          + " and PBA.BA_T_ARCH='I' " 
                                          + " order by numero ";
                                db.setQuerySelect( query );
				db.executeQuerySelect();
				cbValues = db.getRSColsData();
		    }
		    catch (Exception ex) {
		      throw new WellException(
		        "com.wellcom.prosa.sacii.getArchivoEntrada: "
		        + ex.toString());
		    }	 
		return cbValues;
	}
	public ArrayList getArchivoSalida(HttpSession session,String banco,String fechaIni,String fechaFin,String tipo) throws WellException{
	String sessionID;
	Database db;
	ArrayList cbValues;
	 try {
	    	sessionID = session.getId() + "db";
	    	db = (Database)session.getAttribute( sessionID );
                                query = " select distinct numero, (numero || ' ' || descripcion)descripcion "
					  + " from  PMADMIN.PRSA_BITACORA_ARCHIVOS PBA INNER JOIN "
                                          + " PMADMIN.PRSA_ARCHIVOS PA  ON PBA.BA_NUM_ARCH = PA.NUMERO "
				          + " where PA.salida in (1) ";
                                            if(tipo.equals("bancoAdq")){
                                            query+= " and PBA.BA_ENT_ADQ in ("+banco+") ";
                                            }if(tipo.equals("bancoEmi")){
                                            query+= " and PBA.BA_ENT_EMI in ("+banco+") ";
                                            }
                                 query+= " AND PBA.BA_FCH_PROC BETWEEN TO_DATE('"+fechaIni+"','dd-MM-yyyy') AND TO_DATE('"+fechaFin+"','dd-MM-yyyy') "
                                          + " and PBA.BA_T_ARCH='O' " 
                                          + " order by numero ";	
        	        db.setQuerySelect( query );
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
	    }
	    catch (Exception ex) {
	      throw new WellException(
	        "com.wellcom.prosa.sacii.getArchivoEntrada: "
	        + ex.toString());
	    }
	return cbValues;
}

        public ArrayList getEntidadesTx(HttpSession session, String valores) throws WellException {
		String sessionID;
		Database db;
		ArrayList cbValues;
		
		try {
			sessionID = session.getId() + "db";
			db = (Database)session.getAttribute( sessionID );

				query = "SELECT NUMERO_PROSA, (NUMERO_PROSA || ' ' || DESCRIPCION) ENTIDADES "
							+"FROM PMADMIN.PRSA_ENTIDADES where NUMERO_PROSA IN ("+valores+") ORDER BY 1";
//							+" AND NUMERO_FIID NOT LIKE 'U%' " 
//                            +" AND DESCRIPCION NOT LIKE '%DOLARES%'";							
			db.setQuerySelect(query);
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
		} catch (Exception ex) {
			      throw new WellException("com.wellcom.prosa.sacii.ComboBox.getEntidadesTx: " + ex.toString());
		}
		return cbValues;
	}        
        public ArrayList getBinInternacionEntidad(HttpSession session,String valores) throws WellException {
		String sessionID;
		Database db;
		ArrayList cbValues;
		
		try {
			sessionID = session.getId() + "db";
			db = (Database)session.getAttribute( sessionID );
                            query="SELECT DISTINCT PB.PBIN_BIN, (PB.PBIN_BIN || ' ' || DESCRIPCION) DESCRIPCION\n" +
                                "FROM PMADMIN.PRSA_ENTIDADES PE\n" +
                                "INNER JOIN PMADMIN.PRSA_BIN PB\n" +
                                "ON PE.NUMERO_PROSA = PB.PBIN_ISS_ENTITY\n" +
                                "WHERE PB.PBIN_BIN IN ("+valores+")\n" +
                                "UNION ALL\n" +
                                "SELECT DISTINCT CBA.BINA_BIN, (CBA.BINA_BIN || ' ' || DESCRIPCION) DESCRIPCION\n" +
                                "FROM PMADMIN.VW_BUS_ACQ VBA\n" +
                                "INNER JOIN CORE.CZ_BIN_ACQ CBA\n" +
                                "ON VBA.BU_TX_ADQ = CBA.BINA_BU\n" +
                                "WHERE CBA.BINA_BIN in ("+valores+")\n" +
                                "UNION ALL\n" +
                                "SELECT DISTINCT CBI.BINI_BIN, (CBI.BINI_BIN || ' ' || DESCRIPCION) DESCRIPCION\n" +
                                "FROM PMADMIN.VW_BUS_EMI VBE\n" +
                                "INNER JOIN CORE.CZ_BIN_ISS CBI\n" +
                                "ON VBE.BU_TX_ISS = CBI.BINI_OWN_BU\n" +
                                "WHERE CBI.BINI_OWN_BU in ("+valores+")";
			db.setQuerySelect(query);
			db.executeQuerySelect();
			cbValues = db.getRSColsData();
		} catch (Exception ex) {
			      throw new WellException("com.wellcom.prosa.sacii.ComboBox.getEntidadesTx: " + ex.toString());
		}
		return cbValues;
	}    
/*#Marca de cambio:  SAS-DRT B-54-2904-15  Termina Modificación #  */	
}
