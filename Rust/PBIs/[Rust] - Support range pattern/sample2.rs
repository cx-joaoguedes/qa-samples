fn main() {
    let c = 'c';

    match c {
        'a'..='z' => println!("Character is a lowercase letter"),
        'A'..='Z' => println!("Character is an uppercase letter"),
        _ => println!("Character is not a letter"),
    }
}
