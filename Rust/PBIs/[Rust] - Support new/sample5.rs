// Enum Constructor
enum Result<T, E> {
    Ok(T),
    Err(E),
}

fn main() {
    let success = Result::Ok(42);
    match success {
        Result::Ok(value) => println!("Success: {}", value),
        Result::Err(_) => println!("Error"),
    }
}
