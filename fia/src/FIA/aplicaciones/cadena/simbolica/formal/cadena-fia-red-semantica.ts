import { i18 } from "../../../../i18/labels";
import { Grafo, IGrafo, RedSemantica } from "../../../../paradigmas/simbolica/modelos/formal/sistema/semantica";
import { agentMessage } from "../../../../thread";
import { CadenaFIASimbolica } from "../cadena-fia-simbolica";

export class CadenaGrafo extends Grafo {


}

export class CadenaFIARedSemantica extends CadenaFIASimbolica {

    entidades: IGrafo[] = [];

    modelo = new RedSemantica();
    nombre = i18.APPS.CADENA.SIMBOLICA.RED.NOMBRE;

    constructor() {

        super();

        const grafo = new CadenaGrafo();

        this.modelo.nombre = i18.APPS.CADENA.SIMBOLICA.SEMANTICA.NOMBRE;
        this.modelo.base = grafo;

    }

    async instanciar(): Promise<string> {

        console.log(agentMessage(this.nombre, i18.APPS.CADENA.SIMBOLICA.SIMULATION_START));

        this.cargaRed();

        console.log(
            agentMessage(this.nombre, `${i18.APPS.CADENA.SIMULATION_BODY}:${this.imprimir()}`)
        );

        return `${i18.APPS.CADENA.SIMBOLICA.SIMULATION_END}`;
    }

    cargaRed() {

        const red = i18.APPS.CADENA.SIMBOLICA.DOMINIO;
        this.modelo.cargar(red, this.entidades);

    }

    imprimir(): string {

        let out = "";
        this.entidades.forEach(e => {
            out += e.imprimir();
        })
        return out;
    }
}


