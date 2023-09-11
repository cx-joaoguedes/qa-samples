import org.springframework.expression.Expression
import org.springframework.expression.ExpressionParser
import org.springframework.expression.spel.standard.SpelExpressionParser

fun main(args : Array<String>) {
    val parser: ExpressionParser = SpelExpressionParser()
    val exp: Expression = parser.parseExpression(args[0])
    val result = exp.value
    if (result != null) {
        println(result)
    }
}