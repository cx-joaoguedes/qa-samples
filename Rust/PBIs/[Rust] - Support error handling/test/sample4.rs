fn custom_panic() {
    panic!("This is a custom panic inside a function!");
}

fn main() {
    custom_panic();
}
