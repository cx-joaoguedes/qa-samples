// Captured Variable
fn main() {
    let x = 10;
    let closure_with_captured_variable = |y| {
        x + y
    };

    let closure_value = closure_with_captured_variable(15);
    println!("The value of the closure is: {}", closure_value);
}
