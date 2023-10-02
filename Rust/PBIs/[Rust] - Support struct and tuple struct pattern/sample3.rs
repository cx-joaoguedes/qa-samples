struct PointTuple(i32, i32);

fn main() {
    let p = PointTuple(10, 20);
    
    match p {
        PointTuple(10, 20) => println!("Case 1: Matched (10, 20)"),
        _ => println!("Default Case"),
    }
}
