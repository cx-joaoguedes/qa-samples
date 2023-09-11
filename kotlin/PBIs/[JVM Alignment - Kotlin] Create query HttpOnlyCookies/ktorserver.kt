import io.ktor.application.*

data class UserSession(val id: String, val count: Int)

fun ktorserver() {
    embeddedServer(Netty, 8085) {
         install(Sessions) {
            cookie<UserSession>("user_session") {
                cookie.httpOnly = false
                cookie.secure = false
            }
			cookie<CartSession>("cart_session") {
					cookie.httpOnly = true
					cookie.secure = true
				}
			}

        routing {
            get("/") {
                val MY_COOKIE_NAME = "c"
                var value = "AAA"
                val cookie = Cookie(MY_COOKIE_NAME, value,
                    httpOnly = true,
                    secure = true
                )
                call.response.cookies.append(cookie)
                val cookie2 = Cookie(MY_COOKIE_NAME, value)
                call.response.cookies.append(cookie2)
                call.sessions.set(UserSession(id = "123abc", count = 0))
                call.respondText("Hello, world!", ContentType.Text.Html)
				
				call.response.cookies.append(
					name = "newcookie",
					value = "newcookievalue",
					httpOnly = false
				)
            }
        }
    }.start(wait = true)
}

fun main(args: Array<String>) {
    ktorserver()
}