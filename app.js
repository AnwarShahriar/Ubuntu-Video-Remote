const express = require('express');
const app = express();
const robot = require('robot');

const PORT = process.env.PORT || 3000;

app.get('/toggle', (req, res) => {
    robot.keyTap('space');
    res.send("Ok");
});

app.listen(PORT, () => {
    console.log(`Listening to port ${PORT}`);
});