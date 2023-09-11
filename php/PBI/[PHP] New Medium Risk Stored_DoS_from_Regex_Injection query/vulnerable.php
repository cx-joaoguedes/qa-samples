<?php

function isUsernameInPassword($username, $password) {
    return preg_match($username, $password);
}

$pstmt = $con->prepare("SELECT username FROM users WHERE id = ?");
$pstmt -> bind_param("i", $userID);
$pstmt -> execute();
$pstmt -> bind_result($username);
$pstmt -> fetch();

// Get input
$id = $_SESSION[ 'id' ];

// Check database
$query  = "SELECT first_name, last_name FROM users WHERE user_id = '$id' LIMIT 1;";
$username = mysqli_query($GLOBALS["___mysqli_ston"],  $query ) or die( '<pre>Something went wrong.</pre>' );
	

if (isUsernameInPassword($username, $password)) {
    echo "Do not use your username as part of the password";
}
else {
    updateUser($username, $password);
}
