struct Person {
    name: String,
    age: u32,
}

fn main() {
    let mut person = Person {
        name: "Alice".to_string(),
        age: 30,
    };

    person.age += 1;
    println("{} is {} years old.", person.name, person.age);
}