import { GenesisBlock, IAccion, Intencion, Mundo, iFIA } from "../../genesis-block";

export namespace IASituada {

    type Aferencia = (w: Mundo) => IAccion;
    type Eferencia = (a: IAccion) => Mundo;

    export interface IAutomata {
        paso: (a: Aferencia) => Eferencia;
    }

    export interface iIASituada extends iFIA {

        automata: IAutomata;

    }

    export class iIASituada extends GenesisBlock implements iIASituada {
        aferencia: (w: Mundo) => IAccion;
        eferencia: (a: IAccion) => Mundo;
    }

    export const fiaSituada = new iIASituada();

    fiaSituada.nombre = "FIA Situada";
    fiaSituada.razona =
        (w: Mundo, i: Intencion) => {
        return "Sí";
    }

}
