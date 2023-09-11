import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.client.request.*
import io.ktor.http.*

fun main() {
    val client = HttpClient(Apache)

    val id = readLine() ?: ""
    val url = "https://example.com/api?id=$id"
    val response = client.get<String>(url)
    println(response)
}
