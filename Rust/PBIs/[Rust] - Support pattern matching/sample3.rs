fn main() {
    fn basic_pattern_matching(value: i32) -> &'static str {
        match value {
            0 => "Zero",
            1 => "One",
            _ => "Other",
        }
    }

let value = basic_pattern_matching(5);

}
