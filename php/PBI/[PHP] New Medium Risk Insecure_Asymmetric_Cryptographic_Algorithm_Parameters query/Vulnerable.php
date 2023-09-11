<?php 
// Generate an RSA key pair with 512-bit private key
$config = array(
    "digest_alg" => "sha256",
    "private_key_bits" => 512, // INPUT
    "private_key_type" => OPENSSL_KEYTYPE_RSA,
);
$rsa_key = openssl_pkey_new($config); // SINK

// Get the private and public keys
openssl_pkey_export($rsa_key, $private_key);
$public_key = openssl_pkey_get_details($rsa_key);
$public_key = $public_key["key"];

// Encrypt a message with the public key
$message = "Hello, world!";
openssl_public_encrypt($message, $encrypted, $public_key);

// Decrypt the message with the private key
openssl_private_decrypt($encrypted, $decrypted, $private_key);

// Print the original message and the decrypted message
echo "Original message: " . $message . "\n";
echo "Decrypted message: " . $decrypted . "\n";
?>