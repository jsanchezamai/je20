console.log("Iniciando el moderlizador de Fundamentos de inteligencia artificial. v1...");

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

export class FIA implements iFIA {
    abstrae: (p: IPercepto) => IAprendize;
    razona: (w: string, i: string) => IAccion;
    modelo = "FIA_Genesis";
    objetivos: string;
}

console.log(new Date(), "\t - Proceso principal:");
console.log(new Date(), "\t\t - Carga de la declaración FIA", FIA);

const fia = new FIA();
console.log(new Date(), "\t\t - Carga de la instancia génesis FIA", fia);