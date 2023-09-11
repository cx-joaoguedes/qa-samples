import io.ktor.application.*

data class UserSession(val id: String, val count: Int)

fun ktorserver() {
    embeddedServer(Netty, 8085) {

        // example 2
        routing {
            get("/profile") {
                val sessionId = call.sessions.get<Session>()?.id ?: error("No session id found")
                val session = SessionManager.getSession(sessionId) ?: error("Invalid session id")

                val responseCookies = buildSetCookieHeader(
                    Cookie("session_id", session.id),
                    Cookie("user_id", session.userId.toString()),
                    Cookie("access_token", session.accessToken)
                )

                call.response.headers.append(HttpHeaders.SetCookie, responseCookies)

                call.respond("Welcome back!")
            }
        }
    }
}
