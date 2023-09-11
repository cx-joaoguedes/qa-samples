<?php
  ini_set('display_errors', 1);
  ini_set('display_startup_errors', 1);
  error_reporting(E_ALL);
  
	$algo = "md5"; // source, if algo is unsafe!
	$key = "1234567812345678";
	$str = $_GET['str'];
	$filename = "hashing.php";
	$salt = "pepper";

	echo "hash ".hash($algo, $str); // result sink, if $algo is unsecure
	echo "hash_file ".hash_file($algo, $filename); // result sink, if $algo is unsecure
    echo "hash_hmac_file ".hash_hmac_file($algo,$filename,$key); // result sink, if $algo is unsecure
	echo "hash_hmac ".hash_hmac($algo, $str, $key); // result sink, if $algo is unsecure
	echo "mhash ".mhash($algo, $str); // result sink, if $algo is unsecure
    echo "hash_pbkdf2 ".hash_pbkdf2($algo,$str, $salt, 100); // result sink, if $algo is unsecure

	$ctx = hash_init($algo); // result sink; subsequent uses are immaterial
	hash_update($ctx, $str); 
	hash_update_file($ctx, $filename); 
	$fp = fopen($filename, "r");
	hash_update_stream($ctx, $fp);
	$hash = hash_final($ctx, true); 
	echo "hash_update + hash_update_file + hash_update_stream " . $hash;
?>