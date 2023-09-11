import io.ktor.server.application.*
import io.ktor.http.content.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File

fun Application.main() {
    routing {
	
		//not secure
        get("/user/{id}") {
            val userId = call.parameters["id"]
            val user = User[userId]
            call.respond(userId)
        }
    }
}