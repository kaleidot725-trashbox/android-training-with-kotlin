package kaleidot725.internalexternalstorage

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    val fileName : String = "hello_file"
    val output : String = "hello world!"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Internal Storage
        var internalStream : FileOutputStream? = null
        try {
            internalStream = openFileOutput(fileName, Context.MODE_PRIVATE)
            internalStream.write(output.toByte() as ByteArray?)
        }catch(e : Exception){
            print("error message $e")
        }
        finally {
            try {
                internalStream?.close()
            }catch (e : Exception) {
                print("error message $e")
            }
        }

        // External Storage
        var externalStream : FileOutputStream ?= null
        try {
            val exDir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
            val exFileName = "$exDir/$fileName"
            externalStream = openFileOutput(exFileName, Context.MODE_PRIVATE)
            externalStream.write(output.toByte() as ByteArray?)
        } catch (e : Exception) {
            print("error message $e")
        }
        finally {
            try {
                externalStream?.close()
            }catch (e : Exception) {
                print("error message $e")
            }
        }
    }
}
