package kaleidot725.messagingandnotification

import android.widget.TextView
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by kaleidot725 on 2018/01/07.
 */
class ClickableAdapter(context : Context, objects : List<ClickableAdapter.ClickableItem>) :
        BindableAdapter<ClickableAdapter.ClickableItem>(context, objects) {
    private val LAYOUT_ID = android.R.layout.simple_expandable_list_item_1

    override fun newView(inflater: LayoutInflater, position: Int, parent : ViewGroup) : View {
        val view : View = inflater.inflate(LAYOUT_ID, parent, false)
        val holder = ViewHolder(view)
        view.tag = holder
        return view
    }

    override fun bindView(item : ClickableItem, position : Int, view : View) {
        val holder = view.tag as ViewHolder
        holder.title.text = item.Title
        view.setOnClickListener(item.ClickListener)
    }

    private class ViewHolder(view : View) {
        val title : TextView = view.findViewById(android.R.id.text1)
    }

    public  class ClickableItem (title:String, clickListener : View.OnClickListener) {
        public val Title : String = title
        public val ClickListener : View.OnClickListener = clickListener
    }
}