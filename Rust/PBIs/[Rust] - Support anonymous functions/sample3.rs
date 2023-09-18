fn main() {
    let x = 10;
    
    // Fn closure (immutable borrowing)
    let imm_closure = || {
        println!("Immutable closure: {}", x);
    };
    
    // FnMut closure (mutable borrowing)
    let mut_closure = || {
        println!("Mutable closure: {}", x);
    };
    
    // FnOnce closure (consumes the variable)
    let once_closure = move || {
        println!("Consuming closure: {}", x);
    };
    
    imm_closure();
    mut_closure();
    once_closure();
    
    // This line would cause an error because `x` was moved into `once_closure`.
    // println!("Outside: {}", x);
}
