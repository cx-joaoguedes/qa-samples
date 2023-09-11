import org.springframework.expression.ExpressionParser
import org.springframework.expression.spel.standard.SpelExpressionParser

fun main(args : Array<String>){
    evaluateSpelExpressionFromUserInput(args[0])
}

fun evaluateSpelExpressionFromUserInput(contextObject: Any): Any? {
    val expressionString = readLine()
    val parser: ExpressionParser = SpelExpressionParser()
    val expression = parser.parseExpression(expressionString)
    return expression.value

}
