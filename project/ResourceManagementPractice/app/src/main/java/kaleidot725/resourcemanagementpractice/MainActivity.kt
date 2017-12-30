package kaleidot725.resourcemanagementpractice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageviewanim)
        val animation = AnimationUtils.loadAnimation(this, R.anim.anim)
        imageView.startAnimation(animation)
    }
}
