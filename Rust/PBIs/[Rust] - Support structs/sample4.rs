struct Circle {
    radius: f64,
}

impl Circle {
    fn area(&self) -> f64 {
        std::f64::consts::PI * self.radius * self.radius
    }
}

fn main() {
    let circle = Circle { radius: 5.0 };
    println!("Circle area: {}", circle.area());
}
