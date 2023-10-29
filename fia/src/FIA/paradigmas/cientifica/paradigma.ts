import { GenesisBlock, Intencion, Mundo } from "../../genesis-block";
import { i18 } from "../../i18/labels";
import { TuringTester } from "../../turing-test";

export namespace IACientifica {

    export const fiaFuerte = new GenesisBlock();

    fiaFuerte.nombre = i18.FIA_CIENTIFICA_FUERTE_LABEL;
    fiaFuerte.razona =
        (w: Mundo, i: Intencion) => {
        return "Sí";
    }
    fiaFuerte.imprimir = () => {
        const tester = new TuringTester();
        return `${i18.LAUNCHING_TURING_TEST}: ${tester.test(fiaFuerte)}`;
    }

    export const fiaDebil = new GenesisBlock();

    fiaDebil.nombre = i18.FIA_CIENCITICA_DEBIL_LABEL;
    fiaDebil.razona =
        (w: Mundo, i: Intencion) => {
        return "No";
    }
    fiaDebil.imprimir = () => {
        const tester = new TuringTester();
        return `${i18.LAUNCHING_TURING_TEST}: ${tester.test(fiaDebil)}`;
    }

}
