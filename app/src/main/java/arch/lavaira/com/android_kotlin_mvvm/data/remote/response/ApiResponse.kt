package arch.lavaira.com.android_kotlin_mvvm.data.remote.response

import android.content.Context
import android.text.TextUtils
import arch.lavaira.com.android_kotlin_mvvm.MvvmApplication
import arch.lavaira.com.android_kotlin_mvvm.R
import com.google.gson.Gson
import com.google.gson.stream.MalformedJsonException
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

/****
 * Data model class which represents the API Response
 * Author: Lajesh Dineshkumar
 * Company: Lavaira
 * Created on: 4/3/19
 * Modified on: 4/3/19
 *****/
data class ApiResponse <out T>(
    val status: Int,
    val data: T?,
    val error: Throwable?
) {

    var errorCode: String = ""
    var errorDescription: String = ""

    init {
        error?.let {
            val context: Context = MvvmApplication.applicationContext()
            this.errorDescription = context.getString(R.string.unknownError)
            when (it) {
                is SocketTimeoutException -> {
                    this.errorDescription = context.getString(R.string.requestTimeOutError)
                    this.errorCode = context.getString(R.string.networkErrorCode)
                }
                is MalformedJsonException -> {
                    this.errorDescription = context.getString(R.string.responseMalformedJson)
                    this.errorCode = context.getString(R.string.errorCodeMalformedJson)
                }
                is IOException -> {
                    this.errorDescription = context.getString(R.string.networkError)
                    this.errorCode = context.getString(R.string.networkErrorCode)
                }

                is HttpException -> {
                    try {
                        val apiErrorResponse: ErrorResponse = Gson().fromJson(it.response().errorBody()?.string(), ErrorResponse::class.java)
                        if (!TextUtils.isEmpty(apiErrorResponse.errorCode))
                            this.errorCode = apiErrorResponse.errorCode
                        if (!TextUtils.isEmpty(apiErrorResponse.errorDescription))
                            this.errorDescription = apiErrorResponse.errorDescription
                    } catch (ex: Exception) {
                        this.errorDescription = context.getString(R.string.unknownError)
                    }
                }
            }
        }
    }
}