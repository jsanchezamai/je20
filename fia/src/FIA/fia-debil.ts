import { GenesisBlock, Intention, World } from "./genesis-block";

export const FiaDebil = new GenesisBlock();

FiaDebil.modelo = "FIA Debil";
FiaDebil.razona =
    (w: World, i: Intention) => {
    return "No";
}
