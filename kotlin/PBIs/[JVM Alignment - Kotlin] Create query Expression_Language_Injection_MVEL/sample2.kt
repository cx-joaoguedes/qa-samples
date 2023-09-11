import org.mvel2.MVEL

fun main() {
    val userInput = readLine() 
    val greeting = "Hello, "+ userInput
    val compiledGreeting = MVEL.compileExpression(greeting)
    val variables = mapOf("userInput" to "World")
    val result = MVEL.executeExpression(compiledGreeting, variables)
    println(result)
}