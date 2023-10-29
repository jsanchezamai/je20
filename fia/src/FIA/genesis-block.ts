export type Any = string;

export type World = Any;

export type Intention = Any;

export interface iFIA {
    abstrae: (p: IPercepto) => IAprendize;
    razona: (w: World, i: Intention) => IAccion;
    modelo: World;
    objetivos: Intention;
}

export interface IAprendize {

}

export interface IRelacion<T> {

}

export interface IEntidad {

}

export interface IPercepto {

}

export interface IAccion {

}

export interface IProblema {
    agente: IEntidad;
    objeto: IEntidad;
    relacion: IRelacion<IEntidad>
}

export interface ISoluciones {

}

export interface IRequisitos {

}

export class FIA implements iFIA {
    abstrae: (p: IPercepto) => IAprendize;
    razona: (w: string, i: string) => IAccion;
    modelo = "FIA";
    objetivos: string;
}

export class GenesisBlock implements iFIA {
    abstrae: (p: IPercepto) => IAprendize;
    razona: (w: string, i: string) => IAccion;
    modelo = "FIA_Genesis";
    objetivos: string;
}
