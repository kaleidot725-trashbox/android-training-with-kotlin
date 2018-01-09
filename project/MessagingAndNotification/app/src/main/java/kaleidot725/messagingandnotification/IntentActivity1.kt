package kaleidot725.messagingandnotification

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.widget.Toast

class IntentActivity1 : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent1)

        var button1 : View = findViewById(R.id.CallActivity1)
        var button2 : View = findViewById(R.id.CallActivity2)
        var button3 : View = findViewById(R.id.CallActivity3)

        button1.setOnClickListener {
            val intent : Intent = Intent(this, NewActivity1::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("StartMessage", "NewActivity2を開始します")

            var intent : Intent = Intent( this, NewActivity2::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }

        button3.setOnClickListener {
            var intent : Intent = Intent(this, NewActivity3::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
        }
    }
}
