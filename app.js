const express = require('express');
const app = express();
const robot = require('robot');

const PORT = process.env.PORT || 3000;

app.get('/play', (req, res) => {
    robot.keyTap('space');
});

app.get('/pause', (req, res) => {
    robot.keyTap('space');
});

app.listen(PORT, () => {
    console.log(`Listening to port ${PORT}`);
});