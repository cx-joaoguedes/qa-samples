<?php
	ini_set('display_errors', 1);
	ini_set('display_startup_errors', 1);
	error_reporting(E_ALL);
	echo 'Standard DES: ',
	    crypt('rasmuslerdorf', 'rl'), // Result
	    "\n";
	echo 'Extended DES: ',
	    crypt('rasmuslerdorf', '_J9..rasm'), // Result 
	    "\n";
	echo 'MD5:          ',
	    crypt('rasmuslerdorf', '$1$rasmusle$'), // Result
	    "\n";
	echo 'Blowfish:     ',
	    crypt('rasmuslerdorf', '$2a$07$usesomesillystringforsalt$'), // Result
	    "\n";
	echo 'Blowfish:     ',
	    crypt('rasmuslerdorf', '$2b$07$usesomesillystringforsalt$'), // Result
	    "\n";
	echo 'Blowfish:     ',
	    crypt('rasmuslerdorf', '$2x$07$usesomesillystringforsalt$'), // Result
	    "\n";
	echo 'Blowfish:     ',
	    crypt('rasmuslerdorf', '$2y$07$usesomesillystringforsalt$'), // Result
	    "\n";
	echo 'SHA-256:      ',
	    crypt('rasmuslerdorf', '$5$rounds=5000$usesomesillystringforsalt$'), // Secure
	    "\n";
	$salt = '$6$rounds=5000$usesomesillystringforsalt$';
	echo 'SHA-512:      ',
	    crypt('rasmuslerdorf', $salt), // Secure
	    "\n";

	$salt2 = '$7$rounds=5000$usesomesillystringforsalt2$';
	echo 'SHA-512:      ',
	    crypt('rasmuslerdorf', $salt2), // Result
	    "\n";
?>