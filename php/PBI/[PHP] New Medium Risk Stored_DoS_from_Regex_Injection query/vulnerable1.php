<?php

// user input
// Get input
$id = $_SESSION[ 'id' ];

// Check database
$query  = "SELECT first_name, last_name FROM users WHERE user_id = '$id' LIMIT 1;";
$input = mysqli_query($GLOBALS["___mysqli_ston"],  $query ) or die( '<pre>Something went wrong.</pre>' );
	
$str = "aacb";
$pattern = $input;
echo "looking for <b>$pattern</b> in string <b>$str</b>.</br>";
// preg_match is the sink for this vulnerability
echo preg_match($pattern, $str)? "The match was found!":"It wasn't found a match...";

?>

</br>

<form method="get">
    <p>Input:</p>
    <input type="text" name="input"/>
</form>