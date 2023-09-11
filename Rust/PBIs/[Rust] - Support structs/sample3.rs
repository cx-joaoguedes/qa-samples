#[derive(Debug, PartialEq)]
struct Rectangle {
    width: u32,
    height: u32,
}

fn main() {
    let rect1 = Rectangle { width: 30, height: 50 };
    let rect2 = Rectangle { width: 30, height: 50 };
    let rect3 = Rectangle { width: 20, height: 40 };

    println!("rect1: {:?}", rect1);
    println!("rect2: {:?}", rect2);
    println!("rect3: {:?}", rect3);

    println!("rect1 == rect2: {}", rect1 == rect2);
    println!("rect1 == rect3: {}", rect1 == rect3);
}
