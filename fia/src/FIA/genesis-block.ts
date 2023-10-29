import { i18 } from "./i18/labels";

export type Any = string;

export type Mundo = Any;

export type Intencion = Any;

export interface iFIA {

    nombre: string;

    abstrae: (p: IPercepto) => IAprendize;
    razona: (w: Mundo, i: Intencion) => IAccion;

    mundo: Mundo;

    objetivos: Intencion;

    imprimir: () => string;
}

export interface IAprendize {

}

export interface IPercepto {

}

export interface IAccion {

}

export class FIA implements iFIA {
    mundo: Mundo;
    abstrae: (p: IPercepto) => IAprendize;
    razona: (w: string, i: string) => IAccion;
    nombre = "FIA";
    objetivos: string;

    imprimir(): string {
        return `${i18.NOT_INIT_LABEL}`;
    }

}

export class GenesisBlock extends FIA {

    mundo: Mundo;
    abstrae: (p: IPercepto) => IAprendize;
    razona: (w: string, i: string) => IAccion;
    nombre = "FIA_Genesis";
    objetivos: string;

}
