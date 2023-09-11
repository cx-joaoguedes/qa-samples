<?php


function use_mt_rand (){

	mt_srand();
	$key2 = '';
	
	for($i = 0; $i < $length; $i ++) {
		$key2 .= chr(mt_rand());
	}
}


?>