import { ITrinity } from "../interfaces/ITrinity";

export interface IEastWestSchism {

    htmlKey: string;

    east: ITrinity;
    west: ITrinity;

    setEast(): void;
    setWest(): void;

    printChurch(church: ITrinity): void;

    printSchism: (htmlKey: string) => void;

}
