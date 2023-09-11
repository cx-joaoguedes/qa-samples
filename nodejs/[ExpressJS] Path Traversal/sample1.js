const express = require('express')
const app = express()

app.use(express.json())

// vulnerable
app.get('/download/:file', function (req, res) {
    var file = req.params.file;
    res.download(__dirname + '/uploads/' + file);
});

// vulnerable
app.post('/download/', function (req, res) {
    var file = req.body.file;
    res.download(__dirname + '/uploads/' + file);
});

// vulnerable
app.get('/download/:fileName', (req, res) => {
    const filePath = `./files/${req.params.fileName}`;
    res.download(filePath);
});

// vulnerable
app.get('/view-directory/:dirName', (req, res) => {
    const dirPath = `./directories/${req.params.dirName}`;
    fs.readdir(dirPath, (err, files) => {
        if (err) return res.send(err);
        res.send(files);
    });
});

// vulnerable
app.get('/serve-file/:fileName', (req, res) => {
    const filePath = `./files/${req.params.fileName}`;
    fs.readFile(filePath, (err, data) => {
        if (err) return res.send(err);
        res.send(data);
    });
});

// vulnerable
app.post('/upload/:dirName', (req, res) => {
    const dirPath = `./files/${req.params.dirName}`;
    const uploadedFile = req.files.uploadedFile;
    uploadedFile.mv(`${dirPath}/${uploadedFile.name}`, (err) => {
        if (err) return res.send(err);
        res.send('File uploaded successfully');
    });
});



// sanitized
app.get('/download/:file', function (req, res) {
    var file = req.params.file;
    var filePath = path.join(__dirname, 'uploads', file);

    if (filePath.indexOf(__dirname + '/uploads') !== 0) {
        return res.status(400).send('Invalid file path');
    }

    res.download(filePath);
});

// sanitized
app.get('/file', (req, res) => {
    res.download(req.query.payload, {root: './uploads'}) // Sanitized
})

app.use('/static', express.static(__dirname + '/public'));

app.listen(3000)