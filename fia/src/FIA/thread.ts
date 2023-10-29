
import { FIA, GenesisBlock } from "./genesis-block";
import { FiaFuerte } from "./fia-fuerte";
import { FiaDebil } from "./fia-debil";
import { TuringTester } from "./turing-test";

console.log("Iniciando el modelizador de Fundamentos de inteligencia artificial. v1...");

console.log("\t - Proceso principal:");

const fia = new FIA();

console.log("\t\t - Carga del modelo semilla:", fia.modelo);

const gb = new GenesisBlock();
console.log("\t\t - Carga de la instancia génesis:", gb.modelo);

console.log("\n", "\t - Hechos raíz:");

const test = new TuringTester();

console.log("\t\t - Tipos de inteligencia #1:");
console.log("\t\t\t tester> ¿Eres o podrías ser humana?");
console.log(`\t\t\t ${FiaDebil.modelo}> ${test.test(FiaDebil)}`);

console.log("\t\t - Tipos de inteligencia #2:");
console.log("\t\t\t tester> ¿Eres o podrías ser humana?");
console.log(`\t\t\t ${FiaFuerte.modelo}> ${test.test(FiaFuerte)}`);

console.log("\n", "\t - Aplicación finalizada");