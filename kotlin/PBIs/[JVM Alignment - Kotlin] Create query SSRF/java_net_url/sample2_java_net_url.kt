package com.example.plugins

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import java.net.HttpURLConnection
import java.net.URL

fun Application.configureRouting() {
    routing {
        get("/fetch") {
            val url = call.parameters["url"] ?: throw BadRequestException("Url parameter is required")
            val conn = URL(url).openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            conn.connect()
            val response = conn.inputStream.bufferedReader().readText()
            call.respondText(response, ContentType.Text.Plain)
        }
    }
}
