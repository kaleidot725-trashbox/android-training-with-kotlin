package kaleidot725.listview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlin.Array

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create ArrayList
        var mutableList = mutableListOf<String>()
        for (i in 0..20) mutableList.add(i.toString())

        // Create Adapter
        val adapter : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, mutableList)

        // Set Adapter, ArrayList
        val listView : ListView = findViewById(R.id.ListView)
        listView.adapter = adapter
        listView.setOnItemClickListener { parent, view, position, id ->
            val str : String = parent.getItemAtPosition(position).toString()
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
        }

        // Create Adapter
        val customAdapter : ArrayAdapter<String> = CustomListItemAdapter(this, mutableList)

        // Set Adapter, ArrayList
        val customListView : ListView = findViewById(R.id.CustomListView)
        customListView.adapter = customAdapter
        listView.setOnItemClickListener { parent, view, position, id ->
            val str : String = parent.getItemAtPosition(position).toString()
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
        }
    }
}
