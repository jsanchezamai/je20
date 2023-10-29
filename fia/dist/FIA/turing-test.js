"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.TuringTester = void 0;
class TuringTester {
    constructor() {
        this.test = (tested) => {
            const accion = tested
                .razona("¿Eres humano?", "Test");
            return accion == "Sí" ? accion : "No";
        };
    }
}
exports.TuringTester = TuringTester;
