fn main() {
    let mut num = 5;

    {
        let temp = num * 2;
        num = temp + 10;
    }

    println!("Final value: {}", num); // Output: Final value: 20
}
