package kaleidot725.viewpager

import android.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager = findViewById(R.id.Pager) as ViewPager
        //pager.adapter = SamplePagerAdapter(this)

        // Support Packageを使用するためgetSupportFragmentManagerとなる
        pager.adapter = MainFragmentPagerAdapter(supportFragmentManager)
    }
}
