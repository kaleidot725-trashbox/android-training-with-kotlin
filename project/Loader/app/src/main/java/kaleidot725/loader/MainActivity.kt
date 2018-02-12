package kaleidot725.loader

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.LoaderManager
import android.support.v4.content.Loader
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity(), LoaderManager.LoaderCallbacks<String> {
    val TAG : String = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.v(TAG, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 読み込むローダのIDと任意の引数を指定する
        val manager = getSupportLoaderManager()
        val argsForLoader = Bundle()
        manager.initLoader(0, argsForLoader, this)

        // 非同期処理を開始する
        MyAsyncTask(applicationContext).execute()
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<String>? {
        Log.v(TAG, "onCreateLoader")
        when (id) {
            0 ->
                    return MyAsyncTaskLoader(this)
            else ->
                    return null
        }
    }

    override fun onLoadFinished(loader: Loader<String>?, data: String?) {
        Log.v(TAG, "onLoadFinished")
        Toast.makeText(this, data, Toast.LENGTH_LONG).show()
    }

    override fun onLoaderReset(loader: Loader<String>?) {}
}
