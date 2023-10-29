import { L } from "../../ChristianSeed";
import { typeGuardIsGod } from "../../existence";
import { GodHypostasis } from "../../interfaces/GodHypostasis";
import { IGod } from "../../interfaces/IGod";


export class God implements IGod {

    eye = L.EYE_GOD;

    hypostasis: GodHypostasis = GodHypostasis.All;

    created: boolean = false;
    begotten: boolean = false;
    proceed: boolean = false;

    constructor() {
    }

    getSource(): string {

        const source = this.created ?
            ` ${L.SOURCE_CREATED}` : this.begotten ?
                ` ${L.SOURCE_BEGOTTEN}` : this.proceed ?
                    ` ${L.SOURCE_PROCEED}` : `${L.SOURCE_NOTHING}`;

        const sentence = `${L.SOURCE_LABEL}${source}.`;
        return sentence;
    }

    areYou(object: IGod): string {
        let sentence;
        if (this === object) {
            sentence = `${L.EX_S}${L.YOU_SELF} ${this.eye}${L.EX_E} ${this.getSource()}`;
        } else {
            const answer = typeGuardIsGod(this) || typeGuardIsGod(object);
            const yes = `${L.YOU_IS}`;
            const no = `${L.YOU_ISNOT}`;
            sentence = `${L.QU_S}${L.YOU_IS} ${this.eye} ${L.YOU_ALSO} ${object.eye}${L.QU_E} ${answer ? yes : no}.`;
        }
        return sentence;
    }

}
