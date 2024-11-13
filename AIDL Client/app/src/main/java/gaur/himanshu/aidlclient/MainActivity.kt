package gaur.himanshu.aidlclient

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import gaur.himanshu.aidlapp.Dummy
import gaur.himanshu.aidlapp.IMyAidlInterface
import gaur.himanshu.aidlclient.ui.theme.AIDLClientTheme

class MainActivity : ComponentActivity() {

    private var aidl: IMyAidlInterface? = null

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {

            aidl = IMyAidlInterface.Stub.asInterface(p1)
            Log.d("TAGGGGGGGG", "onServiceConnected: ${aidl?.calculate(4, 3)}")
            Log.d(
                "TAGGGGGGGG",
                "onServiceConnected: ${aidl?.transformation(Dummy(name = "Himanshu", age = 24))}"
            )
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            aidl = null
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val intent = Intent("gaur.himanshu.aidlapp.IMyAidlInterface")
        intent.setPackage("gaur.himanshu.aidlapp")
        bindService(intent,serviceConnection, BIND_AUTO_CREATE)

        setContent {
            AIDLClientTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                }
            }
        }
    }

    override fun onDestroy() {
        unbindService(serviceConnection)
        super.onDestroy()
    }
}
