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
        get("/resetPassword") {
            //http://127.0.0.1:8080/resetPassword?username=user1&newPass=passXpto
            val username = call.request.queryParameters["username"]
            val newPass = call.request.queryParameters["newPass"]
            resetPassword(username, newPass);
            call.respondText("Password reset for: ${username}", ContentType.Text.Html)
        }
    }
}

fun resetPassword(username: String?, password: String?) {
    println("Password reset")
}
