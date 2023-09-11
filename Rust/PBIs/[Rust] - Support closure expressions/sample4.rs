// Conditional Closure
fn main() {
    let conditional_closure = |b: bool| -> Box<dyn Fn(i32) -> i32> {
        if b {
            let doubler = |x: i32| x * 2;
            Box::new(doubler)
        } else {
            let tripler = |x: i32| x + 1;
            Box::new(tripler)
        }
    };

    let doubler = conditional_closure(true);
    let tripler = conditional_closure(false);

    let doubled = doubler(10);
    println!("10 doubled is: {}", doubled);

    let tripled = tripler(10);
    println!("10 tripled is: {}", tripled);
}
