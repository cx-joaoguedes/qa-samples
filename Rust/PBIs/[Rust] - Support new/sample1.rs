// Simple Constructor
struct Person {
    name: String,
    age: u32,
}

// Implement an associated function to create a new Person instance
impl Person {
    fn new(name: String, age: u32) -> Person {
        Person { name, age }
    }
}

fn main() {
    // Create a new Person instance using the associated function
    let person1 = Person::new(String::from("Alice"), 30);
    
    // Access fields of the person
    println!("Name: {}", person1.name);
    println!("Age: {}", person1.age);
}
