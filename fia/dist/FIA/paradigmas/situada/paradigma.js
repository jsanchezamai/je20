"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.IASituada = void 0;
const genesis_block_1 = require("../../genesis-block");
const labels_1 = require("../../i18/labels");
const thread_1 = require("../../thread");
const cadena_produccion_1 = require("../../mundos/cadena-produccion");
var IASituada;
(function (IASituada) {
    class iIASituada extends genesis_block_1.GenesisBlock {
        async instanciar() {
            const demo = "Final de ejecución";
            console.log((0, thread_1.agentMessage)(labels_1.i18.FIA_SITUADA_LABEL, labels_1.i18.SITUADA.SIMULATION_START));
            const cadena = new cadena_produccion_1.CadenaProduccion();
            const modelo = await cadena.instanciar();
            console.log((0, thread_1.agentMessage)(labels_1.i18.FIA_SITUADA_LABEL, `${labels_1.i18.SITUADA.SIMULATION_BODY}:${modelo.nombre}`));
            return `${demo}`;
        }
    }
    IASituada.iIASituada = iIASituada;
    IASituada.fiaSituada = new iIASituada();
    IASituada.fiaSituada.nombre = labels_1.i18.FIA_SITUADA_LABEL;
    IASituada.fiaSituada.razona =
        (w, i) => {
            return "Sí";
        };
})(IASituada || (exports.IASituada = IASituada = {}));
