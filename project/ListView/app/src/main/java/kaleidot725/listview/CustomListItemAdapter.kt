package kaleidot725.listview

import android.widget.ArrayAdapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.custom_list_item.view.*
import org.w3c.dom.Text
import kotlin.collections.ArrayList

/**
 * Created by kaleidot725 on 2018/01/14.
 */
class CustomListItemAdapter(context : Context, objects : List<String>) : ArrayAdapter<String>(context, 0, objects) {
    private val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var newView : View? = null

        if (newView == null) {
            newView = inflater.inflate(R.layout.custom_list_item, parent,false)

            val item = getItem(position)
            val titleView = newView?.findViewById(R.id.TitleText) as TextView
            titleView.text = "Title" + item

            val subTitleView = newView?.findViewById(R.id.SubTitleText) as TextView
            subTitleView.text = "SubTitle" + item
        }
        else {
            newView = view
        }

        return newView as View
    }
}