import { Trinity } from "./implementation/Trinity";
import { ITrinity } from "./interfaces/ITrinity";
import { en, es, tech } from "./io";

export let L = en;

const schema: ITrinity = new Trinity();
schema.printHypostasis("trinity");
schema.getSchism().printSchism("filioque");

L = es;
schema.redefineHypostasis();
schema.printHypostasis("trinity_es");
schema.getSchism().printSchism("filioque_es");

L = tech;
schema.redefineHypostasis();
schema.printHypostasis("trinity_te");
schema.getSchism().printSchism("filioque_te");