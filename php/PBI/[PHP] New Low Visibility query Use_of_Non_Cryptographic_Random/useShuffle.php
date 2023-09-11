<?php


function use_shuffle()
{
	$str = 'abcdef';
	$shuffled = str_shuffle($str);
	echo $shuffled;
	
	
	$numbers = range(1, 20);
	shuffle($numbers);
	foreach ($numbers as $number) {
		echo "$number ";
	}
	
}




?>