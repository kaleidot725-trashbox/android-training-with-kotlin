package kaleidot725.parcelable

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val extras : Bundle = intent.extras
        val parcelableData : MyParcelable  = extras.getParcelable("parcelableData")
        Toast.makeText(this, "data:" + parcelableData.mData, Toast.LENGTH_LONG).show()
    }
}
