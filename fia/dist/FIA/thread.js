"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const genesis_block_1 = require("./genesis-block");
const indice_1 = require("./paradigmas/cientifica/indice");
const indice_2 = require("./paradigmas/simbolica/indice");
const indice_3 = require("./paradigmas/situada/indice");
const indice_4 = require("./paradigmas/conexionista/indice");
const menu_1 = require("./menu");
const m = new menu_1.Menu(["- ¡¡Listo para interactuar, humanos!!!",
    "- Not today, close, please, bye!"]);
m.run().then((value) => {
    console.log(value);
});
console.log("Iniciando el modelizador de Fundamentos de inteligencia artificial. v1...");
console.log("\t - Proceso principal:");
const fia = new genesis_block_1.FIA();
console.log("\t\t - Carga del modelo semilla:", fia.nombre);
const gb = new genesis_block_1.GenesisBlock();
console.log("\t\t - Carga de la instancia génesis:", gb.nombre);
console.log("\n", "\t - Hechos raíz:");
(0, indice_1.loadCientifica)();
(0, indice_2.loadSimbolica)();
(0, indice_3.loadSituada)();
(0, indice_4.loadConexionista)();
console.log("\n", "\t - El sistema inteligente ha sido cargado!");
