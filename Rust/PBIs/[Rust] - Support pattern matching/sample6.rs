fn main() {
    fn ignoring_values(value: (i32, i32)) -> i32 {
        match value {
            (_, y) => y,
        }
    }
    
    println!("{}", ignoring_values((1,50)));
    
    
    }