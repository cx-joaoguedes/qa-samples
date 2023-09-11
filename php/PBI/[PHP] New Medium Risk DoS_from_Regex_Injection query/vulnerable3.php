<?php

function isUsernameInPassword($username, $password) {
    return preg_match($username, $password);
}

$username = $_GET['input']?:"";

if (isUsernameInPassword($username, $password)) {
    echo "Do not use your username as part of the password";
}
else {
    updateUser($username, $password);
}
