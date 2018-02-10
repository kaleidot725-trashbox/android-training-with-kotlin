package kaleidot725.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class StartedService : Service() {
    val tag: String = StartedService::class.java.simpleName
    override fun onBind(intent: Intent): IBinder? {
        Log.v(tag, "onBind")
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.v(tag, "onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Log.v(tag, "onDestroy")
        super.onDestroy()
    }
}
