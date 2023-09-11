package com.example.plugins

import io.ktor.application.*
import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.client.request.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import java.net.URL

fun Application.configureRouting() {
    routing {
        get("/fetchUrl") {
            val urlString = call.request.queryParameters["url"]
            if (urlString.isNullOrEmpty()) {
                call.respond(HttpStatusCode.BadRequest, "Please provide a URL.")
            } else {
                val url = URL(urlString)
                val client = HttpClient(Apache) // Using Apache engine
                val response: HttpResponse = client.request(url.toString()) { // SSRF vulnerability here
                    method = HttpMethod.Get
                }
                call.respondText(response.readText())
            }
        }
    }
}
