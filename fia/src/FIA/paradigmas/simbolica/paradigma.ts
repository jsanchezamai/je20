import { GenesisBlock, Intencion, Mundo, iFIA } from "../../genesis-block";
import { i18 } from "../../i18/labels";
import { IMundo } from '../../mundos/paradigma';
import { ISolucion } from "../conexionista/paradigma";
import { IFacetas } from "./modelos/conceptual/sistema/marcos";
import { IProblema, IRequisitos } from "./modelos/formal/inferencia/relacion/paradigma";

    /**
     * INFERENCIA
     */
    export interface IDominio {}

    export interface IInferencia {
        dominio: IDominio;
    }

    export interface IInferenciaConcepto extends IInferencia {};

    export interface IInferenciaRelacion extends IInferencia {};

    export interface IInferenciaAccion extends IInferencia {};

    export class Inferencia implements IInferencia {
        dominio: IDominio;
}

    /**
     * REGLAS
     */

    export interface IReglaCondicional extends IInferencia {}

    export interface IReglaSiEntonces extends IInferencia {}

    /**
     * IInferenciaConcepto
     */
    export interface IReglaObjetoAtributoValor extends IInferenciaConcepto {}

    export interface IReglaMarco extends IInferenciaConcepto {
        facetas: IFacetas
    }

    /**
     * IInferenciaRelacion
     */
    export interface IReglaLogica extends IInferenciaRelacion {}

    export interface IReglaRed extends IInferenciaRelacion {}

    export interface IReglaDependencia extends IInferenciaRelacion {}


    /**
     * IInferenciaAccion
     */

    export interface IReglaLista extends IInferenciaAccion {}

    export interface IReglaGuion extends IReglaLista {}

    export interface IReglaSistema extends IInferenciaAccion {}

    /**
     * REPRESENTACIÓN CONOCIMIENTO
     */


    export interface IBaseConocimiento extends IDominio {


    }

    export interface IMotorInferencia extends IDominio {
    }

    export interface IEstrategiaControl extends IDominio {
    }

    export interface IModeloRepresentacional {

    }

    /**
     * NO EVALUABLE, NO EJECUTABLE
     */
    export interface IModeloConceptual extends IModeloRepresentacional {
        base: IBaseConocimiento;
    }

    /**
     * EVALUABLE, NO EJECUTABLE
     */
    export interface IModeloFormal extends IModeloConceptual {
        motor: IMotorInferencia;
    }

    /**
     * EVALUABLE, EJECUTABLE
     */
    export interface IModeloComputacional extends IModeloFormal {
        control: IEstrategiaControl;
    }

    export interface iIASimbolica extends iFIA {

        modelo: IModeloRepresentacional;

        analisis: (p: IProblema) => ISolucion[];
        sintesis: (r: IRequisitos) => ISolucion;
        modificacion: (s: ISolucion) => IMundo;
    }

    export class IASimbolica extends GenesisBlock implements iIASimbolica {

        modelo: IModeloRepresentacional;

        analisis: (p: IProblema) => ISolucion[];
        sintesis: (r: IRequisitos) => ISolucion;
        modificacion: (r: ISolucion) => IMundo;
    }

export namespace IASimbolica {

    export const fiaSimbolica = new IASimbolica();

    fiaSimbolica.nombre = i18.FIA_SIMBOLICA_LABEL;
    fiaSimbolica.razona =
        (m: Mundo, i: Intencion) => {
        return "No";
    }

}
