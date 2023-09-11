import org.mvel2.MVEL
import java.util.HashMap

object MVELExample extends App {

  // Define a simple data object
  case class Person(name: String, age: Int)

  // Create an instance of Person
  val person = Person("Alice", 30)

  // Take input expression from user
  println("Enter an MVEL expression:")
  val inputExpression = scala.io.StdIn.readLine()

  try {
    // Compile the input expression
    val expression = MVEL.compileExpression(inputExpression)

    // Evaluate the expression using the data object
    val result = MVEL.executeExpression(expression, person)

    // Print the result
    println(s"Evaluation result: $result")
  } catch {
    case ex: Exception =>
      println(s"Error: ${ex.getMessage}")
  }
}
