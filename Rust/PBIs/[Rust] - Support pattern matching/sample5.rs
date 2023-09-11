fn main() {
    fn tuple_destructuring(pair: (i32, i32)) -> i32 {
        match pair {
            (0, y) => y,
            (x, 0) => x,
            (x, y) => x + y,
        }
    }
}