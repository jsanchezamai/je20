"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Grafo = exports.Entidad = void 0;
const arcos_1 = require("./arcos");
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
class Grafo {
    constructor() {
        this.arcos = new arcos_1.Arcos();
    }
    imprimir() {
        let out = "";
        out += "\n\t - (grafo) -" + this.nombre + "; arcos";
        this.arcos.estado.forEach(e => {
            out += "\n\t\t - " + e.etiqueta.estado.nombre;
        });
        return out;
    }
}
exports.Grafo = Grafo;
