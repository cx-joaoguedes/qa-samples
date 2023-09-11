import boto3

client = boto3.client('s3')
resource = boto3.resource('s3')

# 1st Order Outputs


def s3_client_put_object():
    response = client.put_object(
        Body='',
        CacheControl='',
        ContentDisposition='',
        ContentEncoding='',
        ContentLanguage='',
        Metadata='',
        Tagging='',
    )


def s3_client_put_object_tagging():
    response = client.put_object_tagging(
        Bucket='string',
        Key='string',
        Tagging={
            'TagSet': [
                {
                    'Key': 'string',
                    'Value': 'string'
                },
            ]
        }
    )


def s3_client_upload_file():
    resource.meta.client.upload_file('string', 'mybucket', 'hello.txt')


def s3_client_upload_fileobj():
    data = "hello"
    client.upload_fileobj(data, 'mybucket', 'mykey')


def s3_client_upload_part():
    response = client.upload_part(
        Body='fileToUpload',
        Bucket='examplebucket',
        Key='examplelargeobject',
        PartNumber='1',
        UploadId='xadcOB_7YPBOJuoFiQ9cz4P3Pe6FIZwO4f7wN93uHsNBEw97pl5eNwzExg0LAT2dUN91cOmrEQHDsP3WA60CEg--',
    )
