struct Address {
    city: String,
    zip_code: String,
}

struct Person {
    name: String,
    age: u32,
    address: Address,
}

fn main() {
    let address = Address {
        city: String::from("New York"),
        zip_code: String::from("10001"),
    };
    let person = Person {
        name: String::from("John"),
        age: 35,
        address,
    };
    println!("Name: {}, Age: {}", person.name, person.age);
    println!("City: {}, Zip Code: {}", person.address.city, person.address.zip_code);
}
