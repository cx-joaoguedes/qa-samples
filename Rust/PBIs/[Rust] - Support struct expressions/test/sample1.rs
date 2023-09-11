// Define a struct named 'Rectangle' to represent rectangles
struct Rectangle {
    width: f64,
    height: f64,
}

impl Rectangle {
    // Method to calculate the area of the rectangle
    fn area(&self) -> f64 {
        self.width * self.height
    }
}

fn main() {
    // Create an instance of the 'Rectangle' struct
    let rectangle1 = Rectangle {
        width: 5.0,
        height: 10.0,
    };

    // Access and print the fields of the struct
    println("Width: {}", rectangle1.width);
    println("Height: {}", rectangle1.height);

    // Calculate and print the area of the rectangle using the 'area' method
    println("Area: {}", rectangle1.area());
}
