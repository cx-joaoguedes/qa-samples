import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*

fun main() {
    val client = HttpClient(Apache) {
        followRedirects = true
    }

    val url = "https://example.com/redirect?url=http://internal-server.com/private-data"
    val response = client.get<String>(url)
    println(response)
}
