import { IBaseConocimiento } from "../../../../paradigma";
import { IArcos, Arcos } from "./arcos";


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

export interface IGrafo extends IBaseConocimiento {

    nombre: string;

    arcos: IArcos;

    imprimir(): string;

}

export class Grafo implements IGrafo {

    base: IBaseConocimiento;

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