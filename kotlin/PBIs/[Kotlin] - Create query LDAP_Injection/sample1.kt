import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.netty.channel.*
import io.netty.channel.socket.SocketChannel
import io.netty.handler.codec.http.*
import io.netty.handler.codec.http.HttpResponseStatus.*
import io.netty.handler.codec.http.HttpVersion.*
import io.netty.util.*
import java.net.InetSocketAddress
import javax.naming.Context
import javax.naming.NamingException
import javax.naming.directory.InitialDirContext

fun main() {
    val port = 8080
    embeddedServer(Netty, port) {
        routing {
            get("/") {
                call.respondText("Hello, world!")
            }

            post("/auth") {
                val params = call.parameters
                val username = params["username"]
                val password = params["password"]
                val ldap_hostname = params["ldap_hostname"]
                val ldap_port = params["ldap_port"]

                if (authenticateLDAPUser(username, password, ldap_hostname,ldap_port)) {
                    call.respondText("Authentication successful!")
                } else {
                    call.respondText("Authentication failed!")
                }
            }
        }

        connector {
            port = 8080
        }

        serverChannelOption(ChannelOption.SO_BACKLOG, 1024)
        childChannelOption(ChannelOption.TCP_NODELAY, true)
        childChannelOption(ChannelOption.SO_KEEPALIVE, true)
        channelInitializer { ch ->
            ch.pipeline().addLast(HttpServerCodec())
            ch.pipeline().addLast(HttpObjectAggregator(512 * 1024))
            ch.pipeline().addLast(HttpHandler())
        }
    }.start(wait = true)
}

class HttpHandler : SimpleChannelInboundHandler<FullHttpRequest>() {
    override fun channelRead0(ctx: ChannelHandlerContext, request: FullHttpRequest) {
        val response = DefaultFullHttpResponse(HTTP_1_1, OK)
        response.content().writeBytes("Hello, world!".toByteArray())
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain")
        response.headers().set(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes())
        ctx.writeAndFlush(response)
    }

    override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
        cause.printStackTrace()
        ctx.close()
    }
}

private fun authenticateLDAPUser(username: String, password: String, , ldap_hostname: String ,ldap_port: String): Boolean {
    val env = mutableMapOf<String, Any>()
    env[Context.INITIAL_CONTEXT_FACTORY] = "com.sun.jndi.ldap.LdapCtxFactory"
    env[Context.PROVIDER_URL] = "ldap://${LDAP_HOSTNAME}:${LDAP_PORT}"
    env[Context.SECURITY_AUTHENTICATION] = "simple"
    env[Context.SECURITY_PRINCIPAL] = "cn=$username,ou=users,dc=mycompany,dc=com"
    env[Context.SECURITY_CREDENTIALS] = password

    try {
        val context = InitialDirContext(env)
        context.close()
        return true
    } catch (e: NamingException) {
        return false
    }
}
