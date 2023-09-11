<?php 
if(isset($_REQUEST["username"]) && isset($_REQUEST["password"])) {
	$username = $_REQUEST["username"];
	$password2 = base64_encode($_REQUEST["password"]);
	$passwordd2 = password_hash($password2, PASSWORD_ARGON2I);
	$conn = new mysqli("x", "y", "z");
	$stmt = $conn->prepare("INSERT INTO users (username, password) VALUES (?, ?)");
	$stmt->bind_param("ss", ...[$username, $passwordd2 ]);
	$stmt->execute();
	// Handle authentication
	$stmt->close();
	$conn->close();
}
?>
