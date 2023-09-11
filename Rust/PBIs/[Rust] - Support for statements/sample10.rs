fn main() {
    let names = vec!["Alice", "Bob", "Charlie"];
    for (index, name) in names.iter().enumerate() {
        println!("Index: {}, Name: {}", index, name);
    }
}
