const port = 8080;

// imports
const express = require('express');
const assert = require('assert');

// creates an express app
const app = express();

// start the server
app.listen(port, function (err) {
    if (!err)
        console.log(`Server is running at port ${port}`);
    else
        console.log(err);
});

// create routes
const router = require('express').Router();
router.get('/', (req, res) => {
    const input = req.query.input;
    try {
        assert.doesNotMatch(input, /<script\b[^>]*>([\s\S]*?)<\/script>/);
    } catch (err) {
        return res.send("Invalid input")
    }
    res.send(input)
});
app.use('/', router);