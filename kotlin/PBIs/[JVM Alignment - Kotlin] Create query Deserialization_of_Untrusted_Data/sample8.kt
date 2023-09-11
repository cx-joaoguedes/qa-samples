import com.caucho.hessian.io.Hessian2Input
import com.caucho.hessian.io.HessianInput
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import java.io.ByteArrayInputStream
import java.io.ObjectInputStream

data class MyObject(val name: String, val age: Int)

fun main() {
    val server = embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
            register(ContentType.Application.Hessian) {
                HessianConverter()
            }
            register(ContentType.Application.Hessian2) {
                Hessian2Converter()
            }
        }
        routing {
            post("/hessian") {
                val inputStream = ByteArrayInputStream(call.receive<ByteArray>())
                val ois = HessianInput(inputStream)
                val obj = ois.readObject() as MyObject
                call.respond(HttpStatusCode.OK, obj)
            }
            post("/hessian2") {
                val inputStream = ByteArrayInputStream(call.receive<ByteArray>())
                val ois = Hessian2Input(inputStream)
                val obj = ois.readObject() as MyObject
                call.respond(HttpStatusCode.OK, obj)
            }
