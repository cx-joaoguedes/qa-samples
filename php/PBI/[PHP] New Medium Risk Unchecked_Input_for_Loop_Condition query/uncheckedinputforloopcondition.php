<?php
$input = $_GET['input']; // user input

if ($input > 0 and $input < 40) { // This condition is a sanitizer
  foreach(range($input, 20) as $i) { // no result in this foreach
    echo $i;
  }
}
else if ($input > 0) { // This condition is not a sanitizer
  foreach(range(20, $input) as $i) { // A result should end at this line (ex: input is 50000)
    echo $i;
  }
}
else if ($input < 40) { // This condition is not a sanitizer
  foreach(range($input, 20) as $i) { // A result should end at this line (ex: input is -5000)
    echo $i;
  }
}

if ($input > 0 or $input < 40) { // This condition is NOT enough for a sanitizer (because of 'or'')
  foreach(range($input, 20) as $i) { // A result should end at this line (ex: input is 50000)
    echo $i;
  }
}

if ($input < 0 and $input > 40) { // The signs are wrong so this condition is not a sanitizer
  foreach(range($input, 20) as $i) { // A result should end at this line (ex: input is 50000)
    echo $i;
  }
}

if ($input < 50) {
  for( $i = 0; $i < $input; $i++ ) { // $i is limited to [0; 50] so it's not vulnerable
    $a ++;
    $b += 5;
  }
  
  for ($i=0; $input<$i; $i--){ // $i is vulnerable: [-inf; 0] and a result must appear
    echo "Vulnerable to a DoS vulnerability";
  }
}
else if ($input > -50) {
  for( $i = 0; $i < $input; $i++ ) { // $i is vulnerable: [0; +inf] and a result must appear
    $a ++;
    $b += 5;
  }
  
  for( $i = 0; $input < $i; $i-- ) { // $i is limited to [-50; 0] so it's not vulnerable
    echo "Vulnerable to a DoS vulnerability";
  }
}

// $i is vulnerable: [-inf; 0] and a result must appear
if ($input < 10) for ($i=0; $i>$input; ecco("$i"), $i--);

function ecco($a){
	echo $a;
}

$aux = strlen($input);
if ($aux < 40) { // This condition is a sanitizer for a foreach
  foreach(range(1, $aux) as $i) { // no result in this foreach
    echo $input[$i-1];
  }
}
else if (strlen($input) > 40) {
  foreach(range(1, strlen($input)) as $i) { // $i can be any number in [1; +inf], this is vulnerable
    echo $input[$i-1];
  }
}

for( $i = 20; $i < strlen($input); $i++ ) { // $i is between [1; +inf] this is vulnerable
  $a ++;
  $b += 5;
}

while ($i < $input) { $i++; }

do { $i++; } while($i < $input);
?>