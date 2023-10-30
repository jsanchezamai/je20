import { i18 } from "../i18/labels";
import { IModelo, IMundo, Mundo } from "./mundo";

export class CadenaProduccion {
    mundo: IMundo;

    constructor() {
    }

    async instanciar(): Promise<IModelo> {

        return await new Promise(async (resolve, reject) => {

            this.mundo = new Mundo();
            this.mundo.nombre = `${i18.MUNDO.EJEMPLOS_CADENA_LABEL}`;

            const modelo = await this.mundo.ciclo();

            resolve(modelo);

        })

    }
}