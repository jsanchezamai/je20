import { IEntidad, IEstado, IConcepto, IGrafo } from "./grafo";

export interface IRelacionEstructural extends IEstado {
    valor: "subclase-de" | "instancia-de" | "parte-de" | string;
}

export class RelacionEstructural implements IRelacionEstructural {
    nombre: string;
    valor = "";
}

export interface IRelacionDescriptiva extends IEstado {
    valor: "";
}

export class RelacionDescriptiva implements IRelacionDescriptiva {
    valor: "";
    nombre: string;
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

export class EtiquetaDescriptiva implements IEtiquetaDescriptiva {
    estado: IRelacionDescriptiva = new RelacionDescriptiva();
}

export interface IArco {

    etiqueta: IEtiqueta;
    destino: IGrafo;

}

export class Arco implements IArco {
    etiqueta: IEtiqueta;
    destino: IGrafo;
}

export interface IArcoDescriptivo extends IArco {

    etiqueta: IEtiquetaDescriptiva;

}

export class ArcoDescriptivo implements IArcoDescriptivo {

    destino: IGrafo;
    etiqueta = new EtiquetaDescriptiva();

}


export interface IArcoEstructural extends IArco {

    etiqueta: IEtiquetaEstructural;

}

export class ArcoEstructural extends Arco implements IArcoEstructural {

    etiqueta = new EtiquetaEstructural();

}

export interface IArcos {

    estado: IArco[];

}

export class Arcos implements IArcos {
    estado = [];
}