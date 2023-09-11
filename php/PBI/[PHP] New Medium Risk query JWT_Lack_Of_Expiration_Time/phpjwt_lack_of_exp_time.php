<?php 
require 'vendor/autoload.php';

use Firebase\JWT\JWT;
use Firebase\JWT\Key;

$key = 'secretkey';

$now   = new DateTimeImmutable();

// shouldn't be a result because the expiration date is set
$payload = [
    'iss' => 'https://checkmarx.com',
    'exp' =>  $now->modify('+1 hour')->getTimestamp(),
    'user' => "Superadmin"
];

$jwt = JWT::encode($payload, $key, 'HS256');

// should be a result because the expiration date is not set
$payload2 = [
    'iss' => 'https://checkmarx.com',
    'user' => "Superadmin"
];

$jwt2 = JWT::encode($payload2, $key, 'HS256');

print_r($jwt."\n\n".$jwt2);
?>