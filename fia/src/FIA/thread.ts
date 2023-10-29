import { Runtime } from "./engine/kernel/runtime";
import { iFIA } from "./genesis-block";
import { i18 } from "./i18/labels";
import * as readline from 'readline';

export const EXIT_PROMPT_INDEX = 99;

const rt = new Runtime();
rt.start();

export function systemMessage(message: string) {
    return `${i18.ME_LABEL}> ${message}`;
}

export function agentMessage(agent: string, message: string) {
    return `${agent}> ${message}`;
}

export function menuOption(message: string) {
    return `\t - ${message}`;
}

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const waitForUserInput = () => {

    console.log(systemMessage(`${i18.MENU_HEADER_LABEL}`));
    Runtime.threads.forEach((t: iFIA, index: number) => {
        console.log(menuOption(`[${index}]: Modelo: ${t.nombre}`));
    });
    console.log(menuOption(`[${EXIT_PROMPT_INDEX}]: ${i18.EXIT_PROMT_LABEL}`));

    rl.question(`${i18.MENU_PROMPT_DATA_LABEL}`, (answer) => {

        const index = parseInt(answer);
        if (isNaN(index)) {
            console.log("No FIA index given!", answer);
        } else {

            try {
                const fia = Runtime.threads[index];

                console.clear();
                console.log(systemMessage(`${i18.LAUNCH_FIA_LABEL}: ${fia.nombre}`));
                console.log(agentMessage(fia.nombre, fia.imprimir()));

            } catch(Ex) {
                console.log("Error loading FIA", Ex.message);
            }
        }
        if (index == EXIT_PROMPT_INDEX){
            console.log(systemMessage(`"System closed by user! Bye!"`));
            rl.close();
        } else {
            waitForUserInput();
        }
    });
}

console.log(systemMessage(`${i18.LOAD_FIA_LABEL}`));
waitForUserInput();