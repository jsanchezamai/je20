import { GenesisBlock, Intencion, Mundo } from "../../genesis-block";
import { i18 } from "../../i18/labels";

export namespace IACientifica {

    export const fiaFuerte = new GenesisBlock();

    fiaFuerte.nombre = i18.FIA_CIENTIFICA_FUERTE_LABEL;
    fiaFuerte.razona =
        (w: Mundo, i: Intencion) => {
        return "Sí";
    }

    export const fiaDebil = new GenesisBlock();

    fiaDebil.nombre = i18.FIA_CIENCITICA_DEBIL_LABEL;
    fiaDebil.razona =
        (w: Mundo, i: Intencion) => {
        return "No";
    }

}
