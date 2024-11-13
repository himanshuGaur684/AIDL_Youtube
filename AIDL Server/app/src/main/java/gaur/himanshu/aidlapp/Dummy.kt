package gaur.himanshu.aidlapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dummy(
    val name:String,
    val age:Int
):Parcelable
