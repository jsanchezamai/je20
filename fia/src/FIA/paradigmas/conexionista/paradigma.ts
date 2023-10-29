import { GenesisBlock, Intencion, Mundo, iFIA } from "../../genesis-block";

export namespace IAConexionista {

    export interface ICanalizacion {}

    export interface IRedNeuronalArtificial {
        clasificador: IClasificadorNumericoParametrizado;

        clasificar: (c: ICanalizacion) => ISolucion;
    }

    export interface ISolucion {}

    export interface IEtiqueta {

    }

    export interface IAprendizaje {

    }

    export interface IAprendizajeSupervisado extends IAprendizaje {
        etiquetado: IEtiqueta;
    }

    export interface IAprendizajeNoSupervisado extends IAprendizaje  {

    }

    export interface IClasificadorNumericoParametrizado {

        canalizacion: ICanalizacion;

    }

    export interface iIAConexionista extends iFIA {

        red: IRedNeuronalArtificial;

        inferencia: (p: ICanalizacion) => ISolucion;

    }

    export class IAConexionista extends GenesisBlock implements iIAConexionista {

        red: IRedNeuronalArtificial;

        aprendizaje: (p: IAprendizaje) => IRedNeuronalArtificial;

        inferencia(c: ICanalizacion): ISolucion {
            return this.red.clasificar(c);
        }
    }

    export const fiaConexionista = new IAConexionista();

    fiaConexionista.nombre = "FIA Conexionista";
    fiaConexionista.razona =
        (m: Mundo, i: Intencion) => {
        return "No";
    }

}
