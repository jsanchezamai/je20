"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.IACientifica = void 0;
const genesis_block_1 = require("../../genesis-block");
var IACientifica;
(function (IACientifica) {
    IACientifica.fiaFuerte = new genesis_block_1.GenesisBlock();
    IACientifica.fiaFuerte.modelo = "FIA Fuerte";
    IACientifica.fiaFuerte.razona =
        (w, i) => {
            return "Sí";
        };
    IACientifica.fiaDebil = new genesis_block_1.GenesisBlock();
    IACientifica.fiaDebil.modelo = "FIA Debil";
    IACientifica.fiaDebil.razona =
        (w, i) => {
            return "No";
        };
})(IACientifica || (exports.IACientifica = IACientifica = {}));
