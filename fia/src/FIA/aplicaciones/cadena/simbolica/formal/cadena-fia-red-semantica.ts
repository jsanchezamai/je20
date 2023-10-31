import { RedSemantica } from "../../../../paradigmas/simbolica/modelos/formal/sistema/semantica";
import { CadenaFIASimbolica } from "../cadena-fia-simbolica";


export class CadenaRedSemantica extends CadenaFIASimbolica {

    constructor() {
        super();
        this.modelo = new RedSemantica();
    }

}


