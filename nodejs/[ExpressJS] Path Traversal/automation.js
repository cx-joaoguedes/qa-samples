const express = require('express')
const app = express()
const port = 3000

app.get('/downloadFileUnsafe', (req, res) => {
    res.download(req.query.payload)
})

app.get('/downloadFileSafe', (req, res) => {
    res.download(req.query.payload, {root: './uploads'})
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})
