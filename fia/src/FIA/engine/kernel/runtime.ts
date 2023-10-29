
import { iFIA, FIA, GenesisBlock } from "../../genesis-block";
import { IACientifica } from "../../paradigmas/cientifica/paradigma";
import { IASimbolica } from "../../paradigmas/simbolica/paradigma";
import { IASituada } from "../../paradigmas/situada/paradigma";
import { IAConexionista } from "../../paradigmas/conexionista/paradigma";

export class Runtime {

    static threads: iFIA[] = [];

    start() {

        const fia = new FIA();
        Runtime.threads.push(fia);

        const gb = new GenesisBlock();
        Runtime.threads.push(gb);

        Runtime.threads.push(IACientifica.fiaDebil);
        Runtime.threads.push(IACientifica.fiaFuerte);
        Runtime.threads.push(IASimbolica.fiaSimbolica);
        Runtime.threads.push(IASituada.fiaSituada);
        Runtime.threads.push(IAConexionista.fiaConexionista);

    }

    demo() {



    }
}