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
        get("/createUser") {
            //http://127.0.0.1:8080/createUser?username=user1&password=passXpto
            val username = call.request.queryParameters["username"]
            val password = call.request.queryParameters["password"]
            createUser(username, password)
            call.respondText("User created: ${username}", ContentType.Text.Html)
        }
    }
}

fun createUser(username: String?, password: String?) {
    println("User created")
}
