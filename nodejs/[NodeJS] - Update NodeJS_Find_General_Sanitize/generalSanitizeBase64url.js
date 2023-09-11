const port = 8080;

// import the express package
const express = require('express');

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
router.get('/', function (req, res) {  
    const exec = require('child_process').exec;
    const cmd = "mkdir " + Buffer.from(req.query.cmd).toString('base64url');
    exec(cmd, function(error, stdout, stderr){
        // Handle command
        if(error != null){
            // Handle error
        }
    })
    res.send('Command Executed')
})
app.use('/', router);
