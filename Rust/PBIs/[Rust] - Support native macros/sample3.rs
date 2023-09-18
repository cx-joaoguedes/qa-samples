// assert! and assert_eql
fn main() {
    let x = 42;
    let result = add_two(x);
    assert!(x > 0);
    assert_eq!(result, 44);
}

fn add_two(x: i32) -> i32 {
    x + 2
}
