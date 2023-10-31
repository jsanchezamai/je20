import { Inferencia, IInferenciaRelacion, IDominio } from "../../../../paradigma";

export interface ISolucion {}

export interface IProblema {

    predicado: IPredicado;
    dominio: IDominio;

}

export interface IPredicado {}

export interface IEntidad {

}

export interface IRequisitos  {
}

export class InferenciaRelacion
    extends Inferencia
    implements IInferenciaRelacion {
}