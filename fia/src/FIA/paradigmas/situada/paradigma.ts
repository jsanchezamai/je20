import { GenesisBlock, IAccion, Intencion, Mundo, iFIA } from "../../genesis-block";
import { i18 } from "../../i18/labels";

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

    fiaSituada.nombre = i18.FIA_SITUADA_LABEL;
    fiaSituada.razona =
        (w: Mundo, i: Intencion) => {
        return "Sí";
    }

}
