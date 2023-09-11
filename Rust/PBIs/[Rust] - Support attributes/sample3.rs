// Conditional compilation attributes.
#[cfg(target_os = "windows")]
fn windows_only_function() {
    println("This code runs on Windows!");
}

#[cfg(not(target_os = "windows"))]
fn windows_only_function() {
    println("This code does not run on Windows.");
}

fn main() {
    windows_only_function();
}
