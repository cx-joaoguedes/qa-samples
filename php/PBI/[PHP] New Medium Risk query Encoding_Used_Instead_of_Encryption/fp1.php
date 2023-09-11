<?php 
if(isset($_REQUEST["username"]) && isset($_REQUEST["password"])) {
	$username = $_REQUEST["username"];
	$password1 = password_hash($_REQUEST["password"], PASSWORD_ARGON2I);
	$passwordd1 = base64_encode($password1);
	$conn = new mysqli("x", "y", "z");
	$stmt = $conn->prepare("INSERT INTO users (username, password) VALUES (?, ?)");
	$stmt->bind_param("ss", ...[$username, $passwordd1 ]);
	$stmt->execute();
	// Handle authentication
	$stmt->close();
	$conn->close();
}
?>
