<?php

require 'vendor/autoload.php';
use Lcobucci\JWT\Configuration;
use Lcobucci\JWT\Signer\Hmac\Sha256;
use Lcobucci\JWT\Signer\Key\InMemory;
use Lcobucci\JWT\Validation\Constraint\SignedWith;

// initialize all the values
$symmetricconfig = Configuration::forSymmetricSigner(
    new Sha256(),
    InMemory::plainText('secretkeysecretkeysecretkeysecretkey')
);
$tokenWithoutSignature = 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOi8vY2hlY2ttYXJ4LmNvbSIsImF1ZCI6Imh0dHA6Ly9leGFtcGxlLmNvbSIsImlhdCI6MTY1Mzk5OTYwNSwibmJmIjoxNjUzOTk5NjA1LCJ1c2VyIjoiU3VwZXJhZG1pbiJ9.';
$validToken = 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsInVzZXIiOiJTdXBlcmFkbWluIn0.eyJpc3MiOiJodHRwOi8vZXhhbXBsZS5jb20iLCJhdWQiOiJodHRwOi8vZXhhbXBsZS5vcmciLCJqdGkiOiI0ZjFnMjNhMTJhYSIsImlhdCI6MTY1NDE1ODY4NS4zMTczNDYsIm5iZiI6MTY1NDE1ODc0NS4zMTczNDYsImV4cCI6MTY1NDE2MjI4NS4zMTczNDYsInVzZXIiOiJTdXBlcmFkbWluIn0.MAioEhvy2wFSZbG4M1CrmdHX-LSAR35aiF-t-bgi5NI';

setcookie('jwt',$tokenWithoutSignature);
$symmetricconfig->setValidationConstraints(new SignedWith($symmetricconfig->signer(), $symmetricconfig->signingKey()));
$constraints = $symmetricconfig->validationConstraints();

// start of the flow from a cookie
if(isset($_COOKIE['jwt'])) {
    $token = $_COOKIE['jwt'];
}

//the following block shouldn't be a result because it has the token validation
//parse the token
$parsedtoken = $symmetricconfig->parser()->parse($token);

//validate the token
if ( $symmetricconfig->validator()->validate($parsedtoken, ...$constraints)) {
    //use the token
    echo $parsedtoken->claims()->get("user");
}
else {
    echo "invalid signature";   
}

// the following block should be a SAST result because there is no validation between parsing and using the token component
$parsedtoken2 = $symmetricconfig->parser()->parse($token);
echo $parsedtoken2->claims()->get("user");

// The following line should also be a result because there is no validation in the flow from the parsing to the token usage. The validation above may be unsuccessful, but the token component is still used.
echo $parsedtoken->claims()->get("user");

?>