import org.springframework.expression.ExpressionParser
import org.springframework.expression.spel.standard.SpelExpressionParser

object SpelExample {
  def main(args: Array[String]): Unit = {
    // Create an instance of ExpressionParser
    val parser: ExpressionParser = new SpelExpressionParser()

    // Get input from user
    println("Enter your name:")
    val name = scala.io.StdIn.readLine()

    println("Enter your age:")
    val age = scala.io.StdIn.readInt()

    // Define a context object for evaluation
    val context = new Person(name, age)

    // Define an expression to be evaluated
    val expression = parser.parseExpression(name.toUpperCase() + " is " + age + " years old")

    // Evaluate the expression and print the result
    val result = expression.getValue(context, classOf[String])
    println(result)
  }
}

// Define a sample data class
case class Person(name: String, age: Int)
