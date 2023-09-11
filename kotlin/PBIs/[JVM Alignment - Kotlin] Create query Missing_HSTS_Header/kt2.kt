import io.ktor.server.application.*
import io.ktor.server.plugins.hsts.*
// ...
fun main() {
    embeddedServer(Netty, port = 8080) {
        install(HSTS) //TN
        // ...
    }.start(wait = true)
}