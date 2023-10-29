"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.GenesisBlock = exports.FIA = void 0;
const labels_1 = require("./i18/labels");
class FIA {
    constructor() {
        this.nombre = "FIA";
    }
    imprimir() {
        return `${labels_1.i18.NOT_INIT_LABEL}`;
    }
}
exports.FIA = FIA;
class GenesisBlock extends FIA {
    constructor() {
        super(...arguments);
        this.nombre = "FIA_Genesis";
    }
}
exports.GenesisBlock = GenesisBlock;
