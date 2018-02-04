package kaleidot725.persistence

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.SharedPreferences
import android.widget.TextView
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity(), SharedPreferences.OnSharedPreferenceChangeListener {
    var mSharedPreferences : SharedPreferences? = null
    var mName : String? = null
    var mAge : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSharedPreferences = getSharedPreferences("person", MODE_PRIVATE)
        mSharedPreferences?.registerOnSharedPreferenceChangeListener(this)
        mName = mSharedPreferences?.getString("name", "0")
        mAge = mSharedPreferences?.getInt("age", 0)

        val nameView = findViewById<View>(R.id.Name) as TextView
        nameView.text = mName

        val ageView = findViewById<View>(R.id.Age) as TextView
        ageView.text = mAge.toString()

        val nextAge : Int = mAge?.inc() ?: 0
        val nextName : String = mName + nextAge.toString()
        val editor : SharedPreferences.Editor? = mSharedPreferences?.edit()
        editor?.putString("name", nextName)
        editor?.putInt("age", nextAge)
        editor?.commit()
    }

    override fun onDestroy() {
        mSharedPreferences?.unregisterOnSharedPreferenceChangeListener(this)
        super.onDestroy()
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        Toast.makeText(this, "update shared preferences $key", Toast.LENGTH_LONG).show()
    }
}
