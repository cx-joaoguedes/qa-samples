// Vulnerable Code
$tokenWithoutSignature = 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOi8vY2hlY2ttYXJ4LmNvbSIsImF1ZCI6Imh0dHA6Ly9leGFtcGxlLmNvbSIsImlhdCI6MTY1Mzk5OTYwNSwibmJmIjoxNjUzOTk5NjA1LCJ1c2VyIjoiU3VwZXJhZG1pbiJ9.';
setcookie('jwt', $tokenWithoutSignature);

// Start of the flow from the cookie
if (isset($_COOKIE['jwt'])) {
    $token = $_COOKIE['jwt'];
}

// Parse the token without validation
$parsedtoken = $symmetricconfig->parser()->parse($validToken);

// No validation, straight to using the token claims
echo $parsedtoken->claims()->get("user");

// Another round of token parsing without validation
$parsedtoken2 = $symmetricconfig->parser()->parse($validToken);
echo $parsedtoken2->claims()->get("user");

// Risky move: Access the token claims without validating the signature
echo $parsedtoken->claims()->get("user");
