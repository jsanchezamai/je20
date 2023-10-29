
import { FIA, GenesisBlock } from "./genesis-block";
import { loadCiencia } from "./paradigmas/cientifica/indice";
import { loadSimbolica } from "./paradigmas/simbolica/indice";
import { loadSituada } from "./paradigmas/situada/indice";

console.log("Iniciando el modelizador de Fundamentos de inteligencia artificial. v1...");

console.log("\t - Proceso principal:");

const fia = new FIA();

console.log("\t\t - Carga del modelo semilla:", fia.modelo);

const gb = new GenesisBlock();
console.log("\t\t - Carga de la instancia génesis:", gb.modelo);

console.log("\n", "\t - Hechos raíz:");

loadCiencia();
loadSimbolica();
loadSituada();

console.log("\n", "\t - Aplicación finalizada");
