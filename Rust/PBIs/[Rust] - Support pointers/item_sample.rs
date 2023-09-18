fn main() {
    let value = 42;
    let raw_ptr: *const i32 = &value as *const i32; // *const T creates a raw pointer to a value

    unsafe {
        println!("Value: {}", *raw_ptr); // Unsafe block needed to dereference raw pointers
    }
}