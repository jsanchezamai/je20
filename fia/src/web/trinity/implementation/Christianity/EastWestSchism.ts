import { L } from "../../ChristianSeed";
import { ChristianityRegions } from "../../interfaces/Christianity/ChristianityRegions";
import { GodHypostasis } from "../../interfaces/Christianity/GodHypostasis";
import { IEastWestSchism } from "../../interfaces/Christianity/IEastWestSchism";
import { ISpirit } from "../../interfaces/Christianity/ISpirit";
import { ITrinity } from "../../interfaces/Christianity/ITrinity";
import { Spirit } from "./Spirit";
import { Trinity } from "./Trinity";

export class EastWestSchism implements IEastWestSchism{

    htmlKey: string = "";

    east: ITrinity;
    west: ITrinity;

    constructor(Niceno_Constantinopolitan__Creed: ITrinity) {
        this.east = Object.assign(new Trinity(), Niceno_Constantinopolitan__Creed);
        this.west = Object.assign(new Trinity(), Niceno_Constantinopolitan__Creed);
        this.setEast();
        this.setWest();
    }

    setEast(): void {
        this.east.region = ChristianityRegions.Eastern_Orthodox;
        const ortodoxSpirit = new Spirit();
        const ortodoxFather = this.east.getHypostasis(GodHypostasis.Father);
        ortodoxSpirit.proceedFrom = [ortodoxFather];
        this.east.redefineSpirit(ortodoxSpirit);
    }

    setWest(): void {
        this.west.region = ChristianityRegions.Western_Catholic;
        const catholicSpirit = new Spirit();
        const catholicFather = this.west.getHypostasis(GodHypostasis.Father);
        const catholicSon = this.west.getHypostasis(GodHypostasis.Son);
        catholicSpirit.proceedFrom = [catholicFather, catholicSon];
        this.west.redefineSpirit(catholicSpirit);
    }

    printSchism(htmlKey: string) {
        this.htmlKey = htmlKey;

        const title = document.getElementById(`${htmlKey}h2`);
        title?.append(L.SCHISM_TITLE);

        this.printChurch(this.east);
        this.printChurch(this.west);
    }

    printChurch(church: ITrinity): void {
        const title = document.getElementById(`${this.htmlKey + church.region}h1`);
        title?.append(L.SCHISM_TITLE);

        const subtitle = document.getElementById(`${this.htmlKey + church.region}h2`);
        subtitle?.append(L.SCHISM_SUBTITLE);

        const div = document.getElementById(`${this.htmlKey}div`);

        const churchText = document.createElement(`h3`);
        churchText?.append(church.region === ChristianityRegions.Eastern_Orthodox ? L.SCHISM_EAST : L.SCHISM_WEST);
        div?.appendChild(churchText);

        const ul = document.createElement("ul");
        div?.appendChild(ul);
        const spirit = church.getHypostasis(GodHypostasis.Spirit) as ISpirit;
        spirit.proceedFrom.forEach(o => {
            const li = document.createElement("li");
            li.textContent = `${L.SCHISM_CAUSE}: ${o.eye}`;
            ul?.appendChild(li);
        });
    }
}
