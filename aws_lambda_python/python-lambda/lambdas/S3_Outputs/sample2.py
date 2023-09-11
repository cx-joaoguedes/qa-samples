import boto3

resource = boto3.resource('s3')

# 1st Order Outputs


def s3_bucket_put_object():
    bucket = resource.Bucket('name')
    bucket.put_object() # Not catching

def s3_bucket_upload_file():
    bucket = resource.Bucket('name')
    bucket.upload_file('/tmp/hello.txt', 'hello.txt')

def s3_bucket_upload_fileobj():
    data = "hello"
    bucket = resource.Bucket('mybucket')
    bucket.upload_fileobj(data, 'mykey')

def s3_object_put():
    obj = resource.Object('bucket_name','key')
    response = obj.put(
        Body='',
        CacheControl='',
        ContentDisposition='',
        ContentEncoding='',
        ContentLanguage='',
        Metadata='',
        Tagging='',
    )

def s3_object_upload_file():
    obj = resource.Object('bucket_name','key')
    obj.upload_file('/tmp/hello.txt')

def s3_object_upload_fileobj():
    data = "hello"
    obj = resource.Object('bucket_name','key')
    obj.upload_fileobj(data)

def s3_object_load():
    obj = resource.Object('bucket_name','key')
    obj.cache_control = ''
    obj.content_disposition = ''
    obj.content_encoding = ''
    obj.content_language = ''
    obj.metadata = ''
    obj.tagging = ''
    obj.load()
    # obj.reload()
