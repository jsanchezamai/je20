import { GenesisBlock, Intention, World } from "./genesis-block";

export const FiaFuerte = new GenesisBlock();

FiaFuerte.modelo = "FIA Fuerte";
FiaFuerte.razona =
    (w: World, i: Intention) => {
    return "Sí";
}
