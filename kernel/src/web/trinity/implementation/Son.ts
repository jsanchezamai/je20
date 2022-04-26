import { ISon } from "../interfaces/ISon";
import { L } from "../seed";
import { GodHypostasis } from "../interfaces/GodHypostasis";
import { God } from "./God";


export class Son extends God implements ISon {

    eye = L.EYE_SON;

    hypostasis: GodHypostasis = GodHypostasis.Son;

    created: boolean = false;
    begotten: boolean = true;
    proceed: boolean = false;
}
