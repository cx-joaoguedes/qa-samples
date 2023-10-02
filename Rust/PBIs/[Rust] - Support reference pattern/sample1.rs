fn main() {
    let x = 42;
    let y = &x; // Borrow a reference to x

    println!("x: {}", x);
    println!("y: {}", *y); // Dereference y to access the value
}
