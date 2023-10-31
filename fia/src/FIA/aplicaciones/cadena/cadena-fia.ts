import { GenesisBlock } from "../../genesis-block";
import { i18 } from "../../i18/labels";
import { agentMessage } from "../../thread";
import { iIASituada } from "../../paradigmas/situada/paradigma";
import { CadenaEstados } from "./cadena-estado";
import { CadenaAutomata } from "./cadena-automata";

// export namespace IASituada {

    export const TOPE_POSICION = 9;

    export class FIACadena extends GenesisBlock implements iIASituada {

        runAsync = true;

        automata = new CadenaAutomata<CadenaEstados>();

        async instanciar(): Promise<string> {

            console.log(agentMessage(i18.SITUADA.CADENA.NOMBRE, i18.SITUADA.SIMULATION_START));

            this.automata.configurar();
            await this.automata.inicializar();

            console.log(
                agentMessage(i18.SITUADA.CADENA.NOMBRE,
                `${i18.SITUADA.SIMULATION_BODY}:${this.automata.mundo.modelo.imprimir()}`)
            );

            return `${i18.SITUADA.SIMULATION_END}`;
        }
    }

// }

export namespace IASituadaCadenaProduccion {

    export const fiaCadena = new FIACadena();

    fiaCadena.nombre = i18.SITUADA.CADENA.NOMBRE;

}