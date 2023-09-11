class SharedResource {
    val lock = ReentrantLock()
    var value = 0
}

fun main() {
    val sharedResource = SharedResource()
    repeat(10000) {
        thread {
            sharedResource.lock.lock()
            sharedResource.value++
            sharedResource.lock.unlock()
        }
    }
    println("Value: ${sharedResource.value}")
}
