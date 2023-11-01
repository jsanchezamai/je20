"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.CadenaFIARedSemantica = exports.CadenaGrafo = void 0;
const labels_1 = require("../../../../i18/labels");
const semantica_1 = require("../../../../paradigmas/simbolica/modelos/formal/sistema/semantica");
const thread_1 = require("../../../../thread");
const cadena_fia_simbolica_1 = require("../cadena-fia-simbolica");
class CadenaGrafo extends semantica_1.Grafo {
}
exports.CadenaGrafo = CadenaGrafo;
class CadenaFIARedSemantica extends cadena_fia_simbolica_1.CadenaFIASimbolica {
    constructor() {
        super();
        this.entidades = [];
        this.modelo = new semantica_1.RedSemantica();
        this.nombre = labels_1.i18.APPS.CADENA.SIMBOLICA.RED.NOMBRE;
        const grafo = new CadenaGrafo();
        this.modelo.nombre = labels_1.i18.APPS.CADENA.SIMBOLICA.SEMANTICA.NOMBRE;
        this.modelo.base = grafo;
    }
    async instanciar() {
        console.log((0, thread_1.agentMessage)(this.nombre, labels_1.i18.APPS.CADENA.SIMBOLICA.SIMULATION_START));
        this.cargaRed();
        console.log((0, thread_1.agentMessage)(this.nombre, `${labels_1.i18.APPS.CADENA.SIMULATION_BODY}:${this.imprimir()}`));
        return `${labels_1.i18.APPS.CADENA.SIMBOLICA.SIMULATION_END}`;
    }
    cargaRed() {
        const red = labels_1.i18.APPS.CADENA.SIMBOLICA.DOMINIO;
        this.modelo.cargar(red, this.entidades);
    }
    imprimir() {
        let out = "";
        this.entidades.forEach(e => {
            out += e.imprimir();
        });
        return out;
    }
}
exports.CadenaFIARedSemantica = CadenaFIARedSemantica;
