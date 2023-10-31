"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.CadenaRedSemantica = void 0;
const semantica_1 = require("../../../../paradigmas/simbolica/modelos/formal/sistema/semantica");
const cadena_fia_simbolica_1 = require("../cadena-fia-simbolica");
class CadenaRedSemantica extends cadena_fia_simbolica_1.CadenaFIASimbolica {
    constructor() {
        super();
        this.modelo = new semantica_1.RedSemantica();
    }
}
exports.CadenaRedSemantica = CadenaRedSemantica;
