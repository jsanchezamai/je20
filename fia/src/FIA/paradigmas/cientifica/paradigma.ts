import { GenesisBlock, Intencion, Mundo } from "../../genesis-block";

export namespace IACientifica {

    export const fiaFuerte = new GenesisBlock();

    fiaFuerte.nombre = "FIA Fuerte";
    fiaFuerte.razona =
        (w: Mundo, i: Intencion) => {
        return "Sí";
    }

    export const fiaDebil = new GenesisBlock();

    fiaDebil.nombre = "FIA Debil";
    fiaDebil.razona =
        (w: Mundo, i: Intencion) => {
        return "No";
    }

}
