fn main() {
    let x = 10;
    let y = 5;

    let result = {
        let temp = x + y; // A local variable 'temp' is defined within the block.
        temp * 2 // This expression is the value of the block.
    };

    println!("Result: {}", result); // Output: Result: 30
}
