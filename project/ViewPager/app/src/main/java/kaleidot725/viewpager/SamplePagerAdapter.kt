package kaleidot725.viewpager

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.ViewGroup
import android.view.View
import android.widget.TextView

/**
 * Created by kaleidot725 on 2018/01/15.
 */
class SamplePagerAdapter(context : Context) : PagerAdapter() {
    private val mPageCount : Int = 5
    private val mContext : Context = context

    override fun instantiateItem(container : ViewGroup, position : Int) : Any {
        var textView = TextView(mContext)
        textView.text = "Position" + position
        container.addView(textView)
        return textView
    }

    override fun destroyItem(container : ViewGroup, position: Int, any : Any){
        container.removeView(any as View)
    }

    override fun getCount(): Int {
        return mPageCount
    }

    override  fun isViewFromObject(view : View, any : Any) : Boolean {
        return (view == any as TextView)
    }
}