unsafe fn unsafe_function() {
    println("This is an unsafe function.");
}

fn main() {
    unsafe {
        unsafe_function(); // Calling an unsafe function outside of main
    }
}
