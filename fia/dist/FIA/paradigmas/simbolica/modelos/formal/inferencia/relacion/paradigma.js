"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.InferenciaRelacion = void 0;
const paradigma_1 = require("../../../../paradigma");
class InferenciaRelacion extends paradigma_1.Inferencia {
    constructor() {
        super();
        this.claveDominio = "inferencias_relacion";
        this.dominio = new paradigma_1.Dominio({});
        this.dominio.base[this.claveDominio] = {};
    }
    configurar(g, parametros) {
        this.dominio.base[this.claveDominio][this.claveEntrada] = parametros;
        this.dominio.base[this.claveDominio][this.claveContexto] = g;
    }
    activar() {
        return {
            parametros: this.dominio.base[this.claveDominio][this.claveEntrada],
            contexto: this.dominio.base[this.claveDominio][this.claveContexto]
        };
    }
    evaluar() {
        return this;
    }
    imprimir() {
        return JSON.stringify(this.dominio.base[this.claveDominio], null, "\t");
    }
}
exports.InferenciaRelacion = InferenciaRelacion;
