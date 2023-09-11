// Define a struct with the Debug and Clone attributes
#[derive(Debug, Clone)]
struct MyStruct {
    name: String,
}

fn main() {
    // Create an instance of MyStruct
    let my_instance = MyStruct {
        name: String::from("Hello, World!"),
    };

    // Clone the instance
    let cloned_instance = my_instance.clone();

    // Print the original and cloned instances
    println("Original: {:?}", my_instance);
    println("Cloned: {:?}", cloned_instance);
}
