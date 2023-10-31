import { i18 } from "../../i18/labels";
import { Automata } from "../../paradigmas/situada/paradigma";
import { CadenaModelo } from "./cadena-modelo";
import { TOPE_POSICION } from "./cadena-fia";
import { CadenaMundo } from "./cadena-mundo";
import { CadenaEstado } from "./cadena-estado";

export class CadenaAutomata<CadenaEstados> extends Automata<CadenaEstados> {

    configurar(): void {

        this.mundo = new CadenaMundo();
        this.mundo.modelo = new CadenaModelo();
        this.mundo.nombre = i18.SITUADA.CADENA.NOMBRE;
        this.mundo.modelo.muerte = TOPE_POSICION;

        this.estado = new CadenaEstado<CadenaEstados>(this.mundo.modelo);

        super.configurar();

    }

}