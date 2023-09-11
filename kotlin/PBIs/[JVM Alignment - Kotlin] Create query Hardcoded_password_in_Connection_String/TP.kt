import java.sql.*

fun main() {
    val connectionString = "jdbc:mysql://localhost:3306/mydatabase"
    val username = "myuser"
    val password = "mypassword"

    // Establish a connection to the database using the connection string, username, and password
    val connection = DriverManager.getConnection(connectionString, username, password)

    // Execute a simple query to test the connection
    val statement = connection.createStatement()
    val resultSet = statement.executeQuery("SELECT * FROM mytable")

    // Process the result set
    while (resultSet.next()) {
        val id = resultSet.getInt("id")
        val name = resultSet.getString("name")
        val age = resultSet.getInt("age")
        println("id=$id, name=$name, age=$age")
    }

    // Close the result set, statement, and connection
    resultSet.close()
    statement.close()
    connection.close()
}
