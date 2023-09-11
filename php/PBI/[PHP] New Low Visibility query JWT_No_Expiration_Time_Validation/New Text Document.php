<?php

// Decode the JWT token
function decodeJWT($token, $secretKey)
{
    try {
        $decoded = \Firebase\JWT\JWT::decode($token, $secretKey, array('HS256'));
        return $decoded;
    } catch (\Firebase\JWT\ExpiredException $e) {
        // Handle expired token
        return null;
    } catch (Exception $e) {
        // Handle other errors
        return null;
    }
}

// Example usage
$token = 'your_jwt_token_here';
$secretKey = 'your_secret_key_here';

$decodedToken = decodeJWT($token, $secretKey);

if ($decodedToken !== null) {
    // JWT is valid
    // Your code here
} else {
    // JWT is invalid or expired
    // Your code here
}
?>
