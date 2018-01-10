package kaleidot725.messagingandnotification

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat

class NotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        val builder : NotificationCompat.Builder = NotificationCompat.Builder(this, "normal_channel")
        val intent  : Intent = Intent(this, MainActivity::class.java)
        val pending : PendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val notification : Notification = builder
                .setWhen(System.currentTimeMillis())
                .setContentTitle("通知です")
                .setContentText("何もありませんが通知してみました。")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setTicker("通知です")
                .setContentIntent(pending)
                .setOnlyAlertOnce(true)
                .setAutoCancel(true)
                .build()

        val manager : NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(0, notification)
    }
}
