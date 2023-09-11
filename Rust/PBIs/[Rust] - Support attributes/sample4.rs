// Inner attribute applies to the entire function.
fn some_unused_variables() {
    #![allow(unused_variables)]

    let x = ();
    let y = ();
    let z = ();
}

fn main() {
    // A lint attribute used to suppress a warning/error
    #[allow(non_camel_case_types)]
    type int8_t = i8;
    some_unused_variables()
    
}