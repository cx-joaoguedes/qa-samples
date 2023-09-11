<?php
require 'vendor/autoload.php';
use Lcobucci\JWT\Configuration;
use Lcobucci\JWT\Signer\Hmac\Sha256 as hmacsha256;
use Lcobucci\JWT\Signer\Key\InMemory;
use Lcobucci\JWT\Signer\Rsa\Sha256 as rsasha256;
use Lcobucci\JWT\Validation\Constraint\SignedWith;

ini_set('display_errors', 1);
ini_set('display_startup_errors', 1);
error_reporting(E_ALL);

putenv("jwtpass=secretkeysecretkeysecretkeysecretkey");

//should be a result because it uses a hardcoded secret as an argument
$config = Configuration::forSymmetricSigner(new hmacsha256(), InMemory::plainText("secretkeysecretkeysecretkeysecretkey"));

//should be a result because it uses a hardcoded secret as an argument
$config2 = Configuration::forSymmetricSigner(new hmacsha256(), InMemory::base64Encoded('c2VjcmV0a2V5c2VjcmV0a2V5c2VjcmV0a2V5c2VjcmV0a2V5'));

//should be a result because it uses a hardcoded private key password as an argument
$config3 = Configuration::forAsymmetricSigner(new rsasha256(), InMemory::file(__DIR__."/keys/private.pem","supersecretpassword"), InMemory::file(__DIR__."/keys/public.pem"));

//should be a result because it uses a hardcoded secret from a variable containing a plaintext password
$pass = "secretkeysecretkeysecretkeysecretkey";
$config4 = Configuration::forSymmetricSigner(new hmacsha256(), InMemory::plainText($pass));

//shouldn't be a result because it gets the secret from the environment variable
$config5 = Configuration::forSymmetricSigner(new hmacsha256(), InMemory::plainText(getenv("jwtpass")));

//shouldn't be a result because it gets a secret from the file
$config6 = Configuration::forSymmetricSigner(new hmacsha256(), InMemory::file(__DIR__."/keys/secret.txt"));

$now   = new DateTimeImmutable();

// shouldn't be a result because it uses the secret stored in the Configuration object
$token = $config->builder()
                ->issuedBy('https://checkmarx.com')
                ->getToken($config->signer(), $config->signingKey());

// shouldn't be a result because it uses the secret stored in the Configuration object
$token2 = $config2->builder()
                ->issuedBy('https://checkmarx.com')
                ->getToken($config2->signer(), $config2->signingKey());

// shouldn't be a result because it uses the secret stored in the Configuration object
$token3 = $config3->builder()
                ->issuedBy('https://checkmarx.com')
                ->getToken($config3->signer(), $config3->signingKey());

// shouldn't be a result because it uses the secret stored in the Configuration object
$token4 = $config4->builder()
                ->issuedBy('https://checkmarx.com')
                ->getToken($config4->signer(), $config4->signingKey());
                
// shouldn't be a result because it uses the secret stored in the Configuration object
$token5 = $config5->builder()
                ->issuedBy('https://checkmarx.com')
                ->getToken($config5->signer(), $config5->signingKey()); 

// should be a result because it uses the hardcoded secret as an argument
$token6 = $config->builder()
                ->issuedBy('https://checkmarx.com')
                ->getToken($config->signer(), InMemory::plainText("secretkeysecretkeysecretkeysecretkey"));  
                            
$token7 = $config6->builder()
                ->issuedBy('https://checkmarx.com')
                ->getToken($config2->signer(), $config2->signingKey());
                                                     

// shouldn't be a result because it uses the secret stored in the Configuration object
$config3->setValidationConstraints(new SignedWith($config3->signer(), $config3->verificationKey()));

 if ($config3->validator()->validate($token3, ...$config3->validationConstraints()))
{echo "Token is valid. Username is ".$token3->claims()->get("user");}
else {echo "token is not valid";}     


// should be a result because it uses the hardcoded secret as an argument
$var = new SignedWith($config->signer(), InMemory::plainText("secretkeysecretkeysecretkeysecretkey"));

$config->setValidationConstraints($var);

$config->setValidationConstraints(new SignedWith($config->signer(), InMemory::plainText("secretkeysecretkeysecretkeysecretkey")));

if ($config->validator()->validate($token, ...$config->validationConstraints()))
{echo "Token is valid. Username is ".$token->claims()->get("user");}
else {echo "token is not valid";}     

?>