fn main() {
    let outer_variable = 5;

    {
        let inner_variable = 10;
        println!("Inner variable: {}", inner_variable);
        println!("Accessing outer variable from the inner block: {}", outer_variable);
    }

    println!("Accessing outer variable from the outer block: {}", outer_variable);
}