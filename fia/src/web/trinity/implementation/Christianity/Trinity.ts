import { L } from "../../ChristianSeed";
import { ChristianityRegions } from "../../interfaces/ChristianityRegions";
import { GodHypostasis } from "../../interfaces/GodHypostasis";
import { IEastWestSchism } from "../../interfaces/IEastWestSchism";
import { IFather } from "../../interfaces/IFather";
import { IGod } from "../../interfaces/IGod";
import { ISon } from "../../interfaces/ISon";
import { ISpirit } from "../../interfaces/ISpirit";
import { ITrinity } from "../../interfaces/ITrinity";
import { EastWestSchism } from "../EastWestSchism";
import { Father } from "../Father";
import { God } from "../God";
import { Son } from "../Son";
import { Spirit } from "../Spirit";


export class Trinity implements ITrinity {

    htmlKey: string = "";

    existence: IGod[] = [];

    god: IGod = new God();
    father: IFather = new Father();
    son: ISon = new Son();
    spirit: ISpirit = new Spirit();

    region: ChristianityRegions = ChristianityRegions.Ecumenical;

    constructor() {
        this.setExistence();
    }

    redefineHypostasis() {
        this.god = new God();
        this.father = new Father();
        this.son = new Son();
        this.spirit = new Spirit();

        this.setExistence();
    }

    setExistence(): void {
        this.existence = [this.god, this.father, this.son, this.spirit];
    }

    redefineSpirit(spirit: ISpirit): void {
        this.spirit = Object.assign(new Spirit(), spirit);
        this.setExistence();
    }

    getHypostasis(hypostasis: GodHypostasis): IGod {
        return this.existence.find(g => g.hypostasis === hypostasis) || this.god;
    }

    printHypostasis(htmlKey: string): void {

        this.htmlKey = htmlKey;

        const title = document.getElementById(`${htmlKey}h1`);
        title?.append(L.TRINITY_TITLE);

        const subtitle = document.getElementById(`${htmlKey}h2`);
        subtitle?.append(L.TRINITY_SUBTITLE);

        const desc = document.getElementById(`${htmlKey}h3`);
        desc?.append(L.HYPOSTASIS_DESCRIPTION);

        const div = document.getElementById(`${htmlKey}div`);

        // Print self
        const ul = document.createElement("ul");
        div?.appendChild(ul);
        this.existence.forEach(o => {
            const li = document.createElement("li");
            li.textContent = o.areYou(o);
            ul?.appendChild(li);
        });

        // Print relations
        this.existence.forEach(o => {
            const ul = document.createElement("ul");
            div?.appendChild(ul);
            this.existence.forEach(oo => {
                const li = document.createElement("li");
                if (o === oo) return;
                li.textContent = o.areYou(oo);
                ul?.appendChild(li);
            })
        });
    }

    getSchism(): IEastWestSchism {
        return new EastWestSchism(this);
    }
}
