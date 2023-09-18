// Iterating with closures
fn main() {
    let numbers = vec![1, 2, 3, 4, 5];
    
    // Using a closure with an iterator to square each element
    let squared: Vec<_> = numbers.iter().map(|&x| x * x).collect();
    
    println!("Squared: {:?}", squared);
}
