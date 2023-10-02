fn main() {
    let numbers = vec![1, 2, 3, 4, 5];

    // Create an immutable reference to the vector
    let num_ref = &numbers;

    // Access elements using the reference
    for num in num_ref {
        println!("{}", num);
    }
}
