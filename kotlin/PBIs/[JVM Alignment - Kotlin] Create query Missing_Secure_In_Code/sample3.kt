import io.ktor.application.*

data class UserSession(val id: String, val count: Int)

fun ktorserver() {
    embeddedServer(Netty, 8085) {

            // example 3
            routing {
                post("/submit") {
                    val formData = call.receiveMultipart().readAllParts()
                    val sessionId = formData.filterIsInstance<PartData.FormItem>().firstOrNull { it.name == "session_id" }?.value ?: error("No session id provided")
                    val session = SessionManager.getSession(sessionId) ?: error("Invalid session id")

                    val responseCookies = buildSetCookieHeader(
                        Cookie("session_id", session.id),
                        Cookie("user_id", session.userId.toString()),
                        Cookie("access_token", session.accessToken)
                    )

                    call.response.headers.append(HttpHeaders.SetCookie, responseCookies)

                    // save form data
                    val file = formData.filterIsInstance<PartData.FileItem>().firstOrNull { it.name == "file" } ?: error("No file provided")
                    val content = file.streamProvider().readBytes()

                    call.respond("Form submitted!")
                }
            }
        }
    }
