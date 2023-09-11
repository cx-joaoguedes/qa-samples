package com.example.plugins

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import java.net.URL

fun Application.configureRouting() {
    routing {
        get("/proxy") {
            val url = URL(call.parameters["url"])
            val response = url.readText()
            call.respondText(response)
        }
    }
}
