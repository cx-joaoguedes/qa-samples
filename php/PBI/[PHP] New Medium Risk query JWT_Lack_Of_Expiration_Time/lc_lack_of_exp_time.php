<?php

require 'vendor/autoload.php';
use Lcobucci\JWT\Configuration;
use Lcobucci\JWT\Signer\Hmac\Sha256;
use Lcobucci\JWT\Signer\Key\InMemory;

$config = Configuration::forSymmetricSigner(
    new Sha256(),
    InMemory::base64Encoded('mBC5v1sOKVvbdEitdSBenu59nfNfhwkedkJVNabosTw=')
);

$now   = new DateTimeImmutable();

// shouldn't be a result because the expiration time is set
$token = $config->builder()
                ->issuedBy('https://checkmarx.com')
                ->withClaim('user', "Superadmin")
                ->expiresAt($now->modify('+1 hour'))
                ->getToken($config->signer(), $config->signingKey());


// should be a result because the expiration time is not set
$token2 = $config->builder()
                ->issuedBy('https://checkmarx.com')
                ->withClaim('user', "Superadmin")
                ->getToken($config->signer(), $config->signingKey());

?>