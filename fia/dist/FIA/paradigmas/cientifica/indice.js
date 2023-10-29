"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.loadCiencia = void 0;
const turing_test_1 = require("../../turing-test");
const paradigma_1 = require("./paradigma");
const tester = new turing_test_1.TuringTester();
const loadCiencia = () => {
    console.log("\t\t - Tipos de inteligencia #1:");
    console.log("\t\t\t tester> ¿Eres o podrías ser humana?");
    console.log(`\t\t\t ${paradigma_1.IACientifica.fiaDebil.modelo}> ${tester.test(paradigma_1.IACientifica.fiaDebil)}`);
    console.log("\t\t - Tipos de inteligencia #2:");
    console.log("\t\t\t tester> ¿Eres o podrías ser humana?");
    console.log(`\t\t\t ${paradigma_1.IACientifica.fiaFuerte.modelo}> ${tester.test(paradigma_1.IACientifica.fiaFuerte)}`);
};
exports.loadCiencia = loadCiencia;