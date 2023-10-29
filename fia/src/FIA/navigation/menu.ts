import * as readline from 'readline';
import { i18, i18_ME } from './thread';

export function systemMessage(message: string) {
    return `${i18.ME_LABEL}> ${message}`;
}
export class Menu {
    private currentIndex = 0;
    constructor(public menuItems: string[]) {}

    private colorText(text: string, color: string): string {
        const colorCodes: Record<string, string> = { reset: '\x1b[0m', green: '\x1b[32m', blue: '\x1b[34m' };
        return `${colorCodes[color] || colorCodes.reset}${text}${colorCodes.reset}`;
    }

    private renderMenu(): void {
        console.clear();
        console.log(this.colorText(systemMessage(`${i18.MENU_HEADER_LABEL}`), 'blue'));
        this.menuItems.forEach((item, i) =>
            console.log(i === this.currentIndex ? this.colorText(`→ ${item}`, 'green') : `  ${item}`),
        );
    }

    private async inputText(prompt: string): Promise<string> {
        const rl = readline.createInterface({
            input: process.stdin,
            output: process.stdout,
        });

        return new Promise(res => {
            rl.question(prompt, (answer: string) => {
                rl.close();
                res(answer);
            });
        });
    }

    async run(): Promise<{ selectedItem: string; text: string }> {
        return new Promise(async res => {
            const handleKeyPress = async (str: string, key: readline.Key) => {
                if (key.name === 'up') {
                    this.currentIndex = this.currentIndex > 0 ? this.currentIndex - 1 : this.menuItems.length - 1;
                } else if (key.name === 'down') {
                    this.currentIndex = this.currentIndex < this.menuItems.length - 1 ? this.currentIndex + 1 : 0;
                } else if (key.name === 'return') {
                    process.stdin.setRawMode(false);
                    process.stdin.removeListener('keypress', handleKeyPress);
                    const text = await this.inputText(
                        this.colorText(systemMessage(`${i18.MENU_PROMPT_DATA_LABEL}`), 'blue'),
                    );
                    return res({ selectedItem: this.menuItems[this.currentIndex], text });
                } else if (key.name === 'c' && key.ctrl) process.exit(0);

                this.renderMenu();
            };

            readline.emitKeypressEvents(process.stdin);
            process.stdin.setRawMode(true);
            process.stdin.on('keypress', handleKeyPress);
            this.renderMenu();
        });
    }
}