package kaleidot725.viewpagerpractice

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class MainFragment : Fragment() {
    var position : Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_main, container, false)
        val text = view?.findViewById(R.id.TextView1) as TextView
        text?.text = position.toString()
        return view
    }
}
