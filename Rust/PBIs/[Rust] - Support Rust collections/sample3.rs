// Create a vector of integers
fn main() {
    let mut vector = Vec::new();

    // Add elements to the vector
    vector.push(1);
    vector.push(2);
    vector.push(3);

    // Get the length of the vector
    let length = vector.len();

    // Print the elements of the vector
    for element in vector {
        println!("{}", element);
    }

    // Remove the last element from the vector
    let element = vector.pop();

    // Check if the vector is empty
    let is_empty = vector.is_empty();

    // Get the reference to the first element in the vector
    let first_element = &vector[0];
}
