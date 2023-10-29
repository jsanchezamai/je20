import { GenesisBlock, IAccion, IProblema, IRequisitos, ISoluciones, Intention, World, iFIA } from "../../genesis-block";

export namespace IASituada {

    export interface iIASituada extends iFIA {
        aferencia: (w: World) => IAccion;
        eferencia: (a: IAccion) => World;
    }

    export class iIASituada extends GenesisBlock implements iIASituada {
        aferencia: (w: World) => IAccion;
        eferencia: (a: IAccion) => World;
    }

    export const fiaSituada = new iIASituada();

    fiaSituada.modelo = "FIA Situada";
    fiaSituada.razona =
        (w: World, i: Intention) => {
        return "Sí";
    }

}
