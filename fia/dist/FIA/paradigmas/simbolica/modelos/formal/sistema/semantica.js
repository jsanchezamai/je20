"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.RedSemantica = exports.ReglaRed = exports.Grafo = void 0;
const paradigma_1 = require("../inferencia/relacion/paradigma");
const paradigma_2 = require("../paradigma");
class Grafo {
}
exports.Grafo = Grafo;
class ReglaRed extends paradigma_1.InferenciaRelacion {
}
exports.ReglaRed = ReglaRed;
class RedSemantica extends paradigma_2.Formal {
    constructor() {
        super(...arguments);
        this.base = new Grafo();
        this.motor = new ReglaRed();
    }
}
exports.RedSemantica = RedSemantica;
