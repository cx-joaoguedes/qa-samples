struct Point {
    x: i32,
    y: i32,
}

fn main() {
    let s = Point { x: 10, y: 20 };
    
    match s {
        Point { x: 10, y: 20 } => println!("Case 1: Matched"),
        Point { x: 20, y: 10 } => println!("Case 2: Order doesn't matter"),
        Point { x: 10, .. } => println!("Case 3: Matched with x: 10"),
        Point { .. } => println!("Case 4: Matched any Point"),
        _ => println!("Default Case"),
    }
}
