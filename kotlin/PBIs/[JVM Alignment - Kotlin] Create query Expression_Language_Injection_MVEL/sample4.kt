import org.mvel2.MVEL
import javax.xml.bind.DatatypeConverter

fun main() {
    val userInput = readLine() 
	val hexText = DatatypeConverter.printHexBinary(userInput.toByteArray())
    val greeting = "Hello, "+ hexText
    val compiledGreeting = MVEL.compileExpression(greeting)
    val variables = mapOf("userInput" to "World")
    val result = MVEL.executeExpression(compiledGreeting, variables)
    println(result)
}