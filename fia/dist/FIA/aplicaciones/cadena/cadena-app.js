"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.CadenaApp = void 0;
const labels_1 = require("../../i18/labels");
const thread_1 = require("../../thread");
const paradigma_1 = require("../paradigma");
const cadena_fia_red_semantica_1 = require("./simbolica/formal/cadena-fia-red-semantica");
const cadena_fia_situada_1 = require("./situada/cadena-fia-situada");
class CadenaApp extends paradigma_1.App {
    constructor() {
        super();
        this.nombre = labels_1.i18.APPS.CADENA.NOMBRE;
    }
    async instanciar() {
        console.log((0, thread_1.agentMessage)(this.nombre, labels_1.i18.APPS.CADENA.SIMULATION_START));
        /**
         *
         */
        this.situada = new cadena_fia_situada_1.CadenaFIASituada();
        this.simbolica = new cadena_fia_red_semantica_1.CadenaRedSemantica();
        await Promise.all([
            this.situada.instanciar(),
            this.simbolica.instanciar()
        ]);
        return `${labels_1.i18.APPS.CADENA.SIMULATION_END}`;
    }
}
exports.CadenaApp = CadenaApp;
