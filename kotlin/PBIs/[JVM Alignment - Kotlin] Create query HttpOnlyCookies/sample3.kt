import io.ktor.http.*
import io.ktor.response.*

call.response.headers.append(HttpHeaders.SetCookie, "my-cookie-name=my-cookie-value; HttpOnly")
