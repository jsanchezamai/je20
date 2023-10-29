import { L } from "../../ChristianSeed";
import { GodHypostasis } from "../../interfaces/GodHypostasis";
import { IFather } from "../../interfaces/IFather";
import { God } from "./God";

export class Father extends God implements IFather {

    eye = L.EYE_FATHER;

    created: boolean = true;
    begotten: boolean = false;
    proceed: boolean = false;

    hypostasis: GodHypostasis = GodHypostasis.Father;

}
