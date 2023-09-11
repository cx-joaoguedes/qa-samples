fn main() {
    let num = 42;
    let ptr = &num as *const i32; // Create a raw pointer
    
    unsafe {
        println("Value at ptr: {}", *ptr); // Dereference raw pointer inside unsafe block
    }
}
