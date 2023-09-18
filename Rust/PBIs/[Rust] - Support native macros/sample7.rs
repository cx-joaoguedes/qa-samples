// include! and include_str!
fn main() {
    include!("config.rs");
    let license_text = include_str!("LICENSE.txt");
    println!("{}", license_text);
}
