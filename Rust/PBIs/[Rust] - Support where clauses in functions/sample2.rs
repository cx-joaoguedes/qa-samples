struct A<T>
where
    T: Iterator,
    T::Item: Copy,
{
    f: T,
}

fn main() {
    let vec = vec![1, 2, 3];
    let a = A { f: vec.into_iter() }; // This will not compile because i32 is not Copy.
}
