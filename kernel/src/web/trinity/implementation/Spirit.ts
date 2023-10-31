import { ISpirit } from "../interfaces/ISpirit";
import { IGod } from "../interfaces/IGod";
import { L } from "../seed";
import { GodHypostasis } from "../interfaces/GodHypostasis";
import { God } from "./God";


export class Spirit extends God implements ISpirit {

    eye = L.EYE_SPIRIT;

    hypostasis: GodHypostasis = GodHypostasis.Spirit;

    created: boolean = false;
    begotten: boolean = false;
    proceed: boolean = true;

    proceedFrom: IGod[] = [];

}
