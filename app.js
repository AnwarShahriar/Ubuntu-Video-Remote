const express = require('express');
const app = express();
const robot = require('robotjs');
const networkUtils = require('./network-utils');

const PORT = process.env.PORT || 3000;

app.get('/toggle', (req, res) => {
    robot.keyTap('space');
    res.send("Ok");
});

app.listen(PORT, () => {
    console.log(`Listening to port ${PORT}`);
    const IP = networkUtils.ip() || "No valid IP found";
    console.log('Please put the IP to Anroid client given below: ');
    console.log(`IP: ${IP}`);
});