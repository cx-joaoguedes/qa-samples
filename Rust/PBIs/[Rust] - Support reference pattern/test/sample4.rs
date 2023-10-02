fn add(a: &i32, b: &i32) -> i32 {
    a + b
}

fn main() {
    let x = 10;
    let y = 20;

    let result = add(&x, &y);
    println!("Result: {}", result);
}
