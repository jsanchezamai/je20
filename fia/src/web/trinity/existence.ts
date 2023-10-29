import { Father } from "./implementation/Father";
import { God } from "./implementation/God";
import { Son } from "./implementation/Son";
import { Spirit } from "./implementation/Spirit";
import { L } from "./seed";

export function typeGuardIsGod(object: God | Father | Son | Spirit): object is God {
    return (object as God).eye === L.EYE_GOD;
}