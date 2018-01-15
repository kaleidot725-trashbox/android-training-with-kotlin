package kaleidot725.viewpager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by kaleidot725 on 2018/01/16.
 */
class MainFragmentPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {
    val PAGE_COUNT : Int = 5
    val fm = fm

    override fun getItem(position : Int) : Fragment {
        val fragment = MainFragment()
        fragment.position = position
        return fragment
    }

    override fun getCount() : Int {
        return PAGE_COUNT
    }
}