package arch.lavaira.com.android_kotlin_mvvm.data.remote.response

import com.google.gson.annotations.SerializedName

/****
 * Data Model class which represents the error response
 * Author: Lajesh Dineshkumar
 * Company: Lavaira
 * Created on: 4/3/19
 * Modified on: 4/3/19
 *****/
data class ErrorResponse (@SerializedName("errorCode") var errorCode:  String,
                          @SerializedName("errorDescription") var errorDescription: String){
    init {
        errorCode = ""
        errorDescription = ""
    }
}