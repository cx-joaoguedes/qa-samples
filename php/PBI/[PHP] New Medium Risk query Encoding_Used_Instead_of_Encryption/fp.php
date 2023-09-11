<?php 
if(isset($_REQUEST["username"]) && isset($_REQUEST["password"])) {
	$username = $_REQUEST["username"];
	$password0 = password_hash($_REQUEST["password"], PASSWORD_ARGON2I);
	$conn = new mysqli("x", "y", "z");
	$stmt = $conn->prepare("INSERT INTO users (username, password) VALUES (?, ?)");
	$stmt->bind_param("ss", ...[$username, $password0 ]);
	$stmt->execute();
	// Handle authentication
	$stmt->close();
	$conn->close();
}
?>
