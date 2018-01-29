package kaleidot725.parcelable

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent : Intent = Intent(this, SubActivity::class.java)
        val parcelableData : MyParcelable = MyParcelable()
        intent.putExtra("parcelableData", parcelableData)
        startActivity(intent)
    }
}
