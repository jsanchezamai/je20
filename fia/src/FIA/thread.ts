
import { FIA, GenesisBlock } from "./genesis-block";
import { loadCientifica } from "./paradigmas/cientifica/indice";
import { loadSimbolica } from "./paradigmas/simbolica/indice";
import { loadSituada } from "./paradigmas/situada/indice";
import { loadConexionista } from "./paradigmas/conexionista/indice";
import { Menu } from "./menu";


const m = new Menu(
    ["- ¡¡Listo para interactuar, humanos!!!",
    "- Not today, close, please, bye!"]
);

m.run().then(
    (value: { selectedItem: string; text: string }) => {
    console.log(value);
    }
);

console.log("Iniciando el modelizador de Fundamentos de inteligencia artificial. v1...");

console.log("\t - Proceso principal:");

const fia = new FIA();

console.log("\t\t - Carga del modelo semilla:", fia.nombre);

const gb = new GenesisBlock();
console.log("\t\t - Carga de la instancia génesis:", gb.nombre);

console.log("\n", "\t - Hechos raíz:");

loadCientifica();
loadSimbolica();
loadSituada();
loadConexionista();

console.log("\n", "\t - El sistema inteligente ha sido cargado!");




