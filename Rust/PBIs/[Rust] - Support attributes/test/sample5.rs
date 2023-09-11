// A conditionally-compiled module
#[cfg(target_os = "linux")]
mod bar {
    pub fn linux_specific_function() {
        println("This function is only available on Linux.");
    }
}

fn main() {
    // Call the Linux-specific function if we're on Linux
    #[cfg(target_os = "linux")]
    bar::linux_specific_function();
}