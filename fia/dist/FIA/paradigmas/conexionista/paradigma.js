"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.IAConexionista = void 0;
const genesis_block_1 = require("../../genesis-block");
const labels_1 = require("../../i18/labels");
var IAConexionista;
(function (IAConexionista_1) {
    class IAConexionista extends genesis_block_1.GenesisBlock {
        inferencia(c) {
            return this.red.clasificar(c);
        }
    }
    IAConexionista_1.IAConexionista = IAConexionista;
    IAConexionista_1.fiaConexionista = new IAConexionista();
    IAConexionista_1.fiaConexionista.nombre = labels_1.i18.FIA_CONEXIONISTA_LABEL;
    IAConexionista_1.fiaConexionista.razona =
        (m, i) => {
            return "No";
        };
})(IAConexionista || (exports.IAConexionista = IAConexionista = {}));
