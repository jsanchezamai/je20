"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Mundo = exports.Modelo = void 0;
const thread_1 = require("../thread");
const labels_1 = require("../i18/labels");
class Modelo {
    constructor() {
        this.nombre = "Modelo base. 10 días; pulso: 1 segundo";
        this.dia = 0;
        this.muerte = 3;
        this.pulso = 1000;
    }
}
exports.Modelo = Modelo;
class Mundo {
    constructor() {
        this.nombre = "mundo-1";
        this.modelo = new Modelo();
    }
    async ciclo() {
        return await new Promise((resolve, reject) => {
            console.log((0, thread_1.agentMessage)(this.nombre, `${labels_1.i18.MUNDO.INICIO_LABEL}`));
            this.pulsoVital = setInterval(() => this.jornada(resolve, reject), this.modelo.pulso);
        });
    }
    jornada(vivir, morir) {
        if (this.vivo()) {
            try {
                this.modelo = this.pulso(this.modelo);
            }
            catch (ex) {
                console.log("Error en mundo", this.nombre, ex.message);
                this.deponer(this.pulsoVital);
                return morir({
                    estado: ex.message,
                    modelo: this.modelo
                });
            }
        }
        else {
            this.deponer(this.pulsoVital);
            vivir(this.modelo);
        }
    }
    deponer(intervalo) {
        this.destructor();
        clearInterval(intervalo);
    }
    destructor() {
        console.log((0, thread_1.agentMessage)(this.nombre, `${labels_1.i18.MUNDO.FIN_LABEL}`));
    }
    pulso(m) {
        m.dia++;
        console.log((0, thread_1.agentMessage)(this.nombre, `${labels_1.i18.MUNDO.DIA_LABEL} ${m.dia}`));
        return m;
    }
    vivo() {
        return this.modelo.dia <= this.modelo.muerte;
    }
}
exports.Mundo = Mundo;
