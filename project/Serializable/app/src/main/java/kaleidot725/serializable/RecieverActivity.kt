package kaleidot725.serializable

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseArray
import android.widget.Toast

class RecieverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reciever)

        val bundleParams = intent.getBundleExtra("bundleParams")
        Toast.makeText(this, bundleParams.getString("data"), Toast.LENGTH_LONG).show()
    }
}
