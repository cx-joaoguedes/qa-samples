// Constructor with default values
struct Rectangle {
    width: u32,
    height: u32,
}

impl Rectangle {
    fn new() -> Rectangle {
        Rectangle { width: 0, height: 0 }
    }
}

fn main() {
    let empty_rect = Rectangle::new();
    let a = empty_rect.width;
    println!("Empty Rectangle: width = {}, height = {}", empty_rect.width, empty_rect.height);
}
