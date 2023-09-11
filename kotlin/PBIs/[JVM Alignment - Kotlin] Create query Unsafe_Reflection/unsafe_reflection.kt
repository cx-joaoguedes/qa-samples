import kotlin.reflect.KCallable
import java.lang.Runtime
import kotlin.reflect.KFunction
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.functions
import kotlin.reflect.jvm.javaMethod
import kotlin.reflect.jvm.kotlinFunction

class MyClass {
    var name = "SomeName"

    fun printName() {
        println("You are " + name)
    }
}

fun isOdd(x: Int) = x % 2 != 0


fun main(args: Array<String>)
{
    val user_input_1 = readLine()
    val user_input_2 = readLine()

    //TYPE 1: Class reference
    val clazz = MyClass::class //KClass Object - not a result (no user input)
    val method = clazz.java.getMethod(user_input_1) //reflection result
    val instance = clazz.java.newInstance() //not a result (isn't influenced by the user input)

    //TYPE 1B: Bound Class References
    println("The qualified name: ${instance::class.qualifiedName}") //reflection using an instance of the class "receiver"

    //Type 2: Callable References
    //Base on code from type 1:
    method.invoke(instance) //Type 2 reflection result

    val classByUser = Class.forName(user_input_2) //Result - Class is derived from user input
    val kFunc1 = (clazz.java.methods.find { it.name == user_input_1 })?.kotlinFunction //Result - user_input_1 influences the method name
    val kFunc2 = (classByUser.methods.find { it.name == "SOME_STRING" })?.kotlinFunction //Result - classByUser influences on the chosen method

    var kFunc = kFunc1
    if(kFunc == null)
    {
        kFunc = kFunc2
    }
    kFunc?.call(instance) //This is a result either if kFunc is "kFunc1" or "kFunc2"
    
}