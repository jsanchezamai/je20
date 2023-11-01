import { GenesisBlock } from "../../genesis-block";
import { i18 } from "../../i18/labels";
import { agentMessage } from "../../thread";
import { App } from "../paradigma";
import { CadenaFIARedSemantica } from "./simbolica/formal/cadena-fia-red-semantica";
import { CadenaFIASituada } from "./situada/cadena-fia-situada";

export class CadenaApp extends App {

    runAsync: true;

    constructor() {
        super();
        this.nombre = i18.APPS.CADENA.NOMBRE;
    }

    async instanciar(): Promise<string> {

        console.log(agentMessage(this.nombre, i18.APPS.CADENA.SIMULATION_START));

        /**
         *
         */
        // this.situada = new CadenaFIASituada();
        this.simbolica = new CadenaFIARedSemantica();

        const salidas = await Promise.all(
            [
                // this.situada.instanciar(),
                this.simbolica.instanciar()
            ]
        );

        return `${salidas.join("\n\t - ")}${i18.APPS.CADENA.SIMULATION_END}`;
    }
}