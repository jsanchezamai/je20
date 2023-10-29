
import { iFIA, FIA, GenesisBlock } from "../../genesis-block";
import { loadCientifica } from "../../paradigmas/cientifica/indice";
import { loadSimbolica } from "../../paradigmas/simbolica/indice";
import { loadSituada } from "../../paradigmas/situada/indice";
import { loadConexionista } from "../../paradigmas/conexionista/indice";
import { IACientifica } from "../../paradigmas/cientifica/paradigma";
import { IASimbolica } from "../../paradigmas/simbolica/paradigma";
import { IASituada } from "../../paradigmas/situada/paradigma";
import { IAConexionista } from "../../paradigmas/conexionista/paradigma";

export class Runtime {

    static threads: iFIA[] = [];

    start() {

        console.log("Iniciando el modelizador de Fundamentos de inteligencia artificial. v1...");

        console.log("\t - Proceso principal:");

        const fia = new FIA();
        Runtime.threads.push(fia);

        console.log("\t\t - Carga del modelo semilla:", fia.nombre);

        const gb = new GenesisBlock();
        Runtime.threads.push(gb);

        console.log("\t\t - Carga de la instancia génesis:", gb.nombre);

        console.log("\n", "\t - Hechos raíz:");

        loadCientifica()
        Runtime.threads.push(IACientifica.fiaDebil);
        Runtime.threads.push(IACientifica.fiaFuerte);

        loadSimbolica()
        Runtime.threads.push(IASimbolica.fiaSimbolica);

        loadSituada();
        Runtime.threads.push(IASituada.fiaSituada);

        loadConexionista();
        Runtime.threads.push(IAConexionista.fiaConexionista);

        console.log("\n", "\t - El sistema inteligente ha sido cargado!");
    }
}