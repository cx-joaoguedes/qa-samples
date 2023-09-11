package com.example.plugins

import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/login") {
            //http://127.0.0.1:8080/login?username=user1&password=passXpto&ssn=123
            val username = call.request.queryParameters["username"]
            val password = call.request.queryParameters["password"]
				 val card = call.request.queryParameters["card"]
            createUser(username, password, card)
            call.respondText("Logged in as: ${username}, ${card}", ContentType.Text.Html) // Result here because ssn var. Should not give result for username
        }
    }
}

fun createUser(username: String?, password: String?, cod_cartao: String?) {
    println("User logged in")
}
