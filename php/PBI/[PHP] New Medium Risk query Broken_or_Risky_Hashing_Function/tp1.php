<?php
ini_set('display_errors', 1);
ini_set('display_startup_errors', 1);
error_reporting(E_ALL);

	$str = $_GET['str'];
	$filename = "hashing.php";
    echo "ezmlm_hash ".ezmlm_hash($str); // RESULT - deprecated and removed, "highly discouraged"
		// Oddly specific, sha1 and md5 have their own PHP functions
	echo "md5 ".md5($str); // RESULT - deprecated, vulnerable algorithm
	echo "sha1 ".sha1($str); // RESULT - deprecated, vulnerable algorithm
	echo "md5_file ".md5_file($filename); // RESULT - deprecated, vulnerable algorithm
	echo "sha1_file ".sha1_file($filename); // RESULT - deprecated, vulnerable algorithm
?>