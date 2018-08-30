/*###############################################################################
 # Nombre del Programa :  formatT140.js                                          #
 #-------------------------------------------------------------------------------#
 # Autor               : Daniel Ramirez Torres                                   #
 # Compania            : SAS S.A. DE C.V.                                        #
 # Proyecto/Procliente : B-54-2904-15               Fecha: 21/04/2016            #
 # Modificacion        : Mejorar Reportería SAC2                                 #
 # Marca del Cambio    : B-54-2904-15 SAS-DRT                                    #
 #-------------------------------------------------------------------------------#
 # Numero de Parametros: 0                                                       #
 ###############################################################################*/

function filtrar(tipo) {
    var entidad = [];
    var entidadEr = [];
    var tipoTx = [];
    var ica = [];
    var IcaRe = [];
    var contadorTx = 0;
    var contMonN = 0;
    var contMonU = 0;
    var contRecImpo = 0;
    var contToRefus = 0;
    var contFEEMonN = 0;
    var contFEEU = 0;
    var valores = "";

//    alert(tipo);
    var infoDin = document.getElementById('infoDinH').value;

    var valorSplit = "";
    var valorDec = 0;
    var valorDec1 = 0;
    var cbotipoInfo = document.getElementById('tipoInfo').value;
    var cbotipoEnt = document.getElementById('Entidades');
    var cbotipoEntr = document.getElementById('EntidadesEr');
    var cbotipoTx = document.getElementById('tipoTx');
    var cbotipoIca = document.getElementById('tipoIca');
    var cbotipoIcaRe = document.getElementById('tipoIcaRe');
    if (cbotipoInfo != "None") {
        if (cbotipoInfo == "0") {
            valorSplit = "?";//rechazos
            valorDec = 1;
            valorDec1 = 0;
            cbotipoEnt.style.display = 'none';
            cbotipoEntr.style.display = 'inline';
            cbotipoTx.style.display = 'none';
            cbotipoIca.style.display = 'none';
            cbotipoTx.value = "None";
            cbotipoEnt.value = "None";
            document.getElementById('tipoIca').value = "None";
            document.getElementById('trTtx').style.display = 'none';
            document.getElementById('trTR').style.display = 'inline';
            document.getElementById('tipoIcaRe').style.display = 'inline';


        } else if (cbotipoInfo == "1") {
            valorSplit = "!";
            valorDec1 = 1;
            valorDec = 0;
            cbotipoEntr.style.display = 'none';
            cbotipoEnt.style.display = 'inline';
            cbotipoTx.style.display = 'inline';
            cbotipoEntr.value = "None";
            cbotipoIcaRe.value = "None";
            cbotipoIca.style.display = 'inline';
            document.getElementById('trTR').style.display = 'none';
            document.getElementById('tipoIcaRe').style.display = 'none';
            document.getElementById('trTtx').style.display = 'inline';
        }
    } else {
        document.getElementById('infoDin').innerHTML = valores;
        return;
    }
    entidad = pushCbo(cbotipoEnt);
    ica = pushCbo(cbotipoIca);
    entidadEr = pushCbo(cbotipoEntr);
    tipoTx = pushCbo(cbotipoTx);
    IcaRe = pushCbo(cbotipoIcaRe);
    var infoDinAr0 = document.getElementById('infoDinH').value.split(";");

    var infoDinAr = infoDinAr0[valorDec].split(valorSplit);
    for (var i = 0; i < infoDinAr.length; i++) {
//    for (var i = (0 + 1); i < (infoDinAr.length - valorDec1); i++) {
        if (ica.length != 0) {
            for (var p = 0; p < ica.length; p++) {
                console.log("-" + infoDinAr[i].substring(6, 12) + "-");
                if (Number(infoDinAr[i].substring(6, 12)) == Number(ica[p])) {
                    if (entidad.length != 0) {
                        for (var l = 0; l < entidad.length; l++) {
//        console.log(infoDinAr[i].substring(12,16)+"---"+entidad[l]);
                            if (tipoTx.length != 0) {
                                if (Number(infoDinAr[i].substring(12, 16)) == Number(entidad[l])) {
                                    for (var n = 0; n < tipoTx.length; n++) {
                                        if (infoDinAr[i].substring(31, 46).replace(" ", "") == tipoTx[n].replace(" ", "")) {
                                            valores += infoDinAr[i];
                                            if (infoDinAr[i].substring(51, 59) != "") {
                                                contadorTx += parseInt(infoDinAr[i].substring(51, 59).replace(" ", ""));
                                            }
                                            if (infoDinAr[i].substring(86, 94).replace(" ", "") == "840-USD") {
                                                contMonU += parseFloat(infoDinAr[i].substring(60, 83).replace(" ", "").replace(",", ""));
                                            } else if (infoDinAr[i].substring(86, 94).replace(" ", "") == "484-MXN") {
                                                contMonN += parseFloat(infoDinAr[i].substring(60, 83).replace(" ", "").replace(",", ""));
                                            }
                                            if (infoDinAr[i].substring(118, 126).replace(" ", "") == "484-MXN") {
                                                contFEEMonN += parseFloat(infoDinAr[i].substring(95, 115).replace(" ", "").replace(",", ""));
                                            } else if (infoDinAr[i].substring(118, 126).replace(" ", "") == "840-USD") {
                                                contFEEU += parseFloat(infoDinAr[i].substring(95, 115).replace(" ", "").replace(",", ""));
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (Number(infoDinAr[i].substring(12, 16)) == Number(entidad[l])) {
                                    valores += infoDinAr[i];
                                    if (infoDinAr[i].substring(51, 59) != "") {
                                        contadorTx += parseInt(infoDinAr[i].substring(51, 59).replace(" ", ""));
                                    }
                                    if (infoDinAr[i].substring(86, 94).replace(" ", "") == "840-USD") {
                                        contMonU += parseFloat(infoDinAr[i].substring(60, 83).replace(" ", "").replace(",", ""));
                                    } else if (infoDinAr[i].substring(86, 94).replace(" ", "") == "484-MXN") {
                                        contMonN += parseFloat(infoDinAr[i].substring(60, 83).replace(" ", "").replace(",", ""));
                                    }
                                    if (infoDinAr[i].substring(118, 126).replace(" ", "") == "484-MXN") {
                                        contFEEMonN += parseFloat(infoDinAr[i].substring(95, 115).replace(" ", "").replace(",", ""));
                                    } else if (infoDinAr[i].substring(118, 126).replace(" ", "") == "840-USD") {
                                        contFEEU += parseFloat(infoDinAr[i].substring(95, 115).replace(" ", "").replace(",", ""));
                                    }
                                }
                            }
                        }
                    } else {
                        if (tipoTx.length != 0) {

                            for (var n = 0; n < tipoTx.length; n++) {
                                if (infoDinAr[i].substring(31, 46).replace(" ", "") == tipoTx[n].replace(" ", "")) {
                                    valores += infoDinAr[i];
                                    if (infoDinAr[i].substring(51, 59) != "") {
                                        contadorTx += parseInt(infoDinAr[i].substring(51, 59).replace(" ", ""));
                                    }
                                    if (infoDinAr[i].substring(86, 94).replace(" ", "") == "840-USD") {
                                        contMonU += parseFloat(infoDinAr[i].substring(60, 83).replace(" ", "").replace(",", ""));
                                    } else if (infoDinAr[i].substring(86, 94).replace(" ", "") == "484-MXN") {
                                        contMonN += parseFloat(infoDinAr[i].substring(60, 83).replace(" ", "").replace(",", ""));
                                    }
                                    if (infoDinAr[i].substring(118, 126).replace(" ", "") == "484-MXN") {
                                        contFEEMonN += parseFloat(infoDinAr[i].substring(95, 115).replace(" ", "").replace(",", ""));
                                    } else if (infoDinAr[i].substring(118, 126).replace(" ", "") == "840-USD") {
                                        contFEEU += parseFloat(infoDinAr[i].substring(95, 115).replace(" ", "").replace(",", ""));
                                    }
                                }
                            }
                        } else {
                            if (entidadEr.length != 0) {
                                for (var m = 0; m < entidadEr.length; m++) {
                                    if (Number(infoDinAr[i].substring(12, 16)) == Number(entidadEr[m])) {
                                        contRecImpo += parseFloat(infoDinAr[i].substring(43, 59));
                                        contToRefus++;
                                        valores += infoDinAr[i];
                                    }
                                }
                            } else {
                                valores += infoDinAr[i];
                                if (infoDinAr[i].substring(51, 59) != "") {
                                    contadorTx += parseInt(infoDinAr[i].substring(51, 59).replace(" ", ""));
                                }
                                if (infoDinAr[i].substring(86, 94).replace(" ", "") == "840-USD") {
                                    contMonU += parseFloat(infoDinAr[i].substring(60, 83).replace(" ", "").replace(",", ""));
                                } else if (infoDinAr[i].substring(86, 94).replace(" ", "") == "484-MXN") {
                                    contMonN += parseFloat(infoDinAr[i].substring(60, 83).replace(" ", "").replace(",", ""));
                                }
                                if (infoDinAr[i].substring(43, 58) != "") {
                                    contRecImpo += parseFloat(infoDinAr[i].substring(43, 59));
                                    contToRefus++;
                                }
                                if (infoDinAr[i].substring(118, 126).replace(" ", "") == "484-MXN") {
                                    contFEEMonN += parseFloat(infoDinAr[i].substring(95, 115).replace(" ", "").replace(",", ""));
                                } else if (infoDinAr[i].substring(118, 126).replace(" ", "") == "840-USD") {
                                    contFEEU += parseFloat(infoDinAr[i].substring(95, 115).replace(" ", "").replace(",", ""));
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if (entidad.length != 0) {
                for (var l = 0; l < entidad.length; l++) {
//        console.log(infoDinAr[i].substring(12,16)+"---"+entidad[l]);
                    if (tipoTx.length != 0) {
                        if (Number(infoDinAr[i].substring(12, 16)) == Number(entidad[l])) {
                            for (var n = 0; n < tipoTx.length; n++) {
                                if (infoDinAr[i].substring(31, 46).replace(" ", "") == tipoTx[n].replace(" ", "")) {
                                    valores += infoDinAr[i];
                                    if (infoDinAr[i].substring(51, 59) != "") {
                                        contadorTx += parseInt(infoDinAr[i].substring(51, 59).replace(" ", ""));
                                    }
                                    if (infoDinAr[i].substring(86, 94).replace(" ", "") == "840-USD") {
                                        contMonU += parseFloat(infoDinAr[i].substring(60, 83).replace(" ", "").replace(",", ""));
                                    } else if (infoDinAr[i].substring(86, 94).replace(" ", "") == "484-MXN") {
                                        contMonN += parseFloat(infoDinAr[i].substring(60, 83).replace(" ", "").replace(",", ""));
                                    }
                                    if (infoDinAr[i].substring(118, 126).replace(" ", "") == "484-MXN") {
                                        contFEEMonN += parseFloat(infoDinAr[i].substring(95, 115).replace(" ", "").replace(",", ""));
                                    } else if (infoDinAr[i].substring(118, 126).replace(" ", "") == "840-USD") {
                                        contFEEU += parseFloat(infoDinAr[i].substring(95, 115).replace(" ", "").replace(",", ""));
                                    }
                                }
                            }
                        }
                    } else {
                        if (Number(infoDinAr[i].substring(12, 16)) == Number(entidad[l])) {
                            valores += infoDinAr[i];
                            if (infoDinAr[i].substring(51, 59) != "") {
                                contadorTx += parseInt(infoDinAr[i].substring(51, 59).replace(" ", ""));
                            }
                            if (infoDinAr[i].substring(86, 94).replace(" ", "") == "840-USD") {
                                contMonU += parseFloat(infoDinAr[i].substring(60, 83).replace(" ", "").replace(",", ""));
                            } else if (infoDinAr[i].substring(86, 94).replace(" ", "") == "484-MXN") {
                                contMonN += parseFloat(infoDinAr[i].substring(60, 83).replace(" ", "").replace(",", ""));
                            }
                            if (infoDinAr[i].substring(118, 126).replace(" ", "") == "484-MXN") {
                                contFEEMonN += parseFloat(infoDinAr[i].substring(95, 115).replace(" ", "").replace(",", ""));
                            } else if (infoDinAr[i].substring(118, 126).replace(" ", "") == "840-USD") {
                                contFEEU += parseFloat(infoDinAr[i].substring(95, 115).replace(" ", "").replace(",", ""));
                            }
                        }
                    }
                }
            } else {
                if (tipoTx.length != 0) {
                    for (var n = 0; n < tipoTx.length; n++) {
                        if (infoDinAr[i].substring(31, 46).replace(" ", "") == tipoTx[n].replace(" ", "")) {
                            valores += infoDinAr[i];
                            if (infoDinAr[i].substring(51, 59) != "") {
                                contadorTx += parseInt(infoDinAr[i].substring(51, 59).replace(" ", ""));
                            }
                            if (infoDinAr[i].substring(86, 94).replace(" ", "") == "840-USD") {
                                contMonU += parseFloat(infoDinAr[i].substring(60, 83).replace(" ", "").replace(",", ""));
                            } else if (infoDinAr[i].substring(86, 94).replace(" ", "") == "484-MXN") {
                                contMonN += parseFloat(infoDinAr[i].substring(60, 83).replace(" ", "").replace(",", ""));
                            }
                            if (infoDinAr[i].substring(118, 126).replace(" ", "") == "484-MXN") {
                                contFEEMonN += parseFloat(infoDinAr[i].substring(95, 115).replace(" ", "").replace(",", ""));
                            } else if (infoDinAr[i].substring(118, 126).replace(" ", "") == "840-USD") {
                                contFEEU += parseFloat(infoDinAr[i].substring(95, 115).replace(" ", "").replace(",", ""));
                            }
                        }
                    }
                } else {
                    if (entidadEr.length != 0) {
                        for (var m = 0; m < entidadEr.length; m++) {
                            //console.log("aqiu:" + infoDinAr[i].substring(3, 7)+"-");
                            if (Number(infoDinAr[i].substring(12, 16)) == Number(entidadEr[m])) {
                                if (IcaRe.length != 0) {
                                    for (var r = 0; r < IcaRe.length; r++) {
                                        if (Number(infoDinAr[i].substring(6, 12)) == Number(IcaRe[r])) {
                                            contRecImpo += parseFloat(infoDinAr[i].substring(43, 59));
                                            contToRefus++;
                                            valores += infoDinAr[i];
                                        }
                                    }
                                } else {
                                    contRecImpo += parseFloat(infoDinAr[i].substring(43, 59));
                                    contToRefus++;
                                    valores += infoDinAr[i];
                                }
                            }
                        }
                    } else {
                        if (IcaRe.length != 0) {
                            for (var r = 0; r < IcaRe.length; r++) {
                                if (Number(infoDinAr[i].substring(6, 12)) == Number(IcaRe[r])) {
                                    if (infoDinAr[i].substring(51, 59) != "") {
                                        contadorTx += parseInt(infoDinAr[i].substring(51, 59).replace(" ", ""));
                                    }
                                    if (infoDinAr[i].substring(86, 94).replace(" ", "") == "840-USD") {
                                        contMonU += parseFloat(infoDinAr[i].substring(60, 83).replace(" ", "").replace(",", ""));
                                    } else if (infoDinAr[i].substring(86, 94).replace(" ", "") == "484-MXN") {
                                        contMonN += parseFloat(infoDinAr[i].substring(60, 83).replace(" ", "").replace(",", ""));
                                    }
                                    if (infoDinAr[i].substring(43, 58) != "") {
                                        contRecImpo += parseFloat(infoDinAr[i].substring(43, 59));
                                        contToRefus++;
                                    }
                                    if (infoDinAr[i].substring(118, 126).replace(" ", "") == "484-MXN") {
                                        contFEEMonN += parseFloat(infoDinAr[i].substring(95, 115).replace(" ", "").replace(",", ""));
                                    } else if (infoDinAr[i].substring(118, 126).replace(" ", "") == "840-USD") {
                                        contFEEU += parseFloat(infoDinAr[i].substring(95, 115).replace(" ", "").replace(",", ""));
                                    }
                                    valores += infoDinAr[i];
                                }
                            }
                        } else {
                            if (infoDinAr[i].substring(51, 59) != "") {
                                contadorTx += parseInt(infoDinAr[i].substring(51, 59).replace(" ", ""));
                            }
                            if (infoDinAr[i].substring(86, 94).replace(" ", "") == "840-USD") {
                                contMonU += parseFloat(infoDinAr[i].substring(60, 83).replace(" ", "").replace(",", ""));
                            } else if (infoDinAr[i].substring(86, 94).replace(" ", "") == "484-MXN") {
                                contMonN += parseFloat(infoDinAr[i].substring(60, 83).replace(" ", "").replace(",", ""));
                            }
                            if (infoDinAr[i].substring(43, 58) != "") {
                                contRecImpo += parseFloat(infoDinAr[i].substring(43, 59));
                                contToRefus++;
                            }
                            if (infoDinAr[i].substring(118, 126).replace(" ", "") == "484-MXN") {
                                contFEEMonN += parseFloat(infoDinAr[i].substring(95, 115).replace(" ", "").replace(",", ""));
                            } else if (infoDinAr[i].substring(118, 126).replace(" ", "") == "840-USD") {
                                contFEEU += parseFloat(infoDinAr[i].substring(95, 115).replace(" ", "").replace(",", ""));
                            }
                            valores += infoDinAr[i];
                        }
                    }
                }
            }
        }
    }
    document.getElementById('infoDin').innerHTML = valores;
    document.getElementById('contTx').value = currency(contadorTx, 0, [',', ",", ',']);
    document.getElementById('sumReUS').value = currency(contMonU, 2, [',', ",", '.']);
    document.getElementById('sumReMX').value = currency(contMonN, 2, [',', ",", '.']);
    document.getElementById('sumTImp').value = currency(contRecImpo, 2, [',', ",", '.']);
    document.getElementById('contRe').value = currency(contToRefus, 0, [',', ",", ',']);
    document.getElementById('sumFeeMX').value = currency(contFEEMonN, 2, [',', ",", ',']);
    document.getElementById('sumFeeUS').value = currency(contFEEU, 2, [',', ",", ',']);
}

function currency(value, decimals, separators) {
    decimals = decimals >= 0 ? parseInt(decimals, 0) : 2;
    separators = separators || ['.', "'", ','];
    var number = (parseFloat(value) || 0).toFixed(decimals);
    if (number.length <= (4 + decimals))
        return number.replace('.', separators[separators.length - 1]);
    var parts = number.split(/[-.]/);
    value = parts[parts.length > 1 ? parts.length - 2 : 0];
    var result = value.substr(value.length - 3, 3) + (parts.length > 1 ?
            separators[separators.length - 1] + parts[parts.length - 1] : '');
    var start = value.length - 6;
    var idx = 0;
    while (start > -3) {
        result = (start > 0 ? value.substr(start, 3) : value.substr(0, 3 + start))
                + separators[idx] + result;
        idx = (++idx) % 2;
        start -= 3;
    }
    return (parts.length == 3 ? '-' : '') + result;
}

function pushCbo(cbo) {
    var arrayCbo = [];
    if (cbo.value != "None") {
        for (var indice = 0; indice < cbo.length; indice++)
        {
            if (cbo.options[indice].selected) {
                if (cbo.options[indice].value != "None") {
                    arrayCbo.push(cbo.options[indice].value);
                }

            }
        }
    }
    return arrayCbo;
}