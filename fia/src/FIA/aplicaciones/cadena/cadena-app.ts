import { GenesisBlock } from "../../genesis-block";
import { i18 } from "../../i18/labels";
import { agentMessage } from "../../thread";
import { App } from "../paradigma";
import { CadenaRedSemantica } from "./simbolica/formal/cadena-fia-red-semantica";
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
        this.situada = new CadenaFIASituada();
        this.simbolica = new CadenaRedSemantica();

        await Promise.all(
            [
                this.situada.instanciar(),
                this.simbolica.instanciar()
            ]
        );

        return `${i18.APPS.CADENA.SIMULATION_END}`;
    }
}