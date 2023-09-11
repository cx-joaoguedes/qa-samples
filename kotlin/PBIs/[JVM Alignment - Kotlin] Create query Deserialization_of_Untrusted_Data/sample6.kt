import com.thoughtworks.xstream.XStream
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import java.io.ByteArrayInputStream

data class MyObject(val name: String, val age: Int)

fun main() {
    val xstream = XStream()
    val server = embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
            register(ContentType.Application.Xml, XStreamConverter(xstream))
        }
        routing {
            post("/object") {
                val xml = call.receive<String>()
                val inputStream = ByteArrayInputStream(xml.toByteArray())
                val obj = xstream.fromXML(inputStream) as MyObject
                call.respond(HttpStatusCode.OK, obj)
            }
        }
    }
    server.start(wait = true)
}
