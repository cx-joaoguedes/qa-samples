<?php
require 'vendor/autoload.php';
use Lcobucci\Clock\SystemClock;
use Lcobucci\JWT\Configuration;
use Lcobucci\JWT\Signer\Hmac\Sha256;
use Lcobucci\JWT\Signer\Key\InMemory;
use Lcobucci\JWT\Validation\RequiredConstraintsViolated;
use Lcobucci\JWT\Validation\Constraint\StrictValidAt;
use Lcobucci\JWT\Validation\Constraint\SignedWith;
use Lcobucci\JWT\Validation\Constraint\LooseValidAt;

$config = Configuration::forSymmetricSigner(
    new Sha256(),
    InMemory::base64Encoded('mBC5v1sOKVvbdEitdSBenu59nfNfhwkedkJVNabosTw=')
);
$config2 = Configuration::forSymmetricSigner(
    new Sha256(),
    InMemory::base64Encoded('mBC5v1sOKVvbdEitdSBenu59nfNfhwkedkJVNabosTw=')
);
$config3 = Configuration::forSymmetricSigner(
    new Sha256(),
    InMemory::base64Encoded('mBC5v1sOKVvbdEitdSBenu59nfNfhwkedkJVNabosTw=')
);

$now   = new DateTimeImmutable();

// create a token with an exp date
$token = $config->builder()
                ->issuedBy('https://checkmarx.com')
                ->withClaim('user', "Superadmin")
                ->expiresAt($now->modify('+1 hour'))
                ->issuedAt($now)
                ->canOnlyBeUsedAfter($now)
                ->getToken($config->signer(), $config->signingKey());
// create a token w/o an exp date
$token2 = $config->builder()
                ->issuedBy('https://checkmarx.com')
                ->withClaim('user', "Superadmin")
                ->getToken($config->signer(), $config->signingKey());
				
// check exp validity. if exp claim is missing or expired the check fails               
$config->setValidationConstraints(
    new SignedWith($config->signer(), $config->signingKey()), 
    new StrictValidAt(SystemClock::fromSystemTimezone())
);

// check exp validity, if exp claim is missing the check is successful, if exp is present but expired the check fails. Therefore, this constraint shouldn't be considered a sanitizer
$config2->setValidationConstraints(
    new SignedWith($config->signer(), $config->signingKey()), 
    new LooseValidAt(SystemClock::fromSystemTimezone())
);

// check exp validity. both strictValidAt and looseValidAt constrains are processed , therefore, if exp is missing or expired the check fails
$config3->setValidationConstraints(
    new SignedWith($config->signer(), $config->signingKey()), 
    new LooseValidAt(SystemClock::fromSystemTimezone()),
    new StrictValidAt(SystemClock::fromSystemTimezone())
);

// create cookies and get the JWT values from the cookies
setcookie("JWT1",$token->toString());
setcookie("JWT2",$token2->toString());
$tokenFromCookie = $config->parser()->parse($_COOKIE["JWT1"]);
$tokenFromCookie2 = $config2->parser()->parse($_COOKIE["JWT2"]);

// shouldn't be a result. the validationConstraints enforce the exp claim
if ($config->validator()->validate($tokenFromCookie, ...$config->validationConstraints()))
{echo "Token is valid. Username is ".$tokenFromCookie->claims()->get("user");}
else {echo "token is not valid";}
// shouldn't be a result. the validationConstraints enforce the exp claim
try {
    $config->validator()->assert($tokenFromCookie, ...$config->validationConstraints());
    echo "Token is valid. Username is ".$tokenFromCookie->claims()->get("user");
} catch (RequiredConstraintsViolated $e) {
    echo "Token is invalid";
}
// should be a result. the validationConstraints do not enforce the exp claim
if ($config2->validator()->validate($token2, ...$config2->validationConstraints()))
{echo "Token is valid. Username is ".$tokenFromCookie2->claims()->get("user");}
else {echo "token is not valid";}

// should be a result. the validationConstraints do not enforce the exp claim
try {
    $config2->validator()->assert($token2, ...$config2->validationConstraints());
    echo "Token is valid. Username is ".$tokenFromCookie2->claims()->get("user");
} catch (RequiredConstraintsViolated $e) {echo "Token is invalid";}

// shouldn't be a result. the validationConstraints enforce the exp claim
if ($config3->validator()->validate($token2, ...$config3->validationConstraints()))
{echo "Token is valid. Username is ".$tokenFromCookie2->claims()->get("user");}
else {echo "token is not valid";}

// shouldn't be a result. the validationConstraints enforce the exp claim
try {
    $config3->validator()->assert($token2, ...$config3->validationConstraints());
    echo "Token is valid. Username is ".$tokenFromCookie2->claims()->get("user");
} catch (RequiredConstraintsViolated $e) {echo "Token is invalid";}
?>