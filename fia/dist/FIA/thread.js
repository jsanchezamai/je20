"use strict";
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    var desc = Object.getOwnPropertyDescriptor(m, k);
    if (!desc || ("get" in desc ? !m.__esModule : desc.writable || desc.configurable)) {
      desc = { enumerable: true, get: function() { return m[k]; } };
    }
    Object.defineProperty(o, k2, desc);
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || function (mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (k !== "default" && Object.prototype.hasOwnProperty.call(mod, k)) __createBinding(result, mod, k);
    __setModuleDefault(result, mod);
    return result;
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.menuOption = exports.systemMessage = void 0;
const runtime_1 = require("./engine/kernel/runtime");
const labels_1 = require("./i18/labels");
const readline = __importStar(require("readline"));
const rt = new runtime_1.Runtime();
rt.start();
function systemMessage(message) {
    return `${labels_1.i18.ME_LABEL}> ${message}`;
}
exports.systemMessage = systemMessage;
function menuOption(message) {
    return `\t - ${message}`;
}
exports.menuOption = menuOption;
runtime_1.Runtime.threads.forEach((t, index) => {
    console.log(menuOption(`[${index}]: Ejecutar ${t.nombre}`));
});
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
const waitForUserInput = () => {
    rl.question(`${labels_1.i18.MENU_PROMPT_DATA_LABEL}`, (answer) => {
        const index = parseInt(answer);
        if (isNaN(index)) {
            console.log("No FIA index given!", answer);
        }
        else {
            try {
                const fia = runtime_1.Runtime.threads[index];
                console.log("Write FIA", fia.nombre);
            }
            catch (Ex) {
                console.log("Error loading FIA", Ex.message);
            }
        }
        if (index == 0) {
            console.log("run close");
            rl.close();
        }
        else {
            console.log("run index", index);
            waitForUserInput();
        }
    });
};
waitForUserInput();
