fn main() {
    let temperature = 25;

    match temperature {
        0..=32 => println!("It's freezing!"),
        33..=70 => println!("It's mild"),
        71..=100 => println!("It's hot"),
        _ => println!("Temperature is out of range"),
    }
}
