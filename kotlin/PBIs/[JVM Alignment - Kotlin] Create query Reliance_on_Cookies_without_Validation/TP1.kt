fun main() {
get("/admin") {

    val cookieValue = call.request.cookies["role"]

    if (cookieValue != null && cookieValue.equals("admin")){

        call.respondRedirect("/admin/index")

    }

    call.respondText("Unauthorized", ContentType.Text.Html)

}
}