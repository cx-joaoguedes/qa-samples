'use strict';
const { createRequire, createRequireFromPath } = require('module');
const {resolve} = require('path')
const express = require('express')
const app = express()

app.get('/create-require',(req,res)=>{
  user_input = req.params.user_input
createRequire(resolve(user_input));
})

console.log(process.argv[2])

createRequire(resolve('./some-folder/some-file'));
createRequire(resolve('./some-file'));
createRequire(resolve('../some-folder/some-file'));

createRequire(resolve(process.argv[2]));

