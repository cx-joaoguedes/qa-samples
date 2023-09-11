import io.ktor.client.HttpClient
import io.ktor.client.features.websocket.WebSocket
import io.ktor.client.features.websocket.webSocketSession
import io.ktor.http.cio.websocket.*
import kotlinx.coroutines.*
import java.util.*

fun main() = runBlocking {
    val scanner = Scanner(System.`in`)
    print("Insert url: ")
    val input = String(scanner.nextLine().toCharArray())

    val client = HttpClient()

    val session = client.webSocketSession(
        method = HttpMethod.Get,
        host = input,
        path = "/"
    )

    // Send a message to the server
    session.send(Frame.Text("Hello, server!"))

    // Receive messages from the server
    while (true) {
        val frame = session.incoming.receive()
        if (frame is Frame.Text) {
            println("Received message from server: ${frame.readText()}")
        }
    }

    // Close the session
    session.close()

    // Shutdown the client
    client.close()
}
