#[derive(Debug)] // Add Debug for printing Point and PointTuple
struct Point {
    x: i32,
    y: i32,
}

#[derive(Debug)] // Add Debug for printing Point and PointTuple
struct PointTuple(i32, i32);

fn main() {
    let s = Point { x: 10, y: 20 };
    let p = PointTuple(10, 20);

    match s {
        Point { x: 10, y: 20 } => println!("Matched Point {{ x: 10, y: 20 }}"),
        Point { y: 10, x: 20 } => println!("Matched Point {{ y: 10, x: 20 }}"),
        Point { x: 10, .. } => println!("Matched Point {{ x: 10, .. }}"),
        Point { .. } => println!("Matched any Point"),
        _ => println!("Default Case for s"),
    }

    match p {
        PointTuple(10, 20) => println!("Matched PointTuple (10, 20)"),
        _ => println!("Default Case for p"),
    }
}
