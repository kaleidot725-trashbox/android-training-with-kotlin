package kaleidot725.viewpagerpractice

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.support.v4.view.ViewPager
import android.os.Bundle
import android.view.View
import com.astuetz.PagerSlidingTabStrip

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager = findViewById<View>(R.id.pager) as ViewPager
        pager.adapter = MainFragmentPagerAdapter(supportFragmentManager)

        val tabs = findViewById<View>(R.id.tabs) as PagerSlidingTabStrip
        tabs.setViewPager(pager)
    }
}
