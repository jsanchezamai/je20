import { Inferencia, IInferenciaRelacion, IDominio, Dominio, IInferencia } from "../../../../paradigma";
import { IGrafo } from "../../sistema/semantica/grafo";

export interface ISolucion {}

export interface IProblema {

    predicado: IPredicado;
    dominio: IDominio;

}

export interface IPredicado {}

export interface IRequisitos  {
}

export class InferenciaRelacion
    extends Inferencia
    implements IInferenciaRelacion {

        claveDominio = "inferencias_relacion";

        dominio: IDominio = new Dominio({});

        constructor() {
            super();
            this.dominio.base[this.claveDominio] = {};
        }

        configurar(g: IGrafo, parametros: IDominio): void {

            this.dominio.base[this.claveDominio][this.claveEntrada] = parametros;
            this.dominio.base[this.claveDominio][this.claveContexto] = g;
        }

        evaluar(): IInferencia {
            return this;
        }
}