<?php 
if(isset($_REQUEST["username"]) && isset($_REQUEST["password"])) {
	$username = $_REQUEST["username"];
	$password = base64_encode($_REQUEST["password"]); // Source
	$conn = new mysqli("x", "y", "z");
	$stmt = $conn->prepare("INSERT INTO users (username, password) VALUES (?, ?)");
	$stmt->bind_param("ss", ...[$username, $password ]); // Sink
	$stmt->execute();
	// Handle authentication
	$stmt->close();
	$conn->close();
}
?>
