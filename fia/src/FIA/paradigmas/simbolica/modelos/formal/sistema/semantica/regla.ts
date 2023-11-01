import { i18 } from "../../../../../../i18/labels";
import { IReglaRed, IInferencia } from "../../../../paradigma";
import { InferenciaRelacion } from "../../inferencia/relacion/paradigma";

export class ReglaRed extends InferenciaRelacion implements IReglaRed {

    evaluar(): IInferencia {

        const activar = this.activar();

        console.log(
            i18.SIMBOLICA.SEMANTICA.REGLA,
            "> ReglaRed",
            "Entidades origen: ", activar.contexto.arcos.estado.length,
            "Parametros: ", Object.keys(activar.parametros).length
        );

        return this;
    }
}