import java.util.concurrent.locks.ReentrantLock

class MyThread: Thread() {
    private val lock = ReentrantLock()

    override fun run() {
        // do some work
        lock.lock()  // (vulnerable) acquire lock
        // do some more work
        lock.unlock()  // release lock
    }
}

fun main() {
    val threads = mutableListOf<MyThread>()
    for (i in 1..10) {
        threads.add(MyThread())
    }
    threads.forEach { it.start() }
}
