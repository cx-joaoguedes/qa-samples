// Define a generic struct 'Pair' with a single type parameter.
struct Pair<T> {
    value: T,
}

// Implement methods for the 'Pair' struct.
impl<T> Pair<T> {
    // Constructor for Pair.
    fn new(value: T) -> Self {
        Pair { value }
    }

    // Getter method to get the value.
    fn get(&self) -> &T {
        &self.value
    }
}

fn main() {
    // Create a Pair with an integer.
    let int_pair = Pair::new(42);

    // Create a Pair with a string.
    let string_pair = Pair::new("Hello, Rust!");

    // Use the get method to retrieve and print the values.
    println("Integer Pair: {}", int_pair.get());
    println("String Pair: {}", string_pair.get());
}
