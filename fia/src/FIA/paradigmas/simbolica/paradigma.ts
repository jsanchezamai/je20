import { GenesisBlock, Intencion, Mundo, iFIA } from "../../genesis-block";

export namespace IASimbolica {

    export interface IHecho {}

    export interface IRegla {}

    export interface ISolucion {}

    export interface IProblema {

        predicado: IPredicado;
        dominio: IDominio;

    }

    export interface IPredicado {
        paso: (h: IHecho, R: IRegla) => ISolucion;
    }

    export interface IEntidad {

    }

    export interface IDominio {

        entidades: IEntidad[];
        hechos: IHecho[];
        reglas: IRegla[];

    }

    export interface IRequisitos extends IDominio {
    }

    export interface iIASimbolica extends iFIA {

        dominio: IDominio;

        analisis: (p: IProblema) => ISolucion;
        sintesis: (r: IRequisitos) => ISolucion;
        modificacion: (s: ISolucion) => Mundo;
    }

    export class IASimbolica extends GenesisBlock implements iIASimbolica {
        mundo: string;
        dominio: IDominio;
        analisis: (p: IProblema) => ISolucion;
        sintesis: (r: IRequisitos) => ISolucion;
        modificacion: (r: ISolucion) => Mundo;
    }

    export const fiaSimbolica = new IASimbolica();

    fiaSimbolica.nombre = "FIA Simbolica";
    fiaSimbolica.razona =
        (w: Mundo, i: Intencion) => {
        return "No";
    }

}
