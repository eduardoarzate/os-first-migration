/*###############################################################################
 # Nombre del Programa :  envio.js                                               #
 # Autor               :  JOAQUIN MOJICA Q.                                      #
 # Compania            :  WELLCOM S.A. DE C.V.                                   #
 # Proyecto/Procliente :  P-08-299-04                 	   FECHA:15/10/2008     #
 # Descripcion General :										                    #
 #                                                                               #
 # Programa Dependiente:                                                         #
 # Programa Subsecuente:                                                         #
 # Cond. de ejecucion  :						                                    #
 #                                                                               #
 #                                                                               #
 # Dias de ejecucion   :														    #
 #################################################################################
 #								MODIFICACIONES                                  #
 # Autor               :  German Gonzalez                                        #
 # Compania            :  WELLCOM S.A. DE C.V.                                   #
 # Proyecto/Procliente :  N-08-2253-12                Fecha: 13/02/2013          #
 # Modificación        :  Adicionar indicadores ABM a Reporte de log certificado #
 #-----------------------------------------------------------------------------  #
 #								MODIFICACIONES                                  #
 # Autor               :  German Gonzalez                                        #
 # Compania            :  WELLCOM S.A. DE C.V.                                   #
 # Proyecto/Procliente :  N-04-2207-13                Fecha: 02/12/2013          #
 # Modificación        :  Actualización de LOG CERTIFICADO con Indicadores ABM a #
 #                        detalle                                                #
 #-----------------------------------------------------------------------------  #
 # Autor               : Carlos Mendez De Luna                                   #
 # Compania            : PROSA                                                   #
 # Proyecto/Procliente : C-04-3035-13                            Fecha:11/12/2013#
 # Modificacion        : Generacion de Proceso de Diferencia de Cuota de         #
 #                       Intercambio de EGLO SAC2                                #
 #-----------------------------------------------------------------------------  #
 # Autor               : Salvador Montiel                                        #
 # Compania            : AM Estudio                                              #
 # Proyecto/Procliente : P-54-2940-14               Fecha: 23/04/2015            #
 # Modificacion        : Soporte Interactivo (FAQs,Tutoriales,Manuales)          #
 # Marca del Cambio    : P-54-2940-14 AMEstudio 23.04.2015                       #
 #-------------------------------------------------------------------------------#
 # Autor               : Daniel Ramirez Torres                                   #
 # Compania            : SAS S.A. DE C.V.                                        #
 # Proyecto/Procliente : B-54-2904-15               Fecha: 27/06/2016            #
 # Modificacion        : Mejorar Reportería SAC2                                 #
 # Marca del Cambio    : B-54-2904-15 SAS-DRT                                    #
 #-----------------------------------------------------------------------------   #
 # Autor               :  Daniel Ramírez Torres                                   #
 # Compania            :  SAS S.A. DE C.V.                                        #
 # Proyecto/Procliente :  F-52-8063-16                 Fecha: 10/01/2017          #
 # Modificacion        :  Mejora Conexiones  SAC2                                 #
 # Marca del Cambio    :  SAS-DRT F-52-8063-16                                    #
 #------------------------------------------------------------------------------- #
 # Numero de Parametros: 0                                                       #
 ###############################################################################*/

var tagScript = '(?:<script.*?>)((\n|\r|.)*?)(?:<\/script>)';
/**
 * Eval script fragment
 * @return String
 */
String.prototype.evalScript = function ()
{
    return (this.match(new RegExp(tagScript, 'img')) || []).evalScript();
};
/**
 * strip script fragment
 * @return String
 */
String.prototype.stripScript = function ()
{
    return this.replace(new RegExp(tagScript, 'img'), '');
};
/**
 * extract script fragment
 * @return String
 */
String.prototype.extractScript = function ()
{
    var matchAll = new RegExp(tagScript, 'img');
    return (this.match(matchAll) || []);
};
/**
 * Eval scripts
 * @return String
 */
Array.prototype.evalScript = function (extracted)
{
    var s = this.map(function (sr) {
        var sc = (sr.match(new RegExp(tagScript, 'im')) || ['', ''])[1];
        if (window.execScript) {
            window.execScript(sc);
        } else
        {
            window.setTimeout(sc, 0);
        }
    });
    return true;
};
/**
 * Map array elements
 * @param {Function} fun
 * @return Function
 */
Array.prototype.map = function (fun)
{
    if (typeof fun !== "function") {
        return false;
    }
    var i = 0, l = this.length;
    for (i = 0; i < l; i++)
    {
        fun(this[i]);
    }
    return true;
};



























var element = null;
var element2 = null;
var pagina_requerida = false;
var url = null;
var initDate = "";
var BancoAdq = "";
var BancoEmi = "";
var NoTrans = "";
var Fuente = "";
var Importe = "";
var NoCuenta = "";
var NoAuto = "";
var NoRef = "";
var NoComer = "";
var NomComer = "";
var GiroComer = "";
//var TipoCaptura = "";

//Marca inicio: P-54-2940-14 AMEstudio 23.04.2015

function rbtnCheckedSoporte()
{
    var nL = document.getElementsByName("rbtn");
    var val = '-1';

    for (var i = 0; i < nL.length; i++) {
        if (nL[i].checked) {
            val = i;
            /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
            cambioPaginaReload('ControllerServletHerr?action=detallesoporte&rbtn=' + val, 'rightPanel');
            /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
        }
    }
}

function descargarSoporte(id)
{
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
    cambioPaginaReload('ControllerServletHerr?action=descargarsoporte&rbtn=' + id, 'rightPanel');
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
}

function editarSoporte(id)
{
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
    cambioPaginaReload('ControllerServletHerr?action=editarsoporte&rbtn=' + id, 'rightPanel');
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
}

function eliminarSoporte(id)
{

    if (confirm('Estas seguro que deseas eliminar este registro?'))
    {
        /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
        cambioPaginaReload('ControllerServletHerr?action=eliminarsoporte&rbtn=' + id, 'rightPanel');
        /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
    } else
    {
        return false;
    }



}

//Marca fin: P-54-2940-14 AMEstudio 23.04.2015

function urlDescarga(action)
{

    var urlTmp = "ReloadServlet?action=" + action;
    return urlTmp;

}


function sendDatasSoporte(action, idPos)
{

    if (action != "")
    {
        url = urlDescarga(action);
        if (window.XMLHttpRequest)
        {
            // Si es Mozilla, Safari etc
            pagina_requerida = new XMLHttpRequest();
        } else if (window.ActiveXObject)
        {
            // pero si es IEz
            try
            {
                pagina_requerida = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e)
            {
                // en caso que sea una versión antigua
                try
                {
                    pagina_requerida = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e)
                {
                }
            }
        } else
            return false;

        pagina_requerida.onreadystatechange = function ()
        {
            // función de respuesta
            cargarpagina2(pagina_requerida, idPos);
        }

        pagina_requerida.open('POST', url, true); // asignamos los métodos open y send
        pagina_requerida.send(null);
    } else
    {

    }
}

//Marca fin: AMEstudio

//1 Parametro
function sendData(id, action, idPos)
{
    /* 
     Marca del Cambio : WELL-EMQ-P-02-1202-09 Inicia la Modificacion   08/02/2010
     */
    //alert("valor: "+action);
    if ((id == "interred" && action == "division") || (id == "bancoAdq" && action == "archivoAdq") || (id == "fiid" && action == "cargaresultado") || (id == "banco" && action == "cargacomercio") || (id == "interred" && action == "divisiondol") || (id == "banco" && action == "cargacomercio") || (id == "bancoEmi" && action == "archivo0054") || (id == "tipoProc" && action == "cargafavor") || (id == "bancoEmi" && action == "archivoEmi") || (id == "bancoAdq" && action == "fuente")) {
        /* 
         Marca del Cambio : WELL-EMQ-P-02-1202-09 Finaliza la Modificacion   08/02/2010
         */
        var elementSelection = document.getElementById(id);
        element = "";
        for (i = 0; i < elementSelection.length; i++) {
            if (elementSelection[i].selected) {
                if (element != "")
                    element += ","
                element += elementSelection[i].value;
            }
        }
    } else
        element = document.getElementById(id).value;

    url = createUrl(action, id, element);
    if (window.XMLHttpRequest)
    {
        // Si es Mozilla, Safari etc
        pagina_requerida = new XMLHttpRequest();
    } else if (window.ActiveXObject)
    {
        // pero si es IE
        try
        {
            pagina_requerida = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e)
        {
            // en caso que sea una versión antigua
            try
            {
                pagina_requerida = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e)
            {
            }
        }
    } else
        return false;
    pagina_requerida.onreadystatechange = function ()
    {
        // función de respuesta
        cargarpaginaR(pagina_requerida, idPos);
    }

    pagina_requerida.open('POST', url, true); // asignamos los métodos open y send
    pagina_requerida.send(null);
}

function createUrl(action, id, element)
{
    var urlTmp = "ReloadServlet?action=" + action + "&" + id + "=" + element;
    return urlTmp;
}

function cargarpaginaR(pagina_requerida, idPos)
{
    if (pagina_requerida.readyState == 4 && (pagina_requerida.status == 200 || window.location.href.indexOf("http") == -1)) {
        var scs = pagina_requerida.responseText.extractScript();
        document.getElementById(idPos).innerHTML = pagina_requerida.responseText.stripScript();
        scs.evalScript();
    }
}

//2 Parametros
function sendDatas(id, id2, action, idPos)
{
    element = document.getElementById(id).value;
    element2 = document.getElementById(id2).value;
    if (element != "")
    {
        url = createUrls(id, id2, action, element, element2);
        if (window.XMLHttpRequest)
        {
            // Si es Mozilla, Safari etc
            pagina_requerida = new XMLHttpRequest();
        } else if (window.ActiveXObject)
        {
            // pero si es IEz
            try
            {
                pagina_requerida = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e)
            {
                // en caso que sea una versión antigua
                try
                {
                    pagina_requerida = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e)
                {
                }
            }
        } else
            return false;

        pagina_requerida.onreadystatechange = function ()
        {
            // función de respuesta
            cargarpagina2(pagina_requerida, idPos);
        }

        pagina_requerida.open('POST', url, true); // asignamos los métodos open y send
        pagina_requerida.send(null);
    } else
    {

    }
}

/********** Inicio Modificacion WELLCOM N-08-2253-12  **********/
function sendDatas205(idInitDate, idEndDate, idCuenta, idComercio, idReferencia, action, idPos, accion)
{
    this.initDate = document.getElementById(idInitDate).value;
    this.endDate = document.getElementById(idEndDate).value;
    this.cuenta = document.getElementById(idCuenta).value;
    this.comercio = document.getElementById(idComercio).value;
    this.referencia = document.getElementById(idReferencia).value;

    url = createURL205(initDate, endDate, cuenta, comercio, referencia,
            idInitDate, idEndDate, idCuenta, idComercio, idReferencia, action, idPos, accion);


    if (window.XMLHttpRequest)
    {
        pagina_requerida = new XMLHttpRequest();
    } else if (window.ActiveXObject)
    {
        try
        {
            pagina_requerida = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e)
        {
            try
            {
                pagina_requerida = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e)
            {
            }
        }
    } else
        return false;

    pagina_requerida.onreadystatechange = function ()
    {
        cargarpagina(pagina_requerida, idPos);
    }
    pagina_requerida.open('POST', url, true);
    pagina_requerida.send(null);
}
/********** Fin    Modificacion WELLCOM N-08-2253-12  **********/

/********** Inicio Modificacion WELLCOM N-08-2253-12  **********/
function sendDatas205H(idInitDate, idEndDate, idCuenta, idComercio, idReferencia, action, idPos, accion)
{
    this.initDate = document.getElementById(idInitDate).value;
    this.endDate = document.getElementById(idEndDate).value;
    this.cuenta = document.getElementById(idCuenta).value;
    this.comercio = document.getElementById(idComercio).value;
    this.referencia = document.getElementById(idReferencia).value;

    url = createURL205H(initDate, endDate, cuenta, comercio, referencia,
            idInitDate, idEndDate, idCuenta, idComercio, idReferencia, action, idPos, accion);

    if (window.XMLHttpRequest)
    {
        pagina_requerida = new XMLHttpRequest();
    } else if (window.ActiveXObject)
    {
        try
        {
            pagina_requerida = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e)
        {
            try
            {
                pagina_requerida = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e)
            {
            }
        }
    } else
        return false;

    pagina_requerida.onreadystatechange = function ()
    {
        cargarpagina(pagina_requerida, idPos);
    }
    pagina_requerida.open('POST', url, true);
    pagina_requerida.send(null);
}
/********** Fin    Modificacion WELLCOM N-08-2253-12  **********/

/*Inicia cambio WELLCOM N-04-2207-13 29/13/2013 */
function sendDatasPTLF(idInitDateM, idInitDateY, idAfiliacion, idCuenta, idBanco, action, idPos, accion)
{
    this.initDateM = document.getElementById(idInitDateM).value;
    this.initDateY = document.getElementById(idInitDateY).value;
    this.afiliacion = document.getElementById(idAfiliacion).value;
    this.cuenta = document.getElementById(idCuenta).value;
    this.banco = document.getElementById(idBanco).value;

    url = createURLPTLF(initDateM, initDateY, afiliacion, cuenta, banco,
            idInitDateM, idInitDateY, idAfiliacion, idCuenta, idBanco, action, idPos, accion);

    if (window.XMLHttpRequest)
    {
        pagina_requerida = new XMLHttpRequest();
    } else if (window.ActiveXObject)
    {
        try
        {
            pagina_requerida = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e)
        {
            try
            {
                pagina_requerida = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e)
            {
            }
        }
    } else
        return false;

    pagina_requerida.onreadystatechange = function ()
    {
        cargarpagina(pagina_requerida, idPos);
    }
    pagina_requerida.open('POST', url, true);
    pagina_requerida.send(null);
}
/*Fin cambio WELLCOM N-04-2207-13 29/13/2013 */

function createUrls(id, id2, action, element, element2)
{
    var urlTmp = "ReloadServlet?action=" + action + "&" + id + "=" + element + "&" + id2 + "=" + element2;
    return urlTmp;
}

//function createUrls(id, id2, id3, action, element, element2, element3)
//{
//		var urlTmp="ReloadServlet?action="+action+"&"+id+"="+element+"&"+id2+"="+element2+"&"+id3+"="+element3;
//		return urlTmp;
//}

function cargarpagina2(pagina_requerida, idPos)
{
    if (pagina_requerida.readyState == 4 && (pagina_requerida.status == 200 || window.location.href.indexOf("http") == -1))
    {
        document.getElementById(idPos).innerHTML = pagina_requerida.responseText;
    }
}

//15 Parametros
function sendMoreDatas(idMes, idYear, idBancoAdq, idBancoEmi, idNoTrans, idFuente, idImporte,
        idNoCuenta, idNoAuto, idNoRef, idNoComer, idNomComer, idGiroComer, action, idPos, accion)
{

    this.mes = document.getElementById(idMes).value;
    this.year = document.getElementById(idYear).value;
//	this.endDate      = document.getElementById(idendDate).value;
    this.NoCuenta = document.getElementById(idNoCuenta).value;
    try
    {
        this.BancoAdq = document.getElementById(idBancoAdq).value;
        this.BancoEmi = document.getElementById(idBancoEmi).value;
        this.NoTrans = document.getElementById(idNoTrans).value;
        this.Fuente = document.getElementById(idFuente).value;
        this.Importe = document.getElementById(idImporte).value;
//		this.NomArchivo  = document.getElementById(idNomArchivo).value;
        this.NoComer = document.getElementById(idNoComer).value;
        this.NoAuto = document.getElementById(idNoAuto).value;
        this.NoRef = document.getElementById(idNoRef).value;
        this.NomComer = document.getElementById(idNomComer).value;
        this.GiroComer = document.getElementById(idGiroComer).value;
//		this.TipoCaptura = document.getElementById(idTipoCaptura).value;
    } catch (e)
    {
    }
    url = createUrlMoreParam('01' + '/' + mes + '/' + year, BancoAdq, BancoEmi, NoTrans, Fuente, Importe,
            NoCuenta, NoAuto, NoRef, NoComer, NomComer, GiroComer,
            'txtfStartDate', idBancoAdq, idBancoEmi, idNoTrans, idFuente, idImporte,
            idNoCuenta, idNoAuto, idNoRef, idNoComer, idNomComer, idGiroComer,
            action, idPos, accion);

    if (window.XMLHttpRequest)
    {
        // Si es Mozilla, Safari etc
        pagina_requerida = new XMLHttpRequest();
    } else if (window.ActiveXObject)
    {
        // pero si es IE
        try
        {
            pagina_requerida = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e)
        {
            // en caso que sea una versión antigua
            try
            {
                pagina_requerida = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e)
            {
            }
        }
    } else
        return false;

    pagina_requerida.onreadystatechange = function ()
    {
        // función de respuesta
        cargarpagina(pagina_requerida, idPos);
    }

    pagina_requerida.open('POST', url, true); // asignamos los métodos open y send
    pagina_requerida.send(null);
}

/********** Inicio Modificacion WELLCOM N-08-2253-12  **********/
function createURL205(initDate, endDate, cuenta, comercio, referencia,
        idInitDate, idEndDate, idCuenta, idComercio, idReferencia, action, idPos, accion)
{

    var urlTmp = "ReloadServlet?action=" + action + "&" +
            idInitDate + "=" + initDate + "&" +
            idEndDate + "=" + endDate + "&" +
            idCuenta + "=" + cuenta + "&" +
            idComercio + "=" + comercio + "&" +
            idReferencia + "=" + referencia + "&" +
            "accion" + "=" + accion + "&";
    return urlTmp;
}
/********** Fin    Modificacion WELLCOM N-08-2253-12  **********/

/********** Inicio Modificacion WELLCOM N-08-2253-12  **********/
function createURL205H(initDate, endDate, cuenta, comercio, referencia,
        idInitDate, idEndDate, idCuenta, idComercio, idReferencia, action, idPos, accion)
{
    var urlTmp = "ReloadServlet?action=" + action + "&" +
            idInitDate + "=" + initDate + "&" +
            idEndDate + "=" + endDate + "&" +
            idCuenta + "=" + cuenta + "&" +
            idComercio + "=" + comercio + "&" +
            idReferencia + "=" + referencia + "&" +
            "accion" + "=" + accion + "&";
    return urlTmp;
}
/********** Fin    Modificacion WELLCOM N-08-2253-12  **********/

/*Inicia cambio WELLCOM N-04-2207-2013 29/11/2013 */
function createURLPTLF(initDateM, initDateY, afiliacion, cuenta, banco,
        idInitDateM, idInitDateY, idAfiliacion, idCuenta, idBanco, action, idPos, accion)
{
    var urlTmp = "ReloadServlet?action=" + action + "&" +
            idInitDateM + "=" + initDateM + "&" +
            idInitDateY + "=" + initDateY + "&" +
            idAfiliacion + "=" + afiliacion + "&" +
            idCuenta + "=" + cuenta + "&" +
            idBanco + "=" + banco + "&" +
            "accion" + "=" + accion + "&";
    return urlTmp;
}
/*Fin cambio WELLCOM N-04-2207-13 29/11/2013 */

function createUrlMoreParam(initDate, BancoAdq, BancoEmi, NoTrans, Fuente, Importe,
        NoCuenta, NoAuto, NoRef, NoComer, NomComer, GiroComer,
        idinitDate, idBancoAdq, idBancoEmi, idNoTrans, idFuente, idImporte,
        idNoCuenta, idNoAuto, iNoRef, idNoComer, idNomComer, idGiroComer,
        action, idPos, accion)
{
    var urlTmp = "ReloadServlet?action=" + action + "&" +
            idinitDate + "=" + initDate + "&" +
//					idendDate     + "=" + endDate     + "&" +
            idBancoAdq + "=" + BancoAdq + "&" +
            idBancoEmi + "=" + BancoEmi + "&" +
            idNoTrans + "=" + NoTrans + "&" +
            idFuente + "=" + Fuente + "&" +
            idImporte + "=" + Importe + "&" +
//					idNomArchivo  + "=" + NomArchivo  + "&" +
            idNoCuenta + "=" + NoCuenta + "&" +
            idNoAuto + "=" + NoAuto + "&" +
            iNoRef + "=" + NoRef + "&" +
            idNoComer + "=" + NoComer + "&" +
            idNomComer + "=" + NomComer + "&" +
            idGiroComer + "=" + GiroComer + "&" +
//					idTipoCaptura + "=" + TipoCaptura + "&";
            "accion" + "=" + accion + "&";
    return urlTmp;
}

function cargarpagina(pagina_requerida, idPos)
{
    if (pagina_requerida.readyState == 4 && (pagina_requerida.status == 200 || window.location.href.indexOf("http") == -1))
    {
        try
        {
            ventanaModal.close();
        } catch (e)
        {
        }

        document.getElementById(idPos).innerHTML = pagina_requerida.responseText;
    }
}

function rbtnChecked()
{

    var nL = document.getElementsByName("rbtn");

    //alert(nL);
    var val = '-1';

    for (var i = 0; i < nL.length; i++) {
        //alert(nL[i]+" "+nL[i].checked);
        if (nL[i].checked) {
            val = i;
        }
    }
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
    cambioPaginaReload('ControllerServletHerr?action=delModSacii&rbtn=' + val, 'rightPanel');
    /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/

}

function rbtnCheckedTipo()
{

    var nL = document.getElementsByName("rbtn");

    //alert(nL);
    var val = '-1';

    for (var i = 0; i < nL.length; i++) {
        //alert(nL[i]+" "+nL[i].checked);
        if (nL[i].checked) {
            val = i;
            //Alert("val:"+val);
            /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
            cambioPaginaReload('ControllerServletHerr?action=edittipocambio&rbtn=' + val, 'rightPanel');
            /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
        }
    }
}

/* Inicia cambio C-04-3035-13 */
function rbtnCheckedDC()
{

    var nL = document.getElementsByName("rbtn");

    //alert(nL);
    var val = '-1';

    for (var i = 0; i < nL.length; i++) {
        //alert(nL[i]+" "+nL[i].checked);
        if (nL[i].checked) {
            val = i;
            //Alert("val:"+val);
            /*Modificacion: SAS-DRT F-52-8063-16 Marca de inicio*/
            cambioPaginaReload('ControllerServletHerr?action=editdifcuotas&rbtn=' + val, 'rightPanel');
            /*Modificacion: SAS-DRT F-52-8063-16 Marca de fin*/
        }
    }
}
/* Termina cambio C-04-3035-13 */
function ventana(id)
{
    this.ventanaModal = id;
}

/* Inicia cambio B-54-2904-15 SAS-DRT  */
function sendDataConciliacion(evento, tipo) {
    try {
        var xhttp = new XMLHttpRequest();
        var cadena = "";
        var txtfStartDate = document.getElementById('txtfStartDate').value;
        var txtfEndDate = document.getElementById('txtfEndDate').value;
        cadena += evento;
        cadena += "&txtfStartDate=" + txtfStartDate;
        cadena += "&txtfEndDate=" + txtfEndDate;
        cadena += "&banco=" + getValuesMultiple(tipo);
        cadena += "&tipo=" + tipo;
        document.getElementById("img01").style.display = 'inline';
        xhttp.onreadystatechange = function () {
            if (xhttp.readyState == 4 && xhttp.status == 200) {
                document.getElementById('comboBoxArchivo').innerHTML = xhttp.responseText;
                document.getElementById("img01").style.display = 'none';
            }
        };
        xhttp.open("POST", "ReloadServlet?action=" + cadena, true);
        xhttp.send();
    } catch (e)
    {
        document.getElementById("img01").style.display = 'none';
        alert("Error al solicitar información: " + e);
    }
}

function getValuesMultiple(elemento) {
    var cadena = "";
    var txtSelectedValuesObj = document.getElementById(elemento);
    for (var i = 0; i < txtSelectedValuesObj.options.length; i++) {
        if (txtSelectedValuesObj.options[i].selected) {
            cadena += txtSelectedValuesObj.options[i].value + ",";
        }
    }
    return cadena.substring(0, cadena.length - 1);
}

function sendDat1() {
    try {
        var xhttp = new XMLHttpRequest();
        var cadena = "";
        var txtfStartDate = document.getElementById('txtfStartDate').value;
        cadena += "&txtfStartDate=" + txtfStartDate;
        xhttp.onreadystatechange = function () {
            if (xhttp.readyState == 4 && xhttp.status == 200) {
                document.getElementById('bancoBin').innerHTML = xhttp.responseText;
            }
        };
        xhttp.open("POST", "ReloadServlet?action=loadBinIn" + cadena, true);
        xhttp.send();
    } catch (e)
    {
        alert("Error al solicitar información: " + e);
    }
}

/* Termina cambio B-54-2904-15 SAS-DRT */

