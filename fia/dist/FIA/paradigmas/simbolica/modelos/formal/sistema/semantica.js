"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.RedSemantica = exports.ReglaRed = exports.Grafo = exports.ArcoEstructural = exports.EtiquetaEstructural = exports.RelacionEstructural = exports.Entidad = void 0;
const paradigma_1 = require("../inferencia/relacion/paradigma");
const paradigma_2 = require("../paradigma");
class Entidad {
    constructor() {
        this.nombre = "entidad";
        this.valor = "entidad";
    }
    imprimir() {
        return this.nombre;
    }
}
exports.Entidad = Entidad;
class RelacionEstructural {
    constructor() {
        this.valor = "";
    }
}
exports.RelacionEstructural = RelacionEstructural;
class EtiquetaEstructural {
    constructor() {
        this.estado = new RelacionEstructural();
    }
}
exports.EtiquetaEstructural = EtiquetaEstructural;
class ArcoEstructural {
    constructor() {
        this.etiqueta = new EtiquetaEstructural();
    }
}
exports.ArcoEstructural = ArcoEstructural;
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
