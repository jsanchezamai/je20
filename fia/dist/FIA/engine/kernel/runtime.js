"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Runtime = void 0;
const genesis_block_1 = require("../../genesis-block");
const indice_1 = require("../../paradigmas/cientifica/indice");
const indice_2 = require("../../paradigmas/simbolica/indice");
const indice_3 = require("../../paradigmas/situada/indice");
const indice_4 = require("../../paradigmas/conexionista/indice");
const paradigma_1 = require("../../paradigmas/cientifica/paradigma");
const paradigma_2 = require("../../paradigmas/simbolica/paradigma");
const paradigma_3 = require("../../paradigmas/situada/paradigma");
const paradigma_4 = require("../../paradigmas/conexionista/paradigma");
class Runtime {
    start() {
        console.log("Iniciando el modelizador de Fundamentos de inteligencia artificial. v1...");
        console.log("\t - Proceso principal:");
        const fia = new genesis_block_1.FIA();
        Runtime.threads.push(fia);
        console.log("\t\t - Carga del modelo semilla:", fia.nombre);
        const gb = new genesis_block_1.GenesisBlock();
        Runtime.threads.push(gb);
        console.log("\t\t - Carga de la instancia génesis:", gb.nombre);
        console.log("\n", "\t - Hechos raíz:");
        (0, indice_1.loadCientifica)();
        Runtime.threads.push(paradigma_1.IACientifica.fiaDebil);
        Runtime.threads.push(paradigma_1.IACientifica.fiaFuerte);
        (0, indice_2.loadSimbolica)();
        Runtime.threads.push(paradigma_2.IASimbolica.fiaSimbolica);
        (0, indice_3.loadSituada)();
        Runtime.threads.push(paradigma_3.IASituada.fiaSituada);
        (0, indice_4.loadConexionista)();
        Runtime.threads.push(paradigma_4.IAConexionista.fiaConexionista);
        console.log("\n", "\t - El sistema inteligente ha sido cargado!");
    }
}
exports.Runtime = Runtime;
Runtime.threads = [];
