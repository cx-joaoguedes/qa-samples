<?php
// User-provided input
$userInput = $_POST['input'];

// Validate and sanitize the user input
$validatedInput = validateInput($userInput);

// Loop using the validated input
for ($i = 0; $i < $validatedInput; $i++) {
    // Loop body
    echo "Iteration: $i<br>";
}

// Function to validate and sanitize the input
function validateInput($input) {
    // Perform input validation and sanitization
    // Example: Ensure the input is a positive integer
    $validatedInput = filter_var($input, FILTER_VALIDATE_INT);

    if ($validatedInput === false || $validatedInput <= 0) {
        // Handle validation failure, throw an exception, or provide a default value
        // Example: Throw an exception
        throw new Exception("Invalid input provided");
    }

    return $validatedInput;
}
?>
