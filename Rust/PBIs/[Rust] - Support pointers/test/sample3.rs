// Raw Pointer (const and mut)
fn main() {
    let value = 42;
    let raw_ptr: *const i32 = &value;

    unsafe {
        println!("Value through raw pointer: {}", *raw_ptr);
    }

    let mut mutable_value = 99;
    let raw_mut_ptr: *mut i32 = &mut mutable_value;

    unsafe {
        *raw_mut_ptr += 1;
        println!("Modified value through raw pointer: {}", *raw_mut_ptr);
    }
}
