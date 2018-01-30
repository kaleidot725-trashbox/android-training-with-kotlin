package kaleidot725.persistence

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.SharedPreferences
import android.widget.TextView
import android.view.View

class MainActivity : AppCompatActivity() {

    var mName : String? = null
    var mAge : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 前回の設定値を読み込む
        readPerson()

        // 設定値を表示する
        val nameView = findViewById<View>(R.id.Name) as TextView
        nameView.text = mName
        val ageView = findViewById<View>(R.id.Age) as TextView
        ageView.text = mAge?.toString()

        // 設定値を更新する
        if (mAge == null) {
            mName = "0"
            mAge = 0
        }else {
            mAge = mAge?.inc()
            mName += mAge?.toString()
        }

        // 設定を書き込む
        savePerson()
    }

    fun savePerson() : Boolean {
        // 第1引数に設定ファイルの名称を指定、第2引数にファイルの操作モードを指定する
        val sp : SharedPreferences = getSharedPreferences("person", Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sp.edit()

        // valueを設定する
        if (mName != null) {
            editor.putString("name", mName as String)
        }

        if (mAge != null) {
            editor.putInt("age", mAge as Int)
        }

        // commitまたはapplyで保存する
        // applyは保存の完了を待たずに処理が戻ってくるので、処理が完了したか判断できない。
        // 今回はサンプルに従いcommitを利用する
        return editor.commit()
    }

    fun readPerson() {
        val sp : SharedPreferences = getSharedPreferences("person", Context.MODE_PRIVATE)
        mName = sp.getString("name", "0")
        mAge = sp.getInt("age", 0)
    }
}
