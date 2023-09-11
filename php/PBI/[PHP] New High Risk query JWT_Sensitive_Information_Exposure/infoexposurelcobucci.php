<?php

require 'vendor/autoload.php';

use Lcobucci\JWT\Signer\Hmac\Sha256;
use Lcobucci\JWT\Signer\Key\InMemory;
use Lcobucci\JWT\Encoding\ChainedFormatter;
use Lcobucci\JWT\Encoding\JoseEncoder;
use Lcobucci\JWT\Token\Builder;

ini_set('display_errors', 1);
ini_set('display_startup_errors', 1);
error_reporting(E_ALL);

$tokenBuilder = (new Builder(new JoseEncoder(), ChainedFormatter::default()));
$algorithm    = new Sha256();
$signingKey   = InMemory::plainText(random_bytes(32));

$ssn = "000-00-0000";
$card = "1234-1234-1234-1234";

// should be a result because it has credit card and social security added to the token claims
$token = $tokenBuilder
                ->issuedBy('https://checkmarx.com')
                ->withClaim('user', "Superadmin")
                ->withClaim('ssn', $ssn)
                ->withClaim('ccdata', $card)
                ->getToken($algorithm, $signingKey);

// shouldn't be a result because the token doesn't contain sensitive data
$token2 = $tokenBuilder
                ->issuedBy('https://checkmarx.com')
                ->withClaim('user', "Superadmin")
                ->getToken($algorithm, $signingKey);

// shouldn't be a result because the token doesn't contain sensitive data      
$hashedssn = hash("sha256", $ssn);

$key = "1234567812345678";

$cipher = "AES-128-GCM"; 
$ivlen = openssl_cipher_iv_length($cipher);
$iv = openssl_random_pseudo_bytes($ivlen);
$ciphertext = openssl_encrypt($ssn, $cipher, $key, $options=0, $iv, $tag);

$token3 = $tokenBuilder
                ->issuedBy('https://checkmarx.com')
                ->withClaim('user', "Superadmin")
                ->withClaim('ssn', $hashedssn)
                ->getToken($algorithm, $signingKey);
echo $token3->toString();                                          

?>