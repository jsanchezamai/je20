
import { Any, iFIA } from "./genesis-block";
import { agentMessage, systemMessage } from "./thread";
import { i18 } from "./i18/labels"

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


        console.log(agentMessage(tested.nombre, i18.TURING_TEST_START_LABEL));
        console.log(agentMessage(i18.ME_TURING_TESTER, i18.TURING_TEST_LABEL));
        const accion = tested
            .razona(i18.TURING_TEST_LABEL, "Test");

        const veredicto = accion == "Sí" ? accion as TestResult : "No";
        console.log(agentMessage(tested.nombre, veredicto));

        console.log(agentMessage(i18.ME_TURING_TESTER, i18.TURING_TEST_STOP_LABEL))

        return "";
    }

}