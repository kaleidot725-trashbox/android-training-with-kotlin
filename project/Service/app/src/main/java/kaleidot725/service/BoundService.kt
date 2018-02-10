package kaleidot725.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class BoundService : Service() {
    val TAG = BoundService::class.java.simpleName
    private val mBinder = ServiceBinder()

    override fun onCreate() {
        super.onCreate()
        Log.v(TAG, "onCreate")
    }

    // 最初にバインドした時のコールバック
    override fun onBind(intent: Intent): IBinder? {
        return mBinder
    }

    // 再度バインドした時のコールバック
    override fun onRebind(intent: Intent) {
        super.onRebind(intent)
        Log.v(TAG, "onRebind")
    }

    // バインドを解除された時のコールバック
    override fun onUnbind(intent: Intent): Boolean {
        Log.v(TAG, "onUnbind")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG, "onDestroy")
    }

    // サービスをバインドした後、バインドしたサービスのインスタンスそのものを得るためのインタフェース
    inner class ServiceBinder : Binder() {
        val service: BoundService get() = this@BoundService
    }
}
