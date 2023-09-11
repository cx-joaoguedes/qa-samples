import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.client.request.*
import io.ktor.http.*

fun main() {
    val client = HttpClient(Apache)

    val url = readLine() ?: ""
    val response = client.get<String>(url)
    println(response)
}
