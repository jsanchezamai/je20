import { Runtime } from "./engine/kernel/runtime";
import { iFIA } from "./genesis-block";
import { i18 } from "./i18/labels";
import * as readline from 'readline';

const rt = new Runtime();
rt.start();

export function systemMessage(message: string) {
    return `${i18.ME_LABEL}> ${message}`;
}

export function menuOption(message: string) {
    return `\t - ${message}`;
}

Runtime.threads.forEach((t: iFIA, index: number) => {
    console.log(menuOption(`[${index}]: Ejecutar ${t.nombre}`));
})

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const waitForUserInput = () => {

    rl.question(`${i18.MENU_PROMPT_DATA_LABEL}`, (answer) => {

        const index = parseInt(answer);
        if (isNaN(index)) {
            console.log("No FIA index given!", answer);
        } else {

            try {
                const fia = Runtime.threads[index];
                console.log("Write FIA", fia.nombre);

            } catch(Ex) {
                console.log("Error loading FIA", Ex.message);
            }
        }
        if (index == 0){
            console.log("run close");
            rl.close();
        } else {
            console.log("run index", index);
            waitForUserInput();
        }
    });
}

waitForUserInput();