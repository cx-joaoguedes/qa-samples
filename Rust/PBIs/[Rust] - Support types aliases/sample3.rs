type MathFn = fn(i32, i32) -> i32;

fn add(a: i32, b: i32) -> i32 {
    a + b
}

fn main() {
    let math_function: MathFn = add;
    let result = math_function(5, 7);
    println!("Result: {}", result);
}
