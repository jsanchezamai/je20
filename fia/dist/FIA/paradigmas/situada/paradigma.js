"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.IASituada = void 0;
const genesis_block_1 = require("../../genesis-block");
const labels_1 = require("../../i18/labels");
var IASituada;
(function (IASituada) {
    class iIASituada extends genesis_block_1.GenesisBlock {
    }
    IASituada.iIASituada = iIASituada;
    IASituada.fiaSituada = new iIASituada();
    IASituada.fiaSituada.nombre = labels_1.i18.FIA_SITUADA_LABEL;
    IASituada.fiaSituada.razona =
        (w, i) => {
            return "Sí";
        };
})(IASituada || (exports.IASituada = IASituada = {}));
