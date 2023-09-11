<?php


function use_rand(){

	srand();
	$key1 = '';
	for($i = 0; $i < $length; $i ++) {
		$key1 .= chr(rand());
	}
}



?>