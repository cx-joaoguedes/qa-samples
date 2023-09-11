const AWS = require('aws-sdk')
const s3 = new AWS.S3({
    accessKeyId: 'ACCESS_KEY_ID',
    secretAccessKey: 'SECRET_ACCESS_KEY'
});

// List all buckets

s3.listBuckets((err, data) => {
    if (err) console.log(err, err.stack);
    else console.log(data.Buckets);
});

// Create Bucket

const bucketParams = {
    Bucket: 'my-new-bucket'
};

s3.createBucket(bucketParams, (err, data) => {
    if (err) console.log(err, err.stack);
    else console.log(`Bucket created successfully: ${data.Location}`);
});

// Upload to bucket

const uploadParams = {
    Bucket: 'my-existing-bucket',
    Key: 'my-file.txt',
    Body: 'Hello, S3!'
};

s3.upload(uploadParams, (err, data) => {
    if (err) console.log(err, err.stack);
    else console.log(`File uploaded successfully: ${data.Location}`);
});

// download from bucket

const downloadParams = {
    Bucket: 'my-existing-bucket',
    Key: 'my-file.txt'
};

s3.getObject(downloadParams, (err, data) => {
    if (err) console.log(err, err.stack);
    else console.log(`File contents: ${data.Body.toString()}`);
});

// delete from bucket

const deleteParams = {
    Bucket: 'my-existing-bucket',
    Key: 'my-file.txt'
};

s3.deleteObject(deleteParams, (err, data) => {
    if (err) console.log(err, err.stack);
    else console.log(`File deleted successfully`);
});