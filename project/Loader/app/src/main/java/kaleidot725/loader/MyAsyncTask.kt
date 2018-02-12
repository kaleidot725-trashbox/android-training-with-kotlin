package kaleidot725.loader

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.widget.Toast

/**
 * Created by kaleidot725 on 2018/02/12.
 */
class MyAsyncTask(context : Context) : AsyncTask<Void, Void, Void>() {
    val mContext : Context = context

    override fun onPreExecute() {
        super.onPreExecute()
        Toast.makeText(mContext, "onPreExecute", Toast.LENGTH_LONG).show()
    }

    override fun onProgressUpdate(vararg values: Void?) {
        super.onProgressUpdate(*values)
        Toast.makeText(mContext, "onProgressUpdate", Toast.LENGTH_LONG).show()
    }

    override fun doInBackground(vararg params: Void?): Void? {
        try {
            publishProgress()
            Thread.sleep(2000L)
            publishProgress()
            Thread.sleep(2000L)
            publishProgress()
            Thread.sleep(2000L)
            publishProgress()
            Thread.sleep(2000L)
            publishProgress()
            Thread.sleep(2000L)
            publishProgress()
            Thread.sleep(2000L)
            publishProgress()
            Thread.sleep(2000L)
            publishProgress()
            Thread.sleep(2000L)
        }catch (e : InterruptedException){
            Log.e(MyAsyncTask::class.java.simpleName, "thread interrupted", e)
        }

        return null
    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)
        Toast.makeText(mContext, "onPostExecute", Toast.LENGTH_LONG).show()
    }
}