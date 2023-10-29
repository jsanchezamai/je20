"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.IACientifica = void 0;
const genesis_block_1 = require("../../genesis-block");
const labels_1 = require("../../i18/labels");
var IACientifica;
(function (IACientifica) {
    IACientifica.fiaFuerte = new genesis_block_1.GenesisBlock();
    IACientifica.fiaFuerte.nombre = labels_1.i18.FIA_CIENTIFICA_FUERTE_LABEL;
    IACientifica.fiaFuerte.razona =
        (w, i) => {
            return "Sí";
        };
    IACientifica.fiaDebil = new genesis_block_1.GenesisBlock();
    IACientifica.fiaDebil.nombre = labels_1.i18.FIA_CIENCITICA_DEBIL_LABEL;
    IACientifica.fiaDebil.razona =
        (w, i) => {
            return "No";
        };
})(IACientifica || (exports.IACientifica = IACientifica = {}));
