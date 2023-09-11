import io.ktor.http.*
import io.ktor.response.*

call.response.cookies.append(
    name = "my-cookie-name",
    value = "my-cookie-value",
    httpOnly = true,
    domain = "mydomain.com",
    path = "/",
    secure = true,
    expires = GMTDate(2023, 3, 31, 12, 0, 0)
)
