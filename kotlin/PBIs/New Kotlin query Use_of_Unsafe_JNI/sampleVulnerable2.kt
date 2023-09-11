package com.example.nativeCpp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
		val stringInput = readLine()
        findViewById<TextView>(R.id.sample_text).text = stringFromJNI(stringInput)
    }

    external fun stringFromJNI(stringInput): String

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}