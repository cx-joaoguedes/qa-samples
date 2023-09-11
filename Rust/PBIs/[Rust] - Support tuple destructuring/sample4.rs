// Nested Tuples
fn main() {
    let tuple = ((1, 2), (3, 4));
    let ((a, _), (_, b)) = tuple;

    println!("a: {}, b: {}", a, b);
}
