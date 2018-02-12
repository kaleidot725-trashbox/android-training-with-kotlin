package kaleidot725.handlerandlooper

import android.os.Looper

/**
 * Created by kaleidot725 on 2018/02/12.
 */
class MyThread : Thread(){

    override fun run() {
        Looper.prepare()
        Looper.loop()
    }
}