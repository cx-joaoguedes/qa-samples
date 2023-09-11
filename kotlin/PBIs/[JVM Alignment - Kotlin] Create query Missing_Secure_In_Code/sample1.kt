import io.ktor.application.*

data class UserSession(val id: String, val count: Int)

fun ktorserver() {
    embeddedServer(Netty, 8085) {

        // example 1
        routing {
            get("/login") {
                val sessionId = call.parameters["session_id"] ?: error("No session id provided")
                val session = SessionManager.getSession(sessionId) ?: error("Invalid session id")

                val responseCookies = buildSetCookieHeader(
                    Cookie("session_id", session.id),
                    Cookie("user_id", session.userId.toString()),
                    Cookie("access_token", session.accessToken)
                )

                call.response.headers.append(HttpHeaders.SetCookie, responseCookies)

                call.respond("Logged in!")
            }
        }
    }
}
