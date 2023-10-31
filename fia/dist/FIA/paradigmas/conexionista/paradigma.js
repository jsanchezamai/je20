"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.IAConexionista = void 0;
const genesis_block_1 = require("../../genesis-block");
const labels_1 = require("../../i18/labels");
class IAConexionista extends genesis_block_1.GenesisBlock {
    inferencia(c) {
        return this.red.clasificar(c);
    }
}
exports.IAConexionista = IAConexionista;
(function (IAConexionista) {
    IAConexionista.fiaConexionista = new IAConexionista();
    IAConexionista.fiaConexionista.nombre = labels_1.i18.FIA_CONEXIONISTA_LABEL;
    IAConexionista.fiaConexionista.razona =
        (m, i) => {
            return "No";
        };
})(IAConexionista || (exports.IAConexionista = IAConexionista = {}));
