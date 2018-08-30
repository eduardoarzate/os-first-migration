/*###############################################################################
#                               MODIFICACIONES                                  #
# Compania            :  SAS S.A. DE C.V.                                  		#
# Proyecto/Procliente :  P-06-0527-11                Fecha: 13/08/2015          #
#                     :  Implementación de Hub de Pagos en PROSA                #
# Modificación        : AUTOMATIZACION DE PREPAGO                               #
#-----------------------------------------------------------------------------  #
#################################################################################
# Numero de Parametros: 0                                                       #
################################################################################# */

package com.wellcom.prosa.sacii;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class ControllerServletUtil 
{
	public static void SICLIRH0130Main(HttpSession session,String PRSA_SETL_IND,String PRSA_RPT_IND,String initDate,String endDate)
    {
		    session.setAttribute( "PRSA_SETL_IND", PRSA_SETL_IND);
    		session.setAttribute( "PRSA_RPT_IND", PRSA_RPT_IND);
    		session.setAttribute("txtfStartDate", initDate);
    		session.setAttribute("txtfEndDate", endDate);
	}
	
	public static void SICLIRH0135Main(HttpSession session,String PRSA_SETL_IND,String PRSA_RPT_IND,String initDate,String endDate)
    {
		    session.setAttribute( "PRSA_SETL_IND", PRSA_SETL_IND);
    		session.setAttribute( "PRSA_RPT_IND", PRSA_RPT_IND);
    		session.setAttribute("txtfStartDate", initDate);
    		session.setAttribute("txtfEndDate", endDate);
	}
	
	public static void SICLIRH0140Main(HttpSession session,String PRSA_SETL_IND,String PRSA_RPT_IND,String initDate,String endDate)
    {
		    session.setAttribute( "PRSA_SETL_IND", PRSA_SETL_IND);
    		session.setAttribute( "PRSA_RPT_IND", PRSA_RPT_IND);
    		session.setAttribute("txtfStartDate", initDate);
    	    session.setAttribute("txtfEndDate", endDate);
	}
	
	public static void SICLIRH0430Main(HttpSession session,String PRSA_SETL_IND,String PRSA_RPT_IND,String initDate,String endDate,String interredesStr)
    {
		    session.setAttribute( "PRSA_SETL_IND", PRSA_SETL_IND);
    		session.setAttribute( "PRSA_RPT_IND", PRSA_RPT_IND);
    		session.setAttribute( "txtfStartDate", initDate);
    		session.setAttribute( "txtfEndDate", endDate);
    		session.setAttribute( "interred", interredesStr);
	}
	
	public static void SICLIRHP320Main(HttpSession session,String PRSA_SETL_IND,String PRSA_RPT_IND,String initDate,String endDate)
    {
		    session.setAttribute( "PRSA_SETL_IND", PRSA_SETL_IND);
    		session.setAttribute( "PRSA_RPT_IND", PRSA_RPT_IND);
    	    session.setAttribute("txtfStartDate", initDate);
    	    session.setAttribute("txtfEndDate", endDate);
	}

    public static void SICLIRH0110Main(HttpSession session,String PRSA_SETL_IND,String PRSA_RPT_IND,String initDate,String endDate,String bancosEmi)
    {
    	    session.setAttribute( "PRSA_SETL_IND", PRSA_SETL_IND);
            session.setAttribute( "PRSA_RPT_IND", PRSA_RPT_IND);
            session.setAttribute("txtfStartDate", initDate);
            session.setAttribute("txtfEndDate", endDate);
            session.setAttribute("bancoEmi", bancosEmi);
    }
	
	public static void SICLIRH0120Main(HttpSession session,String PRSA_SETL_IND,String PRSA_RPT_IND,String initDate,String endDate,String interredesStr,String divisionesStr)
    {
			session.setAttribute( "PRSA_SETL_IND", PRSA_SETL_IND);
    		session.setAttribute( "PRSA_RPT_IND", PRSA_RPT_IND);
    		session.setAttribute( "txtfStartDate", initDate);
    		session.setAttribute( "txtfEndDate", endDate);
    		session.setAttribute( "interred", interredesStr);
    		session.setAttribute( "division", divisionesStr);
	}
	
	public static void SICMTRH001Main(HttpSession session,String PRSA_SETL_IND,String PRSA_RPT_IND,String initDate,String endDate)
    {
		    session.setAttribute( "PRSA_SETL_IND", PRSA_SETL_IND);
    		session.setAttribute( "PRSA_RPT_IND", PRSA_RPT_IND);
    		session.setAttribute( "txtfStartDate", initDate);
    		session.setAttribute( "txtfEndDate", endDate);
	}
	
	public static void SICCOMR001Main(HttpSession session,String PRSA_SETL_IND,String PRSA_RPT_IND,String initDate,String endDate)
    {
		    session.setAttribute( "PRSA_SETL_IND", PRSA_SETL_IND);
    		session.setAttribute( "PRSA_RPT_IND", PRSA_RPT_IND);
    		session.setAttribute("txtfStartDate", initDate);
    	    session.setAttribute("txtfEndDate", endDate);
	}
}
