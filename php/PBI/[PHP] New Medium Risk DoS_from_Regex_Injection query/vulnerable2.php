<?php

$input = $_GET['input']?:"";

$str = "ab";
$pattern = "/$input/";
echo "looking for <b>$pattern</b> in string <b>$str</b>.</br>";

$arrayIterator = new ArrayIterator(array('test 1', 'another test', 'test 123', $str));
$regexIterator = new RegexIterator($arrayIterator, $pattern);

foreach ($regexIterator as $value) {
    echo $value . "\n";
}