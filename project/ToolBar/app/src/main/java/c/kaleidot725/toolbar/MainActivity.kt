package c.kaleidot725.toolbar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lollipop（API Level 21）から　
        // ActionBar.NAVIGATION_MODEがdeprecatedとなったらしい
        // ActionBarのTabとSpinnerの利用が非推奨となるので実装しないこととする。
    }
}
