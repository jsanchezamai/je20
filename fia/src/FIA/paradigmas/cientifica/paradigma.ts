import { GenesisBlock, Intention, World } from "../../genesis-block";

export namespace IACientifica {

    export const fiaFuerte = new GenesisBlock();

    fiaFuerte.modelo = "FIA Fuerte";
    fiaFuerte.razona =
        (w: World, i: Intention) => {
        return "Sí";
    }

    export const fiaDebil = new GenesisBlock();

    fiaDebil.modelo = "FIA Debil";
    fiaDebil.razona =
        (w: World, i: Intention) => {
        return "No";
    }

}
