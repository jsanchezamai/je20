"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.InferenciaRelacion = void 0;
const paradigma_1 = require("../../../../paradigma");
class InferenciaRelacion extends paradigma_1.Inferencia {
    constructor() {
        super(...arguments);
        this.claveDominio = "inferencias_relacion";
        this.dominio = new paradigma_1.Dominio({});
    }
    configurar(g, parametros) {
        this.dominio.base[this.claveDominio][this.claveEntrada] = parametros;
        this.dominio.base[this.claveDominio][this.claveContexto] = g;
    }
    evaluar() {
        return this;
    }
}
exports.InferenciaRelacion = InferenciaRelacion;
