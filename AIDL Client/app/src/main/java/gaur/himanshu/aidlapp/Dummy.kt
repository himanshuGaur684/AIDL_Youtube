package gaur.himanshu.aidlapp

import android.content.Intent
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dummy(
    val name:String,
    val age:Int
):Parcelable
