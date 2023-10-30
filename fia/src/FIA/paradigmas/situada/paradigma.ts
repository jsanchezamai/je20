import { GenesisBlock, IAccion, Intencion, Mundo, iFIA } from "../../genesis-block";
import { i18 } from "../../i18/labels";
import { agentMessage } from "../../thread";
import { CadenaProduccion } from "../../mundos/cadena-produccion";

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

        async instanciar(): Promise<string> {

            const demo = "Final de ejecución";

            console.log(agentMessage(i18.FIA_SITUADA_LABEL, i18.SITUADA.SIMULATION_START));

            const cadena = new CadenaProduccion();
            console.log(agentMessage(i18.FIA_SITUADA_LABEL, i18.SITUADA.SIMULATION_BODY));

            const modelo = await cadena.instanciar();
            console.log(agentMessage(i18.FIA_SITUADA_LABEL, modelo.nombre));

            return `${demo}`;
        }
    }

    export const fiaSituada = new iIASituada();

    fiaSituada.nombre = i18.FIA_SITUADA_LABEL;
    fiaSituada.razona =
        (w: Mundo, i: Intencion) => {
        return "Sí";
    }

}
