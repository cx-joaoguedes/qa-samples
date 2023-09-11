import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.ldap.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import javax.naming.directory.SearchControls
import javax.naming.ldap.LdapContext

object Users : Table()

fun main(args : Array<String>) {
    embeddedServer(Netty, port = 8080) {
        routing {
            get("/storedLDAPunsafe") {
                val userId = call.request.queryParameters["userId"]
                val userPasswordCredential = transaction {
                    Users.select { Users.name eq "$userId" }.limit(1).single()
                }
                val realm = "auth-realm"
                ldapAuthenticate(userPasswordCredential, "ldap://0.0.0.0:389", "OU=Catalog,DC=op,DC=serv") {
                    val users = (lookup("OU=UsersCatalog") as LdapContext)
                    val controls = SearchControls().apply {
                        searchScope = SearchControls.ONELEVEL_SCOPE
                        returningAttributes = arrayOf("+", "*")
                    }
                    users.search("OU=Catalog,DC=op,DC=serv", "(&(objectCategory=user)(CN=${userPasswordCredential.name})(memberOf=APPADMIN_GROUP_DN))", controls).asSequence().firstOrNull {
                        it != null
                    }?.let { UserIdPrincipal(userPasswordCredential.name) }
                }
            }

            get("/storedLDAPsafe") {
                val userId = call.request.queryParameters["userId"]
                val userPasswordCredential = transaction {
                    Users.select { Users.name eq "$userId" }.limit(1).single()
                }
                val realm = "auth-realm"
                ldapAuthenticate(userPasswordCredential, "ldap://0.0.0.0:389", "OU=Catalog,DC=op,DC=serv") {
                    val users = (lookup("OU=UsersCatalog") as LdapContext)
                    val controls = SearchControls().apply {
                        searchScope = SearchControls.ONELEVEL_SCOPE
                        returningAttributes = arrayOf("+", "*")
                    }

                    val re = Regex("[^A-Za-z0-9 ]")
                    val sanitizedName = re.replace(userPasswordCredential.name, "") //replace all non-Alphanumeric characters; only works if all usernames are purely alphanumeric
                    users.search("OU=Catalog,DC=op,DC=serv", "(&(objectCategory=user)(CN=${sanitizedName})(memberOf=APPADMIN_GROUP_DN))", controls).asSequence().firstOrNull {
                        it != null
                    }?.let { UserIdPrincipal(userPasswordCredential.name) }

                }
            }
        }
    }
}