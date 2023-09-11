class Sample {
    val ADMIN_USER = "admin"
	val ADMIN_PASSWORD = "P@ssw0rd"

	fun isAdmin(username: String, password: String): Boolean {
		return username == ADMIN_USER && password == ADMIN_PASSWORD
	}

    fun isAdminUnsafe(username: String, password: String): Boolean {
        var isMatch = false;

        if (username == "admin") {
            if (password == "P@ssw0rd")
                isMatch = true;
        }

        return isMatch;
    }

    fun isAdminUnsafe2(username: String, password: String): Boolean {
        var isMatch = false;

        if (username.equals("admin")) {
            if (password.equals("P@ssw0rd"))
                isMatch = true;
        }

        return isMatch;
    }

    fun isAdminSafe(username: String, password: String): Boolean {
        var adminPrivs = false;

        if (authenticateUser(username, password)) {
            val privs : UserPrivileges = getUserPrivileges(username);

            if (privs.isAdmin)
                adminPrivs = true;
        }

        return adminPrivs;
    }
}