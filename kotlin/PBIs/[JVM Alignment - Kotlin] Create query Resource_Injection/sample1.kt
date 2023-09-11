import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import java.net.ServerSocket
import java.net.Socket

fun main() {
	embeddedServer(Netty, port = 8080) {
		routing {
			get("/connect-unsafe") {
				val portNo = call.request.queryParameters["port"]!!.toInt()
				val serverSock = ServerSocket(portNo)
				val listener = Thread {
					while (true) {
						val client: Socket = serverSock.accept()
					}
				}
				listener.start()
			}

			get("/connect-safe") {
				val portNo = when (call.request.queryParameters["port"]) {
					"quicktime" -> 1220
					"kazaa" -> 1214
					"battlenet" -> 1119
					else -> 80
				}
				val serverSock = ServerSocket(portNo)
				val listener = Thread {
					while (true) {
						val client: Socket = serverSock.accept()
					}
				}
				listener.start()
			}
		}
	}
}