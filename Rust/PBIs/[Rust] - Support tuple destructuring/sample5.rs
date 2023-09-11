// Tuple and value destructuring
fn main() {
    let pair = (5, 7);
    let z = 10;

    let (x, y) = pair;
    let result = x + y + z;

    println!("Result: {}", result);
}