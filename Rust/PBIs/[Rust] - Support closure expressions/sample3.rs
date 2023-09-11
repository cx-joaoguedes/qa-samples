// A closure that takes a vector of integers as input and returns the sum of all the integers in the vector
fn main() {
    let vector = vec![1, 2, 3, 4, 5];

    let sum_closure = |v: Vec<i32>| {
        v.iter().sum()
    };

    let sum: i32 = sum_closure(vector);
    println!("The sum of the vector is: {}", sum);
}