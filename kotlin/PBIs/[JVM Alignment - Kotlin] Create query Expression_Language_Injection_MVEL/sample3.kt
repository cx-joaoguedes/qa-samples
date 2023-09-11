import org.mvel2.MVEL
import android.util.Base64

fun main() {
    val userInput = readLine() 
	val encodedText = Base64.encodeToString(userInput.toByteArray(), Base64.DEFAULT)
    val greeting = "Hello, "+ encodedText
    val compiledGreeting = MVEL.compileExpression(greeting)
    val variables = mapOf("userInput" to "World")
    val result = MVEL.executeExpression(compiledGreeting, variables)
    println(result)
}