// Mutable Reference (&mut)
fn main() {
    let mut value = 42;
    let reference = &mut value;

    println!("Value before modification: {}", value);

    *reference += 10; // Modify the value through a mutable reference

    println!("Value after modification: {}", value);
}
