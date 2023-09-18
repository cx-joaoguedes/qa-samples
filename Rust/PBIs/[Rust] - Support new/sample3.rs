// Generic Struct Constructor
struct Pair<T> {
    first: T,
    second: T,
}

impl<T> Pair<T> {
    fn new(first: T, second: T) -> Pair<T> {
        Pair { first, second }
    }
}

fn main() {
    let pair = Pair::new("Hello", "World");
    println!("Pair: first = {}, second = {}", pair.first, pair.second);
}