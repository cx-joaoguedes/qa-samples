package com.example.plugins

import io.ktor.application.*
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureRouting() {
    routing {
        get("/fetchUrl") {
            val url = call.request.queryParameters["url"]
            if (url.isNullOrEmpty()) {
                call.respond(HttpStatusCode.BadRequest, "Please provide a URL.")
            } else {
                val client = HttpClient()
                val response: HttpResponse = client.get(url) // SSRF vulnerability here
                call.respondText(response.readText())
            }
        }
    }
}
