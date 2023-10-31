import { IModeloFormal, IMotorInferencia } from "../../paradigma";
import { Conceptual } from "../conceptual/paradigma";

export class Formal extends Conceptual implements IModeloFormal {
    motor: IMotorInferencia;

}