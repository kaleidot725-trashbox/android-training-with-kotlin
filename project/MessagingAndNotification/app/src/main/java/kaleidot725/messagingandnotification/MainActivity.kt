package kaleidot725.messagingandnotification

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.ListView

class MainActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var clikableItems = ArrayList<ClickableAdapter.ClickableItem>()
        clikableItems.add(ClickableAdapter.ClickableItem(getString(R.string.intent_1),
                ItemClickListener(IntentActivity1::class.java)))
        clikableItems.add(ClickableAdapter.ClickableItem(getString(R.string.intent_2),
                ItemClickListener(IntentActivity2::class.java)))
        clikableItems.add(ClickableAdapter.ClickableItem(getString(R.string.notification),
                ItemClickListener(NotificationActivity::class.java)))

        var adapter = ClickableAdapter(this, clikableItems)
        val lv : ListView= findViewById(R.id.practiceList)
        lv.adapter = adapter
    }

    private class ItemClickListener(activityClass : Class<out Activity>) : View.OnClickListener{
        var mClass : Class<out Activity> = activityClass

        override fun onClick(v : View) {
            ContextCompat.startActivity(v.context, Intent(v.context, mClass), null)
        }
    }
}
