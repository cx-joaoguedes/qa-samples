<?php 
//Define cipher 
$cipher = "aes-256-cbc"; 
//Generate a 256-bit encryption key 
$encryption_key = openssl_random_pseudo_bytes(32);
// Generate an initialization vector 
$iv = substr(bin2hex(rand()), -16); // IV is not CSPRNG
//Data to encrypt 
$data = "bigsecret"; 
$encrypted_data = openssl_encrypt($data, $cipher, $encryption_key, 0, $iv); 
echo "<br>Encrypted Text: " . $encrypted_data; 
?>
