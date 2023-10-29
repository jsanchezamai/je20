"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.IASimbolica = void 0;
const genesis_block_1 = require("../../genesis-block");
var IASimbolica;
(function (IASimbolica_1) {
    class IASimbolica extends genesis_block_1.GenesisBlock {
    }
    IASimbolica_1.IASimbolica = IASimbolica;
    IASimbolica_1.fiaSimbolica = new IASimbolica();
    IASimbolica_1.fiaSimbolica.nombre = "FIA Simbolica";
    IASimbolica_1.fiaSimbolica.razona =
        (w, i) => {
            return "No";
        };
})(IASimbolica || (exports.IASimbolica = IASimbolica = {}));
