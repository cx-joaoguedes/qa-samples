// Constructor Function Impl
struct Point {
    x: i32,
    y: i32,
}

impl Point {
    fn new(x: i32, y: i32) -> Point {
        Point { x, y }
    }
}

fn main() {
    let point = Point::new(10, 20);
    println!("Point: x = {}, y = {}", point.x, point.y);
}
