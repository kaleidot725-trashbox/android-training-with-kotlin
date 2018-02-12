package kaleidot725.handlerandlooper

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val looper = mainLooper
        val handler = Handler(looper)
        handler.run {
            Toast.makeText(this@MainActivity, "handler run!", Toast.LENGTH_LONG).show()
        }

        handler.run {
            Toast.makeText(this@MainActivity, "handler run!!", Toast.LENGTH_LONG).show()
        }

        handler.run {
            Toast.makeText(this@MainActivity, "handler run!!!", Toast.LENGTH_LONG).show()
        }

        handler.run {
            Toast.makeText(this@MainActivity, "handler run!!!!", Toast.LENGTH_LONG).show()
        }

        handler.run {
            Toast.makeText(this@MainActivity, "handler run!!!!!", Toast.LENGTH_LONG).show()
        }

        Toast.makeText(this, "Queuing complete!!", Toast.LENGTH_LONG)
    }
}
