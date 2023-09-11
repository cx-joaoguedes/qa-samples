import io.ktor.client.HttpClient
import io.ktor.client.features.websocket.*
import io.ktor.http.cio.websocket.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import java.util.*

fun main() = runBlocking {
    val scanner = Scanner(System.`in`)
    print("Insert url: ")
    val input = String(scanner.nextLine().toCharArray())

    val client = HttpClient()

    client.ws(
        method = HttpMethod.Get,
        host = input,
        path = "/"
    ) {
        // Send a message to the server
        send(Frame.Text("Hello, server!"))
        // Receive messages from the server
        while (true) {
            val frame = incoming.receive()
            if (frame is Frame.Text) {
                println("Received message from server: ${frame.readText()}")
            }
        }
    }
    client.wss(
        method = HttpMethod.Get,
        host = "example.com",
        path = input
    ) {
        send(Frame.Text("Hello, server!"))
        while (true) {
            val frame = incoming.receive()
            if (frame is Frame.Text) {
                println("Received message from server: ${frame.readText()}")
            }
        }
    }
    client.webSocket(
        method = HttpMethod.Get,
        host = input,
        path = "/"
    ) {
        send(Frame.Text("Hello, server!"))
        while (true) {
            val frame = incoming.receive()
            if (frame is Frame.Text) {
                println("Received message from server: ${frame.readText()}")
            }
        }
    }

    client.close()
}