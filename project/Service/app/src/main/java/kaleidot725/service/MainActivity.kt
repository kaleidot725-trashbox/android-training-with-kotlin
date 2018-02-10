package kaleidot725.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.content.Context.BIND_AUTO_CREATE



class MainActivity : AppCompatActivity() {
    val TAG : String = MainActivity::class.java.simpleName

    var mBoundService : BoundService? = null
    var mConnection : ServiceConnection = object : ServiceConnection {
        public override fun onServiceDisconnected(name : ComponentName?) {
            mBoundService = null
        }

        public override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.v(TAG, "onServiceConnected")
            mBoundService = (service as BoundService.ServiceBinder).service
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // スタートサービス開始
        val intent = Intent(this, StartedService::class.java)
        startService(intent)

        // バインドサービス開始
        bindService(Intent(this, BoundService::class.java), mConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onStop() {
        // スタートサービス停止
        val intent = Intent(this, StartedService::class.java)
        stopService(intent)

        // バインドサービス停止
        unbindService(mConnection);

        super.onStop()
    }
}
