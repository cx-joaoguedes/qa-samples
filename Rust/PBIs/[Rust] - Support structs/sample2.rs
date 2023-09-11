struct Color(i32, i32, i32);

fn main() {
    let red = Color(255, 0, 0);
    println!("Red: ({}, {}, {})", red.0, red.1, red.2);
}
