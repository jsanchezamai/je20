import { GenesisBlock, IAccion, IProblema, IRequisitos, ISoluciones, Intention, World, iFIA } from "../../genesis-block";

export namespace IASimbolica {

    export interface iIASimbolica extends iFIA {
        analisis: (p: IProblema) => ISoluciones;
        sintesis: (R: IRequisitos) => ISoluciones;
        modificacion: (R: World) => World;
    }

    export class IASimbolica extends GenesisBlock implements iIASimbolica {
        analisis: (p: IProblema) => ISoluciones;
        sintesis: (R: IRequisitos) => ISoluciones;
        modificacion: (R: string) => string;
    }

    export const fiaSimbolica = new IASimbolica();

    fiaSimbolica.modelo = "FIA Simbolica";
    fiaSimbolica.razona =
        (w: World, i: Intention) => {
        return "Sí";
    }

}
