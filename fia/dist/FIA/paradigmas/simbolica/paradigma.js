"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.IASimbolica = void 0;
const genesis_block_1 = require("../../genesis-block");
const labels_1 = require("../../i18/labels");
var IASimbolica;
(function (IASimbolica_1) {
    class IASimbolica extends genesis_block_1.GenesisBlock {
    }
    IASimbolica_1.IASimbolica = IASimbolica;
    IASimbolica_1.fiaSimbolica = new IASimbolica();
    IASimbolica_1.fiaSimbolica.nombre = labels_1.i18.FIA_SIMBOLICA_LABEL;
    IASimbolica_1.fiaSimbolica.razona =
        (m, i) => {
            return "No";
        };
})(IASimbolica || (exports.IASimbolica = IASimbolica = {}));
