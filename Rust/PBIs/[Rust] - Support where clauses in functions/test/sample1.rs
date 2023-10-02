struct A<T>
where
    T: Iterator,
{
    f: T,
}

fn main() {
    let vec = vec![1, 2, 3];
    let a = A { f: vec.into_iter() };
    for item in a.f {
        println!("{}", item);
    }
}
