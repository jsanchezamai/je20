"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.IASituada = void 0;
const genesis_block_1 = require("../../genesis-block");
var IASituada;
(function (IASituada) {
    class iIASituada extends genesis_block_1.GenesisBlock {
    }
    IASituada.iIASituada = iIASituada;
    IASituada.fiaSituada = new iIASituada();
    IASituada.fiaSituada.nombre = "FIA Situada";
    IASituada.fiaSituada.razona =
        (w, i) => {
            return "Sí";
        };
})(IASituada || (exports.IASituada = IASituada = {}));
