fn main() {
    let mut x = 42;

    // Create a mutable reference to x and modify its value
    let x_ref = &mut x;
    *x_ref += 10;

    println!("Modified x: {}", x);
}