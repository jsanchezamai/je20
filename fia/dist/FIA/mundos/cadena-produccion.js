"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.CadenaProduccion = void 0;
const labels_1 = require("../i18/labels");
const mundo_1 = require("./mundo");
class CadenaProduccion {
    constructor() {
    }
    async instanciar() {
        return await new Promise(async (resolve, reject) => {
            this.mundo = new mundo_1.Mundo();
            this.mundo.nombre = `${labels_1.i18.MUNDO.EJEMPLOS_CADENA_LABEL}`;
            const modelo = await this.mundo.ciclo();
            resolve(modelo);
        });
    }
}
exports.CadenaProduccion = CadenaProduccion;
