import { TuringTester } from "../../turing-test";
import { IACientifica } from "./paradigma";

const tester = new TuringTester();

export const loadCiencia = () => {

    console.log("\t\t - Tipos de inteligencia #1:");
    console.log("\t\t\t tester> ¿Eres o podrías ser humana?");
    console.log(`\t\t\t ${IACientifica.fiaDebil.nombre}> ${tester.test(IACientifica.fiaDebil)}`);

    console.log("\t\t - Tipos de inteligencia #2:");
    console.log("\t\t\t tester> ¿Eres o podrías ser humana?");
    console.log(`\t\t\t ${IACientifica.fiaFuerte.nombre}> ${tester.test(IACientifica.fiaFuerte)}`);
}

