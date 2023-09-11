fn main() {
    println!("Outer function: {}", outer_function(5));
}

fn outer_function(x: i32) -> i32 {
    // This is the outer function.
    
    // Define a nested function.
    fn inner_function(y: i32) -> i32 {
        // This is the nested function.
        y * 2
    }

    let result = inner_function(x);
    result
}
