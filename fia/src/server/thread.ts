console.log("Thread launched");

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

export interface IPercepto {

}

export interface IAccion {

}

export class FIA {


}