"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.FiaFuerte = void 0;
const genesis_block_1 = require("./genesis-block");
exports.FiaFuerte = new genesis_block_1.GenesisBlock();
exports.FiaFuerte.modelo = "FIA Fuerte";
exports.FiaFuerte.razona =
    (w, i) => {
        return "Sí";
    };
