package kaleidot725.loader

import android.content.AsyncTaskLoader
import android.content.Context
import android.util.Log
import kotlin.concurrent.thread

/**
 * Created by kaleidot725 on 2018/02/11.
 */
class MyAsyncTaskLoader(context : Context) : AsyncTaskLoader<String>(context){
    val TAG : String = MyAsyncTaskLoader::class.java.simpleName
    var mCachedData : String? = null

    override fun loadInBackground(): String {
        try {
            Thread.sleep(100)
        }
        catch (e : InterruptedException) {
            Log.e(TAG, "Interrupted!:", e)
        }

        Log.v(TAG, "loadInBackground")
        return "hogehoge"
    }

    override fun deliverResult(data: String?) {
        // キャッシュデータをリセットする
        if (isReset) {
            if (mCachedData != null) {
                mCachedData = null
            }
            Log.v(TAG, "deliverResult reset")
            return
        }

        // 得られたデータをキャッシュする
        mCachedData = data

        // キャッシュデータを通知する
        if (isStarted) {
            Log.v(TAG, "deliverResult notify")
            super.deliverResult(data)
        }
    }

    override fun onStartLoading() {
        if (mCachedData != null) {
            deliverResult(mCachedData)
            return
        }

        if (takeContentChanged() || mCachedData == null) {
            forceLoad()
        }

        Log.v(TAG, "onStartLoading")
        super.onStartLoading()
    }

    override fun onStopLoading() {
        cancelLoad()

        Log.v(TAG, "onStopLoading")
        super.onStopLoading()
    }

    override fun onReset() {
        onStopLoading()

        Log.v(TAG, "onReset")
        super.onReset()
    }
}