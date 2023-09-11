import io.ktor.http.*
import io.ktor.response.*

call.response.cookies.append(
    name = "my-cookie-name",
    value = "my-cookie-value",
    httpOnly = true
)
