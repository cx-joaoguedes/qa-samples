<?php
$input = $_GET['input']?:"";

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