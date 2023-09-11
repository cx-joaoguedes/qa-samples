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
        get("/updatePassword") {
            //http://127.0.0.1:8080/updatePassword?newPass=passXpto
            val newPass = call.request.queryParameters["newPass"]
            updatePassword(newPass);
            call.respondText("New password is: ${newPass}", ContentType.Text.Html)
        }
    }
}

fun updatePassword(password: String?) {
    println("Password updated")
}