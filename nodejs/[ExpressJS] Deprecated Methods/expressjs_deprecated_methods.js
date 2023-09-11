const express = require('express')
var HttpStatus = require('http-status-codes');
const app = express()
const port = 3000

// plain text

app.get('/', (req, res) => {
    res.status('200').send('Hello World!') // sink
})

// defined string

var statusCode = '200'

app.get('/', (req, res) => {
    res.status(statusCode).send('Hello World!') // sink
})

// member

var HttpCodes = {
   success : '200',
   notFound : '404'
   // etc
}

app.get('/', (req, res) => {
    res.status(HttpCodes.success).send('Hello World!') // sink
})

// using third party library (uses integer values)

app.get('/', (req, res) => {
    res.status(HttpStatus.OK).send('Hello World!') // not a sink
})

// will result in "express deprecated res.status("200"): use res.status(200) instead"

app.get('/', (req, res) => {
    console.log("Client IP:", req.connection.remoteAddress); // sink
    console.log("Client Port:", req.connection.remotePort); // sink
    res.send("Hello World!");
});