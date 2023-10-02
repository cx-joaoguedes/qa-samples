struct Point(i32, i32);
type Coordinates = Point;

fn main() {
    let point = Coordinates(10, 20);
    println!("Coordinates: ({}, {})", point.0, point.1);
}
