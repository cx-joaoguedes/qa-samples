import java.util.Scanner

fun callHardware() : String{
    val stringInput = readLine()
    hardwareIO(stringInput.toCharArray())
}

//define native function
external fun hardwareIO(input: CharArray): String

companion object {
    init {
        //load native library
        System.loadLibrary("hardware-lib")
    }
}