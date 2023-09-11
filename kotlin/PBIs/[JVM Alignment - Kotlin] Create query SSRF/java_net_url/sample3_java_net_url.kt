package com.example.plugins

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import java.net.InetAddress

fun Application.configureRouting() {
    routing {
        get("/dnsLookup") {
            val domain = call.parameters["domain"] ?: throw BadRequestException("Domain parameter is required")
            val address = InetAddress.getByName(domain).hostAddress
            call.respondText("IP address for $domain is $address", ContentType.Text.Plain)
        }
    }
}
