package kaleidot725.loader

import android.content.Loader
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.LoaderManager
import android.widget.Toast

class MainActivity : AppCompatActivity(), android.app.LoaderManager.LoaderCallbacks<String> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = getSupportLoaderManager()
        val argsForLoader = Bundle()
        manager.initLoader(0, argsForLoader, this as LoaderManager.LoaderCallbacks<String>)
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<String>? {
        when (id) {
            0 ->
                    return MyAsyncTaskLoader(this)
            else ->
                    return null
        }
    }

    override fun onLoadFinished(loader: Loader<String>?, data: String?) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show()
    }

    override fun onLoaderReset(loader: Loader<String>?) {}
}
