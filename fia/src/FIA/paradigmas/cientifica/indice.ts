import { TuringTester } from "../../turing-test";
import { IACientifica } from "./paradigma";

const tester = new TuringTester();

export const loadCientifica = () => {



    console.log(`\t\t\t ${IACientifica.fiaFuerte.nombre}> ${tester.test(IACientifica.fiaFuerte)}`);
}

