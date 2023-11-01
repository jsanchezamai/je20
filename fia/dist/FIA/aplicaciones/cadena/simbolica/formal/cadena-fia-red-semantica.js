"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.CadenaRedSemantica = exports.CadendaGrafo = void 0;
const labels_1 = require("../../../../i18/labels");
const semantica_1 = require("../../../../paradigmas/simbolica/modelos/formal/sistema/semantica");
const thread_1 = require("../../../../thread");
const cadena_fia_simbolica_1 = require("../cadena-fia-simbolica");
class CadendaGrafo extends semantica_1.Grafo {
}
exports.CadendaGrafo = CadendaGrafo;
class CadenaRedSemantica extends cadena_fia_simbolica_1.CadenaFIASimbolica {
    constructor() {
        super();
        this.entidades = [];
        this.nombre = labels_1.i18.APPS.CADENA.SIMBOLICA.RED.NOMBRE;
        const grafo = new CadendaGrafo();
        this.modelo = new semantica_1.RedSemantica();
        this.modelo.base = grafo;
    }
    async instanciar() {
        console.log((0, thread_1.agentMessage)(this.nombre, labels_1.i18.APPS.CADENA.SIMBOLICA.SIMULATION_START));
        this.cargaRed();
        console.log((0, thread_1.agentMessage)(this.nombre, `${labels_1.i18.APPS.CADENA.SIMULATION_BODY}:${this.imprimir()}`));
        return `${labels_1.i18.APPS.CADENA.SIMBOLICA.SIMULATION_END}`;
    }
    cargaRed() {
        const red = labels_1.i18.APPS.CADENA.SIMBOLICA.DOMINIO;
        /**
         * Añadir entidades maestras
         */
        Object.keys(red.ENTIDADES).forEach(i => {
            const valor = red.ENTIDADES[i];
            const label = {
                nombre: `${valor}`,
                valor: `${valor}`
            };
            const entidad = Object.assign(new CadendaGrafo(), label);
            this.entidades.push(entidad);
        });
        /**
         * Añadir entidades del arco "subclase-de"
         */
        Object.keys(red.ARCOS.ESTRUCTURALES.SUBCLASE).forEach(clase_hija => {
            const etiqueta_texto = red.ARCOS.ESTRUCTURALES.SUBCLASE.texto;
            if (clase_hija === etiqueta_texto) {
                return;
            }
            const existing = this.entidades.find(e => e.nombre === clase_hija);
            const grafoHija = existing || new CadendaGrafo();
            if (existing) {
            }
            else {
                this.entidades.push(grafoHija);
                grafoHija.nombre = clase_hija;
            }
            const padres = red.ARCOS.ESTRUCTURALES.SUBCLASE[clase_hija];
            Object.keys(padres).forEach(clase_padre => {
                const grafoPadre = this.entidades.find(e => e.nombre === clase_padre);
                if (!grafoPadre) {
                    console.log("Error de integridad en CadenaFiaRedSemantica.ARCOS.ESTRUCTURALES.SUBCLASE", "padre no encontrado para la hija", clase_hija);
                    return;
                }
                const relacion = new semantica_1.RelacionEstructural();
                relacion.nombre = etiqueta_texto.replace("clave", grafoHija.nombre).replace("valor", grafoPadre.nombre);
                const etiqueta = new semantica_1.EtiquetaEstructural();
                etiqueta.estado = relacion;
                const arco = new semantica_1.ArcoEstructural();
                arco.destino = grafoPadre;
                arco.etiqueta = etiqueta;
                grafoHija.arcos.estado.push(arco);
            });
        });
    }
    imprimir() {
        let out = "";
        this.entidades.forEach(e => {
            out += "\n\t -- (entidad) --" + e;
        });
        return out;
    }
}
exports.CadenaRedSemantica = CadenaRedSemantica;
