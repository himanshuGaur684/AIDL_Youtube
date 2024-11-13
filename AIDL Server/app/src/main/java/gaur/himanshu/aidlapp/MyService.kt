package gaur.himanshu.aidlapp

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyService : Service() {

    private val binder = object : IMyAidlInterface.Stub(){
        override fun calculate(a: Int, b: Int): Int {
            return a.plus(b)
        }

        override fun getMessage(): String {
           return "Connect"
        }

        override fun transformation(dummy: Dummy?): Dummy {
            return Dummy(
                name =  dummy?.name?.plus(" transformation").toString(),
                age = dummy?.age?.plus(18)?:0
            )
        }
    }

    override fun onBind(p0: Intent?): IBinder {
        return binder
    }
}