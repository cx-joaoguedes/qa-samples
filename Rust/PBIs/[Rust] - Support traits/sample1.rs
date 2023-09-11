// Define a trait called 'Printable'
trait Printable {
    fn print(&self);
}

// Implement the 'Printable' trait for the 'i32' type
impl Printable for i32 {
    fn print(&self) {
        println!("Printing an i32: {}", self);
    }
}

// Implement the 'Printable' trait for the 'String' type
impl Printable for String {
    fn print(&self) {
        println!("Printing a String: {}", self);
    }
}

// A generic function that accepts any type that implements the 'Printable' trait
fn print_generic<T: Printable>(item: T) {
    item.print();
}

fn main() {
    let number = 42;
    let text = String::from("Hello, Rust!");

    // Call the generic function with different types
    print_generic(number); // Printing an i32: 42
    print_generic(text);   // Printing a String: Hello, Rust!
}
