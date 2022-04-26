const path = require('path');

module.exports = {
    entry: ['./src/web/trinity/seed.ts'],
    module: {
        rules: [
            {
                test: /\.tsx?$/,
                use: 'ts-loader',
                exclude: /node_modules/,
            }
        ],
    },
    resolve: {
        alias: {
        },
        extensions: ['.tsx', '.ts', '.js', '.d.ts']
    },
    output: {
        filename: 'trinity.js',
        path: path.resolve(__dirname, '../../../dist/web'),
    }
};