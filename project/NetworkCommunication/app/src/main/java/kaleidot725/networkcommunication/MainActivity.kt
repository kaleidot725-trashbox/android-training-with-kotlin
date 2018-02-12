package kaleidot725.networkcommunication

import android.content.Context
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLConnection
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = cm.activeNetworkInfo

        // 接続されているサービスの名称を表示する
        if (info.isConnected) {
            Toast.makeText(this, info.typeName + " connected", Toast.LENGTH_LONG).show()
        }

        // もしWifiで接続されていたら、Wifi用の処理を動作させる
        if (info.type == ConnectivityManager.TYPE_MOBILE) {
            Toast.makeText(this, "mobile startup", Toast.LENGTH_LONG).show()
        }
        else if (info.type == ConnectivityManager.TYPE_WIFI) {
            Toast.makeText(this, "Wifi startup", Toast.LENGTH_LONG).show()
        }
        else {
            Toast.makeText(this, "Undefined type", Toast.LENGTH_LONG).show()
        }

        simpleGet()
    }

    private fun simpleGet(){
        val url = URL("http://mixi.jp")
        var connection : HttpURLConnection? = null

        try {
            connection = url.openConnection() as HttpURLConnection
            connection?.connect()

            val inputStream = connection.getInputStream()
            val src = StringBuilder()
            while (true) {
                val line = ByteArray(1024)
                val size = inputStream.read(line)
                if (size <= 0) {
                    break
                }

                src.append(String(line, Charset.defaultCharset()))
            }
        }catch (e : IOException) {
            e.printStackTrace()
        }finally {
            connection?.disconnect()
        }
    }

    private fun simplePost(){
        val url = URL("http://mixi.jp")
        var connection : HttpURLConnection? = null

        try {
            connection = url.openConnection() as HttpURLConnection
            connection?.requestMethod = "POST"
            connection?.doOutput = true

            val postData = "hoge=fuga&piyo=test"
            val outputStream = connection.outputStream
            outputStream.write(postData.toByteArray())
            outputStream.flush()
            outputStream.close()

            val inputStream = connection.inputStream
            val src = StringBuilder()
            while (true) {
                val line = ByteArray(1024)
                val size = inputStream.read(line)
                if (size <= 0) {
                    break
                }

                src.append(String(line, Charset.defaultCharset()))
            }
        } catch (e : IOException) {
            e.printStackTrace()
        } finally {
            connection?.disconnect()
        }
    }
}
