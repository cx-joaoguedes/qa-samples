fun main() {
get("/admin") {

    val mySession: UserSession? = call.sessions.get<UserSession>()

    if (mySession.role.equals("admin")){

        call.respondRedirect("/admin/index")

    }

    call.respondText("Unauthorized", ContentType.Text.Html)

}
}