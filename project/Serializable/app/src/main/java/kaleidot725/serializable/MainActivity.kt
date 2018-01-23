package kaleidot725.serializable

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseArray
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent : Intent = Intent(this, RecieverActivity::class.java)

        val bundle : Bundle = Bundle()
        bundle.putString("data", "value")
        intent.putExtra("bundleParams", bundle)

        val sparseArray = SparseArray<String>()
        sparseArray.put(R.id.one_text   , "一つ目のテキストビュー")
        sparseArray.put(R.id.two_text   , "二つ目のテキストビュー")
        sparseArray.put(R.id.three_text , "三つ目のテキストビュー")
        sparseArray.put(R.id.four_text  , "四つ目のテキストビュー")

        val oneTextView = findViewById<View>(R.id.one_text) as TextView
        oneTextView.text = sparseArray.get(R.id.one_text)

        val twoTextView = findViewById<View>(R.id.two_text) as TextView
        twoTextView.text = sparseArray.get(R.id.two_text)

        val threeTextView = findViewById<View>(R.id.three_text) as TextView
        threeTextView.text = sparseArray.get(R.id.three_text)

        val fourTextView = findViewById<View>(R.id.four_text) as TextView
        fourTextView.text = sparseArray.get(R.id.four_text)

        startActivity(intent)
    }
}
