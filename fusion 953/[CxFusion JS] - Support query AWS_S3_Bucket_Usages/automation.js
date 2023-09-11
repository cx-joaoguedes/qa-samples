const s3_bucket = 'the-heuristic-is-working'; //1x Result
const Bucket = 'bucket-name';
const params = {
    Bucket: Bucket,
    Key: "bucket-key",
    UploadId: "example7YPBOJuoFiQ9cz4P3Pe6FIZwO4f7wN93uHsNBEw97pl5eNwzExg0LAT2dUN91cOmrEQHDsP3WA60CEg--"
};

const something = require('aws-sdk');
const s3Client = new something.S3();
s3Client.listParts(params, function (err, data) { //1x Result
    if (err) console.log(err, err.stack);
    else console.log(data);
});

const { S3 } = require('aws-sdk');
const s3Client2 = new S3();
s3Client2.deleteObject({ //1x Result
    Bucket: "bucket-name2",
    Key: "bucket-key2"
}, function (err, data) {
    if (err) console.log(err, err.stack);
    else console.log(data);
});

const ThisAlsoWorks = require('aws-sdk/clients/s3');
const ok= new ThisAlsoWorks();
ok.listParts(params, function (err, data) { //1x Result
    if (err) console.log(err, err.stack);
    else console.log(data);
});

const { S3Client, DeleteBucketCommand } = require('@aws-sdk/client-s3');
const s3Client3 = new S3Client({ region: "eu-west-2" });
const deleteBucket = async (name) => {
    try {
      const data = await s3Client3.send(
          new DeleteBucketCommand({ Bucket: name }) //1x Result
      );
      console.log(data);
      return data;
    } catch (err) { console.log("Error", err); }
};
deleteBucket("bucket-name3");

const something2 = require('@aws-sdk/client-s3');
const s3Client4 = new something2.S3Client({ region: "eu-west-2" });
const listBucketMetadata = async (name) => {
    try {
      const data = await s3Client4.send(
          new something2.ListBucketsCommand({ Bucket: name }) //1x Result
      );
      console.log(data);
      return data;
    } catch (err) { console.log("Error", err); }
};
listBucketMetadata(Bucket);