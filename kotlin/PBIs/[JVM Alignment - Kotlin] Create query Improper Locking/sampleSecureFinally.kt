import java.util.concurrent.locks

// Unlock inside a finally block

class MyClass2() {
    // Safe:
    private val lockk : ReentrantLock = ReentrantLock()
	private val lockk1 : ReentrantLock = ReentrantLock()
	private val lockk2 : ReentrantLock = ReentrantLock()
    var counter: Int = 0
        private set

    fun increaseCtr2() {
        try {
            lockk.lock()
            counter++
			lockk.unlock()
        } finally {
            
        }
    }
	
	fun increaseCtr3() {
        try {
            lockk.lock()
            counter++
        } finally {
            lockk.unlock()
        }
    }
	
	fun increaseCtr4() {
        try {
            lockk.lock()
            counter++
        } finally {
            x=1
        }
    }
	
	fun test1() {
        try {
            lockk1.lock()
            counter++
        } finally {
            lockk2.unlock()
        }
    }
	
	fun test2() {
        try {
            lockk2.lock()
            counter++
        } finally {
            lockk1.unlock()
        }
    }
}