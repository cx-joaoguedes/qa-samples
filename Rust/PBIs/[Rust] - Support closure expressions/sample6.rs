// Sorting Elements Using a Closure
fn main() {
    let sort_closure = |mut numbers: Vec<i32>| {
        numbers.sort();
        numbers
    };

    let sorted_numbers = sort_closure(vec![1, 5, 3, 2, 4]);
    println!("The sorted numbers are: {:?}", sorted_numbers);
}