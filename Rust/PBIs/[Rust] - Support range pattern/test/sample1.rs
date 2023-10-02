fn main() {
    let num = 5;

    match num {
        1..=10 => println!("Number is between 1 and 10"),
        _ => println!("Number is outside the range"),
    }
}