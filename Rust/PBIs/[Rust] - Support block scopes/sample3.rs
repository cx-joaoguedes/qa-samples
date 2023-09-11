fn main() {
    let age = 25;

    let age_category = {
        if age < 18 {
            "Teenager"
        } else if age < 65 {
            "Adult"
        } else {
            "Senior"
        }
    };

    println!("Age category: {}", age_category); // Output: Age category: Adult
}
