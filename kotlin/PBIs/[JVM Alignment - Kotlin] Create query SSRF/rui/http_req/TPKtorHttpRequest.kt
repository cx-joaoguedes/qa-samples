import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.http.content.*
import java.util.*

suspend fun main() {
    val scanner = Scanner(System.`in`)
    print("Insert url: ")
    val input = String(scanner.nextLine().toCharArray())

    var client = HttpClient() {
        expectSuccess = false // Suppress exceptions for non-200/300 HTTP codes
    }

    var e1_response: HttpResponse = client.get(input)
    println("e1_response: " + e1_response.bodyAsText())

    var builder = HttpRequestBuilder()
    builder.method = HttpMethod.Get
    builder.url(urlString=input)
    builder.header("Content-Type", "application/json")

    var e2_response: HttpResponse = client.get(builder)
    println("e2_response: " + e2_response.bodyAsText())

    var builder2 = HttpRequestBuilder.invoke(host=input)
    var e3_response: HttpResponse = client.get(builder2)
    println("e3_response: " + e3_response.bodyAsText())

    var builder3 = HttpRequestBuilder.Companion.invoke(scheme="https", host="www.google.pt", path=input)
    var e4_response: HttpResponse = client.get(builder3)
    println("e4_response: " + e4_response)

    var e5_response: HttpResponse = client.get{
        url(input)
        header("User-Agent", "Mozilla/5.0")
    }
    println("e5_response: " + e5_response.bodyAsText())

    client.close()
}