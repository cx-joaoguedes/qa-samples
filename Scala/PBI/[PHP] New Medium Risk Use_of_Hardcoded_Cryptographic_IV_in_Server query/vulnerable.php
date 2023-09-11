<?php
$plaintext = "message to be encrypted";
$cipher = "aes-128-gcm";
$key = "key";
if (in_array($cipher, openssl_get_cipher_methods()))
{
    $ivlen = openssl_cipher_iv_length($cipher);
    $iv = "hardcodedIV"; // Hardcoded IV

    // Encryption method using Hardcoded IV
    $ciphertext = openssl_encrypt($plaintext, $cipher, $key, $options=0, $iv, $tag);
    $original_plaintext = openssl_decrypt($ciphertext, $cipher, $key, $options=0, $iv, $tag);
    echo $original_plaintext."\n";
    echo $ciphertext."\n";
}
?>