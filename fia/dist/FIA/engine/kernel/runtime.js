"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Runtime = void 0;
const genesis_block_1 = require("../../genesis-block");
const paradigma_1 = require("../../paradigmas/cientifica/paradigma");
const paradigma_2 = require("../../paradigmas/simbolica/paradigma");
const paradigma_3 = require("../../paradigmas/situada/paradigma");
const paradigma_4 = require("../../paradigmas/conexionista/paradigma");
class Runtime {
    start() {
        const fia = new genesis_block_1.FIA();
        Runtime.threads.push(fia);
        const gb = new genesis_block_1.GenesisBlock();
        Runtime.threads.push(gb);
        Runtime.threads.push(paradigma_1.IACientifica.fiaDebil);
        Runtime.threads.push(paradigma_1.IACientifica.fiaFuerte);
        Runtime.threads.push(paradigma_2.IASimbolica.fiaSimbolica);
        Runtime.threads.push(paradigma_3.IASituada.fiaSituada);
        Runtime.threads.push(paradigma_4.IAConexionista.fiaConexionista);
    }
    demo() {
    }
}
exports.Runtime = Runtime;
Runtime.threads = [];
