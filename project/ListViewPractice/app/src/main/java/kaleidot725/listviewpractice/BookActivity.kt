package kaleidot725.listviewpractice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class BookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        val titleView = findViewById<TextView>(R.id.TitleText)
        titleView.text = intent.getStringExtra("Title")

        val authorView = findViewById<TextView>(R.id.AuthorText)
        authorView.text = intent.getStringExtra("Author")

        val priceView = findViewById<TextView>(R.id.PriceText)
        priceView.text = intent.getStringExtra("Price") + "円"
    }
}
