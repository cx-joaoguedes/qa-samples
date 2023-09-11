import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}

@RestController
class LoginController {

    @PostMapping("/login")
    fun login(@RequestBody credentials: Credentials): String {
        val username = credentials.username
        val password = credentials.password

        // Perform authentication logic here

        return "Login successful"
    }
}

data class Credentials(val username: String, val password: String)
