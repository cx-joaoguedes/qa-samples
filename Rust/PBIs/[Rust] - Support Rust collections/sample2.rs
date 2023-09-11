use std::collections::HashMap;

fn main() {
    let mut hash_map = HashMap::new();

    // Insert a key-value pair into the hash map
    hash_map.insert("key1", "value1");
    hash_map.insert("key2", "value2");

    // Get the value associated with a key
    let value = hash_map.get("key1");

    // Check if a key is present in the hash map
    let is_present = hash_map.contains_key("key1");
}
