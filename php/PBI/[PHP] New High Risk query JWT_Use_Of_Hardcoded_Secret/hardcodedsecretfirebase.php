<?php 
require 'vendor/autoload.php';
use Firebase\JWT\JWT;
use Firebase\JWT\Key;
use Firebase\JWT\ExpiredException;

ini_set('display_errors', 1);
ini_set('display_startup_errors', 1);
error_reporting(E_ALL);
$key = 'secretkey';
$payload = [
    'iss' => 'https://checkmarx.com',
    'aud' => 'http://example.com',
    'user' => "Superadmin"
];

// should be a result because it uses a hardcoded secret from a variable
$jwt = JWT::encode($payload, $key, 'HS256');

// should be a result because it uses a hardcoded secret as an argument
$jwt2 = JWT::encode($payload, "secretkey", 'HS256');

// shouldn't be a result because it uses password from the environment
putenv("jwtpass=supersecretpassword");
$pass = getenv("jwtpass");
$jwt3 = JWT::encode($payload, $pass, 'HS256');

// should be a result because it uses a hardcoded secret from a variable
$decoded = JWT::decode($jwt, new Key($key, 'HS256'));

// should be a result because it uses a hardcoded secret from a variable
$segments = [];
$header = ['typ' => 'JWT', 'alg' => "HS256"];
$segments[] = JWT::urlsafeB64Encode((string) JWT::jsonEncode($header));
$segments[] = JWT::urlsafeB64Encode((string) JWT::jsonEncode($payload));
$signing_input = \implode('.', $segments);
$signature = JWT::sign($signing_input, $key, "HS256"); //sink

$publicKey2 = 
"-----BEGIN PUBLIC KEY-----
MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEArAuWV+588twq5lLYuP7/
TwXJH0nr/sHUDGsSnZ7kf4Whkg/9/T1yHZbvoT962W5pX45cX1QibUmj9qYEKkZm
wtjzGXBxGwYtPkBo2rXf/WRgneiFiiqPYw6UjTKFsGwimAUPD5R6XyunFchScEqG
JA0GK+h7gmksramhOVr/1u/my2FCW0mFTEL0zTEmg/pO0ZXYvjlhWo5OCLmxH5tB
RdtkUml+FYXTFoCqvaWwkdqKwQMrJ979LDGXrpVYkpAEQ+f8aUmzvU1yuBstryff
9FE5TAwvNXQ97um4Q+wLf89EoDY2+aKQAO7raJ8o/klbfdyUgu5ZzOb0CEGPiFBY
u8glcRLpG3ZFtEVzkBtidNwmYn6o/FxVZEdJkFJXSXfIceK8I2dRRkpx/UrdxrNA
/Ztqqz+fnDGBRMDUxSHduUVFssWPw8DE6z9C0f8dxYERgbU92Xuhv8m/OWsdU9Pm
zb1MjBY9yyuz4kmuvQArAU48DRyJdjGok+UPD+INpKjJAgMBAAE=
-----END PUBLIC KEY-----";
$passphrase = 'supersecretpassword';
$privateKeyFile = __DIR__.'/keys/private.pem';
$publicKeyFile = __DIR__.'/keys/public.pem';

// should be a result because the private key password is hardcoded
$privateKey = openssl_pkey_get_private(
    file_get_contents($privateKeyFile),
    $passphrase
);

// shouldn't be a result because the private key is read from the file
$publicKey = openssl_pkey_get_details($privateKey)['key'];
$jwt4 = JWT::encode($payload, $privateKey, 'RS256');

// shouldn't be a result because the public key is not a secret
$decoded = JWT::decode($jwt4, new Key($publicKey2, 'RS256'));

$privateKey2 = "-----BEGIN PRIVATE KEY-----
MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCRU9l/iwsCb9Ls
zncZ+7QmdvEtnByXY4fUjQu2W1GvhZY3OKRZxMfUdfKWogISGf4qC8qHT5YkM4gl
yZ8Ay2ki8hXqagMcdEPx2vTm5UXXEz1Jk10ikRU8dtqcah5a2l7LSukFqmYUgefc
CaI9DDKQ4jj1yGReMACefSO4eQJedOYO2LLeL5QxltWG/vMzdAwFVKBRNW5/ouxX
hQ91WLpkIMSKdD4GQmgBeOA7mq10NQSMA44B2cRmSY1EdiQK5jsmMtPjfRu6liun
L5Giid5bZMFbYDt/eoC5jWLPA1+TZ6ar+jUegGAIMf7xn1ue+zTMdQzzdgvqjepm
Ib0g2zzfAgMBAAECggEAHg0ovKcT770P8MgA+O6DojCWTsgpYWTDgcBo25yml5UY
KvMbiTSX3edF8sAtjXCyjh9CEhjzAylkzeuTZaaqZv+IaKDjY87m/ew5GEXw2ziv
Q7elWrCFo6swKYgIHuFpGMC0zucdlMAIIggb9GPBURR2ktyNZKyodB2MdWkQhFd4
LVZoUTu3clodnYi5GXIQBTAXOtBRgb0DvTXrltMWlhm3RK+QJTvjLqxuI8eeciwy
yypZbTY3kEi64aMNB2tex/wzG5o4eUMDY7yhvdwqX7SPIb1Zbhdb524r5LWEMJD1
/blAlhEtmMRbcybdI1Eag0W9OvzUweI1Zb54kwt5gQKBgQC7bdxUV6EleVZhTFVN
cE9Czs7m9UR/hstSsC5ZipGUnE+DskUK6g75KbkRhLmZpBCVmmoi/9PoJzPgQcdU
kYvWPqG7O5ZgHqmcgMF+mTrK9K5OVw6l6+wenqwRYqKgX8WVYWx4wsjyqNxwxn1t
HR2uzDiwa68ePtpVJzAJbEkndQKBgQDGftvsIiKrgdGICF7ePaTCH9oeGjY3eLgQ
PfnBdr3TsvT3u1eb5d9AGQqFkUrSCpOQp+fqHAXFJzOwcQpqU7deMRtQbGjsNFcD
FYEDHxwktQOLE8ywQopD5074NQpwgOj4iDm+fKCwlbN5K/7dsQxpgeSzkAzAW8cX
XMsL7oZcgwKBgCrV5t8Xz+qCmq1OBsjV/CdmoH7EW01R/zH8tfsc4jy2pK2Slpjx
+U4UrQlF7i0hA/FNAyjQkxuhqgd8wROg1/a1Bb2G1s1M9LKh8pb+aiNsXFHnL5/Y
FXTCCs1GX6iLetqzE1leGxLqaMcVdiDz4I7MecBIPBOLhdakSCQ/LVDpAoGBAJoY
1icFgSDgkYgn525lMMk77Rs9giWiZFLHqmNVCZ2V6rOAD02KMb0TM6Xp28ogR9sf
Xt3Sj3A1NN2fhFRzVYGcYfYXk4T8RSixwwxnVHPyyyNnZZrYrXp10krC8q3Qhgyb
xShqnF06erBxRVVaI6atHp2AEUYsee1bLo6+yDR9AoGAFsmPcanEs8rsM5DGv6Ri
NhggXuaVMz3/MDSBwQjt5770DPJxFhEqnBFcvEJJgMs5yQsAcLS3CHgU/Ps3MIpX
SMcjsjHqVw/OapZVOfJ45F1nRez1NkS9Fm5PGcvchgX9/dNp+iPCrPPkl8LgMXqd
1xaci/ACfjyGp5/HGtqbCn0=
-----END PRIVATE KEY-----";

//should be a result because the private key is hardcoded. It's not encrypted with a password
$jwt5 = JWT::encode($payload, $privateKey2, 'RS256');
?>