<?php 
require 'vendor/autoload.php';

use Firebase\JWT\JWT;
use Firebase\JWT\Key;

$key = 'secretkey';
$ssn = "000-00-0000";
$card = "1234-1234-1234-1234";


// should be a result because the token contains sensitive data
$payload = [
    'iss' => 'https://checkmarx.com',
    'ssn' => $ssn,
    'ccdata' => $card,
    'user' => "Superadmin"
];

$jwt = JWT::encode($payload, $key, 'HS256');

// shouldn't be a result because the token contains no sensitive data
$payload2 = [
    'iss' => 'https://checkmarx.com',
    'user' => "Superadmin"
];

$jwt2 = JWT::encode($payload2, $key, 'HS256');

// shouldn't be a result because the sensitive data is encrypted
$key = "1234567812345678";
$cipher = "AES-128-GCM"; 
$ivlen = openssl_cipher_iv_length($cipher);
$iv = openssl_random_pseudo_bytes($ivlen);
$ciphertext = openssl_encrypt($ssn, $cipher, $key, $options=0, $iv, $tag);

$payload3 = [
    'iss' => 'https://checkmarx.com',
    'ssn' => $ciphertext,
    'user' => "Superadmin"
];

$jwt3 = JWT::encode($payload3, $key, 'HS256');
?>