
import { Any, iFIA } from "./genesis-block";

export type TestResult = Any;
export type Test = (tested: iFIA) => TestResult;

export interface ITuringTest {

    tested: iFIA;

    test: Test
}

export class TuringTester implements ITuringTest {

    tested: iFIA;

    constructor() {}

    test = (tested: iFIA) => {

        const accion = tested
            .razona("¿Eres humano?", "Test");

        return accion == "Sí" ? accion as TestResult : "No";
    }

}