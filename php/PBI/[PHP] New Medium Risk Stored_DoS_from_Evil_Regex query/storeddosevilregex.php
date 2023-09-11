<?php
function isAlphanumeric($str) {
    return preg_match('/^([a-zA-Z0-9 ]+)*$/', $str);
}

$servername = "localhost";
$username = "username";
$password = "password";
$dbname = "myDB";

$conn = new mysqli($servername, $username, $password, $dbname);

$pstmt = $conn->prepare("SELECT data FROM documents WHERE id = ?");
$pstmt -> bind_param("i", $documentID);
$pstmt -> execute();
$data = $pstmt -> get_result();
$row = $data -> fetch_assoc();

if (!isAlphanumeric($row['data'])) {
    echo "Dangerous characters found on document data. Preview unavailable.";
}
else {
    previewDocument($row['data']);
}
?>