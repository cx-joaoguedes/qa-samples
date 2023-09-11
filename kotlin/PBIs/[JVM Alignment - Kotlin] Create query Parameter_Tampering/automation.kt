import io.ktor.server.application.*
import io.ktor.http.content.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File

fun Application.main() {
    routing {
	
		//not secure
		get("/profile") {
			val userId = call.request.queryParameters["userId"]

			val userAddress = userAddressBook[userId]
			call.respondText(userAddress, ContentType.Text.Html)
		}
		
		//secure
		get("/profile") {
			val mySession: MySession? = call.sessions.get<MySession>()
			val userAddress = userAddressBook[mySession.userId]
			call.respondText(userAddress, ContentType.Text.Html)
		}
    }
}