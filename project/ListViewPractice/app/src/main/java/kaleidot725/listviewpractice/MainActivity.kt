package kaleidot725.listviewpractice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.app.Fragment
import android.content.Intent
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    private var customListView : ListView? = null
    private var customAdapter : ArrayAdapter<Book>? = null

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

        // Create Adapter, Set Adapter
        customAdapter = BookListItemAdapter(this, mutableList)
        customListView = findViewById(R.id.CustomListView)
        customListView?.adapter = customAdapter
        customListView?.setOnItemClickListener { parent, view, position, id ->
            var intent : Intent = Intent(this, BookActivity::class.java)
            val selectedBook : Book? = mutableList[position]

            intent.putExtra("Title", selectedBook?.title)
            intent.putExtra("Author", selectedBook?.author)
            intent.putExtra("Price", selectedBook?.price.toString())
            startActivity(intent)
        }

        // Set ClickEvent
        val scrollOfTopButton = findViewById(R.id.ScrollOfTopButton) as Button
        scrollOfTopButton.setOnClickListener { v: View? ->
            customListView?.smoothScrollToPosition(0)
        }

        // Register Custom ListView Context Menu
        registerForContextMenu(customListView)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menu?.setHeaderTitle("Edit Menu")

        val inflater : MenuInflater = menuInflater
        menuInflater.inflate(R.menu.custom_list_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        // public static interface ContextMenu.ContextMenuInfoと定義されており、
        // インタフェースを実装したのがAdapterView.AdapterContextMenuInfo
        val menuInfo: AdapterView.AdapterContextMenuInfo = item?.menuInfo as AdapterView.AdapterContextMenuInfo

        // 選択したメニューを実行する
        when (item?.itemId) {
            R.id.add_setting_menu -> {
                val selectedItem = customAdapter?.getItem(menuInfo.position)
                if (selectedItem != null) {
                    customAdapter?.add(Book(selectedItem.title, selectedItem.author, selectedItem.price))
                }
            }

            R.id.remove_setting_menu -> {
                customAdapter?.remove(customAdapter?.getItem(menuInfo.position))
            }
        }

        return super.onContextItemSelected(item)
    }
}
