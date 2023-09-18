// Shared Reference Pointer(&)
fn main() {
    let value = 42;
    let reference = &value;

    println!("Value: {}", value);
    println!("Shared Reference: {}", reference);

    // You can use reference just like the original value for reading.
}
