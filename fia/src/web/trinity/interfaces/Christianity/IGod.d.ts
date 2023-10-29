import { GodHypostasis } from "./GodHypostasis";


export interface IGod {

    eye: string;

    hypostasis: GodHypostasis;

    getSource: () => string;
    areYou: (object: IGod) => string;

    created: boolean;
    begotten: boolean;
    proceed: boolean;

}
