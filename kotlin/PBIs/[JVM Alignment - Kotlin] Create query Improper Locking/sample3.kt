class Account(private var balance: Int) {
    private val lock = ReentrantLock()
    fun withdraw(amount: Int) {
        lock.unlock()
        balance -= amount
        lock.lock()
    }
}

fun main() {
    val account = Account(1000)
    repeat(10000) {
        thread {
            account.withdraw(10)
        }
    }
    println("Balance: ${account.balance}")
}
