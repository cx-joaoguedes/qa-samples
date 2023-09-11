// A closure that takes a string as input and returns the length of the string
fn main() {
    let length_closure = |s: String| s.len();

    let length = length_closure("Hello, world!".to_string());
    println!("The length of the string is: {}", length);
}
