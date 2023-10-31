import { L } from "../../ChristianSeed";
import { Father } from "../../implementation/Christianity/Father";
import { God } from "../../implementation/Christianity/God";
import { Son } from "../../implementation/Christianity/Son";
import { Spirit } from "../../implementation/Christianity/Spirit";

export function typeGuardIsGod(object: God | Father | Son | Spirit): object is God {
    return (object as God).eye === L.EYE_GOD;
}