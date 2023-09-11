fn main() {
    let numbers = [10, 20, 30, 40, 50];

    // Access elements from index 1 to 3 (excluding 4)
    let slice = &numbers[1..4];
    
    for num in slice {
        println!("{}", num);
    }
}
