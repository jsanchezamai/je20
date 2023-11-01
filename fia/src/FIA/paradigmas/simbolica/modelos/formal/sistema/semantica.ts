import { IBaseConocimiento, IDominio, IModeloFormal, IMotorInferencia, IReglaRed, Inferencia } from "../../../paradigma";
import { Computable } from "../../computable/paradigma";
import { InferenciaRelacion } from "../inferencia/relacion/paradigma";
import { Formal } from "../paradigma";
import { Estado } from '../../../../situada/paradigma';
import { CadenaGrafo } from "../../../../../aplicaciones/cadena/simbolica/formal/cadena-fia-red-semantica";
import { i18 } from "../../../../../i18/labels";
import { agentMessage } from "../../../../../thread";

export interface IEstado {
    nombre: string;
    valor: string;
}

export interface IConcepto extends IEstado {
}

export interface IEntidad extends IEstado {
    imprimir(): void;
}

export class Entidad implements IEntidad {
    nombre = "entidad";
    valor = "entidad";

    imprimir() {
        return this.nombre;
    }

}

export interface IRelacionEstructural extends IEstado {
    valor: "subclase-de" | "instancia-de" | "parte-de" | string;
}

export class RelacionEstructural implements IRelacionEstructural {
    nombre: string;
    valor = "";
}

export interface IEtiqueta {
    estado: IEstado;
}

export interface IEtiquetaEstructural extends IEtiqueta {
    estado: IRelacionEstructural;
}

export class EtiquetaEstructural implements IEtiquetaEstructural {
    estado: IRelacionEstructural = new RelacionEstructural();
}

export interface IEtiquetaDescriptiva extends IEtiqueta {
    estado: IConcepto | IEntidad;
}

export interface IArco extends InferenciaRelacion {

    etiqueta: IEtiqueta;
    destino: IGrafo;

}

export interface IArcoDescriptivo extends IArco {

    etiqueta: IEtiquetaDescriptiva;
    destino: IGrafo;

}

export interface IArcoEstructural extends IArco {

    etiqueta: IEtiquetaEstructural;
    destino: IGrafo;

}

export class ArcoEstructural implements IArcoEstructural {

    etiqueta = new EtiquetaEstructural();
    destino: IGrafo;
    dominio: IDominio;

}

export interface IArcos {

    estado: IArco[];

}

export class Arcos implements IArcos {
    estado = [];
}

export interface IGrafo extends IBaseConocimiento {

    nombre: string;

    arcos: IArcos;

    imprimir(): string;

}

export class Grafo implements IGrafo {

    nombre: string;

    arcos: IArcos = new Arcos();

    imprimir(): string {

        let out = "";
        out += "\n\t - (grafo) -" + this.nombre + "; arcos";
        this.arcos.estado.forEach(e => {
            out += "\n\t\t - " + e.etiqueta.estado.nombre;
        });
        return out;
    }

}

export class ReglaRed extends InferenciaRelacion implements IReglaRed {

}

export interface IRedSemantica extends IModeloFormal {

    cargar(red: Set<string>, entidades: IGrafo[]);

}
export class RedSemantica extends Formal implements IRedSemantica {

    nombre = i18.SIMBOLICA.SEMANTICA.NOMBRE;

    base = new Grafo();
    motor = new ReglaRed();


    cargar(red: any, entidades: IGrafo[]) {
        /**
         * Añadir entidades maestras
         */
        Object.keys(red.ENTIDADES).forEach(i => {

            // Creación de entidad
            const valor = red.ENTIDADES[i];

            // Opcional: mapeo de valores por defecto
            const entidad = Object.assign(
                new CadenaGrafo(),
                {}
            );
            entidad.nombre = valor;

            console.log(agentMessage(this.nombre,
                `${i18.APPS.CADENA.SIMBOLICA.AGREGANDO_ENTIDADES_LABEL}${valor}`
            ));
            entidades.push(entidad);

        });

        /**
         * Añadir entidades del arco "subclase-de"
         */
        Object.keys(red.ARCOS.ESTRUCTURALES.SUBCLASE).forEach(clase_hija => {

            const etiqueta_texto = red.ARCOS.ESTRUCTURALES.SUBCLASE.texto;
            if (clase_hija === "texto") {
                return;
            }

            const existing = entidades.find(e => e.nombre === clase_hija);

            const grafoHija = existing || new CadenaGrafo();
            if (existing) {

            } else {
                entidades.push(grafoHija);
                grafoHija.nombre = clase_hija;
            }

            const padres = red.ARCOS.ESTRUCTURALES.SUBCLASE[clase_hija];

            Object.keys(padres).forEach(clase_padre => {

                const grafoPadre = entidades.find(e => e.nombre === clase_padre);

                if (!grafoPadre) {
                    console.log(
                        "Error de integridad en CadenaFiaRedSemantica.ARCOS.ESTRUCTURALES.SUBCLASE",
                        ", padre no encontrado para la hija:",
                        clase_hija,
                        ", padre:",
                        clase_padre
                    );
                    return;
                }

                const relacion = new RelacionEstructural();
                relacion.nombre =  etiqueta_texto.replace("clave", grafoHija.nombre).replace("valor", grafoPadre.nombre);

                const etiqueta = new EtiquetaEstructural();
                etiqueta.estado = relacion;

                const arco = new ArcoEstructural();
                arco.destino = grafoPadre;
                arco.etiqueta = etiqueta;
                grafoHija.arcos.estado.push(arco);

                console.log(agentMessage(this.nombre,
                    `${i18.APPS.CADENA.SIMBOLICA.AGREGANDO_SUBCLASES_LABEL}${grafoHija.nombre}/${grafoPadre.nombre}`
                ));

            });

        });

        /**
        * Añadir entidades del arco "parte-de"
        */
        Object.keys(red.ARCOS.ESTRUCTURALES.PARTE).forEach(clase_padre => {

            const etiqueta_texto = red.ARCOS.ESTRUCTURALES.PARTE.texto;
            if (clase_padre === "texto") {
                return;
            }

            const existing = entidades.find(e => e.nombre === clase_padre);

            const grafoPadre = existing || new CadenaGrafo();
            if (existing) {

            } else {
                entidades.push(grafoPadre);
                grafoPadre.nombre = clase_padre;
            }

            const partes = red.ARCOS.ESTRUCTURALES.PARTE[clase_padre];

            Object.keys(partes).forEach(clase_hijo => {

                const existing2 = entidades.find(e => e.nombre === clase_hijo);

                const grafoHijo = existing2 || new CadenaGrafo();
                if (existing2) {

                } else {
                    entidades.push(grafoHijo);
                    grafoHijo.nombre = clase_hijo;
                }

                const relacion = new RelacionEstructural();

                relacion.nombre =  etiqueta_texto.replace("clave", grafoPadre.nombre).replace("valor", grafoHijo.nombre);

                const etiqueta = new EtiquetaEstructural();
                etiqueta.estado = relacion;

                const arco = new ArcoEstructural();
                arco.destino = grafoPadre;
                arco.etiqueta = etiqueta;
                grafoHijo.arcos.estado.push(arco);

                console.log(agentMessage(this.nombre,
                    `${i18.APPS.CADENA.SIMBOLICA.AGREGANDO_PARTE_LABEL}${grafoHijo.nombre}/${grafoPadre.nombre}`
                ));

            });

        });
    }

}