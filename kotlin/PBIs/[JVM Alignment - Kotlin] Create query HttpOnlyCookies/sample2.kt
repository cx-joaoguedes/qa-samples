import io.ktor.http.*
import io.ktor.response.*

val cookie = Cookie(
    name = "my-cookie-name",
    value = "my-cookie-value",
    httpOnly = true
)
call.response.cookies.append(cookie)
