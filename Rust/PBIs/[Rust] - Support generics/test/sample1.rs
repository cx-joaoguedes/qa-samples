// A generic function that takes two values of the same type and returns their sum
fn add<T>(a: T, b: T) -> T
where
    T: std::ops::Add<Output = T>,
{
    a + b
}

fn main() {
    let num1 = 5;
    let num2 = 7;

    let result = add(num1, num2);
    println!("Result: {}", result); // Prints: Result: 12

    let float1 = 3.5;
    let float2 = 1.2;

    let float_result = add(float1, float2);
    println!("Float Result: {}", float_result); // Prints: Float Result: 4.7
}
