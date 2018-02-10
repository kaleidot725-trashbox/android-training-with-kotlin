package kaleidot725.service

import android.app.IntentService
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {
    val tag: String = MyIntentService::class.java.simpleName

    override fun onCreate() {
        super.onCreate()
        Log.v(tag, "onCreate")
    }

    override fun onBind(intent: Intent?): IBinder {
        Log.v(tag, "onBind")
        return super.onBind(intent)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.v(tag, "onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onHandleIntent(intent: Intent?) {
        Log.v(tag, "onHandleIntent")
    }

    override fun onDestroy() {
        Log.v(tag, "onDestroy")
        super.onDestroy()
    }

}