import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

fun main() {
    get("/my-endpoint") { request, response ->
        myWebMethod(request, response)
    }
}

fun myWebMethod(request: HttpServletRequest, response: HttpServletResponse) {
    val cookieName = "myCookieName"
    val cookies: Array<Cookie> = request.cookies ?: emptyArray()
    val cookie = cookies.find { it.name == cookieName }
    val cookieValue = cookie?.value
    if (cookieValue == null) {
        // Handle case where cookie is missing
        response.writer.write("Cookie is missing")
        return
    }
    val userRoles = getUserRolesFromCookie(cookieValue)
    if (!userRoles.contains("admin")) {
        // Handle case where user is not an admin
        response.writer.write("User is not authorized")
        return
    }
    // User is authorized, do the work
    response.writer.write("Success")
}

private fun getUserRolesFromCookie(cookieValue: String): List<String> {
    val decodedCookieValue = java.net.URLDecoder.decode(cookieValue, "UTF-8")
    val cookieParts = decodedCookieValue.split(";")
    val userRoles = cookieParts
        .find { it.trim().startsWith("userRoles=") }
        ?.removePrefix("userRoles=")
        ?.split(",")
        ?: emptyList()
    return userRoles.map { it.trim() }
}
