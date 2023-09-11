<?php
//ini_set('pcre.backtrack_limit', '1000000000000000000000000');
// Get input
$id = $_SESSION[ 'id' ];

// Check database
$query  = "SELECT first_name, last_name FROM users WHERE user_id = '$id' LIMIT 1;";
$input = mysqli_query($GLOBALS["___mysqli_ston"],  $query ) or die( '<pre>Something went wrong.</pre>' );
	
$str = "aab";
$pattern = "/$input/";
echo "looking for <b>$pattern</b> in string <b>$str</b>.</br>";

$arrayIterator = new ArrayIterator(array('test 1', 'another test', 'test 123', $str));
$regexIterator = new RegexIterator($arrayIterator, $pattern);

foreach ($regexIterator as $value) {
    echo $value . "\n";
}