package kaleidot725.listviewpractice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private var customListView : ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create ArrayList
        var mutableList = mutableListOf<Book>()
        mutableList.add(Book("あなたのための物語", "長谷敏司", 648))
        mutableList.add(Book("君たちはどう生きるか", "吉野源三郎", 1048))
        mutableList.add(Book("TEST1", "ABC1", 701))
        mutableList.add(Book("TEST2", "ABC2", 702))
        mutableList.add(Book("TEST3", "ABC3", 703))
        mutableList.add(Book("TEST4", "ABC4", 704))
        mutableList.add(Book("TEST5", "ABC5", 705))
        mutableList.add(Book("TEST6", "ABC6", 706))
        mutableList.add(Book("TEST7", "ABC7", 707))
        mutableList.add(Book("TEST8", "ABC8", 708))

        // Create Adapter
        val customAdapter : ArrayAdapter<Book> = BookListItemAdapter(this, mutableList)

        // Set Adapter, ArrayList
        customListView = findViewById(R.id.CustomListView)
        customListView?.adapter = customAdapter

        val scrollOfTopButton = findViewById(R.id.ScrollOfTopButton) as Button
        scrollOfTopButton.setOnClickListener { v: View? ->
            customListView?.smoothScrollToPosition(0)
        }
    }
}
