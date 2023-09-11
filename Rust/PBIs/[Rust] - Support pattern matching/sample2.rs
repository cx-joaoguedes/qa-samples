fn main() {
    let value = 5;

    match value {
        1 => println!("It's one!"),
        2 | 3 => println!("It's two or three!"),
        4..=6 => println!("It's between 4 and 6 inclusive!"),
        _ => println!("It's something else!"),
    }
}
