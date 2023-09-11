import io.ktor.server.application.*
import io.ktor.server.plugins.hsts.*
// ...
fun Application.module() {
    install(HSTS) { //TP
		maxAgeInSeconds = 10
		includeSubDomains = false
	}
}