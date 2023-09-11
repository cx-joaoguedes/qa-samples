// Rest of Tuple
fn main() {
    let triple = (100, 200, 300);
    let (first, second, ..) = triple;

    println!("First: {}, Second: {}", first, second);
}