// Printing passed variable to Closure
fn main() {
    let greeting_closure = |name| {
        println!("Hello, {}!", name);
    };

    greeting_closure("Bard");
}