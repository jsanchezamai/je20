import { IBaseConocimiento, IModeloFormal, IMotorInferencia, IReglaRed, Inferencia } from "../../../paradigma";
import { Computable } from "../../computable/paradigma";
import { InferenciaRelacion } from "../inferencia/relacion/paradigma";
import { Formal } from "../paradigma";

export interface IEstado {
    valor: string;
}

export interface IConcepto extends IEstado {
    valor: "concepto";
}

export interface IEntidad extends IEstado {
    valor: "entidad"
}

export interface IRelacionEstructural extends IEstado {
    valor: "subclase-de" | "instancia-de" | "parte-de" | string;
}

export interface IEtiqueta {
    estado: IEstado;
}

export interface IEtiquetaEstructural extends IEtiqueta {
    estado: IRelacionEstructural;
}

export interface IEtiquetaDescriptiva extends IEtiqueta {
    estado: IConcepto | IEntidad;
}

export interface IArco extends InferenciaRelacion {

    etiqueta: IEtiqueta;
    destino: IGrafo;

}

export interface IArcoDescriptivo extends IArco {

    etiqueta: IEtiquetaDescriptiva;
    destino: IGrafo;

}

export interface IArcoEstructural extends IArco {

    etiqueta: IEtiquetaEstructural;
    destino: IGrafo;

}

export interface IArcos {

    estado: IArco[];

}

export interface IGrafo extends IBaseConocimiento {

    arcos: IArcos;

}

export class Grafo implements IGrafo {

    nombre: string;

    arcos: IArcos;

}

export class ReglaRed extends InferenciaRelacion implements IReglaRed {

}

export class RedSemantica extends Formal {

    base = new Grafo();
    motor = new ReglaRed();

}