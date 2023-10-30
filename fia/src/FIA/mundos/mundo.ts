import { agentMessage, systemMessage } from "../thread"
import { i18 } from "../i18/labels"

export interface IModelo {

    nombre: string;

    /**
     * Contador de días (uno por ciclo)
     */
    dia: number;

    /**
     * Límite de días, el mundo se depondrá
     */
    muerte: number;

    /**
     * Frecuencia de ciclo (en ms)
     */
    pulso: number;

}

export class Modelo implements IModelo {

    nombre = "Modelo base. 10 días; pulso: 1 segundo";
    dia: number = 0;
    muerte: number = 3;
    pulso: number = 1000;
}

export interface IMundo {

    nombre: string;
    modelo: IModelo;

    pulsoVital: NodeJS.Timeout;

    vivo(): boolean;

    pulso: (m: IModelo) => IModelo;

    ciclo: () => Promise<IModelo>;

    jornada(vivir: Function, morir: Function): void;
}

export class Mundo implements IMundo {

    nombre = "mundo-1";

    modelo = new Modelo();

    pulsoVital: NodeJS.Timeout;

    constructor() {}

    async ciclo(): Promise<IModelo> {

        return await new Promise((resolve, reject) => {

            console.log(agentMessage(this.nombre, `${i18.MUNDO.INICIO_LABEL}`));
            this.pulsoVital = setInterval(() => this.jornada(resolve, reject), this.modelo.pulso);

        });
    }

    jornada(vivir: Function, morir: Function) {

        if (this.vivo()) {

            try {

                this.modelo = this.pulso(this.modelo);

            } catch(ex) {

                console.log("Error en mundo", this.nombre, ex.message);

                this.deponer(this.pulsoVital);

                return morir({
                    estado: ex.message,
                    modelo: this.modelo
                });

            }

        } else {
            this.deponer(this.pulsoVital);
            vivir(this.modelo);

        }
    }

    deponer(intervalo: any) {

        clearInterval(intervalo);
        this.destructor();

    }

    destructor() {
        agentMessage(this.nombre, `${i18.MUNDO.FIN_LABEL}`)
    }

    pulso(m: IModelo): IModelo {

        m.dia++;
        console.log(agentMessage(this.nombre, `${i18.MUNDO.DIA_LABEL} ${m.dia}`));

        return m;
    }

    vivo(): boolean {
        return this.modelo.dia <= this.modelo.muerte;
    }

}