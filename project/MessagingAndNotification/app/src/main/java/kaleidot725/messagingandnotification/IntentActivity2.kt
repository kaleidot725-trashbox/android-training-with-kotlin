package kaleidot725.messagingandnotification

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class IntentActivity2 : Activity() {

    val ACTION_FIRST  = "jp.mixi.practice.messagingandnotification.intent.action.FIRST"
    val ACTION_SECOND = "jp.mixi.practice.messagingandnotification.intent.action.SECOND"
    val ACTION_THIRD  = "jp.mixi.practice.messagingandnotification.intent.action.THIRD"
    val mMyBroadcastReciever : MyBroadcastReciever = MyBroadcastReciever()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent2)

        var button1 : View = findViewById(R.id.CallAction1)
        var button2 : View = findViewById(R.id.CallAction2)
        var button3 : View = findViewById(R.id.CallAction3)

        button1.setOnClickListener {
            val intent : Intent = Intent()
            intent.action = ACTION_FIRST
            sendBroadcast(intent)
        }

        button2.setOnClickListener {
            val intent : Intent = Intent()
            intent.action = ACTION_SECOND
            sendBroadcast(intent)
        }

        button3.setOnClickListener {
            val intent : Intent = Intent()
            intent.action = ACTION_THIRD
            sendBroadcast(intent)
        }

        val intentFilter = IntentFilter()
        intentFilter.addAction(ACTION_FIRST)
        intentFilter.addAction(ACTION_SECOND)
        intentFilter.addAction(ACTION_THIRD)
        registerReceiver(mMyBroadcastReciever, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(mMyBroadcastReciever)
    }

    class MyBroadcastReciever : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.v("Intent", intent?.action)
        }
    }
}
