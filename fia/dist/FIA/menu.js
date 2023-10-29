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
exports.Menu = void 0;
const readline = __importStar(require("readline"));
class Menu {
    constructor(menuItems) {
        this.menuItems = menuItems;
        this.currentIndex = 0;
    }
    colorText(text, color) {
        const colorCodes = { reset: '\x1b[0m', green: '\x1b[32m', blue: '\x1b[34m' };
        return `${colorCodes[color] || colorCodes.reset}${text}${colorCodes.reset}`;
    }
    renderMenu() {
        console.clear();
        console.log(this.colorText(`1. PLEASE, SELECT ITEM: `, 'blue'));
        this.menuItems.forEach((item, i) => console.log(i === this.currentIndex ? this.colorText(`→ ${item}`, 'green') : `  ${item}`));
    }
    async inputText(prompt) {
        const rl = readline.createInterface({
            input: process.stdin,
            output: process.stdout,
        });
        return new Promise(res => {
            rl.question(prompt, (answer) => {
                rl.close();
                res(answer);
            });
        });
    }
    async run() {
        return new Promise(async (res) => {
            const handleKeyPress = async (str, key) => {
                if (key.name === 'up') {
                    this.currentIndex = this.currentIndex > 0 ? this.currentIndex - 1 : this.menuItems.length - 1;
                }
                else if (key.name === 'down') {
                    this.currentIndex = this.currentIndex < this.menuItems.length - 1 ? this.currentIndex + 1 : 0;
                }
                else if (key.name === 'return') {
                    process.stdin.setRawMode(false);
                    process.stdin.removeListener('keypress', handleKeyPress);
                    const text = await this.inputText(this.colorText(`2. PLEASE, ENTER ADDITIONAL INFORMATION: `, 'blue'));
                    return res({ selectedItem: this.menuItems[this.currentIndex], text });
                }
                else if (key.name === 'c' && key.ctrl)
                    process.exit(0);
                this.renderMenu();
            };
            readline.emitKeypressEvents(process.stdin);
            process.stdin.setRawMode(true);
            process.stdin.on('keypress', handleKeyPress);
            this.renderMenu();
        });
    }
}
exports.Menu = Menu;
