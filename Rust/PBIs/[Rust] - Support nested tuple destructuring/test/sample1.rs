// Generic
fn main() {
    // Create a nested tuple
    let nested_tuple = ("Alice", (30, "Bob"));

    // Access elements of the nested tuple
    let name = nested_tuple.0;
    let age_and_friend = nested_tuple.1;

    // Access elements within the nested tuple
    let age = age_and_friend.0;
    let friend = age_and_friend.1;

    // Print the values
    println!("Name: {}", name);
    println!("Age: {}", age);
    println!("Friend: {}", friend);
}
