package kaleidot725.messagingandnotification

import android.widget.ArrayAdapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by kaleidot725 on 2018/01/07.
 */
abstract class BindableAdapter<T>(context : Context, objects : List<T>) : ArrayAdapter<T> (context, 0, objects) {
    private val  inflater = LayoutInflater.from(context)

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var newView = view ?: newView(inflater, position, parent)
        bindView(getItem(position), position, newView)
        return newView
    }

    abstract fun newView(inflater: LayoutInflater, position: Int, parent : ViewGroup) : View
    abstract fun bindView(item : T, position : Int, view : View)
}
