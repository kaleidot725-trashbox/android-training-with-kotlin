package kaleidot725.fragmentpractice

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var state : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = fragmentManager.beginTransaction()
        val next = MainFragment()
        transaction.add(R.id.MyContainer,next)
        transaction.commit()

        val toggleButton = findViewById<Button>(R.id.ToggleButton)
        toggleButton.setOnClickListener{
            val transaction = fragmentManager.beginTransaction()
            val next  = if (state) MainFragment() else SubFragment()
            state = !state

            transaction.replace(R.id.MyContainer, next)
            transaction.commit()
        }
    }
}
