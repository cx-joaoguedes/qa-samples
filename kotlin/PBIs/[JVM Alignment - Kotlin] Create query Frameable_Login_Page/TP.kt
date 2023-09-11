import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/login")
class LoginServlet : HttpServlet() {

    @Throws(ServletException::class, IOException::class)
    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {

        val username = request.getParameter("username")
        val password = request.getParameter("password")

        // perform authentication logic here
        if (isValidUser(username, password)) {
            // if authentication successful, redirect to home page
            response.sendRedirect("home.jsp")
        } else {
            // if authentication fails, display error message
            request.setAttribute("errorMessage", "Invalid username or password")
            request.getRequestDispatcher("login.jsp").forward(request, response)
        }
    }

    private fun isValidUser(username: String?, password: String?): Boolean {
        // perform authentication validation here
        return "admin".equals(username, ignoreCase = true) && "password123".equals(password)
    }
}