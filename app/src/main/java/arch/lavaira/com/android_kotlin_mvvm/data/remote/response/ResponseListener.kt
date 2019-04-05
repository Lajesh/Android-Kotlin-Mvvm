package arch.lavaira.com.android_kotlin_mvvm.data.remote.response

/****
 * ResponseListener callback which is responsible for giving the API response back to the presentation layer
 * Author: Lajesh Dineshkumar
 * Company: Lavaira
 * Created on: 4/3/19
 * Modified on: 4/3/19
 *****/
interface ResponseListener<T> {
    fun onStart()
    fun onFinish()
    fun onResponse(result: ApiResponse<T>)
}