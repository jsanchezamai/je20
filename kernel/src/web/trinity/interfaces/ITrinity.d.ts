import { IGod } from "../interfaces/IGod";
import { ISpirit } from "../interfaces/ISpirit";
import { ChristianityRegions } from "./ChristianityRegions";
import { GodHypostasis } from "./GodHypostasis";
import { IEastWestSchism } from "./IEastWestSchism";

export interface ITrinity {

    htmlKey: string;
    existence: IGod[];

    redefineHypostasis: () => void;
    setExistence: () => void;

    redefineSpirit(spirit: ISpirit): void;

    region: ChristianityRegions;

    getHypostasis(hypostasis: GodHypostasis): IGod;

    printHypostasis: (htmlKey: string) => void;

    getSchism: () => IEastWestSchism;

}
