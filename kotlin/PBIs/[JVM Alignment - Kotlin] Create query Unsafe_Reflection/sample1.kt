import io.ktor.application.*
import io.ktor.features.ContentNegotiation
import io.ktor.features.StatusPages
import io.ktor.features.json
import io.ktor.features.ContentTransformationException
import io.ktor.features.ContentTransformationExceptionCause
import io.ktor.features.NotFoundException
import io.ktor.features.StatusPagesException
import io.ktor.features.StatusPages.Configuration.Status.PageNotFound
import io.ktor.features.StatusPages.Configuration.Status.INTERNAL_SERVER_ERROR
import io.ktor.features.StatusPages.Configuration.Status.BadRequest
import io.ktor.features.StatusPages.Configuration.Status.NotFound
import io.ktor.features.StatusPages.Configuration.Status.Unauthorized
import io.ktor.features.StatusPages.Configuration.Status.Forbidden
import io.ktor.features.StatusPages.Configuration.Status.MethodNotAllowed
import io.ktor.features.StatusPages.Configuration.Status.NotAcceptable
import io.ktor.features.StatusPages.Configuration.Status.UnsupportedMediaType
import io.ktor.features.StatusPages.Configuration.Status.NotImplemented
import io.ktor.features.StatusPages.Configuration.Status.ServiceUnavailable
import io.ktor.features.StatusPages.Configuration.Status.GatewayTimeout
import io.ktor.features.StatusPages.Configuration.Status.BadGateway
import io.ktor.routing.*
import io.ktor.http.HttpStatusCode
import io.ktor.request.receiveParameters
import java.lang.reflect.Method

class MyClass {
    var name = "SomeName"
    fun printName() {
        println("You are " + name)
    }
}

fun Application.module() {
    install(ContentNegotiation) {
        json { }
    }

    install(StatusPages) {
        // Configure status pages here
    }

    routing {
        get("/invoke") {
            val userInput1 = call.request.queryParameters["user_input_1"]
            val userInput2 = call.request.queryParameters["user_input_2"]
            
            // Type 1: Class reference
            val clazz = MyClass::class
            val method = clazz.java.getMethod(userInput1)
            val instance = clazz.java.newInstance()

            // Type 1B: Bound Class References
            val qualifiedName = instance::class.qualifiedName

            // Type 2: Callable References
            method.invoke(instance)

            // Type 3: Class.forName
            val classByUser = Class.forName(userInput2)
            val kFunc1 = (clazz.java.methods.find { it.name == userInput1 })?.kotlinFunction
            val kFunc2 = (classByUser.methods.find { it.name == "SOME_STRING" })?.kotlinFunction

            var kFunc: ((Any?) -> Any?)? = kFunc1
            if (kFunc == null) {
                kFunc = kFunc2
            }

            kFunc?.call(instance)

            call.respondText("Done", status = HttpStatusCode.OK)
        }
    }
}

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}
