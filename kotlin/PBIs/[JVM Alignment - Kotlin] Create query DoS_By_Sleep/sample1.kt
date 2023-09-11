fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        val sleepTime = args[0].toLongOrNull()

        if (sleepTime != null) {
            println("Sleeping for ${sleepTime}ms")
            Thread.sleep(sleepTime)
            println("Done sleeping")
        } else {
            println("Invalid sleep time specified: ${args[0]}")
        }
    } else {
        println("Please specify a sleep time in milliseconds")
    }
}
