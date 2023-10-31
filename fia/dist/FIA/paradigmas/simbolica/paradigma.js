"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.IASimbolica = exports.Inferencia = void 0;
const genesis_block_1 = require("../../genesis-block");
const labels_1 = require("../../i18/labels");
;
;
;
class Inferencia {
}
exports.Inferencia = Inferencia;
class IASimbolica extends genesis_block_1.GenesisBlock {
}
exports.IASimbolica = IASimbolica;
(function (IASimbolica) {
    IASimbolica.fiaSimbolica = new IASimbolica();
    IASimbolica.fiaSimbolica.nombre = labels_1.i18.FIA_SIMBOLICA_LABEL;
    IASimbolica.fiaSimbolica.razona =
        (m, i) => {
            return "No";
        };
})(IASimbolica || (exports.IASimbolica = IASimbolica = {}));
