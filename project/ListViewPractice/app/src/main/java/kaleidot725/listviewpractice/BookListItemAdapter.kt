package kaleidot725.listviewpractice

import android.widget.ArrayAdapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by kaleidot725 on 2018/01/14.
 */
class BookListItemAdapter(context : Context, objects : List<Book>) : ArrayAdapter<Book>(context, 0, objects) {
    private val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var newView : View? = null

        if (newView == null) {
            newView = inflater.inflate(R.layout.custom_list_item, parent,false)

            val item = getItem(position)
            val titleView = newView.findViewById(R.id.TitleText) as TextView
            titleView.text = item.title

            val publisherView = newView.findViewById(R.id.AuthorText) as TextView
            publisherView.text = item.author

            val priceView = newView.findViewById(R.id.PriceText) as TextView
            priceView.text = item.price.toString() + "円"
        }
        else {
            newView = view
        }

        return newView as View
    }
}